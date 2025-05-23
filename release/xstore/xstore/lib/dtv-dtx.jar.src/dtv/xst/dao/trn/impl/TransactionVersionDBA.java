/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.TransactionVersionId;
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
/*     */ public class TransactionVersionDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1583695930L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _baseAppVersion;
/*     */   private Date _baseAppDate;
/*     */   private String _baseSchemaVersion;
/*     */   private Date _baseSchemaDate;
/*     */   private String _customerAppVersion;
/*     */   private String _customerSchemaVersion;
/*     */   private Date _customerSchemaDate;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.base_app_version, t.base_app_date, t.base_schema_version, t.base_schema_date, t.customer_app_version, t.customer_schema_version, t.customer_schema_date FROM trn_trans_version t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.base_app_version, t.base_app_date, t.base_schema_version, t.base_schema_date, t.customer_app_version, t.customer_schema_version, t.customer_schema_date FROM trn_trans_version t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trn_trans_version(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, create_date, create_user_id, update_date, update_user_id, base_app_version, base_app_date, base_schema_version, base_schema_date, customer_app_version, customer_schema_version, customer_schema_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._baseAppVersion, this._baseAppDate, this._baseSchemaVersion, this._baseSchemaDate, this._customerAppVersion, this._customerSchemaVersion, this._customerSchemaDate } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 91, 12, 91, 12, 12, 91, 12, 91, 12, 12, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trn_trans_version SET update_date = ?, update_user_id = ?, base_app_version = ?, base_app_date = ?, base_schema_version = ?, base_schema_date = ?, customer_app_version = ?, customer_schema_version = ?, customer_schema_date = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  78 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._baseAppVersion, this._baseAppDate, this._baseSchemaVersion, this._baseSchemaDate, this._customerAppVersion, this._customerSchemaVersion, this._customerSchemaDate } };
/*  83 */     return updateParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 91, 12, 91, 12, 12, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  88 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trn_trans_version" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  94 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 100 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 103 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence };
/*     */   }
/*     */   
/* 106 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 109 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 112 */     return "trn_trans_version";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new TransactionVersionFiller(this);
/*     */   }
/*     */   
/*     */   private static class TransactionVersionFiller
/*     */     implements IFiller {
/*     */     private TransactionVersionDBA _parent;
/*     */     
/*     */     public TransactionVersionFiller(TransactionVersionDBA argParent) {
/* 128 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 133 */       long primitiveResult = argResultSet.getLong(1);
/* 134 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 135 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 141 */       primitiveResult = argResultSet.getLong(2);
/* 142 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 143 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 148 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 149 */       if (t3 != null) {
/* 150 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 153 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 158 */       long l1 = argResultSet.getLong(4);
/* 159 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 160 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 166 */       l1 = argResultSet.getLong(5);
/* 167 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 168 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 173 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 174 */       if (t6 != null) {
/* 175 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 178 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 181 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 183 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 184 */       if (t8 != null) {
/* 185 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 188 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 191 */       this._parent._updateUserId = argResultSet.getString(9);
/* 192 */       this._parent._baseAppVersion = argResultSet.getString(10);
/*     */       
/* 194 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 195 */       if (t11 != null) {
/* 196 */         this._parent._baseAppDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 199 */         this._parent._baseAppDate = null;
/*     */       } 
/*     */       
/* 202 */       this._parent._baseSchemaVersion = argResultSet.getString(12);
/*     */       
/* 204 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 205 */       if (t13 != null) {
/* 206 */         this._parent._baseSchemaDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 209 */         this._parent._baseSchemaDate = null;
/*     */       } 
/*     */       
/* 212 */       this._parent._customerAppVersion = argResultSet.getString(14);
/* 213 */       this._parent._customerSchemaVersion = argResultSet.getString(15);
/*     */       
/* 215 */       Timestamp t16 = argResultSet.getTimestamp(16);
/* 216 */       if (t16 != null) {
/* 217 */         this._parent._customerSchemaDate = (Date)new DtvDate(t16.getTime());
/*     */       } else {
/*     */         
/* 220 */         this._parent._customerSchemaDate = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 227 */     argDAO.suppressStateChanges(true);
/* 228 */     TransactionVersionDAO dao = (TransactionVersionDAO)argDAO;
/* 229 */     dao.setOrganizationId(this._organizationId);
/* 230 */     dao.setRetailLocationId(this._retailLocationId);
/* 231 */     dao.setBusinessDate(this._businessDate);
/* 232 */     dao.setWorkstationId(this._workstationId);
/* 233 */     dao.setTransactionSequence(this._transactionSequence);
/* 234 */     dao.setCreateDate(this._createDate);
/* 235 */     dao.setCreateUserId(this._createUserId);
/* 236 */     dao.setUpdateDate(this._updateDate);
/* 237 */     dao.setUpdateUserId(this._updateUserId);
/* 238 */     dao.setBaseAppVersion(this._baseAppVersion);
/* 239 */     dao.setBaseAppDate(this._baseAppDate);
/* 240 */     dao.setBaseSchemaVersion(this._baseSchemaVersion);
/* 241 */     dao.setBaseSchemaDate(this._baseSchemaDate);
/* 242 */     dao.setCustomerAppVersion(this._customerAppVersion);
/* 243 */     dao.setCustomerSchemaVersion(this._customerSchemaVersion);
/* 244 */     dao.setCustomerSchemaDate(this._customerSchemaDate);
/* 245 */     argDAO.suppressStateChanges(false);
/* 246 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 250 */     return loadDAO((IDataAccessObject)new TransactionVersionDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 254 */     TransactionVersionDAO dao = (TransactionVersionDAO)argDAO;
/* 255 */     this._organizationId = dao.getOrganizationId();
/* 256 */     this._retailLocationId = dao.getRetailLocationId();
/* 257 */     this._businessDate = dao.getBusinessDate();
/* 258 */     this._workstationId = dao.getWorkstationId();
/* 259 */     this._transactionSequence = dao.getTransactionSequence();
/* 260 */     this._createDate = dao.getCreateDate();
/* 261 */     this._createUserId = dao.getCreateUserId();
/* 262 */     this._updateDate = dao.getUpdateDate();
/* 263 */     this._updateUserId = dao.getUpdateUserId();
/* 264 */     this._baseAppVersion = dao.getBaseAppVersion();
/* 265 */     this._baseAppDate = dao.getBaseAppDate();
/* 266 */     this._baseSchemaVersion = dao.getBaseSchemaVersion();
/* 267 */     this._baseSchemaDate = dao.getBaseSchemaDate();
/* 268 */     this._customerAppVersion = dao.getCustomerAppVersion();
/* 269 */     this._customerSchemaVersion = dao.getCustomerSchemaVersion();
/* 270 */     this._customerSchemaDate = dao.getCustomerSchemaDate();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 274 */     TransactionVersionId id = (TransactionVersionId)argId;
/* 275 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 276 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 277 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 278 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 279 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 280 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 284 */     TransactionVersionId id = new TransactionVersionId();
/* 285 */     id.setOrganizationId(this._organizationId);
/* 286 */     id.setRetailLocationId(this._retailLocationId);
/* 287 */     id.setBusinessDate(this._businessDate);
/* 288 */     id.setWorkstationId(this._workstationId);
/* 289 */     id.setTransactionSequence(this._transactionSequence);
/* 290 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 298 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 302 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\TransactionVersionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */