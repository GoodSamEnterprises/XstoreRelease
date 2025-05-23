/*    */ package dtv.xst.dao.tsn;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.com.IReasonCode;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITillControlTransaction extends IDataModel, IPosTransaction {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_TYPECODE = new EventEnum("set typeCode");
/* 14 */   public static final EventEnum SET_EMPLOYEEID = new EventEnum("set employeeId");
/* 15 */   public static final EventEnum SET_REASONCODE = new EventEnum("set reasonCode");
/* 16 */   public static final EventEnum ADD_TILLCONTROLTRANSACTIONDETAILS = new EventEnum("add TillControlTransactionDetails");
/* 17 */   public static final EventEnum REMOVE_TILLCONTROLTRANSACTIONDETAILS = new EventEnum("remove TillControlTransactionDetails");
/* 18 */   public static final EventEnum SET_TILLCONTROLTRANSACTIONDETAILS = new EventEnum("set TillControlTransactionDetails");
/* 19 */   public static final EventEnum SET_REASONCODEOBJECT = new EventEnum("set ReasonCodeObject");
/* 20 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 21 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 22 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getTypeCode();
/*    */   
/*    */   void setTypeCode(String paramString);
/*    */   
/*    */   String getEmployeeId();
/*    */   
/*    */   void setEmployeeId(String paramString);
/*    */   
/*    */   String getReasonCode();
/*    */   
/*    */   void setReasonCode(String paramString);
/*    */   
/*    */   IDataModel getTillControlTransactionExt();
/*    */   
/*    */   void setTillControlTransactionExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ITillControlTransactionDetail> getTillControlTransactionDetails();
/*    */   
/*    */   void setTillControlTransactionDetails(List<ITillControlTransactionDetail> paramList);
/*    */   
/*    */   void addTillControlTransactionDetail(ITillControlTransactionDetail paramITillControlTransactionDetail);
/*    */   
/*    */   void removeTillControlTransactionDetail(ITillControlTransactionDetail paramITillControlTransactionDetail);
/*    */   
/*    */   IReasonCode getReasonCodeObject();
/*    */   
/*    */   void setReasonCodeObject(IReasonCode paramIReasonCode);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\ITillControlTransaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */