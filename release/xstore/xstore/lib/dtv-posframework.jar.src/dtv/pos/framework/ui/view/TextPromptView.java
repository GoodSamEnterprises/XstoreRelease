/*     */ package dtv.pos.framework.ui.view;
/*     */ 
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventConstraint;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.constraint.NameConstraint;
/*     */ import dtv.hardware.HardwareMgr;
/*     */ import dtv.pos.framework.action.XstDataAction;
/*     */ import dtv.pos.framework.ui.component.XstFocusBarTextField;
/*     */ import dtv.pos.framework.ui.config.IconGroupConfig;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.IModel;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
/*     */ import dtv.pos.iframework.ui.config.IPromptConfig;
/*     */ import dtv.pos.iframework.ui.model.IPromptModel;
/*     */ import dtv.pos.iframework.ui.model.ITextPromptModel;
/*     */ import dtv.pos.iframework.ui.model.IUIInputModel;
/*     */ import dtv.pos.ui.component.PosComponentFactory;
/*     */ import dtv.pos.ui.component.PosFocusBar;
/*     */ import dtv.pos.ui.component.PosTextField;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.context.IContextChangeListener;
/*     */ import dtv.ui.swing.DtvPanel;
/*     */ import dtv.util.MutableString;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Component;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.text.ParseException;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.event.DocumentEvent;
/*     */ import javax.swing.event.DocumentListener;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TextPromptView
/*     */   extends AbstractUIView<ITextPromptModel>
/*     */ {
/*  44 */   private static final Logger logger = Logger.getLogger(TextPromptView.class);
/*  45 */   private static final IEventConstraint SET_VALUES_CONSTRAINT = (IEventConstraint)new NameConstraint(IPromptModel.SET_VALUES);
/*     */   
/*  47 */   private final Icon fingerprintIcon_ = UIRM.getImageIcon("_imageEnrollFingerAvailableFocusbar");
/*     */ 
/*     */   
/*     */   private final IEventAware modelChangeHandler_;
/*     */ 
/*     */   
/*     */   private PosFocusBar focusBar_;
/*     */   
/*     */   private DtvPanel focusPanel_;
/*     */ 
/*     */   
/*     */   public TextPromptView() {
/*  59 */     ITextPromptModel model = ((IModeController)this._modeProvider.get()).getStationModel().getTextPromptModel();
/*  60 */     this.modelChangeHandler_ = (IEventAware)new EventHandler()
/*     */       {
/*     */         protected void handle(Event argEvent)
/*     */         {
/*  64 */           TextPromptView.this.handleModelChange(argEvent);
/*     */         }
/*     */       };
/*  67 */     getFocusBar().getTextField().getDocument().addDocumentListener(new DocumentListener()
/*     */         {
/*     */           public void changedUpdate(DocumentEvent e) {
/*  70 */             TextPromptView.this.commitEdit();
/*     */           }
/*     */ 
/*     */           
/*     */           public void insertUpdate(DocumentEvent e) {
/*  75 */             TextPromptView.this.commitEdit();
/*     */           }
/*     */ 
/*     */           
/*     */           public void removeUpdate(DocumentEvent e) {
/*  80 */             TextPromptView.this.commitEdit();
/*     */           }
/*     */         });
/*  83 */     setModel(model);
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  88 */     if (this.focusPanel_ == null) {
/*  89 */       this.focusPanel_ = new DtvPanel(DtvPanel.FOCUS_BAR_PANEL_ID, new BorderLayout());
/*  90 */       ((IModeController)this._modeProvider.get()).getContextManager().addContextChangeListener((IContextChangeListener)this.focusPanel_);
/*     */     } 
/*     */     
/*  93 */     return (JComponent)this.focusPanel_;
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  98 */     return (JComponent)getFocusBar().getTextField();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deregisterEventHandlers(ITextPromptModel argModel) {
/* 104 */     this._eventManager.deregisterEventHandler(this.modelChangeHandler_, (IEventSource)argModel);
/*     */     
/* 106 */     getFocusBar().getTextField().removePropertyChangeListener((PropertyChangeListener)argModel);
/*     */     
/* 108 */     super.deregisterEventHandlers(argModel);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void registerEventHandlers(ITextPromptModel argModel) {
/* 114 */     super.registerEventHandlers(argModel);
/* 115 */     this._eventManager.registerEventHandler(this.modelChangeHandler_, (IEventSource)argModel, SET_VALUES_CONSTRAINT);
/*     */     
/* 117 */     getFocusBar().getTextField().addPropertyChangeListener((PropertyChangeListener)argModel);
/*     */   }
/*     */   
/*     */   void commitEdit() {
/*     */     try {
/* 122 */       getFocusBar().getTextField().commitEdit();
/*     */     }
/* 124 */     catch (ParseException ex) {
/* 125 */       logger.info("CAUGHT EXCEPTION", ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   PosFocusBar getFocusBar() {
/* 130 */     if (this.focusBar_ == null) {
/* 131 */       XstFocusBarTextField textField = new XstFocusBarTextField();
/* 132 */       this.focusBar_ = PosComponentFactory.getInstance().createFocusBar(textField.getTextFieldComponent());
/* 133 */       getDisplayComponent().add((Component)this.focusBar_, "Center");
/*     */     } 
/*     */     
/* 136 */     return this.focusBar_;
/*     */   }
/*     */   
/*     */   void handleModelChange(Event argEvent) {
/* 140 */     IPromptModel promptModel = (IPromptModel)argEvent.getSource(IPromptModel.class);
/* 141 */     IPromptConfig config = promptModel.getPromptConfig();
/* 142 */     boolean fingerprintEnabled = isFingerprintEnabled(config);
/*     */ 
/*     */ 
/*     */     
/* 146 */     final MutableString title = this._localeManager.getRegisteredString(config.getTitleSectionConfig().getText(promptModel.getPromptArgs()));
/*     */     
/* 148 */     final MutableString instruction = this._localeManager.getRegisteredString(config.getMsgSectionConfig().getText(promptModel.getPromptArgs()));
/* 149 */     final IXstAction iconTouchAction = getTouchAction(config);
/* 150 */     final Icon icon = getIcon(config, fingerprintEnabled);
/* 151 */     final Icon touchIcon = getTouchIcon(config, iconTouchAction, fingerprintEnabled);
/*     */     
/* 153 */     final IDataFieldConfig dataFieldConfig = config.isDataFieldConfigSet() ? promptModel.getPromptConfig().getDataFieldConfig() : null;
/* 154 */     final boolean fieldEnabled = (dataFieldConfig != null) ? (!dataFieldConfig.isEntryDisabled()) : true;
/*     */     
/* 156 */     final MutableString text = (dataFieldConfig != null && dataFieldConfig.getValue() == null) ? this._localeManager.getRegisteredString(dataFieldConfig.getTextKey()) : null;
/*     */ 
/*     */     
/* 159 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */           public void run() {
/* 162 */             PosFocusBar fb = TextPromptView.this.getFocusBar();
/* 163 */             PosTextField tf = fb.getTextField();
/*     */ 
/*     */             
/* 166 */             if (dataFieldConfig != null) {
/* 167 */               tf.setEntryMasked(dataFieldConfig.isEntryMasked());
/* 168 */               tf.setFormatters(dataFieldConfig.getFormatters());
/* 169 */               tf.clear();
/* 170 */               if (text != null) {
/* 171 */                 tf.setText(text);
/*     */               } else {
/*     */                 
/* 174 */                 tf.setValue(dataFieldConfig.getValue());
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/* 179 */             fb.setFieldDescription(title);
/* 180 */             fb.setInstruction(instruction);
/* 181 */             fb.setFieldIcon(icon);
/* 182 */             fb.setFieldTouchIcon(touchIcon);
/* 183 */             fb.setFieldIconTouchAction((Action)iconTouchAction);
/*     */ 
/*     */             
/* 186 */             tf.setVisible(fieldEnabled);
/* 187 */             tf.setEnabled(fieldEnabled);
/* 188 */             tf.selectAll();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private Icon getIcon(IPromptConfig argConfig, boolean argFingerprintEnabled) {
/* 194 */     if (argFingerprintEnabled) {
/* 195 */       return this.fingerprintIcon_;
/*     */     }
/*     */     
/* 198 */     return argConfig.getIconGroupConfig().getIcon();
/*     */   }
/*     */ 
/*     */   
/*     */   private IXstAction getTouchAction(IPromptConfig argConfig) {
/* 203 */     IconGroupConfig iconGroupConfig = (IconGroupConfig)argConfig.getIconGroupConfig();
/* 204 */     if (iconGroupConfig.getTouchConfig() != null) {
/* 205 */       IXstAction iconTouchAction = iconGroupConfig.getTouchConfig().getAction();
/* 206 */       if (iconTouchAction instanceof XstDataAction) {
/* 207 */         ((XstDataAction)iconTouchAction).setModel((IUIInputModel)getModel());
/*     */       }
/* 209 */       return iconTouchAction;
/*     */     } 
/* 211 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private Icon getTouchIcon(IPromptConfig argConfig, IXstAction argTouchAction, boolean argFingerprintEnabled) {
/* 216 */     if (!argFingerprintEnabled && argTouchAction != null) {
/* 217 */       return argConfig.getIconGroupConfig().getPressIcon();
/*     */     }
/* 219 */     return null;
/*     */   }
/*     */   
/*     */   private boolean isFingerprintEnabled(IPromptConfig argConfig) {
/* 223 */     return (argConfig.isFingerprintEnabled() && 
/* 224 */       HardwareMgr.getCurrentHardwareMgr().isBiometricDevicePresent());
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\TextPromptView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */