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
/*     */ public class SessionControlTransactionDBA
/*     */   extends PosTransactionDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 893283927L;
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
/*     */   private Integer _sessionWorkstationSequence;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.typcode, t.session_wkstn_seq FROM tsn_session_control_trans t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.typcode, t.session_wkstn_seq FROM tsn_session_control_trans t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_session_control_trans(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, create_date, create_user_id, update_date, update_user_id, typcode, session_wkstn_seq) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._typeCode, this._sessionWorkstationSequence } };
/*  65 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 91, 12, 91, 12, 12, 4 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_session_control_trans SET update_date = ?, update_user_id = ?, typcode = ?, session_wkstn_seq = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  84 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._typeCode, this._sessionWorkstationSequence } };
/*  85 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  88 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 4 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  91 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/*  94 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_session_control_trans" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  98 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 105 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 109 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence };
/*     */   }
/*     */   
/* 112 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 116 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 120 */     return "tsn_session_control_trans";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 125 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 129 */     return new SessionControlTransactionFiller(this);
/*     */   }
/*     */   
/*     */   private static class SessionControlTransactionFiller
/*     */     implements IFiller {
/*     */     private SessionControlTransactionDBA _parent;
/*     */     
/*     */     public SessionControlTransactionFiller(SessionControlTransactionDBA argParent) {
/* 137 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 142 */       long primitiveResult = argResultSet.getLong(1);
/* 143 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 144 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 150 */       primitiveResult = argResultSet.getLong(2);
/* 151 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 152 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 157 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 158 */       if (t3 != null) {
/* 159 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 162 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 167 */       long l1 = argResultSet.getLong(4);
/* 168 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 169 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 175 */       l1 = argResultSet.getLong(5);
/* 176 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 177 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 182 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 183 */       if (t6 != null) {
/* 184 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 187 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 190 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 192 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 193 */       if (t8 != null) {
/* 194 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 197 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 200 */       this._parent._updateUserId = argResultSet.getString(9);
/* 201 */       this._parent._typeCode = argResultSet.getString(10);
/*     */ 
/*     */       
/* 204 */       int i = argResultSet.getInt(11);
/* 205 */       if (i != 0 || argResultSet.getObject(11) != null) {
/* 206 */         this._parent._sessionWorkstationSequence = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 215 */     super.loadDAO(argDAO);
/* 216 */     argDAO.suppressStateChanges(true);
/* 217 */     SessionControlTransactionDAO dao = (SessionControlTransactionDAO)argDAO;
/* 218 */     dao.setOrganizationId(this._organizationId);
/* 219 */     dao.setRetailLocationId(this._retailLocationId);
/* 220 */     dao.setBusinessDate(this._businessDate);
/* 221 */     dao.setWorkstationId(this._workstationId);
/* 222 */     dao.setTransactionSequence(this._transactionSequence);
/* 223 */     dao.setCreateDate(this._createDate);
/* 224 */     dao.setCreateUserId(this._createUserId);
/* 225 */     dao.setUpdateDate(this._updateDate);
/* 226 */     dao.setUpdateUserId(this._updateUserId);
/* 227 */     dao.setTypeCode(this._typeCode);
/* 228 */     dao.setSessionWorkstationSequence(this._sessionWorkstationSequence);
/* 229 */     argDAO.suppressStateChanges(false);
/* 230 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 235 */     return loadDAO((IDataAccessObject)new SessionControlTransactionDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 240 */     SessionControlTransactionDAO dao = (SessionControlTransactionDAO)argDAO;
/* 241 */     super.fill((IDataAccessObject)dao);
/* 242 */     this._organizationId = dao.getOrganizationId();
/* 243 */     this._retailLocationId = dao.getRetailLocationId();
/* 244 */     this._businessDate = dao.getBusinessDate();
/* 245 */     this._workstationId = dao.getWorkstationId();
/* 246 */     this._transactionSequence = dao.getTransactionSequence();
/* 247 */     this._createDate = dao.getCreateDate();
/* 248 */     this._createUserId = dao.getCreateUserId();
/* 249 */     this._updateDate = dao.getUpdateDate();
/* 250 */     this._updateUserId = dao.getUpdateUserId();
/* 251 */     this._typeCode = dao.getTypeCode();
/* 252 */     this._sessionWorkstationSequence = dao.getSessionWorkstationSequence();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 257 */     PosTransactionId id = (PosTransactionId)argId;
/* 258 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 259 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 260 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 261 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 262 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 263 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 267 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 271 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\SessionControlTransactionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */