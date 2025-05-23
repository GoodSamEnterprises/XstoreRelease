/*     */ package dtv.xst.dao.ctl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ctl.DeviceRegistrationId;
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
/*     */ public class DeviceRegistrationDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 163923535L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _ipAddress;
/*     */   private Date _dateTimestamp;
/*     */   private Date _businessDate;
/*     */   private String _xtoreVersion;
/*     */   private String _envVersion;
/*     */   private Boolean _activeFlag;
/*     */   private String _configVersion;
/*     */   private Boolean _primaryRegister;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.ip_address, t.date_timestamp, t.business_date, t.xstore_version, t.env_version, t.active_flag, t.config_version, t.primary_register_flag FROM ctl_device_registration t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.ip_address, t.date_timestamp, t.business_date, t.xstore_version, t.env_version, t.active_flag, t.config_version, t.primary_register_flag FROM ctl_device_registration t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ctl_device_registration(organization_id, rtl_loc_id, wkstn_id, create_date, create_user_id, update_date, update_user_id, ip_address, date_timestamp, business_date, xstore_version, env_version, active_flag, config_version, primary_register_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._ipAddress, this._dateTimestamp, this._businessDate, this._xtoreVersion, this._envVersion, this._activeFlag, this._configVersion, this._primaryRegister } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 91, 12, 91, 12, 12, 91, 91, 12, 12, -7, 12, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ctl_device_registration SET update_date = ?, update_user_id = ?, ip_address = ?, date_timestamp = ?, business_date = ?, xstore_version = ?, env_version = ?, active_flag = ?, config_version = ?, primary_register_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._ipAddress, this._dateTimestamp, this._businessDate, this._xtoreVersion, this._envVersion, this._activeFlag, this._configVersion, this._primaryRegister } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 91, 91, 12, 12, -7, 12, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ctl_device_registration" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._retailLocationId, this._workstationId };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "ctl_device_registration";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new DeviceRegistrationFiller(this);
/*     */   }
/*     */   
/*     */   private static class DeviceRegistrationFiller
/*     */     implements IFiller {
/*     */     private DeviceRegistrationDBA _parent;
/*     */     
/*     */     public DeviceRegistrationFiller(DeviceRegistrationDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 132 */       long primitiveResult = argResultSet.getLong(1);
/* 133 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 134 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 140 */       primitiveResult = argResultSet.getLong(2);
/* 141 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 142 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 148 */       primitiveResult = argResultSet.getLong(3);
/* 149 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 150 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 155 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 156 */       if (t4 != null) {
/* 157 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 165 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 166 */       if (t6 != null) {
/* 167 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._updateUserId = argResultSet.getString(7);
/* 174 */       this._parent._ipAddress = argResultSet.getString(8);
/*     */       
/* 176 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 177 */       if (t9 != null) {
/* 178 */         this._parent._dateTimestamp = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._dateTimestamp = null;
/*     */       } 
/*     */ 
/*     */       
/* 185 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 186 */       if (t10 != null) {
/* 187 */         this._parent._businessDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 190 */         this._parent._businessDate = null;
/*     */       } 
/*     */       
/* 193 */       this._parent._xtoreVersion = argResultSet.getString(11);
/* 194 */       this._parent._envVersion = argResultSet.getString(12);
/* 195 */       this._parent._activeFlag = Boolean.valueOf(argResultSet.getBoolean(13));
/* 196 */       this._parent._configVersion = argResultSet.getString(14);
/* 197 */       this._parent._primaryRegister = Boolean.valueOf(argResultSet.getBoolean(15));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 202 */     argDAO.suppressStateChanges(true);
/* 203 */     DeviceRegistrationDAO dao = (DeviceRegistrationDAO)argDAO;
/* 204 */     dao.setOrganizationId(this._organizationId);
/* 205 */     dao.setRetailLocationId(this._retailLocationId);
/* 206 */     dao.setWorkstationId(this._workstationId);
/* 207 */     dao.setCreateDate(this._createDate);
/* 208 */     dao.setCreateUserId(this._createUserId);
/* 209 */     dao.setUpdateDate(this._updateDate);
/* 210 */     dao.setUpdateUserId(this._updateUserId);
/* 211 */     dao.setIpAddress(this._ipAddress);
/* 212 */     dao.setDateTimestamp(this._dateTimestamp);
/* 213 */     dao.setBusinessDate(this._businessDate);
/* 214 */     dao.setXtoreVersion(this._xtoreVersion);
/* 215 */     dao.setEnvVersion(this._envVersion);
/* 216 */     dao.setActiveFlag(this._activeFlag);
/* 217 */     dao.setConfigVersion(this._configVersion);
/* 218 */     dao.setPrimaryRegister(this._primaryRegister);
/* 219 */     argDAO.suppressStateChanges(false);
/* 220 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 224 */     return loadDAO((IDataAccessObject)new DeviceRegistrationDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 228 */     DeviceRegistrationDAO dao = (DeviceRegistrationDAO)argDAO;
/* 229 */     this._organizationId = dao.getOrganizationId();
/* 230 */     this._retailLocationId = dao.getRetailLocationId();
/* 231 */     this._workstationId = dao.getWorkstationId();
/* 232 */     this._createDate = dao.getCreateDate();
/* 233 */     this._createUserId = dao.getCreateUserId();
/* 234 */     this._updateDate = dao.getUpdateDate();
/* 235 */     this._updateUserId = dao.getUpdateUserId();
/* 236 */     this._ipAddress = dao.getIpAddress();
/* 237 */     this._dateTimestamp = dao.getDateTimestamp();
/* 238 */     this._businessDate = dao.getBusinessDate();
/* 239 */     this._xtoreVersion = dao.getXtoreVersion();
/* 240 */     this._envVersion = dao.getEnvVersion();
/* 241 */     this._activeFlag = (dao.getActiveFlag() != null) ? dao.getActiveFlag() : Boolean.valueOf(false);
/* 242 */     this._configVersion = dao.getConfigVersion();
/* 243 */     this._primaryRegister = (dao.getPrimaryRegister() != null) ? dao.getPrimaryRegister() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 247 */     DeviceRegistrationId id = (DeviceRegistrationId)argId;
/* 248 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 249 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 250 */     argStatement.setLong(3, id.getWorkstationId().longValue());
/* 251 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 255 */     DeviceRegistrationId id = new DeviceRegistrationId();
/* 256 */     id.setOrganizationId(this._organizationId);
/* 257 */     id.setRetailLocationId(this._retailLocationId);
/* 258 */     id.setWorkstationId(this._workstationId);
/* 259 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 267 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 271 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\DeviceRegistrationDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */