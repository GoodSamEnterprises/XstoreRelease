package dtv.pos.iframework.ui.model;

import dtv.pos.iframework.IModel;

public interface IMessageModel extends IModel {
  boolean addMessage(IMessage paramIMessage);
  
  void clearMessages();
  
  IMessage getCurrentMessage();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\model\IMessageModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */