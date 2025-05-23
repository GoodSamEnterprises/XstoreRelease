/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemRestrictionCalendarPropertyId;
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
/*     */ public class ItemRestrictionCalendarPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1560309740L;
/*     */   private Long _organizationId;
/*     */   private String _restrictionCategory;
/*     */   private String _restrictionCode;
/*     */   private String _dayCode;
/*     */   private Date _effectiveDate;
/*     */   private Date _startTime;
/*     */   private String _saleLineItemTypeCode;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.restriction_category, t.restriction_code, t.day_code, t.effective_date, t.start_time, t.sale_lineitm_typecode, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_item_restrict_calendar_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND restriction_category = ?  AND restriction_code = ?  AND day_code = ?  AND effective_date = ?  AND start_time = ?  AND sale_lineitm_typecode = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.organization_id, t.restriction_category, t.restriction_code, t.day_code, t.effective_date, t.start_time, t.sale_lineitm_typecode, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_item_restrict_calendar_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE organization_id = ?  AND restriction_category = ?  AND restriction_code = ?  AND day_code = ?  AND effective_date = ?  AND start_time = ?  AND sale_lineitm_typecode = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_restrict_calendar_p(organization_id, restriction_category, restriction_code, day_code, effective_date, start_time, sale_lineitm_typecode, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._organizationId, this._restrictionCategory, this._restrictionCode, this._dayCode, this._effectiveDate, this._startTime, this._saleLineItemTypeCode, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 91, 12, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_restrict_calendar_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  78 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  83 */     return updateParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  88 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_restrict_calendar_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND restriction_category = ?  AND restriction_code = ?  AND day_code = ?  AND effective_date = ?  AND start_time = ?  AND sale_lineitm_typecode = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  94 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 100 */     return " WHERE organization_id = ?  AND restriction_category = ?  AND restriction_code = ?  AND day_code = ?  AND effective_date = ?  AND start_time = ?  AND sale_lineitm_typecode = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 103 */     return new Object[] { this._organizationId, this._restrictionCategory, this._restrictionCode, this._dayCode, this._effectiveDate, this._startTime, this._saleLineItemTypeCode, this._propertyCode };
/*     */   }
/*     */   
/* 106 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12, 91, 91, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 109 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 112 */     return "itm_item_restrict_calendar_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new ItemRestrictionCalendarPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemRestrictionCalendarPropertyFiller
/*     */     implements IFiller {
/*     */     private ItemRestrictionCalendarPropertyDBA _parent;
/*     */     
/*     */     public ItemRestrictionCalendarPropertyFiller(ItemRestrictionCalendarPropertyDBA argParent) {
/* 128 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 133 */       long primitiveResult = argResultSet.getLong(1);
/* 134 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 135 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 139 */       this._parent._restrictionCategory = argResultSet.getString(2);
/* 140 */       this._parent._restrictionCode = argResultSet.getString(3);
/* 141 */       this._parent._dayCode = argResultSet.getString(4);
/*     */       
/* 143 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 144 */       if (t5 != null) {
/* 145 */         this._parent._effectiveDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 148 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 152 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 153 */       if (t6 != null) {
/* 154 */         this._parent._startTime = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._startTime = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._saleLineItemTypeCode = argResultSet.getString(7);
/* 161 */       this._parent._propertyCode = argResultSet.getString(8);
/* 162 */       this._parent._type = argResultSet.getString(9);
/* 163 */       this._parent._stringValue = argResultSet.getString(10);
/*     */       
/* 165 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 166 */       if (t11 != null) {
/* 167 */         this._parent._dateValue = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._decimalValue = argResultSet.getBigDecimal(12);
/*     */       
/* 175 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 176 */       if (t13 != null) {
/* 177 */         this._parent._createDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 183 */       this._parent._createUserId = argResultSet.getString(14);
/*     */       
/* 185 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 186 */       if (t15 != null) {
/* 187 */         this._parent._updateDate = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 190 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 193 */       this._parent._updateUserId = argResultSet.getString(16);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 198 */     argDAO.suppressStateChanges(true);
/* 199 */     ItemRestrictionCalendarPropertyDAO dao = (ItemRestrictionCalendarPropertyDAO)argDAO;
/* 200 */     dao.setOrganizationId(this._organizationId);
/* 201 */     dao.setRestrictionCategory(this._restrictionCategory);
/* 202 */     dao.setRestrictionCode(this._restrictionCode);
/* 203 */     dao.setDayCode(this._dayCode);
/* 204 */     dao.setEffectiveDate(this._effectiveDate);
/* 205 */     dao.setStartTime(this._startTime);
/* 206 */     dao.setSaleLineItemTypeCode(this._saleLineItemTypeCode);
/* 207 */     dao.setPropertyCode(this._propertyCode);
/* 208 */     dao.setType(this._type);
/* 209 */     dao.setStringValue(this._stringValue);
/* 210 */     dao.setDateValue(this._dateValue);
/* 211 */     dao.setDecimalValue(this._decimalValue);
/* 212 */     dao.setCreateDate(this._createDate);
/* 213 */     dao.setCreateUserId(this._createUserId);
/* 214 */     dao.setUpdateDate(this._updateDate);
/* 215 */     dao.setUpdateUserId(this._updateUserId);
/* 216 */     argDAO.suppressStateChanges(false);
/* 217 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 221 */     return loadDAO((IDataAccessObject)new ItemRestrictionCalendarPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 225 */     ItemRestrictionCalendarPropertyDAO dao = (ItemRestrictionCalendarPropertyDAO)argDAO;
/* 226 */     this._organizationId = dao.getOrganizationId();
/* 227 */     this._restrictionCategory = dao.getRestrictionCategory();
/* 228 */     this._restrictionCode = dao.getRestrictionCode();
/* 229 */     this._dayCode = dao.getDayCode();
/* 230 */     this._effectiveDate = dao.getEffectiveDate();
/* 231 */     this._startTime = dao.getStartTime();
/* 232 */     this._saleLineItemTypeCode = dao.getSaleLineItemTypeCode();
/* 233 */     this._propertyCode = dao.getPropertyCode();
/* 234 */     this._type = dao.getType();
/* 235 */     this._stringValue = dao.getStringValue();
/* 236 */     this._dateValue = dao.getDateValue();
/* 237 */     this._decimalValue = dao.getDecimalValue();
/* 238 */     this._createDate = dao.getCreateDate();
/* 239 */     this._createUserId = dao.getCreateUserId();
/* 240 */     this._updateDate = dao.getUpdateDate();
/* 241 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 245 */     ItemRestrictionCalendarPropertyId id = (ItemRestrictionCalendarPropertyId)argId;
/* 246 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 247 */     argStatement.setString(2, id.getRestrictionCategory());
/* 248 */     argStatement.setString(3, id.getRestrictionCode());
/* 249 */     argStatement.setString(4, id.getDayCode());
/* 250 */     argStatement.setTimestamp(5, new Timestamp(id.getEffectiveDate().getTime()));
/* 251 */     argStatement.setTimestamp(6, new Timestamp(id.getStartTime().getTime()));
/* 252 */     argStatement.setString(7, id.getSaleLineItemTypeCode());
/* 253 */     argStatement.setString(8, id.getPropertyCode());
/* 254 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 258 */     ItemRestrictionCalendarPropertyId id = new ItemRestrictionCalendarPropertyId();
/* 259 */     id.setOrganizationId(this._organizationId);
/* 260 */     id.setRestrictionCategory(this._restrictionCategory);
/* 261 */     id.setRestrictionCode(this._restrictionCode);
/* 262 */     id.setDayCode(this._dayCode);
/* 263 */     id.setEffectiveDate(this._effectiveDate);
/* 264 */     id.setStartTime(this._startTime);
/* 265 */     id.setSaleLineItemTypeCode(this._saleLineItemTypeCode);
/* 266 */     id.setPropertyCode(this._propertyCode);
/* 267 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 275 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 279 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictionCalendarPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */