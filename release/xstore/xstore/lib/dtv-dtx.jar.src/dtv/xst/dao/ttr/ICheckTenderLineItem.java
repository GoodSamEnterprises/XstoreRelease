/*    */ package dtv.xst.dao.ttr;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface ICheckTenderLineItem extends IDataModel, ICheckTenderLineItemModel, ITenderLineItem {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_ADJUDICATIONCODE = new EventEnum("set adjudicationCode");
/* 14 */   public static final EventEnum SET_AUTHORIZATIONCODE = new EventEnum("set authorizationCode");
/* 15 */   public static final EventEnum SET_AUTHORIZATIONMETHODCODE = new EventEnum("set authorizationMethodCode");
/* 16 */   public static final EventEnum SET_BANKID = new EventEnum("set bankId");
/* 17 */   public static final EventEnum SET_CHECKACCOUNTNUMBER = new EventEnum("set checkAccountNumber");
/* 18 */   public static final EventEnum SET_CHECKSEQUENCENUMBER = new EventEnum("set checkSequenceNumber");
/* 19 */   public static final EventEnum SET_CUSTOMERBIRTHDATE = new EventEnum("set customerBirthDate");
/* 20 */   public static final EventEnum SET_ENTRYMETHODCODE = new EventEnum("set entryMethodCode");
/* 21 */   public static final EventEnum SET_MICRDATA = new EventEnum("set micrData");
/* 22 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 23 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 24 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getAuthorizationCode();
/*    */   
/*    */   void setAuthorizationCode(String paramString);
/*    */   
/*    */   String getAuthorizationMethodCode();
/*    */   
/*    */   void setAuthorizationMethodCode(String paramString);
/*    */   
/*    */   String getBankId();
/*    */   
/*    */   void setBankId(String paramString);
/*    */   
/*    */   String getCheckAccountNumber();
/*    */   
/*    */   void setCheckAccountNumber(String paramString);
/*    */   
/*    */   String getCheckSequenceNumber();
/*    */   
/*    */   void setCheckSequenceNumber(String paramString);
/*    */   
/*    */   Date getCustomerBirthDate();
/*    */   
/*    */   void setCustomerBirthDate(Date paramDate);
/*    */   
/*    */   String getEntryMethodCode();
/*    */   
/*    */   void setEntryMethodCode(String paramString);
/*    */   
/*    */   String getMicrData();
/*    */   
/*    */   void setMicrData(String paramString);
/*    */   
/*    */   IDataModel getCheckTenderLineItemExt();
/*    */   
/*    */   void setCheckTenderLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\ICheckTenderLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */