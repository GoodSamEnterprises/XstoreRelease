/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.ItemRestrictGS1Id;
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
/*     */ public class ItemRestrictGS1DBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1589828438L;
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _fieldId;
/*     */   private String _startValue;
/*     */   private String _aiType;
/*     */   private String _endValue;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _recordState;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.item_id, t.field_id, t.start_value, t.ai_type, t.end_value, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.record_state FROM itm_restrict_gs1 t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND field_id = ?  AND start_value = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.item_id, t.field_id, t.start_value, t.ai_type, t.end_value, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.record_state FROM itm_restrict_gs1 t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND item_id = ?  AND field_id = ?  AND start_value = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_restrict_gs1(organization_id, item_id, field_id, start_value, ai_type, end_value, org_code, org_value, create_date, create_user_id, update_date, update_user_id, record_state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._itemId, this._fieldId, this._startValue, this._aiType, this._endValue, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._recordState } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 12, 12, 12, 12, 91, 12, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_restrict_gs1 SET ai_type = ?, end_value = ?, org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, record_state = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._aiType, this._endValue, this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._recordState } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 12, 12, 91, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_restrict_gs1" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND field_id = ?  AND start_value = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND item_id = ?  AND field_id = ?  AND start_value = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._itemId, this._fieldId, this._startValue };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "itm_restrict_gs1";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new ItemRestrictGS1Filler(this);
/*     */   }
/*     */   
/*     */   private static class ItemRestrictGS1Filler
/*     */     implements IFiller {
/*     */     private ItemRestrictGS1DBA _parent;
/*     */     
/*     */     public ItemRestrictGS1Filler(ItemRestrictGS1DBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       long primitiveResult = argResultSet.getLong(1);
/* 131 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 132 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 136 */       this._parent._itemId = argResultSet.getString(2);
/* 137 */       this._parent._fieldId = argResultSet.getString(3);
/* 138 */       this._parent._startValue = argResultSet.getString(4);
/* 139 */       this._parent._aiType = argResultSet.getString(5);
/* 140 */       this._parent._endValue = argResultSet.getString(6);
/* 141 */       this._parent._orgCode = argResultSet.getString(7);
/* 142 */       this._parent._orgValue = argResultSet.getString(8);
/*     */       
/* 144 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 145 */       if (t9 != null) {
/* 146 */         this._parent._createDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._createUserId = argResultSet.getString(10);
/*     */       
/* 154 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 155 */       if (t11 != null) {
/* 156 */         this._parent._updateDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 159 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 162 */       this._parent._updateUserId = argResultSet.getString(12);
/* 163 */       this._parent._recordState = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 168 */     argDAO.suppressStateChanges(true);
/* 169 */     ItemRestrictGS1DAO dao = (ItemRestrictGS1DAO)argDAO;
/* 170 */     dao.setOrganizationId(this._organizationId);
/* 171 */     dao.setItemId(this._itemId);
/* 172 */     dao.setFieldId(this._fieldId);
/* 173 */     dao.setStartValue(this._startValue);
/* 174 */     dao.setAiType(this._aiType);
/* 175 */     dao.setEndValue(this._endValue);
/* 176 */     dao.setOrgCode(this._orgCode);
/* 177 */     dao.setOrgValue(this._orgValue);
/* 178 */     dao.setCreateDate(this._createDate);
/* 179 */     dao.setCreateUserId(this._createUserId);
/* 180 */     dao.setUpdateDate(this._updateDate);
/* 181 */     dao.setUpdateUserId(this._updateUserId);
/* 182 */     dao.setRecordState(this._recordState);
/* 183 */     argDAO.suppressStateChanges(false);
/* 184 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 188 */     return loadDAO((IDataAccessObject)new ItemRestrictGS1DAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 192 */     ItemRestrictGS1DAO dao = (ItemRestrictGS1DAO)argDAO;
/* 193 */     this._organizationId = dao.getOrganizationId();
/* 194 */     this._itemId = dao.getItemId();
/* 195 */     this._fieldId = dao.getFieldId();
/* 196 */     this._startValue = dao.getStartValue();
/* 197 */     this._aiType = dao.getAiType();
/* 198 */     this._endValue = dao.getEndValue();
/* 199 */     this._orgCode = dao.getOrgCode();
/* 200 */     this._orgValue = dao.getOrgValue();
/* 201 */     this._createDate = dao.getCreateDate();
/* 202 */     this._createUserId = dao.getCreateUserId();
/* 203 */     this._updateDate = dao.getUpdateDate();
/* 204 */     this._updateUserId = dao.getUpdateUserId();
/* 205 */     this._recordState = dao.getRecordState();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 209 */     ItemRestrictGS1Id id = (ItemRestrictGS1Id)argId;
/* 210 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 211 */     argStatement.setString(2, id.getItemId());
/* 212 */     argStatement.setString(3, id.getFieldId());
/* 213 */     argStatement.setString(4, id.getStartValue());
/* 214 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 218 */     ItemRestrictGS1Id id = new ItemRestrictGS1Id();
/* 219 */     id.setOrganizationId(this._organizationId);
/* 220 */     id.setItemId(this._itemId);
/* 221 */     id.setFieldId(this._fieldId);
/* 222 */     id.setStartValue(this._startValue);
/* 223 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 231 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 235 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictGS1DBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */