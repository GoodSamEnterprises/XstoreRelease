package dtv.pos.iframework.op.req;

import dtv.pos.common.FormKey;
import dtv.pos.iframework.form.FormLocationType;

public interface IFormReqHandler extends IOpReqHandler {
  FormLocationType getFormLocationFromConfiguration(FormKey paramFormKey);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\req\IFormReqHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */