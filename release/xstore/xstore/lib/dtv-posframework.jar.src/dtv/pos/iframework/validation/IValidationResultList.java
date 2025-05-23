package dtv.pos.iframework.validation;

public interface IValidationResultList {
  void add(IValidationResult paramIValidationResult);
  
  void addAll(IValidationResultList paramIValidationResultList);
  
  IValidationResult[] getInvalidResults();
  
  IValidationResult getInvalidResults(int paramInt);
  
  boolean isSecured();
  
  boolean isValid();
  
  int size();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\validation\IValidationResultList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */