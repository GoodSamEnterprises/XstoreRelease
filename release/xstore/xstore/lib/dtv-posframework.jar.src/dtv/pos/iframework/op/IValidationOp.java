package dtv.pos.iframework.op;

import dtv.pos.common.PromptKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.validation.IValidationRule;
import java.util.List;

public interface IValidationOp extends IOperationImpl {
  List<IValidationRule> getValidationRules();
  
  void setValidationRules(List<IValidationRule> paramList);
  
  IOpResponse runValidationCheck(IXstEvent paramIXstEvent, PromptKey paramPromptKey);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\IValidationOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */