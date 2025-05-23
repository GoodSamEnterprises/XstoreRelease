package dtv.data2.dataloader.applicability;

import dtv.data2.dataloader.fileprocessing.FileLine;

public interface IApplicabilityCondition {
  boolean isApplicable(FileLine paramFileLine);
  
  void setParameter(String paramString1, String paramString2);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\applicability\IApplicabilityCondition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */