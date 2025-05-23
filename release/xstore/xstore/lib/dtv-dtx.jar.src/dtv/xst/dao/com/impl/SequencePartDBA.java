/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.SequencePartId;
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
/*     */ public class SequencePartDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 971889524L;
/*     */   private Long _organizationId;
/*     */   private String _sequenceId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _prefix;
/*     */   private String _suffix;
/*     */   private Boolean _encode;
/*     */   private String _checkDigitAlgorithm;
/*     */   private Boolean _numeric;
/*     */   private Long _padLength;
/*     */   private String _padCharacter;
/*     */   private Long _initialValue;
/*     */   private Long _maxValue;
/*     */   private Long _valueIncrement;
/*     */   private Boolean _includeStoreId;
/*     */   private Long _storePadLength;
/*     */   private Boolean _includeWorkstationId;
/*     */   private Long _workstationPadLength;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.sequence_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.prefix, t.suffix, t.encode_flag, t.check_digit_algo, t.numeric_flag, t.pad_length, t.pad_character, t.initial_value, t.max_value, t.value_increment, t.include_store_id, t.store_pad_length, t.include_wkstn_id, t.wkstn_pad_length FROM com_sequence_part t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND sequence_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  49 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  53 */     return "SELECT t.organization_id, t.sequence_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.prefix, t.suffix, t.encode_flag, t.check_digit_algo, t.numeric_flag, t.pad_length, t.pad_character, t.initial_value, t.max_value, t.value_increment, t.include_store_id, t.store_pad_length, t.include_wkstn_id, t.wkstn_pad_length FROM com_sequence_part t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  59 */     return " WHERE organization_id = ?  AND sequence_id = ?  ";
/*     */   }
/*     */   
/*  62 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_sequence_part(organization_id, sequence_id, create_date, create_user_id, update_date, update_user_id, prefix, suffix, encode_flag, check_digit_algo, numeric_flag, pad_length, pad_character, initial_value, max_value, value_increment, include_store_id, store_pad_length, include_wkstn_id, wkstn_pad_length) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  65 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  69 */     Object[][] insertParameterObject = { { this._organizationId, this._sequenceId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._prefix, this._suffix, this._encode, this._checkDigitAlgorithm, this._numeric, this._padLength, this._padCharacter, this._initialValue, this._maxValue, this._valueIncrement, this._includeStoreId, this._storePadLength, this._includeWorkstationId, this._workstationPadLength } };
/*  70 */     return insertParameterObject;
/*     */   }
/*     */   
/*  73 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 12, -7, 12, -7, -5, 12, -5, -5, -5, -7, -5, -7, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  76 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  79 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_sequence_part SET update_date = ?, update_user_id = ?, prefix = ?, suffix = ?, encode_flag = ?, check_digit_algo = ?, numeric_flag = ?, pad_length = ?, pad_character = ?, initial_value = ?, max_value = ?, value_increment = ?, include_store_id = ?, store_pad_length = ?, include_wkstn_id = ?, wkstn_pad_length = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  82 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  86 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._prefix, this._suffix, this._encode, this._checkDigitAlgorithm, this._numeric, this._padLength, this._padCharacter, this._initialValue, this._maxValue, this._valueIncrement, this._includeStoreId, this._storePadLength, this._includeWorkstationId, this._workstationPadLength } };
/*  87 */     return updateParameterObject;
/*     */   }
/*     */   
/*  90 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, -7, 12, -7, -5, 12, -5, -5, -5, -7, -5, -7, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  92 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  95 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_sequence_part" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND sequence_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  98 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 104 */     return " WHERE organization_id = ?  AND sequence_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 107 */     return new Object[] { this._organizationId, this._sequenceId };
/*     */   }
/*     */   
/* 110 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 113 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 116 */     return "com_sequence_part";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 120 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 124 */     return new SequencePartFiller(this);
/*     */   }
/*     */   
/*     */   private static class SequencePartFiller
/*     */     implements IFiller {
/*     */     private SequencePartDBA _parent;
/*     */     
/*     */     public SequencePartFiller(SequencePartDBA argParent) {
/* 132 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 137 */       long primitiveResult = argResultSet.getLong(1);
/* 138 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 139 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 143 */       this._parent._sequenceId = argResultSet.getString(2);
/*     */       
/* 145 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 146 */       if (t3 != null) {
/* 147 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 155 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 156 */       if (t5 != null) {
/* 157 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._updateUserId = argResultSet.getString(6);
/* 164 */       this._parent._prefix = argResultSet.getString(7);
/* 165 */       this._parent._suffix = argResultSet.getString(8);
/* 166 */       this._parent._encode = Boolean.valueOf(argResultSet.getBoolean(9));
/* 167 */       this._parent._checkDigitAlgorithm = argResultSet.getString(10);
/* 168 */       this._parent._numeric = Boolean.valueOf(argResultSet.getBoolean(11));
/*     */ 
/*     */       
/* 171 */       long l1 = argResultSet.getLong(12);
/* 172 */       if (l1 != 0L || argResultSet.getObject(12) != null) {
/* 173 */         this._parent._padLength = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 177 */       this._parent._padCharacter = argResultSet.getString(13);
/*     */ 
/*     */       
/* 180 */       l1 = argResultSet.getLong(14);
/* 181 */       if (l1 != 0L || argResultSet.getObject(14) != null) {
/* 182 */         this._parent._initialValue = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 188 */       l1 = argResultSet.getLong(15);
/* 189 */       if (l1 != 0L || argResultSet.getObject(15) != null) {
/* 190 */         this._parent._maxValue = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 196 */       l1 = argResultSet.getLong(16);
/* 197 */       if (l1 != 0L || argResultSet.getObject(16) != null) {
/* 198 */         this._parent._valueIncrement = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 202 */       this._parent._includeStoreId = Boolean.valueOf(argResultSet.getBoolean(17));
/*     */ 
/*     */       
/* 205 */       l1 = argResultSet.getLong(18);
/* 206 */       if (l1 != 0L || argResultSet.getObject(18) != null) {
/* 207 */         this._parent._storePadLength = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 211 */       this._parent._includeWorkstationId = Boolean.valueOf(argResultSet.getBoolean(19));
/*     */ 
/*     */       
/* 214 */       l1 = argResultSet.getLong(20);
/* 215 */       if (l1 != 0L || argResultSet.getObject(20) != null) {
/* 216 */         this._parent._workstationPadLength = Long.valueOf(l1);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 224 */     argDAO.suppressStateChanges(true);
/* 225 */     SequencePartDAO dao = (SequencePartDAO)argDAO;
/* 226 */     dao.setOrganizationId(this._organizationId);
/* 227 */     dao.setSequenceId(this._sequenceId);
/* 228 */     dao.setCreateDate(this._createDate);
/* 229 */     dao.setCreateUserId(this._createUserId);
/* 230 */     dao.setUpdateDate(this._updateDate);
/* 231 */     dao.setUpdateUserId(this._updateUserId);
/* 232 */     dao.setPrefix(this._prefix);
/* 233 */     dao.setSuffix(this._suffix);
/* 234 */     dao.setEncode(this._encode);
/* 235 */     dao.setCheckDigitAlgorithm(this._checkDigitAlgorithm);
/* 236 */     dao.setNumeric(this._numeric);
/* 237 */     dao.setPadLength(this._padLength);
/* 238 */     dao.setPadCharacter(this._padCharacter);
/* 239 */     dao.setInitialValue(this._initialValue);
/* 240 */     dao.setMaxValue(this._maxValue);
/* 241 */     dao.setValueIncrement(this._valueIncrement);
/* 242 */     dao.setIncludeStoreId(this._includeStoreId);
/* 243 */     dao.setStorePadLength(this._storePadLength);
/* 244 */     dao.setIncludeWorkstationId(this._includeWorkstationId);
/* 245 */     dao.setWorkstationPadLength(this._workstationPadLength);
/* 246 */     argDAO.suppressStateChanges(false);
/* 247 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 251 */     return loadDAO((IDataAccessObject)new SequencePartDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 255 */     SequencePartDAO dao = (SequencePartDAO)argDAO;
/* 256 */     this._organizationId = dao.getOrganizationId();
/* 257 */     this._sequenceId = dao.getSequenceId();
/* 258 */     this._createDate = dao.getCreateDate();
/* 259 */     this._createUserId = dao.getCreateUserId();
/* 260 */     this._updateDate = dao.getUpdateDate();
/* 261 */     this._updateUserId = dao.getUpdateUserId();
/* 262 */     this._prefix = dao.getPrefix();
/* 263 */     this._suffix = dao.getSuffix();
/* 264 */     this._encode = (dao.getEncode() != null) ? dao.getEncode() : Boolean.valueOf(false);
/* 265 */     this._checkDigitAlgorithm = dao.getCheckDigitAlgorithm();
/* 266 */     this._numeric = (dao.getNumeric() != null) ? dao.getNumeric() : Boolean.valueOf(false);
/* 267 */     this._padLength = dao.getPadLength();
/* 268 */     this._padCharacter = dao.getPadCharacter();
/* 269 */     this._initialValue = dao.getInitialValue();
/* 270 */     this._maxValue = dao.getMaxValue();
/* 271 */     this._valueIncrement = dao.getValueIncrement();
/* 272 */     this._includeStoreId = (dao.getIncludeStoreId() != null) ? dao.getIncludeStoreId() : Boolean.valueOf(false);
/* 273 */     this._storePadLength = dao.getStorePadLength();
/* 274 */     this._includeWorkstationId = (dao.getIncludeWorkstationId() != null) ? dao.getIncludeWorkstationId() : Boolean.valueOf(false);
/* 275 */     this._workstationPadLength = dao.getWorkstationPadLength();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 279 */     SequencePartId id = (SequencePartId)argId;
/* 280 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 281 */     argStatement.setString(2, id.getSequenceId());
/* 282 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 286 */     SequencePartId id = new SequencePartId();
/* 287 */     id.setOrganizationId(this._organizationId);
/* 288 */     id.setSequenceId(this._sequenceId);
/* 289 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 297 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 301 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\SequencePartDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */