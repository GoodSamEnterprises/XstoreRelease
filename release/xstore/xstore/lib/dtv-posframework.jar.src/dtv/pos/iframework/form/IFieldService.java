package dtv.pos.iframework.form;

import dtv.event.IEventSource;

public interface IFieldService extends IEventSource {
  void notifyFieldChanged(String paramString, Object paramObject);
  
  void registerField(IEditModel paramIEditModel, IEditModelField paramIEditModelField, String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\IFieldService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */