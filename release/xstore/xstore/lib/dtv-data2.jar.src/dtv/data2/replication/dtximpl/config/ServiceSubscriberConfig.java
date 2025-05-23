/*    */ package dtv.data2.replication.dtximpl.config;
/*    */ 
/*    */ import dtv.data2.replication.ReplicationException;
/*    */ import dtv.util.config.AbstractParentConfig;
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
/*    */ public class ServiceSubscriberConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private static final String TAG_NAME = "name";
/*    */   private static final String TAG_EXCLUDE = "exclude";
/*    */   private String name_;
/*    */   private boolean exclude_ = false;
/*    */   
/*    */   public String getSubscriberName() {
/* 29 */     return this.name_;
/*    */   }
/*    */   
/*    */   public boolean isExcluded() {
/* 33 */     return this.exclude_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 41 */     if ("name".equalsIgnoreCase(argKey)) {
/* 42 */       this.name_ = argValue.toString();
/*    */     }
/* 44 */     else if ("exclude".equalsIgnoreCase(argKey)) {
/*    */       
/* 46 */       if (argValue.toString().equals("true")) {
/* 47 */         this.exclude_ = true;
/*    */       }
/* 49 */       else if (argValue.toString().equals("false")) {
/* 50 */         this.exclude_ = false;
/*    */       } else {
/*    */         
/* 53 */         throw new ReplicationException("A bad value is configured for a replication service subscriber.  The exclude attribute must be a boolean value, but was: '" + argValue + "' Source: " + 
/*    */             
/* 55 */             getSourceDescription());
/*    */       } 
/*    */     } else {
/*    */       
/* 59 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 65 */     return "ServiceSubscriberConfig name: " + this.name_ + " exluded: " + this.exclude_;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\config\ServiceSubscriberConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */