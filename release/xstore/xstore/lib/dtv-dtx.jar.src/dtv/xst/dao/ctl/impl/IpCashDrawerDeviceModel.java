/*      */ package dtv.xst.dao.ctl.impl;
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
/*      */ import dtv.xst.dao.ctl.IIpCashDrawerDevice;
/*      */ import dtv.xst.dao.ctl.IIpCashDrawerDeviceProperty;
/*      */ import dtv.xst.dao.ctl.IpCashDrawerDevicePropertyId;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class IpCashDrawerDeviceModel extends AbstractDataModelWithPropertyImpl<IIpCashDrawerDeviceProperty> implements IIpCashDrawerDevice {
/*      */   private static final long serialVersionUID = -1578154783L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   
/*      */   public String toString() {
/*   33 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IDataModel _myExtension; private HistoricalList<IIpCashDrawerDeviceProperty> _properties; private transient HistoricalList<IIpCashDrawerDeviceProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   38 */     setDAO((IDataAccessObject)new IpCashDrawerDeviceDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private IpCashDrawerDeviceDAO getDAO_() {
/*   46 */     return (IpCashDrawerDeviceDAO)this._daoImpl;
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
/*   70 */       this._events.post(IIpCashDrawerDevice.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*   83 */       if (this._properties != null) {
/*      */         
/*   85 */         Iterator<IpCashDrawerDevicePropertyModel> it = this._properties.iterator();
/*   86 */         while (it.hasNext())
/*      */         {
/*   88 */           ((IpCashDrawerDevicePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   93 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  101 */     if (getDAO_().getRetailLocationId() != null) {
/*  102 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  105 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  114 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  115 */       this._events != null && 
/*  116 */       postEventsForChanges()) {
/*  117 */       this._events.post(IIpCashDrawerDevice.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  124 */     boolean ev_postable = false;
/*      */     
/*  126 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  127 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  128 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  129 */       ev_postable = true;
/*  130 */       if (this._properties != null) {
/*      */         
/*  132 */         Iterator<IpCashDrawerDevicePropertyModel> it = this._properties.iterator();
/*  133 */         while (it.hasNext())
/*      */         {
/*  135 */           ((IpCashDrawerDevicePropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  140 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCashDrawerId() {
/*  148 */     return getDAO_().getCashDrawerId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCashDrawerId(String argCashDrawerId) {
/*  156 */     if (setCashDrawerId_noev(argCashDrawerId) && 
/*  157 */       this._events != null && 
/*  158 */       postEventsForChanges()) {
/*  159 */       this._events.post(IIpCashDrawerDevice.SET_CASHDRAWERID, argCashDrawerId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCashDrawerId_noev(String argCashDrawerId) {
/*  166 */     boolean ev_postable = false;
/*      */     
/*  168 */     if ((getDAO_().getCashDrawerId() == null && argCashDrawerId != null) || (
/*  169 */       getDAO_().getCashDrawerId() != null && !getDAO_().getCashDrawerId().equals(argCashDrawerId))) {
/*  170 */       getDAO_().setCashDrawerId(argCashDrawerId);
/*  171 */       ev_postable = true;
/*  172 */       if (this._properties != null) {
/*      */         
/*  174 */         Iterator<IpCashDrawerDevicePropertyModel> it = this._properties.iterator();
/*  175 */         while (it.hasNext())
/*      */         {
/*  177 */           ((IpCashDrawerDevicePropertyModel)it.next()).setCashDrawerId_noev(argCashDrawerId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  182 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDrawerStatus() {
/*  190 */     return getDAO_().getDrawerStatus();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDrawerStatus(String argDrawerStatus) {
/*  198 */     if (setDrawerStatus_noev(argDrawerStatus) && 
/*  199 */       this._events != null && 
/*  200 */       postEventsForChanges()) {
/*  201 */       this._events.post(IIpCashDrawerDevice.SET_DRAWERSTATUS, argDrawerStatus);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDrawerStatus_noev(String argDrawerStatus) {
/*  208 */     boolean ev_postable = false;
/*      */     
/*  210 */     if ((getDAO_().getDrawerStatus() == null && argDrawerStatus != null) || (
/*  211 */       getDAO_().getDrawerStatus() != null && !getDAO_().getDrawerStatus().equals(argDrawerStatus))) {
/*  212 */       getDAO_().setDrawerStatus(argDrawerStatus);
/*  213 */       ev_postable = true;
/*      */     } 
/*      */     
/*  216 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getProductName() {
/*  224 */     return getDAO_().getProductName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setProductName(String argProductName) {
/*  232 */     if (setProductName_noev(argProductName) && 
/*  233 */       this._events != null && 
/*  234 */       postEventsForChanges()) {
/*  235 */       this._events.post(IIpCashDrawerDevice.SET_PRODUCTNAME, argProductName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setProductName_noev(String argProductName) {
/*  242 */     boolean ev_postable = false;
/*      */     
/*  244 */     if ((getDAO_().getProductName() == null && argProductName != null) || (
/*  245 */       getDAO_().getProductName() != null && !getDAO_().getProductName().equals(argProductName))) {
/*  246 */       getDAO_().setProductName(argProductName);
/*  247 */       ev_postable = true;
/*      */     } 
/*      */     
/*  250 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDescription() {
/*  258 */     return getDAO_().getDescription();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDescription(String argDescription) {
/*  266 */     if (setDescription_noev(argDescription) && 
/*  267 */       this._events != null && 
/*  268 */       postEventsForChanges()) {
/*  269 */       this._events.post(IIpCashDrawerDevice.SET_DESCRIPTION, argDescription);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDescription_noev(String argDescription) {
/*  276 */     boolean ev_postable = false;
/*      */     
/*  278 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/*  279 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/*  280 */       getDAO_().setDescription(argDescription);
/*  281 */       ev_postable = true;
/*      */     } 
/*      */     
/*  284 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSerialNumber() {
/*  292 */     return getDAO_().getSerialNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSerialNumber(String argSerialNumber) {
/*  300 */     if (setSerialNumber_noev(argSerialNumber) && 
/*  301 */       this._events != null && 
/*  302 */       postEventsForChanges()) {
/*  303 */       this._events.post(IIpCashDrawerDevice.SET_SERIALNUMBER, argSerialNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSerialNumber_noev(String argSerialNumber) {
/*  310 */     boolean ev_postable = false;
/*      */     
/*  312 */     if ((getDAO_().getSerialNumber() == null && argSerialNumber != null) || (
/*  313 */       getDAO_().getSerialNumber() != null && !getDAO_().getSerialNumber().equals(argSerialNumber))) {
/*  314 */       getDAO_().setSerialNumber(argSerialNumber);
/*  315 */       ev_postable = true;
/*      */     } 
/*      */     
/*  318 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getIpAddress() {
/*  326 */     return getDAO_().getIpAddress();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIpAddress(String argIpAddress) {
/*  334 */     if (setIpAddress_noev(argIpAddress) && 
/*  335 */       this._events != null && 
/*  336 */       postEventsForChanges()) {
/*  337 */       this._events.post(IIpCashDrawerDevice.SET_IPADDRESS, argIpAddress);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setIpAddress_noev(String argIpAddress) {
/*  344 */     boolean ev_postable = false;
/*      */     
/*  346 */     if ((getDAO_().getIpAddress() == null && argIpAddress != null) || (
/*  347 */       getDAO_().getIpAddress() != null && !getDAO_().getIpAddress().equals(argIpAddress))) {
/*  348 */       getDAO_().setIpAddress(argIpAddress);
/*  349 */       ev_postable = true;
/*      */     } 
/*      */     
/*  352 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTcpPort() {
/*  360 */     if (getDAO_().getTcpPort() != null) {
/*  361 */       return getDAO_().getTcpPort().longValue();
/*      */     }
/*      */     
/*  364 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTcpPort(long argTcpPort) {
/*  373 */     if (setTcpPort_noev(argTcpPort) && 
/*  374 */       this._events != null && 
/*  375 */       postEventsForChanges()) {
/*  376 */       this._events.post(IIpCashDrawerDevice.SET_TCPPORT, Long.valueOf(argTcpPort));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTcpPort_noev(long argTcpPort) {
/*  383 */     boolean ev_postable = false;
/*      */     
/*  385 */     if ((getDAO_().getTcpPort() == null && Long.valueOf(argTcpPort) != null) || (
/*  386 */       getDAO_().getTcpPort() != null && !getDAO_().getTcpPort().equals(Long.valueOf(argTcpPort)))) {
/*  387 */       getDAO_().setTcpPort(Long.valueOf(argTcpPort));
/*  388 */       ev_postable = true;
/*      */     } 
/*      */     
/*  391 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getMacAddress() {
/*  399 */     return getDAO_().getMacAddress();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMacAddress(String argMacAddress) {
/*  407 */     if (setMacAddress_noev(argMacAddress) && 
/*  408 */       this._events != null && 
/*  409 */       postEventsForChanges()) {
/*  410 */       this._events.post(IIpCashDrawerDevice.SET_MACADDRESS, argMacAddress);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMacAddress_noev(String argMacAddress) {
/*  417 */     boolean ev_postable = false;
/*      */     
/*  419 */     if ((getDAO_().getMacAddress() == null && argMacAddress != null) || (
/*  420 */       getDAO_().getMacAddress() != null && !getDAO_().getMacAddress().equals(argMacAddress))) {
/*  421 */       getDAO_().setMacAddress(argMacAddress);
/*  422 */       ev_postable = true;
/*      */     } 
/*      */     
/*  425 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSubnetMask() {
/*  433 */     return getDAO_().getSubnetMask();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSubnetMask(String argSubnetMask) {
/*  441 */     if (setSubnetMask_noev(argSubnetMask) && 
/*  442 */       this._events != null && 
/*  443 */       postEventsForChanges()) {
/*  444 */       this._events.post(IIpCashDrawerDevice.SET_SUBNETMASK, argSubnetMask);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSubnetMask_noev(String argSubnetMask) {
/*  451 */     boolean ev_postable = false;
/*      */     
/*  453 */     if ((getDAO_().getSubnetMask() == null && argSubnetMask != null) || (
/*  454 */       getDAO_().getSubnetMask() != null && !getDAO_().getSubnetMask().equals(argSubnetMask))) {
/*  455 */       getDAO_().setSubnetMask(argSubnetMask);
/*  456 */       ev_postable = true;
/*      */     } 
/*      */     
/*  459 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getGateway() {
/*  467 */     return getDAO_().getGateway();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGateway(String argGateway) {
/*  475 */     if (setGateway_noev(argGateway) && 
/*  476 */       this._events != null && 
/*  477 */       postEventsForChanges()) {
/*  478 */       this._events.post(IIpCashDrawerDevice.SET_GATEWAY, argGateway);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setGateway_noev(String argGateway) {
/*  485 */     boolean ev_postable = false;
/*      */     
/*  487 */     if ((getDAO_().getGateway() == null && argGateway != null) || (
/*  488 */       getDAO_().getGateway() != null && !getDAO_().getGateway().equals(argGateway))) {
/*  489 */       getDAO_().setGateway(argGateway);
/*  490 */       ev_postable = true;
/*      */     } 
/*      */     
/*  493 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDnsHostName() {
/*  501 */     return getDAO_().getDnsHostName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDnsHostName(String argDnsHostName) {
/*  509 */     if (setDnsHostName_noev(argDnsHostName) && 
/*  510 */       this._events != null && 
/*  511 */       postEventsForChanges()) {
/*  512 */       this._events.post(IIpCashDrawerDevice.SET_DNSHOSTNAME, argDnsHostName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDnsHostName_noev(String argDnsHostName) {
/*  519 */     boolean ev_postable = false;
/*      */     
/*  521 */     if ((getDAO_().getDnsHostName() == null && argDnsHostName != null) || (
/*  522 */       getDAO_().getDnsHostName() != null && !getDAO_().getDnsHostName().equals(argDnsHostName))) {
/*  523 */       getDAO_().setDnsHostName(argDnsHostName);
/*  524 */       ev_postable = true;
/*      */     } 
/*      */     
/*  527 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDhcp() {
/*  535 */     if (getDAO_().getDhcp() != null) {
/*  536 */       return getDAO_().getDhcp().booleanValue();
/*      */     }
/*      */     
/*  539 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDhcp(boolean argDhcp) {
/*  548 */     if (setDhcp_noev(argDhcp) && 
/*  549 */       this._events != null && 
/*  550 */       postEventsForChanges()) {
/*  551 */       this._events.post(IIpCashDrawerDevice.SET_DHCP, Boolean.valueOf(argDhcp));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDhcp_noev(boolean argDhcp) {
/*  558 */     boolean ev_postable = false;
/*      */     
/*  560 */     if ((getDAO_().getDhcp() == null && Boolean.valueOf(argDhcp) != null) || (
/*  561 */       getDAO_().getDhcp() != null && !getDAO_().getDhcp().equals(Boolean.valueOf(argDhcp)))) {
/*  562 */       getDAO_().setDhcp(Boolean.valueOf(argDhcp));
/*  563 */       ev_postable = true;
/*      */     } 
/*      */     
/*  566 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFirmwareVersion() {
/*  574 */     return getDAO_().getFirmwareVersion();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFirmwareVersion(String argFirmwareVersion) {
/*  582 */     if (setFirmwareVersion_noev(argFirmwareVersion) && 
/*  583 */       this._events != null && 
/*  584 */       postEventsForChanges()) {
/*  585 */       this._events.post(IIpCashDrawerDevice.SET_FIRMWAREVERSION, argFirmwareVersion);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFirmwareVersion_noev(String argFirmwareVersion) {
/*  592 */     boolean ev_postable = false;
/*      */     
/*  594 */     if ((getDAO_().getFirmwareVersion() == null && argFirmwareVersion != null) || (
/*  595 */       getDAO_().getFirmwareVersion() != null && !getDAO_().getFirmwareVersion().equals(argFirmwareVersion))) {
/*  596 */       getDAO_().setFirmwareVersion(argFirmwareVersion);
/*  597 */       ev_postable = true;
/*      */     } 
/*      */     
/*  600 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getKup() {
/*  608 */     return getDAO_().getKup();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setKup(String argKup) {
/*  616 */     if (setKup_noev(argKup) && 
/*  617 */       this._events != null && 
/*  618 */       postEventsForChanges()) {
/*  619 */       this._events.post(IIpCashDrawerDevice.SET_KUP, argKup);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setKup_noev(String argKup) {
/*  626 */     boolean ev_postable = false;
/*      */     
/*  628 */     if ((getDAO_().getKup() == null && argKup != null) || (
/*  629 */       getDAO_().getKup() != null && !getDAO_().getKup().equals(argKup))) {
/*  630 */       getDAO_().setKup(argKup);
/*  631 */       ev_postable = true;
/*      */     } 
/*      */     
/*  634 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getKupUpdateDate() {
/*  642 */     return getDAO_().getKupUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setKupUpdateDate(Date argKupUpdateDate) {
/*  650 */     if (setKupUpdateDate_noev(argKupUpdateDate) && 
/*  651 */       this._events != null && 
/*  652 */       postEventsForChanges()) {
/*  653 */       this._events.post(IIpCashDrawerDevice.SET_KUPUPDATEDATE, argKupUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setKupUpdateDate_noev(Date argKupUpdateDate) {
/*  660 */     boolean ev_postable = false;
/*      */     
/*  662 */     if ((getDAO_().getKupUpdateDate() == null && argKupUpdateDate != null) || (
/*  663 */       getDAO_().getKupUpdateDate() != null && !getDAO_().getKupUpdateDate().equals(argKupUpdateDate))) {
/*  664 */       getDAO_().setKupUpdateDate(argKupUpdateDate);
/*  665 */       ev_postable = true;
/*      */     } 
/*      */     
/*  668 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getBeepOnOpen() {
/*  676 */     if (getDAO_().getBeepOnOpen() != null) {
/*  677 */       return getDAO_().getBeepOnOpen().booleanValue();
/*      */     }
/*      */     
/*  680 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBeepOnOpen(boolean argBeepOnOpen) {
/*  689 */     if (setBeepOnOpen_noev(argBeepOnOpen) && 
/*  690 */       this._events != null && 
/*  691 */       postEventsForChanges()) {
/*  692 */       this._events.post(IIpCashDrawerDevice.SET_BEEPONOPEN, Boolean.valueOf(argBeepOnOpen));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBeepOnOpen_noev(boolean argBeepOnOpen) {
/*  699 */     boolean ev_postable = false;
/*      */     
/*  701 */     if ((getDAO_().getBeepOnOpen() == null && Boolean.valueOf(argBeepOnOpen) != null) || (
/*  702 */       getDAO_().getBeepOnOpen() != null && !getDAO_().getBeepOnOpen().equals(Boolean.valueOf(argBeepOnOpen)))) {
/*  703 */       getDAO_().setBeepOnOpen(Boolean.valueOf(argBeepOnOpen));
/*  704 */       ev_postable = true;
/*      */     } 
/*      */     
/*  707 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getBeepLongOpen() {
/*  715 */     if (getDAO_().getBeepLongOpen() != null) {
/*  716 */       return getDAO_().getBeepLongOpen().booleanValue();
/*      */     }
/*      */     
/*  719 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBeepLongOpen(boolean argBeepLongOpen) {
/*  728 */     if (setBeepLongOpen_noev(argBeepLongOpen) && 
/*  729 */       this._events != null && 
/*  730 */       postEventsForChanges()) {
/*  731 */       this._events.post(IIpCashDrawerDevice.SET_BEEPLONGOPEN, Boolean.valueOf(argBeepLongOpen));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBeepLongOpen_noev(boolean argBeepLongOpen) {
/*  738 */     boolean ev_postable = false;
/*      */     
/*  740 */     if ((getDAO_().getBeepLongOpen() == null && Boolean.valueOf(argBeepLongOpen) != null) || (
/*  741 */       getDAO_().getBeepLongOpen() != null && !getDAO_().getBeepLongOpen().equals(Boolean.valueOf(argBeepLongOpen)))) {
/*  742 */       getDAO_().setBeepLongOpen(Boolean.valueOf(argBeepLongOpen));
/*  743 */       ev_postable = true;
/*      */     } 
/*      */     
/*  746 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  754 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  762 */     if (setCreateDate_noev(argCreateDate) && 
/*  763 */       this._events != null && 
/*  764 */       postEventsForChanges()) {
/*  765 */       this._events.post(IIpCashDrawerDevice.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  772 */     boolean ev_postable = false;
/*      */     
/*  774 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  775 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  776 */       getDAO_().setCreateDate(argCreateDate);
/*  777 */       ev_postable = true;
/*      */     } 
/*      */     
/*  780 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  788 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  796 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  797 */       this._events != null && 
/*  798 */       postEventsForChanges()) {
/*  799 */       this._events.post(IIpCashDrawerDevice.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  806 */     boolean ev_postable = false;
/*      */     
/*  808 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  809 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  810 */       getDAO_().setCreateUserId(argCreateUserId);
/*  811 */       ev_postable = true;
/*      */     } 
/*      */     
/*  814 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  822 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  830 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  831 */       this._events != null && 
/*  832 */       postEventsForChanges()) {
/*  833 */       this._events.post(IIpCashDrawerDevice.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  840 */     boolean ev_postable = false;
/*      */     
/*  842 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  843 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  844 */       getDAO_().setUpdateDate(argUpdateDate);
/*  845 */       ev_postable = true;
/*      */     } 
/*      */     
/*  848 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  856 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  864 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  865 */       this._events != null && 
/*  866 */       postEventsForChanges()) {
/*  867 */       this._events.post(IIpCashDrawerDevice.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  874 */     boolean ev_postable = false;
/*      */     
/*  876 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  877 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  878 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  879 */       ev_postable = true;
/*      */     } 
/*      */     
/*  882 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IIpCashDrawerDeviceProperty newProperty(String argPropertyName) {
/*  886 */     IpCashDrawerDevicePropertyId id = new IpCashDrawerDevicePropertyId();
/*      */     
/*  888 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  889 */     id.setCashDrawerId(getCashDrawerId());
/*  890 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  892 */     IIpCashDrawerDeviceProperty prop = (IIpCashDrawerDeviceProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IIpCashDrawerDeviceProperty.class);
/*  893 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IIpCashDrawerDeviceProperty> getProperties() {
/*  902 */     if (this._properties == null) {
/*  903 */       this._properties = new HistoricalList(null);
/*      */     }
/*  905 */     return (List<IIpCashDrawerDeviceProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IIpCashDrawerDeviceProperty> argProperties) {
/*  909 */     if (this._properties == null) {
/*  910 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  912 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  915 */     for (IIpCashDrawerDeviceProperty child : this._properties) {
/*  916 */       IpCashDrawerDevicePropertyModel model = (IpCashDrawerDevicePropertyModel)child;
/*  917 */       model.setOrganizationId_noev(getOrganizationId());
/*  918 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  919 */       model.setCashDrawerId_noev(getCashDrawerId());
/*  920 */       if (child instanceof IDataModelImpl) {
/*  921 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  922 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  923 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  924 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  927 */       if (postEventsForChanges()) {
/*  928 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addIpCashDrawerDeviceProperty(IIpCashDrawerDeviceProperty argIpCashDrawerDeviceProperty) {
/*  934 */     if (this._properties == null) {
/*  935 */       this._properties = new HistoricalList(null);
/*      */     }
/*  937 */     argIpCashDrawerDeviceProperty.setOrganizationId(getOrganizationId());
/*  938 */     argIpCashDrawerDeviceProperty.setRetailLocationId(getRetailLocationId());
/*  939 */     argIpCashDrawerDeviceProperty.setCashDrawerId(getCashDrawerId());
/*  940 */     if (argIpCashDrawerDeviceProperty instanceof IDataModelImpl) {
/*  941 */       IDataAccessObject childDao = ((IDataModelImpl)argIpCashDrawerDeviceProperty).getDAO();
/*  942 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  943 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  944 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  949 */     if (postEventsForChanges()) {
/*  950 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argIpCashDrawerDeviceProperty));
/*      */     }
/*      */     
/*  953 */     this._properties.add(argIpCashDrawerDeviceProperty);
/*  954 */     if (postEventsForChanges()) {
/*  955 */       this._events.post(IIpCashDrawerDevice.ADD_PROPERTIES, argIpCashDrawerDeviceProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeIpCashDrawerDeviceProperty(IIpCashDrawerDeviceProperty argIpCashDrawerDeviceProperty) {
/*  960 */     if (this._properties != null) {
/*      */       
/*  962 */       if (postEventsForChanges()) {
/*  963 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argIpCashDrawerDeviceProperty));
/*      */       }
/*  965 */       this._properties.remove(argIpCashDrawerDeviceProperty);
/*  966 */       if (postEventsForChanges()) {
/*  967 */         this._events.post(IIpCashDrawerDevice.REMOVE_PROPERTIES, argIpCashDrawerDeviceProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  974 */     if ("Properties".equals(argFieldId)) {
/*  975 */       return getProperties();
/*      */     }
/*  977 */     if ("IpCashDrawerDeviceExtension".equals(argFieldId)) {
/*  978 */       return this._myExtension;
/*      */     }
/*      */     
/*  981 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  987 */     if ("Properties".equals(argFieldId)) {
/*  988 */       setProperties(changeToList(argValue, IIpCashDrawerDeviceProperty.class));
/*      */     }
/*  990 */     else if ("IpCashDrawerDeviceExtension".equals(argFieldId)) {
/*  991 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  994 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1000 */     this._persistenceDefaults = argPD;
/* 1001 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1002 */     this._eventManager = argEM;
/* 1003 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1004 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1005 */     if (this._properties != null) {
/* 1006 */       for (IIpCashDrawerDeviceProperty relationship : this._properties) {
/* 1007 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getIpCashDrawerDeviceExt() {
/* 1013 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setIpCashDrawerDeviceExt(IDataModel argExt) {
/* 1017 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1022 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1026 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1029 */     super.startTransaction();
/*      */     
/* 1031 */     this._propertiesSavepoint = this._properties;
/* 1032 */     if (this._properties != null) {
/* 1033 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1034 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1035 */       while (it.hasNext()) {
/* 1036 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1041 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1046 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1049 */     super.rollbackChanges();
/*      */     
/* 1051 */     this._properties = this._propertiesSavepoint;
/* 1052 */     this._propertiesSavepoint = null;
/* 1053 */     if (this._properties != null) {
/* 1054 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1055 */       while (it.hasNext()) {
/* 1056 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1064 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1067 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1070 */     super.commitTransaction();
/*      */     
/* 1072 */     this._propertiesSavepoint = this._properties;
/* 1073 */     if (this._properties != null) {
/* 1074 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1075 */       while (it.hasNext()) {
/* 1076 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1078 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1082 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1087 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\IpCashDrawerDeviceModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */