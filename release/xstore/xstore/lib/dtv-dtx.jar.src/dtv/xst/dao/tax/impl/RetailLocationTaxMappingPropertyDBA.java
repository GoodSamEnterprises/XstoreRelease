/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tax.RetailLocationTaxMappingPropertyId;
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
/*     */ public class RetailLocationTaxMappingPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1098107472L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tax_rtl_loc_tax_mapping_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.rtl_loc_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tax_rtl_loc_tax_mapping_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tax_rtl_loc_tax_mapping_p(organization_id, rtl_loc_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tax_rtl_loc_tax_mapping_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tax_rtl_loc_tax_mapping_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._retailLocationId, this._propertyCode };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "tax_rtl_loc_tax_mapping_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new RetailLocationTaxMappingPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class RetailLocationTaxMappingPropertyFiller
/*     */     implements IFiller {
/*     */     private RetailLocationTaxMappingPropertyDBA _parent;
/*     */     
/*     */     public RetailLocationTaxMappingPropertyFiller(RetailLocationTaxMappingPropertyDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       long primitiveResult = argResultSet.getLong(1);
/* 129 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 130 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 136 */       primitiveResult = argResultSet.getLong(2);
/* 137 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 138 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 142 */       this._parent._propertyCode = argResultSet.getString(3);
/* 143 */       this._parent._type = argResultSet.getString(4);
/* 144 */       this._parent._stringValue = argResultSet.getString(5);
/*     */       
/* 146 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 147 */       if (t6 != null) {
/* 148 */         this._parent._dateValue = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 154 */       this._parent._decimalValue = argResultSet.getBigDecimal(7);
/*     */       
/* 156 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 157 */       if (t8 != null) {
/* 158 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 161 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 164 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 166 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 167 */       if (t10 != null) {
/* 168 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 171 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 174 */       this._parent._updateUserId = argResultSet.getString(11);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 179 */     argDAO.suppressStateChanges(true);
/* 180 */     RetailLocationTaxMappingPropertyDAO dao = (RetailLocationTaxMappingPropertyDAO)argDAO;
/* 181 */     dao.setOrganizationId(this._organizationId);
/* 182 */     dao.setRetailLocationId(this._retailLocationId);
/* 183 */     dao.setPropertyCode(this._propertyCode);
/* 184 */     dao.setType(this._type);
/* 185 */     dao.setStringValue(this._stringValue);
/* 186 */     dao.setDateValue(this._dateValue);
/* 187 */     dao.setDecimalValue(this._decimalValue);
/* 188 */     dao.setCreateDate(this._createDate);
/* 189 */     dao.setCreateUserId(this._createUserId);
/* 190 */     dao.setUpdateDate(this._updateDate);
/* 191 */     dao.setUpdateUserId(this._updateUserId);
/* 192 */     argDAO.suppressStateChanges(false);
/* 193 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 197 */     return loadDAO((IDataAccessObject)new RetailLocationTaxMappingPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 201 */     RetailLocationTaxMappingPropertyDAO dao = (RetailLocationTaxMappingPropertyDAO)argDAO;
/* 202 */     this._organizationId = dao.getOrganizationId();
/* 203 */     this._retailLocationId = dao.getRetailLocationId();
/* 204 */     this._propertyCode = dao.getPropertyCode();
/* 205 */     this._type = dao.getType();
/* 206 */     this._stringValue = dao.getStringValue();
/* 207 */     this._dateValue = dao.getDateValue();
/* 208 */     this._decimalValue = dao.getDecimalValue();
/* 209 */     this._createDate = dao.getCreateDate();
/* 210 */     this._createUserId = dao.getCreateUserId();
/* 211 */     this._updateDate = dao.getUpdateDate();
/* 212 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 216 */     RetailLocationTaxMappingPropertyId id = (RetailLocationTaxMappingPropertyId)argId;
/* 217 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 218 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 219 */     argStatement.setString(3, id.getPropertyCode());
/* 220 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 224 */     RetailLocationTaxMappingPropertyId id = new RetailLocationTaxMappingPropertyId();
/* 225 */     id.setOrganizationId(this._organizationId);
/* 226 */     id.setRetailLocationId(this._retailLocationId);
/* 227 */     id.setPropertyCode(this._propertyCode);
/* 228 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 236 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 240 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\RetailLocationTaxMappingPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */