/*    */ package dtv.xst.dao.cwo.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.cwo.IWorkItem;
/*    */ import dtv.xst.dao.cwo.IWorkItemModel;
/*    */ import dtv.xst.dao.cwo.IWorkItemProperty;
/*    */ import dtv.xst.dao.itm.ItemId;
/*    */ import dtv.xst.dao.loc.RetailLocationId;
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
/*    */ public abstract class WorkItemBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IWorkItemProperty>
/*    */   implements IWorkItem, IWorkItemModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public ItemId getItemIdObject() {
/* 28 */     ItemId id = new ItemId();
/* 29 */     id.setItemId(getItemId());
/* 30 */     return id;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RetailLocationId getRetailLocationIdObject() {
/* 42 */     RetailLocationId id = new RetailLocationId();
/* 43 */     id.setRetailLocationId(Long.valueOf(getWorkOrderAccount().getRetailLocationId()));
/* 44 */     return id;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\WorkItemBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */