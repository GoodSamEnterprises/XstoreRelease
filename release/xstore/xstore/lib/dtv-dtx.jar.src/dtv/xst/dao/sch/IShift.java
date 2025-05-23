/*    */ package dtv.xst.dao.sch;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IShift extends IDataModel, IHasDataProperty<IShiftProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_SHIFTID = new EventEnum("set shiftId");
/* 11 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 12 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_NAME = new EventEnum("set name");
/* 18 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 19 */   public static final EventEnum SET_WORKCODE = new EventEnum("set workCode");
/* 20 */   public static final EventEnum SET_STARTTIME = new EventEnum("set startTime");
/* 21 */   public static final EventEnum SET_ENDTIME = new EventEnum("set endTime");
/* 22 */   public static final EventEnum SET_VOID = new EventEnum("set void");
/* 23 */   public static final EventEnum SET_BREAKDURATION = new EventEnum("set breakDuration");
/* 24 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 25 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 26 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 27 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 28 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 29 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getShiftId();
/*    */   
/*    */   void setShiftId(long paramLong);
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
/*    */   String getName();
/*    */   
/*    */   void setName(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   String getWorkCode();
/*    */   
/*    */   void setWorkCode(String paramString);
/*    */   
/*    */   Date getStartTime();
/*    */   
/*    */   void setStartTime(Date paramDate);
/*    */   
/*    */   Date getEndTime();
/*    */   
/*    */   void setEndTime(Date paramDate);
/*    */   
/*    */   boolean getVoid();
/*    */   
/*    */   void setVoid(boolean paramBoolean);
/*    */   
/*    */   long getBreakDuration();
/*    */   
/*    */   void setBreakDuration(long paramLong);
/*    */   
/*    */   IDataModel getShiftExt();
/*    */   
/*    */   void setShiftExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IShiftProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IShiftProperty> paramList);
/*    */   
/*    */   void addShiftProperty(IShiftProperty paramIShiftProperty);
/*    */   
/*    */   void removeShiftProperty(IShiftProperty paramIShiftProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sch\IShift.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */