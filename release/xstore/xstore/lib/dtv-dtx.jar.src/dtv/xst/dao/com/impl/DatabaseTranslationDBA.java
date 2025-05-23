/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.com.DatabaseTranslationId;
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
/*     */ public class DatabaseTranslationDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1081353750L;
/*     */   private Long _organizationId;
/*     */   private String _locale;
/*     */   private String _translationKey;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _translation;
/*     */   private String _externalSystem;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.locale, t.translation_key, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.translation, t.external_system FROM com_translations t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND locale = ?  AND translation_key = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.locale, t.translation_key, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.translation, t.external_system FROM com_translations t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND locale = ?  AND translation_key = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_translations(organization_id, locale, translation_key, create_date, create_user_id, update_date, update_user_id, org_code, org_value, translation, external_system) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._locale, this._translationKey, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._translation, this._externalSystem } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_translations SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, translation = ?, external_system = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._translation, this._externalSystem } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_translations" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND locale = ?  AND translation_key = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND locale = ?  AND translation_key = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._locale, this._translationKey };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "com_translations";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new DatabaseTranslationFiller(this);
/*     */   }
/*     */   
/*     */   private static class DatabaseTranslationFiller
/*     */     implements IFiller {
/*     */     private DatabaseTranslationDBA _parent;
/*     */     
/*     */     public DatabaseTranslationFiller(DatabaseTranslationDBA argParent) {
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
/* 134 */       this._parent._locale = argResultSet.getString(2);
/* 135 */       this._parent._translationKey = argResultSet.getString(3);
/*     */       
/* 137 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 138 */       if (t4 != null) {
/* 139 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 142 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 145 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 147 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 148 */       if (t6 != null) {
/* 149 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 152 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 155 */       this._parent._updateUserId = argResultSet.getString(7);
/* 156 */       this._parent._orgCode = argResultSet.getString(8);
/* 157 */       this._parent._orgValue = argResultSet.getString(9);
/* 158 */       this._parent._translation = argResultSet.getString(10);
/* 159 */       this._parent._externalSystem = argResultSet.getString(11);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 164 */     argDAO.suppressStateChanges(true);
/* 165 */     DatabaseTranslationDAO dao = (DatabaseTranslationDAO)argDAO;
/* 166 */     dao.setOrganizationId(this._organizationId);
/* 167 */     dao.setLocale(this._locale);
/* 168 */     dao.setTranslationKey(this._translationKey);
/* 169 */     dao.setCreateDate(this._createDate);
/* 170 */     dao.setCreateUserId(this._createUserId);
/* 171 */     dao.setUpdateDate(this._updateDate);
/* 172 */     dao.setUpdateUserId(this._updateUserId);
/* 173 */     dao.setOrgCode(this._orgCode);
/* 174 */     dao.setOrgValue(this._orgValue);
/* 175 */     dao.setTranslation(this._translation);
/* 176 */     dao.setExternalSystem(this._externalSystem);
/* 177 */     argDAO.suppressStateChanges(false);
/* 178 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 182 */     return loadDAO((IDataAccessObject)new DatabaseTranslationDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 186 */     DatabaseTranslationDAO dao = (DatabaseTranslationDAO)argDAO;
/* 187 */     this._organizationId = dao.getOrganizationId();
/* 188 */     this._locale = dao.getLocale();
/* 189 */     this._translationKey = dao.getTranslationKey();
/* 190 */     this._createDate = dao.getCreateDate();
/* 191 */     this._createUserId = dao.getCreateUserId();
/* 192 */     this._updateDate = dao.getUpdateDate();
/* 193 */     this._updateUserId = dao.getUpdateUserId();
/* 194 */     this._orgCode = dao.getOrgCode();
/* 195 */     this._orgValue = dao.getOrgValue();
/* 196 */     this._translation = dao.getTranslation();
/* 197 */     this._externalSystem = dao.getExternalSystem();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 201 */     DatabaseTranslationId id = (DatabaseTranslationId)argId;
/* 202 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 203 */     argStatement.setString(2, id.getLocale());
/* 204 */     argStatement.setString(3, id.getTranslationKey());
/* 205 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 209 */     DatabaseTranslationId id = new DatabaseTranslationId();
/* 210 */     id.setOrganizationId(this._organizationId);
/* 211 */     id.setLocale(this._locale);
/* 212 */     id.setTranslationKey(this._translationKey);
/* 213 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 221 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 225 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\DatabaseTranslationDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */