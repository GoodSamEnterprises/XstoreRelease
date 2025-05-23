/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemRestrictionPropertyId;
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
/*     */ public class ItemRestrictionPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1913911182L;
/*     */   private Long _organizationId;
/*     */   private String _restrictionCategory;
/*     */   private String _restrictionCode;
/*     */   private Date _effectiveDate;
/*     */   private String _saleLineItemTypeCode;
/*     */   private String _propertyName;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.restriction_category, t.restriction_code, t.effective_date, t.sale_lineitm_typecode, t.property_name, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_item_restriction_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND restriction_category = ?  AND restriction_code = ?  AND effective_date = ?  AND sale_lineitm_typecode = ?  AND property_name = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.restriction_category, t.restriction_code, t.effective_date, t.sale_lineitm_typecode, t.property_name, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_item_restriction_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND restriction_category = ?  AND restriction_code = ?  AND effective_date = ?  AND sale_lineitm_typecode = ?  AND property_name = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_restriction_p(organization_id, restriction_category, restriction_code, effective_date, sale_lineitm_typecode, property_name, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._restrictionCategory, this._restrictionCode, this._effectiveDate, this._saleLineItemTypeCode, this._propertyName, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 12, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_restriction_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_restriction_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND restriction_category = ?  AND restriction_code = ?  AND effective_date = ?  AND sale_lineitm_typecode = ?  AND property_name = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND restriction_category = ?  AND restriction_code = ?  AND effective_date = ?  AND sale_lineitm_typecode = ?  AND property_name = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._restrictionCategory, this._restrictionCode, this._effectiveDate, this._saleLineItemTypeCode, this._propertyName, this._propertyCode };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 91, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "itm_item_restriction_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new ItemRestrictionPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemRestrictionPropertyFiller
/*     */     implements IFiller {
/*     */     private ItemRestrictionPropertyDBA _parent;
/*     */     
/*     */     public ItemRestrictionPropertyFiller(ItemRestrictionPropertyDBA argParent) {
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
/* 138 */       this._parent._restrictionCategory = argResultSet.getString(2);
/* 139 */       this._parent._restrictionCode = argResultSet.getString(3);
/*     */       
/* 141 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 142 */       if (t4 != null) {
/* 143 */         this._parent._effectiveDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 146 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */       
/* 149 */       this._parent._saleLineItemTypeCode = argResultSet.getString(5);
/* 150 */       this._parent._propertyName = argResultSet.getString(6);
/* 151 */       this._parent._propertyCode = argResultSet.getString(7);
/* 152 */       this._parent._type = argResultSet.getString(8);
/* 153 */       this._parent._stringValue = argResultSet.getString(9);
/*     */       
/* 155 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 156 */       if (t10 != null) {
/* 157 */         this._parent._dateValue = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._decimalValue = argResultSet.getBigDecimal(11);
/*     */       
/* 165 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 166 */       if (t12 != null) {
/* 167 */         this._parent._createDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._createUserId = argResultSet.getString(13);
/*     */       
/* 175 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 176 */       if (t14 != null) {
/* 177 */         this._parent._updateDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 183 */       this._parent._updateUserId = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 188 */     argDAO.suppressStateChanges(true);
/* 189 */     ItemRestrictionPropertyDAO dao = (ItemRestrictionPropertyDAO)argDAO;
/* 190 */     dao.setOrganizationId(this._organizationId);
/* 191 */     dao.setRestrictionCategory(this._restrictionCategory);
/* 192 */     dao.setRestrictionCode(this._restrictionCode);
/* 193 */     dao.setEffectiveDate(this._effectiveDate);
/* 194 */     dao.setSaleLineItemTypeCode(this._saleLineItemTypeCode);
/* 195 */     dao.setPropertyName(this._propertyName);
/* 196 */     dao.setPropertyCode(this._propertyCode);
/* 197 */     dao.setType(this._type);
/* 198 */     dao.setStringValue(this._stringValue);
/* 199 */     dao.setDateValue(this._dateValue);
/* 200 */     dao.setDecimalValue(this._decimalValue);
/* 201 */     dao.setCreateDate(this._createDate);
/* 202 */     dao.setCreateUserId(this._createUserId);
/* 203 */     dao.setUpdateDate(this._updateDate);
/* 204 */     dao.setUpdateUserId(this._updateUserId);
/* 205 */     argDAO.suppressStateChanges(false);
/* 206 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 210 */     return loadDAO((IDataAccessObject)new ItemRestrictionPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 214 */     ItemRestrictionPropertyDAO dao = (ItemRestrictionPropertyDAO)argDAO;
/* 215 */     this._organizationId = dao.getOrganizationId();
/* 216 */     this._restrictionCategory = dao.getRestrictionCategory();
/* 217 */     this._restrictionCode = dao.getRestrictionCode();
/* 218 */     this._effectiveDate = dao.getEffectiveDate();
/* 219 */     this._saleLineItemTypeCode = dao.getSaleLineItemTypeCode();
/* 220 */     this._propertyName = dao.getPropertyName();
/* 221 */     this._propertyCode = dao.getPropertyCode();
/* 222 */     this._type = dao.getType();
/* 223 */     this._stringValue = dao.getStringValue();
/* 224 */     this._dateValue = dao.getDateValue();
/* 225 */     this._decimalValue = dao.getDecimalValue();
/* 226 */     this._createDate = dao.getCreateDate();
/* 227 */     this._createUserId = dao.getCreateUserId();
/* 228 */     this._updateDate = dao.getUpdateDate();
/* 229 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 233 */     ItemRestrictionPropertyId id = (ItemRestrictionPropertyId)argId;
/* 234 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 235 */     argStatement.setString(2, id.getRestrictionCategory());
/* 236 */     argStatement.setString(3, id.getRestrictionCode());
/* 237 */     argStatement.setTimestamp(4, new Timestamp(id.getEffectiveDate().getTime()));
/* 238 */     argStatement.setString(5, id.getSaleLineItemTypeCode());
/* 239 */     argStatement.setString(6, id.getPropertyName());
/* 240 */     argStatement.setString(7, id.getPropertyCode());
/* 241 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 245 */     ItemRestrictionPropertyId id = new ItemRestrictionPropertyId();
/* 246 */     id.setOrganizationId(this._organizationId);
/* 247 */     id.setRestrictionCategory(this._restrictionCategory);
/* 248 */     id.setRestrictionCode(this._restrictionCode);
/* 249 */     id.setEffectiveDate(this._effectiveDate);
/* 250 */     id.setSaleLineItemTypeCode(this._saleLineItemTypeCode);
/* 251 */     id.setPropertyName(this._propertyName);
/* 252 */     id.setPropertyCode(this._propertyCode);
/* 253 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 261 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 265 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictionPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */