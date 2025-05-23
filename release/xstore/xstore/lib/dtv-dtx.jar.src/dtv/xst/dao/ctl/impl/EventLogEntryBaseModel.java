/*    */ package dtv.xst.dao.ctl.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelImpl;
/*    */ import dtv.xst.dao.ctl.IEventLogEntry;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class EventLogEntryBaseModel
/*    */   extends AbstractDataModelImpl
/*    */   implements IEventLogEntry
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void setLogTimestamp(Date argLogTimestamp) {
/* 32 */     if (getArrivalTimestamp() == null)
/* 33 */       setArrivalTimestamp(argLogTimestamp); 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\EventLogEntryBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */