/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.CustomerConsentInfoId;
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
/*     */ 
/*     */ public class CustomerConsentInfoDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1453591286L;
/*     */   private Long _organizationId;
/*     */   private Date _effectiveDate;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _termsAndConditions;
/*     */   private String _consent1Text;
/*     */   private String _consent2Text;
/*     */   private String _consent3Text;
/*     */   private String _consent4Text;
/*     */   private String _consent5Text;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.effective_date, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.terms_and_conditions, t.consent1_text, t.consent2_text, t.consent3_text, t.consent4_text, t.consent5_text FROM crm_consent_info t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND effective_date = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.effective_date, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.terms_and_conditions, t.consent1_text, t.consent2_text, t.consent3_text, t.consent4_text, t.consent5_text FROM crm_consent_info t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND effective_date = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO crm_consent_info(organization_id, effective_date, create_date, create_user_id, update_date, update_user_id, terms_and_conditions, consent1_text, consent2_text, consent3_text, consent4_text, consent5_text) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._effectiveDate, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._termsAndConditions, this._consent1Text, this._consent2Text, this._consent3Text, this._consent4Text, this._consent5Text } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 91, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE crm_consent_info SET update_date = ?, update_user_id = ?, terms_and_conditions = ?, consent1_text = ?, consent2_text = ?, consent3_text = ?, consent4_text = ?, consent5_text = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._termsAndConditions, this._consent1Text, this._consent2Text, this._consent3Text, this._consent4Text, this._consent5Text } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM crm_consent_info" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND effective_date = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND effective_date = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._effectiveDate };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 91 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "crm_consent_info";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new CustomerConsentInfoFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerConsentInfoFiller
/*     */     implements IFiller {
/*     */     private CustomerConsentInfoDBA _parent;
/*     */     
/*     */     public CustomerConsentInfoFiller(CustomerConsentInfoDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       long primitiveResult = argResultSet.getLong(1);
/* 130 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 136 */       Timestamp t2 = argResultSet.getTimestamp(2);
/* 137 */       if (t2 != null) {
/* 138 */         this._parent._effectiveDate = (Date)new DtvDate(t2.getTime());
/*     */       } else {
/*     */         
/* 141 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 145 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 146 */       if (t3 != null) {
/* 147 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 155 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 156 */       if (t5 != null) {
/* 157 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._updateUserId = argResultSet.getString(6);
/* 164 */       this._parent._termsAndConditions = argResultSet.getString(7);
/* 165 */       this._parent._consent1Text = argResultSet.getString(8);
/* 166 */       this._parent._consent2Text = argResultSet.getString(9);
/* 167 */       this._parent._consent3Text = argResultSet.getString(10);
/* 168 */       this._parent._consent4Text = argResultSet.getString(11);
/* 169 */       this._parent._consent5Text = argResultSet.getString(12);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 174 */     argDAO.suppressStateChanges(true);
/* 175 */     CustomerConsentInfoDAO dao = (CustomerConsentInfoDAO)argDAO;
/* 176 */     dao.setOrganizationId(this._organizationId);
/* 177 */     dao.setEffectiveDate(this._effectiveDate);
/* 178 */     dao.setCreateDate(this._createDate);
/* 179 */     dao.setCreateUserId(this._createUserId);
/* 180 */     dao.setUpdateDate(this._updateDate);
/* 181 */     dao.setUpdateUserId(this._updateUserId);
/* 182 */     dao.setTermsAndConditions(this._termsAndConditions);
/* 183 */     dao.setConsent1Text(this._consent1Text);
/* 184 */     dao.setConsent2Text(this._consent2Text);
/* 185 */     dao.setConsent3Text(this._consent3Text);
/* 186 */     dao.setConsent4Text(this._consent4Text);
/* 187 */     dao.setConsent5Text(this._consent5Text);
/* 188 */     argDAO.suppressStateChanges(false);
/* 189 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 193 */     return loadDAO((IDataAccessObject)new CustomerConsentInfoDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 197 */     CustomerConsentInfoDAO dao = (CustomerConsentInfoDAO)argDAO;
/* 198 */     this._organizationId = dao.getOrganizationId();
/* 199 */     this._effectiveDate = dao.getEffectiveDate();
/* 200 */     this._createDate = dao.getCreateDate();
/* 201 */     this._createUserId = dao.getCreateUserId();
/* 202 */     this._updateDate = dao.getUpdateDate();
/* 203 */     this._updateUserId = dao.getUpdateUserId();
/* 204 */     this._termsAndConditions = dao.getTermsAndConditions();
/* 205 */     this._consent1Text = dao.getConsent1Text();
/* 206 */     this._consent2Text = dao.getConsent2Text();
/* 207 */     this._consent3Text = dao.getConsent3Text();
/* 208 */     this._consent4Text = dao.getConsent4Text();
/* 209 */     this._consent5Text = dao.getConsent5Text();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 213 */     CustomerConsentInfoId id = (CustomerConsentInfoId)argId;
/* 214 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 215 */     argStatement.setTimestamp(2, new Timestamp(id.getEffectiveDate().getTime()));
/* 216 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 220 */     CustomerConsentInfoId id = new CustomerConsentInfoId();
/* 221 */     id.setOrganizationId(this._organizationId);
/* 222 */     id.setEffectiveDate(this._effectiveDate);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\CustomerConsentInfoDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */