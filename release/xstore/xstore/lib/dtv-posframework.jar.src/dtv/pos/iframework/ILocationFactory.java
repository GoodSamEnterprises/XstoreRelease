package dtv.pos.iframework;

import dtv.xst.dao.loc.IRetailLocation;
import dtv.xst.dao.loc.IWorkstation;
import dtv.xst.dao.loc.RetailLocationId;
import dtv.xst.daocommon.IHierarchyElement;
import dtv.xst.daocommon.IHierarchyItem;
import java.util.List;

public interface ILocationFactory {
  void init();
  
  List<? extends IRetailLocation> getAllLocations();
  
  List<? extends IHierarchyElement> getOrganizationHierarchy(IHierarchyItem paramIHierarchyItem);
  
  IHierarchyElement getOrganizationHierarchyNode(long paramLong);
  
  List<? extends IHierarchyElement> getPricingHierarchy(IHierarchyItem paramIHierarchyItem);
  
  IHierarchyElement getPricingHierarchyNode(long paramLong);
  
  IRetailLocation getStoreById(long paramLong);
  
  IRetailLocation getStoreById(RetailLocationId paramRetailLocationId);
  
  List<? extends IWorkstation> getWorkstations(IRetailLocation paramIRetailLocation);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\ILocationFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */