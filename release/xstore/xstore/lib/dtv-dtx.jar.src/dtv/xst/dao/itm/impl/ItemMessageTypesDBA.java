/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.ItemMessageTypesId;
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
/*     */ public class ItemMessageTypesDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1893294981L;
/*     */   private String _messageId;
/*     */   private Long _organizationId;
/*     */   private String _lineItemType;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.msg_id, t.organization_id, t.sale_lineitm_typcode, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_item_msg_types t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE msg_id = ?  AND organization_id = ?  AND sale_lineitm_typcode = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  38 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  42 */     return "SELECT t.msg_id, t.organization_id, t.sale_lineitm_typcode, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_item_msg_types t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  48 */     return " WHERE msg_id = ?  AND organization_id = ?  AND sale_lineitm_typcode = ?  ";
/*     */   }
/*     */   
/*  51 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_msg_types(msg_id, organization_id, sale_lineitm_typcode, org_code, org_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  54 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  58 */     Object[][] insertParameterObject = { { this._messageId, this._organizationId, this._lineItemType, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  59 */     return insertParameterObject;
/*     */   }
/*     */   
/*  62 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 12, 12, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  65 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  68 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_msg_types SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  71 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  75 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId } };
/*  76 */     return updateParameterObject;
/*     */   }
/*     */   
/*  79 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  81 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  84 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_msg_types" }; private static final String WHERE_OBJECT = " WHERE msg_id = ?  AND organization_id = ?  AND sale_lineitm_typcode = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  87 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  93 */     return " WHERE msg_id = ?  AND organization_id = ?  AND sale_lineitm_typcode = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  96 */     return new Object[] { this._messageId, this._organizationId, this._lineItemType };
/*     */   }
/*     */   
/*  99 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 102 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 105 */     return "itm_item_msg_types";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 109 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 113 */     return new ItemMessageTypesFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemMessageTypesFiller
/*     */     implements IFiller {
/*     */     private ItemMessageTypesDBA _parent;
/*     */     
/*     */     public ItemMessageTypesFiller(ItemMessageTypesDBA argParent) {
/* 121 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 124 */       this._parent._messageId = argResultSet.getString(1);
/*     */ 
/*     */       
/* 127 */       long primitiveResult = argResultSet.getLong(2);
/* 128 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 129 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 133 */       this._parent._lineItemType = argResultSet.getString(3);
/* 134 */       this._parent._orgCode = argResultSet.getString(4);
/* 135 */       this._parent._orgValue = argResultSet.getString(5);
/*     */       
/* 137 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 138 */       if (t6 != null) {
/* 139 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 142 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 145 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 147 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 148 */       if (t8 != null) {
/* 149 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 152 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 155 */       this._parent._updateUserId = argResultSet.getString(9);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 160 */     argDAO.suppressStateChanges(true);
/* 161 */     ItemMessageTypesDAO dao = (ItemMessageTypesDAO)argDAO;
/* 162 */     dao.setMessageId(this._messageId);
/* 163 */     dao.setOrganizationId(this._organizationId);
/* 164 */     dao.setLineItemType(this._lineItemType);
/* 165 */     dao.setOrgCode(this._orgCode);
/* 166 */     dao.setOrgValue(this._orgValue);
/* 167 */     dao.setCreateDate(this._createDate);
/* 168 */     dao.setCreateUserId(this._createUserId);
/* 169 */     dao.setUpdateDate(this._updateDate);
/* 170 */     dao.setUpdateUserId(this._updateUserId);
/* 171 */     argDAO.suppressStateChanges(false);
/* 172 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 176 */     return loadDAO((IDataAccessObject)new ItemMessageTypesDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 180 */     ItemMessageTypesDAO dao = (ItemMessageTypesDAO)argDAO;
/* 181 */     this._messageId = dao.getMessageId();
/* 182 */     this._organizationId = dao.getOrganizationId();
/* 183 */     this._lineItemType = dao.getLineItemType();
/* 184 */     this._orgCode = dao.getOrgCode();
/* 185 */     this._orgValue = dao.getOrgValue();
/* 186 */     this._createDate = dao.getCreateDate();
/* 187 */     this._createUserId = dao.getCreateUserId();
/* 188 */     this._updateDate = dao.getUpdateDate();
/* 189 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 193 */     ItemMessageTypesId id = (ItemMessageTypesId)argId;
/* 194 */     argStatement.setString(1, id.getMessageId());
/* 195 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 196 */     argStatement.setString(3, id.getLineItemType());
/* 197 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 201 */     ItemMessageTypesId id = new ItemMessageTypesId();
/* 202 */     id.setMessageId(this._messageId);
/* 203 */     id.setOrganizationId(this._organizationId);
/* 204 */     id.setLineItemType(this._lineItemType);
/* 205 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 213 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 217 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemMessageTypesDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */