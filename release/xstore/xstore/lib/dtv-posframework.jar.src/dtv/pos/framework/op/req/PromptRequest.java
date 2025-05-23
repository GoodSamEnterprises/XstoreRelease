/*     */ package dtv.pos.framework.op.req;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.common.PromptKey;
/*     */ import dtv.pos.framework.ui.config.PromptConfig;
/*     */ import dtv.pos.iframework.op.req.IUIOpRequest;
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
/*     */ public class PromptRequest
/*     */   implements IUIOpRequest
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  24 */   public static final PromptKey BLANK_TEXT_PROMPT = PromptKey.valueOf("EMPTY_DISABLED_TEXT");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final PromptConfig _promptConfig;
/*     */ 
/*     */ 
/*     */   
/*     */   protected final PromptKey _promptKey;
/*     */ 
/*     */ 
/*     */   
/*     */   protected final IFormattable[] _promptArgs;
/*     */ 
/*     */ 
/*     */   
/*     */   private final FormKey _parentFormKey;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PromptRequest(PromptKey promptKey, PromptConfig config, FormKey argParentFormKey, IFormattable... promptArgs) {
/*  47 */     this._promptKey = (promptKey != null) ? promptKey : PromptKey.DEFAULT;
/*  48 */     this._promptArgs = promptArgs;
/*  49 */     this._promptConfig = config;
/*  50 */     this._parentFormKey = argParentFormKey;
/*     */     
/*  52 */     if (this._promptConfig == null) {
/*  53 */       throw new NullPointerException();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormKey getParentFormKey() {
/*  62 */     return this._parentFormKey;
/*     */   }
/*     */   
/*     */   public IFormattable[] getPromptArgs() {
/*  66 */     return this._promptArgs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PromptConfig getPromptConfig() {
/*  76 */     return this._promptConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PromptKey getPromptKey() {
/*  85 */     return this._promptKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRequestType() {
/*  91 */     return OpRequestType.PROMPT.name() + "_" + this._promptConfig.getPromptType();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUiRequestKey() {
/*  97 */     return getPromptKey().toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder str = new StringBuilder(200);
/* 104 */     str.append(getClass().getName());
/* 105 */     str.append("::PromptKey = ").append(getPromptKey());
/*     */     
/* 107 */     if (getPromptArgs() != null) {
/* 108 */       str.append("::Arguments = [").append(getPromptArgs()).append("]");
/*     */     }
/*     */     
/* 111 */     return str.toString();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\PromptRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */