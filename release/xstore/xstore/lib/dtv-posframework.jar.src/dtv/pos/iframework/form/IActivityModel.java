package dtv.pos.iframework.form;

import dtv.pos.iframework.IModel;
import java.util.Date;
import javax.swing.Icon;

public interface IActivityModel extends IModel {
  Object getAlternativeSource();
  
  String getDataRenderingRule();
  
  Date getDate();
  
  String getDetails();
  
  Icon getIcon();
  
  Object getSource();
  
  String getTitle();
  
  boolean isFirst();
  
  boolean isLast();
  
  void setAlternativeSource(Object paramObject);
  
  void setDataRenderingRule(String paramString);
  
  void setDate(Date paramDate);
  
  void setDetails(String paramString);
  
  void setIcon(Icon paramIcon);
  
  void setIsFirst(boolean paramBoolean);
  
  void setIsLast(boolean paramBoolean);
  
  void setSource(Object paramObject);
  
  void setTitle(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\IActivityModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */