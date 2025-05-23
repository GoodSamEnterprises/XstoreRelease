/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryDocumentCrossReference extends IDataModel, IHasDataProperty<IInventoryDocumentCrossReferenceProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_DOCUMENTID = new EventEnum("set documentId");
/* 11 */   public static final EventEnum SET_INVENTORYDOCUMENTLINENUMBER = new EventEnum("set inventoryDocumentLineNumber");
/* 12 */   public static final EventEnum SET_DOCUMENTTYPECODE = new EventEnum("set documentTypeCode");
/* 13 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_CROSSREFORGANIZATIONID = new EventEnum("set crossRefOrganizationId");
/* 19 */   public static final EventEnum SET_CROSSREFDOCUMENTID = new EventEnum("set crossRefDocumentId");
/* 20 */   public static final EventEnum SET_CROSSREFLINENUMBER = new EventEnum("set crossRefLineNumber");
/* 21 */   public static final EventEnum SET_CROSSREFDOCUMENTTYPECODE = new EventEnum("set crossRefDocumentTypeCode");
/* 22 */   public static final EventEnum SET_CROSSREFRETAILLOCATIONID = new EventEnum("set crossRefRetailLocationId");
/* 23 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 24 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 25 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 26 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 27 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 28 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getDocumentId();
/*    */   
/*    */   void setDocumentId(String paramString);
/*    */   
/*    */   int getInventoryDocumentLineNumber();
/*    */   
/*    */   void setInventoryDocumentLineNumber(int paramInt);
/*    */   
/*    */   String getDocumentTypeCode();
/*    */   
/*    */   void setDocumentTypeCode(String paramString);
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
/*    */   long getCrossRefOrganizationId();
/*    */   
/*    */   void setCrossRefOrganizationId(long paramLong);
/*    */   
/*    */   String getCrossRefDocumentId();
/*    */   
/*    */   void setCrossRefDocumentId(String paramString);
/*    */   
/*    */   int getCrossRefLineNumber();
/*    */   
/*    */   void setCrossRefLineNumber(int paramInt);
/*    */   
/*    */   String getCrossRefDocumentTypeCode();
/*    */   
/*    */   void setCrossRefDocumentTypeCode(String paramString);
/*    */   
/*    */   long getCrossRefRetailLocationId();
/*    */   
/*    */   void setCrossRefRetailLocationId(long paramLong);
/*    */   
/*    */   IDataModel getInventoryDocumentCrossReferenceExt();
/*    */   
/*    */   void setInventoryDocumentCrossReferenceExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInventoryDocumentCrossReferenceProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryDocumentCrossReferenceProperty> paramList);
/*    */   
/*    */   void addInventoryDocumentCrossReferenceProperty(IInventoryDocumentCrossReferenceProperty paramIInventoryDocumentCrossReferenceProperty);
/*    */   
/*    */   void removeInventoryDocumentCrossReferenceProperty(IInventoryDocumentCrossReferenceProperty paramIInventoryDocumentCrossReferenceProperty);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryDocumentCrossReference.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */