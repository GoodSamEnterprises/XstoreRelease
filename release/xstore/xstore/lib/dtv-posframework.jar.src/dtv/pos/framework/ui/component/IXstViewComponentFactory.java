package dtv.pos.framework.ui.component;

import dtv.pos.framework.form.component.FormPanel;
import dtv.pos.framework.form.component.IMasterDetailFormPanel;
import dtv.pos.framework.form.config.FormLayoutConfig;
import dtv.pos.framework.ui.config.ResolvedFieldConfig;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.form.component.IFormComponent;
import dtv.pos.iframework.form.config.IFormComponentConfig;
import dtv.pos.iframework.ui.IXstViewComponent;
import dtv.pos.iframework.ui.config.IViewComponentConfig;
import dtv.ui.ComponentID;
import dtv.ui.model.ICombinedListModel;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public interface IXstViewComponentFactory {
  XstActionList createActionList();
  
  XstActionList createActionList(ICombinedListModel<Object> paramICombinedListModel);
  
  XstActionList createActionList(ICombinedListModel<Object> paramICombinedListModel, ComponentID paramComponentID);
  
  XstAnchor createAnchor();
  
  XstAppFrame createAppFrame(boolean paramBoolean);
  
  XstButton createButton();
  
  XstButton createButton(ComponentID paramComponentID);
  
  XstButton createButton(IXstAction paramIXstAction);
  
  XstButton createButton(IXstAction paramIXstAction, KeyStroke paramKeyStroke);
  
  XstButton createButton(IXstAction paramIXstAction, KeyStroke paramKeyStroke, ComponentID paramComponentID);
  
  XstButton createButton(KeyStroke paramKeyStroke);
  
  JComponent createComponent(IViewComponentConfig<?> paramIViewComponentConfig, boolean paramBoolean);
  
  JComponent createComponent(IViewComponentConfig<?> paramIViewComponentConfig, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject, boolean paramBoolean);
  
  IFormComponent createFormComponent(IFormComponentConfig<?> paramIFormComponentConfig, boolean paramBoolean);
  
  IFormComponent createFormComponent(ResolvedFieldConfig paramResolvedFieldConfig);
  
  FormPanel createFormPanel(IFormComponentConfig paramIFormComponentConfig, boolean paramBoolean1, boolean paramBoolean2);
  
  FormPanel createFormPanel(ResolvedFieldConfig paramResolvedFieldConfig, String paramString, boolean paramBoolean, ComponentID paramComponentID, List<IXstAction> paramList);
  
  XstLabel createLabel();
  
  XstLabel createLabel(Icon paramIcon);
  
  XstLabel createLabel(String paramString);
  
  XstLabel createLabel(String paramString, Icon paramIcon);
  
  XstList createList();
  
  XstList createList(boolean paramBoolean);
  
  XstList createList(ComponentID paramComponentID);
  
  XstList createList(ICombinedListModel<Object> paramICombinedListModel);
  
  XstList createList(ICombinedListModel<Object> paramICombinedListModel, boolean paramBoolean);
  
  XstLongTextField createLongTextField();
  
  XstMessageArea createMessageArea();
  
  IMasterDetailFormPanel createMultiTabFormPanel(FormLayoutConfig paramFormLayoutConfig, boolean paramBoolean);
  
  XstReadOnlyTextArea createReadOnlyTextArea();
  
  XstTitledInstructionPanel createSecondaryTitledInstructionPanel();
  
  XstTextField createTextField();
  
  XstTitledInstructionPanel createTitledInstructionPanel();
  
  XstTitledInstructionPanel createTitledInstructionPanel(IXstViewComponent paramIXstViewComponent);
  
  XstTitledInstructionPanel createTitledInstructionPanel(JComponent paramJComponent);
  
  XstTitledPanel createTitledPanel();
  
  XstTitledPanel createTitledPanel(IXstViewComponent paramIXstViewComponent);
  
  XstTitledPanel createTitledPanel(JComponent paramJComponent);
  
  XstLabel createWrappingLabel();
  
  XstLabel createWrappingLabel(Icon paramIcon);
  
  XstLabel createWrappingLabel(String paramString);
  
  XstLabel createWrappingLabel(String paramString, Icon paramIcon);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\IXstViewComponentFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */