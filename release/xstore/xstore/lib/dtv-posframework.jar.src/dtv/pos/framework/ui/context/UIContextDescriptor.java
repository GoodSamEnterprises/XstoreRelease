/*     */ package dtv.pos.framework.ui.context;
/*     */ 
/*     */ import dtv.pos.iframework.ui.context.IUIContext;
/*     */ import dtv.pos.iframework.ui.context.IUIContextDescriptor;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.temp.InjectionHammer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UIContextDescriptor
/*     */   implements IUIContextDescriptor
/*     */ {
/*     */   private final String contextKey_;
/*     */   private final long changeType_;
/*     */   private IUIContext context_;
/*     */   private String toString_;
/*     */   @Inject
/*     */   private ContextConfigHelper _contextConfigHelper;
/*     */   
/*     */   public UIContextDescriptor(IUIContext argContext) {
/*  39 */     this(argContext, 4369L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UIContextDescriptor(IUIContext argContext, long argChangeType) {
/*  50 */     this(argContext.getName(), argChangeType);
/*  51 */     this.context_ = argContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UIContextDescriptor(String argContextKey) {
/*  60 */     this(argContextKey, 4369L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UIContextDescriptor(String argContextKey, long argChangeType) {
/*  71 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */     
/*  73 */     if (StringUtils.isEmpty(argContextKey)) {
/*  74 */       throw new IllegalArgumentException("Context key cannot be null!");
/*     */     }
/*     */     
/*  77 */     this.contextKey_ = argContextKey.trim();
/*  78 */     this.changeType_ = argChangeType;
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
/*     */   public long getChangeType() {
/*  90 */     return this.changeType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IUIContext getContext() {
/*  99 */     if (this.context_ == null) {
/* 100 */       this.context_ = this._contextConfigHelper.getContext(this.contextKey_);
/*     */     }
/*     */     
/* 103 */     return this.context_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 112 */     if (this.toString_ == null) {
/* 113 */       this.toString_ = this.contextKey_ + "@" + getChangeType();
/*     */     }
/*     */     
/* 116 */     return this.toString_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\context\UIContextDescriptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */