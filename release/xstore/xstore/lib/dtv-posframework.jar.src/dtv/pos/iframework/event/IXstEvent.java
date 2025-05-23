package dtv.pos.iframework.event;

public interface IXstEvent {
  Object getData();
  
  Object[] getDataSet();
  
  String getName();
  
  Object getSource();
  
  String getStringData();
  
  IXstEventType getType();
  
  void setData(Object paramObject);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\event\IXstEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */