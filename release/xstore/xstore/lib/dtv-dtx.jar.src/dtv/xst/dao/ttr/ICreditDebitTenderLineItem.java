/*    */ package dtv.xst.dao.ttr;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface ICreditDebitTenderLineItem extends IDataModel, ICreditDebitTenderLineItemModel, ITenderLineItem {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_ACCOUNTNUMBER = new EventEnum("set accountNumber");
/* 14 */   public static final EventEnum SET_ADJUDICATIONCODE = new EventEnum("set adjudicationCode");
/* 15 */   public static final EventEnum SET_AUTHORIZATIONMETHODCODE = new EventEnum("set authorizationMethodCode");
/* 16 */   public static final EventEnum SET_AUTHORIZATIONCODE = new EventEnum("set authorizationCode");
/* 17 */   public static final EventEnum SET_BANKREFERENCENUMBER = new EventEnum("set bankReferenceNumber");
/* 18 */   public static final EventEnum SET_CUSTOMERNAME = new EventEnum("set customerName");
/* 19 */   public static final EventEnum SET_ENTRYMETHODCODE = new EventEnum("set entryMethodCode");
/* 20 */   public static final EventEnum SET_PS2000 = new EventEnum("set ps2000");
/* 21 */   public static final EventEnum SET_MEDIAISSUERID = new EventEnum("set mediaIssuerId");
/* 22 */   public static final EventEnum SET_PERSONALIDREFERENCENUMBER = new EventEnum("set personalIdReferenceNumber");
/* 23 */   public static final EventEnum SET_PERSONALIDREQUIREDTYPECODE = new EventEnum("set personalIdRequiredTypeCode");
/* 24 */   public static final EventEnum SET_EXPIRATIONDATESTRING = new EventEnum("set expirationDateString");
/* 25 */   public static final EventEnum SET_CASHBACKAMOUNT = new EventEnum("set cashbackAmount");
/* 26 */   public static final EventEnum SET_CARDLEVELINDICATOR = new EventEnum("set cardLevelIndicator");
/* 27 */   public static final EventEnum SET_ACCOUNTNUMBERHASH = new EventEnum("set accountNumberHash");
/* 28 */   public static final EventEnum SET_AUTHORIZATIONTOKEN = new EventEnum("set authorizationToken");
/* 29 */   public static final EventEnum SET_TRANSACTIONREFERENCEDATA = new EventEnum("set transactionReferenceData");
/* 30 */   public static final EventEnum SET_TRACENUMBER = new EventEnum("set traceNumber");
/* 31 */   public static final EventEnum SET_TAXAMOUNT = new EventEnum("set taxAmount");
/* 32 */   public static final EventEnum SET_DISCOUNTAMOUNT = new EventEnum("set discountAmount");
/* 33 */   public static final EventEnum SET_FREIGHTAMOUNT = new EventEnum("set freightAmount");
/* 34 */   public static final EventEnum SET_DUTYAMOUNT = new EventEnum("set dutyAmount");
/* 35 */   public static final EventEnum SET_ORIGLOCALDATETIME = new EventEnum("set origLocalDateTime");
/* 36 */   public static final EventEnum SET_ORIGTRANSMISSIONDATETIME = new EventEnum("set origTransmissionDateTime");
/* 37 */   public static final EventEnum SET_ORIGSTAN = new EventEnum("set origSTAN");
/* 38 */   public static final EventEnum SET_TRANSACTIONIDENTIFIER = new EventEnum("set transactionIdentifier");
/* 39 */   public static final EventEnum SET_CCVERRORCODE = new EventEnum("set ccvErrorCode");
/* 40 */   public static final EventEnum SET_POSENTRYMODECHANGE = new EventEnum("set posEntryModeChange");
/* 41 */   public static final EventEnum SET_PROCESSINGCODE = new EventEnum("set processingCode");
/* 42 */   public static final EventEnum SET_POSENTRYMODE = new EventEnum("set posEntryMode");
/* 43 */   public static final EventEnum SET_POSADDITIONALDATA = new EventEnum("set posAdditionalData");
/* 44 */   public static final EventEnum SET_NETWORKRESULTINDICATOR = new EventEnum("set networkResultIndicator");
/* 45 */   public static final EventEnum SET_MERCHANTCATEGORYCODE = new EventEnum("set merchantCategoryCode");
/* 46 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 47 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 48 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
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
/*    */   String getAdjudicationCode();
/*    */   
/*    */   void setAdjudicationCode(String paramString);
/*    */   
/*    */   String getAuthorizationMethodCode();
/*    */   
/*    */   void setAuthorizationMethodCode(String paramString);
/*    */   
/*    */   String getAuthorizationCode();
/*    */   
/*    */   void setAuthorizationCode(String paramString);
/*    */   
/*    */   String getBankReferenceNumber();
/*    */   
/*    */   void setBankReferenceNumber(String paramString);
/*    */   
/*    */   String getCustomerName();
/*    */   
/*    */   void setCustomerName(String paramString);
/*    */   
/*    */   String getEntryMethodCode();
/*    */   
/*    */   void setEntryMethodCode(String paramString);
/*    */   
/*    */   String getPs2000();
/*    */   
/*    */   void setPs2000(String paramString);
/*    */   
/*    */   String getMediaIssuerId();
/*    */   
/*    */   void setMediaIssuerId(String paramString);
/*    */   
/*    */   String getPersonalIdReferenceNumber();
/*    */   
/*    */   void setPersonalIdReferenceNumber(String paramString);
/*    */   
/*    */   String getPersonalIdRequiredTypeCode();
/*    */   
/*    */   void setPersonalIdRequiredTypeCode(String paramString);
/*    */   
/*    */   BigDecimal getCashbackAmount();
/*    */   
/*    */   void setCashbackAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getCardLevelIndicator();
/*    */   
/*    */   void setCardLevelIndicator(String paramString);
/*    */   
/*    */   String getAccountNumberHash();
/*    */   
/*    */   void setAccountNumberHash(String paramString);
/*    */   
/*    */   String getAuthorizationToken();
/*    */   
/*    */   void setAuthorizationToken(String paramString);
/*    */   
/*    */   String getTransactionReferenceData();
/*    */   
/*    */   void setTransactionReferenceData(String paramString);
/*    */   
/*    */   String getTraceNumber();
/*    */   
/*    */   void setTraceNumber(String paramString);
/*    */   
/*    */   BigDecimal getTaxAmount();
/*    */   
/*    */   void setTaxAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getDiscountAmount();
/*    */   
/*    */   void setDiscountAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getFreightAmount();
/*    */   
/*    */   void setFreightAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getDutyAmount();
/*    */   
/*    */   void setDutyAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getOrigLocalDateTime();
/*    */   
/*    */   void setOrigLocalDateTime(String paramString);
/*    */   
/*    */   String getOrigTransmissionDateTime();
/*    */   
/*    */   void setOrigTransmissionDateTime(String paramString);
/*    */   
/*    */   String getOrigSTAN();
/*    */   
/*    */   void setOrigSTAN(String paramString);
/*    */   
/*    */   String getTransactionIdentifier();
/*    */   
/*    */   void setTransactionIdentifier(String paramString);
/*    */   
/*    */   String getCcvErrorCode();
/*    */   
/*    */   void setCcvErrorCode(String paramString);
/*    */   
/*    */   String getPosEntryModeChange();
/*    */   
/*    */   void setPosEntryModeChange(String paramString);
/*    */   
/*    */   String getProcessingCode();
/*    */   
/*    */   void setProcessingCode(String paramString);
/*    */   
/*    */   String getPosEntryMode();
/*    */   
/*    */   void setPosEntryMode(String paramString);
/*    */   
/*    */   String getPosAdditionalData();
/*    */   
/*    */   void setPosAdditionalData(String paramString);
/*    */   
/*    */   String getNetworkResultIndicator();
/*    */   
/*    */   void setNetworkResultIndicator(String paramString);
/*    */   
/*    */   String getMerchantCategoryCode();
/*    */   
/*    */   void setMerchantCategoryCode(String paramString);
/*    */   
/*    */   IDataModel getCreditDebitTenderLineItemExt();
/*    */   
/*    */   void setCreditDebitTenderLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\ICreditDebitTenderLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */