/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryValidDestinationsId;
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
/*     */ public class InventoryValidDestinationsDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 866266725L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _documentTypeCode;
/*     */   private String _documentSubtypeCode;
/*     */   private String _destinationTypeEnum;
/*     */   private String _destinationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _description;
/*     */   private Integer _sortOrder;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.document_typcode, t.document_subtypcode, t.destination_type_enum, t.destination_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.description, t.sort_order FROM inv_valid_destinations t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND document_typcode = ?  AND document_subtypcode = ?  AND destination_type_enum = ?  AND destination_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.rtl_loc_id, t.document_typcode, t.document_subtypcode, t.destination_type_enum, t.destination_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.description, t.sort_order FROM inv_valid_destinations t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND document_typcode = ?  AND document_subtypcode = ?  AND destination_type_enum = ?  AND destination_id = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_valid_destinations(organization_id, rtl_loc_id, document_typcode, document_subtypcode, destination_type_enum, destination_id, create_date, create_user_id, update_date, update_user_id, description, sort_order) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._documentTypeCode, this._documentSubtypeCode, this._destinationTypeEnum, this._destinationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._description, this._sortOrder } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 12, 12, 91, 12, 91, 12, 12, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_valid_destinations SET update_date = ?, update_user_id = ?, description = ?, sort_order = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._description, this._sortOrder } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_valid_destinations" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND document_typcode = ?  AND document_subtypcode = ?  AND destination_type_enum = ?  AND destination_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND document_typcode = ?  AND document_subtypcode = ?  AND destination_type_enum = ?  AND destination_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._retailLocationId, this._documentTypeCode, this._documentSubtypeCode, this._destinationTypeEnum, this._destinationId };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "inv_valid_destinations";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new InventoryValidDestinationsFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryValidDestinationsFiller
/*     */     implements IFiller {
/*     */     private InventoryValidDestinationsDBA _parent;
/*     */     
/*     */     public InventoryValidDestinationsFiller(InventoryValidDestinationsDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       long primitiveResult = argResultSet.getLong(1);
/* 130 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 137 */       primitiveResult = argResultSet.getLong(2);
/* 138 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 139 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 143 */       this._parent._documentTypeCode = argResultSet.getString(3);
/* 144 */       this._parent._documentSubtypeCode = argResultSet.getString(4);
/* 145 */       this._parent._destinationTypeEnum = argResultSet.getString(5);
/* 146 */       this._parent._destinationId = argResultSet.getString(6);
/*     */       
/* 148 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 149 */       if (t7 != null) {
/* 150 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 153 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 156 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 158 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 159 */       if (t9 != null) {
/* 160 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 163 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 166 */       this._parent._updateUserId = argResultSet.getString(10);
/* 167 */       this._parent._description = argResultSet.getString(11);
/*     */ 
/*     */       
/* 170 */       int i = argResultSet.getInt(12);
/* 171 */       if (i != 0 || argResultSet.getObject(12) != null) {
/* 172 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 180 */     argDAO.suppressStateChanges(true);
/* 181 */     InventoryValidDestinationsDAO dao = (InventoryValidDestinationsDAO)argDAO;
/* 182 */     dao.setOrganizationId(this._organizationId);
/* 183 */     dao.setRetailLocationId(this._retailLocationId);
/* 184 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 185 */     dao.setDocumentSubtypeCode(this._documentSubtypeCode);
/* 186 */     dao.setDestinationTypeEnum(this._destinationTypeEnum);
/* 187 */     dao.setDestinationId(this._destinationId);
/* 188 */     dao.setCreateDate(this._createDate);
/* 189 */     dao.setCreateUserId(this._createUserId);
/* 190 */     dao.setUpdateDate(this._updateDate);
/* 191 */     dao.setUpdateUserId(this._updateUserId);
/* 192 */     dao.setDescription(this._description);
/* 193 */     dao.setSortOrder(this._sortOrder);
/* 194 */     argDAO.suppressStateChanges(false);
/* 195 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 199 */     return loadDAO((IDataAccessObject)new InventoryValidDestinationsDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 203 */     InventoryValidDestinationsDAO dao = (InventoryValidDestinationsDAO)argDAO;
/* 204 */     this._organizationId = dao.getOrganizationId();
/* 205 */     this._retailLocationId = dao.getRetailLocationId();
/* 206 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 207 */     this._documentSubtypeCode = dao.getDocumentSubtypeCode();
/* 208 */     this._destinationTypeEnum = dao.getDestinationTypeEnum();
/* 209 */     this._destinationId = dao.getDestinationId();
/* 210 */     this._createDate = dao.getCreateDate();
/* 211 */     this._createUserId = dao.getCreateUserId();
/* 212 */     this._updateDate = dao.getUpdateDate();
/* 213 */     this._updateUserId = dao.getUpdateUserId();
/* 214 */     this._description = dao.getDescription();
/* 215 */     this._sortOrder = dao.getSortOrder();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 219 */     InventoryValidDestinationsId id = (InventoryValidDestinationsId)argId;
/* 220 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 221 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 222 */     argStatement.setString(3, id.getDocumentTypeCode());
/* 223 */     argStatement.setString(4, id.getDocumentSubtypeCode());
/* 224 */     argStatement.setString(5, id.getDestinationTypeEnum());
/* 225 */     argStatement.setString(6, id.getDestinationId());
/* 226 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 230 */     InventoryValidDestinationsId id = new InventoryValidDestinationsId();
/* 231 */     id.setOrganizationId(this._organizationId);
/* 232 */     id.setRetailLocationId(this._retailLocationId);
/* 233 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 234 */     id.setDocumentSubtypeCode(this._documentSubtypeCode);
/* 235 */     id.setDestinationTypeEnum(this._destinationTypeEnum);
/* 236 */     id.setDestinationId(this._destinationId);
/* 237 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 245 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 249 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryValidDestinationsDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */