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
/*    */ public class WorkstationStateType
/*    */ {
/* 18 */   private static final Logger logger_ = Logger.getLogger(WorkstationStateType.class);
/*    */ 
/*    */   
/* 21 */   public static final WorkstationStateType OPEN = new WorkstationStateType("OPEN");
/* 22 */   public static final WorkstationStateType CLOSED = new WorkstationStateType("CLOSED");
/* 23 */   public static final WorkstationStateType PENDING_CLOSE = new WorkstationStateType("PENDING_CLOSE");
/*    */ 
/*    */ 
/*    */   
/*    */   private static Map<String, WorkstationStateType> values_;
/*    */ 
/*    */ 
/*    */   
/*    */   private final String name_;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static WorkstationStateType forName(String argName) {
/* 37 */     if (argName == null) {
/* 38 */       return null;
/*    */     }
/* 40 */     WorkstationStateType found = values_.get(argName.trim().toUpperCase());
/* 41 */     if (found == null) {
/* 42 */       logger_.warn("There is no instance of [" + WorkstationStateType.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*    */     }
/*    */     
/* 45 */     return found;
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
/*    */   protected WorkstationStateType(String argName) {
/* 57 */     this.name_ = argName.trim().toUpperCase();
/* 58 */     if (values_ == null) {
/* 59 */       values_ = new HashMap<>();
/*    */     }
/* 61 */     values_.put(this.name_, this);
/*    */   }
/*    */   
/*    */   public String getName() {
/* 65 */     return this.name_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 75 */     return getName();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\systemcycle\WorkstationStateType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */