/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.CustomizationModifierId;
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
/*     */ public class CustomizationModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1871520854L;
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private Integer _sequence;
/*     */   private Integer _modSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _customizationCode;
/*     */   private String _customizationMessage;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.order_id, t.detail_seq, t.mod_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.customization_code, t.customization_message FROM xom_customization_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  AND mod_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.order_id, t.detail_seq, t.mod_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.customization_code, t.customization_message FROM xom_customization_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  AND mod_seq = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO xom_customization_mod(organization_id, order_id, detail_seq, mod_seq, create_date, create_user_id, update_date, update_user_id, customization_code, customization_message) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._orderId, this._sequence, this._modSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._customizationCode, this._customizationMessage } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 4, 91, 12, 91, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE xom_customization_mod SET update_date = ?, update_user_id = ?, customization_code = ?, customization_message = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._customizationCode, this._customizationMessage } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM xom_customization_mod" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  AND mod_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  AND mod_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._orderId, this._sequence, this._modSequence };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "xom_customization_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new CustomizationModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomizationModifierFiller
/*     */     implements IFiller {
/*     */     private CustomizationModifierDBA _parent;
/*     */     
/*     */     public CustomizationModifierFiller(CustomizationModifierDBA argParent) {
/* 122 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 127 */       long l = argResultSet.getLong(1);
/* 128 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 129 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 133 */       this._parent._orderId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 136 */       int primitiveResult = argResultSet.getInt(3);
/* 137 */       if (primitiveResult != 0 || argResultSet.getObject(3) != null) {
/* 138 */         this._parent._sequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 144 */       primitiveResult = argResultSet.getInt(4);
/* 145 */       if (primitiveResult != 0 || argResultSet.getObject(4) != null) {
/* 146 */         this._parent._modSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 151 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 152 */       if (t5 != null) {
/* 153 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 159 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 161 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 162 */       if (t7 != null) {
/* 163 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 166 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 169 */       this._parent._updateUserId = argResultSet.getString(8);
/* 170 */       this._parent._customizationCode = argResultSet.getString(9);
/* 171 */       this._parent._customizationMessage = argResultSet.getString(10);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 176 */     argDAO.suppressStateChanges(true);
/* 177 */     CustomizationModifierDAO dao = (CustomizationModifierDAO)argDAO;
/* 178 */     dao.setOrganizationId(this._organizationId);
/* 179 */     dao.setOrderId(this._orderId);
/* 180 */     dao.setSequence(this._sequence);
/* 181 */     dao.setModSequence(this._modSequence);
/* 182 */     dao.setCreateDate(this._createDate);
/* 183 */     dao.setCreateUserId(this._createUserId);
/* 184 */     dao.setUpdateDate(this._updateDate);
/* 185 */     dao.setUpdateUserId(this._updateUserId);
/* 186 */     dao.setCustomizationCode(this._customizationCode);
/* 187 */     dao.setCustomizationMessage(this._customizationMessage);
/* 188 */     argDAO.suppressStateChanges(false);
/* 189 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 193 */     return loadDAO((IDataAccessObject)new CustomizationModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 197 */     CustomizationModifierDAO dao = (CustomizationModifierDAO)argDAO;
/* 198 */     this._organizationId = dao.getOrganizationId();
/* 199 */     this._orderId = dao.getOrderId();
/* 200 */     this._sequence = dao.getSequence();
/* 201 */     this._modSequence = dao.getModSequence();
/* 202 */     this._createDate = dao.getCreateDate();
/* 203 */     this._createUserId = dao.getCreateUserId();
/* 204 */     this._updateDate = dao.getUpdateDate();
/* 205 */     this._updateUserId = dao.getUpdateUserId();
/* 206 */     this._customizationCode = dao.getCustomizationCode();
/* 207 */     this._customizationMessage = dao.getCustomizationMessage();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 211 */     CustomizationModifierId id = (CustomizationModifierId)argId;
/* 212 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 213 */     argStatement.setString(2, id.getOrderId());
/* 214 */     argStatement.setInt(3, id.getSequence().intValue());
/* 215 */     argStatement.setInt(4, id.getModSequence().intValue());
/* 216 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 220 */     CustomizationModifierId id = new CustomizationModifierId();
/* 221 */     id.setOrganizationId(this._organizationId);
/* 222 */     id.setOrderId(this._orderId);
/* 223 */     id.setSequence(this._sequence);
/* 224 */     id.setModSequence(this._modSequence);
/* 225 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 233 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 237 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\CustomizationModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */