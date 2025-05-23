/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.AddressStateId;
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
/*     */ public class AddressStateDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 417522973L;
/*     */   private Long _organizationId;
/*     */   private String _countryId;
/*     */   private String _stateId;
/*     */   private String _addressMode;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _stateName;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.country_id, t.state_id, t.address_mode, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.state_name FROM com_address_state t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND country_id = ?  AND state_id = ?  AND address_mode = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  38 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  42 */     return "SELECT t.organization_id, t.country_id, t.state_id, t.address_mode, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.state_name FROM com_address_state t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  48 */     return " WHERE organization_id = ?  AND country_id = ?  AND state_id = ?  AND address_mode = ?  ";
/*     */   }
/*     */   
/*  51 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_address_state(organization_id, country_id, state_id, address_mode, create_date, create_user_id, update_date, update_user_id, state_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  54 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  58 */     Object[][] insertParameterObject = { { this._organizationId, this._countryId, this._stateId, this._addressMode, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._stateName } };
/*  59 */     return insertParameterObject;
/*     */   }
/*     */   
/*  62 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 12, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  65 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  68 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_address_state SET update_date = ?, update_user_id = ?, state_name = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  71 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  75 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._stateName } };
/*  76 */     return updateParameterObject;
/*     */   }
/*     */   
/*  79 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  81 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  84 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_address_state" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND country_id = ?  AND state_id = ?  AND address_mode = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  87 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  93 */     return " WHERE organization_id = ?  AND country_id = ?  AND state_id = ?  AND address_mode = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  96 */     return new Object[] { this._organizationId, this._countryId, this._stateId, this._addressMode };
/*     */   }
/*     */   
/*  99 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 102 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 105 */     return "com_address_state";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 109 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 113 */     return new AddressStateFiller(this);
/*     */   }
/*     */   
/*     */   private static class AddressStateFiller
/*     */     implements IFiller {
/*     */     private AddressStateDBA _parent;
/*     */     
/*     */     public AddressStateFiller(AddressStateDBA argParent) {
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
/* 132 */       this._parent._countryId = argResultSet.getString(2);
/* 133 */       this._parent._stateId = argResultSet.getString(3);
/* 134 */       this._parent._addressMode = argResultSet.getString(4);
/*     */       
/* 136 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 137 */       if (t5 != null) {
/* 138 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 141 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 144 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 146 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 147 */       if (t7 != null) {
/* 148 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 154 */       this._parent._updateUserId = argResultSet.getString(8);
/* 155 */       this._parent._stateName = argResultSet.getString(9);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 160 */     argDAO.suppressStateChanges(true);
/* 161 */     AddressStateDAO dao = (AddressStateDAO)argDAO;
/* 162 */     dao.setOrganizationId(this._organizationId);
/* 163 */     dao.setCountryId(this._countryId);
/* 164 */     dao.setStateId(this._stateId);
/* 165 */     dao.setAddressMode(this._addressMode);
/* 166 */     dao.setCreateDate(this._createDate);
/* 167 */     dao.setCreateUserId(this._createUserId);
/* 168 */     dao.setUpdateDate(this._updateDate);
/* 169 */     dao.setUpdateUserId(this._updateUserId);
/* 170 */     dao.setStateName(this._stateName);
/* 171 */     argDAO.suppressStateChanges(false);
/* 172 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 176 */     return loadDAO((IDataAccessObject)new AddressStateDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 180 */     AddressStateDAO dao = (AddressStateDAO)argDAO;
/* 181 */     this._organizationId = dao.getOrganizationId();
/* 182 */     this._countryId = dao.getCountryId();
/* 183 */     this._stateId = dao.getStateId();
/* 184 */     this._addressMode = dao.getAddressMode();
/* 185 */     this._createDate = dao.getCreateDate();
/* 186 */     this._createUserId = dao.getCreateUserId();
/* 187 */     this._updateDate = dao.getUpdateDate();
/* 188 */     this._updateUserId = dao.getUpdateUserId();
/* 189 */     this._stateName = dao.getStateName();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 193 */     AddressStateId id = (AddressStateId)argId;
/* 194 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 195 */     argStatement.setString(2, id.getCountryId());
/* 196 */     argStatement.setString(3, id.getStateId());
/* 197 */     argStatement.setString(4, id.getAddressMode());
/* 198 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 202 */     AddressStateId id = new AddressStateId();
/* 203 */     id.setOrganizationId(this._organizationId);
/* 204 */     id.setCountryId(this._countryId);
/* 205 */     id.setStateId(this._stateId);
/* 206 */     id.setAddressMode(this._addressMode);
/* 207 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 215 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 219 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AddressStateDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */