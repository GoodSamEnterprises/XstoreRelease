/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryDocumentCrossReferenceId;
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
/*     */ public class InventoryDocumentCrossReferenceDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -683921086L;
/*     */   private Long _organizationId;
/*     */   private String _documentId;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private String _documentTypeCode;
/*     */   private Long _retailLocationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _crossRefOrganizationId;
/*     */   private String _crossRefDocumentId;
/*     */   private Integer _crossRefLineNumber;
/*     */   private String _crossRefDocumentTypeCode;
/*     */   private Long _crossRefRetailLocationId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.invctl_document_id, t.invctl_document_line_nbr, t.document_typcode, t.rtl_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.cross_ref_organization_id, t.cross_ref_document_id, t.cross_ref_line_number, t.cross_ref_document_typcode, t.cross_ref_rtl_loc_id FROM inv_invctl_document_xref t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND invctl_document_id = ?  AND invctl_document_line_nbr = ?  AND document_typcode = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.invctl_document_id, t.invctl_document_line_nbr, t.document_typcode, t.rtl_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.cross_ref_organization_id, t.cross_ref_document_id, t.cross_ref_line_number, t.cross_ref_document_typcode, t.cross_ref_rtl_loc_id FROM inv_invctl_document_xref t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND invctl_document_id = ?  AND invctl_document_line_nbr = ?  AND document_typcode = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_invctl_document_xref(organization_id, invctl_document_id, invctl_document_line_nbr, document_typcode, rtl_loc_id, create_date, create_user_id, update_date, update_user_id, cross_ref_organization_id, cross_ref_document_id, cross_ref_line_number, cross_ref_document_typcode, cross_ref_rtl_loc_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._documentId, this._inventoryDocumentLineNumber, this._documentTypeCode, this._retailLocationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._crossRefOrganizationId, this._crossRefDocumentId, this._crossRefLineNumber, this._crossRefDocumentTypeCode, this._crossRefRetailLocationId } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 12, -5, 91, 12, 91, 12, -5, 12, 4, 12, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_invctl_document_xref SET update_date = ?, update_user_id = ?, cross_ref_organization_id = ?, cross_ref_document_id = ?, cross_ref_line_number = ?, cross_ref_document_typcode = ?, cross_ref_rtl_loc_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._crossRefOrganizationId, this._crossRefDocumentId, this._crossRefLineNumber, this._crossRefDocumentTypeCode, this._crossRefRetailLocationId } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -5, 12, 4, 12, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_invctl_document_xref" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND invctl_document_id = ?  AND invctl_document_line_nbr = ?  AND document_typcode = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND invctl_document_id = ?  AND invctl_document_line_nbr = ?  AND document_typcode = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._documentId, this._inventoryDocumentLineNumber, this._documentTypeCode, this._retailLocationId };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "inv_invctl_document_xref";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new InventoryDocumentCrossReferenceFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryDocumentCrossReferenceFiller
/*     */     implements IFiller {
/*     */     private InventoryDocumentCrossReferenceDBA _parent;
/*     */     
/*     */     public InventoryDocumentCrossReferenceFiller(InventoryDocumentCrossReferenceDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       long l1 = argResultSet.getLong(1);
/* 132 */       if (l1 != 0L || argResultSet.getObject(1) != null) {
/* 133 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 137 */       this._parent._documentId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 140 */       int i = argResultSet.getInt(3);
/* 141 */       if (i != 0 || argResultSet.getObject(3) != null) {
/* 142 */         this._parent._inventoryDocumentLineNumber = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 146 */       this._parent._documentTypeCode = argResultSet.getString(4);
/*     */ 
/*     */       
/* 149 */       long primitiveResult = argResultSet.getLong(5);
/* 150 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 151 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 156 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 157 */       if (t6 != null) {
/* 158 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 161 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 164 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 166 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 167 */       if (t8 != null) {
/* 168 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 171 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 174 */       this._parent._updateUserId = argResultSet.getString(9);
/*     */ 
/*     */       
/* 177 */       long l3 = argResultSet.getLong(10);
/* 178 */       if (l3 != 0L || argResultSet.getObject(10) != null) {
/* 179 */         this._parent._crossRefOrganizationId = Long.valueOf(l3);
/*     */       }
/*     */ 
/*     */       
/* 183 */       this._parent._crossRefDocumentId = argResultSet.getString(11);
/*     */ 
/*     */       
/* 186 */       int j = argResultSet.getInt(12);
/* 187 */       if (j != 0 || argResultSet.getObject(12) != null) {
/* 188 */         this._parent._crossRefLineNumber = Integer.valueOf(j);
/*     */       }
/*     */ 
/*     */       
/* 192 */       this._parent._crossRefDocumentTypeCode = argResultSet.getString(13);
/*     */ 
/*     */       
/* 195 */       long l2 = argResultSet.getLong(14);
/* 196 */       if (l2 != 0L || argResultSet.getObject(14) != null) {
/* 197 */         this._parent._crossRefRetailLocationId = Long.valueOf(l2);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 205 */     argDAO.suppressStateChanges(true);
/* 206 */     InventoryDocumentCrossReferenceDAO dao = (InventoryDocumentCrossReferenceDAO)argDAO;
/* 207 */     dao.setOrganizationId(this._organizationId);
/* 208 */     dao.setDocumentId(this._documentId);
/* 209 */     dao.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 210 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 211 */     dao.setRetailLocationId(this._retailLocationId);
/* 212 */     dao.setCreateDate(this._createDate);
/* 213 */     dao.setCreateUserId(this._createUserId);
/* 214 */     dao.setUpdateDate(this._updateDate);
/* 215 */     dao.setUpdateUserId(this._updateUserId);
/* 216 */     dao.setCrossRefOrganizationId(this._crossRefOrganizationId);
/* 217 */     dao.setCrossRefDocumentId(this._crossRefDocumentId);
/* 218 */     dao.setCrossRefLineNumber(this._crossRefLineNumber);
/* 219 */     dao.setCrossRefDocumentTypeCode(this._crossRefDocumentTypeCode);
/* 220 */     dao.setCrossRefRetailLocationId(this._crossRefRetailLocationId);
/* 221 */     argDAO.suppressStateChanges(false);
/* 222 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 226 */     return loadDAO((IDataAccessObject)new InventoryDocumentCrossReferenceDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 230 */     InventoryDocumentCrossReferenceDAO dao = (InventoryDocumentCrossReferenceDAO)argDAO;
/* 231 */     this._organizationId = dao.getOrganizationId();
/* 232 */     this._documentId = dao.getDocumentId();
/* 233 */     this._inventoryDocumentLineNumber = dao.getInventoryDocumentLineNumber();
/* 234 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 235 */     this._retailLocationId = dao.getRetailLocationId();
/* 236 */     this._createDate = dao.getCreateDate();
/* 237 */     this._createUserId = dao.getCreateUserId();
/* 238 */     this._updateDate = dao.getUpdateDate();
/* 239 */     this._updateUserId = dao.getUpdateUserId();
/* 240 */     this._crossRefOrganizationId = dao.getCrossRefOrganizationId();
/* 241 */     this._crossRefDocumentId = dao.getCrossRefDocumentId();
/* 242 */     this._crossRefLineNumber = dao.getCrossRefLineNumber();
/* 243 */     this._crossRefDocumentTypeCode = dao.getCrossRefDocumentTypeCode();
/* 244 */     this._crossRefRetailLocationId = dao.getCrossRefRetailLocationId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 248 */     InventoryDocumentCrossReferenceId id = (InventoryDocumentCrossReferenceId)argId;
/* 249 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 250 */     argStatement.setString(2, id.getDocumentId());
/* 251 */     argStatement.setInt(3, id.getInventoryDocumentLineNumber().intValue());
/* 252 */     argStatement.setString(4, id.getDocumentTypeCode());
/* 253 */     argStatement.setLong(5, id.getRetailLocationId().longValue());
/* 254 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 258 */     InventoryDocumentCrossReferenceId id = new InventoryDocumentCrossReferenceId();
/* 259 */     id.setOrganizationId(this._organizationId);
/* 260 */     id.setDocumentId(this._documentId);
/* 261 */     id.setInventoryDocumentLineNumber(this._inventoryDocumentLineNumber);
/* 262 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 263 */     id.setRetailLocationId(this._retailLocationId);
/* 264 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 272 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 276 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentCrossReferenceDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */