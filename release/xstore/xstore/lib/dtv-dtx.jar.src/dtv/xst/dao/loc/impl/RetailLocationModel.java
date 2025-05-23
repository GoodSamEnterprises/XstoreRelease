/*      */ package dtv.xst.dao.loc.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.DataFactory;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventHandler;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.Eventor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.event.handler.CascadingHandler;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.loc.IRetailLocation;
/*      */ import dtv.xst.dao.loc.IRetailLocationProperty;
/*      */ import dtv.xst.dao.loc.RetailLocationPropertyId;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class RetailLocationModel extends RetailLocationBaseModel implements IRetailLocation {
/*      */   private static final long serialVersionUID = -1911878152L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   
/*      */   public String toString() {
/*   34 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IDataModel _myExtension; private HistoricalList<IRetailLocationProperty> _properties; private transient HistoricalList<IRetailLocationProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   39 */     setDAO((IDataAccessObject)new RetailLocationDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private RetailLocationDAO getDAO_() {
/*   47 */     return (RetailLocationDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   55 */     if (getDAO_().getOrganizationId() != null) {
/*   56 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   59 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   68 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   69 */       this._events != null && 
/*   70 */       postEventsForChanges()) {
/*   71 */       this._events.post(IRetailLocation.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   78 */     boolean ev_postable = false;
/*      */     
/*   80 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   81 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   82 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   83 */       ev_postable = true;
/*   84 */       if (this._properties != null) {
/*      */         
/*   86 */         Iterator<RetailLocationPropertyModel> it = this._properties.iterator();
/*   87 */         while (it.hasNext())
/*      */         {
/*   89 */           ((RetailLocationPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   94 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  102 */     if (getDAO_().getRetailLocationId() != null) {
/*  103 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  106 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  115 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  116 */       this._events != null && 
/*  117 */       postEventsForChanges()) {
/*  118 */       this._events.post(IRetailLocation.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  125 */     boolean ev_postable = false;
/*      */     
/*  127 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  128 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  129 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  130 */       ev_postable = true;
/*  131 */       if (this._properties != null) {
/*      */         
/*  133 */         Iterator<RetailLocationPropertyModel> it = this._properties.iterator();
/*  134 */         while (it.hasNext())
/*      */         {
/*  136 */           ((RetailLocationPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  141 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  149 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  157 */     if (setCreateDate_noev(argCreateDate) && 
/*  158 */       this._events != null && 
/*  159 */       postEventsForChanges()) {
/*  160 */       this._events.post(IRetailLocation.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  167 */     boolean ev_postable = false;
/*      */     
/*  169 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  170 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  171 */       getDAO_().setCreateDate(argCreateDate);
/*  172 */       ev_postable = true;
/*      */     } 
/*      */     
/*  175 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  183 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  191 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  192 */       this._events != null && 
/*  193 */       postEventsForChanges()) {
/*  194 */       this._events.post(IRetailLocation.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  201 */     boolean ev_postable = false;
/*      */     
/*  203 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  204 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  205 */       getDAO_().setCreateUserId(argCreateUserId);
/*  206 */       ev_postable = true;
/*      */     } 
/*      */     
/*  209 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  217 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  225 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  226 */       this._events != null && 
/*  227 */       postEventsForChanges()) {
/*  228 */       this._events.post(IRetailLocation.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  235 */     boolean ev_postable = false;
/*      */     
/*  237 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  238 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  239 */       getDAO_().setUpdateDate(argUpdateDate);
/*  240 */       ev_postable = true;
/*      */     } 
/*      */     
/*  243 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  251 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  259 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  260 */       this._events != null && 
/*  261 */       postEventsForChanges()) {
/*  262 */       this._events.post(IRetailLocation.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  269 */     boolean ev_postable = false;
/*      */     
/*  271 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  272 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  273 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  274 */       ev_postable = true;
/*      */     } 
/*      */     
/*  277 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAddress1() {
/*  285 */     return getDAO_().getAddress1();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddress1(String argAddress1) {
/*  293 */     if (setAddress1_noev(argAddress1) && 
/*  294 */       this._events != null && 
/*  295 */       postEventsForChanges()) {
/*  296 */       this._events.post(IRetailLocation.SET_ADDRESS1, argAddress1);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddress1_noev(String argAddress1) {
/*  303 */     boolean ev_postable = false;
/*      */     
/*  305 */     if ((getDAO_().getAddress1() == null && argAddress1 != null) || (
/*  306 */       getDAO_().getAddress1() != null && !getDAO_().getAddress1().equals(argAddress1))) {
/*  307 */       getDAO_().setAddress1(argAddress1);
/*  308 */       ev_postable = true;
/*      */     } 
/*      */     
/*  311 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAddress2() {
/*  319 */     return getDAO_().getAddress2();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddress2(String argAddress2) {
/*  327 */     if (setAddress2_noev(argAddress2) && 
/*  328 */       this._events != null && 
/*  329 */       postEventsForChanges()) {
/*  330 */       this._events.post(IRetailLocation.SET_ADDRESS2, argAddress2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddress2_noev(String argAddress2) {
/*  337 */     boolean ev_postable = false;
/*      */     
/*  339 */     if ((getDAO_().getAddress2() == null && argAddress2 != null) || (
/*  340 */       getDAO_().getAddress2() != null && !getDAO_().getAddress2().equals(argAddress2))) {
/*  341 */       getDAO_().setAddress2(argAddress2);
/*  342 */       ev_postable = true;
/*      */     } 
/*      */     
/*  345 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAddress3() {
/*  353 */     return getDAO_().getAddress3();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddress3(String argAddress3) {
/*  361 */     if (setAddress3_noev(argAddress3) && 
/*  362 */       this._events != null && 
/*  363 */       postEventsForChanges()) {
/*  364 */       this._events.post(IRetailLocation.SET_ADDRESS3, argAddress3);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddress3_noev(String argAddress3) {
/*  371 */     boolean ev_postable = false;
/*      */     
/*  373 */     if ((getDAO_().getAddress3() == null && argAddress3 != null) || (
/*  374 */       getDAO_().getAddress3() != null && !getDAO_().getAddress3().equals(argAddress3))) {
/*  375 */       getDAO_().setAddress3(argAddress3);
/*  376 */       ev_postable = true;
/*      */     } 
/*      */     
/*  379 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAddress4() {
/*  387 */     return getDAO_().getAddress4();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddress4(String argAddress4) {
/*  395 */     if (setAddress4_noev(argAddress4) && 
/*  396 */       this._events != null && 
/*  397 */       postEventsForChanges()) {
/*  398 */       this._events.post(IRetailLocation.SET_ADDRESS4, argAddress4);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddress4_noev(String argAddress4) {
/*  405 */     boolean ev_postable = false;
/*      */     
/*  407 */     if ((getDAO_().getAddress4() == null && argAddress4 != null) || (
/*  408 */       getDAO_().getAddress4() != null && !getDAO_().getAddress4().equals(argAddress4))) {
/*  409 */       getDAO_().setAddress4(argAddress4);
/*  410 */       ev_postable = true;
/*      */     } 
/*      */     
/*  413 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getApartment() {
/*  421 */     return getDAO_().getApartment();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setApartment(String argApartment) {
/*  429 */     if (setApartment_noev(argApartment) && 
/*  430 */       this._events != null && 
/*  431 */       postEventsForChanges()) {
/*  432 */       this._events.post(IRetailLocation.SET_APARTMENT, argApartment);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setApartment_noev(String argApartment) {
/*  439 */     boolean ev_postable = false;
/*      */     
/*  441 */     if ((getDAO_().getApartment() == null && argApartment != null) || (
/*  442 */       getDAO_().getApartment() != null && !getDAO_().getApartment().equals(argApartment))) {
/*  443 */       getDAO_().setApartment(argApartment);
/*  444 */       ev_postable = true;
/*      */     } 
/*      */     
/*  447 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCity() {
/*  455 */     return getDAO_().getCity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCity(String argCity) {
/*  463 */     if (setCity_noev(argCity) && 
/*  464 */       this._events != null && 
/*  465 */       postEventsForChanges()) {
/*  466 */       this._events.post(IRetailLocation.SET_CITY, argCity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCity_noev(String argCity) {
/*  473 */     boolean ev_postable = false;
/*      */     
/*  475 */     if ((getDAO_().getCity() == null && argCity != null) || (
/*  476 */       getDAO_().getCity() != null && !getDAO_().getCity().equals(argCity))) {
/*  477 */       getDAO_().setCity(argCity);
/*  478 */       ev_postable = true;
/*      */     } 
/*      */     
/*  481 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCountry() {
/*  489 */     return getDAO_().getCountry();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCountry(String argCountry) {
/*  497 */     if (setCountry_noev(argCountry) && 
/*  498 */       this._events != null && 
/*  499 */       postEventsForChanges()) {
/*  500 */       this._events.post(IRetailLocation.SET_COUNTRY, argCountry);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCountry_noev(String argCountry) {
/*  507 */     boolean ev_postable = false;
/*      */     
/*  509 */     if ((getDAO_().getCountry() == null && argCountry != null) || (
/*  510 */       getDAO_().getCountry() != null && !getDAO_().getCountry().equals(argCountry))) {
/*  511 */       getDAO_().setCountry(argCountry);
/*  512 */       ev_postable = true;
/*      */     } 
/*      */     
/*  515 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLocale() {
/*  523 */     return getDAO_().getLocale();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLocale(String argLocale) {
/*  531 */     if (setLocale_noev(argLocale) && 
/*  532 */       this._events != null && 
/*  533 */       postEventsForChanges()) {
/*  534 */       this._events.post(IRetailLocation.SET_LOCALE, argLocale);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLocale_noev(String argLocale) {
/*  541 */     boolean ev_postable = false;
/*      */     
/*  543 */     if ((getDAO_().getLocale() == null && argLocale != null) || (
/*  544 */       getDAO_().getLocale() != null && !getDAO_().getLocale().equals(argLocale))) {
/*  545 */       getDAO_().setLocale(argLocale);
/*  546 */       ev_postable = true;
/*      */     } 
/*      */     
/*  549 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCurrencyId() {
/*  557 */     return getDAO_().getCurrencyId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCurrencyId(String argCurrencyId) {
/*  565 */     if (setCurrencyId_noev(argCurrencyId) && 
/*  566 */       this._events != null && 
/*  567 */       postEventsForChanges()) {
/*  568 */       this._events.post(IRetailLocation.SET_CURRENCYID, argCurrencyId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCurrencyId_noev(String argCurrencyId) {
/*  575 */     boolean ev_postable = false;
/*      */     
/*  577 */     if ((getDAO_().getCurrencyId() == null && argCurrencyId != null) || (
/*  578 */       getDAO_().getCurrencyId() != null && !getDAO_().getCurrencyId().equals(argCurrencyId))) {
/*  579 */       getDAO_().setCurrencyId(argCurrencyId);
/*  580 */       ev_postable = true;
/*      */     } 
/*      */     
/*  583 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDescription() {
/*  591 */     return getDAO_().getDescription();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDescription(String argDescription) {
/*  599 */     if (setDescription_noev(argDescription) && 
/*  600 */       this._events != null && 
/*  601 */       postEventsForChanges()) {
/*  602 */       this._events.post(IRetailLocation.SET_DESCRIPTION, argDescription);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDescription_noev(String argDescription) {
/*  609 */     boolean ev_postable = false;
/*      */     
/*  611 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/*  612 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/*  613 */       getDAO_().setDescription(argDescription);
/*  614 */       ev_postable = true;
/*      */     } 
/*      */     
/*  617 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPostalCode() {
/*  625 */     return getDAO_().getPostalCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPostalCode(String argPostalCode) {
/*  633 */     if (setPostalCode_noev(argPostalCode) && 
/*  634 */       this._events != null && 
/*  635 */       postEventsForChanges()) {
/*  636 */       this._events.post(IRetailLocation.SET_POSTALCODE, argPostalCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPostalCode_noev(String argPostalCode) {
/*  643 */     boolean ev_postable = false;
/*      */     
/*  645 */     if ((getDAO_().getPostalCode() == null && argPostalCode != null) || (
/*  646 */       getDAO_().getPostalCode() != null && !getDAO_().getPostalCode().equals(argPostalCode))) {
/*  647 */       getDAO_().setPostalCode(argPostalCode);
/*  648 */       ev_postable = true;
/*      */     } 
/*      */     
/*  651 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getState() {
/*  659 */     return getDAO_().getState();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setState(String argState) {
/*  667 */     if (setState_noev(argState) && 
/*  668 */       this._events != null && 
/*  669 */       postEventsForChanges()) {
/*  670 */       this._events.post(IRetailLocation.SET_STATE, argState);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setState_noev(String argState) {
/*  677 */     boolean ev_postable = false;
/*      */     
/*  679 */     if ((getDAO_().getState() == null && argState != null) || (
/*  680 */       getDAO_().getState() != null && !getDAO_().getState().equals(argState))) {
/*  681 */       getDAO_().setState(argState);
/*  682 */       ev_postable = true;
/*      */     } 
/*      */     
/*  685 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStoreName() {
/*  693 */     return getDAO_().getStoreName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStoreName(String argStoreName) {
/*  701 */     if (setStoreName_noev(argStoreName) && 
/*  702 */       this._events != null && 
/*  703 */       postEventsForChanges()) {
/*  704 */       this._events.post(IRetailLocation.SET_STORENAME, argStoreName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStoreName_noev(String argStoreName) {
/*  711 */     boolean ev_postable = false;
/*      */     
/*  713 */     if ((getDAO_().getStoreName() == null && argStoreName != null) || (
/*  714 */       getDAO_().getStoreName() != null && !getDAO_().getStoreName().equals(argStoreName))) {
/*  715 */       getDAO_().setStoreName(argStoreName);
/*  716 */       ev_postable = true;
/*      */     } 
/*      */     
/*  719 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStoreNbr() {
/*  727 */     return getDAO_().getStoreNbr();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStoreNbr(String argStoreNbr) {
/*  735 */     if (setStoreNbr_noev(argStoreNbr) && 
/*  736 */       this._events != null && 
/*  737 */       postEventsForChanges()) {
/*  738 */       this._events.post(IRetailLocation.SET_STORENBR, argStoreNbr);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStoreNbr_noev(String argStoreNbr) {
/*  745 */     boolean ev_postable = false;
/*      */     
/*  747 */     if ((getDAO_().getStoreNbr() == null && argStoreNbr != null) || (
/*  748 */       getDAO_().getStoreNbr() != null && !getDAO_().getStoreNbr().equals(argStoreNbr))) {
/*  749 */       getDAO_().setStoreNbr(argStoreNbr);
/*  750 */       ev_postable = true;
/*      */     } 
/*      */     
/*  753 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAlternateStoreNbr() {
/*  761 */     return getDAO_().getAlternateStoreNbr();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAlternateStoreNbr(String argAlternateStoreNbr) {
/*  769 */     if (setAlternateStoreNbr_noev(argAlternateStoreNbr) && 
/*  770 */       this._events != null && 
/*  771 */       postEventsForChanges()) {
/*  772 */       this._events.post(IRetailLocation.SET_ALTERNATESTORENBR, argAlternateStoreNbr);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAlternateStoreNbr_noev(String argAlternateStoreNbr) {
/*  779 */     boolean ev_postable = false;
/*      */     
/*  781 */     if ((getDAO_().getAlternateStoreNbr() == null && argAlternateStoreNbr != null) || (
/*  782 */       getDAO_().getAlternateStoreNbr() != null && !getDAO_().getAlternateStoreNbr().equals(argAlternateStoreNbr))) {
/*  783 */       getDAO_().setAlternateStoreNbr(argAlternateStoreNbr);
/*  784 */       ev_postable = true;
/*      */     } 
/*      */     
/*  787 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTelephone1() {
/*  795 */     return getDAO_().getTelephone1();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTelephone1(String argTelephone1) {
/*  803 */     if (setTelephone1_noev(argTelephone1) && 
/*  804 */       this._events != null && 
/*  805 */       postEventsForChanges()) {
/*  806 */       this._events.post(IRetailLocation.SET_TELEPHONE1, argTelephone1);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTelephone1_noev(String argTelephone1) {
/*  813 */     boolean ev_postable = false;
/*      */     
/*  815 */     if ((getDAO_().getTelephone1() == null && argTelephone1 != null) || (
/*  816 */       getDAO_().getTelephone1() != null && !getDAO_().getTelephone1().equals(argTelephone1))) {
/*  817 */       getDAO_().setTelephone1(argTelephone1);
/*  818 */       ev_postable = true;
/*      */     } 
/*      */     
/*  821 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTelephone2() {
/*  829 */     return getDAO_().getTelephone2();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTelephone2(String argTelephone2) {
/*  837 */     if (setTelephone2_noev(argTelephone2) && 
/*  838 */       this._events != null && 
/*  839 */       postEventsForChanges()) {
/*  840 */       this._events.post(IRetailLocation.SET_TELEPHONE2, argTelephone2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTelephone2_noev(String argTelephone2) {
/*  847 */     boolean ev_postable = false;
/*      */     
/*  849 */     if ((getDAO_().getTelephone2() == null && argTelephone2 != null) || (
/*  850 */       getDAO_().getTelephone2() != null && !getDAO_().getTelephone2().equals(argTelephone2))) {
/*  851 */       getDAO_().setTelephone2(argTelephone2);
/*  852 */       ev_postable = true;
/*      */     } 
/*      */     
/*  855 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTelephone3() {
/*  863 */     return getDAO_().getTelephone3();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTelephone3(String argTelephone3) {
/*  871 */     if (setTelephone3_noev(argTelephone3) && 
/*  872 */       this._events != null && 
/*  873 */       postEventsForChanges()) {
/*  874 */       this._events.post(IRetailLocation.SET_TELEPHONE3, argTelephone3);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTelephone3_noev(String argTelephone3) {
/*  881 */     boolean ev_postable = false;
/*      */     
/*  883 */     if ((getDAO_().getTelephone3() == null && argTelephone3 != null) || (
/*  884 */       getDAO_().getTelephone3() != null && !getDAO_().getTelephone3().equals(argTelephone3))) {
/*  885 */       getDAO_().setTelephone3(argTelephone3);
/*  886 */       ev_postable = true;
/*      */     } 
/*      */     
/*  889 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTelephone4() {
/*  897 */     return getDAO_().getTelephone4();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTelephone4(String argTelephone4) {
/*  905 */     if (setTelephone4_noev(argTelephone4) && 
/*  906 */       this._events != null && 
/*  907 */       postEventsForChanges()) {
/*  908 */       this._events.post(IRetailLocation.SET_TELEPHONE4, argTelephone4);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTelephone4_noev(String argTelephone4) {
/*  915 */     boolean ev_postable = false;
/*      */     
/*  917 */     if ((getDAO_().getTelephone4() == null && argTelephone4 != null) || (
/*  918 */       getDAO_().getTelephone4() != null && !getDAO_().getTelephone4().equals(argTelephone4))) {
/*  919 */       getDAO_().setTelephone4(argTelephone4);
/*  920 */       ev_postable = true;
/*      */     } 
/*      */     
/*  923 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getLatitude() {
/*  931 */     return getDAO_().getLatitude();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLatitude(BigDecimal argLatitude) {
/*  939 */     if (setLatitude_noev(argLatitude) && 
/*  940 */       this._events != null && 
/*  941 */       postEventsForChanges()) {
/*  942 */       this._events.post(IRetailLocation.SET_LATITUDE, argLatitude);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLatitude_noev(BigDecimal argLatitude) {
/*  949 */     boolean ev_postable = false;
/*      */     
/*  951 */     if ((getDAO_().getLatitude() == null && argLatitude != null) || (
/*  952 */       getDAO_().getLatitude() != null && !getDAO_().getLatitude().equals(argLatitude))) {
/*  953 */       getDAO_().setLatitude(argLatitude);
/*  954 */       ev_postable = true;
/*      */     } 
/*      */     
/*  957 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getLongitude() {
/*  965 */     return getDAO_().getLongitude();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLongitude(BigDecimal argLongitude) {
/*  973 */     if (setLongitude_noev(argLongitude) && 
/*  974 */       this._events != null && 
/*  975 */       postEventsForChanges()) {
/*  976 */       this._events.post(IRetailLocation.SET_LONGITUDE, argLongitude);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLongitude_noev(BigDecimal argLongitude) {
/*  983 */     boolean ev_postable = false;
/*      */     
/*  985 */     if ((getDAO_().getLongitude() == null && argLongitude != null) || (
/*  986 */       getDAO_().getLongitude() != null && !getDAO_().getLongitude().equals(argLongitude))) {
/*  987 */       getDAO_().setLongitude(argLongitude);
/*  988 */       ev_postable = true;
/*      */     } 
/*      */     
/*  991 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getDefaultTaxPercentage() {
/*  999 */     return getDAO_().getDefaultTaxPercentage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDefaultTaxPercentage(BigDecimal argDefaultTaxPercentage) {
/* 1007 */     if (setDefaultTaxPercentage_noev(argDefaultTaxPercentage) && 
/* 1008 */       this._events != null && 
/* 1009 */       postEventsForChanges()) {
/* 1010 */       this._events.post(IRetailLocation.SET_DEFAULTTAXPERCENTAGE, argDefaultTaxPercentage);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDefaultTaxPercentage_noev(BigDecimal argDefaultTaxPercentage) {
/* 1017 */     boolean ev_postable = false;
/*      */     
/* 1019 */     if ((getDAO_().getDefaultTaxPercentage() == null && argDefaultTaxPercentage != null) || (
/* 1020 */       getDAO_().getDefaultTaxPercentage() != null && !getDAO_().getDefaultTaxPercentage().equals(argDefaultTaxPercentage))) {
/* 1021 */       getDAO_().setDefaultTaxPercentage(argDefaultTaxPercentage);
/* 1022 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1025 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStoreManager() {
/* 1033 */     return getDAO_().getStoreManager();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStoreManager(String argStoreManager) {
/* 1041 */     if (setStoreManager_noev(argStoreManager) && 
/* 1042 */       this._events != null && 
/* 1043 */       postEventsForChanges()) {
/* 1044 */       this._events.post(IRetailLocation.SET_STOREMANAGER, argStoreManager);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStoreManager_noev(String argStoreManager) {
/* 1051 */     boolean ev_postable = false;
/*      */     
/* 1053 */     if ((getDAO_().getStoreManager() == null && argStoreManager != null) || (
/* 1054 */       getDAO_().getStoreManager() != null && !getDAO_().getStoreManager().equals(argStoreManager))) {
/* 1055 */       getDAO_().setStoreManager(argStoreManager);
/* 1056 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1059 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLocationType() {
/* 1067 */     return getDAO_().getLocationType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLocationType(String argLocationType) {
/* 1075 */     if (setLocationType_noev(argLocationType) && 
/* 1076 */       this._events != null && 
/* 1077 */       postEventsForChanges()) {
/* 1078 */       this._events.post(IRetailLocation.SET_LOCATIONTYPE, argLocationType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLocationType_noev(String argLocationType) {
/* 1085 */     boolean ev_postable = false;
/*      */     
/* 1087 */     if ((getDAO_().getLocationType() == null && argLocationType != null) || (
/* 1088 */       getDAO_().getLocationType() != null && !getDAO_().getLocationType().equals(argLocationType))) {
/* 1089 */       getDAO_().setLocationType(argLocationType);
/* 1090 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1093 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDeliveryAvailable() {
/* 1101 */     if (getDAO_().getDeliveryAvailable() != null) {
/* 1102 */       return getDAO_().getDeliveryAvailable().booleanValue();
/*      */     }
/*      */     
/* 1105 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDeliveryAvailable(boolean argDeliveryAvailable) {
/* 1114 */     if (setDeliveryAvailable_noev(argDeliveryAvailable) && 
/* 1115 */       this._events != null && 
/* 1116 */       postEventsForChanges()) {
/* 1117 */       this._events.post(IRetailLocation.SET_DELIVERYAVAILABLE, Boolean.valueOf(argDeliveryAvailable));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDeliveryAvailable_noev(boolean argDeliveryAvailable) {
/* 1124 */     boolean ev_postable = false;
/*      */     
/* 1126 */     if ((getDAO_().getDeliveryAvailable() == null && Boolean.valueOf(argDeliveryAvailable) != null) || (
/* 1127 */       getDAO_().getDeliveryAvailable() != null && !getDAO_().getDeliveryAvailable().equals(Boolean.valueOf(argDeliveryAvailable)))) {
/* 1128 */       getDAO_().setDeliveryAvailable(Boolean.valueOf(argDeliveryAvailable));
/* 1129 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1132 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getPickupAvailable() {
/* 1140 */     if (getDAO_().getPickupAvailable() != null) {
/* 1141 */       return getDAO_().getPickupAvailable().booleanValue();
/*      */     }
/*      */     
/* 1144 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPickupAvailable(boolean argPickupAvailable) {
/* 1153 */     if (setPickupAvailable_noev(argPickupAvailable) && 
/* 1154 */       this._events != null && 
/* 1155 */       postEventsForChanges()) {
/* 1156 */       this._events.post(IRetailLocation.SET_PICKUPAVAILABLE, Boolean.valueOf(argPickupAvailable));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPickupAvailable_noev(boolean argPickupAvailable) {
/* 1163 */     boolean ev_postable = false;
/*      */     
/* 1165 */     if ((getDAO_().getPickupAvailable() == null && Boolean.valueOf(argPickupAvailable) != null) || (
/* 1166 */       getDAO_().getPickupAvailable() != null && !getDAO_().getPickupAvailable().equals(Boolean.valueOf(argPickupAvailable)))) {
/* 1167 */       getDAO_().setPickupAvailable(Boolean.valueOf(argPickupAvailable));
/* 1168 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1171 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getTransferAvailable() {
/* 1179 */     if (getDAO_().getTransferAvailable() != null) {
/* 1180 */       return getDAO_().getTransferAvailable().booleanValue();
/*      */     }
/*      */     
/* 1183 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransferAvailable(boolean argTransferAvailable) {
/* 1192 */     if (setTransferAvailable_noev(argTransferAvailable) && 
/* 1193 */       this._events != null && 
/* 1194 */       postEventsForChanges()) {
/* 1195 */       this._events.post(IRetailLocation.SET_TRANSFERAVAILABLE, Boolean.valueOf(argTransferAvailable));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransferAvailable_noev(boolean argTransferAvailable) {
/* 1202 */     boolean ev_postable = false;
/*      */     
/* 1204 */     if ((getDAO_().getTransferAvailable() == null && Boolean.valueOf(argTransferAvailable) != null) || (
/* 1205 */       getDAO_().getTransferAvailable() != null && !getDAO_().getTransferAvailable().equals(Boolean.valueOf(argTransferAvailable)))) {
/* 1206 */       getDAO_().setTransferAvailable(Boolean.valueOf(argTransferAvailable));
/* 1207 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1210 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getEmailAddress() {
/* 1218 */     return getDAO_().getEmailAddress();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEmailAddress(String argEmailAddress) {
/* 1226 */     if (setEmailAddress_noev(argEmailAddress) && 
/* 1227 */       this._events != null && 
/* 1228 */       postEventsForChanges()) {
/* 1229 */       this._events.post(IRetailLocation.SET_EMAILADDRESS, argEmailAddress);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEmailAddress_noev(String argEmailAddress) {
/* 1236 */     boolean ev_postable = false;
/*      */     
/* 1238 */     if ((getDAO_().getEmailAddress() == null && argEmailAddress != null) || (
/* 1239 */       getDAO_().getEmailAddress() != null && !getDAO_().getEmailAddress().equals(argEmailAddress))) {
/* 1240 */       getDAO_().setEmailAddress(argEmailAddress);
/* 1241 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1244 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getGeoCode() {
/* 1252 */     return getDAO_().getGeoCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGeoCode(String argGeoCode) {
/* 1260 */     if (setGeoCode_noev(argGeoCode) && 
/* 1261 */       this._events != null && 
/* 1262 */       postEventsForChanges()) {
/* 1263 */       this._events.post(IRetailLocation.SET_GEOCODE, argGeoCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setGeoCode_noev(String argGeoCode) {
/* 1270 */     boolean ev_postable = false;
/*      */     
/* 1272 */     if ((getDAO_().getGeoCode() == null && argGeoCode != null) || (
/* 1273 */       getDAO_().getGeoCode() != null && !getDAO_().getGeoCode().equals(argGeoCode))) {
/* 1274 */       getDAO_().setGeoCode(argGeoCode);
/* 1275 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1278 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getUezIndicator() {
/* 1286 */     if (getDAO_().getUezIndicator() != null) {
/* 1287 */       return getDAO_().getUezIndicator().booleanValue();
/*      */     }
/*      */     
/* 1290 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUezIndicator(boolean argUezIndicator) {
/* 1299 */     if (setUezIndicator_noev(argUezIndicator) && 
/* 1300 */       this._events != null && 
/* 1301 */       postEventsForChanges()) {
/* 1302 */       this._events.post(IRetailLocation.SET_UEZINDICATOR, Boolean.valueOf(argUezIndicator));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUezIndicator_noev(boolean argUezIndicator) {
/* 1309 */     boolean ev_postable = false;
/*      */     
/* 1311 */     if ((getDAO_().getUezIndicator() == null && Boolean.valueOf(argUezIndicator) != null) || (
/* 1312 */       getDAO_().getUezIndicator() != null && !getDAO_().getUezIndicator().equals(Boolean.valueOf(argUezIndicator)))) {
/* 1313 */       getDAO_().setUezIndicator(Boolean.valueOf(argUezIndicator));
/* 1314 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1317 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDistrict() {
/* 1325 */     return getDAO_().getDistrict();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDistrict(String argDistrict) {
/* 1333 */     if (setDistrict_noev(argDistrict) && 
/* 1334 */       this._events != null && 
/* 1335 */       postEventsForChanges()) {
/* 1336 */       this._events.post(IRetailLocation.SET_DISTRICT, argDistrict);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDistrict_noev(String argDistrict) {
/* 1343 */     boolean ev_postable = false;
/*      */     
/* 1345 */     if ((getDAO_().getDistrict() == null && argDistrict != null) || (
/* 1346 */       getDAO_().getDistrict() != null && !getDAO_().getDistrict().equals(argDistrict))) {
/* 1347 */       getDAO_().setDistrict(argDistrict);
/* 1348 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1351 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getArea() {
/* 1359 */     return getDAO_().getArea();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setArea(String argArea) {
/* 1367 */     if (setArea_noev(argArea) && 
/* 1368 */       this._events != null && 
/* 1369 */       postEventsForChanges()) {
/* 1370 */       this._events.post(IRetailLocation.SET_AREA, argArea);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setArea_noev(String argArea) {
/* 1377 */     boolean ev_postable = false;
/*      */     
/* 1379 */     if ((getDAO_().getArea() == null && argArea != null) || (
/* 1380 */       getDAO_().getArea() != null && !getDAO_().getArea().equals(argArea))) {
/* 1381 */       getDAO_().setArea(argArea);
/* 1382 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1385 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getUseTillAccountability() {
/* 1393 */     if (getDAO_().getUseTillAccountability() != null) {
/* 1394 */       return getDAO_().getUseTillAccountability().booleanValue();
/*      */     }
/*      */     
/* 1397 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUseTillAccountability(boolean argUseTillAccountability) {
/* 1406 */     if (setUseTillAccountability_noev(argUseTillAccountability) && 
/* 1407 */       this._events != null && 
/* 1408 */       postEventsForChanges()) {
/* 1409 */       this._events.post(IRetailLocation.SET_USETILLACCOUNTABILITY, Boolean.valueOf(argUseTillAccountability));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUseTillAccountability_noev(boolean argUseTillAccountability) {
/* 1416 */     boolean ev_postable = false;
/*      */     
/* 1418 */     if ((getDAO_().getUseTillAccountability() == null && Boolean.valueOf(argUseTillAccountability) != null) || (
/* 1419 */       getDAO_().getUseTillAccountability() != null && !getDAO_().getUseTillAccountability().equals(Boolean.valueOf(argUseTillAccountability)))) {
/* 1420 */       getDAO_().setUseTillAccountability(Boolean.valueOf(argUseTillAccountability));
/* 1421 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1424 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDepositBankName() {
/* 1432 */     return getDAO_().getDepositBankName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDepositBankName(String argDepositBankName) {
/* 1440 */     if (setDepositBankName_noev(argDepositBankName) && 
/* 1441 */       this._events != null && 
/* 1442 */       postEventsForChanges()) {
/* 1443 */       this._events.post(IRetailLocation.SET_DEPOSITBANKNAME, argDepositBankName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDepositBankName_noev(String argDepositBankName) {
/* 1450 */     boolean ev_postable = false;
/*      */     
/* 1452 */     if ((getDAO_().getDepositBankName() == null && argDepositBankName != null) || (
/* 1453 */       getDAO_().getDepositBankName() != null && !getDAO_().getDepositBankName().equals(argDepositBankName))) {
/* 1454 */       getDAO_().setDepositBankName(argDepositBankName);
/* 1455 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1458 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDepositBankAcctNbr() {
/* 1466 */     return getDAO_().getDepositBankAcctNbr();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDepositBankAcctNbr(String argDepositBankAcctNbr) {
/* 1474 */     if (setDepositBankAcctNbr_noev(argDepositBankAcctNbr) && 
/* 1475 */       this._events != null && 
/* 1476 */       postEventsForChanges()) {
/* 1477 */       this._events.post(IRetailLocation.SET_DEPOSITBANKACCTNBR, argDepositBankAcctNbr);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDepositBankAcctNbr_noev(String argDepositBankAcctNbr) {
/* 1484 */     boolean ev_postable = false;
/*      */     
/* 1486 */     if ((getDAO_().getDepositBankAcctNbr() == null && argDepositBankAcctNbr != null) || (
/* 1487 */       getDAO_().getDepositBankAcctNbr() != null && !getDAO_().getDepositBankAcctNbr().equals(argDepositBankAcctNbr))) {
/* 1488 */       getDAO_().setDepositBankAcctNbr(argDepositBankAcctNbr);
/* 1489 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1492 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNeighborhood() {
/* 1500 */     return getDAO_().getNeighborhood();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNeighborhood(String argNeighborhood) {
/* 1508 */     if (setNeighborhood_noev(argNeighborhood) && 
/* 1509 */       this._events != null && 
/* 1510 */       postEventsForChanges()) {
/* 1511 */       this._events.post(IRetailLocation.SET_NEIGHBORHOOD, argNeighborhood);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNeighborhood_noev(String argNeighborhood) {
/* 1518 */     boolean ev_postable = false;
/*      */     
/* 1520 */     if ((getDAO_().getNeighborhood() == null && argNeighborhood != null) || (
/* 1521 */       getDAO_().getNeighborhood() != null && !getDAO_().getNeighborhood().equals(argNeighborhood))) {
/* 1522 */       getDAO_().setNeighborhood(argNeighborhood);
/* 1523 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1526 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCounty() {
/* 1534 */     return getDAO_().getCounty();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCounty(String argCounty) {
/* 1542 */     if (setCounty_noev(argCounty) && 
/* 1543 */       this._events != null && 
/* 1544 */       postEventsForChanges()) {
/* 1545 */       this._events.post(IRetailLocation.SET_COUNTY, argCounty);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCounty_noev(String argCounty) {
/* 1552 */     boolean ev_postable = false;
/*      */     
/* 1554 */     if ((getDAO_().getCounty() == null && argCounty != null) || (
/* 1555 */       getDAO_().getCounty() != null && !getDAO_().getCounty().equals(argCounty))) {
/* 1556 */       getDAO_().setCounty(argCounty);
/* 1557 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1560 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAirportCode() {
/* 1568 */     return getDAO_().getAirportCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAirportCode(String argAirportCode) {
/* 1576 */     if (setAirportCode_noev(argAirportCode) && 
/* 1577 */       this._events != null && 
/* 1578 */       postEventsForChanges()) {
/* 1579 */       this._events.post(IRetailLocation.SET_AIRPORTCODE, argAirportCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAirportCode_noev(String argAirportCode) {
/* 1586 */     boolean ev_postable = false;
/*      */     
/* 1588 */     if ((getDAO_().getAirportCode() == null && argAirportCode != null) || (
/* 1589 */       getDAO_().getAirportCode() != null && !getDAO_().getAirportCode().equals(argAirportCode))) {
/* 1590 */       getDAO_().setAirportCode(argAirportCode);
/* 1591 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1594 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IRetailLocationProperty newProperty(String argPropertyName) {
/* 1598 */     RetailLocationPropertyId id = new RetailLocationPropertyId();
/*      */     
/* 1600 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 1601 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1603 */     IRetailLocationProperty prop = (IRetailLocationProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IRetailLocationProperty.class);
/* 1604 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IRetailLocationProperty> getProperties() {
/* 1613 */     if (this._properties == null) {
/* 1614 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1616 */     return (List<IRetailLocationProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IRetailLocationProperty> argProperties) {
/* 1620 */     if (this._properties == null) {
/* 1621 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1623 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1626 */     for (IRetailLocationProperty child : this._properties) {
/* 1627 */       RetailLocationPropertyModel model = (RetailLocationPropertyModel)child;
/* 1628 */       model.setOrganizationId_noev(getOrganizationId());
/* 1629 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1630 */       if (child instanceof IDataModelImpl) {
/* 1631 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1632 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1633 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1634 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1637 */       if (postEventsForChanges()) {
/* 1638 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addRetailLocationProperty(IRetailLocationProperty argRetailLocationProperty) {
/* 1644 */     if (this._properties == null) {
/* 1645 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1647 */     argRetailLocationProperty.setOrganizationId(getOrganizationId());
/* 1648 */     argRetailLocationProperty.setRetailLocationId(getRetailLocationId());
/* 1649 */     if (argRetailLocationProperty instanceof IDataModelImpl) {
/* 1650 */       IDataAccessObject childDao = ((IDataModelImpl)argRetailLocationProperty).getDAO();
/* 1651 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1652 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1653 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1658 */     if (postEventsForChanges()) {
/* 1659 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailLocationProperty));
/*      */     }
/*      */     
/* 1662 */     this._properties.add(argRetailLocationProperty);
/* 1663 */     if (postEventsForChanges()) {
/* 1664 */       this._events.post(IRetailLocation.ADD_PROPERTIES, argRetailLocationProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeRetailLocationProperty(IRetailLocationProperty argRetailLocationProperty) {
/* 1669 */     if (this._properties != null) {
/*      */       
/* 1671 */       if (postEventsForChanges()) {
/* 1672 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailLocationProperty));
/*      */       }
/* 1674 */       this._properties.remove(argRetailLocationProperty);
/* 1675 */       if (postEventsForChanges()) {
/* 1676 */         this._events.post(IRetailLocation.REMOVE_PROPERTIES, argRetailLocationProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1683 */     if ("Properties".equals(argFieldId)) {
/* 1684 */       return getProperties();
/*      */     }
/* 1686 */     if ("RetailLocationExtension".equals(argFieldId)) {
/* 1687 */       return this._myExtension;
/*      */     }
/*      */     
/* 1690 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1696 */     if ("Properties".equals(argFieldId)) {
/* 1697 */       setProperties(changeToList(argValue, IRetailLocationProperty.class));
/*      */     }
/* 1699 */     else if ("RetailLocationExtension".equals(argFieldId)) {
/* 1700 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1703 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1709 */     this._persistenceDefaults = argPD;
/* 1710 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1711 */     this._eventManager = argEM;
/* 1712 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1713 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1714 */     if (this._properties != null) {
/* 1715 */       for (IRetailLocationProperty relationship : this._properties) {
/* 1716 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getRetailLocationExt() {
/* 1722 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setRetailLocationExt(IDataModel argExt) {
/* 1726 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1731 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1735 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1738 */     super.startTransaction();
/*      */     
/* 1740 */     this._propertiesSavepoint = this._properties;
/* 1741 */     if (this._properties != null) {
/* 1742 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1743 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1744 */       while (it.hasNext()) {
/* 1745 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1750 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1755 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1758 */     super.rollbackChanges();
/*      */     
/* 1760 */     this._properties = this._propertiesSavepoint;
/* 1761 */     this._propertiesSavepoint = null;
/* 1762 */     if (this._properties != null) {
/* 1763 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1764 */       while (it.hasNext()) {
/* 1765 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1773 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1776 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1779 */     super.commitTransaction();
/*      */     
/* 1781 */     this._propertiesSavepoint = this._properties;
/* 1782 */     if (this._properties != null) {
/* 1783 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1784 */       while (it.hasNext()) {
/* 1785 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1787 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1791 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\RetailLocationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */