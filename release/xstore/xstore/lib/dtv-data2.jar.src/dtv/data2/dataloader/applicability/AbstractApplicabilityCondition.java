/*    */ package dtv.data2.dataloader.applicability;
/*    */ 
/*    */ import dtv.data2.dataloader.DataLoaderException;
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
/*    */ public abstract class AbstractApplicabilityCondition
/*    */   implements IApplicabilityCondition
/*    */ {
/*    */   public void setParameter(String argKey, String argValue) {
/* 20 */     throw new DataLoaderException("Unexpected parameter given to " + getClass().getName() + "key: [" + argKey + "] Value: [" + argValue + "]");
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\applicability\AbstractApplicabilityCondition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */