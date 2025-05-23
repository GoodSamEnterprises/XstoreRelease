package dtv.pos.iframework.ui;

import dtv.pos.iframework.action.IXstAction;
import dtv.util.MutableString;
import dtv.util.config.IHasSourceDescription;
import java.util.List;

public interface IMenuItem extends IHasSourceDescription {
  IXstAction getAction();
  
  ActionDisplayType getActionDisplayType();
  
  List<IMenuItem> getChildren();
  
  String getKeywords();
  
  MutableString getMenuDescription();
  
  String getMenuKey();
  
  MutableString getMenuTitle();
  
  IMenuItem getParent();
  
  MutableString getRootTitle();
  
  void initialize();
  
  boolean isBreadCrumbDisabled();
  
  boolean isSticky();
  
  void setParent(IMenuItem paramIMenuItem);
  
  void setSticky(boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\IMenuItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */