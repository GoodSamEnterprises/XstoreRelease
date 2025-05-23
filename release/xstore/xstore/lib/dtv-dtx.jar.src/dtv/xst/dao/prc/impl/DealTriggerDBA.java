/*     */ package dtv.xst.dao.prc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.prc.DealTriggerId;
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
/*     */ public class DealTriggerDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 313657228L;
/*     */   private Long _organizationId;
/*     */   private String _dealId;
/*     */   private String _trigger;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.deal_id, t.deal_trigger, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM prc_deal_trig t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND deal_id = ?  AND deal_trigger = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  38 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  42 */     return "SELECT t.organization_id, t.deal_id, t.deal_trigger, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM prc_deal_trig t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  48 */     return " WHERE organization_id = ?  AND deal_id = ?  AND deal_trigger = ?  ";
/*     */   }
/*     */   
/*  51 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO prc_deal_trig(organization_id, deal_id, deal_trigger, org_code, org_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  54 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  58 */     Object[][] insertParameterObject = { { this._organizationId, this._dealId, this._trigger, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  59 */     return insertParameterObject;
/*     */   }
/*     */   
/*  62 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 12, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  65 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  68 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE prc_deal_trig SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?" };
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
/*  84 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM prc_deal_trig" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND deal_id = ?  AND deal_trigger = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  87 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  93 */     return " WHERE organization_id = ?  AND deal_id = ?  AND deal_trigger = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  96 */     return new Object[] { this._organizationId, this._dealId, this._trigger };
/*     */   }
/*     */   
/*  99 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 102 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 105 */     return "prc_deal_trig";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 109 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 113 */     return new DealTriggerFiller(this);
/*     */   }
/*     */   
/*     */   private static class DealTriggerFiller
/*     */     implements IFiller {
/*     */     private DealTriggerDBA _parent;
/*     */     
/*     */     public DealTriggerFiller(DealTriggerDBA argParent) {
/* 121 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 126 */       long primitiveResult = argResultSet.getLong(1);
/* 127 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 128 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 132 */       this._parent._dealId = argResultSet.getString(2);
/* 133 */       this._parent._trigger = argResultSet.getString(3);
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
/* 161 */     DealTriggerDAO dao = (DealTriggerDAO)argDAO;
/* 162 */     dao.setOrganizationId(this._organizationId);
/* 163 */     dao.setDealId(this._dealId);
/* 164 */     dao.setTrigger(this._trigger);
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
/* 176 */     return loadDAO((IDataAccessObject)new DealTriggerDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 180 */     DealTriggerDAO dao = (DealTriggerDAO)argDAO;
/* 181 */     this._organizationId = dao.getOrganizationId();
/* 182 */     this._dealId = dao.getDealId();
/* 183 */     this._trigger = dao.getTrigger();
/* 184 */     this._orgCode = dao.getOrgCode();
/* 185 */     this._orgValue = dao.getOrgValue();
/* 186 */     this._createDate = dao.getCreateDate();
/* 187 */     this._createUserId = dao.getCreateUserId();
/* 188 */     this._updateDate = dao.getUpdateDate();
/* 189 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 193 */     DealTriggerId id = (DealTriggerId)argId;
/* 194 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 195 */     argStatement.setString(2, id.getDealId());
/* 196 */     argStatement.setString(3, id.getTrigger());
/* 197 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 201 */     DealTriggerId id = new DealTriggerId();
/* 202 */     id.setOrganizationId(this._organizationId);
/* 203 */     id.setDealId(this._dealId);
/* 204 */     id.setTrigger(this._trigger);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\impl\DealTriggerDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */