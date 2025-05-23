/*     */ package dtv.data2.access.config.query;
/*     */ 
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.IHasSourceDescription;
/*     */ import java.util.Properties;
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
/*     */ public class QueryDescriptor
/*     */   implements IHasSourceDescription
/*     */ {
/*  22 */   private static final String[] NO_RESULT_FIELDS = new String[0];
/*     */   
/*     */   private final String name_;
/*     */   
/*     */   private final Properties props_;
/*     */   
/*     */   private final Class<?> queryHandler_;
/*     */   
/*     */   private final String[] resultFields_;
/*     */   private final String sourceDescription_;
/*     */   private Class<?> resultClass_;
/*     */   private String resultClassName_;
/*     */   private String _resultFilterName;
/*     */   
/*     */   public QueryDescriptor(String argName, Class<?> argQueryHandler, Class<?> argResultClass, String[] argResultFields, Properties argProps, String argSourceDescription) {
/*  37 */     this.name_ = argName;
/*  38 */     this.queryHandler_ = argQueryHandler;
/*  39 */     this.resultClass_ = argResultClass;
/*  40 */     this.resultFields_ = argResultFields;
/*  41 */     this.props_ = argProps;
/*  42 */     this.sourceDescription_ = argSourceDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public QueryDescriptor(String argName, Class<?> argQueryHandler, String argResultClassName, String[] argResultFields, Properties argProps, String argSourceDescription) {
/*  48 */     this.name_ = argName;
/*  49 */     this.queryHandler_ = argQueryHandler;
/*  50 */     this.resultClassName_ = argResultClassName;
/*  51 */     this.resultFields_ = argResultFields;
/*  52 */     this.props_ = argProps;
/*  53 */     this.sourceDescription_ = argSourceDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  61 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Properties getProperties() {
/*  69 */     return this.props_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getQueryHandler() {
/*  77 */     return this.queryHandler_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getResultClass() {
/*  85 */     if (this.resultClass_ == null && 
/*  86 */       !StringUtils.isEmpty(this.resultClassName_)) {
/*     */       
/*     */       try {
/*  89 */         this.resultClass_ = Thread.currentThread().getContextClassLoader().loadClass(this.resultClassName_);
/*     */       }
/*  91 */       catch (Exception ex) {
/*     */         
/*     */         try {
/*  94 */           this.resultClass_ = getClass().getClassLoader().loadClass(this.resultClassName_);
/*     */         }
/*  96 */         catch (ClassNotFoundException ex2) {
/*  97 */           throw new DtxException("Unabled to load result class specified in QueryConfig: " + this.resultClassName_, ex);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 103 */     return this.resultClass_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getResultFields() {
/* 111 */     return (this.resultFields_ == null) ? NO_RESULT_FIELDS : this.resultFields_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getResultFilter() {
/* 118 */     return this._resultFilterName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSourceDescription() {
/* 124 */     return this.sourceDescription_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setResultFilter(String argResultFilterName) {
/* 131 */     this._resultFilterName = argResultFilterName;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\query\QueryDescriptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */