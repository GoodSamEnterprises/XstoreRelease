package dtv.data2.access;

public interface IQueryKey<T> {
  Class<? extends IQueryResultInitializer<? extends IQueryResult>> getInitializerClass();
  
  String getName();
  
  Class<T> getResultClass();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IQueryKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */