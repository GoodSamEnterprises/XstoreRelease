package dtv.pos.iframework.reporting;

public interface IReportFillListener {
  void fillCanceled(IReportFill paramIReportFill);
  
  void fillFailed(IReportFill paramIReportFill);
  
  void fillFinished(IReportFill paramIReportFill);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\reporting\IReportFillListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */