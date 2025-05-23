package dtv.pos.iframework.ui.config;

public interface IUIConfig {
  IColorGroupConfig getColorGroupConfig();
  
  IFontConfig getFontConfig();
  
  int getHeight();
  
  IIconGroupConfig getIconGroupConfig();
  
  int getWidth();
  
  void setColorGroupConfig(IColorGroupConfig paramIColorGroupConfig);
  
  void setFontConfig(IFontConfig paramIFontConfig);
  
  void setHeight(Integer paramInteger);
  
  void setIconGroupConfig(IIconGroupConfig paramIIconGroupConfig);
  
  void setWidth(Integer paramInteger);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\config\IUIConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */