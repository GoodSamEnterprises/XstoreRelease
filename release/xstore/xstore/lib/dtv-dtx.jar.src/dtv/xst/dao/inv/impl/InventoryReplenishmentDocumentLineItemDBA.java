/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryReplenishmentDocumentLineItemId;
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
/*     */ public class InventoryReplenishmentDocumentLineItemDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1339662122L;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private BigDecimal _suggestedOrderQuantity;
/*     */   private BigDecimal _orderQuantity;
/*     */   private BigDecimal _confirmedQuantity;
/*     */   private Date _confirmationDate;
/*     */   private String _confirmationNumber;
/*     */   private String _shipVia;
/*     */   private BigDecimal _shippedQuantity;
/*     */   private Date _shippedDate;
/*     */   private BigDecimal _receivedQuantity;
/*     */   private Date _receivedDate;
/*     */   private String _sourceType;
/*     */   private String _sourceId;
/*     */   private String _sourceName;
/*     */   private String _parentDocumentId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.invctl_document_id, t.document_typcode, t.invctl_document_line_nbr, t.organization_id, t.rtl_loc_id, t.suggested_order_qty, t.order_quantity, t.confirmed_quantity, t.confirmation_date, t.confirmation_number, t.ship_via, t.shipped_quantity, t.shipped_date, t.received_quantity, t.received_date, t.source_type, t.source_id, t.source_name, t.parent_document_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM inv_rep_document_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  52 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  56 */     return "SELECT t.invctl_document_id, t.document_typcode, t.invctl_document_line_nbr, t.organization_id, t.rtl_loc_id, t.suggested_order_qty, t.order_quantity, t.confirmed_quantity, t.confirmation_date, t.confirmation_number, t.ship_via, t.shipped_quantity, t.shipped_date, t.received_quantity, t.received_date, t.source_type, t.source_id, t.source_name, t.parent_document_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM inv_rep_document_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  62 */     return " WHERE invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   
/*  65 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_rep_document_lineitm(invctl_document_id, document_typcode, invctl_document_line_nbr, organization_id, rtl_loc_id, suggested_order_qty, order_quantity, confirmed_quantity, confirmation_date, confirmation_number, ship_via, shipped_quantity, shipped_date, received_quantity, received_date, source_type, source_id, source_name, parent_document_id, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  68 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  72 */     Object[][] insertParameterObject = { { this._documentId, this._documentTypeCode, this._inventoryDocumentLineNumber, this._organizationId, this._retailLocationId, this._suggestedOrderQuantity, this._orderQuantity, this._confirmedQuantity, this._confirmationDate, this._confirmationNumber, this._shipVia, this._shippedQuantity, this._shippedDate, this._receivedQuantity, this._receivedDate, this._sourceType, this._sourceId, this._sourceName, this._parentDocumentId, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  73 */     return insertParameterObject;
/*     */   }
/*     */   
/*  76 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, 12, 4, -5, -5, 3, 3, 3, 91, 12, 12, 3, 91, 3, 91, 12, 12, 12, 12, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  79 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  82 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_rep_document_lineitm SET suggested_order_qty = ?, order_quantity = ?, confirmed_quantity = ?, confirmation_date = ?, confirmation_number = ?, ship_via = ?, shipped_quantity = ?, shipped_date = ?, received_quantity = ?, received_date = ?, source_type = ?, source_id = ?, source_name = ?, parent_document_id = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  85 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  89 */     Object[][] updateParameterObject = { { this._suggestedOrderQuantity, this._orderQuantity, this._confirmedQuantity, this._confirmationDate, this._confirmationNumber, this._shipVia, this._shippedQuantity, this._shippedDate, this._receivedQuantity, this._receivedDate, this._sourceType, this._sourceId, this._sourceName, this._parentDocumentId, this._updateDate, this._updateUserId } };
/*  90 */     return updateParameterObject;
/*     */   }
/*     */   
/*  93 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 3, 3, 3, 91, 12, 12, 3, 91, 3, 91, 12, 12, 12, 12, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  95 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  98 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_rep_document_lineitm" }; private static final String WHERE_OBJECT = " WHERE invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 101 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 107 */     return " WHERE invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 110 */     return new Object[] { this._documentId, this._documentTypeCode, this._inventoryDocumentLineNumber, this._organizationId, this._retailLocationId };
/*     */   }
/*     */   
/* 113 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, 12, 4, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 116 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 119 */     return "inv_rep_document_lineitm";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 123 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 127 */     return new InventoryReplenishmentDocumentLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryReplenishmentDocumentLineItemFiller
/*     */     implements IFiller {
/*     */     private InventoryReplenishmentDocumentLineItemDBA _parent;
/*     */     
/*     */     public InventoryReplenishmentDocumentLineItemFiller(InventoryReplenishmentDocumentLineItemDBA argParent) {
/* 135 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 138 */       this._parent._documentId = argResultSet.getString(1);
/* 139 */       this._parent._documentTypeCode = argResultSet.getString(2);
/*     */ 
/*     */       
/* 142 */       int i = argResultSet.getInt(3);
/* 143 */       if (i != 0 || argResultSet.getObject(3) != null) {
/* 144 */         this._parent._inventoryDocumentLineNumber = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 150 */       long primitiveResult = argResultSet.getLong(4);
/* 151 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 152 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 158 */       primitiveResult = argResultSet.getLong(5);
/* 159 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 160 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 164 */       this._parent._suggestedOrderQuantity = argResultSet.getBigDecimal(6);
/* 165 */       this._parent._orderQuantity = argResultSet.getBigDecimal(7);
/* 166 */       this._parent._confirmedQuantity = argResultSet.getBigDecimal(8);
/*     */       
/* 168 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 169 */       if (t9 != null) {
/* 170 */         this._parent._confirmationDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 173 */         this._parent._confirmationDate = null;
/*     */       } 
/*     */       
/* 176 */       this._parent._confirmationNumber = argResultSet.getString(10);
/* 177 */       this._parent._shipVia = argResultSet.getString(11);
/* 178 */       this._parent._shippedQuantity = argResultSet.getBigDecimal(12);
/*     */       
/* 180 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 181 */       if (t13 != null) {
/* 182 */         this._parent._shippedDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 185 */         this._parent._shippedDate = null;
/*     */       } 
/*     */       
/* 188 */       this._parent._receivedQuantity = argResultSet.getBigDecimal(14);
/*     */       
/* 190 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 191 */       if (t15 != null) {
/* 192 */         this._parent._receivedDate = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 195 */         this._parent._receivedDate = null;
/*     */       } 
/*     */       
/* 198 */       this._parent._sourceType = argResultSet.getString(16);
/* 199 */       this._parent._sourceId = argResultSet.getString(17);
/* 200 */       this._parent._sourceName = argResultSet.getString(18);
/* 201 */       this._parent._parentDocumentId = argResultSet.getString(19);
/*     */       
/* 203 */       Timestamp t20 = argResultSet.getTimestamp(20);
/* 204 */       if (t20 != null) {
/* 205 */         this._parent._createDate = (Date)new DtvDate(t20.getTime());
/*     */       } else {
/*     */         
/* 208 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 211 */       this._parent._createUserId = argResultSet.getString(21);
/*     */       
/* 213 */       Timestamp t22 = argResultSet.getTimestamp(22);
/* 214 */       if (t22 != null) {
/* 215 */         this._parent._updateDate = (Date)new DtvDate(t22.getTime());
/*     */       } else {
/*     */         
/* 218 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 221 */       this._parent._updateUserId = argResultSet.getString(23);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 226 */     argDAO.suppressStateChanges(true);
/* 227 */     InventoryReplenishmentDocumentLineItemDAO dao = (InventoryReplenishmentDocumentLineItemDAO)argDAO;
/* 228 */     dao.setDocumentId(this._documentId);
/* 229 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 230 */     dao.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 231 */     dao.setOrganizationId(this._organizationId);
/* 232 */     dao.setRetailLocationId(this._retailLocationId);
/* 233 */     dao.setSuggestedOrderQuantity(this._suggestedOrderQuantity);
/* 234 */     dao.setOrderQuantity(this._orderQuantity);
/* 235 */     dao.setConfirmedQuantity(this._confirmedQuantity);
/* 236 */     dao.setConfirmationDate(this._confirmationDate);
/* 237 */     dao.setConfirmationNumber(this._confirmationNumber);
/* 238 */     dao.setShipVia(this._shipVia);
/* 239 */     dao.setShippedQuantity(this._shippedQuantity);
/* 240 */     dao.setShippedDate(this._shippedDate);
/* 241 */     dao.setReceivedQuantity(this._receivedQuantity);
/* 242 */     dao.setReceivedDate(this._receivedDate);
/* 243 */     dao.setSourceType(this._sourceType);
/* 244 */     dao.setSourceId(this._sourceId);
/* 245 */     dao.setSourceName(this._sourceName);
/* 246 */     dao.setParentDocumentId(this._parentDocumentId);
/* 247 */     dao.setCreateDate(this._createDate);
/* 248 */     dao.setCreateUserId(this._createUserId);
/* 249 */     dao.setUpdateDate(this._updateDate);
/* 250 */     dao.setUpdateUserId(this._updateUserId);
/* 251 */     argDAO.suppressStateChanges(false);
/* 252 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 256 */     return loadDAO((IDataAccessObject)new InventoryReplenishmentDocumentLineItemDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 260 */     InventoryReplenishmentDocumentLineItemDAO dao = (InventoryReplenishmentDocumentLineItemDAO)argDAO;
/* 261 */     this._documentId = dao.getDocumentId();
/* 262 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 263 */     this._inventoryDocumentLineNumber = dao.getInventoryDocumentLineNumber();
/* 264 */     this._organizationId = dao.getOrganizationId();
/* 265 */     this._retailLocationId = dao.getRetailLocationId();
/* 266 */     this._suggestedOrderQuantity = dao.getSuggestedOrderQuantity();
/* 267 */     this._orderQuantity = dao.getOrderQuantity();
/* 268 */     this._confirmedQuantity = dao.getConfirmedQuantity();
/* 269 */     this._confirmationDate = dao.getConfirmationDate();
/* 270 */     this._confirmationNumber = dao.getConfirmationNumber();
/* 271 */     this._shipVia = dao.getShipVia();
/* 272 */     this._shippedQuantity = dao.getShippedQuantity();
/* 273 */     this._shippedDate = dao.getShippedDate();
/* 274 */     this._receivedQuantity = dao.getReceivedQuantity();
/* 275 */     this._receivedDate = dao.getReceivedDate();
/* 276 */     this._sourceType = dao.getSourceType();
/* 277 */     this._sourceId = dao.getSourceId();
/* 278 */     this._sourceName = dao.getSourceName();
/* 279 */     this._parentDocumentId = dao.getParentDocumentId();
/* 280 */     this._createDate = dao.getCreateDate();
/* 281 */     this._createUserId = dao.getCreateUserId();
/* 282 */     this._updateDate = dao.getUpdateDate();
/* 283 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 287 */     InventoryReplenishmentDocumentLineItemId id = (InventoryReplenishmentDocumentLineItemId)argId;
/* 288 */     argStatement.setString(1, id.getDocumentId());
/* 289 */     argStatement.setString(2, id.getDocumentTypeCode());
/* 290 */     argStatement.setInt(3, id.getInventoryDocumentLineNumber().intValue());
/* 291 */     argStatement.setLong(4, id.getOrganizationId().longValue());
/* 292 */     argStatement.setLong(5, id.getRetailLocationId().longValue());
/* 293 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 297 */     InventoryReplenishmentDocumentLineItemId id = new InventoryReplenishmentDocumentLineItemId();
/* 298 */     id.setDocumentId(this._documentId);
/* 299 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 300 */     id.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 301 */     id.setOrganizationId(this._organizationId);
/* 302 */     id.setRetailLocationId(this._retailLocationId);
/* 303 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 311 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 315 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryReplenishmentDocumentLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */