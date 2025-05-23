package dtv.pos.iframework.ui;

import dtv.pos.iframework.ui.config.ITouchConfig;
import dtv.util.config.IConfigObject;
import java.awt.event.MouseEvent;

public interface ITouchResponsivenessRule {
  ITouchConfig getParentConfigObject();
  
  boolean isResponsive(MouseEvent paramMouseEvent);
  
  void setParameter(String paramString, IConfigObject paramIConfigObject);
  
  void setParentConfigObject(ITouchConfig paramITouchConfig);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\ITouchResponsivenessRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */