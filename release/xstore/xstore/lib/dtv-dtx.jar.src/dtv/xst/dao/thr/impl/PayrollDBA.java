/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.PayrollId;
/*     */ import java.math.BigDecimal;
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
/*     */ public class PayrollDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 878130437L;
/*     */   private Long _retailLocId;
/*     */   private Long _partyId;
/*     */   private Long _organizationId;
/*     */   private Date _businessDate;
/*     */   private String _payrollCategory;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _hoursCount;
/*     */   private Boolean _posted;
/*     */   private Date _postedDate;
/*     */   private String _payrollStatus;
/*     */   private Date _reviewedDate;
/*     */   private String _payCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.rtl_loc_id, t.party_id, t.organization_id, t.business_date, t.payroll_category, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.hours_count, t.posted_flag, t.posted_date, t.payroll_status, t.reviewed_date, t.pay_code FROM thr_payroll t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE rtl_loc_id = ?  AND party_id = ?  AND organization_id = ?  AND business_date = ?  AND payroll_category = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.rtl_loc_id, t.party_id, t.organization_id, t.business_date, t.payroll_category, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.hours_count, t.posted_flag, t.posted_date, t.payroll_status, t.reviewed_date, t.pay_code FROM thr_payroll t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE rtl_loc_id = ?  AND party_id = ?  AND organization_id = ?  AND business_date = ?  AND payroll_category = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO thr_payroll(rtl_loc_id, party_id, organization_id, business_date, payroll_category, create_date, create_user_id, update_date, update_user_id, hours_count, posted_flag, posted_date, payroll_status, reviewed_date, pay_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._retailLocId, this._partyId, this._organizationId, this._businessDate, this._payrollCategory, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._hoursCount, this._posted, this._postedDate, this._payrollStatus, this._reviewedDate, this._payCode } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 91, 12, 91, 12, 91, 12, 3, -7, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE thr_payroll SET update_date = ?, update_user_id = ?, hours_count = ?, posted_flag = ?, posted_date = ?, payroll_status = ?, reviewed_date = ?, pay_code = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._hoursCount, this._posted, this._postedDate, this._payrollStatus, this._reviewedDate, this._payCode } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, -7, 91, 12, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM thr_payroll" }; private static final String WHERE_OBJECT = " WHERE rtl_loc_id = ?  AND party_id = ?  AND organization_id = ?  AND business_date = ?  AND payroll_category = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE rtl_loc_id = ?  AND party_id = ?  AND organization_id = ?  AND business_date = ?  AND payroll_category = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._retailLocId, this._partyId, this._organizationId, this._businessDate, this._payrollCategory };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 91, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "thr_payroll";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new PayrollFiller(this);
/*     */   }
/*     */   
/*     */   private static class PayrollFiller
/*     */     implements IFiller {
/*     */     private PayrollDBA _parent;
/*     */     
/*     */     public PayrollFiller(PayrollDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 132 */       long primitiveResult = argResultSet.getLong(1);
/* 133 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 134 */         this._parent._retailLocId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 140 */       primitiveResult = argResultSet.getLong(2);
/* 141 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 142 */         this._parent._partyId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 148 */       primitiveResult = argResultSet.getLong(3);
/* 149 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 150 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 155 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 156 */       if (t4 != null) {
/* 157 */         this._parent._businessDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._businessDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._payrollCategory = argResultSet.getString(5);
/*     */       
/* 165 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 166 */       if (t6 != null) {
/* 167 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 175 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 176 */       if (t8 != null) {
/* 177 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 183 */       this._parent._updateUserId = argResultSet.getString(9);
/* 184 */       this._parent._hoursCount = argResultSet.getBigDecimal(10);
/* 185 */       this._parent._posted = Boolean.valueOf(argResultSet.getBoolean(11));
/*     */       
/* 187 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 188 */       if (t12 != null) {
/* 189 */         this._parent._postedDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 192 */         this._parent._postedDate = null;
/*     */       } 
/*     */       
/* 195 */       this._parent._payrollStatus = argResultSet.getString(13);
/*     */       
/* 197 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 198 */       if (t14 != null) {
/* 199 */         this._parent._reviewedDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 202 */         this._parent._reviewedDate = null;
/*     */       } 
/*     */       
/* 205 */       this._parent._payCode = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 210 */     argDAO.suppressStateChanges(true);
/* 211 */     PayrollDAO dao = (PayrollDAO)argDAO;
/* 212 */     dao.setRetailLocId(this._retailLocId);
/* 213 */     dao.setPartyId(this._partyId);
/* 214 */     dao.setOrganizationId(this._organizationId);
/* 215 */     dao.setBusinessDate(this._businessDate);
/* 216 */     dao.setPayrollCategory(this._payrollCategory);
/* 217 */     dao.setCreateDate(this._createDate);
/* 218 */     dao.setCreateUserId(this._createUserId);
/* 219 */     dao.setUpdateDate(this._updateDate);
/* 220 */     dao.setUpdateUserId(this._updateUserId);
/* 221 */     dao.setHoursCount(this._hoursCount);
/* 222 */     dao.setPosted(this._posted);
/* 223 */     dao.setPostedDate(this._postedDate);
/* 224 */     dao.setPayrollStatus(this._payrollStatus);
/* 225 */     dao.setReviewedDate(this._reviewedDate);
/* 226 */     dao.setPayCode(this._payCode);
/* 227 */     argDAO.suppressStateChanges(false);
/* 228 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 232 */     return loadDAO((IDataAccessObject)new PayrollDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 236 */     PayrollDAO dao = (PayrollDAO)argDAO;
/* 237 */     this._retailLocId = dao.getRetailLocId();
/* 238 */     this._partyId = dao.getPartyId();
/* 239 */     this._organizationId = dao.getOrganizationId();
/* 240 */     this._businessDate = dao.getBusinessDate();
/* 241 */     this._payrollCategory = dao.getPayrollCategory();
/* 242 */     this._createDate = dao.getCreateDate();
/* 243 */     this._createUserId = dao.getCreateUserId();
/* 244 */     this._updateDate = dao.getUpdateDate();
/* 245 */     this._updateUserId = dao.getUpdateUserId();
/* 246 */     this._hoursCount = dao.getHoursCount();
/* 247 */     this._posted = (dao.getPosted() != null) ? dao.getPosted() : Boolean.valueOf(false);
/* 248 */     this._postedDate = dao.getPostedDate();
/* 249 */     this._payrollStatus = dao.getPayrollStatus();
/* 250 */     this._reviewedDate = dao.getReviewedDate();
/* 251 */     this._payCode = dao.getPayCode();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 255 */     PayrollId id = (PayrollId)argId;
/* 256 */     argStatement.setLong(1, id.getRetailLocId().longValue());
/* 257 */     argStatement.setLong(2, id.getPartyId().longValue());
/* 258 */     argStatement.setLong(3, id.getOrganizationId().longValue());
/* 259 */     argStatement.setTimestamp(4, new Timestamp(id.getBusinessDate().getTime()));
/* 260 */     argStatement.setString(5, id.getPayrollCategory());
/* 261 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 265 */     PayrollId id = new PayrollId();
/* 266 */     id.setRetailLocId(this._retailLocId);
/* 267 */     id.setPartyId(this._partyId);
/* 268 */     id.setOrganizationId(this._organizationId);
/* 269 */     id.setBusinessDate(this._businessDate);
/* 270 */     id.setPayrollCategory(this._payrollCategory);
/* 271 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 279 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 283 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\PayrollDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */