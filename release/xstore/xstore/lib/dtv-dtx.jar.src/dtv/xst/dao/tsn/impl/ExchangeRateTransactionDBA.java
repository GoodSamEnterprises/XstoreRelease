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
/*     */ public class ExchangeRateTransactionDBA
/*     */   extends PosTransactionDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 988281115L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM trl_rtrans t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM trl_rtrans t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_rtrans(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  63 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 91, 12, 91, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_rtrans SET update_date = ?, update_user_id = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId } };
/*  83 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_rtrans" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  96 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 103 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 107 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence };
/*     */   }
/*     */   
/* 110 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 114 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 118 */     return "trl_rtrans";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 123 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 127 */     return new ExchangeRateTransactionFiller(this);
/*     */   }
/*     */   
/*     */   private static class ExchangeRateTransactionFiller
/*     */     implements IFiller {
/*     */     private ExchangeRateTransactionDBA _parent;
/*     */     
/*     */     public ExchangeRateTransactionFiller(ExchangeRateTransactionDBA argParent) {
/* 135 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 140 */       long primitiveResult = argResultSet.getLong(1);
/* 141 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 142 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 148 */       primitiveResult = argResultSet.getLong(2);
/* 149 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 150 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 155 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 156 */       if (t3 != null) {
/* 157 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 165 */       long l1 = argResultSet.getLong(4);
/* 166 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 167 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 173 */       l1 = argResultSet.getLong(5);
/* 174 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 175 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 180 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 181 */       if (t6 != null) {
/* 182 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 185 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 188 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 190 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 191 */       if (t8 != null) {
/* 192 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 195 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 198 */       this._parent._updateUserId = argResultSet.getString(9);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 204 */     super.loadDAO(argDAO);
/* 205 */     argDAO.suppressStateChanges(true);
/* 206 */     ExchangeRateTransactionDAO dao = (ExchangeRateTransactionDAO)argDAO;
/* 207 */     dao.setOrganizationId(this._organizationId);
/* 208 */     dao.setRetailLocationId(this._retailLocationId);
/* 209 */     dao.setBusinessDate(this._businessDate);
/* 210 */     dao.setWorkstationId(this._workstationId);
/* 211 */     dao.setTransactionSequence(this._transactionSequence);
/* 212 */     dao.setCreateDate(this._createDate);
/* 213 */     dao.setCreateUserId(this._createUserId);
/* 214 */     dao.setUpdateDate(this._updateDate);
/* 215 */     dao.setUpdateUserId(this._updateUserId);
/* 216 */     argDAO.suppressStateChanges(false);
/* 217 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 222 */     return loadDAO((IDataAccessObject)new ExchangeRateTransactionDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 227 */     ExchangeRateTransactionDAO dao = (ExchangeRateTransactionDAO)argDAO;
/* 228 */     super.fill((IDataAccessObject)dao);
/* 229 */     this._organizationId = dao.getOrganizationId();
/* 230 */     this._retailLocationId = dao.getRetailLocationId();
/* 231 */     this._businessDate = dao.getBusinessDate();
/* 232 */     this._workstationId = dao.getWorkstationId();
/* 233 */     this._transactionSequence = dao.getTransactionSequence();
/* 234 */     this._createDate = dao.getCreateDate();
/* 235 */     this._createUserId = dao.getCreateUserId();
/* 236 */     this._updateDate = dao.getUpdateDate();
/* 237 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 242 */     PosTransactionId id = (PosTransactionId)argId;
/* 243 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 244 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 245 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 246 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 247 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 248 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 252 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 256 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\ExchangeRateTransactionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */