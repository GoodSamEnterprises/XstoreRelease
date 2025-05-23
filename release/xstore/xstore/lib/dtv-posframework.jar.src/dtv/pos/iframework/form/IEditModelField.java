package dtv.pos.iframework.form;

import dtv.util.ListHolder;
import java.util.List;

public interface IEditModelField<T> extends IEditModelFieldMetadata<T>, ListHolder {
  T getValue() throws EditModelException;
  
  String getValueAsString();
  
  boolean hasDependency();
  
  void initialize();
  
  boolean isReadOnly();
  
  void makeRequired();
  
  void setCardinality(ICardinality paramICardinality);
  
  void setEnumeratedPossibleValues(List<T> paramList);
  
  void setReadOnly(boolean paramBoolean);
  
  void setRequired(boolean paramBoolean);
  
  void setValue(T paramT);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\IEditModelField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */