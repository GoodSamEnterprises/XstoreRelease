package dtv.pos.framework.ui.vk;

import java.util.List;

public interface IKeyboardButtonPanel extends IKeyboardPanel {
  List<KeyboardButton> getButtons();
  
  List<KeyboardButton> getModifiables();
  
  List<KeyboardButton> getModifiers();
  
  void loadButtons();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\IKeyboardButtonPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */