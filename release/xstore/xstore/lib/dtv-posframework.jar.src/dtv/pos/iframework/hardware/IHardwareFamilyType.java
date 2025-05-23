package dtv.pos.iframework.hardware;

public interface IHardwareFamilyType<T> {
  Class<? extends T> getDefaultImplClass();
  
  Class<T> getInterface();
  
  String getName();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\hardware\IHardwareFamilyType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */