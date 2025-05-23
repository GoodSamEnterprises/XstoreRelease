/*    */ package dtv.pos.framework.ui.component;
/*    */ 
/*    */ import dtv.pos.ui.component.ISecondaryComponent;
/*    */ import dtv.util.StringUtils;
/*    */ import java.awt.Component;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.atomic.AtomicBoolean;
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
/*    */ public class SecondaryComponentRegistry
/*    */ {
/* 26 */   private static final AtomicBoolean _instantiated = new AtomicBoolean(false);
/*    */   private static final SecondaryComponentRegistry _impl;
/*    */   
/*    */   static {
/* 30 */     String implName = System.getProperty(SecondaryComponentRegistry.class.getName());
/* 31 */     if (StringUtils.isEmpty(implName)) {
/* 32 */       _impl = new SecondaryComponentRegistry();
/*    */     } else {
/*    */       
/*    */       try {
/* 36 */         Class<?> impl = Class.forName(implName);
/* 37 */         _impl = (SecondaryComponentRegistry)impl.newInstance();
/*    */       }
/* 39 */       catch (Exception ex) {
/* 40 */         throw new ExceptionInInitializerError(ex);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Set<String> getSecondaryNames(String argPrimaryName) {
/* 53 */     return _impl.getSecondaryNamesImpl(argPrimaryName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void register(ISecondaryComponent argComponent) {
/* 63 */     _impl.registerImpl(argComponent);
/*    */   }
/*    */ 
/*    */   
/* 67 */   private final Map<String, Set<String>> registry_ = new HashMap<>();
/*    */ 
/*    */   
/*    */   protected SecondaryComponentRegistry() {
/* 71 */     if (!_instantiated.compareAndSet(false, true)) {
/* 72 */       throw new IllegalStateException("Cannot create multiple instances");
/*    */     }
/*    */   }
/*    */   
/*    */   protected Set<String> getSecondaryNamesImpl(String argPrimaryName) {
/*    */     Set<String> secondaries;
/* 78 */     if (this.registry_.containsKey(argPrimaryName)) {
/* 79 */       secondaries = this.registry_.get(argPrimaryName);
/*    */     }
/*    */     else {
/*    */       
/* 83 */       this.registry_.put(argPrimaryName, secondaries = new HashSet<>());
/*    */     } 
/* 85 */     return secondaries;
/*    */   }
/*    */   
/*    */   protected void registerImpl(ISecondaryComponent argComponent) {
/* 89 */     if (!(argComponent instanceof Component))
/*    */     {
/*    */ 
/*    */ 
/*    */       
/* 94 */       throw new IllegalArgumentException("Implementations of [" + ISecondaryComponent.class.getName() + "] must also be an instance of [" + Component.class
/* 95 */           .getName() + "]");
/*    */     }
/* 97 */     String key = argComponent.getPrimaryComponentName();
/* 98 */     Set<String> secondaries = getSecondaryNamesImpl(key);
/* 99 */     secondaries.add(((Component)argComponent).getName());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\SecondaryComponentRegistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */