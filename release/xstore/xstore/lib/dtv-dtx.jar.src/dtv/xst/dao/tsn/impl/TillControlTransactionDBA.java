/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.PosTransactionId;
/*     */ import dtv.xst.dao.trn.impl.PosTransactionDBA;
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
/*     */ public class TillControlTransactionDBA
/*     */   extends PosTransactionDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -62627594L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _typeCode;
/*     */   private String _employeeId;
/*     */   private String _reasonCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.typcode, t.employee_id, t.reason_code FROM tsn_till_control_trans t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.typcode, t.employee_id, t.reason_code FROM tsn_till_control_trans t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_till_control_trans(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, create_date, create_user_id, update_date, update_user_id, typcode, employee_id, reason_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._typeCode, this._employeeId, this._reasonCode } };
/*  66 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 91, 12, 91, 12, 12, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_till_control_trans SET update_date = ?, update_user_id = ?, typcode = ?, employee_id = ?, reason_code = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  80 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  85 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._typeCode, this._employeeId, this._reasonCode } };
/*  86 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  89 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  92 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/*  95 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_till_control_trans" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  99 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 106 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 110 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence };
/*     */   }
/*     */   
/* 113 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 117 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 121 */     return "tsn_till_control_trans";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 126 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 130 */     return new TillControlTransactionFiller(this);
/*     */   }
/*     */   
/*     */   private static class TillControlTransactionFiller
/*     */     implements IFiller {
/*     */     private TillControlTransactionDBA _parent;
/*     */     
/*     */     public TillControlTransactionFiller(TillControlTransactionDBA argParent) {
/* 138 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 143 */       long primitiveResult = argResultSet.getLong(1);
/* 144 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 145 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 151 */       primitiveResult = argResultSet.getLong(2);
/* 152 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 153 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 158 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 159 */       if (t3 != null) {
/* 160 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 163 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 168 */       long l1 = argResultSet.getLong(4);
/* 169 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 170 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 176 */       l1 = argResultSet.getLong(5);
/* 177 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 178 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 183 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 184 */       if (t6 != null) {
/* 185 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 188 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 191 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 193 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 194 */       if (t8 != null) {
/* 195 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 198 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 201 */       this._parent._updateUserId = argResultSet.getString(9);
/* 202 */       this._parent._typeCode = argResultSet.getString(10);
/* 203 */       this._parent._employeeId = argResultSet.getString(11);
/* 204 */       this._parent._reasonCode = argResultSet.getString(12);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 210 */     super.loadDAO(argDAO);
/* 211 */     argDAO.suppressStateChanges(true);
/* 212 */     TillControlTransactionDAO dao = (TillControlTransactionDAO)argDAO;
/* 213 */     dao.setOrganizationId(this._organizationId);
/* 214 */     dao.setRetailLocationId(this._retailLocationId);
/* 215 */     dao.setBusinessDate(this._businessDate);
/* 216 */     dao.setWorkstationId(this._workstationId);
/* 217 */     dao.setTransactionSequence(this._transactionSequence);
/* 218 */     dao.setCreateDate(this._createDate);
/* 219 */     dao.setCreateUserId(this._createUserId);
/* 220 */     dao.setUpdateDate(this._updateDate);
/* 221 */     dao.setUpdateUserId(this._updateUserId);
/* 222 */     dao.setTypeCode(this._typeCode);
/* 223 */     dao.setEmployeeId(this._employeeId);
/* 224 */     dao.setReasonCode(this._reasonCode);
/* 225 */     argDAO.suppressStateChanges(false);
/* 226 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 231 */     return loadDAO((IDataAccessObject)new TillControlTransactionDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 236 */     TillControlTransactionDAO dao = (TillControlTransactionDAO)argDAO;
/* 237 */     super.fill((IDataAccessObject)dao);
/* 238 */     this._organizationId = dao.getOrganizationId();
/* 239 */     this._retailLocationId = dao.getRetailLocationId();
/* 240 */     this._businessDate = dao.getBusinessDate();
/* 241 */     this._workstationId = dao.getWorkstationId();
/* 242 */     this._transactionSequence = dao.getTransactionSequence();
/* 243 */     this._createDate = dao.getCreateDate();
/* 244 */     this._createUserId = dao.getCreateUserId();
/* 245 */     this._updateDate = dao.getUpdateDate();
/* 246 */     this._updateUserId = dao.getUpdateUserId();
/* 247 */     this._typeCode = dao.getTypeCode();
/* 248 */     this._employeeId = dao.getEmployeeId();
/* 249 */     this._reasonCode = dao.getReasonCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 254 */     PosTransactionId id = (PosTransactionId)argId;
/* 255 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 256 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 257 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 258 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 259 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 260 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 264 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 268 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TillControlTransactionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */