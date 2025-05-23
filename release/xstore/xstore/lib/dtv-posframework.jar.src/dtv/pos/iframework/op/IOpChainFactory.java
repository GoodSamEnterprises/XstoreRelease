package dtv.pos.iframework.op;

import dtv.pos.common.OpChainKey;

public interface IOpChainFactory {
  IOpChain getCancelDeniedChain();
  
  IOpChain getOpChain(OpChainKey paramOpChainKey);
  
  boolean isValidChain(OpChainKey paramOpChainKey);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\IOpChainFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */