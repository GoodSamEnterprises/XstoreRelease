/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.ShipmentLineItemId;
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
/*     */ public class ShipmentLineItemDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 383149313L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _shipmentSequence;
/*     */   private Integer _lineItemSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private BigDecimal _shipQuantity;
/*     */   private String _cartonId;
/*     */   private String _statusCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.invctl_document_id, t.document_typcode, t.shipment_seq, t.lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.invctl_document_line_nbr, t.ship_qty, t.carton_id, t.status_code FROM inv_shipment_lines t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND shipment_seq = ?  AND lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.rtl_loc_id, t.invctl_document_id, t.document_typcode, t.shipment_seq, t.lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.invctl_document_line_nbr, t.ship_qty, t.carton_id, t.status_code FROM inv_shipment_lines t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND shipment_seq = ?  AND lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_shipment_lines(organization_id, rtl_loc_id, invctl_document_id, document_typcode, shipment_seq, lineitm_seq, create_date, create_user_id, update_date, update_user_id, invctl_document_line_nbr, ship_qty, carton_id, status_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._documentId, this._documentTypeCode, this._shipmentSequence, this._lineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._inventoryDocumentLineNumber, this._shipQuantity, this._cartonId, this._statusCode } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 4, 4, 91, 12, 91, 12, 4, 3, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_shipment_lines SET update_date = ?, update_user_id = ?, invctl_document_line_nbr = ?, ship_qty = ?, carton_id = ?, status_code = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._inventoryDocumentLineNumber, this._shipQuantity, this._cartonId, this._statusCode } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 4, 3, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_shipment_lines" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND shipment_seq = ?  AND lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND shipment_seq = ?  AND lineitm_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._retailLocationId, this._documentId, this._documentTypeCode, this._shipmentSequence, this._lineItemSequence };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12, 4, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "inv_shipment_lines";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new ShipmentLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class ShipmentLineItemFiller
/*     */     implements IFiller {
/*     */     private ShipmentLineItemDBA _parent;
/*     */     
/*     */     public ShipmentLineItemFiller(ShipmentLineItemDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       long l = argResultSet.getLong(1);
/* 132 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 133 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       l = argResultSet.getLong(2);
/* 140 */       if (l != 0L || argResultSet.getObject(2) != null) {
/* 141 */         this._parent._retailLocationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 145 */       this._parent._documentId = argResultSet.getString(3);
/* 146 */       this._parent._documentTypeCode = argResultSet.getString(4);
/*     */ 
/*     */       
/* 149 */       int primitiveResult = argResultSet.getInt(5);
/* 150 */       if (primitiveResult != 0 || argResultSet.getObject(5) != null) {
/* 151 */         this._parent._shipmentSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 157 */       primitiveResult = argResultSet.getInt(6);
/* 158 */       if (primitiveResult != 0 || argResultSet.getObject(6) != null) {
/* 159 */         this._parent._lineItemSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 164 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 165 */       if (t7 != null) {
/* 166 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 169 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 172 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 174 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 175 */       if (t9 != null) {
/* 176 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 179 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 182 */       this._parent._updateUserId = argResultSet.getString(10);
/*     */ 
/*     */       
/* 185 */       int i = argResultSet.getInt(11);
/* 186 */       if (i != 0 || argResultSet.getObject(11) != null) {
/* 187 */         this._parent._inventoryDocumentLineNumber = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 191 */       this._parent._shipQuantity = argResultSet.getBigDecimal(12);
/* 192 */       this._parent._cartonId = argResultSet.getString(13);
/* 193 */       this._parent._statusCode = argResultSet.getString(14);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 198 */     argDAO.suppressStateChanges(true);
/* 199 */     ShipmentLineItemDAO dao = (ShipmentLineItemDAO)argDAO;
/* 200 */     dao.setOrganizationId(this._organizationId);
/* 201 */     dao.setRetailLocationId(this._retailLocationId);
/* 202 */     dao.setDocumentId(this._documentId);
/* 203 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 204 */     dao.setShipmentSequence(this._shipmentSequence);
/* 205 */     dao.setLineItemSequence(this._lineItemSequence);
/* 206 */     dao.setCreateDate(this._createDate);
/* 207 */     dao.setCreateUserId(this._createUserId);
/* 208 */     dao.setUpdateDate(this._updateDate);
/* 209 */     dao.setUpdateUserId(this._updateUserId);
/* 210 */     dao.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 211 */     dao.setShipQuantity(this._shipQuantity);
/* 212 */     dao.setCartonId(this._cartonId);
/* 213 */     dao.setStatusCode(this._statusCode);
/* 214 */     argDAO.suppressStateChanges(false);
/* 215 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 219 */     return loadDAO((IDataAccessObject)new ShipmentLineItemDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 223 */     ShipmentLineItemDAO dao = (ShipmentLineItemDAO)argDAO;
/* 224 */     this._organizationId = dao.getOrganizationId();
/* 225 */     this._retailLocationId = dao.getRetailLocationId();
/* 226 */     this._documentId = dao.getDocumentId();
/* 227 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 228 */     this._shipmentSequence = dao.getShipmentSequence();
/* 229 */     this._lineItemSequence = dao.getLineItemSequence();
/* 230 */     this._createDate = dao.getCreateDate();
/* 231 */     this._createUserId = dao.getCreateUserId();
/* 232 */     this._updateDate = dao.getUpdateDate();
/* 233 */     this._updateUserId = dao.getUpdateUserId();
/* 234 */     this._inventoryDocumentLineNumber = dao.getInventoryDocumentLineNumber();
/* 235 */     this._shipQuantity = dao.getShipQuantity();
/* 236 */     this._cartonId = dao.getCartonId();
/* 237 */     this._statusCode = dao.getStatusCode();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 241 */     ShipmentLineItemId id = (ShipmentLineItemId)argId;
/* 242 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 243 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 244 */     argStatement.setString(3, id.getDocumentId());
/* 245 */     argStatement.setString(4, id.getDocumentTypeCode());
/* 246 */     argStatement.setInt(5, id.getShipmentSequence().intValue());
/* 247 */     argStatement.setInt(6, id.getLineItemSequence().intValue());
/* 248 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 252 */     ShipmentLineItemId id = new ShipmentLineItemId();
/* 253 */     id.setOrganizationId(this._organizationId);
/* 254 */     id.setRetailLocationId(this._retailLocationId);
/* 255 */     id.setDocumentId(this._documentId);
/* 256 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 257 */     id.setShipmentSequence(this._shipmentSequence);
/* 258 */     id.setLineItemSequence(this._lineItemSequence);
/* 259 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 267 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 271 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipmentLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */