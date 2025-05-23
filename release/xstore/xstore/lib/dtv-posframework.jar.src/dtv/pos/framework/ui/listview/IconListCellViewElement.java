/*     */ package dtv.pos.framework.ui.listview;
/*     */ 
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.ui.action.IPosAction;
/*     */ import dtv.pos.ui.component.PosIconListRow;
/*     */ import dtv.pos.ui.component.PosPrettyListCell;
/*     */ import dtv.pos.ui.plaf.component.PosComponentUIType;
/*     */ import dtv.pos.ui.plaf.component.PosIconListRowUI;
/*     */ import dtv.pos.ui.util.IconUtils;
/*     */ import dtv.ui.ComponentID;
/*     */ import dtv.ui.ComponentPropertySet;
/*     */ import dtv.ui.action.IDtvAction;
/*     */ import dtv.ui.context.Context;
/*     */ import dtv.ui.layout.ViewCellData;
/*     */ import java.awt.Color;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.UIManager;
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
/*     */ public class IconListCellViewElement
/*     */   extends DefaultViewElement
/*     */ {
/*  36 */   private static final float ACTION_KEY_STROKE_X = UIRM.getInt("_iconListActionIconKeystrokeX") / 100.0F;
/*     */   
/*  38 */   private static final float ACTION_KEY_STROKE_WIDTH = UIRM
/*  39 */     .getInt("_iconListActionIconKeystrokeWidth") / 100.0F;
/*  40 */   private static final float ACTION_ACCESS_X = UIRM.getInt("_iconListActionIconAccessX") / 100.0F;
/*  41 */   private static final float ACTION_ACCESS_WIDTH = UIRM
/*  42 */     .getInt("_iconListActionIconAccessWidth") / 100.0F;
/*  43 */   private static final float ACTION_NAME_X = UIRM.getInt("_iconListActionIconNameX") / 100.0F;
/*  44 */   private static final float ACTION_NAME_WIDTH = UIRM.getInt("_iconListActionIconNameWidth") / 100.0F;
/*  45 */   private static final float ACTION_NAVIGABLE_X = UIRM.getInt("_iconListActionIconNavigableX") / 100.0F;
/*  46 */   private static final float ACTION_NAVIGABLE_WIDTH = UIRM
/*  47 */     .getInt("_iconListActionIconNavigableWidth") / 100.0F;
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(JList<?> argList, Object argModel, int argIndex, boolean argIsSelected, boolean argHasFocus) {
/*  57 */     super.initialize(argList, argModel, argIndex, argIsSelected, argHasFocus);
/*     */     
/*  59 */     Context context = ((IModeController)this._modeProvider.get()).getContextManager().getCurrentContext();
/*  60 */     ComponentPropertySet properties = context.getPropertySet(new ComponentID("IconListItem"));
/*  61 */     Color bg1 = properties.getColor("backgroundDefault1");
/*  62 */     if (bg1 == null) {
/*  63 */       bg1 = Color.BLUE;
/*     */     }
/*  65 */     Color bg2 = properties.getColor("backgroundDefault2");
/*  66 */     if (bg2 == null) {
/*  67 */       bg2 = Color.BLUE;
/*     */     }
/*  69 */     Color border = properties.getColor("borderColor");
/*  70 */     if (bg2 == null) {
/*  71 */       bg2 = Color.WHITE;
/*     */     }
/*  73 */     Color hover1 = properties.getColor("backgroundHover1");
/*  74 */     if (hover1 == null) {
/*  75 */       hover1 = Color.WHITE;
/*     */     }
/*  77 */     Color hover2 = properties.getColor("backgroundHover2");
/*  78 */     if (hover2 == null) {
/*  79 */       hover2 = Color.WHITE;
/*     */     }
/*     */     
/*  82 */     PosIconListRow cell = (PosIconListRow)this.cell_;
/*     */     
/*  84 */     cell.setHoverColor1(hover1);
/*  85 */     cell.setHoverColor2(hover2);
/*     */     
/*  87 */     if (argModel instanceof IPosAction) {
/*  88 */       cell.setAction((IDtvAction)argModel);
/*     */     }
/*     */     
/*  91 */     cell.setSelected(argIsSelected);
/*     */     
/*  93 */     if (argList.isValid()) {
/*  94 */       cell.setIsFirstVisible((argList != null) ? ((argList.getFirstVisibleIndex() == argIndex)) : false);
/*     */     }
/*  96 */     cell.setBorder(null);
/*  97 */     cell.setFont(argList.getFont());
/*  98 */     cell.setEnabled((argList.isEnabled() && ((IPosAction)argModel).isEnabled()));
/*  99 */     cell.setFocused(argHasFocus);
/* 100 */     cell.setComponentOrientation(argList.getComponentOrientation());
/* 101 */     boolean paintBackground = (cell.isEnabled() && argIsSelected);
/*     */     
/* 103 */     cell.setBackgroundPainted(paintBackground);
/*     */     
/* 105 */     cell.setMultiSelectList((argList.getSelectionMode() != 0));
/* 106 */     cell.setSelectedFromMultiSelectList((argIsSelected && cell.isMultiSelectList()));
/*     */     
/* 108 */     cell.setBorderColor(border);
/*     */     
/* 110 */     if (!cell.isEnabled()) {
/* 111 */       cell.setForeground(UIRM.getRGBColor("_colorDisabled"));
/* 112 */       cell.setDisabledForeground(UIRM.getRGBColor("_colorDisabled"));
/* 113 */       cell.setBackground(UIManager.getColor("PosPrettyListCell.disabledBackground"));
/*     */     }
/* 115 */     else if (argIsSelected) {
/* 116 */       cell.setBackground(bg1);
/* 117 */       cell.setBackground2(bg2);
/* 118 */       cell.setForeground(argList.getSelectionForeground());
/*     */     } else {
/*     */       
/* 121 */       cell.setBackground(argList.getBackground());
/* 122 */       cell.setForeground((argIndex < 0) ? Color.DARK_GRAY : argList.getForeground());
/*     */     } 
/*     */     
/* 125 */     Object obj = argList.getClientProperty("ITEM_HOVERING_INDEX_PROPERTY");
/* 126 */     if (obj instanceof Integer && ((Integer)obj).intValue() == argIndex && argIndex > -1) {
/* 127 */       cell.setIsHovering(true);
/* 128 */       cell.setBackground(bg1.brighter());
/* 129 */       cell.setBackground2(bg2.brighter());
/*     */     } else {
/*     */       
/* 132 */       cell.setIsHovering(false);
/*     */     } 
/*     */     
/* 135 */     obj = argList.getClientProperty("ITEM_PRESSING_INDEX_PROPERTY");
/* 136 */     if (obj instanceof Integer && ((Integer)obj).intValue() == argIndex && argIndex > -1) {
/* 137 */       cell.setIsPressing(true);
/* 138 */       cell.setBackground(bg1.darker());
/* 139 */       cell.setBackground2(bg2.darker());
/*     */     } else {
/*     */       
/* 142 */       cell.setIsPressing(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected ViewCellData buildViewCellData(boolean argEnabled, String argKeyStrokeText, String argActionName, ImageIcon argAccesImage, ImageIcon argNavigableImage) {
/* 149 */     ImageIcon accessImage = argAccesImage;
/* 150 */     ImageIcon navigableImage = argNavigableImage;
/* 151 */     if (!argEnabled) {
/* 152 */       if (accessImage != null) {
/* 153 */         accessImage = IconUtils.getDisabledImageIcon(accessImage);
/*     */       }
/* 155 */       if (navigableImage != null) {
/* 156 */         navigableImage = IconUtils.getDisabledImageIcon(navigableImage);
/*     */       }
/*     */     } 
/* 159 */     ViewCellData.CellColumn[] columns = { new ViewCellData.CellColumn(argActionName, null, null, null, 2, ACTION_NAME_X, ACTION_NAME_WIDTH, false), new ViewCellData.CellColumn("", argAccesImage, null, null, 0, ACTION_ACCESS_X, ACTION_ACCESS_WIDTH, false), new ViewCellData.CellColumn("", argNavigableImage, null, null, 0, ACTION_NAVIGABLE_X, ACTION_NAVIGABLE_WIDTH, false), new ViewCellData.CellColumn(argKeyStrokeText, null, null, null, 2, ACTION_KEY_STROKE_X, ACTION_KEY_STROKE_WIDTH, false) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 168 */     return new ViewCellData(new ViewCellData.CellRow(columns));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected PosPrettyListCell createPrettyListCell() {
/* 174 */     UIManager.put(PosComponentUIType.POS_ICON_LIST_ROW.toString(), PosIconListRowUI.class.getName());
/* 175 */     return (PosPrettyListCell)new PosIconListRow();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\IconListCellViewElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */