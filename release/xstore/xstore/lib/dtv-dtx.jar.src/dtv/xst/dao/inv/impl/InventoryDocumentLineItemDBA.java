/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryDocumentLineItemId;
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
/*     */ public class InventoryDocumentLineItemDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 652670142L;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _inventoryItemId;
/*     */   private Date _lineItemBusinessDate;
/*     */   private Long _lineItemRetailLocationId;
/*     */   private Integer _lineItemRetailTransactionLineItemSequence;
/*     */   private Long _lineItemTransactionSequence;
/*     */   private String _lineItemTypeCode;
/*     */   private Long _lineItemWorkstationId;
/*     */   private String _statusCode;
/*     */   private String _serialNumber;
/*     */   private BigDecimal _unitCount;
/*     */   private BigDecimal _unitCost;
/*     */   private BigDecimal _expectedCount;
/*     */   private BigDecimal _postedCount;
/*     */   private BigDecimal _postedCost;
/*     */   private String _recordCreationType;
/*     */   private String _enteredItemDescription;
/*     */   private String _enteredItemId;
/*     */   private String _cartonId;
/*     */   private BigDecimal _retail;
/*     */   private String _modelNumber;
/*     */   private String _originalBucketId;
/*     */   private String _originalLocationId;
/*     */   private String _controlNumber;
/*     */   private BigDecimal _shippingWeight;
/*     */   private static final String SELECT_OBJECT = "SELECT t.invctl_document_id, t.document_typcode, t.invctl_document_line_nbr, t.organization_id, t.rtl_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.inventory_item_id, t.lineitm_business_date, t.lineitm_rtl_loc_id, t.lineitm_rtrans_lineitm_seq, t.lineitm_trans_seq, t.lineitm_typcode, t.lineitm_wkstn_id, t.status_code, t.serial_number, t.unit_count, t.unit_cost, t.expected_count, t.posted_count, t.posted_cost, t.record_creation_type, t.entered_item_description, t.entered_item_id, t.carton_id, t.retail, t.model_nbr, t.original_bucket_id, t.original_loc_id, t.control_number, t.shipping_weight FROM inv_invctl_document_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  62 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  66 */     return "SELECT t.invctl_document_id, t.document_typcode, t.invctl_document_line_nbr, t.organization_id, t.rtl_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.inventory_item_id, t.lineitm_business_date, t.lineitm_rtl_loc_id, t.lineitm_rtrans_lineitm_seq, t.lineitm_trans_seq, t.lineitm_typcode, t.lineitm_wkstn_id, t.status_code, t.serial_number, t.unit_count, t.unit_cost, t.expected_count, t.posted_count, t.posted_cost, t.record_creation_type, t.entered_item_description, t.entered_item_id, t.carton_id, t.retail, t.model_nbr, t.original_bucket_id, t.original_loc_id, t.control_number, t.shipping_weight FROM inv_invctl_document_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  72 */     return " WHERE invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   
/*  75 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_invctl_document_lineitm(invctl_document_id, document_typcode, invctl_document_line_nbr, organization_id, rtl_loc_id, create_date, create_user_id, update_date, update_user_id, inventory_item_id, lineitm_business_date, lineitm_rtl_loc_id, lineitm_rtrans_lineitm_seq, lineitm_trans_seq, lineitm_typcode, lineitm_wkstn_id, status_code, serial_number, unit_count, unit_cost, expected_count, posted_count, posted_cost, record_creation_type, entered_item_description, entered_item_id, carton_id, retail, model_nbr, original_bucket_id, original_loc_id, control_number, shipping_weight) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  78 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  82 */     Object[][] insertParameterObject = { { this._documentId, this._documentTypeCode, this._inventoryDocumentLineNumber, this._organizationId, this._retailLocationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._inventoryItemId, this._lineItemBusinessDate, this._lineItemRetailLocationId, this._lineItemRetailTransactionLineItemSequence, this._lineItemTransactionSequence, this._lineItemTypeCode, this._lineItemWorkstationId, this._statusCode, this._serialNumber, this._unitCount, this._unitCost, this._expectedCount, this._postedCount, this._postedCost, this._recordCreationType, this._enteredItemDescription, this._enteredItemId, this._cartonId, this._retail, this._modelNumber, this._originalBucketId, this._originalLocationId, this._controlNumber, this._shippingWeight } };
/*  83 */     return insertParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, 12, 4, -5, -5, 91, 12, 91, 12, 12, 91, -5, 4, -5, 12, -5, 12, 12, 3, 3, 3, 3, 3, 12, 12, 12, 12, 3, 12, 12, 12, 12, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  89 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_invctl_document_lineitm SET update_date = ?, update_user_id = ?, inventory_item_id = ?, lineitm_business_date = ?, lineitm_rtl_loc_id = ?, lineitm_rtrans_lineitm_seq = ?, lineitm_trans_seq = ?, lineitm_typcode = ?, lineitm_wkstn_id = ?, status_code = ?, serial_number = ?, unit_count = ?, unit_cost = ?, expected_count = ?, posted_count = ?, posted_cost = ?, record_creation_type = ?, entered_item_description = ?, entered_item_id = ?, carton_id = ?, retail = ?, model_nbr = ?, original_bucket_id = ?, original_loc_id = ?, control_number = ?, shipping_weight = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  95 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  99 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._inventoryItemId, this._lineItemBusinessDate, this._lineItemRetailLocationId, this._lineItemRetailTransactionLineItemSequence, this._lineItemTransactionSequence, this._lineItemTypeCode, this._lineItemWorkstationId, this._statusCode, this._serialNumber, this._unitCount, this._unitCost, this._expectedCount, this._postedCount, this._postedCost, this._recordCreationType, this._enteredItemDescription, this._enteredItemId, this._cartonId, this._retail, this._modelNumber, this._originalBucketId, this._originalLocationId, this._controlNumber, this._shippingWeight } };
/* 100 */     return updateParameterObject;
/*     */   }
/*     */   
/* 103 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 91, -5, 4, -5, 12, -5, 12, 12, 3, 3, 3, 3, 3, 12, 12, 12, 12, 3, 12, 12, 12, 12, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 105 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 108 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_invctl_document_lineitm" }; private static final String WHERE_OBJECT = " WHERE invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 111 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 117 */     return " WHERE invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 120 */     return new Object[] { this._documentId, this._documentTypeCode, this._inventoryDocumentLineNumber, this._organizationId, this._retailLocationId };
/*     */   }
/*     */   
/* 123 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, 12, 4, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 126 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 129 */     return "inv_invctl_document_lineitm";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 133 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 137 */     return new InventoryDocumentLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryDocumentLineItemFiller
/*     */     implements IFiller {
/*     */     private InventoryDocumentLineItemDBA _parent;
/*     */     
/*     */     public InventoryDocumentLineItemFiller(InventoryDocumentLineItemDBA argParent) {
/* 145 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 148 */       this._parent._documentId = argResultSet.getString(1);
/* 149 */       this._parent._documentTypeCode = argResultSet.getString(2);
/*     */ 
/*     */       
/* 152 */       int i = argResultSet.getInt(3);
/* 153 */       if (i != 0 || argResultSet.getObject(3) != null) {
/* 154 */         this._parent._inventoryDocumentLineNumber = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 160 */       long primitiveResult = argResultSet.getLong(4);
/* 161 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 162 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 168 */       primitiveResult = argResultSet.getLong(5);
/* 169 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 170 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 175 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 176 */       if (t6 != null) {
/* 177 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 183 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 185 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 186 */       if (t8 != null) {
/* 187 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 190 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 193 */       this._parent._updateUserId = argResultSet.getString(9);
/* 194 */       this._parent._inventoryItemId = argResultSet.getString(10);
/*     */       
/* 196 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 197 */       if (t11 != null) {
/* 198 */         this._parent._lineItemBusinessDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 201 */         this._parent._lineItemBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 206 */       long l2 = argResultSet.getLong(12);
/* 207 */       if (l2 != 0L || argResultSet.getObject(12) != null) {
/* 208 */         this._parent._lineItemRetailLocationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 214 */       int j = argResultSet.getInt(13);
/* 215 */       if (j != 0 || argResultSet.getObject(13) != null) {
/* 216 */         this._parent._lineItemRetailTransactionLineItemSequence = Integer.valueOf(j);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 222 */       long l1 = argResultSet.getLong(14);
/* 223 */       if (l1 != 0L || argResultSet.getObject(14) != null) {
/* 224 */         this._parent._lineItemTransactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 228 */       this._parent._lineItemTypeCode = argResultSet.getString(15);
/*     */ 
/*     */       
/* 231 */       l1 = argResultSet.getLong(16);
/* 232 */       if (l1 != 0L || argResultSet.getObject(16) != null) {
/* 233 */         this._parent._lineItemWorkstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 237 */       this._parent._statusCode = argResultSet.getString(17);
/* 238 */       this._parent._serialNumber = argResultSet.getString(18);
/* 239 */       this._parent._unitCount = argResultSet.getBigDecimal(19);
/* 240 */       this._parent._unitCost = argResultSet.getBigDecimal(20);
/* 241 */       this._parent._expectedCount = argResultSet.getBigDecimal(21);
/* 242 */       this._parent._postedCount = argResultSet.getBigDecimal(22);
/* 243 */       this._parent._postedCost = argResultSet.getBigDecimal(23);
/* 244 */       this._parent._recordCreationType = argResultSet.getString(24);
/* 245 */       this._parent._enteredItemDescription = argResultSet.getString(25);
/* 246 */       this._parent._enteredItemId = argResultSet.getString(26);
/* 247 */       this._parent._cartonId = argResultSet.getString(27);
/* 248 */       this._parent._retail = argResultSet.getBigDecimal(28);
/* 249 */       this._parent._modelNumber = argResultSet.getString(29);
/* 250 */       this._parent._originalBucketId = argResultSet.getString(30);
/* 251 */       this._parent._originalLocationId = argResultSet.getString(31);
/* 252 */       this._parent._controlNumber = argResultSet.getString(32);
/* 253 */       this._parent._shippingWeight = argResultSet.getBigDecimal(33);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 258 */     argDAO.suppressStateChanges(true);
/* 259 */     InventoryDocumentLineItemDAO dao = (InventoryDocumentLineItemDAO)argDAO;
/* 260 */     dao.setDocumentId(this._documentId);
/* 261 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 262 */     dao.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 263 */     dao.setOrganizationId(this._organizationId);
/* 264 */     dao.setRetailLocationId(this._retailLocationId);
/* 265 */     dao.setCreateDate(this._createDate);
/* 266 */     dao.setCreateUserId(this._createUserId);
/* 267 */     dao.setUpdateDate(this._updateDate);
/* 268 */     dao.setUpdateUserId(this._updateUserId);
/* 269 */     dao.setInventoryItemId(this._inventoryItemId);
/* 270 */     dao.setLineItemBusinessDate(this._lineItemBusinessDate);
/* 271 */     dao.setLineItemRetailLocationId(this._lineItemRetailLocationId);
/* 272 */     dao.setLineItemRetailTransactionLineItemSequence(this._lineItemRetailTransactionLineItemSequence);
/* 273 */     dao.setLineItemTransactionSequence(this._lineItemTransactionSequence);
/* 274 */     dao.setLineItemTypeCode(this._lineItemTypeCode);
/* 275 */     dao.setLineItemWorkstationId(this._lineItemWorkstationId);
/* 276 */     dao.setStatusCode(this._statusCode);
/* 277 */     dao.setSerialNumber(this._serialNumber);
/* 278 */     dao.setUnitCount(this._unitCount);
/* 279 */     dao.setUnitCost(this._unitCost);
/* 280 */     dao.setExpectedCount(this._expectedCount);
/* 281 */     dao.setPostedCount(this._postedCount);
/* 282 */     dao.setPostedCost(this._postedCost);
/* 283 */     dao.setRecordCreationType(this._recordCreationType);
/* 284 */     dao.setEnteredItemDescription(this._enteredItemDescription);
/* 285 */     dao.setEnteredItemId(this._enteredItemId);
/* 286 */     dao.setCartonId(this._cartonId);
/* 287 */     dao.setRetail(this._retail);
/* 288 */     dao.setModelNumber(this._modelNumber);
/* 289 */     dao.setOriginalBucketId(this._originalBucketId);
/* 290 */     dao.setOriginalLocationId(this._originalLocationId);
/* 291 */     dao.setControlNumber(this._controlNumber);
/* 292 */     dao.setShippingWeight(this._shippingWeight);
/* 293 */     argDAO.suppressStateChanges(false);
/* 294 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 298 */     return loadDAO((IDataAccessObject)new InventoryDocumentLineItemDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 302 */     InventoryDocumentLineItemDAO dao = (InventoryDocumentLineItemDAO)argDAO;
/* 303 */     this._documentId = dao.getDocumentId();
/* 304 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 305 */     this._inventoryDocumentLineNumber = dao.getInventoryDocumentLineNumber();
/* 306 */     this._organizationId = dao.getOrganizationId();
/* 307 */     this._retailLocationId = dao.getRetailLocationId();
/* 308 */     this._createDate = dao.getCreateDate();
/* 309 */     this._createUserId = dao.getCreateUserId();
/* 310 */     this._updateDate = dao.getUpdateDate();
/* 311 */     this._updateUserId = dao.getUpdateUserId();
/* 312 */     this._inventoryItemId = dao.getInventoryItemId();
/* 313 */     this._lineItemBusinessDate = dao.getLineItemBusinessDate();
/* 314 */     this._lineItemRetailLocationId = dao.getLineItemRetailLocationId();
/* 315 */     this._lineItemRetailTransactionLineItemSequence = dao.getLineItemRetailTransactionLineItemSequence();
/* 316 */     this._lineItemTransactionSequence = dao.getLineItemTransactionSequence();
/* 317 */     this._lineItemTypeCode = dao.getLineItemTypeCode();
/* 318 */     this._lineItemWorkstationId = dao.getLineItemWorkstationId();
/* 319 */     this._statusCode = dao.getStatusCode();
/* 320 */     this._serialNumber = dao.getSerialNumber();
/* 321 */     this._unitCount = dao.getUnitCount();
/* 322 */     this._unitCost = dao.getUnitCost();
/* 323 */     this._expectedCount = dao.getExpectedCount();
/* 324 */     this._postedCount = dao.getPostedCount();
/* 325 */     this._postedCost = dao.getPostedCost();
/* 326 */     this._recordCreationType = dao.getRecordCreationType();
/* 327 */     this._enteredItemDescription = dao.getEnteredItemDescription();
/* 328 */     this._enteredItemId = dao.getEnteredItemId();
/* 329 */     this._cartonId = dao.getCartonId();
/* 330 */     this._retail = dao.getRetail();
/* 331 */     this._modelNumber = dao.getModelNumber();
/* 332 */     this._originalBucketId = dao.getOriginalBucketId();
/* 333 */     this._originalLocationId = dao.getOriginalLocationId();
/* 334 */     this._controlNumber = dao.getControlNumber();
/* 335 */     this._shippingWeight = dao.getShippingWeight();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 339 */     InventoryDocumentLineItemId id = (InventoryDocumentLineItemId)argId;
/* 340 */     argStatement.setString(1, id.getDocumentId());
/* 341 */     argStatement.setString(2, id.getDocumentTypeCode());
/* 342 */     argStatement.setInt(3, id.getInventoryDocumentLineNumber().intValue());
/* 343 */     argStatement.setLong(4, id.getOrganizationId().longValue());
/* 344 */     argStatement.setLong(5, id.getRetailLocationId().longValue());
/* 345 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 349 */     InventoryDocumentLineItemId id = new InventoryDocumentLineItemId();
/* 350 */     id.setDocumentId(this._documentId);
/* 351 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 352 */     id.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 353 */     id.setOrganizationId(this._organizationId);
/* 354 */     id.setRetailLocationId(this._retailLocationId);
/* 355 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 363 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 367 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */