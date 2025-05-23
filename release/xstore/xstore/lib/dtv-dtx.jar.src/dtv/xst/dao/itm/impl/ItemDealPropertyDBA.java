/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.ItemDealPropertyId;
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
/*     */ public class ItemDealPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1662263604L;
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _itemDealPropertyCode;
/*     */   private Date _effectiveDate;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _expirationDate;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.item_id, t.itm_deal_property_code, t.effective_date, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.expiration_date, t.type, t.string_value, t.date_value, t.decimal_value FROM itm_item_deal_prop t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND itm_deal_property_code = ?  AND effective_date = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.item_id, t.itm_deal_property_code, t.effective_date, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.expiration_date, t.type, t.string_value, t.date_value, t.decimal_value FROM itm_item_deal_prop t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND item_id = ?  AND itm_deal_property_code = ?  AND effective_date = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_deal_prop(organization_id, item_id, itm_deal_property_code, effective_date, create_date, create_user_id, update_date, update_user_id, org_code, org_value, expiration_date, type, string_value, date_value, decimal_value) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._itemId, this._itemDealPropertyCode, this._effectiveDate, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._expirationDate, this._type, this._stringValue, this._dateValue, this._decimalValue } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 91, 12, 91, 12, 12, 12, 91, 12, 12, 91, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_deal_prop SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, expiration_date = ?, type = ?, string_value = ?, date_value = ?, decimal_value = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._expirationDate, this._type, this._stringValue, this._dateValue, this._decimalValue } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 91, 12, 12, 91, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_deal_prop" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND itm_deal_property_code = ?  AND effective_date = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND item_id = ?  AND itm_deal_property_code = ?  AND effective_date = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._itemId, this._itemDealPropertyCode, this._effectiveDate };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 91 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "itm_item_deal_prop";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new ItemDealPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemDealPropertyFiller
/*     */     implements IFiller {
/*     */     private ItemDealPropertyDBA _parent;
/*     */     
/*     */     public ItemDealPropertyFiller(ItemDealPropertyDBA argParent) {
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
/* 139 */       this._parent._itemDealPropertyCode = argResultSet.getString(3);
/*     */       
/* 141 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 142 */       if (t4 != null) {
/* 143 */         this._parent._effectiveDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 146 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 150 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 151 */       if (t5 != null) {
/* 152 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 155 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 158 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 160 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 161 */       if (t7 != null) {
/* 162 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 165 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 168 */       this._parent._updateUserId = argResultSet.getString(8);
/* 169 */       this._parent._orgCode = argResultSet.getString(9);
/* 170 */       this._parent._orgValue = argResultSet.getString(10);
/*     */       
/* 172 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 173 */       if (t11 != null) {
/* 174 */         this._parent._expirationDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 177 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 180 */       this._parent._type = argResultSet.getString(12);
/* 181 */       this._parent._stringValue = argResultSet.getString(13);
/*     */       
/* 183 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 184 */       if (t14 != null) {
/* 185 */         this._parent._dateValue = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 188 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 191 */       this._parent._decimalValue = argResultSet.getBigDecimal(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 196 */     argDAO.suppressStateChanges(true);
/* 197 */     ItemDealPropertyDAO dao = (ItemDealPropertyDAO)argDAO;
/* 198 */     dao.setOrganizationId(this._organizationId);
/* 199 */     dao.setItemId(this._itemId);
/* 200 */     dao.setItemDealPropertyCode(this._itemDealPropertyCode);
/* 201 */     dao.setEffectiveDate(this._effectiveDate);
/* 202 */     dao.setCreateDate(this._createDate);
/* 203 */     dao.setCreateUserId(this._createUserId);
/* 204 */     dao.setUpdateDate(this._updateDate);
/* 205 */     dao.setUpdateUserId(this._updateUserId);
/* 206 */     dao.setOrgCode(this._orgCode);
/* 207 */     dao.setOrgValue(this._orgValue);
/* 208 */     dao.setExpirationDate(this._expirationDate);
/* 209 */     dao.setType(this._type);
/* 210 */     dao.setStringValue(this._stringValue);
/* 211 */     dao.setDateValue(this._dateValue);
/* 212 */     dao.setDecimalValue(this._decimalValue);
/* 213 */     argDAO.suppressStateChanges(false);
/* 214 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 218 */     return loadDAO((IDataAccessObject)new ItemDealPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 222 */     ItemDealPropertyDAO dao = (ItemDealPropertyDAO)argDAO;
/* 223 */     this._organizationId = dao.getOrganizationId();
/* 224 */     this._itemId = dao.getItemId();
/* 225 */     this._itemDealPropertyCode = dao.getItemDealPropertyCode();
/* 226 */     this._effectiveDate = dao.getEffectiveDate();
/* 227 */     this._createDate = dao.getCreateDate();
/* 228 */     this._createUserId = dao.getCreateUserId();
/* 229 */     this._updateDate = dao.getUpdateDate();
/* 230 */     this._updateUserId = dao.getUpdateUserId();
/* 231 */     this._orgCode = dao.getOrgCode();
/* 232 */     this._orgValue = dao.getOrgValue();
/* 233 */     this._expirationDate = dao.getExpirationDate();
/* 234 */     this._type = dao.getType();
/* 235 */     this._stringValue = dao.getStringValue();
/* 236 */     this._dateValue = dao.getDateValue();
/* 237 */     this._decimalValue = dao.getDecimalValue();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 241 */     ItemDealPropertyId id = (ItemDealPropertyId)argId;
/* 242 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 243 */     argStatement.setString(2, id.getItemId());
/* 244 */     argStatement.setString(3, id.getItemDealPropertyCode());
/* 245 */     argStatement.setTimestamp(4, new Timestamp(id.getEffectiveDate().getTime()));
/* 246 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 250 */     ItemDealPropertyId id = new ItemDealPropertyId();
/* 251 */     id.setOrganizationId(this._organizationId);
/* 252 */     id.setItemId(this._itemId);
/* 253 */     id.setItemDealPropertyCode(this._itemDealPropertyCode);
/* 254 */     id.setEffectiveDate(this._effectiveDate);
/* 255 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 263 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 267 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemDealPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */