/*     */ package dtv.data2.access.config.query;
/*     */ 
/*     */ import dtv.data2.access.config.common.PropertyConfig;
/*     */ import dtv.data2.access.query.SqlQueryBuilder;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.lang3.StringUtils;
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
/*     */ public class QueryConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*  28 */   private static final Logger logger_ = Logger.getLogger(QueryConfig.class);
/*     */   
/*  30 */   private static final String SPACE_AS_HEX = Integer.toString(32, 16);
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
/*  45 */   private final Properties propertyConfigs_ = new Properties();
/*  46 */   private final List<ResultFieldConfig> resultFieldConfigs_ = new ArrayList<>();
/*  47 */   private final List<QueryStatementConfig> statementConfigs_ = new ArrayList<>();
/*  48 */   private final List<QuerySortConfig> sortConfigs_ = new ArrayList<>();
/*  49 */   private final List<QueryHavingConfig> havingConfigs_ = new ArrayList<>();
/*     */   private static final String COMMA_DELIMITER = ", ";
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String name_;
/*     */   private Class<Object> queryHandler_;
/*     */   private String resultClass_;
/*     */   private String _resultFilterName;
/*     */   
/*     */   public QueryDescriptor getQueryDescriptor() {
/*  58 */     String[] results = null;
/*  59 */     ArrayList<String> resultDataTypes = null;
/*     */     
/*  61 */     adaptStatementConfig(this.statementConfigs_);
/*  62 */     adaptSortProperties(this.sortConfigs_);
/*  63 */     adaptHavingClauses(this.havingConfigs_);
/*     */     
/*  65 */     if (this.resultFieldConfigs_ != null && !this.resultFieldConfigs_.isEmpty()) {
/*  66 */       results = new String[this.resultFieldConfigs_.size()];
/*  67 */       resultDataTypes = new ArrayList<>();
/*  68 */       Collections.sort(this.resultFieldConfigs_);
/*     */       
/*  70 */       for (int i = 0; i < this.resultFieldConfigs_.size(); i++) {
/*  71 */         results[i] = ((ResultFieldConfig)this.resultFieldConfigs_.get(i)).getName();
/*  72 */         String dataType = ((ResultFieldConfig)this.resultFieldConfigs_.get(i)).getType();
/*     */         
/*  74 */         if (!StringUtils.isEmpty(dataType)) {
/*  75 */           resultDataTypes.add(((ResultFieldConfig)this.resultFieldConfigs_.get(i)).getType());
/*     */         }
/*     */       } 
/*     */       
/*  79 */       if (this.propertyConfigs_.getProperty("DataTypes") == null && resultDataTypes.size() > 0) {
/*  80 */         this.propertyConfigs_.setProperty("DataTypes", StringUtils.join(resultDataTypes, ", "));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     if (this.propertyConfigs_ != null) {
/*  88 */       Set<Object> propertyKeys = this.propertyConfigs_.keySet();
/*     */       
/*  90 */       for (Object key : propertyKeys) {
/*  91 */         if (key.toString().startsWith("SQL") || key.toString().startsWith("WhereClause") || key
/*  92 */           .toString().startsWith("Parameters")) {
/*  93 */           String value = this.propertyConfigs_.getProperty(key.toString());
/*  94 */           value = SqlQueryBuilder.cleanSqlString(value) + " ";
/*     */           
/*  96 */           for (int ii = 0; ii < value.length(); ii++) {
/*  97 */             char c = value.charAt(ii);
/*     */             
/*  99 */             if (c >= '\000' && c < ' ') {
/* 100 */               value = value.replace(c, ' ');
/* 101 */               logger_.warn("Replacing non-printable char 0x" + Integer.toString(c, 16) + " with 0x" + SPACE_AS_HEX + " at string index: [" + ii + "] - Please cleanup property with key: [" + key + "] from the query definition at: " + 
/*     */                   
/* 103 */                   getSourceDescription());
/*     */             } 
/*     */           } 
/*     */           
/* 107 */           this.propertyConfigs_.setProperty(key.toString(), value);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 114 */     QueryDescriptor queryDescriptor = new QueryDescriptor(this.name_, this.queryHandler_, this.resultClass_, results, this.propertyConfigs_, getSourceDescription());
/* 115 */     queryDescriptor.setResultFilter(this._resultFilterName);
/* 116 */     return queryDescriptor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 122 */     if ("Name".equalsIgnoreCase(argKey)) {
/* 123 */       this.name_ = argValue.toString();
/*     */     }
/* 125 */     else if ("QueryHandler".equalsIgnoreCase(argKey)) {
/* 126 */       this.queryHandler_ = ConfigUtils.toClass(argValue);
/*     */     }
/* 128 */     else if ("ResultFilter".equalsIgnoreCase(argKey)) {
/* 129 */       this._resultFilterName = argValue.toString();
/*     */     }
/* 131 */     else if ("ResultClass".equalsIgnoreCase(argKey)) {
/* 132 */       this.resultClass_ = argValue.toString();
/* 133 */       addProperty("ResultClass", this.resultClass_);
/*     */     }
/* 135 */     else if ("ResultField".equalsIgnoreCase(argKey) && argValue instanceof ResultFieldConfig) {
/* 136 */       ResultFieldConfig value = (ResultFieldConfig)argValue;
/*     */       
/* 138 */       if (value.getOrder() < 0) {
/* 139 */         value.setOrder(this.resultFieldConfigs_.size());
/*     */       }
/* 141 */       this.resultFieldConfigs_.add(value);
/*     */     }
/* 143 */     else if ("Property".equalsIgnoreCase(argKey) && argValue instanceof PropertyConfig) {
/* 144 */       addProperty(((PropertyConfig)argValue).getKey(), ((PropertyConfig)argValue).getValue());
/*     */     }
/* 146 */     else if ("pmType".equalsIgnoreCase(argKey)) {
/* 147 */       addProperty("PMType", argValue.toString());
/*     */     }
/* 149 */     else if ("Suffix".equalsIgnoreCase(argKey)) {
/* 150 */       addProperty("Suffix", argValue.toString());
/*     */     }
/* 152 */     else if ("SQL".equalsIgnoreCase(argKey)) {
/* 153 */       QueryStatementConfig config = (QueryStatementConfig)argValue;
/* 154 */       if (config.getOrder() < 0)
/*     */       {
/* 156 */         config.setOrder(this.statementConfigs_.size());
/*     */       }
/* 158 */       this.statementConfigs_.add(config);
/*     */     }
/* 160 */     else if ("Sort".equalsIgnoreCase(argKey)) {
/* 161 */       this.sortConfigs_.add((QuerySortConfig)argValue);
/*     */     }
/* 163 */     else if ("Having".equalsIgnoreCase(argKey)) {
/* 164 */       this.havingConfigs_.add((QueryHavingConfig)argValue);
/*     */     }
/* 166 */     else if ("ClassName".equals(argKey)) {
/* 167 */       addProperty("ClassName", argValue.toString());
/*     */     } else {
/*     */       
/* 170 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void adaptHavingClauses(List<QueryHavingConfig> argHavingConfigs) {
/* 180 */     int suffix = 1;
/*     */     
/* 182 */     for (QueryHavingConfig havingConfig : argHavingConfigs) {
/* 183 */       addProperty("Having" + suffix, havingConfig.getCondition());
/* 184 */       addProperty("Having" + suffix + ".Field", havingConfig.getTestExpression());
/* 185 */       addProperty("Having" + suffix + ".Parameters", 
/* 186 */           getParamsAsString(havingConfig.getParameters(), ", "));
/* 187 */       suffix++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void adaptSortProperties(List<QuerySortConfig> argSortConfigs) {
/* 197 */     int suffix = 1;
/*     */     
/* 199 */     for (QuerySortConfig sortConfig : argSortConfigs) {
/* 200 */       addProperty("Sort" + suffix, sortConfig.getSortField());
/*     */       
/* 202 */       if (sortConfig.getSortOrder() != null) {
/* 203 */         addProperty("Sort" + suffix + "." + "Order", sortConfig.getSortOrder());
/*     */       }
/*     */       
/* 206 */       if (sortConfig.isRequiredSort() != null) {
/* 207 */         addProperty("Sort" + suffix + "." + "RequiredSort", sortConfig.isRequiredSort());
/*     */       }
/*     */       
/* 210 */       suffix++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void adaptStatementConfig(List<QueryStatementConfig> argStatementConfigs) {
/* 220 */     int queryCount = argStatementConfigs.size();
/*     */     
/* 222 */     if (queryCount > 1) {
/* 223 */       addProperty("QueryCount", String.valueOf(queryCount));
/*     */     }
/*     */     
/* 226 */     Collections.sort(argStatementConfigs);
/* 227 */     int currentQueryIdx = 1;
/*     */     
/* 229 */     for (QueryStatementConfig statementConfig : argStatementConfigs) {
/* 230 */       String requiredParamList = "";
/* 231 */       String suffix = (queryCount > 1) ? String.valueOf(currentQueryIdx) : "";
/* 232 */       addProperty("SQL" + suffix, statementConfig.getStatement());
/* 233 */       requiredParamList = getParamsAsString(statementConfig.getParameters(), ", ");
/*     */       
/* 235 */       if (!StringUtils.isEmpty(requiredParamList)) {
/* 236 */         addProperty("Parameters" + suffix, requiredParamList.toString());
/*     */       }
/*     */       
/* 239 */       for (QueryExpressionConfig expression : statementConfig.getExpressions()) {
/* 240 */         addProperty("Parameters" + suffix + "." + expression.getTrigger(), expression.getParameters());
/* 241 */         addProperty("SQL" + suffix + "." + expression.getTrigger(), expression.getExpression());
/*     */       } 
/*     */       
/* 244 */       if (statementConfig.getDtxWhereClause() != null) {
/* 245 */         addProperty("WhereClause", statementConfig.getDtxWhereClause());
/*     */       }
/*     */       
/* 248 */       if (!statementConfig.isRequired()) {
/* 249 */         addProperty("SQL" + suffix + "." + "Required", String.valueOf(statementConfig.isRequired()));
/*     */       }
/*     */ 
/*     */       
/* 253 */       currentQueryIdx++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addProperty(String argKey, String argValue) {
/* 264 */     if (argKey != null && argValue != null) {
/* 265 */       this.propertyConfigs_.setProperty(argKey, argValue);
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
/*     */   private String getParamsAsString(List<QueryParameterConfig> argParamConfigs, String argDelimiter) {
/* 277 */     StringBuffer paramString = new StringBuffer();
/*     */     
/* 279 */     for (QueryParameterConfig paramConfig : argParamConfigs) {
/* 280 */       if (paramString.length() > 0) {
/* 281 */         paramString.append(argDelimiter);
/*     */       }
/*     */       
/* 284 */       paramString.append(paramConfig.getName());
/*     */     } 
/*     */     
/* 287 */     return paramString.toString();
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\query\QueryConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */