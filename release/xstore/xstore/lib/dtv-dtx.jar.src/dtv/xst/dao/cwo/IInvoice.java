/*    */ package dtv.xst.dao.cwo;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInvoice extends IDataModel, IHasDataProperty<IInvoiceProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_SERVICELOCATIONID = new EventEnum("set serviceLocationId");
/* 11 */   public static final EventEnum SET_INVOICENUMBER = new EventEnum("set invoiceNumber");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_INVOICEDATE = new EventEnum("set invoiceDate");
/* 17 */   public static final EventEnum SET_AMOUNTDUE = new EventEnum("set amountDue");
/* 18 */   public static final EventEnum SET_NOTES = new EventEnum("set notes");
/* 19 */   public static final EventEnum SET_INVOICESERVICELOCATION = new EventEnum("set InvoiceServiceLocation");
/* 20 */   public static final EventEnum ADD_LINEITEMS = new EventEnum("add LineItems");
/* 21 */   public static final EventEnum REMOVE_LINEITEMS = new EventEnum("remove LineItems");
/* 22 */   public static final EventEnum SET_LINEITEMS = new EventEnum("set LineItems");
/* 23 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 24 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 25 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 26 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 27 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 28 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   Date getInvoiceDate();
/*    */   
/*    */   void setInvoiceDate(Date paramDate);
/*    */   
/*    */   BigDecimal getAmountDue();
/*    */   
/*    */   void setAmountDue(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getNotes();
/*    */   
/*    */   void setNotes(String paramString);
/*    */   
/*    */   IDataModel getInvoiceExt();
/*    */   
/*    */   void setInvoiceExt(IDataModel paramIDataModel);
/*    */   
/*    */   IServiceLocation getInvoiceServiceLocation();
/*    */   
/*    */   void setInvoiceServiceLocation(IServiceLocation paramIServiceLocation);
/*    */   
/*    */   List<IInvoiceLineItem> getLineItems();
/*    */   
/*    */   void setLineItems(List<IInvoiceLineItem> paramList);
/*    */   
/*    */   void addInvoiceLineItem(IInvoiceLineItem paramIInvoiceLineItem);
/*    */   
/*    */   void removeInvoiceLineItem(IInvoiceLineItem paramIInvoiceLineItem);
/*    */   
/*    */   List<IInvoiceProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInvoiceProperty> paramList);
/*    */   
/*    */   void addInvoiceProperty(IInvoiceProperty paramIInvoiceProperty);
/*    */   
/*    */   void removeInvoiceProperty(IInvoiceProperty paramIInvoiceProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\IInvoice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */