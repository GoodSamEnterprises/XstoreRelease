/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.AttachedItemsId;
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
/*     */ public class AttachedItemsDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 719229020L;
/*     */   private String _attachedItemId;
/*     */   private Long _organizationId;
/*     */   private String _soldItemId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _beginDatetime;
/*     */   private Date _endDatetime;
/*     */   private Boolean _promptToAdd;
/*     */   private String _promptToAddMsgKey;
/*     */   private BigDecimal _quantityToAdd;
/*     */   private String _lineItemAssociationTypeCode;
/*     */   private Boolean _promptForReturn;
/*     */   private String _promptForReturnMsgKey;
/*     */   private String _externalId;
/*     */   private String _externalSystem;
/*     */   private static final String SELECT_OBJECT = "SELECT t.attached_item_id, t.organization_id, t.sold_item_id, t.level_code, t.level_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.begin_datetime, t.end_datetime, t.prompt_to_add_flag, t.prompt_to_add_msg_key, t.quantity_to_add, t.lineitm_assoc_typcode, t.prompt_for_return_flag, t.prompt_for_return_msg_key, t.external_id, t.external_system FROM itm_attached_items t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE attached_item_id = ?  AND organization_id = ?  AND sold_item_id = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  48 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  52 */     return "SELECT t.attached_item_id, t.organization_id, t.sold_item_id, t.level_code, t.level_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.begin_datetime, t.end_datetime, t.prompt_to_add_flag, t.prompt_to_add_msg_key, t.quantity_to_add, t.lineitm_assoc_typcode, t.prompt_for_return_flag, t.prompt_for_return_msg_key, t.external_id, t.external_system FROM itm_attached_items t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  58 */     return " WHERE attached_item_id = ?  AND organization_id = ?  AND sold_item_id = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   }
/*     */   
/*  61 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_attached_items(attached_item_id, organization_id, sold_item_id, level_code, level_value, create_date, create_user_id, update_date, update_user_id, begin_datetime, end_datetime, prompt_to_add_flag, prompt_to_add_msg_key, quantity_to_add, lineitm_assoc_typcode, prompt_for_return_flag, prompt_for_return_msg_key, external_id, external_system) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  64 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  68 */     Object[][] insertParameterObject = { { this._attachedItemId, this._organizationId, this._soldItemId, this._levelCode, this._levelValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._beginDatetime, this._endDatetime, this._promptToAdd, this._promptToAddMsgKey, this._quantityToAdd, this._lineItemAssociationTypeCode, this._promptForReturn, this._promptForReturnMsgKey, this._externalId, this._externalSystem } };
/*  69 */     return insertParameterObject;
/*     */   }
/*     */   
/*  72 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 12, 12, 91, 12, 91, 12, 91, 91, -7, 12, 3, 12, -7, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  75 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  78 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_attached_items SET update_date = ?, update_user_id = ?, begin_datetime = ?, end_datetime = ?, prompt_to_add_flag = ?, prompt_to_add_msg_key = ?, quantity_to_add = ?, lineitm_assoc_typcode = ?, prompt_for_return_flag = ?, prompt_for_return_msg_key = ?, external_id = ?, external_system = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  81 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  85 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._beginDatetime, this._endDatetime, this._promptToAdd, this._promptToAddMsgKey, this._quantityToAdd, this._lineItemAssociationTypeCode, this._promptForReturn, this._promptForReturnMsgKey, this._externalId, this._externalSystem } };
/*  86 */     return updateParameterObject;
/*     */   }
/*     */   
/*  89 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 91, -7, 12, 3, 12, -7, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  91 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  94 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_attached_items" }; private static final String WHERE_OBJECT = " WHERE attached_item_id = ?  AND organization_id = ?  AND sold_item_id = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  97 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 103 */     return " WHERE attached_item_id = ?  AND organization_id = ?  AND sold_item_id = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 106 */     return new Object[] { this._attachedItemId, this._organizationId, this._soldItemId, this._levelCode, this._levelValue };
/*     */   }
/*     */   
/* 109 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 112 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 115 */     return "itm_attached_items";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 119 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 123 */     return new AttachedItemsFiller(this);
/*     */   }
/*     */   
/*     */   private static class AttachedItemsFiller
/*     */     implements IFiller {
/*     */     private AttachedItemsDBA _parent;
/*     */     
/*     */     public AttachedItemsFiller(AttachedItemsDBA argParent) {
/* 131 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 134 */       this._parent._attachedItemId = argResultSet.getString(1);
/*     */ 
/*     */       
/* 137 */       long primitiveResult = argResultSet.getLong(2);
/* 138 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 139 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 143 */       this._parent._soldItemId = argResultSet.getString(3);
/* 144 */       this._parent._levelCode = argResultSet.getString(4);
/* 145 */       this._parent._levelValue = argResultSet.getString(5);
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
/*     */       
/* 167 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 168 */       if (t10 != null) {
/* 169 */         this._parent._beginDatetime = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 172 */         this._parent._beginDatetime = null;
/*     */       } 
/*     */ 
/*     */       
/* 176 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 177 */       if (t11 != null) {
/* 178 */         this._parent._endDatetime = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._endDatetime = null;
/*     */       } 
/*     */       
/* 184 */       this._parent._promptToAdd = Boolean.valueOf(argResultSet.getBoolean(12));
/* 185 */       this._parent._promptToAddMsgKey = argResultSet.getString(13);
/* 186 */       this._parent._quantityToAdd = argResultSet.getBigDecimal(14);
/* 187 */       this._parent._lineItemAssociationTypeCode = argResultSet.getString(15);
/* 188 */       this._parent._promptForReturn = Boolean.valueOf(argResultSet.getBoolean(16));
/* 189 */       this._parent._promptForReturnMsgKey = argResultSet.getString(17);
/* 190 */       this._parent._externalId = argResultSet.getString(18);
/* 191 */       this._parent._externalSystem = argResultSet.getString(19);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 196 */     argDAO.suppressStateChanges(true);
/* 197 */     AttachedItemsDAO dao = (AttachedItemsDAO)argDAO;
/* 198 */     dao.setAttachedItemId(this._attachedItemId);
/* 199 */     dao.setOrganizationId(this._organizationId);
/* 200 */     dao.setSoldItemId(this._soldItemId);
/* 201 */     dao.setLevelCode(this._levelCode);
/* 202 */     dao.setLevelValue(this._levelValue);
/* 203 */     dao.setCreateDate(this._createDate);
/* 204 */     dao.setCreateUserId(this._createUserId);
/* 205 */     dao.setUpdateDate(this._updateDate);
/* 206 */     dao.setUpdateUserId(this._updateUserId);
/* 207 */     dao.setBeginDatetime(this._beginDatetime);
/* 208 */     dao.setEndDatetime(this._endDatetime);
/* 209 */     dao.setPromptToAdd(this._promptToAdd);
/* 210 */     dao.setPromptToAddMsgKey(this._promptToAddMsgKey);
/* 211 */     dao.setQuantityToAdd(this._quantityToAdd);
/* 212 */     dao.setLineItemAssociationTypeCode(this._lineItemAssociationTypeCode);
/* 213 */     dao.setPromptForReturn(this._promptForReturn);
/* 214 */     dao.setPromptForReturnMsgKey(this._promptForReturnMsgKey);
/* 215 */     dao.setExternalId(this._externalId);
/* 216 */     dao.setExternalSystem(this._externalSystem);
/* 217 */     argDAO.suppressStateChanges(false);
/* 218 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 222 */     return loadDAO((IDataAccessObject)new AttachedItemsDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 226 */     AttachedItemsDAO dao = (AttachedItemsDAO)argDAO;
/* 227 */     this._attachedItemId = dao.getAttachedItemId();
/* 228 */     this._organizationId = dao.getOrganizationId();
/* 229 */     this._soldItemId = dao.getSoldItemId();
/* 230 */     this._levelCode = dao.getLevelCode();
/* 231 */     this._levelValue = dao.getLevelValue();
/* 232 */     this._createDate = dao.getCreateDate();
/* 233 */     this._createUserId = dao.getCreateUserId();
/* 234 */     this._updateDate = dao.getUpdateDate();
/* 235 */     this._updateUserId = dao.getUpdateUserId();
/* 236 */     this._beginDatetime = dao.getBeginDatetime();
/* 237 */     this._endDatetime = dao.getEndDatetime();
/* 238 */     this._promptToAdd = (dao.getPromptToAdd() != null) ? dao.getPromptToAdd() : Boolean.valueOf(false);
/* 239 */     this._promptToAddMsgKey = dao.getPromptToAddMsgKey();
/* 240 */     this._quantityToAdd = dao.getQuantityToAdd();
/* 241 */     this._lineItemAssociationTypeCode = dao.getLineItemAssociationTypeCode();
/* 242 */     this._promptForReturn = (dao.getPromptForReturn() != null) ? dao.getPromptForReturn() : Boolean.valueOf(false);
/* 243 */     this._promptForReturnMsgKey = dao.getPromptForReturnMsgKey();
/* 244 */     this._externalId = dao.getExternalId();
/* 245 */     this._externalSystem = dao.getExternalSystem();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 249 */     AttachedItemsId id = (AttachedItemsId)argId;
/* 250 */     argStatement.setString(1, id.getAttachedItemId());
/* 251 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 252 */     argStatement.setString(3, id.getSoldItemId());
/* 253 */     argStatement.setString(4, id.getLevelCode());
/* 254 */     argStatement.setString(5, id.getLevelValue());
/* 255 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 259 */     AttachedItemsId id = new AttachedItemsId();
/* 260 */     id.setAttachedItemId(this._attachedItemId);
/* 261 */     id.setOrganizationId(this._organizationId);
/* 262 */     id.setSoldItemId(this._soldItemId);
/* 263 */     id.setLevelCode(this._levelCode);
/* 264 */     id.setLevelValue(this._levelValue);
/* 265 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 273 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 277 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\AttachedItemsDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */