/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IWarrantyJournal extends IDataModel, IWarrantyJournalModel, IHasDataProperty<IWarrantyJournalProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_WARRANTYNBR = new EventEnum("set warrantyNbr");
/* 11 */   public static final EventEnum SET_WARRANTYTYPECODE = new EventEnum("set warrantyTypeCode");
/* 12 */   public static final EventEnum SET_JOURNALSEQUENCE = new EventEnum("set journalSequence");
/* 13 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 14 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 15 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 16 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 17 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 18 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 19 */   public static final EventEnum SET_TRANSBUSINESSDATE = new EventEnum("set transBusinessDate");
/* 20 */   public static final EventEnum SET_TRANSRTLLOCID = new EventEnum("set transRtlLocId");
/* 21 */   public static final EventEnum SET_TRANSWKSTNID = new EventEnum("set transWkstnId");
/* 22 */   public static final EventEnum SET_TRANSTRANSSEQ = new EventEnum("set transTransSeq");
/* 23 */   public static final EventEnum SET_WARRANTYPLANID = new EventEnum("set warrantyPlanId");
/* 24 */   public static final EventEnum SET_WARRANTYISSUEDATE = new EventEnum("set warrantyIssueDate");
/* 25 */   public static final EventEnum SET_WARRANTYEXPIRATIONDATE = new EventEnum("set warrantyExpirationDate");
/* 26 */   public static final EventEnum SET_STATUSCODE = new EventEnum("set statusCode");
/* 27 */   public static final EventEnum SET_PURCHASEPRICE = new EventEnum("set purchasePrice");
/* 28 */   public static final EventEnum SET_CUSTOMERID = new EventEnum("set customerId");
/* 29 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 30 */   public static final EventEnum SET_CERTIFICATENBR = new EventEnum("set certificateNbr");
/* 31 */   public static final EventEnum SET_CERTIFICATECOMPANYNAME = new EventEnum("set certificateCompanyName");
/* 32 */   public static final EventEnum SET_WARRANTYITEMID = new EventEnum("set warrantyItemId");
/* 33 */   public static final EventEnum SET_WARRANTYLINEBUSINESSDATE = new EventEnum("set warrantyLineBusinessDate");
/* 34 */   public static final EventEnum SET_WARRANTYLINERTLLOCID = new EventEnum("set warrantyLineRtlLocId");
/* 35 */   public static final EventEnum SET_WARRANTYLINEWKSTNID = new EventEnum("set warrantyLineWkstnId");
/* 36 */   public static final EventEnum SET_WARRANTYLINETRANSSEQ = new EventEnum("set warrantyLineTransSeq");
/* 37 */   public static final EventEnum SET_WARRANTYLINETRANSLINEITEMSEQ = new EventEnum("set warrantyLineTransLineItemSeq");
/* 38 */   public static final EventEnum SET_COVEREDITEMID = new EventEnum("set coveredItemId");
/* 39 */   public static final EventEnum SET_COVEREDLINEBUSINESSDATE = new EventEnum("set coveredLineBusinessDate");
/* 40 */   public static final EventEnum SET_COVEREDLINERTLLOCID = new EventEnum("set coveredLineRtlLocId");
/* 41 */   public static final EventEnum SET_COVEREDLINEWKSTNID = new EventEnum("set coveredLineWkstnId");
/* 42 */   public static final EventEnum SET_COVEREDLINETRANSSEQ = new EventEnum("set coveredLineTransSeq");
/* 43 */   public static final EventEnum SET_COVEREDLINETRANSLINEITEMSEQ = new EventEnum("set coveredLineTransLineItemSeq");
/* 44 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 45 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 46 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 47 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 48 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 49 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   long getJournalSequence();
/*    */   
/*    */   void setJournalSequence(long paramLong);
/*    */   
/*    */   String getOrgCode();
/*    */   
/*    */   void setOrgCode(String paramString);
/*    */   
/*    */   String getOrgValue();
/*    */   
/*    */   void setOrgValue(String paramString);
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
/*    */   Date getTransBusinessDate();
/*    */   
/*    */   void setTransBusinessDate(Date paramDate);
/*    */   
/*    */   long getTransRtlLocId();
/*    */   
/*    */   void setTransRtlLocId(long paramLong);
/*    */   
/*    */   long getTransWkstnId();
/*    */   
/*    */   void setTransWkstnId(long paramLong);
/*    */   
/*    */   long getTransTransSeq();
/*    */   
/*    */   void setTransTransSeq(long paramLong);
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
/*    */   IDataModel getWarrantyJournalExt();
/*    */   
/*    */   void setWarrantyJournalExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IWarrantyJournalProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IWarrantyJournalProperty> paramList);
/*    */   
/*    */   void addWarrantyJournalProperty(IWarrantyJournalProperty paramIWarrantyJournalProperty);
/*    */   
/*    */   void removeWarrantyJournalProperty(IWarrantyJournalProperty paramIWarrantyJournalProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IWarrantyJournal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */