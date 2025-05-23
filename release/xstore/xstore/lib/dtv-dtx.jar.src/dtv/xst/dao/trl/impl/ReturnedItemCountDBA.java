/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.ReturnedItemCountId;
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
/*     */ public class ReturnedItemCountDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1822266509L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Date _businessDate;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _returnedCount;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.rtrans_lineitm_seq, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.returned_count FROM trl_returned_item_count t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.rtrans_lineitm_seq, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.returned_count FROM trl_returned_item_count t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_returned_item_count(organization_id, rtl_loc_id, wkstn_id, business_date, rtrans_lineitm_seq, trans_seq, create_date, create_user_id, update_date, update_user_id, returned_count) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._retailTransactionLineItemSequence, this._transactionSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._returnedCount } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 91, 4, -5, 91, 12, 91, 12, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_returned_item_count SET update_date = ?, update_user_id = ?, returned_count = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._returnedCount } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_returned_item_count" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._retailTransactionLineItemSequence, this._transactionSequence };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 91, 4, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "trl_returned_item_count";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new ReturnedItemCountFiller(this);
/*     */   }
/*     */   
/*     */   private static class ReturnedItemCountFiller
/*     */     implements IFiller {
/*     */     private ReturnedItemCountDBA _parent;
/*     */     
/*     */     public ReturnedItemCountFiller(ReturnedItemCountDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       long primitiveResult = argResultSet.getLong(1);
/* 129 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 130 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 136 */       primitiveResult = argResultSet.getLong(2);
/* 137 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 138 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 144 */       primitiveResult = argResultSet.getLong(3);
/* 145 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 146 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 151 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 152 */       if (t4 != null) {
/* 153 */         this._parent._businessDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 161 */       int i = argResultSet.getInt(5);
/* 162 */       if (i != 0 || argResultSet.getObject(5) != null) {
/* 163 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 169 */       long l1 = argResultSet.getLong(6);
/* 170 */       if (l1 != 0L || argResultSet.getObject(6) != null) {
/* 171 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 176 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 177 */       if (t7 != null) {
/* 178 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 184 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 186 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 187 */       if (t9 != null) {
/* 188 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 191 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 194 */       this._parent._updateUserId = argResultSet.getString(10);
/* 195 */       this._parent._returnedCount = argResultSet.getBigDecimal(11);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 200 */     argDAO.suppressStateChanges(true);
/* 201 */     ReturnedItemCountDAO dao = (ReturnedItemCountDAO)argDAO;
/* 202 */     dao.setOrganizationId(this._organizationId);
/* 203 */     dao.setRetailLocationId(this._retailLocationId);
/* 204 */     dao.setWorkstationId(this._workstationId);
/* 205 */     dao.setBusinessDate(this._businessDate);
/* 206 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 207 */     dao.setTransactionSequence(this._transactionSequence);
/* 208 */     dao.setCreateDate(this._createDate);
/* 209 */     dao.setCreateUserId(this._createUserId);
/* 210 */     dao.setUpdateDate(this._updateDate);
/* 211 */     dao.setUpdateUserId(this._updateUserId);
/* 212 */     dao.setReturnedCount(this._returnedCount);
/* 213 */     argDAO.suppressStateChanges(false);
/* 214 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 218 */     return loadDAO((IDataAccessObject)new ReturnedItemCountDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 222 */     ReturnedItemCountDAO dao = (ReturnedItemCountDAO)argDAO;
/* 223 */     this._organizationId = dao.getOrganizationId();
/* 224 */     this._retailLocationId = dao.getRetailLocationId();
/* 225 */     this._workstationId = dao.getWorkstationId();
/* 226 */     this._businessDate = dao.getBusinessDate();
/* 227 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 228 */     this._transactionSequence = dao.getTransactionSequence();
/* 229 */     this._createDate = dao.getCreateDate();
/* 230 */     this._createUserId = dao.getCreateUserId();
/* 231 */     this._updateDate = dao.getUpdateDate();
/* 232 */     this._updateUserId = dao.getUpdateUserId();
/* 233 */     this._returnedCount = dao.getReturnedCount();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 237 */     ReturnedItemCountId id = (ReturnedItemCountId)argId;
/* 238 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 239 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 240 */     argStatement.setLong(3, id.getWorkstationId().longValue());
/* 241 */     argStatement.setTimestamp(4, new Timestamp(id.getBusinessDate().getTime()));
/* 242 */     argStatement.setInt(5, id.getRetailTransactionLineItemSequence().intValue());
/* 243 */     argStatement.setLong(6, id.getTransactionSequence().longValue());
/* 244 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 248 */     ReturnedItemCountId id = new ReturnedItemCountId();
/* 249 */     id.setOrganizationId(this._organizationId);
/* 250 */     id.setRetailLocationId(this._retailLocationId);
/* 251 */     id.setWorkstationId(this._workstationId);
/* 252 */     id.setBusinessDate(this._businessDate);
/* 253 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 254 */     id.setTransactionSequence(this._transactionSequence);
/* 255 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 263 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 267 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\ReturnedItemCountDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */