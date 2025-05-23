package dtv.pos.iframework.ui.config;

import dtv.util.config.ColorConfig;
import dtv.util.config.ICascadableConfig;
import dtv.util.config.IConfigObject;
import dtv.util.config.ISavableConfig;
import java.awt.Color;

public interface IColorGroupConfig extends ICascadableConfig, ISavableConfig, IConfigObject {
  Color getBgColor();
  
  Color getBgColor2();
  
  Color getFgColor();
  
  Color getHighlightColor();
  
  Color getSelectionBgColor();
  
  Color getSelectionBgColor2();
  
  Color getSelectionFgColor();
  
  void setBgColor(Color paramColor);
  
  void setBgColor(ColorConfig paramColorConfig);
  
  void setBgColor2(Color paramColor);
  
  void setBgColor2(ColorConfig paramColorConfig);
  
  void setFgColor(Color paramColor);
  
  void setFgColor(ColorConfig paramColorConfig);
  
  void setHighlightColor(ColorConfig paramColorConfig);
  
  void setSelectionBgColor(ColorConfig paramColorConfig);
  
  void setSelectionBgColor2(ColorConfig paramColorConfig);
  
  void setSelectionFgColor(ColorConfig paramColorConfig);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\config\IColorGroupConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */