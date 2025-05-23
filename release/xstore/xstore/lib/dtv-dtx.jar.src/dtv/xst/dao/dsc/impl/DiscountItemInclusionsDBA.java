/*     */ package dtv.xst.dao.dsc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.dsc.DiscountItemInclusionsId;
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
/*     */ public class DiscountItemInclusionsDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -844796405L;
/*     */   private String _discountCode;
/*     */   private String _itemId;
/*     */   private Long _organizationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.discount_code, t.item_id, t.organization_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM dsc_discount_item_inclusions t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE discount_code = ?  AND item_id = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  36 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  40 */     return "SELECT t.discount_code, t.item_id, t.organization_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM dsc_discount_item_inclusions t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  46 */     return " WHERE discount_code = ?  AND item_id = ?  AND organization_id = ?  ";
/*     */   }
/*     */   
/*  49 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO dsc_discount_item_inclusions(discount_code, item_id, organization_id, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  52 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  56 */     Object[][] insertParameterObject = { { this._discountCode, this._itemId, this._organizationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  57 */     return insertParameterObject;
/*     */   }
/*     */   
/*  60 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, 12, -5, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  63 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  66 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE dsc_discount_item_inclusions SET update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  69 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  73 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId } };
/*  74 */     return updateParameterObject;
/*     */   }
/*     */   
/*  77 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  79 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  82 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM dsc_discount_item_inclusions" }; private static final String WHERE_OBJECT = " WHERE discount_code = ?  AND item_id = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  85 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  91 */     return " WHERE discount_code = ?  AND item_id = ?  AND organization_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  94 */     return new Object[] { this._discountCode, this._itemId, this._organizationId };
/*     */   }
/*     */   
/*  97 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 100 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 103 */     return "dsc_discount_item_inclusions";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 107 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 111 */     return new DiscountItemInclusionsFiller(this);
/*     */   }
/*     */   
/*     */   private static class DiscountItemInclusionsFiller
/*     */     implements IFiller {
/*     */     private DiscountItemInclusionsDBA _parent;
/*     */     
/*     */     public DiscountItemInclusionsFiller(DiscountItemInclusionsDBA argParent) {
/* 119 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 122 */       this._parent._discountCode = argResultSet.getString(1);
/* 123 */       this._parent._itemId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 126 */       long primitiveResult = argResultSet.getLong(3);
/* 127 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 128 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 133 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 134 */       if (t4 != null) {
/* 135 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 138 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 141 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 143 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 144 */       if (t6 != null) {
/* 145 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 148 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 151 */       this._parent._updateUserId = argResultSet.getString(7);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 156 */     argDAO.suppressStateChanges(true);
/* 157 */     DiscountItemInclusionsDAO dao = (DiscountItemInclusionsDAO)argDAO;
/* 158 */     dao.setDiscountCode(this._discountCode);
/* 159 */     dao.setItemId(this._itemId);
/* 160 */     dao.setOrganizationId(this._organizationId);
/* 161 */     dao.setCreateDate(this._createDate);
/* 162 */     dao.setCreateUserId(this._createUserId);
/* 163 */     dao.setUpdateDate(this._updateDate);
/* 164 */     dao.setUpdateUserId(this._updateUserId);
/* 165 */     argDAO.suppressStateChanges(false);
/* 166 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 170 */     return loadDAO((IDataAccessObject)new DiscountItemInclusionsDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 174 */     DiscountItemInclusionsDAO dao = (DiscountItemInclusionsDAO)argDAO;
/* 175 */     this._discountCode = dao.getDiscountCode();
/* 176 */     this._itemId = dao.getItemId();
/* 177 */     this._organizationId = dao.getOrganizationId();
/* 178 */     this._createDate = dao.getCreateDate();
/* 179 */     this._createUserId = dao.getCreateUserId();
/* 180 */     this._updateDate = dao.getUpdateDate();
/* 181 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 185 */     DiscountItemInclusionsId id = (DiscountItemInclusionsId)argId;
/* 186 */     argStatement.setString(1, id.getDiscountCode());
/* 187 */     argStatement.setString(2, id.getItemId());
/* 188 */     argStatement.setLong(3, id.getOrganizationId().longValue());
/* 189 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 193 */     DiscountItemInclusionsId id = new DiscountItemInclusionsId();
/* 194 */     id.setDiscountCode(this._discountCode);
/* 195 */     id.setItemId(this._itemId);
/* 196 */     id.setOrganizationId(this._organizationId);
/* 197 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 205 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 209 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\impl\DiscountItemInclusionsDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */