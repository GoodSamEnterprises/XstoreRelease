/*     */ package dtv.xst.dao.tnd.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.tnd.TenderUserSettingsPropertyId;
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
/*     */ public class TenderUserSettingsPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1267758615L;
/*     */   private String _groupId;
/*     */   private Long _organizationId;
/*     */   private String _tenderId;
/*     */   private String _usageCode;
/*     */   private String _entryMethodCode;
/*     */   private String _configElement;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.group_id, t.organization_id, t.tndr_id, t.usage_code, t.entry_mthd_code, t.config_element, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tnd_tndr_user_settings_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE group_id = ?  AND organization_id = ?  AND tndr_id = ?  AND usage_code = ?  AND entry_mthd_code = ?  AND config_element = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.group_id, t.organization_id, t.tndr_id, t.usage_code, t.entry_mthd_code, t.config_element, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tnd_tndr_user_settings_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE group_id = ?  AND organization_id = ?  AND tndr_id = ?  AND usage_code = ?  AND entry_mthd_code = ?  AND config_element = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tnd_tndr_user_settings_p(group_id, organization_id, tndr_id, usage_code, entry_mthd_code, config_element, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._groupId, this._organizationId, this._tenderId, this._usageCode, this._entryMethodCode, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 12, 12, 12, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tnd_tndr_user_settings_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tnd_tndr_user_settings_p" }; private static final String WHERE_OBJECT = " WHERE group_id = ?  AND organization_id = ?  AND tndr_id = ?  AND usage_code = ?  AND entry_mthd_code = ?  AND config_element = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE group_id = ?  AND organization_id = ?  AND tndr_id = ?  AND usage_code = ?  AND entry_mthd_code = ?  AND config_element = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._groupId, this._organizationId, this._tenderId, this._usageCode, this._entryMethodCode, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._propertyCode };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 12, 12, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "tnd_tndr_user_settings_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new TenderUserSettingsPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderUserSettingsPropertyFiller
/*     */     implements IFiller {
/*     */     private TenderUserSettingsPropertyDBA _parent;
/*     */     
/*     */     public TenderUserSettingsPropertyFiller(TenderUserSettingsPropertyDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       this._parent._groupId = argResultSet.getString(1);
/*     */ 
/*     */       
/* 133 */       long primitiveResult = argResultSet.getLong(2);
/* 134 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 135 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 139 */       this._parent._tenderId = argResultSet.getString(3);
/* 140 */       this._parent._usageCode = argResultSet.getString(4);
/* 141 */       this._parent._entryMethodCode = argResultSet.getString(5);
/* 142 */       this._parent._configElement = argResultSet.getString(6);
/* 143 */       this._parent._propertyCode = argResultSet.getString(7);
/* 144 */       this._parent._type = argResultSet.getString(8);
/* 145 */       this._parent._stringValue = argResultSet.getString(9);
/*     */       
/* 147 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 148 */       if (t10 != null) {
/* 149 */         this._parent._dateValue = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 152 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 155 */       this._parent._decimalValue = argResultSet.getBigDecimal(11);
/*     */       
/* 157 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 158 */       if (t12 != null) {
/* 159 */         this._parent._createDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 162 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 165 */       this._parent._createUserId = argResultSet.getString(13);
/*     */       
/* 167 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 168 */       if (t14 != null) {
/* 169 */         this._parent._updateDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 172 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 175 */       this._parent._updateUserId = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 180 */     argDAO.suppressStateChanges(true);
/* 181 */     TenderUserSettingsPropertyDAO dao = (TenderUserSettingsPropertyDAO)argDAO;
/* 182 */     dao.setGroupId(this._groupId);
/* 183 */     dao.setOrganizationId(this._organizationId);
/* 184 */     dao.setTenderId(this._tenderId);
/* 185 */     dao.setUsageCode(this._usageCode);
/* 186 */     dao.setEntryMethodCode(this._entryMethodCode);
/* 187 */     dao.setConfigElement(this._configElement);
/* 188 */     dao.setPropertyCode(this._propertyCode);
/* 189 */     dao.setType(this._type);
/* 190 */     dao.setStringValue(this._stringValue);
/* 191 */     dao.setDateValue(this._dateValue);
/* 192 */     dao.setDecimalValue(this._decimalValue);
/* 193 */     dao.setCreateDate(this._createDate);
/* 194 */     dao.setCreateUserId(this._createUserId);
/* 195 */     dao.setUpdateDate(this._updateDate);
/* 196 */     dao.setUpdateUserId(this._updateUserId);
/* 197 */     argDAO.suppressStateChanges(false);
/* 198 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 202 */     return loadDAO((IDataAccessObject)new TenderUserSettingsPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 206 */     TenderUserSettingsPropertyDAO dao = (TenderUserSettingsPropertyDAO)argDAO;
/* 207 */     this._groupId = dao.getGroupId();
/* 208 */     this._organizationId = dao.getOrganizationId();
/* 209 */     this._tenderId = dao.getTenderId();
/* 210 */     this._usageCode = dao.getUsageCode();
/* 211 */     this._entryMethodCode = dao.getEntryMethodCode();
/* 212 */     this._configElement = dao.getConfigElement();
/* 213 */     this._propertyCode = dao.getPropertyCode();
/* 214 */     this._type = dao.getType();
/* 215 */     this._stringValue = dao.getStringValue();
/* 216 */     this._dateValue = dao.getDateValue();
/* 217 */     this._decimalValue = dao.getDecimalValue();
/* 218 */     this._createDate = dao.getCreateDate();
/* 219 */     this._createUserId = dao.getCreateUserId();
/* 220 */     this._updateDate = dao.getUpdateDate();
/* 221 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 225 */     TenderUserSettingsPropertyId id = (TenderUserSettingsPropertyId)argId;
/* 226 */     argStatement.setString(1, id.getGroupId());
/* 227 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 228 */     argStatement.setString(3, id.getTenderId());
/* 229 */     argStatement.setString(4, id.getUsageCode());
/* 230 */     argStatement.setString(5, id.getEntryMethodCode());
/* 231 */     argStatement.setString(6, id.getConfigElement());
/* 232 */     argStatement.setString(7, id.getPropertyCode());
/* 233 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 237 */     TenderUserSettingsPropertyId id = new TenderUserSettingsPropertyId();
/* 238 */     id.setGroupId(this._groupId);
/* 239 */     id.setOrganizationId(this._organizationId);
/* 240 */     id.setTenderId(this._tenderId);
/* 241 */     id.setUsageCode(this._usageCode);
/* 242 */     id.setEntryMethodCode(this._entryMethodCode);
/* 243 */     id.setConfigElement(this._configElement);
/* 244 */     id.setPropertyCode(this._propertyCode);
/* 245 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 253 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 257 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderUserSettingsPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */