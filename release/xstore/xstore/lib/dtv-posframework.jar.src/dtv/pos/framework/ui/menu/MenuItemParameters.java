/*     */ package dtv.pos.framework.ui.menu;
/*     */ 
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.ui.ActionDisplayType;
/*     */ import dtv.pos.iframework.ui.IMenuItem;
/*     */ import dtv.util.config.IHasSourceDescription;
/*     */ import java.util.List;
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
/*     */ public class MenuItemParameters
/*     */   implements IHasSourceDescription
/*     */ {
/*  22 */   private String _menuKey = null;
/*     */   private String _description;
/*  24 */   private List<IMenuItem> _childMenus = null;
/*  25 */   private List<IXstAction> _possibleActions = null;
/*  26 */   private ActionDisplayType _displayType = null;
/*  27 */   private String _sourceDescription = null;
/*  28 */   private Boolean _isBreadCrumbDisabled = Boolean.valueOf(false);
/*  29 */   private String _keywords = null;
/*     */   
/*     */   public List<IMenuItem> getChildren() {
/*  32 */     return this._childMenus;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  36 */     return this._description;
/*     */   }
/*     */   
/*     */   public ActionDisplayType getDisplayType() {
/*  40 */     return this._displayType;
/*     */   }
/*     */   
/*     */   public String getKeywords() {
/*  44 */     return this._keywords;
/*     */   }
/*     */   
/*     */   public String getMenuKey() {
/*  48 */     return this._menuKey;
/*     */   }
/*     */   
/*     */   public List<IXstAction> getPossibleActions() {
/*  52 */     return this._possibleActions;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSourceDescription() {
/*  57 */     return this._sourceDescription;
/*     */   }
/*     */   
/*     */   public boolean isBreadCrumbDisabled() {
/*  61 */     return this._isBreadCrumbDisabled.booleanValue();
/*     */   }
/*     */   
/*     */   public void setActionDisplayType(ActionDisplayType actionDisplayType) {
/*  65 */     this._displayType = actionDisplayType;
/*     */   }
/*     */   
/*     */   public void setChildren(List<IMenuItem> children) {
/*  69 */     this._childMenus = children;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/*  73 */     this._description = argDescription;
/*     */   }
/*     */   
/*     */   public void setIsBreadCrumbDisabled(boolean argIsBreadCrumbDisabled) {
/*  77 */     this._isBreadCrumbDisabled = Boolean.valueOf(argIsBreadCrumbDisabled);
/*     */   }
/*     */   
/*     */   public void setKeywords(String argKeywords) {
/*  81 */     this._keywords = argKeywords;
/*     */   }
/*     */   
/*     */   public void setMenuKey(String menuKey) {
/*  85 */     this._menuKey = menuKey;
/*     */   }
/*     */   
/*     */   public void setPossibleActions(List<IXstAction> possibleActions) {
/*  89 */     this._possibleActions = possibleActions;
/*     */   }
/*     */   
/*     */   public void setSourceDescription(String argValue) {
/*  93 */     this._sourceDescription = argValue;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder sb = new StringBuilder();
/*  99 */     sb.append("menu key = [");
/* 100 */     sb.append(this._menuKey);
/* 101 */     sb.append("], children = [");
/* 102 */     if (this._childMenus != null) {
/* 103 */       for (IMenuItem element : this._childMenus) {
/* 104 */         sb.append("<<");
/* 105 */         sb.append(element);
/* 106 */         sb.append(">>");
/*     */       } 
/*     */     }
/* 109 */     sb.append("], possible actions = [");
/* 110 */     if (this._possibleActions != null) {
/* 111 */       for (IXstAction element : this._possibleActions) {
/* 112 */         sb.append("<<");
/* 113 */         sb.append(element);
/* 114 */         sb.append(">>");
/*     */       } 
/*     */     }
/* 117 */     sb.append("], action display type = [");
/* 118 */     sb.append(this._displayType);
/* 119 */     sb.append("], sticky? = [");
/* 120 */     sb.append("]");
/*     */     
/* 122 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\menu\MenuItemParameters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */