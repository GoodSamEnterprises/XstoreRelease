package dtv.pos.iframework.op;

import dtv.pos.iframework.event.IXstEvent;

public interface IChangeCountryOp {
  IOpResponse handleAfterChangeCountry(IXstEvent paramIXstEvent);
  
  IOpResponse handleChangeCountry(IXstEvent paramIXstEvent);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\IChangeCountryOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */