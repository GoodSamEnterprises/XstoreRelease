/*     */ package dtv.pos.framework.security;
/*     */ 
/*     */ import dtv.xst.dao.crm.IParty;
/*     */ import dtv.xst.dao.hrs.IEmployeeAnswers;
/*     */ import dtv.xst.dao.hrs.IWorkCodes;
/*     */ import dtv.xst.dao.sec.IGroup;
/*     */ import dtv.xst.daocommon.ISystemUser;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UserSecurityAccessChecker
/*     */ {
/*     */   private final ISystemUser _refUser;
/*     */   private final boolean _allowAccessToEqualRank;
/*     */   
/*     */   public static boolean isAccessAllowed(ISystemUser argRefUser, ISystemUser argOtherUser, boolean argAllowAccessToEqualRank) {
/*  38 */     return (new UserSecurityAccessChecker(argRefUser, argAllowAccessToEqualRank)).isAccessAllowed(argOtherUser);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isAccessAllowedToGroup(ISystemUser argRefUser, IGroup argGroup, boolean argAllowAccessToEqualRank) {
/*  56 */     return (new UserSecurityAccessChecker(argRefUser, argAllowAccessToEqualRank))
/*  57 */       .isAccessAllowed(createDummyUser(argGroup));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ISystemUser createDummyUser(final IGroup argGroup) {
/*  68 */     return new ISystemUser()
/*     */       {
/*     */         public boolean getClockedIn() {
/*  71 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean getClockInNotRequired() {
/*  76 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public List<IEmployeeAnswers> getEmployeeAnswers() {
/*  81 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public byte[] getGroupMembership() {
/*  87 */           return new byte[] { 1 };
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean getLockedOut() {
/*  92 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public Date getLockedOutTimestamp() {
/*  97 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public long getOperatorId() {
/* 102 */           return 0L;
/*     */         }
/*     */ 
/*     */         
/*     */         public IParty getOperatorParty() {
/* 107 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public String getPreferredLocale() {
/* 112 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public IGroup getPrimaryGroup() {
/* 118 */           return argGroup;
/*     */         }
/*     */ 
/*     */         
/*     */         public IWorkCodes getWorkCode() {
/* 123 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isClockedIn() {
/* 128 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isLockedOut() {
/* 133 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void setClockedIn(boolean argClockedIn) {}
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void setLockedOut(boolean argLockedOut) {}
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void setLockedOutTimestamp(Date argLockedOutTimestamp) {}
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void setWorkCode(IWorkCodes argCode) {}
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UserSecurityAccessChecker(ISystemUser argRefUser, boolean argAllowAccessToEqualRank) {
/* 163 */     this._refUser = argRefUser;
/* 164 */     this._allowAccessToEqualRank = argAllowAccessToEqualRank;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAccessAllowed(ISystemUser argOtherUser) {
/* 175 */     boolean allowAccess = false;
/*     */     
/* 177 */     if (this._refUser.equals(argOtherUser)) {
/*     */       
/* 179 */       allowAccess = true;
/*     */     } else {
/*     */       
/* 182 */       int refGroupRank = this._refUser.getPrimaryGroup().getGroupRank();
/* 183 */       int otherGroupRank = argOtherUser.getPrimaryGroup().getGroupRank();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 188 */       allowAccess = (refGroupRank > otherGroupRank || (refGroupRank == otherGroupRank && this._allowAccessToEqualRank));
/*     */     } 
/*     */ 
/*     */     
/* 192 */     return allowAccess;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\security\UserSecurityAccessChecker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */