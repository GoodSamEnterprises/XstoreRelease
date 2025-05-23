package dtv.pos.framework.ui.listview.config;

import dtv.pos.framework.ui.listview.IViewElement;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.ui.IViewElementType;
import dtv.pos.iframework.ui.config.IUIConfig;
import java.util.List;

public interface IListViewElementConfig extends IUIConfig {
  IXstAction getHiddenButtonAction();
  
  String getIconKey();
  
  IViewElement getRenderer();
  
  List<ListViewRowConfig> getRows();
  
  IViewElementType getType();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\config\IListViewElementConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */