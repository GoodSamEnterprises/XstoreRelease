package dtv.pos.iframework.form.design.model;

import dtv.util.config.IReflectionParameterCapable;
import dtv.util.config.ISavableConfig;
import dtv.util.config.ParameterListConfig;

public interface ILayoutParameters extends ISavableConfig {
  void deleteColumn(Integer paramInteger);
  
  void deleteRow(Integer paramInteger);
  
  Integer getColumnCount();
  
  double[] getColumnSizes();
  
  @Deprecated
  int[] getGapSizes();
  
  IReflectionParameterCapable<?> getGaps();
  
  ParameterListConfig getParameterListConfig();
  
  Integer getRowCount();
  
  double[] getRowSizes();
  
  Boolean getVerticalStretch();
  
  void insertColumn(Integer paramInteger);
  
  void insertRow(Integer paramInteger);
  
  void setColumnCount(Integer paramInteger);
  
  void setColumnSizes(double[] paramArrayOfdouble);
  
  @Deprecated
  void setGapSizes(int[] paramArrayOfint);
  
  void setGaps(String paramString);
  
  void setRowCount(Integer paramInteger);
  
  void setRowSizes(double[] paramArrayOfdouble);
  
  void setVerticalStretch(Boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\design\model\ILayoutParameters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */