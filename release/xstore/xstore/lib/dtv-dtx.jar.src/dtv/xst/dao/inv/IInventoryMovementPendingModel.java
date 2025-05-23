/*    */ package dtv.xst.dao.inv;
/*    */ 
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.daocommon.IInventoriedLineItem;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
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
/*    */ public interface IInventoryMovementPendingModel
/*    */   extends IInventoriedLineItem
/*    */ {
/* 21 */   public static final EventEnum SET_QUANTITY_CURRENTLY_RECONCILED = new EventEnum("set quantityCurrentReconciled");
/*    */   
/*    */   BigDecimal getItemPrice();
/*    */   
/*    */   BigDecimal getQuantityCurrentlyReconciled();
/*    */   
/*    */   BigDecimal getQuantityNeedingReconciled();
/*    */   
/*    */   Date getTransactionDate();
/*    */   
/*    */   void setQuantityCurrentlyReconciled(BigDecimal paramBigDecimal);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryMovementPendingModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */