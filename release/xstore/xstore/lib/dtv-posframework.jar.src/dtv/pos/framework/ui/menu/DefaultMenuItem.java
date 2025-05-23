/*     */ package dtv.pos.framework.ui.menu;
/*     */ 
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.framework.action.ActionChooser;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.ui.ActionDisplayType;
/*     */ import dtv.pos.iframework.ui.IMenuItem;
/*     */ import dtv.util.MutableString;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultMenuItem
/*     */   implements IMenuItem
/*     */ {
/*  38 */   private static final Logger logger_ = Logger.getLogger(DefaultMenuItem.class);
/*     */   
/*     */   private final MenuItemParameters params_;
/*     */   
/*     */   private ActionChooser actionChooser_;
/*     */   
/*     */   private IMenuItem parent_;
/*     */   
/*     */   private List<IMenuItem> children_;
/*     */   
/*     */   private boolean initialized_;
/*     */   
/*     */   private boolean sticky_;
/*     */   
/*     */   private String sourceDescription_;
/*     */   private String keywords_;
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */   
/*     */   public DefaultMenuItem(MenuItemParameters params) {
/*  58 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */     
/*  60 */     this.params_ = params;
/*  61 */     this.initialized_ = false;
/*  62 */     this.sticky_ = true;
/*  63 */     this.children_ = this.params_.getChildren();
/*  64 */     setSourceDescription(params.getSourceDescription());
/*  65 */     setKeywords(params.getKeywords());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstAction getAction() {
/*  71 */     return this.actionChooser_.getMostAccessibleAction();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ActionDisplayType getActionDisplayType() {
/*  77 */     return this.params_.getDisplayType();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IMenuItem> getChildren() {
/*  83 */     return this.children_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getKeywords() {
/*  89 */     return this.keywords_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableString getMenuDescription() {
/*  95 */     if (this.params_.getDescription() != null) {
/*  96 */       return new MutableString(this.params_.getDescription());
/*     */     }
/*     */     
/*  99 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMenuKey() {
/* 105 */     return this.params_.getMenuKey();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableString getMenuTitle() {
/* 111 */     IXstAction action = getAction();
/* 112 */     return (action == null) ? MutableString.EMPTY : new MutableString(action
/* 113 */         .getActionName().toString(OutputContextType.VIEW));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IMenuItem getParent() {
/* 119 */     return this.parent_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableString getRootTitle() {
/* 125 */     IXstAction action = getAction();
/* 126 */     return (action == null) ? MutableString.EMPTY : new MutableString(action
/* 127 */         .getActionName().toString(OutputContextType.VIEW));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSourceDescription() {
/* 132 */     return this.sourceDescription_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize() {
/* 138 */     if (this.initialized_) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 147 */     configurePossibleActions(this.params_.getPossibleActions());
/*     */ 
/*     */     
/* 150 */     if (this.children_ != null) {
/* 151 */       for (IMenuItem element : this.children_) {
/* 152 */         element.initialize();
/*     */       }
/*     */     }
/* 155 */     this.initialized_ = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreadCrumbDisabled() {
/* 161 */     return this.params_.isBreadCrumbDisabled();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSticky() {
/* 167 */     return this.sticky_;
/*     */   }
/*     */   
/*     */   public void setKeywords(String argKeywords) {
/* 171 */     this.keywords_ = argKeywords;
/*     */   }
/*     */   
/*     */   public void setMenuKey(String argMenuKey) {
/* 175 */     this.params_.setMenuKey(argMenuKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParent(IMenuItem parent) {
/* 181 */     this.parent_ = parent;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSticky(boolean argSticky) {
/* 187 */     this.sticky_ = argSticky;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 192 */     return this.params_.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void configurePossibleActions(List<IXstAction> possibleActions) {
/* 198 */     if (possibleActions == null || possibleActions.isEmpty()) {
/* 199 */       if (StringUtils.isEmpty(this.params_.getMenuKey())) {
/* 200 */         logger_.warn("Menu item @ [" + getSourceDescription() + "] is not named and has no possible actions assigned to it!  It is likely useless and un-assertable.");
/*     */       }
/*     */ 
/*     */       
/* 204 */       this.actionChooser_ = new ActionChooser(possibleActions);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 215 */     boolean navigable = (this.children_ != null && !this.children_.isEmpty());
/*     */     
/* 217 */     for (IXstAction possibleAction : possibleActions) {
/* 218 */       possibleAction.setNavigable(navigable);
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
/* 229 */       if (navigable) {
/* 230 */         possibleAction.setActionListener(new MenuItemSelectedListener());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 235 */     this.actionChooser_ = new ActionChooser(possibleActions);
/*     */   }
/*     */   
/*     */   private void setSourceDescription(String argValue) {
/* 239 */     this.sourceDescription_ = argValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class MenuItemSelectedListener
/*     */     implements ActionListener
/*     */   {
/*     */     public void actionPerformed(ActionEvent event) {
/* 249 */       List<IMenuItem> children = DefaultMenuItem.this.getChildren();
/*     */       
/* 251 */       if (children != null && !children.isEmpty())
/*     */       {
/*     */         
/* 254 */         ((IModeController)DefaultMenuItem.this._modeProvider.get()).getStationModel().getMenuModel().setCurrentMenu(DefaultMenuItem.this);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\menu\DefaultMenuItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */