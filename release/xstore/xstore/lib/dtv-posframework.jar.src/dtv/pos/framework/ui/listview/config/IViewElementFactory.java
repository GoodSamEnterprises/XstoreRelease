package dtv.pos.framework.ui.listview.config;

import dtv.pos.iframework.ui.IViewElementType;
import java.awt.Component;
import javax.swing.ListCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.TreeCellRenderer;

public interface IViewElementFactory extends ListCellRenderer, TableCellRenderer, TreeCellRenderer {
  ListViewConfigHelper getHelper();
  
  Component getHeader(IViewElementType paramIViewElementType, Object paramObject);
  
  IViewElementType getViewTypeFromRule(Object paramObject, String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\config\IViewElementFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */