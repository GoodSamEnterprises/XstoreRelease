/*      */ package dtv.xst.dao._test.impl;
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
/*      */ import dtv.xst.dao._test.IXunitResult;
/*      */ import dtv.xst.dao._test.IXunitResultItem;
/*      */ import dtv.xst.dao._test.IXunitResultProperty;
/*      */ import dtv.xst.dao._test.XunitResultPropertyId;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class XunitResultModel extends AbstractDataModelWithPropertyImpl<IXunitResultProperty> implements IXunitResult {
/*      */   private static final long serialVersionUID = -1359557351L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   
/*      */   public String toString() {
/*   33 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private HistoricalList<IXunitResultItem> _resultItems; private transient HistoricalList<IXunitResultItem> _resultItemsSavepoint; private HistoricalList<IXunitResultProperty> _properties; private transient HistoricalList<IXunitResultProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   38 */     setDAO((IDataAccessObject)new XunitResultDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private XunitResultDAO getDAO_() {
/*   46 */     return (XunitResultDAO)this._daoImpl;
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
/*   70 */       this._events.post(IXunitResult.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*   83 */       if (this._resultItems != null) {
/*      */         
/*   85 */         Iterator<XunitResultItemModel> it = this._resultItems.iterator();
/*   86 */         while (it.hasNext())
/*      */         {
/*   88 */           ((XunitResultItemModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   91 */       if (this._properties != null) {
/*      */         
/*   93 */         Iterator<XunitResultPropertyModel> it = this._properties.iterator();
/*   94 */         while (it.hasNext())
/*      */         {
/*   96 */           ((XunitResultPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  101 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getHostname() {
/*  109 */     return getDAO_().getHostname();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHostname(String argHostname) {
/*  117 */     if (setHostname_noev(argHostname) && 
/*  118 */       this._events != null && 
/*  119 */       postEventsForChanges()) {
/*  120 */       this._events.post(IXunitResult.SET_HOSTNAME, argHostname);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setHostname_noev(String argHostname) {
/*  127 */     boolean ev_postable = false;
/*      */     
/*  129 */     if ((getDAO_().getHostname() == null && argHostname != null) || (
/*  130 */       getDAO_().getHostname() != null && !getDAO_().getHostname().equals(argHostname))) {
/*  131 */       getDAO_().setHostname(argHostname);
/*  132 */       ev_postable = true;
/*  133 */       if (this._resultItems != null) {
/*      */         
/*  135 */         Iterator<XunitResultItemModel> it = this._resultItems.iterator();
/*  136 */         while (it.hasNext())
/*      */         {
/*  138 */           ((XunitResultItemModel)it.next()).setHostname_noev(argHostname);
/*      */         }
/*      */       } 
/*  141 */       if (this._properties != null) {
/*      */         
/*  143 */         Iterator<XunitResultPropertyModel> it = this._properties.iterator();
/*  144 */         while (it.hasNext())
/*      */         {
/*  146 */           ((XunitResultPropertyModel)it.next()).setHostname_noev(argHostname);
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
/*      */   public long getResultTimestamp() {
/*  159 */     if (getDAO_().getResultTimestamp() != null) {
/*  160 */       return getDAO_().getResultTimestamp().longValue();
/*      */     }
/*      */     
/*  163 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setResultTimestamp(long argResultTimestamp) {
/*  172 */     if (setResultTimestamp_noev(argResultTimestamp) && 
/*  173 */       this._events != null && 
/*  174 */       postEventsForChanges()) {
/*  175 */       this._events.post(IXunitResult.SET_RESULTTIMESTAMP, Long.valueOf(argResultTimestamp));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setResultTimestamp_noev(long argResultTimestamp) {
/*  182 */     boolean ev_postable = false;
/*      */     
/*  184 */     if ((getDAO_().getResultTimestamp() == null && Long.valueOf(argResultTimestamp) != null) || (
/*  185 */       getDAO_().getResultTimestamp() != null && !getDAO_().getResultTimestamp().equals(Long.valueOf(argResultTimestamp)))) {
/*  186 */       getDAO_().setResultTimestamp(Long.valueOf(argResultTimestamp));
/*  187 */       ev_postable = true;
/*  188 */       if (this._resultItems != null) {
/*      */         
/*  190 */         Iterator<XunitResultItemModel> it = this._resultItems.iterator();
/*  191 */         while (it.hasNext())
/*      */         {
/*  193 */           ((XunitResultItemModel)it.next()).setResultTimestamp_noev(argResultTimestamp);
/*      */         }
/*      */       } 
/*  196 */       if (this._properties != null) {
/*      */         
/*  198 */         Iterator<XunitResultPropertyModel> it = this._properties.iterator();
/*  199 */         while (it.hasNext())
/*      */         {
/*  201 */           ((XunitResultPropertyModel)it.next()).setResultTimestamp_noev(argResultTimestamp);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  206 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  214 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  222 */     if (setCreateDate_noev(argCreateDate) && 
/*  223 */       this._events != null && 
/*  224 */       postEventsForChanges()) {
/*  225 */       this._events.post(IXunitResult.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  232 */     boolean ev_postable = false;
/*      */     
/*  234 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  235 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  236 */       getDAO_().setCreateDate(argCreateDate);
/*  237 */       ev_postable = true;
/*      */     } 
/*      */     
/*  240 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  248 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  256 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  257 */       this._events != null && 
/*  258 */       postEventsForChanges()) {
/*  259 */       this._events.post(IXunitResult.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  266 */     boolean ev_postable = false;
/*      */     
/*  268 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  269 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  270 */       getDAO_().setCreateUserId(argCreateUserId);
/*  271 */       ev_postable = true;
/*      */     } 
/*      */     
/*  274 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  282 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  290 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  291 */       this._events != null && 
/*  292 */       postEventsForChanges()) {
/*  293 */       this._events.post(IXunitResult.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  300 */     boolean ev_postable = false;
/*      */     
/*  302 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  303 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  304 */       getDAO_().setUpdateDate(argUpdateDate);
/*  305 */       ev_postable = true;
/*      */     } 
/*      */     
/*  308 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  316 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  324 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  325 */       this._events != null && 
/*  326 */       postEventsForChanges()) {
/*  327 */       this._events.post(IXunitResult.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  334 */     boolean ev_postable = false;
/*      */     
/*  336 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  337 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  338 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  339 */       ev_postable = true;
/*      */     } 
/*      */     
/*  342 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getIpAddress() {
/*  350 */     return getDAO_().getIpAddress();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIpAddress(String argIpAddress) {
/*  358 */     if (setIpAddress_noev(argIpAddress) && 
/*  359 */       this._events != null && 
/*  360 */       postEventsForChanges()) {
/*  361 */       this._events.post(IXunitResult.SET_IPADDRESS, argIpAddress);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setIpAddress_noev(String argIpAddress) {
/*  368 */     boolean ev_postable = false;
/*      */     
/*  370 */     if ((getDAO_().getIpAddress() == null && argIpAddress != null) || (
/*  371 */       getDAO_().getIpAddress() != null && !getDAO_().getIpAddress().equals(argIpAddress))) {
/*  372 */       getDAO_().setIpAddress(argIpAddress);
/*  373 */       ev_postable = true;
/*      */     } 
/*      */     
/*  376 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  384 */     if (getDAO_().getRetailLocationId() != null) {
/*  385 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  388 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  397 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  398 */       this._events != null && 
/*  399 */       postEventsForChanges()) {
/*  400 */       this._events.post(IXunitResult.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  407 */     boolean ev_postable = false;
/*      */     
/*  409 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  410 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  411 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  412 */       ev_postable = true;
/*      */     } 
/*      */     
/*  415 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  423 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  431 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  432 */       this._events != null && 
/*  433 */       postEventsForChanges()) {
/*  434 */       this._events.post(IXunitResult.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  441 */     boolean ev_postable = false;
/*      */     
/*  443 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  444 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  445 */       getDAO_().setBusinessDate(argBusinessDate);
/*  446 */       ev_postable = true;
/*      */     } 
/*      */     
/*  449 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  457 */     if (getDAO_().getWorkstationId() != null) {
/*  458 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  461 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  470 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  471 */       this._events != null && 
/*  472 */       postEventsForChanges()) {
/*  473 */       this._events.post(IXunitResult.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  480 */     boolean ev_postable = false;
/*      */     
/*  482 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  483 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  484 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  485 */       ev_postable = true;
/*      */     } 
/*      */     
/*  488 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getXstoreVersion() {
/*  496 */     return getDAO_().getXstoreVersion();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setXstoreVersion(String argXstoreVersion) {
/*  504 */     if (setXstoreVersion_noev(argXstoreVersion) && 
/*  505 */       this._events != null && 
/*  506 */       postEventsForChanges()) {
/*  507 */       this._events.post(IXunitResult.SET_XSTOREVERSION, argXstoreVersion);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setXstoreVersion_noev(String argXstoreVersion) {
/*  514 */     boolean ev_postable = false;
/*      */     
/*  516 */     if ((getDAO_().getXstoreVersion() == null && argXstoreVersion != null) || (
/*  517 */       getDAO_().getXstoreVersion() != null && !getDAO_().getXstoreVersion().equals(argXstoreVersion))) {
/*  518 */       getDAO_().setXstoreVersion(argXstoreVersion);
/*  519 */       ev_postable = true;
/*      */     } 
/*      */     
/*  522 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStatus() {
/*  530 */     return getDAO_().getStatus();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStatus(String argStatus) {
/*  538 */     if (setStatus_noev(argStatus) && 
/*  539 */       this._events != null && 
/*  540 */       postEventsForChanges()) {
/*  541 */       this._events.post(IXunitResult.SET_STATUS, argStatus);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStatus_noev(String argStatus) {
/*  548 */     boolean ev_postable = false;
/*      */     
/*  550 */     if ((getDAO_().getStatus() == null && argStatus != null) || (
/*  551 */       getDAO_().getStatus() != null && !getDAO_().getStatus().equals(argStatus))) {
/*  552 */       getDAO_().setStatus(argStatus);
/*  553 */       ev_postable = true;
/*      */     } 
/*      */     
/*  556 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBeginDatetimestamp() {
/*  564 */     return getDAO_().getBeginDatetimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBeginDatetimestamp(Date argBeginDatetimestamp) {
/*  572 */     if (setBeginDatetimestamp_noev(argBeginDatetimestamp) && 
/*  573 */       this._events != null && 
/*  574 */       postEventsForChanges()) {
/*  575 */       this._events.post(IXunitResult.SET_BEGINDATETIMESTAMP, argBeginDatetimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBeginDatetimestamp_noev(Date argBeginDatetimestamp) {
/*  582 */     boolean ev_postable = false;
/*      */     
/*  584 */     if ((getDAO_().getBeginDatetimestamp() == null && argBeginDatetimestamp != null) || (
/*  585 */       getDAO_().getBeginDatetimestamp() != null && !getDAO_().getBeginDatetimestamp().equals(argBeginDatetimestamp))) {
/*  586 */       getDAO_().setBeginDatetimestamp(argBeginDatetimestamp);
/*  587 */       ev_postable = true;
/*      */     } 
/*      */     
/*  590 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getEndDatetimestamp() {
/*  598 */     return getDAO_().getEndDatetimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEndDatetimestamp(Date argEndDatetimestamp) {
/*  606 */     if (setEndDatetimestamp_noev(argEndDatetimestamp) && 
/*  607 */       this._events != null && 
/*  608 */       postEventsForChanges()) {
/*  609 */       this._events.post(IXunitResult.SET_ENDDATETIMESTAMP, argEndDatetimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEndDatetimestamp_noev(Date argEndDatetimestamp) {
/*  616 */     boolean ev_postable = false;
/*      */     
/*  618 */     if ((getDAO_().getEndDatetimestamp() == null && argEndDatetimestamp != null) || (
/*  619 */       getDAO_().getEndDatetimestamp() != null && !getDAO_().getEndDatetimestamp().equals(argEndDatetimestamp))) {
/*  620 */       getDAO_().setEndDatetimestamp(argEndDatetimestamp);
/*  621 */       ev_postable = true;
/*      */     } 
/*      */     
/*  624 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTotalCount() {
/*  632 */     if (getDAO_().getTotalCount() != null) {
/*  633 */       return getDAO_().getTotalCount().longValue();
/*      */     }
/*      */     
/*  636 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTotalCount(long argTotalCount) {
/*  645 */     if (setTotalCount_noev(argTotalCount) && 
/*  646 */       this._events != null && 
/*  647 */       postEventsForChanges()) {
/*  648 */       this._events.post(IXunitResult.SET_TOTALCOUNT, Long.valueOf(argTotalCount));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTotalCount_noev(long argTotalCount) {
/*  655 */     boolean ev_postable = false;
/*      */     
/*  657 */     if ((getDAO_().getTotalCount() == null && Long.valueOf(argTotalCount) != null) || (
/*  658 */       getDAO_().getTotalCount() != null && !getDAO_().getTotalCount().equals(Long.valueOf(argTotalCount)))) {
/*  659 */       getDAO_().setTotalCount(Long.valueOf(argTotalCount));
/*  660 */       ev_postable = true;
/*      */     } 
/*      */     
/*  663 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getCompletedCount() {
/*  671 */     if (getDAO_().getCompletedCount() != null) {
/*  672 */       return getDAO_().getCompletedCount().longValue();
/*      */     }
/*      */     
/*  675 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCompletedCount(long argCompletedCount) {
/*  684 */     if (setCompletedCount_noev(argCompletedCount) && 
/*  685 */       this._events != null && 
/*  686 */       postEventsForChanges()) {
/*  687 */       this._events.post(IXunitResult.SET_COMPLETEDCOUNT, Long.valueOf(argCompletedCount));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCompletedCount_noev(long argCompletedCount) {
/*  694 */     boolean ev_postable = false;
/*      */     
/*  696 */     if ((getDAO_().getCompletedCount() == null && Long.valueOf(argCompletedCount) != null) || (
/*  697 */       getDAO_().getCompletedCount() != null && !getDAO_().getCompletedCount().equals(Long.valueOf(argCompletedCount)))) {
/*  698 */       getDAO_().setCompletedCount(Long.valueOf(argCompletedCount));
/*  699 */       ev_postable = true;
/*      */     } 
/*      */     
/*  702 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getFailedCount() {
/*  710 */     if (getDAO_().getFailedCount() != null) {
/*  711 */       return getDAO_().getFailedCount().longValue();
/*      */     }
/*      */     
/*  714 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFailedCount(long argFailedCount) {
/*  723 */     if (setFailedCount_noev(argFailedCount) && 
/*  724 */       this._events != null && 
/*  725 */       postEventsForChanges()) {
/*  726 */       this._events.post(IXunitResult.SET_FAILEDCOUNT, Long.valueOf(argFailedCount));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFailedCount_noev(long argFailedCount) {
/*  733 */     boolean ev_postable = false;
/*      */     
/*  735 */     if ((getDAO_().getFailedCount() == null && Long.valueOf(argFailedCount) != null) || (
/*  736 */       getDAO_().getFailedCount() != null && !getDAO_().getFailedCount().equals(Long.valueOf(argFailedCount)))) {
/*  737 */       getDAO_().setFailedCount(Long.valueOf(argFailedCount));
/*  738 */       ev_postable = true;
/*      */     } 
/*      */     
/*  741 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IXunitResultProperty newProperty(String argPropertyName) {
/*  745 */     XunitResultPropertyId id = new XunitResultPropertyId();
/*      */     
/*  747 */     id.setHostname(getHostname());
/*  748 */     id.setResultTimestamp(Long.valueOf(getResultTimestamp()));
/*  749 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  751 */     IXunitResultProperty prop = (IXunitResultProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IXunitResultProperty.class);
/*  752 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "ResultItems")
/*      */   public List<IXunitResultItem> getResultItems() {
/*  764 */     if (this._resultItems == null) {
/*  765 */       this._resultItems = new HistoricalList(null);
/*      */     }
/*  767 */     return (List<IXunitResultItem>)this._resultItems;
/*      */   }
/*      */   
/*      */   public void setResultItems(List<IXunitResultItem> argResultItems) {
/*  771 */     if (this._resultItems == null) {
/*  772 */       this._resultItems = new HistoricalList(argResultItems);
/*      */     } else {
/*  774 */       this._resultItems.setCurrentList(argResultItems);
/*      */     } 
/*      */     
/*  777 */     for (IXunitResultItem child : this._resultItems) {
/*  778 */       child.setParentResult(this);
/*      */     }
/*      */     
/*  781 */     for (IXunitResultItem child : this._resultItems) {
/*  782 */       XunitResultItemModel model = (XunitResultItemModel)child;
/*  783 */       model.setOrganizationId_noev(getOrganizationId());
/*  784 */       model.setHostname_noev(getHostname());
/*  785 */       model.setResultTimestamp_noev(getResultTimestamp());
/*  786 */       if (child instanceof IDataModelImpl) {
/*  787 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  788 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  789 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  790 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  793 */       if (postEventsForChanges()) {
/*  794 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void addXunitResultItemImpl(IXunitResultItem argXunitResultItem) {
/*  801 */     argXunitResultItem.setParentResult(this);
/*  802 */     if (this._resultItems == null) {
/*  803 */       this._resultItems = new HistoricalList(null);
/*      */     }
/*  805 */     argXunitResultItem.setOrganizationId(getOrganizationId());
/*  806 */     argXunitResultItem.setHostname(getHostname());
/*  807 */     argXunitResultItem.setResultTimestamp(getResultTimestamp());
/*  808 */     if (argXunitResultItem instanceof IDataModelImpl) {
/*  809 */       IDataAccessObject childDao = ((IDataModelImpl)argXunitResultItem).getDAO();
/*  810 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  811 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  812 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  817 */     if (postEventsForChanges()) {
/*  818 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argXunitResultItem));
/*      */     }
/*      */     
/*  821 */     this._resultItems.add(argXunitResultItem);
/*  822 */     if (postEventsForChanges()) {
/*  823 */       this._events.post(IXunitResult.ADD_RESULTITEMS, argXunitResultItem);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeXunitResultItem(IXunitResultItem argXunitResultItem) {
/*  828 */     if (this._resultItems != null) {
/*      */       
/*  830 */       if (postEventsForChanges()) {
/*  831 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argXunitResultItem));
/*      */       }
/*  833 */       this._resultItems.remove(argXunitResultItem);
/*      */       
/*  835 */       argXunitResultItem.setParentResult(null);
/*  836 */       if (postEventsForChanges()) {
/*  837 */         this._events.post(IXunitResult.REMOVE_RESULTITEMS, argXunitResultItem);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IXunitResultProperty> getProperties() {
/*  844 */     if (this._properties == null) {
/*  845 */       this._properties = new HistoricalList(null);
/*      */     }
/*  847 */     return (List<IXunitResultProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IXunitResultProperty> argProperties) {
/*  851 */     if (this._properties == null) {
/*  852 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  854 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  857 */     for (IXunitResultProperty child : this._properties) {
/*  858 */       XunitResultPropertyModel model = (XunitResultPropertyModel)child;
/*  859 */       model.setOrganizationId_noev(getOrganizationId());
/*  860 */       model.setHostname_noev(getHostname());
/*  861 */       model.setResultTimestamp_noev(getResultTimestamp());
/*  862 */       if (child instanceof IDataModelImpl) {
/*  863 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  864 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  865 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  866 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  869 */       if (postEventsForChanges()) {
/*  870 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addXunitResultProperty(IXunitResultProperty argXunitResultProperty) {
/*  876 */     if (this._properties == null) {
/*  877 */       this._properties = new HistoricalList(null);
/*      */     }
/*  879 */     argXunitResultProperty.setOrganizationId(getOrganizationId());
/*  880 */     argXunitResultProperty.setHostname(getHostname());
/*  881 */     argXunitResultProperty.setResultTimestamp(getResultTimestamp());
/*  882 */     if (argXunitResultProperty instanceof IDataModelImpl) {
/*  883 */       IDataAccessObject childDao = ((IDataModelImpl)argXunitResultProperty).getDAO();
/*  884 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  885 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  886 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  891 */     if (postEventsForChanges()) {
/*  892 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argXunitResultProperty));
/*      */     }
/*      */     
/*  895 */     this._properties.add(argXunitResultProperty);
/*  896 */     if (postEventsForChanges()) {
/*  897 */       this._events.post(IXunitResult.ADD_PROPERTIES, argXunitResultProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeXunitResultProperty(IXunitResultProperty argXunitResultProperty) {
/*  902 */     if (this._properties != null) {
/*      */       
/*  904 */       if (postEventsForChanges()) {
/*  905 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argXunitResultProperty));
/*      */       }
/*  907 */       this._properties.remove(argXunitResultProperty);
/*  908 */       if (postEventsForChanges()) {
/*  909 */         this._events.post(IXunitResult.REMOVE_PROPERTIES, argXunitResultProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  916 */     if ("ResultItems".equals(argFieldId)) {
/*  917 */       return getResultItems();
/*      */     }
/*  919 */     if ("Properties".equals(argFieldId)) {
/*  920 */       return getProperties();
/*      */     }
/*  922 */     if ("XunitResultExtension".equals(argFieldId)) {
/*  923 */       return this._myExtension;
/*      */     }
/*      */     
/*  926 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  932 */     if ("ResultItems".equals(argFieldId)) {
/*  933 */       setResultItems(changeToList(argValue, IXunitResultItem.class));
/*      */     }
/*  935 */     else if ("Properties".equals(argFieldId)) {
/*  936 */       setProperties(changeToList(argValue, IXunitResultProperty.class));
/*      */     }
/*  938 */     else if ("XunitResultExtension".equals(argFieldId)) {
/*  939 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  942 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  948 */     this._persistenceDefaults = argPD;
/*  949 */     this._daoImpl.setPersistenceDefaults(argPD);
/*  950 */     this._eventManager = argEM;
/*  951 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/*  952 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*  953 */     if (this._resultItems != null) {
/*  954 */       for (IXunitResultItem relationship : this._resultItems) {
/*  955 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*  958 */     if (this._properties != null) {
/*  959 */       for (IXunitResultProperty relationship : this._properties) {
/*  960 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getXunitResultExt() {
/*  966 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setXunitResultExt(IDataModel argExt) {
/*  970 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  975 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  979 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  982 */     super.startTransaction();
/*      */     
/*  984 */     this._resultItemsSavepoint = this._resultItems;
/*  985 */     if (this._resultItems != null) {
/*  986 */       this._resultItemsSavepoint = new HistoricalList((List)this._resultItems);
/*  987 */       Iterator<IDataModel> it = this._resultItems.iterator();
/*  988 */       while (it.hasNext()) {
/*  989 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/*  993 */     this._propertiesSavepoint = this._properties;
/*  994 */     if (this._properties != null) {
/*  995 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/*  996 */       Iterator<IDataModel> it = this._properties.iterator();
/*  997 */       while (it.hasNext()) {
/*  998 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1003 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1008 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1011 */     super.rollbackChanges();
/*      */     
/* 1013 */     this._resultItems = this._resultItemsSavepoint;
/* 1014 */     this._resultItemsSavepoint = null;
/* 1015 */     if (this._resultItems != null) {
/* 1016 */       Iterator<IDataModel> it = this._resultItems.iterator();
/* 1017 */       while (it.hasNext()) {
/* 1018 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1022 */     this._properties = this._propertiesSavepoint;
/* 1023 */     this._propertiesSavepoint = null;
/* 1024 */     if (this._properties != null) {
/* 1025 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1026 */       while (it.hasNext()) {
/* 1027 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1035 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1038 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1041 */     super.commitTransaction();
/*      */     
/* 1043 */     this._resultItemsSavepoint = this._resultItems;
/* 1044 */     if (this._resultItems != null) {
/* 1045 */       Iterator<IDataModel> it = this._resultItems.iterator();
/* 1046 */       while (it.hasNext()) {
/* 1047 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1049 */       this._resultItems = new HistoricalList((List)this._resultItems);
/*      */     } 
/*      */     
/* 1052 */     this._propertiesSavepoint = this._properties;
/* 1053 */     if (this._properties != null) {
/* 1054 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1055 */       while (it.hasNext()) {
/* 1056 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1058 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1062 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1067 */     argStream.defaultReadObject();
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
/*      */   public void addXunitResultItem(IXunitResultItem newItem) {
/* 1081 */     synchronized (this) {
/* 1082 */       newItem.setResultItemSequence((getResultItems().size() + 1));
/*      */     } 
/* 1084 */     addXunitResultItemImpl(newItem);
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\_test\impl\XunitResultModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */