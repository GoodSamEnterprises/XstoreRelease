/*    */ package dtv.xst.dao.itm.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.itm.IAttachedItems;
/*    */ import dtv.xst.dao.itm.IAttachedItemsModel;
/*    */ import dtv.xst.dao.itm.IAttachedItemsProperty;
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
/*    */ public abstract class AttachedItemsBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IAttachedItemsProperty>
/*    */   implements IAttachedItems, IAttachedItemsModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private transient BigDecimal attachedItemPrice_;
/*    */   
/*    */   public BigDecimal getAttachedItemPrice() {
/* 30 */     return this.attachedItemPrice_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setAttachedItemPrice(BigDecimal argAmount) {
/* 36 */     this.attachedItemPrice_ = argAmount;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\AttachedItemsBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */