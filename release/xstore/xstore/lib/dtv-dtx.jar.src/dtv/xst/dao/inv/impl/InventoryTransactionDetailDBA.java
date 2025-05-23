/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryTransactionDetailId;
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
/*     */ public class InventoryTransactionDetailDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1690444045L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _inventoryDetailSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _oldStatusCode;
/*     */   private String _newStatusCode;
/*     */   private BigDecimal _previousUnitCount;
/*     */   private BigDecimal _newUnitCount;
/*     */   private String _actionCode;
/*     */   private BigDecimal _newPostedCount;
/*     */   private BigDecimal _previousPostedCount;
/*     */   private Long _inventoryDocumentRetailLocationId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private String _inventoryItemId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.invctl_trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.old_status_code, t.new_status_code, t.previous_unit_count, t.new_unit_count, t.action_code, t.new_posted_count, t.previous_posted_count, t.invctl_document_rtl_loc_id, t.invctl_document_id, t.document_typcode, t.invctl_document_line_nbr, t.item_id FROM inv_invctl_trans_detail t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND invctl_trans_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  51 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  55 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.invctl_trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.old_status_code, t.new_status_code, t.previous_unit_count, t.new_unit_count, t.action_code, t.new_posted_count, t.previous_posted_count, t.invctl_document_rtl_loc_id, t.invctl_document_id, t.document_typcode, t.invctl_document_line_nbr, t.item_id FROM inv_invctl_trans_detail t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  61 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND invctl_trans_seq = ?  ";
/*     */   }
/*     */   
/*  64 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_invctl_trans_detail(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, invctl_trans_seq, create_date, create_user_id, update_date, update_user_id, old_status_code, new_status_code, previous_unit_count, new_unit_count, action_code, new_posted_count, previous_posted_count, invctl_document_rtl_loc_id, invctl_document_id, document_typcode, invctl_document_line_nbr, item_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  67 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  71 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._inventoryDetailSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._oldStatusCode, this._newStatusCode, this._previousUnitCount, this._newUnitCount, this._actionCode, this._newPostedCount, this._previousPostedCount, this._inventoryDocumentRetailLocationId, this._documentId, this._documentTypeCode, this._inventoryDocumentLineNumber, this._inventoryItemId } };
/*  72 */     return insertParameterObject;
/*     */   }
/*     */   
/*  75 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 12, 12, 3, 3, 12, 3, 3, -5, 12, 12, 4, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  78 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  81 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_invctl_trans_detail SET update_date = ?, update_user_id = ?, old_status_code = ?, new_status_code = ?, previous_unit_count = ?, new_unit_count = ?, action_code = ?, new_posted_count = ?, previous_posted_count = ?, invctl_document_rtl_loc_id = ?, invctl_document_id = ?, document_typcode = ?, invctl_document_line_nbr = ?, item_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  84 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  88 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._oldStatusCode, this._newStatusCode, this._previousUnitCount, this._newUnitCount, this._actionCode, this._newPostedCount, this._previousPostedCount, this._inventoryDocumentRetailLocationId, this._documentId, this._documentTypeCode, this._inventoryDocumentLineNumber, this._inventoryItemId } };
/*  89 */     return updateParameterObject;
/*     */   }
/*     */   
/*  92 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 3, 3, 12, 3, 3, -5, 12, 12, 4, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  94 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  97 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_invctl_trans_detail" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND invctl_trans_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 100 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 106 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND invctl_trans_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 109 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._inventoryDetailSequence };
/*     */   }
/*     */   
/* 112 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 115 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 118 */     return "inv_invctl_trans_detail";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 122 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 126 */     return new InventoryTransactionDetailFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryTransactionDetailFiller
/*     */     implements IFiller {
/*     */     private InventoryTransactionDetailDBA _parent;
/*     */     
/*     */     public InventoryTransactionDetailFiller(InventoryTransactionDetailDBA argParent) {
/* 134 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 139 */       long primitiveResult = argResultSet.getLong(1);
/* 140 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 141 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 147 */       primitiveResult = argResultSet.getLong(2);
/* 148 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 149 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 154 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 155 */       if (t3 != null) {
/* 156 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 159 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 164 */       long l1 = argResultSet.getLong(4);
/* 165 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 166 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 172 */       l1 = argResultSet.getLong(5);
/* 173 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 174 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 180 */       int i = argResultSet.getInt(6);
/* 181 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 182 */         this._parent._inventoryDetailSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 187 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 188 */       if (t7 != null) {
/* 189 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 192 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 195 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 197 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 198 */       if (t9 != null) {
/* 199 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 202 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 205 */       this._parent._updateUserId = argResultSet.getString(10);
/* 206 */       this._parent._oldStatusCode = argResultSet.getString(11);
/* 207 */       this._parent._newStatusCode = argResultSet.getString(12);
/* 208 */       this._parent._previousUnitCount = argResultSet.getBigDecimal(13);
/* 209 */       this._parent._newUnitCount = argResultSet.getBigDecimal(14);
/* 210 */       this._parent._actionCode = argResultSet.getString(15);
/* 211 */       this._parent._newPostedCount = argResultSet.getBigDecimal(16);
/* 212 */       this._parent._previousPostedCount = argResultSet.getBigDecimal(17);
/*     */ 
/*     */       
/* 215 */       long l2 = argResultSet.getLong(18);
/* 216 */       if (l2 != 0L || argResultSet.getObject(18) != null) {
/* 217 */         this._parent._inventoryDocumentRetailLocationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 221 */       this._parent._documentId = argResultSet.getString(19);
/* 222 */       this._parent._documentTypeCode = argResultSet.getString(20);
/*     */ 
/*     */       
/* 225 */       int j = argResultSet.getInt(21);
/* 226 */       if (j != 0 || argResultSet.getObject(21) != null) {
/* 227 */         this._parent._inventoryDocumentLineNumber = Integer.valueOf(j);
/*     */       }
/*     */ 
/*     */       
/* 231 */       this._parent._inventoryItemId = argResultSet.getString(22);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 236 */     argDAO.suppressStateChanges(true);
/* 237 */     InventoryTransactionDetailDAO dao = (InventoryTransactionDetailDAO)argDAO;
/* 238 */     dao.setOrganizationId(this._organizationId);
/* 239 */     dao.setRetailLocationId(this._retailLocationId);
/* 240 */     dao.setBusinessDate(this._businessDate);
/* 241 */     dao.setWorkstationId(this._workstationId);
/* 242 */     dao.setTransactionSequence(this._transactionSequence);
/* 243 */     dao.setInventoryDetailSequence(this._inventoryDetailSequence);
/* 244 */     dao.setCreateDate(this._createDate);
/* 245 */     dao.setCreateUserId(this._createUserId);
/* 246 */     dao.setUpdateDate(this._updateDate);
/* 247 */     dao.setUpdateUserId(this._updateUserId);
/* 248 */     dao.setOldStatusCode(this._oldStatusCode);
/* 249 */     dao.setNewStatusCode(this._newStatusCode);
/* 250 */     dao.setPreviousUnitCount(this._previousUnitCount);
/* 251 */     dao.setNewUnitCount(this._newUnitCount);
/* 252 */     dao.setActionCode(this._actionCode);
/* 253 */     dao.setNewPostedCount(this._newPostedCount);
/* 254 */     dao.setPreviousPostedCount(this._previousPostedCount);
/* 255 */     dao.setInventoryDocumentRetailLocationId(this._inventoryDocumentRetailLocationId);
/* 256 */     dao.setDocumentId(this._documentId);
/* 257 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 258 */     dao.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 259 */     dao.setInventoryItemId(this._inventoryItemId);
/* 260 */     argDAO.suppressStateChanges(false);
/* 261 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 265 */     return loadDAO((IDataAccessObject)new InventoryTransactionDetailDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 269 */     InventoryTransactionDetailDAO dao = (InventoryTransactionDetailDAO)argDAO;
/* 270 */     this._organizationId = dao.getOrganizationId();
/* 271 */     this._retailLocationId = dao.getRetailLocationId();
/* 272 */     this._businessDate = dao.getBusinessDate();
/* 273 */     this._workstationId = dao.getWorkstationId();
/* 274 */     this._transactionSequence = dao.getTransactionSequence();
/* 275 */     this._inventoryDetailSequence = dao.getInventoryDetailSequence();
/* 276 */     this._createDate = dao.getCreateDate();
/* 277 */     this._createUserId = dao.getCreateUserId();
/* 278 */     this._updateDate = dao.getUpdateDate();
/* 279 */     this._updateUserId = dao.getUpdateUserId();
/* 280 */     this._oldStatusCode = dao.getOldStatusCode();
/* 281 */     this._newStatusCode = dao.getNewStatusCode();
/* 282 */     this._previousUnitCount = dao.getPreviousUnitCount();
/* 283 */     this._newUnitCount = dao.getNewUnitCount();
/* 284 */     this._actionCode = dao.getActionCode();
/* 285 */     this._newPostedCount = dao.getNewPostedCount();
/* 286 */     this._previousPostedCount = dao.getPreviousPostedCount();
/* 287 */     this._inventoryDocumentRetailLocationId = dao.getInventoryDocumentRetailLocationId();
/* 288 */     this._documentId = dao.getDocumentId();
/* 289 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 290 */     this._inventoryDocumentLineNumber = dao.getInventoryDocumentLineNumber();
/* 291 */     this._inventoryItemId = dao.getInventoryItemId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 295 */     InventoryTransactionDetailId id = (InventoryTransactionDetailId)argId;
/* 296 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 297 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 298 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 299 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 300 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 301 */     argStatement.setInt(6, id.getInventoryDetailSequence().intValue());
/* 302 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 306 */     InventoryTransactionDetailId id = new InventoryTransactionDetailId();
/* 307 */     id.setOrganizationId(this._organizationId);
/* 308 */     id.setRetailLocationId(this._retailLocationId);
/* 309 */     id.setBusinessDate(this._businessDate);
/* 310 */     id.setWorkstationId(this._workstationId);
/* 311 */     id.setTransactionSequence(this._transactionSequence);
/* 312 */     id.setInventoryDetailSequence(this._inventoryDetailSequence);
/* 313 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 321 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 325 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryTransactionDetailDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */