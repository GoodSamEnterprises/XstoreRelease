/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.com.ReportLookupId;
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
/*     */ public class ReportLookupDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 562595822L;
/*     */   private Long _organizationId;
/*     */   private String _ownerId;
/*     */   private String _ownerType;
/*     */   private String _reportId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _reportUrl;
/*     */   private String _description;
/*     */   private String _recordType;
/*     */   private Date _recordCreationDate;
/*     */   private String _recordLevel;
/*     */   private String _parentReportId;
/*     */   private Boolean _delete;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.owner_id, t.owner_type_enum, t.report_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.report_url, t.description, t.record_type_enum, t.record_creation_date, t.record_level_enum, t.parent_report_id, t.delete_flag FROM com_report_lookup t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND owner_id = ?  AND owner_type_enum = ?  AND report_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.organization_id, t.owner_id, t.owner_type_enum, t.report_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.report_url, t.description, t.record_type_enum, t.record_creation_date, t.record_level_enum, t.parent_report_id, t.delete_flag FROM com_report_lookup t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  56 */     return " WHERE organization_id = ?  AND owner_id = ?  AND owner_type_enum = ?  AND report_id = ?  ";
/*     */   }
/*     */   
/*  59 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_report_lookup(organization_id, owner_id, owner_type_enum, report_id, create_date, create_user_id, update_date, update_user_id, org_code, org_value, report_url, description, record_type_enum, record_creation_date, record_level_enum, parent_report_id, delete_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  62 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._organizationId, this._ownerId, this._ownerType, this._reportId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._reportUrl, this._description, this._recordType, this._recordCreationDate, this._recordLevel, this._parentReportId, this._delete } };
/*  67 */     return insertParameterObject;
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 12, 91, 12, 12, 12, 12, 12, 12, 91, 12, 12, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_report_lookup SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, report_url = ?, description = ?, record_type_enum = ?, record_creation_date = ?, record_level_enum = ?, parent_report_id = ?, delete_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  83 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._reportUrl, this._description, this._recordType, this._recordCreationDate, this._recordLevel, this._parentReportId, this._delete } };
/*  84 */     return updateParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 91, 12, 12, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_report_lookup" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND owner_id = ?  AND owner_type_enum = ?  AND report_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  95 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 101 */     return " WHERE organization_id = ?  AND owner_id = ?  AND owner_type_enum = ?  AND report_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 104 */     return new Object[] { this._organizationId, this._ownerId, this._ownerType, this._reportId };
/*     */   }
/*     */   
/* 107 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 110 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 113 */     return "com_report_lookup";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 117 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 121 */     return new ReportLookupFiller(this);
/*     */   }
/*     */   
/*     */   private static class ReportLookupFiller
/*     */     implements IFiller {
/*     */     private ReportLookupDBA _parent;
/*     */     
/*     */     public ReportLookupFiller(ReportLookupDBA argParent) {
/* 129 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 134 */       long primitiveResult = argResultSet.getLong(1);
/* 135 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 136 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 140 */       this._parent._ownerId = argResultSet.getString(2);
/* 141 */       this._parent._ownerType = argResultSet.getString(3);
/* 142 */       this._parent._reportId = argResultSet.getString(4);
/*     */       
/* 144 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 145 */       if (t5 != null) {
/* 146 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 154 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 155 */       if (t7 != null) {
/* 156 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 159 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 162 */       this._parent._updateUserId = argResultSet.getString(8);
/* 163 */       this._parent._orgCode = argResultSet.getString(9);
/* 164 */       this._parent._orgValue = argResultSet.getString(10);
/* 165 */       this._parent._reportUrl = argResultSet.getString(11);
/* 166 */       this._parent._description = argResultSet.getString(12);
/* 167 */       this._parent._recordType = argResultSet.getString(13);
/*     */       
/* 169 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 170 */       if (t14 != null) {
/* 171 */         this._parent._recordCreationDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 174 */         this._parent._recordCreationDate = null;
/*     */       } 
/*     */       
/* 177 */       this._parent._recordLevel = argResultSet.getString(15);
/* 178 */       this._parent._parentReportId = argResultSet.getString(16);
/* 179 */       this._parent._delete = Boolean.valueOf(argResultSet.getBoolean(17));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 184 */     argDAO.suppressStateChanges(true);
/* 185 */     ReportLookupDAO dao = (ReportLookupDAO)argDAO;
/* 186 */     dao.setOrganizationId(this._organizationId);
/* 187 */     dao.setOwnerId(this._ownerId);
/* 188 */     dao.setOwnerType(this._ownerType);
/* 189 */     dao.setReportId(this._reportId);
/* 190 */     dao.setCreateDate(this._createDate);
/* 191 */     dao.setCreateUserId(this._createUserId);
/* 192 */     dao.setUpdateDate(this._updateDate);
/* 193 */     dao.setUpdateUserId(this._updateUserId);
/* 194 */     dao.setOrgCode(this._orgCode);
/* 195 */     dao.setOrgValue(this._orgValue);
/* 196 */     dao.setReportUrl(this._reportUrl);
/* 197 */     dao.setDescription(this._description);
/* 198 */     dao.setRecordType(this._recordType);
/* 199 */     dao.setRecordCreationDate(this._recordCreationDate);
/* 200 */     dao.setRecordLevel(this._recordLevel);
/* 201 */     dao.setParentReportId(this._parentReportId);
/* 202 */     dao.setDelete(this._delete);
/* 203 */     argDAO.suppressStateChanges(false);
/* 204 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 208 */     return loadDAO((IDataAccessObject)new ReportLookupDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 212 */     ReportLookupDAO dao = (ReportLookupDAO)argDAO;
/* 213 */     this._organizationId = dao.getOrganizationId();
/* 214 */     this._ownerId = dao.getOwnerId();
/* 215 */     this._ownerType = dao.getOwnerType();
/* 216 */     this._reportId = dao.getReportId();
/* 217 */     this._createDate = dao.getCreateDate();
/* 218 */     this._createUserId = dao.getCreateUserId();
/* 219 */     this._updateDate = dao.getUpdateDate();
/* 220 */     this._updateUserId = dao.getUpdateUserId();
/* 221 */     this._orgCode = dao.getOrgCode();
/* 222 */     this._orgValue = dao.getOrgValue();
/* 223 */     this._reportUrl = dao.getReportUrl();
/* 224 */     this._description = dao.getDescription();
/* 225 */     this._recordType = dao.getRecordType();
/* 226 */     this._recordCreationDate = dao.getRecordCreationDate();
/* 227 */     this._recordLevel = dao.getRecordLevel();
/* 228 */     this._parentReportId = dao.getParentReportId();
/* 229 */     this._delete = (dao.getDelete() != null) ? dao.getDelete() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 233 */     ReportLookupId id = (ReportLookupId)argId;
/* 234 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 235 */     argStatement.setString(2, id.getOwnerId());
/* 236 */     argStatement.setString(3, id.getOwnerType());
/* 237 */     argStatement.setString(4, id.getReportId());
/* 238 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 242 */     ReportLookupId id = new ReportLookupId();
/* 243 */     id.setOrganizationId(this._organizationId);
/* 244 */     id.setOwnerId(this._ownerId);
/* 245 */     id.setOwnerType(this._ownerType);
/* 246 */     id.setReportId(this._reportId);
/* 247 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 255 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 259 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ReportLookupDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */