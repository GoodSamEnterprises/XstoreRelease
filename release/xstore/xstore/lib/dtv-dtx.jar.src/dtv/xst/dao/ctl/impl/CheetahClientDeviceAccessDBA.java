/*     */ package dtv.xst.dao.ctl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ctl.CheetahClientDeviceAccessId;
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
/*     */ public class CheetahClientDeviceAccessDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1641526533L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _token;
/*     */   private Long _workstationId;
/*     */   private String _status;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.token, t.wkstn_id, t.status, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM ctl_cheetah_device_access t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND token = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  38 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  42 */     return "SELECT t.organization_id, t.rtl_loc_id, t.token, t.wkstn_id, t.status, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM ctl_cheetah_device_access t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  48 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND token = ?  ";
/*     */   }
/*     */   
/*  51 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ctl_cheetah_device_access(organization_id, rtl_loc_id, token, wkstn_id, status, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  54 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  58 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._token, this._workstationId, this._status, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  59 */     return insertParameterObject;
/*     */   }
/*     */   
/*  62 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, -5, 12, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  65 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  68 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ctl_cheetah_device_access SET wkstn_id = ?, status = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  71 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  75 */     Object[][] updateParameterObject = { { this._workstationId, this._status, this._updateDate, this._updateUserId } };
/*  76 */     return updateParameterObject;
/*     */   }
/*     */   
/*  79 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { -5, 12, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  81 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  84 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ctl_cheetah_device_access" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND token = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  87 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  93 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND token = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  96 */     return new Object[] { this._organizationId, this._retailLocationId, this._token };
/*     */   }
/*     */   
/*  99 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 102 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 105 */     return "ctl_cheetah_device_access";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 109 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 113 */     return new CheetahClientDeviceAccessFiller(this);
/*     */   }
/*     */   
/*     */   private static class CheetahClientDeviceAccessFiller
/*     */     implements IFiller {
/*     */     private CheetahClientDeviceAccessDBA _parent;
/*     */     
/*     */     public CheetahClientDeviceAccessFiller(CheetahClientDeviceAccessDBA argParent) {
/* 121 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 126 */       long primitiveResult = argResultSet.getLong(1);
/* 127 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 128 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 134 */       primitiveResult = argResultSet.getLong(2);
/* 135 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 136 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 140 */       this._parent._token = argResultSet.getString(3);
/*     */ 
/*     */       
/* 143 */       primitiveResult = argResultSet.getLong(4);
/* 144 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 145 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 149 */       this._parent._status = argResultSet.getString(5);
/*     */       
/* 151 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 152 */       if (t6 != null) {
/* 153 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 159 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 161 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 162 */       if (t8 != null) {
/* 163 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 166 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 169 */       this._parent._updateUserId = argResultSet.getString(9);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 174 */     argDAO.suppressStateChanges(true);
/* 175 */     CheetahClientDeviceAccessDAO dao = (CheetahClientDeviceAccessDAO)argDAO;
/* 176 */     dao.setOrganizationId(this._organizationId);
/* 177 */     dao.setRetailLocationId(this._retailLocationId);
/* 178 */     dao.setToken(this._token);
/* 179 */     dao.setWorkstationId(this._workstationId);
/* 180 */     dao.setStatus(this._status);
/* 181 */     dao.setCreateDate(this._createDate);
/* 182 */     dao.setCreateUserId(this._createUserId);
/* 183 */     dao.setUpdateDate(this._updateDate);
/* 184 */     dao.setUpdateUserId(this._updateUserId);
/* 185 */     argDAO.suppressStateChanges(false);
/* 186 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 190 */     return loadDAO((IDataAccessObject)new CheetahClientDeviceAccessDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 194 */     CheetahClientDeviceAccessDAO dao = (CheetahClientDeviceAccessDAO)argDAO;
/* 195 */     this._organizationId = dao.getOrganizationId();
/* 196 */     this._retailLocationId = dao.getRetailLocationId();
/* 197 */     this._token = dao.getToken();
/* 198 */     this._workstationId = dao.getWorkstationId();
/* 199 */     this._status = dao.getStatus();
/* 200 */     this._createDate = dao.getCreateDate();
/* 201 */     this._createUserId = dao.getCreateUserId();
/* 202 */     this._updateDate = dao.getUpdateDate();
/* 203 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 207 */     CheetahClientDeviceAccessId id = (CheetahClientDeviceAccessId)argId;
/* 208 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 209 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 210 */     argStatement.setString(3, id.getToken());
/* 211 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 215 */     CheetahClientDeviceAccessId id = new CheetahClientDeviceAccessId();
/* 216 */     id.setOrganizationId(this._organizationId);
/* 217 */     id.setRetailLocationId(this._retailLocationId);
/* 218 */     id.setToken(this._token);
/* 219 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 227 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 231 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\CheetahClientDeviceAccessDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */