/*    */ package dtv.data2.access.exception;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
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
/*    */ public class PrimaryKeyViolationException
/*    */   extends SpecialActionException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 19 */   private static final ExceptionApplicableRule[] rules = new ExceptionApplicableRule[] { new ExceptionApplicableRule("Primary Key"), new ExceptionApplicableRule("Duplicate Key"), new ExceptionApplicableRule("Unique Constraint"), new ExceptionApplicableRule("ORA-00001"), new ExceptionApplicableRule("No primary key value for foreign key", null, false), new ExceptionApplicableRule("violation de contrainte unique") };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private IDataAccessObject offendingDao_;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static PrimaryKeyViolationException getNewException(String argMessage, Throwable argCause, String argDataSourceName) {
/* 32 */     if (argCause instanceof PrimaryKeyViolationException) {
/* 33 */       return (PrimaryKeyViolationException)argCause;
/*    */     }
/*    */     
/* 36 */     return new PrimaryKeyViolationException(argMessage, argCause, argDataSourceName);
/*    */   }
/*    */   
/*    */   public static PrimaryKeyViolationException getNewException(Throwable argCause, String argDataSourceName) {
/* 40 */     if (argCause instanceof PrimaryKeyViolationException) {
/* 41 */       return (PrimaryKeyViolationException)argCause;
/*    */     }
/*    */     
/* 44 */     return new PrimaryKeyViolationException(argCause, argDataSourceName);
/*    */   }
/*    */   
/*    */   public static boolean isPrimaryKeyViolation(Throwable argException) {
/* 48 */     return (new PrimaryKeyViolationException()).isApplicable(argException);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private PrimaryKeyViolationException() {}
/*    */ 
/*    */ 
/*    */   
/*    */   private PrimaryKeyViolationException(String argMessage, Throwable argCause, String argDataSource) {
/* 58 */     super(argMessage, argCause, argDataSource);
/*    */   }
/*    */   
/*    */   private PrimaryKeyViolationException(Throwable argCause, String argDataSource) {
/* 62 */     super(argCause, argDataSource);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IDataAccessObject getOffendingDao() {
/* 69 */     return this.offendingDao_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setOffendingDao(IDataAccessObject argOffendingDao) {
/* 76 */     this.offendingDao_ = argOffendingDao;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ExceptionApplicableRule[] getApplicableRules() {
/* 82 */     return rules;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\exception\PrimaryKeyViolationException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */