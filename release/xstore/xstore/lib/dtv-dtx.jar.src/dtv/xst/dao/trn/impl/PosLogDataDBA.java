/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.PosLogDataId;
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
/*     */ public class PosLogDataDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1034551238L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Date _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _poslogData;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.poslog_data FROM trn_poslog_data t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.poslog_data FROM trn_poslog_data t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trn_poslog_data(organization_id, rtl_loc_id, wkstn_id, business_date, trans_seq, create_date, create_user_id, update_date, update_user_id, poslog_data) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._poslogData } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 91, -5, 91, 12, 91, 12, 2005 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trn_poslog_data SET update_date = ?, update_user_id = ?, poslog_data = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._poslogData } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 2005 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trn_poslog_data" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 91, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "trn_poslog_data";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new PosLogDataFiller(this);
/*     */   }
/*     */   
/*     */   private static class PosLogDataFiller
/*     */     implements IFiller {
/*     */     private PosLogDataDBA _parent;
/*     */     
/*     */     public PosLogDataFiller(PosLogDataDBA argParent) {
/* 122 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 127 */       long primitiveResult = argResultSet.getLong(1);
/* 128 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 129 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 135 */       primitiveResult = argResultSet.getLong(2);
/* 136 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 137 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 143 */       primitiveResult = argResultSet.getLong(3);
/* 144 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 145 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 150 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 151 */       if (t4 != null) {
/* 152 */         this._parent._businessDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 155 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 160 */       long l1 = argResultSet.getLong(5);
/* 161 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 162 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 167 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 168 */       if (t6 != null) {
/* 169 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 172 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 175 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 177 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 178 */       if (t8 != null) {
/* 179 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 182 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 185 */       this._parent._updateUserId = argResultSet.getString(9);
/*     */ 
/*     */       
/* 188 */       this._parent._poslogData = JDBCHelper.clobToString(argResultSet, 10);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 194 */     argDAO.suppressStateChanges(true);
/* 195 */     PosLogDataDAO dao = (PosLogDataDAO)argDAO;
/* 196 */     dao.setOrganizationId(this._organizationId);
/* 197 */     dao.setRetailLocationId(this._retailLocationId);
/* 198 */     dao.setWorkstationId(this._workstationId);
/* 199 */     dao.setBusinessDate(this._businessDate);
/* 200 */     dao.setTransactionSequence(this._transactionSequence);
/* 201 */     dao.setCreateDate(this._createDate);
/* 202 */     dao.setCreateUserId(this._createUserId);
/* 203 */     dao.setUpdateDate(this._updateDate);
/* 204 */     dao.setUpdateUserId(this._updateUserId);
/* 205 */     dao.setPoslogData(this._poslogData);
/* 206 */     argDAO.suppressStateChanges(false);
/* 207 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 211 */     return loadDAO((IDataAccessObject)new PosLogDataDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 215 */     PosLogDataDAO dao = (PosLogDataDAO)argDAO;
/* 216 */     this._organizationId = dao.getOrganizationId();
/* 217 */     this._retailLocationId = dao.getRetailLocationId();
/* 218 */     this._workstationId = dao.getWorkstationId();
/* 219 */     this._businessDate = dao.getBusinessDate();
/* 220 */     this._transactionSequence = dao.getTransactionSequence();
/* 221 */     this._createDate = dao.getCreateDate();
/* 222 */     this._createUserId = dao.getCreateUserId();
/* 223 */     this._updateDate = dao.getUpdateDate();
/* 224 */     this._updateUserId = dao.getUpdateUserId();
/* 225 */     this._poslogData = dao.getPoslogData();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 229 */     PosLogDataId id = (PosLogDataId)argId;
/* 230 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 231 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 232 */     argStatement.setLong(3, id.getWorkstationId().longValue());
/* 233 */     argStatement.setTimestamp(4, new Timestamp(id.getBusinessDate().getTime()));
/* 234 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 235 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 239 */     PosLogDataId id = new PosLogDataId();
/* 240 */     id.setOrganizationId(this._organizationId);
/* 241 */     id.setRetailLocationId(this._retailLocationId);
/* 242 */     id.setWorkstationId(this._workstationId);
/* 243 */     id.setBusinessDate(this._businessDate);
/* 244 */     id.setTransactionSequence(this._transactionSequence);
/* 245 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 253 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 257 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PosLogDataDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */