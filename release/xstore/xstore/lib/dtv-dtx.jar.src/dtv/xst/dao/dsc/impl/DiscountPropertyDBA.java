/*     */ package dtv.xst.dao.dsc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.dsc.DiscountPropertyId;
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
/*     */ public class DiscountPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -892327338L;
/*     */   private String _discountCode;
/*     */   private Long _organizationId;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.discount_code, t.organization_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM dsc_discount_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE discount_code = ?  AND organization_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.discount_code, t.organization_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM dsc_discount_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE discount_code = ?  AND organization_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO dsc_discount_p(discount_code, organization_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._discountCode, this._organizationId, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE dsc_discount_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM dsc_discount_p" }; private static final String WHERE_OBJECT = " WHERE discount_code = ?  AND organization_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE discount_code = ?  AND organization_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._discountCode, this._organizationId, this._propertyCode };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "dsc_discount_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new DiscountPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class DiscountPropertyFiller
/*     */     implements IFiller {
/*     */     private DiscountPropertyDBA _parent;
/*     */     
/*     */     public DiscountPropertyFiller(DiscountPropertyDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 126 */       this._parent._discountCode = argResultSet.getString(1);
/*     */ 
/*     */       
/* 129 */       long primitiveResult = argResultSet.getLong(2);
/* 130 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 135 */       this._parent._propertyCode = argResultSet.getString(3);
/* 136 */       this._parent._type = argResultSet.getString(4);
/* 137 */       this._parent._stringValue = argResultSet.getString(5);
/*     */       
/* 139 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 140 */       if (t6 != null) {
/* 141 */         this._parent._dateValue = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 147 */       this._parent._decimalValue = argResultSet.getBigDecimal(7);
/*     */       
/* 149 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 150 */       if (t8 != null) {
/* 151 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 159 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 160 */       if (t10 != null) {
/* 161 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 164 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 167 */       this._parent._updateUserId = argResultSet.getString(11);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 172 */     argDAO.suppressStateChanges(true);
/* 173 */     DiscountPropertyDAO dao = (DiscountPropertyDAO)argDAO;
/* 174 */     dao.setDiscountCode(this._discountCode);
/* 175 */     dao.setOrganizationId(this._organizationId);
/* 176 */     dao.setPropertyCode(this._propertyCode);
/* 177 */     dao.setType(this._type);
/* 178 */     dao.setStringValue(this._stringValue);
/* 179 */     dao.setDateValue(this._dateValue);
/* 180 */     dao.setDecimalValue(this._decimalValue);
/* 181 */     dao.setCreateDate(this._createDate);
/* 182 */     dao.setCreateUserId(this._createUserId);
/* 183 */     dao.setUpdateDate(this._updateDate);
/* 184 */     dao.setUpdateUserId(this._updateUserId);
/* 185 */     argDAO.suppressStateChanges(false);
/* 186 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 190 */     return loadDAO((IDataAccessObject)new DiscountPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 194 */     DiscountPropertyDAO dao = (DiscountPropertyDAO)argDAO;
/* 195 */     this._discountCode = dao.getDiscountCode();
/* 196 */     this._organizationId = dao.getOrganizationId();
/* 197 */     this._propertyCode = dao.getPropertyCode();
/* 198 */     this._type = dao.getType();
/* 199 */     this._stringValue = dao.getStringValue();
/* 200 */     this._dateValue = dao.getDateValue();
/* 201 */     this._decimalValue = dao.getDecimalValue();
/* 202 */     this._createDate = dao.getCreateDate();
/* 203 */     this._createUserId = dao.getCreateUserId();
/* 204 */     this._updateDate = dao.getUpdateDate();
/* 205 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 209 */     DiscountPropertyId id = (DiscountPropertyId)argId;
/* 210 */     argStatement.setString(1, id.getDiscountCode());
/* 211 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 212 */     argStatement.setString(3, id.getPropertyCode());
/* 213 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 217 */     DiscountPropertyId id = new DiscountPropertyId();
/* 218 */     id.setDiscountCode(this._discountCode);
/* 219 */     id.setOrganizationId(this._organizationId);
/* 220 */     id.setPropertyCode(this._propertyCode);
/* 221 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 229 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 233 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\impl\DiscountPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */