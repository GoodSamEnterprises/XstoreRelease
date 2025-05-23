/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.com.ShippingFeeTierId;
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
/*     */ public class ShippingFeeTierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 367423706L;
/*     */   private String _ruleName;
/*     */   private Long _organizationId;
/*     */   private String _parentRuleName;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Long _priority;
/*     */   private String _feeType;
/*     */   private BigDecimal _feeValue;
/*     */   private String _shipMethod;
/*     */   private BigDecimal _minPrice;
/*     */   private BigDecimal _maxPrice;
/*     */   private String _itemId;
/*     */   private String _ruleType;
/*     */   private String _param1;
/*     */   private String _param2;
/*     */   private static final String SELECT_OBJECT = "SELECT t.rule_name, t.organization_id, t.parent_rule_name, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.priority, t.fee_type, t.fee_value, t.ship_method, t.min_price, t.max_price, t.item_id, t.rule_type, t.param1, t.param2 FROM com_shipping_fee_tier t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE rule_name = ?  AND organization_id = ?  AND parent_rule_name = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  48 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  52 */     return "SELECT t.rule_name, t.organization_id, t.parent_rule_name, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.priority, t.fee_type, t.fee_value, t.ship_method, t.min_price, t.max_price, t.item_id, t.rule_type, t.param1, t.param2 FROM com_shipping_fee_tier t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  58 */     return " WHERE rule_name = ?  AND organization_id = ?  AND parent_rule_name = ?  ";
/*     */   }
/*     */   
/*  61 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_shipping_fee_tier(rule_name, organization_id, parent_rule_name, create_date, create_user_id, update_date, update_user_id, org_code, org_value, priority, fee_type, fee_value, ship_method, min_price, max_price, item_id, rule_type, param1, param2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  64 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  68 */     Object[][] insertParameterObject = { { this._ruleName, this._organizationId, this._parentRuleName, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._priority, this._feeType, this._feeValue, this._shipMethod, this._minPrice, this._maxPrice, this._itemId, this._ruleType, this._param1, this._param2 } };
/*  69 */     return insertParameterObject;
/*     */   }
/*     */   
/*  72 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 91, 12, 91, 12, 12, 12, -5, 12, 3, 12, 3, 3, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  75 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  78 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_shipping_fee_tier SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, priority = ?, fee_type = ?, fee_value = ?, ship_method = ?, min_price = ?, max_price = ?, item_id = ?, rule_type = ?, param1 = ?, param2 = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  81 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  85 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._priority, this._feeType, this._feeValue, this._shipMethod, this._minPrice, this._maxPrice, this._itemId, this._ruleType, this._param1, this._param2 } };
/*  86 */     return updateParameterObject;
/*     */   }
/*     */   
/*  89 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, -5, 12, 3, 12, 3, 3, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  91 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  94 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_shipping_fee_tier" }; private static final String WHERE_OBJECT = " WHERE rule_name = ?  AND organization_id = ?  AND parent_rule_name = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  97 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 103 */     return " WHERE rule_name = ?  AND organization_id = ?  AND parent_rule_name = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 106 */     return new Object[] { this._ruleName, this._organizationId, this._parentRuleName };
/*     */   }
/*     */   
/* 109 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 112 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 115 */     return "com_shipping_fee_tier";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 119 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 123 */     return new ShippingFeeTierFiller(this);
/*     */   }
/*     */   
/*     */   private static class ShippingFeeTierFiller
/*     */     implements IFiller {
/*     */     private ShippingFeeTierDBA _parent;
/*     */     
/*     */     public ShippingFeeTierFiller(ShippingFeeTierDBA argParent) {
/* 131 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 134 */       this._parent._ruleName = argResultSet.getString(1);
/*     */ 
/*     */       
/* 137 */       long primitiveResult = argResultSet.getLong(2);
/* 138 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 139 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 143 */       this._parent._parentRuleName = argResultSet.getString(3);
/*     */       
/* 145 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 146 */       if (t4 != null) {
/* 147 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 155 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 156 */       if (t6 != null) {
/* 157 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._updateUserId = argResultSet.getString(7);
/* 164 */       this._parent._orgCode = argResultSet.getString(8);
/* 165 */       this._parent._orgValue = argResultSet.getString(9);
/*     */ 
/*     */       
/* 168 */       long l1 = argResultSet.getLong(10);
/* 169 */       if (l1 != 0L || argResultSet.getObject(10) != null) {
/* 170 */         this._parent._priority = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 174 */       this._parent._feeType = argResultSet.getString(11);
/* 175 */       this._parent._feeValue = argResultSet.getBigDecimal(12);
/* 176 */       this._parent._shipMethod = argResultSet.getString(13);
/* 177 */       this._parent._minPrice = argResultSet.getBigDecimal(14);
/* 178 */       this._parent._maxPrice = argResultSet.getBigDecimal(15);
/* 179 */       this._parent._itemId = argResultSet.getString(16);
/* 180 */       this._parent._ruleType = argResultSet.getString(17);
/* 181 */       this._parent._param1 = argResultSet.getString(18);
/* 182 */       this._parent._param2 = argResultSet.getString(19);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 187 */     argDAO.suppressStateChanges(true);
/* 188 */     ShippingFeeTierDAO dao = (ShippingFeeTierDAO)argDAO;
/* 189 */     dao.setRuleName(this._ruleName);
/* 190 */     dao.setOrganizationId(this._organizationId);
/* 191 */     dao.setParentRuleName(this._parentRuleName);
/* 192 */     dao.setCreateDate(this._createDate);
/* 193 */     dao.setCreateUserId(this._createUserId);
/* 194 */     dao.setUpdateDate(this._updateDate);
/* 195 */     dao.setUpdateUserId(this._updateUserId);
/* 196 */     dao.setOrgCode(this._orgCode);
/* 197 */     dao.setOrgValue(this._orgValue);
/* 198 */     dao.setPriority(this._priority);
/* 199 */     dao.setFeeType(this._feeType);
/* 200 */     dao.setFeeValue(this._feeValue);
/* 201 */     dao.setShipMethod(this._shipMethod);
/* 202 */     dao.setMinPrice(this._minPrice);
/* 203 */     dao.setMaxPrice(this._maxPrice);
/* 204 */     dao.setItemId(this._itemId);
/* 205 */     dao.setRuleType(this._ruleType);
/* 206 */     dao.setParam1(this._param1);
/* 207 */     dao.setParam2(this._param2);
/* 208 */     argDAO.suppressStateChanges(false);
/* 209 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 213 */     return loadDAO((IDataAccessObject)new ShippingFeeTierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 217 */     ShippingFeeTierDAO dao = (ShippingFeeTierDAO)argDAO;
/* 218 */     this._ruleName = dao.getRuleName();
/* 219 */     this._organizationId = dao.getOrganizationId();
/* 220 */     this._parentRuleName = dao.getParentRuleName();
/* 221 */     this._createDate = dao.getCreateDate();
/* 222 */     this._createUserId = dao.getCreateUserId();
/* 223 */     this._updateDate = dao.getUpdateDate();
/* 224 */     this._updateUserId = dao.getUpdateUserId();
/* 225 */     this._orgCode = dao.getOrgCode();
/* 226 */     this._orgValue = dao.getOrgValue();
/* 227 */     this._priority = dao.getPriority();
/* 228 */     this._feeType = dao.getFeeType();
/* 229 */     this._feeValue = dao.getFeeValue();
/* 230 */     this._shipMethod = dao.getShipMethod();
/* 231 */     this._minPrice = dao.getMinPrice();
/* 232 */     this._maxPrice = dao.getMaxPrice();
/* 233 */     this._itemId = dao.getItemId();
/* 234 */     this._ruleType = dao.getRuleType();
/* 235 */     this._param1 = dao.getParam1();
/* 236 */     this._param2 = dao.getParam2();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 240 */     ShippingFeeTierId id = (ShippingFeeTierId)argId;
/* 241 */     argStatement.setString(1, id.getRuleName());
/* 242 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 243 */     argStatement.setString(3, id.getParentRuleName());
/* 244 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 248 */     ShippingFeeTierId id = new ShippingFeeTierId();
/* 249 */     id.setRuleName(this._ruleName);
/* 250 */     id.setOrganizationId(this._organizationId);
/* 251 */     id.setParentRuleName(this._parentRuleName);
/* 252 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 260 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 264 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ShippingFeeTierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */