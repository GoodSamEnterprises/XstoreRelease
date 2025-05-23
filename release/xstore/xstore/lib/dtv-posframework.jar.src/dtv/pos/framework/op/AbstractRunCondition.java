/*    */ package dtv.pos.framework.op;
/*    */ 
/*    */ import dtv.pos.framework.scope.DefaultScope;
/*    */ import dtv.pos.framework.scope.ValueKey;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.temp.InjectionHammer;
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
/*    */ public abstract class AbstractRunCondition
/*    */   implements RunChainCondition
/*    */ {
/*    */   @Inject
/*    */   private DefaultScope _defaultScope;
/*    */   private boolean _invertResult = false;
/*    */   
/*    */   public AbstractRunCondition() {
/* 29 */     InjectionHammer.forceAtInjectProcessing(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argKey, String argValue) {
/* 35 */     if ("Invert".equalsIgnoreCase(argKey)) {
/* 36 */       this._invertResult = ConfigUtils.toBoolean(argValue).booleanValue();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean shouldRun() {
/* 43 */     boolean result = shouldRunImpl();
/* 44 */     return this._invertResult ? (!result) : result;
/*    */   }
/*    */   
/*    */   protected <T> T getScopedValue(ValueKey<T> argValueKey) {
/* 48 */     return (T)this._defaultScope.getValue(argValueKey);
/*    */   }
/*    */   
/*    */   protected abstract boolean shouldRunImpl();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\AbstractRunCondition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */