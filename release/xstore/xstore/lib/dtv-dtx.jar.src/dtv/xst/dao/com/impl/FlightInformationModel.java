/*     */ package dtv.xst.dao.com.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.com.FlightInformationPropertyId;
/*     */ import dtv.xst.dao.com.IFlightInformation;
/*     */ import dtv.xst.dao.com.IFlightInformationProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class FlightInformationModel extends AbstractDataModelWithPropertyImpl<IFlightInformationProperty> implements IFlightInformation {
/*     */   private static final long serialVersionUID = 766554748L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IFlightInformationProperty> _properties; private transient HistoricalList<IFlightInformationProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new FlightInformationDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FlightInformationDAO getDAO_() {
/*  46 */     return (FlightInformationDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  54 */     if (getDAO_().getOrganizationId() != null) {
/*  55 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  58 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  67 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  68 */       this._events != null && 
/*  69 */       postEventsForChanges()) {
/*  70 */       this._events.post(IFlightInformation.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  77 */     boolean ev_postable = false;
/*     */     
/*  79 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  80 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  81 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  82 */       ev_postable = true;
/*  83 */       if (this._properties != null) {
/*     */         
/*  85 */         Iterator<FlightInformationPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((FlightInformationPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  93 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getScheduledDateTime() {
/* 101 */     return getDAO_().getScheduledDateTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScheduledDateTime(Date argScheduledDateTime) {
/* 109 */     if (setScheduledDateTime_noev(argScheduledDateTime) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IFlightInformation.SET_SCHEDULEDDATETIME, argScheduledDateTime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setScheduledDateTime_noev(Date argScheduledDateTime) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getScheduledDateTime() == null && argScheduledDateTime != null) || (
/* 122 */       getDAO_().getScheduledDateTime() != null && !getDAO_().getScheduledDateTime().equals(argScheduledDateTime))) {
/* 123 */       getDAO_().setScheduledDateTime(argScheduledDateTime);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<FlightInformationPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((FlightInformationPropertyModel)it.next()).setScheduledDateTime_noev(argScheduledDateTime);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 135 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFlightNumber() {
/* 143 */     return getDAO_().getFlightNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFlightNumber(String argFlightNumber) {
/* 151 */     if (setFlightNumber_noev(argFlightNumber) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IFlightInformation.SET_FLIGHTNUMBER, argFlightNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFlightNumber_noev(String argFlightNumber) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getFlightNumber() == null && argFlightNumber != null) || (
/* 164 */       getDAO_().getFlightNumber() != null && !getDAO_().getFlightNumber().equals(argFlightNumber))) {
/* 165 */       getDAO_().setFlightNumber(argFlightNumber);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<FlightInformationPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((FlightInformationPropertyModel)it.next()).setFlightNumber_noev(argFlightNumber);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 177 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOriginAirport() {
/* 185 */     return getDAO_().getOriginAirport();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOriginAirport(String argOriginAirport) {
/* 193 */     if (setOriginAirport_noev(argOriginAirport) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IFlightInformation.SET_ORIGINAIRPORT, argOriginAirport);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOriginAirport_noev(String argOriginAirport) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getOriginAirport() == null && argOriginAirport != null) || (
/* 206 */       getDAO_().getOriginAirport() != null && !getDAO_().getOriginAirport().equals(argOriginAirport))) {
/* 207 */       getDAO_().setOriginAirport(argOriginAirport);
/* 208 */       ev_postable = true;
/* 209 */       if (this._properties != null) {
/*     */         
/* 211 */         Iterator<FlightInformationPropertyModel> it = this._properties.iterator();
/* 212 */         while (it.hasNext())
/*     */         {
/* 214 */           ((FlightInformationPropertyModel)it.next()).setOriginAirport_noev(argOriginAirport);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 219 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 227 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 235 */     if (setCreateDate_noev(argCreateDate) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(IFlightInformation.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 248 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 249 */       getDAO_().setCreateDate(argCreateDate);
/* 250 */       ev_postable = true;
/*     */     } 
/*     */     
/* 253 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 261 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 269 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 270 */       this._events != null && 
/* 271 */       postEventsForChanges()) {
/* 272 */       this._events.post(IFlightInformation.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 279 */     boolean ev_postable = false;
/*     */     
/* 281 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 282 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 283 */       getDAO_().setCreateUserId(argCreateUserId);
/* 284 */       ev_postable = true;
/*     */     } 
/*     */     
/* 287 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 295 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 303 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 304 */       this._events != null && 
/* 305 */       postEventsForChanges()) {
/* 306 */       this._events.post(IFlightInformation.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 313 */     boolean ev_postable = false;
/*     */     
/* 315 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 316 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 317 */       getDAO_().setUpdateDate(argUpdateDate);
/* 318 */       ev_postable = true;
/*     */     } 
/*     */     
/* 321 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 329 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 337 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 338 */       this._events != null && 
/* 339 */       postEventsForChanges()) {
/* 340 */       this._events.post(IFlightInformation.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 347 */     boolean ev_postable = false;
/*     */     
/* 349 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 350 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 351 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 352 */       ev_postable = true;
/*     */     } 
/*     */     
/* 355 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDestinationAirport() {
/* 363 */     return getDAO_().getDestinationAirport();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDestinationAirport(String argDestinationAirport) {
/* 371 */     if (setDestinationAirport_noev(argDestinationAirport) && 
/* 372 */       this._events != null && 
/* 373 */       postEventsForChanges()) {
/* 374 */       this._events.post(IFlightInformation.SET_DESTINATIONAIRPORT, argDestinationAirport);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDestinationAirport_noev(String argDestinationAirport) {
/* 381 */     boolean ev_postable = false;
/*     */     
/* 383 */     if ((getDAO_().getDestinationAirport() == null && argDestinationAirport != null) || (
/* 384 */       getDAO_().getDestinationAirport() != null && !getDAO_().getDestinationAirport().equals(argDestinationAirport))) {
/* 385 */       getDAO_().setDestinationAirport(argDestinationAirport);
/* 386 */       ev_postable = true;
/*     */     } 
/*     */     
/* 389 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVia1Airport() {
/* 397 */     return getDAO_().getVia1Airport();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVia1Airport(String argVia1Airport) {
/* 405 */     if (setVia1Airport_noev(argVia1Airport) && 
/* 406 */       this._events != null && 
/* 407 */       postEventsForChanges()) {
/* 408 */       this._events.post(IFlightInformation.SET_VIA1AIRPORT, argVia1Airport);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVia1Airport_noev(String argVia1Airport) {
/* 415 */     boolean ev_postable = false;
/*     */     
/* 417 */     if ((getDAO_().getVia1Airport() == null && argVia1Airport != null) || (
/* 418 */       getDAO_().getVia1Airport() != null && !getDAO_().getVia1Airport().equals(argVia1Airport))) {
/* 419 */       getDAO_().setVia1Airport(argVia1Airport);
/* 420 */       ev_postable = true;
/*     */     } 
/*     */     
/* 423 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVia2Airport() {
/* 431 */     return getDAO_().getVia2Airport();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVia2Airport(String argVia2Airport) {
/* 439 */     if (setVia2Airport_noev(argVia2Airport) && 
/* 440 */       this._events != null && 
/* 441 */       postEventsForChanges()) {
/* 442 */       this._events.post(IFlightInformation.SET_VIA2AIRPORT, argVia2Airport);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVia2Airport_noev(String argVia2Airport) {
/* 449 */     boolean ev_postable = false;
/*     */     
/* 451 */     if ((getDAO_().getVia2Airport() == null && argVia2Airport != null) || (
/* 452 */       getDAO_().getVia2Airport() != null && !getDAO_().getVia2Airport().equals(argVia2Airport))) {
/* 453 */       getDAO_().setVia2Airport(argVia2Airport);
/* 454 */       ev_postable = true;
/*     */     } 
/*     */     
/* 457 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVia3Airport() {
/* 465 */     return getDAO_().getVia3Airport();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVia3Airport(String argVia3Airport) {
/* 473 */     if (setVia3Airport_noev(argVia3Airport) && 
/* 474 */       this._events != null && 
/* 475 */       postEventsForChanges()) {
/* 476 */       this._events.post(IFlightInformation.SET_VIA3AIRPORT, argVia3Airport);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVia3Airport_noev(String argVia3Airport) {
/* 483 */     boolean ev_postable = false;
/*     */     
/* 485 */     if ((getDAO_().getVia3Airport() == null && argVia3Airport != null) || (
/* 486 */       getDAO_().getVia3Airport() != null && !getDAO_().getVia3Airport().equals(argVia3Airport))) {
/* 487 */       getDAO_().setVia3Airport(argVia3Airport);
/* 488 */       ev_postable = true;
/*     */     } 
/*     */     
/* 491 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IFlightInformationProperty newProperty(String argPropertyName) {
/* 495 */     FlightInformationPropertyId id = new FlightInformationPropertyId();
/*     */     
/* 497 */     id.setScheduledDateTime(getScheduledDateTime());
/* 498 */     id.setFlightNumber(getFlightNumber());
/* 499 */     id.setOriginAirport(getOriginAirport());
/* 500 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 502 */     IFlightInformationProperty prop = (IFlightInformationProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IFlightInformationProperty.class);
/* 503 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IFlightInformationProperty> getProperties() {
/* 512 */     if (this._properties == null) {
/* 513 */       this._properties = new HistoricalList(null);
/*     */     }
/* 515 */     return (List<IFlightInformationProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IFlightInformationProperty> argProperties) {
/* 519 */     if (this._properties == null) {
/* 520 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 522 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 525 */     for (IFlightInformationProperty child : this._properties) {
/* 526 */       FlightInformationPropertyModel model = (FlightInformationPropertyModel)child;
/* 527 */       model.setOrganizationId_noev(getOrganizationId());
/* 528 */       model.setScheduledDateTime_noev(getScheduledDateTime());
/* 529 */       model.setFlightNumber_noev(getFlightNumber());
/* 530 */       model.setOriginAirport_noev(getOriginAirport());
/* 531 */       if (child instanceof IDataModelImpl) {
/* 532 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 533 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 534 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 535 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 538 */       if (postEventsForChanges()) {
/* 539 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addFlightInformationProperty(IFlightInformationProperty argFlightInformationProperty) {
/* 545 */     if (this._properties == null) {
/* 546 */       this._properties = new HistoricalList(null);
/*     */     }
/* 548 */     argFlightInformationProperty.setOrganizationId(getOrganizationId());
/* 549 */     argFlightInformationProperty.setScheduledDateTime(getScheduledDateTime());
/* 550 */     argFlightInformationProperty.setFlightNumber(getFlightNumber());
/* 551 */     argFlightInformationProperty.setOriginAirport(getOriginAirport());
/* 552 */     if (argFlightInformationProperty instanceof IDataModelImpl) {
/* 553 */       IDataAccessObject childDao = ((IDataModelImpl)argFlightInformationProperty).getDAO();
/* 554 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 555 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 556 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 561 */     if (postEventsForChanges()) {
/* 562 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argFlightInformationProperty));
/*     */     }
/*     */     
/* 565 */     this._properties.add(argFlightInformationProperty);
/* 566 */     if (postEventsForChanges()) {
/* 567 */       this._events.post(IFlightInformation.ADD_PROPERTIES, argFlightInformationProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeFlightInformationProperty(IFlightInformationProperty argFlightInformationProperty) {
/* 572 */     if (this._properties != null) {
/*     */       
/* 574 */       if (postEventsForChanges()) {
/* 575 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argFlightInformationProperty));
/*     */       }
/* 577 */       this._properties.remove(argFlightInformationProperty);
/* 578 */       if (postEventsForChanges()) {
/* 579 */         this._events.post(IFlightInformation.REMOVE_PROPERTIES, argFlightInformationProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 586 */     if ("Properties".equals(argFieldId)) {
/* 587 */       return getProperties();
/*     */     }
/* 589 */     if ("FlightInformationExtension".equals(argFieldId)) {
/* 590 */       return this._myExtension;
/*     */     }
/*     */     
/* 593 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 599 */     if ("Properties".equals(argFieldId)) {
/* 600 */       setProperties(changeToList(argValue, IFlightInformationProperty.class));
/*     */     }
/* 602 */     else if ("FlightInformationExtension".equals(argFieldId)) {
/* 603 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 606 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 612 */     this._persistenceDefaults = argPD;
/* 613 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 614 */     this._eventManager = argEM;
/* 615 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 616 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 617 */     if (this._properties != null) {
/* 618 */       for (IFlightInformationProperty relationship : this._properties) {
/* 619 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getFlightInformationExt() {
/* 625 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setFlightInformationExt(IDataModel argExt) {
/* 629 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 634 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 638 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 641 */     super.startTransaction();
/*     */     
/* 643 */     this._propertiesSavepoint = this._properties;
/* 644 */     if (this._properties != null) {
/* 645 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 646 */       Iterator<IDataModel> it = this._properties.iterator();
/* 647 */       while (it.hasNext()) {
/* 648 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 653 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 658 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 661 */     super.rollbackChanges();
/*     */     
/* 663 */     this._properties = this._propertiesSavepoint;
/* 664 */     this._propertiesSavepoint = null;
/* 665 */     if (this._properties != null) {
/* 666 */       Iterator<IDataModel> it = this._properties.iterator();
/* 667 */       while (it.hasNext()) {
/* 668 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 676 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 679 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 682 */     super.commitTransaction();
/*     */     
/* 684 */     this._propertiesSavepoint = this._properties;
/* 685 */     if (this._properties != null) {
/* 686 */       Iterator<IDataModel> it = this._properties.iterator();
/* 687 */       while (it.hasNext()) {
/* 688 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 690 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 694 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 699 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\FlightInformationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */