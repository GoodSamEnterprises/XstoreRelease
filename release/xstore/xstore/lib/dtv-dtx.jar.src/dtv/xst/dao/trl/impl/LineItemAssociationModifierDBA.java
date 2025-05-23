/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.LineItemAssociationModifierId;
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
/*     */ public class LineItemAssociationModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 387442097L;
/*     */   private Date _businessDate;
/*     */   private Integer _lineItemAssociationModifierSequence;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _childBusinessDate;
/*     */   private Long _childRetailLocationId;
/*     */   private Integer _childRetailTransactionLineItemSequence;
/*     */   private Long _childTransactionSequence;
/*     */   private Long _childWorkstationId;
/*     */   private String _lineItemAssociationTypeCodeString;
/*     */   private static final String SELECT_OBJECT = "SELECT t.parent_business_date, t.lineitm_assoc_mod_seq, t.organization_id, t.parent_rtl_loc_id, t.parent_rtrans_lineitm_seq, t.parent_trans_seq, t.parent_wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.child_business_date, t.child_rtl_loc_id, t.child_rtrans_lineitm_seq, t.child_trans_seq , t.child_wkstn_id , t.lineitm_assoc_typcode  FROM trl_lineitm_assoc_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE parent_business_date = ?  AND lineitm_assoc_mod_seq = ?  AND organization_id = ?  AND parent_rtl_loc_id = ?  AND parent_rtrans_lineitm_seq = ?  AND parent_trans_seq = ?  AND parent_wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.parent_business_date, t.lineitm_assoc_mod_seq, t.organization_id, t.parent_rtl_loc_id, t.parent_rtrans_lineitm_seq, t.parent_trans_seq, t.parent_wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.child_business_date, t.child_rtl_loc_id, t.child_rtrans_lineitm_seq, t.child_trans_seq , t.child_wkstn_id , t.lineitm_assoc_typcode  FROM trl_lineitm_assoc_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  56 */     return " WHERE parent_business_date = ?  AND lineitm_assoc_mod_seq = ?  AND organization_id = ?  AND parent_rtl_loc_id = ?  AND parent_rtrans_lineitm_seq = ?  AND parent_trans_seq = ?  AND parent_wkstn_id = ?  ";
/*     */   }
/*     */   
/*  59 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_lineitm_assoc_mod(parent_business_date, lineitm_assoc_mod_seq, organization_id, parent_rtl_loc_id, parent_rtrans_lineitm_seq, parent_trans_seq, parent_wkstn_id, create_date, create_user_id, update_date, update_user_id, child_business_date, child_rtl_loc_id, child_rtrans_lineitm_seq, child_trans_seq , child_wkstn_id , lineitm_assoc_typcode ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  62 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._businessDate, this._lineItemAssociationModifierSequence, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._childBusinessDate, this._childRetailLocationId, this._childRetailTransactionLineItemSequence, this._childTransactionSequence, this._childWorkstationId, this._lineItemAssociationTypeCodeString } };
/*  67 */     return insertParameterObject;
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, 4, -5, -5, 4, -5, -5, 91, 12, 91, 12, 91, -5, 4, -5, -5, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_lineitm_assoc_mod SET update_date = ?, update_user_id = ?, child_business_date = ?, child_rtl_loc_id = ?, child_rtrans_lineitm_seq = ?, child_trans_seq  = ?, child_wkstn_id  = ?, lineitm_assoc_typcode  = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  83 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._childBusinessDate, this._childRetailLocationId, this._childRetailTransactionLineItemSequence, this._childTransactionSequence, this._childWorkstationId, this._lineItemAssociationTypeCodeString } };
/*  84 */     return updateParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, -5, 4, -5, -5, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_lineitm_assoc_mod" }; private static final String WHERE_OBJECT = " WHERE parent_business_date = ?  AND lineitm_assoc_mod_seq = ?  AND organization_id = ?  AND parent_rtl_loc_id = ?  AND parent_rtrans_lineitm_seq = ?  AND parent_trans_seq = ?  AND parent_wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  95 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 101 */     return " WHERE parent_business_date = ?  AND lineitm_assoc_mod_seq = ?  AND organization_id = ?  AND parent_rtl_loc_id = ?  AND parent_rtrans_lineitm_seq = ?  AND parent_trans_seq = ?  AND parent_wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 104 */     return new Object[] { this._businessDate, this._lineItemAssociationModifierSequence, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId };
/*     */   }
/*     */   
/* 107 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, 4, -5, -5, 4, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 110 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 113 */     return "trl_lineitm_assoc_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 117 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 121 */     return new LineItemAssociationModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class LineItemAssociationModifierFiller
/*     */     implements IFiller {
/*     */     private LineItemAssociationModifierDBA _parent;
/*     */     
/*     */     public LineItemAssociationModifierFiller(LineItemAssociationModifierDBA argParent) {
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
/* 145 */         this._parent._lineItemAssociationModifierSequence = Integer.valueOf(j);
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
/*     */       
/* 210 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 211 */       if (t12 != null) {
/* 212 */         this._parent._childBusinessDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 215 */         this._parent._childBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 220 */       long l3 = argResultSet.getLong(13);
/* 221 */       if (l3 != 0L || argResultSet.getObject(13) != null) {
/* 222 */         this._parent._childRetailLocationId = Long.valueOf(l3);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 228 */       int k = argResultSet.getInt(14);
/* 229 */       if (k != 0 || argResultSet.getObject(14) != null) {
/* 230 */         this._parent._childRetailTransactionLineItemSequence = Integer.valueOf(k);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 236 */       long l2 = argResultSet.getLong(15);
/* 237 */       if (l2 != 0L || argResultSet.getObject(15) != null) {
/* 238 */         this._parent._childTransactionSequence = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 244 */       l2 = argResultSet.getLong(16);
/* 245 */       if (l2 != 0L || argResultSet.getObject(16) != null) {
/* 246 */         this._parent._childWorkstationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 250 */       this._parent._lineItemAssociationTypeCodeString = argResultSet.getString(17);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 255 */     argDAO.suppressStateChanges(true);
/* 256 */     LineItemAssociationModifierDAO dao = (LineItemAssociationModifierDAO)argDAO;
/* 257 */     dao.setBusinessDate(this._businessDate);
/* 258 */     dao.setLineItemAssociationModifierSequence(this._lineItemAssociationModifierSequence);
/* 259 */     dao.setOrganizationId(this._organizationId);
/* 260 */     dao.setRetailLocationId(this._retailLocationId);
/* 261 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 262 */     dao.setTransactionSequence(this._transactionSequence);
/* 263 */     dao.setWorkstationId(this._workstationId);
/* 264 */     dao.setCreateDate(this._createDate);
/* 265 */     dao.setCreateUserId(this._createUserId);
/* 266 */     dao.setUpdateDate(this._updateDate);
/* 267 */     dao.setUpdateUserId(this._updateUserId);
/* 268 */     dao.setChildBusinessDate(this._childBusinessDate);
/* 269 */     dao.setChildRetailLocationId(this._childRetailLocationId);
/* 270 */     dao.setChildRetailTransactionLineItemSequence(this._childRetailTransactionLineItemSequence);
/* 271 */     dao.setChildTransactionSequence(this._childTransactionSequence);
/* 272 */     dao.setChildWorkstationId(this._childWorkstationId);
/* 273 */     dao.setLineItemAssociationTypeCodeString(this._lineItemAssociationTypeCodeString);
/* 274 */     argDAO.suppressStateChanges(false);
/* 275 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 279 */     return loadDAO((IDataAccessObject)new LineItemAssociationModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 283 */     LineItemAssociationModifierDAO dao = (LineItemAssociationModifierDAO)argDAO;
/* 284 */     this._businessDate = dao.getBusinessDate();
/* 285 */     this._lineItemAssociationModifierSequence = dao.getLineItemAssociationModifierSequence();
/* 286 */     this._organizationId = dao.getOrganizationId();
/* 287 */     this._retailLocationId = dao.getRetailLocationId();
/* 288 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 289 */     this._transactionSequence = dao.getTransactionSequence();
/* 290 */     this._workstationId = dao.getWorkstationId();
/* 291 */     this._createDate = dao.getCreateDate();
/* 292 */     this._createUserId = dao.getCreateUserId();
/* 293 */     this._updateDate = dao.getUpdateDate();
/* 294 */     this._updateUserId = dao.getUpdateUserId();
/* 295 */     this._childBusinessDate = dao.getChildBusinessDate();
/* 296 */     this._childRetailLocationId = dao.getChildRetailLocationId();
/* 297 */     this._childRetailTransactionLineItemSequence = dao.getChildRetailTransactionLineItemSequence();
/* 298 */     this._childTransactionSequence = dao.getChildTransactionSequence();
/* 299 */     this._childWorkstationId = dao.getChildWorkstationId();
/* 300 */     this._lineItemAssociationTypeCodeString = dao.getLineItemAssociationTypeCodeString();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 304 */     LineItemAssociationModifierId id = (LineItemAssociationModifierId)argId;
/* 305 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDate().getTime()));
/* 306 */     argStatement.setInt(2, id.getLineItemAssociationModifierSequence().intValue());
/* 307 */     argStatement.setLong(3, id.getOrganizationId().longValue());
/* 308 */     argStatement.setLong(4, id.getRetailLocationId().longValue());
/* 309 */     argStatement.setInt(5, id.getRetailTransactionLineItemSequence().intValue());
/* 310 */     argStatement.setLong(6, id.getTransactionSequence().longValue());
/* 311 */     argStatement.setLong(7, id.getWorkstationId().longValue());
/* 312 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 316 */     LineItemAssociationModifierId id = new LineItemAssociationModifierId();
/* 317 */     id.setBusinessDate(this._businessDate);
/* 318 */     id.setLineItemAssociationModifierSequence(this._lineItemAssociationModifierSequence);
/* 319 */     id.setOrganizationId(this._organizationId);
/* 320 */     id.setRetailLocationId(this._retailLocationId);
/* 321 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 322 */     id.setTransactionSequence(this._transactionSequence);
/* 323 */     id.setWorkstationId(this._workstationId);
/* 324 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 332 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 336 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\LineItemAssociationModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */