/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailTransactionLineItemId;
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
/*     */ public class AccountCreditTenderLineItemDBA
/*     */   extends TenderLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -183245535L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.cust_acct_id, t.cust_acct_code FROM ttr_acct_credit_tndr_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.cust_acct_id, t.cust_acct_code FROM ttr_acct_credit_tndr_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ttr_acct_credit_tndr_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, cust_acct_id, cust_acct_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._custAccountId, this._custAccountCode } };
/*  66 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ttr_acct_credit_tndr_lineitm SET update_date = ?, update_user_id = ?, cust_acct_id = ?, cust_acct_code = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  80 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  85 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._custAccountId, this._custAccountCode } };
/*  86 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  89 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  92 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/*  95 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ttr_acct_credit_tndr_lineitm" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  99 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 106 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 110 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 113 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 117 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 121 */     return "ttr_acct_credit_tndr_lineitm";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 126 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 130 */     return new AccountCreditTenderLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class AccountCreditTenderLineItemFiller
/*     */     implements IFiller {
/*     */     private AccountCreditTenderLineItemDBA _parent;
/*     */     
/*     */     public AccountCreditTenderLineItemFiller(AccountCreditTenderLineItemDBA argParent) {
/* 138 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 143 */       long primitiveResult = argResultSet.getLong(1);
/* 144 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 145 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 151 */       primitiveResult = argResultSet.getLong(2);
/* 152 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 153 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 158 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 159 */       if (t3 != null) {
/* 160 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 163 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 168 */       long l1 = argResultSet.getLong(4);
/* 169 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 170 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 176 */       l1 = argResultSet.getLong(5);
/* 177 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 178 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 184 */       int i = argResultSet.getInt(6);
/* 185 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 186 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 191 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 192 */       if (t7 != null) {
/* 193 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 196 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 199 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 201 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 202 */       if (t9 != null) {
/* 203 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 206 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 209 */       this._parent._updateUserId = argResultSet.getString(10);
/* 210 */       this._parent._custAccountId = argResultSet.getString(11);
/* 211 */       this._parent._custAccountCode = argResultSet.getString(12);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 217 */     super.loadDAO(argDAO);
/* 218 */     argDAO.suppressStateChanges(true);
/* 219 */     AccountCreditTenderLineItemDAO dao = (AccountCreditTenderLineItemDAO)argDAO;
/* 220 */     dao.setOrganizationId(this._organizationId);
/* 221 */     dao.setRetailLocationId(this._retailLocationId);
/* 222 */     dao.setBusinessDate(this._businessDate);
/* 223 */     dao.setWorkstationId(this._workstationId);
/* 224 */     dao.setTransactionSequence(this._transactionSequence);
/* 225 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 226 */     dao.setCreateDate(this._createDate);
/* 227 */     dao.setCreateUserId(this._createUserId);
/* 228 */     dao.setUpdateDate(this._updateDate);
/* 229 */     dao.setUpdateUserId(this._updateUserId);
/* 230 */     dao.setCustAccountId(this._custAccountId);
/* 231 */     dao.setCustAccountCode(this._custAccountCode);
/* 232 */     argDAO.suppressStateChanges(false);
/* 233 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 238 */     return loadDAO((IDataAccessObject)new AccountCreditTenderLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 243 */     AccountCreditTenderLineItemDAO dao = (AccountCreditTenderLineItemDAO)argDAO;
/* 244 */     super.fill((IDataAccessObject)dao);
/* 245 */     this._organizationId = dao.getOrganizationId();
/* 246 */     this._retailLocationId = dao.getRetailLocationId();
/* 247 */     this._businessDate = dao.getBusinessDate();
/* 248 */     this._workstationId = dao.getWorkstationId();
/* 249 */     this._transactionSequence = dao.getTransactionSequence();
/* 250 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 251 */     this._createDate = dao.getCreateDate();
/* 252 */     this._createUserId = dao.getCreateUserId();
/* 253 */     this._updateDate = dao.getUpdateDate();
/* 254 */     this._updateUserId = dao.getUpdateUserId();
/* 255 */     this._custAccountId = dao.getCustAccountId();
/* 256 */     this._custAccountCode = dao.getCustAccountCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 261 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 262 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 263 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 264 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 265 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 266 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 267 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 268 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 272 */     String[] sels = super.getAllSelects();
/* 273 */     String[] result = new String[sels.length + 1];
/* 274 */     result[0] = getSelectImpl();
/* 275 */     System.arraycopy(sels, 0, result, 1, sels.length);
/* 276 */     return result;
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 280 */     IFiller[] fills = super.getAllFillers();
/* 281 */     IFiller[] result = new IFiller[fills.length + 1];
/* 282 */     result[0] = getFillerImpl();
/* 283 */     System.arraycopy(fills, 0, result, 1, fills.length);
/* 284 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\AccountCreditTenderLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */