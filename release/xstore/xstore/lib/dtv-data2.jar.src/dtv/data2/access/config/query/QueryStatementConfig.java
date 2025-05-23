/*     */ package dtv.data2.access.config.query;
/*     */ 
/*     */ import com.google.common.base.CharMatcher;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public class QueryStatementConfig
/*     */   extends AbstractParentConfig
/*     */   implements Comparable<QueryStatementConfig>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  25 */   private final List<QueryExpressionConfig> expressions_ = new ArrayList<>();
/*  26 */   private int order_ = -1;
/*  27 */   private final List<QueryParameterConfig> parameters_ = new ArrayList<>();
/*  28 */   private String statement_ = null;
/*  29 */   private String dtxWhereClause_ = null;
/*     */   
/*     */   private boolean requiredFlag_ = true;
/*     */ 
/*     */   
/*     */   public int compareTo(QueryStatementConfig argOther) {
/*  35 */     return this.order_ - argOther.order_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDtxWhereClause() {
/*  44 */     return this.dtxWhereClause_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<QueryExpressionConfig> getExpressions() {
/*  53 */     return this.expressions_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOrder() {
/*  62 */     return this.order_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<QueryParameterConfig> getParameters() {
/*  71 */     return this.parameters_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStatement() {
/*  80 */     return this.statement_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRequired() {
/*  89 */     return this.requiredFlag_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  95 */     if ("Expression".equalsIgnoreCase(argKey)) {
/*  96 */       this.expressions_.add((QueryExpressionConfig)argValue);
/*     */     }
/*  98 */     else if ("Parameter".equalsIgnoreCase(argKey)) {
/*  99 */       this.parameters_.add((QueryParameterConfig)argValue);
/*     */     }
/* 101 */     else if ("Order".equalsIgnoreCase(argKey)) {
/* 102 */       this.order_ = ConfigUtils.asInt(argValue.toString());
/*     */     }
/* 104 */     else if ("Statement".equalsIgnoreCase(argKey)) {
/* 105 */       this.statement_ = CharMatcher.WHITESPACE.trimLeadingFrom(argValue.toString());
/*     */     }
/* 107 */     else if ("WhereClause".equalsIgnoreCase(argKey)) {
/* 108 */       this.dtxWhereClause_ = argValue.toString();
/*     */     }
/* 110 */     else if ("required".equalsIgnoreCase(argKey)) {
/* 111 */       this.requiredFlag_ = Boolean.valueOf(argValue.toString()).booleanValue();
/*     */     } else {
/*     */       
/* 114 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrder(int argOrder) {
/* 124 */     this.order_ = argOrder;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\query\QueryStatementConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */