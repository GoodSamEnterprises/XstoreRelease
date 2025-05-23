package dtv.docbuilding;

import dtv.docbuilding.trace.ITracer;
import java.io.Serializable;
import java.util.List;

public interface IDocElement extends Serializable, Cloneable {
  Object clone();
  
  List<? extends Object> getLines();
  
  boolean isTextAppendable();
  
  void trace(ITracer paramITracer);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\IDocElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */