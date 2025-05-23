package dtv.pos.iframework.op;

public interface IOperationImpl extends IOperation {
  OpApplicability getApplicabilityState();
  
  void setApplicabilityState(OpApplicability paramOpApplicability);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\IOperationImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */