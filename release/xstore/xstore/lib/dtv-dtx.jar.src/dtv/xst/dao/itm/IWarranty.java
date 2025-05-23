/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IWarranty extends IDataModel, IWarrantyModel, IHasDataProperty<IWarrantyProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_WARRANTYNBR = new EventEnum("set warrantyNbr");
/* 11 */   public static final EventEnum SET_WARRANTYTYPECODE = new EventEnum("set warrantyTypeCode");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_WARRANTYPLANID = new EventEnum("set warrantyPlanId");
/* 17 */   public static final EventEnum SET_WARRANTYISSUEDATE = new EventEnum("set warrantyIssueDate");
/* 18 */   public static final EventEnum SET_WARRANTYEXPIRATIONDATE = new EventEnum("set warrantyExpirationDate");
/* 19 */   public static final EventEnum SET_STATUSCODE = new EventEnum("set statusCode");
/* 20 */   public static final EventEnum SET_PURCHASEPRICE = new EventEnum("set purchasePrice");
/* 21 */   public static final EventEnum SET_CUSTOMERID = new EventEnum("set customerId");
/* 22 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 23 */   public static final EventEnum SET_CERTIFICATENBR = new EventEnum("set certificateNbr");
/* 24 */   public static final EventEnum SET_CERTIFICATECOMPANYNAME = new EventEnum("set certificateCompanyName");
/* 25 */   public static final EventEnum SET_WARRANTYITEMID = new EventEnum("set warrantyItemId");
/* 26 */   public static final EventEnum SET_WARRANTYLINEBUSINESSDATE = new EventEnum("set warrantyLineBusinessDate");
/* 27 */   public static final EventEnum SET_WARRANTYLINERTLLOCID = new EventEnum("set warrantyLineRtlLocId");
/* 28 */   public static final EventEnum SET_WARRANTYLINEWKSTNID = new EventEnum("set warrantyLineWkstnId");
/* 29 */   public static final EventEnum SET_WARRANTYLINETRANSSEQ = new EventEnum("set warrantyLineTransSeq");
/* 30 */   public static final EventEnum SET_WARRANTYLINETRANSLINEITEMSEQ = new EventEnum("set warrantyLineTransLineItemSeq");
/* 31 */   public static final EventEnum SET_COVEREDITEMID = new EventEnum("set coveredItemId");
/* 32 */   public static final EventEnum SET_COVEREDLINEBUSINESSDATE = new EventEnum("set coveredLineBusinessDate");
/* 33 */   public static final EventEnum SET_COVEREDLINERTLLOCID = new EventEnum("set coveredLineRtlLocId");
/* 34 */   public static final EventEnum SET_COVEREDLINEWKSTNID = new EventEnum("set coveredLineWkstnId");
/* 35 */   public static final EventEnum SET_COVEREDLINETRANSSEQ = new EventEnum("set coveredLineTransSeq");
/* 36 */   public static final EventEnum SET_COVEREDLINETRANSLINEITEMSEQ = new EventEnum("set coveredLineTransLineItemSeq");
/* 37 */   public static final EventEnum SET_COVEREDITEMPURCHASEDATE = new EventEnum("set coveredItemPurchaseDate");
/* 38 */   public static final EventEnum SET_COVEREDITEMPURCHASEPRICE = new EventEnum("set coveredItemPurchasePrice");
/* 39 */   public static final EventEnum SET_COVEREDITEMPURCHASELOCATION = new EventEnum("set coveredItemPurchaseLocation");
/* 40 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 41 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 42 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 43 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 44 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 45 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getWarrantyNbr();
/*    */   
/*    */   void setWarrantyNbr(String paramString);
/*    */   
/*    */   String getWarrantyTypeCode();
/*    */   
/*    */   void setWarrantyTypeCode(String paramString);
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
/*    */   String getWarrantyPlanId();
/*    */   
/*    */   void setWarrantyPlanId(String paramString);
/*    */   
/*    */   Date getWarrantyIssueDate();
/*    */   
/*    */   void setWarrantyIssueDate(Date paramDate);
/*    */   
/*    */   Date getWarrantyExpirationDate();
/*    */   
/*    */   void setWarrantyExpirationDate(Date paramDate);
/*    */   
/*    */   String getStatusCode();
/*    */   
/*    */   void setStatusCode(String paramString);
/*    */   
/*    */   BigDecimal getPurchasePrice();
/*    */   
/*    */   void setPurchasePrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getCustomerId();
/*    */   
/*    */   void setCustomerId(String paramString);
/*    */   
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
/*    */   
/*    */   String getCertificateNbr();
/*    */   
/*    */   void setCertificateNbr(String paramString);
/*    */   
/*    */   String getCertificateCompanyName();
/*    */   
/*    */   void setCertificateCompanyName(String paramString);
/*    */   
/*    */   String getWarrantyItemId();
/*    */   
/*    */   void setWarrantyItemId(String paramString);
/*    */   
/*    */   Date getWarrantyLineBusinessDate();
/*    */   
/*    */   void setWarrantyLineBusinessDate(Date paramDate);
/*    */   
/*    */   long getWarrantyLineRtlLocId();
/*    */   
/*    */   void setWarrantyLineRtlLocId(long paramLong);
/*    */   
/*    */   long getWarrantyLineWkstnId();
/*    */   
/*    */   void setWarrantyLineWkstnId(long paramLong);
/*    */   
/*    */   long getWarrantyLineTransSeq();
/*    */   
/*    */   void setWarrantyLineTransSeq(long paramLong);
/*    */   
/*    */   int getWarrantyLineTransLineItemSeq();
/*    */   
/*    */   void setWarrantyLineTransLineItemSeq(int paramInt);
/*    */   
/*    */   String getCoveredItemId();
/*    */   
/*    */   void setCoveredItemId(String paramString);
/*    */   
/*    */   Date getCoveredLineBusinessDate();
/*    */   
/*    */   void setCoveredLineBusinessDate(Date paramDate);
/*    */   
/*    */   long getCoveredLineRtlLocId();
/*    */   
/*    */   void setCoveredLineRtlLocId(long paramLong);
/*    */   
/*    */   long getCoveredLineWkstnId();
/*    */   
/*    */   void setCoveredLineWkstnId(long paramLong);
/*    */   
/*    */   long getCoveredLineTransSeq();
/*    */   
/*    */   void setCoveredLineTransSeq(long paramLong);
/*    */   
/*    */   int getCoveredLineTransLineItemSeq();
/*    */   
/*    */   void setCoveredLineTransLineItemSeq(int paramInt);
/*    */   
/*    */   Date getCoveredItemPurchaseDate();
/*    */   
/*    */   void setCoveredItemPurchaseDate(Date paramDate);
/*    */   
/*    */   BigDecimal getCoveredItemPurchasePrice();
/*    */   
/*    */   void setCoveredItemPurchasePrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getCoveredItemPurchaseLocation();
/*    */   
/*    */   void setCoveredItemPurchaseLocation(String paramString);
/*    */   
/*    */   IDataModel getWarrantyExt();
/*    */   
/*    */   void setWarrantyExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IWarrantyProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IWarrantyProperty> paramList);
/*    */   
/*    */   void addWarrantyProperty(IWarrantyProperty paramIWarrantyProperty);
/*    */   
/*    */   void removeWarrantyProperty(IWarrantyProperty paramIWarrantyProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IWarranty.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */