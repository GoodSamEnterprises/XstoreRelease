/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.PosTransactionId;
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
/*     */ public class PostVoidTransactionDBA
/*     */   extends PosTransactionDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -906774582L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _voidedTransactionEntryCode;
/*     */   private Date _voidedBusinessDate;
/*     */   private Long _voidedWorkstationId;
/*     */   private Long _voidedTransactionId;
/*     */   private Long _voidedRetailStoreId;
/*     */   private Long _voidedOrganizationId;
/*     */   private String _postVoidReasonCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.voided_trans_entry_code, t.voided_business_date, t.voided_wkstn_id, t.voided_trans_id, t.voided_rtl_store_id, t.voided_org_id, t.post_void_reascode FROM trn_post_void_trans t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.voided_trans_entry_code, t.voided_business_date, t.voided_wkstn_id, t.voided_trans_id, t.voided_rtl_store_id, t.voided_org_id, t.post_void_reascode FROM trn_post_void_trans t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  57 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*  60 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trn_post_void_trans(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, create_date, create_user_id, update_date, update_user_id, voided_trans_entry_code, voided_business_date, voided_wkstn_id, voided_trans_id, voided_rtl_store_id, voided_org_id, post_void_reascode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  64 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  69 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._voidedTransactionEntryCode, this._voidedBusinessDate, this._voidedWorkstationId, this._voidedTransactionId, this._voidedRetailStoreId, this._voidedOrganizationId, this._postVoidReasonCode } };
/*  70 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  73 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 91, 12, 91, 12, 12, 91, -5, -5, -5, -5, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  77 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  80 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trn_post_void_trans SET update_date = ?, update_user_id = ?, voided_trans_entry_code = ?, voided_business_date = ?, voided_wkstn_id = ?, voided_trans_id = ?, voided_rtl_store_id = ?, voided_org_id = ?, post_void_reascode = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  84 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  89 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._voidedTransactionEntryCode, this._voidedBusinessDate, this._voidedWorkstationId, this._voidedTransactionId, this._voidedRetailStoreId, this._voidedOrganizationId, this._postVoidReasonCode } };
/*  90 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  93 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 91, -5, -5, -5, -5, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  96 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/*  99 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trn_post_void_trans" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 103 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 110 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 114 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence };
/*     */   }
/*     */   
/* 117 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 121 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 125 */     return "trn_post_void_trans";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 130 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 134 */     return new PostVoidTransactionFiller(this);
/*     */   }
/*     */   
/*     */   private static class PostVoidTransactionFiller
/*     */     implements IFiller {
/*     */     private PostVoidTransactionDBA _parent;
/*     */     
/*     */     public PostVoidTransactionFiller(PostVoidTransactionDBA argParent) {
/* 142 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 147 */       long primitiveResult = argResultSet.getLong(1);
/* 148 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 149 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 155 */       primitiveResult = argResultSet.getLong(2);
/* 156 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 157 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 162 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 163 */       if (t3 != null) {
/* 164 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 167 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 172 */       long l1 = argResultSet.getLong(4);
/* 173 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 174 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 180 */       l1 = argResultSet.getLong(5);
/* 181 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 182 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 187 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 188 */       if (t6 != null) {
/* 189 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 192 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 195 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 197 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 198 */       if (t8 != null) {
/* 199 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 202 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 205 */       this._parent._updateUserId = argResultSet.getString(9);
/* 206 */       this._parent._voidedTransactionEntryCode = argResultSet.getString(10);
/*     */       
/* 208 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 209 */       if (t11 != null) {
/* 210 */         this._parent._voidedBusinessDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 213 */         this._parent._voidedBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 218 */       long l2 = argResultSet.getLong(12);
/* 219 */       if (l2 != 0L || argResultSet.getObject(12) != null) {
/* 220 */         this._parent._voidedWorkstationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 226 */       l2 = argResultSet.getLong(13);
/* 227 */       if (l2 != 0L || argResultSet.getObject(13) != null) {
/* 228 */         this._parent._voidedTransactionId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 234 */       l2 = argResultSet.getLong(14);
/* 235 */       if (l2 != 0L || argResultSet.getObject(14) != null) {
/* 236 */         this._parent._voidedRetailStoreId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 242 */       l2 = argResultSet.getLong(15);
/* 243 */       if (l2 != 0L || argResultSet.getObject(15) != null) {
/* 244 */         this._parent._voidedOrganizationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 248 */       this._parent._postVoidReasonCode = argResultSet.getString(16);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 254 */     super.loadDAO(argDAO);
/* 255 */     argDAO.suppressStateChanges(true);
/* 256 */     PostVoidTransactionDAO dao = (PostVoidTransactionDAO)argDAO;
/* 257 */     dao.setOrganizationId(this._organizationId);
/* 258 */     dao.setRetailLocationId(this._retailLocationId);
/* 259 */     dao.setBusinessDate(this._businessDate);
/* 260 */     dao.setWorkstationId(this._workstationId);
/* 261 */     dao.setTransactionSequence(this._transactionSequence);
/* 262 */     dao.setCreateDate(this._createDate);
/* 263 */     dao.setCreateUserId(this._createUserId);
/* 264 */     dao.setUpdateDate(this._updateDate);
/* 265 */     dao.setUpdateUserId(this._updateUserId);
/* 266 */     dao.setVoidedTransactionEntryCode(this._voidedTransactionEntryCode);
/* 267 */     dao.setVoidedBusinessDate(this._voidedBusinessDate);
/* 268 */     dao.setVoidedWorkstationId(this._voidedWorkstationId);
/* 269 */     dao.setVoidedTransactionId(this._voidedTransactionId);
/* 270 */     dao.setVoidedRetailStoreId(this._voidedRetailStoreId);
/* 271 */     dao.setVoidedOrganizationId(this._voidedOrganizationId);
/* 272 */     dao.setPostVoidReasonCode(this._postVoidReasonCode);
/* 273 */     argDAO.suppressStateChanges(false);
/* 274 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 279 */     return loadDAO((IDataAccessObject)new PostVoidTransactionDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 284 */     PostVoidTransactionDAO dao = (PostVoidTransactionDAO)argDAO;
/* 285 */     super.fill((IDataAccessObject)dao);
/* 286 */     this._organizationId = dao.getOrganizationId();
/* 287 */     this._retailLocationId = dao.getRetailLocationId();
/* 288 */     this._businessDate = dao.getBusinessDate();
/* 289 */     this._workstationId = dao.getWorkstationId();
/* 290 */     this._transactionSequence = dao.getTransactionSequence();
/* 291 */     this._createDate = dao.getCreateDate();
/* 292 */     this._createUserId = dao.getCreateUserId();
/* 293 */     this._updateDate = dao.getUpdateDate();
/* 294 */     this._updateUserId = dao.getUpdateUserId();
/* 295 */     this._voidedTransactionEntryCode = dao.getVoidedTransactionEntryCode();
/* 296 */     this._voidedBusinessDate = dao.getVoidedBusinessDate();
/* 297 */     this._voidedWorkstationId = dao.getVoidedWorkstationId();
/* 298 */     this._voidedTransactionId = dao.getVoidedTransactionId();
/* 299 */     this._voidedRetailStoreId = dao.getVoidedRetailStoreId();
/* 300 */     this._voidedOrganizationId = dao.getVoidedOrganizationId();
/* 301 */     this._postVoidReasonCode = dao.getPostVoidReasonCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 306 */     PosTransactionId id = (PosTransactionId)argId;
/* 307 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 308 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 309 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 310 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 311 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 312 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 316 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 320 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PostVoidTransactionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */