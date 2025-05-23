package dtv.docbuilding;

import dtv.barcode.BarcodeTextType;
import dtv.docbuilding.types.DocBuilderRowStyleType;
import dtv.pos.iframework.hardware.AlignmentType;
import dtv.pos.iframework.hardware.IBarcode;
import java.io.File;
import java.util.Collection;

public interface IDocElementFactory {
  String getFieldStyleEnd(String paramString);
  
  String getFieldStyleStart(String paramString);
  
  String getHorizontalRuleText(String paramString1, int paramInt, String paramString2);
  
  IDocElement[] getPageBreakElements();
  
  DocSectionParamMap getParameterMap();
  
  String getRowStyle(DocBuilderRowStyleType paramDocBuilderRowStyleType);
  
  boolean isTraceEnabled();
  
  IBarcodeElement makeBarcodeElement(IBarcode paramIBarcode, AlignmentType paramAlignmentType, BarcodeTextType paramBarcodeTextType, int paramInt1, int paramInt2, String paramString);
  
  IDocElement makeHorizontalRuleElement(String paramString1, int paramInt, String paramString2);
  
  IPictureElement makePictureElement(File paramFile, boolean paramBoolean);
  
  ISignatureElement makeSignatureElement(String paramString, AlignmentType paramAlignmentType);
  
  ITextElement makeTextElement(Collection<? extends Object> paramCollection);
  
  ITextElement makeTraceElement(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\IDocElementFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */