/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ttr.TenderSignatureId;
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
/*     */ public class TenderSignatureDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1418685476L;
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
/*     */   private String _signature;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.signature FROM ttr_signature t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.signature FROM ttr_signature t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ttr_signature(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, signature) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._signature } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 2005 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ttr_signature SET update_date = ?, update_user_id = ?, signature = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._signature } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 2005 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ttr_signature" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "ttr_signature";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new TenderSignatureFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderSignatureFiller
/*     */     implements IFiller {
/*     */     private TenderSignatureDBA _parent;
/*     */     
/*     */     public TenderSignatureFiller(TenderSignatureDBA argParent) {
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
/* 143 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 144 */       if (t3 != null) {
/* 145 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 148 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 153 */       long l1 = argResultSet.getLong(4);
/* 154 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 155 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 161 */       l1 = argResultSet.getLong(5);
/* 162 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 163 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 169 */       int i = argResultSet.getInt(6);
/* 170 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 171 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
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
/* 197 */       this._parent._signature = JDBCHelper.clobToString(argResultSet, 11);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 203 */     argDAO.suppressStateChanges(true);
/* 204 */     TenderSignatureDAO dao = (TenderSignatureDAO)argDAO;
/* 205 */     dao.setOrganizationId(this._organizationId);
/* 206 */     dao.setRetailLocationId(this._retailLocationId);
/* 207 */     dao.setBusinessDate(this._businessDate);
/* 208 */     dao.setWorkstationId(this._workstationId);
/* 209 */     dao.setTransactionSequence(this._transactionSequence);
/* 210 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 211 */     dao.setCreateDate(this._createDate);
/* 212 */     dao.setCreateUserId(this._createUserId);
/* 213 */     dao.setUpdateDate(this._updateDate);
/* 214 */     dao.setUpdateUserId(this._updateUserId);
/* 215 */     dao.setSignature(this._signature);
/* 216 */     argDAO.suppressStateChanges(false);
/* 217 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 221 */     return loadDAO((IDataAccessObject)new TenderSignatureDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 225 */     TenderSignatureDAO dao = (TenderSignatureDAO)argDAO;
/* 226 */     this._organizationId = dao.getOrganizationId();
/* 227 */     this._retailLocationId = dao.getRetailLocationId();
/* 228 */     this._businessDate = dao.getBusinessDate();
/* 229 */     this._workstationId = dao.getWorkstationId();
/* 230 */     this._transactionSequence = dao.getTransactionSequence();
/* 231 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 232 */     this._createDate = dao.getCreateDate();
/* 233 */     this._createUserId = dao.getCreateUserId();
/* 234 */     this._updateDate = dao.getUpdateDate();
/* 235 */     this._updateUserId = dao.getUpdateUserId();
/* 236 */     this._signature = dao.getSignature();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 240 */     TenderSignatureId id = (TenderSignatureId)argId;
/* 241 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 242 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 243 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 244 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 245 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 246 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 247 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 251 */     TenderSignatureId id = new TenderSignatureId();
/* 252 */     id.setOrganizationId(this._organizationId);
/* 253 */     id.setRetailLocationId(this._retailLocationId);
/* 254 */     id.setBusinessDate(this._businessDate);
/* 255 */     id.setWorkstationId(this._workstationId);
/* 256 */     id.setTransactionSequence(this._transactionSequence);
/* 257 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\TenderSignatureDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */