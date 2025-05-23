package dtv.data2.dataloader.filelocator;

import java.io.File;
import java.util.List;

public interface IDataFileLocator {
  void cleanup();
  
  List<File> getDataFiles();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\filelocator\IDataFileLocator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */