/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.PayrollPropertyId;
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
/*     */ public class PayrollPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -967794182L;
/*     */   private Long _retailLocId;
/*     */   private Long _partyId;
/*     */   private Long _organizationId;
/*     */   private Date _businessDate;
/*     */   private String _payrollCategory;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.rtl_loc_id, t.party_id, t.organization_id, t.business_date, t.payroll_category, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM thr_payroll_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE rtl_loc_id = ?  AND party_id = ?  AND organization_id = ?  AND business_date = ?  AND payroll_category = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.rtl_loc_id, t.party_id, t.organization_id, t.business_date, t.payroll_category, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM thr_payroll_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE rtl_loc_id = ?  AND party_id = ?  AND organization_id = ?  AND business_date = ?  AND payroll_category = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO thr_payroll_p(rtl_loc_id, party_id, organization_id, business_date, payroll_category, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._retailLocId, this._partyId, this._organizationId, this._businessDate, this._payrollCategory, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 91, 12, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE thr_payroll_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM thr_payroll_p" }; private static final String WHERE_OBJECT = " WHERE rtl_loc_id = ?  AND party_id = ?  AND organization_id = ?  AND business_date = ?  AND payroll_category = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE rtl_loc_id = ?  AND party_id = ?  AND organization_id = ?  AND business_date = ?  AND payroll_category = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._retailLocId, this._partyId, this._organizationId, this._businessDate, this._payrollCategory, this._propertyCode };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 91, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "thr_payroll_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new PayrollPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class PayrollPropertyFiller
/*     */     implements IFiller {
/*     */     private PayrollPropertyDBA _parent;
/*     */     
/*     */     public PayrollPropertyFiller(PayrollPropertyDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       long primitiveResult = argResultSet.getLong(1);
/* 132 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 133 */         this._parent._retailLocId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       primitiveResult = argResultSet.getLong(2);
/* 140 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 141 */         this._parent._partyId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 147 */       primitiveResult = argResultSet.getLong(3);
/* 148 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 149 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 154 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 155 */       if (t4 != null) {
/* 156 */         this._parent._businessDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 159 */         this._parent._businessDate = null;
/*     */       } 
/*     */       
/* 162 */       this._parent._payrollCategory = argResultSet.getString(5);
/* 163 */       this._parent._propertyCode = argResultSet.getString(6);
/* 164 */       this._parent._type = argResultSet.getString(7);
/* 165 */       this._parent._stringValue = argResultSet.getString(8);
/*     */       
/* 167 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 168 */       if (t9 != null) {
/* 169 */         this._parent._dateValue = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 172 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 175 */       this._parent._decimalValue = argResultSet.getBigDecimal(10);
/*     */       
/* 177 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 178 */       if (t11 != null) {
/* 179 */         this._parent._createDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 182 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 185 */       this._parent._createUserId = argResultSet.getString(12);
/*     */       
/* 187 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 188 */       if (t13 != null) {
/* 189 */         this._parent._updateDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 192 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 195 */       this._parent._updateUserId = argResultSet.getString(14);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 200 */     argDAO.suppressStateChanges(true);
/* 201 */     PayrollPropertyDAO dao = (PayrollPropertyDAO)argDAO;
/* 202 */     dao.setRetailLocId(this._retailLocId);
/* 203 */     dao.setPartyId(this._partyId);
/* 204 */     dao.setOrganizationId(this._organizationId);
/* 205 */     dao.setBusinessDate(this._businessDate);
/* 206 */     dao.setPayrollCategory(this._payrollCategory);
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
/* 221 */     return loadDAO((IDataAccessObject)new PayrollPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 225 */     PayrollPropertyDAO dao = (PayrollPropertyDAO)argDAO;
/* 226 */     this._retailLocId = dao.getRetailLocId();
/* 227 */     this._partyId = dao.getPartyId();
/* 228 */     this._organizationId = dao.getOrganizationId();
/* 229 */     this._businessDate = dao.getBusinessDate();
/* 230 */     this._payrollCategory = dao.getPayrollCategory();
/* 231 */     this._propertyCode = dao.getPropertyCode();
/* 232 */     this._type = dao.getType();
/* 233 */     this._stringValue = dao.getStringValue();
/* 234 */     this._dateValue = dao.getDateValue();
/* 235 */     this._decimalValue = dao.getDecimalValue();
/* 236 */     this._createDate = dao.getCreateDate();
/* 237 */     this._createUserId = dao.getCreateUserId();
/* 238 */     this._updateDate = dao.getUpdateDate();
/* 239 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 243 */     PayrollPropertyId id = (PayrollPropertyId)argId;
/* 244 */     argStatement.setLong(1, id.getRetailLocId().longValue());
/* 245 */     argStatement.setLong(2, id.getPartyId().longValue());
/* 246 */     argStatement.setLong(3, id.getOrganizationId().longValue());
/* 247 */     argStatement.setTimestamp(4, new Timestamp(id.getBusinessDate().getTime()));
/* 248 */     argStatement.setString(5, id.getPayrollCategory());
/* 249 */     argStatement.setString(6, id.getPropertyCode());
/* 250 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 254 */     PayrollPropertyId id = new PayrollPropertyId();
/* 255 */     id.setRetailLocId(this._retailLocId);
/* 256 */     id.setPartyId(this._partyId);
/* 257 */     id.setOrganizationId(this._organizationId);
/* 258 */     id.setBusinessDate(this._businessDate);
/* 259 */     id.setPayrollCategory(this._payrollCategory);
/* 260 */     id.setPropertyCode(this._propertyCode);
/* 261 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 269 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 273 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\PayrollPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */