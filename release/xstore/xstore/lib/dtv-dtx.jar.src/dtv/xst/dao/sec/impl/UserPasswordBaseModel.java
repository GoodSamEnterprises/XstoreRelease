/*    */ package dtv.xst.dao.sec.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.util.CalendarField;
/*    */ import dtv.util.DateUtils;
/*    */ import dtv.xst.dao.sec.IUserPassword;
/*    */ import dtv.xst.dao.sec.IUserPasswordProperty;
/*    */ import dtv.xst.dao.sec.IUserRole;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class UserPasswordBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IUserPasswordProperty>
/*    */   implements IUserPassword
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 25 */   private int passwordLifeSpanInDays_ = 90;
/* 26 */   private int passwordFailureLifeSpanInMinutes_ = 30;
/*    */ 
/*    */ 
/*    */   
/*    */   public Date getExpiration() {
/* 31 */     return DateUtils.dateAdd(CalendarField.DAY, this.passwordLifeSpanInDays_, getEffectiveDate());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String[] getRoles() {
/* 37 */     List<IUserRole> roleObjects = getRoleObjects();
/* 38 */     List<String> roles = new ArrayList<>();
/*    */     
/* 40 */     if (roleObjects != null && !roleObjects.isEmpty()) {
/* 41 */       for (IUserRole role : roleObjects) {
/* 42 */         roles.add(role.getRoleCode());
/*    */       }
/* 44 */       return roles.<String>toArray(new String[roles.size()]);
/*    */     } 
/*    */     
/* 47 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isLockedOut() {
/* 53 */     Calendar lockoutCalendarReleaseDate = null;
/* 54 */     if (getLockedOutTimeStamp() != null) {
/* 55 */       lockoutCalendarReleaseDate = Calendar.getInstance();
/* 56 */       lockoutCalendarReleaseDate.setTime(getLockedOutTimeStamp());
/* 57 */       lockoutCalendarReleaseDate.add(12, this.passwordFailureLifeSpanInMinutes_);
/*    */     } 
/*    */     
/* 60 */     if (lockoutCalendarReleaseDate != null && 
/* 61 */       DateUtils.getNewDate().before(lockoutCalendarReleaseDate.getTime())) {
/* 62 */       return true;
/*    */     }
/*    */     
/* 65 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setPasswordFailureLifeSpanInMinutes(int argPasswordFailureLifeSpan) {
/* 77 */     this.passwordFailureLifeSpanInMinutes_ = argPasswordFailureLifeSpan;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setPasswordLifeSpanInDays(int argPasswordLifeSpan) {
/* 88 */     this.passwordLifeSpanInDays_ = argPasswordLifeSpan;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\UserPasswordBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */