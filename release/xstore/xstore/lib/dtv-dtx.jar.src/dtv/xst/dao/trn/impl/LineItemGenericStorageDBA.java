/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.LineItemGenericStorageId;
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
/*     */ public class LineItemGenericStorageDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 608488907L;
/*     */   private Date _businessDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _lineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _dataStorage;
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.data_storage FROM trn_generic_lineitm_storage t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.data_storage FROM trn_generic_lineitm_storage t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trn_generic_lineitm_storage(business_date, organization_id, rtl_loc_id, rtrans_lineitm_seq, trans_seq, wkstn_id, create_date, create_user_id, update_date, update_user_id, data_storage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._businessDate, this._organizationId, this._retailLocationId, this._lineItemSequence, this._transactionSequence, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._dataStorage } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, -5, -5, 4, -5, -5, 91, 12, 91, 12, 2005 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trn_generic_lineitm_storage SET update_date = ?, update_user_id = ?, data_storage = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._dataStorage } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 2005 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trn_generic_lineitm_storage" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._businessDate, this._organizationId, this._retailLocationId, this._lineItemSequence, this._transactionSequence, this._workstationId };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, -5, -5, 4, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "trn_generic_lineitm_storage";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new LineItemGenericStorageFiller(this);
/*     */   }
/*     */   
/*     */   private static class LineItemGenericStorageFiller
/*     */     implements IFiller {
/*     */     private LineItemGenericStorageDBA _parent;
/*     */     
/*     */     public LineItemGenericStorageFiller(LineItemGenericStorageDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 127 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 128 */       if (t1 != null) {
/* 129 */         this._parent._businessDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 132 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 137 */       long l1 = argResultSet.getLong(2);
/* 138 */       if (l1 != 0L || argResultSet.getObject(2) != null) {
/* 139 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 145 */       l1 = argResultSet.getLong(3);
/* 146 */       if (l1 != 0L || argResultSet.getObject(3) != null) {
/* 147 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 153 */       int i = argResultSet.getInt(4);
/* 154 */       if (i != 0 || argResultSet.getObject(4) != null) {
/* 155 */         this._parent._lineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 161 */       long primitiveResult = argResultSet.getLong(5);
/* 162 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 163 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 169 */       primitiveResult = argResultSet.getLong(6);
/* 170 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 171 */         this._parent._workstationId = Long.valueOf(primitiveResult);
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
/*     */ 
/*     */       
/* 197 */       this._parent._dataStorage = JDBCHelper.clobToString(argResultSet, 11);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 203 */     argDAO.suppressStateChanges(true);
/* 204 */     LineItemGenericStorageDAO dao = (LineItemGenericStorageDAO)argDAO;
/* 205 */     dao.setBusinessDate(this._businessDate);
/* 206 */     dao.setOrganizationId(this._organizationId);
/* 207 */     dao.setRetailLocationId(this._retailLocationId);
/* 208 */     dao.setLineItemSequence(this._lineItemSequence);
/* 209 */     dao.setTransactionSequence(this._transactionSequence);
/* 210 */     dao.setWorkstationId(this._workstationId);
/* 211 */     dao.setCreateDate(this._createDate);
/* 212 */     dao.setCreateUserId(this._createUserId);
/* 213 */     dao.setUpdateDate(this._updateDate);
/* 214 */     dao.setUpdateUserId(this._updateUserId);
/* 215 */     dao.setDataStorage(this._dataStorage);
/* 216 */     argDAO.suppressStateChanges(false);
/* 217 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 221 */     return loadDAO((IDataAccessObject)new LineItemGenericStorageDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 225 */     LineItemGenericStorageDAO dao = (LineItemGenericStorageDAO)argDAO;
/* 226 */     this._businessDate = dao.getBusinessDate();
/* 227 */     this._organizationId = dao.getOrganizationId();
/* 228 */     this._retailLocationId = dao.getRetailLocationId();
/* 229 */     this._lineItemSequence = dao.getLineItemSequence();
/* 230 */     this._transactionSequence = dao.getTransactionSequence();
/* 231 */     this._workstationId = dao.getWorkstationId();
/* 232 */     this._createDate = dao.getCreateDate();
/* 233 */     this._createUserId = dao.getCreateUserId();
/* 234 */     this._updateDate = dao.getUpdateDate();
/* 235 */     this._updateUserId = dao.getUpdateUserId();
/* 236 */     this._dataStorage = dao.getDataStorage();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 240 */     LineItemGenericStorageId id = (LineItemGenericStorageId)argId;
/* 241 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDate().getTime()));
/* 242 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 243 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 244 */     argStatement.setInt(4, id.getLineItemSequence().intValue());
/* 245 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 246 */     argStatement.setLong(6, id.getWorkstationId().longValue());
/* 247 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 251 */     LineItemGenericStorageId id = new LineItemGenericStorageId();
/* 252 */     id.setBusinessDate(this._businessDate);
/* 253 */     id.setOrganizationId(this._organizationId);
/* 254 */     id.setRetailLocationId(this._retailLocationId);
/* 255 */     id.setLineItemSequence(this._lineItemSequence);
/* 256 */     id.setTransactionSequence(this._transactionSequence);
/* 257 */     id.setWorkstationId(this._workstationId);
/* 258 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 266 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 270 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\LineItemGenericStorageDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */