/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.pos.framework.action.IXstActionFactory;
/*     */ import dtv.pos.framework.event.KeyActionPair;
/*     */ import dtv.pos.framework.ui.component.XstList;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.IActionOwner;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewCellConfig;
/*     */ import dtv.pos.iframework.ui.config.IRendererDefConfig;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.model.ICombinedListModel;
/*     */ import dtv.ui.swing.DtvList;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Component;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.event.ListSelectionEvent;
/*     */ import javax.swing.event.ListSelectionListener;
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
/*     */ public class ScrollEventFormList<T extends IFormModel>
/*     */   extends AbstractListFormComponent<T>
/*     */   implements ListSelectionListener, IActionOwner
/*     */ {
/*  43 */   private static final Logger logger_ = Logger.getLogger(ScrollEventFormList.class);
/*     */   
/*     */   final XstList list_;
/*     */   
/*     */   private final Collection<? extends KeyActionPair> scrollKeyActions_;
/*     */   
/*     */   private ICombinedListModel<Object> listModel_;
/*     */   
/*     */   private int selectionMode_;
/*     */   
/*     */   private boolean editMode_;
/*     */   
/*     */   private JPanel containerPanel_;
/*     */   
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */   @Inject
/*     */   private IXstActionFactory _actionFactory;
/*     */   
/*     */   public ScrollEventFormList() {
/*  63 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */     
/*  65 */     this.containerPanel_ = createContainerPanel();
/*  66 */     this.containerPanel_.setFocusable(false);
/*  67 */     this.containerPanel_.setOpaque(false);
/*  68 */     this.containerPanel_.setLayout(new BorderLayout());
/*  69 */     this.containerPanel_.setBorder(BorderFactory.createLineBorder(UIRM.getRGBColor("_colorBorder")));
/*  70 */     this.containerPanel_.setFont(UIResourceManager.getInstance().getFont("_defaultFont"));
/*     */     
/*  72 */     this.list_ = createListComponent();
/*  73 */     this.list_.getListComponent().addListSelectionListener(this);
/*  74 */     this.containerPanel_.add(this.list_.getDisplayComponent(), "Center");
/*  75 */     setComponent(this.containerPanel_);
/*     */     
/*  77 */     this.scrollKeyActions_ = createScrollKeyActions();
/*  78 */     ((IModeController)this._modeProvider.get()).getUiController().registerKeyActions(this.scrollKeyActions_, this, new Component[] { getFocusComponent() });
/*     */     
/*  80 */     this.list_.getFocusComponent().setFocusable(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  86 */     return this.containerPanel_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  92 */     return this.list_.getFocusComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(IFormComponentConfig<?> argCfg) {
/*  99 */     IFormViewCellConfig config = (IFormViewCellConfig)argCfg;
/* 100 */     this.selectionMode_ = config.getSelectionMode().getValue();
/*     */     
/* 102 */     IRendererDefConfig cellDef = config.getRendererDef("Cell");
/* 103 */     IRendererDefConfig columnHeaderDef = config.getRendererDef("ColumnHeader");
/* 104 */     IRendererDefConfig rowHeaderDef = config.getRendererDef("RowHeader");
/*     */     
/* 106 */     if (cellDef != null) {
/* 107 */       this.list_.setCellRendererDef(cellDef.toRendererDef());
/*     */     }
/* 109 */     if (columnHeaderDef != null) {
/* 110 */       this.list_.setColumnHeaderRendererDef(columnHeaderDef.toRendererDef());
/*     */     }
/* 112 */     if (rowHeaderDef != null) {
/* 113 */       this.list_.setRowHeaderRendererDef(rowHeaderDef.toRendererDef());
/*     */     }
/* 115 */     super.init(argCfg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/* 121 */     return (this.list_.getDisplayComponent().isEnabled() && this.list_.getDisplayComponent().isShowing());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void valueChanged(ListSelectionEvent evt) {
/* 127 */     if (this.editMode_ && !evt.getValueIsAdjusting()) {
/* 128 */       updateModelValue();
/*     */     }
/*     */     
/* 131 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 135 */             ScrollEventFormList.this.list_.getListComponent().ensureIndexIsVisible(ScrollEventFormList.this.list_
/* 136 */                 .getModel().getSelectionModel().getLeadSelectionIndex());
/*     */ 
/*     */             
/* 139 */             ((IModeController)ScrollEventFormList.this._modeProvider.get()).getStationModel().getPromptActionModel().evaluateVisibility();
/*     */           }
/*     */         },  true, false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected JPanel createContainerPanel() {
/* 146 */     return new JPanel();
/*     */   }
/*     */   
/*     */   protected XstList createListComponent() {
/* 150 */     return new XstList(DtvList.TOUCH_READY_TRANSACTION_LIST_ID);
/*     */   }
/*     */   
/*     */   protected Collection<? extends KeyActionPair> createScrollKeyActions() {
/* 154 */     return this._actionFactory.getScrollKeyActions();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<Object> getSelections() {
/* 160 */     logger_.warn("shouldn't get here", new Throwable("STACK TRACE"));
/* 161 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponentValue(Object newValue) {
/* 168 */     if (!ObjectUtils.equivalent(this.listModel_, newValue)) {
/*     */       
/* 170 */       if (this.listModel_ != null) {
/* 171 */         this.listModel_.getSelectionModel().removeListSelectionListener(this);
/*     */       }
/* 173 */       this.listModel_ = (ICombinedListModel<Object>)newValue;
/* 174 */       this.list_.setModel(this.listModel_);
/*     */       
/* 176 */       this.listModel_.getSelectionModel().setSelectionMode(this.selectionMode_);
/* 177 */       this.listModel_.getSelectionModel().addListSelectionListener(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setSelections(List<Object> value) {
/* 184 */     logger_.warn("shouldn't get here", new Throwable("STACK TRACE"));
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\ScrollEventFormList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */