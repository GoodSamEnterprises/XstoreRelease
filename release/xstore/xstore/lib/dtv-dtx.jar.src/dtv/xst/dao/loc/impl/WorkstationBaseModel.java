/*    */ package dtv.xst.dao.loc.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.loc.IWorkstation;
/*    */ import dtv.xst.dao.loc.IWorkstationModel;
/*    */ import dtv.xst.dao.loc.IWorkstationProperty;
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
/*    */ public abstract class WorkstationBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IWorkstationProperty>
/*    */   implements IWorkstation, IWorkstationModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String workstationState_;
/*    */   
/*    */   public String getWorkstationState() {
/* 28 */     return this.workstationState_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setWorkstationState(String argWorkstationState) {
/* 34 */     this.workstationState_ = argWorkstationState;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\WorkstationBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */