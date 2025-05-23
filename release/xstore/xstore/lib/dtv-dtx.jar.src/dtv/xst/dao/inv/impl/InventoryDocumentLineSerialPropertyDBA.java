/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryDocumentLineSerialPropertyId;
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
/*     */ public class InventoryDocumentLineSerialPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1974686764L;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _serialLineNumber;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.invctl_document_id, t.document_typcode, t.invctl_document_line_nbr, t.organization_id, t.rtl_loc_id, t.serial_line_nbr, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM inv_invctl_doc_lineserial_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND serial_line_nbr = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.invctl_document_id, t.document_typcode, t.invctl_document_line_nbr, t.organization_id, t.rtl_loc_id, t.serial_line_nbr, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM inv_invctl_doc_lineserial_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND serial_line_nbr = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_invctl_doc_lineserial_p(invctl_document_id, document_typcode, invctl_document_line_nbr, organization_id, rtl_loc_id, serial_line_nbr, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._documentId, this._documentTypeCode, this._inventoryDocumentLineNumber, this._organizationId, this._retailLocationId, this._serialLineNumber, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, 12, 4, -5, -5, 4, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_invctl_doc_lineserial_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_invctl_doc_lineserial_p" }; private static final String WHERE_OBJECT = " WHERE invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND serial_line_nbr = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND serial_line_nbr = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._documentId, this._documentTypeCode, this._inventoryDocumentLineNumber, this._organizationId, this._retailLocationId, this._serialLineNumber, this._propertyCode };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, 12, 4, -5, -5, 4, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "inv_invctl_doc_lineserial_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new InventoryDocumentLineSerialPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryDocumentLineSerialPropertyFiller
/*     */     implements IFiller {
/*     */     private InventoryDocumentLineSerialPropertyDBA _parent;
/*     */     
/*     */     public InventoryDocumentLineSerialPropertyFiller(InventoryDocumentLineSerialPropertyDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       this._parent._documentId = argResultSet.getString(1);
/* 131 */       this._parent._documentTypeCode = argResultSet.getString(2);
/*     */ 
/*     */       
/* 134 */       int i = argResultSet.getInt(3);
/* 135 */       if (i != 0 || argResultSet.getObject(3) != null) {
/* 136 */         this._parent._inventoryDocumentLineNumber = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       long l = argResultSet.getLong(4);
/* 143 */       if (l != 0L || argResultSet.getObject(4) != null) {
/* 144 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 150 */       l = argResultSet.getLong(5);
/* 151 */       if (l != 0L || argResultSet.getObject(5) != null) {
/* 152 */         this._parent._retailLocationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 158 */       int primitiveResult = argResultSet.getInt(6);
/* 159 */       if (primitiveResult != 0 || argResultSet.getObject(6) != null) {
/* 160 */         this._parent._serialLineNumber = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 164 */       this._parent._propertyCode = argResultSet.getString(7);
/* 165 */       this._parent._type = argResultSet.getString(8);
/* 166 */       this._parent._stringValue = argResultSet.getString(9);
/*     */       
/* 168 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 169 */       if (t10 != null) {
/* 170 */         this._parent._dateValue = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 173 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 176 */       this._parent._decimalValue = argResultSet.getBigDecimal(11);
/*     */       
/* 178 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 179 */       if (t12 != null) {
/* 180 */         this._parent._createDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 183 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 186 */       this._parent._createUserId = argResultSet.getString(13);
/*     */       
/* 188 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 189 */       if (t14 != null) {
/* 190 */         this._parent._updateDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 193 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 196 */       this._parent._updateUserId = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 201 */     argDAO.suppressStateChanges(true);
/* 202 */     InventoryDocumentLineSerialPropertyDAO dao = (InventoryDocumentLineSerialPropertyDAO)argDAO;
/* 203 */     dao.setDocumentId(this._documentId);
/* 204 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 205 */     dao.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 206 */     dao.setOrganizationId(this._organizationId);
/* 207 */     dao.setRetailLocationId(this._retailLocationId);
/* 208 */     dao.setSerialLineNumber(this._serialLineNumber);
/* 209 */     dao.setPropertyCode(this._propertyCode);
/* 210 */     dao.setType(this._type);
/* 211 */     dao.setStringValue(this._stringValue);
/* 212 */     dao.setDateValue(this._dateValue);
/* 213 */     dao.setDecimalValue(this._decimalValue);
/* 214 */     dao.setCreateDate(this._createDate);
/* 215 */     dao.setCreateUserId(this._createUserId);
/* 216 */     dao.setUpdateDate(this._updateDate);
/* 217 */     dao.setUpdateUserId(this._updateUserId);
/* 218 */     argDAO.suppressStateChanges(false);
/* 219 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 223 */     return loadDAO((IDataAccessObject)new InventoryDocumentLineSerialPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 227 */     InventoryDocumentLineSerialPropertyDAO dao = (InventoryDocumentLineSerialPropertyDAO)argDAO;
/* 228 */     this._documentId = dao.getDocumentId();
/* 229 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 230 */     this._inventoryDocumentLineNumber = dao.getInventoryDocumentLineNumber();
/* 231 */     this._organizationId = dao.getOrganizationId();
/* 232 */     this._retailLocationId = dao.getRetailLocationId();
/* 233 */     this._serialLineNumber = dao.getSerialLineNumber();
/* 234 */     this._propertyCode = dao.getPropertyCode();
/* 235 */     this._type = dao.getType();
/* 236 */     this._stringValue = dao.getStringValue();
/* 237 */     this._dateValue = dao.getDateValue();
/* 238 */     this._decimalValue = dao.getDecimalValue();
/* 239 */     this._createDate = dao.getCreateDate();
/* 240 */     this._createUserId = dao.getCreateUserId();
/* 241 */     this._updateDate = dao.getUpdateDate();
/* 242 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 246 */     InventoryDocumentLineSerialPropertyId id = (InventoryDocumentLineSerialPropertyId)argId;
/* 247 */     argStatement.setString(1, id.getDocumentId());
/* 248 */     argStatement.setString(2, id.getDocumentTypeCode());
/* 249 */     argStatement.setInt(3, id.getInventoryDocumentLineNumber().intValue());
/* 250 */     argStatement.setLong(4, id.getOrganizationId().longValue());
/* 251 */     argStatement.setLong(5, id.getRetailLocationId().longValue());
/* 252 */     argStatement.setInt(6, id.getSerialLineNumber().intValue());
/* 253 */     argStatement.setString(7, id.getPropertyCode());
/* 254 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 258 */     InventoryDocumentLineSerialPropertyId id = new InventoryDocumentLineSerialPropertyId();
/* 259 */     id.setDocumentId(this._documentId);
/* 260 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 261 */     id.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 262 */     id.setOrganizationId(this._organizationId);
/* 263 */     id.setRetailLocationId(this._retailLocationId);
/* 264 */     id.setSerialLineNumber(this._serialLineNumber);
/* 265 */     id.setPropertyCode(this._propertyCode);
/* 266 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 274 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 278 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentLineSerialPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */