package dtv.docbuilding;

import java.io.IOException;
import java.io.Serializable;

public interface IPosDocument extends Serializable {
  void appendElement(IDocElement paramIDocElement) throws IOException;
  
  void appendElements(IDocElement[] paramArrayOfIDocElement) throws IOException;
  
  IDocElement[] getElements();
  
  boolean isReadable();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\IPosDocument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */