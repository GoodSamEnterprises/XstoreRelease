/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderRepositoryStatusId;
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
/*     */ public class TenderRepositoryStatusDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1132449040L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _tenderRepositoryId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Boolean _issued;
/*     */   private Long _activeSessionId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.tndr_repository_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.issued_flag, t.active_session_id FROM tsn_tndr_repository_status t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND tndr_repository_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  38 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  42 */     return "SELECT t.organization_id, t.rtl_loc_id, t.tndr_repository_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.issued_flag, t.active_session_id FROM tsn_tndr_repository_status t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  48 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND tndr_repository_id = ?  ";
/*     */   }
/*     */   
/*  51 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_tndr_repository_status(organization_id, rtl_loc_id, tndr_repository_id, create_date, create_user_id, update_date, update_user_id, issued_flag, active_session_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  54 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  58 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._tenderRepositoryId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._issued, this._activeSessionId } };
/*  59 */     return insertParameterObject;
/*     */   }
/*     */   
/*  62 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 91, 12, 91, 12, -7, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  65 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  68 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_tndr_repository_status SET update_date = ?, update_user_id = ?, issued_flag = ?, active_session_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  71 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  75 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._issued, this._activeSessionId } };
/*  76 */     return updateParameterObject;
/*     */   }
/*     */   
/*  79 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -7, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  81 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  84 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_tndr_repository_status" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND tndr_repository_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  87 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  93 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND tndr_repository_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  96 */     return new Object[] { this._organizationId, this._retailLocationId, this._tenderRepositoryId };
/*     */   }
/*     */   
/*  99 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 102 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 105 */     return "tsn_tndr_repository_status";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 109 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 113 */     return new TenderRepositoryStatusFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderRepositoryStatusFiller
/*     */     implements IFiller {
/*     */     private TenderRepositoryStatusDBA _parent;
/*     */     
/*     */     public TenderRepositoryStatusFiller(TenderRepositoryStatusDBA argParent) {
/* 121 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 126 */       long primitiveResult = argResultSet.getLong(1);
/* 127 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 128 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 134 */       primitiveResult = argResultSet.getLong(2);
/* 135 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 136 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 140 */       this._parent._tenderRepositoryId = argResultSet.getString(3);
/*     */       
/* 142 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 143 */       if (t4 != null) {
/* 144 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 147 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 150 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 152 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 153 */       if (t6 != null) {
/* 154 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._updateUserId = argResultSet.getString(7);
/* 161 */       this._parent._issued = Boolean.valueOf(argResultSet.getBoolean(8));
/*     */ 
/*     */       
/* 164 */       long l1 = argResultSet.getLong(9);
/* 165 */       if (l1 != 0L || argResultSet.getObject(9) != null) {
/* 166 */         this._parent._activeSessionId = Long.valueOf(l1);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 174 */     argDAO.suppressStateChanges(true);
/* 175 */     TenderRepositoryStatusDAO dao = (TenderRepositoryStatusDAO)argDAO;
/* 176 */     dao.setOrganizationId(this._organizationId);
/* 177 */     dao.setRetailLocationId(this._retailLocationId);
/* 178 */     dao.setTenderRepositoryId(this._tenderRepositoryId);
/* 179 */     dao.setCreateDate(this._createDate);
/* 180 */     dao.setCreateUserId(this._createUserId);
/* 181 */     dao.setUpdateDate(this._updateDate);
/* 182 */     dao.setUpdateUserId(this._updateUserId);
/* 183 */     dao.setIssued(this._issued);
/* 184 */     dao.setActiveSessionId(this._activeSessionId);
/* 185 */     argDAO.suppressStateChanges(false);
/* 186 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 190 */     return loadDAO((IDataAccessObject)new TenderRepositoryStatusDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 194 */     TenderRepositoryStatusDAO dao = (TenderRepositoryStatusDAO)argDAO;
/* 195 */     this._organizationId = dao.getOrganizationId();
/* 196 */     this._retailLocationId = dao.getRetailLocationId();
/* 197 */     this._tenderRepositoryId = dao.getTenderRepositoryId();
/* 198 */     this._createDate = dao.getCreateDate();
/* 199 */     this._createUserId = dao.getCreateUserId();
/* 200 */     this._updateDate = dao.getUpdateDate();
/* 201 */     this._updateUserId = dao.getUpdateUserId();
/* 202 */     this._issued = (dao.getIssued() != null) ? dao.getIssued() : Boolean.valueOf(false);
/* 203 */     this._activeSessionId = dao.getActiveSessionId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 207 */     TenderRepositoryStatusId id = (TenderRepositoryStatusId)argId;
/* 208 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 209 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 210 */     argStatement.setString(3, id.getTenderRepositoryId());
/* 211 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 215 */     TenderRepositoryStatusId id = new TenderRepositoryStatusId();
/* 216 */     id.setOrganizationId(this._organizationId);
/* 217 */     id.setRetailLocationId(this._retailLocationId);
/* 218 */     id.setTenderRepositoryId(this._tenderRepositoryId);
/* 219 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 227 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 231 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderRepositoryStatusDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */