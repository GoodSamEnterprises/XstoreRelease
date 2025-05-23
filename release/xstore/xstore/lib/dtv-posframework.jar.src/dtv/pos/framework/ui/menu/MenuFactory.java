/*     */ package dtv.pos.framework.ui.menu;
/*     */ 
/*     */ import com.micros.xstore.config.IConfigMgr;
/*     */ import com.micros.xstore.config.IPropertyCascader;
/*     */ import com.micros.xstore.config.common.Action;
/*     */ import com.micros.xstore.config.impl.ConfigLoadingException;
/*     */ import com.micros.xstore.config.impl.LocatableObject;
/*     */ import com.micros.xstore.config.menu.MenuItemType;
/*     */ import com.micros.xstore.config.menu.MenuOptionType;
/*     */ import com.micros.xstore.config.menu.MenuOptionsType;
/*     */ import com.micros.xstore.config.menu.MenuSet;
/*     */ import com.micros.xstore.config.menu.SubMenuType;
/*     */ import dtv.pos.framework.action.IXstActionFactory;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.ui.ActionDisplayType;
/*     */ import dtv.pos.iframework.ui.IMenuItem;
/*     */ import dtv.util.config.ConfigException;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class MenuFactory
/*     */   implements IMenuFactory
/*     */ {
/*  37 */   private static final Logger _logger = Logger.getLogger(MenuFactory.class);
/*     */ 
/*     */   
/*     */   private IConfigMgr<MenuSet> _menuConfigMgr;
/*     */ 
/*     */   
/*     */   private Map<String, MenuSet.MenuItem> _menuMap;
/*     */   
/*     */   private IPropertyCascader<MenuItemType> _menuCascader;
/*     */   
/*     */   @Inject
/*     */   private IXstActionFactory _actionFactory;
/*     */ 
/*     */   
/*     */   public MenuFactory(IConfigMgr<MenuSet> argMenuConfigMgr) {
/*  52 */     this._menuConfigMgr = argMenuConfigMgr;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IMenuItem getMenu(String argMenuName) {
/*  58 */     MenuSet.MenuItem menuItemConfig = this._menuMap.get(argMenuName);
/*  59 */     DefaultMenuItem menuItem = buildMenuFromConfig((MenuItemType)menuItemConfig);
/*  60 */     menuItem.setMenuKey(argMenuName);
/*  61 */     return menuItem;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init() {
/*     */     try {
/*  68 */       MenuSet menuSet = (MenuSet)this._menuConfigMgr.getResolvedConfigs();
/*  69 */       this._menuMap = new HashMap<>();
/*     */       
/*  71 */       for (MenuSet.MenuItem menuItem : menuSet.getMenuItems()) {
/*  72 */         this._menuMap.put(menuItem.getName(), menuItem);
/*     */       }
/*     */     }
/*  75 */     catch (ConfigLoadingException ex) {
/*  76 */       _logger.error("Failed to successfully load ActionConfig.xml files.", (Throwable)ex);
/*  77 */       throw new ConfigException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValidMenu(String argMenuName) {
/*  84 */     return this._menuMap.containsKey(argMenuName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMenuCascader(IPropertyCascader<MenuItemType> argMenuCascader) {
/*  92 */     this._menuCascader = argMenuCascader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DefaultMenuItem buildMenuFromConfig(MenuItemType argMenuItemConfig) {
/*  99 */     Action menuActionConfig = new Action();
/* 100 */     menuActionConfig.setRef(argMenuItemConfig.getActionRef());
/* 101 */     menuActionConfig.setCategory(argMenuItemConfig.getCategory());
/* 102 */     menuActionConfig.setKeyStroke(argMenuItemConfig.getKeyStroke());
/* 103 */     menuActionConfig.setText(argMenuItemConfig.getText());
/*     */     
/* 105 */     IXstAction menuItemAction = this._actionFactory.getAction(null, menuActionConfig);
/* 106 */     List<IXstAction> actions = new ArrayList<>();
/* 107 */     actions.add(menuItemAction);
/*     */     
/* 109 */     if (!isMenuItemValid(actions, argMenuItemConfig.getSourceDescription())) {
/* 110 */       return null;
/*     */     }
/*     */     
/* 113 */     MenuItemParameters params = new MenuItemParameters();
/*     */     
/* 115 */     params.setPossibleActions(actions);
/*     */     
/* 117 */     if (argMenuItemConfig.getDisplayType() != null) {
/* 118 */       ActionDisplayType displayType = ActionDisplayType.forName(argMenuItemConfig.getDisplayType().name());
/* 119 */       params.setActionDisplayType(displayType);
/*     */     } 
/*     */     
/* 122 */     params.setSourceDescription(argMenuItemConfig.getSourceDescription());
/* 123 */     params.setKeywords(argMenuItemConfig.getKeywords());
/*     */     
/* 125 */     List<IMenuItem> menuContent = new ArrayList<>();
/*     */ 
/*     */     
/* 128 */     for (LocatableObject child : argMenuItemConfig.getMenuOptionsAndMenuOptionsAndSubMenus()) {
/* 129 */       if (child instanceof MenuOptionsType) {
/*     */ 
/*     */         
/* 132 */         MenuOptionsType optionsType = (MenuOptionsType)child;
/* 133 */         IMenuItem referencedMenu = getMenu(optionsType.getRef());
/* 134 */         menuContent.addAll(referencedMenu.getChildren()); continue;
/*     */       } 
/* 136 */       if (child instanceof com.micros.xstore.config.menu.MenuGapType) {
/* 137 */         IXstAction action = this._actionFactory.getEmptyAction();
/* 138 */         MenuItemParameters gapParams = new MenuItemParameters();
/* 139 */         gapParams.setPossibleActions(Collections.singletonList(action));
/* 140 */         IMenuItem gapItem = new DefaultMenuItem(gapParams);
/* 141 */         menuContent.add(gapItem); continue;
/*     */       } 
/* 143 */       if (child instanceof SubMenuType) {
/*     */         MenuItemType menuItemType;
/*     */         
/* 146 */         SubMenuType subMenuConfig = (SubMenuType)child;
/* 147 */         SubMenuType subMenuType1 = subMenuConfig;
/*     */         
/* 149 */         if (subMenuConfig.getRef() != null) {
/*     */ 
/*     */ 
/*     */           
/* 153 */           MenuItemType cleanMenuConfig = new MenuItemType();
/*     */           
/* 155 */           cleanMenuConfig = (MenuItemType)this._menuCascader.copyCascadableProperties((LocatableObject)cleanMenuConfig, (LocatableObject)subMenuConfig);
/*     */ 
/*     */           
/* 158 */           MenuSet.MenuItem referent = this._menuMap.get(subMenuConfig.getRef());
/*     */           
/* 160 */           if (referent == null) {
/* 161 */             _logger.info("SubMenu item will be excluded, as its reference does not exist [" + subMenuConfig
/* 162 */                 .getRef() + "] @@ " + subMenuConfig.getSourceDescription());
/*     */             
/*     */             continue;
/*     */           } 
/* 166 */           menuItemType = (MenuItemType)this._menuCascader.copyCascadableProperties((LocatableObject)cleanMenuConfig, (LocatableObject)referent);
/*     */         } 
/*     */ 
/*     */         
/* 170 */         if (menuItemType.getKeywords() == null) {
/* 171 */           menuItemType.setKeywords(argMenuItemConfig.getKeywords());
/*     */         }
/*     */         
/* 174 */         if (menuItemType.getDisplayType() == null) {
/* 175 */           menuItemType.setDisplayType(argMenuItemConfig.getDisplayType());
/*     */         }
/*     */         
/* 178 */         if (argMenuItemConfig.getSticky() != null && menuItemType.getSticky() == null) {
/* 179 */           menuItemType.setSticky(argMenuItemConfig.getSticky());
/* 180 */           menuItemType.setStickyParent(argMenuItemConfig.getSticky());
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 185 */         IMenuItem subMenu = buildMenuFromConfig(menuItemType);
/*     */ 
/*     */ 
/*     */         
/* 189 */         if (subMenu != null)
/* 190 */           menuContent.add(subMenu); 
/*     */         continue;
/*     */       } 
/* 193 */       if (child instanceof MenuOptionType) {
/* 194 */         MenuOptionType menuOptionConfig = (MenuOptionType)child;
/* 195 */         List<IXstAction> possibleActions = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 201 */         if (!menuOptionConfig.getActions().isEmpty()) {
/* 202 */           for (Action actionConfig : menuOptionConfig.getActions()) {
/* 203 */             IXstAction action = this._actionFactory.getAction(null, actionConfig);
/* 204 */             possibleActions.add(action);
/*     */           } 
/*     */         } else {
/*     */           
/* 208 */           Action actionConfig = new Action();
/* 209 */           actionConfig.setKeyStroke(menuOptionConfig.getKeyStroke());
/* 210 */           actionConfig.setRef(menuOptionConfig.getRef());
/* 211 */           actionConfig.setText(menuOptionConfig.getText());
/* 212 */           actionConfig.setFile(menuOptionConfig.getFile());
/* 213 */           actionConfig.setLineNumber(menuOptionConfig.getLineNumber());
/* 214 */           actionConfig.setColumnNumber(menuOptionConfig.getColumnNumber());
/* 215 */           IXstAction action = this._actionFactory.getAction(null, actionConfig);
/*     */           
/* 217 */           if (action != null) {
/* 218 */             possibleActions.add(action);
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 223 */         if (!isMenuItemValid(possibleActions, child.getSourceDescription())) {
/*     */           continue;
/*     */         }
/*     */         
/* 227 */         MenuItemParameters menuOptionParameters = new MenuItemParameters();
/* 228 */         menuOptionParameters.setSourceDescription(child.getSourceDescription());
/* 229 */         menuOptionParameters.setKeywords(menuOptionConfig.getKeywords());
/* 230 */         menuOptionParameters.setPossibleActions(possibleActions);
/* 231 */         Boolean bcDisabled = ConfigUtils.toBoolean(menuOptionConfig.getBreadCrumbsDisabled(), false);
/* 232 */         menuOptionParameters.setIsBreadCrumbDisabled(bcDisabled.booleanValue());
/*     */         
/* 234 */         IMenuItem menuItem = new DefaultMenuItem(menuOptionParameters);
/* 235 */         menuContent.add(menuItem);
/*     */       } 
/*     */     } 
/*     */     
/* 239 */     params.setChildren(menuContent);
/* 240 */     DefaultMenuItem newMenuItem = new DefaultMenuItem(params);
/* 241 */     boolean sticky = ConfigUtils.toBoolean(argMenuItemConfig.getSticky(), false).booleanValue();
/* 242 */     newMenuItem.setSticky(sticky);
/* 243 */     return newMenuItem;
/*     */   }
/*     */   
/*     */   protected boolean isMenuItemValid(List<IXstAction> argMenuActions, String argMenuConfigLocation) {
/* 247 */     if (argMenuActions == null || argMenuActions.isEmpty()) {
/* 248 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 253 */     boolean valid = true;
/*     */     
/* 255 */     for (IXstAction action : argMenuActions) {
/* 256 */       if (!action.isValid()) {
/* 257 */         _logger.info("Menu item will be excluded, as its action key does not exist [" + action.getActionKey() + "] @@ " + argMenuConfigLocation);
/*     */         
/* 259 */         valid = false;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 264 */     return valid;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\menu\MenuFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */