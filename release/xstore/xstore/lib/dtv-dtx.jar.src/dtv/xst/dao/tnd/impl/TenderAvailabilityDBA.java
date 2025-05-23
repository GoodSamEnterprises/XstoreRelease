/*     */ package dtv.xst.dao.tnd.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tnd.TenderAvailabilityId;
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
/*     */ public class TenderAvailabilityDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 754612847L;
/*     */   private String _availabilityCode;
/*     */   private Long _organizationId;
/*     */   private String _tenderId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.availability_code, t.organization_id, t.tndr_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tnd_tndr_availability t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE availability_code = ?  AND organization_id = ?  AND tndr_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  36 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  40 */     return "SELECT t.availability_code, t.organization_id, t.tndr_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tnd_tndr_availability t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  46 */     return " WHERE availability_code = ?  AND organization_id = ?  AND tndr_id = ?  ";
/*     */   }
/*     */   
/*  49 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tnd_tndr_availability(availability_code, organization_id, tndr_id, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  52 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  56 */     Object[][] insertParameterObject = { { this._availabilityCode, this._organizationId, this._tenderId, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  57 */     return insertParameterObject;
/*     */   }
/*     */   
/*  60 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  63 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  66 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tnd_tndr_availability SET update_date = ?, update_user_id = ?" };
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
/*  82 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tnd_tndr_availability" }; private static final String WHERE_OBJECT = " WHERE availability_code = ?  AND organization_id = ?  AND tndr_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  85 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  91 */     return " WHERE availability_code = ?  AND organization_id = ?  AND tndr_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  94 */     return new Object[] { this._availabilityCode, this._organizationId, this._tenderId };
/*     */   }
/*     */   
/*  97 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 100 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 103 */     return "tnd_tndr_availability";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 107 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 111 */     return new TenderAvailabilityFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderAvailabilityFiller
/*     */     implements IFiller {
/*     */     private TenderAvailabilityDBA _parent;
/*     */     
/*     */     public TenderAvailabilityFiller(TenderAvailabilityDBA argParent) {
/* 119 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 122 */       this._parent._availabilityCode = argResultSet.getString(1);
/*     */ 
/*     */       
/* 125 */       long primitiveResult = argResultSet.getLong(2);
/* 126 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 127 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 131 */       this._parent._tenderId = argResultSet.getString(3);
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
/* 157 */     TenderAvailabilityDAO dao = (TenderAvailabilityDAO)argDAO;
/* 158 */     dao.setAvailabilityCode(this._availabilityCode);
/* 159 */     dao.setOrganizationId(this._organizationId);
/* 160 */     dao.setTenderId(this._tenderId);
/* 161 */     dao.setCreateDate(this._createDate);
/* 162 */     dao.setCreateUserId(this._createUserId);
/* 163 */     dao.setUpdateDate(this._updateDate);
/* 164 */     dao.setUpdateUserId(this._updateUserId);
/* 165 */     argDAO.suppressStateChanges(false);
/* 166 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 170 */     return loadDAO((IDataAccessObject)new TenderAvailabilityDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 174 */     TenderAvailabilityDAO dao = (TenderAvailabilityDAO)argDAO;
/* 175 */     this._availabilityCode = dao.getAvailabilityCode();
/* 176 */     this._organizationId = dao.getOrganizationId();
/* 177 */     this._tenderId = dao.getTenderId();
/* 178 */     this._createDate = dao.getCreateDate();
/* 179 */     this._createUserId = dao.getCreateUserId();
/* 180 */     this._updateDate = dao.getUpdateDate();
/* 181 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 185 */     TenderAvailabilityId id = (TenderAvailabilityId)argId;
/* 186 */     argStatement.setString(1, id.getAvailabilityCode());
/* 187 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 188 */     argStatement.setString(3, id.getTenderId());
/* 189 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 193 */     TenderAvailabilityId id = new TenderAvailabilityId();
/* 194 */     id.setAvailabilityCode(this._availabilityCode);
/* 195 */     id.setOrganizationId(this._organizationId);
/* 196 */     id.setTenderId(this._tenderId);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderAvailabilityDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */