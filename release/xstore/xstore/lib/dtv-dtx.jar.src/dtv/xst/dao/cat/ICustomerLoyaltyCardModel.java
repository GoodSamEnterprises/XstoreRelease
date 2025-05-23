package dtv.xst.dao.cat;

public interface ICustomerLoyaltyCardModel extends IHasExpirationDate {
  IAwardAccount getPrimaryAwardAccount();
  
  ICustomerLoyaltyAccount getPrimaryLoyaltyAccount();
  
  boolean isOwned();
  
  void setOwned(boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerLoyaltyCardModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */