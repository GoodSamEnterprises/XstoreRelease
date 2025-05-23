/*     */ package dtv.xst.dao.ctl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ctl.IpCashDrawerDeviceId;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IpCashDrawerDeviceDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1578154783L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _cashDrawerId;
/*     */   private String _drawerStatus;
/*     */   private String _productName;
/*     */   private String _description;
/*     */   private String _serialNumber;
/*     */   private String _ipAddress;
/*     */   private Long _tcpPort;
/*     */   private String _macAddress;
/*     */   private String _subnetMask;
/*     */   private String _gateway;
/*     */   private String _dnsHostName;
/*     */   private Boolean _dhcp;
/*     */   private String _firmwareVersion;
/*     */   private String _kup;
/*     */   private Date _kupUpdateDate;
/*     */   private Boolean _beepOnOpen;
/*     */   private Boolean _beepLongOpen;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.cash_drawer_id, t.drawer_status, t.product_name, t.description, t.serial_number, t.ip_address, t.tcp_port, t.mac_address, t.subnet_mask, t.gateway, t.dns_hostname, t.dhcp_flag, t.firmware_version, t.kup, t.kup_update_date, t.beep_on_open_flag, t.beep_long_open_flag, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM ctl_ip_cashdrawer_device t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND cash_drawer_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  52 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  56 */     return "SELECT t.organization_id, t.rtl_loc_id, t.cash_drawer_id, t.drawer_status, t.product_name, t.description, t.serial_number, t.ip_address, t.tcp_port, t.mac_address, t.subnet_mask, t.gateway, t.dns_hostname, t.dhcp_flag, t.firmware_version, t.kup, t.kup_update_date, t.beep_on_open_flag, t.beep_long_open_flag, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM ctl_ip_cashdrawer_device t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  62 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND cash_drawer_id = ?  ";
/*     */   }
/*     */   
/*  65 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ctl_ip_cashdrawer_device(organization_id, rtl_loc_id, cash_drawer_id, drawer_status, product_name, description, serial_number, ip_address, tcp_port, mac_address, subnet_mask, gateway, dns_hostname, dhcp_flag, firmware_version, kup, kup_update_date, beep_on_open_flag, beep_long_open_flag, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  68 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  72 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._cashDrawerId, this._drawerStatus, this._productName, this._description, this._serialNumber, this._ipAddress, this._tcpPort, this._macAddress, this._subnetMask, this._gateway, this._dnsHostName, this._dhcp, this._firmwareVersion, this._kup, this._kupUpdateDate, this._beepOnOpen, this._beepLongOpen, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  73 */     return insertParameterObject;
/*     */   }
/*     */   
/*  76 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 12, 12, 12, 12, -5, 12, 12, 12, 12, -7, 12, 12, 91, -7, -7, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  79 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  82 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ctl_ip_cashdrawer_device SET drawer_status = ?, product_name = ?, description = ?, serial_number = ?, ip_address = ?, tcp_port = ?, mac_address = ?, subnet_mask = ?, gateway = ?, dns_hostname = ?, dhcp_flag = ?, firmware_version = ?, kup = ?, kup_update_date = ?, beep_on_open_flag = ?, beep_long_open_flag = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  85 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  89 */     Object[][] updateParameterObject = { { this._drawerStatus, this._productName, this._description, this._serialNumber, this._ipAddress, this._tcpPort, this._macAddress, this._subnetMask, this._gateway, this._dnsHostName, this._dhcp, this._firmwareVersion, this._kup, this._kupUpdateDate, this._beepOnOpen, this._beepLongOpen, this._updateDate, this._updateUserId } };
/*  90 */     return updateParameterObject;
/*     */   }
/*     */   
/*  93 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 12, 12, 12, -5, 12, 12, 12, 12, -7, 12, 12, 91, -7, -7, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  95 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  98 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ctl_ip_cashdrawer_device" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND cash_drawer_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 101 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 107 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND cash_drawer_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 110 */     return new Object[] { this._organizationId, this._retailLocationId, this._cashDrawerId };
/*     */   }
/*     */   
/* 113 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 116 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 119 */     return "ctl_ip_cashdrawer_device";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 123 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 127 */     return new IpCashDrawerDeviceFiller(this);
/*     */   }
/*     */   
/*     */   private static class IpCashDrawerDeviceFiller
/*     */     implements IFiller {
/*     */     private IpCashDrawerDeviceDBA _parent;
/*     */     
/*     */     public IpCashDrawerDeviceFiller(IpCashDrawerDeviceDBA argParent) {
/* 135 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 140 */       long primitiveResult = argResultSet.getLong(1);
/* 141 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 142 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 148 */       primitiveResult = argResultSet.getLong(2);
/* 149 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 150 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 154 */       this._parent._cashDrawerId = argResultSet.getString(3);
/* 155 */       this._parent._drawerStatus = argResultSet.getString(4);
/* 156 */       this._parent._productName = argResultSet.getString(5);
/* 157 */       this._parent._description = argResultSet.getString(6);
/* 158 */       this._parent._serialNumber = argResultSet.getString(7);
/* 159 */       this._parent._ipAddress = argResultSet.getString(8);
/*     */ 
/*     */       
/* 162 */       primitiveResult = argResultSet.getLong(9);
/* 163 */       if (primitiveResult != 0L || argResultSet.getObject(9) != null) {
/* 164 */         this._parent._tcpPort = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 168 */       this._parent._macAddress = argResultSet.getString(10);
/* 169 */       this._parent._subnetMask = argResultSet.getString(11);
/* 170 */       this._parent._gateway = argResultSet.getString(12);
/* 171 */       this._parent._dnsHostName = argResultSet.getString(13);
/* 172 */       this._parent._dhcp = Boolean.valueOf(argResultSet.getBoolean(14));
/* 173 */       this._parent._firmwareVersion = argResultSet.getString(15);
/* 174 */       this._parent._kup = argResultSet.getString(16);
/*     */       
/* 176 */       Timestamp t17 = argResultSet.getTimestamp(17);
/* 177 */       if (t17 != null) {
/* 178 */         this._parent._kupUpdateDate = (Date)new DtvDate(t17.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._kupUpdateDate = null;
/*     */       } 
/*     */       
/* 184 */       this._parent._beepOnOpen = Boolean.valueOf(argResultSet.getBoolean(18));
/* 185 */       this._parent._beepLongOpen = Boolean.valueOf(argResultSet.getBoolean(19));
/*     */       
/* 187 */       Timestamp t20 = argResultSet.getTimestamp(20);
/* 188 */       if (t20 != null) {
/* 189 */         this._parent._createDate = (Date)new DtvDate(t20.getTime());
/*     */       } else {
/*     */         
/* 192 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 195 */       this._parent._createUserId = argResultSet.getString(21);
/*     */       
/* 197 */       Timestamp t22 = argResultSet.getTimestamp(22);
/* 198 */       if (t22 != null) {
/* 199 */         this._parent._updateDate = (Date)new DtvDate(t22.getTime());
/*     */       } else {
/*     */         
/* 202 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 205 */       this._parent._updateUserId = argResultSet.getString(23);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 210 */     argDAO.suppressStateChanges(true);
/* 211 */     IpCashDrawerDeviceDAO dao = (IpCashDrawerDeviceDAO)argDAO;
/* 212 */     dao.setOrganizationId(this._organizationId);
/* 213 */     dao.setRetailLocationId(this._retailLocationId);
/* 214 */     dao.setCashDrawerId(this._cashDrawerId);
/* 215 */     dao.setDrawerStatus(this._drawerStatus);
/* 216 */     dao.setProductName(this._productName);
/* 217 */     dao.setDescription(this._description);
/* 218 */     dao.setSerialNumber(this._serialNumber);
/* 219 */     dao.setIpAddress(this._ipAddress);
/* 220 */     dao.setTcpPort(this._tcpPort);
/* 221 */     dao.setMacAddress(this._macAddress);
/* 222 */     dao.setSubnetMask(this._subnetMask);
/* 223 */     dao.setGateway(this._gateway);
/* 224 */     dao.setDnsHostName(this._dnsHostName);
/* 225 */     dao.setDhcp(this._dhcp);
/* 226 */     dao.setFirmwareVersion(this._firmwareVersion);
/* 227 */     dao.setKup(this._kup);
/* 228 */     dao.setKupUpdateDate(this._kupUpdateDate);
/* 229 */     dao.setBeepOnOpen(this._beepOnOpen);
/* 230 */     dao.setBeepLongOpen(this._beepLongOpen);
/* 231 */     dao.setCreateDate(this._createDate);
/* 232 */     dao.setCreateUserId(this._createUserId);
/* 233 */     dao.setUpdateDate(this._updateDate);
/* 234 */     dao.setUpdateUserId(this._updateUserId);
/* 235 */     argDAO.suppressStateChanges(false);
/* 236 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 240 */     return loadDAO((IDataAccessObject)new IpCashDrawerDeviceDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 244 */     IpCashDrawerDeviceDAO dao = (IpCashDrawerDeviceDAO)argDAO;
/* 245 */     this._organizationId = dao.getOrganizationId();
/* 246 */     this._retailLocationId = dao.getRetailLocationId();
/* 247 */     this._cashDrawerId = dao.getCashDrawerId();
/* 248 */     this._drawerStatus = dao.getDrawerStatus();
/* 249 */     this._productName = dao.getProductName();
/* 250 */     this._description = dao.getDescription();
/* 251 */     this._serialNumber = dao.getSerialNumber();
/* 252 */     this._ipAddress = dao.getIpAddress();
/* 253 */     this._tcpPort = dao.getTcpPort();
/* 254 */     this._macAddress = dao.getMacAddress();
/* 255 */     this._subnetMask = dao.getSubnetMask();
/* 256 */     this._gateway = dao.getGateway();
/* 257 */     this._dnsHostName = dao.getDnsHostName();
/* 258 */     this._dhcp = (dao.getDhcp() != null) ? dao.getDhcp() : Boolean.valueOf(false);
/* 259 */     this._firmwareVersion = dao.getFirmwareVersion();
/* 260 */     this._kup = dao.getKup();
/* 261 */     this._kupUpdateDate = dao.getKupUpdateDate();
/* 262 */     this._beepOnOpen = (dao.getBeepOnOpen() != null) ? dao.getBeepOnOpen() : Boolean.valueOf(false);
/* 263 */     this._beepLongOpen = (dao.getBeepLongOpen() != null) ? dao.getBeepLongOpen() : Boolean.valueOf(false);
/* 264 */     this._createDate = dao.getCreateDate();
/* 265 */     this._createUserId = dao.getCreateUserId();
/* 266 */     this._updateDate = dao.getUpdateDate();
/* 267 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 271 */     IpCashDrawerDeviceId id = (IpCashDrawerDeviceId)argId;
/* 272 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 273 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 274 */     argStatement.setString(3, id.getCashDrawerId());
/* 275 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 279 */     IpCashDrawerDeviceId id = new IpCashDrawerDeviceId();
/* 280 */     id.setOrganizationId(this._organizationId);
/* 281 */     id.setRetailLocationId(this._retailLocationId);
/* 282 */     id.setCashDrawerId(this._cashDrawerId);
/* 283 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 291 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 295 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\IpCashDrawerDeviceDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */