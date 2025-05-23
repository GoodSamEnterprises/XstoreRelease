/*    */ package dtv.pos.framework.ui.listview;
/*    */ 
/*    */ import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
/*    */ import dtv.ui.layout.ViewCellData;
/*    */ import dtv.util.StringUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.IconConfig;
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import javax.swing.ImageIcon;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NamedIconColumnDataHandler
/*    */   extends DefaultCellDataHandler
/*    */ {
/* 35 */   protected final Map<String, ImageIcon> iconMap_ = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ViewCellData.CellColumn buildCellColumn(ListViewColumnConfig argColConfig, Object argModel, Color argDefaultRowTextColor, Font argDefaultRowFont) {
/* 41 */     String iconName = StringUtils.nonNull(getModelValue(argModel, argColConfig.getAttribute()));
/* 42 */     ImageIcon icon = this.iconMap_.get(iconName);
/*    */     
/* 44 */     return buildCellColumn((String)null, icon, argDefaultRowTextColor, argDefaultRowFont, argColConfig);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, IConfigObject argValue) {
/* 50 */     if (argValue instanceof IconConfig) {
/* 51 */       this.iconMap_.put(argName, ((IconConfig)argValue).getIcon());
/*    */     } else {
/*    */       
/* 54 */       super.setParameter(argName, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final ImageIcon getIcon(String argName) {
/* 65 */     return this.iconMap_.get(argName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final Set<String> getIconNames() {
/* 73 */     return this.iconMap_.keySet();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\NamedIconColumnDataHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */