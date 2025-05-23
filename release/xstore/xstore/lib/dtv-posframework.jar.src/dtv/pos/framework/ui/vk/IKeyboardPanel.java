package dtv.pos.framework.ui.vk;

import java.awt.AWTEvent;
import java.util.List;

public interface IKeyboardPanel extends IIsSlidingComponent {
  void dispatchEvent(AWTEvent paramAWTEvent);
  
  List<IKeyboardButtonPanel> getButtonPanels();
  
  Object getValue(String paramString);
  
  void repaint();
  
  void setValue(String paramString, Object paramObject);
  
  void setVisible(boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\IKeyboardPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */