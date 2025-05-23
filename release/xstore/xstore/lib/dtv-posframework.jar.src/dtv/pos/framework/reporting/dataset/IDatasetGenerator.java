package dtv.pos.framework.reporting.dataset;

import dtv.pos.framework.reporting.ReportException;
import dtv.pos.iframework.reporting.IReportDefinition;
import java.util.Collection;
import java.util.Map;

public interface IDatasetGenerator {
  byte[] generate(IReportDefinition paramIReportDefinition, Map<String, Object> paramMap, Collection<?> paramCollection) throws ReportException;
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\dataset\IDatasetGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */