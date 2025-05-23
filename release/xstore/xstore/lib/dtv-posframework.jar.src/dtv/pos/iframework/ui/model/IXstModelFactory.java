package dtv.pos.iframework.ui.model;

import dtv.pos.common.FormKey;
import dtv.pos.iframework.form.IListEditModel;
import dtv.pos.iframework.type.ModelKey;
import dtv.ui.model.ICombinedListModel;

public interface IXstModelFactory {
  IFormModel createFormModel(FormKey paramFormKey);
  
  ICombinedListModel<Object> createListModel();
  
  IListEditModel<Object> createListModel(ModelKey<? extends IListEditModel<Object>> paramModelKey);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\model\IXstModelFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */