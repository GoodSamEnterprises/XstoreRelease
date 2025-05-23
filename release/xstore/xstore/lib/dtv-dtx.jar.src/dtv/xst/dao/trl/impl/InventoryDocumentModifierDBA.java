/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.InventoryDocumentModifierId;
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
/*     */ public class InventoryDocumentModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1151176082L;
/*     */   private Date _businessDate;
/*     */   private Integer _documentModifierSequence;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.invctl_document_mod_seq, t.organization_id, t.rtl_loc_id, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.invctl_document_id, t.document_typcode FROM trl_invctl_document_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND invctl_document_mod_seq = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.business_date, t.invctl_document_mod_seq, t.organization_id, t.rtl_loc_id, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.invctl_document_id, t.document_typcode FROM trl_invctl_document_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE business_date = ?  AND invctl_document_mod_seq = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_invctl_document_mod(business_date, invctl_document_mod_seq, organization_id, rtl_loc_id, trans_seq, wkstn_id, create_date, create_user_id, update_date, update_user_id, invctl_document_id, document_typcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._businessDate, this._documentModifierSequence, this._organizationId, this._retailLocationId, this._transactionSequence, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._documentId, this._documentTypeCode } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, 4, -5, -5, -5, -5, 91, 12, 91, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_invctl_document_mod SET update_date = ?, update_user_id = ?, invctl_document_id = ?, document_typcode = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._documentId, this._documentTypeCode } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_invctl_document_mod" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND invctl_document_mod_seq = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE business_date = ?  AND invctl_document_mod_seq = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._businessDate, this._documentModifierSequence, this._organizationId, this._retailLocationId, this._transactionSequence, this._workstationId };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, 4, -5, -5, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "trl_invctl_document_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new InventoryDocumentModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryDocumentModifierFiller
/*     */     implements IFiller {
/*     */     private InventoryDocumentModifierDBA _parent;
/*     */     
/*     */     public InventoryDocumentModifierFiller(InventoryDocumentModifierDBA argParent) {
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
/*     */ 
/*     */       
/* 138 */       int i = argResultSet.getInt(2);
/* 139 */       if (i != 0 || argResultSet.getObject(2) != null) {
/* 140 */         this._parent._documentModifierSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 146 */       long primitiveResult = argResultSet.getLong(3);
/* 147 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 148 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 154 */       primitiveResult = argResultSet.getLong(4);
/* 155 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 156 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 162 */       primitiveResult = argResultSet.getLong(5);
/* 163 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 164 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 170 */       primitiveResult = argResultSet.getLong(6);
/* 171 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 172 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 177 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 178 */       if (t7 != null) {
/* 179 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 182 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 185 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 187 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 188 */       if (t9 != null) {
/* 189 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 192 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 195 */       this._parent._updateUserId = argResultSet.getString(10);
/* 196 */       this._parent._documentId = argResultSet.getString(11);
/* 197 */       this._parent._documentTypeCode = argResultSet.getString(12);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 202 */     argDAO.suppressStateChanges(true);
/* 203 */     InventoryDocumentModifierDAO dao = (InventoryDocumentModifierDAO)argDAO;
/* 204 */     dao.setBusinessDate(this._businessDate);
/* 205 */     dao.setDocumentModifierSequence(this._documentModifierSequence);
/* 206 */     dao.setOrganizationId(this._organizationId);
/* 207 */     dao.setRetailLocationId(this._retailLocationId);
/* 208 */     dao.setTransactionSequence(this._transactionSequence);
/* 209 */     dao.setWorkstationId(this._workstationId);
/* 210 */     dao.setCreateDate(this._createDate);
/* 211 */     dao.setCreateUserId(this._createUserId);
/* 212 */     dao.setUpdateDate(this._updateDate);
/* 213 */     dao.setUpdateUserId(this._updateUserId);
/* 214 */     dao.setDocumentId(this._documentId);
/* 215 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 216 */     argDAO.suppressStateChanges(false);
/* 217 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 221 */     return loadDAO((IDataAccessObject)new InventoryDocumentModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 225 */     InventoryDocumentModifierDAO dao = (InventoryDocumentModifierDAO)argDAO;
/* 226 */     this._businessDate = dao.getBusinessDate();
/* 227 */     this._documentModifierSequence = dao.getDocumentModifierSequence();
/* 228 */     this._organizationId = dao.getOrganizationId();
/* 229 */     this._retailLocationId = dao.getRetailLocationId();
/* 230 */     this._transactionSequence = dao.getTransactionSequence();
/* 231 */     this._workstationId = dao.getWorkstationId();
/* 232 */     this._createDate = dao.getCreateDate();
/* 233 */     this._createUserId = dao.getCreateUserId();
/* 234 */     this._updateDate = dao.getUpdateDate();
/* 235 */     this._updateUserId = dao.getUpdateUserId();
/* 236 */     this._documentId = dao.getDocumentId();
/* 237 */     this._documentTypeCode = dao.getDocumentTypeCode();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 241 */     InventoryDocumentModifierId id = (InventoryDocumentModifierId)argId;
/* 242 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDate().getTime()));
/* 243 */     argStatement.setInt(2, id.getDocumentModifierSequence().intValue());
/* 244 */     argStatement.setLong(3, id.getOrganizationId().longValue());
/* 245 */     argStatement.setLong(4, id.getRetailLocationId().longValue());
/* 246 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 247 */     argStatement.setLong(6, id.getWorkstationId().longValue());
/* 248 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 252 */     InventoryDocumentModifierId id = new InventoryDocumentModifierId();
/* 253 */     id.setBusinessDate(this._businessDate);
/* 254 */     id.setDocumentModifierSequence(this._documentModifierSequence);
/* 255 */     id.setOrganizationId(this._organizationId);
/* 256 */     id.setRetailLocationId(this._retailLocationId);
/* 257 */     id.setTransactionSequence(this._transactionSequence);
/* 258 */     id.setWorkstationId(this._workstationId);
/* 259 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 267 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 271 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\InventoryDocumentModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */