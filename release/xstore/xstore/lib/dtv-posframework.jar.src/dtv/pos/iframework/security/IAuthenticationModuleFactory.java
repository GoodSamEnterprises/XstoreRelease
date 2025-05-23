package dtv.pos.iframework.security;

import java.util.List;

public interface IAuthenticationModuleFactory {
  List<IAuthenticationModule> createModules(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\security\IAuthenticationModuleFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */