/*    */ package dtv.data2.access.query;
/*    */ 
/*    */ import dtv.data2.access.impl.PersistenceConstants;
/*    */ import java.util.Map;
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
/*    */ public class CaseHintProcessingSqlDecorator
/*    */   extends HintProcessingSqlDecorator
/*    */ {
/*    */   public CaseHintProcessingSqlDecorator(Map<String, String> argPatterns) {
/* 22 */     super(argPatterns);
/*    */   }
/*    */ 
/*    */   
/*    */   public CaseHintProcessingSqlDecorator(Map<String, String> argPatterns, String argHintBegin, String argHintEnd) {
/* 27 */     super(argPatterns, argHintBegin, argHintEnd);
/*    */   }
/*    */ 
/*    */   
/*    */   protected String replaceHints(String argInput) {
/* 32 */     if (PersistenceConstants.MANAGE_CASE) {
/* 33 */       return super.replaceHints(argInput);
/*    */     }
/*    */     
/* 36 */     return argInput;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\CaseHintProcessingSqlDecorator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */