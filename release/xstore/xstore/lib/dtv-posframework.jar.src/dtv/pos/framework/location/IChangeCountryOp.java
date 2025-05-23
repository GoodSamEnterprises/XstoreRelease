package dtv.pos.framework.location;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

public interface IChangeCountryOp {
  IOpResponse handleAfterChangeCountry(IXstEvent paramIXstEvent);
  
  IOpResponse handleChangeCountry(IXstEvent paramIXstEvent);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\location\IChangeCountryOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */