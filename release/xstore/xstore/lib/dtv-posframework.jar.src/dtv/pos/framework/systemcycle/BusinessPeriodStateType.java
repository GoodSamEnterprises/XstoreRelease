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
/*    */ 
/*    */ public class BusinessPeriodStateType
/*    */ {
/* 19 */   private static final Logger logger_ = Logger.getLogger(BusinessPeriodStateType.class);
/*    */ 
/*    */   
/* 22 */   public static final BusinessPeriodStateType OPEN = new BusinessPeriodStateType("OPEN");
/* 23 */   public static final BusinessPeriodStateType CLOSED = new BusinessPeriodStateType("CLOSED");
/*    */ 
/*    */ 
/*    */   
/*    */   private static Map<String, BusinessPeriodStateType> values_;
/*    */ 
/*    */ 
/*    */   
/*    */   private final String name_;
/*    */ 
/*    */ 
/*    */   
/*    */   public static BusinessPeriodStateType forName(String argName) {
/* 36 */     if (argName == null) {
/* 37 */       return null;
/*    */     }
/* 39 */     BusinessPeriodStateType found = values_.get(argName.trim().toUpperCase());
/* 40 */     if (found == null) {
/* 41 */       logger_.warn("There is no instance of [" + BusinessPeriodStateType.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*    */     }
/*    */     
/* 44 */     return found;
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
/*    */   protected BusinessPeriodStateType(String argName) {
/* 56 */     this.name_ = argName.trim().toUpperCase();
/* 57 */     if (values_ == null) {
/* 58 */       values_ = new HashMap<>();
/*    */     }
/* 60 */     values_.put(this.name_, this);
/*    */   }
/*    */   
/*    */   public String getName() {
/* 64 */     return this.name_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 74 */     return getName();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\systemcycle\BusinessPeriodStateType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */