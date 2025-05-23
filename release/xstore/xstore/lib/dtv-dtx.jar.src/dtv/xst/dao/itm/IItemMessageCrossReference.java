/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IItemMessageCrossReference extends IDataModel, IHasDataProperty<IItemMessageCrossReferenceProperty> {
/*  9 */   public static final EventEnum SET_MESSAGEID = new EventEnum("set messageId");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 12 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 13 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 19 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 20 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 21 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 22 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 23 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getMessageId();
/*    */   
/*    */   void setMessageId(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
/*    */   
/*    */   String getOrgCode();
/*    */   
/*    */   void setOrgCode(String paramString);
/*    */   
/*    */   String getOrgValue();
/*    */   
/*    */   void setOrgValue(String paramString);
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
/*    */   IDataModel getItemMessageCrossReferenceExt();
/*    */   
/*    */   void setItemMessageCrossReferenceExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IItemMessageCrossReferenceProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IItemMessageCrossReferenceProperty> paramList);
/*    */   
/*    */   void addItemMessageCrossReferenceProperty(IItemMessageCrossReferenceProperty paramIItemMessageCrossReferenceProperty);
/*    */   
/*    */   void removeItemMessageCrossReferenceProperty(IItemMessageCrossReferenceProperty paramIItemMessageCrossReferenceProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IItemMessageCrossReference.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */