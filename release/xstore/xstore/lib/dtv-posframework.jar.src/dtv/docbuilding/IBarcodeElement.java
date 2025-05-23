package dtv.docbuilding;

import dtv.barcode.BarcodeTextType;
import dtv.barcode.BarcodeType;
import dtv.pos.iframework.hardware.AlignmentType;

public interface IBarcodeElement extends IDocElement {
  AlignmentType getAlignment();
  
  BarcodeType getBarcodeType();
  
  String getContent();
  
  int getHeight();
  
  String getPrefix();
  
  BarcodeTextType getTextPosition();
  
  int getWidth();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\IBarcodeElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */