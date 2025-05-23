/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ttr.IdentityVerificationId;
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
/*     */ public class IdentityVerificationDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1897243161L;
/*     */   private Date _businessDate;
/*     */   private Integer _identityVerificationSequence;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _idNumber;
/*     */   private String _idTypeCode;
/*     */   private String _issuingAuthority;
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.identity_verification_seq, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.id_nbr, t.id_typcode, t.issuing_authority FROM ttr_identity_verification t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND identity_verification_seq = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.business_date, t.identity_verification_seq, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.id_nbr, t.id_typcode, t.issuing_authority FROM ttr_identity_verification t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE business_date = ?  AND identity_verification_seq = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ttr_identity_verification(business_date, identity_verification_seq, organization_id, rtl_loc_id, rtrans_lineitm_seq, trans_seq, wkstn_id, create_date, create_user_id, update_date, update_user_id, id_nbr, id_typcode, issuing_authority) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._businessDate, this._identityVerificationSequence, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._idNumber, this._idTypeCode, this._issuingAuthority } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, 4, -5, -5, 4, -5, -5, 91, 12, 91, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ttr_identity_verification SET update_date = ?, update_user_id = ?, id_nbr = ?, id_typcode = ?, issuing_authority = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._idNumber, this._idTypeCode, this._issuingAuthority } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ttr_identity_verification" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND identity_verification_seq = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE business_date = ?  AND identity_verification_seq = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._businessDate, this._identityVerificationSequence, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, 4, -5, -5, 4, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "ttr_identity_verification";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new IdentityVerificationFiller(this);
/*     */   }
/*     */   
/*     */   private static class IdentityVerificationFiller
/*     */     implements IFiller {
/*     */     private IdentityVerificationDBA _parent;
/*     */     
/*     */     public IdentityVerificationFiller(IdentityVerificationDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 131 */       if (t1 != null) {
/* 132 */         this._parent._businessDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 135 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 140 */       int j = argResultSet.getInt(2);
/* 141 */       if (j != 0 || argResultSet.getObject(2) != null) {
/* 142 */         this._parent._identityVerificationSequence = Integer.valueOf(j);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 148 */       long l1 = argResultSet.getLong(3);
/* 149 */       if (l1 != 0L || argResultSet.getObject(3) != null) {
/* 150 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 156 */       l1 = argResultSet.getLong(4);
/* 157 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 158 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 164 */       int i = argResultSet.getInt(5);
/* 165 */       if (i != 0 || argResultSet.getObject(5) != null) {
/* 166 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 172 */       long primitiveResult = argResultSet.getLong(6);
/* 173 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 174 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 180 */       primitiveResult = argResultSet.getLong(7);
/* 181 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 182 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 187 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 188 */       if (t8 != null) {
/* 189 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 192 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 195 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 197 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 198 */       if (t10 != null) {
/* 199 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 202 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 205 */       this._parent._updateUserId = argResultSet.getString(11);
/* 206 */       this._parent._idNumber = argResultSet.getString(12);
/* 207 */       this._parent._idTypeCode = argResultSet.getString(13);
/* 208 */       this._parent._issuingAuthority = argResultSet.getString(14);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 213 */     argDAO.suppressStateChanges(true);
/* 214 */     IdentityVerificationDAO dao = (IdentityVerificationDAO)argDAO;
/* 215 */     dao.setBusinessDate(this._businessDate);
/* 216 */     dao.setIdentityVerificationSequence(this._identityVerificationSequence);
/* 217 */     dao.setOrganizationId(this._organizationId);
/* 218 */     dao.setRetailLocationId(this._retailLocationId);
/* 219 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 220 */     dao.setTransactionSequence(this._transactionSequence);
/* 221 */     dao.setWorkstationId(this._workstationId);
/* 222 */     dao.setCreateDate(this._createDate);
/* 223 */     dao.setCreateUserId(this._createUserId);
/* 224 */     dao.setUpdateDate(this._updateDate);
/* 225 */     dao.setUpdateUserId(this._updateUserId);
/* 226 */     dao.setIdNumber(this._idNumber);
/* 227 */     dao.setIdTypeCode(this._idTypeCode);
/* 228 */     dao.setIssuingAuthority(this._issuingAuthority);
/* 229 */     argDAO.suppressStateChanges(false);
/* 230 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 234 */     return loadDAO((IDataAccessObject)new IdentityVerificationDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 238 */     IdentityVerificationDAO dao = (IdentityVerificationDAO)argDAO;
/* 239 */     this._businessDate = dao.getBusinessDate();
/* 240 */     this._identityVerificationSequence = dao.getIdentityVerificationSequence();
/* 241 */     this._organizationId = dao.getOrganizationId();
/* 242 */     this._retailLocationId = dao.getRetailLocationId();
/* 243 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 244 */     this._transactionSequence = dao.getTransactionSequence();
/* 245 */     this._workstationId = dao.getWorkstationId();
/* 246 */     this._createDate = dao.getCreateDate();
/* 247 */     this._createUserId = dao.getCreateUserId();
/* 248 */     this._updateDate = dao.getUpdateDate();
/* 249 */     this._updateUserId = dao.getUpdateUserId();
/* 250 */     this._idNumber = dao.getIdNumber();
/* 251 */     this._idTypeCode = dao.getIdTypeCode();
/* 252 */     this._issuingAuthority = dao.getIssuingAuthority();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 256 */     IdentityVerificationId id = (IdentityVerificationId)argId;
/* 257 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDate().getTime()));
/* 258 */     argStatement.setInt(2, id.getIdentityVerificationSequence().intValue());
/* 259 */     argStatement.setLong(3, id.getOrganizationId().longValue());
/* 260 */     argStatement.setLong(4, id.getRetailLocationId().longValue());
/* 261 */     argStatement.setInt(5, id.getRetailTransactionLineItemSequence().intValue());
/* 262 */     argStatement.setLong(6, id.getTransactionSequence().longValue());
/* 263 */     argStatement.setLong(7, id.getWorkstationId().longValue());
/* 264 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 268 */     IdentityVerificationId id = new IdentityVerificationId();
/* 269 */     id.setBusinessDate(this._businessDate);
/* 270 */     id.setIdentityVerificationSequence(this._identityVerificationSequence);
/* 271 */     id.setOrganizationId(this._organizationId);
/* 272 */     id.setRetailLocationId(this._retailLocationId);
/* 273 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 274 */     id.setTransactionSequence(this._transactionSequence);
/* 275 */     id.setWorkstationId(this._workstationId);
/* 276 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 284 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 288 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\IdentityVerificationDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */