package dtv.pos.iframework.reporting;

import dtv.i18n.IFormattable;
import dtv.pos.framework.reporting.LabelUsage;
import java.util.List;
import java.util.Map;
import org.springframework.core.io.Resource;

public interface IReportDefinition {
  Resource getDataTemplate();
  
  int getLabelColumnCount();
  
  int getLabelRowCount();
  
  LabelUsage getLabelUsage();
  
  Resource getLayoutTemplate();
  
  String getName();
  
  IFormattable getParameterPromptMessage();
  
  String getPrinter();
  
  String getPrinterRequestType();
  
  Boolean getPromptPageRange();
  
  Map<String, Object> getProperties();
  
  IFormattable getTitle();
  
  List<String> getTitleParameters();
  
  void setDataTemplate(Resource paramResource);
  
  void setLabelColumnCount(int paramInt);
  
  void setLabelRowCount(int paramInt);
  
  void setLabelUsage(String paramString);
  
  void setLayoutTemplate(Resource paramResource);
  
  void setParameterPromptMessage(String paramString);
  
  void setPrinter(String paramString);
  
  void setPrinterRequestType(String paramString);
  
  void setPromptPageRange(Boolean paramBoolean);
  
  void setProperties(Map<String, Object> paramMap);
  
  void setTitle(String paramString);
  
  void setTitleParameters(List<String> paramList);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\reporting\IReportDefinition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */