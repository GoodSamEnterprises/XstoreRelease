/*    */ package dtv.xst.dao.cwo.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.cwo.IInvoice;
/*    */ import dtv.xst.dao.cwo.IInvoiceLineItem;
/*    */ import dtv.xst.dao.cwo.IInvoiceProperty;
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
/*    */ public abstract class InvoiceBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IInvoiceProperty>
/*    */   implements IInvoice
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void addInvoiceLineItem(IInvoiceLineItem argInvoiceLineItem) {
/* 27 */     synchronized (this) {
/* 28 */       argInvoiceLineItem.setInvoiceLineItemSequence(getLineItems().size() + 1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\InvoiceBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */