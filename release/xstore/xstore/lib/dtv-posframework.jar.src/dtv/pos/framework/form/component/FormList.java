/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import com.micros.xstore.config.form.field.FormParameterTypeEnumeration;
/*     */ import dtv.pos.common.ViewElementType;
/*     */ import dtv.pos.framework.ui.component.XstList;
/*     */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*     */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*     */ import dtv.pos.framework.ui.model.DefaultListInputModel;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.config.EnumPossibleValues;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewCellConfig;
/*     */ import dtv.pos.iframework.ui.RendererDef;
/*     */ import dtv.pos.iframework.ui.SelectionMode;
/*     */ import dtv.pos.iframework.ui.config.IRendererDefConfig;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.model.ICombinedListModel;
/*     */ import dtv.ui.swing.DtvList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.event.ListSelectionEvent;
/*     */ import javax.swing.event.ListSelectionListener;
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
/*     */ public class FormList<T extends IFormModel>
/*     */   extends AbstractListFormComponent<T>
/*     */   implements ListSelectionListener
/*     */ {
/*     */   private static final int MODEL_MODE_UNKNOWN = 0;
/*     */   private static final int MODEL_MODE_SIMPLE = 1;
/*     */   private static final int MODEL_MODE_LIST_MODEL = 2;
/*     */   private static final int MODEL_MODE_SINGLE_SELECTION = 3;
/*  54 */   private static final Logger logger_ = Logger.getLogger(FormList.class);
/*     */   
/*     */   final XstList xstList_;
/*     */   
/*     */   final DefaultListInputModel editListModel_;
/*     */   private final DefaultListInputModel viewListModel_;
/*     */   private List selectedItems_;
/*     */   private int modelMode_;
/*     */   private int selectionMode_;
/*     */   private boolean editMode_;
/*     */   private boolean settingNewModel_;
/*  65 */   private int localSelectionMode = SelectionMode.SINGLE_SELECTION.getValue();
/*     */   
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */ 
/*     */   
/*     */   public FormList() {
/*  72 */     InjectionHammer.forceAtInjectProcessing(this);
/*  73 */     this.xstList_ = createListComponent();
/*  74 */     this.xstList_.getListComponent().addListSelectionListener(this);
/*     */     
/*  76 */     setComponent((JComponent)this.xstList_.getListComponent());
/*     */     
/*  78 */     this.editListModel_ = new DefaultListInputModel();
/*  79 */     this.viewListModel_ = new DefaultListInputModel();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  85 */     return this.xstList_.getDisplayComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  91 */     return this.xstList_.getFocusComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(IFormComponentConfig<?> argCfg) {
/*  97 */     IFormViewCellConfig config = (IFormViewCellConfig)argCfg;
/*  98 */     this.selectionMode_ = config.getSelectionMode().getValue();
/*     */     
/* 100 */     this.editListModel_.getSelectionModel().setSelectionMode(this.selectionMode_);
/* 101 */     this.viewListModel_.getSelectionModel().setSelectionMode(this.selectionMode_);
/*     */     
/* 103 */     IRendererDefConfig cellDef = config.getRendererDef("Cell");
/* 104 */     IRendererDefConfig alternateCellDef = config.getRendererDef("AlternateCell");
/* 105 */     IRendererDefConfig columnHeaderDef = config.getRendererDef("ColumnHeader");
/* 106 */     IRendererDefConfig rowHeaderDef = config.getRendererDef("RowHeader");
/* 107 */     IRendererDefConfig ulCornerDef = config.getRendererDef("UpperLeft");
/*     */     
/* 109 */     if (cellDef != null) {
/* 110 */       this.xstList_.setCellRendererDef(cellDef.toRendererDef());
/*     */     }
/* 112 */     if (alternateCellDef != null) {
/* 113 */       this.xstList_.setAlternateCellRendererDef(alternateCellDef.toRendererDef());
/*     */     }
/* 115 */     if (columnHeaderDef != null) {
/* 116 */       this.xstList_.setColumnHeaderRendererDef(columnHeaderDef.toRendererDef());
/*     */     }
/* 118 */     if (rowHeaderDef != null) {
/* 119 */       this.xstList_.setRowHeaderRendererDef(rowHeaderDef.toRendererDef());
/*     */     }
/* 121 */     if (ulCornerDef != null) {
/* 122 */       this.xstList_.setCornerRendererDef("UPPER_LEFT_CORNER", ulCornerDef.toRendererDef());
/*     */     }
/*     */     
/* 125 */     EnumPossibleValues ev = config.getEnumPossibleValues();
/* 126 */     if (ev != null) {
/* 127 */       DefaultListInputModel model = new DefaultListInputModel();
/* 128 */       model.getModel().setElements(ev.getValuesList());
/* 129 */       this.xstList_.setModel((ICombinedListModel)model);
/*     */     } 
/* 131 */     super.init(argCfg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(ResolvedFieldConfig argFieldDef) {
/* 137 */     String selectionType = argFieldDef.getParameter(FormParameterTypeEnumeration.LIST_SELECTION_MODE.value());
/*     */     
/* 139 */     if (selectionType != null) {
/*     */       try {
/* 141 */         this.localSelectionMode = SelectionMode.forName(selectionType).getValue();
/*     */       }
/* 143 */       catch (NullPointerException ex) {
/* 144 */         logger_.error("Unknown list selection mode [" + argFieldDef
/* 145 */             .getParameter(FormParameterTypeEnumeration.LIST_SELECTION_MODE.value()) + "] defaulting to single selection mode.");
/*     */         
/* 147 */         this.localSelectionMode = SelectionMode.SINGLE_SELECTION.getValue();
/*     */       } 
/*     */     }
/*     */     
/* 151 */     this.selectionMode_ = this.localSelectionMode;
/*     */ 
/*     */     
/* 154 */     if (this.localSelectionMode == SelectionMode.NO_SELECTION.getValue()) {
/* 155 */       this.selectionMode_ = SelectionMode.SINGLE_SELECTION.getValue();
/*     */     }
/*     */     
/* 158 */     this.editListModel_.getSelectionModel().setSelectionMode(this.selectionMode_);
/* 159 */     this.viewListModel_.getSelectionModel().setSelectionMode(this.selectionMode_);
/*     */     
/* 161 */     String cellType = argFieldDef.getParameter(FormParameterTypeEnumeration.CELL_TYPE.value());
/* 162 */     String cellRuleList = argFieldDef.getParameter(FormParameterTypeEnumeration.CELL_RULE_SET.value());
/* 163 */     if (!StringUtils.isEmpty(cellType) || !StringUtils.isEmpty(cellRuleList)) {
/* 164 */       RendererDef renderer = new RendererDef(false, cellRuleList, ViewElementType.valueOf(cellType));
/* 165 */       this.xstList_.setCellRendererDef(renderer);
/*     */     } 
/*     */ 
/*     */     
/* 169 */     String alternativeCellType = argFieldDef.getParameter(FormParameterTypeEnumeration.ALTERNATE_CELL_TYPE.value());
/* 170 */     if (!StringUtils.isEmpty(alternativeCellType)) {
/* 171 */       RendererDef renderer = new RendererDef(false, null, ViewElementType.valueOf(alternativeCellType));
/* 172 */       this.xstList_.setAlternateCellRendererDef(renderer);
/*     */     } 
/*     */ 
/*     */     
/* 176 */     String columnHeaderType = argFieldDef.getParameter(FormParameterTypeEnumeration.COLUMN_HEADER_TYPE.value());
/* 177 */     if (!StringUtils.isEmpty(columnHeaderType)) {
/* 178 */       RendererDef renderer = new RendererDef(false, null, ViewElementType.valueOf(columnHeaderType));
/* 179 */       this.xstList_.setColumnHeaderRendererDef(renderer);
/*     */     } 
/*     */     
/* 182 */     String rowHeaderType = argFieldDef.getParameter(FormParameterTypeEnumeration.ROW_HEADER_TYPE.value());
/* 183 */     if (!StringUtils.isEmpty(rowHeaderType)) {
/* 184 */       RendererDef renderer = new RendererDef(false, null, ViewElementType.valueOf(rowHeaderType));
/* 185 */       this.xstList_.setRowHeaderRendererDef(renderer);
/*     */     } 
/*     */     
/* 188 */     setAlwaysEnabled(true);
/* 189 */     super.init(argFieldDef);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void valueChanged(final ListSelectionEvent evt) {
/* 195 */     if (this.modelMode_ != 2) {
/* 196 */       updateModelValue();
/*     */     }
/*     */     
/* 199 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */           public void run() {
/* 202 */             FormList.this.xstList_.getListComponent().ensureIndexIsVisible(evt.getLastIndex());
/*     */ 
/*     */             
/* 205 */             ((IModeController)FormList.this._modeProvider.get()).getStationModel().getPromptActionModel().evaluateVisibility();
/*     */           }
/*     */         },  true);
/*     */   }
/*     */   
/*     */   protected XstList createListComponent() {
/* 211 */     return XstViewComponentFactory.getInstance().createList(DtvList.TOUCH_READY_LIST_NO_ARROWS_ID);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getComponentValue() {
/* 217 */     if (this.modelMode_ == 3) {
/* 218 */       List selection = this.xstList_.getModel().getSelectedElements();
/* 219 */       return (selection == null || selection.size() == 0) ? null : selection.get(0);
/*     */     } 
/*     */     
/* 222 */     return super.getComponentValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected JComponent getFontComponent() {
/* 229 */     return (JComponent)this.xstList_.getListComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected JComponent getMostVisibleComponent() {
/* 235 */     return (JComponent)this.xstList_.getListComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected List getSelections() {
/* 241 */     if (this.modelMode_ == 1) {
/* 242 */       return this.editMode_ ? this.editListModel_.getSelectedElements() : this.selectedItems_;
/*     */     }
/*     */     
/* 245 */     logger_.warn("shouldn't get here", new Throwable("STACK TRACE"));
/* 246 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initNewModelState(T argOldModel, T argNewModel) {
/* 253 */     this.settingNewModel_ = true;
/* 254 */     IEditModel em = null;
/*     */     
/* 256 */     if (argNewModel != null) {
/* 257 */       em = argNewModel.getEditModel();
/*     */     }
/* 259 */     if (em == null) {
/* 260 */       this.editListModel_.clearModel();
/* 261 */       this.viewListModel_.clearModel();
/*     */     } else {
/*     */       
/* 264 */       Class<?> c = em.getDataType(this.fieldKey_);
/* 265 */       if (List.class.isAssignableFrom(c)) {
/* 266 */         this.modelMode_ = 1;
/* 267 */         this.selectedItems_ = (List)em.getValue(this.fieldKey_);
/* 268 */         if (this.selectedItems_ == null) {
/* 269 */           this.selectedItems_ = Collections.EMPTY_LIST;
/*     */         }
/*     */         
/* 272 */         List availableItems = em.getEnumeratedPossibleValues(this.fieldKey_);
/* 273 */         if (availableItems == null) {
/* 274 */           availableItems = Collections.EMPTY_LIST;
/*     */         }
/*     */         
/* 277 */         availableItems = (List)wrapValue(availableItems);
/* 278 */         this.selectedItems_ = (List)wrapValue(this.selectedItems_);
/*     */ 
/*     */ 
/*     */         
/* 282 */         this.editMode_ = (argNewModel.isEditable() && argNewModel.isEditable(this.fieldKey_));
/*     */         
/* 284 */         this.editListModel_.getModel().setElements(availableItems);
/* 285 */         this.viewListModel_.getModel().setElements(this.selectedItems_);
/*     */         
/* 287 */         if (this.editMode_) {
/* 288 */           this.xstList_.setModel((ICombinedListModel)this.editListModel_);
/*     */         } else {
/*     */           
/* 291 */           this.xstList_.setModel((ICombinedListModel)this.viewListModel_);
/*     */         } 
/*     */         
/* 294 */         setComponentEnabled(true);
/*     */       }
/* 296 */       else if (ICombinedListModel.class.isAssignableFrom(c)) {
/* 297 */         this.modelMode_ = 2;
/*     */       }
/* 299 */       else if (this.selectionMode_ == 0) {
/* 300 */         this.modelMode_ = 3;
/* 301 */         List availableItems = em.getEnumeratedPossibleValues(this.fieldKey_);
/* 302 */         if (availableItems == null) {
/* 303 */           availableItems = Collections.EMPTY_LIST;
/*     */         }
/* 305 */         this.editMode_ = argNewModel.isEditable();
/* 306 */         this.editListModel_.getModel().setElements(availableItems);
/* 307 */         this.xstList_.setModel((ICombinedListModel)this.editListModel_);
/*     */       } else {
/*     */         
/* 310 */         this.modelMode_ = 0;
/* 311 */         logger_.warn("unexpected field type for a FormList [" + c + "]");
/*     */       } 
/* 313 */       ensureLastSelectionIsVisible();
/*     */     } 
/* 315 */     super.initNewModelState(argOldModel, argNewModel);
/* 316 */     this.settingNewModel_ = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponentValue(Object argValue) {
/* 322 */     if ((this.modelMode_ == 1 && argValue == null) || argValue instanceof List) {
/* 323 */       setSelections((List<Object>)argValue);
/*     */     }
/* 325 */     else if ((this.modelMode_ == 2 && argValue == null) || argValue instanceof ICombinedListModel) {
/*     */       
/* 327 */       ICombinedListModel listModel = (ICombinedListModel)argValue;
/* 328 */       listModel.getSelectionModel().setSelectionMode(this.selectionMode_);
/* 329 */       this.xstList_.setModel(listModel);
/*     */     }
/* 331 */     else if (this.modelMode_ == 3) {
/* 332 */       this.xstList_.setSelection(argValue, true);
/*     */     } else {
/*     */       
/* 335 */       logger_.warn("unexpected value " + argValue + " of type " + ((argValue == null) ? null : argValue
/*     */           
/* 337 */           .getClass().getName()) + " in model mode " + this.modelMode_, new Throwable("STACK TRACE"));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setSelections(List<Object> argSelections) {
/* 345 */     if (this.editMode_ && this.settingNewModel_) {
/* 346 */       this.editListModel_.setSelections(argSelections);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateState() {
/* 353 */     super.updateState();
/*     */     
/* 355 */     if (this.localSelectionMode == SelectionMode.NO_SELECTION.getValue()) {
/* 356 */       setComponentEnabled(false);
/*     */     }
/*     */   }
/*     */   
/*     */   private void ensureLastSelectionIsVisible() {
/* 361 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 365 */             int visibleRow = Math.max(0, FormList.this.editListModel_.getSelectionModel().getMaxSelectionIndex());
/* 366 */             FormList.this.xstList_.getListComponent().ensureIndexIsVisible(visibleRow);
/*     */           }
/*     */         }true, true);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */