/*    */ package dtv.xst.dao.com;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IReasonCode extends IDataModel, IHasDataProperty<IReasonCodeProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_REASONTYPECODE = new EventEnum("set reasonTypeCode");
/* 11 */   public static final EventEnum SET_REASONCODE = new EventEnum("set reasonCode");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_CONFIGELEMENT = new EventEnum("set configElement");
/* 17 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 18 */   public static final EventEnum SET_COMMENTREQUIRED = new EventEnum("set commentRequired");
/* 19 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 20 */   public static final EventEnum SET_PARENTCODE = new EventEnum("set parentCode");
/* 21 */   public static final EventEnum SET_GLACCOUNTNUMBER = new EventEnum("set glAccountNumber");
/* 22 */   public static final EventEnum SET_MINIMUMAMT = new EventEnum("set minimumAmt");
/* 23 */   public static final EventEnum SET_MAXIMUMAMT = new EventEnum("set maximumAmt");
/* 24 */   public static final EventEnum SET_CUSTOMERMESSAGE = new EventEnum("set customerMessage");
/* 25 */   public static final EventEnum SET_INVENTORYACTIONCODE = new EventEnum("set inventoryActionCode");
/* 26 */   public static final EventEnum SET_INVENTORYLOCATIONID = new EventEnum("set inventoryLocationId");
/* 27 */   public static final EventEnum SET_INVENTORYBUCKETID = new EventEnum("set inventoryBucketId");
/* 28 */   public static final EventEnum SET_HIDDEN = new EventEnum("set hidden");
/* 29 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 30 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 31 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 32 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 33 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 34 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getReasonTypeCode();
/*    */   
/*    */   void setReasonTypeCode(String paramString);
/*    */   
/*    */   String getReasonCode();
/*    */   
/*    */   void setReasonCode(String paramString);
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
/*    */   String getConfigElement();
/*    */   
/*    */   void setConfigElement(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   String getCommentRequired();
/*    */   
/*    */   void setCommentRequired(String paramString);
/*    */   
/*    */   int getSortOrder();
/*    */   
/*    */   void setSortOrder(int paramInt);
/*    */   
/*    */   String getParentCode();
/*    */   
/*    */   void setParentCode(String paramString);
/*    */   
/*    */   String getGlAccountNumber();
/*    */   
/*    */   void setGlAccountNumber(String paramString);
/*    */   
/*    */   BigDecimal getMinimumAmt();
/*    */   
/*    */   void setMinimumAmt(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getMaximumAmt();
/*    */   
/*    */   void setMaximumAmt(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getCustomerMessage();
/*    */   
/*    */   void setCustomerMessage(String paramString);
/*    */   
/*    */   String getInventoryActionCode();
/*    */   
/*    */   void setInventoryActionCode(String paramString);
/*    */   
/*    */   String getInventoryLocationId();
/*    */   
/*    */   void setInventoryLocationId(String paramString);
/*    */   
/*    */   String getInventoryBucketId();
/*    */   
/*    */   void setInventoryBucketId(String paramString);
/*    */   
/*    */   boolean getHidden();
/*    */   
/*    */   void setHidden(boolean paramBoolean);
/*    */   
/*    */   IDataModel getReasonCodeExt();
/*    */   
/*    */   void setReasonCodeExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IReasonCodeProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IReasonCodeProperty> paramList);
/*    */   
/*    */   void addReasonCodeProperty(IReasonCodeProperty paramIReasonCodeProperty);
/*    */   
/*    */   void removeReasonCodeProperty(IReasonCodeProperty paramIReasonCodeProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\IReasonCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */