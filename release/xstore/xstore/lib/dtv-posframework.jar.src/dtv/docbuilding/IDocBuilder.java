package dtv.docbuilding;

import dtv.docbuilding.trace.ITracer;
import java.io.IOException;

public interface IDocBuilder<T extends dtv.util.CompositeObject> {
  void addSection(DocSectionRef paramDocSectionRef);
  
  <D extends IPosDocument> D build(D paramD, Object paramObject, IDocElementFactory paramIDocElementFactory) throws IOException;
  
  T getDocType();
  
  String getLocale();
  
  IPrinterTargetInfo getPrinterTargetInfo();
  
  boolean isEmailDoc();
  
  void setEmailDoc(boolean paramBoolean);
  
  void setLocale(String paramString);
  
  void setPrinterTargetInfo(IPrinterTargetInfo paramIPrinterTargetInfo);
  
  void trace(ITracer paramITracer);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\IDocBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */