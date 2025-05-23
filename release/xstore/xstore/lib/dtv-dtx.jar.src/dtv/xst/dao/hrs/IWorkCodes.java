/*    */ package dtv.xst.dao.hrs;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.thr.IPayrollCategory;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IWorkCodes extends IDataModel, IWorkCodesModel, IHasDataProperty<IWorkCodesProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_WORKCODE = new EventEnum("set workCode");
/* 11 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 12 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 18 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 19 */   public static final EventEnum SET_SELLING = new EventEnum("set selling");
/* 20 */   public static final EventEnum SET_PRIVILEGE = new EventEnum("set privilege");
/* 21 */   public static final EventEnum SET_PAYROLLCATEGORYSTRING = new EventEnum("set payrollCategoryString");
/* 22 */   public static final EventEnum SET_MINIMUMCLOCKINDURATION = new EventEnum("set minimumClockInDuration");
/* 23 */   public static final EventEnum SET_MINIMUMCLOCKOUTDURATION = new EventEnum("set minimumClockOutDuration");
/* 24 */   public static final EventEnum SET_HIDDEN = new EventEnum("set hidden");
/* 25 */   public static final EventEnum SET_PAYROLLCATEGORY = new EventEnum("set PayrollCategory");
/* 26 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 27 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 28 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 29 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 30 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 31 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getWorkCode();
/*    */   
/*    */   void setWorkCode(String paramString);
/*    */   
/*    */   String getOrgCode();
/*    */   
/*    */   void setOrgCode(String paramString);
/*    */   
/*    */   String getOrgValue();
/*    */   
/*    */   void setOrgValue(String paramString);
/*    */   
/*    */   Date getCreateDate();
/*    */   
/*    */   void setCreateDate(Date paramDate);
/*    */   
/*    */   String getCreateUserId();
/*    */   
/*    */   void setCreateUserId(String paramString);
/*    */   
/*    */   Date getUpdateDate();
/*    */   
/*    */   void setUpdateDate(Date paramDate);
/*    */   
/*    */   String getUpdateUserId();
/*    */   
/*    */   void setUpdateUserId(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   int getSortOrder();
/*    */   
/*    */   void setSortOrder(int paramInt);
/*    */   
/*    */   boolean getSelling();
/*    */   
/*    */   void setSelling(boolean paramBoolean);
/*    */   
/*    */   String getPrivilege();
/*    */   
/*    */   void setPrivilege(String paramString);
/*    */   
/*    */   String getPayrollCategoryString();
/*    */   
/*    */   void setPayrollCategoryString(String paramString);
/*    */   
/*    */   int getMinimumClockInDuration();
/*    */   
/*    */   void setMinimumClockInDuration(int paramInt);
/*    */   
/*    */   int getMinimumClockOutDuration();
/*    */   
/*    */   void setMinimumClockOutDuration(int paramInt);
/*    */   
/*    */   boolean getHidden();
/*    */   
/*    */   void setHidden(boolean paramBoolean);
/*    */   
/*    */   IDataModel getWorkCodesExt();
/*    */   
/*    */   void setWorkCodesExt(IDataModel paramIDataModel);
/*    */   
/*    */   IPayrollCategory getPayrollCategory();
/*    */   
/*    */   void setPayrollCategory(IPayrollCategory paramIPayrollCategory);
/*    */   
/*    */   List<IWorkCodesProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IWorkCodesProperty> paramList);
/*    */   
/*    */   void addWorkCodesProperty(IWorkCodesProperty paramIWorkCodesProperty);
/*    */   
/*    */   void removeWorkCodesProperty(IWorkCodesProperty paramIWorkCodesProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\IWorkCodes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */