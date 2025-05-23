/*    */ package dtv.pos.framework.systemcycle;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class RetailLocationStateType
/*    */ {
/* 18 */   private static final Logger logger_ = Logger.getLogger(RetailLocationStateType.class);
/*    */ 
/*    */   
/* 21 */   public static final RetailLocationStateType OPEN = new RetailLocationStateType("OPEN");
/*    */   
/* 23 */   public static final RetailLocationStateType CLOSED = new RetailLocationStateType("CLOSED");
/*    */ 
/*    */ 
/*    */   
/*    */   private static Map<String, RetailLocationStateType> values_;
/*    */ 
/*    */ 
/*    */   
/*    */   private final String name_;
/*    */ 
/*    */ 
/*    */   
/*    */   public static RetailLocationStateType forName(String argName) {
/* 36 */     if (argName == null) {
/* 37 */       return null;
/*    */     }
/* 39 */     RetailLocationStateType found = values_.get(argName.trim().toUpperCase());
/* 40 */     if (found == null) {
/* 41 */       logger_.warn("There is no instance of [" + RetailLocationStateType.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*    */     }
/*    */     
/* 44 */     return found;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected RetailLocationStateType(String argName) {
/* 50 */     this.name_ = argName.trim().toUpperCase();
/* 51 */     if (values_ == null) {
/* 52 */       values_ = new HashMap<>();
/*    */     }
/* 54 */     values_.put(this.name_, this);
/*    */   }
/*    */   
/*    */   public String getName() {
/* 58 */     return this.name_;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 63 */     return getName();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\systemcycle\RetailLocationStateType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */