/*     */ package dtv.xst.dao.ttr.impl;
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
/*     */ public class CouponTenderLineItemDBA
/*     */   extends TenderLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1207671295L;
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
/*     */   private String _couponTypeCode;
/*     */   private Date _expirationDate;
/*     */   private Boolean _keyEntered;
/*     */   private String _manufacturerFamilyCode;
/*     */   private String _manufacturerId;
/*     */   private String _promotionCode;
/*     */   private String _scanCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.typcode, t.expr_date, t.key_entered_flag, t.manufacturer_family_code, t.manufacturer_id, t.promotion_code, t.scan_code FROM ttr_coupon_tndr_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  47 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  51 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.typcode, t.expr_date, t.key_entered_flag, t.manufacturer_family_code, t.manufacturer_id, t.promotion_code, t.scan_code FROM ttr_coupon_tndr_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  58 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  61 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ttr_coupon_tndr_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, typcode, expr_date, key_entered_flag, manufacturer_family_code, manufacturer_id, promotion_code, scan_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  65 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  70 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._couponTypeCode, this._expirationDate, this._keyEntered, this._manufacturerFamilyCode, this._manufacturerId, this._promotionCode, this._scanCode } };
/*  71 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  74 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 12, 91, -7, 12, 12, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  78 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  81 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ttr_coupon_tndr_lineitm SET update_date = ?, update_user_id = ?, typcode = ?, expr_date = ?, key_entered_flag = ?, manufacturer_family_code = ?, manufacturer_id = ?, promotion_code = ?, scan_code = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  85 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  90 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._couponTypeCode, this._expirationDate, this._keyEntered, this._manufacturerFamilyCode, this._manufacturerId, this._promotionCode, this._scanCode } };
/*  91 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  94 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 91, -7, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  97 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/* 100 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ttr_coupon_tndr_lineitm" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 104 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 111 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 115 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 118 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 122 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 126 */     return "ttr_coupon_tndr_lineitm";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 131 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 135 */     return new CouponTenderLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class CouponTenderLineItemFiller
/*     */     implements IFiller {
/*     */     private CouponTenderLineItemDBA _parent;
/*     */     
/*     */     public CouponTenderLineItemFiller(CouponTenderLineItemDBA argParent) {
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
/*     */ 
/*     */       
/* 156 */       primitiveResult = argResultSet.getLong(2);
/* 157 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 158 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 163 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 164 */       if (t3 != null) {
/* 165 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 168 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 173 */       long l1 = argResultSet.getLong(4);
/* 174 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 175 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 181 */       l1 = argResultSet.getLong(5);
/* 182 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 183 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 189 */       int i = argResultSet.getInt(6);
/* 190 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 191 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 196 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 197 */       if (t7 != null) {
/* 198 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 201 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 204 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 206 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 207 */       if (t9 != null) {
/* 208 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 211 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 214 */       this._parent._updateUserId = argResultSet.getString(10);
/* 215 */       this._parent._couponTypeCode = argResultSet.getString(11);
/*     */       
/* 217 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 218 */       if (t12 != null) {
/* 219 */         this._parent._expirationDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 222 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 225 */       this._parent._keyEntered = Boolean.valueOf(argResultSet.getBoolean(13));
/* 226 */       this._parent._manufacturerFamilyCode = argResultSet.getString(14);
/* 227 */       this._parent._manufacturerId = argResultSet.getString(15);
/* 228 */       this._parent._promotionCode = argResultSet.getString(16);
/* 229 */       this._parent._scanCode = argResultSet.getString(17);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 235 */     super.loadDAO(argDAO);
/* 236 */     argDAO.suppressStateChanges(true);
/* 237 */     CouponTenderLineItemDAO dao = (CouponTenderLineItemDAO)argDAO;
/* 238 */     dao.setOrganizationId(this._organizationId);
/* 239 */     dao.setRetailLocationId(this._retailLocationId);
/* 240 */     dao.setBusinessDate(this._businessDate);
/* 241 */     dao.setWorkstationId(this._workstationId);
/* 242 */     dao.setTransactionSequence(this._transactionSequence);
/* 243 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 244 */     dao.setCreateDate(this._createDate);
/* 245 */     dao.setCreateUserId(this._createUserId);
/* 246 */     dao.setUpdateDate(this._updateDate);
/* 247 */     dao.setUpdateUserId(this._updateUserId);
/* 248 */     dao.setCouponTypeCode(this._couponTypeCode);
/* 249 */     dao.setExpirationDate(this._expirationDate);
/* 250 */     dao.setKeyEntered(this._keyEntered);
/* 251 */     dao.setManufacturerFamilyCode(this._manufacturerFamilyCode);
/* 252 */     dao.setManufacturerId(this._manufacturerId);
/* 253 */     dao.setPromotionCode(this._promotionCode);
/* 254 */     dao.setScanCode(this._scanCode);
/* 255 */     argDAO.suppressStateChanges(false);
/* 256 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 261 */     return loadDAO((IDataAccessObject)new CouponTenderLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 266 */     CouponTenderLineItemDAO dao = (CouponTenderLineItemDAO)argDAO;
/* 267 */     super.fill((IDataAccessObject)dao);
/* 268 */     this._organizationId = dao.getOrganizationId();
/* 269 */     this._retailLocationId = dao.getRetailLocationId();
/* 270 */     this._businessDate = dao.getBusinessDate();
/* 271 */     this._workstationId = dao.getWorkstationId();
/* 272 */     this._transactionSequence = dao.getTransactionSequence();
/* 273 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 274 */     this._createDate = dao.getCreateDate();
/* 275 */     this._createUserId = dao.getCreateUserId();
/* 276 */     this._updateDate = dao.getUpdateDate();
/* 277 */     this._updateUserId = dao.getUpdateUserId();
/* 278 */     this._couponTypeCode = dao.getCouponTypeCode();
/* 279 */     this._expirationDate = dao.getExpirationDate();
/* 280 */     this._keyEntered = (dao.getKeyEntered() != null) ? dao.getKeyEntered() : Boolean.valueOf(false);
/* 281 */     this._manufacturerFamilyCode = dao.getManufacturerFamilyCode();
/* 282 */     this._manufacturerId = dao.getManufacturerId();
/* 283 */     this._promotionCode = dao.getPromotionCode();
/* 284 */     this._scanCode = dao.getScanCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 289 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 290 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 291 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 292 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 293 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 294 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 295 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 296 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 300 */     String[] sels = super.getAllSelects();
/* 301 */     String[] result = new String[sels.length + 1];
/* 302 */     result[0] = getSelectImpl();
/* 303 */     System.arraycopy(sels, 0, result, 1, sels.length);
/* 304 */     return result;
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 308 */     IFiller[] fills = super.getAllFillers();
/* 309 */     IFiller[] result = new IFiller[fills.length + 1];
/* 310 */     result[0] = getFillerImpl();
/* 311 */     System.arraycopy(fills, 0, result, 1, fills.length);
/* 312 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\CouponTenderLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */