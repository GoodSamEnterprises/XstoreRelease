package dtv.pos.framework.version;

public interface IVersionReporter {
  UniversalVersion getBaseAppVersion();
  
  UniversalVersion getBaseSchemaVersion(SchemaVersionScope paramSchemaVersionScope);
  
  UniversalVersion getCustomerAppVersion();
  
  UniversalVersion getCustomerPatchVersion();
  
  UniversalVersion getCustomerSchemaVersion(SchemaVersionScope paramSchemaVersionScope);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\version\IVersionReporter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */