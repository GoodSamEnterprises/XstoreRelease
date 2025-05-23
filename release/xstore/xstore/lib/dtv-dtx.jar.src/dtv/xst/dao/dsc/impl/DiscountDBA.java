/*     */ package dtv.xst.dao.dsc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.dsc.DiscountId;
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
/*     */ public class DiscountDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 337828193L;
/*     */   private String _discountCode;
/*     */   private Long _organizationId;
/*     */   private String _className;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _configElement;
/*     */   private BigDecimal _amount;
/*     */   private String _applicationMethodCode;
/*     */   private String _calculationMethodCode;
/*     */   private String _description;
/*     */   private Date _effectiveDatetime;
/*     */   private Boolean _exclusiveDiscount;
/*     */   private Date _expirationDatetime;
/*     */   private Long _maximumTransactionCount;
/*     */   private BigDecimal _minimumEligiblePrice;
/*     */   private BigDecimal _percent;
/*     */   private String _prompt;
/*     */   private String _sound;
/*     */   private String _typeCode;
/*     */   private Boolean _serializedDiscount;
/*     */   private String _privilegeType;
/*     */   private String _taxabilityCode;
/*     */   private BigDecimal _maxDiscount;
/*     */   private BigDecimal _maxAmount;
/*     */   private BigDecimal _maxPercentage;
/*     */   private Integer _sortOrder;
/*     */   private Boolean _disallowChange;
/*     */   private static final String SELECT_OBJECT = "SELECT t.discount_code, t.organization_id, t.dtv_class_name, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.config_element, t.discount, t.app_mthd_code, t.calculation_mthd_code, t.description, t.effective_datetime, t.exclusive_discount_flag, t.expr_datetime, t.max_trans_count, t.min_eligible_price, t.percentage, t.prompt, t.sound, t.typcode, t.serialized_discount_flag, t.privilege_type, t.taxability_code, t.max_discount, t.max_amount, t.max_percentage, t.sort_order, t.disallow_change_flag FROM dsc_discount t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE discount_code = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  58 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  62 */     return "SELECT t.discount_code, t.organization_id, t.dtv_class_name, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.config_element, t.discount, t.app_mthd_code, t.calculation_mthd_code, t.description, t.effective_datetime, t.exclusive_discount_flag, t.expr_datetime, t.max_trans_count, t.min_eligible_price, t.percentage, t.prompt, t.sound, t.typcode, t.serialized_discount_flag, t.privilege_type, t.taxability_code, t.max_discount, t.max_amount, t.max_percentage, t.sort_order, t.disallow_change_flag FROM dsc_discount t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  68 */     return " WHERE discount_code = ?  AND organization_id = ?  ";
/*     */   }
/*     */   
/*  71 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO dsc_discount(discount_code, organization_id, dtv_class_name, create_date, create_user_id, update_date, update_user_id, config_element, discount, app_mthd_code, calculation_mthd_code, description, effective_datetime, exclusive_discount_flag, expr_datetime, max_trans_count, min_eligible_price, percentage, prompt, sound, typcode, serialized_discount_flag, privilege_type, taxability_code, max_discount, max_amount, max_percentage, sort_order, disallow_change_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  74 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  78 */     Object[][] insertParameterObject = { { this._discountCode, this._organizationId, this._className, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._amount, this._applicationMethodCode, this._calculationMethodCode, this._description, this._effectiveDatetime, this._exclusiveDiscount, this._expirationDatetime, this._maximumTransactionCount, this._minimumEligiblePrice, this._percent, this._prompt, this._sound, this._typeCode, this._serializedDiscount, this._privilegeType, this._taxabilityCode, this._maxDiscount, this._maxAmount, this._maxPercentage, this._sortOrder, this._disallowChange } };
/*  79 */     return insertParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 91, 12, 91, 12, 12, 3, 12, 12, 12, 91, -7, 91, -5, 3, 3, 12, 12, 12, -7, 12, 12, 3, 3, 3, 4, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  85 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE dsc_discount SET dtv_class_name = ?, update_date = ?, update_user_id = ?, config_element = ?, discount = ?, app_mthd_code = ?, calculation_mthd_code = ?, description = ?, effective_datetime = ?, exclusive_discount_flag = ?, expr_datetime = ?, max_trans_count = ?, min_eligible_price = ?, percentage = ?, prompt = ?, sound = ?, typcode = ?, serialized_discount_flag = ?, privilege_type = ?, taxability_code = ?, max_discount = ?, max_amount = ?, max_percentage = ?, sort_order = ?, disallow_change_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  91 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  95 */     Object[][] updateParameterObject = { { this._className, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._amount, this._applicationMethodCode, this._calculationMethodCode, this._description, this._effectiveDatetime, this._exclusiveDiscount, this._expirationDatetime, this._maximumTransactionCount, this._minimumEligiblePrice, this._percent, this._prompt, this._sound, this._typeCode, this._serializedDiscount, this._privilegeType, this._taxabilityCode, this._maxDiscount, this._maxAmount, this._maxPercentage, this._sortOrder, this._disallowChange } };
/*  96 */     return updateParameterObject;
/*     */   }
/*     */   
/*  99 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 91, 12, 12, 3, 12, 12, 12, 91, -7, 91, -5, 3, 3, 12, 12, 12, -7, 12, 12, 3, 3, 3, 4, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 101 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 104 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM dsc_discount" }; private static final String WHERE_OBJECT = " WHERE discount_code = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 107 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 113 */     return " WHERE discount_code = ?  AND organization_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 116 */     return new Object[] { this._discountCode, this._organizationId };
/*     */   }
/*     */   
/* 119 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 122 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 125 */     return "dsc_discount";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 129 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 133 */     return new DiscountFiller(this);
/*     */   }
/*     */   
/*     */   private static class DiscountFiller
/*     */     implements IFiller {
/*     */     private DiscountDBA _parent;
/*     */     
/*     */     public DiscountFiller(DiscountDBA argParent) {
/* 141 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 144 */       this._parent._discountCode = argResultSet.getString(1);
/*     */ 
/*     */       
/* 147 */       long primitiveResult = argResultSet.getLong(2);
/* 148 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 149 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 153 */       this._parent._className = argResultSet.getString(3);
/*     */       
/* 155 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 156 */       if (t4 != null) {
/* 157 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 165 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 166 */       if (t6 != null) {
/* 167 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._updateUserId = argResultSet.getString(7);
/* 174 */       this._parent._configElement = argResultSet.getString(8);
/* 175 */       this._parent._amount = argResultSet.getBigDecimal(9);
/* 176 */       this._parent._applicationMethodCode = argResultSet.getString(10);
/* 177 */       this._parent._calculationMethodCode = argResultSet.getString(11);
/* 178 */       this._parent._description = argResultSet.getString(12);
/*     */       
/* 180 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 181 */       if (t13 != null) {
/* 182 */         this._parent._effectiveDatetime = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 185 */         this._parent._effectiveDatetime = null;
/*     */       } 
/*     */       
/* 188 */       this._parent._exclusiveDiscount = Boolean.valueOf(argResultSet.getBoolean(14));
/*     */       
/* 190 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 191 */       if (t15 != null) {
/* 192 */         this._parent._expirationDatetime = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 195 */         this._parent._expirationDatetime = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 200 */       long l1 = argResultSet.getLong(16);
/* 201 */       if (l1 != 0L || argResultSet.getObject(16) != null) {
/* 202 */         this._parent._maximumTransactionCount = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 206 */       this._parent._minimumEligiblePrice = argResultSet.getBigDecimal(17);
/* 207 */       this._parent._percent = argResultSet.getBigDecimal(18);
/* 208 */       this._parent._prompt = argResultSet.getString(19);
/* 209 */       this._parent._sound = argResultSet.getString(20);
/* 210 */       this._parent._typeCode = argResultSet.getString(21);
/* 211 */       this._parent._serializedDiscount = Boolean.valueOf(argResultSet.getBoolean(22));
/* 212 */       this._parent._privilegeType = argResultSet.getString(23);
/* 213 */       this._parent._taxabilityCode = argResultSet.getString(24);
/* 214 */       this._parent._maxDiscount = argResultSet.getBigDecimal(25);
/* 215 */       this._parent._maxAmount = argResultSet.getBigDecimal(26);
/* 216 */       this._parent._maxPercentage = argResultSet.getBigDecimal(27);
/*     */ 
/*     */       
/* 219 */       int i = argResultSet.getInt(28);
/* 220 */       if (i != 0 || argResultSet.getObject(28) != null) {
/* 221 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 225 */       this._parent._disallowChange = Boolean.valueOf(argResultSet.getBoolean(29));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 230 */     argDAO.suppressStateChanges(true);
/* 231 */     DiscountDAO dao = (DiscountDAO)argDAO;
/* 232 */     dao.setDiscountCode(this._discountCode);
/* 233 */     dao.setOrganizationId(this._organizationId);
/* 234 */     dao.setClassName(this._className);
/* 235 */     dao.setCreateDate(this._createDate);
/* 236 */     dao.setCreateUserId(this._createUserId);
/* 237 */     dao.setUpdateDate(this._updateDate);
/* 238 */     dao.setUpdateUserId(this._updateUserId);
/* 239 */     dao.setConfigElement(this._configElement);
/* 240 */     dao.setAmount(this._amount);
/* 241 */     dao.setApplicationMethodCode(this._applicationMethodCode);
/* 242 */     dao.setCalculationMethodCode(this._calculationMethodCode);
/* 243 */     dao.setDescription(this._description);
/* 244 */     dao.setEffectiveDatetime(this._effectiveDatetime);
/* 245 */     dao.setExclusiveDiscount(this._exclusiveDiscount);
/* 246 */     dao.setExpirationDatetime(this._expirationDatetime);
/* 247 */     dao.setMaximumTransactionCount(this._maximumTransactionCount);
/* 248 */     dao.setMinimumEligiblePrice(this._minimumEligiblePrice);
/* 249 */     dao.setPercent(this._percent);
/* 250 */     dao.setPrompt(this._prompt);
/* 251 */     dao.setSound(this._sound);
/* 252 */     dao.setTypeCode(this._typeCode);
/* 253 */     dao.setSerializedDiscount(this._serializedDiscount);
/* 254 */     dao.setPrivilegeType(this._privilegeType);
/* 255 */     dao.setTaxabilityCode(this._taxabilityCode);
/* 256 */     dao.setMaxDiscount(this._maxDiscount);
/* 257 */     dao.setMaxAmount(this._maxAmount);
/* 258 */     dao.setMaxPercentage(this._maxPercentage);
/* 259 */     dao.setSortOrder(this._sortOrder);
/* 260 */     dao.setDisallowChange(this._disallowChange);
/* 261 */     argDAO.suppressStateChanges(false);
/* 262 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 266 */     return loadDAO((IDataAccessObject)new DiscountDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 270 */     DiscountDAO dao = (DiscountDAO)argDAO;
/* 271 */     this._discountCode = dao.getDiscountCode();
/* 272 */     this._organizationId = dao.getOrganizationId();
/* 273 */     this._className = dao.getClassName();
/* 274 */     this._createDate = dao.getCreateDate();
/* 275 */     this._createUserId = dao.getCreateUserId();
/* 276 */     this._updateDate = dao.getUpdateDate();
/* 277 */     this._updateUserId = dao.getUpdateUserId();
/* 278 */     this._configElement = dao.getConfigElement();
/* 279 */     this._amount = dao.getAmount();
/* 280 */     this._applicationMethodCode = dao.getApplicationMethodCode();
/* 281 */     this._calculationMethodCode = dao.getCalculationMethodCode();
/* 282 */     this._description = dao.getDescription();
/* 283 */     this._effectiveDatetime = dao.getEffectiveDatetime();
/* 284 */     this._exclusiveDiscount = (dao.getExclusiveDiscount() != null) ? dao.getExclusiveDiscount() : Boolean.valueOf(false);
/* 285 */     this._expirationDatetime = dao.getExpirationDatetime();
/* 286 */     this._maximumTransactionCount = dao.getMaximumTransactionCount();
/* 287 */     this._minimumEligiblePrice = dao.getMinimumEligiblePrice();
/* 288 */     this._percent = dao.getPercent();
/* 289 */     this._prompt = dao.getPrompt();
/* 290 */     this._sound = dao.getSound();
/* 291 */     this._typeCode = dao.getTypeCode();
/* 292 */     this._serializedDiscount = (dao.getSerializedDiscount() != null) ? dao.getSerializedDiscount() : Boolean.valueOf(false);
/* 293 */     this._privilegeType = dao.getPrivilegeType();
/* 294 */     this._taxabilityCode = dao.getTaxabilityCode();
/* 295 */     this._maxDiscount = dao.getMaxDiscount();
/* 296 */     this._maxAmount = dao.getMaxAmount();
/* 297 */     this._maxPercentage = dao.getMaxPercentage();
/* 298 */     this._sortOrder = dao.getSortOrder();
/* 299 */     this._disallowChange = (dao.getDisallowChange() != null) ? dao.getDisallowChange() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 303 */     DiscountId id = (DiscountId)argId;
/* 304 */     argStatement.setString(1, id.getDiscountCode());
/* 305 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 306 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 310 */     DiscountId id = new DiscountId();
/* 311 */     id.setDiscountCode(this._discountCode);
/* 312 */     id.setOrganizationId(this._organizationId);
/* 313 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {
/* 317 */     DiscountDBA adapter = (DiscountDBA)argAdapter;
/* 318 */     this._discountCode = adapter._discountCode;
/* 319 */     this._organizationId = adapter._organizationId;
/* 320 */     this._className = adapter._className;
/* 321 */     this._createDate = adapter._createDate;
/* 322 */     this._createUserId = adapter._createUserId;
/* 323 */     this._updateDate = adapter._updateDate;
/* 324 */     this._updateUserId = adapter._updateUserId;
/* 325 */     this._configElement = adapter._configElement;
/* 326 */     this._amount = adapter._amount;
/* 327 */     this._applicationMethodCode = adapter._applicationMethodCode;
/* 328 */     this._calculationMethodCode = adapter._calculationMethodCode;
/* 329 */     this._description = adapter._description;
/* 330 */     this._effectiveDatetime = adapter._effectiveDatetime;
/* 331 */     this._exclusiveDiscount = adapter._exclusiveDiscount;
/* 332 */     this._expirationDatetime = adapter._expirationDatetime;
/* 333 */     this._maximumTransactionCount = adapter._maximumTransactionCount;
/* 334 */     this._minimumEligiblePrice = adapter._minimumEligiblePrice;
/* 335 */     this._percent = adapter._percent;
/* 336 */     this._prompt = adapter._prompt;
/* 337 */     this._sound = adapter._sound;
/* 338 */     this._typeCode = adapter._typeCode;
/* 339 */     this._serializedDiscount = adapter._serializedDiscount;
/* 340 */     this._privilegeType = adapter._privilegeType;
/* 341 */     this._taxabilityCode = adapter._taxabilityCode;
/* 342 */     this._maxDiscount = adapter._maxDiscount;
/* 343 */     this._maxAmount = adapter._maxAmount;
/* 344 */     this._maxPercentage = adapter._maxPercentage;
/* 345 */     this._sortOrder = adapter._sortOrder;
/* 346 */     this._disallowChange = adapter._disallowChange;
/*     */   }
/*     */   
/*     */   public boolean isExtensible() {
/* 350 */     return true;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 354 */     return this._className;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\impl\DiscountDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */