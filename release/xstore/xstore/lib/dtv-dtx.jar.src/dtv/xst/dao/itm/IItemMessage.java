/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IItemMessage extends IDataModel, IItemMessageModel, IHasDataProperty<IItemMessageProperty> {
/*  9 */   public static final EventEnum SET_MESSAGEID = new EventEnum("set messageId");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 12 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 13 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_CONTENTTYPE = new EventEnum("set contentType");
/* 19 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 20 */   public static final EventEnum SET_MESSAGEKEY = new EventEnum("set messageKey");
/* 21 */   public static final EventEnum SET_TITLEKEY = new EventEnum("set titleKey");
/* 22 */   public static final EventEnum ADD_LINEITEMTYPES = new EventEnum("add LineItemTypes");
/* 23 */   public static final EventEnum REMOVE_LINEITEMTYPES = new EventEnum("remove LineItemTypes");
/* 24 */   public static final EventEnum SET_LINEITEMTYPES = new EventEnum("set LineItemTypes");
/* 25 */   public static final EventEnum ADD_ITEMIDS = new EventEnum("add ItemIds");
/* 26 */   public static final EventEnum REMOVE_ITEMIDS = new EventEnum("remove ItemIds");
/* 27 */   public static final EventEnum SET_ITEMIDS = new EventEnum("set ItemIds");
/* 28 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 29 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 30 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 31 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 32 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 33 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
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
/*    */   String getContentType();
/*    */   
/*    */   void setContentType(String paramString);
/*    */   
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   String getMessageKey();
/*    */   
/*    */   void setMessageKey(String paramString);
/*    */   
/*    */   String getTitleKey();
/*    */   
/*    */   void setTitleKey(String paramString);
/*    */   
/*    */   IDataModel getItemMessageExt();
/*    */   
/*    */   void setItemMessageExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IItemMessageTypes> getLineItemTypes();
/*    */   
/*    */   void setLineItemTypes(List<IItemMessageTypes> paramList);
/*    */   
/*    */   void addItemMessageTypes(IItemMessageTypes paramIItemMessageTypes);
/*    */   
/*    */   void removeItemMessageTypes(IItemMessageTypes paramIItemMessageTypes);
/*    */   
/*    */   List<IItemMessageCrossReference> getItemIds();
/*    */   
/*    */   void setItemIds(List<IItemMessageCrossReference> paramList);
/*    */   
/*    */   void addItemMessageCrossReference(IItemMessageCrossReference paramIItemMessageCrossReference);
/*    */   
/*    */   void removeItemMessageCrossReference(IItemMessageCrossReference paramIItemMessageCrossReference);
/*    */   
/*    */   List<IItemMessageProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IItemMessageProperty> paramList);
/*    */   
/*    */   void addItemMessageProperty(IItemMessageProperty paramIItemMessageProperty);
/*    */   
/*    */   void removeItemMessageProperty(IItemMessageProperty paramIItemMessageProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IItemMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */