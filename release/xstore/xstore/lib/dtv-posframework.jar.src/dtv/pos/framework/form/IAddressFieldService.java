package dtv.pos.framework.form;

import dtv.pos.iframework.form.IEditModel;
import dtv.pos.iframework.form.IFieldService;
import dtv.util.address.IAddressServiceListener;

public interface IAddressFieldService extends IFieldService, IAddressServiceListener {
  void registerModel(IEditModel paramIEditModel, IHasAddressFields paramIHasAddressFields);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\IAddressFieldService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */