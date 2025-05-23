/*    */ package dtv.pos.common;
/*    */ 
/*    */ import java.time.LocalDate;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class BusinessDate
/*    */ {
/*    */   private final LocalDate businessDate;
/*    */   private final BusinessDateQualifier qualifier;
/*    */   
/*    */   public BusinessDate(LocalDate argBusinessDate, BusinessDateQualifier argQualifier) {
/* 30 */     this.businessDate = argBusinessDate;
/* 31 */     this.qualifier = argQualifier;
/*    */   }
/*    */   
/*    */   public LocalDate getBusinessDate() {
/* 35 */     return this.businessDate;
/*    */   }
/*    */   
/*    */   public BusinessDateQualifier getQualifier() {
/* 39 */     return this.qualifier;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\BusinessDate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */