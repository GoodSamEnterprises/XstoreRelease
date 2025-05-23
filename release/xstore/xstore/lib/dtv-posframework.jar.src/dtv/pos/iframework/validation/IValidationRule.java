package dtv.pos.iframework.validation;

import dtv.util.config.IConfigObject;
import dtv.util.config.IHasSourceDescription;
import dtv.util.config.ISourceLocationAware;

public interface IValidationRule extends IHasSourceDescription, ISourceLocationAware {
  void setParameter(String paramString, IConfigObject paramIConfigObject);
  
  IValidationResult validate();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\validation\IValidationRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */