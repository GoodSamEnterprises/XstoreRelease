package dtv.logbuilder.routing;

import dtv.util.IHasParameters;
import dtv.util.config.IHasSourceDescription;

public interface IRoutingRule extends IHasParameters, IHasSourceDescription {
  boolean doesRuleApply(Object paramObject);
  
  String getDocumentId();
  
  String getFileId();
  
  void setDocumentId(String paramString);
  
  void setFileId(String paramString);
  
  void setSourceDescription(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\routing\IRoutingRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */