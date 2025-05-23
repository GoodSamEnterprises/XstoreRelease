/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemLabelBatchId;
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
/*     */ public class ItemLabelBatchDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -51165127L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _batchName;
/*     */   private String _itemId;
/*     */   private String _stockLabel;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _count;
/*     */   private BigDecimal _overridenPrice;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.batch_name, t.item_id, t.stock_label, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.count, t.overriden_price FROM itm_item_label_batch t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND batch_name = ?  AND item_id = ?  AND stock_label = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.rtl_loc_id, t.batch_name, t.item_id, t.stock_label, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.count, t.overriden_price FROM itm_item_label_batch t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND batch_name = ?  AND item_id = ?  AND stock_label = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_label_batch(organization_id, rtl_loc_id, batch_name, item_id, stock_label, create_date, create_user_id, update_date, update_user_id, count, overriden_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._batchName, this._itemId, this._stockLabel, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._count, this._overridenPrice } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 12, 91, 12, 91, 12, -5, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_label_batch SET update_date = ?, update_user_id = ?, count = ?, overriden_price = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._count, this._overridenPrice } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -5, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_label_batch" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND batch_name = ?  AND item_id = ?  AND stock_label = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND batch_name = ?  AND item_id = ?  AND stock_label = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._retailLocationId, this._batchName, this._itemId, this._stockLabel };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "itm_item_label_batch";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new ItemLabelBatchFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemLabelBatchFiller
/*     */     implements IFiller {
/*     */     private ItemLabelBatchDBA _parent;
/*     */     
/*     */     public ItemLabelBatchFiller(ItemLabelBatchDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       long primitiveResult = argResultSet.getLong(1);
/* 129 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 130 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 136 */       primitiveResult = argResultSet.getLong(2);
/* 137 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 138 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 142 */       this._parent._batchName = argResultSet.getString(3);
/* 143 */       this._parent._itemId = argResultSet.getString(4);
/* 144 */       this._parent._stockLabel = argResultSet.getString(5);
/*     */       
/* 146 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 147 */       if (t6 != null) {
/* 148 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 154 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 156 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 157 */       if (t8 != null) {
/* 158 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 161 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 164 */       this._parent._updateUserId = argResultSet.getString(9);
/*     */ 
/*     */       
/* 167 */       long l1 = argResultSet.getLong(10);
/* 168 */       if (l1 != 0L || argResultSet.getObject(10) != null) {
/* 169 */         this._parent._count = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 173 */       this._parent._overridenPrice = argResultSet.getBigDecimal(11);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 178 */     argDAO.suppressStateChanges(true);
/* 179 */     ItemLabelBatchDAO dao = (ItemLabelBatchDAO)argDAO;
/* 180 */     dao.setOrganizationId(this._organizationId);
/* 181 */     dao.setRetailLocationId(this._retailLocationId);
/* 182 */     dao.setBatchName(this._batchName);
/* 183 */     dao.setItemId(this._itemId);
/* 184 */     dao.setStockLabel(this._stockLabel);
/* 185 */     dao.setCreateDate(this._createDate);
/* 186 */     dao.setCreateUserId(this._createUserId);
/* 187 */     dao.setUpdateDate(this._updateDate);
/* 188 */     dao.setUpdateUserId(this._updateUserId);
/* 189 */     dao.setCount(this._count);
/* 190 */     dao.setOverridenPrice(this._overridenPrice);
/* 191 */     argDAO.suppressStateChanges(false);
/* 192 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 196 */     return loadDAO((IDataAccessObject)new ItemLabelBatchDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 200 */     ItemLabelBatchDAO dao = (ItemLabelBatchDAO)argDAO;
/* 201 */     this._organizationId = dao.getOrganizationId();
/* 202 */     this._retailLocationId = dao.getRetailLocationId();
/* 203 */     this._batchName = dao.getBatchName();
/* 204 */     this._itemId = dao.getItemId();
/* 205 */     this._stockLabel = dao.getStockLabel();
/* 206 */     this._createDate = dao.getCreateDate();
/* 207 */     this._createUserId = dao.getCreateUserId();
/* 208 */     this._updateDate = dao.getUpdateDate();
/* 209 */     this._updateUserId = dao.getUpdateUserId();
/* 210 */     this._count = dao.getCount();
/* 211 */     this._overridenPrice = dao.getOverridenPrice();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 215 */     ItemLabelBatchId id = (ItemLabelBatchId)argId;
/* 216 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 217 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 218 */     argStatement.setString(3, id.getBatchName());
/* 219 */     argStatement.setString(4, id.getItemId());
/* 220 */     argStatement.setString(5, id.getStockLabel());
/* 221 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 225 */     ItemLabelBatchId id = new ItemLabelBatchId();
/* 226 */     id.setOrganizationId(this._organizationId);
/* 227 */     id.setRetailLocationId(this._retailLocationId);
/* 228 */     id.setBatchName(this._batchName);
/* 229 */     id.setItemId(this._itemId);
/* 230 */     id.setStockLabel(this._stockLabel);
/* 231 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 239 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 243 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemLabelBatchDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */