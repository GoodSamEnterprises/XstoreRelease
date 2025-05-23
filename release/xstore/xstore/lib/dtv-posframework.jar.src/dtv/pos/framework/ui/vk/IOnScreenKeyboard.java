package dtv.pos.framework.ui.vk;

import java.awt.Rectangle;
import java.awt.Window;

public interface IOnScreenKeyboard {
  void addKeyboardListenerImpl(Keyboard.IKeyboardListener paramIKeyboardListener);
  
  Window getKeyboardOwnerImpl();
  
  boolean hideImpl();
  
  boolean isShowingImpl();
  
  void nextLayoutImpl();
  
  void ownerBoundsChangedImpl(Rectangle paramRectangle);
  
  void previousLayoutImpl();
  
  void repaintImpl();
  
  boolean showImpl();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\IOnScreenKeyboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */