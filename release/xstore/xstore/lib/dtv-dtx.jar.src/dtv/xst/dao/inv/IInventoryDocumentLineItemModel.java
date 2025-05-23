package dtv.xst.dao.inv;

import dtv.data2.access.IDataModel;
import dtv.xst.dao.cat.ICustomerItemAccountDetail;
import dtv.xst.dao.itm.IItem;
import dtv.xst.daocommon.IInventoriedLineItem;
import java.math.BigDecimal;

public interface IInventoryDocumentLineItemModel extends IDataModel, IInventoriedLineItem, IHasDocumentId {
  public static final String RECORD_CREATION_TYPE_STORE = "STORE";
  
  void commitTemp();
  
  String getComment();
  
  ICustomerItemAccountDetail getCustItemAcctDetail();
  
  IItem getInventoryItem();
  
  IItem getItem();
  
  String getItemDescription();
  
  String getItemDimensionValue(int paramInt);
  
  String getSerialNumbersString();
  
  BigDecimal getTempPostedCost();
  
  BigDecimal getTempPostedCount();
  
  String getTempStatusCode();
  
  BigDecimal getTempUnitCost();
  
  BigDecimal getTempUnitCount();
  
  void setCustItemAcctDetail(ICustomerItemAccountDetail paramICustomerItemAccountDetail);
  
  void setDimension1(String paramString);
  
  void setDimension2(String paramString);
  
  void setDimension3(String paramString);
  
  void setInventoryItem(IItem paramIItem);
  
  void setItem(IItem paramIItem);
  
  void setOnHandQuantity(BigDecimal paramBigDecimal);
  
  void setStyleId(String paramString);
  
  void setTempPostedCost(BigDecimal paramBigDecimal);
  
  void setTempPostedCount(BigDecimal paramBigDecimal);
  
  void setTempStatusCode(String paramString);
  
  void setTempUnitCost(BigDecimal paramBigDecimal);
  
  void setTempUnitCount(BigDecimal paramBigDecimal);
  
  void startTemp();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryDocumentLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */