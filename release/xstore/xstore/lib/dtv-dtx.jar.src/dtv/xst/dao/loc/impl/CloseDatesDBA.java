/*     */ package dtv.xst.dao.loc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.loc.CloseDatesId;
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
/*     */ public class CloseDatesDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -93581427L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _closeDate;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _reasonCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.close_date, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.reason_code FROM loc_close_dates t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND close_date = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  37 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  41 */     return "SELECT t.organization_id, t.rtl_loc_id, t.close_date, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.reason_code FROM loc_close_dates t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  47 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND close_date = ?  ";
/*     */   }
/*     */   
/*  50 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO loc_close_dates(organization_id, rtl_loc_id, close_date, create_date, create_user_id, update_date, update_user_id, reason_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  53 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  57 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._closeDate, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._reasonCode } };
/*  58 */     return insertParameterObject;
/*     */   }
/*     */   
/*  61 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, 91, 12, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  64 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  67 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE loc_close_dates SET update_date = ?, update_user_id = ?, reason_code = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  70 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  74 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._reasonCode } };
/*  75 */     return updateParameterObject;
/*     */   }
/*     */   
/*  78 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  80 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  83 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM loc_close_dates" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND close_date = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  86 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  92 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND close_date = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  95 */     return new Object[] { this._organizationId, this._retailLocationId, this._closeDate };
/*     */   }
/*     */   
/*  98 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 101 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 104 */     return "loc_close_dates";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 108 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 112 */     return new CloseDatesFiller(this);
/*     */   }
/*     */   
/*     */   private static class CloseDatesFiller
/*     */     implements IFiller {
/*     */     private CloseDatesDBA _parent;
/*     */     
/*     */     public CloseDatesFiller(CloseDatesDBA argParent) {
/* 120 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 125 */       long primitiveResult = argResultSet.getLong(1);
/* 126 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 127 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 133 */       primitiveResult = argResultSet.getLong(2);
/* 134 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 135 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 140 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 141 */       if (t3 != null) {
/* 142 */         this._parent._closeDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 145 */         this._parent._closeDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 149 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 150 */       if (t4 != null) {
/* 151 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 159 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 160 */       if (t6 != null) {
/* 161 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 164 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 167 */       this._parent._updateUserId = argResultSet.getString(7);
/* 168 */       this._parent._reasonCode = argResultSet.getString(8);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 173 */     argDAO.suppressStateChanges(true);
/* 174 */     CloseDatesDAO dao = (CloseDatesDAO)argDAO;
/* 175 */     dao.setOrganizationId(this._organizationId);
/* 176 */     dao.setRetailLocationId(this._retailLocationId);
/* 177 */     dao.setCloseDate(this._closeDate);
/* 178 */     dao.setCreateDate(this._createDate);
/* 179 */     dao.setCreateUserId(this._createUserId);
/* 180 */     dao.setUpdateDate(this._updateDate);
/* 181 */     dao.setUpdateUserId(this._updateUserId);
/* 182 */     dao.setReasonCode(this._reasonCode);
/* 183 */     argDAO.suppressStateChanges(false);
/* 184 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 188 */     return loadDAO((IDataAccessObject)new CloseDatesDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 192 */     CloseDatesDAO dao = (CloseDatesDAO)argDAO;
/* 193 */     this._organizationId = dao.getOrganizationId();
/* 194 */     this._retailLocationId = dao.getRetailLocationId();
/* 195 */     this._closeDate = dao.getCloseDate();
/* 196 */     this._createDate = dao.getCreateDate();
/* 197 */     this._createUserId = dao.getCreateUserId();
/* 198 */     this._updateDate = dao.getUpdateDate();
/* 199 */     this._updateUserId = dao.getUpdateUserId();
/* 200 */     this._reasonCode = dao.getReasonCode();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 204 */     CloseDatesId id = (CloseDatesId)argId;
/* 205 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 206 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 207 */     argStatement.setTimestamp(3, new Timestamp(id.getCloseDate().getTime()));
/* 208 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 212 */     CloseDatesId id = new CloseDatesId();
/* 213 */     id.setOrganizationId(this._organizationId);
/* 214 */     id.setRetailLocationId(this._retailLocationId);
/* 215 */     id.setCloseDate(this._closeDate);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\CloseDatesDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */