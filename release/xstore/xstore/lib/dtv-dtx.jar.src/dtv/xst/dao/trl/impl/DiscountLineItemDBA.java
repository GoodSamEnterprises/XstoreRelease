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
/*     */ public class DiscountLineItemDBA
/*     */   extends RetailTransactionLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1289146792L;
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
/*     */   private BigDecimal _amount;
/*     */   private BigDecimal _percent;
/*     */   private BigDecimal _newPrice;
/*     */   private BigDecimal _newPriceQuantity;
/*     */   private String _serialNumber;
/*     */   private String _discountCode;
/*     */   private String _taxabilityCode;
/*     */   private String _awardTransactionId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.percentage, t.new_price, t.new_price_quantity, t.serial_number, t.discount_code, t.taxability_code, t.award_trans_id FROM trl_discount_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  48 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  52 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.percentage, t.new_price, t.new_price_quantity, t.serial_number, t.discount_code, t.taxability_code, t.award_trans_id FROM trl_discount_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  59 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  62 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_discount_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, amt, percentage, new_price, new_price_quantity, serial_number, discount_code, taxability_code, award_trans_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  66 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  71 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._amount, this._percent, this._newPrice, this._newPriceQuantity, this._serialNumber, this._discountCode, this._taxabilityCode, this._awardTransactionId } };
/*  72 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  75 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 3, 3, 3, 3, 12, 12, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  79 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  82 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_discount_lineitm SET update_date = ?, update_user_id = ?, amt = ?, percentage = ?, new_price = ?, new_price_quantity = ?, serial_number = ?, discount_code = ?, taxability_code = ?, award_trans_id = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  86 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  91 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._amount, this._percent, this._newPrice, this._newPriceQuantity, this._serialNumber, this._discountCode, this._taxabilityCode, this._awardTransactionId } };
/*  92 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  95 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 3, 3, 3, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  98 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/* 101 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_discount_lineitm" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 105 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 112 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 116 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 119 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 123 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 127 */     return "trl_discount_lineitm";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 132 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 136 */     return new DiscountLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class DiscountLineItemFiller
/*     */     implements IFiller {
/*     */     private DiscountLineItemDBA _parent;
/*     */     
/*     */     public DiscountLineItemFiller(DiscountLineItemDBA argParent) {
/* 144 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 149 */       long primitiveResult = argResultSet.getLong(1);
/* 150 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 151 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 157 */       primitiveResult = argResultSet.getLong(2);
/* 158 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 159 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 164 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 165 */       if (t3 != null) {
/* 166 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 169 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 174 */       long l1 = argResultSet.getLong(4);
/* 175 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 176 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 182 */       l1 = argResultSet.getLong(5);
/* 183 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 184 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 190 */       int i = argResultSet.getInt(6);
/* 191 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 192 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 197 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 198 */       if (t7 != null) {
/* 199 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 202 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 205 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 207 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 208 */       if (t9 != null) {
/* 209 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 212 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 215 */       this._parent._updateUserId = argResultSet.getString(10);
/* 216 */       this._parent._amount = argResultSet.getBigDecimal(11);
/* 217 */       this._parent._percent = argResultSet.getBigDecimal(12);
/* 218 */       this._parent._newPrice = argResultSet.getBigDecimal(13);
/* 219 */       this._parent._newPriceQuantity = argResultSet.getBigDecimal(14);
/* 220 */       this._parent._serialNumber = argResultSet.getString(15);
/* 221 */       this._parent._discountCode = argResultSet.getString(16);
/* 222 */       this._parent._taxabilityCode = argResultSet.getString(17);
/* 223 */       this._parent._awardTransactionId = argResultSet.getString(18);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 229 */     super.loadDAO(argDAO);
/* 230 */     argDAO.suppressStateChanges(true);
/* 231 */     DiscountLineItemDAO dao = (DiscountLineItemDAO)argDAO;
/* 232 */     dao.setOrganizationId(this._organizationId);
/* 233 */     dao.setRetailLocationId(this._retailLocationId);
/* 234 */     dao.setBusinessDate(this._businessDate);
/* 235 */     dao.setWorkstationId(this._workstationId);
/* 236 */     dao.setTransactionSequence(this._transactionSequence);
/* 237 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 238 */     dao.setCreateDate(this._createDate);
/* 239 */     dao.setCreateUserId(this._createUserId);
/* 240 */     dao.setUpdateDate(this._updateDate);
/* 241 */     dao.setUpdateUserId(this._updateUserId);
/* 242 */     dao.setAmount(this._amount);
/* 243 */     dao.setPercent(this._percent);
/* 244 */     dao.setNewPrice(this._newPrice);
/* 245 */     dao.setNewPriceQuantity(this._newPriceQuantity);
/* 246 */     dao.setSerialNumber(this._serialNumber);
/* 247 */     dao.setDiscountCode(this._discountCode);
/* 248 */     dao.setTaxabilityCode(this._taxabilityCode);
/* 249 */     dao.setAwardTransactionId(this._awardTransactionId);
/* 250 */     argDAO.suppressStateChanges(false);
/* 251 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 256 */     return loadDAO((IDataAccessObject)new DiscountLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 261 */     DiscountLineItemDAO dao = (DiscountLineItemDAO)argDAO;
/* 262 */     super.fill((IDataAccessObject)dao);
/* 263 */     this._organizationId = dao.getOrganizationId();
/* 264 */     this._retailLocationId = dao.getRetailLocationId();
/* 265 */     this._businessDate = dao.getBusinessDate();
/* 266 */     this._workstationId = dao.getWorkstationId();
/* 267 */     this._transactionSequence = dao.getTransactionSequence();
/* 268 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 269 */     this._createDate = dao.getCreateDate();
/* 270 */     this._createUserId = dao.getCreateUserId();
/* 271 */     this._updateDate = dao.getUpdateDate();
/* 272 */     this._updateUserId = dao.getUpdateUserId();
/* 273 */     this._amount = dao.getAmount();
/* 274 */     this._percent = dao.getPercent();
/* 275 */     this._newPrice = dao.getNewPrice();
/* 276 */     this._newPriceQuantity = dao.getNewPriceQuantity();
/* 277 */     this._serialNumber = dao.getSerialNumber();
/* 278 */     this._discountCode = dao.getDiscountCode();
/* 279 */     this._taxabilityCode = dao.getTaxabilityCode();
/* 280 */     this._awardTransactionId = dao.getAwardTransactionId();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 285 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 286 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 287 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 288 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 289 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 290 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 291 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 292 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 296 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 300 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\DiscountLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */