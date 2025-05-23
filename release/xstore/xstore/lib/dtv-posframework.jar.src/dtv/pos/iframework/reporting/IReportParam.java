package dtv.pos.iframework.reporting;

import dtv.i18n.IFormattable;
import dtv.pos.framework.reporting.type.ReportParamComponentType;

public interface IReportParam {
  Object getActualValue();
  
  ReportParamComponentType getComponentType();
  
  String getFieldKey();
  
  String[] getInvokeMethods();
  
  IFormattable getLabel();
  
  Object getValue();
  
  boolean isNewGroup();
  
  void setValue(Object paramObject);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\reporting\IReportParam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */