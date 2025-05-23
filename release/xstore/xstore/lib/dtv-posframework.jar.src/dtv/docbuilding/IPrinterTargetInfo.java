package dtv.docbuilding;

import dtv.util.xmlexport.IXmlExportable;
import java.io.Serializable;

public interface IPrinterTargetInfo extends Serializable, IXmlExportable {
  String getBackupPrinterType();
  
  String getPrinterType();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\IPrinterTargetInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */