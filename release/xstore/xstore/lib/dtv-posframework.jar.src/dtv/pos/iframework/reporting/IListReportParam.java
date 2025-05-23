package dtv.pos.iframework.reporting;

import dtv.pos.iframework.ui.SelectionMode;
import java.util.List;

public interface IListReportParam extends IReportParam {
  Object getDefaultSelection();
  
  SelectionMode getListSelectionMode();
  
  List<Object> getPossibleValues();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\reporting\IListReportParam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */