package dtv.data2.access;

import java.io.Serializable;

public interface IHasConfigElement extends IHasObjectId, Serializable {
  String getConfigElement();
  
  void setConfigElement(String paramString);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IHasConfigElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */