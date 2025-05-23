/*    */ package dtv.pos.framework.tax;
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
/*    */ public class TaxSystemType
/*    */ {
/* 20 */   private static final Logger logger_ = Logger.getLogger(TaxSystemType.class);
/*    */ 
/*    */   
/* 23 */   public static final TaxSystemType XSTORE = new TaxSystemType("XSTORE");
/*    */ 
/*    */ 
/*    */   
/*    */   private static Map<String, TaxSystemType> values_;
/*    */ 
/*    */ 
/*    */   
/*    */   private final String name_;
/*    */ 
/*    */ 
/*    */   
/*    */   public static TaxSystemType forName(String argName) {
/* 36 */     if (argName == null) {
/* 37 */       return null;
/*    */     }
/* 39 */     TaxSystemType found = values_.get(argName.trim().toUpperCase());
/* 40 */     if (found == null) {
/* 41 */       logger_.warn("There is no instance of [" + TaxSystemType.class
/* 42 */           .getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
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
/*    */   protected TaxSystemType(String argName) {
/* 57 */     this.name_ = argName.trim().toUpperCase();
/* 58 */     if (values_ == null) {
/* 59 */       values_ = new HashMap<>();
/*    */     }
/* 61 */     values_.put(this.name_, this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object other) {
/* 66 */     if (other == this) {
/* 67 */       return true;
/*    */     }
/* 69 */     if (other instanceof String) {
/* 70 */       return ((String)other).equalsIgnoreCase(this.name_);
/*    */     }
/* 72 */     if (other instanceof TaxSystemType) {
/* 73 */       return this.name_.equals(((TaxSystemType)other).name_);
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 79 */     return this.name_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 85 */     return this.name_.hashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 95 */     return this.name_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\tax\TaxSystemType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */