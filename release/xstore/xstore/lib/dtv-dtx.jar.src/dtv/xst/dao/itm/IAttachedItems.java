/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.trl.ILineItemAssociationTypeCode;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface IAttachedItems extends IDataModel, IAttachedItemsModel, IHasDataProperty<IAttachedItemsProperty> {
/*  9 */   public static final EventEnum SET_ATTACHEDITEMID = new EventEnum("set attachedItemId");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_SOLDITEMID = new EventEnum("set soldItemId");
/* 12 */   public static final EventEnum SET_LEVELCODE = new EventEnum("set levelCode");
/* 13 */   public static final EventEnum SET_LEVELVALUE = new EventEnum("set levelValue");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_BEGINDATETIME = new EventEnum("set beginDatetime");
/* 19 */   public static final EventEnum SET_ENDDATETIME = new EventEnum("set endDatetime");
/* 20 */   public static final EventEnum SET_PROMPTTOADD = new EventEnum("set promptToAdd");
/* 21 */   public static final EventEnum SET_PROMPTTOADDMSGKEY = new EventEnum("set promptToAddMsgKey");
/* 22 */   public static final EventEnum SET_QUANTITYTOADD = new EventEnum("set quantityToAdd");
/* 23 */   public static final EventEnum SET_LINEITEMASSOCIATIONTYPECODE = new EventEnum("set lineItemAssociationTypeCode");
/* 24 */   public static final EventEnum SET_PROMPTFORRETURN = new EventEnum("set promptForReturn");
/* 25 */   public static final EventEnum SET_PROMPTFORRETURNMSGKEY = new EventEnum("set promptForReturnMsgKey");
/* 26 */   public static final EventEnum SET_EXTERNALID = new EventEnum("set externalId");
/* 27 */   public static final EventEnum SET_EXTERNALSYSTEM = new EventEnum("set externalSystem");
/* 28 */   public static final EventEnum SET_ATTACHEDITEM = new EventEnum("set AttachedItem");
/* 29 */   public static final EventEnum SET_SOLDITEM = new EventEnum("set SoldItem");
/* 30 */   public static final EventEnum SET_ASSOCIATIONTYPE = new EventEnum("set AssociationType");
/* 31 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 32 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 33 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 34 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 35 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 36 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getAttachedItemId();
/*    */   
/*    */   void setAttachedItemId(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getSoldItemId();
/*    */   
/*    */   void setSoldItemId(String paramString);
/*    */   
/*    */   String getLevelCode();
/*    */   
/*    */   void setLevelCode(String paramString);
/*    */   
/*    */   String getLevelValue();
/*    */   
/*    */   void setLevelValue(String paramString);
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
/*    */   Date getBeginDatetime();
/*    */   
/*    */   void setBeginDatetime(Date paramDate);
/*    */   
/*    */   Date getEndDatetime();
/*    */   
/*    */   void setEndDatetime(Date paramDate);
/*    */   
/*    */   boolean getPromptToAdd();
/*    */   
/*    */   void setPromptToAdd(boolean paramBoolean);
/*    */   
/*    */   String getPromptToAddMsgKey();
/*    */   
/*    */   void setPromptToAddMsgKey(String paramString);
/*    */   
/*    */   BigDecimal getQuantityToAdd();
/*    */   
/*    */   void setQuantityToAdd(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getLineItemAssociationTypeCode();
/*    */   
/*    */   void setLineItemAssociationTypeCode(String paramString);
/*    */   
/*    */   boolean getPromptForReturn();
/*    */   
/*    */   void setPromptForReturn(boolean paramBoolean);
/*    */   
/*    */   String getPromptForReturnMsgKey();
/*    */   
/*    */   void setPromptForReturnMsgKey(String paramString);
/*    */   
/*    */   String getExternalId();
/*    */   
/*    */   void setExternalId(String paramString);
/*    */   
/*    */   String getExternalSystem();
/*    */   
/*    */   void setExternalSystem(String paramString);
/*    */   
/*    */   IDataModel getAttachedItemsExt();
/*    */   
/*    */   void setAttachedItemsExt(IDataModel paramIDataModel);
/*    */   
/*    */   IItem getAttachedItem();
/*    */   
/*    */   void setAttachedItem(IItem paramIItem);
/*    */   
/*    */   IItem getSoldItem();
/*    */   
/*    */   void setSoldItem(IItem paramIItem);
/*    */   
/*    */   ILineItemAssociationTypeCode getAssociationType();
/*    */   
/*    */   void setAssociationType(ILineItemAssociationTypeCode paramILineItemAssociationTypeCode);
/*    */   
/*    */   List<IAttachedItemsProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IAttachedItemsProperty> paramList);
/*    */   
/*    */   void addAttachedItemsProperty(IAttachedItemsProperty paramIAttachedItemsProperty);
/*    */   
/*    */   void removeAttachedItemsProperty(IAttachedItemsProperty paramIAttachedItemsProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IAttachedItems.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */