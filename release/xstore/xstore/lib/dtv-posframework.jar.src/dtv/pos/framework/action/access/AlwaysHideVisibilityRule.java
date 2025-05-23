/*    */ package dtv.pos.framework.action.access;
/*    */ 
/*    */ import dtv.pos.iframework.visibilityrules.AccessLevel;
/*    */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
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
/*    */ public final class AlwaysHideVisibilityRule
/*    */   extends AbstractVisibilityRule
/*    */ {
/*    */   protected final IAccessLevel checkVisibilityImpl() {
/* 20 */     return (IAccessLevel)AccessLevel.DENIED;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\access\AlwaysHideVisibilityRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */