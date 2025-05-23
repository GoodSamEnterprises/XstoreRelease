/*      */ package dtv.xst.dao.doc.impl;
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
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.doc.DocumentDefinitionPropertyId;
/*      */ import dtv.xst.dao.doc.IDocumentDefinition;
/*      */ import dtv.xst.dao.doc.IDocumentDefinitionProperties;
/*      */ import dtv.xst.dao.doc.IDocumentDefinitionProperty;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class DocumentDefinitionModel extends AbstractDataModelWithPropertyImpl<IDocumentDefinitionProperty> implements IDocumentDefinition {
/*      */   private static final long serialVersionUID = -1031194386L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   
/*      */   public String toString() {
/*   33 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private HistoricalList<IDocumentDefinitionProperties> _docDefProperties; private transient HistoricalList<IDocumentDefinitionProperties> _docDefPropertiesSavepoint; private HistoricalList<IDocumentDefinitionProperty> _properties; private transient HistoricalList<IDocumentDefinitionProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   38 */     setDAO((IDataAccessObject)new DocumentDefinitionDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private DocumentDefinitionDAO getDAO_() {
/*   46 */     return (DocumentDefinitionDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSeriesId() {
/*   54 */     return getDAO_().getSeriesId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesId(String argSeriesId) {
/*   62 */     if (setSeriesId_noev(argSeriesId) && 
/*   63 */       this._events != null && 
/*   64 */       postEventsForChanges()) {
/*   65 */       this._events.post(IDocumentDefinition.SET_SERIESID, argSeriesId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSeriesId_noev(String argSeriesId) {
/*   72 */     boolean ev_postable = false;
/*      */     
/*   74 */     if ((getDAO_().getSeriesId() == null && argSeriesId != null) || (
/*   75 */       getDAO_().getSeriesId() != null && !getDAO_().getSeriesId().equals(argSeriesId))) {
/*   76 */       getDAO_().setSeriesId(argSeriesId);
/*   77 */       ev_postable = true;
/*   78 */       if (this._docDefProperties != null) {
/*      */         
/*   80 */         Iterator<DocumentDefinitionPropertiesModel> it = this._docDefProperties.iterator();
/*   81 */         while (it.hasNext())
/*      */         {
/*   83 */           ((DocumentDefinitionPropertiesModel)it.next()).setSeriesId_noev(argSeriesId);
/*      */         }
/*      */       } 
/*   86 */       if (this._properties != null) {
/*      */         
/*   88 */         Iterator<DocumentDefinitionPropertyModel> it = this._properties.iterator();
/*   89 */         while (it.hasNext())
/*      */         {
/*   91 */           ((DocumentDefinitionPropertyModel)it.next()).setSeriesId_noev(argSeriesId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   96 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*  104 */     if (getDAO_().getOrganizationId() != null) {
/*  105 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*  108 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*  117 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  118 */       this._events != null && 
/*  119 */       postEventsForChanges()) {
/*  120 */       this._events.post(IDocumentDefinition.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  127 */     boolean ev_postable = false;
/*      */     
/*  129 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  130 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  131 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  132 */       ev_postable = true;
/*  133 */       if (this._docDefProperties != null) {
/*      */         
/*  135 */         Iterator<DocumentDefinitionPropertiesModel> it = this._docDefProperties.iterator();
/*  136 */         while (it.hasNext())
/*      */         {
/*  138 */           ((DocumentDefinitionPropertiesModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  141 */       if (this._properties != null) {
/*      */         
/*  143 */         Iterator<DocumentDefinitionPropertyModel> it = this._properties.iterator();
/*  144 */         while (it.hasNext())
/*      */         {
/*  146 */           ((DocumentDefinitionPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  151 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDocumentType() {
/*  159 */     return getDAO_().getDocumentType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDocumentType(String argDocumentType) {
/*  167 */     if (setDocumentType_noev(argDocumentType) && 
/*  168 */       this._events != null && 
/*  169 */       postEventsForChanges()) {
/*  170 */       this._events.post(IDocumentDefinition.SET_DOCUMENTTYPE, argDocumentType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDocumentType_noev(String argDocumentType) {
/*  177 */     boolean ev_postable = false;
/*      */     
/*  179 */     if ((getDAO_().getDocumentType() == null && argDocumentType != null) || (
/*  180 */       getDAO_().getDocumentType() != null && !getDAO_().getDocumentType().equals(argDocumentType))) {
/*  181 */       getDAO_().setDocumentType(argDocumentType);
/*  182 */       ev_postable = true;
/*  183 */       if (this._docDefProperties != null) {
/*      */         
/*  185 */         Iterator<DocumentDefinitionPropertiesModel> it = this._docDefProperties.iterator();
/*  186 */         while (it.hasNext())
/*      */         {
/*  188 */           ((DocumentDefinitionPropertiesModel)it.next()).setDocumentType_noev(argDocumentType);
/*      */         }
/*      */       } 
/*  191 */       if (this._properties != null) {
/*      */         
/*  193 */         Iterator<DocumentDefinitionPropertyModel> it = this._properties.iterator();
/*  194 */         while (it.hasNext())
/*      */         {
/*  196 */           ((DocumentDefinitionPropertyModel)it.next()).setDocumentType_noev(argDocumentType);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  201 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  209 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  217 */     if (setCreateDate_noev(argCreateDate) && 
/*  218 */       this._events != null && 
/*  219 */       postEventsForChanges()) {
/*  220 */       this._events.post(IDocumentDefinition.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  227 */     boolean ev_postable = false;
/*      */     
/*  229 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  230 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  231 */       getDAO_().setCreateDate(argCreateDate);
/*  232 */       ev_postable = true;
/*      */     } 
/*      */     
/*  235 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  243 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  251 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  252 */       this._events != null && 
/*  253 */       postEventsForChanges()) {
/*  254 */       this._events.post(IDocumentDefinition.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  261 */     boolean ev_postable = false;
/*      */     
/*  263 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  264 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  265 */       getDAO_().setCreateUserId(argCreateUserId);
/*  266 */       ev_postable = true;
/*      */     } 
/*      */     
/*  269 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  277 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  285 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  286 */       this._events != null && 
/*  287 */       postEventsForChanges()) {
/*  288 */       this._events.post(IDocumentDefinition.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  295 */     boolean ev_postable = false;
/*      */     
/*  297 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  298 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  299 */       getDAO_().setUpdateDate(argUpdateDate);
/*  300 */       ev_postable = true;
/*      */     } 
/*      */     
/*  303 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  311 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  319 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  320 */       this._events != null && 
/*  321 */       postEventsForChanges()) {
/*  322 */       this._events.post(IDocumentDefinition.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  329 */     boolean ev_postable = false;
/*      */     
/*  331 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  332 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  333 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  334 */       ev_postable = true;
/*      */     } 
/*      */     
/*  337 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrgCode() {
/*  345 */     return getDAO_().getOrgCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrgCode(String argOrgCode) {
/*  353 */     if (setOrgCode_noev(argOrgCode) && 
/*  354 */       this._events != null && 
/*  355 */       postEventsForChanges()) {
/*  356 */       this._events.post(IDocumentDefinition.SET_ORGCODE, argOrgCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrgCode_noev(String argOrgCode) {
/*  363 */     boolean ev_postable = false;
/*      */     
/*  365 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/*  366 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/*  367 */       getDAO_().setOrgCode(argOrgCode);
/*  368 */       ev_postable = true;
/*      */     } 
/*      */     
/*  371 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrgValue() {
/*  379 */     return getDAO_().getOrgValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrgValue(String argOrgValue) {
/*  387 */     if (setOrgValue_noev(argOrgValue) && 
/*  388 */       this._events != null && 
/*  389 */       postEventsForChanges()) {
/*  390 */       this._events.post(IDocumentDefinition.SET_ORGVALUE, argOrgValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrgValue_noev(String argOrgValue) {
/*  397 */     boolean ev_postable = false;
/*      */     
/*  399 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/*  400 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/*  401 */       getDAO_().setOrgValue(argOrgValue);
/*  402 */       ev_postable = true;
/*      */     } 
/*      */     
/*  405 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getStartIssueDate() {
/*  413 */     return getDAO_().getStartIssueDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStartIssueDate(Date argStartIssueDate) {
/*  421 */     if (setStartIssueDate_noev(argStartIssueDate) && 
/*  422 */       this._events != null && 
/*  423 */       postEventsForChanges()) {
/*  424 */       this._events.post(IDocumentDefinition.SET_STARTISSUEDATE, argStartIssueDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStartIssueDate_noev(Date argStartIssueDate) {
/*  431 */     boolean ev_postable = false;
/*      */     
/*  433 */     if ((getDAO_().getStartIssueDate() == null && argStartIssueDate != null) || (
/*  434 */       getDAO_().getStartIssueDate() != null && !getDAO_().getStartIssueDate().equals(argStartIssueDate))) {
/*  435 */       getDAO_().setStartIssueDate(argStartIssueDate);
/*  436 */       ev_postable = true;
/*      */     } 
/*      */     
/*  439 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getEndIssueDate() {
/*  447 */     return getDAO_().getEndIssueDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEndIssueDate(Date argEndIssueDate) {
/*  455 */     if (setEndIssueDate_noev(argEndIssueDate) && 
/*  456 */       this._events != null && 
/*  457 */       postEventsForChanges()) {
/*  458 */       this._events.post(IDocumentDefinition.SET_ENDISSUEDATE, argEndIssueDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEndIssueDate_noev(Date argEndIssueDate) {
/*  465 */     boolean ev_postable = false;
/*      */     
/*  467 */     if ((getDAO_().getEndIssueDate() == null && argEndIssueDate != null) || (
/*  468 */       getDAO_().getEndIssueDate() != null && !getDAO_().getEndIssueDate().equals(argEndIssueDate))) {
/*  469 */       getDAO_().setEndIssueDate(argEndIssueDate);
/*  470 */       ev_postable = true;
/*      */     } 
/*      */     
/*  473 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getStartRedeemDate() {
/*  481 */     return getDAO_().getStartRedeemDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStartRedeemDate(Date argStartRedeemDate) {
/*  489 */     if (setStartRedeemDate_noev(argStartRedeemDate) && 
/*  490 */       this._events != null && 
/*  491 */       postEventsForChanges()) {
/*  492 */       this._events.post(IDocumentDefinition.SET_STARTREDEEMDATE, argStartRedeemDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStartRedeemDate_noev(Date argStartRedeemDate) {
/*  499 */     boolean ev_postable = false;
/*      */     
/*  501 */     if ((getDAO_().getStartRedeemDate() == null && argStartRedeemDate != null) || (
/*  502 */       getDAO_().getStartRedeemDate() != null && !getDAO_().getStartRedeemDate().equals(argStartRedeemDate))) {
/*  503 */       getDAO_().setStartRedeemDate(argStartRedeemDate);
/*  504 */       ev_postable = true;
/*      */     } 
/*      */     
/*  507 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getEndRedeemDate() {
/*  515 */     return getDAO_().getEndRedeemDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEndRedeemDate(Date argEndRedeemDate) {
/*  523 */     if (setEndRedeemDate_noev(argEndRedeemDate) && 
/*  524 */       this._events != null && 
/*  525 */       postEventsForChanges()) {
/*  526 */       this._events.post(IDocumentDefinition.SET_ENDREDEEMDATE, argEndRedeemDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEndRedeemDate_noev(Date argEndRedeemDate) {
/*  533 */     boolean ev_postable = false;
/*      */     
/*  535 */     if ((getDAO_().getEndRedeemDate() == null && argEndRedeemDate != null) || (
/*  536 */       getDAO_().getEndRedeemDate() != null && !getDAO_().getEndRedeemDate().equals(argEndRedeemDate))) {
/*  537 */       getDAO_().setEndRedeemDate(argEndRedeemDate);
/*  538 */       ev_postable = true;
/*      */     } 
/*      */     
/*  541 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getVendorId() {
/*  549 */     return getDAO_().getVendorId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVendorId(String argVendorId) {
/*  557 */     if (setVendorId_noev(argVendorId) && 
/*  558 */       this._events != null && 
/*  559 */       postEventsForChanges()) {
/*  560 */       this._events.post(IDocumentDefinition.SET_VENDORID, argVendorId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVendorId_noev(String argVendorId) {
/*  567 */     boolean ev_postable = false;
/*      */     
/*  569 */     if ((getDAO_().getVendorId() == null && argVendorId != null) || (
/*  570 */       getDAO_().getVendorId() != null && !getDAO_().getVendorId().equals(argVendorId))) {
/*  571 */       getDAO_().setVendorId(argVendorId);
/*  572 */       ev_postable = true;
/*      */     } 
/*      */     
/*  575 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDescription() {
/*  583 */     return getDAO_().getDescription();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDescription(String argDescription) {
/*  591 */     if (setDescription_noev(argDescription) && 
/*  592 */       this._events != null && 
/*  593 */       postEventsForChanges()) {
/*  594 */       this._events.post(IDocumentDefinition.SET_DESCRIPTION, argDescription);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDescription_noev(String argDescription) {
/*  601 */     boolean ev_postable = false;
/*      */     
/*  603 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/*  604 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/*  605 */       getDAO_().setDescription(argDescription);
/*  606 */       ev_postable = true;
/*      */     } 
/*      */     
/*  609 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getReceiptType() {
/*  617 */     return getDAO_().getReceiptType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReceiptType(String argReceiptType) {
/*  625 */     if (setReceiptType_noev(argReceiptType) && 
/*  626 */       this._events != null && 
/*  627 */       postEventsForChanges()) {
/*  628 */       this._events.post(IDocumentDefinition.SET_RECEIPTTYPE, argReceiptType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setReceiptType_noev(String argReceiptType) {
/*  635 */     boolean ev_postable = false;
/*      */     
/*  637 */     if ((getDAO_().getReceiptType() == null && argReceiptType != null) || (
/*  638 */       getDAO_().getReceiptType() != null && !getDAO_().getReceiptType().equals(argReceiptType))) {
/*  639 */       getDAO_().setReceiptType(argReceiptType);
/*  640 */       ev_postable = true;
/*      */     } 
/*      */     
/*  643 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSegmentType() {
/*  651 */     return getDAO_().getSegmentType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSegmentType(String argSegmentType) {
/*  659 */     if (setSegmentType_noev(argSegmentType) && 
/*  660 */       this._events != null && 
/*  661 */       postEventsForChanges()) {
/*  662 */       this._events.post(IDocumentDefinition.SET_SEGMENTTYPE, argSegmentType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSegmentType_noev(String argSegmentType) {
/*  669 */     boolean ev_postable = false;
/*      */     
/*  671 */     if ((getDAO_().getSegmentType() == null && argSegmentType != null) || (
/*  672 */       getDAO_().getSegmentType() != null && !getDAO_().getSegmentType().equals(argSegmentType))) {
/*  673 */       getDAO_().setSegmentType(argSegmentType);
/*  674 */       ev_postable = true;
/*      */     } 
/*      */     
/*  677 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTextCodeValue() {
/*  685 */     return getDAO_().getTextCodeValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTextCodeValue(String argTextCodeValue) {
/*  693 */     if (setTextCodeValue_noev(argTextCodeValue) && 
/*  694 */       this._events != null && 
/*  695 */       postEventsForChanges()) {
/*  696 */       this._events.post(IDocumentDefinition.SET_TEXTCODEVALUE, argTextCodeValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTextCodeValue_noev(String argTextCodeValue) {
/*  703 */     boolean ev_postable = false;
/*      */     
/*  705 */     if ((getDAO_().getTextCodeValue() == null && argTextCodeValue != null) || (
/*  706 */       getDAO_().getTextCodeValue() != null && !getDAO_().getTextCodeValue().equals(argTextCodeValue))) {
/*  707 */       getDAO_().setTextCodeValue(argTextCodeValue);
/*  708 */       ev_postable = true;
/*      */     } 
/*      */     
/*  711 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFileName() {
/*  719 */     return getDAO_().getFileName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFileName(String argFileName) {
/*  727 */     if (setFileName_noev(argFileName) && 
/*  728 */       this._events != null && 
/*  729 */       postEventsForChanges()) {
/*  730 */       this._events.post(IDocumentDefinition.SET_FILENAME, argFileName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFileName_noev(String argFileName) {
/*  737 */     boolean ev_postable = false;
/*      */     
/*  739 */     if ((getDAO_().getFileName() == null && argFileName != null) || (
/*  740 */       getDAO_().getFileName() != null && !getDAO_().getFileName().equals(argFileName))) {
/*  741 */       getDAO_().setFileName(argFileName);
/*  742 */       ev_postable = true;
/*      */     } 
/*      */     
/*  745 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IDocumentDefinitionProperty newProperty(String argPropertyName) {
/*  749 */     DocumentDefinitionPropertyId id = new DocumentDefinitionPropertyId();
/*      */     
/*  751 */     id.setSeriesId(getSeriesId());
/*  752 */     id.setDocumentType(getDocumentType());
/*  753 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  755 */     IDocumentDefinitionProperty prop = (IDocumentDefinitionProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDocumentDefinitionProperty.class);
/*  756 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "DocDefProperties")
/*      */   public List<IDocumentDefinitionProperties> getDocDefProperties() {
/*  768 */     if (this._docDefProperties == null) {
/*  769 */       this._docDefProperties = new HistoricalList(null);
/*      */     }
/*  771 */     return (List<IDocumentDefinitionProperties>)this._docDefProperties;
/*      */   }
/*      */   
/*      */   public void setDocDefProperties(List<IDocumentDefinitionProperties> argDocDefProperties) {
/*  775 */     if (this._docDefProperties == null) {
/*  776 */       this._docDefProperties = new HistoricalList(argDocDefProperties);
/*      */     } else {
/*  778 */       this._docDefProperties.setCurrentList(argDocDefProperties);
/*      */     } 
/*      */     
/*  781 */     for (IDocumentDefinitionProperties child : this._docDefProperties) {
/*  782 */       child.setParentDocumentDefinition(this);
/*      */     }
/*      */     
/*  785 */     for (IDocumentDefinitionProperties child : this._docDefProperties) {
/*  786 */       DocumentDefinitionPropertiesModel model = (DocumentDefinitionPropertiesModel)child;
/*  787 */       model.setSeriesId_noev(getSeriesId());
/*  788 */       model.setOrganizationId_noev(getOrganizationId());
/*  789 */       model.setDocumentType_noev(getDocumentType());
/*  790 */       if (child instanceof IDataModelImpl) {
/*  791 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  792 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  793 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  794 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  797 */       if (postEventsForChanges()) {
/*  798 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addDocumentDefinitionProperties(IDocumentDefinitionProperties argDocumentDefinitionProperties) {
/*  805 */     argDocumentDefinitionProperties.setParentDocumentDefinition(this);
/*  806 */     if (this._docDefProperties == null) {
/*  807 */       this._docDefProperties = new HistoricalList(null);
/*      */     }
/*  809 */     argDocumentDefinitionProperties.setSeriesId(getSeriesId());
/*  810 */     argDocumentDefinitionProperties.setOrganizationId(getOrganizationId());
/*  811 */     argDocumentDefinitionProperties.setDocumentType(getDocumentType());
/*  812 */     if (argDocumentDefinitionProperties instanceof IDataModelImpl) {
/*  813 */       IDataAccessObject childDao = ((IDataModelImpl)argDocumentDefinitionProperties).getDAO();
/*  814 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  815 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  816 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  821 */     if (postEventsForChanges()) {
/*  822 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentDefinitionProperties));
/*      */     }
/*      */     
/*  825 */     this._docDefProperties.add(argDocumentDefinitionProperties);
/*  826 */     if (postEventsForChanges()) {
/*  827 */       this._events.post(IDocumentDefinition.ADD_DOCDEFPROPERTIES, argDocumentDefinitionProperties);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeDocumentDefinitionProperties(IDocumentDefinitionProperties argDocumentDefinitionProperties) {
/*  832 */     if (this._docDefProperties != null) {
/*      */       
/*  834 */       if (postEventsForChanges()) {
/*  835 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentDefinitionProperties));
/*      */       }
/*  837 */       this._docDefProperties.remove(argDocumentDefinitionProperties);
/*      */       
/*  839 */       argDocumentDefinitionProperties.setParentDocumentDefinition(null);
/*  840 */       if (postEventsForChanges()) {
/*  841 */         this._events.post(IDocumentDefinition.REMOVE_DOCDEFPROPERTIES, argDocumentDefinitionProperties);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IDocumentDefinitionProperty> getProperties() {
/*  848 */     if (this._properties == null) {
/*  849 */       this._properties = new HistoricalList(null);
/*      */     }
/*  851 */     return (List<IDocumentDefinitionProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IDocumentDefinitionProperty> argProperties) {
/*  855 */     if (this._properties == null) {
/*  856 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  858 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  861 */     for (IDocumentDefinitionProperty child : this._properties) {
/*  862 */       DocumentDefinitionPropertyModel model = (DocumentDefinitionPropertyModel)child;
/*  863 */       model.setSeriesId_noev(getSeriesId());
/*  864 */       model.setOrganizationId_noev(getOrganizationId());
/*  865 */       model.setDocumentType_noev(getDocumentType());
/*  866 */       if (child instanceof IDataModelImpl) {
/*  867 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  868 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  869 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  870 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  873 */       if (postEventsForChanges()) {
/*  874 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addDocumentDefinitionProperty(IDocumentDefinitionProperty argDocumentDefinitionProperty) {
/*  880 */     if (this._properties == null) {
/*  881 */       this._properties = new HistoricalList(null);
/*      */     }
/*  883 */     argDocumentDefinitionProperty.setSeriesId(getSeriesId());
/*  884 */     argDocumentDefinitionProperty.setOrganizationId(getOrganizationId());
/*  885 */     argDocumentDefinitionProperty.setDocumentType(getDocumentType());
/*  886 */     if (argDocumentDefinitionProperty instanceof IDataModelImpl) {
/*  887 */       IDataAccessObject childDao = ((IDataModelImpl)argDocumentDefinitionProperty).getDAO();
/*  888 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  889 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  890 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  895 */     if (postEventsForChanges()) {
/*  896 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentDefinitionProperty));
/*      */     }
/*      */     
/*  899 */     this._properties.add(argDocumentDefinitionProperty);
/*  900 */     if (postEventsForChanges()) {
/*  901 */       this._events.post(IDocumentDefinition.ADD_PROPERTIES, argDocumentDefinitionProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeDocumentDefinitionProperty(IDocumentDefinitionProperty argDocumentDefinitionProperty) {
/*  906 */     if (this._properties != null) {
/*      */       
/*  908 */       if (postEventsForChanges()) {
/*  909 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentDefinitionProperty));
/*      */       }
/*  911 */       this._properties.remove(argDocumentDefinitionProperty);
/*  912 */       if (postEventsForChanges()) {
/*  913 */         this._events.post(IDocumentDefinition.REMOVE_PROPERTIES, argDocumentDefinitionProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  920 */     if ("DocDefProperties".equals(argFieldId)) {
/*  921 */       return getDocDefProperties();
/*      */     }
/*  923 */     if ("Properties".equals(argFieldId)) {
/*  924 */       return getProperties();
/*      */     }
/*  926 */     if ("DocumentDefinitionExtension".equals(argFieldId)) {
/*  927 */       return this._myExtension;
/*      */     }
/*      */     
/*  930 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  936 */     if ("DocDefProperties".equals(argFieldId)) {
/*  937 */       setDocDefProperties(changeToList(argValue, IDocumentDefinitionProperties.class));
/*      */     }
/*  939 */     else if ("Properties".equals(argFieldId)) {
/*  940 */       setProperties(changeToList(argValue, IDocumentDefinitionProperty.class));
/*      */     }
/*  942 */     else if ("DocumentDefinitionExtension".equals(argFieldId)) {
/*  943 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  946 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  952 */     this._persistenceDefaults = argPD;
/*  953 */     this._daoImpl.setPersistenceDefaults(argPD);
/*  954 */     this._eventManager = argEM;
/*  955 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/*  956 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*  957 */     if (this._docDefProperties != null) {
/*  958 */       for (IDocumentDefinitionProperties relationship : this._docDefProperties) {
/*  959 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*  962 */     if (this._properties != null) {
/*  963 */       for (IDocumentDefinitionProperty relationship : this._properties) {
/*  964 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getDocumentDefinitionExt() {
/*  970 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setDocumentDefinitionExt(IDataModel argExt) {
/*  974 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  979 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  983 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  986 */     super.startTransaction();
/*      */     
/*  988 */     this._docDefPropertiesSavepoint = this._docDefProperties;
/*  989 */     if (this._docDefProperties != null) {
/*  990 */       this._docDefPropertiesSavepoint = new HistoricalList((List)this._docDefProperties);
/*  991 */       Iterator<IDataModel> it = this._docDefProperties.iterator();
/*  992 */       while (it.hasNext()) {
/*  993 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/*  997 */     this._propertiesSavepoint = this._properties;
/*  998 */     if (this._properties != null) {
/*  999 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1000 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1001 */       while (it.hasNext()) {
/* 1002 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1007 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1012 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1015 */     super.rollbackChanges();
/*      */     
/* 1017 */     this._docDefProperties = this._docDefPropertiesSavepoint;
/* 1018 */     this._docDefPropertiesSavepoint = null;
/* 1019 */     if (this._docDefProperties != null) {
/* 1020 */       Iterator<IDataModel> it = this._docDefProperties.iterator();
/* 1021 */       while (it.hasNext()) {
/* 1022 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1026 */     this._properties = this._propertiesSavepoint;
/* 1027 */     this._propertiesSavepoint = null;
/* 1028 */     if (this._properties != null) {
/* 1029 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1030 */       while (it.hasNext()) {
/* 1031 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1039 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1042 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1045 */     super.commitTransaction();
/*      */     
/* 1047 */     this._docDefPropertiesSavepoint = this._docDefProperties;
/* 1048 */     if (this._docDefProperties != null) {
/* 1049 */       Iterator<IDataModel> it = this._docDefProperties.iterator();
/* 1050 */       while (it.hasNext()) {
/* 1051 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1053 */       this._docDefProperties = new HistoricalList((List)this._docDefProperties);
/*      */     } 
/*      */     
/* 1056 */     this._propertiesSavepoint = this._properties;
/* 1057 */     if (this._properties != null) {
/* 1058 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1059 */       while (it.hasNext()) {
/* 1060 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1062 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1066 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1071 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\impl\DocumentDefinitionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */