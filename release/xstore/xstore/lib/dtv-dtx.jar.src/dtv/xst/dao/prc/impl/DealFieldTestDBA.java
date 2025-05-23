/*     */ package dtv.xst.dao.prc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.prc.DealFieldTestId;
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
/*     */ public class DealFieldTestDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1604134528L;
/*     */   private Long _organizationId;
/*     */   private String _dealId;
/*     */   private Integer _ordinal;
/*     */   private Integer _itemConditionGroup;
/*     */   private Integer _itemConditionSeq;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _field;
/*     */   private String _matchRule;
/*     */   private String _value1;
/*     */   private String _value2;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.deal_id, t.item_ordinal, t.item_condition_group, t.item_condition_seq, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.item_field, t.match_rule, t.value1, t.value2 FROM prc_deal_field_test t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND deal_id = ?  AND item_ordinal = ?  AND item_condition_group = ?  AND item_condition_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.deal_id, t.item_ordinal, t.item_condition_group, t.item_condition_seq, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.item_field, t.match_rule, t.value1, t.value2 FROM prc_deal_field_test t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND deal_id = ?  AND item_ordinal = ?  AND item_condition_group = ?  AND item_condition_seq = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO prc_deal_field_test(organization_id, deal_id, item_ordinal, item_condition_group, item_condition_seq, org_code, org_value, create_date, create_user_id, update_date, update_user_id, item_field, match_rule, value1, value2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._dealId, this._ordinal, this._itemConditionGroup, this._itemConditionSeq, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._field, this._matchRule, this._value1, this._value2 } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 4, 4, 12, 12, 91, 12, 91, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE prc_deal_field_test SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, item_field = ?, match_rule = ?, value1 = ?, value2 = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._field, this._matchRule, this._value1, this._value2 } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM prc_deal_field_test" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND deal_id = ?  AND item_ordinal = ?  AND item_condition_group = ?  AND item_condition_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND deal_id = ?  AND item_ordinal = ?  AND item_condition_group = ?  AND item_condition_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._dealId, this._ordinal, this._itemConditionGroup, this._itemConditionSeq };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4, 4, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "prc_deal_field_test";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new DealFieldTestFiller(this);
/*     */   }
/*     */   
/*     */   private static class DealFieldTestFiller
/*     */     implements IFiller {
/*     */     private DealFieldTestDBA _parent;
/*     */     
/*     */     public DealFieldTestFiller(DealFieldTestDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 132 */       long l = argResultSet.getLong(1);
/* 133 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 134 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 138 */       this._parent._dealId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 141 */       int primitiveResult = argResultSet.getInt(3);
/* 142 */       if (primitiveResult != 0 || argResultSet.getObject(3) != null) {
/* 143 */         this._parent._ordinal = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 149 */       primitiveResult = argResultSet.getInt(4);
/* 150 */       if (primitiveResult != 0 || argResultSet.getObject(4) != null) {
/* 151 */         this._parent._itemConditionGroup = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 157 */       primitiveResult = argResultSet.getInt(5);
/* 158 */       if (primitiveResult != 0 || argResultSet.getObject(5) != null) {
/* 159 */         this._parent._itemConditionSeq = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 163 */       this._parent._orgCode = argResultSet.getString(6);
/* 164 */       this._parent._orgValue = argResultSet.getString(7);
/*     */       
/* 166 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 167 */       if (t8 != null) {
/* 168 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 171 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 174 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 176 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 177 */       if (t10 != null) {
/* 178 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 184 */       this._parent._updateUserId = argResultSet.getString(11);
/* 185 */       this._parent._field = argResultSet.getString(12);
/* 186 */       this._parent._matchRule = argResultSet.getString(13);
/* 187 */       this._parent._value1 = argResultSet.getString(14);
/* 188 */       this._parent._value2 = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 193 */     argDAO.suppressStateChanges(true);
/* 194 */     DealFieldTestDAO dao = (DealFieldTestDAO)argDAO;
/* 195 */     dao.setOrganizationId(this._organizationId);
/* 196 */     dao.setDealId(this._dealId);
/* 197 */     dao.setOrdinal(this._ordinal);
/* 198 */     dao.setItemConditionGroup(this._itemConditionGroup);
/* 199 */     dao.setItemConditionSeq(this._itemConditionSeq);
/* 200 */     dao.setOrgCode(this._orgCode);
/* 201 */     dao.setOrgValue(this._orgValue);
/* 202 */     dao.setCreateDate(this._createDate);
/* 203 */     dao.setCreateUserId(this._createUserId);
/* 204 */     dao.setUpdateDate(this._updateDate);
/* 205 */     dao.setUpdateUserId(this._updateUserId);
/* 206 */     dao.setField(this._field);
/* 207 */     dao.setMatchRule(this._matchRule);
/* 208 */     dao.setValue1(this._value1);
/* 209 */     dao.setValue2(this._value2);
/* 210 */     argDAO.suppressStateChanges(false);
/* 211 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 215 */     return loadDAO((IDataAccessObject)new DealFieldTestDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 219 */     DealFieldTestDAO dao = (DealFieldTestDAO)argDAO;
/* 220 */     this._organizationId = dao.getOrganizationId();
/* 221 */     this._dealId = dao.getDealId();
/* 222 */     this._ordinal = dao.getOrdinal();
/* 223 */     this._itemConditionGroup = dao.getItemConditionGroup();
/* 224 */     this._itemConditionSeq = dao.getItemConditionSeq();
/* 225 */     this._orgCode = dao.getOrgCode();
/* 226 */     this._orgValue = dao.getOrgValue();
/* 227 */     this._createDate = dao.getCreateDate();
/* 228 */     this._createUserId = dao.getCreateUserId();
/* 229 */     this._updateDate = dao.getUpdateDate();
/* 230 */     this._updateUserId = dao.getUpdateUserId();
/* 231 */     this._field = dao.getField();
/* 232 */     this._matchRule = dao.getMatchRule();
/* 233 */     this._value1 = dao.getValue1();
/* 234 */     this._value2 = dao.getValue2();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 238 */     DealFieldTestId id = (DealFieldTestId)argId;
/* 239 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 240 */     argStatement.setString(2, id.getDealId());
/* 241 */     argStatement.setInt(3, id.getOrdinal().intValue());
/* 242 */     argStatement.setInt(4, id.getItemConditionGroup().intValue());
/* 243 */     argStatement.setInt(5, id.getItemConditionSeq().intValue());
/* 244 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 248 */     DealFieldTestId id = new DealFieldTestId();
/* 249 */     id.setOrganizationId(this._organizationId);
/* 250 */     id.setDealId(this._dealId);
/* 251 */     id.setOrdinal(this._ordinal);
/* 252 */     id.setItemConditionGroup(this._itemConditionGroup);
/* 253 */     id.setItemConditionSeq(this._itemConditionSeq);
/* 254 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 262 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 266 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\impl\DealFieldTestDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */