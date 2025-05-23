/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.AirportPropertyId;
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
/*     */ public class AirportPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1481071520L;
/*     */   private Long _organizationId;
/*     */   private String _airportCode;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.airport_code, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM com_airport_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND airport_code = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.airport_code, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM com_airport_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND airport_code = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_airport_p(organization_id, airport_code, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._airportCode, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_airport_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_airport_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND airport_code = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND airport_code = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._airportCode, this._propertyCode };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "com_airport_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new AirportPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class AirportPropertyFiller
/*     */     implements IFiller {
/*     */     private AirportPropertyDBA _parent;
/*     */     
/*     */     public AirportPropertyFiller(AirportPropertyDBA argParent) {
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
/* 134 */       this._parent._airportCode = argResultSet.getString(2);
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
/* 173 */     AirportPropertyDAO dao = (AirportPropertyDAO)argDAO;
/* 174 */     dao.setOrganizationId(this._organizationId);
/* 175 */     dao.setAirportCode(this._airportCode);
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
/* 190 */     return loadDAO((IDataAccessObject)new AirportPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 194 */     AirportPropertyDAO dao = (AirportPropertyDAO)argDAO;
/* 195 */     this._organizationId = dao.getOrganizationId();
/* 196 */     this._airportCode = dao.getAirportCode();
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
/* 209 */     AirportPropertyId id = (AirportPropertyId)argId;
/* 210 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 211 */     argStatement.setString(2, id.getAirportCode());
/* 212 */     argStatement.setString(3, id.getPropertyCode());
/* 213 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 217 */     AirportPropertyId id = new AirportPropertyId();
/* 218 */     id.setOrganizationId(this._organizationId);
/* 219 */     id.setAirportCode(this._airportCode);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AirportPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */