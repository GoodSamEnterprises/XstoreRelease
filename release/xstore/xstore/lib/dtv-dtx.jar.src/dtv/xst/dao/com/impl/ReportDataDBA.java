/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.com.ReportDataId;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class ReportDataDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -370615522L;
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
/*     */   private byte[] _reportData;
/*     */   private Boolean _delete;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.owner_id, t.owner_type_enum, t.report_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.report_data, t.delete_flag FROM com_report_data t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND owner_id = ?  AND owner_type_enum = ?  AND report_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.owner_id, t.owner_type_enum, t.report_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.report_data, t.delete_flag FROM com_report_data t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND owner_id = ?  AND owner_type_enum = ?  AND report_id = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_report_data(organization_id, owner_id, owner_type_enum, report_id, create_date, create_user_id, update_date, update_user_id, org_code, org_value, report_data, delete_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._ownerId, this._ownerType, this._reportId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._reportData, this._delete } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 12, 91, 12, 12, 12, -4, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_report_data SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, report_data = ?, delete_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._reportData, this._delete } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, -4, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_report_data" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND owner_id = ?  AND owner_type_enum = ?  AND report_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND owner_id = ?  AND owner_type_enum = ?  AND report_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._ownerId, this._ownerType, this._reportId };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "com_report_data";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new ReportDataFiller(this);
/*     */   }
/*     */   
/*     */   private static class ReportDataFiller
/*     */     implements IFiller {
/*     */     private ReportDataDBA _parent;
/*     */     
/*     */     public ReportDataFiller(ReportDataDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       long primitiveResult = argResultSet.getLong(1);
/* 130 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 135 */       this._parent._ownerId = argResultSet.getString(2);
/* 136 */       this._parent._ownerType = argResultSet.getString(3);
/* 137 */       this._parent._reportId = argResultSet.getString(4);
/*     */       
/* 139 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 140 */       if (t5 != null) {
/* 141 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 147 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 149 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 150 */       if (t7 != null) {
/* 151 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._updateUserId = argResultSet.getString(8);
/* 158 */       this._parent._orgCode = argResultSet.getString(9);
/* 159 */       this._parent._orgValue = argResultSet.getString(10);
/* 160 */       this._parent._reportData = argResultSet.getBytes(11);
/* 161 */       this._parent._delete = Boolean.valueOf(argResultSet.getBoolean(12));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 166 */     argDAO.suppressStateChanges(true);
/* 167 */     ReportDataDAO dao = (ReportDataDAO)argDAO;
/* 168 */     dao.setOrganizationId(this._organizationId);
/* 169 */     dao.setOwnerId(this._ownerId);
/* 170 */     dao.setOwnerType(this._ownerType);
/* 171 */     dao.setReportId(this._reportId);
/* 172 */     dao.setCreateDate(this._createDate);
/* 173 */     dao.setCreateUserId(this._createUserId);
/* 174 */     dao.setUpdateDate(this._updateDate);
/* 175 */     dao.setUpdateUserId(this._updateUserId);
/* 176 */     dao.setOrgCode(this._orgCode);
/* 177 */     dao.setOrgValue(this._orgValue);
/*     */     
/* 179 */     if (this._reportData != null) {
/*     */       try {
/* 181 */         ByteArrayInputStream bais = new ByteArrayInputStream(this._reportData);
/* 182 */         ObjectInputStream ois = new ObjectInputStream(bais);
/* 183 */         Object o = ois.readObject();
/* 184 */         dao.setReportData(o);
/*     */       }
/* 186 */       catch (Exception ee) {
/* 187 */         throw new DtxException("An exception occurred while deserializing field: _reportData. Value: " + this._reportData, ee);
/*     */       } 
/*     */     } else {
/*     */       
/* 191 */       dao.setReportData(null);
/*     */     } 
/* 193 */     dao.setDelete(this._delete);
/* 194 */     argDAO.suppressStateChanges(false);
/* 195 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 199 */     return loadDAO((IDataAccessObject)new ReportDataDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 203 */     ReportDataDAO dao = (ReportDataDAO)argDAO;
/* 204 */     this._organizationId = dao.getOrganizationId();
/* 205 */     this._ownerId = dao.getOwnerId();
/* 206 */     this._ownerType = dao.getOwnerType();
/* 207 */     this._reportId = dao.getReportId();
/* 208 */     this._createDate = dao.getCreateDate();
/* 209 */     this._createUserId = dao.getCreateUserId();
/* 210 */     this._updateDate = dao.getUpdateDate();
/* 211 */     this._updateUserId = dao.getUpdateUserId();
/* 212 */     this._orgCode = dao.getOrgCode();
/* 213 */     this._orgValue = dao.getOrgValue();
/*     */     
/* 215 */     Object oo0 = dao.getReportData();
/* 216 */     if (oo0 != null) {
/*     */       try {
/* 218 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 219 */         ObjectOutputStream oos = new ObjectOutputStream(baos);
/* 220 */         oos.writeObject(oo0);
/* 221 */         this._reportData = baos.toByteArray();
/*     */       }
/* 223 */       catch (Exception ee) {
/* 224 */         throw new DtxException("An exception occurred while serializing to field: _reportData. Value: " + oo0, ee);
/*     */       } 
/*     */     } else {
/*     */       
/* 228 */       this._reportData = null;
/*     */     } 
/*     */     
/* 231 */     this._delete = (dao.getDelete() != null) ? dao.getDelete() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 235 */     ReportDataId id = (ReportDataId)argId;
/* 236 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 237 */     argStatement.setString(2, id.getOwnerId());
/* 238 */     argStatement.setString(3, id.getOwnerType());
/* 239 */     argStatement.setString(4, id.getReportId());
/* 240 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 244 */     ReportDataId id = new ReportDataId();
/* 245 */     id.setOrganizationId(this._organizationId);
/* 246 */     id.setOwnerId(this._ownerId);
/* 247 */     id.setOwnerType(this._ownerType);
/* 248 */     id.setReportId(this._reportId);
/* 249 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 257 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 261 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ReportDataDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */