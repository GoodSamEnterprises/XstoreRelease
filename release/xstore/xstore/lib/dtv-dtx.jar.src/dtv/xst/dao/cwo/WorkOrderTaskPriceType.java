/*    */ package dtv.xst.dao.cwo;
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
/*    */ public enum WorkOrderTaskPriceType
/*    */ {
/* 14 */   ESTIMATE, ACTUAL;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 22 */     return name();
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
/* 33 */     return getName().equalsIgnoreCase(argName);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\WorkOrderTaskPriceType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */