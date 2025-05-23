package dtv.pos.chart.util;

import java.awt.Font;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import org.jfree.chart.labels.StandardXYToolTipGenerator;

public interface IDtvPlotRendererWrapper {
  void setBaseItemLabelFont(Font paramFont);
  
  void setBaseToolTipGenerator(StandardXYToolTipGenerator paramStandardXYToolTipGenerator);
  
  void setSeriesItemLabelFont(int paramInt, Font paramFont);
  
  void setSeriesPaint(int paramInt, Paint paramPaint);
  
  void setSeriesShape(int paramInt, Shape paramShape);
  
  void setSeriesShapesFilled(int paramInt, boolean paramBoolean);
  
  void setSeriesShapesVisible(int paramInt, boolean paramBoolean);
  
  void setSeriesStroke(int paramInt, Stroke paramStroke);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\char\\util\IDtvPlotRendererWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */