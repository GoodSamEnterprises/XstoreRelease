/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.CartonId;
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
/*     */ public class CartonDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 2011245855L;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private String _cartonId;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _cartonStatusCode;
/*     */   private String _controlNumber;
/*     */   private String _recordCreationType;
/*     */   private static final String SELECT_OBJECT = "SELECT t.invctl_document_id, t.document_typcode, t.carton_id, t.organization_id, t.rtl_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.carton_statcode, t.control_number, t.record_creation_type FROM inv_carton t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE invctl_document_id = ?  AND document_typcode = ?  AND carton_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.invctl_document_id, t.document_typcode, t.carton_id, t.organization_id, t.rtl_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.carton_statcode, t.control_number, t.record_creation_type FROM inv_carton t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE invctl_document_id = ?  AND document_typcode = ?  AND carton_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_carton(invctl_document_id, document_typcode, carton_id, organization_id, rtl_loc_id, create_date, create_user_id, update_date, update_user_id, carton_statcode, control_number, record_creation_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._documentId, this._documentTypeCode, this._cartonId, this._organizationId, this._retailLocationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._cartonStatusCode, this._controlNumber, this._recordCreationType } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, 12, 12, -5, -5, 91, 12, 91, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_carton SET update_date = ?, update_user_id = ?, carton_statcode = ?, control_number = ?, record_creation_type = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._cartonStatusCode, this._controlNumber, this._recordCreationType } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_carton" }; private static final String WHERE_OBJECT = " WHERE invctl_document_id = ?  AND document_typcode = ?  AND carton_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE invctl_document_id = ?  AND document_typcode = ?  AND carton_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._documentId, this._documentTypeCode, this._cartonId, this._organizationId, this._retailLocationId };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, 12, 12, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "inv_carton";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new CartonFiller(this);
/*     */   }
/*     */   
/*     */   private static class CartonFiller
/*     */     implements IFiller {
/*     */     private CartonDBA _parent;
/*     */     
/*     */     public CartonFiller(CartonDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 127 */       this._parent._documentId = argResultSet.getString(1);
/* 128 */       this._parent._documentTypeCode = argResultSet.getString(2);
/* 129 */       this._parent._cartonId = argResultSet.getString(3);
/*     */ 
/*     */       
/* 132 */       long primitiveResult = argResultSet.getLong(4);
/* 133 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 134 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 140 */       primitiveResult = argResultSet.getLong(5);
/* 141 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 142 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 147 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 148 */       if (t6 != null) {
/* 149 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 152 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 155 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 157 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 158 */       if (t8 != null) {
/* 159 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 162 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 165 */       this._parent._updateUserId = argResultSet.getString(9);
/* 166 */       this._parent._cartonStatusCode = argResultSet.getString(10);
/* 167 */       this._parent._controlNumber = argResultSet.getString(11);
/* 168 */       this._parent._recordCreationType = argResultSet.getString(12);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 173 */     argDAO.suppressStateChanges(true);
/* 174 */     CartonDAO dao = (CartonDAO)argDAO;
/* 175 */     dao.setDocumentId(this._documentId);
/* 176 */     dao.setDocumentTypeCode(this._documentTypeCode);
/* 177 */     dao.setCartonId(this._cartonId);
/* 178 */     dao.setOrganizationId(this._organizationId);
/* 179 */     dao.setRetailLocationId(this._retailLocationId);
/* 180 */     dao.setCreateDate(this._createDate);
/* 181 */     dao.setCreateUserId(this._createUserId);
/* 182 */     dao.setUpdateDate(this._updateDate);
/* 183 */     dao.setUpdateUserId(this._updateUserId);
/* 184 */     dao.setCartonStatusCode(this._cartonStatusCode);
/* 185 */     dao.setControlNumber(this._controlNumber);
/* 186 */     dao.setRecordCreationType(this._recordCreationType);
/* 187 */     argDAO.suppressStateChanges(false);
/* 188 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 192 */     return loadDAO((IDataAccessObject)new CartonDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 196 */     CartonDAO dao = (CartonDAO)argDAO;
/* 197 */     this._documentId = dao.getDocumentId();
/* 198 */     this._documentTypeCode = dao.getDocumentTypeCode();
/* 199 */     this._cartonId = dao.getCartonId();
/* 200 */     this._organizationId = dao.getOrganizationId();
/* 201 */     this._retailLocationId = dao.getRetailLocationId();
/* 202 */     this._createDate = dao.getCreateDate();
/* 203 */     this._createUserId = dao.getCreateUserId();
/* 204 */     this._updateDate = dao.getUpdateDate();
/* 205 */     this._updateUserId = dao.getUpdateUserId();
/* 206 */     this._cartonStatusCode = dao.getCartonStatusCode();
/* 207 */     this._controlNumber = dao.getControlNumber();
/* 208 */     this._recordCreationType = dao.getRecordCreationType();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 212 */     CartonId id = (CartonId)argId;
/* 213 */     argStatement.setString(1, id.getDocumentId());
/* 214 */     argStatement.setString(2, id.getDocumentTypeCode());
/* 215 */     argStatement.setString(3, id.getCartonId());
/* 216 */     argStatement.setLong(4, id.getOrganizationId().longValue());
/* 217 */     argStatement.setLong(5, id.getRetailLocationId().longValue());
/* 218 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 222 */     CartonId id = new CartonId();
/* 223 */     id.setDocumentId(this._documentId);
/* 224 */     id.setDocumentTypeCode(this._documentTypeCode);
/* 225 */     id.setCartonId(this._cartonId);
/* 226 */     id.setOrganizationId(this._organizationId);
/* 227 */     id.setRetailLocationId(this._retailLocationId);
/* 228 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 236 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 240 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\CartonDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */