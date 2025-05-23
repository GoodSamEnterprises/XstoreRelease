package dtv.pos.iframework.ui;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.WindowListener;

public interface IXstAppFrame extends IXstViewComponent {
  void add(Component paramComponent, String paramString);
  
  void addWindowListener(WindowListener paramWindowListener);
  
  Window getFrameComponent();
  
  void show(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\IXstAppFrame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */