/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.SubstituteItemsPropertyId;
/*     */ import java.math.BigDecimal;
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
/*     */ public class SubstituteItemsPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1473222427L;
/*     */   private Long _organizationId;
/*     */   private String _primaryItemId;
/*     */   private String _substituteItemId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.primary_item_id, t.substitute_item_id, t.level_code, t.level_value, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_substitute_items_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND primary_item_id = ?  AND substitute_item_id = ?  AND level_code = ?  AND level_value = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.primary_item_id, t.substitute_item_id, t.level_code, t.level_value, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_substitute_items_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND primary_item_id = ?  AND substitute_item_id = ?  AND level_code = ?  AND level_value = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_substitute_items_p(organization_id, primary_item_id, substitute_item_id, level_code, level_value, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._primaryItemId, this._substituteItemId, this._levelCode, this._levelValue, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 12, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_substitute_items_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_substitute_items_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND primary_item_id = ?  AND substitute_item_id = ?  AND level_code = ?  AND level_value = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND primary_item_id = ?  AND substitute_item_id = ?  AND level_code = ?  AND level_value = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._primaryItemId, this._substituteItemId, this._levelCode, this._levelValue, this._propertyCode };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "itm_substitute_items_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new SubstituteItemsPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class SubstituteItemsPropertyFiller
/*     */     implements IFiller {
/*     */     private SubstituteItemsPropertyDBA _parent;
/*     */     
/*     */     public SubstituteItemsPropertyFiller(SubstituteItemsPropertyDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       long primitiveResult = argResultSet.getLong(1);
/* 132 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 133 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 137 */       this._parent._primaryItemId = argResultSet.getString(2);
/* 138 */       this._parent._substituteItemId = argResultSet.getString(3);
/* 139 */       this._parent._levelCode = argResultSet.getString(4);
/* 140 */       this._parent._levelValue = argResultSet.getString(5);
/* 141 */       this._parent._propertyCode = argResultSet.getString(6);
/* 142 */       this._parent._type = argResultSet.getString(7);
/* 143 */       this._parent._stringValue = argResultSet.getString(8);
/*     */       
/* 145 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 146 */       if (t9 != null) {
/* 147 */         this._parent._dateValue = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._decimalValue = argResultSet.getBigDecimal(10);
/*     */       
/* 155 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 156 */       if (t11 != null) {
/* 157 */         this._parent._createDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._createUserId = argResultSet.getString(12);
/*     */       
/* 165 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 166 */       if (t13 != null) {
/* 167 */         this._parent._updateDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._updateUserId = argResultSet.getString(14);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 178 */     argDAO.suppressStateChanges(true);
/* 179 */     SubstituteItemsPropertyDAO dao = (SubstituteItemsPropertyDAO)argDAO;
/* 180 */     dao.setOrganizationId(this._organizationId);
/* 181 */     dao.setPrimaryItemId(this._primaryItemId);
/* 182 */     dao.setSubstituteItemId(this._substituteItemId);
/* 183 */     dao.setLevelCode(this._levelCode);
/* 184 */     dao.setLevelValue(this._levelValue);
/* 185 */     dao.setPropertyCode(this._propertyCode);
/* 186 */     dao.setType(this._type);
/* 187 */     dao.setStringValue(this._stringValue);
/* 188 */     dao.setDateValue(this._dateValue);
/* 189 */     dao.setDecimalValue(this._decimalValue);
/* 190 */     dao.setCreateDate(this._createDate);
/* 191 */     dao.setCreateUserId(this._createUserId);
/* 192 */     dao.setUpdateDate(this._updateDate);
/* 193 */     dao.setUpdateUserId(this._updateUserId);
/* 194 */     argDAO.suppressStateChanges(false);
/* 195 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 199 */     return loadDAO((IDataAccessObject)new SubstituteItemsPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 203 */     SubstituteItemsPropertyDAO dao = (SubstituteItemsPropertyDAO)argDAO;
/* 204 */     this._organizationId = dao.getOrganizationId();
/* 205 */     this._primaryItemId = dao.getPrimaryItemId();
/* 206 */     this._substituteItemId = dao.getSubstituteItemId();
/* 207 */     this._levelCode = dao.getLevelCode();
/* 208 */     this._levelValue = dao.getLevelValue();
/* 209 */     this._propertyCode = dao.getPropertyCode();
/* 210 */     this._type = dao.getType();
/* 211 */     this._stringValue = dao.getStringValue();
/* 212 */     this._dateValue = dao.getDateValue();
/* 213 */     this._decimalValue = dao.getDecimalValue();
/* 214 */     this._createDate = dao.getCreateDate();
/* 215 */     this._createUserId = dao.getCreateUserId();
/* 216 */     this._updateDate = dao.getUpdateDate();
/* 217 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 221 */     SubstituteItemsPropertyId id = (SubstituteItemsPropertyId)argId;
/* 222 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 223 */     argStatement.setString(2, id.getPrimaryItemId());
/* 224 */     argStatement.setString(3, id.getSubstituteItemId());
/* 225 */     argStatement.setString(4, id.getLevelCode());
/* 226 */     argStatement.setString(5, id.getLevelValue());
/* 227 */     argStatement.setString(6, id.getPropertyCode());
/* 228 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 232 */     SubstituteItemsPropertyId id = new SubstituteItemsPropertyId();
/* 233 */     id.setOrganizationId(this._organizationId);
/* 234 */     id.setPrimaryItemId(this._primaryItemId);
/* 235 */     id.setSubstituteItemId(this._substituteItemId);
/* 236 */     id.setLevelCode(this._levelCode);
/* 237 */     id.setLevelValue(this._levelValue);
/* 238 */     id.setPropertyCode(this._propertyCode);
/* 239 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 247 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 251 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\SubstituteItemsPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */