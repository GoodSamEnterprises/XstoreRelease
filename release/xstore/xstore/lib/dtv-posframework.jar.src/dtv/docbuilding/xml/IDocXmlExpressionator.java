package dtv.docbuilding.xml;

import dtv.docbuilding.IDocElementFactory;
import dtv.i18n.formatter.output.IOutputFormatter;
import java.util.List;

public interface IDocXmlExpressionator {
  List<DocXmlTextDescriptor> describe(String paramString);
  
  String evaluateAndFormat(String paramString1, Object paramObject, IOutputFormatter paramIOutputFormatter, IDocElementFactory paramIDocElementFactory, String paramString2);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\IDocXmlExpressionator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */