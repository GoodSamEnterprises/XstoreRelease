/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerAccountAuthorizationId;
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
/*     */ 
/*     */ public class CustomerAccountAuthorizationDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1099471766L;
/*     */   private Long _organizationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Date _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _statusCode;
/*     */   private Date _statusDatetime;
/*     */   private String _authorizationType;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtrans_lineitm_seq, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.status_code, t.status_datetime, t.authorization_type FROM cat_authorizations t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtrans_lineitm_seq = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.rtrans_lineitm_seq, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.status_code, t.status_datetime, t.authorization_type FROM cat_authorizations t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND rtrans_lineitm_seq = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_authorizations(organization_id, rtrans_lineitm_seq, rtl_loc_id, wkstn_id, business_date, trans_seq, create_date, create_user_id, update_date, update_user_id, status_code, status_datetime, authorization_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._retailTransactionLineItemSequence, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._statusCode, this._statusDatetime, this._authorizationType } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 4, -5, -5, 91, -5, 91, 12, 91, 12, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_authorizations SET update_date = ?, update_user_id = ?, status_code = ?, status_datetime = ?, authorization_type = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._statusCode, this._statusDatetime, this._authorizationType } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_authorizations" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtrans_lineitm_seq = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND rtrans_lineitm_seq = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._retailTransactionLineItemSequence, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 4, -5, -5, 91, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "cat_authorizations";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new CustomerAccountAuthorizationFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerAccountAuthorizationFiller
/*     */     implements IFiller {
/*     */     private CustomerAccountAuthorizationDBA _parent;
/*     */     
/*     */     public CustomerAccountAuthorizationFiller(CustomerAccountAuthorizationDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       long l1 = argResultSet.getLong(1);
/* 131 */       if (l1 != 0L || argResultSet.getObject(1) != null) {
/* 132 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 138 */       int i = argResultSet.getInt(2);
/* 139 */       if (i != 0 || argResultSet.getObject(2) != null) {
/* 140 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 146 */       long primitiveResult = argResultSet.getLong(3);
/* 147 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 148 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 154 */       primitiveResult = argResultSet.getLong(4);
/* 155 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 156 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 161 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 162 */       if (t5 != null) {
/* 163 */         this._parent._businessDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 166 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 171 */       long l2 = argResultSet.getLong(6);
/* 172 */       if (l2 != 0L || argResultSet.getObject(6) != null) {
/* 173 */         this._parent._transactionSequence = Long.valueOf(l2);
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
/* 197 */       this._parent._statusCode = argResultSet.getString(11);
/*     */       
/* 199 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 200 */       if (t12 != null) {
/* 201 */         this._parent._statusDatetime = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 204 */         this._parent._statusDatetime = null;
/*     */       } 
/*     */       
/* 207 */       this._parent._authorizationType = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 212 */     argDAO.suppressStateChanges(true);
/* 213 */     CustomerAccountAuthorizationDAO dao = (CustomerAccountAuthorizationDAO)argDAO;
/* 214 */     dao.setOrganizationId(this._organizationId);
/* 215 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 216 */     dao.setRetailLocationId(this._retailLocationId);
/* 217 */     dao.setWorkstationId(this._workstationId);
/* 218 */     dao.setBusinessDate(this._businessDate);
/* 219 */     dao.setTransactionSequence(this._transactionSequence);
/* 220 */     dao.setCreateDate(this._createDate);
/* 221 */     dao.setCreateUserId(this._createUserId);
/* 222 */     dao.setUpdateDate(this._updateDate);
/* 223 */     dao.setUpdateUserId(this._updateUserId);
/* 224 */     dao.setStatusCode(this._statusCode);
/* 225 */     dao.setStatusDatetime(this._statusDatetime);
/* 226 */     dao.setAuthorizationType(this._authorizationType);
/* 227 */     argDAO.suppressStateChanges(false);
/* 228 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 232 */     return loadDAO((IDataAccessObject)new CustomerAccountAuthorizationDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 236 */     CustomerAccountAuthorizationDAO dao = (CustomerAccountAuthorizationDAO)argDAO;
/* 237 */     this._organizationId = dao.getOrganizationId();
/* 238 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 239 */     this._retailLocationId = dao.getRetailLocationId();
/* 240 */     this._workstationId = dao.getWorkstationId();
/* 241 */     this._businessDate = dao.getBusinessDate();
/* 242 */     this._transactionSequence = dao.getTransactionSequence();
/* 243 */     this._createDate = dao.getCreateDate();
/* 244 */     this._createUserId = dao.getCreateUserId();
/* 245 */     this._updateDate = dao.getUpdateDate();
/* 246 */     this._updateUserId = dao.getUpdateUserId();
/* 247 */     this._statusCode = dao.getStatusCode();
/* 248 */     this._statusDatetime = dao.getStatusDatetime();
/* 249 */     this._authorizationType = dao.getAuthorizationType();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 253 */     CustomerAccountAuthorizationId id = (CustomerAccountAuthorizationId)argId;
/* 254 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 255 */     argStatement.setInt(2, id.getRetailTransactionLineItemSequence().intValue());
/* 256 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 257 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 258 */     argStatement.setTimestamp(5, new Timestamp(id.getBusinessDate().getTime()));
/* 259 */     argStatement.setLong(6, id.getTransactionSequence().longValue());
/* 260 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 264 */     CustomerAccountAuthorizationId id = new CustomerAccountAuthorizationId();
/* 265 */     id.setOrganizationId(this._organizationId);
/* 266 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 267 */     id.setRetailLocationId(this._retailLocationId);
/* 268 */     id.setWorkstationId(this._workstationId);
/* 269 */     id.setBusinessDate(this._businessDate);
/* 270 */     id.setTransactionSequence(this._transactionSequence);
/* 271 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 279 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 283 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountAuthorizationDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */