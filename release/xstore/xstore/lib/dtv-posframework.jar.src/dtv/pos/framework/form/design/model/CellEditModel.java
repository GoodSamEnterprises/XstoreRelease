/*     */ package dtv.pos.framework.form.design.model;
/*     */ 
/*     */ import dtv.i18n.FormatterType;
/*     */ import dtv.pos.common.ViewElementType;
/*     */ import dtv.pos.framework.form.LayoutLocation;
/*     */ import dtv.pos.framework.form.config.FormViewCellConfig;
/*     */ import dtv.pos.framework.ui.config.FontConfig;
/*     */ import dtv.pos.iframework.form.config.EnumPossibleValues;
/*     */ import dtv.pos.iframework.form.design.type.FontSize;
/*     */ import dtv.pos.iframework.form.design.type.FormComponentType;
/*     */ import dtv.pos.iframework.ui.FontStyle;
/*     */ import dtv.pos.iframework.ui.ScrollingPolicy;
/*     */ import dtv.pos.iframework.ui.SelectionMode;
/*     */ import dtv.pos.iframework.ui.TableLayoutHorizontalAlignment;
/*     */ import dtv.pos.iframework.ui.TableLayoutVerticalAlignment;
/*     */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
/*     */ import java.awt.Color;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CellEditModel
/*     */   extends AbstractDetailEditModel
/*     */ {
/*  30 */   private static final Logger logger_ = Logger.getLogger(CellEditModel.class);
/*     */   
/*     */   private static final int TYPE = 0;
/*     */   
/*     */   private static final int RESOURCE = 1;
/*     */   private static final int TEXT_KEY = 2;
/*     */   private static final int READ_ONLY = 3;
/*     */   private static final int REQUIRED = 4;
/*     */   private static final int ROW_POSN = 5;
/*     */   private static final int COL_POSN = 6;
/*     */   private static final int ROW_SPAN = 7;
/*     */   private static final int COL_SPAN = 8;
/*     */   private static final int VALIGN = 9;
/*     */   private static final int HALIGN = 10;
/*     */   private static final int TAB_ORDER = 11;
/*     */   private static final int FOREGROUND_COLOR = 12;
/*     */   private static final int HEIGHT = 13;
/*     */   private static final int WIDTH = 14;
/*     */   private static final int FONT_NAME = 15;
/*     */   private static final int FONT_SIZE = 16;
/*     */   private static final int FONT_STYLE = 17;
/*     */   private static final int ENUM_POSSIBLE_VALUES = 18;
/*     */   private static final int NOTIFY_DELAY = 19;
/*     */   private static final int VISIBILITY_GROUP = 20;
/*     */   private static final int XML_TAG_TYPE = 21;
/*     */   private static final int TEXT_EDIT_FORMAT = 22;
/*     */   private static final int CELL_RENDER_SIMPLE_RENDERER = 23;
/*     */   private static final int CELL_RENDER_HEADER_TYPE = 24;
/*     */   private static final int CELL_RENDER_ELEMENT_TYPE = 25;
/*     */   private static final int CELL_RENDER_SELECTION_MODE = 26;
/*     */   private static final int LABEL_FORMATTER_TYPE = 27;
/*     */   private static final int HORIZONTAL_SCROLLING_MODE = 28;
/*     */   private static final int VERTICAL_SCROLLING_MODE = 29;
/*     */   private static final int BORDER_TEXT_KEY = 30;
/*     */   private static final int MODEL_ROW_COUNT = 31;
/*     */   private final FormViewCellConfig config_;
/*     */   private final LayoutLocation position_;
/*     */   
/*     */   private static boolean allowsNotifyDelay(FormComponentType argType) {
/*  69 */     String type = argType.toString();
/*  70 */     if (FormComponentType.COMBO_BOX.toString().equals(type)) {
/*  71 */       return true;
/*     */     }
/*  73 */     if (FormComponentType.LIST.toString().equals(type)) {
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean usesCellRendering(FormComponentType argType) {
/*  80 */     String type = argType.toString();
/*  81 */     if (FormComponentType.LIST.toString().equals(type)) {
/*  82 */       return true;
/*     */     }
/*  84 */     if (FormComponentType.TABLE.toString().equals(type)) {
/*  85 */       return true;
/*     */     }
/*  87 */     if ("ScrollEventFormList".equals(type)) {
/*  88 */       return true;
/*     */     }
/*     */     
/*  91 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean usesScrolling(FormComponentType argType) {
/*  96 */     String type = argType.toString();
/*  97 */     if (FormComponentType.LIST.toString().equals(type)) {
/*  98 */       return true;
/*     */     }
/* 100 */     if (FormComponentType.TABLE.toString().equals(type)) {
/* 101 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     if ("ScrollEventFormList".equals(type)) {
/* 108 */       return true;
/*     */     }
/*     */     
/* 111 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellEditModel(FormViewCellConfig argPanelConfig) {
/* 120 */     super(31, new String[] { "type", "resource", "textkey", "readonly", "required", "row position", "column position", "row span", "column span", "vertical alignment", "horizontal align", "tab order", "foreground color", "height", "width", "font name", "font size", "font style", "possible values", "notify delay", "visibility group", "custom:xml-tag", "text:entry formats", "cell rendering: use simple renderer", "cell rendering: header type", "cell rendering: element type", "cell rendering: selection mode", "label: formatter type", "scrolling: horizontal", "scrolling: vertical", "panel: border text key" }, new Class[] { FormComponentType.class, String.class, String.class, Boolean.class, Boolean.class, Integer.class, Integer.class, Integer.class, Integer.class, TableLayoutVerticalAlignment.class, TableLayoutHorizontalAlignment.class, Integer.class, Color.class, Integer.class, Integer.class, String.class, FontSize.class, FontStyle.class, EnumPossibleValues.class, Integer.class, String.class, String.class, IDataFieldConfig.class, Boolean.class, String.class, String.class, SelectionMode.class, FormatterType.class, ScrollingPolicy.class, ScrollingPolicy.class, String.class });
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
/* 162 */     this.config_ = argPanelConfig;
/* 163 */     this.position_ = this.config_.getEditableLayoutLocation();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValueAt(int rowIndex, int columnIndex) {
/* 168 */     if (columnIndex == 0) {
/* 169 */       return super.getValueAt(rowIndex, columnIndex);
/*     */     }
/* 171 */     switch (rowIndex) {
/*     */       case 0:
/* 173 */         return FormComponentType.forName(this.config_.getType());
/*     */       case 1:
/* 175 */         return this.config_.getResource();
/*     */       case 2:
/* 177 */         return (this.config_.getTextKey() == null) ? null : this.config_.getTextKey().getUnformattedData();
/*     */       case 3:
/* 179 */         return this.config_.getReadOnly();
/*     */       case 4:
/* 181 */         return this.config_.getRequired();
/*     */       case 5:
/* 183 */         return this.position_.getRow();
/*     */       case 6:
/* 185 */         return this.position_.getColumn();
/*     */       case 7:
/* 187 */         return this.position_.getRowSpan();
/*     */       case 8:
/* 189 */         return this.position_.getColumnSpan();
/*     */       case 10:
/* 191 */         return this.position_.getHorizontalAlignment();
/*     */       case 9:
/* 193 */         return this.position_.getVerticalAlignment();
/*     */       case 11:
/* 195 */         if (FormComponentType.PANEL.equals(getValueAt(0, 1))) {
/* 196 */           return null;
/*     */         }
/*     */         
/* 199 */         return this.config_.getTabOrder();
/*     */       
/*     */       case 12:
/* 202 */         return this.config_.getForegroundColor();
/*     */       case 13:
/* 204 */         return this.config_.getHeightObject();
/*     */       case 14:
/* 206 */         return this.config_.getWidthObject();
/*     */       case 15:
/* 208 */         return ((FontConfig)this.config_.getFontConfig()).getFontName();
/*     */       case 16:
/* 210 */         return ((FontConfig)this.config_.getFontConfig()).getFontSize();
/*     */       case 17:
/* 212 */         return ((FontConfig)this.config_.getFontConfig()).getFontStyle();
/*     */       
/*     */       case 18:
/* 215 */         return this.config_.getEnumPossibleValues();
/*     */       
/*     */       case 19:
/* 218 */         return this.config_.getNotifyDelay();
/*     */       
/*     */       case 20:
/* 221 */         return this.config_.getVisibilityGroup();
/*     */       
/*     */       case 21:
/* 224 */         return this.config_.getXmlTag();
/*     */       
/*     */       case 22:
/* 227 */         return this.config_.getDataConfig();
/*     */       
/*     */       case 23:
/* 230 */         return this.config_.getUseSimpleRenderer();
/*     */       case 24:
/* 232 */         return this.config_.getColumnHeaderRendererType();
/*     */       case 25:
/* 234 */         return this.config_.getCellRendererType();
/*     */       case 26:
/* 236 */         return this.config_.getSelectionMode();
/*     */       
/*     */       case 28:
/* 239 */         return this.config_.getHorizontalScrollingPolicy();
/*     */       case 29:
/* 241 */         return this.config_.getVerticalScrollingPolicy();
/*     */       
/*     */       case 27:
/* 244 */         return this.config_.getFormatterType();
/*     */       
/*     */       case 30:
/* 247 */         return (this.config_.getBorderTextKey() == null) ? null : this.config_.getBorderTextKey().getUnformattedData();
/*     */     } 
/*     */     
/* 250 */     logger_.warn("unexpected row " + rowIndex);
/* 251 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 257 */     if (columnIndex != 1) {
/* 258 */       return false;
/*     */     }
/*     */     
/* 261 */     switch (rowIndex) {
/*     */ 
/*     */       
/*     */       case 22:
/* 265 */         return FormComponentType.TEXT_FIELD.equals(getValueAt(0, 1));
/*     */ 
/*     */       
/*     */       case 23:
/*     */       case 24:
/*     */       case 25:
/*     */       case 26:
/* 272 */         return usesCellRendering((FormComponentType)getValueAt(0, 1));
/*     */       
/*     */       case 28:
/*     */       case 29:
/* 276 */         return usesScrolling((FormComponentType)getValueAt(0, 1));
/*     */ 
/*     */       
/*     */       case 27:
/* 280 */         return FormComponentType.LABEL.equals(getValueAt(0, 1));
/*     */ 
/*     */       
/*     */       case 18:
/* 284 */         return this.config_.allowsPossibleValues();
/*     */ 
/*     */       
/*     */       case 21:
/* 288 */         return true;
/*     */       
/*     */       case 19:
/* 291 */         return allowsNotifyDelay((FormComponentType)getValueAt(0, 1));
/*     */       
/*     */       case 20:
/* 294 */         return true;
/*     */       
/*     */       case 30:
/* 297 */         return FormComponentType.PANEL.equals(getValueAt(0, 1));
/*     */       
/*     */       case 11:
/* 300 */         return !FormComponentType.PANEL.equals(getValueAt(0, 1));
/*     */     } 
/*     */ 
/*     */     
/* 304 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
/* 311 */     if (columnIndex == 1) {
/* 312 */       switch (rowIndex) {
/*     */         case 0:
/* 314 */           this.config_.setType("" + aValue);
/*     */           return;
/*     */         case 1:
/* 317 */           this.config_.setResource("" + aValue);
/*     */           return;
/*     */         case 2:
/* 320 */           this.config_.setTextKey("" + aValue);
/*     */           return;
/*     */         case 3:
/*     */           try {
/* 324 */             this.config_.setReadOnly(Boolean.valueOf("" + aValue));
/*     */           }
/* 326 */           catch (Exception ex) {
/*     */             
/* 328 */             logger_.debug("CAUGHT EXCEPTION", ex);
/*     */           } 
/*     */           return;
/*     */         case 4:
/*     */           try {
/* 333 */             this.config_.setRequired(Boolean.valueOf("" + aValue));
/*     */           }
/* 335 */           catch (Exception ex) {
/*     */             
/* 337 */             logger_.debug("CAUGHT EXCEPTION", ex);
/*     */           } 
/*     */           return;
/*     */         case 5:
/*     */           try {
/* 342 */             this.position_.setRow(Integer.valueOf("" + aValue));
/* 343 */             saveLayoutPosition();
/*     */           }
/* 345 */           catch (NumberFormatException ex) {
/*     */             
/* 347 */             logger_.debug("CAUGHT EXCEPTION", ex);
/*     */           } 
/*     */           return;
/*     */         case 6:
/*     */           try {
/* 352 */             this.position_.setColumn(Integer.valueOf("" + aValue));
/* 353 */             saveLayoutPosition();
/*     */           }
/* 355 */           catch (NumberFormatException ex) {
/*     */             
/* 357 */             logger_.debug("CAUGHT EXCEPTION", ex);
/*     */           } 
/*     */           return;
/*     */         case 7:
/*     */           try {
/* 362 */             this.position_.setRowSpan(Integer.valueOf("" + aValue));
/* 363 */             saveLayoutPosition();
/*     */           }
/* 365 */           catch (NumberFormatException ex) {
/*     */             
/* 367 */             logger_.debug("CAUGHT EXCEPTION", ex);
/*     */           } 
/*     */           return;
/*     */         case 8:
/*     */           try {
/* 372 */             this.position_.setColumnSpan(Integer.valueOf("" + aValue));
/* 373 */             saveLayoutPosition();
/*     */           }
/* 375 */           catch (NumberFormatException ex) {
/*     */             
/* 377 */             logger_.debug("CAUGHT EXCEPTION", ex);
/*     */           } 
/*     */           return;
/*     */         case 10:
/* 381 */           if (aValue instanceof TableLayoutHorizontalAlignment) {
/* 382 */             this.position_.setHorizontalAlignment((TableLayoutHorizontalAlignment)aValue);
/* 383 */             saveLayoutPosition();
/*     */           } else {
/*     */             
/* 386 */             logger_.warn("unexpected HALIGN value " + aValue);
/*     */           } 
/*     */           return;
/*     */         case 9:
/* 390 */           if (aValue instanceof TableLayoutVerticalAlignment) {
/* 391 */             this.position_.setVerticalAlignment((TableLayoutVerticalAlignment)aValue);
/* 392 */             saveLayoutPosition();
/*     */           } else {
/*     */             
/* 395 */             logger_.warn("unexpected VALIGN value " + aValue);
/*     */           } 
/*     */           return;
/*     */         case 11:
/*     */           try {
/* 400 */             this.config_.setTabOrder(Integer.valueOf("" + aValue));
/*     */           }
/* 402 */           catch (NumberFormatException ex) {
/*     */             
/* 404 */             logger_.debug("CAUGHT EXCEPTION", ex);
/*     */           } 
/*     */           return;
/*     */         case 12:
/* 408 */           this.config_.getColorGroupConfig().setFgColor((Color)aValue);
/*     */           return;
/*     */         case 13:
/*     */           try {
/* 412 */             this.config_.setHeight(Integer.valueOf("" + aValue));
/*     */           }
/* 414 */           catch (NumberFormatException ex) {
/* 415 */             this.config_.setHeight(null);
/*     */           } 
/*     */           return;
/*     */         case 14:
/*     */           try {
/* 420 */             this.config_.setWidth(Integer.valueOf("" + aValue));
/*     */           }
/* 422 */           catch (NumberFormatException ex) {
/* 423 */             this.config_.setWidth(null);
/*     */           } 
/*     */           return;
/*     */         case 15:
/* 427 */           ((FontConfig)this.config_.getFontConfig()).setFontName("" + aValue);
/*     */           return;
/*     */         case 16:
/* 430 */           ((FontConfig)this.config_.getFontConfig()).setFontSize((FontSize)aValue);
/*     */           return;
/*     */         case 17:
/* 433 */           ((FontConfig)this.config_.getFontConfig()).setFontStyle((FontStyle)aValue);
/*     */           return;
/*     */         
/*     */         case 18:
/* 437 */           this.config_.setEnumPossibleValues((EnumPossibleValues)aValue);
/*     */           return;
/*     */         
/*     */         case 19:
/*     */           try {
/* 442 */             this.config_.setNotifyDelay(Integer.valueOf("" + aValue));
/*     */           }
/* 444 */           catch (NumberFormatException ex) {
/*     */             
/* 446 */             logger_.debug("CAUGHT EXCEPTION", ex);
/*     */           } 
/*     */           return;
/*     */         
/*     */         case 20:
/* 451 */           this.config_.setVisibilityGroup(String.valueOf(aValue));
/*     */           return;
/*     */         
/*     */         case 21:
/* 455 */           this.config_.setXmlTag((String)aValue);
/*     */           return;
/*     */         
/*     */         case 22:
/* 459 */           this.config_.setDataConfig((IDataFieldConfig)aValue);
/*     */           return;
/*     */         
/*     */         case 23:
/* 463 */           this.config_.setUseSimpleRenderer(Boolean.valueOf("" + aValue));
/*     */           return;
/*     */         case 24:
/* 466 */           this.config_.setHeaderRendererType(ViewElementType.valueOf((String)aValue));
/*     */           return;
/*     */         case 25:
/* 469 */           this.config_.setCellRendererType(ViewElementType.valueOf((String)aValue));
/*     */           return;
/*     */         case 26:
/* 472 */           this.config_.setSelectionMode((SelectionMode)aValue);
/*     */           return;
/*     */         
/*     */         case 28:
/* 476 */           this.config_.setHorizontalScrollingPolicy((ScrollingPolicy)aValue);
/*     */           return;
/*     */         case 29:
/* 479 */           this.config_.setVerticalScrollingPolicy((ScrollingPolicy)aValue);
/*     */           return;
/*     */         
/*     */         case 27:
/* 483 */           this.config_.setFormatterType((FormatterType)aValue);
/*     */           return;
/*     */         
/*     */         case 30:
/* 487 */           this.config_.setBorderTextKey("" + aValue);
/*     */           return;
/*     */       } 
/*     */       
/* 491 */       logger_.warn("unexpected row " + rowIndex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void saveLayoutPosition() {
/* 497 */     this.config_.setLayoutLocation(this.position_.toString());
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\model\CellEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */