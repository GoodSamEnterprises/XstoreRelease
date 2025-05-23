/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.DocumentInventoryLocationModifierId;
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
/*     */ public class DocumentInventoryLocationModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 432445997L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Long _documentLineNumber;
/*     */   private Long _modifierSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _serialNumber;
/*     */   private String _sourceLocationId;
/*     */   private String _sourceBucketId;
/*     */   private String _destinationLocationId;
/*     */   private String _destinationBucketId;
/*     */   private String _itemId;
/*     */   private BigDecimal _quantity;
/*     */   private String _actionCode;
/*     */   private BigDecimal _cost;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.document_id, t.document_typcode, t.document_line_nbr, t.mod_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.serial_nbr, t.source_location_id, t.source_bucket_id, t.dest_location_id, t.dest_bucket_id, t.item_id, t.quantity, t.action_code, t.cost FROM inv_inventory_loc_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND document_id = ?  AND document_typcode = ?  AND document_line_nbr = ?  AND mod_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  48 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  52 */     return "SELECT t.organization_id, t.rtl_loc_id, t.document_id, t.document_typcode, t.document_line_nbr, t.mod_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.serial_nbr, t.source_location_id, t.source_bucket_id, t.dest_location_id, t.dest_bucket_id, t.item_id, t.quantity, t.action_code, t.cost FROM inv_inventory_loc_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  58 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND document_id = ?  AND document_typcode = ?  AND document_line_nbr = ?  AND mod_seq = ?  ";
/*     */   }
/*     */   
/*  61 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_inventory_loc_mod(organization_id, rtl_loc_id, document_id, document_typcode, document_line_nbr, mod_seq, create_date, create_user_id, update_date, update_user_id, serial_nbr, source_location_id, source_bucket_id, dest_location_id, dest_bucket_id, item_id, quantity, action_code, cost) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  64 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  68 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._documentId, this._documentTypeCode, this._documentLineNumber, this._modifierSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._serialNumber, this._sourceLocationId, this._sourceBucketId, this._destinationLocationId, this._destinationBucketId, this._itemId, this._quantity, this._actionCode, this._cost } };
/*  69 */     return insertParameterObject;
/*     */   }
/*     */   
/*  72 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, -5, -5, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 3, 12, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  75 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  78 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_inventory_loc_mod SET update_date = ?, update_user_id = ?, serial_nbr = ?, source_location_id = ?, source_bucket_id = ?, dest_location_id = ?, dest_bucket_id = ?, item_id = ?, quantity = ?, action_code = ?, cost = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  81 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  85 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._serialNumber, this._sourceLocationId, this._sourceBucketId, this._destinationLocationId, this._destinationBucketId, this._itemId, this._quantity, this._actionCode, this._cost } };
/*  86 */     return updateParameterObject;
/*     */   }
/*     */   
/*  89 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 3, 12, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  91 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  94 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_inventory_loc_mod" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND document_id = ?  AND document_typcode = ?  AND document_line_nbr = ?  AND mod_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  97 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 103 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND document_id = ?  AND document_typcode = ?  AND document_line_nbr = ?  AND mod_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 106 */     return new Object[] { this._organizationId, this._retailLocationId, this._documentId, this._documentTypeCode, this._documentLineNumber, this._modifierSequence };
/*     */   }
/*     */   
/* 109 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 112 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 115 */     return "inv_inventory_loc_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 119 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 123 */     return new DocumentInventoryLocationModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class DocumentInventoryLocationModifierFiller
/*     */     implements IFiller {
/*     */     private DocumentInventoryLocationModifierDBA _parent;
/*     */     
/*     */     public DocumentInventoryLocationModifierFiller(DocumentInventoryLocationModifierDBA argParent) {
/* 131 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 136 */       long primitiveResult = argResultSet.getLong(1);
/* 137 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 138 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 144 */       primitiveResult = argResultSet.getLong(2);
/* 145 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 146 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 150 */       this._parent._documentId = argResultSet.getString(3);
/* 151 */       this._parent._documentTypeCode = argResultSet.getString(4);
/*     */ 
/*     */       
/* 154 */       primitiveResult = argResultSet.getLong(5);
/* 155 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 156 */         this._parent._documentLineNumber = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 162 */       primitiveResult = argResultSet.getLong(6);
/* 163 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 164 */         this._parent._modifierSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 169 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 170 */       if (t7 != null) {
/* 171 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 174 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 177 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 179 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 180 */       if (t9 != null) {
/* 181 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 184 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 187 */       this._parent._updateUserId = argResultSet.getString(10);
/* 188 */       this._parent._serialNumber = argResultSet.getString(11);
/* 189 */       this._parent._sourceLocationId = argResultSet.getString(12);
/* 190 */       this._parent._sourceBucketId = argResultSet.getString(13);
/* 191 */       this._parent._destinationLocationId = argResultSet.getString(14);
/* 192 */       this._parent._destinationBucketId = argResultSet.getString(15);
/* 193 */       this._parent._itemId = argResultSet.getString(16);
/* 194 */       this._parent._quantity = argResultSet.getBigDecimal(17);
/* 195 */       this._parent._actionCode = argResultSet.getString(18);
/* 196 */       this._parent._cost = argResultSet.getBigDecimal(19);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 201 */     argDAO.suppressStateChanges(true);
/* 202 */     DocumentInventoryLocationModifierDAO dao = (DocumentInventoryLocationModifierDAO)argDAO;
/* 203 */     dao.setOrganizationId(this._organizationId);
/* 204 */     dao.setRetailLocationId(this._retailLocationId);
/* 205 */     dao.setDocumentId(this._documentId);
/* 206 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 207 */     dao.setDocumentLineNumber(this._documentLineNumber);
/* 208 */     dao.setModifierSequence(this._modifierSequence);
/* 209 */     dao.setCreateDate(this._createDate);
/* 210 */     dao.setCreateUserId(this._createUserId);
/* 211 */     dao.setUpdateDate(this._updateDate);
/* 212 */     dao.setUpdateUserId(this._updateUserId);
/* 213 */     dao.setSerialNumber(this._serialNumber);
/* 214 */     dao.setSourceLocationId(this._sourceLocationId);
/* 215 */     dao.setSourceBucketId(this._sourceBucketId);
/* 216 */     dao.setDestinationLocationId(this._destinationLocationId);
/* 217 */     dao.setDestinationBucketId(this._destinationBucketId);
/* 218 */     dao.setItemId(this._itemId);
/* 219 */     dao.setQuantity(this._quantity);
/* 220 */     dao.setActionCode(this._actionCode);
/* 221 */     dao.setCost(this._cost);
/* 222 */     argDAO.suppressStateChanges(false);
/* 223 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 227 */     return loadDAO((IDataAccessObject)new DocumentInventoryLocationModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 231 */     DocumentInventoryLocationModifierDAO dao = (DocumentInventoryLocationModifierDAO)argDAO;
/* 232 */     this._organizationId = dao.getOrganizationId();
/* 233 */     this._retailLocationId = dao.getRetailLocationId();
/* 234 */     this._documentId = dao.getDocumentId();
/* 235 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 236 */     this._documentLineNumber = dao.getDocumentLineNumber();
/* 237 */     this._modifierSequence = dao.getModifierSequence();
/* 238 */     this._createDate = dao.getCreateDate();
/* 239 */     this._createUserId = dao.getCreateUserId();
/* 240 */     this._updateDate = dao.getUpdateDate();
/* 241 */     this._updateUserId = dao.getUpdateUserId();
/* 242 */     this._serialNumber = dao.getSerialNumber();
/* 243 */     this._sourceLocationId = dao.getSourceLocationId();
/* 244 */     this._sourceBucketId = dao.getSourceBucketId();
/* 245 */     this._destinationLocationId = dao.getDestinationLocationId();
/* 246 */     this._destinationBucketId = dao.getDestinationBucketId();
/* 247 */     this._itemId = dao.getItemId();
/* 248 */     this._quantity = dao.getQuantity();
/* 249 */     this._actionCode = dao.getActionCode();
/* 250 */     this._cost = dao.getCost();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 254 */     DocumentInventoryLocationModifierId id = (DocumentInventoryLocationModifierId)argId;
/* 255 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 256 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 257 */     argStatement.setString(3, id.getDocumentId());
/* 258 */     argStatement.setString(4, id.getDocumentTypeCode());
/* 259 */     argStatement.setLong(5, id.getDocumentLineNumber().longValue());
/* 260 */     argStatement.setLong(6, id.getModifierSequence().longValue());
/* 261 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 265 */     DocumentInventoryLocationModifierId id = new DocumentInventoryLocationModifierId();
/* 266 */     id.setOrganizationId(this._organizationId);
/* 267 */     id.setRetailLocationId(this._retailLocationId);
/* 268 */     id.setDocumentId(this._documentId);
/* 269 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 270 */     id.setDocumentLineNumber(this._documentLineNumber);
/* 271 */     id.setModifierSequence(this._modifierSequence);
/* 272 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 280 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 284 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\DocumentInventoryLocationModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */