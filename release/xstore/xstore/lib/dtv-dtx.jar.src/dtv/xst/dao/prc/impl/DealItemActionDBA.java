/*     */ package dtv.xst.dao.prc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.prc.DealItemActionId;
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
/*     */ public class DealItemActionDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1580459819L;
/*     */   private Long _organizationId;
/*     */   private String _dealId;
/*     */   private Integer _ordinal;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Boolean _consumable;
/*     */   private BigDecimal _minQty;
/*     */   private BigDecimal _maxQty;
/*     */   private BigDecimal _minItemTotal;
/*     */   private String _actionType;
/*     */   private BigDecimal _actionArg;
/*     */   private BigDecimal _actionArgQty;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.deal_id, t.item_ordinal, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.consumable, t.qty_min, t.qty_max, t.min_item_total, t.deal_action, t.action_arg, t.action_arg_qty FROM prc_deal_item t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND deal_id = ?  AND item_ordinal = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.organization_id, t.deal_id, t.item_ordinal, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.consumable, t.qty_min, t.qty_max, t.min_item_total, t.deal_action, t.action_arg, t.action_arg_qty FROM prc_deal_item t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE organization_id = ?  AND deal_id = ?  AND item_ordinal = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO prc_deal_item(organization_id, deal_id, item_ordinal, org_code, org_value, create_date, create_user_id, update_date, update_user_id, consumable, qty_min, qty_max, min_item_total, deal_action, action_arg, action_arg_qty) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._organizationId, this._dealId, this._ordinal, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._consumable, this._minQty, this._maxQty, this._minItemTotal, this._actionType, this._actionArg, this._actionArgQty } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 12, 12, 91, 12, 91, 12, -7, 3, 3, 3, 12, 3, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE prc_deal_item SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, consumable = ?, qty_min = ?, qty_max = ?, min_item_total = ?, deal_action = ?, action_arg = ?, action_arg_qty = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  78 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._consumable, this._minQty, this._maxQty, this._minItemTotal, this._actionType, this._actionArg, this._actionArgQty } };
/*  83 */     return updateParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, -7, 3, 3, 3, 12, 3, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  88 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM prc_deal_item" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND deal_id = ?  AND item_ordinal = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  94 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 100 */     return " WHERE organization_id = ?  AND deal_id = ?  AND item_ordinal = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 103 */     return new Object[] { this._organizationId, this._dealId, this._ordinal };
/*     */   }
/*     */   
/* 106 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 109 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 112 */     return "prc_deal_item";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new DealItemActionFiller(this);
/*     */   }
/*     */   
/*     */   private static class DealItemActionFiller
/*     */     implements IFiller {
/*     */     private DealItemActionDBA _parent;
/*     */     
/*     */     public DealItemActionFiller(DealItemActionDBA argParent) {
/* 128 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 133 */       long l = argResultSet.getLong(1);
/* 134 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 135 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 139 */       this._parent._dealId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 142 */       int primitiveResult = argResultSet.getInt(3);
/* 143 */       if (primitiveResult != 0 || argResultSet.getObject(3) != null) {
/* 144 */         this._parent._ordinal = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 148 */       this._parent._orgCode = argResultSet.getString(4);
/* 149 */       this._parent._orgValue = argResultSet.getString(5);
/*     */       
/* 151 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 152 */       if (t6 != null) {
/* 153 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 159 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 161 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 162 */       if (t8 != null) {
/* 163 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 166 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 169 */       this._parent._updateUserId = argResultSet.getString(9);
/* 170 */       this._parent._consumable = Boolean.valueOf(argResultSet.getBoolean(10));
/* 171 */       this._parent._minQty = argResultSet.getBigDecimal(11);
/* 172 */       this._parent._maxQty = argResultSet.getBigDecimal(12);
/* 173 */       this._parent._minItemTotal = argResultSet.getBigDecimal(13);
/* 174 */       this._parent._actionType = argResultSet.getString(14);
/* 175 */       this._parent._actionArg = argResultSet.getBigDecimal(15);
/* 176 */       this._parent._actionArgQty = argResultSet.getBigDecimal(16);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 181 */     argDAO.suppressStateChanges(true);
/* 182 */     DealItemActionDAO dao = (DealItemActionDAO)argDAO;
/* 183 */     dao.setOrganizationId(this._organizationId);
/* 184 */     dao.setDealId(this._dealId);
/* 185 */     dao.setOrdinal(this._ordinal);
/* 186 */     dao.setOrgCode(this._orgCode);
/* 187 */     dao.setOrgValue(this._orgValue);
/* 188 */     dao.setCreateDate(this._createDate);
/* 189 */     dao.setCreateUserId(this._createUserId);
/* 190 */     dao.setUpdateDate(this._updateDate);
/* 191 */     dao.setUpdateUserId(this._updateUserId);
/* 192 */     dao.setConsumable(this._consumable);
/* 193 */     dao.setMinQty(this._minQty);
/* 194 */     dao.setMaxQty(this._maxQty);
/* 195 */     dao.setMinItemTotal(this._minItemTotal);
/* 196 */     dao.setActionType(this._actionType);
/* 197 */     dao.setActionArg(this._actionArg);
/* 198 */     dao.setActionArgQty(this._actionArgQty);
/* 199 */     argDAO.suppressStateChanges(false);
/* 200 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 204 */     return loadDAO((IDataAccessObject)new DealItemActionDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 208 */     DealItemActionDAO dao = (DealItemActionDAO)argDAO;
/* 209 */     this._organizationId = dao.getOrganizationId();
/* 210 */     this._dealId = dao.getDealId();
/* 211 */     this._ordinal = dao.getOrdinal();
/* 212 */     this._orgCode = dao.getOrgCode();
/* 213 */     this._orgValue = dao.getOrgValue();
/* 214 */     this._createDate = dao.getCreateDate();
/* 215 */     this._createUserId = dao.getCreateUserId();
/* 216 */     this._updateDate = dao.getUpdateDate();
/* 217 */     this._updateUserId = dao.getUpdateUserId();
/* 218 */     this._consumable = (dao.getConsumable() != null) ? dao.getConsumable() : Boolean.valueOf(false);
/* 219 */     this._minQty = dao.getMinQty();
/* 220 */     this._maxQty = dao.getMaxQty();
/* 221 */     this._minItemTotal = dao.getMinItemTotal();
/* 222 */     this._actionType = dao.getActionType();
/* 223 */     this._actionArg = dao.getActionArg();
/* 224 */     this._actionArgQty = dao.getActionArgQty();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 228 */     DealItemActionId id = (DealItemActionId)argId;
/* 229 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 230 */     argStatement.setString(2, id.getDealId());
/* 231 */     argStatement.setInt(3, id.getOrdinal().intValue());
/* 232 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 236 */     DealItemActionId id = new DealItemActionId();
/* 237 */     id.setOrganizationId(this._organizationId);
/* 238 */     id.setDealId(this._dealId);
/* 239 */     id.setOrdinal(this._ordinal);
/* 240 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 248 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 252 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\impl\DealItemActionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */