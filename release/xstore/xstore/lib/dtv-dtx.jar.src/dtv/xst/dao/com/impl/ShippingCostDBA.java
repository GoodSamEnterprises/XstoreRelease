/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.com.ShippingCostId;
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
/*     */ public class ShippingCostDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -234631493L;
/*     */   private Long _organizationId;
/*     */   private String _category;
/*     */   private BigDecimal _beginRange;
/*     */   private BigDecimal _endRange;
/*     */   private BigDecimal _cost;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private BigDecimal _minimumCost;
/*     */   private BigDecimal _maximumCost;
/*     */   private String _itemId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.category, t.begin_range, t.end_range, t.cost, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.minimum_cost, t.maximum_cost, t.item_id FROM com_shipping_cost t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND category = ?  AND begin_range = ?  AND end_range = ?  AND cost = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.category, t.begin_range, t.end_range, t.cost, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.minimum_cost, t.maximum_cost, t.item_id FROM com_shipping_cost t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND category = ?  AND begin_range = ?  AND end_range = ?  AND cost = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_shipping_cost(organization_id, category, begin_range, end_range, cost, create_date, create_user_id, update_date, update_user_id, org_code, org_value, minimum_cost, maximum_cost, item_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._category, this._beginRange, this._endRange, this._cost, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._minimumCost, this._maximumCost, this._itemId } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 3, 3, 3, 91, 12, 91, 12, 12, 12, 3, 3, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_shipping_cost SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, minimum_cost = ?, maximum_cost = ?, item_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._minimumCost, this._maximumCost, this._itemId } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 3, 3, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_shipping_cost" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND category = ?  AND begin_range = ?  AND end_range = ?  AND cost = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND category = ?  AND begin_range = ?  AND end_range = ?  AND cost = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._category, this._beginRange, this._endRange, this._cost };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 3, 3, 3 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "com_shipping_cost";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new ShippingCostFiller(this);
/*     */   }
/*     */   
/*     */   private static class ShippingCostFiller
/*     */     implements IFiller {
/*     */     private ShippingCostDBA _parent;
/*     */     
/*     */     public ShippingCostFiller(ShippingCostDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       long primitiveResult = argResultSet.getLong(1);
/* 132 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 133 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 137 */       this._parent._category = argResultSet.getString(2);
/* 138 */       this._parent._beginRange = argResultSet.getBigDecimal(3);
/* 139 */       this._parent._endRange = argResultSet.getBigDecimal(4);
/* 140 */       this._parent._cost = argResultSet.getBigDecimal(5);
/*     */       
/* 142 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 143 */       if (t6 != null) {
/* 144 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 147 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 150 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 152 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 153 */       if (t8 != null) {
/* 154 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._updateUserId = argResultSet.getString(9);
/* 161 */       this._parent._orgCode = argResultSet.getString(10);
/* 162 */       this._parent._orgValue = argResultSet.getString(11);
/* 163 */       this._parent._minimumCost = argResultSet.getBigDecimal(12);
/* 164 */       this._parent._maximumCost = argResultSet.getBigDecimal(13);
/* 165 */       this._parent._itemId = argResultSet.getString(14);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 170 */     argDAO.suppressStateChanges(true);
/* 171 */     ShippingCostDAO dao = (ShippingCostDAO)argDAO;
/* 172 */     dao.setOrganizationId(this._organizationId);
/* 173 */     dao.setCategory(this._category);
/* 174 */     dao.setBeginRange(this._beginRange);
/* 175 */     dao.setEndRange(this._endRange);
/* 176 */     dao.setCost(this._cost);
/* 177 */     dao.setCreateDate(this._createDate);
/* 178 */     dao.setCreateUserId(this._createUserId);
/* 179 */     dao.setUpdateDate(this._updateDate);
/* 180 */     dao.setUpdateUserId(this._updateUserId);
/* 181 */     dao.setOrgCode(this._orgCode);
/* 182 */     dao.setOrgValue(this._orgValue);
/* 183 */     dao.setMinimumCost(this._minimumCost);
/* 184 */     dao.setMaximumCost(this._maximumCost);
/* 185 */     dao.setItemId(this._itemId);
/* 186 */     argDAO.suppressStateChanges(false);
/* 187 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 191 */     return loadDAO((IDataAccessObject)new ShippingCostDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 195 */     ShippingCostDAO dao = (ShippingCostDAO)argDAO;
/* 196 */     this._organizationId = dao.getOrganizationId();
/* 197 */     this._category = dao.getCategory();
/* 198 */     this._beginRange = dao.getBeginRange();
/* 199 */     this._endRange = dao.getEndRange();
/* 200 */     this._cost = dao.getCost();
/* 201 */     this._createDate = dao.getCreateDate();
/* 202 */     this._createUserId = dao.getCreateUserId();
/* 203 */     this._updateDate = dao.getUpdateDate();
/* 204 */     this._updateUserId = dao.getUpdateUserId();
/* 205 */     this._orgCode = dao.getOrgCode();
/* 206 */     this._orgValue = dao.getOrgValue();
/* 207 */     this._minimumCost = dao.getMinimumCost();
/* 208 */     this._maximumCost = dao.getMaximumCost();
/* 209 */     this._itemId = dao.getItemId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 213 */     ShippingCostId id = (ShippingCostId)argId;
/* 214 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 215 */     argStatement.setString(2, id.getCategory());
/* 216 */     argStatement.setBigDecimal(3, id.getBeginRange());
/* 217 */     argStatement.setBigDecimal(4, id.getEndRange());
/* 218 */     argStatement.setBigDecimal(5, id.getCost());
/* 219 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 223 */     ShippingCostId id = new ShippingCostId();
/* 224 */     id.setOrganizationId(this._organizationId);
/* 225 */     id.setCategory(this._category);
/* 226 */     id.setBeginRange(this._beginRange);
/* 227 */     id.setEndRange(this._endRange);
/* 228 */     id.setCost(this._cost);
/* 229 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 237 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 241 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ShippingCostDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */