/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailTransactionLineItemId;
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
/*     */ public class RetailTransactionExchangeLineItemDBA
/*     */   extends RetailTransactionLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -790483899L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private String _itemId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _originalSerialNumber;
/*     */   private String _newSerialNumber;
/*     */   private Long _originalRetailLocationId;
/*     */   private Date _originalBusinessDate;
/*     */   private Long _originalWorkstationId;
/*     */   private Long _originalTransactionSequence;
/*     */   private Integer _oiginalLineItemSequence;
/*     */   private String _exchangeReasonCode;
/*     */   private String _exchangeComment;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.orig_serial_nbr, t.new_serial_nbr, t.orig_rtl_loc_id, t.orig_business_date, t.orig_wkstn_id, t.orig_trans_seq, t.orig_lineitm_seq, t.exchange_reason_code, t.exchange_comment FROM trl_rtrans_serial_exchange t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  50 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  54 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.orig_serial_nbr, t.new_serial_nbr, t.orig_rtl_loc_id, t.orig_business_date, t.orig_wkstn_id, t.orig_trans_seq, t.orig_lineitm_seq, t.exchange_reason_code, t.exchange_comment FROM trl_rtrans_serial_exchange t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  61 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  64 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_rtrans_serial_exchange(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, item_id, create_date, create_user_id, update_date, update_user_id, orig_serial_nbr, new_serial_nbr, orig_rtl_loc_id, orig_business_date, orig_wkstn_id, orig_trans_seq, orig_lineitm_seq, exchange_reason_code, exchange_comment) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  68 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  73 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._itemId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._originalSerialNumber, this._newSerialNumber, this._originalRetailLocationId, this._originalBusinessDate, this._originalWorkstationId, this._originalTransactionSequence, this._oiginalLineItemSequence, this._exchangeReasonCode, this._exchangeComment } };
/*  74 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  77 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 12, 91, 12, 91, 12, 12, 12, -5, 91, -5, -5, 4, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  81 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  84 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_rtrans_serial_exchange SET item_id = ?, update_date = ?, update_user_id = ?, orig_serial_nbr = ?, new_serial_nbr = ?, orig_rtl_loc_id = ?, orig_business_date = ?, orig_wkstn_id = ?, orig_trans_seq = ?, orig_lineitm_seq = ?, exchange_reason_code = ?, exchange_comment = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  88 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  93 */     Object[][] updateParameterObject = { { this._itemId, this._updateDate, this._updateUserId, this._originalSerialNumber, this._newSerialNumber, this._originalRetailLocationId, this._originalBusinessDate, this._originalWorkstationId, this._originalTransactionSequence, this._oiginalLineItemSequence, this._exchangeReasonCode, this._exchangeComment } };
/*  94 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  97 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 91, 12, 12, 12, -5, 91, -5, -5, 4, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/* 100 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/* 103 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_rtrans_serial_exchange" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 107 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 114 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 118 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 121 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 125 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 129 */     return "trl_rtrans_serial_exchange";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 134 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 138 */     return new RetailTransactionExchangeLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class RetailTransactionExchangeLineItemFiller
/*     */     implements IFiller {
/*     */     private RetailTransactionExchangeLineItemDBA _parent;
/*     */     
/*     */     public RetailTransactionExchangeLineItemFiller(RetailTransactionExchangeLineItemDBA argParent) {
/* 146 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 151 */       long primitiveResult = argResultSet.getLong(1);
/* 152 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 153 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 159 */       primitiveResult = argResultSet.getLong(2);
/* 160 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 161 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 166 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 167 */       if (t3 != null) {
/* 168 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 171 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 176 */       long l1 = argResultSet.getLong(4);
/* 177 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 178 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 184 */       l1 = argResultSet.getLong(5);
/* 185 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 186 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 192 */       int i = argResultSet.getInt(6);
/* 193 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 194 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 198 */       this._parent._itemId = argResultSet.getString(7);
/*     */       
/* 200 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 201 */       if (t8 != null) {
/* 202 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 205 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 208 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 210 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 211 */       if (t10 != null) {
/* 212 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 215 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 218 */       this._parent._updateUserId = argResultSet.getString(11);
/* 219 */       this._parent._originalSerialNumber = argResultSet.getString(12);
/* 220 */       this._parent._newSerialNumber = argResultSet.getString(13);
/*     */ 
/*     */       
/* 223 */       long l2 = argResultSet.getLong(14);
/* 224 */       if (l2 != 0L || argResultSet.getObject(14) != null) {
/* 225 */         this._parent._originalRetailLocationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 230 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 231 */       if (t15 != null) {
/* 232 */         this._parent._originalBusinessDate = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 235 */         this._parent._originalBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 240 */       long l3 = argResultSet.getLong(16);
/* 241 */       if (l3 != 0L || argResultSet.getObject(16) != null) {
/* 242 */         this._parent._originalWorkstationId = Long.valueOf(l3);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 248 */       l3 = argResultSet.getLong(17);
/* 249 */       if (l3 != 0L || argResultSet.getObject(17) != null) {
/* 250 */         this._parent._originalTransactionSequence = Long.valueOf(l3);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 256 */       int j = argResultSet.getInt(18);
/* 257 */       if (j != 0 || argResultSet.getObject(18) != null) {
/* 258 */         this._parent._oiginalLineItemSequence = Integer.valueOf(j);
/*     */       }
/*     */ 
/*     */       
/* 262 */       this._parent._exchangeReasonCode = argResultSet.getString(19);
/* 263 */       this._parent._exchangeComment = argResultSet.getString(20);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 269 */     super.loadDAO(argDAO);
/* 270 */     argDAO.suppressStateChanges(true);
/* 271 */     RetailTransactionExchangeLineItemDAO dao = (RetailTransactionExchangeLineItemDAO)argDAO;
/* 272 */     dao.setOrganizationId(this._organizationId);
/* 273 */     dao.setRetailLocationId(this._retailLocationId);
/* 274 */     dao.setBusinessDate(this._businessDate);
/* 275 */     dao.setWorkstationId(this._workstationId);
/* 276 */     dao.setTransactionSequence(this._transactionSequence);
/* 277 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 278 */     dao.setItemId(this._itemId);
/* 279 */     dao.setCreateDate(this._createDate);
/* 280 */     dao.setCreateUserId(this._createUserId);
/* 281 */     dao.setUpdateDate(this._updateDate);
/* 282 */     dao.setUpdateUserId(this._updateUserId);
/* 283 */     dao.setOriginalSerialNumber(this._originalSerialNumber);
/* 284 */     dao.setNewSerialNumber(this._newSerialNumber);
/* 285 */     dao.setOriginalRetailLocationId(this._originalRetailLocationId);
/* 286 */     dao.setOriginalBusinessDate(this._originalBusinessDate);
/* 287 */     dao.setOriginalWorkstationId(this._originalWorkstationId);
/* 288 */     dao.setOriginalTransactionSequence(this._originalTransactionSequence);
/* 289 */     dao.setOiginalLineItemSequence(this._oiginalLineItemSequence);
/* 290 */     dao.setExchangeReasonCode(this._exchangeReasonCode);
/* 291 */     dao.setExchangeComment(this._exchangeComment);
/* 292 */     argDAO.suppressStateChanges(false);
/* 293 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 298 */     return loadDAO((IDataAccessObject)new RetailTransactionExchangeLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 303 */     RetailTransactionExchangeLineItemDAO dao = (RetailTransactionExchangeLineItemDAO)argDAO;
/* 304 */     super.fill((IDataAccessObject)dao);
/* 305 */     this._organizationId = dao.getOrganizationId();
/* 306 */     this._retailLocationId = dao.getRetailLocationId();
/* 307 */     this._businessDate = dao.getBusinessDate();
/* 308 */     this._workstationId = dao.getWorkstationId();
/* 309 */     this._transactionSequence = dao.getTransactionSequence();
/* 310 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 311 */     this._itemId = dao.getItemId();
/* 312 */     this._createDate = dao.getCreateDate();
/* 313 */     this._createUserId = dao.getCreateUserId();
/* 314 */     this._updateDate = dao.getUpdateDate();
/* 315 */     this._updateUserId = dao.getUpdateUserId();
/* 316 */     this._originalSerialNumber = dao.getOriginalSerialNumber();
/* 317 */     this._newSerialNumber = dao.getNewSerialNumber();
/* 318 */     this._originalRetailLocationId = dao.getOriginalRetailLocationId();
/* 319 */     this._originalBusinessDate = dao.getOriginalBusinessDate();
/* 320 */     this._originalWorkstationId = dao.getOriginalWorkstationId();
/* 321 */     this._originalTransactionSequence = dao.getOriginalTransactionSequence();
/* 322 */     this._oiginalLineItemSequence = dao.getOiginalLineItemSequence();
/* 323 */     this._exchangeReasonCode = dao.getExchangeReasonCode();
/* 324 */     this._exchangeComment = dao.getExchangeComment();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 329 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 330 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 331 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 332 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 333 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 334 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 335 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 336 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 340 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 344 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionExchangeLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */