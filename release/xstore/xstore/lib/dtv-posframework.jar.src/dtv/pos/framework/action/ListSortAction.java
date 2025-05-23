/*     */ package dtv.pos.framework.action;
/*     */ 
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.framework.action.type.SortActionKey;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.ISortAction;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.action.SortActionComparatorFactory;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.IEditModelField;
/*     */ import dtv.pos.iframework.security.ISecurityResponse;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.pos.iframework.ui.model.IStationModel;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.ui.model.ICombinedListModel;
/*     */ import dtv.ui.model.IListModel;
/*     */ import dtv.util.ListHolder;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import java.awt.Image;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
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
/*     */ public class ListSortAction
/*     */   extends XstDefaultAction
/*     */   implements ISortAction
/*     */ {
/*  41 */   private static final Logger _logger = Logger.getLogger(ListSortAction.class);
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*  44 */   private String _listField = null;
/*  45 */   private Comparator<Object> _sortComparator = null;
/*  46 */   private SortDirection _currentSortDirection = SortDirection.NONE;
/*  47 */   private Image _imageAscending = UIResourceManager.getInstance().getImage("_imageSortArrowAscending");
/*  48 */   private Image _imageDescending = UIResourceManager.getInstance().getImage("_imageSortArrowDescending");
/*     */   
/*     */   @Inject
/*     */   private SortActionComparatorFactory _comparatorFactory;
/*     */ 
/*     */   
/*     */   public ListSortAction(SortActionKey argKey) {
/*  55 */     super(null, (IXstActionKey)argKey);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Icon getSmallIcon() {
/*  63 */     switch (this._currentSortDirection)
/*     */     { case ASCENDING:
/*  65 */         sortIcon = new ImageIcon(this._imageAscending);
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
/*  77 */         return sortIcon;case DESCENDING: sortIcon = new ImageIcon(this._imageDescending); return sortIcon; }  Icon sortIcon = null; return sortIcon;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyAccessGranted(ISecurityResponse argResponse) {
/*  83 */     super.notifyAccessGranted(argResponse);
/*     */     
/*  85 */     ListHolder listHolder = getListHolder();
/*     */     
/*  87 */     if (listHolder == null || listHolder.getElements() == null) {
/*  88 */       _logger.warn("No list to sort could be determined; no sorting will be attempted. [sortKey = " + 
/*  89 */           getActionKey() + "].");
/*     */     } else {
/*     */       Comparator<Object> reverseComparator;
/*     */ 
/*     */       
/*  94 */       List<?> listToSort = new ArrayList(listHolder.getElements());
/*     */       
/*  96 */       if (this._sortComparator == null) {
/*  97 */         _logger.warn("No comparator has been specified for sorting; no sorting is going to be performed.");
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 103 */       switch (this._currentSortDirection) {
/*     */ 
/*     */         
/*     */         case DESCENDING:
/*     */         case NONE:
/* 108 */           Collections.sort(listToSort, this._sortComparator);
/* 109 */           listHolder.setCurrentComparator(this._sortComparator);
/* 110 */           this._currentSortDirection = SortDirection.ASCENDING;
/*     */           break;
/*     */ 
/*     */         
/*     */         case ASCENDING:
/* 115 */           reverseComparator = Collections.reverseOrder(this._sortComparator);
/* 116 */           Collections.sort(listToSort, reverseComparator);
/* 117 */           listHolder.setCurrentComparator(reverseComparator);
/* 118 */           this._currentSortDirection = SortDirection.DESCENDING;
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 124 */       listHolder.setElements(listToSort);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setComparator(Comparator<Object> argComparator) {
/* 131 */     this._sortComparator = argComparator;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameters(List<ParameterConfig> argParams) {
/* 137 */     super.setParameters(argParams);
/*     */     
/* 139 */     for (ParameterConfig param : argParams) {
/* 140 */       if ("comparator".equalsIgnoreCase(param.getName())) {
/* 141 */         setComparator(this._comparatorFactory.getComparator(param.getValue().toString()));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortField(String argSortField) {
/* 149 */     this._listField = argSortField;
/*     */   }
/*     */   protected ListHolder getListHolder() {
/*     */     IEditModelField<?> iEditModelField;
/* 153 */     ListHolder listHolder = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 159 */     if (this._listField != null) {
/* 160 */       IStationModel stationModel = ((IModeController)this._modeProvider.get()).getStationModel();
/*     */       
/* 162 */       FormKey formKey = FormKey.valueOf(getActionKey().toString());
/* 163 */       IFormModel formModel = stationModel.getFormModel(formKey);
/* 164 */       IEditModel editModel = formModel.getEditModel();
/*     */       
/* 166 */       IEditModelField<?> field = editModel.getFieldDef(this._listField);
/*     */       
/* 168 */       Object fieldValue = field.getValue();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 173 */       if (fieldValue instanceof ICombinedListModel) {
/* 174 */         ICombinedListModel<?> listModel = (ICombinedListModel)fieldValue;
/* 175 */         IListModel iListModel = listModel.getModel();
/*     */       } else {
/*     */         
/* 178 */         iEditModelField = field;
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     return (ListHolder)iEditModelField;
/*     */   }
/*     */   
/*     */   private enum SortDirection {
/* 186 */     NONE, ASCENDING, DESCENDING;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\ListSortAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */