package dtv.data2.cache;

public interface ICache {
  void clear();
  
  void destroy();
  
  Object get(Object paramObject) throws NotCachedException;
  
  String getCacheId();
  
  Object getSafely(Object paramObject);
  
  String getStatusReport();
  
  void init(String paramString);
  
  void put(Object paramObject1, Object paramObject2);
  
  void remove(Object paramObject);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\cache\ICache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */