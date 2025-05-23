/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.ItemRestrictionId;
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
/*     */ public class ItemRestrictionDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1589862041L;
/*     */   private Long _organizationId;
/*     */   private String _restrictionCategory;
/*     */   private String _restrictionCode;
/*     */   private Date _effectiveDate;
/*     */   private String _saleLineItemTypeCode;
/*     */   private String _propertyName;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _expirationDate;
/*     */   private Boolean _booleanValue;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Boolean _onCalendar;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.restriction_category, t.restriction_code, t.effective_date, t.sale_lineitm_typecode, t.property_name, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.expiration_date, t.boolean_value, t.string_value, t.date_value, t.decimal_value, t.on_calendar_flag FROM itm_item_restriction t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND restriction_category = ?  AND restriction_code = ?  AND effective_date = ?  AND sale_lineitm_typecode = ?  AND property_name = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  47 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  51 */     return "SELECT t.organization_id, t.restriction_category, t.restriction_code, t.effective_date, t.sale_lineitm_typecode, t.property_name, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.expiration_date, t.boolean_value, t.string_value, t.date_value, t.decimal_value, t.on_calendar_flag FROM itm_item_restriction t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  57 */     return " WHERE organization_id = ?  AND restriction_category = ?  AND restriction_code = ?  AND effective_date = ?  AND sale_lineitm_typecode = ?  AND property_name = ?  ";
/*     */   }
/*     */   
/*  60 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_restriction(organization_id, restriction_category, restriction_code, effective_date, sale_lineitm_typecode, property_name, org_code, org_value, create_date, create_user_id, update_date, update_user_id, expiration_date, boolean_value, string_value, date_value, decimal_value, on_calendar_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  63 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  67 */     Object[][] insertParameterObject = { { this._organizationId, this._restrictionCategory, this._restrictionCode, this._effectiveDate, this._saleLineItemTypeCode, this._propertyName, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._expirationDate, this._booleanValue, this._stringValue, this._dateValue, this._decimalValue, this._onCalendar } };
/*  68 */     return insertParameterObject;
/*     */   }
/*     */   
/*  71 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 12, 12, 12, 91, 12, 91, 12, 91, -7, 12, 91, 3, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  74 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  77 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_restriction SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, expiration_date = ?, boolean_value = ?, string_value = ?, date_value = ?, decimal_value = ?, on_calendar_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  80 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  84 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._expirationDate, this._booleanValue, this._stringValue, this._dateValue, this._decimalValue, this._onCalendar } };
/*  85 */     return updateParameterObject;
/*     */   }
/*     */   
/*  88 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 91, -7, 12, 91, 3, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  90 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  93 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_restriction" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND restriction_category = ?  AND restriction_code = ?  AND effective_date = ?  AND sale_lineitm_typecode = ?  AND property_name = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  96 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 102 */     return " WHERE organization_id = ?  AND restriction_category = ?  AND restriction_code = ?  AND effective_date = ?  AND sale_lineitm_typecode = ?  AND property_name = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 105 */     return new Object[] { this._organizationId, this._restrictionCategory, this._restrictionCode, this._effectiveDate, this._saleLineItemTypeCode, this._propertyName };
/*     */   }
/*     */   
/* 108 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 91, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 111 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 114 */     return "itm_item_restriction";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 118 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 122 */     return new ItemRestrictionFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemRestrictionFiller
/*     */     implements IFiller {
/*     */     private ItemRestrictionDBA _parent;
/*     */     
/*     */     public ItemRestrictionFiller(ItemRestrictionDBA argParent) {
/* 130 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 135 */       long primitiveResult = argResultSet.getLong(1);
/* 136 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 137 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 141 */       this._parent._restrictionCategory = argResultSet.getString(2);
/* 142 */       this._parent._restrictionCode = argResultSet.getString(3);
/*     */       
/* 144 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 145 */       if (t4 != null) {
/* 146 */         this._parent._effectiveDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._saleLineItemTypeCode = argResultSet.getString(5);
/* 153 */       this._parent._propertyName = argResultSet.getString(6);
/* 154 */       this._parent._orgCode = argResultSet.getString(7);
/* 155 */       this._parent._orgValue = argResultSet.getString(8);
/*     */       
/* 157 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 158 */       if (t9 != null) {
/* 159 */         this._parent._createDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 162 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 165 */       this._parent._createUserId = argResultSet.getString(10);
/*     */       
/* 167 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 168 */       if (t11 != null) {
/* 169 */         this._parent._updateDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 172 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 175 */       this._parent._updateUserId = argResultSet.getString(12);
/*     */       
/* 177 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 178 */       if (t13 != null) {
/* 179 */         this._parent._expirationDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 182 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 185 */       this._parent._booleanValue = Boolean.valueOf(argResultSet.getBoolean(14));
/* 186 */       this._parent._stringValue = argResultSet.getString(15);
/*     */       
/* 188 */       Timestamp t16 = argResultSet.getTimestamp(16);
/* 189 */       if (t16 != null) {
/* 190 */         this._parent._dateValue = (Date)new DtvDate(t16.getTime());
/*     */       } else {
/*     */         
/* 193 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 196 */       this._parent._decimalValue = argResultSet.getBigDecimal(17);
/* 197 */       this._parent._onCalendar = Boolean.valueOf(argResultSet.getBoolean(18));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 202 */     argDAO.suppressStateChanges(true);
/* 203 */     ItemRestrictionDAO dao = (ItemRestrictionDAO)argDAO;
/* 204 */     dao.setOrganizationId(this._organizationId);
/* 205 */     dao.setRestrictionCategory(this._restrictionCategory);
/* 206 */     dao.setRestrictionCode(this._restrictionCode);
/* 207 */     dao.setEffectiveDate(this._effectiveDate);
/* 208 */     dao.setSaleLineItemTypeCode(this._saleLineItemTypeCode);
/* 209 */     dao.setPropertyName(this._propertyName);
/* 210 */     dao.setOrgCode(this._orgCode);
/* 211 */     dao.setOrgValue(this._orgValue);
/* 212 */     dao.setCreateDate(this._createDate);
/* 213 */     dao.setCreateUserId(this._createUserId);
/* 214 */     dao.setUpdateDate(this._updateDate);
/* 215 */     dao.setUpdateUserId(this._updateUserId);
/* 216 */     dao.setExpirationDate(this._expirationDate);
/* 217 */     dao.setBooleanValue(this._booleanValue);
/* 218 */     dao.setStringValue(this._stringValue);
/* 219 */     dao.setDateValue(this._dateValue);
/* 220 */     dao.setDecimalValue(this._decimalValue);
/* 221 */     dao.setOnCalendar(this._onCalendar);
/* 222 */     argDAO.suppressStateChanges(false);
/* 223 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 227 */     return loadDAO((IDataAccessObject)new ItemRestrictionDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 231 */     ItemRestrictionDAO dao = (ItemRestrictionDAO)argDAO;
/* 232 */     this._organizationId = dao.getOrganizationId();
/* 233 */     this._restrictionCategory = dao.getRestrictionCategory();
/* 234 */     this._restrictionCode = dao.getRestrictionCode();
/* 235 */     this._effectiveDate = dao.getEffectiveDate();
/* 236 */     this._saleLineItemTypeCode = dao.getSaleLineItemTypeCode();
/* 237 */     this._propertyName = dao.getPropertyName();
/* 238 */     this._orgCode = dao.getOrgCode();
/* 239 */     this._orgValue = dao.getOrgValue();
/* 240 */     this._createDate = dao.getCreateDate();
/* 241 */     this._createUserId = dao.getCreateUserId();
/* 242 */     this._updateDate = dao.getUpdateDate();
/* 243 */     this._updateUserId = dao.getUpdateUserId();
/* 244 */     this._expirationDate = dao.getExpirationDate();
/* 245 */     this._booleanValue = (dao.getBooleanValue() != null) ? dao.getBooleanValue() : Boolean.valueOf(false);
/* 246 */     this._stringValue = dao.getStringValue();
/* 247 */     this._dateValue = dao.getDateValue();
/* 248 */     this._decimalValue = dao.getDecimalValue();
/* 249 */     this._onCalendar = (dao.getOnCalendar() != null) ? dao.getOnCalendar() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 253 */     ItemRestrictionId id = (ItemRestrictionId)argId;
/* 254 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 255 */     argStatement.setString(2, id.getRestrictionCategory());
/* 256 */     argStatement.setString(3, id.getRestrictionCode());
/* 257 */     argStatement.setTimestamp(4, new Timestamp(id.getEffectiveDate().getTime()));
/* 258 */     argStatement.setString(5, id.getSaleLineItemTypeCode());
/* 259 */     argStatement.setString(6, id.getPropertyName());
/* 260 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 264 */     ItemRestrictionId id = new ItemRestrictionId();
/* 265 */     id.setOrganizationId(this._organizationId);
/* 266 */     id.setRestrictionCategory(this._restrictionCategory);
/* 267 */     id.setRestrictionCode(this._restrictionCode);
/* 268 */     id.setEffectiveDate(this._effectiveDate);
/* 269 */     id.setSaleLineItemTypeCode(this._saleLineItemTypeCode);
/* 270 */     id.setPropertyName(this._propertyName);
/* 271 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 279 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 283 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */