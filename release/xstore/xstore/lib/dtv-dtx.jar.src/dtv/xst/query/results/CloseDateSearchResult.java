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
/*    */ public class CloseDateSearchResult
/*    */   extends AbstractQueryResult
/*    */ {
/*    */   private static final long serialVersionUID = 8675309L;
/*    */   private Date closeDate_;
/*    */   private Long retailLocationId_;
/*    */   private Long organizationId_;
/*    */   
/*    */   public Date getCloseDate() {
/* 31 */     return this.closeDate_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Long getOrganizationId() {
/* 40 */     return this.organizationId_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Long getRetailLocationId() {
/* 49 */     return this.retailLocationId_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setCloseDate(Date closeDate) {
/* 58 */     this.closeDate_ = closeDate;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setOrganizationId(Long orgId) {
/* 67 */     this.organizationId_ = orgId;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRetailLocationId(Long retailLocId) {
/* 76 */     this.retailLocationId_ = retailLocId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IObjectId getObjectIdImpl() {
/* 82 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\CloseDateSearchResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */