/*     */ package dtv.xst.dao.tnd.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.tnd.TenderOptionsId;
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
/*     */ public class TenderOptionsDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1928444662L;
/*     */   private Long _organizationId;
/*     */   private String _tenderId;
/*     */   private String _configElement;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Boolean _authExpirationDateRequired;
/*     */   private String _authMethodCode;
/*     */   private Boolean _authRequired;
/*     */   private Boolean _custAssociation;
/*     */   private String _custIdReqCode;
/*     */   private Boolean _customerSignatureRequired;
/*     */   private Boolean _dfltToAmountDue;
/*     */   private Date _effectiveDate;
/*     */   private Boolean _endorsementRequired;
/*     */   private Date _expirationDate;
/*     */   private Boolean _includeInTypeCount;
/*     */   private Boolean _magneticSwipeReaderRequired;
/*     */   private Integer _maxDaysForReturn;
/*     */   private Integer _minDaysForReturn;
/*     */   private BigDecimal _minimumDenominationAmount;
/*     */   private Boolean _openCashDrawerRequired;
/*     */   private Boolean _pinRequired;
/*     */   private Boolean _populateSystemCount;
/*     */   private Boolean _serialIdentificationNbrRequired;
/*     */   private String _unitCountCode;
/*     */   private Boolean _suggestDeposit;
/*     */   private BigDecimal _suggestedDepositThreshold;
/*     */   private BigDecimal _cashChangeLimit;
/*     */   private String _changeTenderId;
/*     */   private Boolean _overtenderOverridable;
/*     */   private Boolean _nonVoidable;
/*     */   private BigDecimal _closeCountDiscrepancyThreshold;
/*     */   private Boolean _cidMsrRequired;
/*     */   private Boolean _cidKeyedRequired;
/*     */   private Boolean _postalRequired;
/*     */   private Boolean _disallowSplitTender;
/*     */   private Boolean _postVoidOpenCashDrawerRequired;
/*     */   private String _reportingGroup;
/*     */   private Boolean _changeAllowedWhenForeign;
/*     */   private String _fiscalTenderId;
/*     */   private String _roundingMode;
/*     */   private Boolean _assignCashDrawerRequired;
/*     */   private Boolean _postVoidAssignCashDrawerRequired;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.tndr_id, t.config_element, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.auth_expr_date_req_flag, t.auth_mthd_code, t.auth_req_flag, t.cust_association_flag, t.cust_id_req_code, t.cust_sig_req_flag, t.dflt_to_amt_due_flag, t.effective_date, t.endorsement_req_flag, t.expr_date, t.include_in_type_count_flag, t.mag_swipe_reader_req_flag, t.max_days_for_return, t.min_days_for_return, t.min_denomination_amt, t.open_cash_drawer_req_flag, t.pin_req_flag, t.populate_system_count_flag, t.serial_id_nbr_req_flag, t.unit_count_req_code, t.suggest_deposit_flag, t.suggested_deposit_threshold, t.cash_change_limit, t.change_tndr_id, t.over_tender_overridable_flag, t.non_voidable_flag, t.close_count_disc_threshold, t.cid_msr_req_flag, t.cid_keyed_req_flag, t.postal_code_req_flag, t.disallow_split_tndr_flag, t.post_void_open_drawer_flag, t.reporting_group, t.change_allowed_when_foreign, t.fiscal_tndr_id, t.rounding_mode, t.assign_cash_drawer_req_flag, t.post_void_assign_drawer_flag FROM tnd_tndr_options t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND tndr_id = ?  AND config_element = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  74 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  78 */     return "SELECT t.organization_id, t.tndr_id, t.config_element, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.auth_expr_date_req_flag, t.auth_mthd_code, t.auth_req_flag, t.cust_association_flag, t.cust_id_req_code, t.cust_sig_req_flag, t.dflt_to_amt_due_flag, t.effective_date, t.endorsement_req_flag, t.expr_date, t.include_in_type_count_flag, t.mag_swipe_reader_req_flag, t.max_days_for_return, t.min_days_for_return, t.min_denomination_amt, t.open_cash_drawer_req_flag, t.pin_req_flag, t.populate_system_count_flag, t.serial_id_nbr_req_flag, t.unit_count_req_code, t.suggest_deposit_flag, t.suggested_deposit_threshold, t.cash_change_limit, t.change_tndr_id, t.over_tender_overridable_flag, t.non_voidable_flag, t.close_count_disc_threshold, t.cid_msr_req_flag, t.cid_keyed_req_flag, t.postal_code_req_flag, t.disallow_split_tndr_flag, t.post_void_open_drawer_flag, t.reporting_group, t.change_allowed_when_foreign, t.fiscal_tndr_id, t.rounding_mode, t.assign_cash_drawer_req_flag, t.post_void_assign_drawer_flag FROM tnd_tndr_options t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  84 */     return " WHERE organization_id = ?  AND tndr_id = ?  AND config_element = ?  ";
/*     */   }
/*     */   
/*  87 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tnd_tndr_options(organization_id, tndr_id, config_element, create_date, create_user_id, update_date, update_user_id, auth_expr_date_req_flag, auth_mthd_code, auth_req_flag, cust_association_flag, cust_id_req_code, cust_sig_req_flag, dflt_to_amt_due_flag, effective_date, endorsement_req_flag, expr_date, include_in_type_count_flag, mag_swipe_reader_req_flag, max_days_for_return, min_days_for_return, min_denomination_amt, open_cash_drawer_req_flag, pin_req_flag, populate_system_count_flag, serial_id_nbr_req_flag, unit_count_req_code, suggest_deposit_flag, suggested_deposit_threshold, cash_change_limit, change_tndr_id, over_tender_overridable_flag, non_voidable_flag, close_count_disc_threshold, cid_msr_req_flag, cid_keyed_req_flag, postal_code_req_flag, disallow_split_tndr_flag, post_void_open_drawer_flag, reporting_group, change_allowed_when_foreign, fiscal_tndr_id, rounding_mode, assign_cash_drawer_req_flag, post_void_assign_drawer_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  90 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  94 */     Object[][] insertParameterObject = { { this._organizationId, this._tenderId, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._authExpirationDateRequired, this._authMethodCode, this._authRequired, this._custAssociation, this._custIdReqCode, this._customerSignatureRequired, this._dfltToAmountDue, this._effectiveDate, this._endorsementRequired, this._expirationDate, this._includeInTypeCount, this._magneticSwipeReaderRequired, this._maxDaysForReturn, this._minDaysForReturn, this._minimumDenominationAmount, this._openCashDrawerRequired, this._pinRequired, this._populateSystemCount, this._serialIdentificationNbrRequired, this._unitCountCode, this._suggestDeposit, this._suggestedDepositThreshold, this._cashChangeLimit, this._changeTenderId, this._overtenderOverridable, this._nonVoidable, this._closeCountDiscrepancyThreshold, this._cidMsrRequired, this._cidKeyedRequired, this._postalRequired, this._disallowSplitTender, this._postVoidOpenCashDrawerRequired, this._reportingGroup, this._changeAllowedWhenForeign, this._fiscalTenderId, this._roundingMode, this._assignCashDrawerRequired, this._postVoidAssignCashDrawerRequired } };
/*  95 */     return insertParameterObject;
/*     */   }
/*     */   
/*  98 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, -7, 12, -7, -7, 12, -7, -7, 91, -7, 91, -7, -7, 4, 4, 3, -7, -7, -7, -7, 12, -7, 3, 3, 12, -7, -7, 3, -7, -7, -7, -7, -7, 12, -7, 12, 12, -7, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/* 101 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/* 104 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tnd_tndr_options SET update_date = ?, update_user_id = ?, auth_expr_date_req_flag = ?, auth_mthd_code = ?, auth_req_flag = ?, cust_association_flag = ?, cust_id_req_code = ?, cust_sig_req_flag = ?, dflt_to_amt_due_flag = ?, effective_date = ?, endorsement_req_flag = ?, expr_date = ?, include_in_type_count_flag = ?, mag_swipe_reader_req_flag = ?, max_days_for_return = ?, min_days_for_return = ?, min_denomination_amt = ?, open_cash_drawer_req_flag = ?, pin_req_flag = ?, populate_system_count_flag = ?, serial_id_nbr_req_flag = ?, unit_count_req_code = ?, suggest_deposit_flag = ?, suggested_deposit_threshold = ?, cash_change_limit = ?, change_tndr_id = ?, over_tender_overridable_flag = ?, non_voidable_flag = ?, close_count_disc_threshold = ?, cid_msr_req_flag = ?, cid_keyed_req_flag = ?, postal_code_req_flag = ?, disallow_split_tndr_flag = ?, post_void_open_drawer_flag = ?, reporting_group = ?, change_allowed_when_foreign = ?, fiscal_tndr_id = ?, rounding_mode = ?, assign_cash_drawer_req_flag = ?, post_void_assign_drawer_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/* 107 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/* 111 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._authExpirationDateRequired, this._authMethodCode, this._authRequired, this._custAssociation, this._custIdReqCode, this._customerSignatureRequired, this._dfltToAmountDue, this._effectiveDate, this._endorsementRequired, this._expirationDate, this._includeInTypeCount, this._magneticSwipeReaderRequired, this._maxDaysForReturn, this._minDaysForReturn, this._minimumDenominationAmount, this._openCashDrawerRequired, this._pinRequired, this._populateSystemCount, this._serialIdentificationNbrRequired, this._unitCountCode, this._suggestDeposit, this._suggestedDepositThreshold, this._cashChangeLimit, this._changeTenderId, this._overtenderOverridable, this._nonVoidable, this._closeCountDiscrepancyThreshold, this._cidMsrRequired, this._cidKeyedRequired, this._postalRequired, this._disallowSplitTender, this._postVoidOpenCashDrawerRequired, this._reportingGroup, this._changeAllowedWhenForeign, this._fiscalTenderId, this._roundingMode, this._assignCashDrawerRequired, this._postVoidAssignCashDrawerRequired } };
/* 112 */     return updateParameterObject;
/*     */   }
/*     */   
/* 115 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -7, 12, -7, -7, 12, -7, -7, 91, -7, 91, -7, -7, 4, 4, 3, -7, -7, -7, -7, 12, -7, 3, 3, 12, -7, -7, 3, -7, -7, -7, -7, -7, 12, -7, 12, 12, -7, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 117 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 120 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tnd_tndr_options" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND tndr_id = ?  AND config_element = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 123 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 129 */     return " WHERE organization_id = ?  AND tndr_id = ?  AND config_element = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 132 */     return new Object[] { this._organizationId, this._tenderId, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }) };
/*     */   }
/*     */   
/* 135 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 138 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 141 */     return "tnd_tndr_options";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 145 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 149 */     return new TenderOptionsFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderOptionsFiller
/*     */     implements IFiller {
/*     */     private TenderOptionsDBA _parent;
/*     */     
/*     */     public TenderOptionsFiller(TenderOptionsDBA argParent) {
/* 157 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 162 */       long primitiveResult = argResultSet.getLong(1);
/* 163 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 164 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 168 */       this._parent._tenderId = argResultSet.getString(2);
/* 169 */       this._parent._configElement = argResultSet.getString(3);
/*     */       
/* 171 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 172 */       if (t4 != null) {
/* 173 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 176 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 179 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 181 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 182 */       if (t6 != null) {
/* 183 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 186 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 189 */       this._parent._updateUserId = argResultSet.getString(7);
/* 190 */       this._parent._authExpirationDateRequired = Boolean.valueOf(argResultSet.getBoolean(8));
/* 191 */       this._parent._authMethodCode = argResultSet.getString(9);
/* 192 */       this._parent._authRequired = Boolean.valueOf(argResultSet.getBoolean(10));
/* 193 */       this._parent._custAssociation = Boolean.valueOf(argResultSet.getBoolean(11));
/* 194 */       this._parent._custIdReqCode = argResultSet.getString(12);
/* 195 */       this._parent._customerSignatureRequired = Boolean.valueOf(argResultSet.getBoolean(13));
/* 196 */       this._parent._dfltToAmountDue = Boolean.valueOf(argResultSet.getBoolean(14));
/*     */       
/* 198 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 199 */       if (t15 != null) {
/* 200 */         this._parent._effectiveDate = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 203 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */       
/* 206 */       this._parent._endorsementRequired = Boolean.valueOf(argResultSet.getBoolean(16));
/*     */       
/* 208 */       Timestamp t17 = argResultSet.getTimestamp(17);
/* 209 */       if (t17 != null) {
/* 210 */         this._parent._expirationDate = (Date)new DtvDate(t17.getTime());
/*     */       } else {
/*     */         
/* 213 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 216 */       this._parent._includeInTypeCount = Boolean.valueOf(argResultSet.getBoolean(18));
/* 217 */       this._parent._magneticSwipeReaderRequired = Boolean.valueOf(argResultSet.getBoolean(19));
/*     */ 
/*     */       
/* 220 */       int i = argResultSet.getInt(20);
/* 221 */       if (i != 0 || argResultSet.getObject(20) != null) {
/* 222 */         this._parent._maxDaysForReturn = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 228 */       i = argResultSet.getInt(21);
/* 229 */       if (i != 0 || argResultSet.getObject(21) != null) {
/* 230 */         this._parent._minDaysForReturn = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 234 */       this._parent._minimumDenominationAmount = argResultSet.getBigDecimal(22);
/* 235 */       this._parent._openCashDrawerRequired = Boolean.valueOf(argResultSet.getBoolean(23));
/* 236 */       this._parent._pinRequired = Boolean.valueOf(argResultSet.getBoolean(24));
/* 237 */       this._parent._populateSystemCount = Boolean.valueOf(argResultSet.getBoolean(25));
/* 238 */       this._parent._serialIdentificationNbrRequired = Boolean.valueOf(argResultSet.getBoolean(26));
/* 239 */       this._parent._unitCountCode = argResultSet.getString(27);
/* 240 */       this._parent._suggestDeposit = Boolean.valueOf(argResultSet.getBoolean(28));
/* 241 */       this._parent._suggestedDepositThreshold = argResultSet.getBigDecimal(29);
/* 242 */       this._parent._cashChangeLimit = argResultSet.getBigDecimal(30);
/* 243 */       this._parent._changeTenderId = argResultSet.getString(31);
/* 244 */       this._parent._overtenderOverridable = Boolean.valueOf(argResultSet.getBoolean(32));
/* 245 */       this._parent._nonVoidable = Boolean.valueOf(argResultSet.getBoolean(33));
/* 246 */       this._parent._closeCountDiscrepancyThreshold = argResultSet.getBigDecimal(34);
/* 247 */       this._parent._cidMsrRequired = Boolean.valueOf(argResultSet.getBoolean(35));
/* 248 */       this._parent._cidKeyedRequired = Boolean.valueOf(argResultSet.getBoolean(36));
/* 249 */       this._parent._postalRequired = Boolean.valueOf(argResultSet.getBoolean(37));
/* 250 */       this._parent._disallowSplitTender = Boolean.valueOf(argResultSet.getBoolean(38));
/* 251 */       this._parent._postVoidOpenCashDrawerRequired = Boolean.valueOf(argResultSet.getBoolean(39));
/* 252 */       this._parent._reportingGroup = argResultSet.getString(40);
/* 253 */       this._parent._changeAllowedWhenForeign = Boolean.valueOf(argResultSet.getBoolean(41));
/* 254 */       this._parent._fiscalTenderId = argResultSet.getString(42);
/* 255 */       this._parent._roundingMode = argResultSet.getString(43);
/* 256 */       this._parent._assignCashDrawerRequired = Boolean.valueOf(argResultSet.getBoolean(44));
/* 257 */       this._parent._postVoidAssignCashDrawerRequired = Boolean.valueOf(argResultSet.getBoolean(45));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 262 */     argDAO.suppressStateChanges(true);
/* 263 */     TenderOptionsDAO dao = (TenderOptionsDAO)argDAO;
/* 264 */     dao.setOrganizationId(this._organizationId);
/* 265 */     dao.setTenderId(this._tenderId);
/* 266 */     dao.setConfigElement(this._configElement);
/* 267 */     dao.setCreateDate(this._createDate);
/* 268 */     dao.setCreateUserId(this._createUserId);
/* 269 */     dao.setUpdateDate(this._updateDate);
/* 270 */     dao.setUpdateUserId(this._updateUserId);
/* 271 */     dao.setAuthExpirationDateRequired(this._authExpirationDateRequired);
/* 272 */     dao.setAuthMethodCode(this._authMethodCode);
/* 273 */     dao.setAuthRequired(this._authRequired);
/* 274 */     dao.setCustAssociation(this._custAssociation);
/* 275 */     dao.setCustIdReqCode(this._custIdReqCode);
/* 276 */     dao.setCustomerSignatureRequired(this._customerSignatureRequired);
/* 277 */     dao.setDfltToAmountDue(this._dfltToAmountDue);
/* 278 */     dao.setEffectiveDate(this._effectiveDate);
/* 279 */     dao.setEndorsementRequired(this._endorsementRequired);
/* 280 */     dao.setExpirationDate(this._expirationDate);
/* 281 */     dao.setIncludeInTypeCount(this._includeInTypeCount);
/* 282 */     dao.setMagneticSwipeReaderRequired(this._magneticSwipeReaderRequired);
/* 283 */     dao.setMaxDaysForReturn(this._maxDaysForReturn);
/* 284 */     dao.setMinDaysForReturn(this._minDaysForReturn);
/* 285 */     dao.setMinimumDenominationAmount(this._minimumDenominationAmount);
/* 286 */     dao.setOpenCashDrawerRequired(this._openCashDrawerRequired);
/* 287 */     dao.setPinRequired(this._pinRequired);
/* 288 */     dao.setPopulateSystemCount(this._populateSystemCount);
/* 289 */     dao.setSerialIdentificationNbrRequired(this._serialIdentificationNbrRequired);
/* 290 */     dao.setUnitCountCode(this._unitCountCode);
/* 291 */     dao.setSuggestDeposit(this._suggestDeposit);
/* 292 */     dao.setSuggestedDepositThreshold(this._suggestedDepositThreshold);
/* 293 */     dao.setCashChangeLimit(this._cashChangeLimit);
/* 294 */     dao.setChangeTenderId(this._changeTenderId);
/* 295 */     dao.setOvertenderOverridable(this._overtenderOverridable);
/* 296 */     dao.setNonVoidable(this._nonVoidable);
/* 297 */     dao.setCloseCountDiscrepancyThreshold(this._closeCountDiscrepancyThreshold);
/* 298 */     dao.setCidMsrRequired(this._cidMsrRequired);
/* 299 */     dao.setCidKeyedRequired(this._cidKeyedRequired);
/* 300 */     dao.setPostalRequired(this._postalRequired);
/* 301 */     dao.setDisallowSplitTender(this._disallowSplitTender);
/* 302 */     dao.setPostVoidOpenCashDrawerRequired(this._postVoidOpenCashDrawerRequired);
/* 303 */     dao.setReportingGroup(this._reportingGroup);
/* 304 */     dao.setChangeAllowedWhenForeign(this._changeAllowedWhenForeign);
/* 305 */     dao.setFiscalTenderId(this._fiscalTenderId);
/* 306 */     dao.setRoundingMode(this._roundingMode);
/* 307 */     dao.setAssignCashDrawerRequired(this._assignCashDrawerRequired);
/* 308 */     dao.setPostVoidAssignCashDrawerRequired(this._postVoidAssignCashDrawerRequired);
/* 309 */     argDAO.suppressStateChanges(false);
/* 310 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 314 */     return loadDAO((IDataAccessObject)new TenderOptionsDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 318 */     TenderOptionsDAO dao = (TenderOptionsDAO)argDAO;
/* 319 */     this._organizationId = dao.getOrganizationId();
/* 320 */     this._tenderId = dao.getTenderId();
/* 321 */     this._configElement = dao.getConfigElement();
/* 322 */     this._createDate = dao.getCreateDate();
/* 323 */     this._createUserId = dao.getCreateUserId();
/* 324 */     this._updateDate = dao.getUpdateDate();
/* 325 */     this._updateUserId = dao.getUpdateUserId();
/* 326 */     this._authExpirationDateRequired = (dao.getAuthExpirationDateRequired() != null) ? dao.getAuthExpirationDateRequired() : Boolean.valueOf(false);
/* 327 */     this._authMethodCode = dao.getAuthMethodCode();
/* 328 */     this._authRequired = (dao.getAuthRequired() != null) ? dao.getAuthRequired() : Boolean.valueOf(false);
/* 329 */     this._custAssociation = (dao.getCustAssociation() != null) ? dao.getCustAssociation() : Boolean.valueOf(false);
/* 330 */     this._custIdReqCode = dao.getCustIdReqCode();
/* 331 */     this._customerSignatureRequired = (dao.getCustomerSignatureRequired() != null) ? dao.getCustomerSignatureRequired() : Boolean.valueOf(false);
/* 332 */     this._dfltToAmountDue = (dao.getDfltToAmountDue() != null) ? dao.getDfltToAmountDue() : Boolean.valueOf(false);
/* 333 */     this._effectiveDate = dao.getEffectiveDate();
/* 334 */     this._endorsementRequired = (dao.getEndorsementRequired() != null) ? dao.getEndorsementRequired() : Boolean.valueOf(false);
/* 335 */     this._expirationDate = dao.getExpirationDate();
/* 336 */     this._includeInTypeCount = (dao.getIncludeInTypeCount() != null) ? dao.getIncludeInTypeCount() : Boolean.valueOf(false);
/* 337 */     this._magneticSwipeReaderRequired = (dao.getMagneticSwipeReaderRequired() != null) ? dao.getMagneticSwipeReaderRequired() : Boolean.valueOf(false);
/* 338 */     this._maxDaysForReturn = dao.getMaxDaysForReturn();
/* 339 */     this._minDaysForReturn = dao.getMinDaysForReturn();
/* 340 */     this._minimumDenominationAmount = dao.getMinimumDenominationAmount();
/* 341 */     this._openCashDrawerRequired = (dao.getOpenCashDrawerRequired() != null) ? dao.getOpenCashDrawerRequired() : Boolean.valueOf(false);
/* 342 */     this._pinRequired = (dao.getPinRequired() != null) ? dao.getPinRequired() : Boolean.valueOf(false);
/* 343 */     this._populateSystemCount = (dao.getPopulateSystemCount() != null) ? dao.getPopulateSystemCount() : Boolean.valueOf(false);
/* 344 */     this._serialIdentificationNbrRequired = (dao.getSerialIdentificationNbrRequired() != null) ? dao.getSerialIdentificationNbrRequired() : Boolean.valueOf(false);
/* 345 */     this._unitCountCode = dao.getUnitCountCode();
/* 346 */     this._suggestDeposit = (dao.getSuggestDeposit() != null) ? dao.getSuggestDeposit() : Boolean.valueOf(false);
/* 347 */     this._suggestedDepositThreshold = dao.getSuggestedDepositThreshold();
/* 348 */     this._cashChangeLimit = dao.getCashChangeLimit();
/* 349 */     this._changeTenderId = dao.getChangeTenderId();
/* 350 */     this._overtenderOverridable = (dao.getOvertenderOverridable() != null) ? dao.getOvertenderOverridable() : Boolean.valueOf(false);
/* 351 */     this._nonVoidable = (dao.getNonVoidable() != null) ? dao.getNonVoidable() : Boolean.valueOf(false);
/* 352 */     this._closeCountDiscrepancyThreshold = dao.getCloseCountDiscrepancyThreshold();
/* 353 */     this._cidMsrRequired = (dao.getCidMsrRequired() != null) ? dao.getCidMsrRequired() : Boolean.valueOf(false);
/* 354 */     this._cidKeyedRequired = (dao.getCidKeyedRequired() != null) ? dao.getCidKeyedRequired() : Boolean.valueOf(false);
/* 355 */     this._postalRequired = (dao.getPostalRequired() != null) ? dao.getPostalRequired() : Boolean.valueOf(false);
/* 356 */     this._disallowSplitTender = (dao.getDisallowSplitTender() != null) ? dao.getDisallowSplitTender() : Boolean.valueOf(false);
/* 357 */     this._postVoidOpenCashDrawerRequired = (dao.getPostVoidOpenCashDrawerRequired() != null) ? dao.getPostVoidOpenCashDrawerRequired() : Boolean.valueOf(false);
/* 358 */     this._reportingGroup = dao.getReportingGroup();
/* 359 */     this._changeAllowedWhenForeign = (dao.getChangeAllowedWhenForeign() != null) ? dao.getChangeAllowedWhenForeign() : Boolean.valueOf(false);
/* 360 */     this._fiscalTenderId = dao.getFiscalTenderId();
/* 361 */     this._roundingMode = dao.getRoundingMode();
/* 362 */     this._assignCashDrawerRequired = (dao.getAssignCashDrawerRequired() != null) ? dao.getAssignCashDrawerRequired() : Boolean.valueOf(false);
/* 363 */     this._postVoidAssignCashDrawerRequired = (dao.getPostVoidAssignCashDrawerRequired() != null) ? dao.getPostVoidAssignCashDrawerRequired() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 367 */     TenderOptionsId id = (TenderOptionsId)argId;
/* 368 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 369 */     argStatement.setString(2, id.getTenderId());
/* 370 */     argStatement.setString(3, id.getConfigElement());
/* 371 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 375 */     TenderOptionsId id = new TenderOptionsId();
/* 376 */     id.setOrganizationId(this._organizationId);
/* 377 */     id.setTenderId(this._tenderId);
/* 378 */     id.setConfigElement(this._configElement);
/* 379 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 387 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 391 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderOptionsDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */