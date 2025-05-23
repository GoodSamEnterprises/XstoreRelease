/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventConstraint;
/*     */ import dtv.event.constraint.NameConstraint;
/*     */ import dtv.pos.framework.scope.TransactionScope;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.form.component.IFormComponent;
/*     */ import dtv.pos.ui.component.PosPanel;
/*     */ import dtv.pos.ui.plaf.component.TransactionViewHelper;
/*     */ import dtv.ui.ComponentID;
/*     */ import dtv.ui.ComponentPropertySet;
/*     */ import dtv.ui.IComponent;
/*     */ import dtv.ui.context.ContextChangeEvent;
/*     */ import dtv.ui.context.DefaultContextChangeListener;
/*     */ import dtv.ui.context.IContextChangeListener;
/*     */ import dtv.ui.swing.DtvPanel;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import dtv.xst.dao.trn.IPosTransaction;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Insets;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import javax.swing.JComponent;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class FormInformationPanel
/*     */   extends FormPanel
/*     */   implements IFormComponent, IContextChangeListener, IComponent
/*     */ {
/*  42 */   private static final Logger _logger = Logger.getLogger(FormInformationPanel.class);
/*     */   
/*  44 */   protected static final Insets margins_ = UIRM.getInsets("_marginTransactionInformationPanel");
/*  45 */   protected static final Color border_ = UIRM.getRGBColor("_colorBorder", Color.WHITE);
/*  46 */   protected static final Color background_ = UIRM
/*  47 */     .getRGBColor("_colorTransactionInformationPanel", new Color(77, 118, 149));
/*     */   
/*  49 */   private final EventHandler _newTransactionHandler = new EventHandler()
/*     */     {
/*     */       protected void handle(Event argEvent) {
/*  52 */         IPosTransaction transaction = (IPosTransaction)argEvent.getPayload();
/*  53 */         FormInformationPanel.this.newTransaction(transaction);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private InformationPanel informationPanel_;
/*     */   
/*     */   private IContextChangeListener listener_;
/*     */   
/*     */   private ComponentID id_;
/*     */   
/*     */   private ComponentPropertySet properties_;
/*     */   
/*     */   @Inject
/*     */   protected Provider<IModeController> _modeProvider;
/*     */   @Inject
/*     */   protected TransactionScope _transactionScope;
/*     */   @Inject
/*     */   protected EventManager _eventManager;
/*     */   
/*     */   public FormInformationPanel() {
/*  74 */     InjectionHammer.forceAtInjectProcessing(this);
/*  75 */     this.informationPanel_ = createInformationPanel();
/*     */     
/*  77 */     this.id_ = DtvPanel.INFORMATION_PANEL_ID;
/*  78 */     this.properties_ = new ComponentPropertySet();
/*  79 */     ((IModeController)this._modeProvider.get()).getContextManager().addContextChangeListener(this);
/*     */     
/*  81 */     this._eventManager.registerEventHandler((IEventAware)this._newTransactionHandler, this._transactionScope.getEventSource(), (IEventConstraint)new NameConstraint(TransactionScope.CURRENT_TRANSACTION));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getContainer() {
/*  88 */     return (JComponent)getInformationPanel();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  94 */     return (JComponent)getInformationPanel();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/* 100 */     return (JComponent)getInformationPanel();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ComponentID getID() {
/* 106 */     return this.id_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ComponentPropertySet getPropertySet() {
/* 112 */     return this.properties_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleContextChange(ContextChangeEvent argEvent) {
/* 118 */     if (this.listener_ == null) {
/* 119 */       this.listener_ = (IContextChangeListener)new DefaultContextChangeListener(this);
/*     */     }
/* 121 */     this.listener_.handleContextChange(argEvent);
/*     */     
/* 123 */     if (_logger.isDebugEnabled()) {
/* 124 */       _logger.debug("Handling context change for tab pane [" + this + "]: " + argEvent);
/*     */     }
/* 126 */     this.informationPanel_.repaint();
/*     */   }
/*     */   
/*     */   protected InformationPanel createInformationPanel() {
/* 130 */     return new InformationPanel();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected InformationPanel getInformationPanel() {
/* 138 */     return this.informationPanel_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void newTransaction(IPosTransaction argTransaction) {}
/*     */ 
/*     */   
/*     */   public class InformationPanel
/*     */     extends PosPanel
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     private static final double heightToContainerHeightRatio_ = 0.08503401360544217D;
/* 150 */     private Dimension size_ = new Dimension();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public InformationPanel() {
/* 157 */       setFocusable(false);
/* 158 */       setOpaque(false);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Dimension getPreferredSize() {
/* 164 */       calculateSize(getParent(), this.size_);
/* 165 */       return this.size_;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void paint(Graphics g) {
/* 171 */       paintBackground(g);
/* 172 */       super.paint(g);
/* 173 */       paintBorder(g);
/*     */     }
/*     */     
/*     */     protected void paintBackground(Graphics g) {
/* 177 */       setBackground(FormInformationPanel.this.properties_.getColor("background"));
/* 178 */       g.setColor(getBackground());
/* 179 */       g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void paintBorder(Graphics g) {
/* 184 */       g.setColor(FormInformationPanel.border_);
/* 185 */       g.drawRect(0, 0, getWidth() - 1, getHeight());
/*     */     }
/*     */     
/*     */     private void calculateSize(Container argParent, Dimension size) {
/* 189 */       Container c = TransactionViewHelper.getMyTransactionParent(argParent);
/* 190 */       if (c != null) {
/* 191 */         size.width = c.getWidth();
/* 192 */         size.height = (int)Math.round(0.08503401360544217D * c.getHeight());
/*     */       } else {
/*     */         
/* 195 */         size.width = 0;
/* 196 */         size.height = 0;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormInformationPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */