/*     */ package dtv.xst.dao.crm.impl;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.ICustomerLoyaltyCard;
/*     */ import dtv.xst.dao.crm.ICustomerNote;
/*     */ import dtv.xst.dao.crm.IPartyEmail;
/*     */ import dtv.xst.dao.crm.IPartyIdCrossReference;
/*     */ import dtv.xst.dao.crm.IPartyLocaleInformation;
/*     */ import dtv.xst.dao.crm.IPartyModel;
/*     */ import dtv.xst.dao.crm.IPartyProperty;
/*     */ import dtv.xst.dao.crm.IPartySegment;
/*     */ import dtv.xst.dao.crm.IPartyTelephone;
/*     */ import dtv.xst.dao.crm.PartyEmailId;
/*     */ import dtv.xst.dao.crm.PartyIdCrossReferenceId;
/*     */ import dtv.xst.dao.crm.PartyLocaleInformationId;
/*     */ import dtv.xst.dao.crm.PartyTelephoneId;
/*     */ import dtv.xst.dao.hrs.EmployeeId;
/*     */ import dtv.xst.dao.prc.DealId;
/*     */ import dtv.xst.daocommon.TelephoneType;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ 
/*     */ public abstract class PartyBaseModel extends AbstractDataModelWithPropertyImpl<IPartyProperty> implements IParty, IPartyModel {
/*  29 */   private transient List<IPartySegment> _partySegments = null; private static final long serialVersionUID = 1L;
/*  30 */   private transient Set<DealId> _targetedDeals = null;
/*     */   private transient boolean _promptedForLoyalty = false;
/*     */   private transient boolean _promptedForLoyaltyExpiration = false;
/*  33 */   private transient String _securityPrivilege = "";
/*     */ 
/*     */ 
/*     */   
/*     */   public void addCustomerNote(ICustomerNote argCustomerNote) {
/*  38 */     if (argCustomerNote.getNoteSequence() <= 0L) {
/*  39 */       argCustomerNote.setNoteSequence((getCustomerNotes().size() + 1));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addPartyEmail(IPartyEmail argPartyEmail) {
/*  46 */     if (argPartyEmail.getSequence() <= 0) {
/*  47 */       argPartyEmail.setSequence(getEmailInformation().size() + 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addPartyLocaleInformation(IPartyLocaleInformation argPartyLocaleInformation) {
/*  54 */     if (argPartyLocaleInformation.getSequence() <= 0) {
/*  55 */       argPartyLocaleInformation.setSequence(getLocaleInformation().size() + 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSegment(IPartySegment argSegment) {
/*  62 */     getSegments().add(argSegment);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addTargetedDeal(DealId argTargetedDeal) {
/*  68 */     getTargetedDeals().add(argTargetedDeal);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAlternatePartyId(String argAlternateIdOwner) {
/*  74 */     String xrefValue = null;
/*     */ 
/*     */     
/*  77 */     for (IPartyIdCrossReference xref : getAlternatePartyIds()) {
/*  78 */       if (xref.getAlternateIdOwner().equalsIgnoreCase(argAlternateIdOwner)) {
/*  79 */         xrefValue = xref.getAlternateId();
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  84 */     return xrefValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCountry() {
/*  90 */     return (getPrimaryLocaleInformation() != null) ? getPrimaryLocaleInformation().getCountry() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomerPropertyValue(String argKey) {
/*  96 */     return getStringProperty(argKey, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmailAddress() {
/* 102 */     IPartyEmail primaryEmail = getPrimaryEmailInformation();
/* 103 */     return (primaryEmail != null) ? primaryEmail.getEmailAddress() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getEmailContact() {
/* 109 */     IPartyEmail primaryEmail = getPrimaryEmailInformation();
/* 110 */     return (primaryEmail == null) ? false : primaryEmail.getContact();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EmployeeId getEmployeeIdObject() {
/* 116 */     EmployeeId id = new EmployeeId();
/* 117 */     id.setEmployeeId(getEmployeeId());
/* 118 */     return id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ICustomerLoyaltyCard> getExpiringLoyaltyCards(Date argCurrentDate, Integer argDaysMargin) {
/* 129 */     List<ICustomerLoyaltyCard> list = new ArrayList<>();
/*     */     
/* 131 */     if (argCurrentDate == null || argDaysMargin == null) {
/* 132 */       return list;
/*     */     }
/*     */     
/* 135 */     for (ICustomerLoyaltyCard card : getLoyaltyCards()) {
/* 136 */       if (card.getExpirationDate() != null) {
/* 137 */         long currentDate = argCurrentDate.getTime();
/* 138 */         long expirationDate = card.getExpirationDate().getTime();
/* 139 */         long margin = argDaysMargin.longValue() * 24L * 60L * 60L * 1000L;
/*     */         
/* 141 */         if (currentDate + margin >= expirationDate) {
/* 142 */           list.add(card);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 148 */     list.sort(Comparator.comparing(ICustomerLoyaltyCard::getExpirationDate, 
/* 149 */           Comparator.nullsLast(Comparator.naturalOrder())));
/*     */     
/* 151 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ICustomerLoyaltyCard> getExpiringLoyaltyCards(DtvDate argCurrentDate, Integer argDaysMargin) {
/* 162 */     return getExpiringLoyaltyCards((Date)argCurrentDate, argDaysMargin);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getMailingList() {
/* 168 */     IPartyLocaleInformation primaryAddress = getPrimaryLocaleInformation();
/* 169 */     return (primaryAddress == null) ? false : primaryAddress.getContact();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMaskedSocialSecurityNbr() {
/* 175 */     return getStringProperty("MASKED_SSN_PROPERTY");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IPartyEmail getPrimaryEmailInformation() {
/* 181 */     IPartyEmail primaryEmail = null;
/*     */     
/* 183 */     for (IPartyEmail email : getEmailInformation()) {
/* 184 */       if (email.getPrimary()) {
/* 185 */         primaryEmail = email;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 190 */     if (primaryEmail == null && !getEmailInformation().isEmpty()) {
/* 191 */       primaryEmail = getEmailInformation().get(0);
/*     */     }
/*     */     
/* 194 */     return primaryEmail;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IPartyLocaleInformation getPrimaryLocaleInformation() {
/* 200 */     IPartyLocaleInformation primaryLocale = null;
/*     */ 
/*     */     
/* 203 */     for (IPartyLocaleInformation locale : getLocaleInformation()) {
/* 204 */       if (locale.getPrimary()) {
/* 205 */         primaryLocale = locale;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 211 */     if (primaryLocale == null && !getLocaleInformation().isEmpty()) {
/* 212 */       primaryLocale = getLocaleInformation().get(0);
/*     */     }
/*     */     
/* 215 */     return primaryLocale;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ICustomerLoyaltyCard getPrimaryLoyaltyCard() {
/* 221 */     return getLoyaltyCards().isEmpty() ? null : getLoyaltyCards().get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IPartyTelephone getPrimaryTelephoneInformation() {
/* 227 */     IPartyTelephone primaryTelephone = null;
/*     */ 
/*     */     
/* 230 */     for (IPartyTelephone telephone : getTelephoneInformation()) {
/* 231 */       if (telephone.getPrimary()) {
/* 232 */         primaryTelephone = telephone;
/*     */ 
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 239 */     if (primaryTelephone == null) {
/* 240 */       primaryTelephone = getTelephoneInformation(TelephoneType.HOME.name(), false);
/*     */     }
/*     */ 
/*     */     
/* 244 */     if (primaryTelephone == null && !getTelephoneInformation().isEmpty()) {
/* 245 */       primaryTelephone = getTelephoneInformation().get(0);
/*     */     }
/*     */     
/* 248 */     return primaryTelephone;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPromptedForLoyalty() {
/* 254 */     return this._promptedForLoyalty;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPromptedForLoyaltyExpiration() {
/* 260 */     return this._promptedForLoyaltyExpiration;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSecurityPrivilege() {
/* 266 */     return this._securityPrivilege;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IPartySegment> getSegments() {
/* 273 */     if (this._partySegments == null) {
/* 274 */       this._partySegments = new ArrayList<>();
/*     */     }
/*     */     
/* 277 */     return this._partySegments;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<DealId> getTargetedDeals() {
/* 284 */     if (this._targetedDeals == null) {
/* 285 */       this._targetedDeals = new HashSet<>();
/*     */     }
/*     */     
/* 288 */     return this._targetedDeals;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephone1() {
/* 294 */     return getTelephoneNumber(1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getTelephone1Contact() {
/* 300 */     return getTelephoneContact(1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephone2() {
/* 306 */     return getTelephoneNumber(2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getTelephone2Contact() {
/* 312 */     return getTelephoneContact(2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephone3() {
/* 318 */     return getTelephoneNumber(3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getTelephone3Contact() {
/* 324 */     return getTelephoneContact(3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephone4() {
/* 330 */     return getTelephoneNumber(4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getTelephone4Contact() {
/* 336 */     return getTelephoneContact(4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IPartyTelephone getTelephoneInformation(int argPhoneIdx) {
/* 342 */     return getTelephoneInformation(argPhoneIdx, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IPartyTelephone getTelephoneInformation(String argPhoneType, boolean argCreateIfNotExists) {
/* 348 */     IPartyTelephone result = null;
/*     */     
/* 350 */     for (IPartyTelephone phone : getTelephoneInformation()) {
/* 351 */       if (phone.getTelephoneType().equalsIgnoreCase(argPhoneType)) {
/* 352 */         result = phone;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 357 */     if (result == null && argCreateIfNotExists) {
/* 358 */       PartyTelephoneId phoneId = new PartyTelephoneId();
/* 359 */       phoneId.setOrganizationId(Long.valueOf(getOrganizationId()));
/* 360 */       phoneId.setPartyId(Long.valueOf(getPartyId()));
/* 361 */       phoneId.setTelephoneType(argPhoneType);
/*     */       
/* 363 */       result = (IPartyTelephone)DataFactory.createObject((IObjectId)phoneId, IPartyTelephone.class);
/*     */       
/* 365 */       addPartyTelephone(result);
/*     */     } 
/*     */     
/* 368 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeSegment(IPartySegment argSegment) {
/* 374 */     getSegments().remove(argSegment);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeTargetedDeal(DealId argTargetedDeal) {
/* 380 */     getTargetedDeals().remove(argTargetedDeal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IPartyIdCrossReference setAlternatePartyId(String argAlternateIdOwner, String argAlternateId) {
/* 387 */     for (IPartyIdCrossReference iPartyIdCrossReference : getAlternatePartyIds()) {
/* 388 */       if (iPartyIdCrossReference.getAlternateIdOwner().equalsIgnoreCase(argAlternateIdOwner)) {
/* 389 */         iPartyIdCrossReference.setAlternateId(argAlternateId);
/* 390 */         return iPartyIdCrossReference;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 395 */     PartyIdCrossReferenceId id = new PartyIdCrossReferenceId();
/* 396 */     id.setAlternateIdOwner(argAlternateIdOwner);
/*     */     
/* 398 */     IPartyIdCrossReference xref = (IPartyIdCrossReference)DataFactory.getInstance().createNewObject((IObjectId)id, IPartyIdCrossReference.class);
/*     */     
/* 400 */     xref.setAlternateId(argAlternateId);
/* 401 */     addPartyIdCrossReference(xref);
/*     */     
/* 403 */     return xref;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerPropertyValue(String argKey, String argValue) {
/* 409 */     setStringProperty(argKey, argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmailAddress(String argEmailAddress) {
/* 415 */     IPartyEmail primaryEmail = getPrimaryEmailInformation();
/*     */     
/* 417 */     if (primaryEmail == null) {
/* 418 */       primaryEmail = addPrimaryEmail();
/*     */     }
/*     */     
/* 421 */     primaryEmail.setPrimary(true);
/* 422 */     primaryEmail.setEmailAddress(argEmailAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmailContact(boolean argEmailContact) {
/* 428 */     IPartyEmail primaryEmail = getPrimaryEmailInformation();
/*     */     
/* 430 */     if (primaryEmail == null) {
/* 431 */       primaryEmail = addPrimaryEmail();
/*     */     }
/*     */     
/* 434 */     primaryEmail.setContact(argEmailContact);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMailingList(boolean argMailingList) {
/* 440 */     IPartyLocaleInformation primaryAddress = getPrimaryLocaleInformation();
/*     */     
/* 442 */     if (primaryAddress == null) {
/* 443 */       primaryAddress = addPrimaryAddress();
/*     */     }
/*     */     
/* 446 */     primaryAddress.setContact(argMailingList);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaskedSocialSecuityNbr(String argMaskedSecurityNbr) {
/* 452 */     setStringProperty("MASKED_SSN_PROPERTY", argMaskedSecurityNbr);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPromptedForLoyalty(boolean argPrompt) {
/* 458 */     this._promptedForLoyalty = argPrompt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPromptedForLoyaltyExpiration(boolean argPrompt) {
/* 464 */     this._promptedForLoyaltyExpiration = argPrompt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSecurityPrivilege(String argSecPrivilege) {
/* 470 */     this._securityPrivilege = argSecPrivilege;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSegments(List<? extends IPartySegment> argSegments) {
/* 476 */     this._partySegments = new ArrayList<>(argSegments);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTargetedDeals(Collection<? extends DealId> argTargetedDeals) {
/* 482 */     this._targetedDeals = new HashSet<>(argTargetedDeals);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone1(String argPhoneNumber) {
/* 488 */     setTelephoneNumber(1, argPhoneNumber);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone1Contact(boolean argPhoneContact) {
/* 494 */     setTelephoneContact(1, argPhoneContact);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone2(String argPhoneNumber) {
/* 500 */     setTelephoneNumber(2, argPhoneNumber);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone2Contact(boolean argPhoneContact) {
/* 506 */     setTelephoneContact(2, argPhoneContact);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone3(String argPhoneNumber) {
/* 512 */     setTelephoneNumber(3, argPhoneNumber);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone3Contact(boolean argPhoneContact) {
/* 518 */     setTelephoneContact(3, argPhoneContact);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone4(String argPhoneNumber) {
/* 524 */     setTelephoneNumber(4, argPhoneNumber);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone4Contact(boolean argPhoneContact) {
/* 530 */     setTelephoneContact(4, argPhoneContact);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephoneContact(String argPhoneType, boolean argPhoneContact) {
/* 536 */     getTelephoneInformation(argPhoneType, true).setContact(argPhoneContact);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephoneNumber(String argPhoneType, String argPhoneNumber) {
/* 542 */     getTelephoneInformation(argPhoneType, true).setTelephoneNumber(argPhoneNumber);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IPartyLocaleInformation addPrimaryAddress() {
/* 551 */     PartyLocaleInformationId addressId = new PartyLocaleInformationId();
/* 552 */     addressId.setOrganizationId(Long.valueOf(getOrganizationId()));
/* 553 */     addressId.setPartyId(Long.valueOf(getPartyId()));
/*     */     
/* 555 */     IPartyLocaleInformation address = (IPartyLocaleInformation)DataFactory.createObject((IObjectId)addressId, IPartyLocaleInformation.class);
/* 556 */     address.setPrimary(true);
/*     */     
/* 558 */     addPartyLocaleInformation(address);
/*     */     
/* 560 */     return address;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IPartyEmail addPrimaryEmail() {
/* 569 */     PartyEmailId emailId = new PartyEmailId();
/* 570 */     emailId.setOrganizationId(Long.valueOf(getOrganizationId()));
/* 571 */     emailId.setPartyId(Long.valueOf(getPartyId()));
/*     */     
/* 573 */     IPartyEmail email = (IPartyEmail)DataFactory.createObject((IObjectId)emailId, IPartyEmail.class);
/* 574 */     email.setEmailType("Home");
/* 575 */     email.setPrimary(true);
/*     */     
/* 577 */     addPartyEmail(email);
/*     */     
/* 579 */     return email;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean getTelephoneContact(int argPhoneIdx) {
/* 585 */     IPartyTelephone telephoneModel = getTelephoneInformation(argPhoneIdx, false);
/* 586 */     return (telephoneModel == null) ? false : telephoneModel.getContact();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IPartyTelephone getTelephoneInformation(int argPhoneIdx, boolean argCreateIfNotExists) {
/* 593 */     return getTelephoneInformation(getTelephoneType(argPhoneIdx), argCreateIfNotExists);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String getTelephoneNumber(int argPhoneIdx) {
/* 599 */     IPartyTelephone telephoneModel = getTelephoneInformation(argPhoneIdx, false);
/* 600 */     return (telephoneModel == null) ? null : telephoneModel.getTelephoneNumber();
/*     */   }
/*     */ 
/*     */   
/*     */   private String getTelephoneType(int argPhoneIdx) {
/* 605 */     TelephoneType type = TelephoneType.values()[argPhoneIdx - 1];
/* 606 */     return type.name();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setTelephoneContact(int argPhoneIdx, boolean argPhoneContact) {
/* 612 */     getTelephoneInformation(argPhoneIdx, true).setContact(argPhoneContact);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setTelephoneNumber(int argPhoneIdx, String argPhoneNumber) {
/* 618 */     getTelephoneInformation(argPhoneIdx, true).setTelephoneNumber(argPhoneNumber);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */