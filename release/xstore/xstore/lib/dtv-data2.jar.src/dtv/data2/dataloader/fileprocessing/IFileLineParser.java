package dtv.data2.dataloader.fileprocessing;

import dtv.data2.access.IPersistable;
import java.util.List;

public interface IFileLineParser {
  List<IPersistable> parse(FileLine paramFileLine);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\fileprocessing\IFileLineParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */