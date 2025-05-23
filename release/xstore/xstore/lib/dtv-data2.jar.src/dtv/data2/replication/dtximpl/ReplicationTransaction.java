/*     */ package dtv.data2.replication.dtximpl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.replication.ReplicationException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
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
/*     */ public class ReplicationTransaction
/*     */ {
/*     */   private String serviceName_;
/*     */   private String transactionId_;
/*  26 */   private long organizationId_ = 0L;
/*  27 */   private int retailLocationId_ = 0;
/*  28 */   private long workstationId_ = 0L;
/*     */   
/*  30 */   private long createdTime_ = 0L;
/*  31 */   private long expiresAfter_ = 0L;
/*  32 */   private List<String> dataXmlStrings_ = new ArrayList<>();
/*     */   private boolean expireImmediately_ = false;
/*     */   private boolean neverExpires_ = false;
/*     */   private boolean newTransaction_ = true;
/*  36 */   private int failedOfflineAttempts_ = 0;
/*  37 */   private int failedErrorAttempts_ = 0;
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
/*     */   public void addDataAsXmlString(String argXmlString) {
/*  99 */     this.dataXmlStrings_.add(argXmlString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCreatedTime() {
/* 109 */     return this.createdTime_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getExpiresAfter() {
/* 118 */     if (this.expireImmediately_) {
/* 119 */       throw new ReplicationException("Invalid call to getExpiresAfter().  expireImmediately_ is true,  so getExpiresAfter() is undefined.");
/*     */     }
/*     */ 
/*     */     
/* 123 */     if (this.neverExpires_) {
/* 124 */       throw new ReplicationException("Invalid call to getExpiresAfter().  neverExpires_ is true,  so getExpiresAfter() is undefined.");
/*     */     }
/*     */ 
/*     */     
/* 128 */     return this.expiresAfter_;
/*     */   }
/*     */   
/*     */   public boolean getExpiresImmediately() {
/* 132 */     return this.expireImmediately_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFailedErrorAttempts() {
/* 139 */     return this.failedErrorAttempts_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFailedOfflineAttempts() {
/* 146 */     return this.failedOfflineAttempts_;
/*     */   }
/*     */   
/*     */   public boolean getNeverExpires() {
/* 150 */     return this.neverExpires_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getNewTransaction() {
/* 159 */     return this.newTransaction_;
/*     */   }
/*     */   
/*     */   public long getOrganizationId() {
/* 163 */     return this.organizationId_;
/*     */   }
/*     */   
/*     */   public List<IPersistable> getPersistables() {
/* 167 */     String dataXmlString = getPersistablesAsXml();
/* 168 */     String docType = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE ConfigData [ <!ENTITY tilde \"&#126;\"> ]>";
/*     */ 
/*     */     
/* 171 */     StringBuilder buff = new StringBuilder(docType.length() + dataXmlString.length() + 15);
/* 172 */     buff.append(docType);
/* 173 */     buff.append("<data>");
/* 174 */     buff.append(dataXmlString);
/* 175 */     buff.append("</data>");
/*     */     try {
/* 177 */       return DaoUtils.getPersistablesForXml(buff.toString());
/*     */     }
/* 179 */     catch (Exception ee) {
/* 180 */       throw new ReplicationException("An error occurred while parsing XML: " + dataXmlString, ee);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getPersistablesAsXml() {
/* 185 */     StringBuilder builder = new StringBuilder();
/* 186 */     for (String xmlString : this.dataXmlStrings_) {
/* 187 */       builder.append(xmlString);
/*     */     }
/* 189 */     return builder.toString();
/*     */   }
/*     */   
/*     */   public int getRetailLocationId() {
/* 193 */     return this.retailLocationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getServiceName() {
/* 202 */     return this.serviceName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTransactionId() {
/* 213 */     return this.transactionId_;
/*     */   }
/*     */   
/*     */   public long getWorkstationId() {
/* 217 */     return this.workstationId_;
/*     */   }
/*     */   
/*     */   public void incrementErrorFailures() {
/* 221 */     this.failedErrorAttempts_++;
/*     */   }
/*     */   
/*     */   public void incrementOfflineFailures() {
/* 225 */     this.failedOfflineAttempts_++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isExpired() {
/* 235 */     if (this.neverExpires_) {
/* 236 */       return false;
/*     */     }
/*     */     
/* 239 */     if (this.expireImmediately_) {
/* 240 */       return true;
/*     */     }
/*     */     
/* 243 */     long now = System.currentTimeMillis();
/*     */     
/* 245 */     if (this.createdTime_ + this.expiresAfter_ < now) {
/* 246 */       return true;
/*     */     }
/*     */     
/* 249 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreatedTime(long argDateTimeCreated) {
/* 260 */     this.createdTime_ = argDateTimeCreated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpiresAfter(long argExpiresAfter) {
/* 269 */     this.expiresAfter_ = argExpiresAfter;
/*     */   }
/*     */   
/*     */   public void setExpiresImmediately(boolean argExpiresImmediately) {
/* 273 */     this.expireImmediately_ = argExpiresImmediately;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFailedErrorAttempts(int argFailedErrorAttempts) {
/* 280 */     this.failedErrorAttempts_ = argFailedErrorAttempts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFailedOfflineAttempts(int argFailedOfflineAttempts) {
/* 287 */     this.failedOfflineAttempts_ = argFailedOfflineAttempts;
/*     */   }
/*     */   
/*     */   public void setNeverExpires(boolean argNeverExpires) {
/* 291 */     if (argNeverExpires && this.expireImmediately_) {
/* 292 */       throw new ReplicationException("A replication transaction cannot never expire and immediately expireat the same time. " + this);
/*     */     }
/*     */     
/* 295 */     this.neverExpires_ = argNeverExpires;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNewTransaction(boolean argNewTransaction) {
/* 304 */     this.newTransaction_ = argNewTransaction;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 308 */     this.organizationId_ = argOrganizationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(int argRetailLocationId) {
/* 312 */     this.retailLocationId_ = argRetailLocationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setServiceName(String argServiceName) {
/* 321 */     this.serviceName_ = argServiceName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionId(String argTransactionId) {
/* 332 */     this.transactionId_ = argTransactionId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 336 */     this.workstationId_ = argWorkstationId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 342 */     StringBuilder buf = new StringBuilder(512);
/*     */     
/* 344 */     buf.append(super.toString());
/* 345 */     buf.append(":");
/* 346 */     buf.append(this.organizationId_);
/* 347 */     buf.append(":");
/* 348 */     buf.append(this.serviceName_);
/* 349 */     buf.append(":");
/* 350 */     buf.append(new Date(this.createdTime_));
/* 351 */     buf.append(":");
/* 352 */     buf.append(getPersistablesAsXml());
/* 353 */     return buf.toString();
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\ReplicationTransaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */