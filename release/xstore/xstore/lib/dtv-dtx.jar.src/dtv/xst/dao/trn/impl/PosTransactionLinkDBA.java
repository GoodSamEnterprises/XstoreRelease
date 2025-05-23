/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.PosTransactionLinkId;
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
/*     */ public class PosTransactionLinkDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -878991580L;
/*     */   private Date _businessDate;
/*     */   private Date _linkBusinessDate;
/*     */   private Long _linkRetailLocationId;
/*     */   private Long _linkTransactionSequence;
/*     */   private Long _linkWorkstationId;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _linkTypeCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.link_business_date, t.link_rtl_loc_id, t.link_trans_seq, t.link_wkstn_id, t.organization_id, t.rtl_loc_id, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.link_typcode FROM trn_trans_link t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND link_business_date = ?  AND link_rtl_loc_id = ?  AND link_trans_seq = ?  AND link_wkstn_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.business_date, t.link_business_date, t.link_rtl_loc_id, t.link_trans_seq, t.link_wkstn_id, t.organization_id, t.rtl_loc_id, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.link_typcode FROM trn_trans_link t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE business_date = ?  AND link_business_date = ?  AND link_rtl_loc_id = ?  AND link_trans_seq = ?  AND link_wkstn_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trn_trans_link(business_date, link_business_date, link_rtl_loc_id, link_trans_seq, link_wkstn_id, organization_id, rtl_loc_id, trans_seq, wkstn_id, create_date, create_user_id, update_date, update_user_id, link_typcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._businessDate, this._linkBusinessDate, this._linkRetailLocationId, this._linkTransactionSequence, this._linkWorkstationId, this._organizationId, this._retailLocationId, this._transactionSequence, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._linkTypeCode } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, 91, -5, -5, -5, -5, -5, -5, -5, 91, 12, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trn_trans_link SET update_date = ?, update_user_id = ?, link_typcode = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._linkTypeCode } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trn_trans_link" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND link_business_date = ?  AND link_rtl_loc_id = ?  AND link_trans_seq = ?  AND link_wkstn_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE business_date = ?  AND link_business_date = ?  AND link_rtl_loc_id = ?  AND link_trans_seq = ?  AND link_wkstn_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._businessDate, this._linkBusinessDate, this._linkRetailLocationId, this._linkTransactionSequence, this._linkWorkstationId, this._organizationId, this._retailLocationId, this._transactionSequence, this._workstationId };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, 91, -5, -5, -5, -5, -5, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "trn_trans_link";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new PosTransactionLinkFiller(this);
/*     */   }
/*     */   
/*     */   private static class PosTransactionLinkFiller
/*     */     implements IFiller {
/*     */     private PosTransactionLinkDBA _parent;
/*     */     
/*     */     public PosTransactionLinkFiller(PosTransactionLinkDBA argParent) {
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
/* 139 */       Timestamp t2 = argResultSet.getTimestamp(2);
/* 140 */       if (t2 != null) {
/* 141 */         this._parent._linkBusinessDate = (Date)new DtvDate(t2.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._linkBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 149 */       long primitiveResult = argResultSet.getLong(3);
/* 150 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 151 */         this._parent._linkRetailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 157 */       primitiveResult = argResultSet.getLong(4);
/* 158 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 159 */         this._parent._linkTransactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 165 */       primitiveResult = argResultSet.getLong(5);
/* 166 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 167 */         this._parent._linkWorkstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 173 */       primitiveResult = argResultSet.getLong(6);
/* 174 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 175 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 181 */       primitiveResult = argResultSet.getLong(7);
/* 182 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 183 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 189 */       primitiveResult = argResultSet.getLong(8);
/* 190 */       if (primitiveResult != 0L || argResultSet.getObject(8) != null) {
/* 191 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 197 */       primitiveResult = argResultSet.getLong(9);
/* 198 */       if (primitiveResult != 0L || argResultSet.getObject(9) != null) {
/* 199 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 204 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 205 */       if (t10 != null) {
/* 206 */         this._parent._createDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 209 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 212 */       this._parent._createUserId = argResultSet.getString(11);
/*     */       
/* 214 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 215 */       if (t12 != null) {
/* 216 */         this._parent._updateDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 219 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 222 */       this._parent._updateUserId = argResultSet.getString(13);
/* 223 */       this._parent._linkTypeCode = argResultSet.getString(14);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 228 */     argDAO.suppressStateChanges(true);
/* 229 */     PosTransactionLinkDAO dao = (PosTransactionLinkDAO)argDAO;
/* 230 */     dao.setBusinessDate(this._businessDate);
/* 231 */     dao.setLinkBusinessDate(this._linkBusinessDate);
/* 232 */     dao.setLinkRetailLocationId(this._linkRetailLocationId);
/* 233 */     dao.setLinkTransactionSequence(this._linkTransactionSequence);
/* 234 */     dao.setLinkWorkstationId(this._linkWorkstationId);
/* 235 */     dao.setOrganizationId(this._organizationId);
/* 236 */     dao.setRetailLocationId(this._retailLocationId);
/* 237 */     dao.setTransactionSequence(this._transactionSequence);
/* 238 */     dao.setWorkstationId(this._workstationId);
/* 239 */     dao.setCreateDate(this._createDate);
/* 240 */     dao.setCreateUserId(this._createUserId);
/* 241 */     dao.setUpdateDate(this._updateDate);
/* 242 */     dao.setUpdateUserId(this._updateUserId);
/* 243 */     dao.setLinkTypeCode(this._linkTypeCode);
/* 244 */     argDAO.suppressStateChanges(false);
/* 245 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 249 */     return loadDAO((IDataAccessObject)new PosTransactionLinkDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 253 */     PosTransactionLinkDAO dao = (PosTransactionLinkDAO)argDAO;
/* 254 */     this._businessDate = dao.getBusinessDate();
/* 255 */     this._linkBusinessDate = dao.getLinkBusinessDate();
/* 256 */     this._linkRetailLocationId = dao.getLinkRetailLocationId();
/* 257 */     this._linkTransactionSequence = dao.getLinkTransactionSequence();
/* 258 */     this._linkWorkstationId = dao.getLinkWorkstationId();
/* 259 */     this._organizationId = dao.getOrganizationId();
/* 260 */     this._retailLocationId = dao.getRetailLocationId();
/* 261 */     this._transactionSequence = dao.getTransactionSequence();
/* 262 */     this._workstationId = dao.getWorkstationId();
/* 263 */     this._createDate = dao.getCreateDate();
/* 264 */     this._createUserId = dao.getCreateUserId();
/* 265 */     this._updateDate = dao.getUpdateDate();
/* 266 */     this._updateUserId = dao.getUpdateUserId();
/* 267 */     this._linkTypeCode = dao.getLinkTypeCode();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 271 */     PosTransactionLinkId id = (PosTransactionLinkId)argId;
/* 272 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDate().getTime()));
/* 273 */     argStatement.setTimestamp(2, new Timestamp(id.getLinkBusinessDate().getTime()));
/* 274 */     argStatement.setLong(3, id.getLinkRetailLocationId().longValue());
/* 275 */     argStatement.setLong(4, id.getLinkTransactionSequence().longValue());
/* 276 */     argStatement.setLong(5, id.getLinkWorkstationId().longValue());
/* 277 */     argStatement.setLong(6, id.getOrganizationId().longValue());
/* 278 */     argStatement.setLong(7, id.getRetailLocationId().longValue());
/* 279 */     argStatement.setLong(8, id.getTransactionSequence().longValue());
/* 280 */     argStatement.setLong(9, id.getWorkstationId().longValue());
/* 281 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 285 */     PosTransactionLinkId id = new PosTransactionLinkId();
/* 286 */     id.setBusinessDate(this._businessDate);
/* 287 */     id.setLinkBusinessDate(this._linkBusinessDate);
/* 288 */     id.setLinkRetailLocationId(this._linkRetailLocationId);
/* 289 */     id.setLinkTransactionSequence(this._linkTransactionSequence);
/* 290 */     id.setLinkWorkstationId(this._linkWorkstationId);
/* 291 */     id.setOrganizationId(this._organizationId);
/* 292 */     id.setRetailLocationId(this._retailLocationId);
/* 293 */     id.setTransactionSequence(this._transactionSequence);
/* 294 */     id.setWorkstationId(this._workstationId);
/* 295 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 303 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 307 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PosTransactionLinkDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */