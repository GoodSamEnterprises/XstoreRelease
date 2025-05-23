package dtv.pos.iframework.form.config;

import dtv.util.config.IConfigObject;
import dtv.util.config.ISavableConfig;
import javax.swing.table.TableColumnModel;

public interface ITableColumnsConfig extends ISavableConfig, IConfigObject {
  TableColumnModel getTableColumnModel();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\config\ITableColumnsConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */