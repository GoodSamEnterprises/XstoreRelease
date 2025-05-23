/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.cwo.WorkOrderPricingId;
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
/*     */ public class WorkOrderPricingDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 273533545L;
/*     */   private Long _organizationId;
/*     */   private String _priceCode;
/*     */   private String _itemId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private BigDecimal _price;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.price_code, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.price FROM cwo_work_order_pricing t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND price_code = ?  AND item_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.price_code, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.price FROM cwo_work_order_pricing t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND price_code = ?  AND item_id = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cwo_work_order_pricing(organization_id, price_code, item_id, create_date, create_user_id, update_date, update_user_id, org_code, org_value, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._priceCode, this._itemId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._price } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 12, 12, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cwo_work_order_pricing SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, price = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._price } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cwo_work_order_pricing" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND price_code = ?  AND item_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND price_code = ?  AND item_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._priceCode, this._itemId };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "cwo_work_order_pricing";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new WorkOrderPricingFiller(this);
/*     */   }
/*     */   
/*     */   private static class WorkOrderPricingFiller
/*     */     implements IFiller {
/*     */     private WorkOrderPricingDBA _parent;
/*     */     
/*     */     public WorkOrderPricingFiller(WorkOrderPricingDBA argParent) {
/* 122 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 127 */       long primitiveResult = argResultSet.getLong(1);
/* 128 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 129 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 133 */       this._parent._priceCode = argResultSet.getString(2);
/* 134 */       this._parent._itemId = argResultSet.getString(3);
/*     */       
/* 136 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 137 */       if (t4 != null) {
/* 138 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 141 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 144 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 146 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 147 */       if (t6 != null) {
/* 148 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 154 */       this._parent._updateUserId = argResultSet.getString(7);
/* 155 */       this._parent._orgCode = argResultSet.getString(8);
/* 156 */       this._parent._orgValue = argResultSet.getString(9);
/* 157 */       this._parent._price = argResultSet.getBigDecimal(10);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 162 */     argDAO.suppressStateChanges(true);
/* 163 */     WorkOrderPricingDAO dao = (WorkOrderPricingDAO)argDAO;
/* 164 */     dao.setOrganizationId(this._organizationId);
/* 165 */     dao.setPriceCode(this._priceCode);
/* 166 */     dao.setItemId(this._itemId);
/* 167 */     dao.setCreateDate(this._createDate);
/* 168 */     dao.setCreateUserId(this._createUserId);
/* 169 */     dao.setUpdateDate(this._updateDate);
/* 170 */     dao.setUpdateUserId(this._updateUserId);
/* 171 */     dao.setOrgCode(this._orgCode);
/* 172 */     dao.setOrgValue(this._orgValue);
/* 173 */     dao.setPrice(this._price);
/* 174 */     argDAO.suppressStateChanges(false);
/* 175 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 179 */     return loadDAO((IDataAccessObject)new WorkOrderPricingDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 183 */     WorkOrderPricingDAO dao = (WorkOrderPricingDAO)argDAO;
/* 184 */     this._organizationId = dao.getOrganizationId();
/* 185 */     this._priceCode = dao.getPriceCode();
/* 186 */     this._itemId = dao.getItemId();
/* 187 */     this._createDate = dao.getCreateDate();
/* 188 */     this._createUserId = dao.getCreateUserId();
/* 189 */     this._updateDate = dao.getUpdateDate();
/* 190 */     this._updateUserId = dao.getUpdateUserId();
/* 191 */     this._orgCode = dao.getOrgCode();
/* 192 */     this._orgValue = dao.getOrgValue();
/* 193 */     this._price = dao.getPrice();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 197 */     WorkOrderPricingId id = (WorkOrderPricingId)argId;
/* 198 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 199 */     argStatement.setString(2, id.getPriceCode());
/* 200 */     argStatement.setString(3, id.getItemId());
/* 201 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 205 */     WorkOrderPricingId id = new WorkOrderPricingId();
/* 206 */     id.setOrganizationId(this._organizationId);
/* 207 */     id.setPriceCode(this._priceCode);
/* 208 */     id.setItemId(this._itemId);
/* 209 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 217 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 221 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\WorkOrderPricingDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */