/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.com.IAddress;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryDocument extends IDataModel, IInventoryDocumentModel, IHasDataProperty<IInventoryDocumentProperty> {
/*  9 */   public static final EventEnum SET_DOCUMENTID = new EventEnum("set documentId");
/* 10 */   public static final EventEnum SET_DOCUMENTTYPECODE = new EventEnum("set documentTypeCode");
/* 11 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 12 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_COMPLETEDATETIME = new EventEnum("set completeDateTime");
/* 18 */   public static final EventEnum SET_CREATEDATETIME = new EventEnum("set createDateTime");
/* 19 */   public static final EventEnum SET_ORIGINATORID = new EventEnum("set originatorId");
/* 20 */   public static final EventEnum SET_STATUSCODE = new EventEnum("set statusCode");
/* 21 */   public static final EventEnum SET_DOCUMENTSUBTYPECODE = new EventEnum("set documentSubtypeCode");
/* 22 */   public static final EventEnum SET_ORIGINATORNAME = new EventEnum("set originatorName");
/* 23 */   public static final EventEnum SET_LASTACTIVITYDATE = new EventEnum("set lastActivityDate");
/* 24 */   public static final EventEnum SET_POREFERENCENUMBER = new EventEnum("set poReferenceNumber");
/* 25 */   public static final EventEnum SET_RECORDCREATIONTYPE = new EventEnum("set recordCreationType");
/* 26 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 27 */   public static final EventEnum SET_CONTROLNUMBER = new EventEnum("set controlNumber");
/* 28 */   public static final EventEnum SET_ORIGINATORADDRESSID = new EventEnum("set originatorAddressId");
/* 29 */   public static final EventEnum SET_SUBMITDATE = new EventEnum("set submitDate");
/* 30 */   public static final EventEnum ADD_INVENTORYDOCUMENTLINEITEMS = new EventEnum("add InventoryDocumentLineItems");
/* 31 */   public static final EventEnum REMOVE_INVENTORYDOCUMENTLINEITEMS = new EventEnum("remove InventoryDocumentLineItems");
/* 32 */   public static final EventEnum SET_INVENTORYDOCUMENTLINEITEMS = new EventEnum("set InventoryDocumentLineItems");
/* 33 */   public static final EventEnum ADD_SHIPMENTS = new EventEnum("add Shipments");
/* 34 */   public static final EventEnum REMOVE_SHIPMENTS = new EventEnum("remove Shipments");
/* 35 */   public static final EventEnum SET_SHIPMENTS = new EventEnum("set Shipments");
/* 36 */   public static final EventEnum ADD_CARTONS = new EventEnum("add Cartons");
/* 37 */   public static final EventEnum REMOVE_CARTONS = new EventEnum("remove Cartons");
/* 38 */   public static final EventEnum SET_CARTONS = new EventEnum("set Cartons");
/* 39 */   public static final EventEnum ADD_NOTES = new EventEnum("add Notes");
/* 40 */   public static final EventEnum REMOVE_NOTES = new EventEnum("remove Notes");
/* 41 */   public static final EventEnum SET_NOTES = new EventEnum("set Notes");
/* 42 */   public static final EventEnum SET_ORIGINATORADDRESS = new EventEnum("set OriginatorAddress");
/* 43 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 44 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 45 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 46 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 47 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 48 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
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
/*    */   Date getCompleteDateTime();
/*    */   
/*    */   void setCompleteDateTime(Date paramDate);
/*    */   
/*    */   Date getCreateDateTime();
/*    */   
/*    */   void setCreateDateTime(Date paramDate);
/*    */   
/*    */   String getOriginatorId();
/*    */   
/*    */   void setOriginatorId(String paramString);
/*    */   
/*    */   String getStatusCode();
/*    */   
/*    */   void setStatusCode(String paramString);
/*    */   
/*    */   String getDocumentSubtypeCode();
/*    */   
/*    */   void setDocumentSubtypeCode(String paramString);
/*    */   
/*    */   String getOriginatorName();
/*    */   
/*    */   void setOriginatorName(String paramString);
/*    */   
/*    */   Date getLastActivityDate();
/*    */   
/*    */   void setLastActivityDate(Date paramDate);
/*    */   
/*    */   String getPoReferenceNumber();
/*    */   
/*    */   void setPoReferenceNumber(String paramString);
/*    */   
/*    */   String getRecordCreationType();
/*    */   
/*    */   void setRecordCreationType(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   String getControlNumber();
/*    */   
/*    */   void setControlNumber(String paramString);
/*    */   
/*    */   String getOriginatorAddressId();
/*    */   
/*    */   void setOriginatorAddressId(String paramString);
/*    */   
/*    */   Date getSubmitDate();
/*    */   
/*    */   void setSubmitDate(Date paramDate);
/*    */   
/*    */   IDataModel getInventoryDocumentExt();
/*    */   
/*    */   void setInventoryDocumentExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInventoryDocumentLineItem> getInventoryDocumentLineItems();
/*    */   
/*    */   void setInventoryDocumentLineItems(List<IInventoryDocumentLineItem> paramList);
/*    */   
/*    */   void addInventoryDocumentLineItem(IInventoryDocumentLineItem paramIInventoryDocumentLineItem);
/*    */   
/*    */   void removeInventoryDocumentLineItem(IInventoryDocumentLineItem paramIInventoryDocumentLineItem);
/*    */   
/*    */   List<IShipment> getShipments();
/*    */   
/*    */   void setShipments(List<IShipment> paramList);
/*    */   
/*    */   void addShipment(IShipment paramIShipment);
/*    */   
/*    */   void removeShipment(IShipment paramIShipment);
/*    */   
/*    */   List<ICarton> getCartons();
/*    */   
/*    */   void setCartons(List<ICarton> paramList);
/*    */   
/*    */   void addCarton(ICarton paramICarton);
/*    */   
/*    */   void removeCarton(ICarton paramICarton);
/*    */   
/*    */   List<IDocumentNote> getNotes();
/*    */   
/*    */   void setNotes(List<IDocumentNote> paramList);
/*    */   
/*    */   void addDocumentNote(IDocumentNote paramIDocumentNote);
/*    */   
/*    */   void removeDocumentNote(IDocumentNote paramIDocumentNote);
/*    */   
/*    */   IAddress getOriginatorAddress();
/*    */   
/*    */   void setOriginatorAddress(IAddress paramIAddress);
/*    */   
/*    */   List<IInventoryDocumentProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryDocumentProperty> paramList);
/*    */   
/*    */   void addInventoryDocumentProperty(IInventoryDocumentProperty paramIInventoryDocumentProperty);
/*    */   
/*    */   void removeInventoryDocumentProperty(IInventoryDocumentProperty paramIInventoryDocumentProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryDocument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */