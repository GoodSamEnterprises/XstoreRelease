/*     */ package dtv.xst.dao.prc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.prc.DealId;
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
/*     */ public class DealDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 2125964L;
/*     */   private Long _organizationId;
/*     */   private String _dealId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _description;
/*     */   private Boolean _consumable;
/*     */   private Boolean _deferred;
/*     */   private Date _effectiveDate;
/*     */   private Date _endDate;
/*     */   private Date _startTime;
/*     */   private Date _endTime;
/*     */   private BigDecimal _generosityCap;
/*     */   private Integer _iterationCap;
/*     */   private Integer _priorityNudge;
/*     */   private BigDecimal _minimumSubtotal;
/*     */   private BigDecimal _maximumSubtotal;
/*     */   private String _transActionType;
/*     */   private BigDecimal _transActionAmount;
/*     */   private String _taxabilityCode;
/*     */   private Boolean _higherNonactionAmt;
/*     */   private Boolean _excludePriceOverride;
/*     */   private Boolean _excludeDiscounted;
/*     */   private Boolean _useWeekSchedule;
/*     */   private Boolean _targeted;
/*     */   private String _promotionId;
/*     */   private Integer _sortOrder;
/*     */   private String _type;
/*     */   private String _groupId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.deal_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.description, t.consumable, t.act_deferred, t.effective_date, t.end_date, t.start_time, t.end_time, t.generosity_cap, t.iteration_cap, t.priority_nudge, t.subtotal_min, t.subtotal_max, t.trwide_action, t.trwide_amount, t.taxability_code, t.higher_nonaction_amt_flag, t.exclude_price_override_flag, t.exclude_discounted_flag, t.week_sched_flag, t.targeted_flag, t.promotion_id, t.sort_order, t.type, t.group_id FROM prc_deal t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND deal_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  61 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  65 */     return "SELECT t.organization_id, t.deal_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.description, t.consumable, t.act_deferred, t.effective_date, t.end_date, t.start_time, t.end_time, t.generosity_cap, t.iteration_cap, t.priority_nudge, t.subtotal_min, t.subtotal_max, t.trwide_action, t.trwide_amount, t.taxability_code, t.higher_nonaction_amt_flag, t.exclude_price_override_flag, t.exclude_discounted_flag, t.week_sched_flag, t.targeted_flag, t.promotion_id, t.sort_order, t.type, t.group_id FROM prc_deal t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  71 */     return " WHERE organization_id = ?  AND deal_id = ?  ";
/*     */   }
/*     */   
/*  74 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO prc_deal(organization_id, deal_id, org_code, org_value, create_date, create_user_id, update_date, update_user_id, description, consumable, act_deferred, effective_date, end_date, start_time, end_time, generosity_cap, iteration_cap, priority_nudge, subtotal_min, subtotal_max, trwide_action, trwide_amount, taxability_code, higher_nonaction_amt_flag, exclude_price_override_flag, exclude_discounted_flag, week_sched_flag, targeted_flag, promotion_id, sort_order, type, group_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  77 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  81 */     Object[][] insertParameterObject = { { this._organizationId, this._dealId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._description, this._consumable, this._deferred, this._effectiveDate, this._endDate, this._startTime, this._endTime, this._generosityCap, this._iterationCap, this._priorityNudge, this._minimumSubtotal, this._maximumSubtotal, this._transActionType, this._transActionAmount, this._taxabilityCode, this._higherNonactionAmt, this._excludePriceOverride, this._excludeDiscounted, this._useWeekSchedule, this._targeted, this._promotionId, this._sortOrder, this._type, this._groupId } };
/*  82 */     return insertParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 12, 91, 12, 12, -7, -7, 91, 91, 91, 91, 3, 4, 4, 3, 3, 12, 3, 12, -7, -7, -7, -7, -7, 12, 4, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  88 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE prc_deal SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, description = ?, consumable = ?, act_deferred = ?, effective_date = ?, end_date = ?, start_time = ?, end_time = ?, generosity_cap = ?, iteration_cap = ?, priority_nudge = ?, subtotal_min = ?, subtotal_max = ?, trwide_action = ?, trwide_amount = ?, taxability_code = ?, higher_nonaction_amt_flag = ?, exclude_price_override_flag = ?, exclude_discounted_flag = ?, week_sched_flag = ?, targeted_flag = ?, promotion_id = ?, sort_order = ?, type = ?, group_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  94 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  98 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._description, this._consumable, this._deferred, this._effectiveDate, this._endDate, this._startTime, this._endTime, this._generosityCap, this._iterationCap, this._priorityNudge, this._minimumSubtotal, this._maximumSubtotal, this._transActionType, this._transActionAmount, this._taxabilityCode, this._higherNonactionAmt, this._excludePriceOverride, this._excludeDiscounted, this._useWeekSchedule, this._targeted, this._promotionId, this._sortOrder, this._type, this._groupId } };
/*  99 */     return updateParameterObject;
/*     */   }
/*     */   
/* 102 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 12, -7, -7, 91, 91, 91, 91, 3, 4, 4, 3, 3, 12, 3, 12, -7, -7, -7, -7, -7, 12, 4, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 104 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 107 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM prc_deal" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND deal_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 110 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 116 */     return " WHERE organization_id = ?  AND deal_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 119 */     return new Object[] { this._organizationId, this._dealId };
/*     */   }
/*     */   
/* 122 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 125 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 128 */     return "prc_deal";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 132 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 136 */     return new DealFiller(this);
/*     */   }
/*     */   
/*     */   private static class DealFiller
/*     */     implements IFiller {
/*     */     private DealDBA _parent;
/*     */     
/*     */     public DealFiller(DealDBA argParent) {
/* 144 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 149 */       long primitiveResult = argResultSet.getLong(1);
/* 150 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 151 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 155 */       this._parent._dealId = argResultSet.getString(2);
/* 156 */       this._parent._orgCode = argResultSet.getString(3);
/* 157 */       this._parent._orgValue = argResultSet.getString(4);
/*     */       
/* 159 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 160 */       if (t5 != null) {
/* 161 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 164 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 167 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 169 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 170 */       if (t7 != null) {
/* 171 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 174 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 177 */       this._parent._updateUserId = argResultSet.getString(8);
/* 178 */       this._parent._description = argResultSet.getString(9);
/* 179 */       this._parent._consumable = Boolean.valueOf(argResultSet.getBoolean(10));
/* 180 */       this._parent._deferred = Boolean.valueOf(argResultSet.getBoolean(11));
/*     */       
/* 182 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 183 */       if (t12 != null) {
/* 184 */         this._parent._effectiveDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 187 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 191 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 192 */       if (t13 != null) {
/* 193 */         this._parent._endDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 196 */         this._parent._endDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 200 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 201 */       if (t14 != null) {
/* 202 */         this._parent._startTime = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 205 */         this._parent._startTime = null;
/*     */       } 
/*     */ 
/*     */       
/* 209 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 210 */       if (t15 != null) {
/* 211 */         this._parent._endTime = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 214 */         this._parent._endTime = null;
/*     */       } 
/*     */       
/* 217 */       this._parent._generosityCap = argResultSet.getBigDecimal(16);
/*     */ 
/*     */       
/* 220 */       int i = argResultSet.getInt(17);
/* 221 */       if (i != 0 || argResultSet.getObject(17) != null) {
/* 222 */         this._parent._iterationCap = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 228 */       i = argResultSet.getInt(18);
/* 229 */       if (i != 0 || argResultSet.getObject(18) != null) {
/* 230 */         this._parent._priorityNudge = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 234 */       this._parent._minimumSubtotal = argResultSet.getBigDecimal(19);
/* 235 */       this._parent._maximumSubtotal = argResultSet.getBigDecimal(20);
/* 236 */       this._parent._transActionType = argResultSet.getString(21);
/* 237 */       this._parent._transActionAmount = argResultSet.getBigDecimal(22);
/* 238 */       this._parent._taxabilityCode = argResultSet.getString(23);
/* 239 */       this._parent._higherNonactionAmt = Boolean.valueOf(argResultSet.getBoolean(24));
/* 240 */       this._parent._excludePriceOverride = Boolean.valueOf(argResultSet.getBoolean(25));
/* 241 */       this._parent._excludeDiscounted = Boolean.valueOf(argResultSet.getBoolean(26));
/* 242 */       this._parent._useWeekSchedule = Boolean.valueOf(argResultSet.getBoolean(27));
/* 243 */       this._parent._targeted = Boolean.valueOf(argResultSet.getBoolean(28));
/* 244 */       this._parent._promotionId = argResultSet.getString(29);
/*     */ 
/*     */       
/* 247 */       i = argResultSet.getInt(30);
/* 248 */       if (i != 0 || argResultSet.getObject(30) != null) {
/* 249 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 253 */       this._parent._type = argResultSet.getString(31);
/* 254 */       this._parent._groupId = argResultSet.getString(32);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 259 */     argDAO.suppressStateChanges(true);
/* 260 */     DealDAO dao = (DealDAO)argDAO;
/* 261 */     dao.setOrganizationId(this._organizationId);
/* 262 */     dao.setDealId(this._dealId);
/* 263 */     dao.setOrgCode(this._orgCode);
/* 264 */     dao.setOrgValue(this._orgValue);
/* 265 */     dao.setCreateDate(this._createDate);
/* 266 */     dao.setCreateUserId(this._createUserId);
/* 267 */     dao.setUpdateDate(this._updateDate);
/* 268 */     dao.setUpdateUserId(this._updateUserId);
/* 269 */     dao.setDescription(this._description);
/* 270 */     dao.setConsumable(this._consumable);
/* 271 */     dao.setDeferred(this._deferred);
/* 272 */     dao.setEffectiveDate(this._effectiveDate);
/* 273 */     dao.setEndDate(this._endDate);
/* 274 */     dao.setStartTime(this._startTime);
/* 275 */     dao.setEndTime(this._endTime);
/* 276 */     dao.setGenerosityCap(this._generosityCap);
/* 277 */     dao.setIterationCap(this._iterationCap);
/* 278 */     dao.setPriorityNudge(this._priorityNudge);
/* 279 */     dao.setMinimumSubtotal(this._minimumSubtotal);
/* 280 */     dao.setMaximumSubtotal(this._maximumSubtotal);
/* 281 */     dao.setTransActionType(this._transActionType);
/* 282 */     dao.setTransActionAmount(this._transActionAmount);
/* 283 */     dao.setTaxabilityCode(this._taxabilityCode);
/* 284 */     dao.setHigherNonactionAmt(this._higherNonactionAmt);
/* 285 */     dao.setExcludePriceOverride(this._excludePriceOverride);
/* 286 */     dao.setExcludeDiscounted(this._excludeDiscounted);
/* 287 */     dao.setUseWeekSchedule(this._useWeekSchedule);
/* 288 */     dao.setTargeted(this._targeted);
/* 289 */     dao.setPromotionId(this._promotionId);
/* 290 */     dao.setSortOrder(this._sortOrder);
/* 291 */     dao.setType(this._type);
/* 292 */     dao.setGroupId(this._groupId);
/* 293 */     argDAO.suppressStateChanges(false);
/* 294 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 298 */     return loadDAO((IDataAccessObject)new DealDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 302 */     DealDAO dao = (DealDAO)argDAO;
/* 303 */     this._organizationId = dao.getOrganizationId();
/* 304 */     this._dealId = dao.getDealId();
/* 305 */     this._orgCode = dao.getOrgCode();
/* 306 */     this._orgValue = dao.getOrgValue();
/* 307 */     this._createDate = dao.getCreateDate();
/* 308 */     this._createUserId = dao.getCreateUserId();
/* 309 */     this._updateDate = dao.getUpdateDate();
/* 310 */     this._updateUserId = dao.getUpdateUserId();
/* 311 */     this._description = dao.getDescription();
/* 312 */     this._consumable = (dao.getConsumable() != null) ? dao.getConsumable() : Boolean.valueOf(false);
/* 313 */     this._deferred = (dao.getDeferred() != null) ? dao.getDeferred() : Boolean.valueOf(false);
/* 314 */     this._effectiveDate = dao.getEffectiveDate();
/* 315 */     this._endDate = dao.getEndDate();
/* 316 */     this._startTime = dao.getStartTime();
/* 317 */     this._endTime = dao.getEndTime();
/* 318 */     this._generosityCap = dao.getGenerosityCap();
/* 319 */     this._iterationCap = dao.getIterationCap();
/* 320 */     this._priorityNudge = dao.getPriorityNudge();
/* 321 */     this._minimumSubtotal = dao.getMinimumSubtotal();
/* 322 */     this._maximumSubtotal = dao.getMaximumSubtotal();
/* 323 */     this._transActionType = dao.getTransActionType();
/* 324 */     this._transActionAmount = dao.getTransActionAmount();
/* 325 */     this._taxabilityCode = dao.getTaxabilityCode();
/* 326 */     this._higherNonactionAmt = (dao.getHigherNonactionAmt() != null) ? dao.getHigherNonactionAmt() : Boolean.valueOf(false);
/* 327 */     this._excludePriceOverride = (dao.getExcludePriceOverride() != null) ? dao.getExcludePriceOverride() : Boolean.valueOf(false);
/* 328 */     this._excludeDiscounted = (dao.getExcludeDiscounted() != null) ? dao.getExcludeDiscounted() : Boolean.valueOf(false);
/* 329 */     this._useWeekSchedule = (dao.getUseWeekSchedule() != null) ? dao.getUseWeekSchedule() : Boolean.valueOf(false);
/* 330 */     this._targeted = (dao.getTargeted() != null) ? dao.getTargeted() : Boolean.valueOf(false);
/* 331 */     this._promotionId = dao.getPromotionId();
/* 332 */     this._sortOrder = dao.getSortOrder();
/* 333 */     this._type = dao.getType();
/* 334 */     this._groupId = dao.getGroupId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 338 */     DealId id = (DealId)argId;
/* 339 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 340 */     argStatement.setString(2, id.getDealId());
/* 341 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 345 */     DealId id = new DealId();
/* 346 */     id.setOrganizationId(this._organizationId);
/* 347 */     id.setDealId(this._dealId);
/* 348 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 356 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 360 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\impl\DealDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */