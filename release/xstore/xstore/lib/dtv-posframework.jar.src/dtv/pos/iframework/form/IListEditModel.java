package dtv.pos.iframework.form;

import dtv.data2.access.IDataModel;
import dtv.ui.model.ICombinedListModel;
import java.util.Comparator;

public interface IListEditModel<T> extends IEditModel, ICombinedListModel<T> {
  void setItemSortComparator(Comparator<IDataModel> paramComparator);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\IListEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */