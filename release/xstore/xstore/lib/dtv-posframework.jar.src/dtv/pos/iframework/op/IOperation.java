package dtv.pos.iframework.op;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.ui.context.IUIContextDescriptor;
import dtv.util.config.IHasSourceDescription;

public interface IOperation extends Cloneable, IHasSourceDescription, LongRunningCapable {
  boolean canceling();
  
  Object clone() throws CloneNotSupportedException;
  
  IUIContextDescriptor getContextDescriptor();
  
  String getLogId();
  
  String getLongRunningMessage();
  
  IOpState getOpState();
  
  String getOpType();
  
  IOpResponse handleBreakPointReversal(IXstEvent paramIXstEvent) throws CancelOpException;
  
  IOpResponse handleOpExec(IXstEvent paramIXstEvent);
  
  boolean hasBreakPoint();
  
  boolean isCancelable();
  
  boolean isComplete();
  
  boolean isLongRunning();
  
  boolean isOperationApplicable();
  
  boolean isRequired();
  
  void setBreakPoint(boolean paramBoolean);
  
  void setCancelable(boolean paramBoolean);
  
  void setComplete(boolean paramBoolean);
  
  void setContextDescriptor(IUIContextDescriptor paramIUIContextDescriptor);
  
  void setLongRunning(boolean paramBoolean);
  
  void setOpState(IOpState paramIOpState);
  
  void setParameter(String paramString1, String paramString2);
  
  void setRequired(boolean paramBoolean);
  
  void setSourceDescription(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\IOperation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */