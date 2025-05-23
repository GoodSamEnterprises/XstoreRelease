package dtv.data2;

import dtv.util.CompositeObject;
import java.util.List;

public interface IPersistenceDefaults {
  String getCurrencyId();
  
  Long getOrganizationId();
  
  List<CompositeObject.TwoPiece<String, String>> getOrgHierarchyAncestry();
  
  Integer getRetailLocationId();
  
  String getUserId();
  
  Long getWorkstationId();
  
  boolean isTraining();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\IPersistenceDefaults.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */