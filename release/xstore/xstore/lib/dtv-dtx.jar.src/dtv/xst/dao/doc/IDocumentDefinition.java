/*    */ package dtv.xst.dao.doc;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDocumentDefinition extends IDataModel, IHasDataProperty<IDocumentDefinitionProperty> {
/*  9 */   public static final EventEnum SET_SERIESID = new EventEnum("set seriesId");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_DOCUMENTTYPE = new EventEnum("set documentType");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 17 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 18 */   public static final EventEnum SET_STARTISSUEDATE = new EventEnum("set startIssueDate");
/* 19 */   public static final EventEnum SET_ENDISSUEDATE = new EventEnum("set endIssueDate");
/* 20 */   public static final EventEnum SET_STARTREDEEMDATE = new EventEnum("set startRedeemDate");
/* 21 */   public static final EventEnum SET_ENDREDEEMDATE = new EventEnum("set endRedeemDate");
/* 22 */   public static final EventEnum SET_VENDORID = new EventEnum("set vendorId");
/* 23 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 24 */   public static final EventEnum SET_RECEIPTTYPE = new EventEnum("set receiptType");
/* 25 */   public static final EventEnum SET_SEGMENTTYPE = new EventEnum("set segmentType");
/* 26 */   public static final EventEnum SET_TEXTCODEVALUE = new EventEnum("set textCodeValue");
/* 27 */   public static final EventEnum SET_FILENAME = new EventEnum("set fileName");
/* 28 */   public static final EventEnum ADD_DOCDEFPROPERTIES = new EventEnum("add DocDefProperties");
/* 29 */   public static final EventEnum REMOVE_DOCDEFPROPERTIES = new EventEnum("remove DocDefProperties");
/* 30 */   public static final EventEnum SET_DOCDEFPROPERTIES = new EventEnum("set DocDefProperties");
/* 31 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 32 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 33 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 34 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 35 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 36 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getSeriesId();
/*    */   
/*    */   void setSeriesId(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getDocumentType();
/*    */   
/*    */   void setDocumentType(String paramString);
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
/*    */   String getOrgCode();
/*    */   
/*    */   void setOrgCode(String paramString);
/*    */   
/*    */   String getOrgValue();
/*    */   
/*    */   void setOrgValue(String paramString);
/*    */   
/*    */   Date getStartIssueDate();
/*    */   
/*    */   void setStartIssueDate(Date paramDate);
/*    */   
/*    */   Date getEndIssueDate();
/*    */   
/*    */   void setEndIssueDate(Date paramDate);
/*    */   
/*    */   Date getStartRedeemDate();
/*    */   
/*    */   void setStartRedeemDate(Date paramDate);
/*    */   
/*    */   Date getEndRedeemDate();
/*    */   
/*    */   void setEndRedeemDate(Date paramDate);
/*    */   
/*    */   String getVendorId();
/*    */   
/*    */   void setVendorId(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   String getReceiptType();
/*    */   
/*    */   void setReceiptType(String paramString);
/*    */   
/*    */   String getSegmentType();
/*    */   
/*    */   void setSegmentType(String paramString);
/*    */   
/*    */   String getTextCodeValue();
/*    */   
/*    */   void setTextCodeValue(String paramString);
/*    */   
/*    */   String getFileName();
/*    */   
/*    */   void setFileName(String paramString);
/*    */   
/*    */   IDataModel getDocumentDefinitionExt();
/*    */   
/*    */   void setDocumentDefinitionExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IDocumentDefinitionProperties> getDocDefProperties();
/*    */   
/*    */   void setDocDefProperties(List<IDocumentDefinitionProperties> paramList);
/*    */   
/*    */   void addDocumentDefinitionProperties(IDocumentDefinitionProperties paramIDocumentDefinitionProperties);
/*    */   
/*    */   void removeDocumentDefinitionProperties(IDocumentDefinitionProperties paramIDocumentDefinitionProperties);
/*    */   
/*    */   List<IDocumentDefinitionProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDocumentDefinitionProperty> paramList);
/*    */   
/*    */   void addDocumentDefinitionProperty(IDocumentDefinitionProperty paramIDocumentDefinitionProperty);
/*    */   
/*    */   void removeDocumentDefinitionProperty(IDocumentDefinitionProperty paramIDocumentDefinitionProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\IDocumentDefinition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */