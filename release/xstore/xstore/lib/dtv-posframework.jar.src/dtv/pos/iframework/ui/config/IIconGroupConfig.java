package dtv.pos.iframework.ui.config;

import dtv.pos.framework.touch.TouchConfig;
import dtv.util.config.ICascadableConfig;
import dtv.util.config.ISavableConfig;
import dtv.util.config.IconConfig;
import javax.swing.ImageIcon;

public interface IIconGroupConfig extends ICascadableConfig, ISavableConfig {
  ImageIcon getDisabledIcon();
  
  IconConfig getDisabledIconConfig();
  
  ImageIcon getIcon();
  
  IconConfig getIconConfig();
  
  ImageIcon getPressIcon();
  
  IconConfig getPressIconConfig();
  
  ImageIcon getRollIcon();
  
  IconConfig getRollIconConfig();
  
  boolean getScaleConfig();
  
  void setDisabledIcon(IconConfig paramIconConfig);
  
  void setIcon(IconConfig paramIconConfig);
  
  void setPressIcon(IconConfig paramIconConfig);
  
  void setRollIcon(IconConfig paramIconConfig);
  
  void setScaleConfig(boolean paramBoolean);
  
  TouchConfig getTouchConfig();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\config\IIconGroupConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */