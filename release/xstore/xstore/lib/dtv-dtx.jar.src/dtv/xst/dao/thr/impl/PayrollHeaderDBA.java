/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.PayrollHeaderId;
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
/*     */ public class PayrollHeaderDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1972081678L;
/*     */   private Long _retailLocId;
/*     */   private Long _partyId;
/*     */   private Long _organizationId;
/*     */   private Date _weekEndingDate;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _reviewedDate;
/*     */   private static final String SELECT_OBJECT = "SELECT t.rtl_loc_id, t.party_id, t.organization_id, t.week_ending_date, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.reviewed_date FROM thr_payroll_header t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE rtl_loc_id = ?  AND party_id = ?  AND organization_id = ?  AND week_ending_date = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  38 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  42 */     return "SELECT t.rtl_loc_id, t.party_id, t.organization_id, t.week_ending_date, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.reviewed_date FROM thr_payroll_header t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  48 */     return " WHERE rtl_loc_id = ?  AND party_id = ?  AND organization_id = ?  AND week_ending_date = ?  ";
/*     */   }
/*     */   
/*  51 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO thr_payroll_header(rtl_loc_id, party_id, organization_id, week_ending_date, create_date, create_user_id, update_date, update_user_id, reviewed_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  54 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  58 */     Object[][] insertParameterObject = { { this._retailLocId, this._partyId, this._organizationId, this._weekEndingDate, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._reviewedDate } };
/*  59 */     return insertParameterObject;
/*     */   }
/*     */   
/*  62 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 91, 91, 12, 91, 12, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  65 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  68 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE thr_payroll_header SET update_date = ?, update_user_id = ?, reviewed_date = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  71 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  75 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._reviewedDate } };
/*  76 */     return updateParameterObject;
/*     */   }
/*     */   
/*  79 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  81 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  84 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM thr_payroll_header" }; private static final String WHERE_OBJECT = " WHERE rtl_loc_id = ?  AND party_id = ?  AND organization_id = ?  AND week_ending_date = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  87 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  93 */     return " WHERE rtl_loc_id = ?  AND party_id = ?  AND organization_id = ?  AND week_ending_date = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  96 */     return new Object[] { this._retailLocId, this._partyId, this._organizationId, this._weekEndingDate };
/*     */   }
/*     */   
/*  99 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 91 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 102 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 105 */     return "thr_payroll_header";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 109 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 113 */     return new PayrollHeaderFiller(this);
/*     */   }
/*     */   
/*     */   private static class PayrollHeaderFiller
/*     */     implements IFiller {
/*     */     private PayrollHeaderDBA _parent;
/*     */     
/*     */     public PayrollHeaderFiller(PayrollHeaderDBA argParent) {
/* 121 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 126 */       long primitiveResult = argResultSet.getLong(1);
/* 127 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 128 */         this._parent._retailLocId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 134 */       primitiveResult = argResultSet.getLong(2);
/* 135 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 136 */         this._parent._partyId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       primitiveResult = argResultSet.getLong(3);
/* 143 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 144 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 149 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 150 */       if (t4 != null) {
/* 151 */         this._parent._weekEndingDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._weekEndingDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 158 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 159 */       if (t5 != null) {
/* 160 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 163 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 166 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 168 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 169 */       if (t7 != null) {
/* 170 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 173 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 176 */       this._parent._updateUserId = argResultSet.getString(8);
/*     */       
/* 178 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 179 */       if (t9 != null) {
/* 180 */         this._parent._reviewedDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 183 */         this._parent._reviewedDate = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 190 */     argDAO.suppressStateChanges(true);
/* 191 */     PayrollHeaderDAO dao = (PayrollHeaderDAO)argDAO;
/* 192 */     dao.setRetailLocId(this._retailLocId);
/* 193 */     dao.setPartyId(this._partyId);
/* 194 */     dao.setOrganizationId(this._organizationId);
/* 195 */     dao.setWeekEndingDate(this._weekEndingDate);
/* 196 */     dao.setCreateDate(this._createDate);
/* 197 */     dao.setCreateUserId(this._createUserId);
/* 198 */     dao.setUpdateDate(this._updateDate);
/* 199 */     dao.setUpdateUserId(this._updateUserId);
/* 200 */     dao.setReviewedDate(this._reviewedDate);
/* 201 */     argDAO.suppressStateChanges(false);
/* 202 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 206 */     return loadDAO((IDataAccessObject)new PayrollHeaderDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 210 */     PayrollHeaderDAO dao = (PayrollHeaderDAO)argDAO;
/* 211 */     this._retailLocId = dao.getRetailLocId();
/* 212 */     this._partyId = dao.getPartyId();
/* 213 */     this._organizationId = dao.getOrganizationId();
/* 214 */     this._weekEndingDate = dao.getWeekEndingDate();
/* 215 */     this._createDate = dao.getCreateDate();
/* 216 */     this._createUserId = dao.getCreateUserId();
/* 217 */     this._updateDate = dao.getUpdateDate();
/* 218 */     this._updateUserId = dao.getUpdateUserId();
/* 219 */     this._reviewedDate = dao.getReviewedDate();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 223 */     PayrollHeaderId id = (PayrollHeaderId)argId;
/* 224 */     argStatement.setLong(1, id.getRetailLocId().longValue());
/* 225 */     argStatement.setLong(2, id.getPartyId().longValue());
/* 226 */     argStatement.setLong(3, id.getOrganizationId().longValue());
/* 227 */     argStatement.setTimestamp(4, new Timestamp(id.getWeekEndingDate().getTime()));
/* 228 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 232 */     PayrollHeaderId id = new PayrollHeaderId();
/* 233 */     id.setRetailLocId(this._retailLocId);
/* 234 */     id.setPartyId(this._partyId);
/* 235 */     id.setOrganizationId(this._organizationId);
/* 236 */     id.setWeekEndingDate(this._weekEndingDate);
/* 237 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 245 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 249 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\PayrollHeaderDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */