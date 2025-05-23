/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.SerializedStockLedgerId;
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
/*     */ 
/*     */ public class SerializedStockLedgerDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 313200603L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _invLocationId;
/*     */   private String _itemId;
/*     */   private String _serialNumber;
/*     */   private String _bucketId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.inv_location_id, t.item_id, t.serial_nbr, t.bucket_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM inv_serialized_stock_ledger t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_location_id = ?  AND item_id = ?  AND serial_nbr = ?  AND bucket_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.rtl_loc_id, t.inv_location_id, t.item_id, t.serial_nbr, t.bucket_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM inv_serialized_stock_ledger t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_location_id = ?  AND item_id = ?  AND serial_nbr = ?  AND bucket_id = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_serialized_stock_ledger(organization_id, rtl_loc_id, inv_location_id, item_id, serial_nbr, bucket_id, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._invLocationId, this._itemId, this._serialNumber, this._bucketId, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 12, 12, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_serialized_stock_ledger SET update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_serialized_stock_ledger" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_location_id = ?  AND item_id = ?  AND serial_nbr = ?  AND bucket_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_location_id = ?  AND item_id = ?  AND serial_nbr = ?  AND bucket_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._retailLocationId, this._invLocationId, this._itemId, this._serialNumber, this._bucketId };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "inv_serialized_stock_ledger";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new SerializedStockLedgerFiller(this);
/*     */   }
/*     */   
/*     */   private static class SerializedStockLedgerFiller
/*     */     implements IFiller {
/*     */     private SerializedStockLedgerDBA _parent;
/*     */     
/*     */     public SerializedStockLedgerFiller(SerializedStockLedgerDBA argParent) {
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
/*     */ 
/*     */       
/* 135 */       primitiveResult = argResultSet.getLong(2);
/* 136 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 137 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 141 */       this._parent._invLocationId = argResultSet.getString(3);
/* 142 */       this._parent._itemId = argResultSet.getString(4);
/* 143 */       this._parent._serialNumber = argResultSet.getString(5);
/* 144 */       this._parent._bucketId = argResultSet.getString(6);
/*     */       
/* 146 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 147 */       if (t7 != null) {
/* 148 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 154 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 156 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 157 */       if (t9 != null) {
/* 158 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 161 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 164 */       this._parent._updateUserId = argResultSet.getString(10);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 169 */     argDAO.suppressStateChanges(true);
/* 170 */     SerializedStockLedgerDAO dao = (SerializedStockLedgerDAO)argDAO;
/* 171 */     dao.setOrganizationId(this._organizationId);
/* 172 */     dao.setRetailLocationId(this._retailLocationId);
/* 173 */     dao.setInvLocationId(this._invLocationId);
/* 174 */     dao.setItemId(this._itemId);
/* 175 */     dao.setSerialNumber(this._serialNumber);
/* 176 */     dao.setBucketId(this._bucketId);
/* 177 */     dao.setCreateDate(this._createDate);
/* 178 */     dao.setCreateUserId(this._createUserId);
/* 179 */     dao.setUpdateDate(this._updateDate);
/* 180 */     dao.setUpdateUserId(this._updateUserId);
/* 181 */     argDAO.suppressStateChanges(false);
/* 182 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 186 */     return loadDAO((IDataAccessObject)new SerializedStockLedgerDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 190 */     SerializedStockLedgerDAO dao = (SerializedStockLedgerDAO)argDAO;
/* 191 */     this._organizationId = dao.getOrganizationId();
/* 192 */     this._retailLocationId = dao.getRetailLocationId();
/* 193 */     this._invLocationId = dao.getInvLocationId();
/* 194 */     this._itemId = dao.getItemId();
/* 195 */     this._serialNumber = dao.getSerialNumber();
/* 196 */     this._bucketId = dao.getBucketId();
/* 197 */     this._createDate = dao.getCreateDate();
/* 198 */     this._createUserId = dao.getCreateUserId();
/* 199 */     this._updateDate = dao.getUpdateDate();
/* 200 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 204 */     SerializedStockLedgerId id = (SerializedStockLedgerId)argId;
/* 205 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 206 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 207 */     argStatement.setString(3, id.getInvLocationId());
/* 208 */     argStatement.setString(4, id.getItemId());
/* 209 */     argStatement.setString(5, id.getSerialNumber());
/* 210 */     argStatement.setString(6, id.getBucketId());
/* 211 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 215 */     SerializedStockLedgerId id = new SerializedStockLedgerId();
/* 216 */     id.setOrganizationId(this._organizationId);
/* 217 */     id.setRetailLocationId(this._retailLocationId);
/* 218 */     id.setInvLocationId(this._invLocationId);
/* 219 */     id.setItemId(this._itemId);
/* 220 */     id.setSerialNumber(this._serialNumber);
/* 221 */     id.setBucketId(this._bucketId);
/* 222 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 230 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 234 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\SerializedStockLedgerDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */