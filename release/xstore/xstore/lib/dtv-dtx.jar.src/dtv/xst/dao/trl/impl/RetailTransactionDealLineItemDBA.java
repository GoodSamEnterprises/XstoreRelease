/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailTransactionLineItemId;
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
/*     */ public class RetailTransactionDealLineItemDBA
/*     */   extends RetailTransactionLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1110874354L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _amount;
/*     */   private String _dealId;
/*     */   private String _reasonCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.deal_id, t.discount_reascode FROM trl_deal_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.deal_id, t.discount_reascode FROM trl_deal_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_deal_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, amt, deal_id, discount_reascode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._amount, this._dealId, this._reasonCode } };
/*  67 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 3, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  74 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  77 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_deal_lineitm SET update_date = ?, update_user_id = ?, amt = ?, deal_id = ?, discount_reascode = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  81 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  86 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._amount, this._dealId, this._reasonCode } };
/*  87 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  90 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  93 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/*  96 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_deal_lineitm" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 100 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 107 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 111 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 114 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 118 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 122 */     return "trl_deal_lineitm";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 127 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 131 */     return new RetailTransactionDealLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class RetailTransactionDealLineItemFiller
/*     */     implements IFiller {
/*     */     private RetailTransactionDealLineItemDBA _parent;
/*     */     
/*     */     public RetailTransactionDealLineItemFiller(RetailTransactionDealLineItemDBA argParent) {
/* 139 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 144 */       long primitiveResult = argResultSet.getLong(1);
/* 145 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 146 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 152 */       primitiveResult = argResultSet.getLong(2);
/* 153 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 154 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 159 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 160 */       if (t3 != null) {
/* 161 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 164 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 169 */       long l1 = argResultSet.getLong(4);
/* 170 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 171 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 177 */       l1 = argResultSet.getLong(5);
/* 178 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 179 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 185 */       int i = argResultSet.getInt(6);
/* 186 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 187 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 192 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 193 */       if (t7 != null) {
/* 194 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 197 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 200 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 202 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 203 */       if (t9 != null) {
/* 204 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 207 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 210 */       this._parent._updateUserId = argResultSet.getString(10);
/* 211 */       this._parent._amount = argResultSet.getBigDecimal(11);
/* 212 */       this._parent._dealId = argResultSet.getString(12);
/* 213 */       this._parent._reasonCode = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 219 */     super.loadDAO(argDAO);
/* 220 */     argDAO.suppressStateChanges(true);
/* 221 */     RetailTransactionDealLineItemDAO dao = (RetailTransactionDealLineItemDAO)argDAO;
/* 222 */     dao.setOrganizationId(this._organizationId);
/* 223 */     dao.setRetailLocationId(this._retailLocationId);
/* 224 */     dao.setBusinessDate(this._businessDate);
/* 225 */     dao.setWorkstationId(this._workstationId);
/* 226 */     dao.setTransactionSequence(this._transactionSequence);
/* 227 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 228 */     dao.setCreateDate(this._createDate);
/* 229 */     dao.setCreateUserId(this._createUserId);
/* 230 */     dao.setUpdateDate(this._updateDate);
/* 231 */     dao.setUpdateUserId(this._updateUserId);
/* 232 */     dao.setAmount(this._amount);
/* 233 */     dao.setDealId(this._dealId);
/* 234 */     dao.setReasonCode(this._reasonCode);
/* 235 */     argDAO.suppressStateChanges(false);
/* 236 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 241 */     return loadDAO((IDataAccessObject)new RetailTransactionDealLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 246 */     RetailTransactionDealLineItemDAO dao = (RetailTransactionDealLineItemDAO)argDAO;
/* 247 */     super.fill((IDataAccessObject)dao);
/* 248 */     this._organizationId = dao.getOrganizationId();
/* 249 */     this._retailLocationId = dao.getRetailLocationId();
/* 250 */     this._businessDate = dao.getBusinessDate();
/* 251 */     this._workstationId = dao.getWorkstationId();
/* 252 */     this._transactionSequence = dao.getTransactionSequence();
/* 253 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 254 */     this._createDate = dao.getCreateDate();
/* 255 */     this._createUserId = dao.getCreateUserId();
/* 256 */     this._updateDate = dao.getUpdateDate();
/* 257 */     this._updateUserId = dao.getUpdateUserId();
/* 258 */     this._amount = dao.getAmount();
/* 259 */     this._dealId = dao.getDealId();
/* 260 */     this._reasonCode = dao.getReasonCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 265 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 266 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 267 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 268 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 269 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 270 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 271 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 272 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 276 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 280 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionDealLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */