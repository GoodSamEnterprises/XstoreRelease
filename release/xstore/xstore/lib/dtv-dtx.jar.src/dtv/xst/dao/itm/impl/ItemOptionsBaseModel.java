/*    */ package dtv.xst.dao.itm.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.util.StringUtils;
/*    */ import dtv.xst.dao.itm.IItemOptions;
/*    */ import dtv.xst.dao.itm.IItemOptionsModel;
/*    */ import dtv.xst.dao.itm.IItemOptionsProperty;
/*    */ import dtv.xst.dao.itm.ItemAvailabilityCode;
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
/*    */ public abstract class ItemOptionsBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IItemOptionsProperty>
/*    */   implements IItemOptions, IItemOptionsModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public String getManufacturer() {
/* 27 */     String itemId = getItemId();
/*    */     
/* 29 */     if (itemId != null) {
/* 30 */       switch (itemId.length()) {
/*    */         case 12:
/*    */         case 13:
/* 33 */           return StringUtils.slice(itemId, 0, 6);
/*    */       } 
/*    */     
/*    */     }
/* 37 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isItemNotAvailable() {
/* 43 */     String code = getItemAvailabilityCode();
/*    */     
/* 45 */     if (code == null || code.equals(ItemAvailabilityCode.AVAILABLE.getName())) {
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected IItemOptions getParentOptions() {
/* 58 */     return (getItem().getParentItem() == null) ? null : getItem().getParentItem().getOptions();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemOptionsBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */