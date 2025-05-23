/*    */ package dtv.pos.framework.ui.menu;
/*    */ 
/*    */ import dtv.pos.framework.ui.listview.AbstractListViewRule;
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
/*    */ public class ListMenuItemListViewRule
/*    */   extends AbstractListViewRule
/*    */ {
/*    */   public boolean checkListViewRule(Object argData) {
/* 20 */     if (argData instanceof dtv.pos.iframework.ui.IMenuItem) {
/* 21 */       return true;
/*    */     }
/* 23 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\menu\ListMenuItemListViewRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */