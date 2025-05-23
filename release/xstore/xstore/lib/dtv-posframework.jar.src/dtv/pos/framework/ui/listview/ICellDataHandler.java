package dtv.pos.framework.ui.listview;

import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
import dtv.ui.layout.ViewCellData;
import dtv.util.config.IConfigObject;
import java.awt.Color;
import java.awt.Font;

public interface ICellDataHandler {
  ViewCellData.CellColumn buildCellColumn(ListViewColumnConfig paramListViewColumnConfig, Object paramObject, Color paramColor, Font paramFont);
  
  void setParameter(String paramString, IConfigObject paramIConfigObject);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\ICellDataHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */