/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.DimensionModifierId;
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
/*     */ 
/*     */ public class DimensionModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -734966211L;
/*     */   private Date _businessDate;
/*     */   private String _dimensionCode;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _value;
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.dimension_code, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.value FROM trl_dimension_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND dimension_code = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.business_date, t.dimension_code, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.value FROM trl_dimension_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE business_date = ?  AND dimension_code = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_dimension_mod(business_date, dimension_code, organization_id, rtl_loc_id, rtrans_lineitm_seq, trans_seq, wkstn_id, create_date, create_user_id, update_date, update_user_id, value) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._businessDate, this._dimensionCode, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._value } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, 12, -5, -5, 4, -5, -5, 91, 12, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_dimension_mod SET update_date = ?, update_user_id = ?, value = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._value } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_dimension_mod" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND dimension_code = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE business_date = ?  AND dimension_code = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._businessDate, this._dimensionCode, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, 12, -5, -5, 4, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "trl_dimension_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new DimensionModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class DimensionModifierFiller
/*     */     implements IFiller {
/*     */     private DimensionModifierDBA _parent;
/*     */     
/*     */     public DimensionModifierFiller(DimensionModifierDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 129 */       if (t1 != null) {
/* 130 */         this._parent._businessDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 133 */         this._parent._businessDate = null;
/*     */       } 
/*     */       
/* 136 */       this._parent._dimensionCode = argResultSet.getString(2);
/*     */ 
/*     */       
/* 139 */       long l1 = argResultSet.getLong(3);
/* 140 */       if (l1 != 0L || argResultSet.getObject(3) != null) {
/* 141 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 147 */       l1 = argResultSet.getLong(4);
/* 148 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 149 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 155 */       int i = argResultSet.getInt(5);
/* 156 */       if (i != 0 || argResultSet.getObject(5) != null) {
/* 157 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 163 */       long primitiveResult = argResultSet.getLong(6);
/* 164 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 165 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 171 */       primitiveResult = argResultSet.getLong(7);
/* 172 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 173 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 178 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 179 */       if (t8 != null) {
/* 180 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 183 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 186 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 188 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 189 */       if (t10 != null) {
/* 190 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 193 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 196 */       this._parent._updateUserId = argResultSet.getString(11);
/* 197 */       this._parent._value = argResultSet.getString(12);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 202 */     argDAO.suppressStateChanges(true);
/* 203 */     DimensionModifierDAO dao = (DimensionModifierDAO)argDAO;
/* 204 */     dao.setBusinessDate(this._businessDate);
/* 205 */     dao.setDimensionCode(this._dimensionCode);
/* 206 */     dao.setOrganizationId(this._organizationId);
/* 207 */     dao.setRetailLocationId(this._retailLocationId);
/* 208 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 209 */     dao.setTransactionSequence(this._transactionSequence);
/* 210 */     dao.setWorkstationId(this._workstationId);
/* 211 */     dao.setCreateDate(this._createDate);
/* 212 */     dao.setCreateUserId(this._createUserId);
/* 213 */     dao.setUpdateDate(this._updateDate);
/* 214 */     dao.setUpdateUserId(this._updateUserId);
/* 215 */     dao.setValue(this._value);
/* 216 */     argDAO.suppressStateChanges(false);
/* 217 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 221 */     return loadDAO((IDataAccessObject)new DimensionModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 225 */     DimensionModifierDAO dao = (DimensionModifierDAO)argDAO;
/* 226 */     this._businessDate = dao.getBusinessDate();
/* 227 */     this._dimensionCode = dao.getDimensionCode();
/* 228 */     this._organizationId = dao.getOrganizationId();
/* 229 */     this._retailLocationId = dao.getRetailLocationId();
/* 230 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 231 */     this._transactionSequence = dao.getTransactionSequence();
/* 232 */     this._workstationId = dao.getWorkstationId();
/* 233 */     this._createDate = dao.getCreateDate();
/* 234 */     this._createUserId = dao.getCreateUserId();
/* 235 */     this._updateDate = dao.getUpdateDate();
/* 236 */     this._updateUserId = dao.getUpdateUserId();
/* 237 */     this._value = dao.getValue();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 241 */     DimensionModifierId id = (DimensionModifierId)argId;
/* 242 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDate().getTime()));
/* 243 */     argStatement.setString(2, id.getDimensionCode());
/* 244 */     argStatement.setLong(3, id.getOrganizationId().longValue());
/* 245 */     argStatement.setLong(4, id.getRetailLocationId().longValue());
/* 246 */     argStatement.setInt(5, id.getRetailTransactionLineItemSequence().intValue());
/* 247 */     argStatement.setLong(6, id.getTransactionSequence().longValue());
/* 248 */     argStatement.setLong(7, id.getWorkstationId().longValue());
/* 249 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 253 */     DimensionModifierId id = new DimensionModifierId();
/* 254 */     id.setBusinessDate(this._businessDate);
/* 255 */     id.setDimensionCode(this._dimensionCode);
/* 256 */     id.setOrganizationId(this._organizationId);
/* 257 */     id.setRetailLocationId(this._retailLocationId);
/* 258 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 259 */     id.setTransactionSequence(this._transactionSequence);
/* 260 */     id.setWorkstationId(this._workstationId);
/* 261 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 269 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 273 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\DimensionModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */