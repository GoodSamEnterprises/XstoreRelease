/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryDocumentLineSerialId;
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
/*     */ public class InventoryDocumentLineSerialDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 423606495L;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _serialLineNumber;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _serialNumber;
/*     */   private static final String SELECT_OBJECT = "SELECT t.invctl_document_id, t.document_typcode, t.invctl_document_line_nbr, t.organization_id, t.rtl_loc_id, t.serial_line_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.serial_nbr FROM inv_invctl_doc_lineserial t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND serial_line_nbr = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.invctl_document_id, t.document_typcode, t.invctl_document_line_nbr, t.organization_id, t.rtl_loc_id, t.serial_line_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.serial_nbr FROM inv_invctl_doc_lineserial t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND serial_line_nbr = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_invctl_doc_lineserial(invctl_document_id, document_typcode, invctl_document_line_nbr, organization_id, rtl_loc_id, serial_line_nbr, create_date, create_user_id, update_date, update_user_id, serial_nbr) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._documentId, this._documentTypeCode, this._inventoryDocumentLineNumber, this._organizationId, this._retailLocationId, this._serialLineNumber, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._serialNumber } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, 12, 4, -5, -5, 4, 91, 12, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_invctl_doc_lineserial SET update_date = ?, update_user_id = ?, serial_nbr = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._serialNumber } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_invctl_doc_lineserial" }; private static final String WHERE_OBJECT = " WHERE invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND serial_line_nbr = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE invctl_document_id = ?  AND document_typcode = ?  AND invctl_document_line_nbr = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND serial_line_nbr = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._documentId, this._documentTypeCode, this._inventoryDocumentLineNumber, this._organizationId, this._retailLocationId, this._serialLineNumber };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, 12, 4, -5, -5, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "inv_invctl_doc_lineserial";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new InventoryDocumentLineSerialFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryDocumentLineSerialFiller
/*     */     implements IFiller {
/*     */     private InventoryDocumentLineSerialDBA _parent;
/*     */     
/*     */     public InventoryDocumentLineSerialFiller(InventoryDocumentLineSerialDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 126 */       this._parent._documentId = argResultSet.getString(1);
/* 127 */       this._parent._documentTypeCode = argResultSet.getString(2);
/*     */ 
/*     */       
/* 130 */       int i = argResultSet.getInt(3);
/* 131 */       if (i != 0 || argResultSet.getObject(3) != null) {
/* 132 */         this._parent._inventoryDocumentLineNumber = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 138 */       long l = argResultSet.getLong(4);
/* 139 */       if (l != 0L || argResultSet.getObject(4) != null) {
/* 140 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 146 */       l = argResultSet.getLong(5);
/* 147 */       if (l != 0L || argResultSet.getObject(5) != null) {
/* 148 */         this._parent._retailLocationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 154 */       int primitiveResult = argResultSet.getInt(6);
/* 155 */       if (primitiveResult != 0 || argResultSet.getObject(6) != null) {
/* 156 */         this._parent._serialLineNumber = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 161 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 162 */       if (t7 != null) {
/* 163 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 166 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 169 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 171 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 172 */       if (t9 != null) {
/* 173 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 176 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 179 */       this._parent._updateUserId = argResultSet.getString(10);
/* 180 */       this._parent._serialNumber = argResultSet.getString(11);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 185 */     argDAO.suppressStateChanges(true);
/* 186 */     InventoryDocumentLineSerialDAO dao = (InventoryDocumentLineSerialDAO)argDAO;
/* 187 */     dao.setDocumentId(this._documentId);
/* 188 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 189 */     dao.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 190 */     dao.setOrganizationId(this._organizationId);
/* 191 */     dao.setRetailLocationId(this._retailLocationId);
/* 192 */     dao.setSerialLineNumber(this._serialLineNumber);
/* 193 */     dao.setCreateDate(this._createDate);
/* 194 */     dao.setCreateUserId(this._createUserId);
/* 195 */     dao.setUpdateDate(this._updateDate);
/* 196 */     dao.setUpdateUserId(this._updateUserId);
/* 197 */     dao.setSerialNumber(this._serialNumber);
/* 198 */     argDAO.suppressStateChanges(false);
/* 199 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 203 */     return loadDAO((IDataAccessObject)new InventoryDocumentLineSerialDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 207 */     InventoryDocumentLineSerialDAO dao = (InventoryDocumentLineSerialDAO)argDAO;
/* 208 */     this._documentId = dao.getDocumentId();
/* 209 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 210 */     this._inventoryDocumentLineNumber = dao.getInventoryDocumentLineNumber();
/* 211 */     this._organizationId = dao.getOrganizationId();
/* 212 */     this._retailLocationId = dao.getRetailLocationId();
/* 213 */     this._serialLineNumber = dao.getSerialLineNumber();
/* 214 */     this._createDate = dao.getCreateDate();
/* 215 */     this._createUserId = dao.getCreateUserId();
/* 216 */     this._updateDate = dao.getUpdateDate();
/* 217 */     this._updateUserId = dao.getUpdateUserId();
/* 218 */     this._serialNumber = dao.getSerialNumber();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 222 */     InventoryDocumentLineSerialId id = (InventoryDocumentLineSerialId)argId;
/* 223 */     argStatement.setString(1, id.getDocumentId());
/* 224 */     argStatement.setString(2, id.getDocumentTypeCode());
/* 225 */     argStatement.setInt(3, id.getInventoryDocumentLineNumber().intValue());
/* 226 */     argStatement.setLong(4, id.getOrganizationId().longValue());
/* 227 */     argStatement.setLong(5, id.getRetailLocationId().longValue());
/* 228 */     argStatement.setInt(6, id.getSerialLineNumber().intValue());
/* 229 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 233 */     InventoryDocumentLineSerialId id = new InventoryDocumentLineSerialId();
/* 234 */     id.setDocumentId(this._documentId);
/* 235 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 236 */     id.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 237 */     id.setOrganizationId(this._organizationId);
/* 238 */     id.setRetailLocationId(this._retailLocationId);
/* 239 */     id.setSerialLineNumber(this._serialLineNumber);
/* 240 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 248 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 252 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentLineSerialDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */