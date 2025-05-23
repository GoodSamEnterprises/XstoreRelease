/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventorySummaryCountTransactionDetailId;
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
/*     */ public class InventorySummaryCountTransactionDetailDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1159165206L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Date _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private Integer _transLineSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _locationId;
/*     */   private String _bucketId;
/*     */   private BigDecimal _systemCount;
/*     */   private BigDecimal _declaredCount;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.trans_line_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.location_id, t.bucket_id, t.system_count, t.declared_count FROM inv_sum_count_trans_dtl t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND trans_line_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.trans_line_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.location_id, t.bucket_id, t.system_count, t.declared_count FROM inv_sum_count_trans_dtl t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND trans_line_seq = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_sum_count_trans_dtl(organization_id, rtl_loc_id, wkstn_id, business_date, trans_seq, trans_line_seq, create_date, create_user_id, update_date, update_user_id, location_id, bucket_id, system_count, declared_count) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._transLineSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._locationId, this._bucketId, this._systemCount, this._declaredCount } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 91, -5, 4, 91, 12, 91, 12, 12, 12, 3, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_sum_count_trans_dtl SET update_date = ?, update_user_id = ?, location_id = ?, bucket_id = ?, system_count = ?, declared_count = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._locationId, this._bucketId, this._systemCount, this._declaredCount } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 3, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_sum_count_trans_dtl" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND trans_line_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND trans_line_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._transLineSequence };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 91, -5, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "inv_sum_count_trans_dtl";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new InventorySummaryCountTransactionDetailFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventorySummaryCountTransactionDetailFiller
/*     */     implements IFiller {
/*     */     private InventorySummaryCountTransactionDetailDBA _parent;
/*     */     
/*     */     public InventorySummaryCountTransactionDetailFiller(InventorySummaryCountTransactionDetailDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       long primitiveResult = argResultSet.getLong(1);
/* 132 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 133 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       primitiveResult = argResultSet.getLong(2);
/* 140 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 141 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 147 */       primitiveResult = argResultSet.getLong(3);
/* 148 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 149 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 154 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 155 */       if (t4 != null) {
/* 156 */         this._parent._businessDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 159 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 164 */       long l1 = argResultSet.getLong(5);
/* 165 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 166 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 172 */       int i = argResultSet.getInt(6);
/* 173 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 174 */         this._parent._transLineSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 179 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 180 */       if (t7 != null) {
/* 181 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 184 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 187 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 189 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 190 */       if (t9 != null) {
/* 191 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 194 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 197 */       this._parent._updateUserId = argResultSet.getString(10);
/* 198 */       this._parent._locationId = argResultSet.getString(11);
/* 199 */       this._parent._bucketId = argResultSet.getString(12);
/* 200 */       this._parent._systemCount = argResultSet.getBigDecimal(13);
/* 201 */       this._parent._declaredCount = argResultSet.getBigDecimal(14);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 206 */     argDAO.suppressStateChanges(true);
/* 207 */     InventorySummaryCountTransactionDetailDAO dao = (InventorySummaryCountTransactionDetailDAO)argDAO;
/* 208 */     dao.setOrganizationId(this._organizationId);
/* 209 */     dao.setRetailLocationId(this._retailLocationId);
/* 210 */     dao.setWorkstationId(this._workstationId);
/* 211 */     dao.setBusinessDate(this._businessDate);
/* 212 */     dao.setTransactionSequence(this._transactionSequence);
/* 213 */     dao.setTransLineSequence(this._transLineSequence);
/* 214 */     dao.setCreateDate(this._createDate);
/* 215 */     dao.setCreateUserId(this._createUserId);
/* 216 */     dao.setUpdateDate(this._updateDate);
/* 217 */     dao.setUpdateUserId(this._updateUserId);
/* 218 */     dao.setLocationId(this._locationId);
/* 219 */     dao.setBucketId(this._bucketId);
/* 220 */     dao.setSystemCount(this._systemCount);
/* 221 */     dao.setDeclaredCount(this._declaredCount);
/* 222 */     argDAO.suppressStateChanges(false);
/* 223 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 227 */     return loadDAO((IDataAccessObject)new InventorySummaryCountTransactionDetailDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 231 */     InventorySummaryCountTransactionDetailDAO dao = (InventorySummaryCountTransactionDetailDAO)argDAO;
/* 232 */     this._organizationId = dao.getOrganizationId();
/* 233 */     this._retailLocationId = dao.getRetailLocationId();
/* 234 */     this._workstationId = dao.getWorkstationId();
/* 235 */     this._businessDate = dao.getBusinessDate();
/* 236 */     this._transactionSequence = dao.getTransactionSequence();
/* 237 */     this._transLineSequence = dao.getTransLineSequence();
/* 238 */     this._createDate = dao.getCreateDate();
/* 239 */     this._createUserId = dao.getCreateUserId();
/* 240 */     this._updateDate = dao.getUpdateDate();
/* 241 */     this._updateUserId = dao.getUpdateUserId();
/* 242 */     this._locationId = dao.getLocationId();
/* 243 */     this._bucketId = dao.getBucketId();
/* 244 */     this._systemCount = dao.getSystemCount();
/* 245 */     this._declaredCount = dao.getDeclaredCount();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 249 */     InventorySummaryCountTransactionDetailId id = (InventorySummaryCountTransactionDetailId)argId;
/* 250 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 251 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 252 */     argStatement.setLong(3, id.getWorkstationId().longValue());
/* 253 */     argStatement.setTimestamp(4, new Timestamp(id.getBusinessDate().getTime()));
/* 254 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 255 */     argStatement.setInt(6, id.getTransLineSequence().intValue());
/* 256 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 260 */     InventorySummaryCountTransactionDetailId id = new InventorySummaryCountTransactionDetailId();
/* 261 */     id.setOrganizationId(this._organizationId);
/* 262 */     id.setRetailLocationId(this._retailLocationId);
/* 263 */     id.setWorkstationId(this._workstationId);
/* 264 */     id.setBusinessDate(this._businessDate);
/* 265 */     id.setTransactionSequence(this._transactionSequence);
/* 266 */     id.setTransLineSequence(this._transLineSequence);
/* 267 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 275 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 279 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventorySummaryCountTransactionDetailDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */