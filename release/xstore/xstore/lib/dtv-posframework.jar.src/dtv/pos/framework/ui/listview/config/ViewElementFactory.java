/*     */ package dtv.pos.framework.ui.listview.config;
/*     */ 
/*     */ import dtv.pos.framework.ui.listview.BackOfficeCellViewElement;
/*     */ import dtv.pos.framework.ui.listview.DefaultViewElement;
/*     */ import dtv.pos.framework.ui.listview.IListViewRule;
/*     */ import dtv.pos.framework.ui.listview.IViewElement;
/*     */ import dtv.pos.framework.ui.listview.IconListCellViewElement;
/*     */ import dtv.pos.framework.ui.listview.SimpleViewElement;
/*     */ import dtv.pos.iframework.ui.IViewElementType;
/*     */ import dtv.pos.iframework.ui.RendererDef;
/*     */ import dtv.ui.swing.DtvList;
/*     */ import dtv.util.ObjectUtils;
/*     */ import java.awt.Component;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTree;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ViewElementFactory
/*     */   implements IViewElementFactory
/*     */ {
/*     */   public static final String VIEW_ELEMENT_FACTORY_PROPERTY = "dtv.pos.factory.viewelement";
/*     */   
/*     */   static {
/*     */     IViewElementFactory instance;
/*     */   }
/*     */   
/*     */   public static IViewElementFactory getInstance() {
/*  34 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  39 */   private static final Logger logger_ = Logger.getLogger(ViewElementFactory.class);
/*     */ 
/*     */   
/*     */   private static final IViewElementFactory INSTANCE;
/*     */ 
/*     */   
/*     */   static {
/*  46 */     String className = System.getProperty("dtv.pos.factory.viewelement");
/*     */     try {
/*  48 */       instance = (IViewElementFactory)Class.forName(className).newInstance();
/*     */     }
/*  50 */     catch (Throwable ex) {
/*  51 */       instance = new ViewElementFactory();
/*     */     } 
/*  53 */     INSTANCE = instance;
/*     */   }
/*     */   
/*  56 */   private final IViewElement iconActionListRenderer_ = (IViewElement)new IconListCellViewElement();
/*  57 */   private final IViewElement backOfficeActionRenderer_ = (IViewElement)new BackOfficeCellViewElement();
/*  58 */   private final IViewElement defaultActionRenderer_ = (IViewElement)new DefaultViewElement(false);
/*  59 */   private final IViewElement defaultCellRenderer_ = (IViewElement)new SimpleViewElement(false);
/*  60 */   private final IViewElement defaultHeaderRenderer_ = (IViewElement)new SimpleViewElement(true);
/*  61 */   private final ListViewConfigReloader configReloader_ = new ListViewConfigReloader();
/*     */   
/*  63 */   private ListViewConfigHelper helper_ = new ListViewConfigHelper();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ViewElementFactory() {
/*  70 */     if (this.defaultHeaderRenderer_ instanceof Component) {
/*  71 */       ((Component)this.defaultHeaderRenderer_).setFocusable(false);
/*     */     }
/*  73 */     this.helper_.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Component getHeader(IViewElementType argHeaderType, Object argModel) {
/*  79 */     reloadModifiedConfigs();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  89 */     IViewElement header = null;
/*     */     
/*  91 */     if (argHeaderType != null) {
/*  92 */       header = getRenderer(this.helper_.getHeaderConfig(argHeaderType));
/*  93 */       if (header == null) {
/*  94 */         logger_.warn(argHeaderType + ": No header configuration defined!");
/*     */       }
/*     */     } 
/*  97 */     if (header == null) {
/*  98 */       header = this.defaultHeaderRenderer_;
/*     */     }
/* 100 */     header.initialize(argModel);
/*     */     
/* 102 */     return header.getDisplayComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ListViewConfigHelper getHelper() {
/* 108 */     return this.helper_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Component getListCellRendererComponent(JList list, Object model, int index, boolean isSelected, boolean cellHasFocus) {
/* 116 */     IViewElement renderer = getRenderer(list, model, index);
/* 117 */     renderer.initialize(list, model, index, isSelected, cellHasFocus);
/*     */     
/* 119 */     return renderer.getDisplayComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Component getTableCellRendererComponent(JTable table, Object model, boolean isSelected, boolean hasFocus, int row, int column) {
/* 126 */     IViewElement renderer = getRenderer(table, model, row, column);
/* 127 */     renderer.initialize(table, model, row, column, isSelected, hasFocus);
/*     */     
/* 129 */     return renderer.getDisplayComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Component getTreeCellRendererComponent(JTree tree, Object model, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
/* 136 */     IViewElement renderer = getRenderer(tree, model, row);
/* 137 */     renderer.initialize(tree, model, row, selected, hasFocus, expanded, leaf);
/*     */     
/* 139 */     return renderer.getDisplayComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IViewElementType getViewTypeFromRule(Object argModel, String argRuleSetName) {
/* 146 */     if (argModel == null) {
/* 147 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 151 */     ListViewRuleConfig[] rules = this.helper_.getRules(argRuleSetName);
/* 152 */     for (ListViewRuleConfig rule : rules) {
/* 153 */       if (evaluateRule(rule, argModel))
/*     */       {
/* 155 */         return rule.getType();
/*     */       }
/*     */     } 
/* 158 */     if (logger_.isDebugEnabled()) {
/* 159 */       logger_.debug("No rule is satisfied at this time to define the type of header/element for model class [" + 
/* 160 */           ObjectUtils.getClassNameFromObject(argModel) + "].");
/*     */     }
/* 162 */     return null;
/*     */   }
/*     */   
/*     */   protected void reloadModifiedConfigs() {
/* 166 */     if (this.configReloader_.reloadIfNeeded()) {
/* 167 */       this.helper_ = new ListViewConfigHelper();
/* 168 */       this.helper_.initialize();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean evaluateRule(ListViewRuleConfig ruleConfig, Object model) {
/* 174 */     IListViewRule rule = ruleConfig.getRule();
/*     */     try {
/* 176 */       return rule.checkListViewRule(model);
/*     */     }
/* 178 */     catch (Exception ex) {
/* 179 */       logger_.error("CAUGHT EXCEPTION", ex);
/* 180 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private IViewElement getRenderer(IListViewElementConfig config) {
/* 186 */     return (config == null) ? null : config.getRenderer();
/*     */   }
/*     */ 
/*     */   
/*     */   private IViewElement getRenderer(JComponent argComp, Object argModel, int argIndex) {
/* 191 */     return getRenderer(argComp, argModel, argIndex, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IViewElement getRenderer(JComponent argComp, Object argModel, int argRow, int argColumn) {
/* 198 */     reloadModifiedConfigs();
/*     */     
/* 200 */     boolean isHeader = (argRow < 0 || argColumn < 0);
/* 201 */     IViewElement defaultRenderer = isHeader ? this.defaultHeaderRenderer_ : this.defaultCellRenderer_;
/* 202 */     IViewElement renderer = null;
/* 203 */     RendererDef cellDef = null;
/*     */     
/* 205 */     if (isHeader) {
/* 206 */       cellDef = (RendererDef)argComp.getClientProperty("ColumnHeaderRendererDef");
/*     */     }
/*     */     else {
/*     */       
/* 210 */       if (argRow % 2 != 0) {
/* 211 */         cellDef = (RendererDef)argComp.getClientProperty("AlternateCellRendererDef");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 216 */       if (cellDef == null) {
/* 217 */         cellDef = (RendererDef)argComp.getClientProperty("CellRendererDef");
/*     */       }
/*     */     } 
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
/* 230 */     if (cellDef == null || !cellDef.isSimple()) {
/* 231 */       if (argModel instanceof javax.swing.Action && !((DtvList)argComp).getID().equals(DtvList.ONE_TOUCH_LIST_ID)) {
/* 232 */         if (argComp instanceof DtvList) {
/* 233 */           if (((DtvList)argComp).getID().equals(DtvList.TOUCH_READY_BACK_OFFICE_LIST_ID)) {
/* 234 */             renderer = this.backOfficeActionRenderer_;
/*     */           }
/* 236 */           else if (((DtvList)argComp).getID().equals(DtvList.TOUCH_READY_ICON_MENU_LIST_ID)) {
/* 237 */             renderer = this.iconActionListRenderer_;
/*     */           } else {
/*     */             
/* 240 */             renderer = this.defaultActionRenderer_;
/*     */           } 
/*     */         } else {
/*     */           
/* 244 */           renderer = this.defaultActionRenderer_;
/*     */         } 
/*     */       } else {
/*     */         
/* 248 */         IViewElementType viewType = (cellDef != null) ? cellDef.getType() : null;
/*     */         
/* 250 */         if (viewType == null) {
/* 251 */           String ruleSet = (cellDef != null) ? cellDef.getRuleSet() : null;
/* 252 */           viewType = getViewTypeFromRule(argModel, ruleSet);
/*     */         } 
/*     */         
/* 255 */         if (viewType != null) {
/* 256 */           logger_.debug("Using view type [" + viewType + "].");
/* 257 */           if (isHeader) {
/* 258 */             renderer = getRenderer(this.helper_.getHeaderConfig(viewType));
/*     */           } else {
/*     */             
/* 261 */             renderer = getRenderer(this.helper_.getElementConfig(viewType));
/*     */           } 
/*     */           
/* 264 */           if (renderer == null) {
/* 265 */             logger_.warn("No configuration is defined for view type [" + viewType + "].");
/* 266 */             renderer = defaultRenderer;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/* 271 */     return (renderer != null) ? renderer : defaultRenderer;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\config\ViewElementFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */