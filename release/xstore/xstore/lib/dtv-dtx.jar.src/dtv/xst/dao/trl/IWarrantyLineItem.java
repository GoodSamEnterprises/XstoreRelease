/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IWarrantyLineItem extends IDataModel, ISaleReturnLineItem {
/*  8 */   public static final EventEnum ADD_WARRANTYMODIFIERS = new EventEnum("add WarrantyModifiers");
/*  9 */   public static final EventEnum REMOVE_WARRANTYMODIFIERS = new EventEnum("remove WarrantyModifiers");
/* 10 */   public static final EventEnum SET_WARRANTYMODIFIERS = new EventEnum("set WarrantyModifiers");
/* 11 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 12 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 13 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   IDataModel getWarrantyLineItemExt();
/*    */   
/*    */   void setWarrantyLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IWarrantyModifier> getWarrantyModifiers();
/*    */   
/*    */   void setWarrantyModifiers(List<IWarrantyModifier> paramList);
/*    */   
/*    */   void addWarrantyModifier(IWarrantyModifier paramIWarrantyModifier);
/*    */   
/*    */   void removeWarrantyModifier(IWarrantyModifier paramIWarrantyModifier);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IWarrantyLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */