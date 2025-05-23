/*    */ package dtv.data2.dataloader.pluggable;
/*    */ 
/*    */ import dtv.util.DateUtils;
/*    */ import java.util.Date;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DeploymentInfo
/*    */ {
/* 20 */   private static final Logger logger_ = Logger.getLogger(DeploymentInfo.class);
/*    */   
/*    */   private String _downloadId;
/*    */   private Date _applicationDate;
/*    */   private String _targetOrgNode;
/*    */   private String _deploymentName;
/*    */   private String _downloadTime;
/*    */   private Boolean _applyImmediately;
/*    */   
/*    */   public Date getApplicationDate() {
/* 30 */     return this._applicationDate;
/*    */   }
/*    */   
/*    */   public Boolean getApplyImmediately() {
/* 34 */     return this._applyImmediately;
/*    */   }
/*    */   
/*    */   public String getDeploymentName() {
/* 38 */     return this._deploymentName;
/*    */   }
/*    */   
/*    */   public String getDownloadId() {
/* 42 */     return this._downloadId;
/*    */   }
/*    */   
/*    */   public String getDownloadTime() {
/* 46 */     return this._downloadTime;
/*    */   }
/*    */   
/*    */   public String getTargetOrgNode() {
/* 50 */     return this._targetOrgNode;
/*    */   }
/*    */   
/*    */   public boolean isFutureApplicationDate() {
/* 54 */     if (this._applicationDate == null) {
/* 55 */       logger_.debug("isFutureApplicationDate: application date is not set, returning false.");
/* 56 */       return false;
/*    */     } 
/*    */     
/* 59 */     Date now = new Date();
/* 60 */     return this._applicationDate.after(now);
/*    */   }
/*    */   
/*    */   public void setApplicationDate(Date argApplicationDate) {
/* 64 */     this._applicationDate = argApplicationDate;
/*    */   }
/*    */   
/*    */   public void setApplyImmediately(Boolean argApplyImmediately) {
/* 68 */     this._applyImmediately = argApplyImmediately;
/*    */   }
/*    */   
/*    */   public void setDeploymentName(String argDeploymentName) {
/* 72 */     this._deploymentName = argDeploymentName;
/*    */   }
/*    */   
/*    */   public void setDownloadId(String argDownloadId) {
/* 76 */     this._downloadId = argDownloadId;
/*    */   }
/*    */   
/*    */   public void setDownloadTime(String argDownloadPriority) {
/* 80 */     this._downloadTime = argDownloadPriority;
/*    */   }
/*    */   
/*    */   public void setTargetOrgNode(String argTarget) {
/* 84 */     this._targetOrgNode = argTarget;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 89 */     String ss = "DeploymentInfo _downloadId=" + this._downloadId + " _applicationDate=";
/* 90 */     if (this._applicationDate != null) {
/* 91 */       ss = ss + DateUtils.format(this._applicationDate);
/*    */     } else {
/*    */       
/* 94 */       ss = ss + "null";
/*    */     } 
/* 96 */     if (this._deploymentName != null) {
/* 97 */       ss = ss + " _deploymentName=" + this._deploymentName;
/*    */     }
/* 99 */     return ss;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\pluggable\DeploymentInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */