/*    */ package dtv.xst.dao.cat.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.cat.IChargeAccountInvoice;
/*    */ import dtv.xst.dao.cat.IChargeAccountInvoiceModel;
/*    */ import dtv.xst.dao.cat.IChargeAccountInvoiceProperty;
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
/*    */ public abstract class ChargeAccountInvoiceBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IChargeAccountInvoiceProperty>
/*    */   implements IChargeAccountInvoice, IChargeAccountInvoiceModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 25 */   private transient BigDecimal lastPaidAmt_ = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BigDecimal getLastPaidAmt() {
/* 33 */     return this.lastPaidAmt_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setLastPaidAmt(BigDecimal argLastPaidAmt) {
/* 42 */     this.lastPaidAmt_ = argLastPaidAmt;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\ChargeAccountInvoiceBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */