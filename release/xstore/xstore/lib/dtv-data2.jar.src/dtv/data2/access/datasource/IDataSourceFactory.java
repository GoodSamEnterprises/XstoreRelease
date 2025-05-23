package dtv.data2.access.datasource;

import java.util.Collection;

public interface IDataSourceFactory {
  DataSourceDescriptor getDataSourceDescriptor(String paramString);
  
  Collection<DataSourceDescriptor> getDataSourceDescriptors();
  
  boolean isDataSourceEnabled(DataSourceDescriptor paramDataSourceDescriptor);
  
  void reinitialize();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\datasource\IDataSourceFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */