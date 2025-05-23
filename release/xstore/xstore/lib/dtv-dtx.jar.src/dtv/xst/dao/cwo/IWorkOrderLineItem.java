/*    */ package dtv.xst.dao.cwo;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface IWorkOrderLineItem extends IDataModel, IWorkOrderLineItemModel, ISaleReturnLineItem {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_PRICESTATUS = new EventEnum("set priceStatus");
/* 14 */   public static final EventEnum SET_INSTRUCTIONS = new EventEnum("set instructions");
/* 15 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 16 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 17 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   Date getCreateDate();
/*    */   
/*    */   void setCreateDate(Date paramDate);
/*    */   
/*    */   String getCreateUserId();
/*    */   
/*    */   void setCreateUserId(String paramString);
/*    */   
/*    */   Date getUpdateDate();
/*    */   
/*    */   void setUpdateDate(Date paramDate);
/*    */   
/*    */   String getUpdateUserId();
/*    */   
/*    */   void setUpdateUserId(String paramString);
/*    */   
/*    */   String getPriceStatus();
/*    */   
/*    */   void setPriceStatus(String paramString);
/*    */   
/*    */   String getInstructions();
/*    */   
/*    */   void setInstructions(String paramString);
/*    */   
/*    */   IDataModel getWorkOrderLineItemExt();
/*    */   
/*    */   void setWorkOrderLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\IWorkOrderLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */