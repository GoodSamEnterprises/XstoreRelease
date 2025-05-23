package dtv.data2.access;

import dtv.data2.access.impl.IDataModelImpl;
import java.util.Collection;
import java.util.List;

public interface IDataModelMetaData {
  void addRelatedDataModels(Collection<?> paramCollection);
  
  IDataModelImpl getDataModel();
  
  List<IDataModelImpl> getRelatedDataModels();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IDataModelMetaData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */