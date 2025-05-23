/*    */ package dtv.xst.dao.cwo;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInvoiceLineItem extends IDataModel, IHasDataProperty<IInvoiceLineItemProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_SERVICELOCATIONID = new EventEnum("set serviceLocationId");
/* 11 */   public static final EventEnum SET_INVOICENUMBER = new EventEnum("set invoiceNumber");
/* 12 */   public static final EventEnum SET_INVOICELINEITEMSEQUENCE = new EventEnum("set invoiceLineItemSequence");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_LINEITEMTYPECODE = new EventEnum("set lineItemTypeCode");
/* 18 */   public static final EventEnum SET_AMOUNT = new EventEnum("set amount");
/* 19 */   public static final EventEnum SET_GLACCOUNT = new EventEnum("set glAccount");
/* 20 */   public static final EventEnum SET_CUSTACCOUNTID = new EventEnum("set custAccountId");
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
/*    */   String getServiceLocationId();
/*    */   
/*    */   void setServiceLocationId(String paramString);
/*    */   
/*    */   String getInvoiceNumber();
/*    */   
/*    */   void setInvoiceNumber(String paramString);
/*    */   
/*    */   int getInvoiceLineItemSequence();
/*    */   
/*    */   void setInvoiceLineItemSequence(int paramInt);
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
/*    */   String getLineItemTypeCode();
/*    */   
/*    */   void setLineItemTypeCode(String paramString);
/*    */   
/*    */   BigDecimal getAmount();
/*    */   
/*    */   void setAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getGlAccount();
/*    */   
/*    */   void setGlAccount(String paramString);
/*    */   
/*    */   String getCustAccountId();
/*    */   
/*    */   void setCustAccountId(String paramString);
/*    */   
/*    */   IDataModel getInvoiceLineItemExt();
/*    */   
/*    */   void setInvoiceLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInvoiceLineItemProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInvoiceLineItemProperty> paramList);
/*    */   
/*    */   void addInvoiceLineItemProperty(IInvoiceLineItemProperty paramIInvoiceLineItemProperty);
/*    */   
/*    */   void removeInvoiceLineItemProperty(IInvoiceLineItemProperty paramIInvoiceLineItemProperty);
/*    */   
/*    */   void setParentInvoice(IInvoice paramIInvoice);
/*    */   
/*    */   IInvoice getParentInvoice();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\IInvoiceLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */