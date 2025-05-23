/*     */ package dtv.pos.framework;
/*     */ 
/*     */ import dtv.pos.common.OpChainKey;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.security.StationState;
/*     */ import dtv.pos.iframework.ui.config.IActionConfig;
/*     */ import dtv.util.ObjectLock;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
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
/*     */ public class ApplicationData
/*     */ {
/*     */   private final String _key;
/*     */   private final OpChainKey _startupOpChainKey;
/*     */   private final OpChainKey _newUserOpChainKey;
/*     */   private final OpChainKey _loginFromOtherAppOpChainKey;
/*     */   private final IActionConfig _actionConfig;
/*     */   private final Collection<String> _applicationLinks;
/*     */   private final ObjectLock _lock;
/*     */   private final StationState _workstationInfo;
/*  31 */   private int _priority = 0;
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
/*     */   public ApplicationData(String key, OpChainKey startupOpChainKey, OpChainKey newUserOpChainKey, OpChainKey loginOpChainKey, IActionConfig actionConfig, Collection<String> applicationLinks, StationState argWorkstationInfo) {
/*  54 */     this._key = key;
/*  55 */     this._startupOpChainKey = startupOpChainKey;
/*  56 */     this._newUserOpChainKey = newUserOpChainKey;
/*  57 */     this._loginFromOtherAppOpChainKey = loginOpChainKey;
/*  58 */     this._actionConfig = actionConfig;
/*  59 */     this._workstationInfo = argWorkstationInfo;
/*  60 */     this
/*  61 */       ._applicationLinks = (applicationLinks == null || applicationLinks.size() == 0) ? new ArrayList<>() : applicationLinks;
/*     */     
/*  63 */     this._lock = new ObjectLock();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/*  68 */     if (obj == this) {
/*  69 */       return true;
/*     */     }
/*  71 */     if (!(obj instanceof ApplicationData)) {
/*  72 */       return false;
/*     */     }
/*  74 */     return ((ApplicationData)obj)._key.equalsIgnoreCase(this._key);
/*     */   }
/*     */   
/*     */   public IXstAction getAction() {
/*  78 */     return this._actionConfig.getAction(null);
/*     */   }
/*     */   
/*     */   public IActionConfig getActionConfig() {
/*  82 */     return this._actionConfig;
/*     */   }
/*     */   
/*     */   public Collection<String> getApplicationLinks() {
/*  86 */     return this._applicationLinks;
/*     */   }
/*     */   
/*     */   public String getKey() {
/*  90 */     return this._key;
/*     */   }
/*     */   
/*     */   public ObjectLock getLock() {
/*  94 */     return this._lock;
/*     */   }
/*     */   
/*     */   public OpChainKey getLoginOpChainKey() {
/*  98 */     return this._loginFromOtherAppOpChainKey;
/*     */   }
/*     */ 
/*     */   
/*     */   public OpChainKey getNewUserOpChainKey() {
/* 103 */     return this._newUserOpChainKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPriority() {
/* 111 */     return this._priority;
/*     */   }
/*     */ 
/*     */   
/*     */   public OpChainKey getStartupOpChainKey() {
/* 116 */     return this._startupOpChainKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StationState getWorkstationInfo() {
/* 124 */     return this._workstationInfo;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 129 */     return this._key.hashCode();
/*     */   }
/*     */   
/*     */   public void setPriority(int argPriority) {
/* 133 */     this._priority = argPriority;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 138 */     return (this._key != null) ? this._key.toString() : null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\ApplicationData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */