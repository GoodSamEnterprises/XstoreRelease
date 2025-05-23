package dtv.pos.iframework.ui.model;

import dtv.i18n.IFormattable;
import dtv.pos.common.FormKey;
import dtv.pos.iframework.action.DataActionGroupKey;
import dtv.pos.iframework.form.IEditModel;
import dtv.ui.model.ISingleSelectionModel;

public interface IFormModel extends IUIInputModel {
  DataActionGroupKey getActionGroupKey();
  
  String getActionGroupSubKey();
  
  IEditModel getEditModel();
  
  IFormattable getFormInstructions();
  
  FormKey getFormKey();
  
  IFormattable getFormName();
  
  String getSelectedTabKeyName();
  
  ISingleSelectionModel getSelectionModel();
  
  boolean isEditable();
  
  boolean isEditable(String paramString);
  
  boolean isRequired(String paramString);
  
  void setActionGroupSubKey(String paramString);
  
  void setSelectionModel(ISingleSelectionModel paramISingleSelectionModel);
  
  void setValues(IEditModel paramIEditModel, DataActionGroupKey paramDataActionGroupKey, boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\model\IFormModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */