package dtv.pos.iframework.form;

public interface IEnumValueWrapper {
  boolean equals(Object paramObject);
  
  Object getActualValue();
  
  int hashCode();
  
  void setActualValue(Object paramObject);
  
  String toString();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\IEnumValueWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */