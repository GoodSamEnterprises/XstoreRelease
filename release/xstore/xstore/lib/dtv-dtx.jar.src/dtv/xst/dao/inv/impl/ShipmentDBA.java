/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.ShipmentId;
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
/*     */ 
/*     */ public class ShipmentDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -451684934L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _shipmentSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _expectedDeliveryDate;
/*     */   private Date _actualDeliveryDate;
/*     */   private Date _expectedShipDate;
/*     */   private Date _actualShipDate;
/*     */   private String _destinationName;
/*     */   private String _shippingCarrier;
/*     */   private String _trackingNumber;
/*     */   private String _shipmentStatusCode;
/*     */   private Long _destinationPartyId;
/*     */   private Long _destinationRetailLocationId;
/*     */   private String _recordCreationType;
/*     */   private String _shippingMethod;
/*     */   private String _shippingLabel;
/*     */   private String _destinationType;
/*     */   private String _destinationServiceLocationId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.invctl_document_id, t.document_typcode, t.shipment_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.expected_delivery_date, t.actual_delivery_date, t.expected_ship_date, t.actual_ship_date, t.destination_name, t.shipping_carrier, t.tracking_nbr, t.shipment_statcode, t.destination_party_id, t.destination_rtl_loc_id, t.record_creation_type, t.shipping_method, t.shipping_label, t.destination_type, t.destination_service_loc_id FROM inv_shipment t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND shipment_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  53 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  57 */     return "SELECT t.organization_id, t.rtl_loc_id, t.invctl_document_id, t.document_typcode, t.shipment_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.expected_delivery_date, t.actual_delivery_date, t.expected_ship_date, t.actual_ship_date, t.destination_name, t.shipping_carrier, t.tracking_nbr, t.shipment_statcode, t.destination_party_id, t.destination_rtl_loc_id, t.record_creation_type, t.shipping_method, t.shipping_label, t.destination_type, t.destination_service_loc_id FROM inv_shipment t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  63 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND shipment_seq = ?  ";
/*     */   }
/*     */   
/*  66 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_shipment(organization_id, rtl_loc_id, invctl_document_id, document_typcode, shipment_seq, create_date, create_user_id, update_date, update_user_id, expected_delivery_date, actual_delivery_date, expected_ship_date, actual_ship_date, destination_name, shipping_carrier, tracking_nbr, shipment_statcode, destination_party_id, destination_rtl_loc_id, record_creation_type, shipping_method, shipping_label, destination_type, destination_service_loc_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  69 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  73 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._documentId, this._documentTypeCode, this._shipmentSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._expectedDeliveryDate, this._actualDeliveryDate, this._expectedShipDate, this._actualShipDate, this._destinationName, this._shippingCarrier, this._trackingNumber, this._shipmentStatusCode, this._destinationPartyId, this._destinationRetailLocationId, this._recordCreationType, this._shippingMethod, this._shippingLabel, this._destinationType, this._destinationServiceLocationId } };
/*  74 */     return insertParameterObject;
/*     */   }
/*     */   
/*  77 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 4, 91, 12, 91, 12, 91, 91, 91, 91, 12, 12, 12, 12, -5, -5, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  80 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  83 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_shipment SET update_date = ?, update_user_id = ?, expected_delivery_date = ?, actual_delivery_date = ?, expected_ship_date = ?, actual_ship_date = ?, destination_name = ?, shipping_carrier = ?, tracking_nbr = ?, shipment_statcode = ?, destination_party_id = ?, destination_rtl_loc_id = ?, record_creation_type = ?, shipping_method = ?, shipping_label = ?, destination_type = ?, destination_service_loc_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  86 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  90 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._expectedDeliveryDate, this._actualDeliveryDate, this._expectedShipDate, this._actualShipDate, this._destinationName, this._shippingCarrier, this._trackingNumber, this._shipmentStatusCode, this._destinationPartyId, this._destinationRetailLocationId, this._recordCreationType, this._shippingMethod, this._shippingLabel, this._destinationType, this._destinationServiceLocationId } };
/*  91 */     return updateParameterObject;
/*     */   }
/*     */   
/*  94 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 91, 91, 91, 12, 12, 12, 12, -5, -5, 12, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  96 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  99 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_shipment" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND shipment_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 102 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 108 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND invctl_document_id = ?  AND document_typcode = ?  AND shipment_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 111 */     return new Object[] { this._organizationId, this._retailLocationId, this._documentId, this._documentTypeCode, this._shipmentSequence };
/*     */   }
/*     */   
/* 114 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 117 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 120 */     return "inv_shipment";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 124 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 128 */     return new ShipmentFiller(this);
/*     */   }
/*     */   
/*     */   private static class ShipmentFiller
/*     */     implements IFiller {
/*     */     private ShipmentDBA _parent;
/*     */     
/*     */     public ShipmentFiller(ShipmentDBA argParent) {
/* 136 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 141 */       long l1 = argResultSet.getLong(1);
/* 142 */       if (l1 != 0L || argResultSet.getObject(1) != null) {
/* 143 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 149 */       l1 = argResultSet.getLong(2);
/* 150 */       if (l1 != 0L || argResultSet.getObject(2) != null) {
/* 151 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 155 */       this._parent._documentId = argResultSet.getString(3);
/* 156 */       this._parent._documentTypeCode = argResultSet.getString(4);
/*     */ 
/*     */       
/* 159 */       int primitiveResult = argResultSet.getInt(5);
/* 160 */       if (primitiveResult != 0 || argResultSet.getObject(5) != null) {
/* 161 */         this._parent._shipmentSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 166 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 167 */       if (t6 != null) {
/* 168 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 171 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 174 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 176 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 177 */       if (t8 != null) {
/* 178 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 184 */       this._parent._updateUserId = argResultSet.getString(9);
/*     */       
/* 186 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 187 */       if (t10 != null) {
/* 188 */         this._parent._expectedDeliveryDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 191 */         this._parent._expectedDeliveryDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 195 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 196 */       if (t11 != null) {
/* 197 */         this._parent._actualDeliveryDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 200 */         this._parent._actualDeliveryDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 204 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 205 */       if (t12 != null) {
/* 206 */         this._parent._expectedShipDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 209 */         this._parent._expectedShipDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 213 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 214 */       if (t13 != null) {
/* 215 */         this._parent._actualShipDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 218 */         this._parent._actualShipDate = null;
/*     */       } 
/*     */       
/* 221 */       this._parent._destinationName = argResultSet.getString(14);
/* 222 */       this._parent._shippingCarrier = argResultSet.getString(15);
/* 223 */       this._parent._trackingNumber = argResultSet.getString(16);
/* 224 */       this._parent._shipmentStatusCode = argResultSet.getString(17);
/*     */ 
/*     */       
/* 227 */       long l2 = argResultSet.getLong(18);
/* 228 */       if (l2 != 0L || argResultSet.getObject(18) != null) {
/* 229 */         this._parent._destinationPartyId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 235 */       l2 = argResultSet.getLong(19);
/* 236 */       if (l2 != 0L || argResultSet.getObject(19) != null) {
/* 237 */         this._parent._destinationRetailLocationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 241 */       this._parent._recordCreationType = argResultSet.getString(20);
/* 242 */       this._parent._shippingMethod = argResultSet.getString(21);
/* 243 */       this._parent._shippingLabel = argResultSet.getString(22);
/* 244 */       this._parent._destinationType = argResultSet.getString(23);
/* 245 */       this._parent._destinationServiceLocationId = argResultSet.getString(24);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 250 */     argDAO.suppressStateChanges(true);
/* 251 */     ShipmentDAO dao = (ShipmentDAO)argDAO;
/* 252 */     dao.setOrganizationId(this._organizationId);
/* 253 */     dao.setRetailLocationId(this._retailLocationId);
/* 254 */     dao.setDocumentId(this._documentId);
/* 255 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 256 */     dao.setShipmentSequence(this._shipmentSequence);
/* 257 */     dao.setCreateDate(this._createDate);
/* 258 */     dao.setCreateUserId(this._createUserId);
/* 259 */     dao.setUpdateDate(this._updateDate);
/* 260 */     dao.setUpdateUserId(this._updateUserId);
/* 261 */     dao.setExpectedDeliveryDate(this._expectedDeliveryDate);
/* 262 */     dao.setActualDeliveryDate(this._actualDeliveryDate);
/* 263 */     dao.setExpectedShipDate(this._expectedShipDate);
/* 264 */     dao.setActualShipDate(this._actualShipDate);
/* 265 */     dao.setDestinationName(this._destinationName);
/* 266 */     dao.setShippingCarrier(this._shippingCarrier);
/* 267 */     dao.setTrackingNumber(this._trackingNumber);
/* 268 */     dao.setShipmentStatusCode(this._shipmentStatusCode);
/* 269 */     dao.setDestinationPartyId(this._destinationPartyId);
/* 270 */     dao.setDestinationRetailLocationId(this._destinationRetailLocationId);
/* 271 */     dao.setRecordCreationType(this._recordCreationType);
/* 272 */     dao.setShippingMethod(this._shippingMethod);
/* 273 */     dao.setShippingLabel(this._shippingLabel);
/* 274 */     dao.setDestinationType(this._destinationType);
/* 275 */     dao.setDestinationServiceLocationId(this._destinationServiceLocationId);
/* 276 */     argDAO.suppressStateChanges(false);
/* 277 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 281 */     return loadDAO((IDataAccessObject)new ShipmentDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 285 */     ShipmentDAO dao = (ShipmentDAO)argDAO;
/* 286 */     this._organizationId = dao.getOrganizationId();
/* 287 */     this._retailLocationId = dao.getRetailLocationId();
/* 288 */     this._documentId = dao.getDocumentId();
/* 289 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 290 */     this._shipmentSequence = dao.getShipmentSequence();
/* 291 */     this._createDate = dao.getCreateDate();
/* 292 */     this._createUserId = dao.getCreateUserId();
/* 293 */     this._updateDate = dao.getUpdateDate();
/* 294 */     this._updateUserId = dao.getUpdateUserId();
/* 295 */     this._expectedDeliveryDate = dao.getExpectedDeliveryDate();
/* 296 */     this._actualDeliveryDate = dao.getActualDeliveryDate();
/* 297 */     this._expectedShipDate = dao.getExpectedShipDate();
/* 298 */     this._actualShipDate = dao.getActualShipDate();
/* 299 */     this._destinationName = dao.getDestinationName();
/* 300 */     this._shippingCarrier = dao.getShippingCarrier();
/* 301 */     this._trackingNumber = dao.getTrackingNumber();
/* 302 */     this._shipmentStatusCode = dao.getShipmentStatusCode();
/* 303 */     this._destinationPartyId = dao.getDestinationPartyId();
/* 304 */     this._destinationRetailLocationId = dao.getDestinationRetailLocationId();
/* 305 */     this._recordCreationType = dao.getRecordCreationType();
/* 306 */     this._shippingMethod = dao.getShippingMethod();
/* 307 */     this._shippingLabel = dao.getShippingLabel();
/* 308 */     this._destinationType = dao.getDestinationType();
/* 309 */     this._destinationServiceLocationId = dao.getDestinationServiceLocationId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 313 */     ShipmentId id = (ShipmentId)argId;
/* 314 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 315 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 316 */     argStatement.setString(3, id.getDocumentId());
/* 317 */     argStatement.setString(4, id.getDocumentTypeCode());
/* 318 */     argStatement.setInt(5, id.getShipmentSequence().intValue());
/* 319 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 323 */     ShipmentId id = new ShipmentId();
/* 324 */     id.setOrganizationId(this._organizationId);
/* 325 */     id.setRetailLocationId(this._retailLocationId);
/* 326 */     id.setDocumentId(this._documentId);
/* 327 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 328 */     id.setShipmentSequence(this._shipmentSequence);
/* 329 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 337 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 341 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipmentDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */