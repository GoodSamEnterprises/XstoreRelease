/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cwo.InvoiceLineItemId;
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
/*     */ public class InvoiceLineItemDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1194092372L;
/*     */   private Long _organizationId;
/*     */   private String _serviceLocationId;
/*     */   private String _invoiceNumber;
/*     */   private Integer _invoiceLineItemSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _lineItemTypeCode;
/*     */   private BigDecimal _amount;
/*     */   private String _glAccount;
/*     */   private String _custAccountId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.service_loc_id, t.invoice_number, t.invoice_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.lineitm_typcode, t.amt, t.gl_account, t.cust_acct_id FROM cwo_invoice_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND service_loc_id = ?  AND invoice_number = ?  AND invoice_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.service_loc_id, t.invoice_number, t.invoice_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.lineitm_typcode, t.amt, t.gl_account, t.cust_acct_id FROM cwo_invoice_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND service_loc_id = ?  AND invoice_number = ?  AND invoice_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cwo_invoice_lineitm(organization_id, service_loc_id, invoice_number, invoice_lineitm_seq, create_date, create_user_id, update_date, update_user_id, lineitm_typcode, amt, gl_account, cust_acct_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._serviceLocationId, this._invoiceNumber, this._invoiceLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._lineItemTypeCode, this._amount, this._glAccount, this._custAccountId } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 4, 91, 12, 91, 12, 12, 3, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cwo_invoice_lineitm SET update_date = ?, update_user_id = ?, lineitm_typcode = ?, amt = ?, gl_account = ?, cust_acct_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._lineItemTypeCode, this._amount, this._glAccount, this._custAccountId } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 3, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cwo_invoice_lineitm" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND service_loc_id = ?  AND invoice_number = ?  AND invoice_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND service_loc_id = ?  AND invoice_number = ?  AND invoice_lineitm_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._serviceLocationId, this._invoiceNumber, this._invoiceLineItemSequence };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "cwo_invoice_lineitm";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new InvoiceLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class InvoiceLineItemFiller
/*     */     implements IFiller {
/*     */     private InvoiceLineItemDBA _parent;
/*     */     
/*     */     public InvoiceLineItemFiller(InvoiceLineItemDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       long l = argResultSet.getLong(1);
/* 130 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 135 */       this._parent._serviceLocationId = argResultSet.getString(2);
/* 136 */       this._parent._invoiceNumber = argResultSet.getString(3);
/*     */ 
/*     */       
/* 139 */       int primitiveResult = argResultSet.getInt(4);
/* 140 */       if (primitiveResult != 0 || argResultSet.getObject(4) != null) {
/* 141 */         this._parent._invoiceLineItemSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 146 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 147 */       if (t5 != null) {
/* 148 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 154 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 156 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 157 */       if (t7 != null) {
/* 158 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 161 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 164 */       this._parent._updateUserId = argResultSet.getString(8);
/* 165 */       this._parent._lineItemTypeCode = argResultSet.getString(9);
/* 166 */       this._parent._amount = argResultSet.getBigDecimal(10);
/* 167 */       this._parent._glAccount = argResultSet.getString(11);
/* 168 */       this._parent._custAccountId = argResultSet.getString(12);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 173 */     argDAO.suppressStateChanges(true);
/* 174 */     InvoiceLineItemDAO dao = (InvoiceLineItemDAO)argDAO;
/* 175 */     dao.setOrganizationId(this._organizationId);
/* 176 */     dao.setServiceLocationId(this._serviceLocationId);
/* 177 */     dao.setInvoiceNumber(this._invoiceNumber);
/* 178 */     dao.setInvoiceLineItemSequence(this._invoiceLineItemSequence);
/* 179 */     dao.setCreateDate(this._createDate);
/* 180 */     dao.setCreateUserId(this._createUserId);
/* 181 */     dao.setUpdateDate(this._updateDate);
/* 182 */     dao.setUpdateUserId(this._updateUserId);
/* 183 */     dao.setLineItemTypeCode(this._lineItemTypeCode);
/* 184 */     dao.setAmount(this._amount);
/* 185 */     dao.setGlAccount(this._glAccount);
/* 186 */     dao.setCustAccountId(this._custAccountId);
/* 187 */     argDAO.suppressStateChanges(false);
/* 188 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 192 */     return loadDAO((IDataAccessObject)new InvoiceLineItemDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 196 */     InvoiceLineItemDAO dao = (InvoiceLineItemDAO)argDAO;
/* 197 */     this._organizationId = dao.getOrganizationId();
/* 198 */     this._serviceLocationId = dao.getServiceLocationId();
/* 199 */     this._invoiceNumber = dao.getInvoiceNumber();
/* 200 */     this._invoiceLineItemSequence = dao.getInvoiceLineItemSequence();
/* 201 */     this._createDate = dao.getCreateDate();
/* 202 */     this._createUserId = dao.getCreateUserId();
/* 203 */     this._updateDate = dao.getUpdateDate();
/* 204 */     this._updateUserId = dao.getUpdateUserId();
/* 205 */     this._lineItemTypeCode = dao.getLineItemTypeCode();
/* 206 */     this._amount = dao.getAmount();
/* 207 */     this._glAccount = dao.getGlAccount();
/* 208 */     this._custAccountId = dao.getCustAccountId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 212 */     InvoiceLineItemId id = (InvoiceLineItemId)argId;
/* 213 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 214 */     argStatement.setString(2, id.getServiceLocationId());
/* 215 */     argStatement.setString(3, id.getInvoiceNumber());
/* 216 */     argStatement.setInt(4, id.getInvoiceLineItemSequence().intValue());
/* 217 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 221 */     InvoiceLineItemId id = new InvoiceLineItemId();
/* 222 */     id.setOrganizationId(this._organizationId);
/* 223 */     id.setServiceLocationId(this._serviceLocationId);
/* 224 */     id.setInvoiceNumber(this._invoiceNumber);
/* 225 */     id.setInvoiceLineItemSequence(this._invoiceLineItemSequence);
/* 226 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 234 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 238 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\InvoiceLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */