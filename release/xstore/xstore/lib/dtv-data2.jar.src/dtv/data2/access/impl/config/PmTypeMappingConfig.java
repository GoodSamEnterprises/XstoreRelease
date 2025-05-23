/*    */ package dtv.data2.access.impl.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PmTypeMappingConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   static final String MAIN_TAG = "PmTypeMapping";
/*    */   private static final String ID_CLASS_TAG = "ObjectId";
/*    */   private static final String PM_TYPE_TAG = "PmType";
/*    */   private static final String LOAD_PROPERTIES_TAG = "LoadProperties";
/*    */   private String idClass_;
/*    */   private String pmType_;
/* 26 */   private Boolean loadProperties_ = Boolean.FALSE;
/*    */   
/*    */   public String getIdClass() {
/* 29 */     return this.idClass_;
/*    */   }
/*    */   
/*    */   public String getPmType() {
/* 33 */     return this.pmType_;
/*    */   }
/*    */   
/*    */   public Boolean isLoadPropertiesEnabled() {
/* 37 */     return this.loadProperties_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 42 */     if ("ObjectId".equalsIgnoreCase(argKey)) {
/* 43 */       this.idClass_ = argValue.toString();
/*    */     }
/* 45 */     else if ("PmType".equalsIgnoreCase(argKey)) {
/* 46 */       this.pmType_ = argValue.toString();
/*    */     }
/* 48 */     else if ("LoadProperties".equalsIgnoreCase(argKey)) {
/* 49 */       this.loadProperties_ = Boolean.valueOf(ConfigUtils.toBoolean(argValue));
/*    */     } else {
/*    */       
/* 52 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\config\PmTypeMappingConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */