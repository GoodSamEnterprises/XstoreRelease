package dtv.pos.iframework.form.config;

import dtv.i18n.IFormattable;
import dtv.pos.iframework.form.component.IFormComponent;
import dtv.pos.iframework.form.design.IHasEquivalence;
import dtv.pos.iframework.ui.config.IViewComponentConfig;
import dtv.util.config.ParameterConfig;
import java.awt.Color;

public interface IFormComponentConfig<C extends IViewComponentConfig> extends IHasEquivalence, IViewComponentConfig<C>, Comparable<IFormComponentConfig<?>> {
  IFormComponent getActiveFormComponent();
  
  Color getBackgroundColor();
  
  Integer getFieldWeight();
  
  Color getForegroundColor();
  
  Integer getHeightObject();
  
  ParameterConfig[] getParameters();
  
  String getResource();
  
  IFormattable getTextKey();
  
  String getType();
  
  IFormattable getValue();
  
  Integer getWidthObject();
  
  boolean isAlwaysEnabled();
  
  boolean isReadOnly();
  
  boolean isRequired();
  
  void setActiveFormComponent(IFormComponent paramIFormComponent);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\config\IFormComponentConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */