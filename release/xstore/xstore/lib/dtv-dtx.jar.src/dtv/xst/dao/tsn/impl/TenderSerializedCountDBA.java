/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderSerializedCountId;
/*     */ import java.math.BigDecimal;
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
/*     */ public class TenderSerializedCountDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -395161513L;
/*     */   private Date _businessDayDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _serializedCountSequence;
/*     */   private String _tenderTypeCode;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _amount;
/*     */   private String _serialNumber;
/*     */   private String _tenderId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.serialized_tndr_count_seq, t.tndr_typcode, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.serial_number, t.tndr_id FROM tsn_serialized_tndr_count t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND serialized_tndr_count_seq = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.serialized_tndr_count_seq, t.tndr_typcode, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.serial_number, t.tndr_id FROM tsn_serialized_tndr_count t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND serialized_tndr_count_seq = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_serialized_tndr_count(business_date, organization_id, rtl_loc_id, serialized_tndr_count_seq, tndr_typcode, trans_seq, wkstn_id, create_date, create_user_id, update_date, update_user_id, amt, serial_number, tndr_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._businessDayDate, this._organizationId, this._retailLocationId, this._serializedCountSequence, this._tenderTypeCode, this._transactionSequence, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._amount, this._serialNumber, this._tenderId } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, -5, -5, 4, 12, -5, -5, 91, 12, 91, 12, 3, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_serialized_tndr_count SET update_date = ?, update_user_id = ?, amt = ?, serial_number = ?, tndr_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._amount, this._serialNumber, this._tenderId } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_serialized_tndr_count" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND serialized_tndr_count_seq = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND serialized_tndr_count_seq = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._businessDayDate, this._organizationId, this._retailLocationId, this._serializedCountSequence, this._tenderTypeCode, this._transactionSequence, this._workstationId };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, -5, -5, 4, 12, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "tsn_serialized_tndr_count";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new TenderSerializedCountFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderSerializedCountFiller
/*     */     implements IFiller {
/*     */     private TenderSerializedCountDBA _parent;
/*     */     
/*     */     public TenderSerializedCountFiller(TenderSerializedCountDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 131 */       if (t1 != null) {
/* 132 */         this._parent._businessDayDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 135 */         this._parent._businessDayDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 140 */       long l1 = argResultSet.getLong(2);
/* 141 */       if (l1 != 0L || argResultSet.getObject(2) != null) {
/* 142 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 148 */       l1 = argResultSet.getLong(3);
/* 149 */       if (l1 != 0L || argResultSet.getObject(3) != null) {
/* 150 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 156 */       int i = argResultSet.getInt(4);
/* 157 */       if (i != 0 || argResultSet.getObject(4) != null) {
/* 158 */         this._parent._serializedCountSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 162 */       this._parent._tenderTypeCode = argResultSet.getString(5);
/*     */ 
/*     */       
/* 165 */       long primitiveResult = argResultSet.getLong(6);
/* 166 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 167 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 173 */       primitiveResult = argResultSet.getLong(7);
/* 174 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 175 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 180 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 181 */       if (t8 != null) {
/* 182 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 185 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 188 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 190 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 191 */       if (t10 != null) {
/* 192 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 195 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 198 */       this._parent._updateUserId = argResultSet.getString(11);
/* 199 */       this._parent._amount = argResultSet.getBigDecimal(12);
/* 200 */       this._parent._serialNumber = argResultSet.getString(13);
/* 201 */       this._parent._tenderId = argResultSet.getString(14);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 206 */     argDAO.suppressStateChanges(true);
/* 207 */     TenderSerializedCountDAO dao = (TenderSerializedCountDAO)argDAO;
/* 208 */     dao.setBusinessDayDate(this._businessDayDate);
/* 209 */     dao.setOrganizationId(this._organizationId);
/* 210 */     dao.setRetailLocationId(this._retailLocationId);
/* 211 */     dao.setSerializedCountSequence(this._serializedCountSequence);
/* 212 */     dao.setTenderTypeCode(this._tenderTypeCode);
/* 213 */     dao.setTransactionSequence(this._transactionSequence);
/* 214 */     dao.setWorkstationId(this._workstationId);
/* 215 */     dao.setCreateDate(this._createDate);
/* 216 */     dao.setCreateUserId(this._createUserId);
/* 217 */     dao.setUpdateDate(this._updateDate);
/* 218 */     dao.setUpdateUserId(this._updateUserId);
/* 219 */     dao.setAmount(this._amount);
/* 220 */     dao.setSerialNumber(this._serialNumber);
/* 221 */     dao.setTenderId(this._tenderId);
/* 222 */     argDAO.suppressStateChanges(false);
/* 223 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 227 */     return loadDAO((IDataAccessObject)new TenderSerializedCountDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 231 */     TenderSerializedCountDAO dao = (TenderSerializedCountDAO)argDAO;
/* 232 */     this._businessDayDate = dao.getBusinessDayDate();
/* 233 */     this._organizationId = dao.getOrganizationId();
/* 234 */     this._retailLocationId = dao.getRetailLocationId();
/* 235 */     this._serializedCountSequence = dao.getSerializedCountSequence();
/* 236 */     this._tenderTypeCode = dao.getTenderTypeCode();
/* 237 */     this._transactionSequence = dao.getTransactionSequence();
/* 238 */     this._workstationId = dao.getWorkstationId();
/* 239 */     this._createDate = dao.getCreateDate();
/* 240 */     this._createUserId = dao.getCreateUserId();
/* 241 */     this._updateDate = dao.getUpdateDate();
/* 242 */     this._updateUserId = dao.getUpdateUserId();
/* 243 */     this._amount = dao.getAmount();
/* 244 */     this._serialNumber = dao.getSerialNumber();
/* 245 */     this._tenderId = dao.getTenderId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 249 */     TenderSerializedCountId id = (TenderSerializedCountId)argId;
/* 250 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDayDate().getTime()));
/* 251 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 252 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 253 */     argStatement.setInt(4, id.getSerializedCountSequence().intValue());
/* 254 */     argStatement.setString(5, id.getTenderTypeCode());
/* 255 */     argStatement.setLong(6, id.getTransactionSequence().longValue());
/* 256 */     argStatement.setLong(7, id.getWorkstationId().longValue());
/* 257 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 261 */     TenderSerializedCountId id = new TenderSerializedCountId();
/* 262 */     id.setBusinessDayDate(this._businessDayDate);
/* 263 */     id.setOrganizationId(this._organizationId);
/* 264 */     id.setRetailLocationId(this._retailLocationId);
/* 265 */     id.setSerializedCountSequence(this._serializedCountSequence);
/* 266 */     id.setTenderTypeCode(this._tenderTypeCode);
/* 267 */     id.setTransactionSequence(this._transactionSequence);
/* 268 */     id.setWorkstationId(this._workstationId);
/* 269 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 277 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 281 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderSerializedCountDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */