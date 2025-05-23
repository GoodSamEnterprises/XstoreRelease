/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IChargeAccountInvoice extends IDataModel, IChargeAccountInvoiceModel, IHasDataProperty<IChargeAccountInvoiceProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CUSTACCOUNTID = new EventEnum("set custAccountId");
/* 11 */   public static final EventEnum SET_CUSTACCOUNTCODE = new EventEnum("set custAccountCode");
/* 12 */   public static final EventEnum SET_INVOICENUMBER = new EventEnum("set invoiceNumber");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_ORIGINALINVOICEBALANCE = new EventEnum("set originalInvoiceBalance");
/* 18 */   public static final EventEnum SET_INVOICEBALANCE = new EventEnum("set invoiceBalance");
/* 19 */   public static final EventEnum SET_LASTACTIVITYDATE = new EventEnum("set lastActivityDate");
/* 20 */   public static final EventEnum SET_INVOICEDATE = new EventEnum("set invoiceDate");
/* 21 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 22 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 23 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 24 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 25 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 26 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getCustAccountId();
/*    */   
/*    */   void setCustAccountId(String paramString);
/*    */   
/*    */   String getCustAccountCode();
/*    */   
/*    */   void setCustAccountCode(String paramString);
/*    */   
/*    */   String getInvoiceNumber();
/*    */   
/*    */   void setInvoiceNumber(String paramString);
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
/*    */   BigDecimal getOriginalInvoiceBalance();
/*    */   
/*    */   void setOriginalInvoiceBalance(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getInvoiceBalance();
/*    */   
/*    */   void setInvoiceBalance(BigDecimal paramBigDecimal);
/*    */   
/*    */   Date getLastActivityDate();
/*    */   
/*    */   void setLastActivityDate(Date paramDate);
/*    */   
/*    */   Date getInvoiceDate();
/*    */   
/*    */   void setInvoiceDate(Date paramDate);
/*    */   
/*    */   IDataModel getChargeAccountInvoiceExt();
/*    */   
/*    */   void setChargeAccountInvoiceExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IChargeAccountInvoiceProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IChargeAccountInvoiceProperty> paramList);
/*    */   
/*    */   void addChargeAccountInvoiceProperty(IChargeAccountInvoiceProperty paramIChargeAccountInvoiceProperty);
/*    */   
/*    */   void removeChargeAccountInvoiceProperty(IChargeAccountInvoiceProperty paramIChargeAccountInvoiceProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\IChargeAccountInvoice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */