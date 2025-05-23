/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemLabelBatchPropertyId;
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
/*     */ public class ItemLabelBatchPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1695564078L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _batchName;
/*     */   private String _itemId;
/*     */   private String _stockLabel;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.batch_name, t.item_id, t.stock_label, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_item_label_batch_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND batch_name = ?  AND item_id = ?  AND stock_label = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.rtl_loc_id, t.batch_name, t.item_id, t.stock_label, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_item_label_batch_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND batch_name = ?  AND item_id = ?  AND stock_label = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_label_batch_p(organization_id, rtl_loc_id, batch_name, item_id, stock_label, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._batchName, this._itemId, this._stockLabel, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 12, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_label_batch_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_label_batch_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND batch_name = ?  AND item_id = ?  AND stock_label = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND batch_name = ?  AND item_id = ?  AND stock_label = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._retailLocationId, this._batchName, this._itemId, this._stockLabel, this._propertyCode };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "itm_item_label_batch_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new ItemLabelBatchPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemLabelBatchPropertyFiller
/*     */     implements IFiller {
/*     */     private ItemLabelBatchPropertyDBA _parent;
/*     */     
/*     */     public ItemLabelBatchPropertyFiller(ItemLabelBatchPropertyDBA argParent) {
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
/*     */ 
/*     */       
/* 139 */       primitiveResult = argResultSet.getLong(2);
/* 140 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 141 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 145 */       this._parent._batchName = argResultSet.getString(3);
/* 146 */       this._parent._itemId = argResultSet.getString(4);
/* 147 */       this._parent._stockLabel = argResultSet.getString(5);
/* 148 */       this._parent._propertyCode = argResultSet.getString(6);
/* 149 */       this._parent._type = argResultSet.getString(7);
/* 150 */       this._parent._stringValue = argResultSet.getString(8);
/*     */       
/* 152 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 153 */       if (t9 != null) {
/* 154 */         this._parent._dateValue = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._decimalValue = argResultSet.getBigDecimal(10);
/*     */       
/* 162 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 163 */       if (t11 != null) {
/* 164 */         this._parent._createDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 167 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 170 */       this._parent._createUserId = argResultSet.getString(12);
/*     */       
/* 172 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 173 */       if (t13 != null) {
/* 174 */         this._parent._updateDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 177 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 180 */       this._parent._updateUserId = argResultSet.getString(14);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 185 */     argDAO.suppressStateChanges(true);
/* 186 */     ItemLabelBatchPropertyDAO dao = (ItemLabelBatchPropertyDAO)argDAO;
/* 187 */     dao.setOrganizationId(this._organizationId);
/* 188 */     dao.setRetailLocationId(this._retailLocationId);
/* 189 */     dao.setBatchName(this._batchName);
/* 190 */     dao.setItemId(this._itemId);
/* 191 */     dao.setStockLabel(this._stockLabel);
/* 192 */     dao.setPropertyCode(this._propertyCode);
/* 193 */     dao.setType(this._type);
/* 194 */     dao.setStringValue(this._stringValue);
/* 195 */     dao.setDateValue(this._dateValue);
/* 196 */     dao.setDecimalValue(this._decimalValue);
/* 197 */     dao.setCreateDate(this._createDate);
/* 198 */     dao.setCreateUserId(this._createUserId);
/* 199 */     dao.setUpdateDate(this._updateDate);
/* 200 */     dao.setUpdateUserId(this._updateUserId);
/* 201 */     argDAO.suppressStateChanges(false);
/* 202 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 206 */     return loadDAO((IDataAccessObject)new ItemLabelBatchPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 210 */     ItemLabelBatchPropertyDAO dao = (ItemLabelBatchPropertyDAO)argDAO;
/* 211 */     this._organizationId = dao.getOrganizationId();
/* 212 */     this._retailLocationId = dao.getRetailLocationId();
/* 213 */     this._batchName = dao.getBatchName();
/* 214 */     this._itemId = dao.getItemId();
/* 215 */     this._stockLabel = dao.getStockLabel();
/* 216 */     this._propertyCode = dao.getPropertyCode();
/* 217 */     this._type = dao.getType();
/* 218 */     this._stringValue = dao.getStringValue();
/* 219 */     this._dateValue = dao.getDateValue();
/* 220 */     this._decimalValue = dao.getDecimalValue();
/* 221 */     this._createDate = dao.getCreateDate();
/* 222 */     this._createUserId = dao.getCreateUserId();
/* 223 */     this._updateDate = dao.getUpdateDate();
/* 224 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 228 */     ItemLabelBatchPropertyId id = (ItemLabelBatchPropertyId)argId;
/* 229 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 230 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 231 */     argStatement.setString(3, id.getBatchName());
/* 232 */     argStatement.setString(4, id.getItemId());
/* 233 */     argStatement.setString(5, id.getStockLabel());
/* 234 */     argStatement.setString(6, id.getPropertyCode());
/* 235 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 239 */     ItemLabelBatchPropertyId id = new ItemLabelBatchPropertyId();
/* 240 */     id.setOrganizationId(this._organizationId);
/* 241 */     id.setRetailLocationId(this._retailLocationId);
/* 242 */     id.setBatchName(this._batchName);
/* 243 */     id.setItemId(this._itemId);
/* 244 */     id.setStockLabel(this._stockLabel);
/* 245 */     id.setPropertyCode(this._propertyCode);
/* 246 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 254 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 258 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemLabelBatchPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */