/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.CorrectionModifierId;
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
/*     */ public class CorrectionModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1247937653L;
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
/*     */   private Long _originalRetailLocationId;
/*     */   private Long _originalWorkstationId;
/*     */   private Date _originalBusinessDate;
/*     */   private Long _originalTransactionSequence;
/*     */   private Integer _originalRetailTransactionLineItemSequence;
/*     */   private String _reasonCode;
/*     */   private String _notes;
/*     */   private BigDecimal _originalTaxAmt;
/*     */   private BigDecimal _originalExtendedPrice;
/*     */   private BigDecimal _originalUnitPrice;
/*     */   private BigDecimal _originalBaseExtendedPrice;
/*     */   private BigDecimal _originalBaseUnitPrice;
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.original_rtl_loc_id, t.original_wkstn_id, t.original_business_date, t.original_trans_seq, t.original_rtrans_lineitm_seq, t.reascode, t.notes, t.original_tax_amt, t.original_extended_amt, t.original_unit_amt, t.original_base_extended_amt, t.original_base_unit_amt FROM trl_correction_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  51 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  55 */     return "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.original_rtl_loc_id, t.original_wkstn_id, t.original_business_date, t.original_trans_seq, t.original_rtrans_lineitm_seq, t.reascode, t.notes, t.original_tax_amt, t.original_extended_amt, t.original_unit_amt, t.original_base_extended_amt, t.original_base_unit_amt FROM trl_correction_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  61 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   
/*  64 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_correction_mod(business_date, organization_id, rtl_loc_id, rtrans_lineitm_seq, trans_seq, wkstn_id, create_date, create_user_id, update_date, update_user_id, original_rtl_loc_id, original_wkstn_id, original_business_date, original_trans_seq, original_rtrans_lineitm_seq, reascode, notes, original_tax_amt, original_extended_amt, original_unit_amt, original_base_extended_amt, original_base_unit_amt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  67 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  71 */     Object[][] insertParameterObject = { { this._businessDate, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._originalRetailLocationId, this._originalWorkstationId, this._originalBusinessDate, this._originalTransactionSequence, this._originalRetailTransactionLineItemSequence, this._reasonCode, this._notes, this._originalTaxAmt, this._originalExtendedPrice, this._originalUnitPrice, this._originalBaseExtendedPrice, this._originalBaseUnitPrice } };
/*  72 */     return insertParameterObject;
/*     */   }
/*     */   
/*  75 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, -5, -5, 4, -5, -5, 91, 12, 91, 12, -5, -5, 91, -5, 4, 12, 12, 3, 3, 3, 3, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  78 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  81 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_correction_mod SET update_date = ?, update_user_id = ?, original_rtl_loc_id = ?, original_wkstn_id = ?, original_business_date = ?, original_trans_seq = ?, original_rtrans_lineitm_seq = ?, reascode = ?, notes = ?, original_tax_amt = ?, original_extended_amt = ?, original_unit_amt = ?, original_base_extended_amt = ?, original_base_unit_amt = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  84 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  88 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._originalRetailLocationId, this._originalWorkstationId, this._originalBusinessDate, this._originalTransactionSequence, this._originalRetailTransactionLineItemSequence, this._reasonCode, this._notes, this._originalTaxAmt, this._originalExtendedPrice, this._originalUnitPrice, this._originalBaseExtendedPrice, this._originalBaseUnitPrice } };
/*  89 */     return updateParameterObject;
/*     */   }
/*     */   
/*  92 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -5, -5, 91, -5, 4, 12, 12, 3, 3, 3, 3, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  94 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  97 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_correction_mod" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 100 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 106 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 109 */     return new Object[] { this._businessDate, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId };
/*     */   }
/*     */   
/* 112 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, -5, -5, 4, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 115 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 118 */     return "trl_correction_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 122 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 126 */     return new CorrectionModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class CorrectionModifierFiller
/*     */     implements IFiller {
/*     */     private CorrectionModifierDBA _parent;
/*     */     
/*     */     public CorrectionModifierFiller(CorrectionModifierDBA argParent) {
/* 134 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 138 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 139 */       if (t1 != null) {
/* 140 */         this._parent._businessDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 143 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 148 */       long l1 = argResultSet.getLong(2);
/* 149 */       if (l1 != 0L || argResultSet.getObject(2) != null) {
/* 150 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 156 */       l1 = argResultSet.getLong(3);
/* 157 */       if (l1 != 0L || argResultSet.getObject(3) != null) {
/* 158 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 164 */       int i = argResultSet.getInt(4);
/* 165 */       if (i != 0 || argResultSet.getObject(4) != null) {
/* 166 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 172 */       long primitiveResult = argResultSet.getLong(5);
/* 173 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 174 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 180 */       primitiveResult = argResultSet.getLong(6);
/* 181 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 182 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 187 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 188 */       if (t7 != null) {
/* 189 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 192 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 195 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 197 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 198 */       if (t9 != null) {
/* 199 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 202 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 205 */       this._parent._updateUserId = argResultSet.getString(10);
/*     */ 
/*     */       
/* 208 */       long l2 = argResultSet.getLong(11);
/* 209 */       if (l2 != 0L || argResultSet.getObject(11) != null) {
/* 210 */         this._parent._originalRetailLocationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 216 */       l2 = argResultSet.getLong(12);
/* 217 */       if (l2 != 0L || argResultSet.getObject(12) != null) {
/* 218 */         this._parent._originalWorkstationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 223 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 224 */       if (t13 != null) {
/* 225 */         this._parent._originalBusinessDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 228 */         this._parent._originalBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 233 */       long l3 = argResultSet.getLong(14);
/* 234 */       if (l3 != 0L || argResultSet.getObject(14) != null) {
/* 235 */         this._parent._originalTransactionSequence = Long.valueOf(l3);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 241 */       int j = argResultSet.getInt(15);
/* 242 */       if (j != 0 || argResultSet.getObject(15) != null) {
/* 243 */         this._parent._originalRetailTransactionLineItemSequence = Integer.valueOf(j);
/*     */       }
/*     */ 
/*     */       
/* 247 */       this._parent._reasonCode = argResultSet.getString(16);
/* 248 */       this._parent._notes = argResultSet.getString(17);
/* 249 */       this._parent._originalTaxAmt = argResultSet.getBigDecimal(18);
/* 250 */       this._parent._originalExtendedPrice = argResultSet.getBigDecimal(19);
/* 251 */       this._parent._originalUnitPrice = argResultSet.getBigDecimal(20);
/* 252 */       this._parent._originalBaseExtendedPrice = argResultSet.getBigDecimal(21);
/* 253 */       this._parent._originalBaseUnitPrice = argResultSet.getBigDecimal(22);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 258 */     argDAO.suppressStateChanges(true);
/* 259 */     CorrectionModifierDAO dao = (CorrectionModifierDAO)argDAO;
/* 260 */     dao.setBusinessDate(this._businessDate);
/* 261 */     dao.setOrganizationId(this._organizationId);
/* 262 */     dao.setRetailLocationId(this._retailLocationId);
/* 263 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 264 */     dao.setTransactionSequence(this._transactionSequence);
/* 265 */     dao.setWorkstationId(this._workstationId);
/* 266 */     dao.setCreateDate(this._createDate);
/* 267 */     dao.setCreateUserId(this._createUserId);
/* 268 */     dao.setUpdateDate(this._updateDate);
/* 269 */     dao.setUpdateUserId(this._updateUserId);
/* 270 */     dao.setOriginalRetailLocationId(this._originalRetailLocationId);
/* 271 */     dao.setOriginalWorkstationId(this._originalWorkstationId);
/* 272 */     dao.setOriginalBusinessDate(this._originalBusinessDate);
/* 273 */     dao.setOriginalTransactionSequence(this._originalTransactionSequence);
/* 274 */     dao.setOriginalRetailTransactionLineItemSequence(this._originalRetailTransactionLineItemSequence);
/* 275 */     dao.setReasonCode(this._reasonCode);
/* 276 */     dao.setNotes(this._notes);
/* 277 */     dao.setOriginalTaxAmt(this._originalTaxAmt);
/* 278 */     dao.setOriginalExtendedPrice(this._originalExtendedPrice);
/* 279 */     dao.setOriginalUnitPrice(this._originalUnitPrice);
/* 280 */     dao.setOriginalBaseExtendedPrice(this._originalBaseExtendedPrice);
/* 281 */     dao.setOriginalBaseUnitPrice(this._originalBaseUnitPrice);
/* 282 */     argDAO.suppressStateChanges(false);
/* 283 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 287 */     return loadDAO((IDataAccessObject)new CorrectionModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 291 */     CorrectionModifierDAO dao = (CorrectionModifierDAO)argDAO;
/* 292 */     this._businessDate = dao.getBusinessDate();
/* 293 */     this._organizationId = dao.getOrganizationId();
/* 294 */     this._retailLocationId = dao.getRetailLocationId();
/* 295 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 296 */     this._transactionSequence = dao.getTransactionSequence();
/* 297 */     this._workstationId = dao.getWorkstationId();
/* 298 */     this._createDate = dao.getCreateDate();
/* 299 */     this._createUserId = dao.getCreateUserId();
/* 300 */     this._updateDate = dao.getUpdateDate();
/* 301 */     this._updateUserId = dao.getUpdateUserId();
/* 302 */     this._originalRetailLocationId = dao.getOriginalRetailLocationId();
/* 303 */     this._originalWorkstationId = dao.getOriginalWorkstationId();
/* 304 */     this._originalBusinessDate = dao.getOriginalBusinessDate();
/* 305 */     this._originalTransactionSequence = dao.getOriginalTransactionSequence();
/* 306 */     this._originalRetailTransactionLineItemSequence = dao.getOriginalRetailTransactionLineItemSequence();
/* 307 */     this._reasonCode = dao.getReasonCode();
/* 308 */     this._notes = dao.getNotes();
/* 309 */     this._originalTaxAmt = dao.getOriginalTaxAmt();
/* 310 */     this._originalExtendedPrice = dao.getOriginalExtendedPrice();
/* 311 */     this._originalUnitPrice = dao.getOriginalUnitPrice();
/* 312 */     this._originalBaseExtendedPrice = dao.getOriginalBaseExtendedPrice();
/* 313 */     this._originalBaseUnitPrice = dao.getOriginalBaseUnitPrice();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 317 */     CorrectionModifierId id = (CorrectionModifierId)argId;
/* 318 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDate().getTime()));
/* 319 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 320 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 321 */     argStatement.setInt(4, id.getRetailTransactionLineItemSequence().intValue());
/* 322 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 323 */     argStatement.setLong(6, id.getWorkstationId().longValue());
/* 324 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 328 */     CorrectionModifierId id = new CorrectionModifierId();
/* 329 */     id.setBusinessDate(this._businessDate);
/* 330 */     id.setOrganizationId(this._organizationId);
/* 331 */     id.setRetailLocationId(this._retailLocationId);
/* 332 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 333 */     id.setTransactionSequence(this._transactionSequence);
/* 334 */     id.setWorkstationId(this._workstationId);
/* 335 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 343 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 347 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\CorrectionModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */