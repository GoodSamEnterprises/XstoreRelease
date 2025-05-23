/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.WarrantyModifierId;
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
/*     */ public class WarrantyModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 154202131L;
/*     */   private Date _businessDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Integer _warrantyModifierSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _warrantyNbr;
/*     */   private String _warrantyTypeCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.warranty_modifier_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.warranty_nbr, t.warranty_typcode FROM trl_warranty_modifier t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  AND warranty_modifier_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.warranty_modifier_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.warranty_nbr, t.warranty_typcode FROM trl_warranty_modifier t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  AND warranty_modifier_seq = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_warranty_modifier(business_date, organization_id, rtl_loc_id, rtrans_lineitm_seq, trans_seq, wkstn_id, warranty_modifier_seq, create_date, create_user_id, update_date, update_user_id, warranty_nbr, warranty_typcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._businessDate, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId, this._warrantyModifierSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._warrantyNbr, this._warrantyTypeCode } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, -5, -5, 4, -5, -5, 4, 91, 12, 91, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_warranty_modifier SET update_date = ?, update_user_id = ?, warranty_nbr = ?, warranty_typcode = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._warrantyNbr, this._warrantyTypeCode } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_warranty_modifier" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  AND warranty_modifier_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  AND warranty_modifier_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._businessDate, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId, this._warrantyModifierSequence };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, -5, -5, 4, -5, -5, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "trl_warranty_modifier";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new WarrantyModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class WarrantyModifierFiller
/*     */     implements IFiller {
/*     */     private WarrantyModifierDBA _parent;
/*     */     
/*     */     public WarrantyModifierFiller(WarrantyModifierDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 130 */       if (t1 != null) {
/* 131 */         this._parent._businessDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 134 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 139 */       long l2 = argResultSet.getLong(2);
/* 140 */       if (l2 != 0L || argResultSet.getObject(2) != null) {
/* 141 */         this._parent._organizationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 147 */       l2 = argResultSet.getLong(3);
/* 148 */       if (l2 != 0L || argResultSet.getObject(3) != null) {
/* 149 */         this._parent._retailLocationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 155 */       int i = argResultSet.getInt(4);
/* 156 */       if (i != 0 || argResultSet.getObject(4) != null) {
/* 157 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 163 */       long l1 = argResultSet.getLong(5);
/* 164 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 165 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 171 */       l1 = argResultSet.getLong(6);
/* 172 */       if (l1 != 0L || argResultSet.getObject(6) != null) {
/* 173 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 179 */       int primitiveResult = argResultSet.getInt(7);
/* 180 */       if (primitiveResult != 0 || argResultSet.getObject(7) != null) {
/* 181 */         this._parent._warrantyModifierSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 186 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 187 */       if (t8 != null) {
/* 188 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 191 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 194 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 196 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 197 */       if (t10 != null) {
/* 198 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 201 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 204 */       this._parent._updateUserId = argResultSet.getString(11);
/* 205 */       this._parent._warrantyNbr = argResultSet.getString(12);
/* 206 */       this._parent._warrantyTypeCode = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 211 */     argDAO.suppressStateChanges(true);
/* 212 */     WarrantyModifierDAO dao = (WarrantyModifierDAO)argDAO;
/* 213 */     dao.setBusinessDate(this._businessDate);
/* 214 */     dao.setOrganizationId(this._organizationId);
/* 215 */     dao.setRetailLocationId(this._retailLocationId);
/* 216 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 217 */     dao.setTransactionSequence(this._transactionSequence);
/* 218 */     dao.setWorkstationId(this._workstationId);
/* 219 */     dao.setWarrantyModifierSequence(this._warrantyModifierSequence);
/* 220 */     dao.setCreateDate(this._createDate);
/* 221 */     dao.setCreateUserId(this._createUserId);
/* 222 */     dao.setUpdateDate(this._updateDate);
/* 223 */     dao.setUpdateUserId(this._updateUserId);
/* 224 */     dao.setWarrantyNbr(this._warrantyNbr);
/* 225 */     dao.setWarrantyTypeCode(this._warrantyTypeCode);
/* 226 */     argDAO.suppressStateChanges(false);
/* 227 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 231 */     return loadDAO((IDataAccessObject)new WarrantyModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 235 */     WarrantyModifierDAO dao = (WarrantyModifierDAO)argDAO;
/* 236 */     this._businessDate = dao.getBusinessDate();
/* 237 */     this._organizationId = dao.getOrganizationId();
/* 238 */     this._retailLocationId = dao.getRetailLocationId();
/* 239 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 240 */     this._transactionSequence = dao.getTransactionSequence();
/* 241 */     this._workstationId = dao.getWorkstationId();
/* 242 */     this._warrantyModifierSequence = dao.getWarrantyModifierSequence();
/* 243 */     this._createDate = dao.getCreateDate();
/* 244 */     this._createUserId = dao.getCreateUserId();
/* 245 */     this._updateDate = dao.getUpdateDate();
/* 246 */     this._updateUserId = dao.getUpdateUserId();
/* 247 */     this._warrantyNbr = dao.getWarrantyNbr();
/* 248 */     this._warrantyTypeCode = dao.getWarrantyTypeCode();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 252 */     WarrantyModifierId id = (WarrantyModifierId)argId;
/* 253 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDate().getTime()));
/* 254 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 255 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 256 */     argStatement.setInt(4, id.getRetailTransactionLineItemSequence().intValue());
/* 257 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 258 */     argStatement.setLong(6, id.getWorkstationId().longValue());
/* 259 */     argStatement.setInt(7, id.getWarrantyModifierSequence().intValue());
/* 260 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 264 */     WarrantyModifierId id = new WarrantyModifierId();
/* 265 */     id.setBusinessDate(this._businessDate);
/* 266 */     id.setOrganizationId(this._organizationId);
/* 267 */     id.setRetailLocationId(this._retailLocationId);
/* 268 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 269 */     id.setTransactionSequence(this._transactionSequence);
/* 270 */     id.setWorkstationId(this._workstationId);
/* 271 */     id.setWarrantyModifierSequence(this._warrantyModifierSequence);
/* 272 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 280 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 284 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\WarrantyModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */