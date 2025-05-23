package dtv.data2x.model;

public interface IDataModelFactory {
  <T extends dtv.data2.access.IDataModel> T create(Class<T> paramClass);
  
  <T extends dtv.data2.access.IDataModel> T createClean(Class<T> paramClass);
  
  <T extends dtv.data2.access.IDataModel> T createTransient(Class<T> paramClass);
  
  <T extends dtv.data2.access.IDataModel> T makeClean(T paramT, boolean paramBoolean);
  
  <T extends dtv.data2.access.IDataModel> T makeDirty(T paramT, boolean paramBoolean);
  
  <T extends dtv.data2.access.IDataModel> T makeTransient(T paramT);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\model\IDataModelFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */