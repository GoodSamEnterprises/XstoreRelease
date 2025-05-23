package dtv.xst.dao.xom;

import dtv.xst.dao.loc.IRetailLocation;
import java.math.BigDecimal;

public interface IOrderModel {
  boolean addOrderRefund();
  
  void addOrderRefund(boolean paramBoolean);
  
  boolean completeOrderTransaction();
  
  void completeOrderTransaction(boolean paramBoolean);
  
  BigDecimal getAccumulatedRefund();
  
  BigDecimal getCancelledItemsSubTotalAmt();
  
  BigDecimal getCancelledItemsTotalAmt();
  
  BigDecimal getCancelledItemsTotalRefund();
  
  BigDecimal getCancelledItemsTotalTax();
  
  BigDecimal getFulfilledItemsPayment();
  
  boolean getGroupShipment();
  
  IRetailLocation getOrderLocationObject();
  
  BigDecimal getShippingFeeAmount();
  
  BigDecimal getTotalDeposit();
  
  BigDecimal getTotalPaymentAmount();
  
  boolean hasCancelledItem();
  
  void hasCancelledItem(boolean paramBoolean);
  
  boolean hasFulfilledItemFromOtherStore();
  
  void hasFulfilledItemFromOtherStore(boolean paramBoolean);
  
  boolean isShippingDocumentCreated();
  
  void setAccumulatedRefund(BigDecimal paramBigDecimal);
  
  void setCancelledItemsSubTotalAmt(BigDecimal paramBigDecimal);
  
  void setCancelledItemsTotalAmt(BigDecimal paramBigDecimal);
  
  void setCancelledItemsTotalRefund(BigDecimal paramBigDecimal);
  
  void setCancelledItemsTotalTax(BigDecimal paramBigDecimal);
  
  void setFulfilledItemsPayment(BigDecimal paramBigDecimal);
  
  void setGroupShipment(boolean paramBoolean);
  
  void setShippingDocumentCreated(boolean paramBoolean);
  
  void setTotalDeposit(BigDecimal paramBigDecimal);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\IOrderModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */