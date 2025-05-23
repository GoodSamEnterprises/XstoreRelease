package dtv.pos.iframework;

import dtv.data2.access.IPersistable;
import dtv.data2.access.exception.PersistenceException;
import java.util.Collection;

public interface IPersistablesBag {
  void addAllObjects(Collection<? extends IPersistable> paramCollection);
  
  void addAllObjects(IPersistable[] paramArrayOfIPersistable);
  
  void addObject(IPersistable paramIPersistable);
  
  void clear();
  
  IPersistable[] getObjects();
  
  boolean persist() throws PersistenceException;
  
  void removeObject(IPersistable paramIPersistable);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\IPersistablesBag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */