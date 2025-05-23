package dtv.pos.iframework.op;

import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.iframework.event.IXstEvent;

public interface IPromptOp extends IOperationImpl, IValidationOp {
  public static final String PARAM_PROMPT_KEY = "PromptKey";
  
  PromptKey getDefaultPromptKey();
  
  IOpResponse getPromptResponse(IXstEvent paramIXstEvent, PromptKey paramPromptKey, IFormattable[] paramArrayOfIFormattable);
  
  IOpResponse handlePromptResponse(IXstEvent paramIXstEvent);
  
  void setPromptKey(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\IPromptOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */