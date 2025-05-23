/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryReplenishmentDocumentLineItem extends IDataModel, IHasDataProperty<IInventoryReplenishmentDocumentLineItemProperty> {
/*  9 */   public static final EventEnum SET_DOCUMENTID = new EventEnum("set documentId");
/* 10 */   public static final EventEnum SET_DOCUMENTTYPECODE = new EventEnum("set documentTypeCode");
/* 11 */   public static final EventEnum SET_INVENTORYDOCUMENTLINENUMBER = new EventEnum("set inventoryDocumentLineNumber");
/* 12 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 13 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 14 */   public static final EventEnum SET_SUGGESTEDORDERQUANTITY = new EventEnum("set suggestedOrderQuantity");
/* 15 */   public static final EventEnum SET_ORDERQUANTITY = new EventEnum("set orderQuantity");
/* 16 */   public static final EventEnum SET_CONFIRMEDQUANTITY = new EventEnum("set confirmedQuantity");
/* 17 */   public static final EventEnum SET_CONFIRMATIONDATE = new EventEnum("set confirmationDate");
/* 18 */   public static final EventEnum SET_CONFIRMATIONNUMBER = new EventEnum("set confirmationNumber");
/* 19 */   public static final EventEnum SET_SHIPVIA = new EventEnum("set shipVia");
/* 20 */   public static final EventEnum SET_SHIPPEDQUANTITY = new EventEnum("set shippedQuantity");
/* 21 */   public static final EventEnum SET_SHIPPEDDATE = new EventEnum("set shippedDate");
/* 22 */   public static final EventEnum SET_RECEIVEDQUANTITY = new EventEnum("set receivedQuantity");
/* 23 */   public static final EventEnum SET_RECEIVEDDATE = new EventEnum("set receivedDate");
/* 24 */   public static final EventEnum SET_SOURCETYPE = new EventEnum("set sourceType");
/* 25 */   public static final EventEnum SET_SOURCEID = new EventEnum("set sourceId");
/* 26 */   public static final EventEnum SET_SOURCENAME = new EventEnum("set sourceName");
/* 27 */   public static final EventEnum SET_PARENTDOCUMENTID = new EventEnum("set parentDocumentId");
/* 28 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 29 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 30 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 31 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 32 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 33 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 34 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 35 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 36 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 37 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getDocumentId();
/*    */   
/*    */   void setDocumentId(String paramString);
/*    */   
/*    */   String getDocumentTypeCode();
/*    */   
/*    */   void setDocumentTypeCode(String paramString);
/*    */   
/*    */   int getInventoryDocumentLineNumber();
/*    */   
/*    */   void setInventoryDocumentLineNumber(int paramInt);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   BigDecimal getSuggestedOrderQuantity();
/*    */   
/*    */   void setSuggestedOrderQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getOrderQuantity();
/*    */   
/*    */   void setOrderQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getConfirmedQuantity();
/*    */   
/*    */   void setConfirmedQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   Date getConfirmationDate();
/*    */   
/*    */   void setConfirmationDate(Date paramDate);
/*    */   
/*    */   String getConfirmationNumber();
/*    */   
/*    */   void setConfirmationNumber(String paramString);
/*    */   
/*    */   String getShipVia();
/*    */   
/*    */   void setShipVia(String paramString);
/*    */   
/*    */   BigDecimal getShippedQuantity();
/*    */   
/*    */   void setShippedQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   Date getShippedDate();
/*    */   
/*    */   void setShippedDate(Date paramDate);
/*    */   
/*    */   BigDecimal getReceivedQuantity();
/*    */   
/*    */   void setReceivedQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   Date getReceivedDate();
/*    */   
/*    */   void setReceivedDate(Date paramDate);
/*    */   
/*    */   String getSourceType();
/*    */   
/*    */   void setSourceType(String paramString);
/*    */   
/*    */   String getSourceId();
/*    */   
/*    */   void setSourceId(String paramString);
/*    */   
/*    */   String getSourceName();
/*    */   
/*    */   void setSourceName(String paramString);
/*    */   
/*    */   String getParentDocumentId();
/*    */   
/*    */   void setParentDocumentId(String paramString);
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
/*    */   IDataModel getInventoryReplenishmentDocumentLineItemExt();
/*    */   
/*    */   void setInventoryReplenishmentDocumentLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInventoryReplenishmentDocumentLineItemProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryReplenishmentDocumentLineItemProperty> paramList);
/*    */   
/*    */   void addInventoryReplenishmentDocumentLineItemProperty(IInventoryReplenishmentDocumentLineItemProperty paramIInventoryReplenishmentDocumentLineItemProperty);
/*    */   
/*    */   void removeInventoryReplenishmentDocumentLineItemProperty(IInventoryReplenishmentDocumentLineItemProperty paramIInventoryReplenishmentDocumentLineItemProperty);
/*    */   
/*    */   void setParentLine(IInventoryDocumentLineItem paramIInventoryDocumentLineItem);
/*    */   
/*    */   IInventoryDocumentLineItem getParentLine();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryReplenishmentDocumentLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */