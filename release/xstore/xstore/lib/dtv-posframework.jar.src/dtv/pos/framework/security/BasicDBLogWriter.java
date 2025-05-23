/*     */ package dtv.pos.framework.security;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.logbuilder.writers.ILogEntryWriter;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.iframework.security.ISecurityLogModel;
/*     */ import dtv.util.TypeSafeMapKey;
/*     */ import dtv.xst.dao.hrs.IEmployee;
/*     */ import dtv.xst.dao.sec.ISecurityLog;
/*     */ import dtv.xst.dao.trn.IPosTransaction;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasicDBLogWriter
/*     */   implements ILogEntryWriter
/*     */ {
/*  31 */   private static final Logger _logger = Logger.getLogger(BasicDBLogWriter.class);
/*     */   
/*     */   private static final String PRIVILEGE_SEPARATOR = "|";
/*     */   
/*     */   private ISecurityLogModel _logModel;
/*     */ 
/*     */   
/*     */   public void close() {
/*  39 */     if (this._logModel == null) {
/*  40 */       _logger.error("A security log model is not present. No security activity will be logged.");
/*     */       
/*     */       return;
/*     */     } 
/*  44 */     ISecurityLog logEntry = (ISecurityLog)DataFactory.createObject(ISecurityLog.class);
/*  45 */     logEntry.setOrganizationId(ConfigurationMgr.getOrganizationId());
/*  46 */     logEntry.setRetailLocationId(this._logModel.getRetailLocationId());
/*  47 */     logEntry.setWorkstationId(this._logModel.getWorkstationId());
/*  48 */     logEntry.setBusinessDate(this._logModel.getCurrentBusinessDate());
/*  49 */     logEntry.setActivityType(this._logModel.getProcessingStep().name());
/*  50 */     logEntry.setSuccess(this._logModel.getSuccess());
/*  51 */     logEntry.setSystemDateTime(new Date());
/*     */     
/*  53 */     if (this._logModel.getSuccess()) {
/*  54 */       if (this._logModel.getSystemUser() instanceof IEmployee) {
/*  55 */         IEmployee employee = (IEmployee)this._logModel.getSystemUser();
/*  56 */         logEntry.setEmployeeId(employee.getEmployeeId());
/*     */       } 
/*     */     } else {
/*     */       
/*  60 */       logEntry.setEmployeeId(this._logModel.getPreviouslyFailedUserId());
/*     */     } 
/*     */     
/*  63 */     IPosTransaction transaction = this._logModel.getRelatedTransaction();
/*     */     
/*  65 */     if (transaction != null) {
/*  66 */       logEntry.setTransactionSequence(transaction.getTransactionSequence());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  74 */     if (this._logModel.getPrivileges() != null && !this._logModel.getPrivileges().isEmpty()) {
/*  75 */       Iterator<String> iter = this._logModel.getPrivileges().iterator();
/*  76 */       StringBuilder builder = new StringBuilder(iter.next());
/*     */       
/*  78 */       while (iter.hasNext()) {
/*  79 */         builder.append("|");
/*  80 */         builder.append(iter.next());
/*     */       } 
/*     */       
/*  83 */       logEntry.setPrivilegeType(builder.toString());
/*     */     } 
/*     */     
/*  86 */     logEntry = setCustomValues(this._logModel, logEntry);
/*  87 */     DataFactory.makePersistent(logEntry);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(Map<TypeSafeMapKey<?>, Object> argSettings) {
/*  93 */     this._logModel = (ISecurityLogModel)ISecurityLogModel.PROP_SECURITY_LOG_MODEL.retrieve(argSettings);
/*     */     
/*  95 */     if (this._logModel == null) {
/*  96 */       _logger.error("A security log model was not provided as a setting to the security log writer. No security activity entry can be logged.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(String argString) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ISecurityLog setCustomValues(ISecurityLogModel argLogModel, ISecurityLog argSecurityLog) {
/* 113 */     return argSecurityLog;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\security\BasicDBLogWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */