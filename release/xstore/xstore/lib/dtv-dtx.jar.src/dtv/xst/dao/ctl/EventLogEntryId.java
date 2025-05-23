/*    */ package dtv.xst.dao.ctl;
/*    */ 
/*    */ import dtv.data2.access.AbstractObjectId;
/*    */ import dtv.data2.access.exception.DtxException;
/*    */ import dtv.util.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EventLogEntryId
/*    */   extends AbstractObjectId
/*    */ {
/*    */   private static final long serialVersionUID = 879668264L;
/*    */   
/*    */   public EventLogEntryId() {}
/*    */   
/*    */   public EventLogEntryId(String argObjectIdValue) {
/* 23 */     setValue(argObjectIdValue);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValue(String argObjectIdValue) {
/* 28 */     String str = argObjectIdValue;
/* 29 */     if (StringUtils.isEmpty(str)) {
/* 30 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*    */     }
/*    */     try {
/* 33 */       String[] arrayOfString = str.split("::");
/*    */     }
/* 35 */     catch (Exception ee) {
/* 36 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object ob) {
/* 42 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 46 */     return 0;
/*    */   }
/*    */   
/*    */   public String getDtxTypeName() {
/* 50 */     return "EventLogEntry";
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 55 */     return "EventLogEntry does not define primary key fields.";
/*    */   }
/*    */   
/*    */   public boolean validate() {
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\EventLogEntryId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */