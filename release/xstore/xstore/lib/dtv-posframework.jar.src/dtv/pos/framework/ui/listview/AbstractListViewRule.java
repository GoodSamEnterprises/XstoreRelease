/*    */ package dtv.pos.framework.ui.listview;
/*    */ 
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ public abstract class AbstractListViewRule
/*    */   implements IListViewRule
/*    */ {
/*    */   protected IConfigObject type_;
/*    */   
/*    */   public IConfigObject getParameter() {
/* 27 */     return this.type_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(IConfigObject argType) {
/* 37 */     this.type_ = argType;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\AbstractListViewRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */