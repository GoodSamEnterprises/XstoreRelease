/*     */ package dtv.xst.dao.prc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.prc.DealWeekId;
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
/*     */ public class DealWeekDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 575037088L;
/*     */   private Long _organizationId;
/*     */   private String _dealId;
/*     */   private String _dayCode;
/*     */   private Date _startTime;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _endTime;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.deal_id, t.day_code, t.start_time, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.end_time FROM prc_deal_week t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND deal_id = ?  AND day_code = ?  AND start_time = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.deal_id, t.day_code, t.start_time, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.end_time FROM prc_deal_week t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND deal_id = ?  AND day_code = ?  AND start_time = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO prc_deal_week(organization_id, deal_id, day_code, start_time, org_code, org_value, create_date, create_user_id, update_date, update_user_id, end_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._dealId, this._dayCode, this._startTime, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._endTime } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 12, 91, 12, 91, 12, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE prc_deal_week SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, end_time = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._endTime } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM prc_deal_week" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND deal_id = ?  AND day_code = ?  AND start_time = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND deal_id = ?  AND day_code = ?  AND start_time = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._dealId, this._dayCode, this._startTime };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 91 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "prc_deal_week";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new DealWeekFiller(this);
/*     */   }
/*     */   
/*     */   private static class DealWeekFiller
/*     */     implements IFiller {
/*     */     private DealWeekDBA _parent;
/*     */     
/*     */     public DealWeekFiller(DealWeekDBA argParent) {
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
/* 134 */       this._parent._dealId = argResultSet.getString(2);
/* 135 */       this._parent._dayCode = argResultSet.getString(3);
/*     */       
/* 137 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 138 */       if (t4 != null) {
/* 139 */         this._parent._startTime = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 142 */         this._parent._startTime = null;
/*     */       } 
/*     */       
/* 145 */       this._parent._orgCode = argResultSet.getString(5);
/* 146 */       this._parent._orgValue = argResultSet.getString(6);
/*     */       
/* 148 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 149 */       if (t7 != null) {
/* 150 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 153 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 156 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 158 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 159 */       if (t9 != null) {
/* 160 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 163 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 166 */       this._parent._updateUserId = argResultSet.getString(10);
/*     */       
/* 168 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 169 */       if (t11 != null) {
/* 170 */         this._parent._endTime = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 173 */         this._parent._endTime = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 180 */     argDAO.suppressStateChanges(true);
/* 181 */     DealWeekDAO dao = (DealWeekDAO)argDAO;
/* 182 */     dao.setOrganizationId(this._organizationId);
/* 183 */     dao.setDealId(this._dealId);
/* 184 */     dao.setDayCode(this._dayCode);
/* 185 */     dao.setStartTime(this._startTime);
/* 186 */     dao.setOrgCode(this._orgCode);
/* 187 */     dao.setOrgValue(this._orgValue);
/* 188 */     dao.setCreateDate(this._createDate);
/* 189 */     dao.setCreateUserId(this._createUserId);
/* 190 */     dao.setUpdateDate(this._updateDate);
/* 191 */     dao.setUpdateUserId(this._updateUserId);
/* 192 */     dao.setEndTime(this._endTime);
/* 193 */     argDAO.suppressStateChanges(false);
/* 194 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 198 */     return loadDAO((IDataAccessObject)new DealWeekDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 202 */     DealWeekDAO dao = (DealWeekDAO)argDAO;
/* 203 */     this._organizationId = dao.getOrganizationId();
/* 204 */     this._dealId = dao.getDealId();
/* 205 */     this._dayCode = dao.getDayCode();
/* 206 */     this._startTime = dao.getStartTime();
/* 207 */     this._orgCode = dao.getOrgCode();
/* 208 */     this._orgValue = dao.getOrgValue();
/* 209 */     this._createDate = dao.getCreateDate();
/* 210 */     this._createUserId = dao.getCreateUserId();
/* 211 */     this._updateDate = dao.getUpdateDate();
/* 212 */     this._updateUserId = dao.getUpdateUserId();
/* 213 */     this._endTime = dao.getEndTime();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 217 */     DealWeekId id = (DealWeekId)argId;
/* 218 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 219 */     argStatement.setString(2, id.getDealId());
/* 220 */     argStatement.setString(3, id.getDayCode());
/* 221 */     argStatement.setTimestamp(4, new Timestamp(id.getStartTime().getTime()));
/* 222 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 226 */     DealWeekId id = new DealWeekId();
/* 227 */     id.setOrganizationId(this._organizationId);
/* 228 */     id.setDealId(this._dealId);
/* 229 */     id.setDayCode(this._dayCode);
/* 230 */     id.setStartTime(this._startTime);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\impl\DealWeekDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */