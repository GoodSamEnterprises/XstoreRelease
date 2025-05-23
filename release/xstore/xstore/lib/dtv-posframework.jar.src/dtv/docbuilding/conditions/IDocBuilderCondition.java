package dtv.docbuilding.conditions;

import dtv.docbuilding.trace.ITracer;
import dtv.util.IHasParameters;
import dtv.util.config.IHasSourceDescription;

public interface IDocBuilderCondition extends IHasParameters, IHasSourceDescription {
  boolean conditionMet(Object paramObject);
  
  void setSourceDescription(String paramString);
  
  void trace(ITracer paramITracer);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\conditions\IDocBuilderCondition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */