/*    */ package dtv.xst.dao.tsn;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.crm.IParty;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface ITenderControlTransaction extends IDataModel, ITenderControlTransactionModel, IPosTransaction {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_AMOUNT = new EventEnum("set amount");
/* 14 */   public static final EventEnum SET_DEPOSITDATE = new EventEnum("set depositDate");
/* 15 */   public static final EventEnum SET_TYPECODE = new EventEnum("set typeCode");
/* 16 */   public static final EventEnum SET_FUNDSRECEIPTPARTYID = new EventEnum("set fundsReceiptPartyId");
/* 17 */   public static final EventEnum SET_INBOUNDSESSIONID = new EventEnum("set inboundSessionId");
/* 18 */   public static final EventEnum SET_INBOUNDTENDERREPOSITORYID = new EventEnum("set inboundTenderRepositoryId");
/* 19 */   public static final EventEnum SET_OUTBOUNDSESSIONID = new EventEnum("set outboundSessionId");
/* 20 */   public static final EventEnum SET_OUTBOUNDTENDERREPOSITORYID = new EventEnum("set outboundTenderRepositoryId");
/* 21 */   public static final EventEnum SET_REASONCODE = new EventEnum("set reasonCode");
/* 22 */   public static final EventEnum SET_SAFEBAGID = new EventEnum("set safeBagId");
/* 23 */   public static final EventEnum SET_FUNDSRECEIPTPARTY = new EventEnum("set FundsReceiptParty");
/* 24 */   public static final EventEnum SET_INBOUNDSESSION = new EventEnum("set InboundSession");
/* 25 */   public static final EventEnum SET_INBOUNDTENDERREPOSITORY = new EventEnum("set InboundTenderRepository");
/* 26 */   public static final EventEnum SET_OUTBOUNDSESSION = new EventEnum("set OutboundSession");
/* 27 */   public static final EventEnum SET_OUTBOUNDTENDERREPOSITORY = new EventEnum("set OutboundTenderRepository");
/* 28 */   public static final EventEnum SET_REASONCODEOBJECT = new EventEnum("set ReasonCodeObject");
/* 29 */   public static final EventEnum ADD_TENDERTYPECOUNTS = new EventEnum("add TenderTypeCounts");
/* 30 */   public static final EventEnum REMOVE_TENDERTYPECOUNTS = new EventEnum("remove TenderTypeCounts");
/* 31 */   public static final EventEnum SET_TENDERTYPECOUNTS = new EventEnum("set TenderTypeCounts");
/* 32 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 33 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 34 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   BigDecimal getAmount();
/*    */   
/*    */   void setAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   Date getDepositDate();
/*    */   
/*    */   void setDepositDate(Date paramDate);
/*    */   
/*    */   String getTypeCode();
/*    */   
/*    */   void setTypeCode(String paramString);
/*    */   
/*    */   long getFundsReceiptPartyId();
/*    */   
/*    */   void setFundsReceiptPartyId(long paramLong);
/*    */   
/*    */   long getInboundSessionId();
/*    */   
/*    */   void setInboundSessionId(long paramLong);
/*    */   
/*    */   String getInboundTenderRepositoryId();
/*    */   
/*    */   void setInboundTenderRepositoryId(String paramString);
/*    */   
/*    */   long getOutboundSessionId();
/*    */   
/*    */   void setOutboundSessionId(long paramLong);
/*    */   
/*    */   String getOutboundTenderRepositoryId();
/*    */   
/*    */   void setOutboundTenderRepositoryId(String paramString);
/*    */   
/*    */   String getReasonCode();
/*    */   
/*    */   void setReasonCode(String paramString);
/*    */   
/*    */   String getSafeBagId();
/*    */   
/*    */   void setSafeBagId(String paramString);
/*    */   
/*    */   IDataModel getTenderControlTransactionExt();
/*    */   
/*    */   void setTenderControlTransactionExt(IDataModel paramIDataModel);
/*    */   
/*    */   IParty getFundsReceiptParty();
/*    */   
/*    */   void setFundsReceiptParty(IParty paramIParty);
/*    */   
/*    */   ISession getInboundSession();
/*    */   
/*    */   void setInboundSession(ISession paramISession);
/*    */   
/*    */   ITenderRepository getInboundTenderRepository();
/*    */   
/*    */   void setInboundTenderRepository(ITenderRepository paramITenderRepository);
/*    */   
/*    */   ISession getOutboundSession();
/*    */   
/*    */   void setOutboundSession(ISession paramISession);
/*    */   
/*    */   ITenderRepository getOutboundTenderRepository();
/*    */   
/*    */   void setOutboundTenderRepository(ITenderRepository paramITenderRepository);
/*    */   
/*    */   IReasonCode getReasonCodeObject();
/*    */   
/*    */   void setReasonCodeObject(IReasonCode paramIReasonCode);
/*    */   
/*    */   List<ITenderTypeCount> getTenderTypeCounts();
/*    */   
/*    */   void setTenderTypeCounts(List<ITenderTypeCount> paramList);
/*    */   
/*    */   void addTenderTypeCount(ITenderTypeCount paramITenderTypeCount);
/*    */   
/*    */   void removeTenderTypeCount(ITenderTypeCount paramITenderTypeCount);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\ITenderControlTransaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */