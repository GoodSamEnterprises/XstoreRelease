package dtv.data2.access;

public interface IHasGenericProperties extends Iterable<Object> {
  boolean containsKey(Object paramObject);
  
  Object get(Object paramObject);
  
  void put(Object paramObject1, Object paramObject2);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IHasGenericProperties.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */