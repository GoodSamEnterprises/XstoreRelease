/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICarton extends IDataModel, ICartonModel, IHasDataProperty<ICartonProperty> {
/*  9 */   public static final EventEnum SET_DOCUMENTID = new EventEnum("set documentId");
/* 10 */   public static final EventEnum SET_DOCUMENTTYPECODE = new EventEnum("set documentTypeCode");
/* 11 */   public static final EventEnum SET_CARTONID = new EventEnum("set cartonId");
/* 12 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 13 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_CARTONSTATUSCODE = new EventEnum("set cartonStatusCode");
/* 19 */   public static final EventEnum SET_CONTROLNUMBER = new EventEnum("set controlNumber");
/* 20 */   public static final EventEnum SET_RECORDCREATIONTYPE = new EventEnum("set recordCreationType");
/* 21 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 22 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 23 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 24 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 25 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 26 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getCartonId();
/*    */   
/*    */   void setCartonId(String paramString);
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
/*    */   String getCartonStatusCode();
/*    */   
/*    */   void setCartonStatusCode(String paramString);
/*    */   
/*    */   String getControlNumber();
/*    */   
/*    */   void setControlNumber(String paramString);
/*    */   
/*    */   String getRecordCreationType();
/*    */   
/*    */   void setRecordCreationType(String paramString);
/*    */   
/*    */   IDataModel getCartonExt();
/*    */   
/*    */   void setCartonExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ICartonProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICartonProperty> paramList);
/*    */   
/*    */   void addCartonProperty(ICartonProperty paramICartonProperty);
/*    */   
/*    */   void removeCartonProperty(ICartonProperty paramICartonProperty);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\ICarton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */