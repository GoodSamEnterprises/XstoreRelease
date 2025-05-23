/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.PosTransactionId;
/*     */ import dtv.xst.dao.trn.impl.PosTransactionDBA;
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
/*     */ public class TenderControlTransactionDBA
/*     */   extends PosTransactionDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -645771435L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _amount;
/*     */   private Date _depositDate;
/*     */   private String _typeCode;
/*     */   private Long _fundsReceiptPartyId;
/*     */   private Long _inboundSessionId;
/*     */   private String _inboundTenderRepositoryId;
/*     */   private Long _outboundSessionId;
/*     */   private String _outboundTenderRepositoryId;
/*     */   private String _reasonCode;
/*     */   private String _safeBagId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.deposit_date, t.typcode, t.funds_receipt_party_id, t.inbound_session_id, t.inbound_tndr_repository_id, t.outbound_session_id, t.outbound_tndr_repository_id, t.reascode, t.safe_bag_id FROM tsn_tndr_control_trans t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  49 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  53 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.deposit_date, t.typcode, t.funds_receipt_party_id, t.inbound_session_id, t.inbound_tndr_repository_id, t.outbound_session_id, t.outbound_tndr_repository_id, t.reascode, t.safe_bag_id FROM tsn_tndr_control_trans t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  60 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*  63 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_tndr_control_trans(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, create_date, create_user_id, update_date, update_user_id, amt, deposit_date, typcode, funds_receipt_party_id, inbound_session_id, inbound_tndr_repository_id, outbound_session_id, outbound_tndr_repository_id, reascode, safe_bag_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  67 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  72 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._amount, this._depositDate, this._typeCode, this._fundsReceiptPartyId, this._inboundSessionId, this._inboundTenderRepositoryId, this._outboundSessionId, this._outboundTenderRepositoryId, this._reasonCode, this._safeBagId } };
/*  73 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  76 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 91, 12, 91, 12, 3, 91, 12, -5, -5, 12, -5, 12, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  80 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  83 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_tndr_control_trans SET update_date = ?, update_user_id = ?, amt = ?, deposit_date = ?, typcode = ?, funds_receipt_party_id = ?, inbound_session_id = ?, inbound_tndr_repository_id = ?, outbound_session_id = ?, outbound_tndr_repository_id = ?, reascode = ?, safe_bag_id = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  87 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  92 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._amount, this._depositDate, this._typeCode, this._fundsReceiptPartyId, this._inboundSessionId, this._inboundTenderRepositoryId, this._outboundSessionId, this._outboundTenderRepositoryId, this._reasonCode, this._safeBagId } };
/*  93 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  96 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 91, 12, -5, -5, 12, -5, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  99 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/* 102 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_tndr_control_trans" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 106 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 113 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 117 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence };
/*     */   }
/*     */   
/* 120 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 124 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 128 */     return "tsn_tndr_control_trans";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 133 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 137 */     return new TenderControlTransactionFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderControlTransactionFiller
/*     */     implements IFiller {
/*     */     private TenderControlTransactionDBA _parent;
/*     */     
/*     */     public TenderControlTransactionFiller(TenderControlTransactionDBA argParent) {
/* 145 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 150 */       long primitiveResult = argResultSet.getLong(1);
/* 151 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 152 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 158 */       primitiveResult = argResultSet.getLong(2);
/* 159 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 160 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 165 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 166 */       if (t3 != null) {
/* 167 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 175 */       long l1 = argResultSet.getLong(4);
/* 176 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 177 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 183 */       l1 = argResultSet.getLong(5);
/* 184 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 185 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 190 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 191 */       if (t6 != null) {
/* 192 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 195 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 198 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 200 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 201 */       if (t8 != null) {
/* 202 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 205 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 208 */       this._parent._updateUserId = argResultSet.getString(9);
/* 209 */       this._parent._amount = argResultSet.getBigDecimal(10);
/*     */       
/* 211 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 212 */       if (t11 != null) {
/* 213 */         this._parent._depositDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 216 */         this._parent._depositDate = null;
/*     */       } 
/*     */       
/* 219 */       this._parent._typeCode = argResultSet.getString(12);
/*     */ 
/*     */       
/* 222 */       long l2 = argResultSet.getLong(13);
/* 223 */       if (l2 != 0L || argResultSet.getObject(13) != null) {
/* 224 */         this._parent._fundsReceiptPartyId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 230 */       l2 = argResultSet.getLong(14);
/* 231 */       if (l2 != 0L || argResultSet.getObject(14) != null) {
/* 232 */         this._parent._inboundSessionId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 236 */       this._parent._inboundTenderRepositoryId = argResultSet.getString(15);
/*     */ 
/*     */       
/* 239 */       l2 = argResultSet.getLong(16);
/* 240 */       if (l2 != 0L || argResultSet.getObject(16) != null) {
/* 241 */         this._parent._outboundSessionId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 245 */       this._parent._outboundTenderRepositoryId = argResultSet.getString(17);
/* 246 */       this._parent._reasonCode = argResultSet.getString(18);
/* 247 */       this._parent._safeBagId = argResultSet.getString(19);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 253 */     super.loadDAO(argDAO);
/* 254 */     argDAO.suppressStateChanges(true);
/* 255 */     TenderControlTransactionDAO dao = (TenderControlTransactionDAO)argDAO;
/* 256 */     dao.setOrganizationId(this._organizationId);
/* 257 */     dao.setRetailLocationId(this._retailLocationId);
/* 258 */     dao.setBusinessDate(this._businessDate);
/* 259 */     dao.setWorkstationId(this._workstationId);
/* 260 */     dao.setTransactionSequence(this._transactionSequence);
/* 261 */     dao.setCreateDate(this._createDate);
/* 262 */     dao.setCreateUserId(this._createUserId);
/* 263 */     dao.setUpdateDate(this._updateDate);
/* 264 */     dao.setUpdateUserId(this._updateUserId);
/* 265 */     dao.setAmount(this._amount);
/* 266 */     dao.setDepositDate(this._depositDate);
/* 267 */     dao.setTypeCode(this._typeCode);
/* 268 */     dao.setFundsReceiptPartyId(this._fundsReceiptPartyId);
/* 269 */     dao.setInboundSessionId(this._inboundSessionId);
/* 270 */     dao.setInboundTenderRepositoryId(this._inboundTenderRepositoryId);
/* 271 */     dao.setOutboundSessionId(this._outboundSessionId);
/* 272 */     dao.setOutboundTenderRepositoryId(this._outboundTenderRepositoryId);
/* 273 */     dao.setReasonCode(this._reasonCode);
/* 274 */     dao.setSafeBagId(this._safeBagId);
/* 275 */     argDAO.suppressStateChanges(false);
/* 276 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 281 */     return loadDAO((IDataAccessObject)new TenderControlTransactionDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 286 */     TenderControlTransactionDAO dao = (TenderControlTransactionDAO)argDAO;
/* 287 */     super.fill((IDataAccessObject)dao);
/* 288 */     this._organizationId = dao.getOrganizationId();
/* 289 */     this._retailLocationId = dao.getRetailLocationId();
/* 290 */     this._businessDate = dao.getBusinessDate();
/* 291 */     this._workstationId = dao.getWorkstationId();
/* 292 */     this._transactionSequence = dao.getTransactionSequence();
/* 293 */     this._createDate = dao.getCreateDate();
/* 294 */     this._createUserId = dao.getCreateUserId();
/* 295 */     this._updateDate = dao.getUpdateDate();
/* 296 */     this._updateUserId = dao.getUpdateUserId();
/* 297 */     this._amount = dao.getAmount();
/* 298 */     this._depositDate = dao.getDepositDate();
/* 299 */     this._typeCode = dao.getTypeCode();
/* 300 */     this._fundsReceiptPartyId = dao.getFundsReceiptPartyId();
/* 301 */     this._inboundSessionId = dao.getInboundSessionId();
/* 302 */     this._inboundTenderRepositoryId = dao.getInboundTenderRepositoryId();
/* 303 */     this._outboundSessionId = dao.getOutboundSessionId();
/* 304 */     this._outboundTenderRepositoryId = dao.getOutboundTenderRepositoryId();
/* 305 */     this._reasonCode = dao.getReasonCode();
/* 306 */     this._safeBagId = dao.getSafeBagId();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 311 */     PosTransactionId id = (PosTransactionId)argId;
/* 312 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 313 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 314 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 315 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 316 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 317 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 321 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 325 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderControlTransactionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */