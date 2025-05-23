package dtv.pos.chart.util;

import java.awt.Paint;
import java.awt.Stroke;
import org.jfree.chart.axis.Axis;

public interface IDtvChartPlotWrapper {
  Axis getDomainAxis();
  
  Axis getRangeAxis();
  
  IDtvPlotRendererWrapper getRenderer();
  
  void setDomainGridlinePaint(Paint paramPaint);
  
  void setOutlineVisible(boolean paramBoolean);
  
  void setRangeGridlinePaint(Paint paramPaint);
  
  void setRangeGridlineStroke(Stroke paramStroke);
  
  void setRangeGridlinesVisible(boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\char\\util\IDtvChartPlotWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */