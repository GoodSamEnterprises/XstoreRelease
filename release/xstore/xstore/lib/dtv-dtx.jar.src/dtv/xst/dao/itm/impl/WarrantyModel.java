/*      */ package dtv.xst.dao.itm.impl;
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
/*      */ import dtv.xst.dao.itm.IWarranty;
/*      */ import dtv.xst.dao.itm.IWarrantyProperty;
/*      */ import dtv.xst.dao.itm.WarrantyPropertyId;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class WarrantyModel extends WarrantyBaseModel implements IWarranty {
/*      */   private static final long serialVersionUID = 566191388L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   
/*      */   public String toString() {
/*   34 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IDataModel _myExtension; private HistoricalList<IWarrantyProperty> _properties; private transient HistoricalList<IWarrantyProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   39 */     setDAO((IDataAccessObject)new WarrantyDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private WarrantyDAO getDAO_() {
/*   47 */     return (WarrantyDAO)this._daoImpl;
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
/*   71 */       this._events.post(IWarranty.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*   86 */         Iterator<WarrantyPropertyModel> it = this._properties.iterator();
/*   87 */         while (it.hasNext())
/*      */         {
/*   89 */           ((WarrantyPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*      */   public String getWarrantyNbr() {
/*  102 */     return getDAO_().getWarrantyNbr();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyNbr(String argWarrantyNbr) {
/*  110 */     if (setWarrantyNbr_noev(argWarrantyNbr) && 
/*  111 */       this._events != null && 
/*  112 */       postEventsForChanges()) {
/*  113 */       this._events.post(IWarranty.SET_WARRANTYNBR, argWarrantyNbr);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyNbr_noev(String argWarrantyNbr) {
/*  120 */     boolean ev_postable = false;
/*      */     
/*  122 */     if ((getDAO_().getWarrantyNbr() == null && argWarrantyNbr != null) || (
/*  123 */       getDAO_().getWarrantyNbr() != null && !getDAO_().getWarrantyNbr().equals(argWarrantyNbr))) {
/*  124 */       getDAO_().setWarrantyNbr(argWarrantyNbr);
/*  125 */       ev_postable = true;
/*  126 */       if (this._properties != null) {
/*      */         
/*  128 */         Iterator<WarrantyPropertyModel> it = this._properties.iterator();
/*  129 */         while (it.hasNext())
/*      */         {
/*  131 */           ((WarrantyPropertyModel)it.next()).setWarrantyNbr_noev(argWarrantyNbr);
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
/*      */   public String getWarrantyTypeCode() {
/*  144 */     return getDAO_().getWarrantyTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyTypeCode(String argWarrantyTypeCode) {
/*  152 */     if (setWarrantyTypeCode_noev(argWarrantyTypeCode) && 
/*  153 */       this._events != null && 
/*  154 */       postEventsForChanges()) {
/*  155 */       this._events.post(IWarranty.SET_WARRANTYTYPECODE, argWarrantyTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyTypeCode_noev(String argWarrantyTypeCode) {
/*  162 */     boolean ev_postable = false;
/*      */     
/*  164 */     if ((getDAO_().getWarrantyTypeCode() == null && argWarrantyTypeCode != null) || (
/*  165 */       getDAO_().getWarrantyTypeCode() != null && !getDAO_().getWarrantyTypeCode().equals(argWarrantyTypeCode))) {
/*  166 */       getDAO_().setWarrantyTypeCode(argWarrantyTypeCode);
/*  167 */       ev_postable = true;
/*  168 */       if (this._properties != null) {
/*      */         
/*  170 */         Iterator<WarrantyPropertyModel> it = this._properties.iterator();
/*  171 */         while (it.hasNext())
/*      */         {
/*  173 */           ((WarrantyPropertyModel)it.next()).setWarrantyTypeCode_noev(argWarrantyTypeCode);
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
/*  197 */       this._events.post(IWarranty.SET_CREATEDATE, argCreateDate);
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
/*  231 */       this._events.post(IWarranty.SET_CREATEUSERID, argCreateUserId);
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
/*  265 */       this._events.post(IWarranty.SET_UPDATEDATE, argUpdateDate);
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
/*  299 */       this._events.post(IWarranty.SET_UPDATEUSERID, argUpdateUserId);
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
/*      */   public String getWarrantyPlanId() {
/*  322 */     return getDAO_().getWarrantyPlanId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyPlanId(String argWarrantyPlanId) {
/*  330 */     super.setWarrantyPlanId(argWarrantyPlanId);
/*      */     
/*  332 */     if (setWarrantyPlanId_noev(argWarrantyPlanId) && 
/*  333 */       this._events != null && 
/*  334 */       postEventsForChanges()) {
/*  335 */       this._events.post(IWarranty.SET_WARRANTYPLANID, argWarrantyPlanId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyPlanId_noev(String argWarrantyPlanId) {
/*  342 */     boolean ev_postable = false;
/*      */     
/*  344 */     if ((getDAO_().getWarrantyPlanId() == null && argWarrantyPlanId != null) || (
/*  345 */       getDAO_().getWarrantyPlanId() != null && !getDAO_().getWarrantyPlanId().equals(argWarrantyPlanId))) {
/*  346 */       getDAO_().setWarrantyPlanId(argWarrantyPlanId);
/*  347 */       ev_postable = true;
/*      */     } 
/*      */     
/*  350 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getWarrantyIssueDate() {
/*  358 */     return getDAO_().getWarrantyIssueDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyIssueDate(Date argWarrantyIssueDate) {
/*  366 */     if (setWarrantyIssueDate_noev(argWarrantyIssueDate) && 
/*  367 */       this._events != null && 
/*  368 */       postEventsForChanges()) {
/*  369 */       this._events.post(IWarranty.SET_WARRANTYISSUEDATE, argWarrantyIssueDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyIssueDate_noev(Date argWarrantyIssueDate) {
/*  376 */     boolean ev_postable = false;
/*      */     
/*  378 */     if ((getDAO_().getWarrantyIssueDate() == null && argWarrantyIssueDate != null) || (
/*  379 */       getDAO_().getWarrantyIssueDate() != null && !getDAO_().getWarrantyIssueDate().equals(argWarrantyIssueDate))) {
/*  380 */       getDAO_().setWarrantyIssueDate(argWarrantyIssueDate);
/*  381 */       ev_postable = true;
/*      */     } 
/*      */     
/*  384 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getWarrantyExpirationDate() {
/*  392 */     return getDAO_().getWarrantyExpirationDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyExpirationDate(Date argWarrantyExpirationDate) {
/*  400 */     if (setWarrantyExpirationDate_noev(argWarrantyExpirationDate) && 
/*  401 */       this._events != null && 
/*  402 */       postEventsForChanges()) {
/*  403 */       this._events.post(IWarranty.SET_WARRANTYEXPIRATIONDATE, argWarrantyExpirationDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyExpirationDate_noev(Date argWarrantyExpirationDate) {
/*  410 */     boolean ev_postable = false;
/*      */     
/*  412 */     if ((getDAO_().getWarrantyExpirationDate() == null && argWarrantyExpirationDate != null) || (
/*  413 */       getDAO_().getWarrantyExpirationDate() != null && !getDAO_().getWarrantyExpirationDate().equals(argWarrantyExpirationDate))) {
/*  414 */       getDAO_().setWarrantyExpirationDate(argWarrantyExpirationDate);
/*  415 */       ev_postable = true;
/*      */     } 
/*      */     
/*  418 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStatusCode() {
/*  426 */     return getDAO_().getStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStatusCode(String argStatusCode) {
/*  434 */     if (setStatusCode_noev(argStatusCode) && 
/*  435 */       this._events != null && 
/*  436 */       postEventsForChanges()) {
/*  437 */       this._events.post(IWarranty.SET_STATUSCODE, argStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStatusCode_noev(String argStatusCode) {
/*  444 */     boolean ev_postable = false;
/*      */     
/*  446 */     if ((getDAO_().getStatusCode() == null && argStatusCode != null) || (
/*  447 */       getDAO_().getStatusCode() != null && !getDAO_().getStatusCode().equals(argStatusCode))) {
/*  448 */       getDAO_().setStatusCode(argStatusCode);
/*  449 */       ev_postable = true;
/*      */     } 
/*      */     
/*  452 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getPurchasePrice() {
/*  460 */     return getDAO_().getPurchasePrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPurchasePrice(BigDecimal argPurchasePrice) {
/*  468 */     if (setPurchasePrice_noev(argPurchasePrice) && 
/*  469 */       this._events != null && 
/*  470 */       postEventsForChanges()) {
/*  471 */       this._events.post(IWarranty.SET_PURCHASEPRICE, argPurchasePrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPurchasePrice_noev(BigDecimal argPurchasePrice) {
/*  478 */     boolean ev_postable = false;
/*      */     
/*  480 */     if ((getDAO_().getPurchasePrice() == null && argPurchasePrice != null) || (
/*  481 */       getDAO_().getPurchasePrice() != null && !getDAO_().getPurchasePrice().equals(argPurchasePrice))) {
/*  482 */       getDAO_().setPurchasePrice(argPurchasePrice);
/*  483 */       ev_postable = true;
/*      */     } 
/*      */     
/*  486 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustomerId() {
/*  494 */     return getDAO_().getCustomerId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustomerId(String argCustomerId) {
/*  502 */     if (setCustomerId_noev(argCustomerId) && 
/*  503 */       this._events != null && 
/*  504 */       postEventsForChanges()) {
/*  505 */       this._events.post(IWarranty.SET_CUSTOMERID, argCustomerId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustomerId_noev(String argCustomerId) {
/*  512 */     boolean ev_postable = false;
/*      */     
/*  514 */     if ((getDAO_().getCustomerId() == null && argCustomerId != null) || (
/*  515 */       getDAO_().getCustomerId() != null && !getDAO_().getCustomerId().equals(argCustomerId))) {
/*  516 */       getDAO_().setCustomerId(argCustomerId);
/*  517 */       ev_postable = true;
/*      */     } 
/*      */     
/*  520 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getPartyId() {
/*  528 */     if (getDAO_().getPartyId() != null) {
/*  529 */       return getDAO_().getPartyId().longValue();
/*      */     }
/*      */     
/*  532 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPartyId(long argPartyId) {
/*  541 */     super.setPartyId(argPartyId);
/*      */     
/*  543 */     if (setPartyId_noev(argPartyId) && 
/*  544 */       this._events != null && 
/*  545 */       postEventsForChanges()) {
/*  546 */       this._events.post(IWarranty.SET_PARTYID, Long.valueOf(argPartyId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPartyId_noev(long argPartyId) {
/*  553 */     boolean ev_postable = false;
/*      */     
/*  555 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/*  556 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/*  557 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/*  558 */       ev_postable = true;
/*      */     } 
/*      */     
/*  561 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCertificateNbr() {
/*  569 */     return getDAO_().getCertificateNbr();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCertificateNbr(String argCertificateNbr) {
/*  577 */     if (setCertificateNbr_noev(argCertificateNbr) && 
/*  578 */       this._events != null && 
/*  579 */       postEventsForChanges()) {
/*  580 */       this._events.post(IWarranty.SET_CERTIFICATENBR, argCertificateNbr);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCertificateNbr_noev(String argCertificateNbr) {
/*  587 */     boolean ev_postable = false;
/*      */     
/*  589 */     if ((getDAO_().getCertificateNbr() == null && argCertificateNbr != null) || (
/*  590 */       getDAO_().getCertificateNbr() != null && !getDAO_().getCertificateNbr().equals(argCertificateNbr))) {
/*  591 */       getDAO_().setCertificateNbr(argCertificateNbr);
/*  592 */       ev_postable = true;
/*      */     } 
/*      */     
/*  595 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCertificateCompanyName() {
/*  603 */     return getDAO_().getCertificateCompanyName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCertificateCompanyName(String argCertificateCompanyName) {
/*  611 */     if (setCertificateCompanyName_noev(argCertificateCompanyName) && 
/*  612 */       this._events != null && 
/*  613 */       postEventsForChanges()) {
/*  614 */       this._events.post(IWarranty.SET_CERTIFICATECOMPANYNAME, argCertificateCompanyName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCertificateCompanyName_noev(String argCertificateCompanyName) {
/*  621 */     boolean ev_postable = false;
/*      */     
/*  623 */     if ((getDAO_().getCertificateCompanyName() == null && argCertificateCompanyName != null) || (
/*  624 */       getDAO_().getCertificateCompanyName() != null && !getDAO_().getCertificateCompanyName().equals(argCertificateCompanyName))) {
/*  625 */       getDAO_().setCertificateCompanyName(argCertificateCompanyName);
/*  626 */       ev_postable = true;
/*      */     } 
/*      */     
/*  629 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getWarrantyItemId() {
/*  637 */     return getDAO_().getWarrantyItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyItemId(String argWarrantyItemId) {
/*  645 */     super.setWarrantyItemId(argWarrantyItemId);
/*      */     
/*  647 */     if (setWarrantyItemId_noev(argWarrantyItemId) && 
/*  648 */       this._events != null && 
/*  649 */       postEventsForChanges()) {
/*  650 */       this._events.post(IWarranty.SET_WARRANTYITEMID, argWarrantyItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyItemId_noev(String argWarrantyItemId) {
/*  657 */     boolean ev_postable = false;
/*      */     
/*  659 */     if ((getDAO_().getWarrantyItemId() == null && argWarrantyItemId != null) || (
/*  660 */       getDAO_().getWarrantyItemId() != null && !getDAO_().getWarrantyItemId().equals(argWarrantyItemId))) {
/*  661 */       getDAO_().setWarrantyItemId(argWarrantyItemId);
/*  662 */       ev_postable = true;
/*      */     } 
/*      */     
/*  665 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getWarrantyLineBusinessDate() {
/*  673 */     return getDAO_().getWarrantyLineBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyLineBusinessDate(Date argWarrantyLineBusinessDate) {
/*  681 */     super.setWarrantyLineBusinessDate(argWarrantyLineBusinessDate);
/*      */     
/*  683 */     if (setWarrantyLineBusinessDate_noev(argWarrantyLineBusinessDate) && 
/*  684 */       this._events != null && 
/*  685 */       postEventsForChanges()) {
/*  686 */       this._events.post(IWarranty.SET_WARRANTYLINEBUSINESSDATE, argWarrantyLineBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyLineBusinessDate_noev(Date argWarrantyLineBusinessDate) {
/*  693 */     boolean ev_postable = false;
/*      */     
/*  695 */     if ((getDAO_().getWarrantyLineBusinessDate() == null && argWarrantyLineBusinessDate != null) || (
/*  696 */       getDAO_().getWarrantyLineBusinessDate() != null && !getDAO_().getWarrantyLineBusinessDate().equals(argWarrantyLineBusinessDate))) {
/*  697 */       getDAO_().setWarrantyLineBusinessDate(argWarrantyLineBusinessDate);
/*  698 */       ev_postable = true;
/*      */     } 
/*      */     
/*  701 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWarrantyLineRtlLocId() {
/*  709 */     if (getDAO_().getWarrantyLineRtlLocId() != null) {
/*  710 */       return getDAO_().getWarrantyLineRtlLocId().longValue();
/*      */     }
/*      */     
/*  713 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyLineRtlLocId(long argWarrantyLineRtlLocId) {
/*  722 */     super.setWarrantyLineRtlLocId(argWarrantyLineRtlLocId);
/*      */     
/*  724 */     if (setWarrantyLineRtlLocId_noev(argWarrantyLineRtlLocId) && 
/*  725 */       this._events != null && 
/*  726 */       postEventsForChanges()) {
/*  727 */       this._events.post(IWarranty.SET_WARRANTYLINERTLLOCID, Long.valueOf(argWarrantyLineRtlLocId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyLineRtlLocId_noev(long argWarrantyLineRtlLocId) {
/*  734 */     boolean ev_postable = false;
/*      */     
/*  736 */     if ((getDAO_().getWarrantyLineRtlLocId() == null && Long.valueOf(argWarrantyLineRtlLocId) != null) || (
/*  737 */       getDAO_().getWarrantyLineRtlLocId() != null && !getDAO_().getWarrantyLineRtlLocId().equals(Long.valueOf(argWarrantyLineRtlLocId)))) {
/*  738 */       getDAO_().setWarrantyLineRtlLocId(Long.valueOf(argWarrantyLineRtlLocId));
/*  739 */       ev_postable = true;
/*      */     } 
/*      */     
/*  742 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWarrantyLineWkstnId() {
/*  750 */     if (getDAO_().getWarrantyLineWkstnId() != null) {
/*  751 */       return getDAO_().getWarrantyLineWkstnId().longValue();
/*      */     }
/*      */     
/*  754 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyLineWkstnId(long argWarrantyLineWkstnId) {
/*  763 */     super.setWarrantyLineWkstnId(argWarrantyLineWkstnId);
/*      */     
/*  765 */     if (setWarrantyLineWkstnId_noev(argWarrantyLineWkstnId) && 
/*  766 */       this._events != null && 
/*  767 */       postEventsForChanges()) {
/*  768 */       this._events.post(IWarranty.SET_WARRANTYLINEWKSTNID, Long.valueOf(argWarrantyLineWkstnId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyLineWkstnId_noev(long argWarrantyLineWkstnId) {
/*  775 */     boolean ev_postable = false;
/*      */     
/*  777 */     if ((getDAO_().getWarrantyLineWkstnId() == null && Long.valueOf(argWarrantyLineWkstnId) != null) || (
/*  778 */       getDAO_().getWarrantyLineWkstnId() != null && !getDAO_().getWarrantyLineWkstnId().equals(Long.valueOf(argWarrantyLineWkstnId)))) {
/*  779 */       getDAO_().setWarrantyLineWkstnId(Long.valueOf(argWarrantyLineWkstnId));
/*  780 */       ev_postable = true;
/*      */     } 
/*      */     
/*  783 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWarrantyLineTransSeq() {
/*  791 */     if (getDAO_().getWarrantyLineTransSeq() != null) {
/*  792 */       return getDAO_().getWarrantyLineTransSeq().longValue();
/*      */     }
/*      */     
/*  795 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyLineTransSeq(long argWarrantyLineTransSeq) {
/*  804 */     super.setWarrantyLineTransSeq(argWarrantyLineTransSeq);
/*      */     
/*  806 */     if (setWarrantyLineTransSeq_noev(argWarrantyLineTransSeq) && 
/*  807 */       this._events != null && 
/*  808 */       postEventsForChanges()) {
/*  809 */       this._events.post(IWarranty.SET_WARRANTYLINETRANSSEQ, Long.valueOf(argWarrantyLineTransSeq));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyLineTransSeq_noev(long argWarrantyLineTransSeq) {
/*  816 */     boolean ev_postable = false;
/*      */     
/*  818 */     if ((getDAO_().getWarrantyLineTransSeq() == null && Long.valueOf(argWarrantyLineTransSeq) != null) || (
/*  819 */       getDAO_().getWarrantyLineTransSeq() != null && !getDAO_().getWarrantyLineTransSeq().equals(Long.valueOf(argWarrantyLineTransSeq)))) {
/*  820 */       getDAO_().setWarrantyLineTransSeq(Long.valueOf(argWarrantyLineTransSeq));
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
/*      */   public int getWarrantyLineTransLineItemSeq() {
/*  832 */     if (getDAO_().getWarrantyLineTransLineItemSeq() != null) {
/*  833 */       return getDAO_().getWarrantyLineTransLineItemSeq().intValue();
/*      */     }
/*      */     
/*  836 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyLineTransLineItemSeq(int argWarrantyLineTransLineItemSeq) {
/*  845 */     super.setWarrantyLineTransLineItemSeq(argWarrantyLineTransLineItemSeq);
/*      */     
/*  847 */     if (setWarrantyLineTransLineItemSeq_noev(argWarrantyLineTransLineItemSeq) && 
/*  848 */       this._events != null && 
/*  849 */       postEventsForChanges()) {
/*  850 */       this._events.post(IWarranty.SET_WARRANTYLINETRANSLINEITEMSEQ, Integer.valueOf(argWarrantyLineTransLineItemSeq));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyLineTransLineItemSeq_noev(int argWarrantyLineTransLineItemSeq) {
/*  857 */     boolean ev_postable = false;
/*      */     
/*  859 */     if ((getDAO_().getWarrantyLineTransLineItemSeq() == null && Integer.valueOf(argWarrantyLineTransLineItemSeq) != null) || (
/*  860 */       getDAO_().getWarrantyLineTransLineItemSeq() != null && !getDAO_().getWarrantyLineTransLineItemSeq().equals(Integer.valueOf(argWarrantyLineTransLineItemSeq)))) {
/*  861 */       getDAO_().setWarrantyLineTransLineItemSeq(Integer.valueOf(argWarrantyLineTransLineItemSeq));
/*  862 */       ev_postable = true;
/*      */     } 
/*      */     
/*  865 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCoveredItemId() {
/*  873 */     return getDAO_().getCoveredItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCoveredItemId(String argCoveredItemId) {
/*  881 */     super.setCoveredItemId(argCoveredItemId);
/*      */     
/*  883 */     if (setCoveredItemId_noev(argCoveredItemId) && 
/*  884 */       this._events != null && 
/*  885 */       postEventsForChanges()) {
/*  886 */       this._events.post(IWarranty.SET_COVEREDITEMID, argCoveredItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCoveredItemId_noev(String argCoveredItemId) {
/*  893 */     boolean ev_postable = false;
/*      */     
/*  895 */     if ((getDAO_().getCoveredItemId() == null && argCoveredItemId != null) || (
/*  896 */       getDAO_().getCoveredItemId() != null && !getDAO_().getCoveredItemId().equals(argCoveredItemId))) {
/*  897 */       getDAO_().setCoveredItemId(argCoveredItemId);
/*  898 */       ev_postable = true;
/*      */     } 
/*      */     
/*  901 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCoveredLineBusinessDate() {
/*  909 */     return getDAO_().getCoveredLineBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCoveredLineBusinessDate(Date argCoveredLineBusinessDate) {
/*  917 */     super.setCoveredLineBusinessDate(argCoveredLineBusinessDate);
/*      */     
/*  919 */     if (setCoveredLineBusinessDate_noev(argCoveredLineBusinessDate) && 
/*  920 */       this._events != null && 
/*  921 */       postEventsForChanges()) {
/*  922 */       this._events.post(IWarranty.SET_COVEREDLINEBUSINESSDATE, argCoveredLineBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCoveredLineBusinessDate_noev(Date argCoveredLineBusinessDate) {
/*  929 */     boolean ev_postable = false;
/*      */     
/*  931 */     if ((getDAO_().getCoveredLineBusinessDate() == null && argCoveredLineBusinessDate != null) || (
/*  932 */       getDAO_().getCoveredLineBusinessDate() != null && !getDAO_().getCoveredLineBusinessDate().equals(argCoveredLineBusinessDate))) {
/*  933 */       getDAO_().setCoveredLineBusinessDate(argCoveredLineBusinessDate);
/*  934 */       ev_postable = true;
/*      */     } 
/*      */     
/*  937 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getCoveredLineRtlLocId() {
/*  945 */     if (getDAO_().getCoveredLineRtlLocId() != null) {
/*  946 */       return getDAO_().getCoveredLineRtlLocId().longValue();
/*      */     }
/*      */     
/*  949 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCoveredLineRtlLocId(long argCoveredLineRtlLocId) {
/*  958 */     super.setCoveredLineRtlLocId(argCoveredLineRtlLocId);
/*      */     
/*  960 */     if (setCoveredLineRtlLocId_noev(argCoveredLineRtlLocId) && 
/*  961 */       this._events != null && 
/*  962 */       postEventsForChanges()) {
/*  963 */       this._events.post(IWarranty.SET_COVEREDLINERTLLOCID, Long.valueOf(argCoveredLineRtlLocId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCoveredLineRtlLocId_noev(long argCoveredLineRtlLocId) {
/*  970 */     boolean ev_postable = false;
/*      */     
/*  972 */     if ((getDAO_().getCoveredLineRtlLocId() == null && Long.valueOf(argCoveredLineRtlLocId) != null) || (
/*  973 */       getDAO_().getCoveredLineRtlLocId() != null && !getDAO_().getCoveredLineRtlLocId().equals(Long.valueOf(argCoveredLineRtlLocId)))) {
/*  974 */       getDAO_().setCoveredLineRtlLocId(Long.valueOf(argCoveredLineRtlLocId));
/*  975 */       ev_postable = true;
/*      */     } 
/*      */     
/*  978 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getCoveredLineWkstnId() {
/*  986 */     if (getDAO_().getCoveredLineWkstnId() != null) {
/*  987 */       return getDAO_().getCoveredLineWkstnId().longValue();
/*      */     }
/*      */     
/*  990 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCoveredLineWkstnId(long argCoveredLineWkstnId) {
/*  999 */     super.setCoveredLineWkstnId(argCoveredLineWkstnId);
/*      */     
/* 1001 */     if (setCoveredLineWkstnId_noev(argCoveredLineWkstnId) && 
/* 1002 */       this._events != null && 
/* 1003 */       postEventsForChanges()) {
/* 1004 */       this._events.post(IWarranty.SET_COVEREDLINEWKSTNID, Long.valueOf(argCoveredLineWkstnId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCoveredLineWkstnId_noev(long argCoveredLineWkstnId) {
/* 1011 */     boolean ev_postable = false;
/*      */     
/* 1013 */     if ((getDAO_().getCoveredLineWkstnId() == null && Long.valueOf(argCoveredLineWkstnId) != null) || (
/* 1014 */       getDAO_().getCoveredLineWkstnId() != null && !getDAO_().getCoveredLineWkstnId().equals(Long.valueOf(argCoveredLineWkstnId)))) {
/* 1015 */       getDAO_().setCoveredLineWkstnId(Long.valueOf(argCoveredLineWkstnId));
/* 1016 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1019 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getCoveredLineTransSeq() {
/* 1027 */     if (getDAO_().getCoveredLineTransSeq() != null) {
/* 1028 */       return getDAO_().getCoveredLineTransSeq().longValue();
/*      */     }
/*      */     
/* 1031 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCoveredLineTransSeq(long argCoveredLineTransSeq) {
/* 1040 */     super.setCoveredLineTransSeq(argCoveredLineTransSeq);
/*      */     
/* 1042 */     if (setCoveredLineTransSeq_noev(argCoveredLineTransSeq) && 
/* 1043 */       this._events != null && 
/* 1044 */       postEventsForChanges()) {
/* 1045 */       this._events.post(IWarranty.SET_COVEREDLINETRANSSEQ, Long.valueOf(argCoveredLineTransSeq));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCoveredLineTransSeq_noev(long argCoveredLineTransSeq) {
/* 1052 */     boolean ev_postable = false;
/*      */     
/* 1054 */     if ((getDAO_().getCoveredLineTransSeq() == null && Long.valueOf(argCoveredLineTransSeq) != null) || (
/* 1055 */       getDAO_().getCoveredLineTransSeq() != null && !getDAO_().getCoveredLineTransSeq().equals(Long.valueOf(argCoveredLineTransSeq)))) {
/* 1056 */       getDAO_().setCoveredLineTransSeq(Long.valueOf(argCoveredLineTransSeq));
/* 1057 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1060 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getCoveredLineTransLineItemSeq() {
/* 1068 */     if (getDAO_().getCoveredLineTransLineItemSeq() != null) {
/* 1069 */       return getDAO_().getCoveredLineTransLineItemSeq().intValue();
/*      */     }
/*      */     
/* 1072 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCoveredLineTransLineItemSeq(int argCoveredLineTransLineItemSeq) {
/* 1081 */     super.setCoveredLineTransLineItemSeq(argCoveredLineTransLineItemSeq);
/*      */     
/* 1083 */     if (setCoveredLineTransLineItemSeq_noev(argCoveredLineTransLineItemSeq) && 
/* 1084 */       this._events != null && 
/* 1085 */       postEventsForChanges()) {
/* 1086 */       this._events.post(IWarranty.SET_COVEREDLINETRANSLINEITEMSEQ, Integer.valueOf(argCoveredLineTransLineItemSeq));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCoveredLineTransLineItemSeq_noev(int argCoveredLineTransLineItemSeq) {
/* 1093 */     boolean ev_postable = false;
/*      */     
/* 1095 */     if ((getDAO_().getCoveredLineTransLineItemSeq() == null && Integer.valueOf(argCoveredLineTransLineItemSeq) != null) || (
/* 1096 */       getDAO_().getCoveredLineTransLineItemSeq() != null && !getDAO_().getCoveredLineTransLineItemSeq().equals(Integer.valueOf(argCoveredLineTransLineItemSeq)))) {
/* 1097 */       getDAO_().setCoveredLineTransLineItemSeq(Integer.valueOf(argCoveredLineTransLineItemSeq));
/* 1098 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1101 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCoveredItemPurchaseDate() {
/* 1109 */     return getDAO_().getCoveredItemPurchaseDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCoveredItemPurchaseDate(Date argCoveredItemPurchaseDate) {
/* 1117 */     if (setCoveredItemPurchaseDate_noev(argCoveredItemPurchaseDate) && 
/* 1118 */       this._events != null && 
/* 1119 */       postEventsForChanges()) {
/* 1120 */       this._events.post(IWarranty.SET_COVEREDITEMPURCHASEDATE, argCoveredItemPurchaseDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCoveredItemPurchaseDate_noev(Date argCoveredItemPurchaseDate) {
/* 1127 */     boolean ev_postable = false;
/*      */     
/* 1129 */     if ((getDAO_().getCoveredItemPurchaseDate() == null && argCoveredItemPurchaseDate != null) || (
/* 1130 */       getDAO_().getCoveredItemPurchaseDate() != null && !getDAO_().getCoveredItemPurchaseDate().equals(argCoveredItemPurchaseDate))) {
/* 1131 */       getDAO_().setCoveredItemPurchaseDate(argCoveredItemPurchaseDate);
/* 1132 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1135 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getCoveredItemPurchasePrice() {
/* 1143 */     return getDAO_().getCoveredItemPurchasePrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCoveredItemPurchasePrice(BigDecimal argCoveredItemPurchasePrice) {
/* 1151 */     if (setCoveredItemPurchasePrice_noev(argCoveredItemPurchasePrice) && 
/* 1152 */       this._events != null && 
/* 1153 */       postEventsForChanges()) {
/* 1154 */       this._events.post(IWarranty.SET_COVEREDITEMPURCHASEPRICE, argCoveredItemPurchasePrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCoveredItemPurchasePrice_noev(BigDecimal argCoveredItemPurchasePrice) {
/* 1161 */     boolean ev_postable = false;
/*      */     
/* 1163 */     if ((getDAO_().getCoveredItemPurchasePrice() == null && argCoveredItemPurchasePrice != null) || (
/* 1164 */       getDAO_().getCoveredItemPurchasePrice() != null && !getDAO_().getCoveredItemPurchasePrice().equals(argCoveredItemPurchasePrice))) {
/* 1165 */       getDAO_().setCoveredItemPurchasePrice(argCoveredItemPurchasePrice);
/* 1166 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1169 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCoveredItemPurchaseLocation() {
/* 1177 */     return getDAO_().getCoveredItemPurchaseLocation();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCoveredItemPurchaseLocation(String argCoveredItemPurchaseLocation) {
/* 1185 */     if (setCoveredItemPurchaseLocation_noev(argCoveredItemPurchaseLocation) && 
/* 1186 */       this._events != null && 
/* 1187 */       postEventsForChanges()) {
/* 1188 */       this._events.post(IWarranty.SET_COVEREDITEMPURCHASELOCATION, argCoveredItemPurchaseLocation);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCoveredItemPurchaseLocation_noev(String argCoveredItemPurchaseLocation) {
/* 1195 */     boolean ev_postable = false;
/*      */     
/* 1197 */     if ((getDAO_().getCoveredItemPurchaseLocation() == null && argCoveredItemPurchaseLocation != null) || (
/* 1198 */       getDAO_().getCoveredItemPurchaseLocation() != null && !getDAO_().getCoveredItemPurchaseLocation().equals(argCoveredItemPurchaseLocation))) {
/* 1199 */       getDAO_().setCoveredItemPurchaseLocation(argCoveredItemPurchaseLocation);
/* 1200 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1203 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IWarrantyProperty newProperty(String argPropertyName) {
/* 1207 */     WarrantyPropertyId id = new WarrantyPropertyId();
/*      */     
/* 1209 */     id.setWarrantyNbr(getWarrantyNbr());
/* 1210 */     id.setWarrantyTypeCode(getWarrantyTypeCode());
/* 1211 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1213 */     IWarrantyProperty prop = (IWarrantyProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IWarrantyProperty.class);
/* 1214 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IWarrantyProperty> getProperties() {
/* 1223 */     if (this._properties == null) {
/* 1224 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1226 */     return (List<IWarrantyProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IWarrantyProperty> argProperties) {
/* 1230 */     if (this._properties == null) {
/* 1231 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1233 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1236 */     for (IWarrantyProperty child : this._properties) {
/* 1237 */       WarrantyPropertyModel model = (WarrantyPropertyModel)child;
/* 1238 */       model.setOrganizationId_noev(getOrganizationId());
/* 1239 */       model.setWarrantyNbr_noev(getWarrantyNbr());
/* 1240 */       model.setWarrantyTypeCode_noev(getWarrantyTypeCode());
/* 1241 */       if (child instanceof IDataModelImpl) {
/* 1242 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1243 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1244 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1245 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1248 */       if (postEventsForChanges()) {
/* 1249 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addWarrantyProperty(IWarrantyProperty argWarrantyProperty) {
/* 1255 */     if (this._properties == null) {
/* 1256 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1258 */     argWarrantyProperty.setOrganizationId(getOrganizationId());
/* 1259 */     argWarrantyProperty.setWarrantyNbr(getWarrantyNbr());
/* 1260 */     argWarrantyProperty.setWarrantyTypeCode(getWarrantyTypeCode());
/* 1261 */     if (argWarrantyProperty instanceof IDataModelImpl) {
/* 1262 */       IDataAccessObject childDao = ((IDataModelImpl)argWarrantyProperty).getDAO();
/* 1263 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1264 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1265 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1270 */     if (postEventsForChanges()) {
/* 1271 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWarrantyProperty));
/*      */     }
/*      */     
/* 1274 */     this._properties.add(argWarrantyProperty);
/* 1275 */     if (postEventsForChanges()) {
/* 1276 */       this._events.post(IWarranty.ADD_PROPERTIES, argWarrantyProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeWarrantyProperty(IWarrantyProperty argWarrantyProperty) {
/* 1281 */     if (this._properties != null) {
/*      */       
/* 1283 */       if (postEventsForChanges()) {
/* 1284 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWarrantyProperty));
/*      */       }
/* 1286 */       this._properties.remove(argWarrantyProperty);
/* 1287 */       if (postEventsForChanges()) {
/* 1288 */         this._events.post(IWarranty.REMOVE_PROPERTIES, argWarrantyProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1295 */     if ("Properties".equals(argFieldId)) {
/* 1296 */       return getProperties();
/*      */     }
/* 1298 */     if ("WarrantyExtension".equals(argFieldId)) {
/* 1299 */       return this._myExtension;
/*      */     }
/*      */     
/* 1302 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1308 */     if ("Properties".equals(argFieldId)) {
/* 1309 */       setProperties(changeToList(argValue, IWarrantyProperty.class));
/*      */     }
/* 1311 */     else if ("WarrantyExtension".equals(argFieldId)) {
/* 1312 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1315 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1321 */     this._persistenceDefaults = argPD;
/* 1322 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1323 */     this._eventManager = argEM;
/* 1324 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1325 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1326 */     if (this._properties != null) {
/* 1327 */       for (IWarrantyProperty relationship : this._properties) {
/* 1328 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getWarrantyExt() {
/* 1334 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setWarrantyExt(IDataModel argExt) {
/* 1338 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1343 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1347 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1350 */     super.startTransaction();
/*      */     
/* 1352 */     this._propertiesSavepoint = this._properties;
/* 1353 */     if (this._properties != null) {
/* 1354 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1355 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1356 */       while (it.hasNext()) {
/* 1357 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1362 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1367 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1370 */     super.rollbackChanges();
/*      */     
/* 1372 */     this._properties = this._propertiesSavepoint;
/* 1373 */     this._propertiesSavepoint = null;
/* 1374 */     if (this._properties != null) {
/* 1375 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1376 */       while (it.hasNext()) {
/* 1377 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1385 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1388 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1391 */     super.commitTransaction();
/*      */     
/* 1393 */     this._propertiesSavepoint = this._properties;
/* 1394 */     if (this._properties != null) {
/* 1395 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1396 */       while (it.hasNext()) {
/* 1397 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1399 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1403 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\WarrantyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */