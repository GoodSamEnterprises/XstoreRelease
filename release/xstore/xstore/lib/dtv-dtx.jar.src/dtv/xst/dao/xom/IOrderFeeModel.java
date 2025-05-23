package dtv.xst.dao.xom;

public interface IOrderFeeModel extends IShadowsSaleItem, IOrderDetail {
  String getTaxType();
  
  void setTaxType(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\IOrderFeeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */