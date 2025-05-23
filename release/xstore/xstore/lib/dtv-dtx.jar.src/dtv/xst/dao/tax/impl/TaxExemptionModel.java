/*      */ package dtv.xst.dao.tax.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.DataFactory;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.com.IAddress;
/*      */ import dtv.xst.dao.com.IReasonCode;
/*      */ import dtv.xst.dao.com.ReasonCodeId;
/*      */ import dtv.xst.dao.tax.ITaxExemption;
/*      */ import dtv.xst.dao.tax.ITaxExemptionProperty;
/*      */ import dtv.xst.dao.tax.TaxExemptionPropertyId;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class TaxExemptionModel extends AbstractDataModelWithPropertyImpl<ITaxExemptionProperty> implements ITaxExemption {
/*      */   private static final long serialVersionUID = -1164693378L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   
/*      */   public String toString() {
/*   34 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IAddress _address; private transient IAddress _addressSavepoint; private HistoricalList<ITaxExemptionProperty> _properties; private transient HistoricalList<ITaxExemptionProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   39 */     setDAO((IDataAccessObject)new TaxExemptionDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private TaxExemptionDAO getDAO_() {
/*   47 */     return (TaxExemptionDAO)this._daoImpl;
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
/*   71 */       this._events.post(ITaxExemption.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*   86 */         Iterator<TaxExemptionPropertyModel> it = this._properties.iterator();
/*   87 */         while (it.hasNext())
/*      */         {
/*   89 */           ((TaxExemptionPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*      */   public String getTaxExemptionId() {
/*  102 */     return getDAO_().getTaxExemptionId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxExemptionId(String argTaxExemptionId) {
/*  110 */     if (setTaxExemptionId_noev(argTaxExemptionId) && 
/*  111 */       this._events != null && 
/*  112 */       postEventsForChanges()) {
/*  113 */       this._events.post(ITaxExemption.SET_TAXEXEMPTIONID, argTaxExemptionId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxExemptionId_noev(String argTaxExemptionId) {
/*  120 */     boolean ev_postable = false;
/*      */     
/*  122 */     if ((getDAO_().getTaxExemptionId() == null && argTaxExemptionId != null) || (
/*  123 */       getDAO_().getTaxExemptionId() != null && !getDAO_().getTaxExemptionId().equals(argTaxExemptionId))) {
/*  124 */       getDAO_().setTaxExemptionId(argTaxExemptionId);
/*  125 */       ev_postable = true;
/*  126 */       if (this._properties != null) {
/*      */         
/*  128 */         Iterator<TaxExemptionPropertyModel> it = this._properties.iterator();
/*  129 */         while (it.hasNext())
/*      */         {
/*  131 */           ((TaxExemptionPropertyModel)it.next()).setTaxExemptionId_noev(argTaxExemptionId);
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
/*      */   public Date getCreateDate() {
/*  144 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  152 */     if (setCreateDate_noev(argCreateDate) && 
/*  153 */       this._events != null && 
/*  154 */       postEventsForChanges()) {
/*  155 */       this._events.post(ITaxExemption.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  162 */     boolean ev_postable = false;
/*      */     
/*  164 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  165 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  166 */       getDAO_().setCreateDate(argCreateDate);
/*  167 */       ev_postable = true;
/*      */     } 
/*      */     
/*  170 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  178 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  186 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  187 */       this._events != null && 
/*  188 */       postEventsForChanges()) {
/*  189 */       this._events.post(ITaxExemption.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  196 */     boolean ev_postable = false;
/*      */     
/*  198 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  199 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  200 */       getDAO_().setCreateUserId(argCreateUserId);
/*  201 */       ev_postable = true;
/*      */     } 
/*      */     
/*  204 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  212 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  220 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  221 */       this._events != null && 
/*  222 */       postEventsForChanges()) {
/*  223 */       this._events.post(ITaxExemption.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  230 */     boolean ev_postable = false;
/*      */     
/*  232 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  233 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  234 */       getDAO_().setUpdateDate(argUpdateDate);
/*  235 */       ev_postable = true;
/*      */     } 
/*      */     
/*  238 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  246 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  254 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  255 */       this._events != null && 
/*  256 */       postEventsForChanges()) {
/*  257 */       this._events.post(ITaxExemption.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  264 */     boolean ev_postable = false;
/*      */     
/*  266 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  267 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  268 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  269 */       ev_postable = true;
/*      */     } 
/*      */     
/*  272 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCertificateHolderName() {
/*  280 */     return getDAO_().getCertificateHolderName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCertificateHolderName(String argCertificateHolderName) {
/*  288 */     if (setCertificateHolderName_noev(argCertificateHolderName) && 
/*  289 */       this._events != null && 
/*  290 */       postEventsForChanges()) {
/*  291 */       this._events.post(ITaxExemption.SET_CERTIFICATEHOLDERNAME, argCertificateHolderName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCertificateHolderName_noev(String argCertificateHolderName) {
/*  298 */     boolean ev_postable = false;
/*      */     
/*  300 */     if ((getDAO_().getCertificateHolderName() == null && argCertificateHolderName != null) || (
/*  301 */       getDAO_().getCertificateHolderName() != null && !getDAO_().getCertificateHolderName().equals(argCertificateHolderName))) {
/*  302 */       getDAO_().setCertificateHolderName(argCertificateHolderName);
/*  303 */       ev_postable = true;
/*      */     } 
/*      */     
/*  306 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCertificateNbr() {
/*  314 */     return getDAO_().getCertificateNbr();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCertificateNbr(String argCertificateNbr) {
/*  322 */     if (setCertificateNbr_noev(argCertificateNbr) && 
/*  323 */       this._events != null && 
/*  324 */       postEventsForChanges()) {
/*  325 */       this._events.post(ITaxExemption.SET_CERTIFICATENBR, argCertificateNbr);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCertificateNbr_noev(String argCertificateNbr) {
/*  332 */     boolean ev_postable = false;
/*      */     
/*  334 */     if ((getDAO_().getCertificateNbr() == null && argCertificateNbr != null) || (
/*  335 */       getDAO_().getCertificateNbr() != null && !getDAO_().getCertificateNbr().equals(argCertificateNbr))) {
/*  336 */       getDAO_().setCertificateNbr(argCertificateNbr);
/*  337 */       ev_postable = true;
/*      */     } 
/*      */     
/*  340 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getPartyId() {
/*  348 */     if (getDAO_().getPartyId() != null) {
/*  349 */       return getDAO_().getPartyId().longValue();
/*      */     }
/*      */     
/*  352 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPartyId(long argPartyId) {
/*  361 */     if (setPartyId_noev(argPartyId) && 
/*  362 */       this._events != null && 
/*  363 */       postEventsForChanges()) {
/*  364 */       this._events.post(ITaxExemption.SET_PARTYID, Long.valueOf(argPartyId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPartyId_noev(long argPartyId) {
/*  371 */     boolean ev_postable = false;
/*      */     
/*  373 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/*  374 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/*  375 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
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
/*      */   public String getReasonCode() {
/*  387 */     return getDAO_().getReasonCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReasonCode(String argReasonCode) {
/*  395 */     if (setReasonCode_noev(argReasonCode) && 
/*  396 */       this._events != null && 
/*  397 */       postEventsForChanges()) {
/*  398 */       this._events.post(ITaxExemption.SET_REASONCODE, argReasonCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setReasonCode_noev(String argReasonCode) {
/*  405 */     boolean ev_postable = false;
/*      */     
/*  407 */     if ((getDAO_().getReasonCode() == null && argReasonCode != null) || (
/*  408 */       getDAO_().getReasonCode() != null && !getDAO_().getReasonCode().equals(argReasonCode))) {
/*  409 */       getDAO_().setReasonCode(argReasonCode);
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
/*      */   public Date getExpirationDate() {
/*  421 */     return getDAO_().getExpirationDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExpirationDate(Date argExpirationDate) {
/*  429 */     if (setExpirationDate_noev(argExpirationDate) && 
/*  430 */       this._events != null && 
/*  431 */       postEventsForChanges()) {
/*  432 */       this._events.post(ITaxExemption.SET_EXPIRATIONDATE, argExpirationDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/*  439 */     boolean ev_postable = false;
/*      */     
/*  441 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/*  442 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/*  443 */       getDAO_().setExpirationDate(argExpirationDate);
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
/*      */   public String getCertificateCountry() {
/*  455 */     return getDAO_().getCertificateCountry();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCertificateCountry(String argCertificateCountry) {
/*  463 */     if (setCertificateCountry_noev(argCertificateCountry) && 
/*  464 */       this._events != null && 
/*  465 */       postEventsForChanges()) {
/*  466 */       this._events.post(ITaxExemption.SET_CERTIFICATECOUNTRY, argCertificateCountry);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCertificateCountry_noev(String argCertificateCountry) {
/*  473 */     boolean ev_postable = false;
/*      */     
/*  475 */     if ((getDAO_().getCertificateCountry() == null && argCertificateCountry != null) || (
/*  476 */       getDAO_().getCertificateCountry() != null && !getDAO_().getCertificateCountry().equals(argCertificateCountry))) {
/*  477 */       getDAO_().setCertificateCountry(argCertificateCountry);
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
/*      */   public String getCertificateState() {
/*  489 */     return getDAO_().getCertificateState();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCertificateState(String argCertificateState) {
/*  497 */     if (setCertificateState_noev(argCertificateState) && 
/*  498 */       this._events != null && 
/*  499 */       postEventsForChanges()) {
/*  500 */       this._events.post(ITaxExemption.SET_CERTIFICATESTATE, argCertificateState);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCertificateState_noev(String argCertificateState) {
/*  507 */     boolean ev_postable = false;
/*      */     
/*  509 */     if ((getDAO_().getCertificateState() == null && argCertificateState != null) || (
/*  510 */       getDAO_().getCertificateState() != null && !getDAO_().getCertificateState().equals(argCertificateState))) {
/*  511 */       getDAO_().setCertificateState(argCertificateState);
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
/*      */   public String getNotes() {
/*  523 */     return getDAO_().getNotes();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNotes(String argNotes) {
/*  531 */     if (setNotes_noev(argNotes) && 
/*  532 */       this._events != null && 
/*  533 */       postEventsForChanges()) {
/*  534 */       this._events.post(ITaxExemption.SET_NOTES, argNotes);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNotes_noev(String argNotes) {
/*  541 */     boolean ev_postable = false;
/*      */     
/*  543 */     if ((getDAO_().getNotes() == null && argNotes != null) || (
/*  544 */       getDAO_().getNotes() != null && !getDAO_().getNotes().equals(argNotes))) {
/*  545 */       getDAO_().setNotes(argNotes);
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
/*      */   public String getPhoneNumber() {
/*  557 */     return getDAO_().getPhoneNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPhoneNumber(String argPhoneNumber) {
/*  565 */     if (setPhoneNumber_noev(argPhoneNumber) && 
/*  566 */       this._events != null && 
/*  567 */       postEventsForChanges()) {
/*  568 */       this._events.post(ITaxExemption.SET_PHONENUMBER, argPhoneNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPhoneNumber_noev(String argPhoneNumber) {
/*  575 */     boolean ev_postable = false;
/*      */     
/*  577 */     if ((getDAO_().getPhoneNumber() == null && argPhoneNumber != null) || (
/*  578 */       getDAO_().getPhoneNumber() != null && !getDAO_().getPhoneNumber().equals(argPhoneNumber))) {
/*  579 */       getDAO_().setPhoneNumber(argPhoneNumber);
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
/*      */   public String getRegion() {
/*  591 */     return getDAO_().getRegion();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRegion(String argRegion) {
/*  599 */     if (setRegion_noev(argRegion) && 
/*  600 */       this._events != null && 
/*  601 */       postEventsForChanges()) {
/*  602 */       this._events.post(ITaxExemption.SET_REGION, argRegion);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRegion_noev(String argRegion) {
/*  609 */     boolean ev_postable = false;
/*      */     
/*  611 */     if ((getDAO_().getRegion() == null && argRegion != null) || (
/*  612 */       getDAO_().getRegion() != null && !getDAO_().getRegion().equals(argRegion))) {
/*  613 */       getDAO_().setRegion(argRegion);
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
/*      */   public String getDiplomaticTitle() {
/*  625 */     return getDAO_().getDiplomaticTitle();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDiplomaticTitle(String argDiplomaticTitle) {
/*  633 */     if (setDiplomaticTitle_noev(argDiplomaticTitle) && 
/*  634 */       this._events != null && 
/*  635 */       postEventsForChanges()) {
/*  636 */       this._events.post(ITaxExemption.SET_DIPLOMATICTITLE, argDiplomaticTitle);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDiplomaticTitle_noev(String argDiplomaticTitle) {
/*  643 */     boolean ev_postable = false;
/*      */     
/*  645 */     if ((getDAO_().getDiplomaticTitle() == null && argDiplomaticTitle != null) || (
/*  646 */       getDAO_().getDiplomaticTitle() != null && !getDAO_().getDiplomaticTitle().equals(argDiplomaticTitle))) {
/*  647 */       getDAO_().setDiplomaticTitle(argDiplomaticTitle);
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
/*      */   public String getCertHolderFirstName() {
/*  659 */     return getDAO_().getCertHolderFirstName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCertHolderFirstName(String argCertHolderFirstName) {
/*  667 */     if (setCertHolderFirstName_noev(argCertHolderFirstName) && 
/*  668 */       this._events != null && 
/*  669 */       postEventsForChanges()) {
/*  670 */       this._events.post(ITaxExemption.SET_CERTHOLDERFIRSTNAME, argCertHolderFirstName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCertHolderFirstName_noev(String argCertHolderFirstName) {
/*  677 */     boolean ev_postable = false;
/*      */     
/*  679 */     if ((getDAO_().getCertHolderFirstName() == null && argCertHolderFirstName != null) || (
/*  680 */       getDAO_().getCertHolderFirstName() != null && !getDAO_().getCertHolderFirstName().equals(argCertHolderFirstName))) {
/*  681 */       getDAO_().setCertHolderFirstName(argCertHolderFirstName);
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
/*      */   public String getCertHolderLastName() {
/*  693 */     return getDAO_().getCertHolderLastName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCertHolderLastName(String argCertHolderLastName) {
/*  701 */     if (setCertHolderLastName_noev(argCertHolderLastName) && 
/*  702 */       this._events != null && 
/*  703 */       postEventsForChanges()) {
/*  704 */       this._events.post(ITaxExemption.SET_CERTHOLDERLASTNAME, argCertHolderLastName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCertHolderLastName_noev(String argCertHolderLastName) {
/*  711 */     boolean ev_postable = false;
/*      */     
/*  713 */     if ((getDAO_().getCertHolderLastName() == null && argCertHolderLastName != null) || (
/*  714 */       getDAO_().getCertHolderLastName() != null && !getDAO_().getCertHolderLastName().equals(argCertHolderLastName))) {
/*  715 */       getDAO_().setCertHolderLastName(argCertHolderLastName);
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
/*      */   public String getAddressId() {
/*  727 */     return getDAO_().getAddressId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddressId(String argAddressId) {
/*  735 */     if (setAddressId_noev(argAddressId) && 
/*  736 */       this._events != null && 
/*  737 */       postEventsForChanges()) {
/*  738 */       this._events.post(ITaxExemption.SET_ADDRESSID, argAddressId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddressId_noev(String argAddressId) {
/*  745 */     boolean ev_postable = false;
/*      */     
/*  747 */     if ((getDAO_().getAddressId() == null && argAddressId != null) || (
/*  748 */       getDAO_().getAddressId() != null && !getDAO_().getAddressId().equals(argAddressId))) {
/*  749 */       getDAO_().setAddressId(argAddressId);
/*  750 */       ev_postable = true;
/*      */     } 
/*      */     
/*  753 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ITaxExemptionProperty newProperty(String argPropertyName) {
/*  757 */     TaxExemptionPropertyId id = new TaxExemptionPropertyId();
/*      */     
/*  759 */     id.setTaxExemptionId(getTaxExemptionId());
/*  760 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  762 */     ITaxExemptionProperty prop = (ITaxExemptionProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITaxExemptionProperty.class);
/*  763 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Address")
/*      */   public IAddress getAddress() {
/*  775 */     return this._address;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAddress(IAddress argAddress) {
/*  780 */     if (argAddress == null) {
/*      */       
/*  782 */       getDAO_().setAddressId(null);
/*  783 */       if (this._address != null)
/*      */       {
/*  785 */         if (postEventsForChanges()) {
/*  786 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._address));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  791 */       getDAO_().setAddressId(argAddress.getAddressId());
/*      */       
/*  793 */       if (postEventsForChanges()) {
/*  794 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAddress));
/*      */       }
/*      */     } 
/*      */     
/*  798 */     this._address = argAddress;
/*  799 */     if (postEventsForChanges()) {
/*  800 */       this._events.post(ITaxExemption.SET_ADDRESS, argAddress);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ITaxExemptionProperty> getProperties() {
/*  806 */     if (this._properties == null) {
/*  807 */       this._properties = new HistoricalList(null);
/*      */     }
/*  809 */     return (List<ITaxExemptionProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ITaxExemptionProperty> argProperties) {
/*  813 */     if (this._properties == null) {
/*  814 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  816 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  819 */     for (ITaxExemptionProperty child : this._properties) {
/*  820 */       TaxExemptionPropertyModel model = (TaxExemptionPropertyModel)child;
/*  821 */       model.setOrganizationId_noev(getOrganizationId());
/*  822 */       model.setTaxExemptionId_noev(getTaxExemptionId());
/*  823 */       if (child instanceof IDataModelImpl) {
/*  824 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  825 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  826 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  827 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  830 */       if (postEventsForChanges()) {
/*  831 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addTaxExemptionProperty(ITaxExemptionProperty argTaxExemptionProperty) {
/*  837 */     if (this._properties == null) {
/*  838 */       this._properties = new HistoricalList(null);
/*      */     }
/*  840 */     argTaxExemptionProperty.setOrganizationId(getOrganizationId());
/*  841 */     argTaxExemptionProperty.setTaxExemptionId(getTaxExemptionId());
/*  842 */     if (argTaxExemptionProperty instanceof IDataModelImpl) {
/*  843 */       IDataAccessObject childDao = ((IDataModelImpl)argTaxExemptionProperty).getDAO();
/*  844 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  845 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  846 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  851 */     if (postEventsForChanges()) {
/*  852 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxExemptionProperty));
/*      */     }
/*      */     
/*  855 */     this._properties.add(argTaxExemptionProperty);
/*  856 */     if (postEventsForChanges()) {
/*  857 */       this._events.post(ITaxExemption.ADD_PROPERTIES, argTaxExemptionProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTaxExemptionProperty(ITaxExemptionProperty argTaxExemptionProperty) {
/*  862 */     if (this._properties != null) {
/*      */       
/*  864 */       if (postEventsForChanges()) {
/*  865 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxExemptionProperty));
/*      */       }
/*  867 */       this._properties.remove(argTaxExemptionProperty);
/*  868 */       if (postEventsForChanges()) {
/*  869 */         this._events.post(ITaxExemption.REMOVE_PROPERTIES, argTaxExemptionProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  876 */     if ("Address".equals(argFieldId)) {
/*  877 */       return getAddress();
/*      */     }
/*  879 */     if ("Properties".equals(argFieldId)) {
/*  880 */       return getProperties();
/*      */     }
/*  882 */     if ("TaxExemptionExtension".equals(argFieldId)) {
/*  883 */       return this._myExtension;
/*      */     }
/*      */     
/*  886 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  892 */     if ("Address".equals(argFieldId)) {
/*  893 */       setAddress((IAddress)argValue);
/*      */     }
/*  895 */     else if ("Properties".equals(argFieldId)) {
/*  896 */       setProperties(changeToList(argValue, ITaxExemptionProperty.class));
/*      */     }
/*  898 */     else if ("TaxExemptionExtension".equals(argFieldId)) {
/*  899 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  902 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  908 */     this._persistenceDefaults = argPD;
/*  909 */     this._daoImpl.setPersistenceDefaults(argPD);
/*  910 */     this._eventManager = argEM;
/*  911 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/*  912 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*  913 */     if (this._address != null) {
/*  914 */       ((IDataModelImpl)this._address).setDependencies(argPD, argEM);
/*      */     }
/*  916 */     if (this._properties != null) {
/*  917 */       for (ITaxExemptionProperty relationship : this._properties) {
/*  918 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getTaxExemptionExt() {
/*  924 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setTaxExemptionExt(IDataModel argExt) {
/*  928 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  933 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  937 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  940 */     super.startTransaction();
/*      */     
/*  942 */     this._addressSavepoint = this._address;
/*  943 */     if (this._address != null) {
/*  944 */       this._address.startTransaction();
/*      */     }
/*      */     
/*  947 */     this._propertiesSavepoint = this._properties;
/*  948 */     if (this._properties != null) {
/*  949 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/*  950 */       Iterator<IDataModel> it = this._properties.iterator();
/*  951 */       while (it.hasNext()) {
/*  952 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  957 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/*  962 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/*  965 */     super.rollbackChanges();
/*      */     
/*  967 */     this._address = this._addressSavepoint;
/*  968 */     this._addressSavepoint = null;
/*  969 */     if (this._address != null) {
/*  970 */       this._address.rollbackChanges();
/*      */     }
/*      */     
/*  973 */     this._properties = this._propertiesSavepoint;
/*  974 */     this._propertiesSavepoint = null;
/*  975 */     if (this._properties != null) {
/*  976 */       Iterator<IDataModel> it = this._properties.iterator();
/*  977 */       while (it.hasNext()) {
/*  978 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/*  986 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/*  989 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/*  992 */     super.commitTransaction();
/*      */     
/*  994 */     this._addressSavepoint = this._address;
/*  995 */     if (this._address != null) {
/*  996 */       this._address.commitTransaction();
/*      */     }
/*      */     
/*  999 */     this._propertiesSavepoint = this._properties;
/* 1000 */     if (this._properties != null) {
/* 1001 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1002 */       while (it.hasNext()) {
/* 1003 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1005 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1009 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1014 */     argStream.defaultReadObject();
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
/*      */   public IReasonCode getReasonCodeObject() {
/* 1027 */     if (StringUtils.isEmpty(getReasonCode())) {
/* 1028 */       return null;
/*      */     }
/* 1030 */     ReasonCodeId id = new ReasonCodeId();
/* 1031 */     id.setReasonTypeCode("TAX_EXEMPT");
/* 1032 */     id.setReasonCode(getReasonCode());
/* 1033 */     return (IReasonCode)DataFactory.getObjectById((IObjectId)id);
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxExemptionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */