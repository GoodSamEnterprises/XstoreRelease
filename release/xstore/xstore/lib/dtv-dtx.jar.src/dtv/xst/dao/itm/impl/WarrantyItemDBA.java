/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemId;
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
/*     */ public class WarrantyItemDBA
/*     */   extends NonPhysicalItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1154324913L;
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _pricingMethodCode;
/*     */   private BigDecimal _warrantyPriceAmt;
/*     */   private BigDecimal _warrantyPricePercentage;
/*     */   private BigDecimal _warrantyMinPriceAmt;
/*     */   private Long _expirationDays;
/*     */   private Long _serviceDays;
/*     */   private Boolean _renewable;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.pricing_mthd_code, t.warranty_price_amt, t.warranty_price_percentage, t.warranty_min_price_amt, t.expiration_days, t.service_days, t.renewable_flag FROM itm_warranty_item t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.pricing_mthd_code, t.warranty_price_amt, t.warranty_price_percentage, t.warranty_min_price_amt, t.expiration_days, t.service_days, t.renewable_flag FROM itm_warranty_item t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_warranty_item(organization_id, item_id, create_date, create_user_id, update_date, update_user_id, pricing_mthd_code, warranty_price_amt, warranty_price_percentage, warranty_min_price_amt, expiration_days, service_days, renewable_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._organizationId, this._itemId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._pricingMethodCode, this._warrantyPriceAmt, this._warrantyPricePercentage, this._warrantyMinPriceAmt, this._expirationDays, this._serviceDays, this._renewable } };
/*  67 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 3, 3, 3, -5, -5, -7 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  74 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  77 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_warranty_item SET update_date = ?, update_user_id = ?, pricing_mthd_code = ?, warranty_price_amt = ?, warranty_price_percentage = ?, warranty_min_price_amt = ?, expiration_days = ?, service_days = ?, renewable_flag = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  81 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  86 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._pricingMethodCode, this._warrantyPriceAmt, this._warrantyPricePercentage, this._warrantyMinPriceAmt, this._expirationDays, this._serviceDays, this._renewable } };
/*  87 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  90 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 3, 3, 3, -5, -5, -7 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  93 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/*  96 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_warranty_item" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 100 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 107 */     return " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 111 */     return new Object[] { this._organizationId, this._itemId };
/*     */   }
/*     */   
/* 114 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 118 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 122 */     return "itm_warranty_item";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 127 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 131 */     return new WarrantyItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class WarrantyItemFiller
/*     */     implements IFiller {
/*     */     private WarrantyItemDBA _parent;
/*     */     
/*     */     public WarrantyItemFiller(WarrantyItemDBA argParent) {
/* 139 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 144 */       long primitiveResult = argResultSet.getLong(1);
/* 145 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 146 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 150 */       this._parent._itemId = argResultSet.getString(2);
/*     */       
/* 152 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 153 */       if (t3 != null) {
/* 154 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 162 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 163 */       if (t5 != null) {
/* 164 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 167 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 170 */       this._parent._updateUserId = argResultSet.getString(6);
/* 171 */       this._parent._pricingMethodCode = argResultSet.getString(7);
/* 172 */       this._parent._warrantyPriceAmt = argResultSet.getBigDecimal(8);
/* 173 */       this._parent._warrantyPricePercentage = argResultSet.getBigDecimal(9);
/* 174 */       this._parent._warrantyMinPriceAmt = argResultSet.getBigDecimal(10);
/*     */ 
/*     */       
/* 177 */       long l1 = argResultSet.getLong(11);
/* 178 */       if (l1 != 0L || argResultSet.getObject(11) != null) {
/* 179 */         this._parent._expirationDays = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 185 */       l1 = argResultSet.getLong(12);
/* 186 */       if (l1 != 0L || argResultSet.getObject(12) != null) {
/* 187 */         this._parent._serviceDays = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 191 */       this._parent._renewable = Boolean.valueOf(argResultSet.getBoolean(13));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 197 */     super.loadDAO(argDAO);
/* 198 */     argDAO.suppressStateChanges(true);
/* 199 */     WarrantyItemDAO dao = (WarrantyItemDAO)argDAO;
/* 200 */     dao.setOrganizationId(this._organizationId);
/* 201 */     dao.setItemId(this._itemId);
/* 202 */     dao.setCreateDate(this._createDate);
/* 203 */     dao.setCreateUserId(this._createUserId);
/* 204 */     dao.setUpdateDate(this._updateDate);
/* 205 */     dao.setUpdateUserId(this._updateUserId);
/* 206 */     dao.setPricingMethodCode(this._pricingMethodCode);
/* 207 */     dao.setWarrantyPriceAmt(this._warrantyPriceAmt);
/* 208 */     dao.setWarrantyPricePercentage(this._warrantyPricePercentage);
/* 209 */     dao.setWarrantyMinPriceAmt(this._warrantyMinPriceAmt);
/* 210 */     dao.setExpirationDays(this._expirationDays);
/* 211 */     dao.setServiceDays(this._serviceDays);
/* 212 */     dao.setRenewable(this._renewable);
/* 213 */     argDAO.suppressStateChanges(false);
/* 214 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 219 */     return loadDAO((IDataAccessObject)new WarrantyItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 224 */     WarrantyItemDAO dao = (WarrantyItemDAO)argDAO;
/* 225 */     super.fill((IDataAccessObject)dao);
/* 226 */     this._organizationId = dao.getOrganizationId();
/* 227 */     this._itemId = dao.getItemId();
/* 228 */     this._createDate = dao.getCreateDate();
/* 229 */     this._createUserId = dao.getCreateUserId();
/* 230 */     this._updateDate = dao.getUpdateDate();
/* 231 */     this._updateUserId = dao.getUpdateUserId();
/* 232 */     this._pricingMethodCode = dao.getPricingMethodCode();
/* 233 */     this._warrantyPriceAmt = dao.getWarrantyPriceAmt();
/* 234 */     this._warrantyPricePercentage = dao.getWarrantyPricePercentage();
/* 235 */     this._warrantyMinPriceAmt = dao.getWarrantyMinPriceAmt();
/* 236 */     this._expirationDays = dao.getExpirationDays();
/* 237 */     this._serviceDays = dao.getServiceDays();
/* 238 */     this._renewable = (dao.getRenewable() != null) ? dao.getRenewable() : Boolean.valueOf(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 243 */     ItemId id = (ItemId)argId;
/* 244 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 245 */     argStatement.setString(2, id.getItemId());
/* 246 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 250 */     String[] sels = super.getAllSelects();
/* 251 */     String[] result = new String[sels.length + 1];
/* 252 */     result[0] = getSelectImpl();
/* 253 */     System.arraycopy(sels, 0, result, 1, sels.length);
/* 254 */     return result;
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 258 */     IFiller[] fills = super.getAllFillers();
/* 259 */     IFiller[] result = new IFiller[fills.length + 1];
/* 260 */     result[0] = getFillerImpl();
/* 261 */     System.arraycopy(fills, 0, result, 1, fills.length);
/* 262 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\WarrantyItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */