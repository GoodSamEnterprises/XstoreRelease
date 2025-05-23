/*    */ package dtv.pos.storecalendar.fourfivefour;
/*    */ 
/*    */ import dtv.util.DateUtils;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.PositiveIntegerConfig;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FourFiveFourCalendarConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   protected Date epoch_;
/* 22 */   protected List<Date> closedDates_ = new ArrayList<>();
/* 23 */   protected List<Integer> closedDayOfWeeks_ = new ArrayList<>();
/*    */   
/*    */   public List<Date> getClosedDates() {
/* 26 */     return this.closedDates_;
/*    */   }
/*    */   
/*    */   public List<Integer> getClosedDayOfWeeks() {
/* 30 */     return this.closedDayOfWeeks_;
/*    */   }
/*    */   
/*    */   public Date getEpoch() {
/* 34 */     return this.epoch_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 45 */     if ("Epoch".equalsIgnoreCase(argKey)) {
/* 46 */       String temp = argValue.toString();
/* 47 */       if (temp.indexOf('T') > 0) {
/* 48 */         this.epoch_ = DateUtils.parseIso(temp);
/*    */       } else {
/*    */         
/* 51 */         this.epoch_ = DateUtils.parseDate(temp);
/*    */       }
/*    */     
/* 54 */     } else if ("ClosedDayOfWeek".equalsIgnoreCase(argKey)) {
/* 55 */       this.closedDayOfWeeks_.add(((PositiveIntegerConfig)argValue).getInteger());
/*    */     }
/* 57 */     else if ("ClosedDate".equalsIgnoreCase(argKey)) {
/* 58 */       this.closedDates_.add(ConfigUtils.toDate(argValue));
/*    */     } else {
/*    */       
/* 61 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\fourfivefour\FourFiveFourCalendarConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */