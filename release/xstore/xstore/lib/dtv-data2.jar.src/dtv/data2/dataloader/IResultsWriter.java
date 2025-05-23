package dtv.data2.dataloader;

import dtv.data2.dataloader.fileprocessing.FileProcessingStats;
import dtv.data2.dataloader.fileprocessing.IHasSourceData;
import java.util.Date;

public interface IResultsWriter {
  void finish(String paramString);
  
  void setFileBeingProcessed(String paramString);
  
  void start(String paramString, Date paramDate);
  
  void writeFailure(String paramString, IHasSourceData paramIHasSourceData);
  
  void writeResultsSummary(FileProcessingStats paramFileProcessingStats);
  
  void writeSuccess(String paramString);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\IResultsWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */