package dtv.data2.dataloader;

import java.io.File;

public interface IFileArchiver {
  void archiveDataFile(File paramFile, String paramString);
  
  boolean archiveStatusFiles();
  
  void archiveSummaryFile();
  
  void cleanUpArchives();
  
  void cleanUpStatusFiles();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\IFileArchiver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */