package dtv.xst.dao.cat;

import java.math.BigDecimal;

public interface ICustomerConsumerChargeAccountModel extends ICustomerAccount {
  String getAccountName();
  
  BigDecimal getAvailableCredit();
  
  BigDecimal getCreditLimit();
  
  IChargeAccountHistory getLastPaymentAccountHistory();
  
  String getOrganizationName();
  
  void setAccountName(String paramString);
  
  void setAvailableCredit(BigDecimal paramBigDecimal);
  
  void updateAccountBalance();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerConsumerChargeAccountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */