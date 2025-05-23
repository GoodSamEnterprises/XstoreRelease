package dtv.docbuilding;

import dtv.docbuilding.trace.ITracer;
import dtv.util.config.IHasSourceDescription;
import java.io.IOException;

public interface IDocBuilderSectionMember extends IHasSourceDescription {
  void buildDoc(IPosDocument paramIPosDocument, Object paramObject, IDocElementFactory paramIDocElementFactory) throws IOException;
  
  void setSourceDescription(String paramString);
  
  void trace(ITracer paramITracer);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\IDocBuilderSectionMember.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */