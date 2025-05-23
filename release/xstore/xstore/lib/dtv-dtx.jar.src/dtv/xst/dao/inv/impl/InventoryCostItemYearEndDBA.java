/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryCostItemYearEndId;
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
/*     */ public class InventoryCostItemYearEndDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1083488738L;
/*     */   private Long _organizationId;
/*     */   private Integer _fiscalYear;
/*     */   private Long _retailLocationId;
/*     */   private String _itemId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _wacQuantityReceived;
/*     */   private BigDecimal _wacValueReceived;
/*     */   private BigDecimal _pwacQuantityOnhandEndofyear;
/*     */   private BigDecimal _pwacValueOnhandEndofyear;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.fiscal_year, t.rtl_loc_id, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.wac_qty_rcvd, t.wac_value_rcvd, t.pwac_qty_onhand_endofyear, t.pwac_value_onhand_endofyear FROM inv_cst_item_yearend t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND fiscal_year = ?  AND rtl_loc_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.fiscal_year, t.rtl_loc_id, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.wac_qty_rcvd, t.wac_value_rcvd, t.pwac_qty_onhand_endofyear, t.pwac_value_onhand_endofyear FROM inv_cst_item_yearend t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND fiscal_year = ?  AND rtl_loc_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_cst_item_yearend(organization_id, fiscal_year, rtl_loc_id, item_id, create_date, create_user_id, update_date, update_user_id, wac_qty_rcvd, wac_value_rcvd, pwac_qty_onhand_endofyear, pwac_value_onhand_endofyear) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._fiscalYear, this._retailLocationId, this._itemId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._wacQuantityReceived, this._wacValueReceived, this._pwacQuantityOnhandEndofyear, this._pwacValueOnhandEndofyear } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 4, -5, 12, 91, 12, 91, 12, 3, 3, 3, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_cst_item_yearend SET update_date = ?, update_user_id = ?, wac_qty_rcvd = ?, wac_value_rcvd = ?, pwac_qty_onhand_endofyear = ?, pwac_value_onhand_endofyear = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._wacQuantityReceived, this._wacValueReceived, this._pwacQuantityOnhandEndofyear, this._pwacValueOnhandEndofyear } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 3, 3, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_cst_item_yearend" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND fiscal_year = ?  AND rtl_loc_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND fiscal_year = ?  AND rtl_loc_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._fiscalYear, this._retailLocationId, this._itemId };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 4, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "inv_cst_item_yearend";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new InventoryCostItemYearEndFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryCostItemYearEndFiller
/*     */     implements IFiller {
/*     */     private InventoryCostItemYearEndDBA _parent;
/*     */     
/*     */     public InventoryCostItemYearEndFiller(InventoryCostItemYearEndDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       long l1 = argResultSet.getLong(1);
/* 130 */       if (l1 != 0L || argResultSet.getObject(1) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 137 */       int i = argResultSet.getInt(2);
/* 138 */       if (i != 0 || argResultSet.getObject(2) != null) {
/* 139 */         this._parent._fiscalYear = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 145 */       long primitiveResult = argResultSet.getLong(3);
/* 146 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 147 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 151 */       this._parent._itemId = argResultSet.getString(4);
/*     */       
/* 153 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 154 */       if (t5 != null) {
/* 155 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 158 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 161 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 163 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 164 */       if (t7 != null) {
/* 165 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 168 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 171 */       this._parent._updateUserId = argResultSet.getString(8);
/* 172 */       this._parent._wacQuantityReceived = argResultSet.getBigDecimal(9);
/* 173 */       this._parent._wacValueReceived = argResultSet.getBigDecimal(10);
/* 174 */       this._parent._pwacQuantityOnhandEndofyear = argResultSet.getBigDecimal(11);
/* 175 */       this._parent._pwacValueOnhandEndofyear = argResultSet.getBigDecimal(12);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 180 */     argDAO.suppressStateChanges(true);
/* 181 */     InventoryCostItemYearEndDAO dao = (InventoryCostItemYearEndDAO)argDAO;
/* 182 */     dao.setOrganizationId(this._organizationId);
/* 183 */     dao.setFiscalYear(this._fiscalYear);
/* 184 */     dao.setRetailLocationId(this._retailLocationId);
/* 185 */     dao.setItemId(this._itemId);
/* 186 */     dao.setCreateDate(this._createDate);
/* 187 */     dao.setCreateUserId(this._createUserId);
/* 188 */     dao.setUpdateDate(this._updateDate);
/* 189 */     dao.setUpdateUserId(this._updateUserId);
/* 190 */     dao.setWacQuantityReceived(this._wacQuantityReceived);
/* 191 */     dao.setWacValueReceived(this._wacValueReceived);
/* 192 */     dao.setPwacQuantityOnhandEndofyear(this._pwacQuantityOnhandEndofyear);
/* 193 */     dao.setPwacValueOnhandEndofyear(this._pwacValueOnhandEndofyear);
/* 194 */     argDAO.suppressStateChanges(false);
/* 195 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 199 */     return loadDAO((IDataAccessObject)new InventoryCostItemYearEndDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 203 */     InventoryCostItemYearEndDAO dao = (InventoryCostItemYearEndDAO)argDAO;
/* 204 */     this._organizationId = dao.getOrganizationId();
/* 205 */     this._fiscalYear = dao.getFiscalYear();
/* 206 */     this._retailLocationId = dao.getRetailLocationId();
/* 207 */     this._itemId = dao.getItemId();
/* 208 */     this._createDate = dao.getCreateDate();
/* 209 */     this._createUserId = dao.getCreateUserId();
/* 210 */     this._updateDate = dao.getUpdateDate();
/* 211 */     this._updateUserId = dao.getUpdateUserId();
/* 212 */     this._wacQuantityReceived = dao.getWacQuantityReceived();
/* 213 */     this._wacValueReceived = dao.getWacValueReceived();
/* 214 */     this._pwacQuantityOnhandEndofyear = dao.getPwacQuantityOnhandEndofyear();
/* 215 */     this._pwacValueOnhandEndofyear = dao.getPwacValueOnhandEndofyear();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 219 */     InventoryCostItemYearEndId id = (InventoryCostItemYearEndId)argId;
/* 220 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 221 */     argStatement.setInt(2, id.getFiscalYear().intValue());
/* 222 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 223 */     argStatement.setString(4, id.getItemId());
/* 224 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 228 */     InventoryCostItemYearEndId id = new InventoryCostItemYearEndId();
/* 229 */     id.setOrganizationId(this._organizationId);
/* 230 */     id.setFiscalYear(this._fiscalYear);
/* 231 */     id.setRetailLocationId(this._retailLocationId);
/* 232 */     id.setItemId(this._itemId);
/* 233 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 241 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 245 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCostItemYearEndDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */