/*     */ package dtv.pos.framework.ui.component;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.assistance.ITrainingModeHelper;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.ui.ComponentID;
/*     */ import dtv.ui.action.AbstractActionPropertyChangeListener;
/*     */ import dtv.ui.context.IContextChangeListener;
/*     */ import dtv.ui.swing.DtvButton;
/*     */ import dtv.ui.temp.UIAccessLevel;
/*     */ import dtv.util.MutableString;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.KeyStroke;
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
/*     */ public class XstButton
/*     */   implements IXstViewComponent
/*     */ {
/*     */   private final DtvButton button_;
/*     */   private PropertyChangeListener listener_;
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */   
/*     */   public XstButton() {
/*  45 */     this(null, null);
/*     */   }
/*     */   
/*     */   public XstButton(ComponentID argId) {
/*  49 */     this(null, null, argId);
/*     */   }
/*     */   
/*     */   public XstButton(IXstAction action) {
/*  53 */     this(action, null);
/*     */   }
/*     */   
/*     */   public XstButton(IXstAction action, KeyStroke fixedKeyStroke) {
/*  57 */     this(action, fixedKeyStroke, null);
/*     */   }
/*     */   
/*     */   public XstButton(IXstAction action, KeyStroke fixedKeyStroke, ComponentID id) {
/*  61 */     InjectionHammer.forceAtInjectProcessing(this);
/*  62 */     this.button_ = new DtvButton(id, (Action)action);
/*  63 */     this.button_.setFixedKeyStroke(fixedKeyStroke);
/*  64 */     this.button_.setAlwaysCapsEnabled(ConfigurationMgr.isTextAllCapsOnButtons());
/*     */     
/*  66 */     ((IModeController)this._modeProvider.get()).getContextManager().addContextChangeListener((IContextChangeListener)this.button_, ITrainingModeHelper.TRAINING_MODE_CONTEXT_CONSTRAINT);
/*     */   }
/*     */ 
/*     */   
/*     */   public XstButton(KeyStroke fixedKeyStroke) {
/*  71 */     this(null, fixedKeyStroke);
/*     */   }
/*     */   
/*     */   public Action getAction() {
/*  75 */     return getButton().getAction();
/*     */   }
/*     */   
/*     */   public DtvButton getButton() {
/*  79 */     return this.button_;
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
/*     */   public JComponent getDisplayComponent() {
/*  91 */     return (JComponent)getButton();
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  96 */     return (JComponent)getButton();
/*     */   }
/*     */   
/*     */   public KeyStroke getKeyStroke() {
/* 100 */     return getButton().getKeyStroke();
/*     */   }
/*     */   
/*     */   public String getKeyStrokeText() {
/* 104 */     return getButton().getKeyStrokeText();
/*     */   }
/*     */   
/*     */   public void setAction(Action action) {
/* 108 */     if (getAction() != null) {
/* 109 */       getAction().removePropertyChangeListener(this.listener_);
/*     */     }
/*     */     
/* 112 */     if (action != null) {
/* 113 */       this.listener_ = createActionPropertyChangeListener(action);
/* 114 */       action.addPropertyChangeListener(this.listener_);
/*     */     } 
/* 116 */     getButton().setAction(action);
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled) {
/* 120 */     getButton().setEnabled(enabled);
/*     */   }
/*     */   
/*     */   public void setFixedKeyStroke(KeyStroke fixedKeyStroke) {
/* 124 */     getButton().setFixedKeyStroke(fixedKeyStroke);
/*     */   }
/*     */   
/*     */   public void setKeyStrokeText(MutableString text) {
/* 128 */     getButton().setKeyStrokeText(text);
/*     */   }
/*     */   
/*     */   public void setText(IFormattable text) {
/* 132 */     getButton().setText(text.toString(OutputContextType.VIEW));
/*     */   }
/*     */   
/*     */   public void setText(String text) {
/* 136 */     getButton().setText(text);
/*     */   }
/*     */   
/*     */   protected PropertyChangeListener createActionPropertyChangeListener(Action action) {
/* 140 */     return (PropertyChangeListener)new XstButtonActionPropertyChangeListener(getButton(), action);
/*     */   }
/*     */   
/*     */   protected static class XstButtonActionPropertyChangeListener
/*     */     extends AbstractActionPropertyChangeListener {
/*     */     public XstButtonActionPropertyChangeListener(DtvButton button, Action action) {
/* 146 */       super((JComponent)button, action);
/*     */     }
/*     */ 
/*     */     
/*     */     public void propertyChange(PropertyChangeEvent event) {
/* 151 */       String type = event.getPropertyName();
/* 152 */       if (type == null) {
/*     */         return;
/*     */       }
/* 155 */       DtvButton button = (DtvButton)getTarget();
/*     */       
/* 157 */       if (button == null) {
/* 158 */         IXstAction action = (IXstAction)event.getSource();
/* 159 */         action.removePropertyChangeListener((PropertyChangeListener)this);
/*     */         
/*     */         return;
/*     */       } 
/* 163 */       if (type == "Name") {
/* 164 */         IFormattable newValue = (IFormattable)event.getNewValue();
/* 165 */         button.setText(newValue.toString(OutputContextType.VIEW));
/*     */       }
/* 167 */       else if (type == "AccessLevel") {
/* 168 */         UIAccessLevel visibility = (UIAccessLevel)event.getNewValue();
/* 169 */         button.setAccessLevel(visibility);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */