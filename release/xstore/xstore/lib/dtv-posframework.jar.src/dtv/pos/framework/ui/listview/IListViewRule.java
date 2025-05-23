package dtv.pos.framework.ui.listview;

import dtv.util.config.IConfigObject;

public interface IListViewRule {
  boolean checkListViewRule(Object paramObject);
  
  void setParameter(IConfigObject paramIConfigObject);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\IListViewRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */