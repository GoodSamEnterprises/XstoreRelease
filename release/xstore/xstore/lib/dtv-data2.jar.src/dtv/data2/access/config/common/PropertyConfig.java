/*    */ package dtv.data2.access.config.common;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.crypto.EncString;
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
/*    */ 
/*    */ 
/*    */ public class PropertyConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String key_;
/*    */   private EncString value_;
/*    */   
/*    */   public String getKey() {
/* 28 */     return this.key_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getValue() {
/* 36 */     return EncString.getSensitiveData(this.value_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argName, IConfigObject argValue) {
/* 41 */     if ("Key".equalsIgnoreCase(argName)) {
/* 42 */       this.key_ = argValue.toString();
/*    */     }
/* 44 */     else if ("Value".equalsIgnoreCase(argName)) {
/* 45 */       this.value_ = EncString.valueOf(argValue.toString());
/*    */     } else {
/*    */       
/* 48 */       warnUnsupported(argName, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\common\PropertyConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */