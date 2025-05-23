package dtv.xst.dao.xom;

import dtv.xst.daocommon.ILocationModifier;

public interface IExtendedLocationModifier extends ILocationModifier {
  String getMiddleName();
  
  String getOrganizationName();
  
  String getSalutation();
  
  String getSuffix();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\IExtendedLocationModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */