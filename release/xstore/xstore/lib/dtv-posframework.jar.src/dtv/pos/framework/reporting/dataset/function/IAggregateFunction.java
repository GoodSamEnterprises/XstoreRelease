package dtv.pos.framework.reporting.dataset.function;

import java.util.HashMap;
import java.util.List;

public interface IAggregateFunction {
  Object calculate(List<HashMap<String, Object>> paramList, String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\dataset\function\IAggregateFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */