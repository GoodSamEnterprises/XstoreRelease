package dtv.pos.iframework.form.dependency;

import dtv.pos.iframework.form.ICardinality;
import dtv.pos.iframework.form.IEditModelField;

public interface IMutableFieldDefinition<T> extends IEditModelField<T> {
  void removeValue();
  
  void setCardinality(ICardinality paramICardinality);
  
  void unremoveValue();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\dependency\IMutableFieldDefinition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */