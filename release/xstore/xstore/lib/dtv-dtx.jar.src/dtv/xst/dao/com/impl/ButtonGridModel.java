/*      */ package dtv.xst.dao.com.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.Eventor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.event.handler.CascadingHandler;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.com.ButtonGridPropertyId;
/*      */ import dtv.xst.dao.com.IButtonGrid;
/*      */ import dtv.xst.dao.com.IButtonGridProperty;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class ButtonGridModel extends AbstractDataModelWithPropertyImpl<IButtonGridProperty> implements IButtonGrid {
/*      */   private static final long serialVersionUID = -1943332424L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   
/*      */   public String toString() {
/*   33 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IDataModel _myExtension; private HistoricalList<IButtonGridProperty> _properties; private transient HistoricalList<IButtonGridProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   38 */     setDAO((IDataAccessObject)new ButtonGridDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ButtonGridDAO getDAO_() {
/*   46 */     return (ButtonGridDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   54 */     if (getDAO_().getOrganizationId() != null) {
/*   55 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   58 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   67 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   68 */       this._events != null && 
/*   69 */       postEventsForChanges()) {
/*   70 */       this._events.post(IButtonGrid.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   77 */     boolean ev_postable = false;
/*      */     
/*   79 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   80 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   81 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   82 */       ev_postable = true;
/*   83 */       if (this._properties != null) {
/*      */         
/*   85 */         Iterator<ButtonGridPropertyModel> it = this._properties.iterator();
/*   86 */         while (it.hasNext())
/*      */         {
/*   88 */           ((ButtonGridPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   93 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLevelCode() {
/*  101 */     return getDAO_().getLevelCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLevelCode(String argLevelCode) {
/*  109 */     if (setLevelCode_noev(argLevelCode) && 
/*  110 */       this._events != null && 
/*  111 */       postEventsForChanges()) {
/*  112 */       this._events.post(IButtonGrid.SET_LEVELCODE, argLevelCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLevelCode_noev(String argLevelCode) {
/*  119 */     boolean ev_postable = false;
/*      */     
/*  121 */     if ((getDAO_().getLevelCode() == null && argLevelCode != null) || (
/*  122 */       getDAO_().getLevelCode() != null && !getDAO_().getLevelCode().equals(argLevelCode))) {
/*  123 */       getDAO_().setLevelCode(argLevelCode);
/*  124 */       ev_postable = true;
/*  125 */       if (this._properties != null) {
/*      */         
/*  127 */         Iterator<ButtonGridPropertyModel> it = this._properties.iterator();
/*  128 */         while (it.hasNext())
/*      */         {
/*  130 */           ((ButtonGridPropertyModel)it.next()).setLevelCode_noev(argLevelCode);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  135 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLevelValue() {
/*  143 */     return getDAO_().getLevelValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLevelValue(String argLevelValue) {
/*  151 */     if (setLevelValue_noev(argLevelValue) && 
/*  152 */       this._events != null && 
/*  153 */       postEventsForChanges()) {
/*  154 */       this._events.post(IButtonGrid.SET_LEVELVALUE, argLevelValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLevelValue_noev(String argLevelValue) {
/*  161 */     boolean ev_postable = false;
/*      */     
/*  163 */     if ((getDAO_().getLevelValue() == null && argLevelValue != null) || (
/*  164 */       getDAO_().getLevelValue() != null && !getDAO_().getLevelValue().equals(argLevelValue))) {
/*  165 */       getDAO_().setLevelValue(argLevelValue);
/*  166 */       ev_postable = true;
/*  167 */       if (this._properties != null) {
/*      */         
/*  169 */         Iterator<ButtonGridPropertyModel> it = this._properties.iterator();
/*  170 */         while (it.hasNext())
/*      */         {
/*  172 */           ((ButtonGridPropertyModel)it.next()).setLevelValue_noev(argLevelValue);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  177 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getGridId() {
/*  185 */     return getDAO_().getGridId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGridId(String argGridId) {
/*  193 */     if (setGridId_noev(argGridId) && 
/*  194 */       this._events != null && 
/*  195 */       postEventsForChanges()) {
/*  196 */       this._events.post(IButtonGrid.SET_GRIDID, argGridId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setGridId_noev(String argGridId) {
/*  203 */     boolean ev_postable = false;
/*      */     
/*  205 */     if ((getDAO_().getGridId() == null && argGridId != null) || (
/*  206 */       getDAO_().getGridId() != null && !getDAO_().getGridId().equals(argGridId))) {
/*  207 */       getDAO_().setGridId(argGridId);
/*  208 */       ev_postable = true;
/*  209 */       if (this._properties != null) {
/*      */         
/*  211 */         Iterator<ButtonGridPropertyModel> it = this._properties.iterator();
/*  212 */         while (it.hasNext())
/*      */         {
/*  214 */           ((ButtonGridPropertyModel)it.next()).setGridId_noev(argGridId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  219 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRowId() {
/*  227 */     if (getDAO_().getRowId() != null) {
/*  228 */       return getDAO_().getRowId().intValue();
/*      */     }
/*      */     
/*  231 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRowId(int argRowId) {
/*  240 */     if (setRowId_noev(argRowId) && 
/*  241 */       this._events != null && 
/*  242 */       postEventsForChanges()) {
/*  243 */       this._events.post(IButtonGrid.SET_ROWID, Integer.valueOf(argRowId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRowId_noev(int argRowId) {
/*  250 */     boolean ev_postable = false;
/*      */     
/*  252 */     if ((getDAO_().getRowId() == null && Integer.valueOf(argRowId) != null) || (
/*  253 */       getDAO_().getRowId() != null && !getDAO_().getRowId().equals(Integer.valueOf(argRowId)))) {
/*  254 */       getDAO_().setRowId(Integer.valueOf(argRowId));
/*  255 */       ev_postable = true;
/*  256 */       if (this._properties != null) {
/*      */         
/*  258 */         Iterator<ButtonGridPropertyModel> it = this._properties.iterator();
/*  259 */         while (it.hasNext())
/*      */         {
/*  261 */           ((ButtonGridPropertyModel)it.next()).setRowId_noev(argRowId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  266 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getColumnId() {
/*  274 */     if (getDAO_().getColumnId() != null) {
/*  275 */       return getDAO_().getColumnId().intValue();
/*      */     }
/*      */     
/*  278 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setColumnId(int argColumnId) {
/*  287 */     if (setColumnId_noev(argColumnId) && 
/*  288 */       this._events != null && 
/*  289 */       postEventsForChanges()) {
/*  290 */       this._events.post(IButtonGrid.SET_COLUMNID, Integer.valueOf(argColumnId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setColumnId_noev(int argColumnId) {
/*  297 */     boolean ev_postable = false;
/*      */     
/*  299 */     if ((getDAO_().getColumnId() == null && Integer.valueOf(argColumnId) != null) || (
/*  300 */       getDAO_().getColumnId() != null && !getDAO_().getColumnId().equals(Integer.valueOf(argColumnId)))) {
/*  301 */       getDAO_().setColumnId(Integer.valueOf(argColumnId));
/*  302 */       ev_postable = true;
/*  303 */       if (this._properties != null) {
/*      */         
/*  305 */         Iterator<ButtonGridPropertyModel> it = this._properties.iterator();
/*  306 */         while (it.hasNext())
/*      */         {
/*  308 */           ((ButtonGridPropertyModel)it.next()).setColumnId_noev(argColumnId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  313 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getComponentId() {
/*  321 */     return getDAO_().getComponentId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setComponentId(String argComponentId) {
/*  329 */     if (setComponentId_noev(argComponentId) && 
/*  330 */       this._events != null && 
/*  331 */       postEventsForChanges()) {
/*  332 */       this._events.post(IButtonGrid.SET_COMPONENTID, argComponentId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setComponentId_noev(String argComponentId) {
/*  339 */     boolean ev_postable = false;
/*      */     
/*  341 */     if ((getDAO_().getComponentId() == null && argComponentId != null) || (
/*  342 */       getDAO_().getComponentId() != null && !getDAO_().getComponentId().equals(argComponentId))) {
/*  343 */       getDAO_().setComponentId(argComponentId);
/*  344 */       ev_postable = true;
/*  345 */       if (this._properties != null) {
/*      */         
/*  347 */         Iterator<ButtonGridPropertyModel> it = this._properties.iterator();
/*  348 */         while (it.hasNext())
/*      */         {
/*  350 */           ((ButtonGridPropertyModel)it.next()).setComponentId_noev(argComponentId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  355 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSortOrder() {
/*  363 */     if (getDAO_().getSortOrder() != null) {
/*  364 */       return getDAO_().getSortOrder().intValue();
/*      */     }
/*      */     
/*  367 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSortOrder(int argSortOrder) {
/*  376 */     if (setSortOrder_noev(argSortOrder) && 
/*  377 */       this._events != null && 
/*  378 */       postEventsForChanges()) {
/*  379 */       this._events.post(IButtonGrid.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSortOrder_noev(int argSortOrder) {
/*  386 */     boolean ev_postable = false;
/*      */     
/*  388 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/*  389 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/*  390 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/*  391 */       ev_postable = true;
/*  392 */       if (this._properties != null) {
/*      */         
/*  394 */         Iterator<ButtonGridPropertyModel> it = this._properties.iterator();
/*  395 */         while (it.hasNext())
/*      */         {
/*  397 */           ((ButtonGridPropertyModel)it.next()).setSortOrder_noev(argSortOrder);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  402 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getChildId() {
/*  410 */     return getDAO_().getChildId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setChildId(String argChildId) {
/*  418 */     if (setChildId_noev(argChildId) && 
/*  419 */       this._events != null && 
/*  420 */       postEventsForChanges()) {
/*  421 */       this._events.post(IButtonGrid.SET_CHILDID, argChildId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setChildId_noev(String argChildId) {
/*  428 */     boolean ev_postable = false;
/*      */     
/*  430 */     if ((getDAO_().getChildId() == null && argChildId != null) || (
/*  431 */       getDAO_().getChildId() != null && !getDAO_().getChildId().equals(argChildId))) {
/*  432 */       getDAO_().setChildId(argChildId);
/*  433 */       ev_postable = true;
/*      */     } 
/*      */     
/*  436 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getKeyName() {
/*  444 */     return getDAO_().getKeyName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setKeyName(String argKeyName) {
/*  452 */     if (setKeyName_noev(argKeyName) && 
/*  453 */       this._events != null && 
/*  454 */       postEventsForChanges()) {
/*  455 */       this._events.post(IButtonGrid.SET_KEYNAME, argKeyName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setKeyName_noev(String argKeyName) {
/*  462 */     boolean ev_postable = false;
/*      */     
/*  464 */     if ((getDAO_().getKeyName() == null && argKeyName != null) || (
/*  465 */       getDAO_().getKeyName() != null && !getDAO_().getKeyName().equals(argKeyName))) {
/*  466 */       getDAO_().setKeyName(argKeyName);
/*  467 */       ev_postable = true;
/*      */     } 
/*      */     
/*  470 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getData() {
/*  478 */     return getDAO_().getData();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setData(String argData) {
/*  486 */     if (setData_noev(argData) && 
/*  487 */       this._events != null && 
/*  488 */       postEventsForChanges()) {
/*  489 */       this._events.post(IButtonGrid.SET_DATA, argData);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setData_noev(String argData) {
/*  496 */     boolean ev_postable = false;
/*      */     
/*  498 */     if ((getDAO_().getData() == null && argData != null) || (
/*  499 */       getDAO_().getData() != null && !getDAO_().getData().equals(argData))) {
/*  500 */       getDAO_().setData(argData);
/*  501 */       ev_postable = true;
/*      */     } 
/*      */     
/*  504 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getText() {
/*  512 */     return getDAO_().getText();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setText(String argText) {
/*  520 */     if (setText_noev(argText) && 
/*  521 */       this._events != null && 
/*  522 */       postEventsForChanges()) {
/*  523 */       this._events.post(IButtonGrid.SET_TEXT, argText);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setText_noev(String argText) {
/*  530 */     boolean ev_postable = false;
/*      */     
/*  532 */     if ((getDAO_().getText() == null && argText != null) || (
/*  533 */       getDAO_().getText() != null && !getDAO_().getText().equals(argText))) {
/*  534 */       getDAO_().setText(argText);
/*  535 */       ev_postable = true;
/*      */     } 
/*      */     
/*  538 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTextX() {
/*  546 */     if (getDAO_().getTextX() != null) {
/*  547 */       return getDAO_().getTextX().intValue();
/*      */     }
/*      */     
/*  550 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTextX(int argTextX) {
/*  559 */     if (setTextX_noev(argTextX) && 
/*  560 */       this._events != null && 
/*  561 */       postEventsForChanges()) {
/*  562 */       this._events.post(IButtonGrid.SET_TEXTX, Integer.valueOf(argTextX));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTextX_noev(int argTextX) {
/*  569 */     boolean ev_postable = false;
/*      */     
/*  571 */     if ((getDAO_().getTextX() == null && Integer.valueOf(argTextX) != null) || (
/*  572 */       getDAO_().getTextX() != null && !getDAO_().getTextX().equals(Integer.valueOf(argTextX)))) {
/*  573 */       getDAO_().setTextX(Integer.valueOf(argTextX));
/*  574 */       ev_postable = true;
/*      */     } 
/*      */     
/*  577 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTextY() {
/*  585 */     if (getDAO_().getTextY() != null) {
/*  586 */       return getDAO_().getTextY().intValue();
/*      */     }
/*      */     
/*  589 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTextY(int argTextY) {
/*  598 */     if (setTextY_noev(argTextY) && 
/*  599 */       this._events != null && 
/*  600 */       postEventsForChanges()) {
/*  601 */       this._events.post(IButtonGrid.SET_TEXTY, Integer.valueOf(argTextY));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTextY_noev(int argTextY) {
/*  608 */     boolean ev_postable = false;
/*      */     
/*  610 */     if ((getDAO_().getTextY() == null && Integer.valueOf(argTextY) != null) || (
/*  611 */       getDAO_().getTextY() != null && !getDAO_().getTextY().equals(Integer.valueOf(argTextY)))) {
/*  612 */       getDAO_().setTextY(Integer.valueOf(argTextY));
/*  613 */       ev_postable = true;
/*      */     } 
/*      */     
/*  616 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getImageFilename() {
/*  624 */     return getDAO_().getImageFilename();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setImageFilename(String argImageFilename) {
/*  632 */     if (setImageFilename_noev(argImageFilename) && 
/*  633 */       this._events != null && 
/*  634 */       postEventsForChanges()) {
/*  635 */       this._events.post(IButtonGrid.SET_IMAGEFILENAME, argImageFilename);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setImageFilename_noev(String argImageFilename) {
/*  642 */     boolean ev_postable = false;
/*      */     
/*  644 */     if ((getDAO_().getImageFilename() == null && argImageFilename != null) || (
/*  645 */       getDAO_().getImageFilename() != null && !getDAO_().getImageFilename().equals(argImageFilename))) {
/*  646 */       getDAO_().setImageFilename(argImageFilename);
/*  647 */       ev_postable = true;
/*      */     } 
/*      */     
/*  650 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getImageX() {
/*  658 */     if (getDAO_().getImageX() != null) {
/*  659 */       return getDAO_().getImageX().intValue();
/*      */     }
/*      */     
/*  662 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setImageX(int argImageX) {
/*  671 */     if (setImageX_noev(argImageX) && 
/*  672 */       this._events != null && 
/*  673 */       postEventsForChanges()) {
/*  674 */       this._events.post(IButtonGrid.SET_IMAGEX, Integer.valueOf(argImageX));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setImageX_noev(int argImageX) {
/*  681 */     boolean ev_postable = false;
/*      */     
/*  683 */     if ((getDAO_().getImageX() == null && Integer.valueOf(argImageX) != null) || (
/*  684 */       getDAO_().getImageX() != null && !getDAO_().getImageX().equals(Integer.valueOf(argImageX)))) {
/*  685 */       getDAO_().setImageX(Integer.valueOf(argImageX));
/*  686 */       ev_postable = true;
/*      */     } 
/*      */     
/*  689 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getImageY() {
/*  697 */     if (getDAO_().getImageY() != null) {
/*  698 */       return getDAO_().getImageY().intValue();
/*      */     }
/*      */     
/*  701 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setImageY(int argImageY) {
/*  710 */     if (setImageY_noev(argImageY) && 
/*  711 */       this._events != null && 
/*  712 */       postEventsForChanges()) {
/*  713 */       this._events.post(IButtonGrid.SET_IMAGEY, Integer.valueOf(argImageY));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setImageY_noev(int argImageY) {
/*  720 */     boolean ev_postable = false;
/*      */     
/*  722 */     if ((getDAO_().getImageY() == null && Integer.valueOf(argImageY) != null) || (
/*  723 */       getDAO_().getImageY() != null && !getDAO_().getImageY().equals(Integer.valueOf(argImageY)))) {
/*  724 */       getDAO_().setImageY(Integer.valueOf(argImageY));
/*  725 */       ev_postable = true;
/*      */     } 
/*      */     
/*  728 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getVisibilityRule() {
/*  736 */     return getDAO_().getVisibilityRule();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVisibilityRule(String argVisibilityRule) {
/*  744 */     if (setVisibilityRule_noev(argVisibilityRule) && 
/*  745 */       this._events != null && 
/*  746 */       postEventsForChanges()) {
/*  747 */       this._events.post(IButtonGrid.SET_VISIBILITYRULE, argVisibilityRule);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVisibilityRule_noev(String argVisibilityRule) {
/*  754 */     boolean ev_postable = false;
/*      */     
/*  756 */     if ((getDAO_().getVisibilityRule() == null && argVisibilityRule != null) || (
/*  757 */       getDAO_().getVisibilityRule() != null && !getDAO_().getVisibilityRule().equals(argVisibilityRule))) {
/*  758 */       getDAO_().setVisibilityRule(argVisibilityRule);
/*  759 */       ev_postable = true;
/*      */     } 
/*      */     
/*  762 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getHeightSpan() {
/*  770 */     if (getDAO_().getHeightSpan() != null) {
/*  771 */       return getDAO_().getHeightSpan().intValue();
/*      */     }
/*      */     
/*  774 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHeightSpan(int argHeightSpan) {
/*  783 */     if (setHeightSpan_noev(argHeightSpan) && 
/*  784 */       this._events != null && 
/*  785 */       postEventsForChanges()) {
/*  786 */       this._events.post(IButtonGrid.SET_HEIGHTSPAN, Integer.valueOf(argHeightSpan));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setHeightSpan_noev(int argHeightSpan) {
/*  793 */     boolean ev_postable = false;
/*      */     
/*  795 */     if ((getDAO_().getHeightSpan() == null && Integer.valueOf(argHeightSpan) != null) || (
/*  796 */       getDAO_().getHeightSpan() != null && !getDAO_().getHeightSpan().equals(Integer.valueOf(argHeightSpan)))) {
/*  797 */       getDAO_().setHeightSpan(Integer.valueOf(argHeightSpan));
/*  798 */       ev_postable = true;
/*      */     } 
/*      */     
/*  801 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getWidthSpan() {
/*  809 */     if (getDAO_().getWidthSpan() != null) {
/*  810 */       return getDAO_().getWidthSpan().intValue();
/*      */     }
/*      */     
/*  813 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWidthSpan(int argWidthSpan) {
/*  822 */     if (setWidthSpan_noev(argWidthSpan) && 
/*  823 */       this._events != null && 
/*  824 */       postEventsForChanges()) {
/*  825 */       this._events.post(IButtonGrid.SET_WIDTHSPAN, Integer.valueOf(argWidthSpan));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWidthSpan_noev(int argWidthSpan) {
/*  832 */     boolean ev_postable = false;
/*      */     
/*  834 */     if ((getDAO_().getWidthSpan() == null && Integer.valueOf(argWidthSpan) != null) || (
/*  835 */       getDAO_().getWidthSpan() != null && !getDAO_().getWidthSpan().equals(Integer.valueOf(argWidthSpan)))) {
/*  836 */       getDAO_().setWidthSpan(Integer.valueOf(argWidthSpan));
/*  837 */       ev_postable = true;
/*      */     } 
/*      */     
/*  840 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getBackgroundRgb() {
/*  848 */     return getDAO_().getBackgroundRgb();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBackgroundRgb(String argBackgroundRgb) {
/*  856 */     if (setBackgroundRgb_noev(argBackgroundRgb) && 
/*  857 */       this._events != null && 
/*  858 */       postEventsForChanges()) {
/*  859 */       this._events.post(IButtonGrid.SET_BACKGROUNDRGB, argBackgroundRgb);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBackgroundRgb_noev(String argBackgroundRgb) {
/*  866 */     boolean ev_postable = false;
/*      */     
/*  868 */     if ((getDAO_().getBackgroundRgb() == null && argBackgroundRgb != null) || (
/*  869 */       getDAO_().getBackgroundRgb() != null && !getDAO_().getBackgroundRgb().equals(argBackgroundRgb))) {
/*  870 */       getDAO_().setBackgroundRgb(argBackgroundRgb);
/*  871 */       ev_postable = true;
/*      */     } 
/*      */     
/*  874 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getForegroundRgb() {
/*  882 */     return getDAO_().getForegroundRgb();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setForegroundRgb(String argForegroundRgb) {
/*  890 */     if (setForegroundRgb_noev(argForegroundRgb) && 
/*  891 */       this._events != null && 
/*  892 */       postEventsForChanges()) {
/*  893 */       this._events.post(IButtonGrid.SET_FOREGROUNDRGB, argForegroundRgb);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setForegroundRgb_noev(String argForegroundRgb) {
/*  900 */     boolean ev_postable = false;
/*      */     
/*  902 */     if ((getDAO_().getForegroundRgb() == null && argForegroundRgb != null) || (
/*  903 */       getDAO_().getForegroundRgb() != null && !getDAO_().getForegroundRgb().equals(argForegroundRgb))) {
/*  904 */       getDAO_().setForegroundRgb(argForegroundRgb);
/*  905 */       ev_postable = true;
/*      */     } 
/*      */     
/*  908 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getButtonStyle() {
/*  916 */     return getDAO_().getButtonStyle();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setButtonStyle(String argButtonStyle) {
/*  924 */     if (setButtonStyle_noev(argButtonStyle) && 
/*  925 */       this._events != null && 
/*  926 */       postEventsForChanges()) {
/*  927 */       this._events.post(IButtonGrid.SET_BUTTONSTYLE, argButtonStyle);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setButtonStyle_noev(String argButtonStyle) {
/*  934 */     boolean ev_postable = false;
/*      */     
/*  936 */     if ((getDAO_().getButtonStyle() == null && argButtonStyle != null) || (
/*  937 */       getDAO_().getButtonStyle() != null && !getDAO_().getButtonStyle().equals(argButtonStyle))) {
/*  938 */       getDAO_().setButtonStyle(argButtonStyle);
/*  939 */       ev_postable = true;
/*      */     } 
/*      */     
/*  942 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getActionIdx() {
/*  950 */     if (getDAO_().getActionIdx() != null) {
/*  951 */       return getDAO_().getActionIdx().intValue();
/*      */     }
/*      */     
/*  954 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActionIdx(int argActionIdx) {
/*  963 */     if (setActionIdx_noev(argActionIdx) && 
/*  964 */       this._events != null && 
/*  965 */       postEventsForChanges()) {
/*  966 */       this._events.post(IButtonGrid.SET_ACTIONIDX, Integer.valueOf(argActionIdx));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setActionIdx_noev(int argActionIdx) {
/*  973 */     boolean ev_postable = false;
/*      */     
/*  975 */     if ((getDAO_().getActionIdx() == null && Integer.valueOf(argActionIdx) != null) || (
/*  976 */       getDAO_().getActionIdx() != null && !getDAO_().getActionIdx().equals(Integer.valueOf(argActionIdx)))) {
/*  977 */       getDAO_().setActionIdx(Integer.valueOf(argActionIdx));
/*  978 */       ev_postable = true;
/*      */     } 
/*      */     
/*  981 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAnimationIdx() {
/*  989 */     if (getDAO_().getAnimationIdx() != null) {
/*  990 */       return getDAO_().getAnimationIdx().intValue();
/*      */     }
/*      */     
/*  993 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAnimationIdx(int argAnimationIdx) {
/* 1002 */     if (setAnimationIdx_noev(argAnimationIdx) && 
/* 1003 */       this._events != null && 
/* 1004 */       postEventsForChanges()) {
/* 1005 */       this._events.post(IButtonGrid.SET_ANIMATIONIDX, Integer.valueOf(argAnimationIdx));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAnimationIdx_noev(int argAnimationIdx) {
/* 1012 */     boolean ev_postable = false;
/*      */     
/* 1014 */     if ((getDAO_().getAnimationIdx() == null && Integer.valueOf(argAnimationIdx) != null) || (
/* 1015 */       getDAO_().getAnimationIdx() != null && !getDAO_().getAnimationIdx().equals(Integer.valueOf(argAnimationIdx)))) {
/* 1016 */       getDAO_().setAnimationIdx(Integer.valueOf(argAnimationIdx));
/* 1017 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1020 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/* 1028 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/* 1036 */     if (setCreateDate_noev(argCreateDate) && 
/* 1037 */       this._events != null && 
/* 1038 */       postEventsForChanges()) {
/* 1039 */       this._events.post(IButtonGrid.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 1046 */     boolean ev_postable = false;
/*      */     
/* 1048 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 1049 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 1050 */       getDAO_().setCreateDate(argCreateDate);
/* 1051 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1054 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/* 1062 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/* 1070 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 1071 */       this._events != null && 
/* 1072 */       postEventsForChanges()) {
/* 1073 */       this._events.post(IButtonGrid.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 1080 */     boolean ev_postable = false;
/*      */     
/* 1082 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 1083 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 1084 */       getDAO_().setCreateUserId(argCreateUserId);
/* 1085 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1088 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/* 1096 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/* 1104 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 1105 */       this._events != null && 
/* 1106 */       postEventsForChanges()) {
/* 1107 */       this._events.post(IButtonGrid.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 1114 */     boolean ev_postable = false;
/*      */     
/* 1116 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 1117 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 1118 */       getDAO_().setUpdateDate(argUpdateDate);
/* 1119 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1122 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/* 1130 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/* 1138 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 1139 */       this._events != null && 
/* 1140 */       postEventsForChanges()) {
/* 1141 */       this._events.post(IButtonGrid.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 1148 */     boolean ev_postable = false;
/*      */     
/* 1150 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 1151 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 1152 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 1153 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1156 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getRecordState() {
/* 1164 */     return getDAO_().getRecordState();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRecordState(String argRecordState) {
/* 1172 */     if (setRecordState_noev(argRecordState) && 
/* 1173 */       this._events != null && 
/* 1174 */       postEventsForChanges()) {
/* 1175 */       this._events.post(IButtonGrid.SET_RECORDSTATE, argRecordState);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRecordState_noev(String argRecordState) {
/* 1182 */     boolean ev_postable = false;
/*      */     
/* 1184 */     if ((getDAO_().getRecordState() == null && argRecordState != null) || (
/* 1185 */       getDAO_().getRecordState() != null && !getDAO_().getRecordState().equals(argRecordState))) {
/* 1186 */       getDAO_().setRecordState(argRecordState);
/* 1187 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1190 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IButtonGridProperty newProperty(String argPropertyName) {
/* 1194 */     ButtonGridPropertyId id = new ButtonGridPropertyId();
/*      */     
/* 1196 */     id.setLevelCode(getLevelCode());
/* 1197 */     id.setLevelValue(getLevelValue());
/* 1198 */     id.setGridId(getGridId());
/* 1199 */     id.setRowId(Integer.valueOf(getRowId()));
/* 1200 */     id.setColumnId(Integer.valueOf(getColumnId()));
/* 1201 */     id.setComponentId(getComponentId());
/* 1202 */     id.setSortOrder(Integer.valueOf(getSortOrder()));
/* 1203 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1205 */     IButtonGridProperty prop = (IButtonGridProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IButtonGridProperty.class);
/* 1206 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IButtonGridProperty> getProperties() {
/* 1215 */     if (this._properties == null) {
/* 1216 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1218 */     return (List<IButtonGridProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IButtonGridProperty> argProperties) {
/* 1222 */     if (this._properties == null) {
/* 1223 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1225 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1228 */     for (IButtonGridProperty child : this._properties) {
/* 1229 */       ButtonGridPropertyModel model = (ButtonGridPropertyModel)child;
/* 1230 */       model.setOrganizationId_noev(getOrganizationId());
/* 1231 */       model.setLevelCode_noev(getLevelCode());
/* 1232 */       model.setLevelValue_noev(getLevelValue());
/* 1233 */       model.setGridId_noev(getGridId());
/* 1234 */       model.setRowId_noev(getRowId());
/* 1235 */       model.setColumnId_noev(getColumnId());
/* 1236 */       model.setComponentId_noev(getComponentId());
/* 1237 */       model.setSortOrder_noev(getSortOrder());
/* 1238 */       if (child instanceof IDataModelImpl) {
/* 1239 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1240 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1241 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1242 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1245 */       if (postEventsForChanges()) {
/* 1246 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addButtonGridProperty(IButtonGridProperty argButtonGridProperty) {
/* 1252 */     if (this._properties == null) {
/* 1253 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1255 */     argButtonGridProperty.setOrganizationId(getOrganizationId());
/* 1256 */     argButtonGridProperty.setLevelCode(getLevelCode());
/* 1257 */     argButtonGridProperty.setLevelValue(getLevelValue());
/* 1258 */     argButtonGridProperty.setGridId(getGridId());
/* 1259 */     argButtonGridProperty.setRowId(getRowId());
/* 1260 */     argButtonGridProperty.setColumnId(getColumnId());
/* 1261 */     argButtonGridProperty.setComponentId(getComponentId());
/* 1262 */     argButtonGridProperty.setSortOrder(getSortOrder());
/* 1263 */     if (argButtonGridProperty instanceof IDataModelImpl) {
/* 1264 */       IDataAccessObject childDao = ((IDataModelImpl)argButtonGridProperty).getDAO();
/* 1265 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1266 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1267 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1272 */     if (postEventsForChanges()) {
/* 1273 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argButtonGridProperty));
/*      */     }
/*      */     
/* 1276 */     this._properties.add(argButtonGridProperty);
/* 1277 */     if (postEventsForChanges()) {
/* 1278 */       this._events.post(IButtonGrid.ADD_PROPERTIES, argButtonGridProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeButtonGridProperty(IButtonGridProperty argButtonGridProperty) {
/* 1283 */     if (this._properties != null) {
/*      */       
/* 1285 */       if (postEventsForChanges()) {
/* 1286 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argButtonGridProperty));
/*      */       }
/* 1288 */       this._properties.remove(argButtonGridProperty);
/* 1289 */       if (postEventsForChanges()) {
/* 1290 */         this._events.post(IButtonGrid.REMOVE_PROPERTIES, argButtonGridProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1297 */     if ("Properties".equals(argFieldId)) {
/* 1298 */       return getProperties();
/*      */     }
/* 1300 */     if ("ButtonGridExtension".equals(argFieldId)) {
/* 1301 */       return this._myExtension;
/*      */     }
/*      */     
/* 1304 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1310 */     if ("Properties".equals(argFieldId)) {
/* 1311 */       setProperties(changeToList(argValue, IButtonGridProperty.class));
/*      */     }
/* 1313 */     else if ("ButtonGridExtension".equals(argFieldId)) {
/* 1314 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1317 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1323 */     this._persistenceDefaults = argPD;
/* 1324 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1325 */     this._eventManager = argEM;
/* 1326 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1327 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1328 */     if (this._properties != null) {
/* 1329 */       for (IButtonGridProperty relationship : this._properties) {
/* 1330 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getButtonGridExt() {
/* 1336 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setButtonGridExt(IDataModel argExt) {
/* 1340 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1345 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1349 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1352 */     super.startTransaction();
/*      */     
/* 1354 */     this._propertiesSavepoint = this._properties;
/* 1355 */     if (this._properties != null) {
/* 1356 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1357 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1358 */       while (it.hasNext()) {
/* 1359 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1364 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1369 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1372 */     super.rollbackChanges();
/*      */     
/* 1374 */     this._properties = this._propertiesSavepoint;
/* 1375 */     this._propertiesSavepoint = null;
/* 1376 */     if (this._properties != null) {
/* 1377 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1378 */       while (it.hasNext()) {
/* 1379 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1387 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1390 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1393 */     super.commitTransaction();
/*      */     
/* 1395 */     this._propertiesSavepoint = this._properties;
/* 1396 */     if (this._properties != null) {
/* 1397 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1398 */       while (it.hasNext()) {
/* 1399 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1401 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1405 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1410 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ButtonGridModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */