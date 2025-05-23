/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.ReceiptLookupId;
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
/*     */ public class ReceiptLookupDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 660712882L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Date _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private String _receiptId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _receiptUrl;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.receipt_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.receipt_url FROM trn_receipt_lookup t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND receipt_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.receipt_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.receipt_url FROM trn_receipt_lookup t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND receipt_id = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trn_receipt_lookup(organization_id, rtl_loc_id, wkstn_id, business_date, trans_seq, receipt_id, create_date, create_user_id, update_date, update_user_id, receipt_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._receiptId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._receiptUrl } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 91, -5, 12, 91, 12, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trn_receipt_lookup SET update_date = ?, update_user_id = ?, receipt_url = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._receiptUrl } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trn_receipt_lookup" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND receipt_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND receipt_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._receiptId };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 91, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "trn_receipt_lookup";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new ReceiptLookupFiller(this);
/*     */   }
/*     */   
/*     */   private static class ReceiptLookupFiller
/*     */     implements IFiller {
/*     */     private ReceiptLookupDBA _parent;
/*     */     
/*     */     public ReceiptLookupFiller(ReceiptLookupDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       long primitiveResult = argResultSet.getLong(1);
/* 129 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 130 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 136 */       primitiveResult = argResultSet.getLong(2);
/* 137 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 138 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 144 */       primitiveResult = argResultSet.getLong(3);
/* 145 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 146 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 151 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 152 */       if (t4 != null) {
/* 153 */         this._parent._businessDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 161 */       long l1 = argResultSet.getLong(5);
/* 162 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 163 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 167 */       this._parent._receiptId = argResultSet.getString(6);
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
/* 188 */       this._parent._receiptUrl = argResultSet.getString(11);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 193 */     argDAO.suppressStateChanges(true);
/* 194 */     ReceiptLookupDAO dao = (ReceiptLookupDAO)argDAO;
/* 195 */     dao.setOrganizationId(this._organizationId);
/* 196 */     dao.setRetailLocationId(this._retailLocationId);
/* 197 */     dao.setWorkstationId(this._workstationId);
/* 198 */     dao.setBusinessDate(this._businessDate);
/* 199 */     dao.setTransactionSequence(this._transactionSequence);
/* 200 */     dao.setReceiptId(this._receiptId);
/* 201 */     dao.setCreateDate(this._createDate);
/* 202 */     dao.setCreateUserId(this._createUserId);
/* 203 */     dao.setUpdateDate(this._updateDate);
/* 204 */     dao.setUpdateUserId(this._updateUserId);
/* 205 */     dao.setReceiptUrl(this._receiptUrl);
/* 206 */     argDAO.suppressStateChanges(false);
/* 207 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 211 */     return loadDAO((IDataAccessObject)new ReceiptLookupDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 215 */     ReceiptLookupDAO dao = (ReceiptLookupDAO)argDAO;
/* 216 */     this._organizationId = dao.getOrganizationId();
/* 217 */     this._retailLocationId = dao.getRetailLocationId();
/* 218 */     this._workstationId = dao.getWorkstationId();
/* 219 */     this._businessDate = dao.getBusinessDate();
/* 220 */     this._transactionSequence = dao.getTransactionSequence();
/* 221 */     this._receiptId = dao.getReceiptId();
/* 222 */     this._createDate = dao.getCreateDate();
/* 223 */     this._createUserId = dao.getCreateUserId();
/* 224 */     this._updateDate = dao.getUpdateDate();
/* 225 */     this._updateUserId = dao.getUpdateUserId();
/* 226 */     this._receiptUrl = dao.getReceiptUrl();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 230 */     ReceiptLookupId id = (ReceiptLookupId)argId;
/* 231 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 232 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 233 */     argStatement.setLong(3, id.getWorkstationId().longValue());
/* 234 */     argStatement.setTimestamp(4, new Timestamp(id.getBusinessDate().getTime()));
/* 235 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 236 */     argStatement.setString(6, id.getReceiptId());
/* 237 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 241 */     ReceiptLookupId id = new ReceiptLookupId();
/* 242 */     id.setOrganizationId(this._organizationId);
/* 243 */     id.setRetailLocationId(this._retailLocationId);
/* 244 */     id.setWorkstationId(this._workstationId);
/* 245 */     id.setBusinessDate(this._businessDate);
/* 246 */     id.setTransactionSequence(this._transactionSequence);
/* 247 */     id.setReceiptId(this._receiptId);
/* 248 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 256 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 260 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\ReceiptLookupDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */