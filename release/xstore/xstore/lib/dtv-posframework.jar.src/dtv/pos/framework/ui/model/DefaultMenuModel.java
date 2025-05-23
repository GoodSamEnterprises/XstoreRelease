/*     */ package dtv.pos.framework.ui.model;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.pos.common.PromptKey;
/*     */ import dtv.pos.framework.action.IXstActionFactory;
/*     */ import dtv.pos.framework.action.type.XstDataActionKey;
/*     */ import dtv.pos.framework.action.type.XstKeyStroke;
/*     */ import dtv.pos.framework.op.req.PromptRequest;
/*     */ import dtv.pos.framework.ui.config.PromptConfig;
/*     */ import dtv.pos.framework.ui.config.PromptConfigHelper;
/*     */ import dtv.pos.framework.ui.menu.DefaultMenuItem;
/*     */ import dtv.pos.framework.ui.menu.IMenuFactory;
/*     */ import dtv.pos.framework.ui.menu.MenuItemParameters;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.action.IXstDataAction;
/*     */ import dtv.pos.iframework.ui.ActionDisplayType;
/*     */ import dtv.pos.iframework.ui.IMenuItem;
/*     */ import dtv.pos.iframework.ui.config.IPromptConfig;
/*     */ import dtv.pos.iframework.ui.model.IMenuModel;
/*     */ import dtv.ui.UIServices;
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultMenuModel
/*     */   extends AbstractUIModel
/*     */   implements IMenuModel
/*     */ {
/*  53 */   public static final IMenuItem EMPTY_MENU = (IMenuItem)new DefaultMenuItem(new MenuItemParameters());
/*     */   
/*  55 */   private static final Logger logger_ = Logger.getLogger(DefaultMenuModel.class);
/*     */   
/*     */   private IMenuItem currentMenuNode_;
/*  58 */   private ActionDisplayType currentDisplayType_ = ActionDisplayType.DEFAULT;
/*     */ 
/*     */   
/*     */   private IModeController _modeController;
/*     */   
/*     */   @Inject
/*     */   private IXstActionFactory _actionFactory;
/*     */   
/*     */   @Inject
/*     */   private IMenuFactory _menuFactory;
/*     */   
/*     */   @Inject
/*     */   private FormattableFactory _formattables;
/*     */   
/*     */   @Inject
/*     */   private PromptConfigHelper _promptConfigHelper;
/*     */ 
/*     */   
/*     */   public DefaultMenuModel() {
/*  77 */     if (logger_.isDebugEnabled()) {
/*  78 */       logger_.debug("Creating " + getClass().getName() + ".");
/*     */     }
/*     */     
/*  81 */     this.currentMenuNode_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<IXstAction> getActions() {
/*  87 */     IMenuItem rootMenuItem = getCurrentMenu();
/*  88 */     if (rootMenuItem == null) {
/*  89 */       return null;
/*     */     }
/*     */     
/*  92 */     List<IMenuItem> children = rootMenuItem.getChildren();
/*     */     
/*  94 */     if (children == null) {
/*  95 */       return null;
/*     */     }
/*     */ 
/*     */     
/*  99 */     Collection<IXstAction> actions = new ArrayList<>();
/*     */     
/* 101 */     for (IMenuItem element : children) {
/* 102 */       actions.add(element.getAction());
/*     */     }
/*     */     
/* 105 */     return actions;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstAction getBackAction() {
/* 111 */     IXstDataAction dataAction = this._actionFactory.getDataAction(XstDataActionKey.CANCEL);
/* 112 */     dataAction.setActionName(this._formattables.getSimpleFormattable("_previousmenu"));
/* 113 */     dataAction.setBackground(new Color(224, 160, 160));
/* 114 */     dataAction.setKeyStroke(XstKeyStroke.forName("escape").getKeyStroke());
/* 115 */     dataAction.setVisible(true);
/*     */     
/* 117 */     return (IXstAction)dataAction;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IMenuItem getCurrentMenu() {
/* 123 */     return this.currentMenuNode_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ActionDisplayType getCurrentMenuDisplayType() {
/* 129 */     return this.currentDisplayType_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IMenuItem getMenu(String key) {
/* 135 */     IMenuItem menu = this._menuFactory.getMenu(key);
/*     */     
/* 137 */     if (menu == null) {
/* 138 */       logger_.warn("There is no menu named [" + key + "]!");
/*     */     } else {
/*     */       
/* 141 */       menu.initialize();
/*     */     } 
/*     */     
/* 144 */     return menu;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSubMenuCurrent() {
/* 150 */     return (this.currentMenuNode_ != null && this.currentMenuNode_.getParent() != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void previousMenu() {
/* 156 */     if (isSubMenuCurrent()) {
/* 157 */       setCurrentMenuImpl(this.currentMenuNode_.getParent());
/*     */       
/* 159 */       this.events_.post(IMenuModel.BACKWARD_TRAVERSAL_CONSTRAINT);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refreshMenu() {
/* 170 */     setCurrentMenuImpl(getCurrentMenu());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrentMenu(IMenuItem menu) {
/* 177 */     boolean childTraversal = (menu != null && menu.getParent() != null && menu.getParent().equals(getCurrentMenu()));
/*     */     
/* 179 */     setCurrentMenuImpl(menu);
/*     */     
/* 181 */     if (childTraversal)
/*     */     {
/* 183 */       this.events_.post(IMenuModel.FORWARD_TRAVERSAL_CONSTRAINT);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrentMenu(final String argKey) {
/* 190 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */           public void run() {
/* 193 */             DefaultMenuModel.this.setCurrentMenuImpl(DefaultMenuModel.this.getMenu(argKey));
/*     */           }
/*     */         },  true, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setModeController(IModeController argModeController) {
/* 200 */     this._modeController = argModeController;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setCurrentMenuImpl(IMenuItem menuNode) {
/* 206 */     if (menuNode != null) {
/*     */ 
/*     */       
/* 209 */       List<IMenuItem> subMenuItems = menuNode.getChildren();
/*     */ 
/*     */       
/* 212 */       if (subMenuItems == null || subMenuItems.isEmpty()) {
/* 213 */         this.events_.post(ActionDisplayType.DEFAULT, new ArrayList(0));
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 219 */       Collection<IXstAction> actions = new ArrayList<>();
/*     */ 
/*     */ 
/*     */       
/* 223 */       ActionDisplayType displayType = null;
/*     */       
/* 225 */       for (IMenuItem subMenuItem : subMenuItems) {
/* 226 */         if (displayType == null && subMenuItem.getActionDisplayType() != null && subMenuItem
/* 227 */           .getChildren().isEmpty())
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 232 */           displayType = subMenuItem.getActionDisplayType();
/*     */         }
/*     */         
/* 235 */         IXstAction action = subMenuItem.getAction();
/* 236 */         actions.add(action);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 242 */         subMenuItem.setParent(menuNode);
/*     */       } 
/*     */       
/* 245 */       if (displayType == null)
/*     */       {
/*     */         
/* 248 */         for (IMenuItem parent = menuNode; parent != null; parent = parent.getParent()) {
/* 249 */           if (parent.getActionDisplayType() != null) {
/* 250 */             displayType = parent.getActionDisplayType();
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/* 256 */       if (displayType == null)
/*     */       {
/* 258 */         displayType = ActionDisplayType.DEFAULT;
/*     */       }
/*     */       
/* 261 */       this.currentMenuNode_ = menuNode;
/* 262 */       this.currentDisplayType_ = displayType;
/*     */ 
/*     */ 
/*     */       
/* 266 */       if (displayType.isPopupType()) {
/* 267 */         PromptKey emptyTextKey = PromptRequest.BLANK_TEXT_PROMPT;
/* 268 */         PromptConfig emptyTextPrompt = this._promptConfigHelper.getPromptConfig(emptyTextKey, null);
/* 269 */         this._modeController.getStationModel().getTextPromptModel().setValues((IPromptConfig)emptyTextPrompt);
/*     */       } 
/*     */ 
/*     */       
/* 273 */       this.events_.post(displayType, actions);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\DefaultMenuModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */