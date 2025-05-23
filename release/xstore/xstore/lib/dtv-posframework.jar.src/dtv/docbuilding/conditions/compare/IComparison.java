package dtv.docbuilding.conditions.compare;

import dtv.util.IHasParameters;
import dtv.util.config.IHasSourceDescription;

public interface IComparison extends IHasParameters, IHasSourceDescription {
  boolean compare(Object[] paramArrayOfObject);
  
  void setSourceDescription(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\conditions\compare\IComparison.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */