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
/*     */ public class CheckTenderLineItemDBA
/*     */   extends TenderLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1404906717L;
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
/*     */   private String _adjudicationCode;
/*     */   private String _authorizationCode;
/*     */   private String _authorizationMethodCode;
/*     */   private String _bankId;
/*     */   private String _checkAccountNumber;
/*     */   private String _checkSequenceNumber;
/*     */   private Date _customerBirthDate;
/*     */   private String _entryMethodCode;
/*     */   private String _micrData;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.adjudication_code, t.auth_nbr, t.auth_mthd_code, t.bank_id, t.check_acct_nbr, t.check_seq_nbr, t.cust_birth_date, t.entry_mthd_code, t.micr FROM ttr_check_tndr_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  49 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  53 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.adjudication_code, t.auth_nbr, t.auth_mthd_code, t.bank_id, t.check_acct_nbr, t.check_seq_nbr, t.cust_birth_date, t.entry_mthd_code, t.micr FROM ttr_check_tndr_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  60 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  63 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ttr_check_tndr_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, adjudication_code, auth_nbr, auth_mthd_code, bank_id, check_acct_nbr, check_seq_nbr, cust_birth_date, entry_mthd_code, micr) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  67 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  72 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._adjudicationCode, this._authorizationCode, this._authorizationMethodCode, this._bankId, this._checkAccountNumber, this._checkSequenceNumber, this._customerBirthDate, this._entryMethodCode, this._micrData } };
/*  73 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  76 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 91, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  80 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  83 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ttr_check_tndr_lineitm SET update_date = ?, update_user_id = ?, adjudication_code = ?, auth_nbr = ?, auth_mthd_code = ?, bank_id = ?, check_acct_nbr = ?, check_seq_nbr = ?, cust_birth_date = ?, entry_mthd_code = ?, micr = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  87 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  92 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._adjudicationCode, this._authorizationCode, this._authorizationMethodCode, this._bankId, this._checkAccountNumber, this._checkSequenceNumber, this._customerBirthDate, this._entryMethodCode, this._micrData } };
/*  93 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  96 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  99 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/* 102 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ttr_check_tndr_lineitm" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 106 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 113 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 117 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 120 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 124 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 128 */     return "ttr_check_tndr_lineitm";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 133 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 137 */     return new CheckTenderLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class CheckTenderLineItemFiller
/*     */     implements IFiller {
/*     */     private CheckTenderLineItemDBA _parent;
/*     */     
/*     */     public CheckTenderLineItemFiller(CheckTenderLineItemDBA argParent) {
/* 145 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 150 */       long primitiveResult = argResultSet.getLong(1);
/* 151 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 152 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 158 */       primitiveResult = argResultSet.getLong(2);
/* 159 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 160 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 165 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 166 */       if (t3 != null) {
/* 167 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 175 */       long l1 = argResultSet.getLong(4);
/* 176 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 177 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 183 */       l1 = argResultSet.getLong(5);
/* 184 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 185 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 191 */       int i = argResultSet.getInt(6);
/* 192 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 193 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 198 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 199 */       if (t7 != null) {
/* 200 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 203 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 206 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 208 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 209 */       if (t9 != null) {
/* 210 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 213 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 216 */       this._parent._updateUserId = argResultSet.getString(10);
/* 217 */       this._parent._adjudicationCode = argResultSet.getString(11);
/* 218 */       this._parent._authorizationCode = argResultSet.getString(12);
/* 219 */       this._parent._authorizationMethodCode = argResultSet.getString(13);
/* 220 */       this._parent._bankId = argResultSet.getString(14);
/* 221 */       this._parent._checkAccountNumber = argResultSet.getString(15);
/* 222 */       this._parent._checkSequenceNumber = argResultSet.getString(16);
/*     */       
/* 224 */       Timestamp t17 = argResultSet.getTimestamp(17);
/* 225 */       if (t17 != null) {
/* 226 */         this._parent._customerBirthDate = (Date)new DtvDate(t17.getTime());
/*     */       } else {
/*     */         
/* 229 */         this._parent._customerBirthDate = null;
/*     */       } 
/*     */       
/* 232 */       this._parent._entryMethodCode = argResultSet.getString(18);
/* 233 */       this._parent._micrData = argResultSet.getString(19);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 239 */     super.loadDAO(argDAO);
/* 240 */     argDAO.suppressStateChanges(true);
/* 241 */     CheckTenderLineItemDAO dao = (CheckTenderLineItemDAO)argDAO;
/* 242 */     dao.setOrganizationId(this._organizationId);
/* 243 */     dao.setRetailLocationId(this._retailLocationId);
/* 244 */     dao.setBusinessDate(this._businessDate);
/* 245 */     dao.setWorkstationId(this._workstationId);
/* 246 */     dao.setTransactionSequence(this._transactionSequence);
/* 247 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 248 */     dao.setCreateDate(this._createDate);
/* 249 */     dao.setCreateUserId(this._createUserId);
/* 250 */     dao.setUpdateDate(this._updateDate);
/* 251 */     dao.setUpdateUserId(this._updateUserId);
/* 252 */     dao.setAdjudicationCode(this._adjudicationCode);
/* 253 */     dao.setAuthorizationCode(this._authorizationCode);
/* 254 */     dao.setAuthorizationMethodCode(this._authorizationMethodCode);
/* 255 */     dao.setBankId(this._bankId);
/* 256 */     dao.setCheckAccountNumber(this._checkAccountNumber);
/* 257 */     dao.setCheckSequenceNumber(this._checkSequenceNumber);
/* 258 */     dao.setCustomerBirthDate(this._customerBirthDate);
/* 259 */     dao.setEntryMethodCode(this._entryMethodCode);
/* 260 */     dao.setMicrData(this._micrData);
/* 261 */     argDAO.suppressStateChanges(false);
/* 262 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 267 */     return loadDAO((IDataAccessObject)new CheckTenderLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 272 */     CheckTenderLineItemDAO dao = (CheckTenderLineItemDAO)argDAO;
/* 273 */     super.fill((IDataAccessObject)dao);
/* 274 */     this._organizationId = dao.getOrganizationId();
/* 275 */     this._retailLocationId = dao.getRetailLocationId();
/* 276 */     this._businessDate = dao.getBusinessDate();
/* 277 */     this._workstationId = dao.getWorkstationId();
/* 278 */     this._transactionSequence = dao.getTransactionSequence();
/* 279 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 280 */     this._createDate = dao.getCreateDate();
/* 281 */     this._createUserId = dao.getCreateUserId();
/* 282 */     this._updateDate = dao.getUpdateDate();
/* 283 */     this._updateUserId = dao.getUpdateUserId();
/* 284 */     this._adjudicationCode = dao.getAdjudicationCode();
/* 285 */     this._authorizationCode = dao.getAuthorizationCode();
/* 286 */     this._authorizationMethodCode = dao.getAuthorizationMethodCode();
/* 287 */     this._bankId = dao.getBankId();
/* 288 */     this._checkAccountNumber = dao.getCheckAccountNumber();
/* 289 */     this._checkSequenceNumber = dao.getCheckSequenceNumber();
/* 290 */     this._customerBirthDate = dao.getCustomerBirthDate();
/* 291 */     this._entryMethodCode = dao.getEntryMethodCode();
/* 292 */     this._micrData = dao.getMicrData();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 297 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 298 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 299 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 300 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 301 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 302 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 303 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 304 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 308 */     String[] sels = super.getAllSelects();
/* 309 */     String[] result = new String[sels.length + 1];
/* 310 */     result[0] = getSelectImpl();
/* 311 */     System.arraycopy(sels, 0, result, 1, sels.length);
/* 312 */     return result;
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 316 */     IFiller[] fills = super.getAllFillers();
/* 317 */     IFiller[] result = new IFiller[fills.length + 1];
/* 318 */     result[0] = getFillerImpl();
/* 319 */     System.arraycopy(fills, 0, result, 1, fills.length);
/* 320 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\CheckTenderLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */