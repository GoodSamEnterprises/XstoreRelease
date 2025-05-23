package dtv.pos.iframework.form;

import dtv.event.IEventSource;
import dtv.i18n.IFormattable;
import dtv.xst.daocommon.ISystemUser;
import java.util.List;

public interface IEditModelFieldMetadata<T> extends IEventSource {
  public static final int ATTR_NONE = 0;
  
  public static final int ATTR_NEW = 2;
  
  public static final int ATTR_READ_ONLY = 4;
  
  public static final int ATTR_NO_SETTER = 8;
  
  ICardinality getCardinality();
  
  Class<T> getDataType();
  
  List<T> getEnumeratedPossibleValues();
  
  IListFieldElementDescr getFieldElementDescriptor();
  
  String getFieldKey();
  
  IFormattable getFieldName();
  
  IEditModelFieldValidationInfo getValidationInfo();
  
  T getValue(Object paramObject);
  
  String getValueAsString(Object paramObject);
  
  IValueWrapperFactory getValueWrapper();
  
  boolean isAvailable();
  
  boolean isReadOnly(boolean paramBoolean);
  
  boolean isSecured();
  
  void setUser(ISystemUser paramISystemUser);
  
  void setValue(T paramT, Object paramObject, boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\IEditModelFieldMetadata.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */