/*     */ package dtv.pos.framework.ui.context;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.LocaleManager;
/*     */ import dtv.pos.iframework.type.ModelKey;
/*     */ import dtv.pos.iframework.ui.context.IComponentState;
/*     */ import dtv.pos.iframework.ui.context.IUIContext;
/*     */ import dtv.ui.context.Context;
/*     */ import dtv.ui.context.ContextID;
/*     */ import dtv.util.MutableString;
/*     */ import java.awt.Color;
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
/*     */ public class UIContext
/*     */   extends Context
/*     */   implements IUIContext
/*     */ {
/*     */   private IFormattable helpKey_;
/*     */   private IComponentState[] componentStates_;
/*     */   private ModelKey listModelKey_;
/*     */   private MutableString title_;
/*     */   private MutableString text1_;
/*     */   private MutableString text2_;
/*     */   private Color bgColor_;
/*     */   private Color bgColor2_;
/*     */   private Color fgColor_;
/*     */   private Color highlightColor_;
/*     */   private SecondDisplayMode secondDisplayMode_;
/*     */   private boolean secondDisplayTransitionEnabled_ = true;
/*     */   
/*     */   public UIContext(String argContextKey) {
/*  43 */     super(new ContextID(argContextKey));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getBackgroundColor() {
/*  53 */     return this.bgColor_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getBackgroundColor2() {
/*  59 */     return this.bgColor2_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IComponentState[] getComponentStates() {
/*  70 */     return this.componentStates_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getForegroundColor() {
/*  80 */     return this.fgColor_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getHelpKey() {
/*  90 */     return this.helpKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getHighlightColor() {
/* 100 */     return this.highlightColor_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelKey getListModelKey() {
/* 110 */     return this.listModelKey_;
/*     */   }
/*     */   
/*     */   public SecondDisplayMode getSecondDisplayMode() {
/* 114 */     return this.secondDisplayMode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableString getText1() {
/* 123 */     return this.text1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableString getText2() {
/* 132 */     return this.text2_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableString getTitle() {
/* 141 */     return this.title_;
/*     */   }
/*     */   
/*     */   public boolean isSecondDisplayTransitionEnabled() {
/* 145 */     return this.secondDisplayTransitionEnabled_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBackgroundColor(Color argColor) {
/* 155 */     this.bgColor_ = argColor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBackgroundColor2(Color argColor) {
/* 161 */     this.bgColor2_ = argColor;
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
/*     */   public void setComponentStates(IComponentState[] argComponentStates) {
/* 173 */     this.componentStates_ = argComponentStates;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForegroundColor(Color argColor) {
/* 183 */     this.fgColor_ = argColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHelpKey(IFormattable argHelpKey) {
/* 192 */     this.helpKey_ = argHelpKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHighlightColor(Color argColor) {
/* 202 */     this.highlightColor_ = argColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setListModelKey(ModelKey argModelKey) {
/* 212 */     this.listModelKey_ = argModelKey;
/*     */   }
/*     */   
/*     */   public void setSecondDisplayMode(SecondDisplayMode argMode) {
/* 216 */     this.secondDisplayMode_ = argMode;
/*     */   }
/*     */   
/*     */   public void setSecondDisplayTransitionEnabled(boolean argEnabled) {
/* 220 */     this.secondDisplayTransitionEnabled_ = argEnabled;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setText1(IFormattable argText1) {
/* 229 */     this.text1_ = LocaleManager.getInstance().getRegisteredString(argText1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setText2(IFormattable argText2) {
/* 238 */     this.text2_ = LocaleManager.getInstance().getRegisteredString(argText2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTitle(IFormattable argTitle) {
/* 247 */     this.title_ = LocaleManager.getInstance().getRegisteredString(argTitle);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\context\UIContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */