/*     */ package dtv.pos.framework.action;
/*     */ 
/*     */ import dtv.pos.common.OpChainKey;
/*     */ import dtv.pos.framework.op.req.SecurityRequest;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.action.IXstActionType;
/*     */ import dtv.pos.iframework.action.IXstChainAction;
/*     */ import dtv.pos.iframework.action.IXstChainActionType;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.op.IOpChainFactory;
/*     */ import dtv.pos.iframework.op.req.IOpReqHandler;
/*     */ import dtv.pos.iframework.op.req.IOpRequest;
/*     */ import dtv.pos.iframework.security.ISecurityResponse;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
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
/*     */ public class XstChainAction
/*     */   extends XstDefaultAction
/*     */   implements IXstChainAction
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final OpChainKey chainKey_;
/*  40 */   private final List<ISecurityResponse> grantedPrivileges_ = new ArrayList<>();
/*  41 */   private final Collection<String> privileges_ = new ArrayList<>();
/*  42 */   private final List<ISecurityResponse> responsePrivileges_ = new ArrayList<>();
/*     */   
/*     */   private IXstEvent trigger_;
/*     */   
/*     */   private boolean required_;
/*     */   @Inject
/*     */   private IOpChainFactory _opChainFactory;
/*     */   
/*     */   public XstChainAction(IXstChainActionType argType, OpChainKey argChainKey) {
/*  51 */     super((IXstActionType)argType, (IXstActionKey)argChainKey);
/*     */     
/*  53 */     this.chainKey_ = argChainKey;
/*  54 */     setRequired(true);
/*  55 */     setTrigger((IXstEvent)this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addPrivilege(String argType) {
/*  61 */     if (!this.privileges_.contains(argType)) {
/*  62 */       this.privileges_.add(argType);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearPrivilege() {
/*  68 */     this.privileges_.clear();
/*  69 */     this.responsePrivileges_.clear();
/*  70 */     this.grantedPrivileges_.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OpChainKey getOpChainKey() {
/*  76 */     return this.chainKey_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPrivilege() {
/*  81 */     String[] privileges = getPrivileges();
/*  82 */     return (privileges != null && privileges.length > 0) ? privileges[0] : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getPrivileges() {
/*  87 */     return (this.privileges_ == null) ? new String[0] : this.privileges_.<String>toArray(new String[this.privileges_.size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   public IXstEvent getTrigger() {
/*  92 */     return this.trigger_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRequired() {
/*  97 */     return this.required_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValid() {
/* 103 */     return this._opChainFactory.isValidChain(this.chainKey_);
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
/*     */   public void notifyAccessDenied(ISecurityResponse argResponse) {
/* 115 */     this.responsePrivileges_.add(argResponse);
/*     */     
/* 117 */     if (this.responsePrivileges_.size() == (getPrivileges()).length) {
/*     */ 
/*     */       
/* 120 */       this.grantedPrivileges_.clear();
/* 121 */       this.responsePrivileges_.clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyAccessGranted(ISecurityResponse argResponse) {
/* 128 */     this.grantedPrivileges_.add(argResponse);
/* 129 */     this.responsePrivileges_.add(argResponse);
/*     */     
/* 131 */     if (argResponse == null || this.grantedPrivileges_.size() == (getPrivileges()).length) {
/*     */ 
/*     */       
/* 134 */       this.grantedPrivileges_.clear();
/* 135 */       this.responsePrivileges_.clear();
/*     */ 
/*     */       
/* 138 */       getEventListener().handleXstEvent((IXstEvent)this);
/*     */     }
/* 140 */     else if (this.responsePrivileges_.size() == (getPrivileges()).length && this.grantedPrivileges_
/* 141 */       .size() != (getPrivileges()).length) {
/*     */ 
/*     */       
/* 144 */       this.grantedPrivileges_.clear();
/* 145 */       this.responsePrivileges_.clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRequired(boolean required) {
/* 151 */     this.required_ = required;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTrigger(IXstEvent argTrigger) {
/* 156 */     this.trigger_ = argTrigger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void actionPerformedImpl(ActionEvent event) {
/* 163 */     String[] privileges = getPrivileges();
/* 164 */     if (privileges == null || privileges.length < 1) {
/* 165 */       notifyAccessGranted((ISecurityResponse)null);
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */       
/* 173 */       this.grantedPrivileges_.clear();
/* 174 */       this.responsePrivileges_.clear();
/*     */       
/* 176 */       for (String privilege : privileges) {
/* 177 */         if (privilege != null) {
/* 178 */           SecurityRequest securityReq = SecurityRequest.getActionRequest(this, privilege);
/* 179 */           IOpReqHandler securityHandler = this._opReqHandlerFactory.getReqHandler(securityReq.getRequestType());
/* 180 */           securityHandler.handleRequest((IOpRequest)securityReq, getEventListener(), (IModeController)this._modeProvider.get());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\XstChainAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */