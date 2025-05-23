/*     */ package dtv.pos.framework.ui.model;
/*     */ 
/*     */ import dtv.pos.i18n.HelpLocalizer;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.ui.model.IHelpModel;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
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
/*     */ public class DefaultHelpModel
/*     */   implements IHelpModel
/*     */ {
/*     */   private static final String DEFAULT_HELP_CONTENT_TYPE = "text/plain";
/*     */   private static final String _defaultHelpTitle;
/*     */   private static final String _defaultHelpMessage;
/*  29 */   private static final Collection<? extends IXstAction> _noHelpActions = Collections.emptyList();
/*     */   
/*     */   static {
/*  32 */     _defaultHelpTitle = HelpLocalizer.localize("_defaultHelpTitle", new dtv.i18n.IFormattable[0]);
/*  33 */     _defaultHelpMessage = HelpLocalizer.localize("_defaultHelpMessage", new dtv.i18n.IFormattable[0]);
/*     */   }
/*     */   
/*     */   private IHelpModel.HelpState _helpState;
/*  37 */   private String _helpTitle = null;
/*  38 */   private String _helpInstructions = null;
/*  39 */   private String _helpMessage = null;
/*  40 */   private String _helpContentType = null;
/*  41 */   private Collection<? extends IXstAction> _helpActions = null;
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearModel() {
/*  46 */     this._helpTitle = null;
/*  47 */     this._helpMessage = null;
/*  48 */     this._helpContentType = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearView() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<? extends IXstAction> getHelpActions() {
/*  58 */     return (this._helpActions == null) ? _noHelpActions : this._helpActions;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHelpContentType() {
/*  64 */     return StringUtils.isEmpty(this._helpContentType) ? getDefaultHelpContentType() : this._helpContentType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHelpInstructions() {
/*  70 */     return this._helpInstructions;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHelpMessage() {
/*  76 */     return (this._helpMessage == null) ? getDefaultHelpMessage() : this._helpMessage;
/*     */   }
/*     */ 
/*     */   
/*     */   public IHelpModel.HelpState getHelpState() {
/*  81 */     return this._helpState;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHelpTitle() {
/*  87 */     return (this._helpTitle == null) ? getDefaultHelpTitle() : this._helpTitle;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHelpActions(Collection<? extends IXstAction> argActions) {
/*  93 */     this._helpActions = argActions;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHelpContentType(String argContentType) {
/*  99 */     this._helpContentType = argContentType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHelpInstructions(String argInstructions) {
/* 105 */     this._helpInstructions = argInstructions;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHelpMessage(String argMessage) {
/* 111 */     this._helpMessage = argMessage;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHelpState(IHelpModel.HelpState argHelpState) {
/* 116 */     this._helpState = argHelpState;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHelpTitle(String argTitle) {
/* 122 */     this._helpTitle = argTitle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDefaultHelpContentType() {
/* 130 */     return "text/plain";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDefaultHelpMessage() {
/* 138 */     return _defaultHelpMessage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDefaultHelpTitle() {
/* 146 */     return _defaultHelpTitle;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\DefaultHelpModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */