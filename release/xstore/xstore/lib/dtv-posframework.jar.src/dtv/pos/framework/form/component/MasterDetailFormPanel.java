/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventConstraint;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.constraint.BooleanConstraint;
/*     */ import dtv.event.constraint.Constraints;
/*     */ import dtv.event.constraint.NameConstraint;
/*     */ import dtv.event.eventor.DefaultEventor;
/*     */ import dtv.hardware.types.InputType;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.framework.event.FormSwipeTouchEvent;
/*     */ import dtv.pos.framework.form.config.FormLayoutConfig;
/*     */ import dtv.pos.framework.ui.ComponentAssembler;
/*     */ import dtv.pos.framework.ui.config.IRootComponentConfig;
/*     */ import dtv.pos.framework.ui.model.DefaultFormModel;
/*     */ import dtv.pos.iframework.event.IXstEventType;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.component.IFormComponent;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.model.DtvSingleSelectionModel;
/*     */ import dtv.ui.model.ISingleSelectionModel;
/*     */ import dtv.ui.touch.ISwipeListener;
/*     */ import dtv.ui.touch.ITouchReady;
/*     */ import dtv.ui.touch.SwipeEvent;
/*     */ import dtv.util.MutableString;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Component;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.SingleSelectionModel;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MasterDetailFormPanel<T extends IFormModel>
/*     */   extends FormPanel<T>
/*     */   implements IMasterDetailFormPanel<T>, ISwipeListener
/*     */ {
/*     */   private static final String NAME_MASTER_PANEL = "MASTER_PANEL";
/*     */   private static final String NAME_DETAIL_PANEL = "DETAIL_PANEL";
/*     */   private static final String NAME_DETAIL_TABS = "DETAIL_TABS";
/*     */   private static final String PROPERTY_CONTENT_LOCATION = "ContentLocation";
/*  61 */   private static final IEventConstraint enabledConstraint_ = Constraints.and(new IEventConstraint[] { (IEventConstraint)new NameConstraint(DefaultFormModel.SET_ENABLED), BooleanConstraint.TRUE });
/*     */   
/*  63 */   private final EventHandler formEnabledHandler_ = new EventHandler()
/*     */     {
/*     */       public void handle(Event argEvent)
/*     */       {
/*  67 */         MasterDetailFormPanel.this.setSelectedIndex(0);
/*     */       }
/*     */     };
/*  70 */   final List<FormPanel> detailViews_ = new ArrayList<>();
/*     */ 
/*     */   
/*  73 */   private final List<ChangeListener> tabChangeListeners_ = new ArrayList<>();
/*     */   
/*  75 */   private Eventor _eventor = (Eventor)new DefaultEventor((IEventSource)new EventDescriptor("dtv.hardware.input.FormSwipe"));
/*     */ 
/*     */ 
/*     */   
/*     */   private JComponent masterContainer_;
/*     */ 
/*     */   
/*     */   JComponent singleDetailContainer_;
/*     */ 
/*     */   
/*     */   JTabbedPane multiDetailContainer_;
/*     */ 
/*     */   
/*     */   private IFormComponent masterView_;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private EventManager _eventManager;
/*     */ 
/*     */ 
/*     */   
/*     */   public MasterDetailFormPanel(FormLayoutConfig argLayoutConfig, boolean argIsTitled) {
/*  97 */     super(argIsTitled);
/*  98 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */     
/* 100 */     JComponent root = ComponentAssembler.getInstance().assemble((IRootComponentConfig)argLayoutConfig, this);
/*     */ 
/*     */     
/* 103 */     getFormPanel().setLayout(new BorderLayout());
/* 104 */     getFormPanel().add(root, "Center");
/*     */ 
/*     */     
/* 107 */     this.multiDetailContainer_.setTabLayoutPolicy(0);
/* 108 */     this.multiDetailContainer_.setTabPlacement(argLayoutConfig.getTabPosition());
/* 109 */     this.multiDetailContainer_.setModel((SingleSelectionModel)new DtvSingleSelectionModel());
/* 110 */     this.multiDetailContainer_.addChangeListener(new TabChangeListener());
/*     */     
/* 112 */     if (this.multiDetailContainer_ instanceof ITouchReady) {
/* 113 */       ((ITouchReady)this.multiDetailContainer_).setSwipeEnabled(true);
/* 114 */       ((ITouchReady)this.multiDetailContainer_).getSwipable().addSwipeListener(this);
/*     */     } 
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
/*     */   
/*     */   public void addDetailView(FormPanel argPanel) {
/* 132 */     this.singleDetailContainer_.removeAll();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 137 */     final int tabindex = this.multiDetailContainer_.getTabCount();
/*     */     
/* 139 */     MutableString mutableTabTitle = argPanel.getMutableTitle();
/*     */     
/* 141 */     if (mutableTabTitle != null) {
/* 142 */       ChangeListener stateChangeListener = new ChangeListener()
/*     */         {
/*     */           public void stateChanged(ChangeEvent event) {
/* 145 */             String tabTitle = event.getSource().toString();
/* 146 */             if (ConfigurationMgr.isTextAllCapsOnTabHeaders()) {
/* 147 */               tabTitle = tabTitle.toUpperCase();
/*     */             }
/* 149 */             MasterDetailFormPanel.this.multiDetailContainer_.setTitleAt(tabindex, tabTitle);
/*     */           }
/*     */         };
/* 152 */       mutableTabTitle.addChangeListener(stateChangeListener);
/*     */ 
/*     */       
/* 155 */       this.tabChangeListeners_.add(stateChangeListener);
/*     */     } 
/*     */ 
/*     */     
/* 159 */     String title = argPanel.getTitle();
/* 160 */     if (ConfigurationMgr.isTextAllCapsOnTabHeaders()) {
/* 161 */       title = title.toUpperCase();
/*     */     }
/* 163 */     this.multiDetailContainer_.add(title, argPanel.getDisplayComponent());
/*     */ 
/*     */     
/* 166 */     this.detailViews_.add(argPanel);
/*     */ 
/*     */ 
/*     */     
/* 170 */     this.formComponentMap_.putAll(argPanel.formComponentMap_);
/*     */ 
/*     */ 
/*     */     
/* 174 */     getDisplayComponent().putClientProperty("SELECTION_MODEL_PROP", this.multiDetailContainer_.getModel());
/*     */ 
/*     */     
/* 177 */     UIServices.showComponentAndParents(this.multiDetailContainer_, true);
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
/*     */   public final void addFormComponent(IFormComponent argComp, String argFieldKey) {
/* 189 */     throw new UnsupportedOperationException("Not a configurable panel!");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/* 199 */     IEditModel editModel = getEditModel();
/*     */     
/* 201 */     if (editModel != null) {
/*     */ 
/*     */       
/* 204 */       String field = editModel.getFocusRequestFieldKey();
/* 205 */       if (field != null && field.length() > 0) {
/* 206 */         Object<?> comp = (Object<?>)this.formComponentMap_.get(field);
/* 207 */         JComponent result = getValidFocusComponent(comp);
/*     */         
/* 209 */         if (result != null) {
/* 210 */           return result;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 216 */     FormPanel selectedPanel = getSelectedFormPanel();
/*     */     
/* 218 */     return (selectedPanel != null) ? selectedPanel.getFocusComponent() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormComponent[] getFormComponents() {
/* 227 */     List<IFormComponent> formComponents = new ArrayList<>();
/*     */ 
/*     */     
/* 230 */     if (this.masterView_ != null) {
/* 231 */       formComponents.add(this.masterView_);
/*     */     }
/*     */     
/* 234 */     formComponents.addAll((Collection)this.detailViews_);
/*     */     
/* 236 */     return formComponents.<IFormComponent>toArray(new IFormComponent[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Component getNamedComponent(String argName) {
/* 242 */     String name = argName.trim();
/*     */     
/* 244 */     if ("MASTER_PANEL".equalsIgnoreCase(name)) {
/* 245 */       return this.masterContainer_;
/*     */     }
/* 247 */     if ("DETAIL_PANEL".equalsIgnoreCase(name)) {
/* 248 */       return this.singleDetailContainer_;
/*     */     }
/* 250 */     if ("DETAIL_TABS".equalsIgnoreCase(name)) {
/* 251 */       return this.multiDetailContainer_;
/*     */     }
/* 253 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormPanel getSelectedFormPanel() {
/* 262 */     int selectedIdx = getSelectedIndex();
/* 263 */     return (selectedIdx >= 0 && selectedIdx < this.detailViews_.size()) ? this.detailViews_
/* 264 */       .get(selectedIdx) : null;
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
/*     */   public int getSelectedIndex() {
/* 278 */     return isMultiPageForm() ? this.multiDetailContainer_.getSelectedIndex() : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ISingleSelectionModel getSelectionModel() {
/* 288 */     return (ISingleSelectionModel)this.multiDetailContainer_.getModel();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void init(IFormComponentConfig argConfig) {
/* 299 */     throw new UnsupportedOperationException("Not a configurable panel!");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerNamedComponent(Component argComponent, String argName) {
/* 310 */     String name = argName.trim();
/*     */     
/* 312 */     if ("MASTER_PANEL".equalsIgnoreCase(name)) {
/* 313 */       this.masterContainer_ = (JComponent)argComponent;
/*     */     }
/* 315 */     else if ("DETAIL_PANEL".equalsIgnoreCase(name)) {
/* 316 */       this.singleDetailContainer_ = (JComponent)argComponent;
/*     */     }
/* 318 */     else if ("DETAIL_TABS".equalsIgnoreCase(name)) {
/* 319 */       this.multiDetailContainer_ = (JTabbedPane)argComponent;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeNamedComponent(String argName) {
/* 326 */     throw new UnsupportedOperationException("Registered component removal is not supported by this class.");
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
/*     */   public void setDetailView(FormPanel argPanel) {
/* 342 */     this.multiDetailContainer_.removeAll();
/*     */ 
/*     */ 
/*     */     
/* 346 */     Object layoutLocation = this.singleDetailContainer_.getClientProperty("ContentLocation");
/* 347 */     this.singleDetailContainer_.removeAll();
/* 348 */     this.singleDetailContainer_.add(argPanel.getDisplayComponent(), layoutLocation);
/*     */ 
/*     */     
/* 351 */     this.detailViews_.clear();
/* 352 */     this.detailViews_.add(argPanel);
/*     */ 
/*     */ 
/*     */     
/* 356 */     this.formComponentMap_.putAll(argPanel.formComponentMap_);
/*     */ 
/*     */     
/* 359 */     UIServices.showComponentAndParents(this.singleDetailContainer_, true);
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
/*     */   public void setMasterView(FormPanel argPanel) {
/* 372 */     Object layoutLocation = this.masterContainer_.getClientProperty("ContentLocation");
/* 373 */     this.masterContainer_.removeAll();
/* 374 */     this.masterContainer_.add(argPanel.getDisplayComponent(), layoutLocation);
/*     */ 
/*     */     
/* 377 */     this.masterView_ = argPanel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelectedIndex(int argIndex) {
/* 388 */     if (isMultiPageForm()) {
/* 389 */       this.multiDetailContainer_.setSelectedIndex(argIndex);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelectionModel(ISingleSelectionModel argModel) {
/* 400 */     if (argModel != null) {
/* 401 */       this.multiDetailContainer_.setModel((SingleSelectionModel)argModel);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void swiped(SwipeEvent argEvent) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void swipedDown(SwipeEvent argEvent) {
/* 412 */     postSwipeEvent(argEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void swipedLeft(SwipeEvent argEvent) {
/* 418 */     postSwipeEvent(argEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void swipedRight(SwipeEvent argEvent) {
/* 424 */     postSwipeEvent(argEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void swipedUp(SwipeEvent argEvent) {
/* 430 */     postSwipeEvent(argEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deregisterEventHandlers(T argModel) {
/* 436 */     this._eventManager.deregisterEventHandler((IEventAware)this.formEnabledHandler_, (IEventSource)argModel);
/* 437 */     super.deregisterEventHandlers(argModel);
/*     */   }
/*     */   
/*     */   protected void postSwipeEvent(SwipeEvent argEvent) {
/* 441 */     FormSwipeTouchEvent event = new FormSwipeTouchEvent((IXstEventType)InputType.FORM_SWIPE_TOUCH_EVENT_TYPE, argEvent, "Form Swiped Event", this);
/*     */     
/* 443 */     this._eventor.post("FORM_SWIPED_EVENT", event);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void registerEventHandlers(T argModel) {
/* 449 */     super.registerEventHandlers(argModel);
/* 450 */     this._eventManager.registerEventHandler((IEventAware)this.formEnabledHandler_, (IEventSource)argModel, enabledConstraint_);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isMultiPageForm() {
/* 455 */     return (this.detailViews_.size() > 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class TabChangeListener
/*     */     implements ChangeListener
/*     */   {
/*     */     public void stateChanged(ChangeEvent changeEvent) {
/* 469 */       if (MasterDetailFormPanel.this.multiDetailContainer_.getTabCount() <= 1) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 474 */       Runnable worker = new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 478 */             FormPanel selectPanel = MasterDetailFormPanel.this.getSelectedFormPanel();
/* 479 */             if (selectPanel == null) {
/*     */               return;
/*     */             }
/* 482 */             Component focusableComponent = selectPanel.getFocusComponent();
/* 483 */             if (focusableComponent != null) {
/* 484 */               focusableComponent.requestFocusInWindow();
/*     */             }
/*     */           }
/*     */         };
/* 488 */       UIServices.invoke(worker, false, false);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\MasterDetailFormPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */