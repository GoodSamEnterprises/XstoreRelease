package dtv.pos.iframework.ui.config;

import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.ui.ITouchResponsivenessRule;
import java.util.List;

public interface ITouchConfig {
  IXstAction getAction();
  
  List<ITouchResponsivenessRule> getResponsivenessRules();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\config\ITouchConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */