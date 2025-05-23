/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.CustomerItemAccountModifierId;
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
/*     */ public class CustomerItemAccountModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1611431859L;
/*     */   private Date _businessDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private BigDecimal _itemAccountExtendedPrice;
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.cust_acct_id, t.cust_acct_code, t.item_acct_extended_price FROM trl_cust_item_acct_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.cust_acct_id, t.cust_acct_code, t.item_acct_extended_price FROM trl_cust_item_acct_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_cust_item_acct_mod(business_date, organization_id, rtl_loc_id, rtrans_lineitm_seq, trans_seq, wkstn_id, create_date, create_user_id, update_date, update_user_id, cust_acct_id, cust_acct_code, item_acct_extended_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._businessDate, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._custAccountId, this._custAccountCode, this._itemAccountExtendedPrice } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, -5, -5, 4, -5, -5, 91, 12, 91, 12, 12, 12, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_cust_item_acct_mod SET update_date = ?, update_user_id = ?, cust_acct_id = ?, cust_acct_code = ?, item_acct_extended_price = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._custAccountId, this._custAccountCode, this._itemAccountExtendedPrice } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_cust_item_acct_mod" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._businessDate, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, -5, -5, 4, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "trl_cust_item_acct_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new CustomerItemAccountModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerItemAccountModifierFiller
/*     */     implements IFiller {
/*     */     private CustomerItemAccountModifierDBA _parent;
/*     */     
/*     */     public CustomerItemAccountModifierFiller(CustomerItemAccountModifierDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 130 */       if (t1 != null) {
/* 131 */         this._parent._businessDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 134 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 139 */       long l1 = argResultSet.getLong(2);
/* 140 */       if (l1 != 0L || argResultSet.getObject(2) != null) {
/* 141 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 147 */       l1 = argResultSet.getLong(3);
/* 148 */       if (l1 != 0L || argResultSet.getObject(3) != null) {
/* 149 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 155 */       int i = argResultSet.getInt(4);
/* 156 */       if (i != 0 || argResultSet.getObject(4) != null) {
/* 157 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 163 */       long primitiveResult = argResultSet.getLong(5);
/* 164 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 165 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 171 */       primitiveResult = argResultSet.getLong(6);
/* 172 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 173 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 178 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 179 */       if (t7 != null) {
/* 180 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 183 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 186 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 188 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 189 */       if (t9 != null) {
/* 190 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 193 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 196 */       this._parent._updateUserId = argResultSet.getString(10);
/* 197 */       this._parent._custAccountId = argResultSet.getString(11);
/* 198 */       this._parent._custAccountCode = argResultSet.getString(12);
/* 199 */       this._parent._itemAccountExtendedPrice = argResultSet.getBigDecimal(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 204 */     argDAO.suppressStateChanges(true);
/* 205 */     CustomerItemAccountModifierDAO dao = (CustomerItemAccountModifierDAO)argDAO;
/* 206 */     dao.setBusinessDate(this._businessDate);
/* 207 */     dao.setOrganizationId(this._organizationId);
/* 208 */     dao.setRetailLocationId(this._retailLocationId);
/* 209 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 210 */     dao.setTransactionSequence(this._transactionSequence);
/* 211 */     dao.setWorkstationId(this._workstationId);
/* 212 */     dao.setCreateDate(this._createDate);
/* 213 */     dao.setCreateUserId(this._createUserId);
/* 214 */     dao.setUpdateDate(this._updateDate);
/* 215 */     dao.setUpdateUserId(this._updateUserId);
/* 216 */     dao.setCustAccountId(this._custAccountId);
/* 217 */     dao.setCustAccountCode(this._custAccountCode);
/* 218 */     dao.setItemAccountExtendedPrice(this._itemAccountExtendedPrice);
/* 219 */     argDAO.suppressStateChanges(false);
/* 220 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 224 */     return loadDAO((IDataAccessObject)new CustomerItemAccountModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 228 */     CustomerItemAccountModifierDAO dao = (CustomerItemAccountModifierDAO)argDAO;
/* 229 */     this._businessDate = dao.getBusinessDate();
/* 230 */     this._organizationId = dao.getOrganizationId();
/* 231 */     this._retailLocationId = dao.getRetailLocationId();
/* 232 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 233 */     this._transactionSequence = dao.getTransactionSequence();
/* 234 */     this._workstationId = dao.getWorkstationId();
/* 235 */     this._createDate = dao.getCreateDate();
/* 236 */     this._createUserId = dao.getCreateUserId();
/* 237 */     this._updateDate = dao.getUpdateDate();
/* 238 */     this._updateUserId = dao.getUpdateUserId();
/* 239 */     this._custAccountId = dao.getCustAccountId();
/* 240 */     this._custAccountCode = dao.getCustAccountCode();
/* 241 */     this._itemAccountExtendedPrice = dao.getItemAccountExtendedPrice();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 245 */     CustomerItemAccountModifierId id = (CustomerItemAccountModifierId)argId;
/* 246 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDate().getTime()));
/* 247 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 248 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 249 */     argStatement.setInt(4, id.getRetailTransactionLineItemSequence().intValue());
/* 250 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 251 */     argStatement.setLong(6, id.getWorkstationId().longValue());
/* 252 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 256 */     CustomerItemAccountModifierId id = new CustomerItemAccountModifierId();
/* 257 */     id.setBusinessDate(this._businessDate);
/* 258 */     id.setOrganizationId(this._organizationId);
/* 259 */     id.setRetailLocationId(this._retailLocationId);
/* 260 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 261 */     id.setTransactionSequence(this._transactionSequence);
/* 262 */     id.setWorkstationId(this._workstationId);
/* 263 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 271 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 275 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\CustomerItemAccountModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */