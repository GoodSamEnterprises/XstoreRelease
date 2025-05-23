/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.ItemMessageId;
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
/*     */ public class ItemMessageDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 2088876372L;
/*     */   private String _messageId;
/*     */   private Long _organizationId;
/*     */   private Date _effectiveDate;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _contentType;
/*     */   private Date _expirationDate;
/*     */   private String _messageKey;
/*     */   private String _titleKey;
/*     */   private static final String SELECT_OBJECT = "SELECT t.msg_id, t.organization_id, t.effective_datetime, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.content_type, t.expr_datetime, t.msg_key, t.title_key FROM itm_item_msg t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE msg_id = ?  AND organization_id = ?  AND effective_datetime = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.msg_id, t.organization_id, t.effective_datetime, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.content_type, t.expr_datetime, t.msg_key, t.title_key FROM itm_item_msg t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE msg_id = ?  AND organization_id = ?  AND effective_datetime = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_msg(msg_id, organization_id, effective_datetime, org_code, org_value, create_date, create_user_id, update_date, update_user_id, content_type, expr_datetime, msg_key, title_key) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._messageId, this._organizationId, this._effectiveDate, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._contentType, this._expirationDate, this._messageKey, this._titleKey } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 91, 12, 12, 91, 12, 91, 12, 12, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_msg SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, content_type = ?, expr_datetime = ?, msg_key = ?, title_key = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._contentType, this._expirationDate, this._messageKey, this._titleKey } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 12, 91, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_msg" }; private static final String WHERE_OBJECT = " WHERE msg_id = ?  AND organization_id = ?  AND effective_datetime = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE msg_id = ?  AND organization_id = ?  AND effective_datetime = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._messageId, this._organizationId, this._effectiveDate };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 91 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "itm_item_msg";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new ItemMessageFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemMessageFiller
/*     */     implements IFiller {
/*     */     private ItemMessageDBA _parent;
/*     */     
/*     */     public ItemMessageFiller(ItemMessageDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       this._parent._messageId = argResultSet.getString(1);
/*     */ 
/*     */       
/* 131 */       long primitiveResult = argResultSet.getLong(2);
/* 132 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 133 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 138 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 139 */       if (t3 != null) {
/* 140 */         this._parent._effectiveDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 143 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */       
/* 146 */       this._parent._orgCode = argResultSet.getString(4);
/* 147 */       this._parent._orgValue = argResultSet.getString(5);
/*     */       
/* 149 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 150 */       if (t6 != null) {
/* 151 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 159 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 160 */       if (t8 != null) {
/* 161 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 164 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 167 */       this._parent._updateUserId = argResultSet.getString(9);
/* 168 */       this._parent._contentType = argResultSet.getString(10);
/*     */       
/* 170 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 171 */       if (t11 != null) {
/* 172 */         this._parent._expirationDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 175 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 178 */       this._parent._messageKey = argResultSet.getString(12);
/* 179 */       this._parent._titleKey = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 184 */     argDAO.suppressStateChanges(true);
/* 185 */     ItemMessageDAO dao = (ItemMessageDAO)argDAO;
/* 186 */     dao.setMessageId(this._messageId);
/* 187 */     dao.setOrganizationId(this._organizationId);
/* 188 */     dao.setEffectiveDate(this._effectiveDate);
/* 189 */     dao.setOrgCode(this._orgCode);
/* 190 */     dao.setOrgValue(this._orgValue);
/* 191 */     dao.setCreateDate(this._createDate);
/* 192 */     dao.setCreateUserId(this._createUserId);
/* 193 */     dao.setUpdateDate(this._updateDate);
/* 194 */     dao.setUpdateUserId(this._updateUserId);
/* 195 */     dao.setContentType(this._contentType);
/* 196 */     dao.setExpirationDate(this._expirationDate);
/* 197 */     dao.setMessageKey(this._messageKey);
/* 198 */     dao.setTitleKey(this._titleKey);
/* 199 */     argDAO.suppressStateChanges(false);
/* 200 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 204 */     return loadDAO((IDataAccessObject)new ItemMessageDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 208 */     ItemMessageDAO dao = (ItemMessageDAO)argDAO;
/* 209 */     this._messageId = dao.getMessageId();
/* 210 */     this._organizationId = dao.getOrganizationId();
/* 211 */     this._effectiveDate = dao.getEffectiveDate();
/* 212 */     this._orgCode = dao.getOrgCode();
/* 213 */     this._orgValue = dao.getOrgValue();
/* 214 */     this._createDate = dao.getCreateDate();
/* 215 */     this._createUserId = dao.getCreateUserId();
/* 216 */     this._updateDate = dao.getUpdateDate();
/* 217 */     this._updateUserId = dao.getUpdateUserId();
/* 218 */     this._contentType = dao.getContentType();
/* 219 */     this._expirationDate = dao.getExpirationDate();
/* 220 */     this._messageKey = dao.getMessageKey();
/* 221 */     this._titleKey = dao.getTitleKey();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 225 */     ItemMessageId id = (ItemMessageId)argId;
/* 226 */     argStatement.setString(1, id.getMessageId());
/* 227 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 228 */     argStatement.setTimestamp(3, new Timestamp(id.getEffectiveDate().getTime()));
/* 229 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 233 */     ItemMessageId id = new ItemMessageId();
/* 234 */     id.setMessageId(this._messageId);
/* 235 */     id.setOrganizationId(this._organizationId);
/* 236 */     id.setEffectiveDate(this._effectiveDate);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemMessageDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */