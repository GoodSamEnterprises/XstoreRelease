package dtv.pos.framework.location;

import dtv.i18n.IFormattable;
import dtv.util.address.ICountry;

public interface IRegion {
  ICountry[] getCountries();
  
  String getId();
  
  IFormattable getName();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\location\IRegion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */