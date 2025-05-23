/*    */ package dtv.pos.framework.scope;
/*    */ 
/*    */ import dtv.pos.framework.logging.ProcessLogger;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.inject.Inject;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public abstract class AbstractScope
/*    */   implements MutableXScope
/*    */ {
/* 30 */   private static final Logger _logger = Logger.getLogger(AbstractScope.class);
/*    */   
/* 32 */   private Map<ValueKey<?>, Object> _storage = new HashMap<>();
/*    */ 
/*    */   
/*    */   @Inject
/*    */   protected ProcessLogger _flowLogger;
/*    */ 
/*    */   
/*    */   public String dump() {
/* 40 */     List<ValueKey<?>> keys = new ArrayList<>(this._storage.keySet());
/* 41 */     Collections.sort(keys);
/*    */     
/* 43 */     StringBuilder sb = new StringBuilder();
/* 44 */     sb.append("Contents of " + getScopeName() + "[" + getClass() + "]\n");
/*    */     
/* 46 */     for (ValueKey<?> key : keys) {
/* 47 */       sb.append("   ");
/* 48 */       sb.append(key);
/* 49 */       sb.append("\n");
/*    */     } 
/*    */     
/* 52 */     return sb.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public <T> T getValue(ValueKey<T> argValueKey) {
/* 63 */     Object value = this._storage.get(argValueKey);
/* 64 */     Class<T> clazz = argValueKey.getValueClass();
/* 65 */     return clazz.cast(value);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public <T> void setValue(ValueKey<T> argValueKey, T argValue) {
/* 77 */     this._storage.put(argValueKey, argValue);
/*    */     
/* 79 */     this._flowLogger.debug(getScopeName(), argValueKey.getName(), null, "+", getAdditionalLogInfo());
/*    */     
/* 81 */     if (_logger.isTraceEnabled()) {
/* 82 */       _logger.trace(new Throwable("STACK TRACE for " + argValueKey));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getAdditionalLogInfo() {
/* 92 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected abstract String getScopeName();
/*    */   
/*    */   protected Map<ValueKey<?>, Object> getStorage() {
/* 99 */     return this._storage;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\scope\AbstractScope.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */