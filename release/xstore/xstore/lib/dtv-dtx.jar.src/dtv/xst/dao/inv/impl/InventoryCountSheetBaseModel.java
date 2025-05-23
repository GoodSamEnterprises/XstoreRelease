/*    */ package dtv.xst.dao.inv.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.inv.IInventoryCountSheet;
/*    */ import dtv.xst.dao.inv.IInventoryCountSheetLineItem;
/*    */ import dtv.xst.dao.inv.IInventoryCountSheetProperty;
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
/*    */ public abstract class InventoryCountSheetBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IInventoryCountSheetProperty>
/*    */   implements IInventoryCountSheet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void addInventoryCountSheetLineItem(IInventoryCountSheetLineItem argLineItem) {
/* 27 */     synchronized (this) {
/* 28 */       argLineItem.setLineItemNumber(getCountSheetLineItems().size() + 1);
/*    */     } 
/*    */     
/* 31 */     argLineItem.setCountCycle(getCountCycle());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSheetBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */