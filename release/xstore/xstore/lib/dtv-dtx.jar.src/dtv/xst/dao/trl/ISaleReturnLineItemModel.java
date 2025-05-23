package dtv.xst.dao.trl;

import dtv.xst.dao.cat.IChargeAccountInvoice;
import dtv.xst.dao.inv.IInventoryDocumentLineItem;
import dtv.xst.dao.trn.PosTransactionId;
import dtv.xst.daocommon.IInventoriedLineItem;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ISaleReturnLineItemModel extends IRetailTransactionLineItem, IInventoriedLineItem {
  void addRemovedDealId(String paramString);
  
  ISaleReturnLineItem clone();
  
  List<IChargeAccountInvoice> getChargeAccountInvoices();
  
  String getCompositeSaleReturnLineItemTypeCode();
  
  boolean getDisallowDealFlag();
  
  boolean getDiscounted();
  
  Date getExpirationDate();
  
  BigDecimal getExtendedPriceConsiderReturnQty();
  
  IInventoryDocumentLineItem getInventoryDocumentLineItem();
  
  String getItemDescription();
  
  String getItemDimensionValue(int paramInt);
  
  String getLineDescription();
  
  BigDecimal getOriginalBaseUnitPrice();
  
  BigDecimal getOriginalTaxRate();
  
  PosTransactionId getOriginalTransactionObjectId();
  
  BigDecimal getPreDealAmount();
  
  BigDecimal getPrediscountAmount();
  
  boolean getPriceChanged();
  
  BigDecimal getQuantityAvailableForReturn();
  
  List<String> getRemovedDealIds();
  
  List<IRetailPriceModifier> getRetailPriceModifierByTypeCode(String paramString);
  
  BigDecimal getReturnedQuantity();
  
  boolean getReturnedWithGiftReceipt();
  
  String getSaleReturnLineItemTypeTranslated();
  
  boolean getSelectedForPrint();
  
  void setChargeAccountInvoices(List<IChargeAccountInvoice> paramList);
  
  void setDisallowDealFlag(boolean paramBoolean);
  
  void setExpirationDate(Date paramDate);
  
  void setInitialQuantity(BigDecimal paramBigDecimal);
  
  void setInventoryDocumentLineItem(IInventoryDocumentLineItem paramIInventoryDocumentLineItem);
  
  void setOriginalBaseUnitPrice(BigDecimal paramBigDecimal);
  
  void setOriginalTaxRate(BigDecimal paramBigDecimal);
  
  void setPreDealAmount(BigDecimal paramBigDecimal);
  
  void setPrediscountAmount(BigDecimal paramBigDecimal);
  
  void setRemovedDealIds(List<String> paramList);
  
  void setReturnedQuantity(BigDecimal paramBigDecimal);
  
  void setReturnedWithGiftReceipt(boolean paramBoolean);
  
  void setSelectedForPrint(boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\ISaleReturnLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */