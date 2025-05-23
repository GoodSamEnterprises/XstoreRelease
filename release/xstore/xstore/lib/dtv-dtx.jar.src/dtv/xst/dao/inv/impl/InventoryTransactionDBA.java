/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.PosTransactionId;
/*     */ import dtv.xst.dao.trn.impl.PosTransactionDBA;
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
/*     */ public class InventoryTransactionDBA
/*     */   extends PosTransactionDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 708666370L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _oldStatusCode;
/*     */   private String _newStatusCode;
/*     */   private String _reasonCode;
/*     */   private Long _inventoryDocumentRetailLocationId;
/*     */   private String _documentTypeCode;
/*     */   private String _documentId;
/*     */   private Date _documentDate;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.old_status_code, t.new_status_code, t.invctl_trans_reascode, t.invctl_document_rtl_loc_id, t.document_typcode, t.invctl_document_id, t.document_date FROM inv_invctl_trans t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.old_status_code, t.new_status_code, t.invctl_trans_reascode, t.invctl_document_rtl_loc_id, t.document_typcode, t.invctl_document_id, t.document_date FROM inv_invctl_trans t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  57 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*  60 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_invctl_trans(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, create_date, create_user_id, update_date, update_user_id, old_status_code, new_status_code, invctl_trans_reascode, invctl_document_rtl_loc_id, document_typcode, invctl_document_id, document_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  64 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  69 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._oldStatusCode, this._newStatusCode, this._reasonCode, this._inventoryDocumentRetailLocationId, this._documentTypeCode, this._documentId, this._documentDate } };
/*  70 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  73 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 91, 12, 91, 12, 12, 12, 12, -5, 12, 12, 91 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  77 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  80 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_invctl_trans SET update_date = ?, update_user_id = ?, old_status_code = ?, new_status_code = ?, invctl_trans_reascode = ?, invctl_document_rtl_loc_id = ?, document_typcode = ?, invctl_document_id = ?, document_date = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  84 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  89 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._oldStatusCode, this._newStatusCode, this._reasonCode, this._inventoryDocumentRetailLocationId, this._documentTypeCode, this._documentId, this._documentDate } };
/*  90 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  93 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, -5, 12, 12, 91 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  96 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/*  99 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_invctl_trans" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 103 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 110 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 114 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence };
/*     */   }
/*     */   
/* 117 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 121 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 125 */     return "inv_invctl_trans";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 130 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 134 */     return new InventoryTransactionFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryTransactionFiller
/*     */     implements IFiller {
/*     */     private InventoryTransactionDBA _parent;
/*     */     
/*     */     public InventoryTransactionFiller(InventoryTransactionDBA argParent) {
/* 142 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 147 */       long primitiveResult = argResultSet.getLong(1);
/* 148 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 149 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 155 */       primitiveResult = argResultSet.getLong(2);
/* 156 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 157 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 162 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 163 */       if (t3 != null) {
/* 164 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 167 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 172 */       long l1 = argResultSet.getLong(4);
/* 173 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 174 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 180 */       l1 = argResultSet.getLong(5);
/* 181 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 182 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 187 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 188 */       if (t6 != null) {
/* 189 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 192 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 195 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 197 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 198 */       if (t8 != null) {
/* 199 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 202 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 205 */       this._parent._updateUserId = argResultSet.getString(9);
/* 206 */       this._parent._oldStatusCode = argResultSet.getString(10);
/* 207 */       this._parent._newStatusCode = argResultSet.getString(11);
/* 208 */       this._parent._reasonCode = argResultSet.getString(12);
/*     */ 
/*     */       
/* 211 */       long l2 = argResultSet.getLong(13);
/* 212 */       if (l2 != 0L || argResultSet.getObject(13) != null) {
/* 213 */         this._parent._inventoryDocumentRetailLocationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 217 */       this._parent._documentTypeCode = argResultSet.getString(14);
/* 218 */       this._parent._documentId = argResultSet.getString(15);
/*     */       
/* 220 */       Timestamp t16 = argResultSet.getTimestamp(16);
/* 221 */       if (t16 != null) {
/* 222 */         this._parent._documentDate = (Date)new DtvDate(t16.getTime());
/*     */       } else {
/*     */         
/* 225 */         this._parent._documentDate = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 233 */     super.loadDAO(argDAO);
/* 234 */     argDAO.suppressStateChanges(true);
/* 235 */     InventoryTransactionDAO dao = (InventoryTransactionDAO)argDAO;
/* 236 */     dao.setOrganizationId(this._organizationId);
/* 237 */     dao.setRetailLocationId(this._retailLocationId);
/* 238 */     dao.setBusinessDate(this._businessDate);
/* 239 */     dao.setWorkstationId(this._workstationId);
/* 240 */     dao.setTransactionSequence(this._transactionSequence);
/* 241 */     dao.setCreateDate(this._createDate);
/* 242 */     dao.setCreateUserId(this._createUserId);
/* 243 */     dao.setUpdateDate(this._updateDate);
/* 244 */     dao.setUpdateUserId(this._updateUserId);
/* 245 */     dao.setOldStatusCode(this._oldStatusCode);
/* 246 */     dao.setNewStatusCode(this._newStatusCode);
/* 247 */     dao.setReasonCode(this._reasonCode);
/* 248 */     dao.setInventoryDocumentRetailLocationId(this._inventoryDocumentRetailLocationId);
/* 249 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 250 */     dao.setDocumentId(this._documentId);
/* 251 */     dao.setDocumentDate(this._documentDate);
/* 252 */     argDAO.suppressStateChanges(false);
/* 253 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 258 */     return loadDAO((IDataAccessObject)new InventoryTransactionDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 263 */     InventoryTransactionDAO dao = (InventoryTransactionDAO)argDAO;
/* 264 */     super.fill((IDataAccessObject)dao);
/* 265 */     this._organizationId = dao.getOrganizationId();
/* 266 */     this._retailLocationId = dao.getRetailLocationId();
/* 267 */     this._businessDate = dao.getBusinessDate();
/* 268 */     this._workstationId = dao.getWorkstationId();
/* 269 */     this._transactionSequence = dao.getTransactionSequence();
/* 270 */     this._createDate = dao.getCreateDate();
/* 271 */     this._createUserId = dao.getCreateUserId();
/* 272 */     this._updateDate = dao.getUpdateDate();
/* 273 */     this._updateUserId = dao.getUpdateUserId();
/* 274 */     this._oldStatusCode = dao.getOldStatusCode();
/* 275 */     this._newStatusCode = dao.getNewStatusCode();
/* 276 */     this._reasonCode = dao.getReasonCode();
/* 277 */     this._inventoryDocumentRetailLocationId = dao.getInventoryDocumentRetailLocationId();
/* 278 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 279 */     this._documentId = dao.getDocumentId();
/* 280 */     this._documentDate = dao.getDocumentDate();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 285 */     PosTransactionId id = (PosTransactionId)argId;
/* 286 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 287 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 288 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 289 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 290 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 291 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 295 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 299 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryTransactionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */