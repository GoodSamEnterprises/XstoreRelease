/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.ItemModifierId;
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
/*     */ public class ItemModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 177238826L;
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private Integer _sequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _itemId;
/*     */   private String _description;
/*     */   private String _imageUrl;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.order_id, t.detail_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.item_id, t.description, t.image_url FROM xom_item_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.order_id, t.detail_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.item_id, t.description, t.image_url FROM xom_item_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO xom_item_mod(organization_id, order_id, detail_seq, create_date, create_user_id, update_date, update_user_id, item_id, description, image_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._orderId, this._sequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._itemId, this._description, this._imageUrl } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 91, 12, 91, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE xom_item_mod SET update_date = ?, update_user_id = ?, item_id = ?, description = ?, image_url = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._itemId, this._description, this._imageUrl } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM xom_item_mod" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._orderId, this._sequence };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "xom_item_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new ItemModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemModifierFiller
/*     */     implements IFiller {
/*     */     private ItemModifierDBA _parent;
/*     */     
/*     */     public ItemModifierFiller(ItemModifierDBA argParent) {
/* 122 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 127 */       long l = argResultSet.getLong(1);
/* 128 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 129 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 133 */       this._parent._orderId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 136 */       int primitiveResult = argResultSet.getInt(3);
/* 137 */       if (primitiveResult != 0 || argResultSet.getObject(3) != null) {
/* 138 */         this._parent._sequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 143 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 144 */       if (t4 != null) {
/* 145 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 148 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 151 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 153 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 154 */       if (t6 != null) {
/* 155 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 158 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 161 */       this._parent._updateUserId = argResultSet.getString(7);
/* 162 */       this._parent._itemId = argResultSet.getString(8);
/* 163 */       this._parent._description = argResultSet.getString(9);
/* 164 */       this._parent._imageUrl = argResultSet.getString(10);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 169 */     argDAO.suppressStateChanges(true);
/* 170 */     ItemModifierDAO dao = (ItemModifierDAO)argDAO;
/* 171 */     dao.setOrganizationId(this._organizationId);
/* 172 */     dao.setOrderId(this._orderId);
/* 173 */     dao.setSequence(this._sequence);
/* 174 */     dao.setCreateDate(this._createDate);
/* 175 */     dao.setCreateUserId(this._createUserId);
/* 176 */     dao.setUpdateDate(this._updateDate);
/* 177 */     dao.setUpdateUserId(this._updateUserId);
/* 178 */     dao.setItemId(this._itemId);
/* 179 */     dao.setDescription(this._description);
/* 180 */     dao.setImageUrl(this._imageUrl);
/* 181 */     argDAO.suppressStateChanges(false);
/* 182 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 186 */     return loadDAO((IDataAccessObject)new ItemModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 190 */     ItemModifierDAO dao = (ItemModifierDAO)argDAO;
/* 191 */     this._organizationId = dao.getOrganizationId();
/* 192 */     this._orderId = dao.getOrderId();
/* 193 */     this._sequence = dao.getSequence();
/* 194 */     this._createDate = dao.getCreateDate();
/* 195 */     this._createUserId = dao.getCreateUserId();
/* 196 */     this._updateDate = dao.getUpdateDate();
/* 197 */     this._updateUserId = dao.getUpdateUserId();
/* 198 */     this._itemId = dao.getItemId();
/* 199 */     this._description = dao.getDescription();
/* 200 */     this._imageUrl = dao.getImageUrl();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 204 */     ItemModifierId id = (ItemModifierId)argId;
/* 205 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 206 */     argStatement.setString(2, id.getOrderId());
/* 207 */     argStatement.setInt(3, id.getSequence().intValue());
/* 208 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 212 */     ItemModifierId id = new ItemModifierId();
/* 213 */     id.setOrganizationId(this._organizationId);
/* 214 */     id.setOrderId(this._orderId);
/* 215 */     id.setSequence(this._sequence);
/* 216 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 224 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 228 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\ItemModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */