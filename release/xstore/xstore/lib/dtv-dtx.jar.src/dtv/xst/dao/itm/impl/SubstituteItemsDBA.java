/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.SubstituteItemsId;
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
/*     */ public class SubstituteItemsDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 453630758L;
/*     */   private Long _organizationId;
/*     */   private String _primaryItemId;
/*     */   private String _substituteItemId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _beginDatetime;
/*     */   private Date _endDatetime;
/*     */   private String _externalId;
/*     */   private String _externalSystem;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.primary_item_id, t.substitute_item_id, t.level_code, t.level_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.begin_datetime, t.end_datetime, t.external_id, t.external_system FROM itm_substitute_items t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND primary_item_id = ?  AND substitute_item_id = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.primary_item_id, t.substitute_item_id, t.level_code, t.level_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.begin_datetime, t.end_datetime, t.external_id, t.external_system FROM itm_substitute_items t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND primary_item_id = ?  AND substitute_item_id = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_substitute_items(organization_id, primary_item_id, substitute_item_id, level_code, level_value, create_date, create_user_id, update_date, update_user_id, begin_datetime, end_datetime, external_id, external_system) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._primaryItemId, this._substituteItemId, this._levelCode, this._levelValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._beginDatetime, this._endDatetime, this._externalId, this._externalSystem } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 12, 91, 12, 91, 12, 91, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_substitute_items SET update_date = ?, update_user_id = ?, begin_datetime = ?, end_datetime = ?, external_id = ?, external_system = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._beginDatetime, this._endDatetime, this._externalId, this._externalSystem } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 91, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_substitute_items" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND primary_item_id = ?  AND substitute_item_id = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND primary_item_id = ?  AND substitute_item_id = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._primaryItemId, this._substituteItemId, this._levelCode, this._levelValue };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "itm_substitute_items";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new SubstituteItemsFiller(this);
/*     */   }
/*     */   
/*     */   private static class SubstituteItemsFiller
/*     */     implements IFiller {
/*     */     private SubstituteItemsDBA _parent;
/*     */     
/*     */     public SubstituteItemsFiller(SubstituteItemsDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       long primitiveResult = argResultSet.getLong(1);
/* 131 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 132 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 136 */       this._parent._primaryItemId = argResultSet.getString(2);
/* 137 */       this._parent._substituteItemId = argResultSet.getString(3);
/* 138 */       this._parent._levelCode = argResultSet.getString(4);
/* 139 */       this._parent._levelValue = argResultSet.getString(5);
/*     */       
/* 141 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 142 */       if (t6 != null) {
/* 143 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 146 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 149 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 151 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 152 */       if (t8 != null) {
/* 153 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 159 */       this._parent._updateUserId = argResultSet.getString(9);
/*     */       
/* 161 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 162 */       if (t10 != null) {
/* 163 */         this._parent._beginDatetime = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 166 */         this._parent._beginDatetime = null;
/*     */       } 
/*     */ 
/*     */       
/* 170 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 171 */       if (t11 != null) {
/* 172 */         this._parent._endDatetime = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 175 */         this._parent._endDatetime = null;
/*     */       } 
/*     */       
/* 178 */       this._parent._externalId = argResultSet.getString(12);
/* 179 */       this._parent._externalSystem = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 184 */     argDAO.suppressStateChanges(true);
/* 185 */     SubstituteItemsDAO dao = (SubstituteItemsDAO)argDAO;
/* 186 */     dao.setOrganizationId(this._organizationId);
/* 187 */     dao.setPrimaryItemId(this._primaryItemId);
/* 188 */     dao.setSubstituteItemId(this._substituteItemId);
/* 189 */     dao.setLevelCode(this._levelCode);
/* 190 */     dao.setLevelValue(this._levelValue);
/* 191 */     dao.setCreateDate(this._createDate);
/* 192 */     dao.setCreateUserId(this._createUserId);
/* 193 */     dao.setUpdateDate(this._updateDate);
/* 194 */     dao.setUpdateUserId(this._updateUserId);
/* 195 */     dao.setBeginDatetime(this._beginDatetime);
/* 196 */     dao.setEndDatetime(this._endDatetime);
/* 197 */     dao.setExternalId(this._externalId);
/* 198 */     dao.setExternalSystem(this._externalSystem);
/* 199 */     argDAO.suppressStateChanges(false);
/* 200 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 204 */     return loadDAO((IDataAccessObject)new SubstituteItemsDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 208 */     SubstituteItemsDAO dao = (SubstituteItemsDAO)argDAO;
/* 209 */     this._organizationId = dao.getOrganizationId();
/* 210 */     this._primaryItemId = dao.getPrimaryItemId();
/* 211 */     this._substituteItemId = dao.getSubstituteItemId();
/* 212 */     this._levelCode = dao.getLevelCode();
/* 213 */     this._levelValue = dao.getLevelValue();
/* 214 */     this._createDate = dao.getCreateDate();
/* 215 */     this._createUserId = dao.getCreateUserId();
/* 216 */     this._updateDate = dao.getUpdateDate();
/* 217 */     this._updateUserId = dao.getUpdateUserId();
/* 218 */     this._beginDatetime = dao.getBeginDatetime();
/* 219 */     this._endDatetime = dao.getEndDatetime();
/* 220 */     this._externalId = dao.getExternalId();
/* 221 */     this._externalSystem = dao.getExternalSystem();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 225 */     SubstituteItemsId id = (SubstituteItemsId)argId;
/* 226 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 227 */     argStatement.setString(2, id.getPrimaryItemId());
/* 228 */     argStatement.setString(3, id.getSubstituteItemId());
/* 229 */     argStatement.setString(4, id.getLevelCode());
/* 230 */     argStatement.setString(5, id.getLevelValue());
/* 231 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 235 */     SubstituteItemsId id = new SubstituteItemsId();
/* 236 */     id.setOrganizationId(this._organizationId);
/* 237 */     id.setPrimaryItemId(this._primaryItemId);
/* 238 */     id.setSubstituteItemId(this._substituteItemId);
/* 239 */     id.setLevelCode(this._levelCode);
/* 240 */     id.setLevelValue(this._levelValue);
/* 241 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 249 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 253 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\SubstituteItemsDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */