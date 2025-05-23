/*      */ package dtv.xst.dao.crm.impl;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.cat.ICustomerLoyaltyCard;
/*      */ import dtv.xst.dao.crm.ICustomerAffiliation;
/*      */ import dtv.xst.dao.crm.ICustomerNote;
/*      */ import dtv.xst.dao.crm.IParty;
/*      */ import dtv.xst.dao.crm.IPartyEmail;
/*      */ import dtv.xst.dao.crm.IPartyIdCrossReference;
/*      */ import dtv.xst.dao.crm.IPartyLocaleInformation;
/*      */ import dtv.xst.dao.crm.IPartyProperty;
/*      */ import dtv.xst.dao.crm.IPartyTelephone;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class PartyModel extends PartyBaseModel implements IParty {
/*      */   private static final long serialVersionUID = 76884678L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private HistoricalList<IPartyIdCrossReference> _alternatePartyIds;
/*      */   private transient HistoricalList<IPartyIdCrossReference> _alternatePartyIdsSavepoint;
/*      */   private HistoricalList<ICustomerAffiliation> _customerGroups;
/*      */   private transient HistoricalList<ICustomerAffiliation> _customerGroupsSavepoint;
/*      */   private HistoricalList<IPartyLocaleInformation> _localeInformation;
/*      */   private transient HistoricalList<IPartyLocaleInformation> _localeInformationSavepoint;
/*      */   
/*      */   public String toString() {
/*   34 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private HistoricalList<IPartyTelephone> _telephoneInformation; private transient HistoricalList<IPartyTelephone> _telephoneInformationSavepoint; private HistoricalList<IPartyEmail> _emailInformation; private transient HistoricalList<IPartyEmail> _emailInformationSavepoint; private HistoricalList<ICustomerLoyaltyCard> _loyaltyCards; private transient HistoricalList<ICustomerLoyaltyCard> _loyaltyCardsSavepoint; private HistoricalList<ICustomerNote> _customerNotes; private transient HistoricalList<ICustomerNote> _customerNotesSavepoint; private HistoricalList<IPartyProperty> _properties; private transient HistoricalList<IPartyProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   39 */     setDAO((IDataAccessObject)new PartyDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private PartyDAO getDAO_() {
/*   47 */     return (PartyDAO)this._daoImpl;
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
/*   71 */       this._events.post(IParty.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*   84 */       if (this._alternatePartyIds != null) {
/*      */         
/*   86 */         Iterator<PartyIdCrossReferenceModel> it = this._alternatePartyIds.iterator();
/*   87 */         while (it.hasNext())
/*      */         {
/*   89 */           ((PartyIdCrossReferenceModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   92 */       if (this._customerGroups != null) {
/*      */         
/*   94 */         Iterator<CustomerAffiliationModel> it = this._customerGroups.iterator();
/*   95 */         while (it.hasNext())
/*      */         {
/*   97 */           ((CustomerAffiliationModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  100 */       if (this._localeInformation != null) {
/*      */         
/*  102 */         Iterator<PartyLocaleInformationModel> it = this._localeInformation.iterator();
/*  103 */         while (it.hasNext())
/*      */         {
/*  105 */           ((PartyLocaleInformationModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  108 */       if (this._telephoneInformation != null) {
/*      */         
/*  110 */         Iterator<PartyTelephoneModel> it = this._telephoneInformation.iterator();
/*  111 */         while (it.hasNext())
/*      */         {
/*  113 */           ((PartyTelephoneModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  116 */       if (this._emailInformation != null) {
/*      */         
/*  118 */         Iterator<PartyEmailModel> it = this._emailInformation.iterator();
/*  119 */         while (it.hasNext())
/*      */         {
/*  121 */           ((PartyEmailModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  124 */       if (this._loyaltyCards != null) {
/*      */         
/*  126 */         Iterator<CustomerLoyaltyCardModel> it = this._loyaltyCards.iterator();
/*  127 */         while (it.hasNext())
/*      */         {
/*  129 */           ((CustomerLoyaltyCardModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  132 */       if (this._customerNotes != null) {
/*      */         
/*  134 */         Iterator<CustomerNoteModel> it = this._customerNotes.iterator();
/*  135 */         while (it.hasNext())
/*      */         {
/*  137 */           ((CustomerNoteModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  140 */       if (this._properties != null) {
/*      */         
/*  142 */         Iterator<PartyPropertyModel> it = this._properties.iterator();
/*  143 */         while (it.hasNext())
/*      */         {
/*  145 */           ((PartyPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  150 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getPartyId() {
/*  158 */     if (getDAO_().getPartyId() != null) {
/*  159 */       return getDAO_().getPartyId().longValue();
/*      */     }
/*      */     
/*  162 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPartyId(long argPartyId) {
/*  171 */     if (setPartyId_noev(argPartyId) && 
/*  172 */       this._events != null && 
/*  173 */       postEventsForChanges()) {
/*  174 */       this._events.post(IParty.SET_PARTYID, Long.valueOf(argPartyId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPartyId_noev(long argPartyId) {
/*  181 */     boolean ev_postable = false;
/*      */     
/*  183 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/*  184 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/*  185 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/*  186 */       ev_postable = true;
/*  187 */       if (this._alternatePartyIds != null) {
/*      */         
/*  189 */         Iterator<PartyIdCrossReferenceModel> it = this._alternatePartyIds.iterator();
/*  190 */         while (it.hasNext())
/*      */         {
/*  192 */           ((PartyIdCrossReferenceModel)it.next()).setPartyId_noev(argPartyId);
/*      */         }
/*      */       } 
/*  195 */       if (this._customerGroups != null) {
/*      */         
/*  197 */         Iterator<CustomerAffiliationModel> it = this._customerGroups.iterator();
/*  198 */         while (it.hasNext())
/*      */         {
/*  200 */           ((CustomerAffiliationModel)it.next()).setPartyId_noev(argPartyId);
/*      */         }
/*      */       } 
/*  203 */       if (this._localeInformation != null) {
/*      */         
/*  205 */         Iterator<PartyLocaleInformationModel> it = this._localeInformation.iterator();
/*  206 */         while (it.hasNext())
/*      */         {
/*  208 */           ((PartyLocaleInformationModel)it.next()).setPartyId_noev(argPartyId);
/*      */         }
/*      */       } 
/*  211 */       if (this._telephoneInformation != null) {
/*      */         
/*  213 */         Iterator<PartyTelephoneModel> it = this._telephoneInformation.iterator();
/*  214 */         while (it.hasNext())
/*      */         {
/*  216 */           ((PartyTelephoneModel)it.next()).setPartyId_noev(argPartyId);
/*      */         }
/*      */       } 
/*  219 */       if (this._emailInformation != null) {
/*      */         
/*  221 */         Iterator<PartyEmailModel> it = this._emailInformation.iterator();
/*  222 */         while (it.hasNext())
/*      */         {
/*  224 */           ((PartyEmailModel)it.next()).setPartyId_noev(argPartyId);
/*      */         }
/*      */       } 
/*  227 */       if (this._loyaltyCards != null) {
/*      */         
/*  229 */         Iterator<CustomerLoyaltyCardModel> it = this._loyaltyCards.iterator();
/*  230 */         while (it.hasNext())
/*      */         {
/*  232 */           ((CustomerLoyaltyCardModel)it.next()).setPartyId_noev(argPartyId);
/*      */         }
/*      */       } 
/*  235 */       if (this._customerNotes != null) {
/*      */         
/*  237 */         Iterator<CustomerNoteModel> it = this._customerNotes.iterator();
/*  238 */         while (it.hasNext())
/*      */         {
/*  240 */           ((CustomerNoteModel)it.next()).setPartyId_noev(argPartyId);
/*      */         }
/*      */       } 
/*  243 */       if (this._properties != null) {
/*      */         
/*  245 */         Iterator<PartyPropertyModel> it = this._properties.iterator();
/*  246 */         while (it.hasNext())
/*      */         {
/*  248 */           ((PartyPropertyModel)it.next()).setPartyId_noev(argPartyId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  253 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  261 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  269 */     if (setCreateDate_noev(argCreateDate) && 
/*  270 */       this._events != null && 
/*  271 */       postEventsForChanges()) {
/*  272 */       this._events.post(IParty.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  279 */     boolean ev_postable = false;
/*      */     
/*  281 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  282 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  283 */       getDAO_().setCreateDate(argCreateDate);
/*  284 */       ev_postable = true;
/*      */     } 
/*      */     
/*  287 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  295 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  303 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  304 */       this._events != null && 
/*  305 */       postEventsForChanges()) {
/*  306 */       this._events.post(IParty.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  313 */     boolean ev_postable = false;
/*      */     
/*  315 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  316 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  317 */       getDAO_().setCreateUserId(argCreateUserId);
/*  318 */       ev_postable = true;
/*      */     } 
/*      */     
/*  321 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  329 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  337 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  338 */       this._events != null && 
/*  339 */       postEventsForChanges()) {
/*  340 */       this._events.post(IParty.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  347 */     boolean ev_postable = false;
/*      */     
/*  349 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  350 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  351 */       getDAO_().setUpdateDate(argUpdateDate);
/*  352 */       ev_postable = true;
/*      */     } 
/*      */     
/*  355 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  363 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  371 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  372 */       this._events != null && 
/*  373 */       postEventsForChanges()) {
/*  374 */       this._events.post(IParty.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  381 */     boolean ev_postable = false;
/*      */     
/*  383 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  384 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  385 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  386 */       ev_postable = true;
/*      */     } 
/*      */     
/*  389 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getAllegianceRetailLocationId() {
/*  397 */     if (getDAO_().getAllegianceRetailLocationId() != null) {
/*  398 */       return getDAO_().getAllegianceRetailLocationId().longValue();
/*      */     }
/*      */     
/*  401 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAllegianceRetailLocationId(long argAllegianceRetailLocationId) {
/*  410 */     if (setAllegianceRetailLocationId_noev(argAllegianceRetailLocationId) && 
/*  411 */       this._events != null && 
/*  412 */       postEventsForChanges()) {
/*  413 */       this._events.post(IParty.SET_ALLEGIANCERETAILLOCATIONID, Long.valueOf(argAllegianceRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAllegianceRetailLocationId_noev(long argAllegianceRetailLocationId) {
/*  420 */     boolean ev_postable = false;
/*      */     
/*  422 */     if ((getDAO_().getAllegianceRetailLocationId() == null && Long.valueOf(argAllegianceRetailLocationId) != null) || (
/*  423 */       getDAO_().getAllegianceRetailLocationId() != null && !getDAO_().getAllegianceRetailLocationId().equals(Long.valueOf(argAllegianceRetailLocationId)))) {
/*  424 */       getDAO_().setAllegianceRetailLocationId(Long.valueOf(argAllegianceRetailLocationId));
/*  425 */       ev_postable = true;
/*      */     } 
/*      */     
/*  428 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBirthDate() {
/*  436 */     return getDAO_().getBirthDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBirthDate(Date argBirthDate) {
/*  444 */     if (setBirthDate_noev(argBirthDate) && 
/*  445 */       this._events != null && 
/*  446 */       postEventsForChanges()) {
/*  447 */       this._events.post(IParty.SET_BIRTHDATE, argBirthDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBirthDate_noev(Date argBirthDate) {
/*  454 */     boolean ev_postable = false;
/*      */     
/*  456 */     if ((getDAO_().getBirthDate() == null && argBirthDate != null) || (
/*  457 */       getDAO_().getBirthDate() != null && !getDAO_().getBirthDate().equals(argBirthDate))) {
/*  458 */       getDAO_().setBirthDate(argBirthDate);
/*  459 */       ev_postable = true;
/*      */     } 
/*      */     
/*  462 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustomerId() {
/*  470 */     return getDAO_().getCustomerId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustomerId(String argCustomerId) {
/*  478 */     if (setCustomerId_noev(argCustomerId) && 
/*  479 */       this._events != null && 
/*  480 */       postEventsForChanges()) {
/*  481 */       this._events.post(IParty.SET_CUSTOMERID, argCustomerId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustomerId_noev(String argCustomerId) {
/*  488 */     boolean ev_postable = false;
/*      */     
/*  490 */     if ((getDAO_().getCustomerId() == null && argCustomerId != null) || (
/*  491 */       getDAO_().getCustomerId() != null && !getDAO_().getCustomerId().equals(argCustomerId))) {
/*  492 */       getDAO_().setCustomerId(argCustomerId);
/*  493 */       ev_postable = true;
/*      */     } 
/*      */     
/*  496 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getEmployeeId() {
/*  504 */     return getDAO_().getEmployeeId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEmployeeId(String argEmployeeId) {
/*  512 */     if (setEmployeeId_noev(argEmployeeId) && 
/*  513 */       this._events != null && 
/*  514 */       postEventsForChanges()) {
/*  515 */       this._events.post(IParty.SET_EMPLOYEEID, argEmployeeId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEmployeeId_noev(String argEmployeeId) {
/*  522 */     boolean ev_postable = false;
/*      */     
/*  524 */     if ((getDAO_().getEmployeeId() == null && argEmployeeId != null) || (
/*  525 */       getDAO_().getEmployeeId() != null && !getDAO_().getEmployeeId().equals(argEmployeeId))) {
/*  526 */       getDAO_().setEmployeeId(argEmployeeId);
/*  527 */       ev_postable = true;
/*      */     } 
/*      */     
/*  530 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNationalTaxId() {
/*  538 */     return getDAO_().getNationalTaxId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNationalTaxId(String argNationalTaxId) {
/*  546 */     if (setNationalTaxId_noev(argNationalTaxId) && 
/*  547 */       this._events != null && 
/*  548 */       postEventsForChanges()) {
/*  549 */       this._events.post(IParty.SET_NATIONALTAXID, argNationalTaxId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNationalTaxId_noev(String argNationalTaxId) {
/*  556 */     boolean ev_postable = false;
/*      */     
/*  558 */     if ((getDAO_().getNationalTaxId() == null && argNationalTaxId != null) || (
/*  559 */       getDAO_().getNationalTaxId() != null && !getDAO_().getNationalTaxId().equals(argNationalTaxId))) {
/*  560 */       getDAO_().setNationalTaxId(argNationalTaxId);
/*  561 */       ev_postable = true;
/*      */     } 
/*      */     
/*  564 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFirstName() {
/*  572 */     return getDAO_().getFirstName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFirstName(String argFirstName) {
/*  580 */     if (setFirstName_noev(argFirstName) && 
/*  581 */       this._events != null && 
/*  582 */       postEventsForChanges()) {
/*  583 */       this._events.post(IParty.SET_FIRSTNAME, argFirstName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFirstName_noev(String argFirstName) {
/*  590 */     boolean ev_postable = false;
/*      */     
/*  592 */     if ((getDAO_().getFirstName() == null && argFirstName != null) || (
/*  593 */       getDAO_().getFirstName() != null && !getDAO_().getFirstName().equals(argFirstName))) {
/*  594 */       getDAO_().setFirstName(argFirstName);
/*  595 */       ev_postable = true;
/*      */     } 
/*      */     
/*  598 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFirstName2() {
/*  606 */     return getDAO_().getFirstName2();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFirstName2(String argFirstName2) {
/*  614 */     if (setFirstName2_noev(argFirstName2) && 
/*  615 */       this._events != null && 
/*  616 */       postEventsForChanges()) {
/*  617 */       this._events.post(IParty.SET_FIRSTNAME2, argFirstName2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFirstName2_noev(String argFirstName2) {
/*  624 */     boolean ev_postable = false;
/*      */     
/*  626 */     if ((getDAO_().getFirstName2() == null && argFirstName2 != null) || (
/*  627 */       getDAO_().getFirstName2() != null && !getDAO_().getFirstName2().equals(argFirstName2))) {
/*  628 */       getDAO_().setFirstName2(argFirstName2);
/*  629 */       ev_postable = true;
/*      */     } 
/*      */     
/*  632 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getGender() {
/*  640 */     return getDAO_().getGender();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGender(String argGender) {
/*  648 */     if (setGender_noev(argGender) && 
/*  649 */       this._events != null && 
/*  650 */       postEventsForChanges()) {
/*  651 */       this._events.post(IParty.SET_GENDER, argGender);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setGender_noev(String argGender) {
/*  658 */     boolean ev_postable = false;
/*      */     
/*  660 */     if ((getDAO_().getGender() == null && argGender != null) || (
/*  661 */       getDAO_().getGender() != null && !getDAO_().getGender().equals(argGender))) {
/*  662 */       getDAO_().setGender(argGender);
/*  663 */       ev_postable = true;
/*      */     } 
/*      */     
/*  666 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLastName() {
/*  674 */     return getDAO_().getLastName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLastName(String argLastName) {
/*  682 */     if (setLastName_noev(argLastName) && 
/*  683 */       this._events != null && 
/*  684 */       postEventsForChanges()) {
/*  685 */       this._events.post(IParty.SET_LASTNAME, argLastName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLastName_noev(String argLastName) {
/*  692 */     boolean ev_postable = false;
/*      */     
/*  694 */     if ((getDAO_().getLastName() == null && argLastName != null) || (
/*  695 */       getDAO_().getLastName() != null && !getDAO_().getLastName().equals(argLastName))) {
/*  696 */       getDAO_().setLastName(argLastName);
/*  697 */       ev_postable = true;
/*      */     } 
/*      */     
/*  700 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLastName2() {
/*  708 */     return getDAO_().getLastName2();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLastName2(String argLastName2) {
/*  716 */     if (setLastName2_noev(argLastName2) && 
/*  717 */       this._events != null && 
/*  718 */       postEventsForChanges()) {
/*  719 */       this._events.post(IParty.SET_LASTNAME2, argLastName2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLastName2_noev(String argLastName2) {
/*  726 */     boolean ev_postable = false;
/*      */     
/*  728 */     if ((getDAO_().getLastName2() == null && argLastName2 != null) || (
/*  729 */       getDAO_().getLastName2() != null && !getDAO_().getLastName2().equals(argLastName2))) {
/*  730 */       getDAO_().setLastName2(argLastName2);
/*  731 */       ev_postable = true;
/*      */     } 
/*      */     
/*  734 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getMiddleName() {
/*  742 */     return getDAO_().getMiddleName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMiddleName(String argMiddleName) {
/*  750 */     if (setMiddleName_noev(argMiddleName) && 
/*  751 */       this._events != null && 
/*  752 */       postEventsForChanges()) {
/*  753 */       this._events.post(IParty.SET_MIDDLENAME, argMiddleName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMiddleName_noev(String argMiddleName) {
/*  760 */     boolean ev_postable = false;
/*      */     
/*  762 */     if ((getDAO_().getMiddleName() == null && argMiddleName != null) || (
/*  763 */       getDAO_().getMiddleName() != null && !getDAO_().getMiddleName().equals(argMiddleName))) {
/*  764 */       getDAO_().setMiddleName(argMiddleName);
/*  765 */       ev_postable = true;
/*      */     } 
/*      */     
/*  768 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPreferredLocale() {
/*  776 */     return getDAO_().getPreferredLocale();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPreferredLocale(String argPreferredLocale) {
/*  784 */     if (setPreferredLocale_noev(argPreferredLocale) && 
/*  785 */       this._events != null && 
/*  786 */       postEventsForChanges()) {
/*  787 */       this._events.post(IParty.SET_PREFERREDLOCALE, argPreferredLocale);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPreferredLocale_noev(String argPreferredLocale) {
/*  794 */     boolean ev_postable = false;
/*      */     
/*  796 */     if ((getDAO_().getPreferredLocale() == null && argPreferredLocale != null) || (
/*  797 */       getDAO_().getPreferredLocale() != null && !getDAO_().getPreferredLocale().equals(argPreferredLocale))) {
/*  798 */       getDAO_().setPreferredLocale(argPreferredLocale);
/*  799 */       ev_postable = true;
/*      */     } 
/*      */     
/*  802 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrganizationName() {
/*  810 */     return getDAO_().getOrganizationName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationName(String argOrganizationName) {
/*  818 */     if (setOrganizationName_noev(argOrganizationName) && 
/*  819 */       this._events != null && 
/*  820 */       postEventsForChanges()) {
/*  821 */       this._events.post(IParty.SET_ORGANIZATIONNAME, argOrganizationName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationName_noev(String argOrganizationName) {
/*  828 */     boolean ev_postable = false;
/*      */     
/*  830 */     if ((getDAO_().getOrganizationName() == null && argOrganizationName != null) || (
/*  831 */       getDAO_().getOrganizationName() != null && !getDAO_().getOrganizationName().equals(argOrganizationName))) {
/*  832 */       getDAO_().setOrganizationName(argOrganizationName);
/*  833 */       ev_postable = true;
/*      */     } 
/*      */     
/*  836 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrganizationTypeCode() {
/*  844 */     return getDAO_().getOrganizationTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationTypeCode(String argOrganizationTypeCode) {
/*  852 */     if (setOrganizationTypeCode_noev(argOrganizationTypeCode) && 
/*  853 */       this._events != null && 
/*  854 */       postEventsForChanges()) {
/*  855 */       this._events.post(IParty.SET_ORGANIZATIONTYPECODE, argOrganizationTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationTypeCode_noev(String argOrganizationTypeCode) {
/*  862 */     boolean ev_postable = false;
/*      */     
/*  864 */     if ((getDAO_().getOrganizationTypeCode() == null && argOrganizationTypeCode != null) || (
/*  865 */       getDAO_().getOrganizationTypeCode() != null && !getDAO_().getOrganizationTypeCode().equals(argOrganizationTypeCode))) {
/*  866 */       getDAO_().setOrganizationTypeCode(argOrganizationTypeCode);
/*  867 */       ev_postable = true;
/*      */     } 
/*      */     
/*  870 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPartyTypeCode() {
/*  878 */     return getDAO_().getPartyTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPartyTypeCode(String argPartyTypeCode) {
/*  886 */     if (setPartyTypeCode_noev(argPartyTypeCode) && 
/*  887 */       this._events != null && 
/*  888 */       postEventsForChanges()) {
/*  889 */       this._events.post(IParty.SET_PARTYTYPECODE, argPartyTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPartyTypeCode_noev(String argPartyTypeCode) {
/*  896 */     boolean ev_postable = false;
/*      */     
/*  898 */     if ((getDAO_().getPartyTypeCode() == null && argPartyTypeCode != null) || (
/*  899 */       getDAO_().getPartyTypeCode() != null && !getDAO_().getPartyTypeCode().equals(argPartyTypeCode))) {
/*  900 */       getDAO_().setPartyTypeCode(argPartyTypeCode);
/*  901 */       ev_postable = true;
/*      */     } 
/*      */     
/*  904 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPictureUri() {
/*  912 */     return getDAO_().getPictureUri();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPictureUri(String argPictureUri) {
/*  920 */     if (setPictureUri_noev(argPictureUri) && 
/*  921 */       this._events != null && 
/*  922 */       postEventsForChanges()) {
/*  923 */       this._events.post(IParty.SET_PICTUREURI, argPictureUri);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPictureUri_noev(String argPictureUri) {
/*  930 */     boolean ev_postable = false;
/*      */     
/*  932 */     if ((getDAO_().getPictureUri() == null && argPictureUri != null) || (
/*  933 */       getDAO_().getPictureUri() != null && !getDAO_().getPictureUri().equals(argPictureUri))) {
/*  934 */       getDAO_().setPictureUri(argPictureUri);
/*  935 */       ev_postable = true;
/*      */     } 
/*      */     
/*  938 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSalutation() {
/*  946 */     return getDAO_().getSalutation();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSalutation(String argSalutation) {
/*  954 */     if (setSalutation_noev(argSalutation) && 
/*  955 */       this._events != null && 
/*  956 */       postEventsForChanges()) {
/*  957 */       this._events.post(IParty.SET_SALUTATION, argSalutation);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSalutation_noev(String argSalutation) {
/*  964 */     boolean ev_postable = false;
/*      */     
/*  966 */     if ((getDAO_().getSalutation() == null && argSalutation != null) || (
/*  967 */       getDAO_().getSalutation() != null && !getDAO_().getSalutation().equals(argSalutation))) {
/*  968 */       getDAO_().setSalutation(argSalutation);
/*  969 */       ev_postable = true;
/*      */     } 
/*      */     
/*  972 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getSignUpRetailLocationId() {
/*  980 */     if (getDAO_().getSignUpRetailLocationId() != null) {
/*  981 */       return getDAO_().getSignUpRetailLocationId().longValue();
/*      */     }
/*      */     
/*  984 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSignUpRetailLocationId(long argSignUpRetailLocationId) {
/*  993 */     if (setSignUpRetailLocationId_noev(argSignUpRetailLocationId) && 
/*  994 */       this._events != null && 
/*  995 */       postEventsForChanges()) {
/*  996 */       this._events.post(IParty.SET_SIGNUPRETAILLOCATIONID, Long.valueOf(argSignUpRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSignUpRetailLocationId_noev(long argSignUpRetailLocationId) {
/* 1003 */     boolean ev_postable = false;
/*      */     
/* 1005 */     if ((getDAO_().getSignUpRetailLocationId() == null && Long.valueOf(argSignUpRetailLocationId) != null) || (
/* 1006 */       getDAO_().getSignUpRetailLocationId() != null && !getDAO_().getSignUpRetailLocationId().equals(Long.valueOf(argSignUpRetailLocationId)))) {
/* 1007 */       getDAO_().setSignUpRetailLocationId(Long.valueOf(argSignUpRetailLocationId));
/* 1008 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1011 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSocialSecurityNbr() {
/* 1019 */     return decryptField("pinfo", getDAO_().getSocialSecurityNbr());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSocialSecurityNbr(String argSocialSecurityNbr) {
/* 1027 */     if (setSocialSecurityNbr_noev(argSocialSecurityNbr) && 
/* 1028 */       this._events != null && 
/* 1029 */       postEventsForChanges()) {
/* 1030 */       this._events.post(IParty.SET_SOCIALSECURITYNBR, argSocialSecurityNbr);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSocialSecurityNbr_noev(String argSocialSecurityNbr) {
/* 1037 */     boolean ev_postable = false;
/*      */     
/* 1039 */     if ((getDAO_().getSocialSecurityNbr() == null && argSocialSecurityNbr != null) || (
/* 1040 */       getDAO_().getSocialSecurityNbr() != null && !getDAO_().getSocialSecurityNbr().equals(argSocialSecurityNbr))) {
/* 1041 */       getDAO_().setSocialSecurityNbr(encryptField("pinfo", argSocialSecurityNbr));
/* 1042 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1045 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSocialSecurityNbrEncrypted() {
/* 1053 */     return getDAO_().getSocialSecurityNbr();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPersonalTaxId() {
/* 1061 */     return getDAO_().getPersonalTaxId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPersonalTaxId(String argPersonalTaxId) {
/* 1069 */     if (setPersonalTaxId_noev(argPersonalTaxId) && 
/* 1070 */       this._events != null && 
/* 1071 */       postEventsForChanges()) {
/* 1072 */       this._events.post(IParty.SET_PERSONALTAXID, argPersonalTaxId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPersonalTaxId_noev(String argPersonalTaxId) {
/* 1079 */     boolean ev_postable = false;
/*      */     
/* 1081 */     if ((getDAO_().getPersonalTaxId() == null && argPersonalTaxId != null) || (
/* 1082 */       getDAO_().getPersonalTaxId() != null && !getDAO_().getPersonalTaxId().equals(argPersonalTaxId))) {
/* 1083 */       getDAO_().setPersonalTaxId(argPersonalTaxId);
/* 1084 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1087 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSuffix() {
/* 1095 */     return getDAO_().getSuffix();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSuffix(String argSuffix) {
/* 1103 */     if (setSuffix_noev(argSuffix) && 
/* 1104 */       this._events != null && 
/* 1105 */       postEventsForChanges()) {
/* 1106 */       this._events.post(IParty.SET_SUFFIX, argSuffix);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSuffix_noev(String argSuffix) {
/* 1113 */     boolean ev_postable = false;
/*      */     
/* 1115 */     if ((getDAO_().getSuffix() == null && argSuffix != null) || (
/* 1116 */       getDAO_().getSuffix() != null && !getDAO_().getSuffix().equals(argSuffix))) {
/* 1117 */       getDAO_().setSuffix(argSuffix);
/* 1118 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1121 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getVoid() {
/* 1129 */     if (getDAO_().getVoid() != null) {
/* 1130 */       return getDAO_().getVoid().booleanValue();
/*      */     }
/*      */     
/* 1133 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVoid(boolean argVoid) {
/* 1142 */     if (setVoid_noev(argVoid) && 
/* 1143 */       this._events != null && 
/* 1144 */       postEventsForChanges()) {
/* 1145 */       this._events.post(IParty.SET_VOID, Boolean.valueOf(argVoid));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVoid_noev(boolean argVoid) {
/* 1152 */     boolean ev_postable = false;
/*      */     
/* 1154 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/* 1155 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/* 1156 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
/* 1157 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1160 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getActive() {
/* 1168 */     if (getDAO_().getActive() != null) {
/* 1169 */       return getDAO_().getActive().booleanValue();
/*      */     }
/*      */     
/* 1172 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActive(boolean argActive) {
/* 1181 */     if (setActive_noev(argActive) && 
/* 1182 */       this._events != null && 
/* 1183 */       postEventsForChanges()) {
/* 1184 */       this._events.post(IParty.SET_ACTIVE, Boolean.valueOf(argActive));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setActive_noev(boolean argActive) {
/* 1191 */     boolean ev_postable = false;
/*      */     
/* 1193 */     if ((getDAO_().getActive() == null && Boolean.valueOf(argActive) != null) || (
/* 1194 */       getDAO_().getActive() != null && !getDAO_().getActive().equals(Boolean.valueOf(argActive)))) {
/* 1195 */       getDAO_().setActive(Boolean.valueOf(argActive));
/* 1196 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1199 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getEmailRcpts() {
/* 1207 */     if (getDAO_().getEmailRcpts() != null) {
/* 1208 */       return getDAO_().getEmailRcpts().booleanValue();
/*      */     }
/*      */     
/* 1211 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEmailRcpts(boolean argEmailRcpts) {
/* 1220 */     if (setEmailRcpts_noev(argEmailRcpts) && 
/* 1221 */       this._events != null && 
/* 1222 */       postEventsForChanges()) {
/* 1223 */       this._events.post(IParty.SET_EMAILRCPTS, Boolean.valueOf(argEmailRcpts));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEmailRcpts_noev(boolean argEmailRcpts) {
/* 1230 */     boolean ev_postable = false;
/*      */     
/* 1232 */     if ((getDAO_().getEmailRcpts() == null && Boolean.valueOf(argEmailRcpts) != null) || (
/* 1233 */       getDAO_().getEmailRcpts() != null && !getDAO_().getEmailRcpts().equals(Boolean.valueOf(argEmailRcpts)))) {
/* 1234 */       getDAO_().setEmailRcpts(Boolean.valueOf(argEmailRcpts));
/* 1235 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1238 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getAnniversaryDate() {
/* 1246 */     return getDAO_().getAnniversaryDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAnniversaryDate(Date argAnniversaryDate) {
/* 1254 */     if (setAnniversaryDate_noev(argAnniversaryDate) && 
/* 1255 */       this._events != null && 
/* 1256 */       postEventsForChanges()) {
/* 1257 */       this._events.post(IParty.SET_ANNIVERSARYDATE, argAnniversaryDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAnniversaryDate_noev(Date argAnniversaryDate) {
/* 1264 */     boolean ev_postable = false;
/*      */     
/* 1266 */     if ((getDAO_().getAnniversaryDate() == null && argAnniversaryDate != null) || (
/* 1267 */       getDAO_().getAnniversaryDate() != null && !getDAO_().getAnniversaryDate().equals(argAnniversaryDate))) {
/* 1268 */       getDAO_().setAnniversaryDate(argAnniversaryDate);
/* 1269 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1272 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getProspect() {
/* 1280 */     if (getDAO_().getProspect() != null) {
/* 1281 */       return getDAO_().getProspect().booleanValue();
/*      */     }
/*      */     
/* 1284 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setProspect(boolean argProspect) {
/* 1293 */     if (setProspect_noev(argProspect) && 
/* 1294 */       this._events != null && 
/* 1295 */       postEventsForChanges()) {
/* 1296 */       this._events.post(IParty.SET_PROSPECT, Boolean.valueOf(argProspect));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setProspect_noev(boolean argProspect) {
/* 1303 */     boolean ev_postable = false;
/*      */     
/* 1305 */     if ((getDAO_().getProspect() == null && Boolean.valueOf(argProspect) != null) || (
/* 1306 */       getDAO_().getProspect() != null && !getDAO_().getProspect().equals(Boolean.valueOf(argProspect)))) {
/* 1307 */       getDAO_().setProspect(Boolean.valueOf(argProspect));
/* 1308 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1311 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getRent() {
/* 1319 */     if (getDAO_().getRent() != null) {
/* 1320 */       return getDAO_().getRent().booleanValue();
/*      */     }
/*      */     
/* 1323 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRent(boolean argRent) {
/* 1332 */     if (setRent_noev(argRent) && 
/* 1333 */       this._events != null && 
/* 1334 */       postEventsForChanges()) {
/* 1335 */       this._events.post(IParty.SET_RENT, Boolean.valueOf(argRent));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRent_noev(boolean argRent) {
/* 1342 */     boolean ev_postable = false;
/*      */     
/* 1344 */     if ((getDAO_().getRent() == null && Boolean.valueOf(argRent) != null) || (
/* 1345 */       getDAO_().getRent() != null && !getDAO_().getRent().equals(Boolean.valueOf(argRent)))) {
/* 1346 */       getDAO_().setRent(Boolean.valueOf(argRent));
/* 1347 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1350 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getPrivacyCard() {
/* 1358 */     if (getDAO_().getPrivacyCard() != null) {
/* 1359 */       return getDAO_().getPrivacyCard().booleanValue();
/*      */     }
/*      */     
/* 1362 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPrivacyCard(boolean argPrivacyCard) {
/* 1371 */     if (setPrivacyCard_noev(argPrivacyCard) && 
/* 1372 */       this._events != null && 
/* 1373 */       postEventsForChanges()) {
/* 1374 */       this._events.post(IParty.SET_PRIVACYCARD, Boolean.valueOf(argPrivacyCard));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPrivacyCard_noev(boolean argPrivacyCard) {
/* 1381 */     boolean ev_postable = false;
/*      */     
/* 1383 */     if ((getDAO_().getPrivacyCard() == null && Boolean.valueOf(argPrivacyCard) != null) || (
/* 1384 */       getDAO_().getPrivacyCard() != null && !getDAO_().getPrivacyCard().equals(Boolean.valueOf(argPrivacyCard)))) {
/* 1385 */       getDAO_().setPrivacyCard(Boolean.valueOf(argPrivacyCard));
/* 1386 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1389 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCommercialCustomer() {
/* 1397 */     if (getDAO_().getCommercialCustomer() != null) {
/* 1398 */       return getDAO_().getCommercialCustomer().booleanValue();
/*      */     }
/*      */     
/* 1401 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCommercialCustomer(boolean argCommercialCustomer) {
/* 1410 */     if (setCommercialCustomer_noev(argCommercialCustomer) && 
/* 1411 */       this._events != null && 
/* 1412 */       postEventsForChanges()) {
/* 1413 */       this._events.post(IParty.SET_COMMERCIALCUSTOMER, Boolean.valueOf(argCommercialCustomer));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCommercialCustomer_noev(boolean argCommercialCustomer) {
/* 1420 */     boolean ev_postable = false;
/*      */     
/* 1422 */     if ((getDAO_().getCommercialCustomer() == null && Boolean.valueOf(argCommercialCustomer) != null) || (
/* 1423 */       getDAO_().getCommercialCustomer() != null && !getDAO_().getCommercialCustomer().equals(Boolean.valueOf(argCommercialCustomer)))) {
/* 1424 */       getDAO_().setCommercialCustomer(Boolean.valueOf(argCommercialCustomer));
/* 1425 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1428 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getContactPref() {
/* 1436 */     return getDAO_().getContactPref();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setContactPref(String argContactPref) {
/* 1444 */     if (setContactPref_noev(argContactPref) && 
/* 1445 */       this._events != null && 
/* 1446 */       postEventsForChanges()) {
/* 1447 */       this._events.post(IParty.SET_CONTACTPREF, argContactPref);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setContactPref_noev(String argContactPref) {
/* 1454 */     boolean ev_postable = false;
/*      */     
/* 1456 */     if ((getDAO_().getContactPref() == null && argContactPref != null) || (
/* 1457 */       getDAO_().getContactPref() != null && !getDAO_().getContactPref().equals(argContactPref))) {
/* 1458 */       getDAO_().setContactPref(argContactPref);
/* 1459 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1462 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IPartyProperty newProperty(String argPropertyName) {
/* 1466 */     PartyPropertyId id = new PartyPropertyId();
/*      */     
/* 1468 */     id.setPartyId(Long.valueOf(getPartyId()));
/* 1469 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1471 */     IPartyProperty prop = (IPartyProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IPartyProperty.class);
/* 1472 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "AlternatePartyIds")
/*      */   public List<IPartyIdCrossReference> getAlternatePartyIds() {
/* 1502 */     if (this._alternatePartyIds == null) {
/* 1503 */       this._alternatePartyIds = new HistoricalList(null);
/*      */     }
/* 1505 */     return (List<IPartyIdCrossReference>)this._alternatePartyIds;
/*      */   }
/*      */   
/*      */   public void setAlternatePartyIds(List<IPartyIdCrossReference> argAlternatePartyIds) {
/* 1509 */     if (this._alternatePartyIds == null) {
/* 1510 */       this._alternatePartyIds = new HistoricalList(argAlternatePartyIds);
/*      */     } else {
/* 1512 */       this._alternatePartyIds.setCurrentList(argAlternatePartyIds);
/*      */     } 
/*      */     
/* 1515 */     for (IPartyIdCrossReference child : this._alternatePartyIds) {
/* 1516 */       PartyIdCrossReferenceModel model = (PartyIdCrossReferenceModel)child;
/* 1517 */       model.setOrganizationId_noev(getOrganizationId());
/* 1518 */       model.setPartyId_noev(getPartyId());
/* 1519 */       if (child instanceof IDataModelImpl) {
/* 1520 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1521 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1522 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1523 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1526 */       if (postEventsForChanges()) {
/* 1527 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addPartyIdCrossReference(IPartyIdCrossReference argPartyIdCrossReference) {
/* 1533 */     if (this._alternatePartyIds == null) {
/* 1534 */       this._alternatePartyIds = new HistoricalList(null);
/*      */     }
/* 1536 */     argPartyIdCrossReference.setOrganizationId(getOrganizationId());
/* 1537 */     argPartyIdCrossReference.setPartyId(getPartyId());
/* 1538 */     if (argPartyIdCrossReference instanceof IDataModelImpl) {
/* 1539 */       IDataAccessObject childDao = ((IDataModelImpl)argPartyIdCrossReference).getDAO();
/* 1540 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1541 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1542 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1547 */     if (postEventsForChanges()) {
/* 1548 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyIdCrossReference));
/*      */     }
/*      */     
/* 1551 */     this._alternatePartyIds.add(argPartyIdCrossReference);
/* 1552 */     if (postEventsForChanges()) {
/* 1553 */       this._events.post(IParty.ADD_ALTERNATEPARTYIDS, argPartyIdCrossReference);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removePartyIdCrossReference(IPartyIdCrossReference argPartyIdCrossReference) {
/* 1558 */     if (this._alternatePartyIds != null) {
/*      */       
/* 1560 */       if (postEventsForChanges()) {
/* 1561 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyIdCrossReference));
/*      */       }
/* 1563 */       this._alternatePartyIds.remove(argPartyIdCrossReference);
/* 1564 */       if (postEventsForChanges()) {
/* 1565 */         this._events.post(IParty.REMOVE_ALTERNATEPARTYIDS, argPartyIdCrossReference);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "CustomerGroups")
/*      */   public List<ICustomerAffiliation> getCustomerGroups() {
/* 1572 */     if (this._customerGroups == null) {
/* 1573 */       this._customerGroups = new HistoricalList(null);
/*      */     }
/* 1575 */     return (List<ICustomerAffiliation>)this._customerGroups;
/*      */   }
/*      */   
/*      */   public void setCustomerGroups(List<ICustomerAffiliation> argCustomerGroups) {
/* 1579 */     if (this._customerGroups == null) {
/* 1580 */       this._customerGroups = new HistoricalList(argCustomerGroups);
/*      */     } else {
/* 1582 */       this._customerGroups.setCurrentList(argCustomerGroups);
/*      */     } 
/*      */     
/* 1585 */     for (ICustomerAffiliation child : this._customerGroups) {
/* 1586 */       CustomerAffiliationModel model = (CustomerAffiliationModel)child;
/* 1587 */       model.setOrganizationId_noev(getOrganizationId());
/* 1588 */       model.setPartyId_noev(getPartyId());
/* 1589 */       if (child instanceof IDataModelImpl) {
/* 1590 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1591 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1592 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1593 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1596 */       if (postEventsForChanges()) {
/* 1597 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addCustomerAffiliation(ICustomerAffiliation argCustomerAffiliation) {
/* 1603 */     if (this._customerGroups == null) {
/* 1604 */       this._customerGroups = new HistoricalList(null);
/*      */     }
/* 1606 */     argCustomerAffiliation.setOrganizationId(getOrganizationId());
/* 1607 */     argCustomerAffiliation.setPartyId(getPartyId());
/* 1608 */     if (argCustomerAffiliation instanceof IDataModelImpl) {
/* 1609 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerAffiliation).getDAO();
/* 1610 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1611 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1612 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1617 */     if (postEventsForChanges()) {
/* 1618 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAffiliation));
/*      */     }
/*      */     
/* 1621 */     this._customerGroups.add(argCustomerAffiliation);
/* 1622 */     if (postEventsForChanges()) {
/* 1623 */       this._events.post(IParty.ADD_CUSTOMERGROUPS, argCustomerAffiliation);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeCustomerAffiliation(ICustomerAffiliation argCustomerAffiliation) {
/* 1628 */     if (this._customerGroups != null) {
/*      */       
/* 1630 */       if (postEventsForChanges()) {
/* 1631 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAffiliation));
/*      */       }
/* 1633 */       this._customerGroups.remove(argCustomerAffiliation);
/* 1634 */       if (postEventsForChanges()) {
/* 1635 */         this._events.post(IParty.REMOVE_CUSTOMERGROUPS, argCustomerAffiliation);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "LocaleInformation")
/*      */   public List<IPartyLocaleInformation> getLocaleInformation() {
/* 1642 */     if (this._localeInformation == null) {
/* 1643 */       this._localeInformation = new HistoricalList(null);
/*      */     }
/* 1645 */     return (List<IPartyLocaleInformation>)this._localeInformation;
/*      */   }
/*      */   
/*      */   public void setLocaleInformation(List<IPartyLocaleInformation> argLocaleInformation) {
/* 1649 */     if (this._localeInformation == null) {
/* 1650 */       this._localeInformation = new HistoricalList(argLocaleInformation);
/*      */     } else {
/* 1652 */       this._localeInformation.setCurrentList(argLocaleInformation);
/*      */     } 
/*      */     
/* 1655 */     for (IPartyLocaleInformation child : this._localeInformation) {
/* 1656 */       child.setParentParty(this);
/*      */     }
/*      */ 
/*      */     
/* 1660 */     for (IPartyLocaleInformation child : this._localeInformation) {
/* 1661 */       PartyLocaleInformationModel model = (PartyLocaleInformationModel)child;
/* 1662 */       model.setOrganizationId_noev(getOrganizationId());
/* 1663 */       model.setPartyId_noev(getPartyId());
/* 1664 */       if (child instanceof IDataModelImpl) {
/* 1665 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1666 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1667 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1668 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1671 */       if (postEventsForChanges()) {
/* 1672 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addPartyLocaleInformation(IPartyLocaleInformation argPartyLocaleInformation) {
/* 1678 */     super.addPartyLocaleInformation(argPartyLocaleInformation);
/*      */ 
/*      */     
/* 1681 */     argPartyLocaleInformation.setParentParty(this);
/* 1682 */     if (this._localeInformation == null) {
/* 1683 */       this._localeInformation = new HistoricalList(null);
/*      */     }
/* 1685 */     argPartyLocaleInformation.setOrganizationId(getOrganizationId());
/* 1686 */     argPartyLocaleInformation.setPartyId(getPartyId());
/* 1687 */     if (argPartyLocaleInformation instanceof IDataModelImpl) {
/* 1688 */       IDataAccessObject childDao = ((IDataModelImpl)argPartyLocaleInformation).getDAO();
/* 1689 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1690 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1691 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1696 */     if (postEventsForChanges()) {
/* 1697 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyLocaleInformation));
/*      */     }
/*      */     
/* 1700 */     this._localeInformation.add(argPartyLocaleInformation);
/* 1701 */     if (postEventsForChanges()) {
/* 1702 */       this._events.post(IParty.ADD_LOCALEINFORMATION, argPartyLocaleInformation);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removePartyLocaleInformation(IPartyLocaleInformation argPartyLocaleInformation) {
/* 1707 */     if (this._localeInformation != null) {
/*      */       
/* 1709 */       if (postEventsForChanges()) {
/* 1710 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyLocaleInformation));
/*      */       }
/* 1712 */       this._localeInformation.remove(argPartyLocaleInformation);
/*      */       
/* 1714 */       argPartyLocaleInformation.setParentParty(null);
/* 1715 */       if (postEventsForChanges()) {
/* 1716 */         this._events.post(IParty.REMOVE_LOCALEINFORMATION, argPartyLocaleInformation);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "TelephoneInformation")
/*      */   public List<IPartyTelephone> getTelephoneInformation() {
/* 1723 */     if (this._telephoneInformation == null) {
/* 1724 */       this._telephoneInformation = new HistoricalList(null);
/*      */     }
/* 1726 */     return (List<IPartyTelephone>)this._telephoneInformation;
/*      */   }
/*      */   
/*      */   public void setTelephoneInformation(List<IPartyTelephone> argTelephoneInformation) {
/* 1730 */     if (this._telephoneInformation == null) {
/* 1731 */       this._telephoneInformation = new HistoricalList(argTelephoneInformation);
/*      */     } else {
/* 1733 */       this._telephoneInformation.setCurrentList(argTelephoneInformation);
/*      */     } 
/*      */     
/* 1736 */     for (IPartyTelephone child : this._telephoneInformation) {
/* 1737 */       PartyTelephoneModel model = (PartyTelephoneModel)child;
/* 1738 */       model.setOrganizationId_noev(getOrganizationId());
/* 1739 */       model.setPartyId_noev(getPartyId());
/* 1740 */       if (child instanceof IDataModelImpl) {
/* 1741 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1742 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1743 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1744 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1747 */       if (postEventsForChanges()) {
/* 1748 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addPartyTelephone(IPartyTelephone argPartyTelephone) {
/* 1754 */     if (this._telephoneInformation == null) {
/* 1755 */       this._telephoneInformation = new HistoricalList(null);
/*      */     }
/* 1757 */     argPartyTelephone.setOrganizationId(getOrganizationId());
/* 1758 */     argPartyTelephone.setPartyId(getPartyId());
/* 1759 */     if (argPartyTelephone instanceof IDataModelImpl) {
/* 1760 */       IDataAccessObject childDao = ((IDataModelImpl)argPartyTelephone).getDAO();
/* 1761 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1762 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1763 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1768 */     if (postEventsForChanges()) {
/* 1769 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyTelephone));
/*      */     }
/*      */     
/* 1772 */     this._telephoneInformation.add(argPartyTelephone);
/* 1773 */     if (postEventsForChanges()) {
/* 1774 */       this._events.post(IParty.ADD_TELEPHONEINFORMATION, argPartyTelephone);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removePartyTelephone(IPartyTelephone argPartyTelephone) {
/* 1779 */     if (this._telephoneInformation != null) {
/*      */       
/* 1781 */       if (postEventsForChanges()) {
/* 1782 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyTelephone));
/*      */       }
/* 1784 */       this._telephoneInformation.remove(argPartyTelephone);
/* 1785 */       if (postEventsForChanges()) {
/* 1786 */         this._events.post(IParty.REMOVE_TELEPHONEINFORMATION, argPartyTelephone);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "EmailInformation")
/*      */   public List<IPartyEmail> getEmailInformation() {
/* 1793 */     if (this._emailInformation == null) {
/* 1794 */       this._emailInformation = new HistoricalList(null);
/*      */     }
/* 1796 */     return (List<IPartyEmail>)this._emailInformation;
/*      */   }
/*      */   
/*      */   public void setEmailInformation(List<IPartyEmail> argEmailInformation) {
/* 1800 */     if (this._emailInformation == null) {
/* 1801 */       this._emailInformation = new HistoricalList(argEmailInformation);
/*      */     } else {
/* 1803 */       this._emailInformation.setCurrentList(argEmailInformation);
/*      */     } 
/*      */     
/* 1806 */     for (IPartyEmail child : this._emailInformation) {
/* 1807 */       child.setParentParty(this);
/*      */     }
/*      */ 
/*      */     
/* 1811 */     for (IPartyEmail child : this._emailInformation) {
/* 1812 */       PartyEmailModel model = (PartyEmailModel)child;
/* 1813 */       model.setOrganizationId_noev(getOrganizationId());
/* 1814 */       model.setPartyId_noev(getPartyId());
/* 1815 */       if (child instanceof IDataModelImpl) {
/* 1816 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1817 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1818 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1819 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1822 */       if (postEventsForChanges()) {
/* 1823 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addPartyEmail(IPartyEmail argPartyEmail) {
/* 1829 */     super.addPartyEmail(argPartyEmail);
/*      */ 
/*      */     
/* 1832 */     argPartyEmail.setParentParty(this);
/* 1833 */     if (this._emailInformation == null) {
/* 1834 */       this._emailInformation = new HistoricalList(null);
/*      */     }
/* 1836 */     argPartyEmail.setOrganizationId(getOrganizationId());
/* 1837 */     argPartyEmail.setPartyId(getPartyId());
/* 1838 */     if (argPartyEmail instanceof IDataModelImpl) {
/* 1839 */       IDataAccessObject childDao = ((IDataModelImpl)argPartyEmail).getDAO();
/* 1840 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1841 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1842 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1847 */     if (postEventsForChanges()) {
/* 1848 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyEmail));
/*      */     }
/*      */     
/* 1851 */     this._emailInformation.add(argPartyEmail);
/* 1852 */     if (postEventsForChanges()) {
/* 1853 */       this._events.post(IParty.ADD_EMAILINFORMATION, argPartyEmail);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removePartyEmail(IPartyEmail argPartyEmail) {
/* 1858 */     if (this._emailInformation != null) {
/*      */       
/* 1860 */       if (postEventsForChanges()) {
/* 1861 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyEmail));
/*      */       }
/* 1863 */       this._emailInformation.remove(argPartyEmail);
/*      */       
/* 1865 */       argPartyEmail.setParentParty(null);
/* 1866 */       if (postEventsForChanges()) {
/* 1867 */         this._events.post(IParty.REMOVE_EMAILINFORMATION, argPartyEmail);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "LoyaltyCards")
/*      */   public List<ICustomerLoyaltyCard> getLoyaltyCards() {
/* 1874 */     if (this._loyaltyCards == null) {
/* 1875 */       this._loyaltyCards = new HistoricalList(null);
/*      */     }
/* 1877 */     return (List<ICustomerLoyaltyCard>)this._loyaltyCards;
/*      */   }
/*      */   
/*      */   public void setLoyaltyCards(List<ICustomerLoyaltyCard> argLoyaltyCards) {
/* 1881 */     if (this._loyaltyCards == null) {
/* 1882 */       this._loyaltyCards = new HistoricalList(argLoyaltyCards);
/*      */     } else {
/* 1884 */       this._loyaltyCards.setCurrentList(argLoyaltyCards);
/*      */     } 
/*      */     
/* 1887 */     for (ICustomerLoyaltyCard child : this._loyaltyCards) {
/* 1888 */       CustomerLoyaltyCardModel model = (CustomerLoyaltyCardModel)child;
/* 1889 */       model.setOrganizationId_noev(getOrganizationId());
/* 1890 */       model.setPartyId_noev(getPartyId());
/* 1891 */       if (child instanceof IDataModelImpl) {
/* 1892 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1893 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1894 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1895 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1898 */       if (postEventsForChanges()) {
/* 1899 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addCustomerLoyaltyCard(ICustomerLoyaltyCard argCustomerLoyaltyCard) {
/* 1905 */     if (this._loyaltyCards == null) {
/* 1906 */       this._loyaltyCards = new HistoricalList(null);
/*      */     }
/* 1908 */     argCustomerLoyaltyCard.setOrganizationId(getOrganizationId());
/* 1909 */     argCustomerLoyaltyCard.setPartyId(getPartyId());
/* 1910 */     if (argCustomerLoyaltyCard instanceof IDataModelImpl) {
/* 1911 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerLoyaltyCard).getDAO();
/* 1912 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1913 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1914 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1919 */     if (postEventsForChanges()) {
/* 1920 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerLoyaltyCard));
/*      */     }
/*      */     
/* 1923 */     this._loyaltyCards.add(argCustomerLoyaltyCard);
/* 1924 */     if (postEventsForChanges()) {
/* 1925 */       this._events.post(IParty.ADD_LOYALTYCARDS, argCustomerLoyaltyCard);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeCustomerLoyaltyCard(ICustomerLoyaltyCard argCustomerLoyaltyCard) {
/* 1930 */     if (this._loyaltyCards != null) {
/*      */       
/* 1932 */       if (postEventsForChanges()) {
/* 1933 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerLoyaltyCard));
/*      */       }
/* 1935 */       this._loyaltyCards.remove(argCustomerLoyaltyCard);
/* 1936 */       if (postEventsForChanges()) {
/* 1937 */         this._events.post(IParty.REMOVE_LOYALTYCARDS, argCustomerLoyaltyCard);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "CustomerNotes")
/*      */   public List<ICustomerNote> getCustomerNotes() {
/* 1944 */     if (this._customerNotes == null) {
/* 1945 */       this._customerNotes = new HistoricalList(null);
/*      */     }
/* 1947 */     return (List<ICustomerNote>)this._customerNotes;
/*      */   }
/*      */   
/*      */   public void setCustomerNotes(List<ICustomerNote> argCustomerNotes) {
/* 1951 */     if (this._customerNotes == null) {
/* 1952 */       this._customerNotes = new HistoricalList(argCustomerNotes);
/*      */     } else {
/* 1954 */       this._customerNotes.setCurrentList(argCustomerNotes);
/*      */     } 
/*      */     
/* 1957 */     for (ICustomerNote child : this._customerNotes) {
/* 1958 */       CustomerNoteModel model = (CustomerNoteModel)child;
/* 1959 */       model.setOrganizationId_noev(getOrganizationId());
/* 1960 */       model.setPartyId_noev(getPartyId());
/* 1961 */       if (child instanceof IDataModelImpl) {
/* 1962 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1963 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1964 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1965 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1968 */       if (postEventsForChanges()) {
/* 1969 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addCustomerNote(ICustomerNote argCustomerNote) {
/* 1975 */     super.addCustomerNote(argCustomerNote);
/*      */     
/* 1977 */     if (this._customerNotes == null) {
/* 1978 */       this._customerNotes = new HistoricalList(null);
/*      */     }
/* 1980 */     argCustomerNote.setOrganizationId(getOrganizationId());
/* 1981 */     argCustomerNote.setPartyId(getPartyId());
/* 1982 */     if (argCustomerNote instanceof IDataModelImpl) {
/* 1983 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerNote).getDAO();
/* 1984 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1985 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1986 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1991 */     if (postEventsForChanges()) {
/* 1992 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerNote));
/*      */     }
/*      */     
/* 1995 */     this._customerNotes.add(argCustomerNote);
/* 1996 */     if (postEventsForChanges()) {
/* 1997 */       this._events.post(IParty.ADD_CUSTOMERNOTES, argCustomerNote);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeCustomerNote(ICustomerNote argCustomerNote) {
/* 2002 */     if (this._customerNotes != null) {
/*      */       
/* 2004 */       if (postEventsForChanges()) {
/* 2005 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerNote));
/*      */       }
/* 2007 */       this._customerNotes.remove(argCustomerNote);
/* 2008 */       if (postEventsForChanges()) {
/* 2009 */         this._events.post(IParty.REMOVE_CUSTOMERNOTES, argCustomerNote);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IPartyProperty> getProperties() {
/* 2016 */     if (this._properties == null) {
/* 2017 */       this._properties = new HistoricalList(null);
/*      */     }
/* 2019 */     return (List<IPartyProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IPartyProperty> argProperties) {
/* 2023 */     if (this._properties == null) {
/* 2024 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 2026 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 2029 */     for (IPartyProperty child : this._properties) {
/* 2030 */       PartyPropertyModel model = (PartyPropertyModel)child;
/* 2031 */       model.setOrganizationId_noev(getOrganizationId());
/* 2032 */       model.setPartyId_noev(getPartyId());
/* 2033 */       if (child instanceof IDataModelImpl) {
/* 2034 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 2035 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 2036 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 2037 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 2040 */       if (postEventsForChanges()) {
/* 2041 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addPartyProperty(IPartyProperty argPartyProperty) {
/* 2047 */     if (this._properties == null) {
/* 2048 */       this._properties = new HistoricalList(null);
/*      */     }
/* 2050 */     argPartyProperty.setOrganizationId(getOrganizationId());
/* 2051 */     argPartyProperty.setPartyId(getPartyId());
/* 2052 */     if (argPartyProperty instanceof IDataModelImpl) {
/* 2053 */       IDataAccessObject childDao = ((IDataModelImpl)argPartyProperty).getDAO();
/* 2054 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 2055 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 2056 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2061 */     if (postEventsForChanges()) {
/* 2062 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyProperty));
/*      */     }
/*      */     
/* 2065 */     this._properties.add(argPartyProperty);
/* 2066 */     if (postEventsForChanges()) {
/* 2067 */       this._events.post(IParty.ADD_PROPERTIES, argPartyProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removePartyProperty(IPartyProperty argPartyProperty) {
/* 2072 */     if (this._properties != null) {
/*      */       
/* 2074 */       if (postEventsForChanges()) {
/* 2075 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyProperty));
/*      */       }
/* 2077 */       this._properties.remove(argPartyProperty);
/* 2078 */       if (postEventsForChanges()) {
/* 2079 */         this._events.post(IParty.REMOVE_PROPERTIES, argPartyProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 2086 */     if ("AlternatePartyIds".equals(argFieldId)) {
/* 2087 */       return getAlternatePartyIds();
/*      */     }
/* 2089 */     if ("CustomerGroups".equals(argFieldId)) {
/* 2090 */       return getCustomerGroups();
/*      */     }
/* 2092 */     if ("LocaleInformation".equals(argFieldId)) {
/* 2093 */       return getLocaleInformation();
/*      */     }
/* 2095 */     if ("TelephoneInformation".equals(argFieldId)) {
/* 2096 */       return getTelephoneInformation();
/*      */     }
/* 2098 */     if ("EmailInformation".equals(argFieldId)) {
/* 2099 */       return getEmailInformation();
/*      */     }
/* 2101 */     if ("LoyaltyCards".equals(argFieldId)) {
/* 2102 */       return getLoyaltyCards();
/*      */     }
/* 2104 */     if ("CustomerNotes".equals(argFieldId)) {
/* 2105 */       return getCustomerNotes();
/*      */     }
/* 2107 */     if ("Properties".equals(argFieldId)) {
/* 2108 */       return getProperties();
/*      */     }
/* 2110 */     if ("PartyExtension".equals(argFieldId)) {
/* 2111 */       return this._myExtension;
/*      */     }
/*      */     
/* 2114 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 2120 */     if ("AlternatePartyIds".equals(argFieldId)) {
/* 2121 */       setAlternatePartyIds(changeToList(argValue, IPartyIdCrossReference.class));
/*      */     }
/* 2123 */     else if ("CustomerGroups".equals(argFieldId)) {
/* 2124 */       setCustomerGroups(changeToList(argValue, ICustomerAffiliation.class));
/*      */     }
/* 2126 */     else if ("LocaleInformation".equals(argFieldId)) {
/* 2127 */       setLocaleInformation(changeToList(argValue, IPartyLocaleInformation.class));
/*      */     }
/* 2129 */     else if ("TelephoneInformation".equals(argFieldId)) {
/* 2130 */       setTelephoneInformation(changeToList(argValue, IPartyTelephone.class));
/*      */     }
/* 2132 */     else if ("EmailInformation".equals(argFieldId)) {
/* 2133 */       setEmailInformation(changeToList(argValue, IPartyEmail.class));
/*      */     }
/* 2135 */     else if ("LoyaltyCards".equals(argFieldId)) {
/* 2136 */       setLoyaltyCards(changeToList(argValue, ICustomerLoyaltyCard.class));
/*      */     }
/* 2138 */     else if ("CustomerNotes".equals(argFieldId)) {
/* 2139 */       setCustomerNotes(changeToList(argValue, ICustomerNote.class));
/*      */     }
/* 2141 */     else if ("Properties".equals(argFieldId)) {
/* 2142 */       setProperties(changeToList(argValue, IPartyProperty.class));
/*      */     }
/* 2144 */     else if ("PartyExtension".equals(argFieldId)) {
/* 2145 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 2148 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 2154 */     this._persistenceDefaults = argPD;
/* 2155 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 2156 */     this._eventManager = argEM;
/* 2157 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 2158 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 2159 */     if (this._alternatePartyIds != null) {
/* 2160 */       for (IPartyIdCrossReference relationship : this._alternatePartyIds) {
/* 2161 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 2164 */     if (this._customerGroups != null) {
/* 2165 */       for (ICustomerAffiliation relationship : this._customerGroups) {
/* 2166 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 2169 */     if (this._localeInformation != null) {
/* 2170 */       for (IPartyLocaleInformation relationship : this._localeInformation) {
/* 2171 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 2174 */     if (this._telephoneInformation != null) {
/* 2175 */       for (IPartyTelephone relationship : this._telephoneInformation) {
/* 2176 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 2179 */     if (this._emailInformation != null) {
/* 2180 */       for (IPartyEmail relationship : this._emailInformation) {
/* 2181 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 2184 */     if (this._loyaltyCards != null) {
/* 2185 */       for (ICustomerLoyaltyCard relationship : this._loyaltyCards) {
/* 2186 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 2189 */     if (this._customerNotes != null) {
/* 2190 */       for (ICustomerNote relationship : this._customerNotes) {
/* 2191 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 2194 */     if (this._properties != null) {
/* 2195 */       for (IPartyProperty relationship : this._properties) {
/* 2196 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getPartyExt() {
/* 2202 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setPartyExt(IDataModel argExt) {
/* 2206 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 2211 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 2215 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 2218 */     super.startTransaction();
/*      */     
/* 2220 */     this._alternatePartyIdsSavepoint = this._alternatePartyIds;
/* 2221 */     if (this._alternatePartyIds != null) {
/* 2222 */       this._alternatePartyIdsSavepoint = new HistoricalList((List)this._alternatePartyIds);
/* 2223 */       Iterator<IDataModel> it = this._alternatePartyIds.iterator();
/* 2224 */       while (it.hasNext()) {
/* 2225 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 2229 */     this._customerGroupsSavepoint = this._customerGroups;
/* 2230 */     if (this._customerGroups != null) {
/* 2231 */       this._customerGroupsSavepoint = new HistoricalList((List)this._customerGroups);
/* 2232 */       Iterator<IDataModel> it = this._customerGroups.iterator();
/* 2233 */       while (it.hasNext()) {
/* 2234 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 2238 */     this._localeInformationSavepoint = this._localeInformation;
/* 2239 */     if (this._localeInformation != null) {
/* 2240 */       this._localeInformationSavepoint = new HistoricalList((List)this._localeInformation);
/* 2241 */       Iterator<IDataModel> it = this._localeInformation.iterator();
/* 2242 */       while (it.hasNext()) {
/* 2243 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 2247 */     this._telephoneInformationSavepoint = this._telephoneInformation;
/* 2248 */     if (this._telephoneInformation != null) {
/* 2249 */       this._telephoneInformationSavepoint = new HistoricalList((List)this._telephoneInformation);
/* 2250 */       Iterator<IDataModel> it = this._telephoneInformation.iterator();
/* 2251 */       while (it.hasNext()) {
/* 2252 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 2256 */     this._emailInformationSavepoint = this._emailInformation;
/* 2257 */     if (this._emailInformation != null) {
/* 2258 */       this._emailInformationSavepoint = new HistoricalList((List)this._emailInformation);
/* 2259 */       Iterator<IDataModel> it = this._emailInformation.iterator();
/* 2260 */       while (it.hasNext()) {
/* 2261 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 2265 */     this._loyaltyCardsSavepoint = this._loyaltyCards;
/* 2266 */     if (this._loyaltyCards != null) {
/* 2267 */       this._loyaltyCardsSavepoint = new HistoricalList((List)this._loyaltyCards);
/* 2268 */       Iterator<IDataModel> it = this._loyaltyCards.iterator();
/* 2269 */       while (it.hasNext()) {
/* 2270 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 2274 */     this._customerNotesSavepoint = this._customerNotes;
/* 2275 */     if (this._customerNotes != null) {
/* 2276 */       this._customerNotesSavepoint = new HistoricalList((List)this._customerNotes);
/* 2277 */       Iterator<IDataModel> it = this._customerNotes.iterator();
/* 2278 */       while (it.hasNext()) {
/* 2279 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 2283 */     this._propertiesSavepoint = this._properties;
/* 2284 */     if (this._properties != null) {
/* 2285 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 2286 */       Iterator<IDataModel> it = this._properties.iterator();
/* 2287 */       while (it.hasNext()) {
/* 2288 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2293 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 2298 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 2301 */     super.rollbackChanges();
/*      */     
/* 2303 */     this._alternatePartyIds = this._alternatePartyIdsSavepoint;
/* 2304 */     this._alternatePartyIdsSavepoint = null;
/* 2305 */     if (this._alternatePartyIds != null) {
/* 2306 */       Iterator<IDataModel> it = this._alternatePartyIds.iterator();
/* 2307 */       while (it.hasNext()) {
/* 2308 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2312 */     this._customerGroups = this._customerGroupsSavepoint;
/* 2313 */     this._customerGroupsSavepoint = null;
/* 2314 */     if (this._customerGroups != null) {
/* 2315 */       Iterator<IDataModel> it = this._customerGroups.iterator();
/* 2316 */       while (it.hasNext()) {
/* 2317 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2321 */     this._localeInformation = this._localeInformationSavepoint;
/* 2322 */     this._localeInformationSavepoint = null;
/* 2323 */     if (this._localeInformation != null) {
/* 2324 */       Iterator<IDataModel> it = this._localeInformation.iterator();
/* 2325 */       while (it.hasNext()) {
/* 2326 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2330 */     this._telephoneInformation = this._telephoneInformationSavepoint;
/* 2331 */     this._telephoneInformationSavepoint = null;
/* 2332 */     if (this._telephoneInformation != null) {
/* 2333 */       Iterator<IDataModel> it = this._telephoneInformation.iterator();
/* 2334 */       while (it.hasNext()) {
/* 2335 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2339 */     this._emailInformation = this._emailInformationSavepoint;
/* 2340 */     this._emailInformationSavepoint = null;
/* 2341 */     if (this._emailInformation != null) {
/* 2342 */       Iterator<IDataModel> it = this._emailInformation.iterator();
/* 2343 */       while (it.hasNext()) {
/* 2344 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2348 */     this._loyaltyCards = this._loyaltyCardsSavepoint;
/* 2349 */     this._loyaltyCardsSavepoint = null;
/* 2350 */     if (this._loyaltyCards != null) {
/* 2351 */       Iterator<IDataModel> it = this._loyaltyCards.iterator();
/* 2352 */       while (it.hasNext()) {
/* 2353 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2357 */     this._customerNotes = this._customerNotesSavepoint;
/* 2358 */     this._customerNotesSavepoint = null;
/* 2359 */     if (this._customerNotes != null) {
/* 2360 */       Iterator<IDataModel> it = this._customerNotes.iterator();
/* 2361 */       while (it.hasNext()) {
/* 2362 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2366 */     this._properties = this._propertiesSavepoint;
/* 2367 */     this._propertiesSavepoint = null;
/* 2368 */     if (this._properties != null) {
/* 2369 */       Iterator<IDataModel> it = this._properties.iterator();
/* 2370 */       while (it.hasNext()) {
/* 2371 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 2379 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 2382 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 2385 */     super.commitTransaction();
/*      */     
/* 2387 */     this._alternatePartyIdsSavepoint = this._alternatePartyIds;
/* 2388 */     if (this._alternatePartyIds != null) {
/* 2389 */       Iterator<IDataModel> it = this._alternatePartyIds.iterator();
/* 2390 */       while (it.hasNext()) {
/* 2391 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2393 */       this._alternatePartyIds = new HistoricalList((List)this._alternatePartyIds);
/*      */     } 
/*      */     
/* 2396 */     this._customerGroupsSavepoint = this._customerGroups;
/* 2397 */     if (this._customerGroups != null) {
/* 2398 */       Iterator<IDataModel> it = this._customerGroups.iterator();
/* 2399 */       while (it.hasNext()) {
/* 2400 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2402 */       this._customerGroups = new HistoricalList((List)this._customerGroups);
/*      */     } 
/*      */     
/* 2405 */     this._localeInformationSavepoint = this._localeInformation;
/* 2406 */     if (this._localeInformation != null) {
/* 2407 */       Iterator<IDataModel> it = this._localeInformation.iterator();
/* 2408 */       while (it.hasNext()) {
/* 2409 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2411 */       this._localeInformation = new HistoricalList((List)this._localeInformation);
/*      */     } 
/*      */     
/* 2414 */     this._telephoneInformationSavepoint = this._telephoneInformation;
/* 2415 */     if (this._telephoneInformation != null) {
/* 2416 */       Iterator<IDataModel> it = this._telephoneInformation.iterator();
/* 2417 */       while (it.hasNext()) {
/* 2418 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2420 */       this._telephoneInformation = new HistoricalList((List)this._telephoneInformation);
/*      */     } 
/*      */     
/* 2423 */     this._emailInformationSavepoint = this._emailInformation;
/* 2424 */     if (this._emailInformation != null) {
/* 2425 */       Iterator<IDataModel> it = this._emailInformation.iterator();
/* 2426 */       while (it.hasNext()) {
/* 2427 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2429 */       this._emailInformation = new HistoricalList((List)this._emailInformation);
/*      */     } 
/*      */     
/* 2432 */     this._loyaltyCardsSavepoint = this._loyaltyCards;
/* 2433 */     if (this._loyaltyCards != null) {
/* 2434 */       Iterator<IDataModel> it = this._loyaltyCards.iterator();
/* 2435 */       while (it.hasNext()) {
/* 2436 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2438 */       this._loyaltyCards = new HistoricalList((List)this._loyaltyCards);
/*      */     } 
/*      */     
/* 2441 */     this._customerNotesSavepoint = this._customerNotes;
/* 2442 */     if (this._customerNotes != null) {
/* 2443 */       Iterator<IDataModel> it = this._customerNotes.iterator();
/* 2444 */       while (it.hasNext()) {
/* 2445 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2447 */       this._customerNotes = new HistoricalList((List)this._customerNotes);
/*      */     } 
/*      */     
/* 2450 */     this._propertiesSavepoint = this._properties;
/* 2451 */     if (this._properties != null) {
/* 2452 */       Iterator<IDataModel> it = this._properties.iterator();
/* 2453 */       while (it.hasNext()) {
/* 2454 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2456 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 2460 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */