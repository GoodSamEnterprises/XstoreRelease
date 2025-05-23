/*     */ package dtv.pos.framework.action;
/*     */ 
/*     */ import dtv.data2x.DataServiceUtils;
/*     */ import dtv.pos.framework.action.type.XstDataActionKey;
/*     */ import dtv.pos.framework.action.type.XstDataActionType;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.action.IXstActionType;
/*     */ import dtv.pos.iframework.action.IXstDataAction;
/*     */ import dtv.pos.iframework.action.IXstDataActionKey;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.event.IXstEventListener;
/*     */ import dtv.pos.iframework.security.ISecurityResponse;
/*     */ import dtv.pos.iframework.ui.model.IPromptActionModel;
/*     */ import dtv.pos.iframework.ui.model.IUIInputModel;
/*     */ import java.awt.event.ActionEvent;
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
/*     */ public class XstDataAction
/*     */   extends XstDefaultAction
/*     */   implements IXstDataAction
/*     */ {
/*  32 */   private static final Logger logger_ = Logger.getLogger(XstDataAction.class);
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   private IUIInputModel dataModel_;
/*     */   private IPromptActionModel parent_;
/*     */   
/*     */   public XstDataAction(XstDataActionType argType, IXstDataActionKey argKey) {
/*  39 */     super((IXstActionType)argType, (IXstActionKey)argKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyAccessGranted(ISecurityResponse argResponse) {
/*  45 */     Object data = null;
/*  46 */     IUIInputModel m = getModel();
/*     */     
/*  48 */     if (m != null) {
/*  49 */       data = m.getUserInput();
/*     */       
/*  51 */       if (data instanceof String) {
/*  52 */         setData(((String)data).trim());
/*     */       } else {
/*     */         
/*  55 */         setData(data);
/*     */       } 
/*     */     } 
/*     */     
/*  59 */     IXstAction action = this;
/*     */ 
/*     */ 
/*     */     
/*  63 */     if (getData() instanceof IXstAction && !XstDataActionKey.CANCEL.equals(getActionKey())) {
/*  64 */       action = (IXstAction)getData();
/*  65 */       clearModels();
/*     */       
/*  67 */       action.actionPerformed(new ActionEvent(this, 0, ""));
/*     */       
/*     */       return;
/*     */     } 
/*  71 */     if (logger_.isDebugEnabled()) {
/*  72 */       logger_.debug("Sending an XstDataAction:\n\tlistener: [" + getEventListener() + "]\n\tdata: [" + 
/*  73 */           DataServiceUtils.toObscuredString(data, true) + "]");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     IXstEventListener listener = getEventListener();
/*  81 */     setEventListener(null);
/*     */     
/*  83 */     listener.handleXstEvent((IXstEvent)action);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setModel(IUIInputModel dataModel) {
/*  89 */     this.dataModel_ = dataModel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParent(IPromptActionModel parent) {
/*  95 */     this.parent_ = parent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IUIInputModel getModel() {
/* 105 */     return this.dataModel_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void clearModels() {
/* 112 */     if (getModel() != null)
/*     */     {
/*     */ 
/*     */       
/* 116 */       getModel().clearView();
/*     */     }
/*     */     
/* 119 */     if (this.parent_ != null) {
/* 120 */       this.parent_.clearModel();
/*     */     }
/*     */     
/* 123 */     setModel((IUIInputModel)null);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\XstDataAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */