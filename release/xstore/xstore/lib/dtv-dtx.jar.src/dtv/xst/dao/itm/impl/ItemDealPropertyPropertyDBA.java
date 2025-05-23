/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemDealPropertyPropertyId;
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
/*     */ public class ItemDealPropertyPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -940445911L;
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _itemDealPropertyCode;
/*     */   private Date _effectiveDate;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.item_id, t.itm_deal_property_code, t.effective_date, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_item_deal_prop_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND itm_deal_property_code = ?  AND effective_date = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.item_id, t.itm_deal_property_code, t.effective_date, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_item_deal_prop_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND item_id = ?  AND itm_deal_property_code = ?  AND effective_date = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_deal_prop_p(organization_id, item_id, itm_deal_property_code, effective_date, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._itemId, this._itemDealPropertyCode, this._effectiveDate, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_deal_prop_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_deal_prop_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND itm_deal_property_code = ?  AND effective_date = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND item_id = ?  AND itm_deal_property_code = ?  AND effective_date = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._itemId, this._itemDealPropertyCode, this._effectiveDate, this._propertyCode };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 91, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "itm_item_deal_prop_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new ItemDealPropertyPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemDealPropertyPropertyFiller
/*     */     implements IFiller {
/*     */     private ItemDealPropertyPropertyDBA _parent;
/*     */     
/*     */     public ItemDealPropertyPropertyFiller(ItemDealPropertyPropertyDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       long primitiveResult = argResultSet.getLong(1);
/* 131 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 132 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 136 */       this._parent._itemId = argResultSet.getString(2);
/* 137 */       this._parent._itemDealPropertyCode = argResultSet.getString(3);
/*     */       
/* 139 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 140 */       if (t4 != null) {
/* 141 */         this._parent._effectiveDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */       
/* 147 */       this._parent._propertyCode = argResultSet.getString(5);
/* 148 */       this._parent._type = argResultSet.getString(6);
/* 149 */       this._parent._stringValue = argResultSet.getString(7);
/*     */       
/* 151 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 152 */       if (t8 != null) {
/* 153 */         this._parent._dateValue = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 159 */       this._parent._decimalValue = argResultSet.getBigDecimal(9);
/*     */       
/* 161 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 162 */       if (t10 != null) {
/* 163 */         this._parent._createDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 166 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 169 */       this._parent._createUserId = argResultSet.getString(11);
/*     */       
/* 171 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 172 */       if (t12 != null) {
/* 173 */         this._parent._updateDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 176 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 179 */       this._parent._updateUserId = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 184 */     argDAO.suppressStateChanges(true);
/* 185 */     ItemDealPropertyPropertyDAO dao = (ItemDealPropertyPropertyDAO)argDAO;
/* 186 */     dao.setOrganizationId(this._organizationId);
/* 187 */     dao.setItemId(this._itemId);
/* 188 */     dao.setItemDealPropertyCode(this._itemDealPropertyCode);
/* 189 */     dao.setEffectiveDate(this._effectiveDate);
/* 190 */     dao.setPropertyCode(this._propertyCode);
/* 191 */     dao.setType(this._type);
/* 192 */     dao.setStringValue(this._stringValue);
/* 193 */     dao.setDateValue(this._dateValue);
/* 194 */     dao.setDecimalValue(this._decimalValue);
/* 195 */     dao.setCreateDate(this._createDate);
/* 196 */     dao.setCreateUserId(this._createUserId);
/* 197 */     dao.setUpdateDate(this._updateDate);
/* 198 */     dao.setUpdateUserId(this._updateUserId);
/* 199 */     argDAO.suppressStateChanges(false);
/* 200 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 204 */     return loadDAO((IDataAccessObject)new ItemDealPropertyPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 208 */     ItemDealPropertyPropertyDAO dao = (ItemDealPropertyPropertyDAO)argDAO;
/* 209 */     this._organizationId = dao.getOrganizationId();
/* 210 */     this._itemId = dao.getItemId();
/* 211 */     this._itemDealPropertyCode = dao.getItemDealPropertyCode();
/* 212 */     this._effectiveDate = dao.getEffectiveDate();
/* 213 */     this._propertyCode = dao.getPropertyCode();
/* 214 */     this._type = dao.getType();
/* 215 */     this._stringValue = dao.getStringValue();
/* 216 */     this._dateValue = dao.getDateValue();
/* 217 */     this._decimalValue = dao.getDecimalValue();
/* 218 */     this._createDate = dao.getCreateDate();
/* 219 */     this._createUserId = dao.getCreateUserId();
/* 220 */     this._updateDate = dao.getUpdateDate();
/* 221 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 225 */     ItemDealPropertyPropertyId id = (ItemDealPropertyPropertyId)argId;
/* 226 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 227 */     argStatement.setString(2, id.getItemId());
/* 228 */     argStatement.setString(3, id.getItemDealPropertyCode());
/* 229 */     argStatement.setTimestamp(4, new Timestamp(id.getEffectiveDate().getTime()));
/* 230 */     argStatement.setString(5, id.getPropertyCode());
/* 231 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 235 */     ItemDealPropertyPropertyId id = new ItemDealPropertyPropertyId();
/* 236 */     id.setOrganizationId(this._organizationId);
/* 237 */     id.setItemId(this._itemId);
/* 238 */     id.setItemDealPropertyCode(this._itemDealPropertyCode);
/* 239 */     id.setEffectiveDate(this._effectiveDate);
/* 240 */     id.setPropertyCode(this._propertyCode);
/* 241 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 249 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 253 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemDealPropertyPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */