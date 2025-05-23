/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.CustomerModifierId;
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
/*     */ public class CustomerModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1501991691L;
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _customerId;
/*     */   private String _organizationName;
/*     */   private String _salutation;
/*     */   private String _firstName;
/*     */   private String _middleName;
/*     */   private String _lastName;
/*     */   private String _suffix;
/*     */   private String _telephone1;
/*     */   private String _telephone2;
/*     */   private String _emailAddress;
/*     */   private Long _addressSequence;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.order_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.customer_id, t.organization_name, t.salutation, t.first_name, t.middle_name, t.last_name, t.suffix, t.telephone1, t.telephone2, t.email_address, t.address_seq FROM xom_customer_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.organization_id, t.order_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.customer_id, t.organization_name, t.salutation, t.first_name, t.middle_name, t.last_name, t.suffix, t.telephone1, t.telephone2, t.email_address, t.address_seq FROM xom_customer_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  56 */     return " WHERE organization_id = ?  AND order_id = ?  ";
/*     */   }
/*     */   
/*  59 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO xom_customer_mod(organization_id, order_id, create_date, create_user_id, update_date, update_user_id, customer_id, organization_name, salutation, first_name, middle_name, last_name, suffix, telephone1, telephone2, email_address, address_seq) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  62 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._organizationId, this._orderId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._customerId, this._organizationName, this._salutation, this._firstName, this._middleName, this._lastName, this._suffix, this._telephone1, this._telephone2, this._emailAddress, this._addressSequence } };
/*  67 */     return insertParameterObject;
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE xom_customer_mod SET update_date = ?, update_user_id = ?, customer_id = ?, organization_name = ?, salutation = ?, first_name = ?, middle_name = ?, last_name = ?, suffix = ?, telephone1 = ?, telephone2 = ?, email_address = ?, address_seq = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  83 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._customerId, this._organizationName, this._salutation, this._firstName, this._middleName, this._lastName, this._suffix, this._telephone1, this._telephone2, this._emailAddress, this._addressSequence } };
/*  84 */     return updateParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM xom_customer_mod" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  95 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 101 */     return " WHERE organization_id = ?  AND order_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 104 */     return new Object[] { this._organizationId, this._orderId };
/*     */   }
/*     */   
/* 107 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 110 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 113 */     return "xom_customer_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 117 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 121 */     return new CustomerModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerModifierFiller
/*     */     implements IFiller {
/*     */     private CustomerModifierDBA _parent;
/*     */     
/*     */     public CustomerModifierFiller(CustomerModifierDBA argParent) {
/* 129 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 134 */       long primitiveResult = argResultSet.getLong(1);
/* 135 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 136 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 140 */       this._parent._orderId = argResultSet.getString(2);
/*     */       
/* 142 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 143 */       if (t3 != null) {
/* 144 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 147 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 150 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 152 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 153 */       if (t5 != null) {
/* 154 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._updateUserId = argResultSet.getString(6);
/* 161 */       this._parent._customerId = argResultSet.getString(7);
/* 162 */       this._parent._organizationName = argResultSet.getString(8);
/* 163 */       this._parent._salutation = argResultSet.getString(9);
/* 164 */       this._parent._firstName = argResultSet.getString(10);
/* 165 */       this._parent._middleName = argResultSet.getString(11);
/* 166 */       this._parent._lastName = argResultSet.getString(12);
/* 167 */       this._parent._suffix = argResultSet.getString(13);
/* 168 */       this._parent._telephone1 = argResultSet.getString(14);
/* 169 */       this._parent._telephone2 = argResultSet.getString(15);
/* 170 */       this._parent._emailAddress = argResultSet.getString(16);
/*     */ 
/*     */       
/* 173 */       long l1 = argResultSet.getLong(17);
/* 174 */       if (l1 != 0L || argResultSet.getObject(17) != null) {
/* 175 */         this._parent._addressSequence = Long.valueOf(l1);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 183 */     argDAO.suppressStateChanges(true);
/* 184 */     CustomerModifierDAO dao = (CustomerModifierDAO)argDAO;
/* 185 */     dao.setOrganizationId(this._organizationId);
/* 186 */     dao.setOrderId(this._orderId);
/* 187 */     dao.setCreateDate(this._createDate);
/* 188 */     dao.setCreateUserId(this._createUserId);
/* 189 */     dao.setUpdateDate(this._updateDate);
/* 190 */     dao.setUpdateUserId(this._updateUserId);
/* 191 */     dao.setCustomerId(this._customerId);
/* 192 */     dao.setOrganizationName(this._organizationName);
/* 193 */     dao.setSalutation(this._salutation);
/* 194 */     dao.setFirstName(this._firstName);
/* 195 */     dao.setMiddleName(this._middleName);
/* 196 */     dao.setLastName(this._lastName);
/* 197 */     dao.setSuffix(this._suffix);
/* 198 */     dao.setTelephone1(this._telephone1);
/* 199 */     dao.setTelephone2(this._telephone2);
/* 200 */     dao.setEmailAddress(this._emailAddress);
/* 201 */     dao.setAddressSequence(this._addressSequence);
/* 202 */     argDAO.suppressStateChanges(false);
/* 203 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 207 */     return loadDAO((IDataAccessObject)new CustomerModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 211 */     CustomerModifierDAO dao = (CustomerModifierDAO)argDAO;
/* 212 */     this._organizationId = dao.getOrganizationId();
/* 213 */     this._orderId = dao.getOrderId();
/* 214 */     this._createDate = dao.getCreateDate();
/* 215 */     this._createUserId = dao.getCreateUserId();
/* 216 */     this._updateDate = dao.getUpdateDate();
/* 217 */     this._updateUserId = dao.getUpdateUserId();
/* 218 */     this._customerId = dao.getCustomerId();
/* 219 */     this._organizationName = dao.getOrganizationName();
/* 220 */     this._salutation = dao.getSalutation();
/* 221 */     this._firstName = dao.getFirstName();
/* 222 */     this._middleName = dao.getMiddleName();
/* 223 */     this._lastName = dao.getLastName();
/* 224 */     this._suffix = dao.getSuffix();
/* 225 */     this._telephone1 = dao.getTelephone1();
/* 226 */     this._telephone2 = dao.getTelephone2();
/* 227 */     this._emailAddress = dao.getEmailAddress();
/* 228 */     this._addressSequence = dao.getAddressSequence();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 232 */     CustomerModifierId id = (CustomerModifierId)argId;
/* 233 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 234 */     argStatement.setString(2, id.getOrderId());
/* 235 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 239 */     CustomerModifierId id = new CustomerModifierId();
/* 240 */     id.setOrganizationId(this._organizationId);
/* 241 */     id.setOrderId(this._orderId);
/* 242 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 250 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 254 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\CustomerModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */