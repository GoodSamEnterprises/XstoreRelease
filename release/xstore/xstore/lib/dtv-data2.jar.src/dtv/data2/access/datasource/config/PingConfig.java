/*    */ package dtv.data2.access.datasource.config;
/*    */ 
/*    */ import dtv.data2.access.config.common.PropertyConfig;
/*    */ import dtv.data2.access.config.common.PropertyConfigConverter;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Properties;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PingConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 25 */   private static final Logger logger_ = Logger.getLogger(PingConfig.class);
/*    */   
/* 27 */   private final List<PropertyConfig> properties_ = new ArrayList<>();
/*    */   
/*    */   private Class<?> impl_;
/*    */   
/*    */   public IPing getPing() {
/* 32 */     IPing ping = null;
/*    */     
/* 34 */     if (this.impl_ == null) {
/* 35 */       throw new Error("No ping implementation specified!");
/*    */     }
/*    */     
/*    */     try {
/* 39 */       ping = (IPing)this.impl_.newInstance();
/*    */     }
/* 41 */     catch (Exception ex) {
/* 42 */       String err = "Invalid IPing implementation: " + this.impl_.getName();
/* 43 */       logger_.error(err, ex);
/* 44 */       throw new Error(err, ex);
/*    */     } 
/*    */     
/* 47 */     if (!this.properties_.isEmpty() && ping != null) {
/* 48 */       ping.setProperties(PropertyConfigConverter.convert(this.properties_, new Properties()));
/*    */     }
/*    */     
/* 51 */     return ping;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 57 */     if ("Property".equalsIgnoreCase(argKey) && argValue instanceof PropertyConfig) {
/* 58 */       this.properties_.add((PropertyConfig)argValue);
/*    */     }
/* 60 */     else if ("ClassName".equalsIgnoreCase(argKey)) {
/* 61 */       Class<?> clazz = ConfigUtils.toClass(argValue);
/* 62 */       if (logger_.isDebugEnabled()) {
/* 63 */         logger_.debug("Ping implementation: " + clazz);
/*    */       }
/* 65 */       this.impl_ = clazz;
/*    */     } else {
/*    */       
/* 68 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\datasource\config\PingConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */