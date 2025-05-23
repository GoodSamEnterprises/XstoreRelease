/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tax.PostalCodeMappingId;
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
/*     */ public class PostalCodeMappingDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1218085834L;
/*     */   private String _city;
/*     */   private Long _organizationId;
/*     */   private String _postalCode;
/*     */   private String _taxLocationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.city, t.organization_id, t.postal_code, t.tax_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tax_postal_code_mapping t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE city = ?  AND organization_id = ?  AND postal_code = ?  AND tax_loc_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  37 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  41 */     return "SELECT t.city, t.organization_id, t.postal_code, t.tax_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tax_postal_code_mapping t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  47 */     return " WHERE city = ?  AND organization_id = ?  AND postal_code = ?  AND tax_loc_id = ?  ";
/*     */   }
/*     */   
/*  50 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tax_postal_code_mapping(city, organization_id, postal_code, tax_loc_id, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  53 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  57 */     Object[][] insertParameterObject = { { this._city, this._organizationId, this._postalCode, this._taxLocationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  58 */     return insertParameterObject;
/*     */   }
/*     */   
/*  61 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 12, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  64 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  67 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tax_postal_code_mapping SET update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  70 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  74 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId } };
/*  75 */     return updateParameterObject;
/*     */   }
/*     */   
/*  78 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  80 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  83 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tax_postal_code_mapping" }; private static final String WHERE_OBJECT = " WHERE city = ?  AND organization_id = ?  AND postal_code = ?  AND tax_loc_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  86 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  92 */     return " WHERE city = ?  AND organization_id = ?  AND postal_code = ?  AND tax_loc_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  95 */     return new Object[] { this._city, this._organizationId, this._postalCode, this._taxLocationId };
/*     */   }
/*     */   
/*  98 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 101 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 104 */     return "tax_postal_code_mapping";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 108 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 112 */     return new PostalCodeMappingFiller(this);
/*     */   }
/*     */   
/*     */   private static class PostalCodeMappingFiller
/*     */     implements IFiller {
/*     */     private PostalCodeMappingDBA _parent;
/*     */     
/*     */     public PostalCodeMappingFiller(PostalCodeMappingDBA argParent) {
/* 120 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 123 */       this._parent._city = argResultSet.getString(1);
/*     */ 
/*     */       
/* 126 */       long primitiveResult = argResultSet.getLong(2);
/* 127 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 128 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 132 */       this._parent._postalCode = argResultSet.getString(3);
/* 133 */       this._parent._taxLocationId = argResultSet.getString(4);
/*     */       
/* 135 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 136 */       if (t5 != null) {
/* 137 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 140 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 143 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 145 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 146 */       if (t7 != null) {
/* 147 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._updateUserId = argResultSet.getString(8);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 158 */     argDAO.suppressStateChanges(true);
/* 159 */     PostalCodeMappingDAO dao = (PostalCodeMappingDAO)argDAO;
/* 160 */     dao.setCity(this._city);
/* 161 */     dao.setOrganizationId(this._organizationId);
/* 162 */     dao.setPostalCode(this._postalCode);
/* 163 */     dao.setTaxLocationId(this._taxLocationId);
/* 164 */     dao.setCreateDate(this._createDate);
/* 165 */     dao.setCreateUserId(this._createUserId);
/* 166 */     dao.setUpdateDate(this._updateDate);
/* 167 */     dao.setUpdateUserId(this._updateUserId);
/* 168 */     argDAO.suppressStateChanges(false);
/* 169 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 173 */     return loadDAO((IDataAccessObject)new PostalCodeMappingDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 177 */     PostalCodeMappingDAO dao = (PostalCodeMappingDAO)argDAO;
/* 178 */     this._city = dao.getCity();
/* 179 */     this._organizationId = dao.getOrganizationId();
/* 180 */     this._postalCode = dao.getPostalCode();
/* 181 */     this._taxLocationId = dao.getTaxLocationId();
/* 182 */     this._createDate = dao.getCreateDate();
/* 183 */     this._createUserId = dao.getCreateUserId();
/* 184 */     this._updateDate = dao.getUpdateDate();
/* 185 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 189 */     PostalCodeMappingId id = (PostalCodeMappingId)argId;
/* 190 */     argStatement.setString(1, id.getCity());
/* 191 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 192 */     argStatement.setString(3, id.getPostalCode());
/* 193 */     argStatement.setString(4, id.getTaxLocationId());
/* 194 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 198 */     PostalCodeMappingId id = new PostalCodeMappingId();
/* 199 */     id.setCity(this._city);
/* 200 */     id.setOrganizationId(this._organizationId);
/* 201 */     id.setPostalCode(this._postalCode);
/* 202 */     id.setTaxLocationId(this._taxLocationId);
/* 203 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 211 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 215 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\PostalCodeMappingDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */