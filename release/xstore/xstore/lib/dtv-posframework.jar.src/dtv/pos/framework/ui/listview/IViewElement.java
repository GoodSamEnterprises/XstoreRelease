package dtv.pos.framework.ui.listview;

import dtv.pos.framework.ui.listview.config.IListViewElementConfig;
import dtv.pos.iframework.ui.IXstViewComponent;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTree;

public interface IViewElement extends IXstViewComponent {
  void initialize(JList<?> paramJList, Object paramObject, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  void initialize(JTable paramJTable, Object paramObject, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);
  
  void initialize(JTree paramJTree, Object paramObject, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  
  void initialize(Object paramObject);
  
  void setConfig(IListViewElementConfig paramIListViewElementConfig);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\IViewElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */