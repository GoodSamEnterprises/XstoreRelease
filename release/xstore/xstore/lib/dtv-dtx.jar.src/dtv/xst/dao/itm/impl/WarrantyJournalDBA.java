/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.WarrantyJournalId;
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
/*     */ public class WarrantyJournalDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 2069047931L;
/*     */   private Long _organizationId;
/*     */   private String _warrantyNbr;
/*     */   private String _warrantyTypeCode;
/*     */   private Long _journalSequence;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _transBusinessDate;
/*     */   private Long _transRtlLocId;
/*     */   private Long _transWkstnId;
/*     */   private Long _transTransSeq;
/*     */   private String _warrantyPlanId;
/*     */   private Date _warrantyIssueDate;
/*     */   private Date _warrantyExpirationDate;
/*     */   private String _statusCode;
/*     */   private BigDecimal _purchasePrice;
/*     */   private String _customerId;
/*     */   private Long _partyId;
/*     */   private String _certificateNbr;
/*     */   private String _certificateCompanyName;
/*     */   private String _warrantyItemId;
/*     */   private Date _warrantyLineBusinessDate;
/*     */   private Long _warrantyLineRtlLocId;
/*     */   private Long _warrantyLineWkstnId;
/*     */   private Long _warrantyLineTransSeq;
/*     */   private Integer _warrantyLineTransLineItemSeq;
/*     */   private String _coveredItemId;
/*     */   private Date _coveredLineBusinessDate;
/*     */   private Long _coveredLineRtlLocId;
/*     */   private Long _coveredLineWkstnId;
/*     */   private Long _coveredLineTransSeq;
/*     */   private Integer _coveredLineTransLineItemSeq;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.warranty_nbr, t.warranty_typcode, t.journal_seq, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.trans_business_date, t.trans_rtl_loc_id, t.trans_wkstn_id, t.trans_trans_seq, t.warranty_plan_id, t.warranty_issue_date, t.warranty_expiration_date, t.status_code, t.purchase_price, t.cust_id, t.party_id, t.certificate_nbr, t.certificate_company_name, t.warranty_item_id, t.warranty_line_business_date, t.warranty_line_rtl_loc_id, t.warranty_line_wkstn_id, t.warranty_line_trans_seq, t.warranty_rtrans_lineitm_seq, t.covered_item_id, t.covered_line_business_date, t.covered_line_rtl_loc_id, t.covered_line_wkstn_id, t.covered_line_trans_seq, t.covered_rtrans_lineitm_seq FROM itm_warranty_journal t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND warranty_nbr = ?  AND warranty_typcode = ?  AND journal_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  64 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  68 */     return "SELECT t.organization_id, t.warranty_nbr, t.warranty_typcode, t.journal_seq, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.trans_business_date, t.trans_rtl_loc_id, t.trans_wkstn_id, t.trans_trans_seq, t.warranty_plan_id, t.warranty_issue_date, t.warranty_expiration_date, t.status_code, t.purchase_price, t.cust_id, t.party_id, t.certificate_nbr, t.certificate_company_name, t.warranty_item_id, t.warranty_line_business_date, t.warranty_line_rtl_loc_id, t.warranty_line_wkstn_id, t.warranty_line_trans_seq, t.warranty_rtrans_lineitm_seq, t.covered_item_id, t.covered_line_business_date, t.covered_line_rtl_loc_id, t.covered_line_wkstn_id, t.covered_line_trans_seq, t.covered_rtrans_lineitm_seq FROM itm_warranty_journal t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  74 */     return " WHERE organization_id = ?  AND warranty_nbr = ?  AND warranty_typcode = ?  AND journal_seq = ?  ";
/*     */   }
/*     */   
/*  77 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_warranty_journal(organization_id, warranty_nbr, warranty_typcode, journal_seq, org_code, org_value, create_date, create_user_id, update_date, update_user_id, trans_business_date, trans_rtl_loc_id, trans_wkstn_id, trans_trans_seq, warranty_plan_id, warranty_issue_date, warranty_expiration_date, status_code, purchase_price, cust_id, party_id, certificate_nbr, certificate_company_name, warranty_item_id, warranty_line_business_date, warranty_line_rtl_loc_id, warranty_line_wkstn_id, warranty_line_trans_seq, warranty_rtrans_lineitm_seq, covered_item_id, covered_line_business_date, covered_line_rtl_loc_id, covered_line_wkstn_id, covered_line_trans_seq, covered_rtrans_lineitm_seq) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  80 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  84 */     Object[][] insertParameterObject = { { this._organizationId, this._warrantyNbr, this._warrantyTypeCode, this._journalSequence, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._transBusinessDate, this._transRtlLocId, this._transWkstnId, this._transTransSeq, this._warrantyPlanId, this._warrantyIssueDate, this._warrantyExpirationDate, this._statusCode, this._purchasePrice, this._customerId, this._partyId, this._certificateNbr, this._certificateCompanyName, this._warrantyItemId, this._warrantyLineBusinessDate, this._warrantyLineRtlLocId, this._warrantyLineWkstnId, this._warrantyLineTransSeq, this._warrantyLineTransLineItemSeq, this._coveredItemId, this._coveredLineBusinessDate, this._coveredLineRtlLocId, this._coveredLineWkstnId, this._coveredLineTransSeq, this._coveredLineTransLineItemSeq } };
/*  85 */     return insertParameterObject;
/*     */   }
/*     */   
/*  88 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, -5, 12, 12, 91, 12, 91, 12, 91, -5, -5, -5, 12, 91, 91, 12, 3, 12, -5, 12, 12, 12, 91, -5, -5, -5, 4, 12, 91, -5, -5, -5, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  91 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  94 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_warranty_journal SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, trans_business_date = ?, trans_rtl_loc_id = ?, trans_wkstn_id = ?, trans_trans_seq = ?, warranty_plan_id = ?, warranty_issue_date = ?, warranty_expiration_date = ?, status_code = ?, purchase_price = ?, cust_id = ?, party_id = ?, certificate_nbr = ?, certificate_company_name = ?, warranty_item_id = ?, warranty_line_business_date = ?, warranty_line_rtl_loc_id = ?, warranty_line_wkstn_id = ?, warranty_line_trans_seq = ?, warranty_rtrans_lineitm_seq = ?, covered_item_id = ?, covered_line_business_date = ?, covered_line_rtl_loc_id = ?, covered_line_wkstn_id = ?, covered_line_trans_seq = ?, covered_rtrans_lineitm_seq = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  97 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/* 101 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._transBusinessDate, this._transRtlLocId, this._transWkstnId, this._transTransSeq, this._warrantyPlanId, this._warrantyIssueDate, this._warrantyExpirationDate, this._statusCode, this._purchasePrice, this._customerId, this._partyId, this._certificateNbr, this._certificateCompanyName, this._warrantyItemId, this._warrantyLineBusinessDate, this._warrantyLineRtlLocId, this._warrantyLineWkstnId, this._warrantyLineTransSeq, this._warrantyLineTransLineItemSeq, this._coveredItemId, this._coveredLineBusinessDate, this._coveredLineRtlLocId, this._coveredLineWkstnId, this._coveredLineTransSeq, this._coveredLineTransLineItemSeq } };
/* 102 */     return updateParameterObject;
/*     */   }
/*     */   
/* 105 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 91, -5, -5, -5, 12, 91, 91, 12, 3, 12, -5, 12, 12, 12, 91, -5, -5, -5, 4, 12, 91, -5, -5, -5, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 107 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 110 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_warranty_journal" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND warranty_nbr = ?  AND warranty_typcode = ?  AND journal_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 113 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 119 */     return " WHERE organization_id = ?  AND warranty_nbr = ?  AND warranty_typcode = ?  AND journal_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 122 */     return new Object[] { this._organizationId, this._warrantyNbr, this._warrantyTypeCode, this._journalSequence };
/*     */   }
/*     */   
/* 125 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 128 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 131 */     return "itm_warranty_journal";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 135 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 139 */     return new WarrantyJournalFiller(this);
/*     */   }
/*     */   
/*     */   private static class WarrantyJournalFiller
/*     */     implements IFiller {
/*     */     private WarrantyJournalDBA _parent;
/*     */     
/*     */     public WarrantyJournalFiller(WarrantyJournalDBA argParent) {
/* 147 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 152 */       long primitiveResult = argResultSet.getLong(1);
/* 153 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 154 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 158 */       this._parent._warrantyNbr = argResultSet.getString(2);
/* 159 */       this._parent._warrantyTypeCode = argResultSet.getString(3);
/*     */ 
/*     */       
/* 162 */       primitiveResult = argResultSet.getLong(4);
/* 163 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 164 */         this._parent._journalSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 168 */       this._parent._orgCode = argResultSet.getString(5);
/* 169 */       this._parent._orgValue = argResultSet.getString(6);
/*     */       
/* 171 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 172 */       if (t7 != null) {
/* 173 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 176 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 179 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 181 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 182 */       if (t9 != null) {
/* 183 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 186 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 189 */       this._parent._updateUserId = argResultSet.getString(10);
/*     */       
/* 191 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 192 */       if (t11 != null) {
/* 193 */         this._parent._transBusinessDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 196 */         this._parent._transBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 201 */       long l1 = argResultSet.getLong(12);
/* 202 */       if (l1 != 0L || argResultSet.getObject(12) != null) {
/* 203 */         this._parent._transRtlLocId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 209 */       l1 = argResultSet.getLong(13);
/* 210 */       if (l1 != 0L || argResultSet.getObject(13) != null) {
/* 211 */         this._parent._transWkstnId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 217 */       l1 = argResultSet.getLong(14);
/* 218 */       if (l1 != 0L || argResultSet.getObject(14) != null) {
/* 219 */         this._parent._transTransSeq = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 223 */       this._parent._warrantyPlanId = argResultSet.getString(15);
/*     */       
/* 225 */       Timestamp t16 = argResultSet.getTimestamp(16);
/* 226 */       if (t16 != null) {
/* 227 */         this._parent._warrantyIssueDate = (Date)new DtvDate(t16.getTime());
/*     */       } else {
/*     */         
/* 230 */         this._parent._warrantyIssueDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 234 */       Timestamp t17 = argResultSet.getTimestamp(17);
/* 235 */       if (t17 != null) {
/* 236 */         this._parent._warrantyExpirationDate = (Date)new DtvDate(t17.getTime());
/*     */       } else {
/*     */         
/* 239 */         this._parent._warrantyExpirationDate = null;
/*     */       } 
/*     */       
/* 242 */       this._parent._statusCode = argResultSet.getString(18);
/* 243 */       this._parent._purchasePrice = argResultSet.getBigDecimal(19);
/* 244 */       this._parent._customerId = argResultSet.getString(20);
/*     */ 
/*     */       
/* 247 */       long l2 = argResultSet.getLong(21);
/* 248 */       if (l2 != 0L || argResultSet.getObject(21) != null) {
/* 249 */         this._parent._partyId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 253 */       this._parent._certificateNbr = argResultSet.getString(22);
/* 254 */       this._parent._certificateCompanyName = argResultSet.getString(23);
/* 255 */       this._parent._warrantyItemId = argResultSet.getString(24);
/*     */       
/* 257 */       Timestamp t25 = argResultSet.getTimestamp(25);
/* 258 */       if (t25 != null) {
/* 259 */         this._parent._warrantyLineBusinessDate = (Date)new DtvDate(t25.getTime());
/*     */       } else {
/*     */         
/* 262 */         this._parent._warrantyLineBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 267 */       long l3 = argResultSet.getLong(26);
/* 268 */       if (l3 != 0L || argResultSet.getObject(26) != null) {
/* 269 */         this._parent._warrantyLineRtlLocId = Long.valueOf(l3);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 275 */       l3 = argResultSet.getLong(27);
/* 276 */       if (l3 != 0L || argResultSet.getObject(27) != null) {
/* 277 */         this._parent._warrantyLineWkstnId = Long.valueOf(l3);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 283 */       l3 = argResultSet.getLong(28);
/* 284 */       if (l3 != 0L || argResultSet.getObject(28) != null) {
/* 285 */         this._parent._warrantyLineTransSeq = Long.valueOf(l3);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 291 */       int i = argResultSet.getInt(29);
/* 292 */       if (i != 0 || argResultSet.getObject(29) != null) {
/* 293 */         this._parent._warrantyLineTransLineItemSeq = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 297 */       this._parent._coveredItemId = argResultSet.getString(30);
/*     */       
/* 299 */       Timestamp t31 = argResultSet.getTimestamp(31);
/* 300 */       if (t31 != null) {
/* 301 */         this._parent._coveredLineBusinessDate = (Date)new DtvDate(t31.getTime());
/*     */       } else {
/*     */         
/* 304 */         this._parent._coveredLineBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 309 */       long l4 = argResultSet.getLong(32);
/* 310 */       if (l4 != 0L || argResultSet.getObject(32) != null) {
/* 311 */         this._parent._coveredLineRtlLocId = Long.valueOf(l4);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 317 */       l4 = argResultSet.getLong(33);
/* 318 */       if (l4 != 0L || argResultSet.getObject(33) != null) {
/* 319 */         this._parent._coveredLineWkstnId = Long.valueOf(l4);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 325 */       l4 = argResultSet.getLong(34);
/* 326 */       if (l4 != 0L || argResultSet.getObject(34) != null) {
/* 327 */         this._parent._coveredLineTransSeq = Long.valueOf(l4);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 333 */       int j = argResultSet.getInt(35);
/* 334 */       if (j != 0 || argResultSet.getObject(35) != null) {
/* 335 */         this._parent._coveredLineTransLineItemSeq = Integer.valueOf(j);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 343 */     argDAO.suppressStateChanges(true);
/* 344 */     WarrantyJournalDAO dao = (WarrantyJournalDAO)argDAO;
/* 345 */     dao.setOrganizationId(this._organizationId);
/* 346 */     dao.setWarrantyNbr(this._warrantyNbr);
/* 347 */     dao.setWarrantyTypeCode(this._warrantyTypeCode);
/* 348 */     dao.setJournalSequence(this._journalSequence);
/* 349 */     dao.setOrgCode(this._orgCode);
/* 350 */     dao.setOrgValue(this._orgValue);
/* 351 */     dao.setCreateDate(this._createDate);
/* 352 */     dao.setCreateUserId(this._createUserId);
/* 353 */     dao.setUpdateDate(this._updateDate);
/* 354 */     dao.setUpdateUserId(this._updateUserId);
/* 355 */     dao.setTransBusinessDate(this._transBusinessDate);
/* 356 */     dao.setTransRtlLocId(this._transRtlLocId);
/* 357 */     dao.setTransWkstnId(this._transWkstnId);
/* 358 */     dao.setTransTransSeq(this._transTransSeq);
/* 359 */     dao.setWarrantyPlanId(this._warrantyPlanId);
/* 360 */     dao.setWarrantyIssueDate(this._warrantyIssueDate);
/* 361 */     dao.setWarrantyExpirationDate(this._warrantyExpirationDate);
/* 362 */     dao.setStatusCode(this._statusCode);
/* 363 */     dao.setPurchasePrice(this._purchasePrice);
/* 364 */     dao.setCustomerId(this._customerId);
/* 365 */     dao.setPartyId(this._partyId);
/* 366 */     dao.setCertificateNbr(this._certificateNbr);
/* 367 */     dao.setCertificateCompanyName(this._certificateCompanyName);
/* 368 */     dao.setWarrantyItemId(this._warrantyItemId);
/* 369 */     dao.setWarrantyLineBusinessDate(this._warrantyLineBusinessDate);
/* 370 */     dao.setWarrantyLineRtlLocId(this._warrantyLineRtlLocId);
/* 371 */     dao.setWarrantyLineWkstnId(this._warrantyLineWkstnId);
/* 372 */     dao.setWarrantyLineTransSeq(this._warrantyLineTransSeq);
/* 373 */     dao.setWarrantyLineTransLineItemSeq(this._warrantyLineTransLineItemSeq);
/* 374 */     dao.setCoveredItemId(this._coveredItemId);
/* 375 */     dao.setCoveredLineBusinessDate(this._coveredLineBusinessDate);
/* 376 */     dao.setCoveredLineRtlLocId(this._coveredLineRtlLocId);
/* 377 */     dao.setCoveredLineWkstnId(this._coveredLineWkstnId);
/* 378 */     dao.setCoveredLineTransSeq(this._coveredLineTransSeq);
/* 379 */     dao.setCoveredLineTransLineItemSeq(this._coveredLineTransLineItemSeq);
/* 380 */     argDAO.suppressStateChanges(false);
/* 381 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 385 */     return loadDAO((IDataAccessObject)new WarrantyJournalDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 389 */     WarrantyJournalDAO dao = (WarrantyJournalDAO)argDAO;
/* 390 */     this._organizationId = dao.getOrganizationId();
/* 391 */     this._warrantyNbr = dao.getWarrantyNbr();
/* 392 */     this._warrantyTypeCode = dao.getWarrantyTypeCode();
/* 393 */     this._journalSequence = dao.getJournalSequence();
/* 394 */     this._orgCode = dao.getOrgCode();
/* 395 */     this._orgValue = dao.getOrgValue();
/* 396 */     this._createDate = dao.getCreateDate();
/* 397 */     this._createUserId = dao.getCreateUserId();
/* 398 */     this._updateDate = dao.getUpdateDate();
/* 399 */     this._updateUserId = dao.getUpdateUserId();
/* 400 */     this._transBusinessDate = dao.getTransBusinessDate();
/* 401 */     this._transRtlLocId = dao.getTransRtlLocId();
/* 402 */     this._transWkstnId = dao.getTransWkstnId();
/* 403 */     this._transTransSeq = dao.getTransTransSeq();
/* 404 */     this._warrantyPlanId = dao.getWarrantyPlanId();
/* 405 */     this._warrantyIssueDate = dao.getWarrantyIssueDate();
/* 406 */     this._warrantyExpirationDate = dao.getWarrantyExpirationDate();
/* 407 */     this._statusCode = dao.getStatusCode();
/* 408 */     this._purchasePrice = dao.getPurchasePrice();
/* 409 */     this._customerId = dao.getCustomerId();
/* 410 */     this._partyId = dao.getPartyId();
/* 411 */     this._certificateNbr = dao.getCertificateNbr();
/* 412 */     this._certificateCompanyName = dao.getCertificateCompanyName();
/* 413 */     this._warrantyItemId = dao.getWarrantyItemId();
/* 414 */     this._warrantyLineBusinessDate = dao.getWarrantyLineBusinessDate();
/* 415 */     this._warrantyLineRtlLocId = dao.getWarrantyLineRtlLocId();
/* 416 */     this._warrantyLineWkstnId = dao.getWarrantyLineWkstnId();
/* 417 */     this._warrantyLineTransSeq = dao.getWarrantyLineTransSeq();
/* 418 */     this._warrantyLineTransLineItemSeq = dao.getWarrantyLineTransLineItemSeq();
/* 419 */     this._coveredItemId = dao.getCoveredItemId();
/* 420 */     this._coveredLineBusinessDate = dao.getCoveredLineBusinessDate();
/* 421 */     this._coveredLineRtlLocId = dao.getCoveredLineRtlLocId();
/* 422 */     this._coveredLineWkstnId = dao.getCoveredLineWkstnId();
/* 423 */     this._coveredLineTransSeq = dao.getCoveredLineTransSeq();
/* 424 */     this._coveredLineTransLineItemSeq = dao.getCoveredLineTransLineItemSeq();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 428 */     WarrantyJournalId id = (WarrantyJournalId)argId;
/* 429 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 430 */     argStatement.setString(2, id.getWarrantyNbr());
/* 431 */     argStatement.setString(3, id.getWarrantyTypeCode());
/* 432 */     argStatement.setLong(4, id.getJournalSequence().longValue());
/* 433 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 437 */     WarrantyJournalId id = new WarrantyJournalId();
/* 438 */     id.setOrganizationId(this._organizationId);
/* 439 */     id.setWarrantyNbr(this._warrantyNbr);
/* 440 */     id.setWarrantyTypeCode(this._warrantyTypeCode);
/* 441 */     id.setJournalSequence(this._journalSequence);
/* 442 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 450 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 454 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\WarrantyJournalDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */