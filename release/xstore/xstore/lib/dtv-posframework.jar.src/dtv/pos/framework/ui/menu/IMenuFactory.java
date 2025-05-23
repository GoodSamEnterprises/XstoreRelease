package dtv.pos.framework.ui.menu;

import dtv.pos.iframework.ui.IMenuItem;

public interface IMenuFactory {
  IMenuItem getMenu(String paramString);
  
  void init();
  
  boolean isValidMenu(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\menu\IMenuFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */