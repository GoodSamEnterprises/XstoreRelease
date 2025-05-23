/*     */ package dtv.xst.dao.dsc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.dsc.DiscountTypeEligibilityId;
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
/*     */ public class DiscountTypeEligibilityDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -853580718L;
/*     */   private String _discountCode;
/*     */   private Long _organizationId;
/*     */   private String _saleLineItemTypeCode;
/*     */   private String _configElement;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.discount_code, t.organization_id, t.sale_lineitm_typcode, t.config_element, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM dsc_disc_type_eligibility t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE discount_code = ?  AND organization_id = ?  AND sale_lineitm_typcode = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  37 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  41 */     return "SELECT t.discount_code, t.organization_id, t.sale_lineitm_typcode, t.config_element, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM dsc_disc_type_eligibility t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  47 */     return " WHERE discount_code = ?  AND organization_id = ?  AND sale_lineitm_typcode = ?  ";
/*     */   }
/*     */   
/*  50 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO dsc_disc_type_eligibility(discount_code, organization_id, sale_lineitm_typcode, config_element, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  53 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  57 */     Object[][] insertParameterObject = { { this._discountCode, this._organizationId, this._saleLineItemTypeCode, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  58 */     return insertParameterObject;
/*     */   }
/*     */   
/*  61 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 12, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  64 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  67 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE dsc_disc_type_eligibility SET config_element = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  70 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  74 */     Object[][] updateParameterObject = { { ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._updateDate, this._updateUserId } };
/*  75 */     return updateParameterObject;
/*     */   }
/*     */   
/*  78 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  80 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  83 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM dsc_disc_type_eligibility" }; private static final String WHERE_OBJECT = " WHERE discount_code = ?  AND organization_id = ?  AND sale_lineitm_typcode = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  86 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  92 */     return " WHERE discount_code = ?  AND organization_id = ?  AND sale_lineitm_typcode = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  95 */     return new Object[] { this._discountCode, this._organizationId, this._saleLineItemTypeCode };
/*     */   }
/*     */   
/*  98 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 101 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 104 */     return "dsc_disc_type_eligibility";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 108 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 112 */     return new DiscountTypeEligibilityFiller(this);
/*     */   }
/*     */   
/*     */   private static class DiscountTypeEligibilityFiller
/*     */     implements IFiller {
/*     */     private DiscountTypeEligibilityDBA _parent;
/*     */     
/*     */     public DiscountTypeEligibilityFiller(DiscountTypeEligibilityDBA argParent) {
/* 120 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 123 */       this._parent._discountCode = argResultSet.getString(1);
/*     */ 
/*     */       
/* 126 */       long primitiveResult = argResultSet.getLong(2);
/* 127 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 128 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 132 */       this._parent._saleLineItemTypeCode = argResultSet.getString(3);
/* 133 */       this._parent._configElement = argResultSet.getString(4);
/*     */       
/* 135 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 136 */       if (t5 != null) {
/* 137 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 140 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 143 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 145 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 146 */       if (t7 != null) {
/* 147 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._updateUserId = argResultSet.getString(8);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 158 */     argDAO.suppressStateChanges(true);
/* 159 */     DiscountTypeEligibilityDAO dao = (DiscountTypeEligibilityDAO)argDAO;
/* 160 */     dao.setDiscountCode(this._discountCode);
/* 161 */     dao.setOrganizationId(this._organizationId);
/* 162 */     dao.setSaleLineItemTypeCode(this._saleLineItemTypeCode);
/* 163 */     dao.setConfigElement(this._configElement);
/* 164 */     dao.setCreateDate(this._createDate);
/* 165 */     dao.setCreateUserId(this._createUserId);
/* 166 */     dao.setUpdateDate(this._updateDate);
/* 167 */     dao.setUpdateUserId(this._updateUserId);
/* 168 */     argDAO.suppressStateChanges(false);
/* 169 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 173 */     return loadDAO((IDataAccessObject)new DiscountTypeEligibilityDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 177 */     DiscountTypeEligibilityDAO dao = (DiscountTypeEligibilityDAO)argDAO;
/* 178 */     this._discountCode = dao.getDiscountCode();
/* 179 */     this._organizationId = dao.getOrganizationId();
/* 180 */     this._saleLineItemTypeCode = dao.getSaleLineItemTypeCode();
/* 181 */     this._configElement = dao.getConfigElement();
/* 182 */     this._createDate = dao.getCreateDate();
/* 183 */     this._createUserId = dao.getCreateUserId();
/* 184 */     this._updateDate = dao.getUpdateDate();
/* 185 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 189 */     DiscountTypeEligibilityId id = (DiscountTypeEligibilityId)argId;
/* 190 */     argStatement.setString(1, id.getDiscountCode());
/* 191 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 192 */     argStatement.setString(3, id.getSaleLineItemTypeCode());
/* 193 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 197 */     DiscountTypeEligibilityId id = new DiscountTypeEligibilityId();
/* 198 */     id.setDiscountCode(this._discountCode);
/* 199 */     id.setOrganizationId(this._organizationId);
/* 200 */     id.setSaleLineItemTypeCode(this._saleLineItemTypeCode);
/* 201 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 209 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 213 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\impl\DiscountTypeEligibilityDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */