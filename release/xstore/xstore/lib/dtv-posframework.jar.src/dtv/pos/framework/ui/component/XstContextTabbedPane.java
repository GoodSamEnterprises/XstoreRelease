/*     */ package dtv.pos.framework.ui.component;
/*     */ 
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventConstraint;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.constraint.Constraints;
/*     */ import dtv.event.constraint.PayloadClassConstraint;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.LocaleManager;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.i18n.event.ILocaleChangeListener;
/*     */ import dtv.i18n.event.LocaleChangeEvent;
/*     */ import dtv.pos.framework.event.InfoChangeDescriptor;
/*     */ import dtv.pos.framework.ui.ComponentAssembler;
/*     */ import dtv.pos.framework.ui.model.InfoMetaDataManager;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.ui.IComponentRegistry;
/*     */ import dtv.pos.iframework.ui.IRefreshableView;
/*     */ import dtv.pos.iframework.ui.IUIController;
/*     */ import dtv.pos.iframework.ui.config.IViewComponentConfig;
/*     */ import dtv.ui.ComponentID;
/*     */ import dtv.ui.ComponentPropertySet;
/*     */ import dtv.ui.context.ContextChangeEvent;
/*     */ import dtv.ui.swing.DtvTabbedPane;
/*     */ import java.awt.Component;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
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
/*     */ 
/*     */ public class XstContextTabbedPane
/*     */   extends DtvTabbedPane
/*     */   implements IEventSource
/*     */ {
/*     */   public static final String SELECTION_CHANGED_EVENT_NAME = "SELECTION_CHANGED_EVENT";
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */   @Inject
/*     */   private EventManager _eventManager;
/*     */   @Inject
/*     */   private InfoMetaDataManager _infoManager;
/*     */   @Inject
/*     */   private LocaleManager _localeManager;
/*     */   @Inject
/*     */   private InfoChangeDescriptor _eventDescriptor;
/*  67 */   private String _currentTabSet = null;
/*     */   
/*  69 */   private List<IFormattable> _tabTitles = new ArrayList<>();
/*     */   
/*  71 */   private final EventHandler _refreshHandler = new EventHandler()
/*     */     {
/*     */       protected void handle(Event argEvent) {
/*  74 */         InfoChangeDescriptor.InfoChangePayload payload = (InfoChangeDescriptor.InfoChangePayload)argEvent.getPayload();
/*     */         
/*  76 */         for (int indexToUpdate = 0; indexToUpdate < XstContextTabbedPane.this.getTabCount(); indexToUpdate++) {
/*  77 */           Component component = XstContextTabbedPane.this.getComponentAt(indexToUpdate);
/*     */           
/*  79 */           if (component.getName().equalsIgnoreCase(payload.getInfoId())) {
/*  80 */             if (XstContextTabbedPane.this.getSelectedIndex() == indexToUpdate) {
/*     */               
/*  82 */               XstContextTabbedPane.this.maybeRefreshTabComponent(component, IRefreshableView.RefreshType.DETAIL);
/*     */               
/*     */               break;
/*     */             } 
/*  86 */             XstContextTabbedPane.this.maybeRefreshTabComponent(component, IRefreshableView.RefreshType.SUMMARY);
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*  95 */   private final ILocaleChangeListener _localeChangeListener = new ILocaleChangeListener()
/*     */     {
/*     */       public void handleLocaleChange(LocaleChangeEvent argEvent) {
/*  98 */         int tabIndex = 0;
/*     */         
/* 100 */         for (IFormattable tabTitle : XstContextTabbedPane.this._tabTitles) {
/* 101 */           XstContextTabbedPane.this.setTitleAt(tabIndex, tabTitle.toString(OutputContextType.VIEW));
/* 102 */           tabIndex++;
/*     */         } 
/*     */       }
/*     */     };
/*     */   
/*     */   public XstContextTabbedPane(ComponentID argId) {
/* 108 */     super(argId);
/*     */     
/* 110 */     IEventConstraint constraint = Constraints.and(new IEventConstraint[] { this._eventDescriptor.getChangeEvent().toConstraint(), (IEventConstraint)new PayloadClassConstraint(InfoChangeDescriptor.InfoChangePayload.class) });
/*     */     
/* 112 */     this._eventManager.registerEventHandler((IEventAware)this._refreshHandler, (IEventSource)this._eventDescriptor, constraint);
/*     */     
/* 114 */     this._localeManager.addLocaleChangeListener(this._localeChangeListener, OutputContextType.VIEW);
/*     */     
/* 116 */     addChangeListener(new ChangeListener()
/*     */         {
/*     */           public void stateChanged(ChangeEvent argE) {
/* 119 */             int selectedIndex = XstContextTabbedPane.this.getSelectedIndex();
/*     */             
/* 121 */             if (selectedIndex < 0) {
/*     */               return;
/*     */             }
/*     */             
/* 125 */             XstContextTabbedPane.this.maybeRefreshTabComponent(XstContextTabbedPane.this.getComponentAt(selectedIndex), IRefreshableView.RefreshType.DETAIL);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleContextChange(ContextChangeEvent event) {
/* 132 */     if (event.getNewContext() != null) {
/* 133 */       ComponentPropertySet setToUse = event.getNewContext().getPropertySet(InfoMetaDataManager.MESSAGE_AREA_TABS_ID);
/* 134 */       String newTabSetName = setToUse.getName();
/*     */       
/* 136 */       if (newTabSetName != null && newTabSetName != this._currentTabSet) {
/* 137 */         this._currentTabSet = newTabSetName;
/* 138 */         removeAll();
/* 139 */         this._tabTitles.clear();
/* 140 */         int tabIndex = 0;
/*     */         
/* 142 */         for (InfoMetaDataManager.InfoMetaData metadata : this._infoManager.getMetaDataList(newTabSetName)) {
/* 143 */           IUIController uiController = ((IModeController)this._modeProvider.get()).getUiController();
/* 144 */           IViewComponentConfig<?> componentConfig = metadata.getComponentConfig();
/*     */ 
/*     */ 
/*     */           
/* 148 */           Component tabView = uiController.getNamedComponent(componentConfig.getName());
/*     */           
/* 150 */           if (tabView == null)
/*     */           {
/* 152 */             tabView = ComponentAssembler.getInstance().assemble(componentConfig, (IComponentRegistry)uiController);
/*     */           }
/*     */           
/* 155 */           IFormattable titleF = metadata.getTitle();
/* 156 */           this._tabTitles.add(titleF);
/* 157 */           String title = titleF.toString(OutputContextType.VIEW);
/*     */           
/* 159 */           addTab(title, metadata.getIcon(), tabView);
/* 160 */           setScaleConfig(tabIndex, false);
/* 161 */           maybeRefreshTabComponent(tabView, IRefreshableView.RefreshType.SUMMARY);
/*     */           
/* 163 */           tabIndex++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 168 */     super.handleContextChange(event);
/*     */   }
/*     */   
/*     */   private void maybeRefreshTabComponent(Component argComponent, IRefreshableView.RefreshType argRefreshType) {
/* 172 */     JComponent jcomponent = (JComponent)argComponent;
/* 173 */     Object wrapper = jcomponent.getClientProperty("COMPONENT_WRAPPER");
/*     */     
/* 175 */     if (wrapper instanceof IRefreshableView) {
/* 176 */       IRefreshableView refreshable = (IRefreshableView)wrapper;
/* 177 */       String contentId = refreshable.getId().getIDName();
/* 178 */       refreshable.refreshView(argCount -> setCounter(contentId, argCount), argRefreshType);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstContextTabbedPane.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */