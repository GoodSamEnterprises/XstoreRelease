/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.com.ShippingFeeId;
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
/*     */ public class ShippingFeeDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1531586856L;
/*     */   private String _ruleName;
/*     */   private Long _organizationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Long _priority;
/*     */   private String _shipItemID;
/*     */   private String _aggregationType;
/*     */   private String _ruleType;
/*     */   private String _param1;
/*     */   private String _param2;
/*     */   private static final String SELECT_OBJECT = "SELECT t.rule_name, t.organization_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.priority, t.ship_item_id, t.aggregation_type, t.rule_type, t.param1, t.param2 FROM com_shipping_fee t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE rule_name = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.rule_name, t.organization_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.priority, t.ship_item_id, t.aggregation_type, t.rule_type, t.param1, t.param2 FROM com_shipping_fee t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE rule_name = ?  AND organization_id = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_shipping_fee(rule_name, organization_id, create_date, create_user_id, update_date, update_user_id, org_code, org_value, priority, ship_item_id, aggregation_type, rule_type, param1, param2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._ruleName, this._organizationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._priority, this._shipItemID, this._aggregationType, this._ruleType, this._param1, this._param2 } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 91, 12, 91, 12, 12, 12, -5, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_shipping_fee SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, priority = ?, ship_item_id = ?, aggregation_type = ?, rule_type = ?, param1 = ?, param2 = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._priority, this._shipItemID, this._aggregationType, this._ruleType, this._param1, this._param2 } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, -5, 12, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_shipping_fee" }; private static final String WHERE_OBJECT = " WHERE rule_name = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE rule_name = ?  AND organization_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._ruleName, this._organizationId };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "com_shipping_fee";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new ShippingFeeFiller(this);
/*     */   }
/*     */   
/*     */   private static class ShippingFeeFiller
/*     */     implements IFiller {
/*     */     private ShippingFeeDBA _parent;
/*     */     
/*     */     public ShippingFeeFiller(ShippingFeeDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       this._parent._ruleName = argResultSet.getString(1);
/*     */ 
/*     */       
/* 132 */       long primitiveResult = argResultSet.getLong(2);
/* 133 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 134 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 139 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 140 */       if (t3 != null) {
/* 141 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 147 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 149 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 150 */       if (t5 != null) {
/* 151 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._updateUserId = argResultSet.getString(6);
/* 158 */       this._parent._orgCode = argResultSet.getString(7);
/* 159 */       this._parent._orgValue = argResultSet.getString(8);
/*     */ 
/*     */       
/* 162 */       long l1 = argResultSet.getLong(9);
/* 163 */       if (l1 != 0L || argResultSet.getObject(9) != null) {
/* 164 */         this._parent._priority = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 168 */       this._parent._shipItemID = argResultSet.getString(10);
/* 169 */       this._parent._aggregationType = argResultSet.getString(11);
/* 170 */       this._parent._ruleType = argResultSet.getString(12);
/* 171 */       this._parent._param1 = argResultSet.getString(13);
/* 172 */       this._parent._param2 = argResultSet.getString(14);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 177 */     argDAO.suppressStateChanges(true);
/* 178 */     ShippingFeeDAO dao = (ShippingFeeDAO)argDAO;
/* 179 */     dao.setRuleName(this._ruleName);
/* 180 */     dao.setOrganizationId(this._organizationId);
/* 181 */     dao.setCreateDate(this._createDate);
/* 182 */     dao.setCreateUserId(this._createUserId);
/* 183 */     dao.setUpdateDate(this._updateDate);
/* 184 */     dao.setUpdateUserId(this._updateUserId);
/* 185 */     dao.setOrgCode(this._orgCode);
/* 186 */     dao.setOrgValue(this._orgValue);
/* 187 */     dao.setPriority(this._priority);
/* 188 */     dao.setShipItemID(this._shipItemID);
/* 189 */     dao.setAggregationType(this._aggregationType);
/* 190 */     dao.setRuleType(this._ruleType);
/* 191 */     dao.setParam1(this._param1);
/* 192 */     dao.setParam2(this._param2);
/* 193 */     argDAO.suppressStateChanges(false);
/* 194 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 198 */     return loadDAO((IDataAccessObject)new ShippingFeeDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 202 */     ShippingFeeDAO dao = (ShippingFeeDAO)argDAO;
/* 203 */     this._ruleName = dao.getRuleName();
/* 204 */     this._organizationId = dao.getOrganizationId();
/* 205 */     this._createDate = dao.getCreateDate();
/* 206 */     this._createUserId = dao.getCreateUserId();
/* 207 */     this._updateDate = dao.getUpdateDate();
/* 208 */     this._updateUserId = dao.getUpdateUserId();
/* 209 */     this._orgCode = dao.getOrgCode();
/* 210 */     this._orgValue = dao.getOrgValue();
/* 211 */     this._priority = dao.getPriority();
/* 212 */     this._shipItemID = dao.getShipItemID();
/* 213 */     this._aggregationType = dao.getAggregationType();
/* 214 */     this._ruleType = dao.getRuleType();
/* 215 */     this._param1 = dao.getParam1();
/* 216 */     this._param2 = dao.getParam2();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 220 */     ShippingFeeId id = (ShippingFeeId)argId;
/* 221 */     argStatement.setString(1, id.getRuleName());
/* 222 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 223 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 227 */     ShippingFeeId id = new ShippingFeeId();
/* 228 */     id.setRuleName(this._ruleName);
/* 229 */     id.setOrganizationId(this._organizationId);
/* 230 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 238 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 242 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ShippingFeeDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */