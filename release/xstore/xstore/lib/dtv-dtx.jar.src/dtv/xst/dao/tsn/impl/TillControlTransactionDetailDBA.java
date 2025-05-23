/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TillControlTransactionDetailId;
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
/*     */ public class TillControlTransactionDetailDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1585992935L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Date _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private Long _transactionLineItemSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _affectedTenderRepositoryId;
/*     */   private Long _affectedWorkstationId;
/*     */   private String _currencyId;
/*     */   private BigDecimal _oldAmount;
/*     */   private BigDecimal _newAmount;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.trans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.affected_tndr_repository_id, t.affected_wkstn_id, t.currency_id, t.old_amount, t.new_amount FROM tsn_till_ctrl_trans_detail t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.trans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.affected_tndr_repository_id, t.affected_wkstn_id, t.currency_id, t.old_amount, t.new_amount FROM tsn_till_ctrl_trans_detail t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_till_ctrl_trans_detail(organization_id, rtl_loc_id, wkstn_id, business_date, trans_seq, trans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, affected_tndr_repository_id, affected_wkstn_id, currency_id, old_amount, new_amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._transactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._affectedTenderRepositoryId, this._affectedWorkstationId, this._currencyId, this._oldAmount, this._newAmount } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 91, -5, -5, 91, 12, 91, 12, 12, -5, 12, 3, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_till_ctrl_trans_detail SET update_date = ?, update_user_id = ?, affected_tndr_repository_id = ?, affected_wkstn_id = ?, currency_id = ?, old_amount = ?, new_amount = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._affectedTenderRepositoryId, this._affectedWorkstationId, this._currencyId, this._oldAmount, this._newAmount } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, -5, 12, 3, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_till_ctrl_trans_detail" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._transactionLineItemSequence };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 91, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "tsn_till_ctrl_trans_detail";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new TillControlTransactionDetailFiller(this);
/*     */   }
/*     */   
/*     */   private static class TillControlTransactionDetailFiller
/*     */     implements IFiller {
/*     */     private TillControlTransactionDetailDBA _parent;
/*     */     
/*     */     public TillControlTransactionDetailFiller(TillControlTransactionDetailDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 132 */       long primitiveResult = argResultSet.getLong(1);
/* 133 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 134 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 140 */       primitiveResult = argResultSet.getLong(2);
/* 141 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 142 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 148 */       primitiveResult = argResultSet.getLong(3);
/* 149 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 150 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 155 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 156 */       if (t4 != null) {
/* 157 */         this._parent._businessDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 165 */       long l1 = argResultSet.getLong(5);
/* 166 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 167 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 173 */       l1 = argResultSet.getLong(6);
/* 174 */       if (l1 != 0L || argResultSet.getObject(6) != null) {
/* 175 */         this._parent._transactionLineItemSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 180 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 181 */       if (t7 != null) {
/* 182 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 185 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 188 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 190 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 191 */       if (t9 != null) {
/* 192 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 195 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 198 */       this._parent._updateUserId = argResultSet.getString(10);
/* 199 */       this._parent._affectedTenderRepositoryId = argResultSet.getString(11);
/*     */ 
/*     */       
/* 202 */       long l2 = argResultSet.getLong(12);
/* 203 */       if (l2 != 0L || argResultSet.getObject(12) != null) {
/* 204 */         this._parent._affectedWorkstationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 208 */       this._parent._currencyId = argResultSet.getString(13);
/* 209 */       this._parent._oldAmount = argResultSet.getBigDecimal(14);
/* 210 */       this._parent._newAmount = argResultSet.getBigDecimal(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 215 */     argDAO.suppressStateChanges(true);
/* 216 */     TillControlTransactionDetailDAO dao = (TillControlTransactionDetailDAO)argDAO;
/* 217 */     dao.setOrganizationId(this._organizationId);
/* 218 */     dao.setRetailLocationId(this._retailLocationId);
/* 219 */     dao.setWorkstationId(this._workstationId);
/* 220 */     dao.setBusinessDate(this._businessDate);
/* 221 */     dao.setTransactionSequence(this._transactionSequence);
/* 222 */     dao.setTransactionLineItemSequence(this._transactionLineItemSequence);
/* 223 */     dao.setCreateDate(this._createDate);
/* 224 */     dao.setCreateUserId(this._createUserId);
/* 225 */     dao.setUpdateDate(this._updateDate);
/* 226 */     dao.setUpdateUserId(this._updateUserId);
/* 227 */     dao.setAffectedTenderRepositoryId(this._affectedTenderRepositoryId);
/* 228 */     dao.setAffectedWorkstationId(this._affectedWorkstationId);
/* 229 */     dao.setCurrencyId(this._currencyId);
/* 230 */     dao.setOldAmount(this._oldAmount);
/* 231 */     dao.setNewAmount(this._newAmount);
/* 232 */     argDAO.suppressStateChanges(false);
/* 233 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 237 */     return loadDAO((IDataAccessObject)new TillControlTransactionDetailDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 241 */     TillControlTransactionDetailDAO dao = (TillControlTransactionDetailDAO)argDAO;
/* 242 */     this._organizationId = dao.getOrganizationId();
/* 243 */     this._retailLocationId = dao.getRetailLocationId();
/* 244 */     this._workstationId = dao.getWorkstationId();
/* 245 */     this._businessDate = dao.getBusinessDate();
/* 246 */     this._transactionSequence = dao.getTransactionSequence();
/* 247 */     this._transactionLineItemSequence = dao.getTransactionLineItemSequence();
/* 248 */     this._createDate = dao.getCreateDate();
/* 249 */     this._createUserId = dao.getCreateUserId();
/* 250 */     this._updateDate = dao.getUpdateDate();
/* 251 */     this._updateUserId = dao.getUpdateUserId();
/* 252 */     this._affectedTenderRepositoryId = dao.getAffectedTenderRepositoryId();
/* 253 */     this._affectedWorkstationId = dao.getAffectedWorkstationId();
/* 254 */     this._currencyId = dao.getCurrencyId();
/* 255 */     this._oldAmount = dao.getOldAmount();
/* 256 */     this._newAmount = dao.getNewAmount();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 260 */     TillControlTransactionDetailId id = (TillControlTransactionDetailId)argId;
/* 261 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 262 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 263 */     argStatement.setLong(3, id.getWorkstationId().longValue());
/* 264 */     argStatement.setTimestamp(4, new Timestamp(id.getBusinessDate().getTime()));
/* 265 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 266 */     argStatement.setLong(6, id.getTransactionLineItemSequence().longValue());
/* 267 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 271 */     TillControlTransactionDetailId id = new TillControlTransactionDetailId();
/* 272 */     id.setOrganizationId(this._organizationId);
/* 273 */     id.setRetailLocationId(this._retailLocationId);
/* 274 */     id.setWorkstationId(this._workstationId);
/* 275 */     id.setBusinessDate(this._businessDate);
/* 276 */     id.setTransactionSequence(this._transactionSequence);
/* 277 */     id.setTransactionLineItemSequence(this._transactionLineItemSequence);
/* 278 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 286 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 290 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TillControlTransactionDetailDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */