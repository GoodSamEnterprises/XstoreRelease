/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.CommissionModifierId;
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
/*     */ public class CommissionModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1992981246L;
/*     */   private Date _businessDate;
/*     */   private Integer _commissionModifierSequenceNbr;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _amount;
/*     */   private BigDecimal _percentage;
/*     */   private BigDecimal _percentageOfItem;
/*     */   private String _typeCode;
/*     */   private String _unverifiableEmployeeId;
/*     */   private Long _employeePartyId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.commission_mod_seq_nbr, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.percentage, t.percentage_of_item, t.typcode, t.unverifiable_emp_id, t.employee_party_id FROM trl_commission_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND commission_mod_seq_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.business_date, t.commission_mod_seq_nbr, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.percentage, t.percentage_of_item, t.typcode, t.unverifiable_emp_id, t.employee_party_id FROM trl_commission_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  56 */     return " WHERE business_date = ?  AND commission_mod_seq_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   
/*  59 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_commission_mod(business_date, commission_mod_seq_nbr, organization_id, rtl_loc_id, rtrans_lineitm_seq, trans_seq, wkstn_id, create_date, create_user_id, update_date, update_user_id, amt, percentage, percentage_of_item, typcode, unverifiable_emp_id, employee_party_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  62 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._businessDate, this._commissionModifierSequenceNbr, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._amount, this._percentage, this._percentageOfItem, this._typeCode, this._unverifiableEmployeeId, this._employeePartyId } };
/*  67 */     return insertParameterObject;
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, 4, -5, -5, 4, -5, -5, 91, 12, 91, 12, 3, 3, 3, 12, 12, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_commission_mod SET update_date = ?, update_user_id = ?, amt = ?, percentage = ?, percentage_of_item = ?, typcode = ?, unverifiable_emp_id = ?, employee_party_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  83 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._amount, this._percentage, this._percentageOfItem, this._typeCode, this._unverifiableEmployeeId, this._employeePartyId } };
/*  84 */     return updateParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 3, 3, 12, 12, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_commission_mod" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND commission_mod_seq_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  95 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 101 */     return " WHERE business_date = ?  AND commission_mod_seq_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 104 */     return new Object[] { this._businessDate, this._commissionModifierSequenceNbr, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId };
/*     */   }
/*     */   
/* 107 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, 4, -5, -5, 4, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 110 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 113 */     return "trl_commission_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 117 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 121 */     return new CommissionModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class CommissionModifierFiller
/*     */     implements IFiller {
/*     */     private CommissionModifierDBA _parent;
/*     */     
/*     */     public CommissionModifierFiller(CommissionModifierDBA argParent) {
/* 129 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 133 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 134 */       if (t1 != null) {
/* 135 */         this._parent._businessDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 138 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 143 */       int j = argResultSet.getInt(2);
/* 144 */       if (j != 0 || argResultSet.getObject(2) != null) {
/* 145 */         this._parent._commissionModifierSequenceNbr = Integer.valueOf(j);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 151 */       long l1 = argResultSet.getLong(3);
/* 152 */       if (l1 != 0L || argResultSet.getObject(3) != null) {
/* 153 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 159 */       l1 = argResultSet.getLong(4);
/* 160 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 161 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 167 */       int i = argResultSet.getInt(5);
/* 168 */       if (i != 0 || argResultSet.getObject(5) != null) {
/* 169 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 175 */       long primitiveResult = argResultSet.getLong(6);
/* 176 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 177 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 183 */       primitiveResult = argResultSet.getLong(7);
/* 184 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 185 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 190 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 191 */       if (t8 != null) {
/* 192 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 195 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 198 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 200 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 201 */       if (t10 != null) {
/* 202 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 205 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 208 */       this._parent._updateUserId = argResultSet.getString(11);
/* 209 */       this._parent._amount = argResultSet.getBigDecimal(12);
/* 210 */       this._parent._percentage = argResultSet.getBigDecimal(13);
/* 211 */       this._parent._percentageOfItem = argResultSet.getBigDecimal(14);
/* 212 */       this._parent._typeCode = argResultSet.getString(15);
/* 213 */       this._parent._unverifiableEmployeeId = argResultSet.getString(16);
/*     */ 
/*     */       
/* 216 */       long l2 = argResultSet.getLong(17);
/* 217 */       if (l2 != 0L || argResultSet.getObject(17) != null) {
/* 218 */         this._parent._employeePartyId = Long.valueOf(l2);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 226 */     argDAO.suppressStateChanges(true);
/* 227 */     CommissionModifierDAO dao = (CommissionModifierDAO)argDAO;
/* 228 */     dao.setBusinessDate(this._businessDate);
/* 229 */     dao.setCommissionModifierSequenceNbr(this._commissionModifierSequenceNbr);
/* 230 */     dao.setOrganizationId(this._organizationId);
/* 231 */     dao.setRetailLocationId(this._retailLocationId);
/* 232 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 233 */     dao.setTransactionSequence(this._transactionSequence);
/* 234 */     dao.setWorkstationId(this._workstationId);
/* 235 */     dao.setCreateDate(this._createDate);
/* 236 */     dao.setCreateUserId(this._createUserId);
/* 237 */     dao.setUpdateDate(this._updateDate);
/* 238 */     dao.setUpdateUserId(this._updateUserId);
/* 239 */     dao.setAmount(this._amount);
/* 240 */     dao.setPercentage(this._percentage);
/* 241 */     dao.setPercentageOfItem(this._percentageOfItem);
/* 242 */     dao.setTypeCode(this._typeCode);
/* 243 */     dao.setUnverifiableEmployeeId(this._unverifiableEmployeeId);
/* 244 */     dao.setEmployeePartyId(this._employeePartyId);
/* 245 */     argDAO.suppressStateChanges(false);
/* 246 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 250 */     return loadDAO((IDataAccessObject)new CommissionModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 254 */     CommissionModifierDAO dao = (CommissionModifierDAO)argDAO;
/* 255 */     this._businessDate = dao.getBusinessDate();
/* 256 */     this._commissionModifierSequenceNbr = dao.getCommissionModifierSequenceNbr();
/* 257 */     this._organizationId = dao.getOrganizationId();
/* 258 */     this._retailLocationId = dao.getRetailLocationId();
/* 259 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 260 */     this._transactionSequence = dao.getTransactionSequence();
/* 261 */     this._workstationId = dao.getWorkstationId();
/* 262 */     this._createDate = dao.getCreateDate();
/* 263 */     this._createUserId = dao.getCreateUserId();
/* 264 */     this._updateDate = dao.getUpdateDate();
/* 265 */     this._updateUserId = dao.getUpdateUserId();
/* 266 */     this._amount = dao.getAmount();
/* 267 */     this._percentage = dao.getPercentage();
/* 268 */     this._percentageOfItem = dao.getPercentageOfItem();
/* 269 */     this._typeCode = dao.getTypeCode();
/* 270 */     this._unverifiableEmployeeId = dao.getUnverifiableEmployeeId();
/* 271 */     this._employeePartyId = dao.getEmployeePartyId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 275 */     CommissionModifierId id = (CommissionModifierId)argId;
/* 276 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDate().getTime()));
/* 277 */     argStatement.setInt(2, id.getCommissionModifierSequenceNbr().intValue());
/* 278 */     argStatement.setLong(3, id.getOrganizationId().longValue());
/* 279 */     argStatement.setLong(4, id.getRetailLocationId().longValue());
/* 280 */     argStatement.setInt(5, id.getRetailTransactionLineItemSequence().intValue());
/* 281 */     argStatement.setLong(6, id.getTransactionSequence().longValue());
/* 282 */     argStatement.setLong(7, id.getWorkstationId().longValue());
/* 283 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 287 */     CommissionModifierId id = new CommissionModifierId();
/* 288 */     id.setBusinessDate(this._businessDate);
/* 289 */     id.setCommissionModifierSequenceNbr(this._commissionModifierSequenceNbr);
/* 290 */     id.setOrganizationId(this._organizationId);
/* 291 */     id.setRetailLocationId(this._retailLocationId);
/* 292 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 293 */     id.setTransactionSequence(this._transactionSequence);
/* 294 */     id.setWorkstationId(this._workstationId);
/* 295 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 303 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 307 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\CommissionModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */