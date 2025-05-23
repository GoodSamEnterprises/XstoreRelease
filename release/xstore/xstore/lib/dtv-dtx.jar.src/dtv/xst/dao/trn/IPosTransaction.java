/*    */ package dtv.xst.dao.trn;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IPosTransaction extends IDataModel, IPosTransactionModel, IHasDataProperty<IPosTransactionProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 12 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 13 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 14 */   public static final EventEnum SET_CLASSNAME = new EventEnum("set className");
/* 15 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 16 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 17 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 18 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 19 */   public static final EventEnum SET_BEGINDATETIMESTAMP = new EventEnum("set beginDateTimestamp");
/* 20 */   public static final EventEnum SET_TRANSACTIONDATE = new EventEnum("set transactionDate");
/* 21 */   public static final EventEnum SET_BEGINTIMEINT = new EventEnum("set beginTimeInt");
/* 22 */   public static final EventEnum SET_ENDDATETIMESTAMP = new EventEnum("set endDateTimestamp");
/* 23 */   public static final EventEnum SET_KEYEDOFFLINE = new EventEnum("set keyedOffline");
/* 24 */   public static final EventEnum SET_POSTED = new EventEnum("set posted");
/* 25 */   public static final EventEnum SET_SESSIONID = new EventEnum("set sessionId");
/* 26 */   public static final EventEnum SET_SUBTOTAL = new EventEnum("set subtotal");
/* 27 */   public static final EventEnum SET_TAXAMOUNT = new EventEnum("set taxAmount");
/* 28 */   public static final EventEnum SET_ROUNDEDAMOUNT = new EventEnum("set roundedAmount");
/* 29 */   public static final EventEnum SET_TOTAL = new EventEnum("set total");
/* 30 */   public static final EventEnum SET_TRANSACTIONSTATUSCODE = new EventEnum("set transactionStatusCode");
/* 31 */   public static final EventEnum SET_TRANSACTIONTYPECODE = new EventEnum("set transactionTypeCode");
/* 32 */   public static final EventEnum SET_TRANSACTIONCANCELLEDREASONCODE = new EventEnum("set transactionCancelledReasonCode");
/* 33 */   public static final EventEnum SET_GENERICSTORAGE = new EventEnum("set genericStorage");
/* 34 */   public static final EventEnum SET_OPERATORPARTYID = new EventEnum("set operatorPartyId");
/* 35 */   public static final EventEnum SET_POSTVOID = new EventEnum("set postVoid");
/* 36 */   public static final EventEnum SET_CASHDRAWERID = new EventEnum("set cashDrawerId");
/* 37 */   public static final EventEnum SET_FISCALNUMBER = new EventEnum("set fiscalNumber");
/* 38 */   public static final EventEnum SET_OPERATORPARTY = new EventEnum("set OperatorParty");
/* 39 */   public static final EventEnum ADD_RETAILTRANSACTIONLINEITEMS = new EventEnum("add RetailTransactionLineItems");
/* 40 */   public static final EventEnum REMOVE_RETAILTRANSACTIONLINEITEMS = new EventEnum("remove RetailTransactionLineItems");
/* 41 */   public static final EventEnum SET_RETAILTRANSACTIONLINEITEMS = new EventEnum("set RetailTransactionLineItems");
/* 42 */   public static final EventEnum ADD_TRANSACTIONLINKS = new EventEnum("add TransactionLinks");
/* 43 */   public static final EventEnum REMOVE_TRANSACTIONLINKS = new EventEnum("remove TransactionLinks");
/* 44 */   public static final EventEnum SET_TRANSACTIONLINKS = new EventEnum("set TransactionLinks");
/* 45 */   public static final EventEnum ADD_TRANSACTIONNOTES = new EventEnum("add TransactionNotes");
/* 46 */   public static final EventEnum REMOVE_TRANSACTIONNOTES = new EventEnum("remove TransactionNotes");
/* 47 */   public static final EventEnum SET_TRANSACTIONNOTES = new EventEnum("set TransactionNotes");
/* 48 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 49 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 50 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 51 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 52 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 53 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
/*    */   
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
/*    */   
/*    */   String getClassName();
/*    */   
/*    */   void setClassName(String paramString);
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
/*    */   Date getBeginDateTimestamp();
/*    */   
/*    */   void setBeginDateTimestamp(Date paramDate);
/*    */   
/*    */   Date getTransactionDate();
/*    */   
/*    */   void setTransactionDate(Date paramDate);
/*    */   
/*    */   int getBeginTimeInt();
/*    */   
/*    */   void setBeginTimeInt(int paramInt);
/*    */   
/*    */   Date getEndDateTimestamp();
/*    */   
/*    */   void setEndDateTimestamp(Date paramDate);
/*    */   
/*    */   boolean getKeyedOffline();
/*    */   
/*    */   void setKeyedOffline(boolean paramBoolean);
/*    */   
/*    */   boolean getPosted();
/*    */   
/*    */   void setPosted(boolean paramBoolean);
/*    */   
/*    */   long getSessionId();
/*    */   
/*    */   void setSessionId(long paramLong);
/*    */   
/*    */   BigDecimal getSubtotal();
/*    */   
/*    */   void setSubtotal(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getTaxAmount();
/*    */   
/*    */   void setTaxAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getRoundedAmount();
/*    */   
/*    */   void setRoundedAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getTotal();
/*    */   
/*    */   void setTotal(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getTransactionStatusCode();
/*    */   
/*    */   void setTransactionStatusCode(String paramString);
/*    */   
/*    */   String getTransactionTypeCode();
/*    */   
/*    */   void setTransactionTypeCode(String paramString);
/*    */   
/*    */   String getTransactionCancelledReasonCode();
/*    */   
/*    */   void setTransactionCancelledReasonCode(String paramString);
/*    */   
/*    */   boolean getGenericStorage();
/*    */   
/*    */   void setGenericStorage(boolean paramBoolean);
/*    */   
/*    */   long getOperatorPartyId();
/*    */   
/*    */   void setOperatorPartyId(long paramLong);
/*    */   
/*    */   boolean getPostVoid();
/*    */   
/*    */   void setPostVoid(boolean paramBoolean);
/*    */   
/*    */   String getCashDrawerId();
/*    */   
/*    */   void setCashDrawerId(String paramString);
/*    */   
/*    */   String getFiscalNumber();
/*    */   
/*    */   void setFiscalNumber(String paramString);
/*    */   
/*    */   IDataModel getPosTransactionExt();
/*    */   
/*    */   void setPosTransactionExt(IDataModel paramIDataModel);
/*    */   
/*    */   IParty getOperatorParty();
/*    */   
/*    */   void setOperatorParty(IParty paramIParty);
/*    */   
/*    */   List<IRetailTransactionLineItem> getRetailTransactionLineItems();
/*    */   
/*    */   void setRetailTransactionLineItems(List<IRetailTransactionLineItem> paramList);
/*    */   
/*    */   void addRetailTransactionLineItem(IRetailTransactionLineItem paramIRetailTransactionLineItem);
/*    */   
/*    */   void removeRetailTransactionLineItem(IRetailTransactionLineItem paramIRetailTransactionLineItem);
/*    */   
/*    */   List<IPosTransactionLink> getTransactionLinks();
/*    */   
/*    */   void setTransactionLinks(List<IPosTransactionLink> paramList);
/*    */   
/*    */   void addPosTransactionLink(IPosTransactionLink paramIPosTransactionLink);
/*    */   
/*    */   void removePosTransactionLink(IPosTransactionLink paramIPosTransactionLink);
/*    */   
/*    */   List<ITransactionNotes> getTransactionNotes();
/*    */   
/*    */   void setTransactionNotes(List<ITransactionNotes> paramList);
/*    */   
/*    */   void addTransactionNotes(ITransactionNotes paramITransactionNotes);
/*    */   
/*    */   void removeTransactionNotes(ITransactionNotes paramITransactionNotes);
/*    */   
/*    */   List<IPosTransactionProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IPosTransactionProperty> paramList);
/*    */   
/*    */   void addPosTransactionProperty(IPosTransactionProperty paramIPosTransactionProperty);
/*    */   
/*    */   void removePosTransactionProperty(IPosTransactionProperty paramIPosTransactionProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\IPosTransaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */