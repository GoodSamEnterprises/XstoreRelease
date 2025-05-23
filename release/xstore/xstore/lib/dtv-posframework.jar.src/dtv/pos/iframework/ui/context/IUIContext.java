package dtv.pos.iframework.ui.context;

import dtv.i18n.IFormattable;
import dtv.pos.iframework.type.ModelKey;
import dtv.util.MutableString;
import java.awt.Color;

public interface IUIContext {
  Color getBackgroundColor();
  
  Color getBackgroundColor2();
  
  IComponentState[] getComponentStates();
  
  Color getForegroundColor();
  
  IFormattable getHelpKey();
  
  Color getHighlightColor();
  
  ModelKey getListModelKey();
  
  String getMenuKey();
  
  String getName();
  
  MutableString getText1();
  
  MutableString getText2();
  
  MutableString getTitle();
  
  void setBackgroundColor(Color paramColor);
  
  void setBackgroundColor2(Color paramColor);
  
  void setComponentStates(IComponentState[] paramArrayOfIComponentState);
  
  void setForegroundColor(Color paramColor);
  
  void setHighlightColor(Color paramColor);
  
  void setListModelKey(ModelKey paramModelKey);
  
  void setMenuKey(String paramString);
  
  void setText1(IFormattable paramIFormattable);
  
  void setText2(IFormattable paramIFormattable);
  
  void setTitle(IFormattable paramIFormattable);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\context\IUIContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */