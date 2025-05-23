package dtv.pos.iframework.form;

import dtv.util.config.ISavableConfig;

public interface ILayoutLocation extends ISavableConfig, Comparable<ILayoutLocation> {
  Integer getColumn();
  
  Integer getColumnSpan();
  
  Integer getRow();
  
  Integer getRowSpan();
  
  void setColumn(Integer paramInteger);
  
  void setColumnSpan(Integer paramInteger);
  
  void setRow(Integer paramInteger);
  
  void setRowSpan(Integer paramInteger);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\ILayoutLocation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */