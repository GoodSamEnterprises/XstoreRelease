package dtv.dataloader.mom;

import dtv.data2.access.IPersistable;
import dtv.data2.dataloader.pluggable.DataFileException;
import dtv.data2.dataloader.pluggable.DataFileMetaData;
import java.util.List;

public interface IMOMDataTransformer {
  List<IPersistable> purgeData(DataFileMetaData<MOMFileConfiguration> paramDataFileMetaData) throws DataFileException;
  
  List<IPersistable> transform(DataFileMetaData<MOMFileConfiguration> paramDataFileMetaData, MOMUnit paramMOMUnit) throws DataFileException;
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\IMOMDataTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */