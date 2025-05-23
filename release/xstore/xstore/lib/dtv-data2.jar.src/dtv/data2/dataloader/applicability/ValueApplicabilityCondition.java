/*    */ package dtv.data2.dataloader.applicability;
/*    */ 
/*    */ import dtv.data2.dataloader.DataLoaderUtils;
/*    */ import dtv.data2.dataloader.fileprocessing.FileLine;
/*    */ import dtv.util.ObjectUtils;
/*    */ import java.util.ArrayList;
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
/*    */ 
/*    */ public class ValueApplicabilityCondition
/*    */   extends AbstractApplicabilityCondition
/*    */ {
/*    */   private static final String PARAM_TEST_VALUE = "testValue";
/*    */   private static final String PARAM_APPLICABLE_VALUE = "applicableValue";
/*    */   private static final String PARAM_INVERT = "invert";
/* 27 */   private final List<String> _applicableValueSpecifiers = new ArrayList<>(4);
/*    */   
/* 29 */   private String _testValueSpecifier = null;
/*    */   
/*    */   private boolean _invert = false;
/*    */ 
/*    */   
/*    */   public boolean isApplicable(FileLine argCurrentLine) {
/* 35 */     boolean applicable = false;
/* 36 */     String testValue = DataLoaderUtils.getValueForValueSpecifier(this._testValueSpecifier, argCurrentLine);
/*    */     
/* 38 */     for (String applicableValueSpecifier : this._applicableValueSpecifiers) {
/* 39 */       String applicableValue = DataLoaderUtils.getValueForValueSpecifier(applicableValueSpecifier, argCurrentLine);
/*    */       
/* 41 */       if (ObjectUtils.equivalent(testValue, applicableValue)) {
/* 42 */         applicable = true;
/*    */         break;
/*    */       } 
/*    */     } 
/* 46 */     return this._invert ? (!applicable) : applicable;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argKey, String argValue) {
/* 52 */     if ("testValue".equalsIgnoreCase(argKey)) {
/* 53 */       this._testValueSpecifier = argValue;
/*    */     }
/* 55 */     else if ("applicableValue".equalsIgnoreCase(argKey)) {
/* 56 */       this._applicableValueSpecifiers.add(argValue);
/*    */     }
/* 58 */     else if ("invert".equalsIgnoreCase(argKey)) {
/* 59 */       this._invert = Boolean.valueOf(argValue).booleanValue();
/*    */     } else {
/*    */       
/* 62 */       super.setParameter(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\applicability\ValueApplicabilityCondition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */