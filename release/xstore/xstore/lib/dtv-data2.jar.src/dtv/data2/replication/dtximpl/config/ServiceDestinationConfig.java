/*     */ package dtv.data2.replication.dtximpl.config;
/*     */ 
/*     */ import dtv.util.config.AbstractParentConfig;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ServiceDestinationConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final String TAG_TYPE = "type";
/*     */   private static final String TAG_DATA_SOURCE_NAME = "dataSourceName";
/*     */   private static final String TAG_DATA_SOURCE_LIST = "dataSourceList";
/*     */   private static final String TAG_DESTINATION_SERVICE_NAME = "destinationService";
/*     */   private String type_;
/*     */   private String dataSourceName_;
/*     */   private List<String> dataSourceList_;
/*     */   private String destinationServiceName_;
/*     */   private String hostIp_;
/*     */   private int hostPort_;
/*     */   private String directory_;
/*     */   private int timeout_;
/*     */   
/*     */   public List<String> getDataSourceList() {
/*  40 */     return this.dataSourceList_;
/*     */   }
/*     */   
/*     */   public String getDataSourceName() {
/*  44 */     return this.dataSourceName_;
/*     */   }
/*     */   
/*     */   public String getDestinationServiceName() {
/*  48 */     return this.destinationServiceName_;
/*     */   }
/*     */   
/*     */   public String getDirectory() {
/*  52 */     return this.directory_;
/*     */   }
/*     */   
/*     */   public String getHostIp() {
/*  56 */     return this.hostIp_;
/*     */   }
/*     */   
/*     */   public int getHostPort() {
/*  60 */     return this.hostPort_;
/*     */   }
/*     */   
/*     */   public int getTimeout() {
/*  64 */     return this.timeout_;
/*     */   }
/*     */   
/*     */   public String getType() {
/*  68 */     return this.type_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  74 */     if ("type".equalsIgnoreCase(argKey)) {
/*  75 */       this.type_ = argValue.toString();
/*     */     }
/*  77 */     else if ("dataSourceName".equalsIgnoreCase(argKey)) {
/*  78 */       this.dataSourceName_ = argValue.toString();
/*     */     }
/*  80 */     else if ("dataSourceList".equalsIgnoreCase(argKey)) {
/*     */       
/*  82 */       String list = argValue.toString();
/*  83 */       String[] divided = list.split(";");
/*  84 */       if (divided != null && divided.length > 0) {
/*  85 */         this.dataSourceList_ = new ArrayList<>(divided.length);
/*  86 */         for (int ii = 0; ii < divided.length; ii++) {
/*  87 */           this.dataSourceList_.add(divided[ii].trim());
/*     */         }
/*     */       }
/*     */     
/*  91 */     } else if ("destinationService".equalsIgnoreCase(argKey)) {
/*  92 */       this.destinationServiceName_ = argValue.toString();
/*     */     } else {
/*     */       
/*  95 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setDataSourceName(String argDataSourceName) {
/* 100 */     this.dataSourceName_ = argDataSourceName;
/*     */   }
/*     */   
/*     */   public void setDestinationServiceName(String argDestinationServiceName) {
/* 104 */     this.destinationServiceName_ = argDestinationServiceName;
/*     */   }
/*     */   
/*     */   public void setDirectory(String argDirectory) {
/* 108 */     this.directory_ = argDirectory;
/*     */   }
/*     */   
/*     */   public void setHostIp(String argHostIp) {
/* 112 */     this.hostIp_ = argHostIp;
/*     */   }
/*     */   
/*     */   public void setHostPort(int argHostPort) {
/* 116 */     this.hostPort_ = argHostPort;
/*     */   }
/*     */   
/*     */   public void setTimeout(int argTimeout) {
/* 120 */     this.timeout_ = argTimeout;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/* 124 */     this.type_ = argType;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\config\ServiceDestinationConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */