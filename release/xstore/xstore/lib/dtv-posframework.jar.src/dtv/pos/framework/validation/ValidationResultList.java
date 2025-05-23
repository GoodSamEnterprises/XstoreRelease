/*    */ package dtv.pos.framework.validation;
/*    */ 
/*    */ import dtv.pos.iframework.validation.IValidationResult;
/*    */ import dtv.pos.iframework.validation.IValidationResultList;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
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
/*    */ public class ValidationResultList
/*    */   implements IValidationResultList
/*    */ {
/* 23 */   private final List<IValidationResult> results_ = new ArrayList<>();
/*    */   
/*    */   private boolean isValid_ = true;
/*    */   
/*    */   private boolean isSecured_ = true;
/*    */   
/*    */   public void add(IValidationResult argResult) {
/* 30 */     if (!argResult.isValid()) {
/* 31 */       this.isValid_ = false;
/* 32 */       this.results_.add(argResult);
/*    */       
/* 34 */       this.isSecured_ &= argResult.isSecured();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addAll(IValidationResultList argOther) {
/* 41 */     this.isValid_ &= argOther.isValid();
/* 42 */     this.isSecured_ &= argOther.isSecured();
/* 43 */     this.results_.addAll(Arrays.asList(argOther.getInvalidResults()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IValidationResult[] getInvalidResults() {
/* 49 */     return this.results_.<IValidationResult>toArray(new IValidationResult[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IValidationResult getInvalidResults(int argIndex) {
/* 55 */     return this.results_.get(argIndex);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isSecured() {
/* 61 */     return this.isSecured_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isValid() {
/* 67 */     return this.isValid_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int size() {
/* 73 */     return this.results_.size();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\validation\ValidationResultList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */