package dtv.pos.iframework.action;

import javax.swing.KeyStroke;

public interface IXstKeyStroke extends IXstActionKey {
  String getDisplayText();
  
  KeyStroke getKeyStroke();
  
  String getName();
  
  void setDisplayText(String paramString);
  
  void setKeyStroke(KeyStroke paramKeyStroke);
  
  String toString();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\action\IXstKeyStroke.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */