package dtv.xst.dao.xom;

import dtv.xst.daocommon.ILocationModifier;

public interface IOrderLocationModifier extends ILocationModifier {
  String getOrderId();
  
  void setEmailAddress(String paramString);
  
  void setLocationAddress(IAddressModifier paramIAddressModifier);
  
  void setLocationId(String paramString);
  
  void setLocationName1(String paramString);
  
  void setLocationName2(String paramString);
  
  void setTelephone1(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\IOrderLocationModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */