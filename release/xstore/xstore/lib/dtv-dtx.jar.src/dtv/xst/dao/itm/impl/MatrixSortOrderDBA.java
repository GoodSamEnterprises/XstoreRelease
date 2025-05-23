/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.MatrixSortOrderId;
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
/*     */ public class MatrixSortOrderDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 647421295L;
/*     */   private Long _organizationId;
/*     */   private String _matrixSortType;
/*     */   private String _matrixSortId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Integer _sortOrder;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.matrix_sort_type, t.matrix_sort_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.sort_order FROM itm_matrix_sort_order t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND matrix_sort_type = ?  AND matrix_sort_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.matrix_sort_type, t.matrix_sort_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.sort_order FROM itm_matrix_sort_order t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND matrix_sort_type = ?  AND matrix_sort_id = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_matrix_sort_order(organization_id, matrix_sort_type, matrix_sort_id, org_code, org_value, create_date, create_user_id, update_date, update_user_id, sort_order) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._matrixSortType, this._matrixSortId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._sortOrder } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 12, 91, 12, 91, 12, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_matrix_sort_order SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, sort_order = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._sortOrder } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_matrix_sort_order" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND matrix_sort_type = ?  AND matrix_sort_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND matrix_sort_type = ?  AND matrix_sort_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._matrixSortType, this._matrixSortId };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "itm_matrix_sort_order";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new MatrixSortOrderFiller(this);
/*     */   }
/*     */   
/*     */   private static class MatrixSortOrderFiller
/*     */     implements IFiller {
/*     */     private MatrixSortOrderDBA _parent;
/*     */     
/*     */     public MatrixSortOrderFiller(MatrixSortOrderDBA argParent) {
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
/* 133 */       this._parent._matrixSortType = argResultSet.getString(2);
/* 134 */       this._parent._matrixSortId = argResultSet.getString(3);
/* 135 */       this._parent._orgCode = argResultSet.getString(4);
/* 136 */       this._parent._orgValue = argResultSet.getString(5);
/*     */       
/* 138 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 139 */       if (t6 != null) {
/* 140 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 143 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 146 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 148 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 149 */       if (t8 != null) {
/* 150 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 153 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 156 */       this._parent._updateUserId = argResultSet.getString(9);
/*     */ 
/*     */       
/* 159 */       int i = argResultSet.getInt(10);
/* 160 */       if (i != 0 || argResultSet.getObject(10) != null) {
/* 161 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 169 */     argDAO.suppressStateChanges(true);
/* 170 */     MatrixSortOrderDAO dao = (MatrixSortOrderDAO)argDAO;
/* 171 */     dao.setOrganizationId(this._organizationId);
/* 172 */     dao.setMatrixSortType(this._matrixSortType);
/* 173 */     dao.setMatrixSortId(this._matrixSortId);
/* 174 */     dao.setOrgCode(this._orgCode);
/* 175 */     dao.setOrgValue(this._orgValue);
/* 176 */     dao.setCreateDate(this._createDate);
/* 177 */     dao.setCreateUserId(this._createUserId);
/* 178 */     dao.setUpdateDate(this._updateDate);
/* 179 */     dao.setUpdateUserId(this._updateUserId);
/* 180 */     dao.setSortOrder(this._sortOrder);
/* 181 */     argDAO.suppressStateChanges(false);
/* 182 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 186 */     return loadDAO((IDataAccessObject)new MatrixSortOrderDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 190 */     MatrixSortOrderDAO dao = (MatrixSortOrderDAO)argDAO;
/* 191 */     this._organizationId = dao.getOrganizationId();
/* 192 */     this._matrixSortType = dao.getMatrixSortType();
/* 193 */     this._matrixSortId = dao.getMatrixSortId();
/* 194 */     this._orgCode = dao.getOrgCode();
/* 195 */     this._orgValue = dao.getOrgValue();
/* 196 */     this._createDate = dao.getCreateDate();
/* 197 */     this._createUserId = dao.getCreateUserId();
/* 198 */     this._updateDate = dao.getUpdateDate();
/* 199 */     this._updateUserId = dao.getUpdateUserId();
/* 200 */     this._sortOrder = dao.getSortOrder();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 204 */     MatrixSortOrderId id = (MatrixSortOrderId)argId;
/* 205 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 206 */     argStatement.setString(2, id.getMatrixSortType());
/* 207 */     argStatement.setString(3, id.getMatrixSortId());
/* 208 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 212 */     MatrixSortOrderId id = new MatrixSortOrderId();
/* 213 */     id.setOrganizationId(this._organizationId);
/* 214 */     id.setMatrixSortType(this._matrixSortType);
/* 215 */     id.setMatrixSortId(this._matrixSortId);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\MatrixSortOrderDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */