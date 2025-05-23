/*    */ package dtv.pos.framework.systemcycle;
/*    */ 
/*    */ import dtv.data2.access.AbstractQueryResult;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.pos.common.BusinessDateHelper;
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
/*    */ public class BusinessDayQueryResult
/*    */   extends AbstractQueryResult
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private Date _date;
/*    */   
/*    */   public Date getDate() {
/* 26 */     return this._date;
/*    */   }
/*    */   
/*    */   public String getFormattedDate() {
/* 30 */     return BusinessDateHelper.getDateTimeRange(this._date);
/*    */   }
/*    */   
/*    */   public void setDate(Date argDate) {
/* 34 */     this._date = argDate;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IObjectId getObjectIdImpl() {
/* 40 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\systemcycle\BusinessDayQueryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */