/*     */ package dtv.pos.framework.ui.listview;
/*     */ 
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.framework.ui.context.UIContext;
/*     */ import dtv.pos.framework.ui.listview.config.IListViewElementConfig;
/*     */ import dtv.pos.framework.ui.listview.config.ListViewColumnConfig;
/*     */ import dtv.pos.framework.ui.listview.config.ListViewRowConfig;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.ui.UIPaint;
/*     */ import dtv.pos.ui.action.IPosAction;
/*     */ import dtv.pos.ui.component.PosComponentFactory;
/*     */ import dtv.pos.ui.component.PosPrettyListCell;
/*     */ import dtv.pos.ui.component.PosPrettyListHeader;
/*     */ import dtv.pos.ui.plaf.PosBorders;
/*     */ import dtv.pos.ui.util.IconUtils;
/*     */ import dtv.ui.action.IDtvAction;
/*     */ import dtv.ui.layout.ViewCellData;
/*     */ import dtv.ui.swing.DtvList;
/*     */ import dtv.ui.temp.UIAccessLevel;
/*     */ import dtv.ui.touch.animation.IHasHiddenButton;
/*     */ import dtv.util.MutableString;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTree;
/*     */ import javax.swing.KeyStroke;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.border.Border;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultViewElement
/*     */   implements IViewElement
/*     */ {
/*  50 */   private static final float ACTION_KEY_STROKE_X = UIRM.getInt("_xListActionKeyStroke") / 100.0F;
/*  51 */   private static final float ACTION_KEY_STROKE_WIDTH = UIRM.getInt("_widthListActionKeyStroke") / 100.0F;
/*  52 */   private static final float ACTION_ACCESS_X = UIRM.getInt("_xListActionAccess") / 100.0F;
/*  53 */   private static final float ACTION_ACCESS_WIDTH = UIRM.getInt("_widthListActionAccess") / 100.0F;
/*  54 */   private static final float ACTION_NAME_X = UIRM.getInt("_xListActionName") / 100.0F;
/*  55 */   private static final float ACTION_NAME_WIDTH = UIRM.getInt("_widthListActionName") / 100.0F;
/*  56 */   private static final float ACTION_NAVIGABLE_X = UIRM.getInt("_xListActionNavigable") / 100.0F;
/*  57 */   private static final float ACTION_NAVIGABLE_WIDTH = UIRM.getInt("_widthListActionNavigable") / 100.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   private static final Map accessIcons_ = new HashMap<>();
/*     */   
/*     */   static {
/*  65 */     accessIcons_.put(UIAccessLevel.DENIED, null);
/*  66 */     accessIcons_.put(UIAccessLevel.DENIED_SHOWN, null);
/*  67 */     accessIcons_.put(UIAccessLevel.DENIED_OVERRIDABLE, UIRM.getImageIcon("_imageListAccessOverridable"));
/*  68 */     accessIcons_.put(UIAccessLevel.GRANTED, null);
/*     */   }
/*     */   
/*     */   protected final PosPrettyListCell cell_;
/*  72 */   protected IListViewElementConfig config_ = null;
/*  73 */   private final boolean headersInCaps_ = ConfigurationMgr.isTextAllCapsOnListHeaders();
/*     */   
/*     */   protected boolean isHeader_;
/*     */   
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */ 
/*     */   
/*     */   public DefaultViewElement() {
/*  82 */     this(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultViewElement(boolean argHeader) {
/*  92 */     InjectionHammer.forceAtInjectProcessing(this);
/*  93 */     this.cell_ = argHeader ? (PosPrettyListCell)createPrettyListHeader() : createPrettyListCell();
/*  94 */     this.isHeader_ = argHeader;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/* 100 */     return (JComponent)this.cell_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/* 106 */     return (JComponent)this.cell_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(JList<?> argList, Object argModel, int argIndex, boolean argIsSelected, boolean argHasFocus) {
/* 114 */     if (argIsSelected && argList instanceof IHasHiddenButton && this.config_ != null) {
/* 115 */       ((IHasHiddenButton)argList).setHiddenButtonAction((Action)this.config_.getHiddenButtonAction());
/*     */     }
/*     */     
/* 118 */     this.cell_.setFont((this.config_ != null) ? this.config_.getFontConfig().getFont(argList.getFont()) : argList.getFont());
/* 119 */     this.cell_.setEnabled(argList.isEnabled());
/* 120 */     this.cell_.setFocused(argHasFocus);
/* 121 */     this.cell_.setComponentOrientation(argList.getComponentOrientation());
/* 122 */     boolean isRowHeader = DtvList.isRowHeader(argList);
/* 123 */     boolean paintBackground = (argList.isEnabled() && (argIsSelected || isRowHeader));
/*     */     
/* 125 */     this.cell_.setBackgroundPainted(paintBackground);
/*     */     
/* 127 */     this.cell_.setMultiSelectList((argList.getSelectionMode() != 0));
/* 128 */     this.cell_.setSelectedFromMultiSelectList((argIsSelected && this.cell_.isMultiSelectList()));
/*     */     
/* 130 */     if (!this.cell_.isEnabled() || (argModel instanceof IPosAction && 
/* 131 */       !((IPosAction)argModel).isEnabled())) {
/* 132 */       this.cell_.setForeground(UIRM.getRGBColor("_colorDisabled"));
/* 133 */       this.cell_.setBackground(UIManager.getColor("PosPrettyListCell.disabledBackground"));
/*     */     }
/* 135 */     else if (argIsSelected && !isRowHeader) {
/* 136 */       UIContext c = (UIContext)((IModeController)this._modeProvider.get()).getContextManager().getCurrentContext();
/*     */ 
/*     */       
/* 139 */       Color defaultSelectedBgColor = (c.getBackgroundColor() != null) ? c.getBackgroundColor() : UIRM.getRGBColor("_colorListSelectionBackground");
/*     */       
/* 141 */       Color bgColorToUse = (this.config_ != null && this.config_.getColorGroupConfig().getSelectionBgColor() != null) ? this.config_.getColorGroupConfig().getSelectionBgColor() : defaultSelectedBgColor;
/*     */ 
/*     */       
/* 144 */       Color defaultSelectedBgColor2 = (c.getBackgroundColor2() != null) ? c.getBackgroundColor2() : UIRM.getRGBColor("_colorListSelectionBackground2");
/*     */       
/* 146 */       Color bgColorToUse2 = (this.config_ != null && this.config_.getColorGroupConfig().getSelectionBgColor2() != null) ? this.config_.getColorGroupConfig().getSelectionBgColor2() : defaultSelectedBgColor2;
/*     */ 
/*     */       
/* 149 */       Color fgColorToUse = (this.config_ != null && this.config_.getColorGroupConfig().getSelectionFgColor() != null) ? this.config_.getColorGroupConfig().getSelectionFgColor() : argList.getSelectionForeground();
/*     */       
/* 151 */       this.cell_.setBackground(bgColorToUse);
/* 152 */       this.cell_.setBackground2(bgColorToUse2);
/* 153 */       this.cell_.setForeground(fgColorToUse);
/*     */     } else {
/*     */       
/* 156 */       Color configBgColor = (this.config_ != null) ? this.config_.getColorGroupConfig().getBgColor() : null;
/* 157 */       this.cell_.setBackground((configBgColor != null) ? configBgColor : argList.getBackground());
/*     */       
/* 159 */       Color configBgColor2 = (this.config_ != null) ? this.config_.getColorGroupConfig().getBgColor2() : null;
/* 160 */       this.cell_.setBackground2((configBgColor2 != null) ? configBgColor2 : argList.getBackground());
/*     */       
/* 162 */       Color configFgColor = (this.config_ != null) ? this.config_.getColorGroupConfig().getFgColor() : null;
/*     */ 
/*     */       
/* 165 */       Color defaultFgColor = (argIndex < 0) ? Color.DARK_GRAY : argList.getForeground();
/* 166 */       this.cell_.setForeground((configFgColor != null) ? configFgColor : defaultFgColor);
/*     */     } 
/*     */     
/* 169 */     if (isRowHeader) {
/* 170 */       this.cell_.setUIPaint(UIPaint.HIGHLIGHT_RIGHT);
/*     */     }
/*     */     
/* 173 */     Border cellBorder = null;
/*     */     
/* 175 */     if (argHasFocus && this.cell_.isEnabled()) {
/*     */       
/* 177 */       Color configHighlightColor = (this.config_ != null) ? this.config_.getColorGroupConfig().getHighlightColor() : null;
/*     */       
/* 179 */       if (configHighlightColor != null) {
/* 180 */         String key = "PosPrettyList.focusCellHighlightBorder" + configHighlightColor.toString();
/* 181 */         cellBorder = UIManager.getBorder(key);
/*     */         
/* 183 */         if (cellBorder == null) {
/*     */           
/* 185 */           cellBorder = PosBorders.getPlainBorder(UIRM.getInsets("_marginListCell"), new BasicStroke(5.0F), configHighlightColor);
/* 186 */           UIManager.getDefaults().put(key, cellBorder);
/*     */         } 
/*     */       } else {
/*     */         
/* 190 */         cellBorder = UIManager.getBorder("PosPrettyList.focusCellHighlightBorder");
/*     */       } 
/*     */     } else {
/*     */       
/* 194 */       cellBorder = UIManager.getBorder("PosPrettyList.noFocusCellBorder");
/*     */     } 
/*     */     
/* 197 */     this.cell_.setBorder(cellBorder);
/*     */     
/* 199 */     if (argModel instanceof Icon) {
/* 200 */       this.cell_.setIcon((Icon)argModel);
/* 201 */       this.cell_.setText("");
/*     */     }
/* 203 */     else if (argModel instanceof ViewCellData) {
/* 204 */       this.cell_.setCellData((ViewCellData)argModel);
/*     */     }
/* 206 */     else if (argModel instanceof IPosAction) {
/* 207 */       this.cell_.setAction((IDtvAction)argModel);
/*     */     }
/* 209 */     else if (argModel instanceof MutableString) {
/* 210 */       this.cell_.setIcon(null);
/* 211 */       this.cell_.setText((MutableString)argModel);
/*     */     } else {
/*     */       
/* 214 */       this.cell_.setIcon(null);
/* 215 */       this.cell_.setText((argModel == null) ? "" : argModel.toString());
/*     */     } 
/*     */     
/* 218 */     if (this.isHeader_) {
/* 219 */       this.cell_.setBackgroundPainted(true);
/*     */       
/* 221 */       Color defaultHeaderBgColor = UIRM.getRGBColor("_colorListHeaderBackground");
/* 222 */       Color configBgColor = (this.config_ != null) ? this.config_.getColorGroupConfig().getBgColor() : null;
/* 223 */       this.cell_.setBackground((configBgColor != null) ? configBgColor : defaultHeaderBgColor);
/*     */       
/* 225 */       Color defaultHeaderBgColor2 = UIRM.getRGBColor("_colorListHeaderBackground2");
/* 226 */       Color configBgColor2 = (this.config_ != null) ? this.config_.getColorGroupConfig().getBgColor2() : null;
/* 227 */       this.cell_.setBackground2((configBgColor2 != null) ? configBgColor2 : defaultHeaderBgColor2);
/*     */       
/* 229 */       Color defaultFgColor = UIRM.getRGBColor("_colorListHeaderForeground");
/* 230 */       Color configFgColor = (this.config_ != null) ? this.config_.getColorGroupConfig().getFgColor() : null;
/* 231 */       this.cell_.setForeground((configFgColor != null) ? configFgColor : defaultFgColor);
/*     */     } 
/*     */     
/* 234 */     initializeCellDisplay(argModel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(JTable argTable, Object argModel, int argRow, int argColumn, boolean argIsSelected, boolean argHasFocus) {
/* 242 */     this.cell_.setFont((this.config_ != null) ? this.config_
/* 243 */         .getFontConfig().getFont(argTable.getFont()) : argTable.getFont());
/* 244 */     this.cell_.setEnabled(argTable.isEnabled());
/* 245 */     this.cell_.setFocused(argHasFocus);
/* 246 */     this.cell_.setComponentOrientation(argTable.getComponentOrientation());
/* 247 */     this.cell_.setBackgroundPainted(argTable.isEnabled());
/*     */     
/* 249 */     if (argIsSelected) {
/* 250 */       Color configBgColor = (this.config_ != null) ? this.config_.getColorGroupConfig().getSelectionBgColor() : null;
/* 251 */       this.cell_.setBackground((configBgColor != null) ? configBgColor : argTable.getSelectionBackground());
/*     */       
/* 253 */       Color defaultSelectedBgColor2 = UIManager.getColor("PosPrettyList.selectionBackground2");
/* 254 */       Color configBgColor2 = (this.config_ != null) ? this.config_.getColorGroupConfig().getSelectionBgColor2() : null;
/* 255 */       this.cell_.setBackground2((configBgColor2 != null) ? configBgColor2 : defaultSelectedBgColor2);
/*     */       
/* 257 */       Color configFgColor = (this.config_ != null) ? this.config_.getColorGroupConfig().getSelectionFgColor() : null;
/* 258 */       this.cell_.setForeground((configFgColor != null) ? configFgColor : argTable.getSelectionForeground());
/*     */     } else {
/*     */       
/* 261 */       this.cell_.setUIPaint(UIPaint.HIGHLIGHT_BOTTOM);
/* 262 */       Color configBgColor = (this.config_ != null) ? this.config_.getColorGroupConfig().getBgColor() : null;
/* 263 */       this.cell_.setBackground((configBgColor != null) ? configBgColor : argTable.getBackground());
/*     */       
/* 265 */       Color configBgColor2 = (this.config_ != null) ? this.config_.getColorGroupConfig().getBgColor2() : null;
/* 266 */       this.cell_.setBackground2((configBgColor2 != null) ? configBgColor2 : argTable.getBackground());
/*     */       
/* 268 */       Color configFgColor = (this.config_ != null) ? this.config_.getColorGroupConfig().getFgColor() : null;
/* 269 */       this.cell_.setForeground((configFgColor != null) ? configFgColor : argTable.getForeground());
/*     */     } 
/* 271 */     this.cell_.setBorder((argHasFocus && this.cell_.isEnabled()) ? 
/* 272 */         UIManager.getBorder("PosPrettyList.focusCellHighlightBorder") : 
/* 273 */         UIManager.getBorder("PosPrettyList.noFocusCellBorder"));
/*     */     
/* 275 */     initializeCellDisplay(argModel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(JTree argTree, Object argModel, int argRow, boolean argIsSelected, boolean argHasFocus, boolean argIsExpanded, boolean argIsLeaf) {
/* 283 */     this.cell_.setFont((this.config_ != null) ? this.config_.getFontConfig().getFont(argTree.getFont()) : argTree.getFont());
/* 284 */     this.cell_.setEnabled(argTree.isEnabled());
/* 285 */     this.cell_.setFocused(argHasFocus);
/* 286 */     this.cell_.setComponentOrientation(argTree.getComponentOrientation());
/* 287 */     this.cell_.setBackgroundPainted((argIsSelected && argTree.isEnabled()));
/*     */     
/* 289 */     this.cell_.setMultiSelectList(
/* 290 */         (argTree.getSelectionModel().getSelectionMode() != 1));
/* 291 */     this.cell_.setSelectedFromMultiSelectList((argIsSelected && this.cell_.isMultiSelectList()));
/*     */     
/* 293 */     if (!this.cell_.isEnabled()) {
/* 294 */       this.cell_.setForeground(Color.lightGray);
/*     */     }
/* 296 */     else if (argIsSelected) {
/* 297 */       Color configBgColor = (this.config_ != null) ? this.config_.getColorGroupConfig().getSelectionBgColor() : null;
/* 298 */       this.cell_.setBackground((configBgColor != null) ? configBgColor : 
/* 299 */           UIManager.getColor("Tree.selectionBackground"));
/*     */       
/* 301 */       Color configFgColor = (this.config_ != null) ? this.config_.getColorGroupConfig().getSelectionFgColor() : null;
/* 302 */       this.cell_.setForeground((configFgColor != null) ? configFgColor : 
/* 303 */           UIManager.getColor("Tree.selectionForeground"));
/*     */     } else {
/*     */       
/* 306 */       Color configBgColor = (this.config_ != null) ? this.config_.getColorGroupConfig().getBgColor() : null;
/* 307 */       this.cell_.setBackground((configBgColor != null) ? configBgColor : argTree.getBackground());
/*     */       
/* 309 */       Color configFgColor = (this.config_ != null) ? this.config_.getColorGroupConfig().getFgColor() : null;
/* 310 */       this.cell_.setForeground((configFgColor != null) ? configFgColor : argTree.getForeground());
/*     */     } 
/* 312 */     this.cell_.setBorder((argHasFocus && this.cell_.isEnabled()) ? 
/* 313 */         UIManager.getBorder("PosPrettyList.focusCellHighlightBorder") : 
/* 314 */         UIManager.getBorder("PosPrettyList.noFocusCellBorder"));
/*     */     
/* 316 */     initializeCellDisplay(argModel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(Object argModel) {
/* 323 */     Color configBgColor = (this.config_ != null) ? this.config_.getColorGroupConfig().getBgColor() : null;
/* 324 */     if (configBgColor != null) {
/* 325 */       this.cell_.setBackgroundPainted(true);
/* 326 */       this.cell_.setBackground(configBgColor);
/*     */     } 
/* 328 */     Color configFgColor = (this.config_ != null) ? this.config_.getColorGroupConfig().getFgColor() : null;
/* 329 */     if (configFgColor != null) {
/* 330 */       this.cell_.setForeground(configFgColor);
/*     */     }
/* 332 */     this.cell_.setFont((this.config_ != null) ? this.config_.getFontConfig().getFont(this.cell_.getFont()) : this.cell_.getFont());
/* 333 */     this.cell_.setBorder(UIManager.getBorder("PosPrettyList.noFocusCellBorder"));
/*     */     
/* 335 */     initializeCellDisplay(argModel);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfig(IListViewElementConfig argConfig) {
/* 341 */     this.config_ = argConfig;
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
/*     */   protected ViewCellData buildViewCellData(boolean argEnabled, String argKeyStrokeText, String argActionName, ImageIcon argAccesImageIcon, ImageIcon argNavigableImageIcon) {
/* 356 */     ViewCellData.CellColumn[] columns = { new ViewCellData.CellColumn(argKeyStrokeText, null, null, null, 0, ACTION_KEY_STROKE_X, ACTION_KEY_STROKE_WIDTH, false), new ViewCellData.CellColumn(argActionName, null, null, null, 2, ACTION_NAME_X, ACTION_NAME_WIDTH, false), new ViewCellData.CellColumn("", argAccesImageIcon, null, null, 0, ACTION_ACCESS_X, ACTION_ACCESS_WIDTH, false), new ViewCellData.CellColumn("", argNavigableImageIcon, null, null, 0, ACTION_NAVIGABLE_X, ACTION_NAVIGABLE_WIDTH, false) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 365 */     return new ViewCellData(new ViewCellData.CellRow(columns));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ViewCellData convertToCellData(IDtvAction action) {
/* 376 */     if (action == null) {
/* 377 */       return null;
/*     */     }
/*     */     
/* 380 */     ImageIcon navigableIcon_ = IconUtils.getImageIcon(UIManager.getIcon("PosPrettyListCell.navigableIcon"));
/*     */ 
/*     */ 
/*     */     
/* 384 */     ImageIcon navigableImage = action.isNavigable() ? navigableIcon_ : null;
/*     */ 
/*     */     
/* 387 */     String keyStrokeText = "";
/* 388 */     KeyStroke keyStroke = action.getKeyStroke();
/* 389 */     if (keyStroke != null) {
/* 390 */       keyStrokeText = KeyEvent.getKeyText(keyStroke.getKeyCode());
/*     */     }
/*     */ 
/*     */     
/* 394 */     ImageIcon accessIcon = (ImageIcon)accessIcons_.get(action.getAccessLevel());
/*     */     
/* 396 */     return buildViewCellData(action.isEnabled(), keyStrokeText, action
/* 397 */         .getActionName().toString(OutputContextType.VIEW), accessIcon, navigableImage);
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
/*     */   protected ViewCellData convertToCellData(String text, ImageIcon icon) {
/* 409 */     ViewCellData.CellColumn column = new ViewCellData.CellColumn(text, icon, null, null, 10, 0.0F, 1.0F, false);
/*     */     
/* 411 */     return new ViewCellData(new ViewCellData.CellRow(column));
/*     */   }
/*     */   
/*     */   protected PosPrettyListCell createPrettyListCell() {
/* 415 */     return PosComponentFactory.getInstance().createPrettyListCell();
/*     */   }
/*     */   
/*     */   protected PosPrettyListHeader createPrettyListHeader() {
/* 419 */     return PosComponentFactory.getInstance().createPrettyListHeader();
/*     */   }
/*     */   
/*     */   private List<ViewCellData.CellRow> getRowData(Object argModel, IListViewElementConfig argConfig) {
/* 423 */     List<ViewCellData.CellRow> rowData = new ArrayList<>();
/*     */     
/* 425 */     for (ListViewRowConfig rowConfig : argConfig.getRows()) {
/* 426 */       if (rowConfig.validateSecurity()) {
/* 427 */         List<ViewCellData.CellColumn> colData = new ArrayList<>();
/*     */         
/* 429 */         Color rowTextColor = rowConfig.getColorGroupConfig().getFgColor();
/* 430 */         Font rowFont = rowConfig.getFontConfig().getFont();
/*     */         
/* 432 */         for (ListViewColumnConfig colConfig : rowConfig.getColumns()) {
/* 433 */           if (colConfig.validateSecurity()) {
/* 434 */             ICellDataHandler cellHandler = colConfig.getCellDataHandlerFactory();
/*     */             
/* 436 */             ViewCellData.CellColumn cellCol = cellHandler.buildCellColumn(colConfig, argModel, rowTextColor, rowFont);
/*     */             
/* 438 */             if (this.headersInCaps_ && cellCol != null && cellCol.getDisplayText() != null && cellCol
/* 439 */               .getDisplayText().length() > 0 && this.isHeader_) {
/* 440 */               cellCol.setDisplayText(cellCol.getDisplayText().toUpperCase());
/*     */             }
/*     */             
/* 443 */             colData.add(cellCol);
/*     */           } 
/*     */         } 
/* 446 */         rowData.add(new ViewCellData.CellRow(colData, rowConfig.getRenderer()));
/*     */       } 
/*     */     } 
/*     */     
/* 450 */     return rowData;
/*     */   }
/*     */ 
/*     */   
/*     */   private void initializeCellDisplay(Object argModel) {
/* 455 */     List<ViewCellData.CellRow> rowData = new ArrayList<>();
/* 456 */     ViewCellData viewCellData = null;
/*     */     
/* 458 */     if (this.config_ != null) {
/* 459 */       if (argModel instanceof IListElementGroup) {
/* 460 */         IListElementGroup<?> wrapper = (IListElementGroup)argModel;
/*     */         
/* 462 */         for (Object o : wrapper.getListElements()) {
/* 463 */           rowData.addAll(getRowData(o, this.config_));
/*     */         }
/*     */       } else {
/*     */         
/* 467 */         rowData.addAll(getRowData(argModel, this.config_));
/*     */       } 
/*     */       
/* 470 */       if (!rowData.isEmpty()) {
/* 471 */         viewCellData = new ViewCellData(rowData);
/* 472 */         viewCellData.setIconKey(this.config_.getIconKey());
/*     */       } 
/*     */     } 
/*     */     
/* 476 */     if (!this.isHeader_ && 
/* 477 */       viewCellData == null) {
/*     */ 
/*     */       
/* 480 */       if (this.cell_.getAction() != null) {
/* 481 */         viewCellData = convertToCellData(this.cell_.getAction());
/*     */       }
/*     */       
/* 484 */       if (viewCellData == null) {
/* 485 */         ImageIcon cellImageIcon = IconUtils.getImageIcon(this.cell_.getIcon());
/* 486 */         viewCellData = convertToCellData(this.cell_.getText(), cellImageIcon);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 491 */     this.cell_.setCellData(viewCellData);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\DefaultViewElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */