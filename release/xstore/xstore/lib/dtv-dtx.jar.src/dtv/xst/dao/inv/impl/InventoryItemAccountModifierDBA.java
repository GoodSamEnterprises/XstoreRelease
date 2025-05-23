/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryItemAccountModifierId;
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
/*     */ public class InventoryItemAccountModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 77985205L;
/*     */   private Long _organizationId;
/*     */   private String _documentId;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private String _documentTypeCode;
/*     */   private Long _retailLocationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _custAccountCode;
/*     */   private String _custAccountId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.invctl_document_id, t.invctl_document_line_nbr, t.document_typcode, t.rtl_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.cust_acct_code, t.cust_acct_id FROM inv_item_acct_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND invctl_document_id = ?  AND invctl_document_line_nbr = ?  AND document_typcode = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.invctl_document_id, t.invctl_document_line_nbr, t.document_typcode, t.rtl_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.cust_acct_code, t.cust_acct_id FROM inv_item_acct_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND invctl_document_id = ?  AND invctl_document_line_nbr = ?  AND document_typcode = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_item_acct_mod(organization_id, invctl_document_id, invctl_document_line_nbr, document_typcode, rtl_loc_id, create_date, create_user_id, update_date, update_user_id, cust_acct_code, cust_acct_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._documentId, this._inventoryDocumentLineNumber, this._documentTypeCode, this._retailLocationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._custAccountCode, this._custAccountId } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 12, -5, 91, 12, 91, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_item_acct_mod SET update_date = ?, update_user_id = ?, cust_acct_code = ?, cust_acct_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._custAccountCode, this._custAccountId } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_item_acct_mod" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND invctl_document_id = ?  AND invctl_document_line_nbr = ?  AND document_typcode = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND invctl_document_id = ?  AND invctl_document_line_nbr = ?  AND document_typcode = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._documentId, this._inventoryDocumentLineNumber, this._documentTypeCode, this._retailLocationId };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "inv_item_acct_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new InventoryItemAccountModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryItemAccountModifierFiller
/*     */     implements IFiller {
/*     */     private InventoryItemAccountModifierDBA _parent;
/*     */     
/*     */     public InventoryItemAccountModifierFiller(InventoryItemAccountModifierDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       long l1 = argResultSet.getLong(1);
/* 129 */       if (l1 != 0L || argResultSet.getObject(1) != null) {
/* 130 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 134 */       this._parent._documentId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 137 */       int i = argResultSet.getInt(3);
/* 138 */       if (i != 0 || argResultSet.getObject(3) != null) {
/* 139 */         this._parent._inventoryDocumentLineNumber = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 143 */       this._parent._documentTypeCode = argResultSet.getString(4);
/*     */ 
/*     */       
/* 146 */       long primitiveResult = argResultSet.getLong(5);
/* 147 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 148 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 153 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 154 */       if (t6 != null) {
/* 155 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 158 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 161 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 163 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 164 */       if (t8 != null) {
/* 165 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 168 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 171 */       this._parent._updateUserId = argResultSet.getString(9);
/* 172 */       this._parent._custAccountCode = argResultSet.getString(10);
/* 173 */       this._parent._custAccountId = argResultSet.getString(11);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 178 */     argDAO.suppressStateChanges(true);
/* 179 */     InventoryItemAccountModifierDAO dao = (InventoryItemAccountModifierDAO)argDAO;
/* 180 */     dao.setOrganizationId(this._organizationId);
/* 181 */     dao.setDocumentId(this._documentId);
/* 182 */     dao.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 183 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 184 */     dao.setRetailLocationId(this._retailLocationId);
/* 185 */     dao.setCreateDate(this._createDate);
/* 186 */     dao.setCreateUserId(this._createUserId);
/* 187 */     dao.setUpdateDate(this._updateDate);
/* 188 */     dao.setUpdateUserId(this._updateUserId);
/* 189 */     dao.setCustAccountCode(this._custAccountCode);
/* 190 */     dao.setCustAccountId(this._custAccountId);
/* 191 */     argDAO.suppressStateChanges(false);
/* 192 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 196 */     return loadDAO((IDataAccessObject)new InventoryItemAccountModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 200 */     InventoryItemAccountModifierDAO dao = (InventoryItemAccountModifierDAO)argDAO;
/* 201 */     this._organizationId = dao.getOrganizationId();
/* 202 */     this._documentId = dao.getDocumentId();
/* 203 */     this._inventoryDocumentLineNumber = dao.getInventoryDocumentLineNumber();
/* 204 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 205 */     this._retailLocationId = dao.getRetailLocationId();
/* 206 */     this._createDate = dao.getCreateDate();
/* 207 */     this._createUserId = dao.getCreateUserId();
/* 208 */     this._updateDate = dao.getUpdateDate();
/* 209 */     this._updateUserId = dao.getUpdateUserId();
/* 210 */     this._custAccountCode = dao.getCustAccountCode();
/* 211 */     this._custAccountId = dao.getCustAccountId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 215 */     InventoryItemAccountModifierId id = (InventoryItemAccountModifierId)argId;
/* 216 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 217 */     argStatement.setString(2, id.getDocumentId());
/* 218 */     argStatement.setInt(3, id.getInventoryDocumentLineNumber().intValue());
/* 219 */     argStatement.setString(4, id.getDocumentTypeCode());
/* 220 */     argStatement.setLong(5, id.getRetailLocationId().longValue());
/* 221 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 225 */     InventoryItemAccountModifierId id = new InventoryItemAccountModifierId();
/* 226 */     id.setOrganizationId(this._organizationId);
/* 227 */     id.setDocumentId(this._documentId);
/* 228 */     id.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 229 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 230 */     id.setRetailLocationId(this._retailLocationId);
/* 231 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 239 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 243 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryItemAccountModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */