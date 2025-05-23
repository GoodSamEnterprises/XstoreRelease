/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.WarrantyId;
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
/*     */ public class WarrantyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 566191388L;
/*     */   private Long _organizationId;
/*     */   private String _warrantyNbr;
/*     */   private String _warrantyTypeCode;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
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
/*     */   private Date _coveredItemPurchaseDate;
/*     */   private BigDecimal _coveredItemPurchasePrice;
/*     */   private String _coveredItemPurchaseLocation;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.warranty_nbr, t.warranty_typcode, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.warranty_plan_id, t.warranty_issue_date, t.warranty_expiration_date, t.status_code, t.purchase_price, t.cust_id, t.party_id, t.certificate_nbr, t.certificate_company_name, t.warranty_item_id, t.warranty_line_business_date, t.warranty_line_rtl_loc_id, t.warranty_line_wkstn_id, t.warranty_line_trans_seq, t.warranty_rtrans_lineitm_seq, t.covered_item_id, t.covered_line_business_date, t.covered_line_rtl_loc_id, t.covered_line_wkstn_id, t.covered_line_trans_seq, t.covered_rtrans_lineitm_seq, t.covered_item_purchase_date, t.covered_item_purchase_price, t.covered_item_purchase_location FROM itm_warranty t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND warranty_nbr = ?  AND warranty_typcode = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  60 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  64 */     return "SELECT t.organization_id, t.warranty_nbr, t.warranty_typcode, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.warranty_plan_id, t.warranty_issue_date, t.warranty_expiration_date, t.status_code, t.purchase_price, t.cust_id, t.party_id, t.certificate_nbr, t.certificate_company_name, t.warranty_item_id, t.warranty_line_business_date, t.warranty_line_rtl_loc_id, t.warranty_line_wkstn_id, t.warranty_line_trans_seq, t.warranty_rtrans_lineitm_seq, t.covered_item_id, t.covered_line_business_date, t.covered_line_rtl_loc_id, t.covered_line_wkstn_id, t.covered_line_trans_seq, t.covered_rtrans_lineitm_seq, t.covered_item_purchase_date, t.covered_item_purchase_price, t.covered_item_purchase_location FROM itm_warranty t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  70 */     return " WHERE organization_id = ?  AND warranty_nbr = ?  AND warranty_typcode = ?  ";
/*     */   }
/*     */   
/*  73 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_warranty(organization_id, warranty_nbr, warranty_typcode, create_date, create_user_id, update_date, update_user_id, warranty_plan_id, warranty_issue_date, warranty_expiration_date, status_code, purchase_price, cust_id, party_id, certificate_nbr, certificate_company_name, warranty_item_id, warranty_line_business_date, warranty_line_rtl_loc_id, warranty_line_wkstn_id, warranty_line_trans_seq, warranty_rtrans_lineitm_seq, covered_item_id, covered_line_business_date, covered_line_rtl_loc_id, covered_line_wkstn_id, covered_line_trans_seq, covered_rtrans_lineitm_seq, covered_item_purchase_date, covered_item_purchase_price, covered_item_purchase_location) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  76 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  80 */     Object[][] insertParameterObject = { { this._organizationId, this._warrantyNbr, this._warrantyTypeCode, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._warrantyPlanId, this._warrantyIssueDate, this._warrantyExpirationDate, this._statusCode, this._purchasePrice, this._customerId, this._partyId, this._certificateNbr, this._certificateCompanyName, this._warrantyItemId, this._warrantyLineBusinessDate, this._warrantyLineRtlLocId, this._warrantyLineWkstnId, this._warrantyLineTransSeq, this._warrantyLineTransLineItemSeq, this._coveredItemId, this._coveredLineBusinessDate, this._coveredLineRtlLocId, this._coveredLineWkstnId, this._coveredLineTransSeq, this._coveredLineTransLineItemSeq, this._coveredItemPurchaseDate, this._coveredItemPurchasePrice, this._coveredItemPurchaseLocation } };
/*  81 */     return insertParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 12, 91, 91, 12, 3, 12, -5, 12, 12, 12, 91, -5, -5, -5, 4, 12, 91, -5, -5, -5, 4, 91, 3, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  87 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_warranty SET update_date = ?, update_user_id = ?, warranty_plan_id = ?, warranty_issue_date = ?, warranty_expiration_date = ?, status_code = ?, purchase_price = ?, cust_id = ?, party_id = ?, certificate_nbr = ?, certificate_company_name = ?, warranty_item_id = ?, warranty_line_business_date = ?, warranty_line_rtl_loc_id = ?, warranty_line_wkstn_id = ?, warranty_line_trans_seq = ?, warranty_rtrans_lineitm_seq = ?, covered_item_id = ?, covered_line_business_date = ?, covered_line_rtl_loc_id = ?, covered_line_wkstn_id = ?, covered_line_trans_seq = ?, covered_rtrans_lineitm_seq = ?, covered_item_purchase_date = ?, covered_item_purchase_price = ?, covered_item_purchase_location = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  93 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  97 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._warrantyPlanId, this._warrantyIssueDate, this._warrantyExpirationDate, this._statusCode, this._purchasePrice, this._customerId, this._partyId, this._certificateNbr, this._certificateCompanyName, this._warrantyItemId, this._warrantyLineBusinessDate, this._warrantyLineRtlLocId, this._warrantyLineWkstnId, this._warrantyLineTransSeq, this._warrantyLineTransLineItemSeq, this._coveredItemId, this._coveredLineBusinessDate, this._coveredLineRtlLocId, this._coveredLineWkstnId, this._coveredLineTransSeq, this._coveredLineTransLineItemSeq, this._coveredItemPurchaseDate, this._coveredItemPurchasePrice, this._coveredItemPurchaseLocation } };
/*  98 */     return updateParameterObject;
/*     */   }
/*     */   
/* 101 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 91, 91, 12, 3, 12, -5, 12, 12, 12, 91, -5, -5, -5, 4, 12, 91, -5, -5, -5, 4, 91, 3, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 103 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 106 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_warranty" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND warranty_nbr = ?  AND warranty_typcode = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 109 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 115 */     return " WHERE organization_id = ?  AND warranty_nbr = ?  AND warranty_typcode = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 118 */     return new Object[] { this._organizationId, this._warrantyNbr, this._warrantyTypeCode };
/*     */   }
/*     */   
/* 121 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 124 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 127 */     return "itm_warranty";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 131 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 135 */     return new WarrantyFiller(this);
/*     */   }
/*     */   
/*     */   private static class WarrantyFiller
/*     */     implements IFiller {
/*     */     private WarrantyDBA _parent;
/*     */     
/*     */     public WarrantyFiller(WarrantyDBA argParent) {
/* 143 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 148 */       long primitiveResult = argResultSet.getLong(1);
/* 149 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 150 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 154 */       this._parent._warrantyNbr = argResultSet.getString(2);
/* 155 */       this._parent._warrantyTypeCode = argResultSet.getString(3);
/*     */       
/* 157 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 158 */       if (t4 != null) {
/* 159 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 162 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 165 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 167 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 168 */       if (t6 != null) {
/* 169 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 172 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 175 */       this._parent._updateUserId = argResultSet.getString(7);
/* 176 */       this._parent._warrantyPlanId = argResultSet.getString(8);
/*     */       
/* 178 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 179 */       if (t9 != null) {
/* 180 */         this._parent._warrantyIssueDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 183 */         this._parent._warrantyIssueDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 187 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 188 */       if (t10 != null) {
/* 189 */         this._parent._warrantyExpirationDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 192 */         this._parent._warrantyExpirationDate = null;
/*     */       } 
/*     */       
/* 195 */       this._parent._statusCode = argResultSet.getString(11);
/* 196 */       this._parent._purchasePrice = argResultSet.getBigDecimal(12);
/* 197 */       this._parent._customerId = argResultSet.getString(13);
/*     */ 
/*     */       
/* 200 */       long l1 = argResultSet.getLong(14);
/* 201 */       if (l1 != 0L || argResultSet.getObject(14) != null) {
/* 202 */         this._parent._partyId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 206 */       this._parent._certificateNbr = argResultSet.getString(15);
/* 207 */       this._parent._certificateCompanyName = argResultSet.getString(16);
/* 208 */       this._parent._warrantyItemId = argResultSet.getString(17);
/*     */       
/* 210 */       Timestamp t18 = argResultSet.getTimestamp(18);
/* 211 */       if (t18 != null) {
/* 212 */         this._parent._warrantyLineBusinessDate = (Date)new DtvDate(t18.getTime());
/*     */       } else {
/*     */         
/* 215 */         this._parent._warrantyLineBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 220 */       long l2 = argResultSet.getLong(19);
/* 221 */       if (l2 != 0L || argResultSet.getObject(19) != null) {
/* 222 */         this._parent._warrantyLineRtlLocId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 228 */       l2 = argResultSet.getLong(20);
/* 229 */       if (l2 != 0L || argResultSet.getObject(20) != null) {
/* 230 */         this._parent._warrantyLineWkstnId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 236 */       l2 = argResultSet.getLong(21);
/* 237 */       if (l2 != 0L || argResultSet.getObject(21) != null) {
/* 238 */         this._parent._warrantyLineTransSeq = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 244 */       int i = argResultSet.getInt(22);
/* 245 */       if (i != 0 || argResultSet.getObject(22) != null) {
/* 246 */         this._parent._warrantyLineTransLineItemSeq = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 250 */       this._parent._coveredItemId = argResultSet.getString(23);
/*     */       
/* 252 */       Timestamp t24 = argResultSet.getTimestamp(24);
/* 253 */       if (t24 != null) {
/* 254 */         this._parent._coveredLineBusinessDate = (Date)new DtvDate(t24.getTime());
/*     */       } else {
/*     */         
/* 257 */         this._parent._coveredLineBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 262 */       long l3 = argResultSet.getLong(25);
/* 263 */       if (l3 != 0L || argResultSet.getObject(25) != null) {
/* 264 */         this._parent._coveredLineRtlLocId = Long.valueOf(l3);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 270 */       l3 = argResultSet.getLong(26);
/* 271 */       if (l3 != 0L || argResultSet.getObject(26) != null) {
/* 272 */         this._parent._coveredLineWkstnId = Long.valueOf(l3);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 278 */       l3 = argResultSet.getLong(27);
/* 279 */       if (l3 != 0L || argResultSet.getObject(27) != null) {
/* 280 */         this._parent._coveredLineTransSeq = Long.valueOf(l3);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 286 */       int j = argResultSet.getInt(28);
/* 287 */       if (j != 0 || argResultSet.getObject(28) != null) {
/* 288 */         this._parent._coveredLineTransLineItemSeq = Integer.valueOf(j);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 293 */       Timestamp t29 = argResultSet.getTimestamp(29);
/* 294 */       if (t29 != null) {
/* 295 */         this._parent._coveredItemPurchaseDate = (Date)new DtvDate(t29.getTime());
/*     */       } else {
/*     */         
/* 298 */         this._parent._coveredItemPurchaseDate = null;
/*     */       } 
/*     */       
/* 301 */       this._parent._coveredItemPurchasePrice = argResultSet.getBigDecimal(30);
/* 302 */       this._parent._coveredItemPurchaseLocation = argResultSet.getString(31);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 307 */     argDAO.suppressStateChanges(true);
/* 308 */     WarrantyDAO dao = (WarrantyDAO)argDAO;
/* 309 */     dao.setOrganizationId(this._organizationId);
/* 310 */     dao.setWarrantyNbr(this._warrantyNbr);
/* 311 */     dao.setWarrantyTypeCode(this._warrantyTypeCode);
/* 312 */     dao.setCreateDate(this._createDate);
/* 313 */     dao.setCreateUserId(this._createUserId);
/* 314 */     dao.setUpdateDate(this._updateDate);
/* 315 */     dao.setUpdateUserId(this._updateUserId);
/* 316 */     dao.setWarrantyPlanId(this._warrantyPlanId);
/* 317 */     dao.setWarrantyIssueDate(this._warrantyIssueDate);
/* 318 */     dao.setWarrantyExpirationDate(this._warrantyExpirationDate);
/* 319 */     dao.setStatusCode(this._statusCode);
/* 320 */     dao.setPurchasePrice(this._purchasePrice);
/* 321 */     dao.setCustomerId(this._customerId);
/* 322 */     dao.setPartyId(this._partyId);
/* 323 */     dao.setCertificateNbr(this._certificateNbr);
/* 324 */     dao.setCertificateCompanyName(this._certificateCompanyName);
/* 325 */     dao.setWarrantyItemId(this._warrantyItemId);
/* 326 */     dao.setWarrantyLineBusinessDate(this._warrantyLineBusinessDate);
/* 327 */     dao.setWarrantyLineRtlLocId(this._warrantyLineRtlLocId);
/* 328 */     dao.setWarrantyLineWkstnId(this._warrantyLineWkstnId);
/* 329 */     dao.setWarrantyLineTransSeq(this._warrantyLineTransSeq);
/* 330 */     dao.setWarrantyLineTransLineItemSeq(this._warrantyLineTransLineItemSeq);
/* 331 */     dao.setCoveredItemId(this._coveredItemId);
/* 332 */     dao.setCoveredLineBusinessDate(this._coveredLineBusinessDate);
/* 333 */     dao.setCoveredLineRtlLocId(this._coveredLineRtlLocId);
/* 334 */     dao.setCoveredLineWkstnId(this._coveredLineWkstnId);
/* 335 */     dao.setCoveredLineTransSeq(this._coveredLineTransSeq);
/* 336 */     dao.setCoveredLineTransLineItemSeq(this._coveredLineTransLineItemSeq);
/* 337 */     dao.setCoveredItemPurchaseDate(this._coveredItemPurchaseDate);
/* 338 */     dao.setCoveredItemPurchasePrice(this._coveredItemPurchasePrice);
/* 339 */     dao.setCoveredItemPurchaseLocation(this._coveredItemPurchaseLocation);
/* 340 */     argDAO.suppressStateChanges(false);
/* 341 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 345 */     return loadDAO((IDataAccessObject)new WarrantyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 349 */     WarrantyDAO dao = (WarrantyDAO)argDAO;
/* 350 */     this._organizationId = dao.getOrganizationId();
/* 351 */     this._warrantyNbr = dao.getWarrantyNbr();
/* 352 */     this._warrantyTypeCode = dao.getWarrantyTypeCode();
/* 353 */     this._createDate = dao.getCreateDate();
/* 354 */     this._createUserId = dao.getCreateUserId();
/* 355 */     this._updateDate = dao.getUpdateDate();
/* 356 */     this._updateUserId = dao.getUpdateUserId();
/* 357 */     this._warrantyPlanId = dao.getWarrantyPlanId();
/* 358 */     this._warrantyIssueDate = dao.getWarrantyIssueDate();
/* 359 */     this._warrantyExpirationDate = dao.getWarrantyExpirationDate();
/* 360 */     this._statusCode = dao.getStatusCode();
/* 361 */     this._purchasePrice = dao.getPurchasePrice();
/* 362 */     this._customerId = dao.getCustomerId();
/* 363 */     this._partyId = dao.getPartyId();
/* 364 */     this._certificateNbr = dao.getCertificateNbr();
/* 365 */     this._certificateCompanyName = dao.getCertificateCompanyName();
/* 366 */     this._warrantyItemId = dao.getWarrantyItemId();
/* 367 */     this._warrantyLineBusinessDate = dao.getWarrantyLineBusinessDate();
/* 368 */     this._warrantyLineRtlLocId = dao.getWarrantyLineRtlLocId();
/* 369 */     this._warrantyLineWkstnId = dao.getWarrantyLineWkstnId();
/* 370 */     this._warrantyLineTransSeq = dao.getWarrantyLineTransSeq();
/* 371 */     this._warrantyLineTransLineItemSeq = dao.getWarrantyLineTransLineItemSeq();
/* 372 */     this._coveredItemId = dao.getCoveredItemId();
/* 373 */     this._coveredLineBusinessDate = dao.getCoveredLineBusinessDate();
/* 374 */     this._coveredLineRtlLocId = dao.getCoveredLineRtlLocId();
/* 375 */     this._coveredLineWkstnId = dao.getCoveredLineWkstnId();
/* 376 */     this._coveredLineTransSeq = dao.getCoveredLineTransSeq();
/* 377 */     this._coveredLineTransLineItemSeq = dao.getCoveredLineTransLineItemSeq();
/* 378 */     this._coveredItemPurchaseDate = dao.getCoveredItemPurchaseDate();
/* 379 */     this._coveredItemPurchasePrice = dao.getCoveredItemPurchasePrice();
/* 380 */     this._coveredItemPurchaseLocation = dao.getCoveredItemPurchaseLocation();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 384 */     WarrantyId id = (WarrantyId)argId;
/* 385 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 386 */     argStatement.setString(2, id.getWarrantyNbr());
/* 387 */     argStatement.setString(3, id.getWarrantyTypeCode());
/* 388 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 392 */     WarrantyId id = new WarrantyId();
/* 393 */     id.setOrganizationId(this._organizationId);
/* 394 */     id.setWarrantyNbr(this._warrantyNbr);
/* 395 */     id.setWarrantyTypeCode(this._warrantyTypeCode);
/* 396 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 404 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 408 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\WarrantyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */