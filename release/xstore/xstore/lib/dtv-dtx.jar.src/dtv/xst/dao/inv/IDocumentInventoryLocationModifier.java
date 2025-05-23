/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDocumentInventoryLocationModifier extends IDataModel, IInventoryLocationModifier, IHasDataProperty<IDocumentInventoryLocationModifierProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_DOCUMENTID = new EventEnum("set documentId");
/* 12 */   public static final EventEnum SET_DOCUMENTTYPECODE = new EventEnum("set documentTypeCode");
/* 13 */   public static final EventEnum SET_DOCUMENTLINENUMBER = new EventEnum("set documentLineNumber");
/* 14 */   public static final EventEnum SET_MODIFIERSEQUENCE = new EventEnum("set modifierSequence");
/* 15 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 16 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 17 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 18 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 19 */   public static final EventEnum SET_SERIALNUMBER = new EventEnum("set serialNumber");
/* 20 */   public static final EventEnum SET_SOURCELOCATIONID = new EventEnum("set sourceLocationId");
/* 21 */   public static final EventEnum SET_SOURCEBUCKETID = new EventEnum("set sourceBucketId");
/* 22 */   public static final EventEnum SET_DESTINATIONLOCATIONID = new EventEnum("set destinationLocationId");
/* 23 */   public static final EventEnum SET_DESTINATIONBUCKETID = new EventEnum("set destinationBucketId");
/* 24 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 25 */   public static final EventEnum SET_QUANTITY = new EventEnum("set quantity");
/* 26 */   public static final EventEnum SET_ACTIONCODE = new EventEnum("set actionCode");
/* 27 */   public static final EventEnum SET_COST = new EventEnum("set cost");
/* 28 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 29 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 30 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 31 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 32 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 33 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   String getDocumentId();
/*    */   
/*    */   void setDocumentId(String paramString);
/*    */   
/*    */   String getDocumentTypeCode();
/*    */   
/*    */   void setDocumentTypeCode(String paramString);
/*    */   
/*    */   long getDocumentLineNumber();
/*    */   
/*    */   void setDocumentLineNumber(long paramLong);
/*    */   
/*    */   long getModifierSequence();
/*    */   
/*    */   void setModifierSequence(long paramLong);
/*    */   
/*    */   String getSerialNumber();
/*    */   
/*    */   void setSerialNumber(String paramString);
/*    */   
/*    */   String getSourceLocationId();
/*    */   
/*    */   void setSourceLocationId(String paramString);
/*    */   
/*    */   String getSourceBucketId();
/*    */   
/*    */   void setSourceBucketId(String paramString);
/*    */   
/*    */   String getDestinationLocationId();
/*    */   
/*    */   void setDestinationLocationId(String paramString);
/*    */   
/*    */   String getDestinationBucketId();
/*    */   
/*    */   void setDestinationBucketId(String paramString);
/*    */   
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
/*    */   
/*    */   BigDecimal getQuantity();
/*    */   
/*    */   void setQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getActionCode();
/*    */   
/*    */   void setActionCode(String paramString);
/*    */   
/*    */   BigDecimal getCost();
/*    */   
/*    */   void setCost(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getDocumentInventoryLocationModifierExt();
/*    */   
/*    */   void setDocumentInventoryLocationModifierExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IDocumentInventoryLocationModifierProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDocumentInventoryLocationModifierProperty> paramList);
/*    */   
/*    */   void addDocumentInventoryLocationModifierProperty(IDocumentInventoryLocationModifierProperty paramIDocumentInventoryLocationModifierProperty);
/*    */   
/*    */   void removeDocumentInventoryLocationModifierProperty(IDocumentInventoryLocationModifierProperty paramIDocumentInventoryLocationModifierProperty);
/*    */   
/*    */   void setParentLineItem(IInventoryDocumentLineItem paramIInventoryDocumentLineItem);
/*    */   
/*    */   IInventoryDocumentLineItem getParentLineItem();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IDocumentInventoryLocationModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */