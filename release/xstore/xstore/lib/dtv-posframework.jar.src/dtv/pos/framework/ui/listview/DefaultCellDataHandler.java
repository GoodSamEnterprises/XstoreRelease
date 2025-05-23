/*    */ package dtv.pos.framework.ui.listview;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.OutputContextType;
/*    */ import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
/*    */ import dtv.pos.iframework.ui.config.ITouchConfig;
/*    */ import dtv.ui.layout.ViewCellData;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import javax.swing.ImageIcon;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefaultCellDataHandler
/*    */   implements ICellDataHandler
/*    */ {
/* 29 */   private static final Logger logger_ = Logger.getLogger(DefaultCellDataHandler.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ViewCellData.CellColumn buildCellColumn(ListViewColumnConfig argColConfig, Object argModel, Color argDefaultRowTextColor, Font argDefaultRowFont) {
/* 43 */     String colText = getCellColumnText(argModel, argColConfig);
/* 44 */     return buildCellColumn(colText, argColConfig.getIcon(), argDefaultRowTextColor, argDefaultRowFont, argColConfig);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, IConfigObject argValue) {
/* 50 */     logger_.warn("Unexpected parameter for " + getClass().getName() + ":" + argName + "=" + argValue);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ViewCellData.CellColumn buildCellColumn(String argCellText, ImageIcon argImage, Color argDefaultRowTextColor, Font argDefaultRowFont, ListViewColumnConfig argColConfig) {
/* 64 */     Color colTextColor = argColConfig.getColorGroupConfig().getFgColor();
/* 65 */     Font colFont = argColConfig.getFontConfig().getFont();
/*    */     
/* 67 */     Color textColor = (colTextColor != null) ? colTextColor : argDefaultRowTextColor;
/* 68 */     Font font = (colFont != null) ? colFont : argDefaultRowFont;
/*    */     
/* 70 */     return new ViewCellData.CellColumn(argCellText, argImage, textColor, font, argColConfig
/* 71 */         .getAlignment().getSwingAlignment(), 1, argColConfig.getStart(), argColConfig
/* 72 */         .getWidth(), argColConfig.getRenderer(), argColConfig.isTextWrapped(), argColConfig
/* 73 */         .isSearchedOn(), (ITouchConfig)argColConfig.getTouchConfig());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected final String getModelValue(Object argModel, IFormattable argAttribute) {
/* 79 */     String value = argAttribute.toString(OutputContextType.VIEW, argModel);
/* 80 */     return value;
/*    */   }
/*    */   
/*    */   private String getCellColumnText(Object argModel, ListViewColumnConfig columnConfig) {
/* 84 */     return getModelValue(argModel, columnConfig.getAttribute(argModel));
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\DefaultCellDataHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */