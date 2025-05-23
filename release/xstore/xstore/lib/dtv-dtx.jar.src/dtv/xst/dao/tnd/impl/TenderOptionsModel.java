/*      */ package dtv.xst.dao.tnd.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.Eventor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.event.handler.CascadingHandler;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.NumberUtils;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.tnd.ITender;
/*      */ import dtv.xst.dao.tnd.ITenderOptions;
/*      */ import dtv.xst.dao.tnd.ITenderOptionsProperty;
/*      */ import dtv.xst.dao.tnd.TenderOptionsPropertyId;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class TenderOptionsModel extends AbstractDataModelWithPropertyImpl<ITenderOptionsProperty> implements ITenderOptions {
/*      */   private static final long serialVersionUID = -1928444662L;
/*      */   private ITender _parentTender;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   
/*      */   public String toString() {
/*   35 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<ITenderOptionsProperty> _properties; private transient HistoricalList<ITenderOptionsProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   40 */     setDAO((IDataAccessObject)new TenderOptionsDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private TenderOptionsDAO getDAO_() {
/*   48 */     return (TenderOptionsDAO)this._daoImpl;
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
/*   72 */       this._events.post(ITenderOptions.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*   87 */         Iterator<TenderOptionsPropertyModel> it = this._properties.iterator();
/*   88 */         while (it.hasNext())
/*      */         {
/*   90 */           ((TenderOptionsPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*      */   public String getTenderId() {
/*  103 */     return getDAO_().getTenderId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTenderId(String argTenderId) {
/*  111 */     if (setTenderId_noev(argTenderId) && 
/*  112 */       this._events != null && 
/*  113 */       postEventsForChanges()) {
/*  114 */       this._events.post(ITenderOptions.SET_TENDERID, argTenderId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTenderId_noev(String argTenderId) {
/*  121 */     boolean ev_postable = false;
/*      */     
/*  123 */     if ((getDAO_().getTenderId() == null && argTenderId != null) || (
/*  124 */       getDAO_().getTenderId() != null && !getDAO_().getTenderId().equals(argTenderId))) {
/*  125 */       getDAO_().setTenderId(argTenderId);
/*  126 */       ev_postable = true;
/*  127 */       if (this._properties != null) {
/*      */         
/*  129 */         Iterator<TenderOptionsPropertyModel> it = this._properties.iterator();
/*  130 */         while (it.hasNext())
/*      */         {
/*  132 */           ((TenderOptionsPropertyModel)it.next()).setTenderId_noev(argTenderId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  137 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getConfigElement() {
/*  145 */     return getDAO_().getConfigElement();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setConfigElement(String argConfigElement) {
/*  153 */     if (setConfigElement_noev(argConfigElement) && 
/*  154 */       this._events != null && 
/*  155 */       postEventsForChanges()) {
/*  156 */       this._events.post(ITenderOptions.SET_CONFIGELEMENT, argConfigElement);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setConfigElement_noev(String argConfigElement) {
/*  163 */     boolean ev_postable = false;
/*      */     
/*  165 */     if ((getDAO_().getConfigElement() == null && argConfigElement != null) || (
/*  166 */       getDAO_().getConfigElement() != null && !getDAO_().getConfigElement().equals(argConfigElement))) {
/*  167 */       getDAO_().setConfigElement(argConfigElement);
/*  168 */       ev_postable = true;
/*  169 */       if (this._properties != null) {
/*      */         
/*  171 */         Iterator<TenderOptionsPropertyModel> it = this._properties.iterator();
/*  172 */         while (it.hasNext())
/*      */         {
/*  174 */           ((TenderOptionsPropertyModel)it.next()).setConfigElement_noev(argConfigElement);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  179 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  187 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  195 */     if (setCreateDate_noev(argCreateDate) && 
/*  196 */       this._events != null && 
/*  197 */       postEventsForChanges()) {
/*  198 */       this._events.post(ITenderOptions.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  205 */     boolean ev_postable = false;
/*      */     
/*  207 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  208 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  209 */       getDAO_().setCreateDate(argCreateDate);
/*  210 */       ev_postable = true;
/*      */     } 
/*      */     
/*  213 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  221 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  229 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  230 */       this._events != null && 
/*  231 */       postEventsForChanges()) {
/*  232 */       this._events.post(ITenderOptions.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  239 */     boolean ev_postable = false;
/*      */     
/*  241 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  242 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  243 */       getDAO_().setCreateUserId(argCreateUserId);
/*  244 */       ev_postable = true;
/*      */     } 
/*      */     
/*  247 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  255 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  263 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  264 */       this._events != null && 
/*  265 */       postEventsForChanges()) {
/*  266 */       this._events.post(ITenderOptions.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  273 */     boolean ev_postable = false;
/*      */     
/*  275 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  276 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  277 */       getDAO_().setUpdateDate(argUpdateDate);
/*  278 */       ev_postable = true;
/*      */     } 
/*      */     
/*  281 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  289 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  297 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  298 */       this._events != null && 
/*  299 */       postEventsForChanges()) {
/*  300 */       this._events.post(ITenderOptions.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  307 */     boolean ev_postable = false;
/*      */     
/*  309 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  310 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  311 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  312 */       ev_postable = true;
/*      */     } 
/*      */     
/*  315 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getAuthExpirationDateRequired() {
/*  323 */     if (getDAO_().getAuthExpirationDateRequired() != null) {
/*  324 */       return getDAO_().getAuthExpirationDateRequired().booleanValue();
/*      */     }
/*      */     
/*  327 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAuthExpirationDateRequired(boolean argAuthExpirationDateRequired) {
/*  336 */     if (setAuthExpirationDateRequired_noev(argAuthExpirationDateRequired) && 
/*  337 */       this._events != null && 
/*  338 */       postEventsForChanges()) {
/*  339 */       this._events.post(ITenderOptions.SET_AUTHEXPIRATIONDATEREQUIRED, Boolean.valueOf(argAuthExpirationDateRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAuthExpirationDateRequired_noev(boolean argAuthExpirationDateRequired) {
/*  346 */     boolean ev_postable = false;
/*      */     
/*  348 */     if ((getDAO_().getAuthExpirationDateRequired() == null && Boolean.valueOf(argAuthExpirationDateRequired) != null) || (
/*  349 */       getDAO_().getAuthExpirationDateRequired() != null && !getDAO_().getAuthExpirationDateRequired().equals(Boolean.valueOf(argAuthExpirationDateRequired)))) {
/*  350 */       getDAO_().setAuthExpirationDateRequired(Boolean.valueOf(argAuthExpirationDateRequired));
/*  351 */       ev_postable = true;
/*      */     } 
/*      */     
/*  354 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAuthMethodCode() {
/*  362 */     return getDAO_().getAuthMethodCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAuthMethodCode(String argAuthMethodCode) {
/*  370 */     if (setAuthMethodCode_noev(argAuthMethodCode) && 
/*  371 */       this._events != null && 
/*  372 */       postEventsForChanges()) {
/*  373 */       this._events.post(ITenderOptions.SET_AUTHMETHODCODE, argAuthMethodCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAuthMethodCode_noev(String argAuthMethodCode) {
/*  380 */     boolean ev_postable = false;
/*      */     
/*  382 */     if ((getDAO_().getAuthMethodCode() == null && argAuthMethodCode != null) || (
/*  383 */       getDAO_().getAuthMethodCode() != null && !getDAO_().getAuthMethodCode().equals(argAuthMethodCode))) {
/*  384 */       getDAO_().setAuthMethodCode(argAuthMethodCode);
/*  385 */       ev_postable = true;
/*      */     } 
/*      */     
/*  388 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getAuthRequired() {
/*  396 */     if (getDAO_().getAuthRequired() != null) {
/*  397 */       return getDAO_().getAuthRequired().booleanValue();
/*      */     }
/*      */     
/*  400 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAuthRequired(boolean argAuthRequired) {
/*  409 */     if (setAuthRequired_noev(argAuthRequired) && 
/*  410 */       this._events != null && 
/*  411 */       postEventsForChanges()) {
/*  412 */       this._events.post(ITenderOptions.SET_AUTHREQUIRED, Boolean.valueOf(argAuthRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAuthRequired_noev(boolean argAuthRequired) {
/*  419 */     boolean ev_postable = false;
/*      */     
/*  421 */     if ((getDAO_().getAuthRequired() == null && Boolean.valueOf(argAuthRequired) != null) || (
/*  422 */       getDAO_().getAuthRequired() != null && !getDAO_().getAuthRequired().equals(Boolean.valueOf(argAuthRequired)))) {
/*  423 */       getDAO_().setAuthRequired(Boolean.valueOf(argAuthRequired));
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
/*      */   public boolean getCustAssociation() {
/*  435 */     if (getDAO_().getCustAssociation() != null) {
/*  436 */       return getDAO_().getCustAssociation().booleanValue();
/*      */     }
/*      */     
/*  439 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustAssociation(boolean argCustAssociation) {
/*  448 */     if (setCustAssociation_noev(argCustAssociation) && 
/*  449 */       this._events != null && 
/*  450 */       postEventsForChanges()) {
/*  451 */       this._events.post(ITenderOptions.SET_CUSTASSOCIATION, Boolean.valueOf(argCustAssociation));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustAssociation_noev(boolean argCustAssociation) {
/*  458 */     boolean ev_postable = false;
/*      */     
/*  460 */     if ((getDAO_().getCustAssociation() == null && Boolean.valueOf(argCustAssociation) != null) || (
/*  461 */       getDAO_().getCustAssociation() != null && !getDAO_().getCustAssociation().equals(Boolean.valueOf(argCustAssociation)))) {
/*  462 */       getDAO_().setCustAssociation(Boolean.valueOf(argCustAssociation));
/*  463 */       ev_postable = true;
/*      */     } 
/*      */     
/*  466 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustIdReqCode() {
/*  474 */     return getDAO_().getCustIdReqCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustIdReqCode(String argCustIdReqCode) {
/*  482 */     if (setCustIdReqCode_noev(argCustIdReqCode) && 
/*  483 */       this._events != null && 
/*  484 */       postEventsForChanges()) {
/*  485 */       this._events.post(ITenderOptions.SET_CUSTIDREQCODE, argCustIdReqCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustIdReqCode_noev(String argCustIdReqCode) {
/*  492 */     boolean ev_postable = false;
/*      */     
/*  494 */     if ((getDAO_().getCustIdReqCode() == null && argCustIdReqCode != null) || (
/*  495 */       getDAO_().getCustIdReqCode() != null && !getDAO_().getCustIdReqCode().equals(argCustIdReqCode))) {
/*  496 */       getDAO_().setCustIdReqCode(argCustIdReqCode);
/*  497 */       ev_postable = true;
/*      */     } 
/*      */     
/*  500 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCustomerSignatureRequired() {
/*  508 */     if (getDAO_().getCustomerSignatureRequired() != null) {
/*  509 */       return getDAO_().getCustomerSignatureRequired().booleanValue();
/*      */     }
/*      */     
/*  512 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustomerSignatureRequired(boolean argCustomerSignatureRequired) {
/*  521 */     if (setCustomerSignatureRequired_noev(argCustomerSignatureRequired) && 
/*  522 */       this._events != null && 
/*  523 */       postEventsForChanges()) {
/*  524 */       this._events.post(ITenderOptions.SET_CUSTOMERSIGNATUREREQUIRED, Boolean.valueOf(argCustomerSignatureRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustomerSignatureRequired_noev(boolean argCustomerSignatureRequired) {
/*  531 */     boolean ev_postable = false;
/*      */     
/*  533 */     if ((getDAO_().getCustomerSignatureRequired() == null && Boolean.valueOf(argCustomerSignatureRequired) != null) || (
/*  534 */       getDAO_().getCustomerSignatureRequired() != null && !getDAO_().getCustomerSignatureRequired().equals(Boolean.valueOf(argCustomerSignatureRequired)))) {
/*  535 */       getDAO_().setCustomerSignatureRequired(Boolean.valueOf(argCustomerSignatureRequired));
/*  536 */       ev_postable = true;
/*      */     } 
/*      */     
/*  539 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDfltToAmountDue() {
/*  547 */     if (getDAO_().getDfltToAmountDue() != null) {
/*  548 */       return getDAO_().getDfltToAmountDue().booleanValue();
/*      */     }
/*      */     
/*  551 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDfltToAmountDue(boolean argDfltToAmountDue) {
/*  560 */     if (setDfltToAmountDue_noev(argDfltToAmountDue) && 
/*  561 */       this._events != null && 
/*  562 */       postEventsForChanges()) {
/*  563 */       this._events.post(ITenderOptions.SET_DFLTTOAMOUNTDUE, Boolean.valueOf(argDfltToAmountDue));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDfltToAmountDue_noev(boolean argDfltToAmountDue) {
/*  570 */     boolean ev_postable = false;
/*      */     
/*  572 */     if ((getDAO_().getDfltToAmountDue() == null && Boolean.valueOf(argDfltToAmountDue) != null) || (
/*  573 */       getDAO_().getDfltToAmountDue() != null && !getDAO_().getDfltToAmountDue().equals(Boolean.valueOf(argDfltToAmountDue)))) {
/*  574 */       getDAO_().setDfltToAmountDue(Boolean.valueOf(argDfltToAmountDue));
/*  575 */       ev_postable = true;
/*      */     } 
/*      */     
/*  578 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getEffectiveDate() {
/*  586 */     return getDAO_().getEffectiveDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEffectiveDate(Date argEffectiveDate) {
/*  594 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/*  595 */       this._events != null && 
/*  596 */       postEventsForChanges()) {
/*  597 */       this._events.post(ITenderOptions.SET_EFFECTIVEDATE, argEffectiveDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/*  604 */     boolean ev_postable = false;
/*      */     
/*  606 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/*  607 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/*  608 */       getDAO_().setEffectiveDate(argEffectiveDate);
/*  609 */       ev_postable = true;
/*      */     } 
/*      */     
/*  612 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getEndorsementRequired() {
/*  620 */     if (getDAO_().getEndorsementRequired() != null) {
/*  621 */       return getDAO_().getEndorsementRequired().booleanValue();
/*      */     }
/*      */     
/*  624 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEndorsementRequired(boolean argEndorsementRequired) {
/*  633 */     if (setEndorsementRequired_noev(argEndorsementRequired) && 
/*  634 */       this._events != null && 
/*  635 */       postEventsForChanges()) {
/*  636 */       this._events.post(ITenderOptions.SET_ENDORSEMENTREQUIRED, Boolean.valueOf(argEndorsementRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEndorsementRequired_noev(boolean argEndorsementRequired) {
/*  643 */     boolean ev_postable = false;
/*      */     
/*  645 */     if ((getDAO_().getEndorsementRequired() == null && Boolean.valueOf(argEndorsementRequired) != null) || (
/*  646 */       getDAO_().getEndorsementRequired() != null && !getDAO_().getEndorsementRequired().equals(Boolean.valueOf(argEndorsementRequired)))) {
/*  647 */       getDAO_().setEndorsementRequired(Boolean.valueOf(argEndorsementRequired));
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
/*      */   public Date getExpirationDate() {
/*  659 */     return getDAO_().getExpirationDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExpirationDate(Date argExpirationDate) {
/*  667 */     if (setExpirationDate_noev(argExpirationDate) && 
/*  668 */       this._events != null && 
/*  669 */       postEventsForChanges()) {
/*  670 */       this._events.post(ITenderOptions.SET_EXPIRATIONDATE, argExpirationDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/*  677 */     boolean ev_postable = false;
/*      */     
/*  679 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/*  680 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/*  681 */       getDAO_().setExpirationDate(argExpirationDate);
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
/*      */   public boolean getIncludeInTypeCount() {
/*  693 */     if (getDAO_().getIncludeInTypeCount() != null) {
/*  694 */       return getDAO_().getIncludeInTypeCount().booleanValue();
/*      */     }
/*      */     
/*  697 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIncludeInTypeCount(boolean argIncludeInTypeCount) {
/*  706 */     if (setIncludeInTypeCount_noev(argIncludeInTypeCount) && 
/*  707 */       this._events != null && 
/*  708 */       postEventsForChanges()) {
/*  709 */       this._events.post(ITenderOptions.SET_INCLUDEINTYPECOUNT, Boolean.valueOf(argIncludeInTypeCount));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setIncludeInTypeCount_noev(boolean argIncludeInTypeCount) {
/*  716 */     boolean ev_postable = false;
/*      */     
/*  718 */     if ((getDAO_().getIncludeInTypeCount() == null && Boolean.valueOf(argIncludeInTypeCount) != null) || (
/*  719 */       getDAO_().getIncludeInTypeCount() != null && !getDAO_().getIncludeInTypeCount().equals(Boolean.valueOf(argIncludeInTypeCount)))) {
/*  720 */       getDAO_().setIncludeInTypeCount(Boolean.valueOf(argIncludeInTypeCount));
/*  721 */       ev_postable = true;
/*      */     } 
/*      */     
/*  724 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getMagneticSwipeReaderRequired() {
/*  732 */     if (getDAO_().getMagneticSwipeReaderRequired() != null) {
/*  733 */       return getDAO_().getMagneticSwipeReaderRequired().booleanValue();
/*      */     }
/*      */     
/*  736 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMagneticSwipeReaderRequired(boolean argMagneticSwipeReaderRequired) {
/*  745 */     if (setMagneticSwipeReaderRequired_noev(argMagneticSwipeReaderRequired) && 
/*  746 */       this._events != null && 
/*  747 */       postEventsForChanges()) {
/*  748 */       this._events.post(ITenderOptions.SET_MAGNETICSWIPEREADERREQUIRED, Boolean.valueOf(argMagneticSwipeReaderRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMagneticSwipeReaderRequired_noev(boolean argMagneticSwipeReaderRequired) {
/*  755 */     boolean ev_postable = false;
/*      */     
/*  757 */     if ((getDAO_().getMagneticSwipeReaderRequired() == null && Boolean.valueOf(argMagneticSwipeReaderRequired) != null) || (
/*  758 */       getDAO_().getMagneticSwipeReaderRequired() != null && !getDAO_().getMagneticSwipeReaderRequired().equals(Boolean.valueOf(argMagneticSwipeReaderRequired)))) {
/*  759 */       getDAO_().setMagneticSwipeReaderRequired(Boolean.valueOf(argMagneticSwipeReaderRequired));
/*  760 */       ev_postable = true;
/*      */     } 
/*      */     
/*  763 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxDaysForReturn() {
/*  771 */     if (getDAO_().getMaxDaysForReturn() != null) {
/*  772 */       return getDAO_().getMaxDaysForReturn().intValue();
/*      */     }
/*      */     
/*  775 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxDaysForReturn(int argMaxDaysForReturn) {
/*  784 */     if (setMaxDaysForReturn_noev(argMaxDaysForReturn) && 
/*  785 */       this._events != null && 
/*  786 */       postEventsForChanges()) {
/*  787 */       this._events.post(ITenderOptions.SET_MAXDAYSFORRETURN, Integer.valueOf(argMaxDaysForReturn));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMaxDaysForReturn_noev(int argMaxDaysForReturn) {
/*  794 */     boolean ev_postable = false;
/*      */     
/*  796 */     if ((getDAO_().getMaxDaysForReturn() == null && Integer.valueOf(argMaxDaysForReturn) != null) || (
/*  797 */       getDAO_().getMaxDaysForReturn() != null && !getDAO_().getMaxDaysForReturn().equals(Integer.valueOf(argMaxDaysForReturn)))) {
/*  798 */       getDAO_().setMaxDaysForReturn(Integer.valueOf(argMaxDaysForReturn));
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
/*      */   public int getMinDaysForReturn() {
/*  810 */     if (getDAO_().getMinDaysForReturn() != null) {
/*  811 */       return getDAO_().getMinDaysForReturn().intValue();
/*      */     }
/*      */     
/*  814 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMinDaysForReturn(int argMinDaysForReturn) {
/*  823 */     if (setMinDaysForReturn_noev(argMinDaysForReturn) && 
/*  824 */       this._events != null && 
/*  825 */       postEventsForChanges()) {
/*  826 */       this._events.post(ITenderOptions.SET_MINDAYSFORRETURN, Integer.valueOf(argMinDaysForReturn));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMinDaysForReturn_noev(int argMinDaysForReturn) {
/*  833 */     boolean ev_postable = false;
/*      */     
/*  835 */     if ((getDAO_().getMinDaysForReturn() == null && Integer.valueOf(argMinDaysForReturn) != null) || (
/*  836 */       getDAO_().getMinDaysForReturn() != null && !getDAO_().getMinDaysForReturn().equals(Integer.valueOf(argMinDaysForReturn)))) {
/*  837 */       getDAO_().setMinDaysForReturn(Integer.valueOf(argMinDaysForReturn));
/*  838 */       ev_postable = true;
/*      */     } 
/*      */     
/*  841 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal getMinimumDenominationAmountImpl() {
/*  849 */     return getDAO_().getMinimumDenominationAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMinimumDenominationAmount(BigDecimal argMinimumDenominationAmount) {
/*  857 */     if (setMinimumDenominationAmount_noev(argMinimumDenominationAmount) && 
/*  858 */       this._events != null && 
/*  859 */       postEventsForChanges()) {
/*  860 */       this._events.post(ITenderOptions.SET_MINIMUMDENOMINATIONAMOUNT, argMinimumDenominationAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMinimumDenominationAmount_noev(BigDecimal argMinimumDenominationAmount) {
/*  867 */     boolean ev_postable = false;
/*      */     
/*  869 */     if ((getDAO_().getMinimumDenominationAmount() == null && argMinimumDenominationAmount != null) || (
/*  870 */       getDAO_().getMinimumDenominationAmount() != null && !getDAO_().getMinimumDenominationAmount().equals(argMinimumDenominationAmount))) {
/*  871 */       getDAO_().setMinimumDenominationAmount(argMinimumDenominationAmount);
/*  872 */       ev_postable = true;
/*      */     } 
/*      */     
/*  875 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getOpenCashDrawerRequired() {
/*  883 */     if (getDAO_().getOpenCashDrawerRequired() != null) {
/*  884 */       return getDAO_().getOpenCashDrawerRequired().booleanValue();
/*      */     }
/*      */     
/*  887 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOpenCashDrawerRequired(boolean argOpenCashDrawerRequired) {
/*  896 */     if (setOpenCashDrawerRequired_noev(argOpenCashDrawerRequired) && 
/*  897 */       this._events != null && 
/*  898 */       postEventsForChanges()) {
/*  899 */       this._events.post(ITenderOptions.SET_OPENCASHDRAWERREQUIRED, Boolean.valueOf(argOpenCashDrawerRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOpenCashDrawerRequired_noev(boolean argOpenCashDrawerRequired) {
/*  906 */     boolean ev_postable = false;
/*      */     
/*  908 */     if ((getDAO_().getOpenCashDrawerRequired() == null && Boolean.valueOf(argOpenCashDrawerRequired) != null) || (
/*  909 */       getDAO_().getOpenCashDrawerRequired() != null && !getDAO_().getOpenCashDrawerRequired().equals(Boolean.valueOf(argOpenCashDrawerRequired)))) {
/*  910 */       getDAO_().setOpenCashDrawerRequired(Boolean.valueOf(argOpenCashDrawerRequired));
/*  911 */       ev_postable = true;
/*      */     } 
/*      */     
/*  914 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getPinRequired() {
/*  922 */     if (getDAO_().getPinRequired() != null) {
/*  923 */       return getDAO_().getPinRequired().booleanValue();
/*      */     }
/*      */     
/*  926 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPinRequired(boolean argPinRequired) {
/*  935 */     if (setPinRequired_noev(argPinRequired) && 
/*  936 */       this._events != null && 
/*  937 */       postEventsForChanges()) {
/*  938 */       this._events.post(ITenderOptions.SET_PINREQUIRED, Boolean.valueOf(argPinRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPinRequired_noev(boolean argPinRequired) {
/*  945 */     boolean ev_postable = false;
/*      */     
/*  947 */     if ((getDAO_().getPinRequired() == null && Boolean.valueOf(argPinRequired) != null) || (
/*  948 */       getDAO_().getPinRequired() != null && !getDAO_().getPinRequired().equals(Boolean.valueOf(argPinRequired)))) {
/*  949 */       getDAO_().setPinRequired(Boolean.valueOf(argPinRequired));
/*  950 */       ev_postable = true;
/*      */     } 
/*      */     
/*  953 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getPopulateSystemCount() {
/*  961 */     if (getDAO_().getPopulateSystemCount() != null) {
/*  962 */       return getDAO_().getPopulateSystemCount().booleanValue();
/*      */     }
/*      */     
/*  965 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPopulateSystemCount(boolean argPopulateSystemCount) {
/*  974 */     if (setPopulateSystemCount_noev(argPopulateSystemCount) && 
/*  975 */       this._events != null && 
/*  976 */       postEventsForChanges()) {
/*  977 */       this._events.post(ITenderOptions.SET_POPULATESYSTEMCOUNT, Boolean.valueOf(argPopulateSystemCount));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPopulateSystemCount_noev(boolean argPopulateSystemCount) {
/*  984 */     boolean ev_postable = false;
/*      */     
/*  986 */     if ((getDAO_().getPopulateSystemCount() == null && Boolean.valueOf(argPopulateSystemCount) != null) || (
/*  987 */       getDAO_().getPopulateSystemCount() != null && !getDAO_().getPopulateSystemCount().equals(Boolean.valueOf(argPopulateSystemCount)))) {
/*  988 */       getDAO_().setPopulateSystemCount(Boolean.valueOf(argPopulateSystemCount));
/*  989 */       ev_postable = true;
/*      */     } 
/*      */     
/*  992 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getSerialIdentificationNbrRequired() {
/* 1000 */     if (getDAO_().getSerialIdentificationNbrRequired() != null) {
/* 1001 */       return getDAO_().getSerialIdentificationNbrRequired().booleanValue();
/*      */     }
/*      */     
/* 1004 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSerialIdentificationNbrRequired(boolean argSerialIdentificationNbrRequired) {
/* 1013 */     if (setSerialIdentificationNbrRequired_noev(argSerialIdentificationNbrRequired) && 
/* 1014 */       this._events != null && 
/* 1015 */       postEventsForChanges()) {
/* 1016 */       this._events.post(ITenderOptions.SET_SERIALIDENTIFICATIONNBRREQUIRED, Boolean.valueOf(argSerialIdentificationNbrRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSerialIdentificationNbrRequired_noev(boolean argSerialIdentificationNbrRequired) {
/* 1023 */     boolean ev_postable = false;
/*      */     
/* 1025 */     if ((getDAO_().getSerialIdentificationNbrRequired() == null && Boolean.valueOf(argSerialIdentificationNbrRequired) != null) || (
/* 1026 */       getDAO_().getSerialIdentificationNbrRequired() != null && !getDAO_().getSerialIdentificationNbrRequired().equals(Boolean.valueOf(argSerialIdentificationNbrRequired)))) {
/* 1027 */       getDAO_().setSerialIdentificationNbrRequired(Boolean.valueOf(argSerialIdentificationNbrRequired));
/* 1028 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1031 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUnitCountCode() {
/* 1039 */     return getDAO_().getUnitCountCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUnitCountCode(String argUnitCountCode) {
/* 1047 */     if (setUnitCountCode_noev(argUnitCountCode) && 
/* 1048 */       this._events != null && 
/* 1049 */       postEventsForChanges()) {
/* 1050 */       this._events.post(ITenderOptions.SET_UNITCOUNTCODE, argUnitCountCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUnitCountCode_noev(String argUnitCountCode) {
/* 1057 */     boolean ev_postable = false;
/*      */     
/* 1059 */     if ((getDAO_().getUnitCountCode() == null && argUnitCountCode != null) || (
/* 1060 */       getDAO_().getUnitCountCode() != null && !getDAO_().getUnitCountCode().equals(argUnitCountCode))) {
/* 1061 */       getDAO_().setUnitCountCode(argUnitCountCode);
/* 1062 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1065 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getSuggestDeposit() {
/* 1073 */     if (getDAO_().getSuggestDeposit() != null) {
/* 1074 */       return getDAO_().getSuggestDeposit().booleanValue();
/*      */     }
/*      */     
/* 1077 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSuggestDeposit(boolean argSuggestDeposit) {
/* 1086 */     if (setSuggestDeposit_noev(argSuggestDeposit) && 
/* 1087 */       this._events != null && 
/* 1088 */       postEventsForChanges()) {
/* 1089 */       this._events.post(ITenderOptions.SET_SUGGESTDEPOSIT, Boolean.valueOf(argSuggestDeposit));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSuggestDeposit_noev(boolean argSuggestDeposit) {
/* 1096 */     boolean ev_postable = false;
/*      */     
/* 1098 */     if ((getDAO_().getSuggestDeposit() == null && Boolean.valueOf(argSuggestDeposit) != null) || (
/* 1099 */       getDAO_().getSuggestDeposit() != null && !getDAO_().getSuggestDeposit().equals(Boolean.valueOf(argSuggestDeposit)))) {
/* 1100 */       getDAO_().setSuggestDeposit(Boolean.valueOf(argSuggestDeposit));
/* 1101 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1104 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getSuggestedDepositThreshold() {
/* 1112 */     return getDAO_().getSuggestedDepositThreshold();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSuggestedDepositThreshold(BigDecimal argSuggestedDepositThreshold) {
/* 1120 */     if (setSuggestedDepositThreshold_noev(argSuggestedDepositThreshold) && 
/* 1121 */       this._events != null && 
/* 1122 */       postEventsForChanges()) {
/* 1123 */       this._events.post(ITenderOptions.SET_SUGGESTEDDEPOSITTHRESHOLD, argSuggestedDepositThreshold);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSuggestedDepositThreshold_noev(BigDecimal argSuggestedDepositThreshold) {
/* 1130 */     boolean ev_postable = false;
/*      */     
/* 1132 */     if ((getDAO_().getSuggestedDepositThreshold() == null && argSuggestedDepositThreshold != null) || (
/* 1133 */       getDAO_().getSuggestedDepositThreshold() != null && !getDAO_().getSuggestedDepositThreshold().equals(argSuggestedDepositThreshold))) {
/* 1134 */       getDAO_().setSuggestedDepositThreshold(argSuggestedDepositThreshold);
/* 1135 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1138 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getCashChangeLimit() {
/* 1146 */     return getDAO_().getCashChangeLimit();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCashChangeLimit(BigDecimal argCashChangeLimit) {
/* 1154 */     if (setCashChangeLimit_noev(argCashChangeLimit) && 
/* 1155 */       this._events != null && 
/* 1156 */       postEventsForChanges()) {
/* 1157 */       this._events.post(ITenderOptions.SET_CASHCHANGELIMIT, argCashChangeLimit);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCashChangeLimit_noev(BigDecimal argCashChangeLimit) {
/* 1164 */     boolean ev_postable = false;
/*      */     
/* 1166 */     if ((getDAO_().getCashChangeLimit() == null && argCashChangeLimit != null) || (
/* 1167 */       getDAO_().getCashChangeLimit() != null && !getDAO_().getCashChangeLimit().equals(argCashChangeLimit))) {
/* 1168 */       getDAO_().setCashChangeLimit(argCashChangeLimit);
/* 1169 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1172 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getChangeTenderId() {
/* 1180 */     return getDAO_().getChangeTenderId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setChangeTenderId(String argChangeTenderId) {
/* 1188 */     if (setChangeTenderId_noev(argChangeTenderId) && 
/* 1189 */       this._events != null && 
/* 1190 */       postEventsForChanges()) {
/* 1191 */       this._events.post(ITenderOptions.SET_CHANGETENDERID, argChangeTenderId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setChangeTenderId_noev(String argChangeTenderId) {
/* 1198 */     boolean ev_postable = false;
/*      */     
/* 1200 */     if ((getDAO_().getChangeTenderId() == null && argChangeTenderId != null) || (
/* 1201 */       getDAO_().getChangeTenderId() != null && !getDAO_().getChangeTenderId().equals(argChangeTenderId))) {
/* 1202 */       getDAO_().setChangeTenderId(argChangeTenderId);
/* 1203 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1206 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getOvertenderOverridable() {
/* 1214 */     if (getDAO_().getOvertenderOverridable() != null) {
/* 1215 */       return getDAO_().getOvertenderOverridable().booleanValue();
/*      */     }
/*      */     
/* 1218 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOvertenderOverridable(boolean argOvertenderOverridable) {
/* 1227 */     if (setOvertenderOverridable_noev(argOvertenderOverridable) && 
/* 1228 */       this._events != null && 
/* 1229 */       postEventsForChanges()) {
/* 1230 */       this._events.post(ITenderOptions.SET_OVERTENDEROVERRIDABLE, Boolean.valueOf(argOvertenderOverridable));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOvertenderOverridable_noev(boolean argOvertenderOverridable) {
/* 1237 */     boolean ev_postable = false;
/*      */     
/* 1239 */     if ((getDAO_().getOvertenderOverridable() == null && Boolean.valueOf(argOvertenderOverridable) != null) || (
/* 1240 */       getDAO_().getOvertenderOverridable() != null && !getDAO_().getOvertenderOverridable().equals(Boolean.valueOf(argOvertenderOverridable)))) {
/* 1241 */       getDAO_().setOvertenderOverridable(Boolean.valueOf(argOvertenderOverridable));
/* 1242 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1245 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getNonVoidable() {
/* 1253 */     if (getDAO_().getNonVoidable() != null) {
/* 1254 */       return getDAO_().getNonVoidable().booleanValue();
/*      */     }
/*      */     
/* 1257 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNonVoidable(boolean argNonVoidable) {
/* 1266 */     if (setNonVoidable_noev(argNonVoidable) && 
/* 1267 */       this._events != null && 
/* 1268 */       postEventsForChanges()) {
/* 1269 */       this._events.post(ITenderOptions.SET_NONVOIDABLE, Boolean.valueOf(argNonVoidable));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNonVoidable_noev(boolean argNonVoidable) {
/* 1276 */     boolean ev_postable = false;
/*      */     
/* 1278 */     if ((getDAO_().getNonVoidable() == null && Boolean.valueOf(argNonVoidable) != null) || (
/* 1279 */       getDAO_().getNonVoidable() != null && !getDAO_().getNonVoidable().equals(Boolean.valueOf(argNonVoidable)))) {
/* 1280 */       getDAO_().setNonVoidable(Boolean.valueOf(argNonVoidable));
/* 1281 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1284 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getCloseCountDiscrepancyThreshold() {
/* 1292 */     return getDAO_().getCloseCountDiscrepancyThreshold();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCloseCountDiscrepancyThreshold(BigDecimal argCloseCountDiscrepancyThreshold) {
/* 1300 */     if (setCloseCountDiscrepancyThreshold_noev(argCloseCountDiscrepancyThreshold) && 
/* 1301 */       this._events != null && 
/* 1302 */       postEventsForChanges()) {
/* 1303 */       this._events.post(ITenderOptions.SET_CLOSECOUNTDISCREPANCYTHRESHOLD, argCloseCountDiscrepancyThreshold);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCloseCountDiscrepancyThreshold_noev(BigDecimal argCloseCountDiscrepancyThreshold) {
/* 1310 */     boolean ev_postable = false;
/*      */     
/* 1312 */     if ((getDAO_().getCloseCountDiscrepancyThreshold() == null && argCloseCountDiscrepancyThreshold != null) || (
/* 1313 */       getDAO_().getCloseCountDiscrepancyThreshold() != null && !getDAO_().getCloseCountDiscrepancyThreshold().equals(argCloseCountDiscrepancyThreshold))) {
/* 1314 */       getDAO_().setCloseCountDiscrepancyThreshold(argCloseCountDiscrepancyThreshold);
/* 1315 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1318 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCidMsrRequired() {
/* 1326 */     if (getDAO_().getCidMsrRequired() != null) {
/* 1327 */       return getDAO_().getCidMsrRequired().booleanValue();
/*      */     }
/*      */     
/* 1330 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCidMsrRequired(boolean argCidMsrRequired) {
/* 1339 */     if (setCidMsrRequired_noev(argCidMsrRequired) && 
/* 1340 */       this._events != null && 
/* 1341 */       postEventsForChanges()) {
/* 1342 */       this._events.post(ITenderOptions.SET_CIDMSRREQUIRED, Boolean.valueOf(argCidMsrRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCidMsrRequired_noev(boolean argCidMsrRequired) {
/* 1349 */     boolean ev_postable = false;
/*      */     
/* 1351 */     if ((getDAO_().getCidMsrRequired() == null && Boolean.valueOf(argCidMsrRequired) != null) || (
/* 1352 */       getDAO_().getCidMsrRequired() != null && !getDAO_().getCidMsrRequired().equals(Boolean.valueOf(argCidMsrRequired)))) {
/* 1353 */       getDAO_().setCidMsrRequired(Boolean.valueOf(argCidMsrRequired));
/* 1354 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1357 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCidKeyedRequired() {
/* 1365 */     if (getDAO_().getCidKeyedRequired() != null) {
/* 1366 */       return getDAO_().getCidKeyedRequired().booleanValue();
/*      */     }
/*      */     
/* 1369 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCidKeyedRequired(boolean argCidKeyedRequired) {
/* 1378 */     if (setCidKeyedRequired_noev(argCidKeyedRequired) && 
/* 1379 */       this._events != null && 
/* 1380 */       postEventsForChanges()) {
/* 1381 */       this._events.post(ITenderOptions.SET_CIDKEYEDREQUIRED, Boolean.valueOf(argCidKeyedRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCidKeyedRequired_noev(boolean argCidKeyedRequired) {
/* 1388 */     boolean ev_postable = false;
/*      */     
/* 1390 */     if ((getDAO_().getCidKeyedRequired() == null && Boolean.valueOf(argCidKeyedRequired) != null) || (
/* 1391 */       getDAO_().getCidKeyedRequired() != null && !getDAO_().getCidKeyedRequired().equals(Boolean.valueOf(argCidKeyedRequired)))) {
/* 1392 */       getDAO_().setCidKeyedRequired(Boolean.valueOf(argCidKeyedRequired));
/* 1393 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1396 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getPostalRequired() {
/* 1404 */     if (getDAO_().getPostalRequired() != null) {
/* 1405 */       return getDAO_().getPostalRequired().booleanValue();
/*      */     }
/*      */     
/* 1408 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPostalRequired(boolean argPostalRequired) {
/* 1417 */     if (setPostalRequired_noev(argPostalRequired) && 
/* 1418 */       this._events != null && 
/* 1419 */       postEventsForChanges()) {
/* 1420 */       this._events.post(ITenderOptions.SET_POSTALREQUIRED, Boolean.valueOf(argPostalRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPostalRequired_noev(boolean argPostalRequired) {
/* 1427 */     boolean ev_postable = false;
/*      */     
/* 1429 */     if ((getDAO_().getPostalRequired() == null && Boolean.valueOf(argPostalRequired) != null) || (
/* 1430 */       getDAO_().getPostalRequired() != null && !getDAO_().getPostalRequired().equals(Boolean.valueOf(argPostalRequired)))) {
/* 1431 */       getDAO_().setPostalRequired(Boolean.valueOf(argPostalRequired));
/* 1432 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1435 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDisallowSplitTender() {
/* 1443 */     if (getDAO_().getDisallowSplitTender() != null) {
/* 1444 */       return getDAO_().getDisallowSplitTender().booleanValue();
/*      */     }
/*      */     
/* 1447 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisallowSplitTender(boolean argDisallowSplitTender) {
/* 1456 */     if (setDisallowSplitTender_noev(argDisallowSplitTender) && 
/* 1457 */       this._events != null && 
/* 1458 */       postEventsForChanges()) {
/* 1459 */       this._events.post(ITenderOptions.SET_DISALLOWSPLITTENDER, Boolean.valueOf(argDisallowSplitTender));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDisallowSplitTender_noev(boolean argDisallowSplitTender) {
/* 1466 */     boolean ev_postable = false;
/*      */     
/* 1468 */     if ((getDAO_().getDisallowSplitTender() == null && Boolean.valueOf(argDisallowSplitTender) != null) || (
/* 1469 */       getDAO_().getDisallowSplitTender() != null && !getDAO_().getDisallowSplitTender().equals(Boolean.valueOf(argDisallowSplitTender)))) {
/* 1470 */       getDAO_().setDisallowSplitTender(Boolean.valueOf(argDisallowSplitTender));
/* 1471 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1474 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getPostVoidOpenCashDrawerRequired() {
/* 1482 */     if (getDAO_().getPostVoidOpenCashDrawerRequired() != null) {
/* 1483 */       return getDAO_().getPostVoidOpenCashDrawerRequired().booleanValue();
/*      */     }
/*      */     
/* 1486 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPostVoidOpenCashDrawerRequired(boolean argPostVoidOpenCashDrawerRequired) {
/* 1495 */     if (setPostVoidOpenCashDrawerRequired_noev(argPostVoidOpenCashDrawerRequired) && 
/* 1496 */       this._events != null && 
/* 1497 */       postEventsForChanges()) {
/* 1498 */       this._events.post(ITenderOptions.SET_POSTVOIDOPENCASHDRAWERREQUIRED, Boolean.valueOf(argPostVoidOpenCashDrawerRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPostVoidOpenCashDrawerRequired_noev(boolean argPostVoidOpenCashDrawerRequired) {
/* 1505 */     boolean ev_postable = false;
/*      */     
/* 1507 */     if ((getDAO_().getPostVoidOpenCashDrawerRequired() == null && Boolean.valueOf(argPostVoidOpenCashDrawerRequired) != null) || (
/* 1508 */       getDAO_().getPostVoidOpenCashDrawerRequired() != null && !getDAO_().getPostVoidOpenCashDrawerRequired().equals(Boolean.valueOf(argPostVoidOpenCashDrawerRequired)))) {
/* 1509 */       getDAO_().setPostVoidOpenCashDrawerRequired(Boolean.valueOf(argPostVoidOpenCashDrawerRequired));
/* 1510 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1513 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getReportingGroup() {
/* 1521 */     return getDAO_().getReportingGroup();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReportingGroup(String argReportingGroup) {
/* 1529 */     if (setReportingGroup_noev(argReportingGroup) && 
/* 1530 */       this._events != null && 
/* 1531 */       postEventsForChanges()) {
/* 1532 */       this._events.post(ITenderOptions.SET_REPORTINGGROUP, argReportingGroup);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setReportingGroup_noev(String argReportingGroup) {
/* 1539 */     boolean ev_postable = false;
/*      */     
/* 1541 */     if ((getDAO_().getReportingGroup() == null && argReportingGroup != null) || (
/* 1542 */       getDAO_().getReportingGroup() != null && !getDAO_().getReportingGroup().equals(argReportingGroup))) {
/* 1543 */       getDAO_().setReportingGroup(argReportingGroup);
/* 1544 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1547 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getChangeAllowedWhenForeign() {
/* 1555 */     if (getDAO_().getChangeAllowedWhenForeign() != null) {
/* 1556 */       return getDAO_().getChangeAllowedWhenForeign().booleanValue();
/*      */     }
/*      */     
/* 1559 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setChangeAllowedWhenForeign(boolean argChangeAllowedWhenForeign) {
/* 1568 */     if (setChangeAllowedWhenForeign_noev(argChangeAllowedWhenForeign) && 
/* 1569 */       this._events != null && 
/* 1570 */       postEventsForChanges()) {
/* 1571 */       this._events.post(ITenderOptions.SET_CHANGEALLOWEDWHENFOREIGN, Boolean.valueOf(argChangeAllowedWhenForeign));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setChangeAllowedWhenForeign_noev(boolean argChangeAllowedWhenForeign) {
/* 1578 */     boolean ev_postable = false;
/*      */     
/* 1580 */     if ((getDAO_().getChangeAllowedWhenForeign() == null && Boolean.valueOf(argChangeAllowedWhenForeign) != null) || (
/* 1581 */       getDAO_().getChangeAllowedWhenForeign() != null && !getDAO_().getChangeAllowedWhenForeign().equals(Boolean.valueOf(argChangeAllowedWhenForeign)))) {
/* 1582 */       getDAO_().setChangeAllowedWhenForeign(Boolean.valueOf(argChangeAllowedWhenForeign));
/* 1583 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1586 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFiscalTenderId() {
/* 1594 */     return getDAO_().getFiscalTenderId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFiscalTenderId(String argFiscalTenderId) {
/* 1602 */     if (setFiscalTenderId_noev(argFiscalTenderId) && 
/* 1603 */       this._events != null && 
/* 1604 */       postEventsForChanges()) {
/* 1605 */       this._events.post(ITenderOptions.SET_FISCALTENDERID, argFiscalTenderId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFiscalTenderId_noev(String argFiscalTenderId) {
/* 1612 */     boolean ev_postable = false;
/*      */     
/* 1614 */     if ((getDAO_().getFiscalTenderId() == null && argFiscalTenderId != null) || (
/* 1615 */       getDAO_().getFiscalTenderId() != null && !getDAO_().getFiscalTenderId().equals(argFiscalTenderId))) {
/* 1616 */       getDAO_().setFiscalTenderId(argFiscalTenderId);
/* 1617 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1620 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getRoundingMode() {
/* 1628 */     return getDAO_().getRoundingMode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRoundingMode(String argRoundingMode) {
/* 1636 */     if (setRoundingMode_noev(argRoundingMode) && 
/* 1637 */       this._events != null && 
/* 1638 */       postEventsForChanges()) {
/* 1639 */       this._events.post(ITenderOptions.SET_ROUNDINGMODE, argRoundingMode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRoundingMode_noev(String argRoundingMode) {
/* 1646 */     boolean ev_postable = false;
/*      */     
/* 1648 */     if ((getDAO_().getRoundingMode() == null && argRoundingMode != null) || (
/* 1649 */       getDAO_().getRoundingMode() != null && !getDAO_().getRoundingMode().equals(argRoundingMode))) {
/* 1650 */       getDAO_().setRoundingMode(argRoundingMode);
/* 1651 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1654 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getAssignCashDrawerRequired() {
/* 1662 */     if (getDAO_().getAssignCashDrawerRequired() != null) {
/* 1663 */       return getDAO_().getAssignCashDrawerRequired().booleanValue();
/*      */     }
/*      */     
/* 1666 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAssignCashDrawerRequired(boolean argAssignCashDrawerRequired) {
/* 1675 */     if (setAssignCashDrawerRequired_noev(argAssignCashDrawerRequired) && 
/* 1676 */       this._events != null && 
/* 1677 */       postEventsForChanges()) {
/* 1678 */       this._events.post(ITenderOptions.SET_ASSIGNCASHDRAWERREQUIRED, Boolean.valueOf(argAssignCashDrawerRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAssignCashDrawerRequired_noev(boolean argAssignCashDrawerRequired) {
/* 1685 */     boolean ev_postable = false;
/*      */     
/* 1687 */     if ((getDAO_().getAssignCashDrawerRequired() == null && Boolean.valueOf(argAssignCashDrawerRequired) != null) || (
/* 1688 */       getDAO_().getAssignCashDrawerRequired() != null && !getDAO_().getAssignCashDrawerRequired().equals(Boolean.valueOf(argAssignCashDrawerRequired)))) {
/* 1689 */       getDAO_().setAssignCashDrawerRequired(Boolean.valueOf(argAssignCashDrawerRequired));
/* 1690 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1693 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getPostVoidAssignCashDrawerRequired() {
/* 1701 */     if (getDAO_().getPostVoidAssignCashDrawerRequired() != null) {
/* 1702 */       return getDAO_().getPostVoidAssignCashDrawerRequired().booleanValue();
/*      */     }
/*      */     
/* 1705 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPostVoidAssignCashDrawerRequired(boolean argPostVoidAssignCashDrawerRequired) {
/* 1714 */     if (setPostVoidAssignCashDrawerRequired_noev(argPostVoidAssignCashDrawerRequired) && 
/* 1715 */       this._events != null && 
/* 1716 */       postEventsForChanges()) {
/* 1717 */       this._events.post(ITenderOptions.SET_POSTVOIDASSIGNCASHDRAWERREQUIRED, Boolean.valueOf(argPostVoidAssignCashDrawerRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPostVoidAssignCashDrawerRequired_noev(boolean argPostVoidAssignCashDrawerRequired) {
/* 1724 */     boolean ev_postable = false;
/*      */     
/* 1726 */     if ((getDAO_().getPostVoidAssignCashDrawerRequired() == null && Boolean.valueOf(argPostVoidAssignCashDrawerRequired) != null) || (
/* 1727 */       getDAO_().getPostVoidAssignCashDrawerRequired() != null && !getDAO_().getPostVoidAssignCashDrawerRequired().equals(Boolean.valueOf(argPostVoidAssignCashDrawerRequired)))) {
/* 1728 */       getDAO_().setPostVoidAssignCashDrawerRequired(Boolean.valueOf(argPostVoidAssignCashDrawerRequired));
/* 1729 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1732 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ITenderOptionsProperty newProperty(String argPropertyName) {
/* 1736 */     TenderOptionsPropertyId id = new TenderOptionsPropertyId();
/*      */     
/* 1738 */     id.setTenderId(getTenderId());
/* 1739 */     id.setConfigElement(getConfigElement());
/* 1740 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1742 */     ITenderOptionsProperty prop = (ITenderOptionsProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITenderOptionsProperty.class);
/* 1743 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ITenderOptionsProperty> getProperties() {
/* 1752 */     if (this._properties == null) {
/* 1753 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1755 */     return (List<ITenderOptionsProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ITenderOptionsProperty> argProperties) {
/* 1759 */     if (this._properties == null) {
/* 1760 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1762 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1765 */     for (ITenderOptionsProperty child : this._properties) {
/* 1766 */       TenderOptionsPropertyModel model = (TenderOptionsPropertyModel)child;
/* 1767 */       model.setOrganizationId_noev(getOrganizationId());
/* 1768 */       model.setTenderId_noev(getTenderId());
/* 1769 */       model.setConfigElement_noev(getConfigElement());
/* 1770 */       if (child instanceof IDataModelImpl) {
/* 1771 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1772 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1773 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1774 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1777 */       if (postEventsForChanges()) {
/* 1778 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addTenderOptionsProperty(ITenderOptionsProperty argTenderOptionsProperty) {
/* 1784 */     if (this._properties == null) {
/* 1785 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1787 */     argTenderOptionsProperty.setOrganizationId(getOrganizationId());
/* 1788 */     argTenderOptionsProperty.setTenderId(getTenderId());
/* 1789 */     argTenderOptionsProperty.setConfigElement(getConfigElement());
/* 1790 */     if (argTenderOptionsProperty instanceof IDataModelImpl) {
/* 1791 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderOptionsProperty).getDAO();
/* 1792 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1793 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1794 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1799 */     if (postEventsForChanges()) {
/* 1800 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderOptionsProperty));
/*      */     }
/*      */     
/* 1803 */     this._properties.add(argTenderOptionsProperty);
/* 1804 */     if (postEventsForChanges()) {
/* 1805 */       this._events.post(ITenderOptions.ADD_PROPERTIES, argTenderOptionsProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTenderOptionsProperty(ITenderOptionsProperty argTenderOptionsProperty) {
/* 1810 */     if (this._properties != null) {
/*      */       
/* 1812 */       if (postEventsForChanges()) {
/* 1813 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderOptionsProperty));
/*      */       }
/* 1815 */       this._properties.remove(argTenderOptionsProperty);
/* 1816 */       if (postEventsForChanges()) {
/* 1817 */         this._events.post(ITenderOptions.REMOVE_PROPERTIES, argTenderOptionsProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentTender(ITender argParentTender) {
/* 1823 */     this._parentTender = argParentTender;
/*      */   }
/*      */   
/*      */   public ITender getParentTender() {
/* 1827 */     return this._parentTender;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1832 */     if ("Properties".equals(argFieldId)) {
/* 1833 */       return getProperties();
/*      */     }
/* 1835 */     if ("TenderOptionsExtension".equals(argFieldId)) {
/* 1836 */       return this._myExtension;
/*      */     }
/*      */     
/* 1839 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1845 */     if ("Properties".equals(argFieldId)) {
/* 1846 */       setProperties(changeToList(argValue, ITenderOptionsProperty.class));
/*      */     }
/* 1848 */     else if ("TenderOptionsExtension".equals(argFieldId)) {
/* 1849 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1852 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1858 */     this._persistenceDefaults = argPD;
/* 1859 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1860 */     this._eventManager = argEM;
/* 1861 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1862 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1863 */     if (this._properties != null) {
/* 1864 */       for (ITenderOptionsProperty relationship : this._properties) {
/* 1865 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getTenderOptionsExt() {
/* 1871 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setTenderOptionsExt(IDataModel argExt) {
/* 1875 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1880 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1884 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1887 */     super.startTransaction();
/*      */     
/* 1889 */     this._propertiesSavepoint = this._properties;
/* 1890 */     if (this._properties != null) {
/* 1891 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1892 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1893 */       while (it.hasNext()) {
/* 1894 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1899 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1904 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1907 */     super.rollbackChanges();
/*      */     
/* 1909 */     this._properties = this._propertiesSavepoint;
/* 1910 */     this._propertiesSavepoint = null;
/* 1911 */     if (this._properties != null) {
/* 1912 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1913 */       while (it.hasNext()) {
/* 1914 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1922 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1925 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1928 */     super.commitTransaction();
/*      */     
/* 1930 */     this._propertiesSavepoint = this._properties;
/* 1931 */     if (this._properties != null) {
/* 1932 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1933 */       while (it.hasNext()) {
/* 1934 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1936 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1940 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1945 */     argStream.defaultReadObject();
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
/*      */   public BigDecimal getMinimumDenominationAmount() {
/* 1963 */     BigDecimal minDenominationAmount = NumberUtils.nonNull(getMinimumDenominationAmountImpl());
/* 1964 */     minDenominationAmount = NumberUtils.greatest(new BigDecimal[] { minDenominationAmount, BigDecimal.ONE });
/* 1965 */     return CurrencyUtils.getUnscaledDecimal(minDenominationAmount.longValue(), getParentTender().getCurrencyId());
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderOptionsModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */