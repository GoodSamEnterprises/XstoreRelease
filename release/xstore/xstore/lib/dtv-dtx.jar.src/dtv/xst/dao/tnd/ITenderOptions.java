/*    */ package dtv.xst.dao.tnd;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITenderOptions extends IDataModel, IHasConfigElement, IHasDataProperty<ITenderOptionsProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_TENDERID = new EventEnum("set tenderId");
/* 11 */   public static final EventEnum SET_CONFIGELEMENT = new EventEnum("set configElement");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_AUTHEXPIRATIONDATEREQUIRED = new EventEnum("set authExpirationDateRequired");
/* 17 */   public static final EventEnum SET_AUTHMETHODCODE = new EventEnum("set authMethodCode");
/* 18 */   public static final EventEnum SET_AUTHREQUIRED = new EventEnum("set authRequired");
/* 19 */   public static final EventEnum SET_CUSTASSOCIATION = new EventEnum("set custAssociation");
/* 20 */   public static final EventEnum SET_CUSTIDREQCODE = new EventEnum("set custIdReqCode");
/* 21 */   public static final EventEnum SET_CUSTOMERSIGNATUREREQUIRED = new EventEnum("set customerSignatureRequired");
/* 22 */   public static final EventEnum SET_DFLTTOAMOUNTDUE = new EventEnum("set dfltToAmountDue");
/* 23 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 24 */   public static final EventEnum SET_ENDORSEMENTREQUIRED = new EventEnum("set endorsementRequired");
/* 25 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 26 */   public static final EventEnum SET_INCLUDEINTYPECOUNT = new EventEnum("set includeInTypeCount");
/* 27 */   public static final EventEnum SET_MAGNETICSWIPEREADERREQUIRED = new EventEnum("set magneticSwipeReaderRequired");
/* 28 */   public static final EventEnum SET_MAXDAYSFORRETURN = new EventEnum("set maxDaysForReturn");
/* 29 */   public static final EventEnum SET_MINDAYSFORRETURN = new EventEnum("set minDaysForReturn");
/* 30 */   public static final EventEnum SET_MINIMUMDENOMINATIONAMOUNT = new EventEnum("set minimumDenominationAmount");
/* 31 */   public static final EventEnum SET_OPENCASHDRAWERREQUIRED = new EventEnum("set openCashDrawerRequired");
/* 32 */   public static final EventEnum SET_PINREQUIRED = new EventEnum("set pinRequired");
/* 33 */   public static final EventEnum SET_POPULATESYSTEMCOUNT = new EventEnum("set populateSystemCount");
/* 34 */   public static final EventEnum SET_SERIALIDENTIFICATIONNBRREQUIRED = new EventEnum("set serialIdentificationNbrRequired");
/* 35 */   public static final EventEnum SET_UNITCOUNTCODE = new EventEnum("set unitCountCode");
/* 36 */   public static final EventEnum SET_SUGGESTDEPOSIT = new EventEnum("set suggestDeposit");
/* 37 */   public static final EventEnum SET_SUGGESTEDDEPOSITTHRESHOLD = new EventEnum("set suggestedDepositThreshold");
/* 38 */   public static final EventEnum SET_CASHCHANGELIMIT = new EventEnum("set cashChangeLimit");
/* 39 */   public static final EventEnum SET_CHANGETENDERID = new EventEnum("set changeTenderId");
/* 40 */   public static final EventEnum SET_OVERTENDEROVERRIDABLE = new EventEnum("set overtenderOverridable");
/* 41 */   public static final EventEnum SET_NONVOIDABLE = new EventEnum("set nonVoidable");
/* 42 */   public static final EventEnum SET_CLOSECOUNTDISCREPANCYTHRESHOLD = new EventEnum("set closeCountDiscrepancyThreshold");
/* 43 */   public static final EventEnum SET_CIDMSRREQUIRED = new EventEnum("set cidMsrRequired");
/* 44 */   public static final EventEnum SET_CIDKEYEDREQUIRED = new EventEnum("set cidKeyedRequired");
/* 45 */   public static final EventEnum SET_POSTALREQUIRED = new EventEnum("set postalRequired");
/* 46 */   public static final EventEnum SET_DISALLOWSPLITTENDER = new EventEnum("set disallowSplitTender");
/* 47 */   public static final EventEnum SET_POSTVOIDOPENCASHDRAWERREQUIRED = new EventEnum("set postVoidOpenCashDrawerRequired");
/* 48 */   public static final EventEnum SET_REPORTINGGROUP = new EventEnum("set reportingGroup");
/* 49 */   public static final EventEnum SET_CHANGEALLOWEDWHENFOREIGN = new EventEnum("set changeAllowedWhenForeign");
/* 50 */   public static final EventEnum SET_FISCALTENDERID = new EventEnum("set fiscalTenderId");
/* 51 */   public static final EventEnum SET_ROUNDINGMODE = new EventEnum("set roundingMode");
/* 52 */   public static final EventEnum SET_ASSIGNCASHDRAWERREQUIRED = new EventEnum("set assignCashDrawerRequired");
/* 53 */   public static final EventEnum SET_POSTVOIDASSIGNCASHDRAWERREQUIRED = new EventEnum("set postVoidAssignCashDrawerRequired");
/* 54 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 55 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 56 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 57 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 58 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 59 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getTenderId();
/*    */   
/*    */   void setTenderId(String paramString);
/*    */   
/*    */   String getConfigElement();
/*    */   
/*    */   void setConfigElement(String paramString);
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
/*    */   boolean getAuthExpirationDateRequired();
/*    */   
/*    */   void setAuthExpirationDateRequired(boolean paramBoolean);
/*    */   
/*    */   String getAuthMethodCode();
/*    */   
/*    */   void setAuthMethodCode(String paramString);
/*    */   
/*    */   boolean getAuthRequired();
/*    */   
/*    */   void setAuthRequired(boolean paramBoolean);
/*    */   
/*    */   boolean getCustAssociation();
/*    */   
/*    */   void setCustAssociation(boolean paramBoolean);
/*    */   
/*    */   String getCustIdReqCode();
/*    */   
/*    */   void setCustIdReqCode(String paramString);
/*    */   
/*    */   boolean getCustomerSignatureRequired();
/*    */   
/*    */   void setCustomerSignatureRequired(boolean paramBoolean);
/*    */   
/*    */   boolean getDfltToAmountDue();
/*    */   
/*    */   void setDfltToAmountDue(boolean paramBoolean);
/*    */   
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
/*    */   
/*    */   boolean getEndorsementRequired();
/*    */   
/*    */   void setEndorsementRequired(boolean paramBoolean);
/*    */   
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   boolean getIncludeInTypeCount();
/*    */   
/*    */   void setIncludeInTypeCount(boolean paramBoolean);
/*    */   
/*    */   boolean getMagneticSwipeReaderRequired();
/*    */   
/*    */   void setMagneticSwipeReaderRequired(boolean paramBoolean);
/*    */   
/*    */   int getMaxDaysForReturn();
/*    */   
/*    */   void setMaxDaysForReturn(int paramInt);
/*    */   
/*    */   int getMinDaysForReturn();
/*    */   
/*    */   void setMinDaysForReturn(int paramInt);
/*    */   
/*    */   BigDecimal getMinimumDenominationAmount();
/*    */   
/*    */   void setMinimumDenominationAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getOpenCashDrawerRequired();
/*    */   
/*    */   void setOpenCashDrawerRequired(boolean paramBoolean);
/*    */   
/*    */   boolean getPinRequired();
/*    */   
/*    */   void setPinRequired(boolean paramBoolean);
/*    */   
/*    */   boolean getPopulateSystemCount();
/*    */   
/*    */   void setPopulateSystemCount(boolean paramBoolean);
/*    */   
/*    */   boolean getSerialIdentificationNbrRequired();
/*    */   
/*    */   void setSerialIdentificationNbrRequired(boolean paramBoolean);
/*    */   
/*    */   String getUnitCountCode();
/*    */   
/*    */   void setUnitCountCode(String paramString);
/*    */   
/*    */   boolean getSuggestDeposit();
/*    */   
/*    */   void setSuggestDeposit(boolean paramBoolean);
/*    */   
/*    */   BigDecimal getSuggestedDepositThreshold();
/*    */   
/*    */   void setSuggestedDepositThreshold(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getCashChangeLimit();
/*    */   
/*    */   void setCashChangeLimit(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getChangeTenderId();
/*    */   
/*    */   void setChangeTenderId(String paramString);
/*    */   
/*    */   boolean getOvertenderOverridable();
/*    */   
/*    */   void setOvertenderOverridable(boolean paramBoolean);
/*    */   
/*    */   boolean getNonVoidable();
/*    */   
/*    */   void setNonVoidable(boolean paramBoolean);
/*    */   
/*    */   BigDecimal getCloseCountDiscrepancyThreshold();
/*    */   
/*    */   void setCloseCountDiscrepancyThreshold(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getCidMsrRequired();
/*    */   
/*    */   void setCidMsrRequired(boolean paramBoolean);
/*    */   
/*    */   boolean getCidKeyedRequired();
/*    */   
/*    */   void setCidKeyedRequired(boolean paramBoolean);
/*    */   
/*    */   boolean getPostalRequired();
/*    */   
/*    */   void setPostalRequired(boolean paramBoolean);
/*    */   
/*    */   boolean getDisallowSplitTender();
/*    */   
/*    */   void setDisallowSplitTender(boolean paramBoolean);
/*    */   
/*    */   boolean getPostVoidOpenCashDrawerRequired();
/*    */   
/*    */   void setPostVoidOpenCashDrawerRequired(boolean paramBoolean);
/*    */   
/*    */   String getReportingGroup();
/*    */   
/*    */   void setReportingGroup(String paramString);
/*    */   
/*    */   boolean getChangeAllowedWhenForeign();
/*    */   
/*    */   void setChangeAllowedWhenForeign(boolean paramBoolean);
/*    */   
/*    */   String getFiscalTenderId();
/*    */   
/*    */   void setFiscalTenderId(String paramString);
/*    */   
/*    */   String getRoundingMode();
/*    */   
/*    */   void setRoundingMode(String paramString);
/*    */   
/*    */   boolean getAssignCashDrawerRequired();
/*    */   
/*    */   void setAssignCashDrawerRequired(boolean paramBoolean);
/*    */   
/*    */   boolean getPostVoidAssignCashDrawerRequired();
/*    */   
/*    */   void setPostVoidAssignCashDrawerRequired(boolean paramBoolean);
/*    */   
/*    */   IDataModel getTenderOptionsExt();
/*    */   
/*    */   void setTenderOptionsExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ITenderOptionsProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITenderOptionsProperty> paramList);
/*    */   
/*    */   void addTenderOptionsProperty(ITenderOptionsProperty paramITenderOptionsProperty);
/*    */   
/*    */   void removeTenderOptionsProperty(ITenderOptionsProperty paramITenderOptionsProperty);
/*    */   
/*    */   void setParentTender(ITender paramITender);
/*    */   
/*    */   ITender getParentTender();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\ITenderOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */