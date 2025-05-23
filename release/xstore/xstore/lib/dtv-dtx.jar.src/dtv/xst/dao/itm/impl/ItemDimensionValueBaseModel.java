/*    */ package dtv.xst.dao.itm.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.util.StringUtils;
/*    */ import dtv.xst.dao.itm.IDimensionSummary;
/*    */ import dtv.xst.dao.itm.IItemDimensionValue;
/*    */ import dtv.xst.dao.itm.IItemDimensionValueProperty;
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
/*    */ public abstract class ItemDimensionValueBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IItemDimensionValueProperty>
/*    */   implements IItemDimensionValue, IDimensionSummary
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public String getDescription() {
/* 27 */     String description = getDAO_().getDescription();
/*    */     
/* 29 */     if (StringUtils.isEmpty(description)) {
/* 30 */       description = getDimensionValue();
/*    */     }
/*    */     
/* 33 */     return description;
/*    */   }
/*    */   
/*    */   private ItemDimensionValueDAO getDAO_() {
/* 37 */     return (ItemDimensionValueDAO)this._daoImpl;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemDimensionValueBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */