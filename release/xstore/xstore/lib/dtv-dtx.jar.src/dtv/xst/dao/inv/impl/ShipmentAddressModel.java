/*      */ package dtv.xst.dao.inv.impl;
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
/*      */ import dtv.xst.dao.inv.IShipmentAddress;
/*      */ import dtv.xst.dao.inv.IShipmentAddressProperty;
/*      */ import dtv.xst.dao.inv.ShipmentAddressPropertyId;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class ShipmentAddressModel extends AbstractDataModelWithPropertyImpl<IShipmentAddressProperty> implements IShipmentAddress {
/*      */   private static final long serialVersionUID = -1035118374L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   
/*      */   public String toString() {
/*   33 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IDataModel _myExtension; private HistoricalList<IShipmentAddressProperty> _properties; private transient HistoricalList<IShipmentAddressProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   38 */     setDAO((IDataAccessObject)new ShipmentAddressDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ShipmentAddressDAO getDAO_() {
/*   46 */     return (ShipmentAddressDAO)this._daoImpl;
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
/*   70 */       this._events.post(IShipmentAddress.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*   85 */         Iterator<ShipmentAddressPropertyModel> it = this._properties.iterator();
/*   86 */         while (it.hasNext())
/*      */         {
/*   88 */           ((ShipmentAddressPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*      */   public long getRetailLocationId() {
/*  101 */     if (getDAO_().getRetailLocationId() != null) {
/*  102 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  105 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  114 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  115 */       this._events != null && 
/*  116 */       postEventsForChanges()) {
/*  117 */       this._events.post(IShipmentAddress.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  124 */     boolean ev_postable = false;
/*      */     
/*  126 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  127 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  128 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  129 */       ev_postable = true;
/*  130 */       if (this._properties != null) {
/*      */         
/*  132 */         Iterator<ShipmentAddressPropertyModel> it = this._properties.iterator();
/*  133 */         while (it.hasNext())
/*      */         {
/*  135 */           ((ShipmentAddressPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  140 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDocumentId() {
/*  148 */     return getDAO_().getDocumentId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDocumentId(String argDocumentId) {
/*  156 */     if (setDocumentId_noev(argDocumentId) && 
/*  157 */       this._events != null && 
/*  158 */       postEventsForChanges()) {
/*  159 */       this._events.post(IShipmentAddress.SET_DOCUMENTID, argDocumentId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDocumentId_noev(String argDocumentId) {
/*  166 */     boolean ev_postable = false;
/*      */     
/*  168 */     if ((getDAO_().getDocumentId() == null && argDocumentId != null) || (
/*  169 */       getDAO_().getDocumentId() != null && !getDAO_().getDocumentId().equals(argDocumentId))) {
/*  170 */       getDAO_().setDocumentId(argDocumentId);
/*  171 */       ev_postable = true;
/*  172 */       if (this._properties != null) {
/*      */         
/*  174 */         Iterator<ShipmentAddressPropertyModel> it = this._properties.iterator();
/*  175 */         while (it.hasNext())
/*      */         {
/*  177 */           ((ShipmentAddressPropertyModel)it.next()).setDocumentId_noev(argDocumentId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  182 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDocumentTypeCode() {
/*  190 */     return getDAO_().getDocumentTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  198 */     if (setDocumentTypeCode_noev(argDocumentTypeCode) && 
/*  199 */       this._events != null && 
/*  200 */       postEventsForChanges()) {
/*  201 */       this._events.post(IShipmentAddress.SET_DOCUMENTTYPECODE, argDocumentTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDocumentTypeCode_noev(String argDocumentTypeCode) {
/*  208 */     boolean ev_postable = false;
/*      */     
/*  210 */     if ((getDAO_().getDocumentTypeCode() == null && argDocumentTypeCode != null) || (
/*  211 */       getDAO_().getDocumentTypeCode() != null && !getDAO_().getDocumentTypeCode().equals(argDocumentTypeCode))) {
/*  212 */       getDAO_().setDocumentTypeCode(argDocumentTypeCode);
/*  213 */       ev_postable = true;
/*  214 */       if (this._properties != null) {
/*      */         
/*  216 */         Iterator<ShipmentAddressPropertyModel> it = this._properties.iterator();
/*  217 */         while (it.hasNext())
/*      */         {
/*  219 */           ((ShipmentAddressPropertyModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  224 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getShipmentSequence() {
/*  232 */     if (getDAO_().getShipmentSequence() != null) {
/*  233 */       return getDAO_().getShipmentSequence().intValue();
/*      */     }
/*      */     
/*  236 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShipmentSequence(int argShipmentSequence) {
/*  245 */     if (setShipmentSequence_noev(argShipmentSequence) && 
/*  246 */       this._events != null && 
/*  247 */       postEventsForChanges()) {
/*  248 */       this._events.post(IShipmentAddress.SET_SHIPMENTSEQUENCE, Integer.valueOf(argShipmentSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setShipmentSequence_noev(int argShipmentSequence) {
/*  255 */     boolean ev_postable = false;
/*      */     
/*  257 */     if ((getDAO_().getShipmentSequence() == null && Integer.valueOf(argShipmentSequence) != null) || (
/*  258 */       getDAO_().getShipmentSequence() != null && !getDAO_().getShipmentSequence().equals(Integer.valueOf(argShipmentSequence)))) {
/*  259 */       getDAO_().setShipmentSequence(Integer.valueOf(argShipmentSequence));
/*  260 */       ev_postable = true;
/*  261 */       if (this._properties != null) {
/*      */         
/*  263 */         Iterator<ShipmentAddressPropertyModel> it = this._properties.iterator();
/*  264 */         while (it.hasNext())
/*      */         {
/*  266 */           ((ShipmentAddressPropertyModel)it.next()).setShipmentSequence_noev(argShipmentSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  271 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  279 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  287 */     if (setCreateDate_noev(argCreateDate) && 
/*  288 */       this._events != null && 
/*  289 */       postEventsForChanges()) {
/*  290 */       this._events.post(IShipmentAddress.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  297 */     boolean ev_postable = false;
/*      */     
/*  299 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  300 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  301 */       getDAO_().setCreateDate(argCreateDate);
/*  302 */       ev_postable = true;
/*      */     } 
/*      */     
/*  305 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  313 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  321 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  322 */       this._events != null && 
/*  323 */       postEventsForChanges()) {
/*  324 */       this._events.post(IShipmentAddress.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  331 */     boolean ev_postable = false;
/*      */     
/*  333 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  334 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  335 */       getDAO_().setCreateUserId(argCreateUserId);
/*  336 */       ev_postable = true;
/*      */     } 
/*      */     
/*  339 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  347 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  355 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  356 */       this._events != null && 
/*  357 */       postEventsForChanges()) {
/*  358 */       this._events.post(IShipmentAddress.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  365 */     boolean ev_postable = false;
/*      */     
/*  367 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  368 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  369 */       getDAO_().setUpdateDate(argUpdateDate);
/*  370 */       ev_postable = true;
/*      */     } 
/*      */     
/*  373 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  381 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  389 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  390 */       this._events != null && 
/*  391 */       postEventsForChanges()) {
/*  392 */       this._events.post(IShipmentAddress.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  399 */     boolean ev_postable = false;
/*      */     
/*  401 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  402 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  403 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  404 */       ev_postable = true;
/*      */     } 
/*      */     
/*  407 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAddress1() {
/*  415 */     return getDAO_().getAddress1();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddress1(String argAddress1) {
/*  423 */     if (setAddress1_noev(argAddress1) && 
/*  424 */       this._events != null && 
/*  425 */       postEventsForChanges()) {
/*  426 */       this._events.post(IShipmentAddress.SET_ADDRESS1, argAddress1);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddress1_noev(String argAddress1) {
/*  433 */     boolean ev_postable = false;
/*      */     
/*  435 */     if ((getDAO_().getAddress1() == null && argAddress1 != null) || (
/*  436 */       getDAO_().getAddress1() != null && !getDAO_().getAddress1().equals(argAddress1))) {
/*  437 */       getDAO_().setAddress1(argAddress1);
/*  438 */       ev_postable = true;
/*      */     } 
/*      */     
/*  441 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAddress2() {
/*  449 */     return getDAO_().getAddress2();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddress2(String argAddress2) {
/*  457 */     if (setAddress2_noev(argAddress2) && 
/*  458 */       this._events != null && 
/*  459 */       postEventsForChanges()) {
/*  460 */       this._events.post(IShipmentAddress.SET_ADDRESS2, argAddress2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddress2_noev(String argAddress2) {
/*  467 */     boolean ev_postable = false;
/*      */     
/*  469 */     if ((getDAO_().getAddress2() == null && argAddress2 != null) || (
/*  470 */       getDAO_().getAddress2() != null && !getDAO_().getAddress2().equals(argAddress2))) {
/*  471 */       getDAO_().setAddress2(argAddress2);
/*  472 */       ev_postable = true;
/*      */     } 
/*      */     
/*  475 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAddress3() {
/*  483 */     return getDAO_().getAddress3();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddress3(String argAddress3) {
/*  491 */     if (setAddress3_noev(argAddress3) && 
/*  492 */       this._events != null && 
/*  493 */       postEventsForChanges()) {
/*  494 */       this._events.post(IShipmentAddress.SET_ADDRESS3, argAddress3);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddress3_noev(String argAddress3) {
/*  501 */     boolean ev_postable = false;
/*      */     
/*  503 */     if ((getDAO_().getAddress3() == null && argAddress3 != null) || (
/*  504 */       getDAO_().getAddress3() != null && !getDAO_().getAddress3().equals(argAddress3))) {
/*  505 */       getDAO_().setAddress3(argAddress3);
/*  506 */       ev_postable = true;
/*      */     } 
/*      */     
/*  509 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAddress4() {
/*  517 */     return getDAO_().getAddress4();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddress4(String argAddress4) {
/*  525 */     if (setAddress4_noev(argAddress4) && 
/*  526 */       this._events != null && 
/*  527 */       postEventsForChanges()) {
/*  528 */       this._events.post(IShipmentAddress.SET_ADDRESS4, argAddress4);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddress4_noev(String argAddress4) {
/*  535 */     boolean ev_postable = false;
/*      */     
/*  537 */     if ((getDAO_().getAddress4() == null && argAddress4 != null) || (
/*  538 */       getDAO_().getAddress4() != null && !getDAO_().getAddress4().equals(argAddress4))) {
/*  539 */       getDAO_().setAddress4(argAddress4);
/*  540 */       ev_postable = true;
/*      */     } 
/*      */     
/*  543 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getApartment() {
/*  551 */     return getDAO_().getApartment();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setApartment(String argApartment) {
/*  559 */     if (setApartment_noev(argApartment) && 
/*  560 */       this._events != null && 
/*  561 */       postEventsForChanges()) {
/*  562 */       this._events.post(IShipmentAddress.SET_APARTMENT, argApartment);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setApartment_noev(String argApartment) {
/*  569 */     boolean ev_postable = false;
/*      */     
/*  571 */     if ((getDAO_().getApartment() == null && argApartment != null) || (
/*  572 */       getDAO_().getApartment() != null && !getDAO_().getApartment().equals(argApartment))) {
/*  573 */       getDAO_().setApartment(argApartment);
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
/*      */   public String getCity() {
/*  585 */     return getDAO_().getCity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCity(String argCity) {
/*  593 */     if (setCity_noev(argCity) && 
/*  594 */       this._events != null && 
/*  595 */       postEventsForChanges()) {
/*  596 */       this._events.post(IShipmentAddress.SET_CITY, argCity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCity_noev(String argCity) {
/*  603 */     boolean ev_postable = false;
/*      */     
/*  605 */     if ((getDAO_().getCity() == null && argCity != null) || (
/*  606 */       getDAO_().getCity() != null && !getDAO_().getCity().equals(argCity))) {
/*  607 */       getDAO_().setCity(argCity);
/*  608 */       ev_postable = true;
/*      */     } 
/*      */     
/*  611 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getState() {
/*  619 */     return getDAO_().getState();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setState(String argState) {
/*  627 */     if (setState_noev(argState) && 
/*  628 */       this._events != null && 
/*  629 */       postEventsForChanges()) {
/*  630 */       this._events.post(IShipmentAddress.SET_STATE, argState);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setState_noev(String argState) {
/*  637 */     boolean ev_postable = false;
/*      */     
/*  639 */     if ((getDAO_().getState() == null && argState != null) || (
/*  640 */       getDAO_().getState() != null && !getDAO_().getState().equals(argState))) {
/*  641 */       getDAO_().setState(argState);
/*  642 */       ev_postable = true;
/*      */     } 
/*      */     
/*  645 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPostalCode() {
/*  653 */     return getDAO_().getPostalCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPostalCode(String argPostalCode) {
/*  661 */     if (setPostalCode_noev(argPostalCode) && 
/*  662 */       this._events != null && 
/*  663 */       postEventsForChanges()) {
/*  664 */       this._events.post(IShipmentAddress.SET_POSTALCODE, argPostalCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPostalCode_noev(String argPostalCode) {
/*  671 */     boolean ev_postable = false;
/*      */     
/*  673 */     if ((getDAO_().getPostalCode() == null && argPostalCode != null) || (
/*  674 */       getDAO_().getPostalCode() != null && !getDAO_().getPostalCode().equals(argPostalCode))) {
/*  675 */       getDAO_().setPostalCode(argPostalCode);
/*  676 */       ev_postable = true;
/*      */     } 
/*      */     
/*  679 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCountry() {
/*  687 */     return getDAO_().getCountry();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCountry(String argCountry) {
/*  695 */     if (setCountry_noev(argCountry) && 
/*  696 */       this._events != null && 
/*  697 */       postEventsForChanges()) {
/*  698 */       this._events.post(IShipmentAddress.SET_COUNTRY, argCountry);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCountry_noev(String argCountry) {
/*  705 */     boolean ev_postable = false;
/*      */     
/*  707 */     if ((getDAO_().getCountry() == null && argCountry != null) || (
/*  708 */       getDAO_().getCountry() != null && !getDAO_().getCountry().equals(argCountry))) {
/*  709 */       getDAO_().setCountry(argCountry);
/*  710 */       ev_postable = true;
/*      */     } 
/*      */     
/*  713 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTelephone1() {
/*  721 */     return getDAO_().getTelephone1();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTelephone1(String argTelephone1) {
/*  729 */     if (setTelephone1_noev(argTelephone1) && 
/*  730 */       this._events != null && 
/*  731 */       postEventsForChanges()) {
/*  732 */       this._events.post(IShipmentAddress.SET_TELEPHONE1, argTelephone1);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTelephone1_noev(String argTelephone1) {
/*  739 */     boolean ev_postable = false;
/*      */     
/*  741 */     if ((getDAO_().getTelephone1() == null && argTelephone1 != null) || (
/*  742 */       getDAO_().getTelephone1() != null && !getDAO_().getTelephone1().equals(argTelephone1))) {
/*  743 */       getDAO_().setTelephone1(argTelephone1);
/*  744 */       ev_postable = true;
/*      */     } 
/*      */     
/*  747 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTelephone2() {
/*  755 */     return getDAO_().getTelephone2();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTelephone2(String argTelephone2) {
/*  763 */     if (setTelephone2_noev(argTelephone2) && 
/*  764 */       this._events != null && 
/*  765 */       postEventsForChanges()) {
/*  766 */       this._events.post(IShipmentAddress.SET_TELEPHONE2, argTelephone2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTelephone2_noev(String argTelephone2) {
/*  773 */     boolean ev_postable = false;
/*      */     
/*  775 */     if ((getDAO_().getTelephone2() == null && argTelephone2 != null) || (
/*  776 */       getDAO_().getTelephone2() != null && !getDAO_().getTelephone2().equals(argTelephone2))) {
/*  777 */       getDAO_().setTelephone2(argTelephone2);
/*  778 */       ev_postable = true;
/*      */     } 
/*      */     
/*  781 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTelephone3() {
/*  789 */     return getDAO_().getTelephone3();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTelephone3(String argTelephone3) {
/*  797 */     if (setTelephone3_noev(argTelephone3) && 
/*  798 */       this._events != null && 
/*  799 */       postEventsForChanges()) {
/*  800 */       this._events.post(IShipmentAddress.SET_TELEPHONE3, argTelephone3);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTelephone3_noev(String argTelephone3) {
/*  807 */     boolean ev_postable = false;
/*      */     
/*  809 */     if ((getDAO_().getTelephone3() == null && argTelephone3 != null) || (
/*  810 */       getDAO_().getTelephone3() != null && !getDAO_().getTelephone3().equals(argTelephone3))) {
/*  811 */       getDAO_().setTelephone3(argTelephone3);
/*  812 */       ev_postable = true;
/*      */     } 
/*      */     
/*  815 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTelephone4() {
/*  823 */     return getDAO_().getTelephone4();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTelephone4(String argTelephone4) {
/*  831 */     if (setTelephone4_noev(argTelephone4) && 
/*  832 */       this._events != null && 
/*  833 */       postEventsForChanges()) {
/*  834 */       this._events.post(IShipmentAddress.SET_TELEPHONE4, argTelephone4);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTelephone4_noev(String argTelephone4) {
/*  841 */     boolean ev_postable = false;
/*      */     
/*  843 */     if ((getDAO_().getTelephone4() == null && argTelephone4 != null) || (
/*  844 */       getDAO_().getTelephone4() != null && !getDAO_().getTelephone4().equals(argTelephone4))) {
/*  845 */       getDAO_().setTelephone4(argTelephone4);
/*  846 */       ev_postable = true;
/*      */     } 
/*      */     
/*  849 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNeighborhood() {
/*  857 */     return getDAO_().getNeighborhood();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNeighborhood(String argNeighborhood) {
/*  865 */     if (setNeighborhood_noev(argNeighborhood) && 
/*  866 */       this._events != null && 
/*  867 */       postEventsForChanges()) {
/*  868 */       this._events.post(IShipmentAddress.SET_NEIGHBORHOOD, argNeighborhood);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNeighborhood_noev(String argNeighborhood) {
/*  875 */     boolean ev_postable = false;
/*      */     
/*  877 */     if ((getDAO_().getNeighborhood() == null && argNeighborhood != null) || (
/*  878 */       getDAO_().getNeighborhood() != null && !getDAO_().getNeighborhood().equals(argNeighborhood))) {
/*  879 */       getDAO_().setNeighborhood(argNeighborhood);
/*  880 */       ev_postable = true;
/*      */     } 
/*      */     
/*  883 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCounty() {
/*  891 */     return getDAO_().getCounty();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCounty(String argCounty) {
/*  899 */     if (setCounty_noev(argCounty) && 
/*  900 */       this._events != null && 
/*  901 */       postEventsForChanges()) {
/*  902 */       this._events.post(IShipmentAddress.SET_COUNTY, argCounty);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCounty_noev(String argCounty) {
/*  909 */     boolean ev_postable = false;
/*      */     
/*  911 */     if ((getDAO_().getCounty() == null && argCounty != null) || (
/*  912 */       getDAO_().getCounty() != null && !getDAO_().getCounty().equals(argCounty))) {
/*  913 */       getDAO_().setCounty(argCounty);
/*  914 */       ev_postable = true;
/*      */     } 
/*      */     
/*  917 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IShipmentAddressProperty newProperty(String argPropertyName) {
/*  921 */     ShipmentAddressPropertyId id = new ShipmentAddressPropertyId();
/*      */     
/*  923 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  924 */     id.setDocumentId(getDocumentId());
/*  925 */     id.setDocumentTypeCode(getDocumentTypeCode());
/*  926 */     id.setShipmentSequence(Integer.valueOf(getShipmentSequence()));
/*  927 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  929 */     IShipmentAddressProperty prop = (IShipmentAddressProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IShipmentAddressProperty.class);
/*  930 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IShipmentAddressProperty> getProperties() {
/*  939 */     if (this._properties == null) {
/*  940 */       this._properties = new HistoricalList(null);
/*      */     }
/*  942 */     return (List<IShipmentAddressProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IShipmentAddressProperty> argProperties) {
/*  946 */     if (this._properties == null) {
/*  947 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  949 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  952 */     for (IShipmentAddressProperty child : this._properties) {
/*  953 */       ShipmentAddressPropertyModel model = (ShipmentAddressPropertyModel)child;
/*  954 */       model.setOrganizationId_noev(getOrganizationId());
/*  955 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  956 */       model.setDocumentId_noev(getDocumentId());
/*  957 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/*  958 */       model.setShipmentSequence_noev(getShipmentSequence());
/*  959 */       if (child instanceof IDataModelImpl) {
/*  960 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  961 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  962 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  963 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  966 */       if (postEventsForChanges()) {
/*  967 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addShipmentAddressProperty(IShipmentAddressProperty argShipmentAddressProperty) {
/*  973 */     if (this._properties == null) {
/*  974 */       this._properties = new HistoricalList(null);
/*      */     }
/*  976 */     argShipmentAddressProperty.setOrganizationId(getOrganizationId());
/*  977 */     argShipmentAddressProperty.setRetailLocationId(getRetailLocationId());
/*  978 */     argShipmentAddressProperty.setDocumentId(getDocumentId());
/*  979 */     argShipmentAddressProperty.setDocumentTypeCode(getDocumentTypeCode());
/*  980 */     argShipmentAddressProperty.setShipmentSequence(getShipmentSequence());
/*  981 */     if (argShipmentAddressProperty instanceof IDataModelImpl) {
/*  982 */       IDataAccessObject childDao = ((IDataModelImpl)argShipmentAddressProperty).getDAO();
/*  983 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  984 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  985 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  990 */     if (postEventsForChanges()) {
/*  991 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShipmentAddressProperty));
/*      */     }
/*      */     
/*  994 */     this._properties.add(argShipmentAddressProperty);
/*  995 */     if (postEventsForChanges()) {
/*  996 */       this._events.post(IShipmentAddress.ADD_PROPERTIES, argShipmentAddressProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeShipmentAddressProperty(IShipmentAddressProperty argShipmentAddressProperty) {
/* 1001 */     if (this._properties != null) {
/*      */       
/* 1003 */       if (postEventsForChanges()) {
/* 1004 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShipmentAddressProperty));
/*      */       }
/* 1006 */       this._properties.remove(argShipmentAddressProperty);
/* 1007 */       if (postEventsForChanges()) {
/* 1008 */         this._events.post(IShipmentAddress.REMOVE_PROPERTIES, argShipmentAddressProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1015 */     if ("Properties".equals(argFieldId)) {
/* 1016 */       return getProperties();
/*      */     }
/* 1018 */     if ("ShipmentAddressExtension".equals(argFieldId)) {
/* 1019 */       return this._myExtension;
/*      */     }
/*      */     
/* 1022 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1028 */     if ("Properties".equals(argFieldId)) {
/* 1029 */       setProperties(changeToList(argValue, IShipmentAddressProperty.class));
/*      */     }
/* 1031 */     else if ("ShipmentAddressExtension".equals(argFieldId)) {
/* 1032 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1035 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1041 */     this._persistenceDefaults = argPD;
/* 1042 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1043 */     this._eventManager = argEM;
/* 1044 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1045 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1046 */     if (this._properties != null) {
/* 1047 */       for (IShipmentAddressProperty relationship : this._properties) {
/* 1048 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getShipmentAddressExt() {
/* 1054 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setShipmentAddressExt(IDataModel argExt) {
/* 1058 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1063 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1067 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1070 */     super.startTransaction();
/*      */     
/* 1072 */     this._propertiesSavepoint = this._properties;
/* 1073 */     if (this._properties != null) {
/* 1074 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1075 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1076 */       while (it.hasNext()) {
/* 1077 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1082 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1087 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1090 */     super.rollbackChanges();
/*      */     
/* 1092 */     this._properties = this._propertiesSavepoint;
/* 1093 */     this._propertiesSavepoint = null;
/* 1094 */     if (this._properties != null) {
/* 1095 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1096 */       while (it.hasNext()) {
/* 1097 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1105 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1108 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1111 */     super.commitTransaction();
/*      */     
/* 1113 */     this._propertiesSavepoint = this._properties;
/* 1114 */     if (this._properties != null) {
/* 1115 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1116 */       while (it.hasNext()) {
/* 1117 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1119 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1123 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1128 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipmentAddressModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */