/*    */ package dtv.xst.pricing;
/*    */ 
/*    */ import dtv.pricing2.AbstractPricingItemAdapter;
/*    */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
/*    */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*    */ import dtv.xst.dao.trl.RetailPriceModifierReasonCode;
/*    */ import dtv.xst.dao.trl.SaleItemType;
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
/*    */ public class XSTPricingItemAdapter
/*    */   extends AbstractPricingItemAdapter<IRetailTransactionLineItem>
/*    */ {
/*    */   public boolean isPriceable(IRetailTransactionLineItem argItem) {
/* 25 */     if (argItem == null) {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     if (argItem.getVoid() || argItem.getVoidLineItemReasonCode() != null) {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     if (argItem instanceof ISaleReturnLineItem) {
/* 34 */       ISaleReturnLineItem item = (ISaleReturnLineItem)argItem;
/* 35 */       if (item.getReturn()) {
/* 36 */         return false;
/*    */       }
/*    */ 
/*    */       
/* 40 */       if (!item.getRetailPriceModifierByTypeCode(RetailPriceModifierReasonCode.NEW_PRICE_RULE.getName()).isEmpty()) {
/* 41 */         return false;
/*    */       }
/* 43 */       if (SaleItemType.RETURN.matches(item.getSaleReturnLineItemTypeCode())) {
/* 44 */         return false;
/*    */       }
/*    */       
/* 47 */       return true;
/*    */     } 
/* 49 */     if (argItem instanceof dtv.xst.dao.doc.IDocumentLineItem) {
/* 50 */       return true;
/*    */     }
/*    */     
/* 53 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\pricing\XSTPricingItemAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */