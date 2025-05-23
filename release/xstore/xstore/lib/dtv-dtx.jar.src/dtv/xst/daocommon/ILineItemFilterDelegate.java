package dtv.xst.daocommon;

import dtv.data2.access.IDataModel;
import java.util.List;

public interface ILineItemFilterDelegate<T extends IDataModel> {
  void addDetails(List<IDataModel> paramList, T paramT);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\daocommon\ILineItemFilterDelegate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */