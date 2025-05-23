package dtv.pos.iframework.action;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.visibilityrules.ISecuredAccessCheck;
import dtv.pos.iframework.visibilityrules.IVisibilityRule;
import dtv.pos.ui.action.IPosAction;
import dtv.util.config.IHoldsConfigParameters;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Action;

public interface IXstAction extends IPosAction, IXstEvent, ISecuredAccessCheck, IHoldsConfigParameters {
  public static final String VISIBILITY_SETTING = "VisibilitySetting";
  
  void addPostAction(Action paramAction);
  
  void clearPostActions();
  
  IXstActionKey getActionKey();
  
  ActionListener getActionListener();
  
  boolean getDataIsFinal();
  
  String getIconKey();
  
  String getKeywords();
  
  List<IVisibilityRule> getVisibilityRules();
  
  boolean isValid();
  
  void removePostAction(Action paramAction);
  
  void setActionKey(IXstActionKey paramIXstActionKey);
  
  void setActionListener(ActionListener paramActionListener);
  
  void setDataIsFinal(boolean paramBoolean);
  
  void setIconKey(String paramString);
  
  void setKeywords(String paramString);
  
  void setVisibilityRules(List<IVisibilityRule> paramList, boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\action\IXstAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */