package dtv.data2.dataloader.pluggable;

import java.io.File;

public interface IDataFileTypeDetector {
  IFileNameSortingStrategy getFileNameSortingStrategy();
  
  DataFileMetaData<?> detect(File paramFile);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\pluggable\IDataFileTypeDetector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */