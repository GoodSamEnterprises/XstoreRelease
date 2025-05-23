/*      */ package dtv.xst.dao.crm.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
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
/*      */ import dtv.xst.dao.crm.IParty;
/*      */ import dtv.xst.dao.crm.IPartyLocaleInformation;
/*      */ import dtv.xst.dao.crm.IPartyLocaleInformationProperty;
/*      */ import dtv.xst.dao.crm.PartyLocaleInformationPropertyId;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class PartyLocaleInformationModel extends AbstractDataModelWithPropertyImpl<IPartyLocaleInformationProperty> implements IPartyLocaleInformation {
/*      */   private static final long serialVersionUID = -1499026356L;
/*      */   private IParty _parentParty;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   
/*      */   public String toString() {
/*   35 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IPartyLocaleInformationProperty> _properties; private transient HistoricalList<IPartyLocaleInformationProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   40 */     setDAO((IDataAccessObject)new PartyLocaleInformationDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private PartyLocaleInformationDAO getDAO_() {
/*   48 */     return (PartyLocaleInformationDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   56 */     if (getDAO_().getOrganizationId() != null) {
/*   57 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   60 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   69 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   70 */       this._events != null && 
/*   71 */       postEventsForChanges()) {
/*   72 */       this._events.post(IPartyLocaleInformation.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   79 */     boolean ev_postable = false;
/*      */     
/*   81 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   82 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   83 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   84 */       ev_postable = true;
/*   85 */       if (this._properties != null) {
/*      */         
/*   87 */         Iterator<PartyLocaleInformationPropertyModel> it = this._properties.iterator();
/*   88 */         while (it.hasNext())
/*      */         {
/*   90 */           ((PartyLocaleInformationPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   95 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getPartyId() {
/*  103 */     if (getDAO_().getPartyId() != null) {
/*  104 */       return getDAO_().getPartyId().longValue();
/*      */     }
/*      */     
/*  107 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPartyId(long argPartyId) {
/*  116 */     if (setPartyId_noev(argPartyId) && 
/*  117 */       this._events != null && 
/*  118 */       postEventsForChanges()) {
/*  119 */       this._events.post(IPartyLocaleInformation.SET_PARTYID, Long.valueOf(argPartyId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPartyId_noev(long argPartyId) {
/*  126 */     boolean ev_postable = false;
/*      */     
/*  128 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/*  129 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/*  130 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/*  131 */       ev_postable = true;
/*  132 */       if (this._properties != null) {
/*      */         
/*  134 */         Iterator<PartyLocaleInformationPropertyModel> it = this._properties.iterator();
/*  135 */         while (it.hasNext())
/*      */         {
/*  137 */           ((PartyLocaleInformationPropertyModel)it.next()).setPartyId_noev(argPartyId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  142 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSequence() {
/*  150 */     if (getDAO_().getSequence() != null) {
/*  151 */       return getDAO_().getSequence().intValue();
/*      */     }
/*      */     
/*  154 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSequence(int argSequence) {
/*  163 */     if (setSequence_noev(argSequence) && 
/*  164 */       this._events != null && 
/*  165 */       postEventsForChanges()) {
/*  166 */       this._events.post(IPartyLocaleInformation.SET_SEQUENCE, Integer.valueOf(argSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSequence_noev(int argSequence) {
/*  173 */     boolean ev_postable = false;
/*      */     
/*  175 */     if ((getDAO_().getSequence() == null && Integer.valueOf(argSequence) != null) || (
/*  176 */       getDAO_().getSequence() != null && !getDAO_().getSequence().equals(Integer.valueOf(argSequence)))) {
/*  177 */       getDAO_().setSequence(Integer.valueOf(argSequence));
/*  178 */       ev_postable = true;
/*  179 */       if (this._properties != null) {
/*      */         
/*  181 */         Iterator<PartyLocaleInformationPropertyModel> it = this._properties.iterator();
/*  182 */         while (it.hasNext())
/*      */         {
/*  184 */           ((PartyLocaleInformationPropertyModel)it.next()).setSequence_noev(argSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  189 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  197 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  205 */     if (setCreateDate_noev(argCreateDate) && 
/*  206 */       this._events != null && 
/*  207 */       postEventsForChanges()) {
/*  208 */       this._events.post(IPartyLocaleInformation.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  215 */     boolean ev_postable = false;
/*      */     
/*  217 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  218 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  219 */       getDAO_().setCreateDate(argCreateDate);
/*  220 */       ev_postable = true;
/*      */     } 
/*      */     
/*  223 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  231 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  239 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  240 */       this._events != null && 
/*  241 */       postEventsForChanges()) {
/*  242 */       this._events.post(IPartyLocaleInformation.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  249 */     boolean ev_postable = false;
/*      */     
/*  251 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  252 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  253 */       getDAO_().setCreateUserId(argCreateUserId);
/*  254 */       ev_postable = true;
/*      */     } 
/*      */     
/*  257 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  265 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  273 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  274 */       this._events != null && 
/*  275 */       postEventsForChanges()) {
/*  276 */       this._events.post(IPartyLocaleInformation.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  283 */     boolean ev_postable = false;
/*      */     
/*  285 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  286 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  287 */       getDAO_().setUpdateDate(argUpdateDate);
/*  288 */       ev_postable = true;
/*      */     } 
/*      */     
/*  291 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  299 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  307 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  308 */       this._events != null && 
/*  309 */       postEventsForChanges()) {
/*  310 */       this._events.post(IPartyLocaleInformation.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  317 */     boolean ev_postable = false;
/*      */     
/*  319 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  320 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  321 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  322 */       ev_postable = true;
/*      */     } 
/*      */     
/*  325 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAddress1() {
/*  333 */     return getDAO_().getAddress1();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddress1(String argAddress1) {
/*  341 */     if (setAddress1_noev(argAddress1) && 
/*  342 */       this._events != null && 
/*  343 */       postEventsForChanges()) {
/*  344 */       this._events.post(IPartyLocaleInformation.SET_ADDRESS1, argAddress1);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddress1_noev(String argAddress1) {
/*  351 */     boolean ev_postable = false;
/*      */     
/*  353 */     if ((getDAO_().getAddress1() == null && argAddress1 != null) || (
/*  354 */       getDAO_().getAddress1() != null && !getDAO_().getAddress1().equals(argAddress1))) {
/*  355 */       getDAO_().setAddress1(argAddress1);
/*  356 */       ev_postable = true;
/*      */     } 
/*      */     
/*  359 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAddress2() {
/*  367 */     return getDAO_().getAddress2();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddress2(String argAddress2) {
/*  375 */     if (setAddress2_noev(argAddress2) && 
/*  376 */       this._events != null && 
/*  377 */       postEventsForChanges()) {
/*  378 */       this._events.post(IPartyLocaleInformation.SET_ADDRESS2, argAddress2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddress2_noev(String argAddress2) {
/*  385 */     boolean ev_postable = false;
/*      */     
/*  387 */     if ((getDAO_().getAddress2() == null && argAddress2 != null) || (
/*  388 */       getDAO_().getAddress2() != null && !getDAO_().getAddress2().equals(argAddress2))) {
/*  389 */       getDAO_().setAddress2(argAddress2);
/*  390 */       ev_postable = true;
/*      */     } 
/*      */     
/*  393 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAddress3() {
/*  401 */     return getDAO_().getAddress3();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddress3(String argAddress3) {
/*  409 */     if (setAddress3_noev(argAddress3) && 
/*  410 */       this._events != null && 
/*  411 */       postEventsForChanges()) {
/*  412 */       this._events.post(IPartyLocaleInformation.SET_ADDRESS3, argAddress3);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddress3_noev(String argAddress3) {
/*  419 */     boolean ev_postable = false;
/*      */     
/*  421 */     if ((getDAO_().getAddress3() == null && argAddress3 != null) || (
/*  422 */       getDAO_().getAddress3() != null && !getDAO_().getAddress3().equals(argAddress3))) {
/*  423 */       getDAO_().setAddress3(argAddress3);
/*  424 */       ev_postable = true;
/*      */     } 
/*      */     
/*  427 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAddress4() {
/*  435 */     return getDAO_().getAddress4();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddress4(String argAddress4) {
/*  443 */     if (setAddress4_noev(argAddress4) && 
/*  444 */       this._events != null && 
/*  445 */       postEventsForChanges()) {
/*  446 */       this._events.post(IPartyLocaleInformation.SET_ADDRESS4, argAddress4);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddress4_noev(String argAddress4) {
/*  453 */     boolean ev_postable = false;
/*      */     
/*  455 */     if ((getDAO_().getAddress4() == null && argAddress4 != null) || (
/*  456 */       getDAO_().getAddress4() != null && !getDAO_().getAddress4().equals(argAddress4))) {
/*  457 */       getDAO_().setAddress4(argAddress4);
/*  458 */       ev_postable = true;
/*      */     } 
/*      */     
/*  461 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getApartment() {
/*  469 */     return getDAO_().getApartment();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setApartment(String argApartment) {
/*  477 */     if (setApartment_noev(argApartment) && 
/*  478 */       this._events != null && 
/*  479 */       postEventsForChanges()) {
/*  480 */       this._events.post(IPartyLocaleInformation.SET_APARTMENT, argApartment);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setApartment_noev(String argApartment) {
/*  487 */     boolean ev_postable = false;
/*      */     
/*  489 */     if ((getDAO_().getApartment() == null && argApartment != null) || (
/*  490 */       getDAO_().getApartment() != null && !getDAO_().getApartment().equals(argApartment))) {
/*  491 */       getDAO_().setApartment(argApartment);
/*  492 */       ev_postable = true;
/*      */     } 
/*      */     
/*  495 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCity() {
/*  503 */     return getDAO_().getCity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCity(String argCity) {
/*  511 */     if (setCity_noev(argCity) && 
/*  512 */       this._events != null && 
/*  513 */       postEventsForChanges()) {
/*  514 */       this._events.post(IPartyLocaleInformation.SET_CITY, argCity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCity_noev(String argCity) {
/*  521 */     boolean ev_postable = false;
/*      */     
/*  523 */     if ((getDAO_().getCity() == null && argCity != null) || (
/*  524 */       getDAO_().getCity() != null && !getDAO_().getCity().equals(argCity))) {
/*  525 */       getDAO_().setCity(argCity);
/*  526 */       ev_postable = true;
/*      */     } 
/*      */     
/*  529 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCountry() {
/*  537 */     return getDAO_().getCountry();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCountry(String argCountry) {
/*  545 */     if (setCountry_noev(argCountry) && 
/*  546 */       this._events != null && 
/*  547 */       postEventsForChanges()) {
/*  548 */       this._events.post(IPartyLocaleInformation.SET_COUNTRY, argCountry);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCountry_noev(String argCountry) {
/*  555 */     boolean ev_postable = false;
/*      */     
/*  557 */     if ((getDAO_().getCountry() == null && argCountry != null) || (
/*  558 */       getDAO_().getCountry() != null && !getDAO_().getCountry().equals(argCountry))) {
/*  559 */       getDAO_().setCountry(argCountry);
/*  560 */       ev_postable = true;
/*      */     } 
/*      */     
/*  563 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPostalCode() {
/*  571 */     return getDAO_().getPostalCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPostalCode(String argPostalCode) {
/*  579 */     if (setPostalCode_noev(argPostalCode) && 
/*  580 */       this._events != null && 
/*  581 */       postEventsForChanges()) {
/*  582 */       this._events.post(IPartyLocaleInformation.SET_POSTALCODE, argPostalCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPostalCode_noev(String argPostalCode) {
/*  589 */     boolean ev_postable = false;
/*      */     
/*  591 */     if ((getDAO_().getPostalCode() == null && argPostalCode != null) || (
/*  592 */       getDAO_().getPostalCode() != null && !getDAO_().getPostalCode().equals(argPostalCode))) {
/*  593 */       getDAO_().setPostalCode(argPostalCode);
/*  594 */       ev_postable = true;
/*      */     } 
/*      */     
/*  597 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getState() {
/*  605 */     return getDAO_().getState();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setState(String argState) {
/*  613 */     if (setState_noev(argState) && 
/*  614 */       this._events != null && 
/*  615 */       postEventsForChanges()) {
/*  616 */       this._events.post(IPartyLocaleInformation.SET_STATE, argState);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setState_noev(String argState) {
/*  623 */     boolean ev_postable = false;
/*      */     
/*  625 */     if ((getDAO_().getState() == null && argState != null) || (
/*  626 */       getDAO_().getState() != null && !getDAO_().getState().equals(argState))) {
/*  627 */       getDAO_().setState(argState);
/*  628 */       ev_postable = true;
/*      */     } 
/*      */     
/*  631 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getContact() {
/*  639 */     if (getDAO_().getContact() != null) {
/*  640 */       return getDAO_().getContact().booleanValue();
/*      */     }
/*      */     
/*  643 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setContact(boolean argContact) {
/*  652 */     if (setContact_noev(argContact) && 
/*  653 */       this._events != null && 
/*  654 */       postEventsForChanges()) {
/*  655 */       this._events.post(IPartyLocaleInformation.SET_CONTACT, Boolean.valueOf(argContact));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setContact_noev(boolean argContact) {
/*  662 */     boolean ev_postable = false;
/*      */     
/*  664 */     if ((getDAO_().getContact() == null && Boolean.valueOf(argContact) != null) || (
/*  665 */       getDAO_().getContact() != null && !getDAO_().getContact().equals(Boolean.valueOf(argContact)))) {
/*  666 */       getDAO_().setContact(Boolean.valueOf(argContact));
/*  667 */       ev_postable = true;
/*      */     } 
/*      */     
/*  670 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getPrimary() {
/*  678 */     if (getDAO_().getPrimary() != null) {
/*  679 */       return getDAO_().getPrimary().booleanValue();
/*      */     }
/*      */     
/*  682 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPrimary(boolean argPrimary) {
/*  691 */     if (setPrimary_noev(argPrimary) && 
/*  692 */       this._events != null && 
/*  693 */       postEventsForChanges()) {
/*  694 */       this._events.post(IPartyLocaleInformation.SET_PRIMARY, Boolean.valueOf(argPrimary));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPrimary_noev(boolean argPrimary) {
/*  701 */     boolean ev_postable = false;
/*      */     
/*  703 */     if ((getDAO_().getPrimary() == null && Boolean.valueOf(argPrimary) != null) || (
/*  704 */       getDAO_().getPrimary() != null && !getDAO_().getPrimary().equals(Boolean.valueOf(argPrimary)))) {
/*  705 */       getDAO_().setPrimary(Boolean.valueOf(argPrimary));
/*  706 */       ev_postable = true;
/*      */     } 
/*      */     
/*  709 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAddressType() {
/*  717 */     return getDAO_().getAddressType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddressType(String argAddressType) {
/*  725 */     if (setAddressType_noev(argAddressType) && 
/*  726 */       this._events != null && 
/*  727 */       postEventsForChanges()) {
/*  728 */       this._events.post(IPartyLocaleInformation.SET_ADDRESSTYPE, argAddressType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddressType_noev(String argAddressType) {
/*  735 */     boolean ev_postable = false;
/*      */     
/*  737 */     if ((getDAO_().getAddressType() == null && argAddressType != null) || (
/*  738 */       getDAO_().getAddressType() != null && !getDAO_().getAddressType().equals(argAddressType))) {
/*  739 */       getDAO_().setAddressType(argAddressType);
/*  740 */       ev_postable = true;
/*      */     } 
/*      */     
/*  743 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNeighborhood() {
/*  751 */     return getDAO_().getNeighborhood();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNeighborhood(String argNeighborhood) {
/*  759 */     if (setNeighborhood_noev(argNeighborhood) && 
/*  760 */       this._events != null && 
/*  761 */       postEventsForChanges()) {
/*  762 */       this._events.post(IPartyLocaleInformation.SET_NEIGHBORHOOD, argNeighborhood);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNeighborhood_noev(String argNeighborhood) {
/*  769 */     boolean ev_postable = false;
/*      */     
/*  771 */     if ((getDAO_().getNeighborhood() == null && argNeighborhood != null) || (
/*  772 */       getDAO_().getNeighborhood() != null && !getDAO_().getNeighborhood().equals(argNeighborhood))) {
/*  773 */       getDAO_().setNeighborhood(argNeighborhood);
/*  774 */       ev_postable = true;
/*      */     } 
/*      */     
/*  777 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCounty() {
/*  785 */     return getDAO_().getCounty();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCounty(String argCounty) {
/*  793 */     if (setCounty_noev(argCounty) && 
/*  794 */       this._events != null && 
/*  795 */       postEventsForChanges()) {
/*  796 */       this._events.post(IPartyLocaleInformation.SET_COUNTY, argCounty);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCounty_noev(String argCounty) {
/*  803 */     boolean ev_postable = false;
/*      */     
/*  805 */     if ((getDAO_().getCounty() == null && argCounty != null) || (
/*  806 */       getDAO_().getCounty() != null && !getDAO_().getCounty().equals(argCounty))) {
/*  807 */       getDAO_().setCounty(argCounty);
/*  808 */       ev_postable = true;
/*      */     } 
/*      */     
/*  811 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IPartyLocaleInformationProperty newProperty(String argPropertyName) {
/*  815 */     PartyLocaleInformationPropertyId id = new PartyLocaleInformationPropertyId();
/*      */     
/*  817 */     id.setPartyId(Long.valueOf(getPartyId()));
/*  818 */     id.setSequence(Integer.valueOf(getSequence()));
/*  819 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  821 */     IPartyLocaleInformationProperty prop = (IPartyLocaleInformationProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IPartyLocaleInformationProperty.class);
/*  822 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IPartyLocaleInformationProperty> getProperties() {
/*  831 */     if (this._properties == null) {
/*  832 */       this._properties = new HistoricalList(null);
/*      */     }
/*  834 */     return (List<IPartyLocaleInformationProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IPartyLocaleInformationProperty> argProperties) {
/*  838 */     if (this._properties == null) {
/*  839 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  841 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  844 */     for (IPartyLocaleInformationProperty child : this._properties) {
/*  845 */       PartyLocaleInformationPropertyModel model = (PartyLocaleInformationPropertyModel)child;
/*  846 */       model.setOrganizationId_noev(getOrganizationId());
/*  847 */       model.setPartyId_noev(getPartyId());
/*  848 */       model.setSequence_noev(getSequence());
/*  849 */       if (child instanceof IDataModelImpl) {
/*  850 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  851 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  852 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  853 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  856 */       if (postEventsForChanges()) {
/*  857 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addPartyLocaleInformationProperty(IPartyLocaleInformationProperty argPartyLocaleInformationProperty) {
/*  863 */     if (this._properties == null) {
/*  864 */       this._properties = new HistoricalList(null);
/*      */     }
/*  866 */     argPartyLocaleInformationProperty.setOrganizationId(getOrganizationId());
/*  867 */     argPartyLocaleInformationProperty.setPartyId(getPartyId());
/*  868 */     argPartyLocaleInformationProperty.setSequence(getSequence());
/*  869 */     if (argPartyLocaleInformationProperty instanceof IDataModelImpl) {
/*  870 */       IDataAccessObject childDao = ((IDataModelImpl)argPartyLocaleInformationProperty).getDAO();
/*  871 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  872 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  873 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  878 */     if (postEventsForChanges()) {
/*  879 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyLocaleInformationProperty));
/*      */     }
/*      */     
/*  882 */     this._properties.add(argPartyLocaleInformationProperty);
/*  883 */     if (postEventsForChanges()) {
/*  884 */       this._events.post(IPartyLocaleInformation.ADD_PROPERTIES, argPartyLocaleInformationProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removePartyLocaleInformationProperty(IPartyLocaleInformationProperty argPartyLocaleInformationProperty) {
/*  889 */     if (this._properties != null) {
/*      */       
/*  891 */       if (postEventsForChanges()) {
/*  892 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyLocaleInformationProperty));
/*      */       }
/*  894 */       this._properties.remove(argPartyLocaleInformationProperty);
/*  895 */       if (postEventsForChanges()) {
/*  896 */         this._events.post(IPartyLocaleInformation.REMOVE_PROPERTIES, argPartyLocaleInformationProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentParty(IParty argParentParty) {
/*  902 */     this._parentParty = argParentParty;
/*      */   }
/*      */   
/*      */   public IParty getParentParty() {
/*  906 */     return this._parentParty;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  911 */     if ("Properties".equals(argFieldId)) {
/*  912 */       return getProperties();
/*      */     }
/*  914 */     if ("PartyLocaleInformationExtension".equals(argFieldId)) {
/*  915 */       return this._myExtension;
/*      */     }
/*      */     
/*  918 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  924 */     if ("Properties".equals(argFieldId)) {
/*  925 */       setProperties(changeToList(argValue, IPartyLocaleInformationProperty.class));
/*      */     }
/*  927 */     else if ("PartyLocaleInformationExtension".equals(argFieldId)) {
/*  928 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  931 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  937 */     this._persistenceDefaults = argPD;
/*  938 */     this._daoImpl.setPersistenceDefaults(argPD);
/*  939 */     this._eventManager = argEM;
/*  940 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/*  941 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*  942 */     if (this._properties != null) {
/*  943 */       for (IPartyLocaleInformationProperty relationship : this._properties) {
/*  944 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getPartyLocaleInformationExt() {
/*  950 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setPartyLocaleInformationExt(IDataModel argExt) {
/*  954 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  959 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  963 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  966 */     super.startTransaction();
/*      */     
/*  968 */     this._propertiesSavepoint = this._properties;
/*  969 */     if (this._properties != null) {
/*  970 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/*  971 */       Iterator<IDataModel> it = this._properties.iterator();
/*  972 */       while (it.hasNext()) {
/*  973 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  978 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/*  983 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/*  986 */     super.rollbackChanges();
/*      */     
/*  988 */     this._properties = this._propertiesSavepoint;
/*  989 */     this._propertiesSavepoint = null;
/*  990 */     if (this._properties != null) {
/*  991 */       Iterator<IDataModel> it = this._properties.iterator();
/*  992 */       while (it.hasNext()) {
/*  993 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1001 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1004 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1007 */     super.commitTransaction();
/*      */     
/* 1009 */     this._propertiesSavepoint = this._properties;
/* 1010 */     if (this._properties != null) {
/* 1011 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1012 */       while (it.hasNext()) {
/* 1013 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1015 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1019 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1024 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyLocaleInformationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */