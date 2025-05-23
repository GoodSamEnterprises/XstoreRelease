package dtv.pos.iframework.ui.config;

import dtv.pos.iframework.ui.IViewElementType;
import dtv.pos.iframework.ui.RendererDef;
import dtv.util.config.IConfigObject;
import dtv.util.config.ISavableConfig;

public interface IRendererDefConfig extends IConfigObject, ISavableConfig {
  public static final String ROLE_CELL = "Cell";
  
  public static final String ROLE_ALTERNATE_CELL = "AlternateCell";
  
  public static final String ROLE_ROW_HEADER = "RowHeader";
  
  public static final String ROLE_COLUMN_HEADER = "ColumnHeader";
  
  public static final String ROLE_UPPER_LEFT = "UpperLeft";
  
  String getRole();
  
  String getRuleSet();
  
  IViewElementType getType();
  
  boolean isSimple();
  
  void setRole(String paramString);
  
  void setRuleSet(String paramString);
  
  void setSimple(boolean paramBoolean);
  
  void setType(IViewElementType paramIViewElementType);
  
  RendererDef toRendererDef();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\config\IRendererDefConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */