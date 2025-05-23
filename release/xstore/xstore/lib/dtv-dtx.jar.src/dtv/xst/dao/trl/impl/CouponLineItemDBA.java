/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailTransactionLineItemId;
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
/*     */ public class CouponLineItemDBA
/*     */   extends RetailTransactionLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 470353805L;
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
/*     */   private String _couponId;
/*     */   private String _couponTypeCode;
/*     */   private Date _expirationDate;
/*     */   private String _entryMethodCode;
/*     */   private String _manufacturerId;
/*     */   private String _valueCode;
/*     */   private BigDecimal _amountEntered;
/*     */   private String _manufacturerFamilyCode;
/*     */   private Boolean _serialized;
/*     */   private Boolean _authorized;
/*     */   private String _redemptionTransId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.coupon_id, t.typcode, t.expr_date, t.entry_mthd_code, t.manufacturer_id, t.value_code, t.amt_entered, t.manufacturer_family_code, t.serialized_flag, t.authorized_flag, t.redemption_trans_id FROM trl_coupon_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  51 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  55 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.coupon_id, t.typcode, t.expr_date, t.entry_mthd_code, t.manufacturer_id, t.value_code, t.amt_entered, t.manufacturer_family_code, t.serialized_flag, t.authorized_flag, t.redemption_trans_id FROM trl_coupon_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  62 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  65 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_coupon_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, coupon_id, typcode, expr_date, entry_mthd_code, manufacturer_id, value_code, amt_entered, manufacturer_family_code, serialized_flag, authorized_flag, redemption_trans_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  69 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  74 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._couponId, this._couponTypeCode, this._expirationDate, this._entryMethodCode, this._manufacturerId, this._valueCode, this._amountEntered, this._manufacturerFamilyCode, this._serialized, this._authorized, this._redemptionTransId } };
/*  75 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  78 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 12, 12, 91, 12, 12, 12, 3, 12, -7, -7, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  82 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  85 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_coupon_lineitm SET update_date = ?, update_user_id = ?, coupon_id = ?, typcode = ?, expr_date = ?, entry_mthd_code = ?, manufacturer_id = ?, value_code = ?, amt_entered = ?, manufacturer_family_code = ?, serialized_flag = ?, authorized_flag = ?, redemption_trans_id = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  89 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  94 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._couponId, this._couponTypeCode, this._expirationDate, this._entryMethodCode, this._manufacturerId, this._valueCode, this._amountEntered, this._manufacturerFamilyCode, this._serialized, this._authorized, this._redemptionTransId } };
/*  95 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  98 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 91, 12, 12, 12, 3, 12, -7, -7, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/* 101 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/* 104 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_coupon_lineitm" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 108 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 115 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 119 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 122 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 126 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 130 */     return "trl_coupon_lineitm";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 135 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 139 */     return new CouponLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class CouponLineItemFiller
/*     */     implements IFiller {
/*     */     private CouponLineItemDBA _parent;
/*     */     
/*     */     public CouponLineItemFiller(CouponLineItemDBA argParent) {
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
/*     */ 
/*     */       
/* 160 */       primitiveResult = argResultSet.getLong(2);
/* 161 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 162 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 167 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 168 */       if (t3 != null) {
/* 169 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 172 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 177 */       long l1 = argResultSet.getLong(4);
/* 178 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 179 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 185 */       l1 = argResultSet.getLong(5);
/* 186 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 187 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 193 */       int i = argResultSet.getInt(6);
/* 194 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 195 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 200 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 201 */       if (t7 != null) {
/* 202 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 205 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 208 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 210 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 211 */       if (t9 != null) {
/* 212 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 215 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 218 */       this._parent._updateUserId = argResultSet.getString(10);
/* 219 */       this._parent._couponId = argResultSet.getString(11);
/* 220 */       this._parent._couponTypeCode = argResultSet.getString(12);
/*     */       
/* 222 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 223 */       if (t13 != null) {
/* 224 */         this._parent._expirationDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 227 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 230 */       this._parent._entryMethodCode = argResultSet.getString(14);
/* 231 */       this._parent._manufacturerId = argResultSet.getString(15);
/* 232 */       this._parent._valueCode = argResultSet.getString(16);
/* 233 */       this._parent._amountEntered = argResultSet.getBigDecimal(17);
/* 234 */       this._parent._manufacturerFamilyCode = argResultSet.getString(18);
/* 235 */       this._parent._serialized = Boolean.valueOf(argResultSet.getBoolean(19));
/* 236 */       this._parent._authorized = Boolean.valueOf(argResultSet.getBoolean(20));
/* 237 */       this._parent._redemptionTransId = argResultSet.getString(21);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 243 */     super.loadDAO(argDAO);
/* 244 */     argDAO.suppressStateChanges(true);
/* 245 */     CouponLineItemDAO dao = (CouponLineItemDAO)argDAO;
/* 246 */     dao.setOrganizationId(this._organizationId);
/* 247 */     dao.setRetailLocationId(this._retailLocationId);
/* 248 */     dao.setBusinessDate(this._businessDate);
/* 249 */     dao.setWorkstationId(this._workstationId);
/* 250 */     dao.setTransactionSequence(this._transactionSequence);
/* 251 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 252 */     dao.setCreateDate(this._createDate);
/* 253 */     dao.setCreateUserId(this._createUserId);
/* 254 */     dao.setUpdateDate(this._updateDate);
/* 255 */     dao.setUpdateUserId(this._updateUserId);
/* 256 */     dao.setCouponId(this._couponId);
/* 257 */     dao.setCouponTypeCode(this._couponTypeCode);
/* 258 */     dao.setExpirationDate(this._expirationDate);
/* 259 */     dao.setEntryMethodCode(this._entryMethodCode);
/* 260 */     dao.setManufacturerId(this._manufacturerId);
/* 261 */     dao.setValueCode(this._valueCode);
/* 262 */     dao.setAmountEntered(this._amountEntered);
/* 263 */     dao.setManufacturerFamilyCode(this._manufacturerFamilyCode);
/* 264 */     dao.setSerialized(this._serialized);
/* 265 */     dao.setAuthorized(this._authorized);
/* 266 */     dao.setRedemptionTransId(this._redemptionTransId);
/* 267 */     argDAO.suppressStateChanges(false);
/* 268 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 273 */     return loadDAO((IDataAccessObject)new CouponLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 278 */     CouponLineItemDAO dao = (CouponLineItemDAO)argDAO;
/* 279 */     super.fill((IDataAccessObject)dao);
/* 280 */     this._organizationId = dao.getOrganizationId();
/* 281 */     this._retailLocationId = dao.getRetailLocationId();
/* 282 */     this._businessDate = dao.getBusinessDate();
/* 283 */     this._workstationId = dao.getWorkstationId();
/* 284 */     this._transactionSequence = dao.getTransactionSequence();
/* 285 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 286 */     this._createDate = dao.getCreateDate();
/* 287 */     this._createUserId = dao.getCreateUserId();
/* 288 */     this._updateDate = dao.getUpdateDate();
/* 289 */     this._updateUserId = dao.getUpdateUserId();
/* 290 */     this._couponId = dao.getCouponId();
/* 291 */     this._couponTypeCode = dao.getCouponTypeCode();
/* 292 */     this._expirationDate = dao.getExpirationDate();
/* 293 */     this._entryMethodCode = dao.getEntryMethodCode();
/* 294 */     this._manufacturerId = dao.getManufacturerId();
/* 295 */     this._valueCode = dao.getValueCode();
/* 296 */     this._amountEntered = dao.getAmountEntered();
/* 297 */     this._manufacturerFamilyCode = dao.getManufacturerFamilyCode();
/* 298 */     this._serialized = (dao.getSerialized() != null) ? dao.getSerialized() : Boolean.valueOf(false);
/* 299 */     this._authorized = (dao.getAuthorized() != null) ? dao.getAuthorized() : Boolean.valueOf(false);
/* 300 */     this._redemptionTransId = dao.getRedemptionTransId();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 305 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 306 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 307 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 308 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 309 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 310 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 311 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\CouponLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */