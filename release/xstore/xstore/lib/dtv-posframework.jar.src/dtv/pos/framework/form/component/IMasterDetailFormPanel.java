package dtv.pos.framework.form.component;

import dtv.pos.iframework.form.component.IFormComponent;
import dtv.pos.iframework.ui.IComponentRegistry;
import dtv.ui.model.ISingleSelectionModel;

public interface IMasterDetailFormPanel<T extends dtv.pos.iframework.ui.model.IFormModel> extends IFormComponent<T>, IComponentRegistry {
  public static final String SELECTION_MODEL_PROP = "SELECTION_MODEL_PROP";
  
  void addDetailView(FormPanel<T> paramFormPanel);
  
  FormPanel<T> getSelectedFormPanel();
  
  int getSelectedIndex();
  
  ISingleSelectionModel getSelectionModel();
  
  void setDetailView(FormPanel<T> paramFormPanel);
  
  void setMasterView(FormPanel<T> paramFormPanel);
  
  void setSelectedIndex(int paramInt);
  
  void setSelectionModel(ISingleSelectionModel paramISingleSelectionModel);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\IMasterDetailFormPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */