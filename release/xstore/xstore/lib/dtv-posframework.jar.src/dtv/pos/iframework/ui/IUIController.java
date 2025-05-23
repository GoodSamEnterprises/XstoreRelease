package dtv.pos.iframework.ui;

import dtv.pos.common.FormKey;
import dtv.pos.framework.event.KeyActionPair;
import dtv.pos.iframework.IModeController;
import dtv.pos.iframework.action.IActionOwner;
import dtv.pos.iframework.event.IXstEventListener;
import dtv.pos.iframework.form.FormLocationType;
import dtv.pos.iframework.ui.context.IUIContextDescriptor;
import java.awt.Component;
import java.util.Collection;
import javax.swing.JComponent;

public interface IUIController extends IComponentRegistry, IDialogOwner {
  Component createUI(String paramString);
  
  void enableTransitions(boolean paramBoolean);
  
  Component getFocusableChildComponent(String paramString);
  
  JComponent getFormView(FormKey paramFormKey, FormLocationType paramFormLocationType);
  
  Object getProperty(String paramString);
  
  void handleContextTransition(IUIContextDescriptor paramIUIContextDescriptor, Object paramObject);
  
  void hideHelpView();
  
  void hidePopupView();
  
  void hideUI();
  
  void initialize();
  
  boolean isInputRestrictedToMenu();
  
  boolean isPopupShowing();
  
  Object putProperty(String paramString, Object paramObject);
  
  void registerKeyActions(Collection<? extends KeyActionPair> paramCollection, IActionOwner paramIActionOwner, Component... paramVarArgs);
  
  void setModeController(IModeController paramIModeController);
  
  void showFocusBar();
  
  JComponent showFormView(FormKey paramFormKey, FormLocationType paramFormLocationType, boolean paramBoolean);
  
  void showHelpView(IXstEventListener paramIXstEventListener);
  
  void showPopupIconMenu();
  
  void showPopupList(boolean paramBoolean);
  
  void showPopupLongText();
  
  void showPopupMenu();
  
  void showPopupNotify();
  
  void showPopupView(boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\IUIController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */