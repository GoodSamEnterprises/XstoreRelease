/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.com.CodeValueId;
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
/*     */ public class CodeValueDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 868073316L;
/*     */   private Long _organizationId;
/*     */   private String _category;
/*     */   private String _code;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _configElement;
/*     */   private String _description;
/*     */   private Integer _sortOrder;
/*     */   private Boolean _hidden;
/*     */   private Integer _rank;
/*     */   private String _imageUrl;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.category, t.code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.config_element, t.description, t.sort_order, t.hidden_flag, t.rank, t.image_url FROM com_code_value t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND category = ?  AND code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.category, t.code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.config_element, t.description, t.sort_order, t.hidden_flag, t.rank, t.image_url FROM com_code_value t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND category = ?  AND code = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_code_value(organization_id, category, code, create_date, create_user_id, update_date, update_user_id, config_element, description, sort_order, hidden_flag, rank, image_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._category, this._code, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._description, this._sortOrder, this._hidden, this._rank, this._imageUrl } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 12, 12, 4, -7, 4, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_code_value SET update_date = ?, update_user_id = ?, config_element = ?, description = ?, sort_order = ?, hidden_flag = ?, rank = ?, image_url = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._description, this._sortOrder, this._hidden, this._rank, this._imageUrl } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 4, -7, 4, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_code_value" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND category = ?  AND code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND category = ?  AND code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._category, this._code };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "com_code_value";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new CodeValueFiller(this);
/*     */   }
/*     */   
/*     */   private static class CodeValueFiller
/*     */     implements IFiller {
/*     */     private CodeValueDBA _parent;
/*     */     
/*     */     public CodeValueFiller(CodeValueDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       long primitiveResult = argResultSet.getLong(1);
/* 131 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 132 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 136 */       this._parent._category = argResultSet.getString(2);
/* 137 */       this._parent._code = argResultSet.getString(3);
/*     */       
/* 139 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 140 */       if (t4 != null) {
/* 141 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 147 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 149 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 150 */       if (t6 != null) {
/* 151 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._updateUserId = argResultSet.getString(7);
/* 158 */       this._parent._configElement = argResultSet.getString(8);
/* 159 */       this._parent._description = argResultSet.getString(9);
/*     */ 
/*     */       
/* 162 */       int i = argResultSet.getInt(10);
/* 163 */       if (i != 0 || argResultSet.getObject(10) != null) {
/* 164 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 168 */       this._parent._hidden = Boolean.valueOf(argResultSet.getBoolean(11));
/*     */ 
/*     */       
/* 171 */       i = argResultSet.getInt(12);
/* 172 */       if (i != 0 || argResultSet.getObject(12) != null) {
/* 173 */         this._parent._rank = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 177 */       this._parent._imageUrl = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 182 */     argDAO.suppressStateChanges(true);
/* 183 */     CodeValueDAO dao = (CodeValueDAO)argDAO;
/* 184 */     dao.setOrganizationId(this._organizationId);
/* 185 */     dao.setCategory(this._category);
/* 186 */     dao.setCode(this._code);
/* 187 */     dao.setCreateDate(this._createDate);
/* 188 */     dao.setCreateUserId(this._createUserId);
/* 189 */     dao.setUpdateDate(this._updateDate);
/* 190 */     dao.setUpdateUserId(this._updateUserId);
/* 191 */     dao.setConfigElement(this._configElement);
/* 192 */     dao.setDescription(this._description);
/* 193 */     dao.setSortOrder(this._sortOrder);
/* 194 */     dao.setHidden(this._hidden);
/* 195 */     dao.setRank(this._rank);
/* 196 */     dao.setImageUrl(this._imageUrl);
/* 197 */     argDAO.suppressStateChanges(false);
/* 198 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 202 */     return loadDAO((IDataAccessObject)new CodeValueDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 206 */     CodeValueDAO dao = (CodeValueDAO)argDAO;
/* 207 */     this._organizationId = dao.getOrganizationId();
/* 208 */     this._category = dao.getCategory();
/* 209 */     this._code = dao.getCode();
/* 210 */     this._createDate = dao.getCreateDate();
/* 211 */     this._createUserId = dao.getCreateUserId();
/* 212 */     this._updateDate = dao.getUpdateDate();
/* 213 */     this._updateUserId = dao.getUpdateUserId();
/* 214 */     this._configElement = dao.getConfigElement();
/* 215 */     this._description = dao.getDescription();
/* 216 */     this._sortOrder = dao.getSortOrder();
/* 217 */     this._hidden = (dao.getHidden() != null) ? dao.getHidden() : Boolean.valueOf(false);
/* 218 */     this._rank = dao.getRank();
/* 219 */     this._imageUrl = dao.getImageUrl();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 223 */     CodeValueId id = (CodeValueId)argId;
/* 224 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 225 */     argStatement.setString(2, id.getCategory());
/* 226 */     argStatement.setString(3, id.getCode());
/* 227 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 231 */     CodeValueId id = new CodeValueId();
/* 232 */     id.setOrganizationId(this._organizationId);
/* 233 */     id.setCategory(this._category);
/* 234 */     id.setCode(this._code);
/* 235 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 243 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 247 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\CodeValueDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */