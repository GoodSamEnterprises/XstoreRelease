/*      */ package dtv.xst.dao.cat.impl;
/*      */ 
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
/*      */ import dtv.xst.dao.cat.DeliveryModifierPropertyId;
/*      */ import dtv.xst.dao.cat.IDeliveryModifier;
/*      */ import dtv.xst.dao.cat.IDeliveryModifierProperty;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class DeliveryModifierModel extends DeliveryModifierBaseModel implements IDeliveryModifier {
/*      */   private static final long serialVersionUID = -2114809077L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   
/*      */   public String toString() {
/*   34 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IDataModel _myExtension; private HistoricalList<IDeliveryModifierProperty> _properties; private transient HistoricalList<IDeliveryModifierProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   39 */     setDAO((IDataAccessObject)new DeliveryModifierDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private DeliveryModifierDAO getDAO_() {
/*   47 */     return (DeliveryModifierDAO)this._daoImpl;
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
/*   71 */       this._events.post(IDeliveryModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*   86 */         Iterator<DeliveryModifierPropertyModel> it = this._properties.iterator();
/*   87 */         while (it.hasNext())
/*      */         {
/*   89 */           ((DeliveryModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*      */   public String getCustAccountId() {
/*  102 */     return getDAO_().getCustAccountId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustAccountId(String argCustAccountId) {
/*  110 */     if (setCustAccountId_noev(argCustAccountId) && 
/*  111 */       this._events != null && 
/*  112 */       postEventsForChanges()) {
/*  113 */       this._events.post(IDeliveryModifier.SET_CUSTACCOUNTID, argCustAccountId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustAccountId_noev(String argCustAccountId) {
/*  120 */     boolean ev_postable = false;
/*      */     
/*  122 */     if ((getDAO_().getCustAccountId() == null && argCustAccountId != null) || (
/*  123 */       getDAO_().getCustAccountId() != null && !getDAO_().getCustAccountId().equals(argCustAccountId))) {
/*  124 */       getDAO_().setCustAccountId(argCustAccountId);
/*  125 */       ev_postable = true;
/*  126 */       if (this._properties != null) {
/*      */         
/*  128 */         Iterator<DeliveryModifierPropertyModel> it = this._properties.iterator();
/*  129 */         while (it.hasNext())
/*      */         {
/*  131 */           ((DeliveryModifierPropertyModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  136 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustAccountCode() {
/*  144 */     return getDAO_().getCustAccountCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustAccountCode(String argCustAccountCode) {
/*  152 */     if (setCustAccountCode_noev(argCustAccountCode) && 
/*  153 */       this._events != null && 
/*  154 */       postEventsForChanges()) {
/*  155 */       this._events.post(IDeliveryModifier.SET_CUSTACCOUNTCODE, argCustAccountCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustAccountCode_noev(String argCustAccountCode) {
/*  162 */     boolean ev_postable = false;
/*      */     
/*  164 */     if ((getDAO_().getCustAccountCode() == null && argCustAccountCode != null) || (
/*  165 */       getDAO_().getCustAccountCode() != null && !getDAO_().getCustAccountCode().equals(argCustAccountCode))) {
/*  166 */       getDAO_().setCustAccountCode(argCustAccountCode);
/*  167 */       ev_postable = true;
/*  168 */       if (this._properties != null) {
/*      */         
/*  170 */         Iterator<DeliveryModifierPropertyModel> it = this._properties.iterator();
/*  171 */         while (it.hasNext())
/*      */         {
/*  173 */           ((DeliveryModifierPropertyModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  178 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  186 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  194 */     if (setCreateDate_noev(argCreateDate) && 
/*  195 */       this._events != null && 
/*  196 */       postEventsForChanges()) {
/*  197 */       this._events.post(IDeliveryModifier.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  204 */     boolean ev_postable = false;
/*      */     
/*  206 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  207 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  208 */       getDAO_().setCreateDate(argCreateDate);
/*  209 */       ev_postable = true;
/*      */     } 
/*      */     
/*  212 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  220 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  228 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  229 */       this._events != null && 
/*  230 */       postEventsForChanges()) {
/*  231 */       this._events.post(IDeliveryModifier.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  238 */     boolean ev_postable = false;
/*      */     
/*  240 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  241 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  242 */       getDAO_().setCreateUserId(argCreateUserId);
/*  243 */       ev_postable = true;
/*      */     } 
/*      */     
/*  246 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  254 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  262 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  263 */       this._events != null && 
/*  264 */       postEventsForChanges()) {
/*  265 */       this._events.post(IDeliveryModifier.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  272 */     boolean ev_postable = false;
/*      */     
/*  274 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  275 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  276 */       getDAO_().setUpdateDate(argUpdateDate);
/*  277 */       ev_postable = true;
/*      */     } 
/*      */     
/*  280 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  288 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  296 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  297 */       this._events != null && 
/*  298 */       postEventsForChanges()) {
/*  299 */       this._events.post(IDeliveryModifier.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  306 */     boolean ev_postable = false;
/*      */     
/*  308 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  309 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  310 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  311 */       ev_postable = true;
/*      */     } 
/*      */     
/*  314 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDeliveryType() {
/*  322 */     return getDAO_().getDeliveryType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDeliveryType(String argDeliveryType) {
/*  330 */     if (setDeliveryType_noev(argDeliveryType) && 
/*  331 */       this._events != null && 
/*  332 */       postEventsForChanges()) {
/*  333 */       this._events.post(IDeliveryModifier.SET_DELIVERYTYPE, argDeliveryType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDeliveryType_noev(String argDeliveryType) {
/*  340 */     boolean ev_postable = false;
/*      */     
/*  342 */     if ((getDAO_().getDeliveryType() == null && argDeliveryType != null) || (
/*  343 */       getDAO_().getDeliveryType() != null && !getDAO_().getDeliveryType().equals(argDeliveryType))) {
/*  344 */       getDAO_().setDeliveryType(argDeliveryType);
/*  345 */       ev_postable = true;
/*      */     } 
/*      */     
/*  348 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFirstName() {
/*  356 */     return getDAO_().getFirstName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFirstName(String argFirstName) {
/*  364 */     if (setFirstName_noev(argFirstName) && 
/*  365 */       this._events != null && 
/*  366 */       postEventsForChanges()) {
/*  367 */       this._events.post(IDeliveryModifier.SET_FIRSTNAME, argFirstName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFirstName_noev(String argFirstName) {
/*  374 */     boolean ev_postable = false;
/*      */     
/*  376 */     if ((getDAO_().getFirstName() == null && argFirstName != null) || (
/*  377 */       getDAO_().getFirstName() != null && !getDAO_().getFirstName().equals(argFirstName))) {
/*  378 */       getDAO_().setFirstName(argFirstName);
/*  379 */       ev_postable = true;
/*      */     } 
/*      */     
/*  382 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getMiddleName() {
/*  390 */     return getDAO_().getMiddleName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMiddleName(String argMiddleName) {
/*  398 */     if (setMiddleName_noev(argMiddleName) && 
/*  399 */       this._events != null && 
/*  400 */       postEventsForChanges()) {
/*  401 */       this._events.post(IDeliveryModifier.SET_MIDDLENAME, argMiddleName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMiddleName_noev(String argMiddleName) {
/*  408 */     boolean ev_postable = false;
/*      */     
/*  410 */     if ((getDAO_().getMiddleName() == null && argMiddleName != null) || (
/*  411 */       getDAO_().getMiddleName() != null && !getDAO_().getMiddleName().equals(argMiddleName))) {
/*  412 */       getDAO_().setMiddleName(argMiddleName);
/*  413 */       ev_postable = true;
/*      */     } 
/*      */     
/*  416 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLastName() {
/*  424 */     return getDAO_().getLastName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLastName(String argLastName) {
/*  432 */     if (setLastName_noev(argLastName) && 
/*  433 */       this._events != null && 
/*  434 */       postEventsForChanges()) {
/*  435 */       this._events.post(IDeliveryModifier.SET_LASTNAME, argLastName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLastName_noev(String argLastName) {
/*  442 */     boolean ev_postable = false;
/*      */     
/*  444 */     if ((getDAO_().getLastName() == null && argLastName != null) || (
/*  445 */       getDAO_().getLastName() != null && !getDAO_().getLastName().equals(argLastName))) {
/*  446 */       getDAO_().setLastName(argLastName);
/*  447 */       ev_postable = true;
/*      */     } 
/*      */     
/*  450 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAddress1() {
/*  458 */     return getDAO_().getAddress1();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddress1(String argAddress1) {
/*  466 */     if (setAddress1_noev(argAddress1) && 
/*  467 */       this._events != null && 
/*  468 */       postEventsForChanges()) {
/*  469 */       this._events.post(IDeliveryModifier.SET_ADDRESS1, argAddress1);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddress1_noev(String argAddress1) {
/*  476 */     boolean ev_postable = false;
/*      */     
/*  478 */     if ((getDAO_().getAddress1() == null && argAddress1 != null) || (
/*  479 */       getDAO_().getAddress1() != null && !getDAO_().getAddress1().equals(argAddress1))) {
/*  480 */       getDAO_().setAddress1(argAddress1);
/*  481 */       ev_postable = true;
/*      */     } 
/*      */     
/*  484 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAddress2() {
/*  492 */     return getDAO_().getAddress2();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddress2(String argAddress2) {
/*  500 */     if (setAddress2_noev(argAddress2) && 
/*  501 */       this._events != null && 
/*  502 */       postEventsForChanges()) {
/*  503 */       this._events.post(IDeliveryModifier.SET_ADDRESS2, argAddress2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddress2_noev(String argAddress2) {
/*  510 */     boolean ev_postable = false;
/*      */     
/*  512 */     if ((getDAO_().getAddress2() == null && argAddress2 != null) || (
/*  513 */       getDAO_().getAddress2() != null && !getDAO_().getAddress2().equals(argAddress2))) {
/*  514 */       getDAO_().setAddress2(argAddress2);
/*  515 */       ev_postable = true;
/*      */     } 
/*      */     
/*  518 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAddress3() {
/*  526 */     return getDAO_().getAddress3();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddress3(String argAddress3) {
/*  534 */     if (setAddress3_noev(argAddress3) && 
/*  535 */       this._events != null && 
/*  536 */       postEventsForChanges()) {
/*  537 */       this._events.post(IDeliveryModifier.SET_ADDRESS3, argAddress3);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddress3_noev(String argAddress3) {
/*  544 */     boolean ev_postable = false;
/*      */     
/*  546 */     if ((getDAO_().getAddress3() == null && argAddress3 != null) || (
/*  547 */       getDAO_().getAddress3() != null && !getDAO_().getAddress3().equals(argAddress3))) {
/*  548 */       getDAO_().setAddress3(argAddress3);
/*  549 */       ev_postable = true;
/*      */     } 
/*      */     
/*  552 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAddress4() {
/*  560 */     return getDAO_().getAddress4();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddress4(String argAddress4) {
/*  568 */     if (setAddress4_noev(argAddress4) && 
/*  569 */       this._events != null && 
/*  570 */       postEventsForChanges()) {
/*  571 */       this._events.post(IDeliveryModifier.SET_ADDRESS4, argAddress4);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddress4_noev(String argAddress4) {
/*  578 */     boolean ev_postable = false;
/*      */     
/*  580 */     if ((getDAO_().getAddress4() == null && argAddress4 != null) || (
/*  581 */       getDAO_().getAddress4() != null && !getDAO_().getAddress4().equals(argAddress4))) {
/*  582 */       getDAO_().setAddress4(argAddress4);
/*  583 */       ev_postable = true;
/*      */     } 
/*      */     
/*  586 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getApartment() {
/*  594 */     return getDAO_().getApartment();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setApartment(String argApartment) {
/*  602 */     if (setApartment_noev(argApartment) && 
/*  603 */       this._events != null && 
/*  604 */       postEventsForChanges()) {
/*  605 */       this._events.post(IDeliveryModifier.SET_APARTMENT, argApartment);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setApartment_noev(String argApartment) {
/*  612 */     boolean ev_postable = false;
/*      */     
/*  614 */     if ((getDAO_().getApartment() == null && argApartment != null) || (
/*  615 */       getDAO_().getApartment() != null && !getDAO_().getApartment().equals(argApartment))) {
/*  616 */       getDAO_().setApartment(argApartment);
/*  617 */       ev_postable = true;
/*      */     } 
/*      */     
/*  620 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCity() {
/*  628 */     return getDAO_().getCity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCity(String argCity) {
/*  636 */     if (setCity_noev(argCity) && 
/*  637 */       this._events != null && 
/*  638 */       postEventsForChanges()) {
/*  639 */       this._events.post(IDeliveryModifier.SET_CITY, argCity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCity_noev(String argCity) {
/*  646 */     boolean ev_postable = false;
/*      */     
/*  648 */     if ((getDAO_().getCity() == null && argCity != null) || (
/*  649 */       getDAO_().getCity() != null && !getDAO_().getCity().equals(argCity))) {
/*  650 */       getDAO_().setCity(argCity);
/*  651 */       ev_postable = true;
/*      */     } 
/*      */     
/*  654 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getState() {
/*  662 */     return getDAO_().getState();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setState(String argState) {
/*  670 */     if (setState_noev(argState) && 
/*  671 */       this._events != null && 
/*  672 */       postEventsForChanges()) {
/*  673 */       this._events.post(IDeliveryModifier.SET_STATE, argState);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setState_noev(String argState) {
/*  680 */     boolean ev_postable = false;
/*      */     
/*  682 */     if ((getDAO_().getState() == null && argState != null) || (
/*  683 */       getDAO_().getState() != null && !getDAO_().getState().equals(argState))) {
/*  684 */       getDAO_().setState(argState);
/*  685 */       ev_postable = true;
/*      */     } 
/*      */     
/*  688 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPostalCode() {
/*  696 */     return getDAO_().getPostalCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPostalCode(String argPostalCode) {
/*  704 */     if (setPostalCode_noev(argPostalCode) && 
/*  705 */       this._events != null && 
/*  706 */       postEventsForChanges()) {
/*  707 */       this._events.post(IDeliveryModifier.SET_POSTALCODE, argPostalCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPostalCode_noev(String argPostalCode) {
/*  714 */     boolean ev_postable = false;
/*      */     
/*  716 */     if ((getDAO_().getPostalCode() == null && argPostalCode != null) || (
/*  717 */       getDAO_().getPostalCode() != null && !getDAO_().getPostalCode().equals(argPostalCode))) {
/*  718 */       getDAO_().setPostalCode(argPostalCode);
/*  719 */       ev_postable = true;
/*      */     } 
/*      */     
/*  722 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCountry() {
/*  730 */     return getDAO_().getCountry();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCountry(String argCountry) {
/*  738 */     if (setCountry_noev(argCountry) && 
/*  739 */       this._events != null && 
/*  740 */       postEventsForChanges()) {
/*  741 */       this._events.post(IDeliveryModifier.SET_COUNTRY, argCountry);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCountry_noev(String argCountry) {
/*  748 */     boolean ev_postable = false;
/*      */     
/*  750 */     if ((getDAO_().getCountry() == null && argCountry != null) || (
/*  751 */       getDAO_().getCountry() != null && !getDAO_().getCountry().equals(argCountry))) {
/*  752 */       getDAO_().setCountry(argCountry);
/*  753 */       ev_postable = true;
/*      */     } 
/*      */     
/*  756 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTelephone1() {
/*  764 */     return getDAO_().getTelephone1();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTelephone1(String argTelephone1) {
/*  772 */     if (setTelephone1_noev(argTelephone1) && 
/*  773 */       this._events != null && 
/*  774 */       postEventsForChanges()) {
/*  775 */       this._events.post(IDeliveryModifier.SET_TELEPHONE1, argTelephone1);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTelephone1_noev(String argTelephone1) {
/*  782 */     boolean ev_postable = false;
/*      */     
/*  784 */     if ((getDAO_().getTelephone1() == null && argTelephone1 != null) || (
/*  785 */       getDAO_().getTelephone1() != null && !getDAO_().getTelephone1().equals(argTelephone1))) {
/*  786 */       getDAO_().setTelephone1(argTelephone1);
/*  787 */       ev_postable = true;
/*      */     } 
/*      */     
/*  790 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTelephone2() {
/*  798 */     return getDAO_().getTelephone2();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTelephone2(String argTelephone2) {
/*  806 */     if (setTelephone2_noev(argTelephone2) && 
/*  807 */       this._events != null && 
/*  808 */       postEventsForChanges()) {
/*  809 */       this._events.post(IDeliveryModifier.SET_TELEPHONE2, argTelephone2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTelephone2_noev(String argTelephone2) {
/*  816 */     boolean ev_postable = false;
/*      */     
/*  818 */     if ((getDAO_().getTelephone2() == null && argTelephone2 != null) || (
/*  819 */       getDAO_().getTelephone2() != null && !getDAO_().getTelephone2().equals(argTelephone2))) {
/*  820 */       getDAO_().setTelephone2(argTelephone2);
/*  821 */       ev_postable = true;
/*      */     } 
/*      */     
/*  824 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTelephone3() {
/*  832 */     return getDAO_().getTelephone3();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTelephone3(String argTelephone3) {
/*  840 */     if (setTelephone3_noev(argTelephone3) && 
/*  841 */       this._events != null && 
/*  842 */       postEventsForChanges()) {
/*  843 */       this._events.post(IDeliveryModifier.SET_TELEPHONE3, argTelephone3);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTelephone3_noev(String argTelephone3) {
/*  850 */     boolean ev_postable = false;
/*      */     
/*  852 */     if ((getDAO_().getTelephone3() == null && argTelephone3 != null) || (
/*  853 */       getDAO_().getTelephone3() != null && !getDAO_().getTelephone3().equals(argTelephone3))) {
/*  854 */       getDAO_().setTelephone3(argTelephone3);
/*  855 */       ev_postable = true;
/*      */     } 
/*      */     
/*  858 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTelephone4() {
/*  866 */     return getDAO_().getTelephone4();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTelephone4(String argTelephone4) {
/*  874 */     if (setTelephone4_noev(argTelephone4) && 
/*  875 */       this._events != null && 
/*  876 */       postEventsForChanges()) {
/*  877 */       this._events.post(IDeliveryModifier.SET_TELEPHONE4, argTelephone4);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTelephone4_noev(String argTelephone4) {
/*  884 */     boolean ev_postable = false;
/*      */     
/*  886 */     if ((getDAO_().getTelephone4() == null && argTelephone4 != null) || (
/*  887 */       getDAO_().getTelephone4() != null && !getDAO_().getTelephone4().equals(argTelephone4))) {
/*  888 */       getDAO_().setTelephone4(argTelephone4);
/*  889 */       ev_postable = true;
/*      */     } 
/*      */     
/*  892 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getShippingMethod() {
/*  900 */     return getDAO_().getShippingMethod();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShippingMethod(String argShippingMethod) {
/*  908 */     if (setShippingMethod_noev(argShippingMethod) && 
/*  909 */       this._events != null && 
/*  910 */       postEventsForChanges()) {
/*  911 */       this._events.post(IDeliveryModifier.SET_SHIPPINGMETHOD, argShippingMethod);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setShippingMethod_noev(String argShippingMethod) {
/*  918 */     boolean ev_postable = false;
/*      */     
/*  920 */     if ((getDAO_().getShippingMethod() == null && argShippingMethod != null) || (
/*  921 */       getDAO_().getShippingMethod() != null && !getDAO_().getShippingMethod().equals(argShippingMethod))) {
/*  922 */       getDAO_().setShippingMethod(argShippingMethod);
/*  923 */       ev_postable = true;
/*      */     } 
/*      */     
/*  926 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTrackingNumber() {
/*  934 */     return getDAO_().getTrackingNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTrackingNumber(String argTrackingNumber) {
/*  942 */     if (setTrackingNumber_noev(argTrackingNumber) && 
/*  943 */       this._events != null && 
/*  944 */       postEventsForChanges()) {
/*  945 */       this._events.post(IDeliveryModifier.SET_TRACKINGNUMBER, argTrackingNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTrackingNumber_noev(String argTrackingNumber) {
/*  952 */     boolean ev_postable = false;
/*      */     
/*  954 */     if ((getDAO_().getTrackingNumber() == null && argTrackingNumber != null) || (
/*  955 */       getDAO_().getTrackingNumber() != null && !getDAO_().getTrackingNumber().equals(argTrackingNumber))) {
/*  956 */       getDAO_().setTrackingNumber(argTrackingNumber);
/*  957 */       ev_postable = true;
/*      */     } 
/*      */     
/*  960 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getInstructions() {
/*  968 */     return getDAO_().getInstructions();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInstructions(String argInstructions) {
/*  976 */     if (setInstructions_noev(argInstructions) && 
/*  977 */       this._events != null && 
/*  978 */       postEventsForChanges()) {
/*  979 */       this._events.post(IDeliveryModifier.SET_INSTRUCTIONS, argInstructions);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setInstructions_noev(String argInstructions) {
/*  986 */     boolean ev_postable = false;
/*      */     
/*  988 */     if ((getDAO_().getInstructions() == null && argInstructions != null) || (
/*  989 */       getDAO_().getInstructions() != null && !getDAO_().getInstructions().equals(argInstructions))) {
/*  990 */       getDAO_().setInstructions(argInstructions);
/*  991 */       ev_postable = true;
/*      */     } 
/*      */     
/*  994 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getExtension() {
/* 1002 */     return getDAO_().getExtension();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExtension(String argExtension) {
/* 1010 */     if (setExtension_noev(argExtension) && 
/* 1011 */       this._events != null && 
/* 1012 */       postEventsForChanges()) {
/* 1013 */       this._events.post(IDeliveryModifier.SET_EXTENSION, argExtension);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExtension_noev(String argExtension) {
/* 1020 */     boolean ev_postable = false;
/*      */     
/* 1022 */     if ((getDAO_().getExtension() == null && argExtension != null) || (
/* 1023 */       getDAO_().getExtension() != null && !getDAO_().getExtension().equals(argExtension))) {
/* 1024 */       getDAO_().setExtension(argExtension);
/* 1025 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1028 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDeliveryDate() {
/* 1036 */     return getDAO_().getDeliveryDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDeliveryDate(Date argDeliveryDate) {
/* 1044 */     if (setDeliveryDate_noev(argDeliveryDate) && 
/* 1045 */       this._events != null && 
/* 1046 */       postEventsForChanges()) {
/* 1047 */       this._events.post(IDeliveryModifier.SET_DELIVERYDATE, argDeliveryDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDeliveryDate_noev(Date argDeliveryDate) {
/* 1054 */     boolean ev_postable = false;
/*      */     
/* 1056 */     if ((getDAO_().getDeliveryDate() == null && argDeliveryDate != null) || (
/* 1057 */       getDAO_().getDeliveryDate() != null && !getDAO_().getDeliveryDate().equals(argDeliveryDate))) {
/* 1058 */       getDAO_().setDeliveryDate(argDeliveryDate);
/* 1059 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1062 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getStartTime() {
/* 1070 */     return getDAO_().getStartTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStartTime(Date argStartTime) {
/* 1078 */     if (setStartTime_noev(argStartTime) && 
/* 1079 */       this._events != null && 
/* 1080 */       postEventsForChanges()) {
/* 1081 */       this._events.post(IDeliveryModifier.SET_STARTTIME, argStartTime);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStartTime_noev(Date argStartTime) {
/* 1088 */     boolean ev_postable = false;
/*      */     
/* 1090 */     if ((getDAO_().getStartTime() == null && argStartTime != null) || (
/* 1091 */       getDAO_().getStartTime() != null && !getDAO_().getStartTime().equals(argStartTime))) {
/* 1092 */       getDAO_().setStartTime(argStartTime);
/* 1093 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1096 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getEndTime() {
/* 1104 */     return getDAO_().getEndTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEndTime(Date argEndTime) {
/* 1112 */     if (setEndTime_noev(argEndTime) && 
/* 1113 */       this._events != null && 
/* 1114 */       postEventsForChanges()) {
/* 1115 */       this._events.post(IDeliveryModifier.SET_ENDTIME, argEndTime);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEndTime_noev(Date argEndTime) {
/* 1122 */     boolean ev_postable = false;
/*      */     
/* 1124 */     if ((getDAO_().getEndTime() == null && argEndTime != null) || (
/* 1125 */       getDAO_().getEndTime() != null && !getDAO_().getEndTime().equals(argEndTime))) {
/* 1126 */       getDAO_().setEndTime(argEndTime);
/* 1127 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1130 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getGeoCode() {
/* 1138 */     return getDAO_().getGeoCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGeoCode(String argGeoCode) {
/* 1146 */     if (setGeoCode_noev(argGeoCode) && 
/* 1147 */       this._events != null && 
/* 1148 */       postEventsForChanges()) {
/* 1149 */       this._events.post(IDeliveryModifier.SET_GEOCODE, argGeoCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setGeoCode_noev(String argGeoCode) {
/* 1156 */     boolean ev_postable = false;
/*      */     
/* 1158 */     if ((getDAO_().getGeoCode() == null && argGeoCode != null) || (
/* 1159 */       getDAO_().getGeoCode() != null && !getDAO_().getGeoCode().equals(argGeoCode))) {
/* 1160 */       getDAO_().setGeoCode(argGeoCode);
/* 1161 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1164 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNeighborhood() {
/* 1172 */     return getDAO_().getNeighborhood();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNeighborhood(String argNeighborhood) {
/* 1180 */     if (setNeighborhood_noev(argNeighborhood) && 
/* 1181 */       this._events != null && 
/* 1182 */       postEventsForChanges()) {
/* 1183 */       this._events.post(IDeliveryModifier.SET_NEIGHBORHOOD, argNeighborhood);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNeighborhood_noev(String argNeighborhood) {
/* 1190 */     boolean ev_postable = false;
/*      */     
/* 1192 */     if ((getDAO_().getNeighborhood() == null && argNeighborhood != null) || (
/* 1193 */       getDAO_().getNeighborhood() != null && !getDAO_().getNeighborhood().equals(argNeighborhood))) {
/* 1194 */       getDAO_().setNeighborhood(argNeighborhood);
/* 1195 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1198 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCounty() {
/* 1206 */     return getDAO_().getCounty();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCounty(String argCounty) {
/* 1214 */     if (setCounty_noev(argCounty) && 
/* 1215 */       this._events != null && 
/* 1216 */       postEventsForChanges()) {
/* 1217 */       this._events.post(IDeliveryModifier.SET_COUNTY, argCounty);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCounty_noev(String argCounty) {
/* 1224 */     boolean ev_postable = false;
/*      */     
/* 1226 */     if ((getDAO_().getCounty() == null && argCounty != null) || (
/* 1227 */       getDAO_().getCounty() != null && !getDAO_().getCounty().equals(argCounty))) {
/* 1228 */       getDAO_().setCounty(argCounty);
/* 1229 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1232 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IDeliveryModifierProperty newProperty(String argPropertyName) {
/* 1236 */     DeliveryModifierPropertyId id = new DeliveryModifierPropertyId();
/*      */     
/* 1238 */     id.setCustAccountId(getCustAccountId());
/* 1239 */     id.setCustAccountCode(getCustAccountCode());
/* 1240 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1242 */     IDeliveryModifierProperty prop = (IDeliveryModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDeliveryModifierProperty.class);
/* 1243 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IDeliveryModifierProperty> getProperties() {
/* 1252 */     if (this._properties == null) {
/* 1253 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1255 */     return (List<IDeliveryModifierProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IDeliveryModifierProperty> argProperties) {
/* 1259 */     if (this._properties == null) {
/* 1260 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1262 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1265 */     for (IDeliveryModifierProperty child : this._properties) {
/* 1266 */       DeliveryModifierPropertyModel model = (DeliveryModifierPropertyModel)child;
/* 1267 */       model.setOrganizationId_noev(getOrganizationId());
/* 1268 */       model.setCustAccountId_noev(getCustAccountId());
/* 1269 */       model.setCustAccountCode_noev(getCustAccountCode());
/* 1270 */       if (child instanceof IDataModelImpl) {
/* 1271 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1272 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1273 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1274 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1277 */       if (postEventsForChanges()) {
/* 1278 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addDeliveryModifierProperty(IDeliveryModifierProperty argDeliveryModifierProperty) {
/* 1284 */     if (this._properties == null) {
/* 1285 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1287 */     argDeliveryModifierProperty.setOrganizationId(getOrganizationId());
/* 1288 */     argDeliveryModifierProperty.setCustAccountId(getCustAccountId());
/* 1289 */     argDeliveryModifierProperty.setCustAccountCode(getCustAccountCode());
/* 1290 */     if (argDeliveryModifierProperty instanceof IDataModelImpl) {
/* 1291 */       IDataAccessObject childDao = ((IDataModelImpl)argDeliveryModifierProperty).getDAO();
/* 1292 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1293 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1294 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1299 */     if (postEventsForChanges()) {
/* 1300 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDeliveryModifierProperty));
/*      */     }
/*      */     
/* 1303 */     this._properties.add(argDeliveryModifierProperty);
/* 1304 */     if (postEventsForChanges()) {
/* 1305 */       this._events.post(IDeliveryModifier.ADD_PROPERTIES, argDeliveryModifierProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeDeliveryModifierProperty(IDeliveryModifierProperty argDeliveryModifierProperty) {
/* 1310 */     if (this._properties != null) {
/*      */       
/* 1312 */       if (postEventsForChanges()) {
/* 1313 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDeliveryModifierProperty));
/*      */       }
/* 1315 */       this._properties.remove(argDeliveryModifierProperty);
/* 1316 */       if (postEventsForChanges()) {
/* 1317 */         this._events.post(IDeliveryModifier.REMOVE_PROPERTIES, argDeliveryModifierProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1324 */     if ("Properties".equals(argFieldId)) {
/* 1325 */       return getProperties();
/*      */     }
/* 1327 */     if ("DeliveryModifierExtension".equals(argFieldId)) {
/* 1328 */       return this._myExtension;
/*      */     }
/*      */     
/* 1331 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1337 */     if ("Properties".equals(argFieldId)) {
/* 1338 */       setProperties(changeToList(argValue, IDeliveryModifierProperty.class));
/*      */     }
/* 1340 */     else if ("DeliveryModifierExtension".equals(argFieldId)) {
/* 1341 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1344 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1350 */     this._persistenceDefaults = argPD;
/* 1351 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1352 */     this._eventManager = argEM;
/* 1353 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1354 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1355 */     if (this._properties != null) {
/* 1356 */       for (IDeliveryModifierProperty relationship : this._properties) {
/* 1357 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getDeliveryModifierExt() {
/* 1363 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setDeliveryModifierExt(IDataModel argExt) {
/* 1367 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1372 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1376 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1379 */     super.startTransaction();
/*      */     
/* 1381 */     this._propertiesSavepoint = this._properties;
/* 1382 */     if (this._properties != null) {
/* 1383 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1384 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1385 */       while (it.hasNext()) {
/* 1386 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1391 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1396 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1399 */     super.rollbackChanges();
/*      */     
/* 1401 */     this._properties = this._propertiesSavepoint;
/* 1402 */     this._propertiesSavepoint = null;
/* 1403 */     if (this._properties != null) {
/* 1404 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1405 */       while (it.hasNext()) {
/* 1406 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1414 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1417 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1420 */     super.commitTransaction();
/*      */     
/* 1422 */     this._propertiesSavepoint = this._properties;
/* 1423 */     if (this._properties != null) {
/* 1424 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1425 */       while (it.hasNext()) {
/* 1426 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1428 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1432 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\DeliveryModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */