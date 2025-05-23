package dtv.pos.iframework.hardware;

import dtv.util.crypto.EncString;

public interface IInput {
  Object getAdditionalInformation(String paramString);
  
  EncString getData();
  
  IHardwareType<?> getSourceType();
  
  boolean isError();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\hardware\IInput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */