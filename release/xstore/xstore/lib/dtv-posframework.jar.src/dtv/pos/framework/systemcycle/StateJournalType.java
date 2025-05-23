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
/*    */ 
/*    */ public class StateJournalType
/*    */ {
/* 20 */   private static final Logger logger_ = Logger.getLogger(StateJournalType.class);
/*    */   
/* 22 */   public static final StateJournalType RTL_LOC_STATE = new StateJournalType("RTL_LOC_STATE");
/* 23 */   public static final StateJournalType WKSTN_STATE = new StateJournalType("WKSTN_STATE");
/* 24 */   public static final StateJournalType BUSINESS_DATE = new StateJournalType("BUSINESS_DATE");
/* 25 */   public static final StateJournalType BUSINESS_PERIOD = new StateJournalType("BUSINESS_PERIOD");
/*    */ 
/*    */   
/*    */   private static Map<String, StateJournalType> values_;
/*    */ 
/*    */   
/*    */   private final String name_;
/*    */ 
/*    */ 
/*    */   
/*    */   public static StateJournalType forName(String argName) {
/* 36 */     if (argName == null) {
/* 37 */       return null;
/*    */     }
/* 39 */     StateJournalType found = values_.get(argName.trim().toUpperCase());
/* 40 */     if (found == null) {
/* 41 */       logger_.warn("There is no instance of [" + StateJournalType.class
/* 42 */           .getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*    */     }
/*    */     
/* 45 */     return found;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected StateJournalType(String argName) {
/* 51 */     this.name_ = argName.trim().toUpperCase();
/* 52 */     if (values_ == null) {
/* 53 */       values_ = new HashMap<>();
/*    */     }
/* 55 */     values_.put(this.name_, this);
/*    */   }
/*    */   
/*    */   public String getName() {
/* 59 */     return this.name_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean matches(String argName) {
/* 70 */     return getName().equalsIgnoreCase(argName);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 75 */     return getName();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\systemcycle\StateJournalType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */