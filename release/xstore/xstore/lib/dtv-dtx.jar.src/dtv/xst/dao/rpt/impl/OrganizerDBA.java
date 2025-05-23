/*     */ package dtv.xst.dao.rpt.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.rpt.OrganizerId;
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
/*     */ public class OrganizerDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -137637105L;
/*     */   private Long _organizationId;
/*     */   private String _reportName;
/*     */   private String _reportGroup;
/*     */   private String _reportElement;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Integer _reportOrder;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.report_name, t.report_group, t.report_element, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.report_order FROM rpt_organizer t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND report_name = ?  AND report_group = ?  AND report_element = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  38 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  42 */     return "SELECT t.organization_id, t.report_name, t.report_group, t.report_element, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.report_order FROM rpt_organizer t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  48 */     return " WHERE organization_id = ?  AND report_name = ?  AND report_group = ?  AND report_element = ?  ";
/*     */   }
/*     */   
/*  51 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO rpt_organizer(organization_id, report_name, report_group, report_element, create_date, create_user_id, update_date, update_user_id, report_order) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  54 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  58 */     Object[][] insertParameterObject = { { this._organizationId, this._reportName, this._reportGroup, this._reportElement, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._reportOrder } };
/*  59 */     return insertParameterObject;
/*     */   }
/*     */   
/*  62 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 12, 91, 12, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  65 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  68 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE rpt_organizer SET update_date = ?, update_user_id = ?, report_order = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  71 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  75 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._reportOrder } };
/*  76 */     return updateParameterObject;
/*     */   }
/*     */   
/*  79 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  81 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  84 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM rpt_organizer" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND report_name = ?  AND report_group = ?  AND report_element = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  87 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  93 */     return " WHERE organization_id = ?  AND report_name = ?  AND report_group = ?  AND report_element = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  96 */     return new Object[] { this._organizationId, this._reportName, this._reportGroup, this._reportElement };
/*     */   }
/*     */   
/*  99 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 102 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 105 */     return "rpt_organizer";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 109 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 113 */     return new OrganizerFiller(this);
/*     */   }
/*     */   
/*     */   private static class OrganizerFiller
/*     */     implements IFiller {
/*     */     private OrganizerDBA _parent;
/*     */     
/*     */     public OrganizerFiller(OrganizerDBA argParent) {
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
/* 132 */       this._parent._reportName = argResultSet.getString(2);
/* 133 */       this._parent._reportGroup = argResultSet.getString(3);
/* 134 */       this._parent._reportElement = argResultSet.getString(4);
/*     */       
/* 136 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 137 */       if (t5 != null) {
/* 138 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 141 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 144 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 146 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 147 */       if (t7 != null) {
/* 148 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 154 */       this._parent._updateUserId = argResultSet.getString(8);
/*     */ 
/*     */       
/* 157 */       int i = argResultSet.getInt(9);
/* 158 */       if (i != 0 || argResultSet.getObject(9) != null) {
/* 159 */         this._parent._reportOrder = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 167 */     argDAO.suppressStateChanges(true);
/* 168 */     OrganizerDAO dao = (OrganizerDAO)argDAO;
/* 169 */     dao.setOrganizationId(this._organizationId);
/* 170 */     dao.setReportName(this._reportName);
/* 171 */     dao.setReportGroup(this._reportGroup);
/* 172 */     dao.setReportElement(this._reportElement);
/* 173 */     dao.setCreateDate(this._createDate);
/* 174 */     dao.setCreateUserId(this._createUserId);
/* 175 */     dao.setUpdateDate(this._updateDate);
/* 176 */     dao.setUpdateUserId(this._updateUserId);
/* 177 */     dao.setReportOrder(this._reportOrder);
/* 178 */     argDAO.suppressStateChanges(false);
/* 179 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 183 */     return loadDAO((IDataAccessObject)new OrganizerDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 187 */     OrganizerDAO dao = (OrganizerDAO)argDAO;
/* 188 */     this._organizationId = dao.getOrganizationId();
/* 189 */     this._reportName = dao.getReportName();
/* 190 */     this._reportGroup = dao.getReportGroup();
/* 191 */     this._reportElement = dao.getReportElement();
/* 192 */     this._createDate = dao.getCreateDate();
/* 193 */     this._createUserId = dao.getCreateUserId();
/* 194 */     this._updateDate = dao.getUpdateDate();
/* 195 */     this._updateUserId = dao.getUpdateUserId();
/* 196 */     this._reportOrder = dao.getReportOrder();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 200 */     OrganizerId id = (OrganizerId)argId;
/* 201 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 202 */     argStatement.setString(2, id.getReportName());
/* 203 */     argStatement.setString(3, id.getReportGroup());
/* 204 */     argStatement.setString(4, id.getReportElement());
/* 205 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 209 */     OrganizerId id = new OrganizerId();
/* 210 */     id.setOrganizationId(this._organizationId);
/* 211 */     id.setReportName(this._reportName);
/* 212 */     id.setReportGroup(this._reportGroup);
/* 213 */     id.setReportElement(this._reportElement);
/* 214 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 222 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 226 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\rpt\impl\OrganizerDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */