/*     */ package dtv.data2.access.query;
/*     */ 
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.IJDBCPersistenceStrategy;
/*     */ import dtv.data2.access.impl.IPersistenceStrategy;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCCall;
/*     */ import dtv.data2.access.impl.jdbc.JDBCPersistenceStrategy;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DtxQueryHandler
/*     */   implements IQueryHandler
/*     */ {
/*  31 */   private static final Logger logger_ = Logger.getLogger(DtxQueryHandler.class);
/*  32 */   private static final Logger queryDebugLogger_ = Logger.getLogger("DtxQueryDebugger");
/*     */ 
/*     */   
/*     */   private Properties props_;
/*     */ 
/*     */   
/*     */   private String sourceDescription_;
/*     */ 
/*     */   
/*     */   private ISqlQueryDecorator _queryDecorator;
/*     */ 
/*     */ 
/*     */   
/*     */   public Object execute(IPersistenceStrategy argStrategy, Map<String, Object> argParameters, QueryToken argQueryToken) {
/*  46 */     if (!(argStrategy instanceof IJDBCPersistenceStrategy)) {
/*  47 */       throw new DtxException(getClass().getName() + " can only work with JDBCPersistenceStrategy currently. The strategy passed instead was; " + argStrategy);
/*     */     }
/*     */     
/*  50 */     Class<?> id = null;
/*  51 */     StringBuilder sql = null;
/*  52 */     List<Object> paramValueList = new ArrayList();
/*     */     
/*     */     try {
/*  55 */       id = getIdClass(argParameters);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  60 */       IJDBCPersistenceStrategy strat = (IJDBCPersistenceStrategy)argStrategy;
/*  61 */       IJDBCTableAdapter adapter = strat.getTableAdapter(id);
/*     */       
/*  63 */       String paramProp = this.props_.getProperty("Parameters");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  68 */       sql = new StringBuilder(1024);
/*  69 */       sql.append(adapter.getSelect());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  75 */       String joinTables = getImplicitJoinTables(this.props_, (Map)argParameters);
/*     */       
/*  77 */       if (joinTables != null && joinTables.length() > 0) {
/*  78 */         sql.append(", ");
/*  79 */         sql.append(joinTables);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  85 */       if (this.props_.getProperty("Filter") != null && this.props_.getProperty("WhereClause") == null) {
/*  86 */         throw new DtxException("Query: " + this.props_.getProperty("Name") + " defines a 'Filter' section, but not a 'WhereClause' section.  What was called 'Filter' under jdo queries is now called 'WhereClause', and should contain valid sql.");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  96 */       String whereClause = this.props_.getProperty("WhereClause");
/*     */       
/*  98 */       if (!StringUtils.isEmpty(whereClause)) {
/*  99 */         sql.append(" ");
/* 100 */         sql.append(whereClause);
/*     */       } 
/*     */       
/* 103 */       StringBuilder param = new StringBuilder();
/* 104 */       if (paramProp != null) {
/* 105 */         param.append(paramProp);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 111 */       JDBCCall call = SqlQueryBuilder.getJDBCCall(argStrategy, sql.toString(), this.props_, argParameters);
/*     */       
/* 113 */       String callString = this._queryDecorator.decorateSql(call.getSqlString(), argStrategy, argParameters);
/* 114 */       sql = new StringBuilder(callString);
/*     */       
/* 116 */       paramValueList = call.getParams();
/*     */     }
/* 118 */     catch (Exception ee) {
/* 119 */       String idClass = (id != null) ? id.getName() : null;
/* 120 */       String msg = "An unexpected exception occurred while building the sql string and parameter list. id class = " + idClass + " sql = " + sql + " parameter list = " + paramValueList;
/*     */ 
/*     */ 
/*     */       
/* 124 */       logger_.error(msg, ee);
/*     */       
/* 126 */       if (ee instanceof DtxException) {
/* 127 */         throw (DtxException)ee;
/*     */       }
/*     */       
/* 130 */       throw new DtxException(msg, ee);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 137 */     if (queryDebugLogger_.isDebugEnabled()) {
/* 138 */       queryDebugLogger_.debug("DTX Query: [" + this.props_.get("Name") + "] preparing to execute on datasource: " + argStrategy
/* 139 */           .getDataSourceName() + " (DtxQueryHandler)");
/* 140 */       queryDebugLogger_.debug("  [" + this.props_.get("Name") + "] sql to execute: " + 
/* 141 */           SqlQueryBuilder.cleanSqlString(sql.toString()));
/* 142 */       queryDebugLogger_.debug("  [" + this.props_.get("Name") + "] parameter values: " + paramValueList);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 149 */     Object result = null;
/*     */     
/*     */     try {
/* 152 */       result = ((JDBCPersistenceStrategy)argStrategy).getModelsByQuery(sql.toString(), paramValueList, id, 
/* 153 */           SqlQueryExecutor.getMaxRecordValue(this.props_), argQueryToken);
/* 154 */       return result;
/*     */     } finally {
/*     */       
/* 157 */       if (queryDebugLogger_.isDebugEnabled()) {
/* 158 */         queryDebugLogger_.debug("  [" + this.props_.get("Name") + "] result: " + result);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Properties getProperties() {
/* 166 */     return this.props_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSourceDescription() {
/* 172 */     return this.sourceDescription_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProperties(Properties argProperties) {
/* 178 */     this.props_ = argProperties;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQueryDecorator(ISqlQueryDecorator argQueryDecorator) {
/* 184 */     this._queryDecorator = argQueryDecorator;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSourceDescription(String argSourceDescription) {
/* 190 */     this.sourceDescription_ = argSourceDescription;
/*     */   }
/*     */   
/*     */   private Class<?> getIdClass(Map<String, Object> argParams) {
/* 194 */     String className = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 199 */     Object classObject = ObjectUtils.coalesce(new Object[] { argParams.get("ClassName"), this.props_.get("ClassName"), this.props_.get("ResultClass") });
/*     */     
/* 201 */     if (classObject != null) {
/* 202 */       if (classObject instanceof Class) {
/* 203 */         className = ((Class)classObject).getName();
/*     */       } else {
/*     */         
/* 206 */         className = classObject.toString();
/*     */       } 
/*     */     }
/*     */     
/* 210 */     if (StringUtils.isEmpty(className)) {
/* 211 */       throw new DtxException("Could not determine candidate class for query: " + this.props_.get("Name") + ". 'ClassName' attribute was not specified in QueryConfig OR in the query parameters.");
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 216 */       return getClass().getClassLoader().loadClass(className);
/*     */     }
/* 218 */     catch (ClassNotFoundException ex) {
/* 219 */       String message = "Unable to find candidate class for query [" + this.props_.get("Name") + "]";
/* 220 */       logger_.error(message, ex);
/* 221 */       throw new DtxException(message, ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getImplicitJoinTables(Properties argProperties, Map<? extends Object, ? extends Object> argParams) {
/* 242 */     String TABLE_PREFIX = "Tables.";
/*     */     
/* 244 */     List<Object> tables = new ArrayList();
/* 245 */     Set<Object> keys = argProperties.keySet();
/*     */     
/* 247 */     if (keys != null && !keys.isEmpty()) {
/*     */       
/* 249 */       Iterator<Object> it = keys.iterator();
/*     */       
/* 251 */       while (it.hasNext()) {
/* 252 */         String key = it.next().toString();
/* 253 */         if (key.startsWith("Tables.")) {
/* 254 */           String optionParm = key.substring("Tables.".length());
/*     */           
/* 256 */           Object present = argParams.get(optionParm);
/*     */           
/* 258 */           if (present != null) {
/* 259 */             tables.add(argProperties.get(key));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 264 */     StringBuilder tableClause = new StringBuilder(tables.size() * 12);
/*     */     
/* 266 */     for (int ii = 0; ii < tables.size(); ii++) {
/* 267 */       tableClause.append(tables.get(ii).toString());
/*     */       
/* 269 */       if (ii < tables.size() - 1) {
/* 270 */         tableClause.append(", ");
/*     */       }
/*     */     } 
/* 273 */     return tableClause.toString();
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\DtxQueryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */