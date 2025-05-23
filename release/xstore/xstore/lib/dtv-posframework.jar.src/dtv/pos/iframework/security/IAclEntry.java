package dtv.pos.iframework.security;

public interface IAclEntry {
  AccessType getAccessType();
  
  byte[] getGroupMembership();
  
  void setAccessType(AccessType paramAccessType);
  
  void setGroupMembership(byte[] paramArrayOfbyte);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\security\IAclEntry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */