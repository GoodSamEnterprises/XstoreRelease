/*    */ package dtv.xst.dao.xom;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IOrder extends IDataModel, IOrderModel, IHasDataProperty<IOrderProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_ORDERID = new EventEnum("set orderId");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_ORDERTYPE = new EventEnum("set orderType");
/* 16 */   public static final EventEnum SET_STATUSCODE = new EventEnum("set statusCode");
/* 17 */   public static final EventEnum SET_ORDERDATE = new EventEnum("set orderDate");
/* 18 */   public static final EventEnum SET_ORDERLOCATIONID = new EventEnum("set orderLocationId");
/* 19 */   public static final EventEnum SET_SUBTOTAL = new EventEnum("set subtotal");
/* 20 */   public static final EventEnum SET_TAXAMOUNT = new EventEnum("set taxAmount");
/* 21 */   public static final EventEnum SET_TOTAL = new EventEnum("set total");
/* 22 */   public static final EventEnum SET_BALANCEDUE = new EventEnum("set balanceDue");
/* 23 */   public static final EventEnum SET_NOTES = new EventEnum("set notes");
/* 24 */   public static final EventEnum SET_REFERENCENUMBER = new EventEnum("set referenceNumber");
/* 25 */   public static final EventEnum SET_ADDITIONALFREIGHTCHARGES = new EventEnum("set additionalFreightCharges");
/* 26 */   public static final EventEnum SET_ADDITIONALCHARGES = new EventEnum("set additionalCharges");
/* 27 */   public static final EventEnum SET_SHIPCOMPLETE = new EventEnum("set shipComplete");
/* 28 */   public static final EventEnum SET_FREIGHTTAX = new EventEnum("set freightTax");
/* 29 */   public static final EventEnum SET_ORDERMESSAGE = new EventEnum("set orderMessage");
/* 30 */   public static final EventEnum SET_GIFTMESSAGE = new EventEnum("set giftMessage");
/* 31 */   public static final EventEnum SET_UNDERREVIEW = new EventEnum("set underReview");
/* 32 */   public static final EventEnum SET_STATUSCODEREASON = new EventEnum("set statusCodeReason");
/* 33 */   public static final EventEnum SET_STATUSCODEREASONNOTE = new EventEnum("set statusCodeReasonNote");
/* 34 */   public static final EventEnum SET_CUSTOMER = new EventEnum("set Customer");
/* 35 */   public static final EventEnum ADD_PAYMENTS = new EventEnum("add Payments");
/* 36 */   public static final EventEnum REMOVE_PAYMENTS = new EventEnum("remove Payments");
/* 37 */   public static final EventEnum SET_PAYMENTS = new EventEnum("set Payments");
/* 38 */   public static final EventEnum ADD_FEES = new EventEnum("add Fees");
/* 39 */   public static final EventEnum REMOVE_FEES = new EventEnum("remove Fees");
/* 40 */   public static final EventEnum SET_FEES = new EventEnum("set Fees");
/* 41 */   public static final EventEnum ADD_ORDERLINES = new EventEnum("add OrderLines");
/* 42 */   public static final EventEnum REMOVE_ORDERLINES = new EventEnum("remove OrderLines");
/* 43 */   public static final EventEnum SET_ORDERLINES = new EventEnum("set OrderLines");
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
/*    */   String getOrderId();
/*    */   
/*    */   void setOrderId(String paramString);
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
/*    */   String getOrderType();
/*    */   
/*    */   void setOrderType(String paramString);
/*    */   
/*    */   String getStatusCode();
/*    */   
/*    */   void setStatusCode(String paramString);
/*    */   
/*    */   Date getOrderDate();
/*    */   
/*    */   void setOrderDate(Date paramDate);
/*    */   
/*    */   String getOrderLocationId();
/*    */   
/*    */   void setOrderLocationId(String paramString);
/*    */   
/*    */   BigDecimal getSubtotal();
/*    */   
/*    */   void setSubtotal(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getTaxAmount();
/*    */   
/*    */   void setTaxAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getTotal();
/*    */   
/*    */   void setTotal(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getBalanceDue();
/*    */   
/*    */   void setBalanceDue(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getNotes();
/*    */   
/*    */   void setNotes(String paramString);
/*    */   
/*    */   String getReferenceNumber();
/*    */   
/*    */   void setReferenceNumber(String paramString);
/*    */   
/*    */   BigDecimal getAdditionalFreightCharges();
/*    */   
/*    */   void setAdditionalFreightCharges(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getAdditionalCharges();
/*    */   
/*    */   void setAdditionalCharges(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getShipComplete();
/*    */   
/*    */   void setShipComplete(boolean paramBoolean);
/*    */   
/*    */   BigDecimal getFreightTax();
/*    */   
/*    */   void setFreightTax(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getOrderMessage();
/*    */   
/*    */   void setOrderMessage(String paramString);
/*    */   
/*    */   String getGiftMessage();
/*    */   
/*    */   void setGiftMessage(String paramString);
/*    */   
/*    */   boolean getUnderReview();
/*    */   
/*    */   void setUnderReview(boolean paramBoolean);
/*    */   
/*    */   String getStatusCodeReason();
/*    */   
/*    */   void setStatusCodeReason(String paramString);
/*    */   
/*    */   String getStatusCodeReasonNote();
/*    */   
/*    */   void setStatusCodeReasonNote(String paramString);
/*    */   
/*    */   IDataModel getOrderExt();
/*    */   
/*    */   void setOrderExt(IDataModel paramIDataModel);
/*    */   
/*    */   ICustomerModifier getCustomer();
/*    */   
/*    */   void setCustomer(ICustomerModifier paramICustomerModifier);
/*    */   
/*    */   List<IOrderPayment> getPayments();
/*    */   
/*    */   void setPayments(List<IOrderPayment> paramList);
/*    */   
/*    */   void addOrderPayment(IOrderPayment paramIOrderPayment);
/*    */   
/*    */   void removeOrderPayment(IOrderPayment paramIOrderPayment);
/*    */   
/*    */   List<IOrderFee> getFees();
/*    */   
/*    */   void setFees(List<IOrderFee> paramList);
/*    */   
/*    */   void addOrderFee(IOrderFee paramIOrderFee);
/*    */   
/*    */   void removeOrderFee(IOrderFee paramIOrderFee);
/*    */   
/*    */   List<IOrderLine> getOrderLines();
/*    */   
/*    */   void setOrderLines(List<IOrderLine> paramList);
/*    */   
/*    */   void addOrderLine(IOrderLine paramIOrderLine);
/*    */   
/*    */   void removeOrderLine(IOrderLine paramIOrderLine);
/*    */   
/*    */   List<IOrderProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IOrderProperty> paramList);
/*    */   
/*    */   void addOrderProperty(IOrderProperty paramIOrderProperty);
/*    */   
/*    */   void removeOrderProperty(IOrderProperty paramIOrderProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\IOrder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */