package dtv.docbuilding;

import dtv.docbuilding.trace.ITracer;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.util.config.IConfigObject;
import dtv.util.config.IHasSourceDescription;
import java.util.Locale;

public interface IDocBuilderField extends IHasSourceDescription {
  FormattedString[] buildField(Object paramObject, IDocElementFactory paramIDocElementFactory, FontInfo paramFontInfo, Locale paramLocale);
  
  DocBuilderAlignmentType getAlignment();
  
  String getContents(Object paramObject, IDocElementFactory paramIDocElementFactory, Locale paramLocale);
  
  Integer getLocation();
  
  int getPriority();
  
  void setParameter(String paramString, IConfigObject paramIConfigObject);
  
  void setSourceDescription(String paramString);
  
  void trace(String paramString, ITracer paramITracer);
  
  public static interface FontInfo {
    String getBeginFont();
    
    String getEndFont();
    
    boolean isDoubleWide();
  }
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\IDocBuilderField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */