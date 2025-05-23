/*     */ package dtv.pos.framework.ui.component;
/*     */ 
/*     */ import dtv.pos.framework.ui.listview.config.ViewElementFactory;
/*     */ import dtv.pos.iframework.ui.IViewElementType;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.iframework.ui.RendererDef;
/*     */ import dtv.ui.ComponentID;
/*     */ import dtv.ui.model.DefaultCombinedListModel;
/*     */ import dtv.ui.model.ICombinedListModel;
/*     */ import dtv.ui.swing.DtvList;
/*     */ import dtv.ui.swing.DtvScrollList;
/*     */ import dtv.ui.swing.DtvScrollPane;
/*     */ import dtv.ui.swing.DtvTouchReadyList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JViewport;
/*     */ import javax.swing.ListCellRenderer;
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
/*     */ public class XstList
/*     */   implements IXstViewComponent
/*     */ {
/*     */   private final JComponent displayComponent_;
/*     */   private ICombinedListModel<Object> model_;
/*     */   
/*     */   public XstList() {
/*  37 */     this(null, null, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XstList(boolean argUseSimpleRenderer) {
/*  47 */     this(null, null, argUseSimpleRenderer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XstList(ComponentID argId) {
/*  55 */     this(argId, null, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XstList(ComponentID argId, boolean argUseSimpleRenderer) {
/*  66 */     this(argId, null, argUseSimpleRenderer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XstList(ComponentID argId, ICombinedListModel<Object> argModel) {
/*  76 */     this(argId, argModel, false);
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
/*     */   public XstList(ComponentID argId, ICombinedListModel<Object> argModel, boolean argUseSimpleRenderer) {
/*  88 */     ComponentID listId = (argId != null) ? argId : DtvList.TOUCH_READY_LIST_ID;
/*     */     
/*  90 */     ComponentID scrollId = DtvList.INTEGRATED_ID.equals(listId) ? DtvScrollPane.HEADER_FOOTER_ID : DtvScrollPane.ENCLOSED_ID;
/*     */     
/*  92 */     if (listId.equals(DtvList.TOUCH_READY_LIST_ID) || listId.equals(DtvList.TOUCH_READY_TRANSACTION_LIST_ID) || listId
/*  93 */       .equals(DtvList.TOUCH_READY_BACK_OFFICE_LIST_ID) || listId
/*  94 */       .equals(DtvList.TOUCH_READY_ICON_MENU_LIST_ID) || listId
/*  95 */       .equals(DtvList.TOUCH_READY_ACTIVITY_LIST_ID) || listId
/*  96 */       .equals(DtvList.TOUCH_READY_NON_INTERACTIVE_LIST_ID)) {
/*  97 */       this.displayComponent_ = (JComponent)new DtvTouchReadyList(listId);
/*     */     } else {
/*     */       
/* 100 */       this.displayComponent_ = (JComponent)new DtvScrollList(scrollId, new DtvList(listId));
/*     */     } 
/*     */     
/* 103 */     ICombinedListModel<Object> model = (argModel != null) ? argModel : (ICombinedListModel<Object>)new DefaultCombinedListModel();
/* 104 */     setModel(model);
/* 105 */     setUseSimpleRenderer(argUseSimpleRenderer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XstList(ICombinedListModel<Object> argModel) {
/* 113 */     this(null, argModel, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XstList(ICombinedListModel<Object> argModel, boolean argUseSimpleRenderer) {
/* 124 */     this(null, argModel, argUseSimpleRenderer);
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/* 129 */     return this.displayComponent_;
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/* 134 */     return (JComponent)getListComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DtvList getListComponent() {
/* 142 */     return getScrollListComponent().getListComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ICombinedListModel<Object> getModel() {
/* 150 */     return this.model_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlternateCellRendererDef(RendererDef argRendererDef) {
/* 160 */     getListComponent().putClientProperty("AlternateCellRendererDef", argRendererDef);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCellRendererDef(RendererDef argRendererDef) {
/* 169 */     getListComponent().putClientProperty("CellRendererDef", argRendererDef);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColumnHeaderRendererDef(RendererDef argRendererDef) {
/* 178 */     JViewport colViewport = getScrollListComponent().getColumnHeader();
/*     */     
/* 180 */     if (colViewport != null && colViewport.getView() instanceof JComponent) {
/* 181 */       JComponent colHeader = (JComponent)colViewport.getView();
/*     */       
/* 183 */       colHeader.putClientProperty("ColumnHeaderRendererDef", argRendererDef);
/* 184 */       colHeader.revalidate();
/* 185 */       colHeader.repaint();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     DtvList list = getListComponent();
/*     */     
/* 196 */     list.putClientProperty("ColumnHeaderRendererDef", argRendererDef);
/* 197 */     list.revalidate();
/* 198 */     list.repaint();
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
/*     */   public void setCornerRendererDef(String argCorner, RendererDef argRendererDef) {
/* 213 */     IViewElementType type = (argRendererDef != null) ? argRendererDef.getType() : null;
/* 214 */     getScrollListComponent().setCorner(argCorner, ViewElementFactory.getInstance().getHeader(type, null));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setModel(ICombinedListModel<Object> argModel) {
/* 222 */     if (argModel == null) {
/* 223 */       this.model_ = null;
/*     */       return;
/*     */     } 
/* 226 */     if (argModel != this.model_) {
/* 227 */       this.model_ = argModel;
/* 228 */       getListComponent().setModel(argModel);
/*     */     } 
/* 230 */     argModel.getModel().setCellRenderer((ListCellRenderer)ViewElementFactory.getInstance());
/* 231 */     argModel.getModel().setDefaultColumnHeaderRenderer(ViewElementFactory.getInstance());
/* 232 */     argModel.getModel().setDefaultRowHeaderRenderer(ViewElementFactory.getInstance());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowHeaderRendererDef(RendererDef argRendererDef) {
/* 241 */     JViewport rowViewport = getScrollListComponent().getRowHeader();
/*     */     
/* 243 */     if (rowViewport != null && rowViewport.getView() instanceof JComponent) {
/* 244 */       JComponent rowHeader = (JComponent)rowViewport.getView();
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
/* 257 */       rowHeader.putClientProperty("CellRendererDef", argRendererDef);
/* 258 */       rowHeader.revalidate();
/* 259 */       rowHeader.repaint();
/*     */     } 
/*     */     
/* 262 */     DtvList list = getListComponent();
/*     */     
/* 264 */     list.putClientProperty("RowHeaderRendererDef", argRendererDef);
/* 265 */     list.revalidate();
/* 266 */     list.repaint();
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
/*     */   public void setSelection(Object argElem, boolean argShow) {
/* 279 */     getModel().setSelection(argElem);
/* 280 */     if (argShow) {
/* 281 */       int selection = getModel().getSelectionModel().getMaxSelectionIndex();
/* 282 */       if (selection >= 0) {
/* 283 */         getListComponent().ensureIndexIsVisible(selection);
/*     */       }
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
/*     */   public void setSelections(List<Object> argElems, boolean argShowLast) {
/* 299 */     getModel().setSelections(argElems);
/* 300 */     if (argShowLast) {
/* 301 */       int maxSelection = getModel().getSelectionModel().getMaxSelectionIndex();
/* 302 */       if (maxSelection >= 0) {
/* 303 */         getListComponent().ensureIndexIsVisible(maxSelection);
/*     */       }
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
/*     */   public void setSelections(Object[] argElems, boolean argShowLast) {
/* 319 */     setSelections((argElems != null) ? Arrays.<Object>asList(argElems) : null, argShowLast);
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
/*     */   public void setUseSimpleRenderer(boolean argUseSimpleRenderer) {
/* 334 */     setCellRendererDef(new RendererDef(argUseSimpleRenderer));
/* 335 */     setColumnHeaderRendererDef(new RendererDef(argUseSimpleRenderer));
/* 336 */     setRowHeaderRendererDef(new RendererDef(argUseSimpleRenderer));
/* 337 */     setCornerRendererDef("UPPER_LEFT_CORNER", new RendererDef(argUseSimpleRenderer));
/*     */   }
/*     */ 
/*     */   
/*     */   private DtvScrollList getScrollListComponent() {
/* 342 */     if (this.displayComponent_ instanceof DtvScrollList) {
/* 343 */       return (DtvScrollList)this.displayComponent_;
/*     */     }
/* 345 */     if (this.displayComponent_ instanceof DtvTouchReadyList) {
/* 346 */       return ((DtvTouchReadyList)this.displayComponent_).getScrollList();
/*     */     }
/*     */     
/* 349 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */