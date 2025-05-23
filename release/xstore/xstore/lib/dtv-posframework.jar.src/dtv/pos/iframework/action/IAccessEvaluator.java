package dtv.pos.iframework.action;

import dtv.pos.iframework.visibilityrules.IAccessLevel;

public interface IAccessEvaluator {
  IAccessLevel evaluateAccess(IXstAction paramIXstAction);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\action\IAccessEvaluator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */