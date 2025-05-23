/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.WarrantyItemPriceId;
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
/*     */ public class WarrantyItemPriceDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 231273530L;
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private Long _warrantyPriceSeq;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _minItemPriceAmt;
/*     */   private BigDecimal _maxItemPriceAmt;
/*     */   private BigDecimal _priceAmt;
/*     */   private BigDecimal _pricePercentage;
/*     */   private BigDecimal _minPriceAmt;
/*     */   private String _refItemId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.item_id, t.warranty_price_seq, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.min_item_price_amt, t.max_item_price_amt, t.price_amt, t.price_percentage, t.min_price_amt, t.ref_item_id FROM itm_warranty_item_price t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND warranty_price_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.item_id, t.warranty_price_seq, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.min_item_price_amt, t.max_item_price_amt, t.price_amt, t.price_percentage, t.min_price_amt, t.ref_item_id FROM itm_warranty_item_price t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND item_id = ?  AND warranty_price_seq = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_warranty_item_price(organization_id, item_id, warranty_price_seq, org_code, org_value, create_date, create_user_id, update_date, update_user_id, min_item_price_amt, max_item_price_amt, price_amt, price_percentage, min_price_amt, ref_item_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._itemId, this._warrantyPriceSeq, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._minItemPriceAmt, this._maxItemPriceAmt, this._priceAmt, this._pricePercentage, this._minPriceAmt, this._refItemId } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, -5, 12, 12, 91, 12, 91, 12, 3, 3, 3, 3, 3, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_warranty_item_price SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, min_item_price_amt = ?, max_item_price_amt = ?, price_amt = ?, price_percentage = ?, min_price_amt = ?, ref_item_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._minItemPriceAmt, this._maxItemPriceAmt, this._priceAmt, this._pricePercentage, this._minPriceAmt, this._refItemId } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 3, 3, 3, 3, 3, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_warranty_item_price" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND warranty_price_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND item_id = ?  AND warranty_price_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._itemId, this._warrantyPriceSeq };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "itm_warranty_item_price";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new WarrantyItemPriceFiller(this);
/*     */   }
/*     */   
/*     */   private static class WarrantyItemPriceFiller
/*     */     implements IFiller {
/*     */     private WarrantyItemPriceDBA _parent;
/*     */     
/*     */     public WarrantyItemPriceFiller(WarrantyItemPriceDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 132 */       long primitiveResult = argResultSet.getLong(1);
/* 133 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 134 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 138 */       this._parent._itemId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 141 */       primitiveResult = argResultSet.getLong(3);
/* 142 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 143 */         this._parent._warrantyPriceSeq = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 147 */       this._parent._orgCode = argResultSet.getString(4);
/* 148 */       this._parent._orgValue = argResultSet.getString(5);
/*     */       
/* 150 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 151 */       if (t6 != null) {
/* 152 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 155 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 158 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 160 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 161 */       if (t8 != null) {
/* 162 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 165 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 168 */       this._parent._updateUserId = argResultSet.getString(9);
/* 169 */       this._parent._minItemPriceAmt = argResultSet.getBigDecimal(10);
/* 170 */       this._parent._maxItemPriceAmt = argResultSet.getBigDecimal(11);
/* 171 */       this._parent._priceAmt = argResultSet.getBigDecimal(12);
/* 172 */       this._parent._pricePercentage = argResultSet.getBigDecimal(13);
/* 173 */       this._parent._minPriceAmt = argResultSet.getBigDecimal(14);
/* 174 */       this._parent._refItemId = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 179 */     argDAO.suppressStateChanges(true);
/* 180 */     WarrantyItemPriceDAO dao = (WarrantyItemPriceDAO)argDAO;
/* 181 */     dao.setOrganizationId(this._organizationId);
/* 182 */     dao.setItemId(this._itemId);
/* 183 */     dao.setWarrantyPriceSeq(this._warrantyPriceSeq);
/* 184 */     dao.setOrgCode(this._orgCode);
/* 185 */     dao.setOrgValue(this._orgValue);
/* 186 */     dao.setCreateDate(this._createDate);
/* 187 */     dao.setCreateUserId(this._createUserId);
/* 188 */     dao.setUpdateDate(this._updateDate);
/* 189 */     dao.setUpdateUserId(this._updateUserId);
/* 190 */     dao.setMinItemPriceAmt(this._minItemPriceAmt);
/* 191 */     dao.setMaxItemPriceAmt(this._maxItemPriceAmt);
/* 192 */     dao.setPriceAmt(this._priceAmt);
/* 193 */     dao.setPricePercentage(this._pricePercentage);
/* 194 */     dao.setMinPriceAmt(this._minPriceAmt);
/* 195 */     dao.setRefItemId(this._refItemId);
/* 196 */     argDAO.suppressStateChanges(false);
/* 197 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 201 */     return loadDAO((IDataAccessObject)new WarrantyItemPriceDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 205 */     WarrantyItemPriceDAO dao = (WarrantyItemPriceDAO)argDAO;
/* 206 */     this._organizationId = dao.getOrganizationId();
/* 207 */     this._itemId = dao.getItemId();
/* 208 */     this._warrantyPriceSeq = dao.getWarrantyPriceSeq();
/* 209 */     this._orgCode = dao.getOrgCode();
/* 210 */     this._orgValue = dao.getOrgValue();
/* 211 */     this._createDate = dao.getCreateDate();
/* 212 */     this._createUserId = dao.getCreateUserId();
/* 213 */     this._updateDate = dao.getUpdateDate();
/* 214 */     this._updateUserId = dao.getUpdateUserId();
/* 215 */     this._minItemPriceAmt = dao.getMinItemPriceAmt();
/* 216 */     this._maxItemPriceAmt = dao.getMaxItemPriceAmt();
/* 217 */     this._priceAmt = dao.getPriceAmt();
/* 218 */     this._pricePercentage = dao.getPricePercentage();
/* 219 */     this._minPriceAmt = dao.getMinPriceAmt();
/* 220 */     this._refItemId = dao.getRefItemId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 224 */     WarrantyItemPriceId id = (WarrantyItemPriceId)argId;
/* 225 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 226 */     argStatement.setString(2, id.getItemId());
/* 227 */     argStatement.setLong(3, id.getWarrantyPriceSeq().longValue());
/* 228 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 232 */     WarrantyItemPriceId id = new WarrantyItemPriceId();
/* 233 */     id.setOrganizationId(this._organizationId);
/* 234 */     id.setItemId(this._itemId);
/* 235 */     id.setWarrantyPriceSeq(this._warrantyPriceSeq);
/* 236 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 244 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 248 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\WarrantyItemPriceDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */