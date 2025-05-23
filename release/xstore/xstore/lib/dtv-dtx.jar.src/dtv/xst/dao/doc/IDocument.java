/*    */ package dtv.xst.dao.doc;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDocument extends IDataModel, IHasDataProperty<IDocumentProperty> {
/*  9 */   public static final EventEnum SET_DOCUMENTID = new EventEnum("set documentId");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_DOCUMENTTYPE = new EventEnum("set documentType");
/* 12 */   public static final EventEnum SET_SERIESID = new EventEnum("set seriesId");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 18 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 19 */   public static final EventEnum SET_DOCUMENTSTATUS = new EventEnum("set documentStatus");
/* 20 */   public static final EventEnum SET_ISSUEDATE = new EventEnum("set issueDate");
/* 21 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 22 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 23 */   public static final EventEnum SET_AMOUNT = new EventEnum("set amount");
/* 24 */   public static final EventEnum SET_MAXAMOUNT = new EventEnum("set maxAmount");
/* 25 */   public static final EventEnum SET_PERCENT = new EventEnum("set percent");
/* 26 */   public static final EventEnum SET_DOCUMENTDEFINITION = new EventEnum("set DocumentDefinition");
/* 27 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 28 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 29 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 30 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 31 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 32 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getDocumentId();
/*    */   
/*    */   void setDocumentId(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getDocumentType();
/*    */   
/*    */   void setDocumentType(String paramString);
/*    */   
/*    */   String getSeriesId();
/*    */   
/*    */   void setSeriesId(String paramString);
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
/*    */   String getDocumentStatus();
/*    */   
/*    */   void setDocumentStatus(String paramString);
/*    */   
/*    */   Date getIssueDate();
/*    */   
/*    */   void setIssueDate(Date paramDate);
/*    */   
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
/*    */   
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   BigDecimal getAmount();
/*    */   
/*    */   void setAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getMaxAmount();
/*    */   
/*    */   void setMaxAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getPercent();
/*    */   
/*    */   void setPercent(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getDocumentExt();
/*    */   
/*    */   void setDocumentExt(IDataModel paramIDataModel);
/*    */   
/*    */   IDocumentDefinition getDocumentDefinition();
/*    */   
/*    */   void setDocumentDefinition(IDocumentDefinition paramIDocumentDefinition);
/*    */   
/*    */   List<IDocumentProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDocumentProperty> paramList);
/*    */   
/*    */   void addDocumentProperty(IDocumentProperty paramIDocumentProperty);
/*    */   
/*    */   void removeDocumentProperty(IDocumentProperty paramIDocumentProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\IDocument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */