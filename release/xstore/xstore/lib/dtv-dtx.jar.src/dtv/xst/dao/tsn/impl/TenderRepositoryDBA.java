/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderRepositoryId;
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
/*     */ public class TenderRepositoryDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -235965090L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _tenderRepositoryId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _description;
/*     */   private String _name;
/*     */   private Boolean _notIssuable;
/*     */   private String _typeCode;
/*     */   private Long _defaultWorkstationId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.tndr_repository_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.description, t.name, t.not_issuable_flag, t.typcode, t.dflt_wkstn_id FROM tsn_tndr_repository t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND tndr_repository_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.rtl_loc_id, t.tndr_repository_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.description, t.name, t.not_issuable_flag, t.typcode, t.dflt_wkstn_id FROM tsn_tndr_repository t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND tndr_repository_id = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_tndr_repository(organization_id, rtl_loc_id, tndr_repository_id, create_date, create_user_id, update_date, update_user_id, description, name, not_issuable_flag, typcode, dflt_wkstn_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._tenderRepositoryId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._description, this._name, this._notIssuable, this._typeCode, this._defaultWorkstationId } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 91, 12, 91, 12, 12, 12, -7, 12, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_tndr_repository SET update_date = ?, update_user_id = ?, description = ?, name = ?, not_issuable_flag = ?, typcode = ?, dflt_wkstn_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._description, this._name, this._notIssuable, this._typeCode, this._defaultWorkstationId } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, -7, 12, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_tndr_repository" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND tndr_repository_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND tndr_repository_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._retailLocationId, this._tenderRepositoryId };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "tsn_tndr_repository";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new TenderRepositoryFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderRepositoryFiller
/*     */     implements IFiller {
/*     */     private TenderRepositoryDBA _parent;
/*     */     
/*     */     public TenderRepositoryFiller(TenderRepositoryDBA argParent) {
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
/*     */ 
/*     */       
/* 137 */       primitiveResult = argResultSet.getLong(2);
/* 138 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 139 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 143 */       this._parent._tenderRepositoryId = argResultSet.getString(3);
/*     */       
/* 145 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 146 */       if (t4 != null) {
/* 147 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 155 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 156 */       if (t6 != null) {
/* 157 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._updateUserId = argResultSet.getString(7);
/* 164 */       this._parent._description = argResultSet.getString(8);
/* 165 */       this._parent._name = argResultSet.getString(9);
/* 166 */       this._parent._notIssuable = Boolean.valueOf(argResultSet.getBoolean(10));
/* 167 */       this._parent._typeCode = argResultSet.getString(11);
/*     */ 
/*     */       
/* 170 */       long l1 = argResultSet.getLong(12);
/* 171 */       if (l1 != 0L || argResultSet.getObject(12) != null) {
/* 172 */         this._parent._defaultWorkstationId = Long.valueOf(l1);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 180 */     argDAO.suppressStateChanges(true);
/* 181 */     TenderRepositoryDAO dao = (TenderRepositoryDAO)argDAO;
/* 182 */     dao.setOrganizationId(this._organizationId);
/* 183 */     dao.setRetailLocationId(this._retailLocationId);
/* 184 */     dao.setTenderRepositoryId(this._tenderRepositoryId);
/* 185 */     dao.setCreateDate(this._createDate);
/* 186 */     dao.setCreateUserId(this._createUserId);
/* 187 */     dao.setUpdateDate(this._updateDate);
/* 188 */     dao.setUpdateUserId(this._updateUserId);
/* 189 */     dao.setDescription(this._description);
/* 190 */     dao.setName(this._name);
/* 191 */     dao.setNotIssuable(this._notIssuable);
/* 192 */     dao.setTypeCode(this._typeCode);
/* 193 */     dao.setDefaultWorkstationId(this._defaultWorkstationId);
/* 194 */     argDAO.suppressStateChanges(false);
/* 195 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 199 */     return loadDAO((IDataAccessObject)new TenderRepositoryDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 203 */     TenderRepositoryDAO dao = (TenderRepositoryDAO)argDAO;
/* 204 */     this._organizationId = dao.getOrganizationId();
/* 205 */     this._retailLocationId = dao.getRetailLocationId();
/* 206 */     this._tenderRepositoryId = dao.getTenderRepositoryId();
/* 207 */     this._createDate = dao.getCreateDate();
/* 208 */     this._createUserId = dao.getCreateUserId();
/* 209 */     this._updateDate = dao.getUpdateDate();
/* 210 */     this._updateUserId = dao.getUpdateUserId();
/* 211 */     this._description = dao.getDescription();
/* 212 */     this._name = dao.getName();
/* 213 */     this._notIssuable = (dao.getNotIssuable() != null) ? dao.getNotIssuable() : Boolean.valueOf(false);
/* 214 */     this._typeCode = dao.getTypeCode();
/* 215 */     this._defaultWorkstationId = dao.getDefaultWorkstationId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 219 */     TenderRepositoryId id = (TenderRepositoryId)argId;
/* 220 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 221 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 222 */     argStatement.setString(3, id.getTenderRepositoryId());
/* 223 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 227 */     TenderRepositoryId id = new TenderRepositoryId();
/* 228 */     id.setOrganizationId(this._organizationId);
/* 229 */     id.setRetailLocationId(this._retailLocationId);
/* 230 */     id.setTenderRepositoryId(this._tenderRepositoryId);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderRepositoryDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */