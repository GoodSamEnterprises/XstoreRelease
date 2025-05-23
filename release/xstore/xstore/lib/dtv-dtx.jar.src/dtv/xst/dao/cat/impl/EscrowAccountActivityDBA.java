/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.EscrowAccountActivityId;
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
/*     */ public class EscrowAccountActivityDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -374900425L;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private Long _seqNbr;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _activityDate;
/*     */   private String _activityEnum;
/*     */   private BigDecimal _amt;
/*     */   private Date _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Long _retailLocationId;
/*     */   private String _sourceCustAccountId;
/*     */   private String _sourceCustAccountCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_id, t.seq_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.activity_date, t.activity_enum, t.amt, t.business_date, t.trans_seq, t.wkstn_id, t.rtl_loc_id, t.source_cust_acct_id, t.source_cust_acct_code FROM cat_escrow_acct_activity t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND seq_nbr = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.organization_id, t.cust_acct_id, t.seq_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.activity_date, t.activity_enum, t.amt, t.business_date, t.trans_seq, t.wkstn_id, t.rtl_loc_id, t.source_cust_acct_id, t.source_cust_acct_code FROM cat_escrow_acct_activity t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND seq_nbr = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_escrow_acct_activity(organization_id, cust_acct_id, seq_nbr, create_date, create_user_id, update_date, update_user_id, activity_date, activity_enum, amt, business_date, trans_seq, wkstn_id, rtl_loc_id, source_cust_acct_id, source_cust_acct_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._organizationId, this._custAccountId, this._seqNbr, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._activityDate, this._activityEnum, this._amt, this._businessDate, this._transactionSequence, this._workstationId, this._retailLocationId, this._sourceCustAccountId, this._sourceCustAccountCode } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, -5, 91, 12, 91, 12, 91, 12, 3, 91, -5, -5, -5, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_escrow_acct_activity SET update_date = ?, update_user_id = ?, activity_date = ?, activity_enum = ?, amt = ?, business_date = ?, trans_seq = ?, wkstn_id = ?, rtl_loc_id = ?, source_cust_acct_id = ?, source_cust_acct_code = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  78 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._activityDate, this._activityEnum, this._amt, this._businessDate, this._transactionSequence, this._workstationId, this._retailLocationId, this._sourceCustAccountId, this._sourceCustAccountCode } };
/*  83 */     return updateParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 12, 3, 91, -5, -5, -5, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  88 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_escrow_acct_activity" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND seq_nbr = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  94 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 100 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND seq_nbr = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 103 */     return new Object[] { this._organizationId, this._custAccountId, this._seqNbr };
/*     */   }
/*     */   
/* 106 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 109 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 112 */     return "cat_escrow_acct_activity";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new EscrowAccountActivityFiller(this);
/*     */   }
/*     */   
/*     */   private static class EscrowAccountActivityFiller
/*     */     implements IFiller {
/*     */     private EscrowAccountActivityDBA _parent;
/*     */     
/*     */     public EscrowAccountActivityFiller(EscrowAccountActivityDBA argParent) {
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
/* 139 */       this._parent._custAccountId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 142 */       primitiveResult = argResultSet.getLong(3);
/* 143 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 144 */         this._parent._seqNbr = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 149 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 150 */       if (t4 != null) {
/* 151 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 159 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 160 */       if (t6 != null) {
/* 161 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 164 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 167 */       this._parent._updateUserId = argResultSet.getString(7);
/*     */       
/* 169 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 170 */       if (t8 != null) {
/* 171 */         this._parent._activityDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 174 */         this._parent._activityDate = null;
/*     */       } 
/*     */       
/* 177 */       this._parent._activityEnum = argResultSet.getString(9);
/* 178 */       this._parent._amt = argResultSet.getBigDecimal(10);
/*     */       
/* 180 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 181 */       if (t11 != null) {
/* 182 */         this._parent._businessDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 185 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 190 */       long l1 = argResultSet.getLong(12);
/* 191 */       if (l1 != 0L || argResultSet.getObject(12) != null) {
/* 192 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 198 */       l1 = argResultSet.getLong(13);
/* 199 */       if (l1 != 0L || argResultSet.getObject(13) != null) {
/* 200 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 206 */       l1 = argResultSet.getLong(14);
/* 207 */       if (l1 != 0L || argResultSet.getObject(14) != null) {
/* 208 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 212 */       this._parent._sourceCustAccountId = argResultSet.getString(15);
/* 213 */       this._parent._sourceCustAccountCode = argResultSet.getString(16);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 218 */     argDAO.suppressStateChanges(true);
/* 219 */     EscrowAccountActivityDAO dao = (EscrowAccountActivityDAO)argDAO;
/* 220 */     dao.setOrganizationId(this._organizationId);
/* 221 */     dao.setCustAccountId(this._custAccountId);
/* 222 */     dao.setSeqNbr(this._seqNbr);
/* 223 */     dao.setCreateDate(this._createDate);
/* 224 */     dao.setCreateUserId(this._createUserId);
/* 225 */     dao.setUpdateDate(this._updateDate);
/* 226 */     dao.setUpdateUserId(this._updateUserId);
/* 227 */     dao.setActivityDate(this._activityDate);
/* 228 */     dao.setActivityEnum(this._activityEnum);
/* 229 */     dao.setAmt(this._amt);
/* 230 */     dao.setBusinessDate(this._businessDate);
/* 231 */     dao.setTransactionSequence(this._transactionSequence);
/* 232 */     dao.setWorkstationId(this._workstationId);
/* 233 */     dao.setRetailLocationId(this._retailLocationId);
/* 234 */     dao.setSourceCustAccountId(this._sourceCustAccountId);
/* 235 */     dao.setSourceCustAccountCode(this._sourceCustAccountCode);
/* 236 */     argDAO.suppressStateChanges(false);
/* 237 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 241 */     return loadDAO((IDataAccessObject)new EscrowAccountActivityDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 245 */     EscrowAccountActivityDAO dao = (EscrowAccountActivityDAO)argDAO;
/* 246 */     this._organizationId = dao.getOrganizationId();
/* 247 */     this._custAccountId = dao.getCustAccountId();
/* 248 */     this._seqNbr = dao.getSeqNbr();
/* 249 */     this._createDate = dao.getCreateDate();
/* 250 */     this._createUserId = dao.getCreateUserId();
/* 251 */     this._updateDate = dao.getUpdateDate();
/* 252 */     this._updateUserId = dao.getUpdateUserId();
/* 253 */     this._activityDate = dao.getActivityDate();
/* 254 */     this._activityEnum = dao.getActivityEnum();
/* 255 */     this._amt = dao.getAmt();
/* 256 */     this._businessDate = dao.getBusinessDate();
/* 257 */     this._transactionSequence = dao.getTransactionSequence();
/* 258 */     this._workstationId = dao.getWorkstationId();
/* 259 */     this._retailLocationId = dao.getRetailLocationId();
/* 260 */     this._sourceCustAccountId = dao.getSourceCustAccountId();
/* 261 */     this._sourceCustAccountCode = dao.getSourceCustAccountCode();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 265 */     EscrowAccountActivityId id = (EscrowAccountActivityId)argId;
/* 266 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 267 */     argStatement.setString(2, id.getCustAccountId());
/* 268 */     argStatement.setLong(3, id.getSeqNbr().longValue());
/* 269 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 273 */     EscrowAccountActivityId id = new EscrowAccountActivityId();
/* 274 */     id.setOrganizationId(this._organizationId);
/* 275 */     id.setCustAccountId(this._custAccountId);
/* 276 */     id.setSeqNbr(this._seqNbr);
/* 277 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 285 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 289 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\EscrowAccountActivityDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */