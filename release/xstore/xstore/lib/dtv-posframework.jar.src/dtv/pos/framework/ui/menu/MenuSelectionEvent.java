/*    */ package dtv.pos.framework.ui.menu;
/*    */ 
/*    */ import dtv.pos.iframework.ui.IMenuItem;
/*    */ import java.util.EventObject;
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
/*    */ public class MenuSelectionEvent
/*    */   extends EventObject
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final IMenuItem menuItem_;
/*    */   
/*    */   public MenuSelectionEvent(IMenuItem argSource) {
/* 23 */     super(argSource);
/* 24 */     this.menuItem_ = argSource;
/*    */   }
/*    */   
/*    */   public IMenuItem getMenuItem() {
/* 28 */     return this.menuItem_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\menu\MenuSelectionEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */