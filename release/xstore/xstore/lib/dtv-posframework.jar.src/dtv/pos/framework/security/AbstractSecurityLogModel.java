/*    */ package dtv.pos.framework.security;
/*    */ 
/*    */ import dtv.logbuilder.model.AbstractLogModel;
/*    */ import dtv.logbuilder.model.ILoggableModel;
/*    */ import dtv.pos.framework.scope.DefaultScope;
/*    */ import dtv.pos.framework.scope.ValueKey;
/*    */ import dtv.pos.iframework.security.ISecurityMgr;
/*    */ import javax.inject.Inject;
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
/*    */ public abstract class AbstractSecurityLogModel
/*    */   extends AbstractLogModel
/*    */   implements ILoggableModel
/*    */ {
/*    */   @Inject
/*    */   private ISecurityMgr _securityMgr;
/*    */   @Inject
/*    */   private DefaultScope _defaultScope;
/*    */   
/*    */   protected <T> T getScopedValue(ValueKey<T> argValueKey) {
/* 35 */     return (T)this._defaultScope.getValue(argValueKey);
/*    */   }
/*    */   
/*    */   protected ISecurityMgr getSecurityMgr() {
/* 39 */     return this._securityMgr;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\security\AbstractSecurityLogModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */