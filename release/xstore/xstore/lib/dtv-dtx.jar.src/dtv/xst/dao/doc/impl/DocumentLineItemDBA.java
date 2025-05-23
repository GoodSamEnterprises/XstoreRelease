/*     */ package dtv.xst.dao.doc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailTransactionLineItemId;
/*     */ import dtv.xst.dao.trl.impl.RetailTransactionLineItemDBA;
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
/*     */ public class DocumentLineItemDBA
/*     */   extends RetailTransactionLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1314475134L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _seriesId;
/*     */   private String _documentId;
/*     */   private String _documentType;
/*     */   private String _activityCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.series_id, t.document_id, t.document_type, t.activity_code FROM doc_document_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.series_id, t.document_id, t.document_type, t.activity_code FROM doc_document_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO doc_document_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, series_id, document_id, document_type, activity_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  62 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  67 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._seriesId, this._documentId, this._documentType, this._activityCode } };
/*  68 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  71 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 12, 12, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  75 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  78 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE doc_document_lineitm SET update_date = ?, update_user_id = ?, series_id = ?, document_id = ?, document_type = ?, activity_code = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  82 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  87 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._seriesId, this._documentId, this._documentType, this._activityCode } };
/*  88 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  91 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  94 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/*  97 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM doc_document_lineitm" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 101 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 108 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 112 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 115 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 119 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 123 */     return "doc_document_lineitm";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 128 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 132 */     return new DocumentLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class DocumentLineItemFiller
/*     */     implements IFiller {
/*     */     private DocumentLineItemDBA _parent;
/*     */     
/*     */     public DocumentLineItemFiller(DocumentLineItemDBA argParent) {
/* 140 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 145 */       long primitiveResult = argResultSet.getLong(1);
/* 146 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 147 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 153 */       primitiveResult = argResultSet.getLong(2);
/* 154 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 155 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 160 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 161 */       if (t3 != null) {
/* 162 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 165 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 170 */       long l1 = argResultSet.getLong(4);
/* 171 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 172 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 178 */       l1 = argResultSet.getLong(5);
/* 179 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 180 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 186 */       int i = argResultSet.getInt(6);
/* 187 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 188 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 193 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 194 */       if (t7 != null) {
/* 195 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 198 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 201 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 203 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 204 */       if (t9 != null) {
/* 205 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 208 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 211 */       this._parent._updateUserId = argResultSet.getString(10);
/* 212 */       this._parent._seriesId = argResultSet.getString(11);
/* 213 */       this._parent._documentId = argResultSet.getString(12);
/* 214 */       this._parent._documentType = argResultSet.getString(13);
/* 215 */       this._parent._activityCode = argResultSet.getString(14);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 221 */     super.loadDAO(argDAO);
/* 222 */     argDAO.suppressStateChanges(true);
/* 223 */     DocumentLineItemDAO dao = (DocumentLineItemDAO)argDAO;
/* 224 */     dao.setOrganizationId(this._organizationId);
/* 225 */     dao.setRetailLocationId(this._retailLocationId);
/* 226 */     dao.setBusinessDate(this._businessDate);
/* 227 */     dao.setWorkstationId(this._workstationId);
/* 228 */     dao.setTransactionSequence(this._transactionSequence);
/* 229 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 230 */     dao.setCreateDate(this._createDate);
/* 231 */     dao.setCreateUserId(this._createUserId);
/* 232 */     dao.setUpdateDate(this._updateDate);
/* 233 */     dao.setUpdateUserId(this._updateUserId);
/* 234 */     dao.setSeriesId(this._seriesId);
/* 235 */     dao.setDocumentId(this._documentId);
/* 236 */     dao.setDocumentType(this._documentType);
/* 237 */     dao.setActivityCode(this._activityCode);
/* 238 */     argDAO.suppressStateChanges(false);
/* 239 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 244 */     return loadDAO((IDataAccessObject)new DocumentLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 249 */     DocumentLineItemDAO dao = (DocumentLineItemDAO)argDAO;
/* 250 */     super.fill((IDataAccessObject)dao);
/* 251 */     this._organizationId = dao.getOrganizationId();
/* 252 */     this._retailLocationId = dao.getRetailLocationId();
/* 253 */     this._businessDate = dao.getBusinessDate();
/* 254 */     this._workstationId = dao.getWorkstationId();
/* 255 */     this._transactionSequence = dao.getTransactionSequence();
/* 256 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 257 */     this._createDate = dao.getCreateDate();
/* 258 */     this._createUserId = dao.getCreateUserId();
/* 259 */     this._updateDate = dao.getUpdateDate();
/* 260 */     this._updateUserId = dao.getUpdateUserId();
/* 261 */     this._seriesId = dao.getSeriesId();
/* 262 */     this._documentId = dao.getDocumentId();
/* 263 */     this._documentType = dao.getDocumentType();
/* 264 */     this._activityCode = dao.getActivityCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 269 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 270 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 271 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 272 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 273 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 274 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 275 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 276 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 280 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 284 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\impl\DocumentLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */