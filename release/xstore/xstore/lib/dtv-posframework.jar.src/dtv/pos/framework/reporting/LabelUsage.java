/*    */ package dtv.pos.framework.reporting;
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
/*    */ public class LabelUsage
/*    */ {
/* 18 */   private static final Logger logger_ = Logger.getLogger(LabelUsage.class);
/*    */ 
/*    */   
/* 21 */   public static final LabelUsage ADDRESS = new LabelUsage("ADDRESS");
/* 22 */   public static final LabelUsage ITEM_TAG = new LabelUsage("ITEM_TAG");
/*    */ 
/*    */ 
/*    */   
/*    */   private static Map<String, LabelUsage> values_;
/*    */ 
/*    */ 
/*    */   
/*    */   private final String name_;
/*    */ 
/*    */ 
/*    */   
/*    */   public static LabelUsage forName(String argName) {
/* 35 */     if (argName == null) {
/* 36 */       return null;
/*    */     }
/* 38 */     LabelUsage found = values_.get(argName.trim().toUpperCase());
/* 39 */     if (found == null) {
/* 40 */       logger_.warn("There is no instance of [" + LabelUsage.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*    */     }
/*    */     
/* 43 */     return found;
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
/*    */   protected LabelUsage(String argName) {
/* 55 */     this.name_ = argName.trim().toUpperCase();
/* 56 */     if (values_ == null) {
/* 57 */       values_ = new HashMap<>();
/*    */     }
/* 59 */     values_.put(this.name_, this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object argOther) {
/* 64 */     if (argOther == this) {
/* 65 */       return true;
/*    */     }
/* 67 */     if (!(argOther instanceof LabelUsage)) {
/* 68 */       return false;
/*    */     }
/* 70 */     LabelUsage other = (LabelUsage)argOther;
/*    */     
/* 72 */     return other.name_.equals(other.name_);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 81 */     return this.name_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 86 */     return this.name_.hashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 96 */     return "LabelUsage[" + this.name_ + "]";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\LabelUsage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */