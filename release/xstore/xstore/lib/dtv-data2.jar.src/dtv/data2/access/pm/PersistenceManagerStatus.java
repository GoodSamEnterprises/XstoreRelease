/*    */ package dtv.data2.access.pm;
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
/*    */ public class PersistenceManagerStatus
/*    */   implements Comparable<PersistenceManagerStatus>
/*    */ {
/* 20 */   private static final Logger logger_ = Logger.getLogger(PersistenceManagerStatus.class);
/*    */ 
/*    */   
/* 23 */   public static final PersistenceManagerStatus ONLINE = new PersistenceManagerStatus("ONLINE", 0);
/* 24 */   public static final PersistenceManagerStatus OFFLINE = new PersistenceManagerStatus("OFFLINE", 1);
/* 25 */   public static final PersistenceManagerStatus UNAVAILABLE = new PersistenceManagerStatus("UNAVAILABLE", 2);
/*    */ 
/*    */   
/*    */   private static Map<String, PersistenceManagerStatus> values_;
/*    */ 
/*    */   
/*    */   private final String name_;
/*    */ 
/*    */   
/*    */   private final int index_;
/*    */ 
/*    */ 
/*    */   
/*    */   public static PersistenceManagerStatus forName(String argName) {
/* 39 */     if (argName == null) {
/* 40 */       return null;
/*    */     }
/* 42 */     PersistenceManagerStatus found = values_.get(argName.trim());
/* 43 */     if (found == null) {
/* 44 */       logger_.warn("There is no instance of [" + PersistenceManagerStatus.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*    */     }
/*    */     
/* 47 */     return found;
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
/*    */ 
/*    */ 
/*    */   
/*    */   protected PersistenceManagerStatus(String argName, int argIndex) {
/* 62 */     this.name_ = argName.trim();
/* 63 */     this.index_ = argIndex;
/* 64 */     if (values_ == null) {
/* 65 */       values_ = new HashMap<>();
/*    */     }
/* 67 */     values_.put(this.name_, this);
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(PersistenceManagerStatus argStatus) {
/* 72 */     return this.index_ - argStatus.index_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 82 */     return this.name_;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\pm\PersistenceManagerStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */