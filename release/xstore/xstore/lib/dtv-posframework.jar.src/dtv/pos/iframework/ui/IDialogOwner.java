package dtv.pos.iframework.ui;

import dtv.ui.action.IDtvAction;
import java.util.Collection;
import javax.swing.KeyStroke;

public interface IDialogOwner {
  IDtvAction getDialogCloseAction();
  
  IDtvAction getDialogCloseAction(String paramString, KeyStroke paramKeyStroke);
  
  void handleDialogClose();
  
  void hideDialog();
  
  void showDialog(IXstViewComponent paramIXstViewComponent, String paramString, Collection<IDtvAction> paramCollection, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\IDialogOwner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */