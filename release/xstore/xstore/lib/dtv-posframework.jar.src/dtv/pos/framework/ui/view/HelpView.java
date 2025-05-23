/*     */ package dtv.pos.framework.ui.view;
/*     */ 
/*     */ import dtv.pos.framework.action.IXstActionFactory;
/*     */ import dtv.pos.framework.event.KeyActionPair;
/*     */ import dtv.pos.framework.ui.component.XstReadOnlyTextArea;
/*     */ import dtv.pos.framework.ui.component.XstTitledInstructionPanel;
/*     */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.IActionOwner;
/*     */ import dtv.pos.iframework.ui.model.IHelpModel;
/*     */ import dtv.pos.ui.plaf.PosBorders;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.swing.DtvScrollPane;
/*     */ import dtv.util.MutableString;
/*     */ import java.awt.Component;
/*     */ import java.util.Collection;
/*     */ import javax.inject.Inject;
/*     */ import javax.swing.JComponent;
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
/*     */ 
/*     */ 
/*     */ public final class HelpView
/*     */   extends AbstractUIView<IHelpModel>
/*     */   implements IActionOwner
/*     */ {
/*  36 */   private static final Logger _logger = Logger.getLogger(HelpView.class);
/*     */   
/*     */   private final XstTitledInstructionPanel _titlePanel;
/*     */   
/*     */   private final XstReadOnlyTextArea _messageArea;
/*     */   
/*     */   private final DtvScrollPane _scrollPane;
/*     */   
/*     */   private final Collection<? extends KeyActionPair> _scrollKeyActions;
/*     */   
/*     */   @Inject
/*     */   private IXstActionFactory _actionFactory;
/*     */ 
/*     */   
/*     */   public HelpView() {
/*  51 */     IHelpModel model = ((IModeController)this._modeProvider.get()).getStationModel().getHelpModel();
/*  52 */     setModel(model);
/*     */     
/*  54 */     this._titlePanel = XstViewComponentFactory.getInstance().createTitledInstructionPanel();
/*  55 */     this._messageArea = XstViewComponentFactory.getInstance().createReadOnlyTextArea();
/*  56 */     this._scrollPane = new DtvScrollPane(this._messageArea.getDisplayComponent());
/*     */     
/*  58 */     this._titlePanel.setContent((JComponent)this._scrollPane);
/*  59 */     getDisplayComponent().putClientProperty("COMPONENT_WRAPPER", this);
/*     */ 
/*     */     
/*  62 */     this._scrollKeyActions = this._actionFactory.getScrollKeyActions();
/*     */     
/*  64 */     ((IModeController)this._modeProvider.get()).getUiController()
/*  65 */       .registerKeyActions(this._scrollKeyActions, this, new Component[] { this._messageArea.getFocusComponent() });
/*     */     
/*  67 */     this._messageArea.getDisplayComponent().setBorder(PosBorders.getMarginBorder());
/*  68 */     this._messageArea.getFocusComponent().setFocusable(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  74 */     return this._titlePanel.getDisplayComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  80 */     return this._titlePanel.getContent();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/*  86 */     return getFocusComponent().isShowing();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateView() {
/*  93 */     final IHelpModel helpModel = getModel();
/*     */     
/*  95 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/*     */             try {
/* 100 */               HelpView.this._titlePanel.setTitle(new MutableString(helpModel.getHelpTitle()));
/* 101 */               HelpView.this._titlePanel.setInstruction(new MutableString(helpModel.getHelpInstructions()));
/*     */               
/* 103 */               String message = helpModel.getHelpMessage();
/* 104 */               String contentType = helpModel.getHelpContentType();
/*     */               
/* 106 */               HelpView.this._messageArea.setContentType(contentType);
/*     */               
/* 108 */               if ("text/html".equalsIgnoreCase(contentType)) {
/* 109 */                 HelpView.this._messageArea.setPage(message);
/*     */               } else {
/*     */                 
/* 112 */                 HelpView.this._messageArea.setText(new MutableString(message));
/*     */               }
/*     */             
/* 115 */             } catch (Exception ex) {
/* 116 */               HelpView._logger.error("CAUGHT EXCEPTION", ex);
/*     */             } 
/*     */           }
/*     */         }true);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\HelpView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */