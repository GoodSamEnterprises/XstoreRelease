package dtv.docbuilding;

public interface IPrintablePosDocument extends IPosDocument {
  String getLocale();
  
  IPrinterTargetInfo getPrinterTargetInfo();
  
  void setLocale(String paramString);
  
  void setPrinterTargetInfo(IPrinterTargetInfo paramIPrinterTargetInfo);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\IPrintablePosDocument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */