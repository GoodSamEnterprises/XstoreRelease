/*     */ package dtv.data2.access.query;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IQueryResult;
/*     */ import dtv.data2.access.config.query.QueryDescriptor;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.exception.FailoverException;
/*     */ import dtv.data2.access.impl.IPersistenceStrategy;
/*     */ import dtv.data2.access.impl.jdbc.JDBCCall;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.inject.Inject;
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
/*     */ public class SqlQueryHandler
/*     */   implements IQueryHandler
/*     */ {
/*     */   public static final String PARAM_DB_TABLE = "DB_TABLE";
/*     */   private static final String PARAM_SUPPRESS_ALIAS = "SuppressTableAlias";
/*     */   private static final String WILDCARD_DB_TABLE = "\\{\\%TABLE\\%\\}";
/*     */   private static final String WILDCARD_DB_TABLE_ALIAS = "\\{\\%ALIAS\\%\\}";
/*     */   private static final Pattern DB_TABLE_ALIAS_PATTERN;
/*  67 */   private static final Logger logger_ = Logger.getLogger(SqlQueryHandler.class);
/*  68 */   private static final Logger queryDebugLogger_ = Logger.getLogger("DtxQueryDebugger");
/*     */   
/*     */   static {
/*  71 */     String ws = "[\\s\\r\\n]+";
/*  72 */     DB_TABLE_ALIAS_PATTERN = Pattern.compile("DELETE[\\s\\r\\n]+\\{\\%ALIAS\\%\\}[\\s\\r\\n]+FROM[\\s\\r\\n]+\\w+[\\s\\r\\n]+(\\w)", 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Properties props_;
/*     */ 
/*     */   
/*     */   private String sourceDescription_;
/*     */ 
/*     */   
/*     */   private String queryKey_;
/*     */ 
/*     */   
/*     */   private ISqlQueryDecorator _queryDecorator;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private IResultFilterFactory _resultFilterFactory;
/*     */ 
/*     */ 
/*     */   
/*     */   public Object execute(IPersistenceStrategy argStrategy, Map<String, Object> argParameters, QueryToken argQueryToken) throws Exception {
/*  96 */     if (!(argStrategy instanceof dtv.data2.access.impl.jdbc.JDBCPersistenceStrategy)) {
/*  97 */       throw new DtxException(getClass().getName() + " can only work with JDBCPersistenceStrategy currently. The strategy passed instead was: " + argStrategy);
/*     */     }
/*     */ 
/*     */     
/* 101 */     String sqlStatementBase = "";
/* 102 */     int queryCount = Integer.parseInt(this.props_.getProperty("QueryCount", "0"));
/*     */     
/* 104 */     if (queryCount > 0) {
/* 105 */       sqlStatementBase = SqlQueryBuilder.buildBaseQuery(this.props_, argParameters, queryCount);
/*     */     } else {
/*     */       
/* 108 */       sqlStatementBase = this.props_.getProperty("SQL");
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 113 */     sqlStatementBase = replaceTableWildcard(sqlStatementBase, argParameters);
/* 114 */     sqlStatementBase = replaceAliasWildcard(sqlStatementBase, argParameters);
/*     */     
/* 116 */     QueryDescriptor queryDescriptor = DataFactory.getInstance().getQueryDescriptor(this.queryKey_);
/*     */     
/* 118 */     JDBCCall call = SqlQueryBuilder.getJDBCCall(argStrategy, sqlStatementBase, this.props_, argParameters);
/*     */     
/* 120 */     String callString = this._queryDecorator.decorateSql(call.getSqlString(), argStrategy, argParameters);
/* 121 */     StringBuilder sql = new StringBuilder(callString);
/*     */     
/* 123 */     if (queryDebugLogger_.isDebugEnabled()) {
/* 124 */       queryDebugLogger_.debug("SQL Query: [" + this.queryKey_ + "] preparing to execute on data source: " + argStrategy
/* 125 */           .getDataSourceName() + " (SqlQueryHandler)");
/* 126 */       queryDebugLogger_.debug("  [" + this.queryKey_ + "] sql to execute: " + call.getSqlString());
/* 127 */       queryDebugLogger_.debug("  [" + this.queryKey_ + "] parameter values: " + call.getParams());
/*     */     } 
/*     */     
/* 130 */     Object<? extends IQueryResult> result = null;
/*     */     try {
/*     */       List<? extends IQueryResult> list;
/* 133 */       result = (Object<? extends IQueryResult>)SqlQueryExecutor.execute(sql.toString(), call.getParams(), call.getParamNames(), this.props_, queryDescriptor
/* 134 */           .getResultFields(), null, queryDescriptor.getResultClass(), argStrategy, argQueryToken);
/*     */ 
/*     */       
/* 137 */       if (result == null) {
/* 138 */         list = null; return list;
/*     */       } 
/*     */       
/* 141 */       Object<? extends IQueryResult> rawResult = null;
/* 142 */       if (result instanceof QueryResultWrapper) {
/* 143 */         rawResult = (Object<? extends IQueryResult>)((QueryResultWrapper)result).getData();
/*     */       } else {
/*     */         
/* 146 */         rawResult = result;
/*     */       } 
/*     */       
/* 149 */       if (queryDescriptor.getResultClass() != null) {
/* 150 */         if (rawResult instanceof Object[][]) {
/*     */           
/* 152 */           List<? extends IQueryResult> resultList = Arrays.asList(QueryResultBuilder.getInstance().buildResults(this.queryKey_, (Object[][])rawResult, queryDescriptor
/* 153 */                 .getResultFields(), queryDescriptor.getResultClass(), argStrategy
/* 154 */                 .getDataSourceName()));
/*     */           
/* 156 */           if (queryDescriptor.getResultFilter() != null) {
/* 157 */             IResultFilter filter = this._resultFilterFactory.getResultFilter(queryDescriptor.getResultFilter());
/* 158 */             rawResult = (Object<? extends IQueryResult>)filter.filter(resultList, argParameters);
/*     */           } else {
/*     */             
/* 161 */             list = resultList;
/*     */           } 
/*     */         } else {
/*     */           
/* 165 */           logger_
/* 166 */             .warn("Query: [" + this.queryKey_ + "] returned unexpected results: [" + result + "] Unable to load this data into the result class.  The raw data will be returned.");
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 171 */       if (result instanceof dtv.data2.access.IQueryResultWrapper) {
/* 172 */         ((QueryResultWrapper)result).setData(list);
/*     */       }
/*     */       
/* 175 */       return result;
/*     */     }
/* 177 */     catch (Exception ee) {
/* 178 */       if (FailoverException.isFailover(ee)) {
/* 179 */         throw FailoverException.getNewException(ee, argStrategy.getDataSourceName());
/*     */       }
/*     */       
/* 182 */       throw ee;
/*     */     }
/*     */     finally {
/*     */       
/* 186 */       if (queryDebugLogger_.isDebugEnabled()) {
/* 187 */         queryDebugLogger_.debug("  [" + this.queryKey_ + "] result: " + result);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Properties getProperties() {
/* 195 */     return this.props_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSourceDescription() {
/* 200 */     return this.sourceDescription_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProperties(Properties argProperties) {
/* 206 */     this.props_ = argProperties;
/*     */     
/* 208 */     if (this.props_ == null) {
/* 209 */       throw new DtxException("Null props were passed to SqlQueryHandler");
/*     */     }
/* 211 */     this.queryKey_ = this.props_.getProperty("Name");
/*     */     
/* 213 */     if (StringUtils.isEmpty(this.queryKey_)) {
/* 214 */       throw new DtxException("Properties passed to SqlQueryHandler do not contain a valid query key. " + this.props_);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQueryDecorator(ISqlQueryDecorator argQueryDecorator) {
/* 222 */     this._queryDecorator = argQueryDecorator;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSourceDescription(String argSourceDescription) {
/* 227 */     this.sourceDescription_ = argSourceDescription;
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
/*     */   protected String replaceAliasWildcard(String argSqlStatement, Map<String, Object> argParameters) {
/* 240 */     String sqlStatement = argSqlStatement;
/* 241 */     boolean suppressAlias = ConfigUtils.toBoolean(argParameters.get("SuppressTableAlias"), false).booleanValue();
/*     */     
/* 243 */     Matcher matcher = DB_TABLE_ALIAS_PATTERN.matcher(argSqlStatement);
/*     */     
/* 245 */     if (matcher.find()) {
/* 246 */       String alias = suppressAlias ? "" : matcher.group(1);
/* 247 */       sqlStatement = sqlStatement.replaceAll("\\{\\%ALIAS\\%\\}", alias);
/*     */     } 
/* 249 */     return sqlStatement;
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
/*     */   protected String replaceTableWildcard(String argSqlStatement, Map<String, Object> argParameters) {
/* 262 */     return argSqlStatement.replaceAll("\\{\\%TABLE\\%\\}", StringUtils.nonNull(argParameters.get("DB_TABLE")));
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\SqlQueryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */