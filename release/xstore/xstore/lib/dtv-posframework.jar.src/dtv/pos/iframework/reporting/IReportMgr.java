package dtv.pos.iframework.reporting;

import dtv.i18n.IFormattable;
import dtv.pos.framework.reporting.DtvReportLoadException;
import dtv.pos.framework.reporting.LabelUsage;
import dtv.pos.framework.reporting.ReportStorage;
import dtv.pos.framework.reporting.config.ReportingConfigException;
import dtv.pos.framework.reporting.type.ReportOwnerType;
import dtv.pos.framework.reporting.type.SavedReportType;
import dtv.xst.dao.com.IReportLookup;
import java.io.IOException;
import java.net.URL;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import org.apache.pdfbox.pdmodel.PDDocument;

public interface IReportMgr {
  ReportStorage convertReportForSave(PDDocument paramPDDocument);
  
  IReportQueryParam buildSqlInStatement(String paramString, Object[] paramArrayOfObject);
  
  void cancelReport(IReportFill paramIReportFill);
  
  void deleteSaved(IReportLookup paramIReportLookup);
  
  void fillReport(IReportFill paramIReportFill);
  
  IReportDefinition[] getLabelLayouts(LabelUsage paramLabelUsage);
  
  AttributeSet getPrinterServiceAttributes(String paramString);
  
  PrintRequestAttributeSet getPrintRequestAttributes(String paramString);
  
  IFormattable[] getPromptInformation(IReportLookup paramIReportLookup);
  
  IReportDefinition getReportDefinition(String paramString);
  
  IReportLookup[] getSavedReports(String paramString1, String paramString2);
  
  PDDocument loadPrint(URL paramURL) throws DtvReportLoadException;
  
  IReportLookup makeLookup(String paramString1, ReportOwnerType paramReportOwnerType, String paramString2, SavedReportType paramSavedReportType);
  
  void runBackgroupReport(String paramString) throws ReportingConfigException;
  
  void runBackgroupReportGroup(String paramString) throws ReportingConfigException;
  
  void saveReport(String paramString1, PDDocument paramPDDocument, String paramString2) throws IOException;
  
  void saveStoreReport(String paramString1, PDDocument paramPDDocument, String paramString2) throws IOException;
  
  void saveStoreReportCriteria(String paramString1, URL paramURL, String paramString2) throws IOException;
  
  void saveUserReport(String paramString1, PDDocument paramPDDocument, String paramString2) throws IOException;
  
  void saveUserReportCriteria(String paramString1, URL paramURL, String paramString2) throws IOException;
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\reporting\IReportMgr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */