package dtv.pos.iframework.reporting;

import dtv.pos.framework.reporting.ReportFillException;
import dtv.pos.framework.reporting.ReportFillStatus;
import java.util.Date;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

public interface IReportFill {
  public static final String MAX_ROWS_PARAM = "JDBC_MAX_ROWS";
  
  void addFillListener(IReportFillListener paramIReportFillListener);
  
  void cancel();
  
  String getDescription();
  
  int getFillId();
  
  AttributeSet getPrinterAttributeSet();
  
  PrintRequestAttributeSet getPrintRequestAttributeSet();
  
  Throwable getProblem();
  
  Object getResults();
  
  ReportFillStatus getStatus();
  
  Date getTime();
  
  boolean isBackground();
  
  void removeFillListener(IReportFillListener paramIReportFillListener);
  
  void run() throws ReportFillException;
  
  void setDescription(String paramString);
  
  void setIsBackground(boolean paramBoolean);
  
  void setProblem(Throwable paramThrowable);
  
  void setStatus(ReportFillStatus paramReportFillStatus);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\reporting\IReportFill.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */