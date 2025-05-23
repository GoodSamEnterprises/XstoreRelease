/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.ReturnedItemJournalId;
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
/*     */ public class ReturnedItemJournalDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 769133365L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Date _businessDate;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _journalSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _returnedCount;
/*     */   private Long _returnedRetailLocationId;
/*     */   private Long _returnedWorkstationId;
/*     */   private Date _returnedBusinessDate;
/*     */   private Integer _returnedRetailTransactionLineItemSequence;
/*     */   private Long _returnedTransactionSequence;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.rtrans_lineitm_seq, t.trans_seq, t.journal_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.returned_count, t.rtn_rtl_loc_id, t.rtn_wkstn_id, t.rtn_business_date, t.rtn_rtrans_lineitm_seq, t.rtn_trans_seq FROM trl_returned_item_journal t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND journal_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.rtrans_lineitm_seq, t.trans_seq, t.journal_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.returned_count, t.rtn_rtl_loc_id, t.rtn_wkstn_id, t.rtn_business_date, t.rtn_rtrans_lineitm_seq, t.rtn_trans_seq FROM trl_returned_item_journal t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  56 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND journal_seq = ?  ";
/*     */   }
/*     */   
/*  59 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_returned_item_journal(organization_id, rtl_loc_id, wkstn_id, business_date, rtrans_lineitm_seq, trans_seq, journal_seq, create_date, create_user_id, update_date, update_user_id, returned_count, rtn_rtl_loc_id, rtn_wkstn_id, rtn_business_date, rtn_rtrans_lineitm_seq, rtn_trans_seq) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  62 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._retailTransactionLineItemSequence, this._transactionSequence, this._journalSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._returnedCount, this._returnedRetailLocationId, this._returnedWorkstationId, this._returnedBusinessDate, this._returnedRetailTransactionLineItemSequence, this._returnedTransactionSequence } };
/*  67 */     return insertParameterObject;
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 91, 4, -5, -5, 91, 12, 91, 12, 3, -5, -5, 91, 4, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_returned_item_journal SET update_date = ?, update_user_id = ?, returned_count = ?, rtn_rtl_loc_id = ?, rtn_wkstn_id = ?, rtn_business_date = ?, rtn_rtrans_lineitm_seq = ?, rtn_trans_seq = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  83 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._returnedCount, this._returnedRetailLocationId, this._returnedWorkstationId, this._returnedBusinessDate, this._returnedRetailTransactionLineItemSequence, this._returnedTransactionSequence } };
/*  84 */     return updateParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, -5, -5, 91, 4, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_returned_item_journal" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND journal_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  95 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 101 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND journal_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 104 */     return new Object[] { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._retailTransactionLineItemSequence, this._transactionSequence, this._journalSequence };
/*     */   }
/*     */   
/* 107 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 91, 4, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 110 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 113 */     return "trl_returned_item_journal";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 117 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 121 */     return new ReturnedItemJournalFiller(this);
/*     */   }
/*     */   
/*     */   private static class ReturnedItemJournalFiller
/*     */     implements IFiller {
/*     */     private ReturnedItemJournalDBA _parent;
/*     */     
/*     */     public ReturnedItemJournalFiller(ReturnedItemJournalDBA argParent) {
/* 129 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 134 */       long primitiveResult = argResultSet.getLong(1);
/* 135 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 136 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       primitiveResult = argResultSet.getLong(2);
/* 143 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 144 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 150 */       primitiveResult = argResultSet.getLong(3);
/* 151 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 152 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 157 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 158 */       if (t4 != null) {
/* 159 */         this._parent._businessDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 162 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 167 */       int i = argResultSet.getInt(5);
/* 168 */       if (i != 0 || argResultSet.getObject(5) != null) {
/* 169 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 175 */       long l1 = argResultSet.getLong(6);
/* 176 */       if (l1 != 0L || argResultSet.getObject(6) != null) {
/* 177 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 183 */       l1 = argResultSet.getLong(7);
/* 184 */       if (l1 != 0L || argResultSet.getObject(7) != null) {
/* 185 */         this._parent._journalSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 190 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 191 */       if (t8 != null) {
/* 192 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 195 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 198 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 200 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 201 */       if (t10 != null) {
/* 202 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 205 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 208 */       this._parent._updateUserId = argResultSet.getString(11);
/* 209 */       this._parent._returnedCount = argResultSet.getBigDecimal(12);
/*     */ 
/*     */       
/* 212 */       long l2 = argResultSet.getLong(13);
/* 213 */       if (l2 != 0L || argResultSet.getObject(13) != null) {
/* 214 */         this._parent._returnedRetailLocationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 220 */       l2 = argResultSet.getLong(14);
/* 221 */       if (l2 != 0L || argResultSet.getObject(14) != null) {
/* 222 */         this._parent._returnedWorkstationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 227 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 228 */       if (t15 != null) {
/* 229 */         this._parent._returnedBusinessDate = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 232 */         this._parent._returnedBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 237 */       int j = argResultSet.getInt(16);
/* 238 */       if (j != 0 || argResultSet.getObject(16) != null) {
/* 239 */         this._parent._returnedRetailTransactionLineItemSequence = Integer.valueOf(j);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 245 */       long l3 = argResultSet.getLong(17);
/* 246 */       if (l3 != 0L || argResultSet.getObject(17) != null) {
/* 247 */         this._parent._returnedTransactionSequence = Long.valueOf(l3);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 255 */     argDAO.suppressStateChanges(true);
/* 256 */     ReturnedItemJournalDAO dao = (ReturnedItemJournalDAO)argDAO;
/* 257 */     dao.setOrganizationId(this._organizationId);
/* 258 */     dao.setRetailLocationId(this._retailLocationId);
/* 259 */     dao.setWorkstationId(this._workstationId);
/* 260 */     dao.setBusinessDate(this._businessDate);
/* 261 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 262 */     dao.setTransactionSequence(this._transactionSequence);
/* 263 */     dao.setJournalSequence(this._journalSequence);
/* 264 */     dao.setCreateDate(this._createDate);
/* 265 */     dao.setCreateUserId(this._createUserId);
/* 266 */     dao.setUpdateDate(this._updateDate);
/* 267 */     dao.setUpdateUserId(this._updateUserId);
/* 268 */     dao.setReturnedCount(this._returnedCount);
/* 269 */     dao.setReturnedRetailLocationId(this._returnedRetailLocationId);
/* 270 */     dao.setReturnedWorkstationId(this._returnedWorkstationId);
/* 271 */     dao.setReturnedBusinessDate(this._returnedBusinessDate);
/* 272 */     dao.setReturnedRetailTransactionLineItemSequence(this._returnedRetailTransactionLineItemSequence);
/* 273 */     dao.setReturnedTransactionSequence(this._returnedTransactionSequence);
/* 274 */     argDAO.suppressStateChanges(false);
/* 275 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 279 */     return loadDAO((IDataAccessObject)new ReturnedItemJournalDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 283 */     ReturnedItemJournalDAO dao = (ReturnedItemJournalDAO)argDAO;
/* 284 */     this._organizationId = dao.getOrganizationId();
/* 285 */     this._retailLocationId = dao.getRetailLocationId();
/* 286 */     this._workstationId = dao.getWorkstationId();
/* 287 */     this._businessDate = dao.getBusinessDate();
/* 288 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 289 */     this._transactionSequence = dao.getTransactionSequence();
/* 290 */     this._journalSequence = dao.getJournalSequence();
/* 291 */     this._createDate = dao.getCreateDate();
/* 292 */     this._createUserId = dao.getCreateUserId();
/* 293 */     this._updateDate = dao.getUpdateDate();
/* 294 */     this._updateUserId = dao.getUpdateUserId();
/* 295 */     this._returnedCount = dao.getReturnedCount();
/* 296 */     this._returnedRetailLocationId = dao.getReturnedRetailLocationId();
/* 297 */     this._returnedWorkstationId = dao.getReturnedWorkstationId();
/* 298 */     this._returnedBusinessDate = dao.getReturnedBusinessDate();
/* 299 */     this._returnedRetailTransactionLineItemSequence = dao.getReturnedRetailTransactionLineItemSequence();
/* 300 */     this._returnedTransactionSequence = dao.getReturnedTransactionSequence();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 304 */     ReturnedItemJournalId id = (ReturnedItemJournalId)argId;
/* 305 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 306 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 307 */     argStatement.setLong(3, id.getWorkstationId().longValue());
/* 308 */     argStatement.setTimestamp(4, new Timestamp(id.getBusinessDate().getTime()));
/* 309 */     argStatement.setInt(5, id.getRetailTransactionLineItemSequence().intValue());
/* 310 */     argStatement.setLong(6, id.getTransactionSequence().longValue());
/* 311 */     argStatement.setLong(7, id.getJournalSequence().longValue());
/* 312 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 316 */     ReturnedItemJournalId id = new ReturnedItemJournalId();
/* 317 */     id.setOrganizationId(this._organizationId);
/* 318 */     id.setRetailLocationId(this._retailLocationId);
/* 319 */     id.setWorkstationId(this._workstationId);
/* 320 */     id.setBusinessDate(this._businessDate);
/* 321 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 322 */     id.setTransactionSequence(this._transactionSequence);
/* 323 */     id.setJournalSequence(this._journalSequence);
/* 324 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 332 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 336 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\ReturnedItemJournalDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */