/*    */ package dtv.data2.access.config.pmtype;
/*    */ 
/*    */ import dtv.util.config.AbstractSetConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ 
/*    */ 
/*    */ public class PersistenceMgrTypeSetConfig
/*    */   extends AbstractSetConfig<PersistenceMgrTypeConfig>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 23 */   private final Map<String, PersistenceMgrTypeConfig> _pmTypeConfigs = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getChildTag() {
/* 29 */     return "PersistenceManagerType";
/*    */   }
/*    */   
/*    */   public PersistenceMgrTypeConfig getPmTypeConfig(String argPmTypeName) {
/* 33 */     return this._pmTypeConfigs.get(argPmTypeName);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 39 */     super.setConfigObject(argKey, argValue);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 44 */     if (getChildTag().equalsIgnoreCase(argKey)) {
/* 45 */       PersistenceMgrTypeConfig config = (PersistenceMgrTypeConfig)argValue;
/* 46 */       this._pmTypeConfigs.put(config.getName(), config);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\pmtype\PersistenceMgrTypeSetConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */