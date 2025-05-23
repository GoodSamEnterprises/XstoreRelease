/*    */ package dtv.pos.framework.ui.listview;
/*    */ 
/*    */ import dtv.pos.ui.action.IPosAction;
/*    */ import dtv.pos.ui.component.PosBackOfficeMenuRowItem;
/*    */ import dtv.pos.ui.component.PosPrettyListCell;
/*    */ import dtv.pos.ui.plaf.component.PosBackOfficeMenuRowItemUI;
/*    */ import dtv.pos.ui.plaf.component.PosComponentUIType;
/*    */ import javax.swing.JList;
/*    */ import javax.swing.UIManager;
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
/*    */ public class BackOfficeCellViewElement
/*    */   extends DefaultViewElement
/*    */ {
/*    */   public void initialize(JList<?> argList, Object argModel, int argIndex, boolean argIsSelected, boolean argHasFocus) {
/* 32 */     super.initialize(argList, argModel, argIndex, argIsSelected, argHasFocus);
/* 33 */     PosBackOfficeMenuRowItem cell = (PosBackOfficeMenuRowItem)this.cell_;
/* 34 */     cell.setSelected(argIsSelected);
/* 35 */     cell.setBorder(null);
/* 36 */     cell.setBackground(null);
/* 37 */     cell.setBackground2(null);
/* 38 */     cell.setBackgroundPainted(false);
/* 39 */     Object obj = argList.getClientProperty("ITEM_HOVERING_INDEX_PROPERTY");
/* 40 */     if (obj != null && obj instanceof Integer && ((Integer)obj).intValue() == argIndex && argIndex > -1) {
/* 41 */       cell.setIsHovering(true);
/*    */     } else {
/*    */       
/* 44 */       cell.setIsHovering(false);
/*    */     } 
/*    */     
/* 47 */     obj = argList.getClientProperty("ITEM_PRESSING_INDEX_PROPERTY");
/* 48 */     if (obj != null && obj instanceof Integer && ((Integer)obj).intValue() == argIndex && argIndex > -1) {
/* 49 */       cell.setPressed(true);
/*    */     } else {
/*    */       
/* 52 */       cell.setPressed(false);
/*    */     } 
/*    */     
/* 55 */     if (!this.cell_.isEnabled() || (argModel instanceof IPosAction && !((IPosAction)argModel).isEnabled())) {
/* 56 */       cell.setEnabled(false);
/*    */     } else {
/*    */       
/* 59 */       cell.setEnabled(true);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected PosPrettyListCell createPrettyListCell() {
/* 66 */     UIManager.put(PosComponentUIType.BACK_OFFICE_MENU_ROW_ITEM.toString(), PosBackOfficeMenuRowItemUI.class
/* 67 */         .getName());
/* 68 */     return (PosPrettyListCell)new PosBackOfficeMenuRowItem();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\BackOfficeCellViewElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */