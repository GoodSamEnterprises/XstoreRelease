/*    */ package dtv.xst.dao.hrs.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.hrs.IEmployeeMessage;
/*    */ import dtv.xst.dao.hrs.IEmployeeMessageModel;
/*    */ import dtv.xst.dao.hrs.IEmployeeMessageProperty;
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
/*    */ public abstract class EmployeeMessageBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IEmployeeMessageProperty>
/*    */   implements IEmployeeMessage, IEmployeeMessageModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public Integer getWorkstationIdObject() {
/* 26 */     return getDAO_().getWorkstationId();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setWorkstationIdObject(Integer argWorkstationId) {
/* 32 */     if ((getDAO_().getWorkstationId() == null && argWorkstationId != null) || (
/* 33 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(argWorkstationId))) {
/* 34 */       getDAO_().setWorkstationId(argWorkstationId);
/* 35 */       this._events.post(IEmployeeMessage.SET_WORKSTATIONID, argWorkstationId);
/*    */     } 
/*    */   }
/*    */   
/*    */   private EmployeeMessageDAO getDAO_() {
/* 40 */     return (EmployeeMessageDAO)this._daoImpl;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeMessageBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */