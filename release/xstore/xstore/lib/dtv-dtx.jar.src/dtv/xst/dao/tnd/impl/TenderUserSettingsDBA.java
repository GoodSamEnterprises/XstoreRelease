/*     */ package dtv.xst.dao.tnd.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.tnd.TenderUserSettingsId;
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
/*     */ public class TenderUserSettingsDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -576227806L;
/*     */   private String _groupId;
/*     */   private Long _organizationId;
/*     */   private String _tenderId;
/*     */   private String _usageCode;
/*     */   private String _entryMethodCode;
/*     */   private String _configElement;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _maximumAcceptAmount;
/*     */   private BigDecimal _minimumAcceptAmount;
/*     */   private BigDecimal _offlineCeilingApprovalAmount;
/*     */   private BigDecimal _offlineFloorApprovalAmount;
/*     */   private BigDecimal _onlineCeilingApprovalAmount;
/*     */   private BigDecimal _onlineFloorApprovalAmount;
/*     */   private BigDecimal _overTenderLimit;
/*     */   private BigDecimal _maximumRefundWithReceiptAmount;
/*     */   private BigDecimal _maximumRefundWithoutReceiptAmount;
/*     */   private static final String SELECT_OBJECT = "SELECT t.group_id, t.organization_id, t.tndr_id, t.usage_code, t.entry_mthd_code, t.config_element, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.max_accept_amt, t.min_accept_amt, t.offline_ceiling_approval_amt, t.offline_floor_approval_amt, t.online_ceiling_approval_amt, t.online_floor_approval_amt, t.over_tndr_limit, t.max_refund_with_receipt, t.max_refund_wo_receipt FROM tnd_tndr_user_settings t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE group_id = ?  AND organization_id = ?  AND tndr_id = ?  AND usage_code = ?  AND entry_mthd_code = ?  AND config_element = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  48 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  52 */     return "SELECT t.group_id, t.organization_id, t.tndr_id, t.usage_code, t.entry_mthd_code, t.config_element, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.max_accept_amt, t.min_accept_amt, t.offline_ceiling_approval_amt, t.offline_floor_approval_amt, t.online_ceiling_approval_amt, t.online_floor_approval_amt, t.over_tndr_limit, t.max_refund_with_receipt, t.max_refund_wo_receipt FROM tnd_tndr_user_settings t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  58 */     return " WHERE group_id = ?  AND organization_id = ?  AND tndr_id = ?  AND usage_code = ?  AND entry_mthd_code = ?  AND config_element = ?  ";
/*     */   }
/*     */   
/*  61 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tnd_tndr_user_settings(group_id, organization_id, tndr_id, usage_code, entry_mthd_code, config_element, create_date, create_user_id, update_date, update_user_id, max_accept_amt, min_accept_amt, offline_ceiling_approval_amt, offline_floor_approval_amt, online_ceiling_approval_amt, online_floor_approval_amt, over_tndr_limit, max_refund_with_receipt, max_refund_wo_receipt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  64 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  68 */     Object[][] insertParameterObject = { { this._groupId, this._organizationId, this._tenderId, this._usageCode, this._entryMethodCode, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._maximumAcceptAmount, this._minimumAcceptAmount, this._offlineCeilingApprovalAmount, this._offlineFloorApprovalAmount, this._onlineCeilingApprovalAmount, this._onlineFloorApprovalAmount, this._overTenderLimit, this._maximumRefundWithReceiptAmount, this._maximumRefundWithoutReceiptAmount } };
/*  69 */     return insertParameterObject;
/*     */   }
/*     */   
/*  72 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 12, 12, 12, 91, 12, 91, 12, 3, 3, 3, 3, 3, 3, 3, 3, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  75 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  78 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tnd_tndr_user_settings SET update_date = ?, update_user_id = ?, max_accept_amt = ?, min_accept_amt = ?, offline_ceiling_approval_amt = ?, offline_floor_approval_amt = ?, online_ceiling_approval_amt = ?, online_floor_approval_amt = ?, over_tndr_limit = ?, max_refund_with_receipt = ?, max_refund_wo_receipt = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  81 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  85 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._maximumAcceptAmount, this._minimumAcceptAmount, this._offlineCeilingApprovalAmount, this._offlineFloorApprovalAmount, this._onlineCeilingApprovalAmount, this._onlineFloorApprovalAmount, this._overTenderLimit, this._maximumRefundWithReceiptAmount, this._maximumRefundWithoutReceiptAmount } };
/*  86 */     return updateParameterObject;
/*     */   }
/*     */   
/*  89 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 3, 3, 3, 3, 3, 3, 3, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  91 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  94 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tnd_tndr_user_settings" }; private static final String WHERE_OBJECT = " WHERE group_id = ?  AND organization_id = ?  AND tndr_id = ?  AND usage_code = ?  AND entry_mthd_code = ?  AND config_element = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  97 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 103 */     return " WHERE group_id = ?  AND organization_id = ?  AND tndr_id = ?  AND usage_code = ?  AND entry_mthd_code = ?  AND config_element = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 106 */     return new Object[] { this._groupId, this._organizationId, this._tenderId, this._usageCode, this._entryMethodCode, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }) };
/*     */   }
/*     */   
/* 109 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 12, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 112 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 115 */     return "tnd_tndr_user_settings";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 119 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 123 */     return new TenderUserSettingsFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderUserSettingsFiller
/*     */     implements IFiller {
/*     */     private TenderUserSettingsDBA _parent;
/*     */     
/*     */     public TenderUserSettingsFiller(TenderUserSettingsDBA argParent) {
/* 131 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 134 */       this._parent._groupId = argResultSet.getString(1);
/*     */ 
/*     */       
/* 137 */       long primitiveResult = argResultSet.getLong(2);
/* 138 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 139 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 143 */       this._parent._tenderId = argResultSet.getString(3);
/* 144 */       this._parent._usageCode = argResultSet.getString(4);
/* 145 */       this._parent._entryMethodCode = argResultSet.getString(5);
/* 146 */       this._parent._configElement = argResultSet.getString(6);
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
/* 167 */       this._parent._maximumAcceptAmount = argResultSet.getBigDecimal(11);
/* 168 */       this._parent._minimumAcceptAmount = argResultSet.getBigDecimal(12);
/* 169 */       this._parent._offlineCeilingApprovalAmount = argResultSet.getBigDecimal(13);
/* 170 */       this._parent._offlineFloorApprovalAmount = argResultSet.getBigDecimal(14);
/* 171 */       this._parent._onlineCeilingApprovalAmount = argResultSet.getBigDecimal(15);
/* 172 */       this._parent._onlineFloorApprovalAmount = argResultSet.getBigDecimal(16);
/* 173 */       this._parent._overTenderLimit = argResultSet.getBigDecimal(17);
/* 174 */       this._parent._maximumRefundWithReceiptAmount = argResultSet.getBigDecimal(18);
/* 175 */       this._parent._maximumRefundWithoutReceiptAmount = argResultSet.getBigDecimal(19);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 180 */     argDAO.suppressStateChanges(true);
/* 181 */     TenderUserSettingsDAO dao = (TenderUserSettingsDAO)argDAO;
/* 182 */     dao.setGroupId(this._groupId);
/* 183 */     dao.setOrganizationId(this._organizationId);
/* 184 */     dao.setTenderId(this._tenderId);
/* 185 */     dao.setUsageCode(this._usageCode);
/* 186 */     dao.setEntryMethodCode(this._entryMethodCode);
/* 187 */     dao.setConfigElement(this._configElement);
/* 188 */     dao.setCreateDate(this._createDate);
/* 189 */     dao.setCreateUserId(this._createUserId);
/* 190 */     dao.setUpdateDate(this._updateDate);
/* 191 */     dao.setUpdateUserId(this._updateUserId);
/* 192 */     dao.setMaximumAcceptAmount(this._maximumAcceptAmount);
/* 193 */     dao.setMinimumAcceptAmount(this._minimumAcceptAmount);
/* 194 */     dao.setOfflineCeilingApprovalAmount(this._offlineCeilingApprovalAmount);
/* 195 */     dao.setOfflineFloorApprovalAmount(this._offlineFloorApprovalAmount);
/* 196 */     dao.setOnlineCeilingApprovalAmount(this._onlineCeilingApprovalAmount);
/* 197 */     dao.setOnlineFloorApprovalAmount(this._onlineFloorApprovalAmount);
/* 198 */     dao.setOverTenderLimit(this._overTenderLimit);
/* 199 */     dao.setMaximumRefundWithReceiptAmount(this._maximumRefundWithReceiptAmount);
/* 200 */     dao.setMaximumRefundWithoutReceiptAmount(this._maximumRefundWithoutReceiptAmount);
/* 201 */     argDAO.suppressStateChanges(false);
/* 202 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 206 */     return loadDAO((IDataAccessObject)new TenderUserSettingsDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 210 */     TenderUserSettingsDAO dao = (TenderUserSettingsDAO)argDAO;
/* 211 */     this._groupId = dao.getGroupId();
/* 212 */     this._organizationId = dao.getOrganizationId();
/* 213 */     this._tenderId = dao.getTenderId();
/* 214 */     this._usageCode = dao.getUsageCode();
/* 215 */     this._entryMethodCode = dao.getEntryMethodCode();
/* 216 */     this._configElement = dao.getConfigElement();
/* 217 */     this._createDate = dao.getCreateDate();
/* 218 */     this._createUserId = dao.getCreateUserId();
/* 219 */     this._updateDate = dao.getUpdateDate();
/* 220 */     this._updateUserId = dao.getUpdateUserId();
/* 221 */     this._maximumAcceptAmount = dao.getMaximumAcceptAmount();
/* 222 */     this._minimumAcceptAmount = dao.getMinimumAcceptAmount();
/* 223 */     this._offlineCeilingApprovalAmount = dao.getOfflineCeilingApprovalAmount();
/* 224 */     this._offlineFloorApprovalAmount = dao.getOfflineFloorApprovalAmount();
/* 225 */     this._onlineCeilingApprovalAmount = dao.getOnlineCeilingApprovalAmount();
/* 226 */     this._onlineFloorApprovalAmount = dao.getOnlineFloorApprovalAmount();
/* 227 */     this._overTenderLimit = dao.getOverTenderLimit();
/* 228 */     this._maximumRefundWithReceiptAmount = dao.getMaximumRefundWithReceiptAmount();
/* 229 */     this._maximumRefundWithoutReceiptAmount = dao.getMaximumRefundWithoutReceiptAmount();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 233 */     TenderUserSettingsId id = (TenderUserSettingsId)argId;
/* 234 */     argStatement.setString(1, id.getGroupId());
/* 235 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 236 */     argStatement.setString(3, id.getTenderId());
/* 237 */     argStatement.setString(4, id.getUsageCode());
/* 238 */     argStatement.setString(5, id.getEntryMethodCode());
/* 239 */     argStatement.setString(6, id.getConfigElement());
/* 240 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 244 */     TenderUserSettingsId id = new TenderUserSettingsId();
/* 245 */     id.setGroupId(this._groupId);
/* 246 */     id.setOrganizationId(this._organizationId);
/* 247 */     id.setTenderId(this._tenderId);
/* 248 */     id.setUsageCode(this._usageCode);
/* 249 */     id.setEntryMethodCode(this._entryMethodCode);
/* 250 */     id.setConfigElement(this._configElement);
/* 251 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 259 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 263 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderUserSettingsDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */