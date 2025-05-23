/*     */ package dtv.pos.framework.security;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IPersistenceMgrType;
/*     */ import dtv.data2.access.pm.PersistenceManagerType;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.xst.dao.crm.IParty;
/*     */ import dtv.xst.dao.crm.PartyId;
/*     */ import dtv.xst.dao.hrs.IEmployeeAnswers;
/*     */ import dtv.xst.dao.hrs.IWorkCodes;
/*     */ import dtv.xst.dao.sec.IGroup;
/*     */ import dtv.xst.daocommon.ISystemUser;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public class DefaultSystemUser
/*     */   implements ISystemUser
/*     */ {
/*  30 */   private static final Logger _logger = Logger.getLogger(DefaultSystemUser.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  36 */   public static final ISystemUser INSTANCE = new DefaultSystemUser();
/*     */   
/*  38 */   private final long operatorId = 0L;
/*     */   
/*     */   private IParty operatorParty;
/*     */   private static String preferredLocale;
/*     */   private IWorkCodes workCode;
/*     */   
/*     */   public DefaultSystemUser() {
/*  45 */     preferredLocale = ConfigurationMgr.getHelper().getString(new String[] { "Store", "SystemConfig", "Locale", "DefaultSystemLocale" });
/*     */     
/*  47 */     if (preferredLocale == null) {
/*  48 */       preferredLocale = "en_US";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getClockedIn() {
/*  55 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getClockInNotRequired() {
/*  61 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IEmployeeAnswers> getEmployeeAnswers() {
/*  67 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getGroupMembership() {
/*  73 */     return new byte[] { 1 };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getLockedOut() {
/*  79 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getLockedOutTimestamp() {
/*  85 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOperatorId() {
/*  91 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized IParty getOperatorParty() {
/*  97 */     if (this.operatorParty == null) {
/*  98 */       this.operatorParty = getParty(0L);
/*     */     }
/*     */     
/* 101 */     return this.operatorParty;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPreferredLocale() {
/* 107 */     return preferredLocale;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IGroup getPrimaryGroup() {
/* 113 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IWorkCodes getWorkCode() {
/* 119 */     return this.workCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isClockedIn() {
/* 125 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLockedOut() {
/* 131 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClockedIn(boolean argClockedIn) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLockedOut(boolean argLockedOut) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLockedOutTimestamp(Date argLockedOutTimestamp) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkCode(IWorkCodes iWorkCodes) {
/* 149 */     this.workCode = iWorkCodes;
/*     */   }
/*     */ 
/*     */   
/*     */   private IParty getParty(long argId) {
/*     */     try {
/* 155 */       PartyId partyId = new PartyId();
/* 156 */       partyId.setPartyId(Long.valueOf(argId));
/*     */       
/* 158 */       return (IParty)DataFactory.getObjectById((IObjectId)partyId, (IPersistenceMgrType)PersistenceManagerType.forName("REGISTER_CORE"));
/*     */     }
/* 160 */     catch (Exception ex) {
/* 161 */       _logger.error("Error initializing default system user!", ex);
/* 162 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\security\DefaultSystemUser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */