package dtv.pos.iframework.action;

import java.util.Comparator;

public interface ISortAction extends IXstAction {
  void setComparator(Comparator<Object> paramComparator);
  
  void setSortField(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\action\ISortAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */