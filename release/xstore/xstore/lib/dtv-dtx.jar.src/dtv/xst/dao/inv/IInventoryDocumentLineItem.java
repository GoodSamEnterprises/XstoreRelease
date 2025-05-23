/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryDocumentLineItem extends IDataModel, IInventoryDocumentLineItemModel, IHasDataProperty<IInventoryDocumentLineItemProperty> {
/*  9 */   public static final EventEnum SET_DOCUMENTID = new EventEnum("set documentId");
/* 10 */   public static final EventEnum SET_DOCUMENTTYPECODE = new EventEnum("set documentTypeCode");
/* 11 */   public static final EventEnum SET_INVENTORYDOCUMENTLINENUMBER = new EventEnum("set inventoryDocumentLineNumber");
/* 12 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 13 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_INVENTORYITEMID = new EventEnum("set inventoryItemId");
/* 19 */   public static final EventEnum SET_LINEITEMBUSINESSDATE = new EventEnum("set lineItemBusinessDate");
/* 20 */   public static final EventEnum SET_LINEITEMRETAILLOCATIONID = new EventEnum("set lineItemRetailLocationId");
/* 21 */   public static final EventEnum SET_LINEITEMRETAILTRANSACTIONLINEITEMSEQUENCE = new EventEnum("set lineItemRetailTransactionLineItemSequence");
/* 22 */   public static final EventEnum SET_LINEITEMTRANSACTIONSEQUENCE = new EventEnum("set lineItemTransactionSequence");
/* 23 */   public static final EventEnum SET_LINEITEMTYPECODE = new EventEnum("set lineItemTypeCode");
/* 24 */   public static final EventEnum SET_LINEITEMWORKSTATIONID = new EventEnum("set lineItemWorkstationId");
/* 25 */   public static final EventEnum SET_STATUSCODE = new EventEnum("set statusCode");
/* 26 */   public static final EventEnum SET_SERIALNUMBER = new EventEnum("set serialNumber");
/* 27 */   public static final EventEnum SET_UNITCOUNT = new EventEnum("set unitCount");
/* 28 */   public static final EventEnum SET_UNITCOST = new EventEnum("set unitCost");
/* 29 */   public static final EventEnum SET_EXPECTEDCOUNT = new EventEnum("set expectedCount");
/* 30 */   public static final EventEnum SET_POSTEDCOUNT = new EventEnum("set postedCount");
/* 31 */   public static final EventEnum SET_POSTEDCOST = new EventEnum("set postedCost");
/* 32 */   public static final EventEnum SET_RECORDCREATIONTYPE = new EventEnum("set recordCreationType");
/* 33 */   public static final EventEnum SET_ENTEREDITEMDESCRIPTION = new EventEnum("set enteredItemDescription");
/* 34 */   public static final EventEnum SET_ENTEREDITEMID = new EventEnum("set enteredItemId");
/* 35 */   public static final EventEnum SET_CARTONID = new EventEnum("set cartonId");
/* 36 */   public static final EventEnum SET_RETAIL = new EventEnum("set retail");
/* 37 */   public static final EventEnum SET_MODELNUMBER = new EventEnum("set modelNumber");
/* 38 */   public static final EventEnum SET_ORIGINALBUCKETID = new EventEnum("set originalBucketId");
/* 39 */   public static final EventEnum SET_ORIGINALLOCATIONID = new EventEnum("set originalLocationId");
/* 40 */   public static final EventEnum SET_CONTROLNUMBER = new EventEnum("set controlNumber");
/* 41 */   public static final EventEnum SET_SHIPPINGWEIGHT = new EventEnum("set shippingWeight");
/* 42 */   public static final EventEnum SET_CUSTOMERITEMACCOUNTMOD = new EventEnum("set CustomerItemAccountMod");
/* 43 */   public static final EventEnum ADD_SERIALNUMBERS = new EventEnum("add SerialNumbers");
/* 44 */   public static final EventEnum REMOVE_SERIALNUMBERS = new EventEnum("remove SerialNumbers");
/* 45 */   public static final EventEnum SET_SERIALNUMBERS = new EventEnum("set SerialNumbers");
/* 46 */   public static final EventEnum ADD_DOCUMENTINVENTORYLOCATIONMODIFIERS = new EventEnum("add DocumentInventoryLocationModifiers");
/* 47 */   public static final EventEnum REMOVE_DOCUMENTINVENTORYLOCATIONMODIFIERS = new EventEnum("remove DocumentInventoryLocationModifiers");
/* 48 */   public static final EventEnum SET_DOCUMENTINVENTORYLOCATIONMODIFIERS = new EventEnum("set DocumentInventoryLocationModifiers");
/* 49 */   public static final EventEnum SET_INVENTORYREPLENISHMENTDOCUMENTLINEITEM = new EventEnum("set InventoryReplenishmentDocumentLineItem");
/* 50 */   public static final EventEnum ADD_NOTES = new EventEnum("add Notes");
/* 51 */   public static final EventEnum REMOVE_NOTES = new EventEnum("remove Notes");
/* 52 */   public static final EventEnum SET_NOTES = new EventEnum("set Notes");
/* 53 */   public static final EventEnum SET_INVENTORYLINECROSSREFERENCE = new EventEnum("set InventoryLineCrossReference");
/* 54 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 55 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 56 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 57 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 58 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 59 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getInventoryItemId();
/*    */   
/*    */   void setInventoryItemId(String paramString);
/*    */   
/*    */   Date getLineItemBusinessDate();
/*    */   
/*    */   void setLineItemBusinessDate(Date paramDate);
/*    */   
/*    */   long getLineItemRetailLocationId();
/*    */   
/*    */   void setLineItemRetailLocationId(long paramLong);
/*    */   
/*    */   int getLineItemRetailTransactionLineItemSequence();
/*    */   
/*    */   void setLineItemRetailTransactionLineItemSequence(int paramInt);
/*    */   
/*    */   long getLineItemTransactionSequence();
/*    */   
/*    */   void setLineItemTransactionSequence(long paramLong);
/*    */   
/*    */   String getLineItemTypeCode();
/*    */   
/*    */   void setLineItemTypeCode(String paramString);
/*    */   
/*    */   long getLineItemWorkstationId();
/*    */   
/*    */   void setLineItemWorkstationId(long paramLong);
/*    */   
/*    */   String getStatusCode();
/*    */   
/*    */   void setStatusCode(String paramString);
/*    */   
/*    */   String getSerialNumber();
/*    */   
/*    */   void setSerialNumber(String paramString);
/*    */   
/*    */   BigDecimal getUnitCount();
/*    */   
/*    */   void setUnitCount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getUnitCost();
/*    */   
/*    */   void setUnitCost(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getExpectedCount();
/*    */   
/*    */   void setExpectedCount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getPostedCount();
/*    */   
/*    */   void setPostedCount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getPostedCost();
/*    */   
/*    */   void setPostedCost(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getRecordCreationType();
/*    */   
/*    */   void setRecordCreationType(String paramString);
/*    */   
/*    */   String getEnteredItemDescription();
/*    */   
/*    */   void setEnteredItemDescription(String paramString);
/*    */   
/*    */   String getEnteredItemId();
/*    */   
/*    */   void setEnteredItemId(String paramString);
/*    */   
/*    */   String getCartonId();
/*    */   
/*    */   void setCartonId(String paramString);
/*    */   
/*    */   BigDecimal getRetail();
/*    */   
/*    */   void setRetail(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getModelNumber();
/*    */   
/*    */   void setModelNumber(String paramString);
/*    */   
/*    */   String getOriginalBucketId();
/*    */   
/*    */   void setOriginalBucketId(String paramString);
/*    */   
/*    */   String getOriginalLocationId();
/*    */   
/*    */   void setOriginalLocationId(String paramString);
/*    */   
/*    */   String getControlNumber();
/*    */   
/*    */   void setControlNumber(String paramString);
/*    */   
/*    */   BigDecimal getShippingWeight();
/*    */   
/*    */   void setShippingWeight(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getInventoryDocumentLineItemExt();
/*    */   
/*    */   void setInventoryDocumentLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   IInventoryItemAccountModifier getCustomerItemAccountMod();
/*    */   
/*    */   void setCustomerItemAccountMod(IInventoryItemAccountModifier paramIInventoryItemAccountModifier);
/*    */   
/*    */   List<IInventoryDocumentLineSerial> getSerialNumbers();
/*    */   
/*    */   void setSerialNumbers(List<IInventoryDocumentLineSerial> paramList);
/*    */   
/*    */   void addInventoryDocumentLineSerial(IInventoryDocumentLineSerial paramIInventoryDocumentLineSerial);
/*    */   
/*    */   void removeInventoryDocumentLineSerial(IInventoryDocumentLineSerial paramIInventoryDocumentLineSerial);
/*    */   
/*    */   List<IDocumentInventoryLocationModifier> getDocumentInventoryLocationModifiers();
/*    */   
/*    */   void setDocumentInventoryLocationModifiers(List<IDocumentInventoryLocationModifier> paramList);
/*    */   
/*    */   void addDocumentInventoryLocationModifier(IDocumentInventoryLocationModifier paramIDocumentInventoryLocationModifier);
/*    */   
/*    */   void removeDocumentInventoryLocationModifier(IDocumentInventoryLocationModifier paramIDocumentInventoryLocationModifier);
/*    */   
/*    */   IInventoryReplenishmentDocumentLineItem getInventoryReplenishmentDocumentLineItem();
/*    */   
/*    */   void setInventoryReplenishmentDocumentLineItem(IInventoryReplenishmentDocumentLineItem paramIInventoryReplenishmentDocumentLineItem);
/*    */   
/*    */   List<IDocumentLineItemNote> getNotes();
/*    */   
/*    */   void setNotes(List<IDocumentLineItemNote> paramList);
/*    */   
/*    */   void addDocumentLineItemNote(IDocumentLineItemNote paramIDocumentLineItemNote);
/*    */   
/*    */   void removeDocumentLineItemNote(IDocumentLineItemNote paramIDocumentLineItemNote);
/*    */   
/*    */   IInventoryDocumentCrossReference getInventoryLineCrossReference();
/*    */   
/*    */   void setInventoryLineCrossReference(IInventoryDocumentCrossReference paramIInventoryDocumentCrossReference);
/*    */   
/*    */   List<IInventoryDocumentLineItemProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryDocumentLineItemProperty> paramList);
/*    */   
/*    */   void addInventoryDocumentLineItemProperty(IInventoryDocumentLineItemProperty paramIInventoryDocumentLineItemProperty);
/*    */   
/*    */   void removeInventoryDocumentLineItemProperty(IInventoryDocumentLineItemProperty paramIInventoryDocumentLineItemProperty);
/*    */   
/*    */   void setParentDocument(IInventoryDocument paramIInventoryDocument);
/*    */   
/*    */   IInventoryDocument getParentDocument();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryDocumentLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */