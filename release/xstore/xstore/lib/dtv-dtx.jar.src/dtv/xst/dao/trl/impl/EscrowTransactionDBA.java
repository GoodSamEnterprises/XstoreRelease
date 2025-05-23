/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.PosTransactionId;
/*     */ import dtv.xst.dao.trn.impl.PosTransactionDBA;
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
/*     */ public class EscrowTransactionDBA
/*     */   extends PosTransactionDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1213959481L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _custAccountId;
/*     */   private Long _activitySequenceNumber;
/*     */   private BigDecimal _escrowAmount;
/*     */   private Long _customerPartyId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.cust_acct_id, t.activity_seq_nbr, t.escrow_amt, t.cust_party_id FROM trl_escrow_trans t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.cust_acct_id, t.activity_seq_nbr, t.escrow_amt, t.cust_party_id FROM trl_escrow_trans t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_escrow_trans(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, create_date, create_user_id, update_date, update_user_id, cust_acct_id, activity_seq_nbr, escrow_amt, cust_party_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._custAccountId, this._activitySequenceNumber, this._escrowAmount, this._customerPartyId } };
/*  67 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 91, 12, 91, 12, 12, -5, 3, -5 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  74 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  77 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_escrow_trans SET update_date = ?, update_user_id = ?, cust_acct_id = ?, activity_seq_nbr = ?, escrow_amt = ?, cust_party_id = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  81 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  86 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._custAccountId, this._activitySequenceNumber, this._escrowAmount, this._customerPartyId } };
/*  87 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  90 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, -5, 3, -5 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  93 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/*  96 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_escrow_trans" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 100 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 107 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 111 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence };
/*     */   }
/*     */   
/* 114 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 118 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 122 */     return "trl_escrow_trans";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 127 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 131 */     return new EscrowTransactionFiller(this);
/*     */   }
/*     */   
/*     */   private static class EscrowTransactionFiller
/*     */     implements IFiller {
/*     */     private EscrowTransactionDBA _parent;
/*     */     
/*     */     public EscrowTransactionFiller(EscrowTransactionDBA argParent) {
/* 139 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 144 */       long primitiveResult = argResultSet.getLong(1);
/* 145 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 146 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 152 */       primitiveResult = argResultSet.getLong(2);
/* 153 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 154 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 159 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 160 */       if (t3 != null) {
/* 161 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 164 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 169 */       long l1 = argResultSet.getLong(4);
/* 170 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 171 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 177 */       l1 = argResultSet.getLong(5);
/* 178 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 179 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 184 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 185 */       if (t6 != null) {
/* 186 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 189 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 192 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 194 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 195 */       if (t8 != null) {
/* 196 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 199 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 202 */       this._parent._updateUserId = argResultSet.getString(9);
/* 203 */       this._parent._custAccountId = argResultSet.getString(10);
/*     */ 
/*     */       
/* 206 */       long l2 = argResultSet.getLong(11);
/* 207 */       if (l2 != 0L || argResultSet.getObject(11) != null) {
/* 208 */         this._parent._activitySequenceNumber = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 212 */       this._parent._escrowAmount = argResultSet.getBigDecimal(12);
/*     */ 
/*     */       
/* 215 */       l2 = argResultSet.getLong(13);
/* 216 */       if (l2 != 0L || argResultSet.getObject(13) != null) {
/* 217 */         this._parent._customerPartyId = Long.valueOf(l2);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 226 */     super.loadDAO(argDAO);
/* 227 */     argDAO.suppressStateChanges(true);
/* 228 */     EscrowTransactionDAO dao = (EscrowTransactionDAO)argDAO;
/* 229 */     dao.setOrganizationId(this._organizationId);
/* 230 */     dao.setRetailLocationId(this._retailLocationId);
/* 231 */     dao.setBusinessDate(this._businessDate);
/* 232 */     dao.setWorkstationId(this._workstationId);
/* 233 */     dao.setTransactionSequence(this._transactionSequence);
/* 234 */     dao.setCreateDate(this._createDate);
/* 235 */     dao.setCreateUserId(this._createUserId);
/* 236 */     dao.setUpdateDate(this._updateDate);
/* 237 */     dao.setUpdateUserId(this._updateUserId);
/* 238 */     dao.setCustAccountId(this._custAccountId);
/* 239 */     dao.setActivitySequenceNumber(this._activitySequenceNumber);
/* 240 */     dao.setEscrowAmount(this._escrowAmount);
/* 241 */     dao.setCustomerPartyId(this._customerPartyId);
/* 242 */     argDAO.suppressStateChanges(false);
/* 243 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 248 */     return loadDAO((IDataAccessObject)new EscrowTransactionDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 253 */     EscrowTransactionDAO dao = (EscrowTransactionDAO)argDAO;
/* 254 */     super.fill((IDataAccessObject)dao);
/* 255 */     this._organizationId = dao.getOrganizationId();
/* 256 */     this._retailLocationId = dao.getRetailLocationId();
/* 257 */     this._businessDate = dao.getBusinessDate();
/* 258 */     this._workstationId = dao.getWorkstationId();
/* 259 */     this._transactionSequence = dao.getTransactionSequence();
/* 260 */     this._createDate = dao.getCreateDate();
/* 261 */     this._createUserId = dao.getCreateUserId();
/* 262 */     this._updateDate = dao.getUpdateDate();
/* 263 */     this._updateUserId = dao.getUpdateUserId();
/* 264 */     this._custAccountId = dao.getCustAccountId();
/* 265 */     this._activitySequenceNumber = dao.getActivitySequenceNumber();
/* 266 */     this._escrowAmount = dao.getEscrowAmount();
/* 267 */     this._customerPartyId = dao.getCustomerPartyId();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 272 */     PosTransactionId id = (PosTransactionId)argId;
/* 273 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 274 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 275 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 276 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 277 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 278 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 282 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 286 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\EscrowTransactionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */