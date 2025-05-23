package dtv.pos.framework.form.design;

import java.io.IOException;
import javax.swing.JMenu;
import javax.swing.JPanel;

public interface IFormDesigner {
  JPanel getDesignerPanel();
  
  JMenu[] getMenus();
  
  boolean isDirty();
  
  void save() throws IOException;
  
  void setDividerLocation(int paramInt);
  
  void setPermission(FormDesignerPermission paramFormDesignerPermission, boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\IFormDesigner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */