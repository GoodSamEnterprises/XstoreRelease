/*    */ package dtv.xst.dao.itm.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.util.ISortable;
/*    */ import dtv.util.StringUtils;
/*    */ import dtv.xst.dao.itm.IItemDimensionType;
/*    */ import dtv.xst.dao.itm.IItemDimensionTypeProperty;
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
/*    */ public abstract class ItemDimensionTypeBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IItemDimensionTypeProperty>
/*    */   implements IItemDimensionType, ISortable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public String getDescription() {
/* 28 */     String description = getDAO_().getDescription();
/*    */     
/* 30 */     if (StringUtils.isEmpty(description)) {
/* 31 */       description = getDimension();
/*    */     }
/*    */     
/* 34 */     return description;
/*    */   }
/*    */   
/*    */   private ItemDimensionTypeDAO getDAO_() {
/* 38 */     return (ItemDimensionTypeDAO)this._daoImpl;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemDimensionTypeBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */