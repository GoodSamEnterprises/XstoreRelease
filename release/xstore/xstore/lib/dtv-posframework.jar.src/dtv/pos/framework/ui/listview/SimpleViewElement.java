/*     */ package dtv.pos.framework.ui.listview;
/*     */ 
/*     */ import dtv.pos.framework.ui.listview.config.IListViewElementConfig;
/*     */ import dtv.pos.ui.component.PosComponentFactory;
/*     */ import dtv.pos.ui.component.PosPrettyListCell;
/*     */ import dtv.pos.ui.util.IconUtils;
/*     */ import dtv.ui.layout.ViewCellData;
/*     */ import dtv.ui.swing.DtvList;
/*     */ import java.awt.Color;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTree;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SimpleViewElement
/*     */   implements IViewElement
/*     */ {
/*  35 */   private static int index_ = 0;
/*     */   
/*     */   private final PosPrettyListCell cell_;
/*  38 */   private final String myId_ = "@" + index_++;
/*     */   
/*     */   private final boolean isHeader_;
/*     */   
/*     */   public SimpleViewElement() {
/*  43 */     this(false);
/*     */   }
/*     */   
/*     */   public SimpleViewElement(boolean argHeader) {
/*  47 */     this.isHeader_ = argHeader;
/*  48 */     if (this.isHeader_) {
/*  49 */       this.cell_ = (PosPrettyListCell)PosComponentFactory.getInstance().createPrettyListHeader();
/*     */     } else {
/*     */       
/*  52 */       this.cell_ = PosComponentFactory.getInstance().createPrettyListCell();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  58 */     return (JComponent)this.cell_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  69 */     return (JComponent)this.cell_;
/*     */   }
/*     */   
/*     */   public String getId() {
/*  73 */     return this.myId_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(JList<?> argList, Object argModel, int argIndex, boolean argIsSelected, boolean argCellHasFocus) {
/*  79 */     setModel(argModel);
/*     */     
/*  81 */     this.cell_.setFont(argList.getFont());
/*  82 */     this.cell_.setEnabled(argList.isEnabled());
/*  83 */     this.cell_.setFocused(argCellHasFocus);
/*  84 */     this.cell_.setComponentOrientation(argList.getComponentOrientation());
/*  85 */     boolean isRowHeader = DtvList.isRowHeader(argList);
/*  86 */     boolean paintBackground = (argList.isEnabled() && (argIsSelected || isRowHeader));
/*     */     
/*  88 */     this.cell_.setBackgroundPainted(paintBackground);
/*     */     
/*  90 */     this.cell_.setMultiSelectList((argList.getSelectionMode() != 0));
/*  91 */     this.cell_.setSelectedFromMultiSelectList((argIsSelected && this.cell_.isMultiSelectList()));
/*     */     
/*  93 */     if (!this.cell_.isEnabled()) {
/*  94 */       this.cell_.setForeground(UIManager.getColor("PosPrettyLabel.disabledText"));
/*  95 */       this.cell_.setBackground(UIManager.getColor("PosPrettyListCell.disabledBackground"));
/*     */     }
/*  97 */     else if (argIsSelected && !isRowHeader) {
/*  98 */       Color defaultSelectedBgColor = UIRM.getRGBColor("_colorListSelectionBackground");
/*  99 */       Color defaultSelectedBgColor2 = UIRM.getRGBColor("_colorListSelectionBackground2");
/*     */       
/* 101 */       this.cell_.setBackground(defaultSelectedBgColor);
/* 102 */       this.cell_.setBackground2(defaultSelectedBgColor2);
/* 103 */       this.cell_.setForeground(argList.getSelectionForeground());
/*     */     } else {
/*     */       
/* 106 */       this.cell_.setBackground(argList.getBackground());
/* 107 */       this.cell_.setBackground2(argList.getBackground());
/* 108 */       this.cell_.setForeground(argList.getForeground());
/*     */     } 
/*     */     
/* 111 */     this.cell_.setBorder((argCellHasFocus && this.cell_.isEnabled()) ? 
/* 112 */         UIManager.getBorder("PosPrettyList.focusCellHighlightBorder") : 
/* 113 */         UIManager.getBorder("PosPrettyList.noFocusCellBorder"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(JTable argTable, Object argModel, int argRow, int argColumn, boolean argIsSelected, boolean argCellHasFocus) {
/* 120 */     setModel(argModel);
/*     */     
/* 122 */     this.cell_.setFont(argTable.getFont());
/* 123 */     this.cell_.setEnabled(argTable.isEnabled());
/* 124 */     this.cell_.setFocused(argCellHasFocus);
/* 125 */     this.cell_.setComponentOrientation(argTable.getComponentOrientation());
/* 126 */     this.cell_.setBackgroundPainted((argIsSelected && argTable.isEnabled()));
/*     */     
/* 128 */     if (argIsSelected) {
/* 129 */       this.cell_.setBackground(argTable.getSelectionBackground());
/* 130 */       this.cell_.setBackground2(UIManager.getColor("PosPrettyList.selectionBackground2"));
/* 131 */       this.cell_.setForeground(argTable.getSelectionForeground());
/*     */     } else {
/*     */       
/* 134 */       this.cell_.setBackground(argTable.getBackground());
/* 135 */       this.cell_.setBackground2(argTable.getBackground());
/* 136 */       this.cell_.setForeground(argTable.getForeground());
/*     */     } 
/* 138 */     this.cell_.setBorder((argCellHasFocus && this.cell_.isEnabled()) ? 
/* 139 */         UIManager.getBorder("PosPrettyList.focusCellHighlightBorder") : 
/* 140 */         UIManager.getBorder("PosPrettyList.noFocusCellBorder"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(JTree argTree, Object argModel, int argRow, boolean argIsSelected, boolean argCellHasFocus, boolean argExpanded, boolean argLeaf) {
/* 147 */     setModel(argModel);
/*     */     
/* 149 */     this.cell_.setFont(argTree.getFont());
/* 150 */     this.cell_.setEnabled(argTree.isEnabled());
/* 151 */     this.cell_.setFocused(argCellHasFocus);
/* 152 */     this.cell_.setComponentOrientation(argTree.getComponentOrientation());
/* 153 */     this.cell_.setBackgroundPainted((argIsSelected && argTree.isEnabled()));
/*     */     
/* 155 */     this.cell_.setMultiSelectList(
/* 156 */         (argTree.getSelectionModel().getSelectionMode() != 1));
/* 157 */     this.cell_.setSelectedFromMultiSelectList((argIsSelected && this.cell_.isMultiSelectList()));
/*     */     
/* 159 */     if (!this.cell_.isEnabled()) {
/* 160 */       this.cell_.setForeground(Color.lightGray);
/*     */     }
/* 162 */     else if (argIsSelected) {
/* 163 */       this.cell_.setBackground(UIManager.getColor("Tree.selectionBackground"));
/* 164 */       this.cell_.setForeground(UIManager.getColor("Tree.selectionForeground"));
/*     */     } else {
/*     */       
/* 167 */       this.cell_.setBackground(argTree.getBackground());
/* 168 */       this.cell_.setForeground(argTree.getForeground());
/*     */     } 
/* 170 */     this.cell_.setBorder((argCellHasFocus && this.cell_.isEnabled()) ? 
/* 171 */         UIManager.getBorder("PosPrettyList.focusCellHighlightBorder") : 
/* 172 */         UIManager.getBorder("PosPrettyList.noFocusCellBorder"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void initialize(Object argModel) {
/* 177 */     setModel(argModel);
/* 178 */     this.cell_.setBorder(UIManager.getBorder("PosPrettyList.noFocusCellBorder"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfig(IListViewElementConfig config) {}
/*     */ 
/*     */   
/*     */   private void setModel(Object argModel) {
/* 187 */     if (argModel instanceof Icon) {
/* 188 */       this.cell_.setIcon((Icon)argModel);
/* 189 */       this.cell_.setText("");
/*     */     } else {
/*     */       
/* 192 */       this.cell_.setIcon(null);
/* 193 */       this.cell_.setText((argModel == null) ? "" : argModel.toString());
/*     */     } 
/*     */     
/* 196 */     if (!this.isHeader_) {
/* 197 */       ImageIcon cellImageIcon = IconUtils.getImageIcon(this.cell_.getIcon());
/*     */       
/* 199 */       ViewCellData.CellColumn column = new ViewCellData.CellColumn(this.cell_.getText(), cellImageIcon, null, null, 10, 0.0F, 1.0F, false);
/*     */       
/* 201 */       ViewCellData data = new ViewCellData(new ViewCellData.CellRow(column));
/*     */       
/* 203 */       this.cell_.setCellData(data);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\SimpleViewElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */