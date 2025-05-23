/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.CartonPropertyId;
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
/*     */ public class CartonPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -883564524L;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private String _cartonId;
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
/*     */   private static final String SELECT_OBJECT = "SELECT t.invctl_document_id, t.document_typcode, t.carton_id, t.organization_id, t.rtl_loc_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM inv_carton_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE invctl_document_id = ?  AND document_typcode = ?  AND carton_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.invctl_document_id, t.document_typcode, t.carton_id, t.organization_id, t.rtl_loc_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM inv_carton_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE invctl_document_id = ?  AND document_typcode = ?  AND carton_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_carton_p(invctl_document_id, document_typcode, carton_id, organization_id, rtl_loc_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._documentId, this._documentTypeCode, this._cartonId, this._organizationId, this._retailLocationId, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, 12, 12, -5, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_carton_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_carton_p" }; private static final String WHERE_OBJECT = " WHERE invctl_document_id = ?  AND document_typcode = ?  AND carton_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE invctl_document_id = ?  AND document_typcode = ?  AND carton_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._documentId, this._documentTypeCode, this._cartonId, this._organizationId, this._retailLocationId, this._propertyCode };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, 12, 12, -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "inv_carton_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new CartonPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class CartonPropertyFiller
/*     */     implements IFiller {
/*     */     private CartonPropertyDBA _parent;
/*     */     
/*     */     public CartonPropertyFiller(CartonPropertyDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       this._parent._documentId = argResultSet.getString(1);
/* 130 */       this._parent._documentTypeCode = argResultSet.getString(2);
/* 131 */       this._parent._cartonId = argResultSet.getString(3);
/*     */ 
/*     */       
/* 134 */       long primitiveResult = argResultSet.getLong(4);
/* 135 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 136 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       primitiveResult = argResultSet.getLong(5);
/* 143 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 144 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 148 */       this._parent._propertyCode = argResultSet.getString(6);
/* 149 */       this._parent._type = argResultSet.getString(7);
/* 150 */       this._parent._stringValue = argResultSet.getString(8);
/*     */       
/* 152 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 153 */       if (t9 != null) {
/* 154 */         this._parent._dateValue = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._decimalValue = argResultSet.getBigDecimal(10);
/*     */       
/* 162 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 163 */       if (t11 != null) {
/* 164 */         this._parent._createDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 167 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 170 */       this._parent._createUserId = argResultSet.getString(12);
/*     */       
/* 172 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 173 */       if (t13 != null) {
/* 174 */         this._parent._updateDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 177 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 180 */       this._parent._updateUserId = argResultSet.getString(14);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 185 */     argDAO.suppressStateChanges(true);
/* 186 */     CartonPropertyDAO dao = (CartonPropertyDAO)argDAO;
/* 187 */     dao.setDocumentId(this._documentId);
/* 188 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 189 */     dao.setCartonId(this._cartonId);
/* 190 */     dao.setOrganizationId(this._organizationId);
/* 191 */     dao.setRetailLocationId(this._retailLocationId);
/* 192 */     dao.setPropertyCode(this._propertyCode);
/* 193 */     dao.setType(this._type);
/* 194 */     dao.setStringValue(this._stringValue);
/* 195 */     dao.setDateValue(this._dateValue);
/* 196 */     dao.setDecimalValue(this._decimalValue);
/* 197 */     dao.setCreateDate(this._createDate);
/* 198 */     dao.setCreateUserId(this._createUserId);
/* 199 */     dao.setUpdateDate(this._updateDate);
/* 200 */     dao.setUpdateUserId(this._updateUserId);
/* 201 */     argDAO.suppressStateChanges(false);
/* 202 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 206 */     return loadDAO((IDataAccessObject)new CartonPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 210 */     CartonPropertyDAO dao = (CartonPropertyDAO)argDAO;
/* 211 */     this._documentId = dao.getDocumentId();
/* 212 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 213 */     this._cartonId = dao.getCartonId();
/* 214 */     this._organizationId = dao.getOrganizationId();
/* 215 */     this._retailLocationId = dao.getRetailLocationId();
/* 216 */     this._propertyCode = dao.getPropertyCode();
/* 217 */     this._type = dao.getType();
/* 218 */     this._stringValue = dao.getStringValue();
/* 219 */     this._dateValue = dao.getDateValue();
/* 220 */     this._decimalValue = dao.getDecimalValue();
/* 221 */     this._createDate = dao.getCreateDate();
/* 222 */     this._createUserId = dao.getCreateUserId();
/* 223 */     this._updateDate = dao.getUpdateDate();
/* 224 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 228 */     CartonPropertyId id = (CartonPropertyId)argId;
/* 229 */     argStatement.setString(1, id.getDocumentId());
/* 230 */     argStatement.setString(2, id.getDocumentTypeCode());
/* 231 */     argStatement.setString(3, id.getCartonId());
/* 232 */     argStatement.setLong(4, id.getOrganizationId().longValue());
/* 233 */     argStatement.setLong(5, id.getRetailLocationId().longValue());
/* 234 */     argStatement.setString(6, id.getPropertyCode());
/* 235 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 239 */     CartonPropertyId id = new CartonPropertyId();
/* 240 */     id.setDocumentId(this._documentId);
/* 241 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 242 */     id.setCartonId(this._cartonId);
/* 243 */     id.setOrganizationId(this._organizationId);
/* 244 */     id.setRetailLocationId(this._retailLocationId);
/* 245 */     id.setPropertyCode(this._propertyCode);
/* 246 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 254 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 258 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\CartonPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */