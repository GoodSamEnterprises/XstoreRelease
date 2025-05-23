/*    */ package dtv.data2.access.config.common;
/*    */ 
/*    */ import dtv.util.config.ConfigHelper;
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
/*    */ 
/*    */ 
/*    */ public abstract class AbstractDataConfigHelper<R extends IConfigObject>
/*    */   extends ConfigHelper<R>
/*    */ {
/*    */   protected IConfigObject getConfigObject(String argTagName, String argDtype, String argSourceDescription) {
/* 21 */     if ("Property".equalsIgnoreCase(argDtype)) {
/* 22 */       return (IConfigObject)new PropertyConfig();
/*    */     }
/*    */     
/* 25 */     return super.getConfigObject(argTagName, argDtype, argSourceDescription);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\common\AbstractDataConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */