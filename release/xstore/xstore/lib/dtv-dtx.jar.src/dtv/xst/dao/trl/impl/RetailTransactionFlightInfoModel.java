/*      */ package dtv.xst.dao.trl.impl;
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
/*      */ import dtv.xst.dao.com.IAirportZone;
/*      */ import dtv.xst.dao.trl.IRetailTransaction;
/*      */ import dtv.xst.dao.trl.IRetailTransactionFlightInfo;
/*      */ import dtv.xst.dao.trl.IRetailTransactionFlightInfoProperty;
/*      */ import dtv.xst.dao.trl.RetailTransactionFlightInfoPropertyId;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class RetailTransactionFlightInfoModel extends AbstractDataModelWithPropertyImpl<IRetailTransactionFlightInfoProperty> implements IRetailTransactionFlightInfo {
/*      */   private static final long serialVersionUID = 978775385L;
/*      */   private IRetailTransaction _parentTransaction;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   
/*      */   public String toString() {
/*   36 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IDataModel _myExtension; private IAirportZone _destinationZoneObject; private transient IAirportZone _destinationZoneObjectSavepoint; private HistoricalList<IRetailTransactionFlightInfoProperty> _properties; private transient HistoricalList<IRetailTransactionFlightInfoProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   41 */     setDAO((IDataAccessObject)new RetailTransactionFlightInfoDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private RetailTransactionFlightInfoDAO getDAO_() {
/*   49 */     return (RetailTransactionFlightInfoDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   57 */     if (getDAO_().getOrganizationId() != null) {
/*   58 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   61 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   70 */     if (setOrganizationId_noev(argOrganizationId));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   76 */     boolean ev_postable = false;
/*      */     
/*   78 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   79 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   80 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   81 */       ev_postable = true;
/*   82 */       if (this._properties != null) {
/*      */         
/*   84 */         Iterator<RetailTransactionFlightInfoPropertyModel> it = this._properties.iterator();
/*   85 */         while (it.hasNext())
/*      */         {
/*   87 */           ((RetailTransactionFlightInfoPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   92 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  100 */     if (getDAO_().getRetailLocationId() != null) {
/*  101 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  104 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  113 */     if (setRetailLocationId_noev(argRetailLocationId));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  119 */     boolean ev_postable = false;
/*      */     
/*  121 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  122 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  123 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  124 */       ev_postable = true;
/*  125 */       if (this._properties != null) {
/*      */         
/*  127 */         Iterator<RetailTransactionFlightInfoPropertyModel> it = this._properties.iterator();
/*  128 */         while (it.hasNext())
/*      */         {
/*  130 */           ((RetailTransactionFlightInfoPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  135 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  143 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  151 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  152 */       this._events != null && 
/*  153 */       postEventsForChanges()) {
/*  154 */       this._events.post(IRetailTransactionFlightInfo.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  161 */     boolean ev_postable = false;
/*      */     
/*  163 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  164 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  165 */       getDAO_().setBusinessDate(argBusinessDate);
/*  166 */       ev_postable = true;
/*  167 */       if (this._properties != null) {
/*      */         
/*  169 */         Iterator<RetailTransactionFlightInfoPropertyModel> it = this._properties.iterator();
/*  170 */         while (it.hasNext())
/*      */         {
/*  172 */           ((RetailTransactionFlightInfoPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  177 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  185 */     if (getDAO_().getWorkstationId() != null) {
/*  186 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  189 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  198 */     if (setWorkstationId_noev(argWorkstationId));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  204 */     boolean ev_postable = false;
/*      */     
/*  206 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  207 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  208 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  209 */       ev_postable = true;
/*  210 */       if (this._properties != null) {
/*      */         
/*  212 */         Iterator<RetailTransactionFlightInfoPropertyModel> it = this._properties.iterator();
/*  213 */         while (it.hasNext())
/*      */         {
/*  215 */           ((RetailTransactionFlightInfoPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  220 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  228 */     if (getDAO_().getTransactionSequence() != null) {
/*  229 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  232 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  241 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  242 */       this._events != null && 
/*  243 */       postEventsForChanges()) {
/*  244 */       this._events.post(IRetailTransactionFlightInfo.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  251 */     boolean ev_postable = false;
/*      */     
/*  253 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/*  254 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/*  255 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/*  256 */       ev_postable = true;
/*  257 */       if (this._properties != null) {
/*      */         
/*  259 */         Iterator<RetailTransactionFlightInfoPropertyModel> it = this._properties.iterator();
/*  260 */         while (it.hasNext())
/*      */         {
/*  262 */           ((RetailTransactionFlightInfoPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  267 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  275 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  283 */     if (setCreateDate_noev(argCreateDate) && 
/*  284 */       this._events != null && 
/*  285 */       postEventsForChanges()) {
/*  286 */       this._events.post(IRetailTransactionFlightInfo.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  293 */     boolean ev_postable = false;
/*      */     
/*  295 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  296 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  297 */       getDAO_().setCreateDate(argCreateDate);
/*  298 */       ev_postable = true;
/*      */     } 
/*      */     
/*  301 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  309 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  317 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  318 */       this._events != null && 
/*  319 */       postEventsForChanges()) {
/*  320 */       this._events.post(IRetailTransactionFlightInfo.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  327 */     boolean ev_postable = false;
/*      */     
/*  329 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  330 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  331 */       getDAO_().setCreateUserId(argCreateUserId);
/*  332 */       ev_postable = true;
/*      */     } 
/*      */     
/*  335 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  343 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  351 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  352 */       this._events != null && 
/*  353 */       postEventsForChanges()) {
/*  354 */       this._events.post(IRetailTransactionFlightInfo.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  361 */     boolean ev_postable = false;
/*      */     
/*  363 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  364 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  365 */       getDAO_().setUpdateDate(argUpdateDate);
/*  366 */       ev_postable = true;
/*      */     } 
/*      */     
/*  369 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  377 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  385 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  386 */       this._events != null && 
/*  387 */       postEventsForChanges()) {
/*  388 */       this._events.post(IRetailTransactionFlightInfo.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  395 */     boolean ev_postable = false;
/*      */     
/*  397 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  398 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  399 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  400 */       ev_postable = true;
/*      */     } 
/*      */     
/*  403 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFlightNumber() {
/*  411 */     return getDAO_().getFlightNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFlightNumber(String argFlightNumber) {
/*  419 */     if (setFlightNumber_noev(argFlightNumber) && 
/*  420 */       this._events != null && 
/*  421 */       postEventsForChanges()) {
/*  422 */       this._events.post(IRetailTransactionFlightInfo.SET_FLIGHTNUMBER, argFlightNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFlightNumber_noev(String argFlightNumber) {
/*  429 */     boolean ev_postable = false;
/*      */     
/*  431 */     if ((getDAO_().getFlightNumber() == null && argFlightNumber != null) || (
/*  432 */       getDAO_().getFlightNumber() != null && !getDAO_().getFlightNumber().equals(argFlightNumber))) {
/*  433 */       getDAO_().setFlightNumber(argFlightNumber);
/*  434 */       ev_postable = true;
/*      */     } 
/*      */     
/*  437 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDestinationAirport() {
/*  445 */     return getDAO_().getDestinationAirport();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDestinationAirport(String argDestinationAirport) {
/*  453 */     if (setDestinationAirport_noev(argDestinationAirport) && 
/*  454 */       this._events != null && 
/*  455 */       postEventsForChanges()) {
/*  456 */       this._events.post(IRetailTransactionFlightInfo.SET_DESTINATIONAIRPORT, argDestinationAirport);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDestinationAirport_noev(String argDestinationAirport) {
/*  463 */     boolean ev_postable = false;
/*      */     
/*  465 */     if ((getDAO_().getDestinationAirport() == null && argDestinationAirport != null) || (
/*  466 */       getDAO_().getDestinationAirport() != null && !getDAO_().getDestinationAirport().equals(argDestinationAirport))) {
/*  467 */       getDAO_().setDestinationAirport(argDestinationAirport);
/*  468 */       ev_postable = true;
/*      */     } 
/*      */     
/*  471 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDestinationCountry() {
/*  479 */     return getDAO_().getDestinationCountry();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDestinationCountry(String argDestinationCountry) {
/*  487 */     if (setDestinationCountry_noev(argDestinationCountry) && 
/*  488 */       this._events != null && 
/*  489 */       postEventsForChanges()) {
/*  490 */       this._events.post(IRetailTransactionFlightInfo.SET_DESTINATIONCOUNTRY, argDestinationCountry);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDestinationCountry_noev(String argDestinationCountry) {
/*  497 */     boolean ev_postable = false;
/*      */     
/*  499 */     if ((getDAO_().getDestinationCountry() == null && argDestinationCountry != null) || (
/*  500 */       getDAO_().getDestinationCountry() != null && !getDAO_().getDestinationCountry().equals(argDestinationCountry))) {
/*  501 */       getDAO_().setDestinationCountry(argDestinationCountry);
/*  502 */       ev_postable = true;
/*      */     } 
/*      */     
/*  505 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDestinationZone() {
/*  513 */     return getDAO_().getDestinationZone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDestinationZone(String argDestinationZone) {
/*  521 */     if (setDestinationZone_noev(argDestinationZone) && 
/*  522 */       this._events != null && 
/*  523 */       postEventsForChanges()) {
/*  524 */       this._events.post(IRetailTransactionFlightInfo.SET_DESTINATIONZONE, argDestinationZone);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDestinationZone_noev(String argDestinationZone) {
/*  531 */     boolean ev_postable = false;
/*      */     
/*  533 */     if ((getDAO_().getDestinationZone() == null && argDestinationZone != null) || (
/*  534 */       getDAO_().getDestinationZone() != null && !getDAO_().getDestinationZone().equals(argDestinationZone))) {
/*  535 */       getDAO_().setDestinationZone(argDestinationZone);
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
/*      */   public String getDestinationAirportName() {
/*  547 */     return getDAO_().getDestinationAirportName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDestinationAirportName(String argDestinationAirportName) {
/*  555 */     if (setDestinationAirportName_noev(argDestinationAirportName) && 
/*  556 */       this._events != null && 
/*  557 */       postEventsForChanges()) {
/*  558 */       this._events.post(IRetailTransactionFlightInfo.SET_DESTINATIONAIRPORTNAME, argDestinationAirportName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDestinationAirportName_noev(String argDestinationAirportName) {
/*  565 */     boolean ev_postable = false;
/*      */     
/*  567 */     if ((getDAO_().getDestinationAirportName() == null && argDestinationAirportName != null) || (
/*  568 */       getDAO_().getDestinationAirportName() != null && !getDAO_().getDestinationAirportName().equals(argDestinationAirportName))) {
/*  569 */       getDAO_().setDestinationAirportName(argDestinationAirportName);
/*  570 */       ev_postable = true;
/*      */     } 
/*      */     
/*  573 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOriginAirport() {
/*  581 */     return getDAO_().getOriginAirport();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginAirport(String argOriginAirport) {
/*  589 */     if (setOriginAirport_noev(argOriginAirport) && 
/*  590 */       this._events != null && 
/*  591 */       postEventsForChanges()) {
/*  592 */       this._events.post(IRetailTransactionFlightInfo.SET_ORIGINAIRPORT, argOriginAirport);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginAirport_noev(String argOriginAirport) {
/*  599 */     boolean ev_postable = false;
/*      */     
/*  601 */     if ((getDAO_().getOriginAirport() == null && argOriginAirport != null) || (
/*  602 */       getDAO_().getOriginAirport() != null && !getDAO_().getOriginAirport().equals(argOriginAirport))) {
/*  603 */       getDAO_().setOriginAirport(argOriginAirport);
/*  604 */       ev_postable = true;
/*      */     } 
/*      */     
/*  607 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxCalculationMode() {
/*  615 */     return getDAO_().getTaxCalculationMode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxCalculationMode(String argTaxCalculationMode) {
/*  623 */     if (setTaxCalculationMode_noev(argTaxCalculationMode) && 
/*  624 */       this._events != null && 
/*  625 */       postEventsForChanges()) {
/*  626 */       this._events.post(IRetailTransactionFlightInfo.SET_TAXCALCULATIONMODE, argTaxCalculationMode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxCalculationMode_noev(String argTaxCalculationMode) {
/*  633 */     boolean ev_postable = false;
/*      */     
/*  635 */     if ((getDAO_().getTaxCalculationMode() == null && argTaxCalculationMode != null) || (
/*  636 */       getDAO_().getTaxCalculationMode() != null && !getDAO_().getTaxCalculationMode().equals(argTaxCalculationMode))) {
/*  637 */       getDAO_().setTaxCalculationMode(argTaxCalculationMode);
/*  638 */       ev_postable = true;
/*      */     } 
/*      */     
/*  641 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFirstFlightNumber() {
/*  649 */     return getDAO_().getFirstFlightNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFirstFlightNumber(String argFirstFlightNumber) {
/*  657 */     if (setFirstFlightNumber_noev(argFirstFlightNumber) && 
/*  658 */       this._events != null && 
/*  659 */       postEventsForChanges()) {
/*  660 */       this._events.post(IRetailTransactionFlightInfo.SET_FIRSTFLIGHTNUMBER, argFirstFlightNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFirstFlightNumber_noev(String argFirstFlightNumber) {
/*  667 */     boolean ev_postable = false;
/*      */     
/*  669 */     if ((getDAO_().getFirstFlightNumber() == null && argFirstFlightNumber != null) || (
/*  670 */       getDAO_().getFirstFlightNumber() != null && !getDAO_().getFirstFlightNumber().equals(argFirstFlightNumber))) {
/*  671 */       getDAO_().setFirstFlightNumber(argFirstFlightNumber);
/*  672 */       ev_postable = true;
/*      */     } 
/*      */     
/*  675 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFirstDestinationAirport() {
/*  683 */     return getDAO_().getFirstDestinationAirport();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFirstDestinationAirport(String argFirstDestinationAirport) {
/*  691 */     if (setFirstDestinationAirport_noev(argFirstDestinationAirport) && 
/*  692 */       this._events != null && 
/*  693 */       postEventsForChanges()) {
/*  694 */       this._events.post(IRetailTransactionFlightInfo.SET_FIRSTDESTINATIONAIRPORT, argFirstDestinationAirport);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFirstDestinationAirport_noev(String argFirstDestinationAirport) {
/*  701 */     boolean ev_postable = false;
/*      */     
/*  703 */     if ((getDAO_().getFirstDestinationAirport() == null && argFirstDestinationAirport != null) || (
/*  704 */       getDAO_().getFirstDestinationAirport() != null && !getDAO_().getFirstDestinationAirport().equals(argFirstDestinationAirport))) {
/*  705 */       getDAO_().setFirstDestinationAirport(argFirstDestinationAirport);
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
/*      */   public String getFirstOriginAirport() {
/*  717 */     return getDAO_().getFirstOriginAirport();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFirstOriginAirport(String argFirstOriginAirport) {
/*  725 */     if (setFirstOriginAirport_noev(argFirstOriginAirport) && 
/*  726 */       this._events != null && 
/*  727 */       postEventsForChanges()) {
/*  728 */       this._events.post(IRetailTransactionFlightInfo.SET_FIRSTORIGINAIRPORT, argFirstOriginAirport);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFirstOriginAirport_noev(String argFirstOriginAirport) {
/*  735 */     boolean ev_postable = false;
/*      */     
/*  737 */     if ((getDAO_().getFirstOriginAirport() == null && argFirstOriginAirport != null) || (
/*  738 */       getDAO_().getFirstOriginAirport() != null && !getDAO_().getFirstOriginAirport().equals(argFirstOriginAirport))) {
/*  739 */       getDAO_().setFirstOriginAirport(argFirstOriginAirport);
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
/*      */   public String getFirstFlightSeatNumber() {
/*  751 */     return getDAO_().getFirstFlightSeatNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFirstFlightSeatNumber(String argFirstFlightSeatNumber) {
/*  759 */     if (setFirstFlightSeatNumber_noev(argFirstFlightSeatNumber) && 
/*  760 */       this._events != null && 
/*  761 */       postEventsForChanges()) {
/*  762 */       this._events.post(IRetailTransactionFlightInfo.SET_FIRSTFLIGHTSEATNUMBER, argFirstFlightSeatNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFirstFlightSeatNumber_noev(String argFirstFlightSeatNumber) {
/*  769 */     boolean ev_postable = false;
/*      */     
/*  771 */     if ((getDAO_().getFirstFlightSeatNumber() == null && argFirstFlightSeatNumber != null) || (
/*  772 */       getDAO_().getFirstFlightSeatNumber() != null && !getDAO_().getFirstFlightSeatNumber().equals(argFirstFlightSeatNumber))) {
/*  773 */       getDAO_().setFirstFlightSeatNumber(argFirstFlightSeatNumber);
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
/*      */   public Date getFirstFlightScheduledDate() {
/*  785 */     return getDAO_().getFirstFlightScheduledDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFirstFlightScheduledDate(Date argFirstFlightScheduledDate) {
/*  793 */     if (setFirstFlightScheduledDate_noev(argFirstFlightScheduledDate) && 
/*  794 */       this._events != null && 
/*  795 */       postEventsForChanges()) {
/*  796 */       this._events.post(IRetailTransactionFlightInfo.SET_FIRSTFLIGHTSCHEDULEDDATE, argFirstFlightScheduledDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFirstFlightScheduledDate_noev(Date argFirstFlightScheduledDate) {
/*  803 */     boolean ev_postable = false;
/*      */     
/*  805 */     if ((getDAO_().getFirstFlightScheduledDate() == null && argFirstFlightScheduledDate != null) || (
/*  806 */       getDAO_().getFirstFlightScheduledDate() != null && !getDAO_().getFirstFlightScheduledDate().equals(argFirstFlightScheduledDate))) {
/*  807 */       getDAO_().setFirstFlightScheduledDate(argFirstFlightScheduledDate);
/*  808 */       ev_postable = true;
/*      */     } 
/*      */     
/*  811 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IRetailTransactionFlightInfoProperty newProperty(String argPropertyName) {
/*  815 */     RetailTransactionFlightInfoPropertyId id = new RetailTransactionFlightInfoPropertyId();
/*      */     
/*  817 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  818 */     id.setBusinessDate(getBusinessDate());
/*  819 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/*  820 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/*  821 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  823 */     IRetailTransactionFlightInfoProperty prop = (IRetailTransactionFlightInfoProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IRetailTransactionFlightInfoProperty.class);
/*  824 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "DestinationZoneObject")
/*      */   public IAirportZone getDestinationZoneObject() {
/*  836 */     return this._destinationZoneObject;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDestinationZoneObject(IAirportZone argDestinationZoneObject) {
/*  841 */     if (argDestinationZoneObject == null) {
/*      */       
/*  843 */       getDAO_().setDestinationZone(null);
/*  844 */       if (this._destinationZoneObject != null)
/*      */       {
/*  846 */         if (postEventsForChanges()) {
/*  847 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._destinationZoneObject));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  852 */       getDAO_().setDestinationZone(argDestinationZoneObject.getZoneId());
/*      */       
/*  854 */       if (postEventsForChanges()) {
/*  855 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDestinationZoneObject));
/*      */       }
/*      */     } 
/*      */     
/*  859 */     this._destinationZoneObject = argDestinationZoneObject;
/*  860 */     if (postEventsForChanges()) {
/*  861 */       this._events.post(IRetailTransactionFlightInfo.SET_DESTINATIONZONEOBJECT, argDestinationZoneObject);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IRetailTransactionFlightInfoProperty> getProperties() {
/*  867 */     if (this._properties == null) {
/*  868 */       this._properties = new HistoricalList(null);
/*      */     }
/*  870 */     return (List<IRetailTransactionFlightInfoProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IRetailTransactionFlightInfoProperty> argProperties) {
/*  874 */     if (this._properties == null) {
/*  875 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  877 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  880 */     for (IRetailTransactionFlightInfoProperty child : this._properties) {
/*  881 */       RetailTransactionFlightInfoPropertyModel model = (RetailTransactionFlightInfoPropertyModel)child;
/*  882 */       model.setOrganizationId_noev(getOrganizationId());
/*  883 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  884 */       model.setBusinessDate_noev(getBusinessDate());
/*  885 */       model.setWorkstationId_noev(getWorkstationId());
/*  886 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  887 */       if (child instanceof IDataModelImpl) {
/*  888 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  889 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  890 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  891 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  894 */       if (postEventsForChanges()) {
/*  895 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addRetailTransactionFlightInfoProperty(IRetailTransactionFlightInfoProperty argRetailTransactionFlightInfoProperty) {
/*  901 */     if (this._properties == null) {
/*  902 */       this._properties = new HistoricalList(null);
/*      */     }
/*  904 */     argRetailTransactionFlightInfoProperty.setOrganizationId(getOrganizationId());
/*  905 */     argRetailTransactionFlightInfoProperty.setRetailLocationId(getRetailLocationId());
/*  906 */     argRetailTransactionFlightInfoProperty.setBusinessDate(getBusinessDate());
/*  907 */     argRetailTransactionFlightInfoProperty.setWorkstationId(getWorkstationId());
/*  908 */     argRetailTransactionFlightInfoProperty.setTransactionSequence(getTransactionSequence());
/*  909 */     if (argRetailTransactionFlightInfoProperty instanceof IDataModelImpl) {
/*  910 */       IDataAccessObject childDao = ((IDataModelImpl)argRetailTransactionFlightInfoProperty).getDAO();
/*  911 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  912 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  913 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  918 */     if (postEventsForChanges()) {
/*  919 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailTransactionFlightInfoProperty));
/*      */     }
/*      */     
/*  922 */     this._properties.add(argRetailTransactionFlightInfoProperty);
/*  923 */     if (postEventsForChanges()) {
/*  924 */       this._events.post(IRetailTransactionFlightInfo.ADD_PROPERTIES, argRetailTransactionFlightInfoProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeRetailTransactionFlightInfoProperty(IRetailTransactionFlightInfoProperty argRetailTransactionFlightInfoProperty) {
/*  929 */     if (this._properties != null) {
/*      */       
/*  931 */       if (postEventsForChanges()) {
/*  932 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailTransactionFlightInfoProperty));
/*      */       }
/*  934 */       this._properties.remove(argRetailTransactionFlightInfoProperty);
/*  935 */       if (postEventsForChanges()) {
/*  936 */         this._events.post(IRetailTransactionFlightInfo.REMOVE_PROPERTIES, argRetailTransactionFlightInfoProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentTransaction(IRetailTransaction argParentTransaction) {
/*  942 */     this._parentTransaction = argParentTransaction;
/*      */   }
/*      */   
/*      */   public IRetailTransaction getParentTransaction() {
/*  946 */     return this._parentTransaction;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  951 */     if ("DestinationZoneObject".equals(argFieldId)) {
/*  952 */       return getDestinationZoneObject();
/*      */     }
/*  954 */     if ("Properties".equals(argFieldId)) {
/*  955 */       return getProperties();
/*      */     }
/*  957 */     if ("RetailTransactionFlightInfoExtension".equals(argFieldId)) {
/*  958 */       return this._myExtension;
/*      */     }
/*      */     
/*  961 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  967 */     if ("DestinationZoneObject".equals(argFieldId)) {
/*  968 */       setDestinationZoneObject((IAirportZone)argValue);
/*      */     }
/*  970 */     else if ("Properties".equals(argFieldId)) {
/*  971 */       setProperties(changeToList(argValue, IRetailTransactionFlightInfoProperty.class));
/*      */     }
/*  973 */     else if ("RetailTransactionFlightInfoExtension".equals(argFieldId)) {
/*  974 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  977 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  983 */     this._persistenceDefaults = argPD;
/*  984 */     this._daoImpl.setPersistenceDefaults(argPD);
/*  985 */     this._eventManager = argEM;
/*  986 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/*  987 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*  988 */     if (this._destinationZoneObject != null) {
/*  989 */       ((IDataModelImpl)this._destinationZoneObject).setDependencies(argPD, argEM);
/*      */     }
/*  991 */     if (this._properties != null) {
/*  992 */       for (IRetailTransactionFlightInfoProperty relationship : this._properties) {
/*  993 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getRetailTransactionFlightInfoExt() {
/*  999 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setRetailTransactionFlightInfoExt(IDataModel argExt) {
/* 1003 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1008 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1012 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1015 */     super.startTransaction();
/*      */     
/* 1017 */     this._destinationZoneObjectSavepoint = this._destinationZoneObject;
/* 1018 */     if (this._destinationZoneObject != null) {
/* 1019 */       this._destinationZoneObject.startTransaction();
/*      */     }
/*      */     
/* 1022 */     this._propertiesSavepoint = this._properties;
/* 1023 */     if (this._properties != null) {
/* 1024 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1025 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1026 */       while (it.hasNext()) {
/* 1027 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1032 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1037 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1040 */     super.rollbackChanges();
/*      */     
/* 1042 */     this._destinationZoneObject = this._destinationZoneObjectSavepoint;
/* 1043 */     this._destinationZoneObjectSavepoint = null;
/* 1044 */     if (this._destinationZoneObject != null) {
/* 1045 */       this._destinationZoneObject.rollbackChanges();
/*      */     }
/*      */     
/* 1048 */     this._properties = this._propertiesSavepoint;
/* 1049 */     this._propertiesSavepoint = null;
/* 1050 */     if (this._properties != null) {
/* 1051 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1052 */       while (it.hasNext()) {
/* 1053 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1061 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1064 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1067 */     super.commitTransaction();
/*      */     
/* 1069 */     this._destinationZoneObjectSavepoint = this._destinationZoneObject;
/* 1070 */     if (this._destinationZoneObject != null) {
/* 1071 */       this._destinationZoneObject.commitTransaction();
/*      */     }
/*      */     
/* 1074 */     this._propertiesSavepoint = this._properties;
/* 1075 */     if (this._properties != null) {
/* 1076 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1077 */       while (it.hasNext()) {
/* 1078 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1080 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1084 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1089 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionFlightInfoModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */