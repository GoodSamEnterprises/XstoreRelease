/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.PosTransactionId;
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
/*     */ public class RainCheckTransactionDBA
/*     */   extends PosTransactionDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1711258762L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _rainCheckId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.rain_check_id FROM trn_raincheck_trans t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.rain_check_id FROM trn_raincheck_trans t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trn_raincheck_trans(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, create_date, create_user_id, update_date, update_user_id, rain_check_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._rainCheckId } };
/*  64 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 91, 12, 91, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trn_raincheck_trans SET update_date = ?, update_user_id = ?, rain_check_id = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  78 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  83 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._rainCheckId } };
/*  84 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  87 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  90 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/*  93 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trn_raincheck_trans" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  97 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 104 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 108 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence };
/*     */   }
/*     */   
/* 111 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 115 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 119 */     return "trn_raincheck_trans";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 124 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 128 */     return new RainCheckTransactionFiller(this);
/*     */   }
/*     */   
/*     */   private static class RainCheckTransactionFiller
/*     */     implements IFiller {
/*     */     private RainCheckTransactionDBA _parent;
/*     */     
/*     */     public RainCheckTransactionFiller(RainCheckTransactionDBA argParent) {
/* 136 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 141 */       long primitiveResult = argResultSet.getLong(1);
/* 142 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 143 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 149 */       primitiveResult = argResultSet.getLong(2);
/* 150 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 151 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 156 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 157 */       if (t3 != null) {
/* 158 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 161 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 166 */       long l1 = argResultSet.getLong(4);
/* 167 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 168 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 174 */       l1 = argResultSet.getLong(5);
/* 175 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 176 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 181 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 182 */       if (t6 != null) {
/* 183 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 186 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 189 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 191 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 192 */       if (t8 != null) {
/* 193 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 196 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 199 */       this._parent._updateUserId = argResultSet.getString(9);
/* 200 */       this._parent._rainCheckId = argResultSet.getString(10);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 206 */     super.loadDAO(argDAO);
/* 207 */     argDAO.suppressStateChanges(true);
/* 208 */     RainCheckTransactionDAO dao = (RainCheckTransactionDAO)argDAO;
/* 209 */     dao.setOrganizationId(this._organizationId);
/* 210 */     dao.setRetailLocationId(this._retailLocationId);
/* 211 */     dao.setBusinessDate(this._businessDate);
/* 212 */     dao.setWorkstationId(this._workstationId);
/* 213 */     dao.setTransactionSequence(this._transactionSequence);
/* 214 */     dao.setCreateDate(this._createDate);
/* 215 */     dao.setCreateUserId(this._createUserId);
/* 216 */     dao.setUpdateDate(this._updateDate);
/* 217 */     dao.setUpdateUserId(this._updateUserId);
/* 218 */     dao.setRainCheckId(this._rainCheckId);
/* 219 */     argDAO.suppressStateChanges(false);
/* 220 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 225 */     return loadDAO((IDataAccessObject)new RainCheckTransactionDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 230 */     RainCheckTransactionDAO dao = (RainCheckTransactionDAO)argDAO;
/* 231 */     super.fill((IDataAccessObject)dao);
/* 232 */     this._organizationId = dao.getOrganizationId();
/* 233 */     this._retailLocationId = dao.getRetailLocationId();
/* 234 */     this._businessDate = dao.getBusinessDate();
/* 235 */     this._workstationId = dao.getWorkstationId();
/* 236 */     this._transactionSequence = dao.getTransactionSequence();
/* 237 */     this._createDate = dao.getCreateDate();
/* 238 */     this._createUserId = dao.getCreateUserId();
/* 239 */     this._updateDate = dao.getUpdateDate();
/* 240 */     this._updateUserId = dao.getUpdateUserId();
/* 241 */     this._rainCheckId = dao.getRainCheckId();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 246 */     PosTransactionId id = (PosTransactionId)argId;
/* 247 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 248 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 249 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 250 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 251 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 252 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 256 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 260 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\RainCheckTransactionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */