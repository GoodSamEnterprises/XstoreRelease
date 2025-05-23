/*    */ package dtv.xst.query.results;
/*    */ 
/*    */ import dtv.data2.access.AbstractQueryResult;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import java.util.Date;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TimestampQueryResult
/*    */   extends AbstractQueryResult
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private Date updateDate_;
/*    */   private Date createDate_;
/*    */   
/*    */   public Date getCreateDate() {
/* 34 */     return this.createDate_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Date getLatestUpdateDate() {
/* 43 */     if (this.createDate_ != null && this.updateDate_ == null) {
/* 44 */       return this.createDate_;
/*    */     }
/* 46 */     if (this.createDate_ == null && this.updateDate_ != null) {
/* 47 */       return this.updateDate_;
/*    */     }
/* 49 */     if (this.createDate_ != null && this.updateDate_ != null) {
/* 50 */       return this.createDate_.before(this.updateDate_) ? this.updateDate_ : this.createDate_;
/*    */     }
/*    */     
/* 53 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Date getUpdateDate() {
/* 63 */     return this.updateDate_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setCreateDate(Date argDate) {
/* 72 */     this.createDate_ = argDate;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setDate(Date argDate) {
/* 81 */     this.updateDate_ = argDate;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IObjectId getObjectIdImpl() {
/* 87 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\TimestampQueryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */