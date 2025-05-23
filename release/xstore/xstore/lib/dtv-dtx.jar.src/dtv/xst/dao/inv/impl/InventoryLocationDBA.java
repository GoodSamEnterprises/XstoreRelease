/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryLocationId;
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
/*     */ public class InventoryLocationDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1324171537L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _locationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _name;
/*     */   private Boolean _systemLocation;
/*     */   private Boolean _active;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.inv_location_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.name, t.system_location_flag, t.active_flag FROM inv_location t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_location_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.rtl_loc_id, t.inv_location_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.name, t.system_location_flag, t.active_flag FROM inv_location t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_location_id = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_location(organization_id, rtl_loc_id, inv_location_id, create_date, create_user_id, update_date, update_user_id, name, system_location_flag, active_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._locationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._name, this._systemLocation, this._active } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 91, 12, 91, 12, 12, -7, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_location SET update_date = ?, update_user_id = ?, name = ?, system_location_flag = ?, active_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._name, this._systemLocation, this._active } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, -7, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_location" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_location_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_location_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._retailLocationId, this._locationId };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "inv_location";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new InventoryLocationFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryLocationFiller
/*     */     implements IFiller {
/*     */     private InventoryLocationDBA _parent;
/*     */     
/*     */     public InventoryLocationFiller(InventoryLocationDBA argParent) {
/* 122 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 127 */       long primitiveResult = argResultSet.getLong(1);
/* 128 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 129 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 135 */       primitiveResult = argResultSet.getLong(2);
/* 136 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 137 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 141 */       this._parent._locationId = argResultSet.getString(3);
/*     */       
/* 143 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 144 */       if (t4 != null) {
/* 145 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 148 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 151 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 153 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 154 */       if (t6 != null) {
/* 155 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 158 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 161 */       this._parent._updateUserId = argResultSet.getString(7);
/* 162 */       this._parent._name = argResultSet.getString(8);
/* 163 */       this._parent._systemLocation = Boolean.valueOf(argResultSet.getBoolean(9));
/* 164 */       this._parent._active = Boolean.valueOf(argResultSet.getBoolean(10));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 169 */     argDAO.suppressStateChanges(true);
/* 170 */     InventoryLocationDAO dao = (InventoryLocationDAO)argDAO;
/* 171 */     dao.setOrganizationId(this._organizationId);
/* 172 */     dao.setRetailLocationId(this._retailLocationId);
/* 173 */     dao.setLocationId(this._locationId);
/* 174 */     dao.setCreateDate(this._createDate);
/* 175 */     dao.setCreateUserId(this._createUserId);
/* 176 */     dao.setUpdateDate(this._updateDate);
/* 177 */     dao.setUpdateUserId(this._updateUserId);
/* 178 */     dao.setName(this._name);
/* 179 */     dao.setSystemLocation(this._systemLocation);
/* 180 */     dao.setActive(this._active);
/* 181 */     argDAO.suppressStateChanges(false);
/* 182 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 186 */     return loadDAO((IDataAccessObject)new InventoryLocationDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 190 */     InventoryLocationDAO dao = (InventoryLocationDAO)argDAO;
/* 191 */     this._organizationId = dao.getOrganizationId();
/* 192 */     this._retailLocationId = dao.getRetailLocationId();
/* 193 */     this._locationId = dao.getLocationId();
/* 194 */     this._createDate = dao.getCreateDate();
/* 195 */     this._createUserId = dao.getCreateUserId();
/* 196 */     this._updateDate = dao.getUpdateDate();
/* 197 */     this._updateUserId = dao.getUpdateUserId();
/* 198 */     this._name = dao.getName();
/* 199 */     this._systemLocation = (dao.getSystemLocation() != null) ? dao.getSystemLocation() : Boolean.valueOf(false);
/* 200 */     this._active = (dao.getActive() != null) ? dao.getActive() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 204 */     InventoryLocationId id = (InventoryLocationId)argId;
/* 205 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 206 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 207 */     argStatement.setString(3, id.getLocationId());
/* 208 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 212 */     InventoryLocationId id = new InventoryLocationId();
/* 213 */     id.setOrganizationId(this._organizationId);
/* 214 */     id.setRetailLocationId(this._retailLocationId);
/* 215 */     id.setLocationId(this._locationId);
/* 216 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 224 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 228 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryLocationDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */