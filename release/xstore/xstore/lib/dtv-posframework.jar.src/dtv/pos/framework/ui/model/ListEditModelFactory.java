package dtv.pos.framework.ui.model;

import dtv.pos.iframework.form.IListEditModel;
import dtv.pos.iframework.type.ModelKey;

public interface ListEditModelFactory {
  IListEditModel<Object> createListModel(ModelKey<?> paramModelKey);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\ListEditModelFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */