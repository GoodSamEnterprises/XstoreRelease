package dtv.pos.framework.version;

import java.util.List;

public interface IVersionHelper extends IVersionReporter {
  VersionInfo getAppVersionInfo();
  
  VersionInfo getSchemaVersionInfo(SchemaVersionScope paramSchemaVersionScope);
  
  List<String> hashCodes();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\version\IVersionHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */