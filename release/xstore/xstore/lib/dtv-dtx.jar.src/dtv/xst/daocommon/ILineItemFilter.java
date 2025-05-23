package dtv.xst.daocommon;

import dtv.data2.access.IDataModel;
import java.util.Comparator;
import java.util.List;

public interface ILineItemFilter {
  List<? extends IDataModel> filter(List<? extends IDataModel> paramList);
  
  void setItemSortComparator(Comparator<IDataModel> paramComparator);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\daocommon\ILineItemFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */