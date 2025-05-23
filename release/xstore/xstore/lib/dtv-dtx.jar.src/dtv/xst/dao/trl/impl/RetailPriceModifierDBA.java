/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailPriceModifierId;
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
/*     */ public class RetailPriceModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1985659613L;
/*     */   private Date _businessDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailPriceModifierSequenceNbr;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _amount;
/*     */   private BigDecimal _extendedAmount;
/*     */   private String _notes;
/*     */   private String _serialNumber;
/*     */   private BigDecimal _percent;
/*     */   private BigDecimal _priceChangeAmount;
/*     */   private String _priceChangeReasonCode;
/*     */   private String _promotionId;
/*     */   private String _description;
/*     */   private String _retailPriceModifierReasonCode;
/*     */   private Boolean _void;
/*     */   private Integer _discountGroupId;
/*     */   private String _dealId;
/*     */   private String _discountCode;
/*     */   private Date _discBusinessDate;
/*     */   private Long _discRetailLocationId;
/*     */   private Integer _discRetailTransactionLineItemSequence;
/*     */   private Long _discTransactionSequence;
/*     */   private Long _discWorkstationId;
/*     */   private String _discountReasonCode;
/*     */   private String _taxabilityCode;
/*     */   private BigDecimal _dealAmount;
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtl_price_mod_seq_nbr, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.extended_amt, t.notes, t.serial_number, t.percentage, t.price_change_amt, t.price_change_reascode, t.promotion_id, t.description, t.rtl_price_mod_reascode, t.void_flag, t.discount_group_id, t.deal_id, t.discount_code, t.disc_business_date, t.disc_rtl_loc_id, t.disc_rtrans_lineitm_seq, t.disc_trans_seq, t.disc_wkstn_id, t.discount_reascode, t.taxability_code, t.deal_amt FROM trl_rtl_price_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtl_price_mod_seq_nbr = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  62 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  66 */     return "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtl_price_mod_seq_nbr, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.extended_amt, t.notes, t.serial_number, t.percentage, t.price_change_amt, t.price_change_reascode, t.promotion_id, t.description, t.rtl_price_mod_reascode, t.void_flag, t.discount_group_id, t.deal_id, t.discount_code, t.disc_business_date, t.disc_rtl_loc_id, t.disc_rtrans_lineitm_seq, t.disc_trans_seq, t.disc_wkstn_id, t.discount_reascode, t.taxability_code, t.deal_amt FROM trl_rtl_price_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  72 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtl_price_mod_seq_nbr = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   
/*  75 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_rtl_price_mod(business_date, organization_id, rtl_loc_id, rtl_price_mod_seq_nbr, rtrans_lineitm_seq, trans_seq, wkstn_id, create_date, create_user_id, update_date, update_user_id, amt, extended_amt, notes, serial_number, percentage, price_change_amt, price_change_reascode, promotion_id, description, rtl_price_mod_reascode, void_flag, discount_group_id, deal_id, discount_code, disc_business_date, disc_rtl_loc_id, disc_rtrans_lineitm_seq, disc_trans_seq, disc_wkstn_id, discount_reascode, taxability_code, deal_amt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  78 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  82 */     Object[][] insertParameterObject = { { this._businessDate, this._organizationId, this._retailLocationId, this._retailPriceModifierSequenceNbr, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._amount, this._extendedAmount, this._notes, this._serialNumber, this._percent, this._priceChangeAmount, this._priceChangeReasonCode, this._promotionId, this._description, this._retailPriceModifierReasonCode, this._void, this._discountGroupId, this._dealId, this._discountCode, this._discBusinessDate, this._discRetailLocationId, this._discRetailTransactionLineItemSequence, this._discTransactionSequence, this._discWorkstationId, this._discountReasonCode, this._taxabilityCode, this._dealAmount } };
/*  83 */     return insertParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, -5, -5, 4, 4, -5, -5, 91, 12, 91, 12, 3, 3, 12, 12, 3, 3, 12, 12, 12, 12, -7, 4, 12, 12, 91, -5, 4, -5, -5, 12, 12, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  89 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_rtl_price_mod SET update_date = ?, update_user_id = ?, amt = ?, extended_amt = ?, notes = ?, serial_number = ?, percentage = ?, price_change_amt = ?, price_change_reascode = ?, promotion_id = ?, description = ?, rtl_price_mod_reascode = ?, void_flag = ?, discount_group_id = ?, deal_id = ?, discount_code = ?, disc_business_date = ?, disc_rtl_loc_id = ?, disc_rtrans_lineitm_seq = ?, disc_trans_seq = ?, disc_wkstn_id = ?, discount_reascode = ?, taxability_code = ?, deal_amt = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  95 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  99 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._amount, this._extendedAmount, this._notes, this._serialNumber, this._percent, this._priceChangeAmount, this._priceChangeReasonCode, this._promotionId, this._description, this._retailPriceModifierReasonCode, this._void, this._discountGroupId, this._dealId, this._discountCode, this._discBusinessDate, this._discRetailLocationId, this._discRetailTransactionLineItemSequence, this._discTransactionSequence, this._discWorkstationId, this._discountReasonCode, this._taxabilityCode, this._dealAmount } };
/* 100 */     return updateParameterObject;
/*     */   }
/*     */   
/* 103 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 3, 12, 12, 3, 3, 12, 12, 12, 12, -7, 4, 12, 12, 91, -5, 4, -5, -5, 12, 12, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 105 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 108 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_rtl_price_mod" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtl_price_mod_seq_nbr = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 111 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 117 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtl_price_mod_seq_nbr = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 120 */     return new Object[] { this._businessDate, this._organizationId, this._retailLocationId, this._retailPriceModifierSequenceNbr, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId };
/*     */   }
/*     */   
/* 123 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, -5, -5, 4, 4, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 126 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 129 */     return "trl_rtl_price_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 133 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 137 */     return new RetailPriceModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class RetailPriceModifierFiller
/*     */     implements IFiller {
/*     */     private RetailPriceModifierDBA _parent;
/*     */     
/*     */     public RetailPriceModifierFiller(RetailPriceModifierDBA argParent) {
/* 145 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 149 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 150 */       if (t1 != null) {
/* 151 */         this._parent._businessDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 159 */       long l1 = argResultSet.getLong(2);
/* 160 */       if (l1 != 0L || argResultSet.getObject(2) != null) {
/* 161 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 167 */       l1 = argResultSet.getLong(3);
/* 168 */       if (l1 != 0L || argResultSet.getObject(3) != null) {
/* 169 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 175 */       int i = argResultSet.getInt(4);
/* 176 */       if (i != 0 || argResultSet.getObject(4) != null) {
/* 177 */         this._parent._retailPriceModifierSequenceNbr = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 183 */       i = argResultSet.getInt(5);
/* 184 */       if (i != 0 || argResultSet.getObject(5) != null) {
/* 185 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 191 */       long primitiveResult = argResultSet.getLong(6);
/* 192 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 193 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 199 */       primitiveResult = argResultSet.getLong(7);
/* 200 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 201 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 206 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 207 */       if (t8 != null) {
/* 208 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 211 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 214 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 216 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 217 */       if (t10 != null) {
/* 218 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 221 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 224 */       this._parent._updateUserId = argResultSet.getString(11);
/* 225 */       this._parent._amount = argResultSet.getBigDecimal(12);
/* 226 */       this._parent._extendedAmount = argResultSet.getBigDecimal(13);
/* 227 */       this._parent._notes = argResultSet.getString(14);
/* 228 */       this._parent._serialNumber = argResultSet.getString(15);
/* 229 */       this._parent._percent = argResultSet.getBigDecimal(16);
/* 230 */       this._parent._priceChangeAmount = argResultSet.getBigDecimal(17);
/* 231 */       this._parent._priceChangeReasonCode = argResultSet.getString(18);
/* 232 */       this._parent._promotionId = argResultSet.getString(19);
/* 233 */       this._parent._description = argResultSet.getString(20);
/* 234 */       this._parent._retailPriceModifierReasonCode = argResultSet.getString(21);
/* 235 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(22));
/*     */ 
/*     */       
/* 238 */       int j = argResultSet.getInt(23);
/* 239 */       if (j != 0 || argResultSet.getObject(23) != null) {
/* 240 */         this._parent._discountGroupId = Integer.valueOf(j);
/*     */       }
/*     */ 
/*     */       
/* 244 */       this._parent._dealId = argResultSet.getString(24);
/* 245 */       this._parent._discountCode = argResultSet.getString(25);
/*     */       
/* 247 */       Timestamp t26 = argResultSet.getTimestamp(26);
/* 248 */       if (t26 != null) {
/* 249 */         this._parent._discBusinessDate = (Date)new DtvDate(t26.getTime());
/*     */       } else {
/*     */         
/* 252 */         this._parent._discBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 257 */       long l3 = argResultSet.getLong(27);
/* 258 */       if (l3 != 0L || argResultSet.getObject(27) != null) {
/* 259 */         this._parent._discRetailLocationId = Long.valueOf(l3);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 265 */       int k = argResultSet.getInt(28);
/* 266 */       if (k != 0 || argResultSet.getObject(28) != null) {
/* 267 */         this._parent._discRetailTransactionLineItemSequence = Integer.valueOf(k);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 273 */       long l2 = argResultSet.getLong(29);
/* 274 */       if (l2 != 0L || argResultSet.getObject(29) != null) {
/* 275 */         this._parent._discTransactionSequence = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 281 */       l2 = argResultSet.getLong(30);
/* 282 */       if (l2 != 0L || argResultSet.getObject(30) != null) {
/* 283 */         this._parent._discWorkstationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 287 */       this._parent._discountReasonCode = argResultSet.getString(31);
/* 288 */       this._parent._taxabilityCode = argResultSet.getString(32);
/* 289 */       this._parent._dealAmount = argResultSet.getBigDecimal(33);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 294 */     argDAO.suppressStateChanges(true);
/* 295 */     RetailPriceModifierDAO dao = (RetailPriceModifierDAO)argDAO;
/* 296 */     dao.setBusinessDate(this._businessDate);
/* 297 */     dao.setOrganizationId(this._organizationId);
/* 298 */     dao.setRetailLocationId(this._retailLocationId);
/* 299 */     dao.setRetailPriceModifierSequenceNbr(this._retailPriceModifierSequenceNbr);
/* 300 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 301 */     dao.setTransactionSequence(this._transactionSequence);
/* 302 */     dao.setWorkstationId(this._workstationId);
/* 303 */     dao.setCreateDate(this._createDate);
/* 304 */     dao.setCreateUserId(this._createUserId);
/* 305 */     dao.setUpdateDate(this._updateDate);
/* 306 */     dao.setUpdateUserId(this._updateUserId);
/* 307 */     dao.setAmount(this._amount);
/* 308 */     dao.setExtendedAmount(this._extendedAmount);
/* 309 */     dao.setNotes(this._notes);
/* 310 */     dao.setSerialNumber(this._serialNumber);
/* 311 */     dao.setPercent(this._percent);
/* 312 */     dao.setPriceChangeAmount(this._priceChangeAmount);
/* 313 */     dao.setPriceChangeReasonCode(this._priceChangeReasonCode);
/* 314 */     dao.setPromotionId(this._promotionId);
/* 315 */     dao.setDescription(this._description);
/* 316 */     dao.setRetailPriceModifierReasonCode(this._retailPriceModifierReasonCode);
/* 317 */     dao.setVoid(this._void);
/* 318 */     dao.setDiscountGroupId(this._discountGroupId);
/* 319 */     dao.setDealId(this._dealId);
/* 320 */     dao.setDiscountCode(this._discountCode);
/* 321 */     dao.setDiscBusinessDate(this._discBusinessDate);
/* 322 */     dao.setDiscRetailLocationId(this._discRetailLocationId);
/* 323 */     dao.setDiscRetailTransactionLineItemSequence(this._discRetailTransactionLineItemSequence);
/* 324 */     dao.setDiscTransactionSequence(this._discTransactionSequence);
/* 325 */     dao.setDiscWorkstationId(this._discWorkstationId);
/* 326 */     dao.setDiscountReasonCode(this._discountReasonCode);
/* 327 */     dao.setTaxabilityCode(this._taxabilityCode);
/* 328 */     dao.setDealAmount(this._dealAmount);
/* 329 */     argDAO.suppressStateChanges(false);
/* 330 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 334 */     return loadDAO((IDataAccessObject)new RetailPriceModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 338 */     RetailPriceModifierDAO dao = (RetailPriceModifierDAO)argDAO;
/* 339 */     this._businessDate = dao.getBusinessDate();
/* 340 */     this._organizationId = dao.getOrganizationId();
/* 341 */     this._retailLocationId = dao.getRetailLocationId();
/* 342 */     this._retailPriceModifierSequenceNbr = dao.getRetailPriceModifierSequenceNbr();
/* 343 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 344 */     this._transactionSequence = dao.getTransactionSequence();
/* 345 */     this._workstationId = dao.getWorkstationId();
/* 346 */     this._createDate = dao.getCreateDate();
/* 347 */     this._createUserId = dao.getCreateUserId();
/* 348 */     this._updateDate = dao.getUpdateDate();
/* 349 */     this._updateUserId = dao.getUpdateUserId();
/* 350 */     this._amount = dao.getAmount();
/* 351 */     this._extendedAmount = dao.getExtendedAmount();
/* 352 */     this._notes = dao.getNotes();
/* 353 */     this._serialNumber = dao.getSerialNumber();
/* 354 */     this._percent = dao.getPercent();
/* 355 */     this._priceChangeAmount = dao.getPriceChangeAmount();
/* 356 */     this._priceChangeReasonCode = dao.getPriceChangeReasonCode();
/* 357 */     this._promotionId = dao.getPromotionId();
/* 358 */     this._description = dao.getDescription();
/* 359 */     this._retailPriceModifierReasonCode = dao.getRetailPriceModifierReasonCode();
/* 360 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/* 361 */     this._discountGroupId = dao.getDiscountGroupId();
/* 362 */     this._dealId = dao.getDealId();
/* 363 */     this._discountCode = dao.getDiscountCode();
/* 364 */     this._discBusinessDate = dao.getDiscBusinessDate();
/* 365 */     this._discRetailLocationId = dao.getDiscRetailLocationId();
/* 366 */     this._discRetailTransactionLineItemSequence = dao.getDiscRetailTransactionLineItemSequence();
/* 367 */     this._discTransactionSequence = dao.getDiscTransactionSequence();
/* 368 */     this._discWorkstationId = dao.getDiscWorkstationId();
/* 369 */     this._discountReasonCode = dao.getDiscountReasonCode();
/* 370 */     this._taxabilityCode = dao.getTaxabilityCode();
/* 371 */     this._dealAmount = dao.getDealAmount();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 375 */     RetailPriceModifierId id = (RetailPriceModifierId)argId;
/* 376 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDate().getTime()));
/* 377 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 378 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 379 */     argStatement.setInt(4, id.getRetailPriceModifierSequenceNbr().intValue());
/* 380 */     argStatement.setInt(5, id.getRetailTransactionLineItemSequence().intValue());
/* 381 */     argStatement.setLong(6, id.getTransactionSequence().longValue());
/* 382 */     argStatement.setLong(7, id.getWorkstationId().longValue());
/* 383 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 387 */     RetailPriceModifierId id = new RetailPriceModifierId();
/* 388 */     id.setBusinessDate(this._businessDate);
/* 389 */     id.setOrganizationId(this._organizationId);
/* 390 */     id.setRetailLocationId(this._retailLocationId);
/* 391 */     id.setRetailPriceModifierSequenceNbr(this._retailPriceModifierSequenceNbr);
/* 392 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 393 */     id.setTransactionSequence(this._transactionSequence);
/* 394 */     id.setWorkstationId(this._workstationId);
/* 395 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 403 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 407 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailPriceModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */