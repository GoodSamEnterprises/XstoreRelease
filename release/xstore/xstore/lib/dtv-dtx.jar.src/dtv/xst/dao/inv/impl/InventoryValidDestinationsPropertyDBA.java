/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryValidDestinationsPropertyId;
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
/*     */ public class InventoryValidDestinationsPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 87833434L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _documentTypeCode;
/*     */   private String _documentSubtypeCode;
/*     */   private String _destinationTypeEnum;
/*     */   private String _destinationId;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.document_typcode, t.document_subtypcode, t.destination_type_enum, t.destination_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM inv_valid_destinations_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND document_typcode = ?  AND document_subtypcode = ?  AND destination_type_enum = ?  AND destination_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.rtl_loc_id, t.document_typcode, t.document_subtypcode, t.destination_type_enum, t.destination_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM inv_valid_destinations_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND document_typcode = ?  AND document_subtypcode = ?  AND destination_type_enum = ?  AND destination_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_valid_destinations_p(organization_id, rtl_loc_id, document_typcode, document_subtypcode, destination_type_enum, destination_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._documentTypeCode, this._documentSubtypeCode, this._destinationTypeEnum, this._destinationId, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 12, 12, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_valid_destinations_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_valid_destinations_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND document_typcode = ?  AND document_subtypcode = ?  AND destination_type_enum = ?  AND destination_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND document_typcode = ?  AND document_subtypcode = ?  AND destination_type_enum = ?  AND destination_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._retailLocationId, this._documentTypeCode, this._documentSubtypeCode, this._destinationTypeEnum, this._destinationId, this._propertyCode };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "inv_valid_destinations_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new InventoryValidDestinationsPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryValidDestinationsPropertyFiller
/*     */     implements IFiller {
/*     */     private InventoryValidDestinationsPropertyDBA _parent;
/*     */     
/*     */     public InventoryValidDestinationsPropertyFiller(InventoryValidDestinationsPropertyDBA argParent) {
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
/*     */ 
/*     */       
/* 140 */       primitiveResult = argResultSet.getLong(2);
/* 141 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 142 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 146 */       this._parent._documentTypeCode = argResultSet.getString(3);
/* 147 */       this._parent._documentSubtypeCode = argResultSet.getString(4);
/* 148 */       this._parent._destinationTypeEnum = argResultSet.getString(5);
/* 149 */       this._parent._destinationId = argResultSet.getString(6);
/* 150 */       this._parent._propertyCode = argResultSet.getString(7);
/* 151 */       this._parent._type = argResultSet.getString(8);
/* 152 */       this._parent._stringValue = argResultSet.getString(9);
/*     */       
/* 154 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 155 */       if (t10 != null) {
/* 156 */         this._parent._dateValue = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 159 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 162 */       this._parent._decimalValue = argResultSet.getBigDecimal(11);
/*     */       
/* 164 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 165 */       if (t12 != null) {
/* 166 */         this._parent._createDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 169 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 172 */       this._parent._createUserId = argResultSet.getString(13);
/*     */       
/* 174 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 175 */       if (t14 != null) {
/* 176 */         this._parent._updateDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 179 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 182 */       this._parent._updateUserId = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 187 */     argDAO.suppressStateChanges(true);
/* 188 */     InventoryValidDestinationsPropertyDAO dao = (InventoryValidDestinationsPropertyDAO)argDAO;
/* 189 */     dao.setOrganizationId(this._organizationId);
/* 190 */     dao.setRetailLocationId(this._retailLocationId);
/* 191 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 192 */     dao.setDocumentSubtypeCode(this._documentSubtypeCode);
/* 193 */     dao.setDestinationTypeEnum(this._destinationTypeEnum);
/* 194 */     dao.setDestinationId(this._destinationId);
/* 195 */     dao.setPropertyCode(this._propertyCode);
/* 196 */     dao.setType(this._type);
/* 197 */     dao.setStringValue(this._stringValue);
/* 198 */     dao.setDateValue(this._dateValue);
/* 199 */     dao.setDecimalValue(this._decimalValue);
/* 200 */     dao.setCreateDate(this._createDate);
/* 201 */     dao.setCreateUserId(this._createUserId);
/* 202 */     dao.setUpdateDate(this._updateDate);
/* 203 */     dao.setUpdateUserId(this._updateUserId);
/* 204 */     argDAO.suppressStateChanges(false);
/* 205 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 209 */     return loadDAO((IDataAccessObject)new InventoryValidDestinationsPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 213 */     InventoryValidDestinationsPropertyDAO dao = (InventoryValidDestinationsPropertyDAO)argDAO;
/* 214 */     this._organizationId = dao.getOrganizationId();
/* 215 */     this._retailLocationId = dao.getRetailLocationId();
/* 216 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 217 */     this._documentSubtypeCode = dao.getDocumentSubtypeCode();
/* 218 */     this._destinationTypeEnum = dao.getDestinationTypeEnum();
/* 219 */     this._destinationId = dao.getDestinationId();
/* 220 */     this._propertyCode = dao.getPropertyCode();
/* 221 */     this._type = dao.getType();
/* 222 */     this._stringValue = dao.getStringValue();
/* 223 */     this._dateValue = dao.getDateValue();
/* 224 */     this._decimalValue = dao.getDecimalValue();
/* 225 */     this._createDate = dao.getCreateDate();
/* 226 */     this._createUserId = dao.getCreateUserId();
/* 227 */     this._updateDate = dao.getUpdateDate();
/* 228 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 232 */     InventoryValidDestinationsPropertyId id = (InventoryValidDestinationsPropertyId)argId;
/* 233 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 234 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 235 */     argStatement.setString(3, id.getDocumentTypeCode());
/* 236 */     argStatement.setString(4, id.getDocumentSubtypeCode());
/* 237 */     argStatement.setString(5, id.getDestinationTypeEnum());
/* 238 */     argStatement.setString(6, id.getDestinationId());
/* 239 */     argStatement.setString(7, id.getPropertyCode());
/* 240 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 244 */     InventoryValidDestinationsPropertyId id = new InventoryValidDestinationsPropertyId();
/* 245 */     id.setOrganizationId(this._organizationId);
/* 246 */     id.setRetailLocationId(this._retailLocationId);
/* 247 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 248 */     id.setDocumentSubtypeCode(this._documentSubtypeCode);
/* 249 */     id.setDestinationTypeEnum(this._destinationTypeEnum);
/* 250 */     id.setDestinationId(this._destinationId);
/* 251 */     id.setPropertyCode(this._propertyCode);
/* 252 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 260 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 264 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryValidDestinationsPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */