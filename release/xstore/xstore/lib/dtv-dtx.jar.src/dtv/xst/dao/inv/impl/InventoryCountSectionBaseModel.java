/*    */ package dtv.xst.dao.inv.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.inv.IInventoryCountSection;
/*    */ import dtv.xst.dao.inv.IInventoryCountSectionDetail;
/*    */ import dtv.xst.dao.inv.IInventoryCountSectionProperty;
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
/*    */ public abstract class InventoryCountSectionBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IInventoryCountSectionProperty>
/*    */   implements IInventoryCountSection
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void addInventoryCountSectionDetail(IInventoryCountSectionDetail argDetail) {
/* 26 */     synchronized (this) {
/* 27 */       int position = 0;
/*    */       
/* 29 */       for (IInventoryCountSectionDetail detail : getSectionDetails()) {
/* 30 */         if (detail.getSectionDetailNumber() > position) {
/* 31 */           position = detail.getSectionDetailNumber();
/*    */         }
/*    */       } 
/*    */       
/* 35 */       argDetail.setSectionDetailNumber(position + 1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSectionBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */