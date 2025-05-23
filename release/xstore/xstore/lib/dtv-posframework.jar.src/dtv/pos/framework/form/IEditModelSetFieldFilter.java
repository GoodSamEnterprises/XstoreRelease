package dtv.pos.framework.form;

import dtv.pos.iframework.form.IEditModel;
import dtv.pos.iframework.form.IEditModelField;

public interface IEditModelSetFieldFilter<T> {
  void init(IEditModel paramIEditModel, IEditModelField<T> paramIEditModelField);
  
  T setValue(IEditModel paramIEditModel, IEditModelField<T> paramIEditModelField, T paramT);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\IEditModelSetFieldFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */