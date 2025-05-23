package dtv.data2.dataloader.pluggable;

import java.util.Iterator;

public interface IDataFileIterator extends Iterator<AtomicPersistables> {
  void close();
  
  DataFileMetaData<?> getMetaData();
  
  AtomicPersistables next() throws DataFileException;
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\pluggable\IDataFileIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */