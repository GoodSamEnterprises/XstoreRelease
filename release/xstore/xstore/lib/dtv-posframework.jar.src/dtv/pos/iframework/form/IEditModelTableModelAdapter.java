package dtv.pos.iframework.form;

import dtv.data2.access.IDataModel;
import dtv.i18n.IFormattable;
import java.util.List;

public interface IEditModelTableModelAdapter {
  int addRow();
  
  Class<?> getColumnClass(int paramInt);
  
  int getColumnCount();
  
  IFormattable getColumnName(int paramInt);
  
  List getEnumeratedPossibleValuesAt(int paramInt);
  
  String getFieldKey(int paramInt);
  
  Object getValueAt(int paramInt1, int paramInt2);
  
  List getValues();
  
  boolean isCellEditable(int paramInt1, int paramInt2);
  
  boolean isRowAddingAllowed();
  
  void setRowAddingAllowed(boolean paramBoolean);
  
  void setValueAt(Object paramObject, int paramInt1, int paramInt2) throws IllegalAccessException;
  
  void setValues(List<IDataModel> paramList);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\IEditModelTableModelAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */