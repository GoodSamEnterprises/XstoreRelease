/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
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
/*     */ public class MovementPendingTransactionDBA
/*     */   extends PosTransactionDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1469642762L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq FROM trn_trans t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  35 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  39 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq FROM trn_trans t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  46 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  53 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/*  57 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence };
/*     */   }
/*     */   
/*  60 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/*  64 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/*  68 */     return "trn_trans";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/*  73 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/*  77 */     return new MovementPendingTransactionFiller(this);
/*     */   }
/*     */   
/*     */   private static class MovementPendingTransactionFiller
/*     */     implements IFiller {
/*     */     private MovementPendingTransactionDBA _parent;
/*     */     
/*     */     public MovementPendingTransactionFiller(MovementPendingTransactionDBA argParent) {
/*  85 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/*  90 */       long primitiveResult = argResultSet.getLong(1);
/*  91 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/*  92 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  98 */       primitiveResult = argResultSet.getLong(2);
/*  99 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 100 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 105 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 106 */       if (t3 != null) {
/* 107 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 110 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 115 */       long l1 = argResultSet.getLong(4);
/* 116 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 117 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 123 */       l1 = argResultSet.getLong(5);
/* 124 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 125 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 134 */     super.loadDAO(argDAO);
/* 135 */     argDAO.suppressStateChanges(true);
/* 136 */     MovementPendingTransactionDAO dao = (MovementPendingTransactionDAO)argDAO;
/* 137 */     dao.setOrganizationId(this._organizationId);
/* 138 */     dao.setRetailLocationId(this._retailLocationId);
/* 139 */     dao.setBusinessDate(this._businessDate);
/* 140 */     dao.setWorkstationId(this._workstationId);
/* 141 */     dao.setTransactionSequence(this._transactionSequence);
/* 142 */     argDAO.suppressStateChanges(false);
/* 143 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 148 */     return loadDAO((IDataAccessObject)new MovementPendingTransactionDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 153 */     MovementPendingTransactionDAO dao = (MovementPendingTransactionDAO)argDAO;
/* 154 */     super.fill((IDataAccessObject)dao);
/* 155 */     this._organizationId = dao.getOrganizationId();
/* 156 */     this._retailLocationId = dao.getRetailLocationId();
/* 157 */     this._businessDate = dao.getBusinessDate();
/* 158 */     this._workstationId = dao.getWorkstationId();
/* 159 */     this._transactionSequence = dao.getTransactionSequence();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 164 */     PosTransactionId id = (PosTransactionId)argId;
/* 165 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 166 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 167 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 168 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 169 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 170 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 174 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 178 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\MovementPendingTransactionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */