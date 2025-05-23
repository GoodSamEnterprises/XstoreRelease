package dtv.data2.dataloader.valuetranslator;

import dtv.data2.dataloader.fileprocessing.FileLine;

public interface IValueTranslator {
  void setParameter(String paramString1, String paramString2);
  
  String translate(String paramString, FileLine paramFileLine);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\valuetranslator\IValueTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */