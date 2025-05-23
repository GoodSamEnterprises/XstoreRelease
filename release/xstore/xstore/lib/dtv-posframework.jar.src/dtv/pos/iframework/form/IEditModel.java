package dtv.pos.iframework.form;

import dtv.event.IEventAware;
import dtv.event.IEventConstraint;
import dtv.i18n.IFormattable;
import dtv.pos.iframework.IModel;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.IValidationResultList;
import dtv.util.IKeyedValue;
import dtv.xst.daocommon.ISystemUser;
import java.util.Collection;
import java.util.List;

public interface IEditModel extends IModel {
  IEditModelField getFieldDef(String paramString);
  
  boolean commitChanges() throws EditModelException;
  
  void deregisterFieldHandler(String paramString, IEventAware paramIEventAware);
  
  Collection<IKeyedValue<String, ?>> getChanges();
  
  Class<?> getDataType(String paramString);
  
  List<?> getEnumeratedPossibleValues(String paramString);
  
  IListFieldElementDescr getFieldElementDescriptor(String paramString);
  
  Collection<String> getFieldKeys();
  
  String getFocusRequestFieldKey();
  
  Integer getMaximum(String paramString);
  
  int getMinimum(String paramString);
  
  IFormattable getModelDescription();
  
  IFormattable getModelTitle();
  
  ISystemUser getUser();
  
  Object getValue(String paramString) throws EditModelException;
  
  IValueWrapperFactory getValueWrapper(String paramString);
  
  boolean hasChanges();
  
  boolean hasFieldChanged(String paramString);
  
  void initializeFieldState();
  
  boolean isArray(String paramString);
  
  boolean isAvailable(String paramString);
  
  boolean isReadOnly(String paramString);
  
  boolean isRequired(String paramString);
  
  void makeRequired(String paramString);
  
  void registerFieldHandler(String paramString, IEventAware paramIEventAware, IEventConstraint paramIEventConstraint);
  
  void registerFieldService(String paramString1, IFieldService paramIFieldService, String paramString2);
  
  void revertChanges();
  
  void revertChanges(String paramString);
  
  void setFieldWeight(String paramString, int paramInt);
  
  void setFocusRequestFieldKey(String paramString);
  
  void setUser(ISystemUser paramISystemUser);
  
  void setValue(String paramString, Object paramObject) throws EditModelException;
  
  IValidationResultList validate();
  
  IValidationResultList validate(IValidationResultList paramIValidationResultList);
  
  IValidationResult validateField(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\IEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */