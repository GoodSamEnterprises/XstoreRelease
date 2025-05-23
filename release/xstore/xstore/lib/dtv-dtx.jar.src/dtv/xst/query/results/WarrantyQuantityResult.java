/*    */ package dtv.xst.query.results;
/*    */ 
/*    */ import dtv.data2.access.AbstractQueryResult;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import java.math.BigDecimal;
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
/*    */ public class WarrantyQuantityResult
/*    */   extends AbstractQueryResult
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private BigDecimal warrantyQuantity_;
/*    */   private String warrantyPlanId_;
/*    */   
/*    */   public String getWarrantyPlanId() {
/* 31 */     return this.warrantyPlanId_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BigDecimal getWarrantyQuantity() {
/* 40 */     return this.warrantyQuantity_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setWarrantyPlanId(String argPlanId) {
/* 49 */     this.warrantyPlanId_ = argPlanId;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setWarrantyQuantity(BigDecimal argValue) {
/* 58 */     this.warrantyQuantity_ = argValue;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IObjectId getObjectIdImpl() {
/* 64 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\WarrantyQuantityResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */