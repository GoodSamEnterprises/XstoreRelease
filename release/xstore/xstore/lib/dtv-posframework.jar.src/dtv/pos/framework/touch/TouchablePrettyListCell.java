/*    */ package dtv.pos.framework.touch;
/*    */ 
/*    */ import dtv.pos.iframework.ui.config.ITouchConfig;
/*    */ import dtv.pos.ui.component.PosPrettyListCell;
/*    */ import dtv.pos.ui.plaf.component.PosComponentUIType;
/*    */ import dtv.ui.layout.ViewCellPositionData;
/*    */ import dtv.ui.touch.ITouchReadyCell;
/*    */ import dtv.ui.touch.TouchHelper;
/*    */ import java.awt.event.MouseEvent;
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
/*    */ public class TouchablePrettyListCell
/*    */   extends PosPrettyListCell
/*    */   implements ITouchReadyCell
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private ViewCellPositionData positionData_;
/*    */   
/*    */   public ViewCellPositionData getPositionData() {
/* 33 */     return this.positionData_;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUIClassID() {
/* 38 */     return PosComponentUIType.TOUCHABLE_PRETTY_LIST_CELL.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isColumnTouchReadyItem() {
/* 44 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isColumnTouchResponsive(ITouchConfig argConfig, MouseEvent argEvent) {
/* 50 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isSelected() {
/* 56 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isTall() {
/* 61 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void processTouchConfig(ITouchConfig config, MouseEvent event) {
/* 67 */     if (config != null && 
/* 68 */       TouchHelper.isTouchResponsive(TouchConfig.getRules(config), event) && 
/* 69 */       TouchConfig.getTouchAction(config) != null) {
/* 70 */       TouchConfig.getTouchAction(config).actionPerformed(TouchHelper.createActionEvent(event));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setPositionData(ViewCellPositionData argPositionData) {
/* 78 */     this.positionData_ = argPositionData;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\touch\TouchablePrettyListCell.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */