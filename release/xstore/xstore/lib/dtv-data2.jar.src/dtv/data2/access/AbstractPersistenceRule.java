/*     */ package dtv.data2.access;
/*     */ 
/*     */ import dtv.data2.access.impl.PersistableMetaData;
/*     */ import dtv.data2.access.impl.config.PmTypeMappingConfigHelper;
/*     */ import dtv.data2.access.pm.PersistenceManagerType;
/*     */ import dtv.data2.access.pm.PmTypeDeterminationException;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.IConfigObject;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractPersistenceRule
/*     */   implements IPersistenceRule
/*     */ {
/*     */   protected static final String PARAM_SOURCE_DATA_SOURCE = "SourceDataSource";
/*     */   protected static final String PARAM_SOURCE_DATA_SOURCE_EXPRESSION = "SourceDataSourceExpression";
/*     */   protected static final String PARAM_TARGET_DATA_SOURCE = "TargetDataSource";
/*     */   protected static final String PARAM_TARGET_DATA_SOURCE_EXPRESSION = "TargetDataSourceExpression";
/*  65 */   private static final Logger _logger = Logger.getLogger(AbstractPersistenceRule.class);
/*     */   
/*     */   @Inject
/*     */   private PmTypeMappingConfigHelper _cfg;
/*     */   
/*     */   private final boolean _supportsSourceDataSourceParam;
/*     */   
/*     */   private final boolean _supportsTargetDataSourceParam;
/*  73 */   private String _sourceDataSourceName = null;
/*  74 */   private String _sourceDataSourceExpression = null;
/*  75 */   private String _targetDataSourceName = null;
/*  76 */   private String _targetDataSourceExpression = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AbstractPersistenceRule() {
/*  82 */     this(false, false);
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
/*     */   public AbstractPersistenceRule(boolean argSupportsSourceDataSourceParam, boolean argSupportsTargetDataSourceParam) {
/* 102 */     this._supportsSourceDataSourceParam = argSupportsSourceDataSourceParam;
/* 103 */     this._supportsTargetDataSourceParam = argSupportsTargetDataSourceParam;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IPersistenceMgrType getPMTypeByObjectId(Class<? extends Object> argObjectIdClass) {
/* 113 */     String pmTypeString = null;
/*     */     try {
/* 115 */       pmTypeString = this._cfg.getPMType(argObjectIdClass.getName());
/* 116 */     } catch (Exception ex) {
/* 117 */       if (ex instanceof PmTypeDeterminationException) {
/* 118 */         throw (RuntimeException)ex;
/*     */       }
/* 120 */       throw new PmTypeDeterminationException("Unable to determine PM type for id: " + argObjectIdClass
/* 121 */           .getName() + " see cause exception.", ex);
/*     */     } 
/*     */ 
/*     */     
/* 125 */     if (!StringUtils.isEmpty(pmTypeString)) {
/* 126 */       return (IPersistenceMgrType)PersistenceManagerType.forName(pmTypeString);
/*     */     }
/* 128 */     throw new PmTypeDeterminationException("Unable to determine PM type for id: " + argObjectIdClass.getName() + " retrieved null or empty PM type string.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getSourceDataSourceExpression() {
/* 138 */     return StringUtils.isEmpty(this._sourceDataSourceExpression) ? this._sourceDataSourceName : this._sourceDataSourceExpression;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getSourceDataSourceName() {
/* 148 */     return this._sourceDataSourceName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getTargetDataSourceName() {
/* 158 */     return this._targetDataSourceName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getTargeteDataSourceExpression() {
/* 166 */     return StringUtils.isEmpty(this._targetDataSourceExpression) ? this._targetDataSourceName : this._targetDataSourceExpression;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isApplicable(PersistableMetaData argPersistableMetaData, Object argObject) {
/* 173 */     return true;
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
/*     */   protected boolean matchesSourceDataSource(String argDataSource, boolean argDefault) {
/* 193 */     String matchExpression = getSourceDataSourceExpression();
/* 194 */     return StringUtils.isEmpty(matchExpression) ? argDefault : argDataSource.matches(matchExpression);
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
/*     */   protected boolean matchesTargetDataSource(String argDataSource, boolean argDefault) {
/* 214 */     String matchExpression = getTargeteDataSourceExpression();
/* 215 */     return StringUtils.isEmpty(matchExpression) ? argDefault : argDataSource.matches(matchExpression);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, IConfigObject argValue) {
/* 221 */     if ("SourceDataSource".equalsIgnoreCase(argName) && this._supportsSourceDataSourceParam) {
/* 222 */       this._sourceDataSourceName = argValue.toString();
/* 223 */     } else if ("SourceDataSourceExpression".equalsIgnoreCase(argName) && this._supportsSourceDataSourceParam) {
/*     */       
/* 225 */       this._sourceDataSourceExpression = argValue.toString();
/* 226 */     } else if ("TargetDataSource".equalsIgnoreCase(argName) && this._supportsTargetDataSourceParam) {
/* 227 */       this._targetDataSourceName = argValue.toString();
/* 228 */     } else if ("TargetDataSourceExpression".equalsIgnoreCase(argName) && this._supportsTargetDataSourceParam) {
/*     */       
/* 230 */       this._targetDataSourceExpression = argValue.toString();
/*     */     } else {
/* 232 */       _logger.warn("This persistence rule does not support parameters!  [" + argName + "] = [" + argValue + "] is illegal!");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\AbstractPersistenceRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */