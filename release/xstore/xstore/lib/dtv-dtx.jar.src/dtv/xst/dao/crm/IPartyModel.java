package dtv.xst.dao.crm;

import dtv.util.IName;
import dtv.xst.dao.cat.ICustomerLoyaltyCard;
import dtv.xst.dao.hrs.EmployeeId;
import dtv.xst.dao.prc.DealId;
import java.util.Collection;
import java.util.List;

public interface IPartyModel extends IName {
  public static final String MASKED_SSN_PROPERTY = "MASKED_SSN_PROPERTY";
  
  String getMaskedSocialSecurityNbr();
  
  void setMaskedSocialSecuityNbr(String paramString);
  
  void addSegment(IPartySegment paramIPartySegment);
  
  void addTargetedDeal(DealId paramDealId);
  
  String getAlternatePartyId(String paramString);
  
  String getCustomerPropertyValue(String paramString);
  
  String getEmailAddress();
  
  boolean getEmailContact();
  
  EmployeeId getEmployeeIdObject();
  
  boolean getMailingList();
  
  IPartyEmail getPrimaryEmailInformation();
  
  IPartyLocaleInformation getPrimaryLocaleInformation();
  
  ICustomerLoyaltyCard getPrimaryLoyaltyCard();
  
  IPartyTelephone getPrimaryTelephoneInformation();
  
  boolean getPromptedForLoyalty();
  
  boolean getPromptedForLoyaltyExpiration();
  
  String getSecurityPrivilege();
  
  List<? extends IPartySegment> getSegments();
  
  Collection<? extends DealId> getTargetedDeals();
  
  String getTelephone1();
  
  boolean getTelephone1Contact();
  
  String getTelephone2();
  
  boolean getTelephone2Contact();
  
  String getTelephone3();
  
  boolean getTelephone3Contact();
  
  String getTelephone4();
  
  boolean getTelephone4Contact();
  
  IPartyTelephone getTelephoneInformation(int paramInt);
  
  IPartyTelephone getTelephoneInformation(String paramString, boolean paramBoolean);
  
  void removeSegment(IPartySegment paramIPartySegment);
  
  void removeTargetedDeal(DealId paramDealId);
  
  IPartyIdCrossReference setAlternatePartyId(String paramString1, String paramString2);
  
  void setCustomerPropertyValue(String paramString1, String paramString2);
  
  void setEmailAddress(String paramString);
  
  void setEmailContact(boolean paramBoolean);
  
  void setMailingList(boolean paramBoolean);
  
  void setPromptedForLoyalty(boolean paramBoolean);
  
  void setPromptedForLoyaltyExpiration(boolean paramBoolean);
  
  void setSecurityPrivilege(String paramString);
  
  void setSegments(List<? extends IPartySegment> paramList);
  
  void setTargetedDeals(Collection<? extends DealId> paramCollection);
  
  void setTelephone1(String paramString);
  
  void setTelephone1Contact(boolean paramBoolean);
  
  void setTelephone2(String paramString);
  
  void setTelephone2Contact(boolean paramBoolean);
  
  void setTelephone3(String paramString);
  
  void setTelephone3Contact(boolean paramBoolean);
  
  void setTelephone4(String paramString);
  
  void setTelephone4Contact(boolean paramBoolean);
  
  void setTelephoneContact(String paramString, boolean paramBoolean);
  
  void setTelephoneNumber(String paramString1, String paramString2);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\IPartyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */