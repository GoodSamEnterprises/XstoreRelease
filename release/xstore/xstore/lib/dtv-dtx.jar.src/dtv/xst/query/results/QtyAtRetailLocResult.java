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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QtyAtRetailLocResult
/*    */   extends AbstractQueryResult
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private long retailLocationId_;
/*    */   private BigDecimal quantity_;
/*    */   
/*    */   public BigDecimal getQuantity() {
/* 39 */     return this.quantity_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long getRetailLocationId() {
/* 48 */     return this.retailLocationId_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setQuantity(BigDecimal argQuantity) {
/* 57 */     this.quantity_ = argQuantity;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRetailLocationId(long argRetailLocationId) {
/* 66 */     this.retailLocationId_ = argRetailLocationId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IObjectId getObjectIdImpl() {
/* 72 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\QtyAtRetailLocResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */