/*     */ package dtv.pos.iframework.action;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.swing.Icon;
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
/*     */ public class ActionParameters
/*     */ {
/*     */   private IXstActionKey actionKey_;
/*     */   private IXstActionType actionType_;
/*     */   private Color backgroundColor_;
/*     */   private Object data_;
/*     */   private Icon disabledIcon_;
/*     */   private Font font_;
/*     */   private Color foregroundColor_;
/*     */   private Icon icon_;
/*     */   private Set<IXstKeyStroke> keyStrokes_;
/*  34 */   private List<ParameterConfig> parameters_ = Collections.emptyList();
/*     */   private Icon pressIcon_;
/*     */   private Icon rollIcon_;
/*     */   private IFormattable textKey_;
/*     */   private IFormattable rootTextKey_;
/*  39 */   private List<IVisibilityRule> visibilityRules_ = Collections.emptyList();
/*     */   
/*     */   private boolean visible_;
/*     */   
/*     */   private boolean navigable_ = false;
/*     */   
/*     */   private String keywords_;
/*     */   
/*     */   private String iconKey_;
/*     */   private boolean _dataIsFinal = false;
/*     */   
/*     */   public IXstActionKey getActionKey() {
/*  51 */     return this.actionKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstActionType getActionType() {
/*  59 */     return this.actionType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getBackgroundColor() {
/*  67 */     return this.backgroundColor_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getData() {
/*  75 */     return this.data_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDataIsFinal() {
/*  83 */     return this._dataIsFinal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Icon getDisabledIcon() {
/*  91 */     return this.disabledIcon_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Font getFont() {
/*  99 */     return this.font_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getForegroundColor() {
/* 107 */     return this.foregroundColor_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Icon getIcon() {
/* 115 */     return this.icon_;
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
/*     */   public String getIconKey() {
/* 131 */     return this.iconKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstKeyStroke getKeyStroke() {
/* 139 */     return (this.keyStrokes_ != null && !this.keyStrokes_.isEmpty()) ? ((IXstKeyStroke[])this.keyStrokes_.toArray((T[])new IXstKeyStroke[0]))[0] : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<IXstKeyStroke> getKeyStrokes() {
/* 148 */     return this.keyStrokes_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getKeywords() {
/* 159 */     return this.keywords_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ParameterConfig> getParameters() {
/* 167 */     return this.parameters_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Icon getPressIcon() {
/* 175 */     return this.pressIcon_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Icon getRollIcon() {
/* 183 */     return this.rollIcon_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getRootTextKey() {
/* 191 */     return this.rootTextKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getTextKey() {
/* 199 */     return this.textKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IVisibilityRule> getVisibilityRules() {
/* 207 */     return this.visibilityRules_;
/*     */   }
/*     */   
/*     */   public boolean isNavigable() {
/* 211 */     return this.navigable_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSecure() {
/* 219 */     for (IVisibilityRule rule : getVisibilityRules()) {
/* 220 */       if (rule instanceof dtv.util.security.ISecured) {
/* 221 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 225 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isVisible() {
/* 233 */     return this.visible_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActionKey(IXstActionKey argActionKey) {
/* 241 */     this.actionKey_ = argActionKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActionType(IXstActionType argActionType) {
/* 249 */     this.actionType_ = argActionType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBackgroundColor(Color argBackgroundColor) {
/* 257 */     this.backgroundColor_ = argBackgroundColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setData(Object argData) {
/* 265 */     this.data_ = argData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDataIsFinal(boolean argIsDataFinal) {
/* 273 */     this._dataIsFinal = argIsDataFinal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisabledIcon(Icon argDisabledIcon) {
/* 281 */     this.disabledIcon_ = argDisabledIcon;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFont(Font argFont) {
/* 289 */     this.font_ = argFont;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForegroundColor(Color argForegroundColor) {
/* 297 */     this.foregroundColor_ = argForegroundColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIcon(Icon argIcon) {
/* 305 */     this.icon_ = argIcon;
/*     */   }
/*     */   
/*     */   public void setIconKey(String argIconKey) {
/* 309 */     this.iconKey_ = argIconKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeyStroke(IXstKeyStroke argKeyStroke) {
/* 317 */     this.keyStrokes_ = new HashSet<>(1);
/* 318 */     this.keyStrokes_.add(argKeyStroke);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeyStrokes(Set<IXstKeyStroke> argKeyStrokes) {
/* 326 */     this.keyStrokes_ = argKeyStrokes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeywords(String argKeywords) {
/* 335 */     this.keywords_ = argKeywords;
/*     */   }
/*     */   
/*     */   public void setNavigable(boolean argNavigable) {
/* 339 */     this.navigable_ = argNavigable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameters(List<ParameterConfig> argParams) {
/* 347 */     this.parameters_ = argParams;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPressIcon(Icon argPressIcon) {
/* 355 */     this.pressIcon_ = argPressIcon;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRollIcon(Icon argRollIcon) {
/* 363 */     this.rollIcon_ = argRollIcon;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRootTextKey(IFormattable argTextKey) {
/* 371 */     this.rootTextKey_ = argTextKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextKey(IFormattable argTextKey) {
/* 379 */     this.textKey_ = argTextKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisibilityRules(List<IVisibilityRule> argVisibilityRules) {
/* 387 */     this.visibilityRules_ = argVisibilityRules;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisible(boolean argVisible) {
/* 396 */     this.visible_ = argVisible;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\action\ActionParameters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */