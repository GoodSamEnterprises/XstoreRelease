/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.ChargeAccountInvoiceId;
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
/*     */ public class ChargeAccountInvoiceDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 749161524L;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private String _invoiceNumber;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _originalInvoiceBalance;
/*     */   private BigDecimal _invoiceBalance;
/*     */   private Date _lastActivityDate;
/*     */   private Date _invoiceDate;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.invoice_number, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.original_invoice_balance, t.invoice_balance, t.last_activity_date, t.invoice_date FROM cat_charge_acct_invoice t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND invoice_number = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.invoice_number, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.original_invoice_balance, t.invoice_balance, t.last_activity_date, t.invoice_date FROM cat_charge_acct_invoice t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND invoice_number = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_charge_acct_invoice(organization_id, cust_acct_id, cust_acct_code, invoice_number, create_date, create_user_id, update_date, update_user_id, original_invoice_balance, invoice_balance, last_activity_date, invoice_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._custAccountId, this._custAccountCode, this._invoiceNumber, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._originalInvoiceBalance, this._invoiceBalance, this._lastActivityDate, this._invoiceDate } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 12, 91, 12, 3, 3, 91, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_charge_acct_invoice SET update_date = ?, update_user_id = ?, original_invoice_balance = ?, invoice_balance = ?, last_activity_date = ?, invoice_date = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._originalInvoiceBalance, this._invoiceBalance, this._lastActivityDate, this._invoiceDate } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 3, 91, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_charge_acct_invoice" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND invoice_number = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND invoice_number = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._custAccountId, this._custAccountCode, this._invoiceNumber };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "cat_charge_acct_invoice";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new ChargeAccountInvoiceFiller(this);
/*     */   }
/*     */   
/*     */   private static class ChargeAccountInvoiceFiller
/*     */     implements IFiller {
/*     */     private ChargeAccountInvoiceDBA _parent;
/*     */     
/*     */     public ChargeAccountInvoiceFiller(ChargeAccountInvoiceDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       long primitiveResult = argResultSet.getLong(1);
/* 130 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 135 */       this._parent._custAccountId = argResultSet.getString(2);
/* 136 */       this._parent._custAccountCode = argResultSet.getString(3);
/* 137 */       this._parent._invoiceNumber = argResultSet.getString(4);
/*     */       
/* 139 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 140 */       if (t5 != null) {
/* 141 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 147 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 149 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 150 */       if (t7 != null) {
/* 151 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._updateUserId = argResultSet.getString(8);
/* 158 */       this._parent._originalInvoiceBalance = argResultSet.getBigDecimal(9);
/* 159 */       this._parent._invoiceBalance = argResultSet.getBigDecimal(10);
/*     */       
/* 161 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 162 */       if (t11 != null) {
/* 163 */         this._parent._lastActivityDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 166 */         this._parent._lastActivityDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 170 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 171 */       if (t12 != null) {
/* 172 */         this._parent._invoiceDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 175 */         this._parent._invoiceDate = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 182 */     argDAO.suppressStateChanges(true);
/* 183 */     ChargeAccountInvoiceDAO dao = (ChargeAccountInvoiceDAO)argDAO;
/* 184 */     dao.setOrganizationId(this._organizationId);
/* 185 */     dao.setCustAccountId(this._custAccountId);
/* 186 */     dao.setCustAccountCode(this._custAccountCode);
/* 187 */     dao.setInvoiceNumber(this._invoiceNumber);
/* 188 */     dao.setCreateDate(this._createDate);
/* 189 */     dao.setCreateUserId(this._createUserId);
/* 190 */     dao.setUpdateDate(this._updateDate);
/* 191 */     dao.setUpdateUserId(this._updateUserId);
/* 192 */     dao.setOriginalInvoiceBalance(this._originalInvoiceBalance);
/* 193 */     dao.setInvoiceBalance(this._invoiceBalance);
/* 194 */     dao.setLastActivityDate(this._lastActivityDate);
/* 195 */     dao.setInvoiceDate(this._invoiceDate);
/* 196 */     argDAO.suppressStateChanges(false);
/* 197 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 201 */     return loadDAO((IDataAccessObject)new ChargeAccountInvoiceDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 205 */     ChargeAccountInvoiceDAO dao = (ChargeAccountInvoiceDAO)argDAO;
/* 206 */     this._organizationId = dao.getOrganizationId();
/* 207 */     this._custAccountId = dao.getCustAccountId();
/* 208 */     this._custAccountCode = dao.getCustAccountCode();
/* 209 */     this._invoiceNumber = dao.getInvoiceNumber();
/* 210 */     this._createDate = dao.getCreateDate();
/* 211 */     this._createUserId = dao.getCreateUserId();
/* 212 */     this._updateDate = dao.getUpdateDate();
/* 213 */     this._updateUserId = dao.getUpdateUserId();
/* 214 */     this._originalInvoiceBalance = dao.getOriginalInvoiceBalance();
/* 215 */     this._invoiceBalance = dao.getInvoiceBalance();
/* 216 */     this._lastActivityDate = dao.getLastActivityDate();
/* 217 */     this._invoiceDate = dao.getInvoiceDate();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 221 */     ChargeAccountInvoiceId id = (ChargeAccountInvoiceId)argId;
/* 222 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 223 */     argStatement.setString(2, id.getCustAccountId());
/* 224 */     argStatement.setString(3, id.getCustAccountCode());
/* 225 */     argStatement.setString(4, id.getInvoiceNumber());
/* 226 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 230 */     ChargeAccountInvoiceId id = new ChargeAccountInvoiceId();
/* 231 */     id.setOrganizationId(this._organizationId);
/* 232 */     id.setCustAccountId(this._custAccountId);
/* 233 */     id.setCustAccountCode(this._custAccountCode);
/* 234 */     id.setInvoiceNumber(this._invoiceNumber);
/* 235 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 243 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 247 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\ChargeAccountInvoiceDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */