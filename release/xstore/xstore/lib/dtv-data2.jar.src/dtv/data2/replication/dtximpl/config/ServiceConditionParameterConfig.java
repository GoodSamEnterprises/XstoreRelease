/*    */ package dtv.data2.replication.dtximpl.config;
/*    */ 
/*    */ import dtv.data2.replication.ReplicationConfigException;
/*    */ import dtv.util.config.AbstractConfig;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ServiceConditionParameterConfig
/*    */   extends AbstractConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private static final String TAG_KEY = "key";
/*    */   private static final String TAG_VALUE = "value";
/*    */   private String key_;
/*    */   private String value_;
/*    */   
/*    */   public String getKey() {
/* 31 */     return this.key_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getValue() {
/* 38 */     return this.value_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 44 */     if (argKey.equals("key")) {
/* 45 */       this.key_ = argValue.toString();
/*    */     }
/* 47 */     else if (argKey.equals("value")) {
/* 48 */       this.value_ = argValue.toString();
/*    */     } else {
/*    */       
/* 51 */       throw new ReplicationConfigException("unknown tag: " + argKey + " Value: " + argValue);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setValue(String arg0) {}
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\config\ServiceConditionParameterConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */