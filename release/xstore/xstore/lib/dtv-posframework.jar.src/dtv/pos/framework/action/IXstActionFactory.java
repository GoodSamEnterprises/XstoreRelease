package dtv.pos.framework.action;

import com.micros.xstore.config.common.Action;
import dtv.pos.common.OpChainKey;
import dtv.pos.framework.event.KeyActionPair;
import dtv.pos.iframework.action.DataActionGroupKey;
import dtv.pos.iframework.action.FormTabKey;
import dtv.pos.iframework.action.IFormNavigationAction;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstChainAction;
import dtv.pos.iframework.action.IXstChainActionType;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.action.IXstDataActionKey;
import dtv.pos.iframework.action.IXstKeyStroke;
import dtv.pos.iframework.action.IXstKeyStrokeAction;
import dtv.pos.iframework.action.IXstMenuAction;
import java.awt.event.ActionEvent;
import java.util.Collection;

public interface IXstActionFactory {
  IXstAction getAction(String paramString);
  
  IFormNavigationAction getFormNavigationAction(DataActionGroupKey paramDataActionGroupKey, FormTabKey paramFormTabKey);
  
  IXstAction getAction(DataActionGroupKey paramDataActionGroupKey, Action paramAction);
  
  IXstChainAction getChainAction(OpChainKey paramOpChainKey, IXstChainActionType paramIXstChainActionType);
  
  IXstDataAction getDataAction(IXstDataActionKey paramIXstDataActionKey);
  
  IXstAction getEmptyAction();
  
  IXstAction getHelpAction();
  
  IXstKeyStrokeAction getKeyStrokeAction(IXstKeyStroke paramIXstKeyStroke);
  
  IXstMenuAction getMenuAction(ActionEvent paramActionEvent);
  
  IXstAction getMoreAction();
  
  IXstKeyStrokeAction getScrollDownAction();
  
  Collection<? extends KeyActionPair> getScrollKeyActions();
  
  IXstKeyStrokeAction getScrollUpAction();
  
  void init();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\IXstActionFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */