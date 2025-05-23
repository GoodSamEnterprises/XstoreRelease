/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IItemRestrictionCalendar extends IDataModel, IHasDataProperty<IItemRestrictionCalendarProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RESTRICTIONCATEGORY = new EventEnum("set restrictionCategory");
/* 11 */   public static final EventEnum SET_RESTRICTIONCODE = new EventEnum("set restrictionCode");
/* 12 */   public static final EventEnum SET_DAYCODE = new EventEnum("set dayCode");
/* 13 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 14 */   public static final EventEnum SET_STARTTIME = new EventEnum("set startTime");
/* 15 */   public static final EventEnum SET_SALELINEITEMTYPECODE = new EventEnum("set saleLineItemTypeCode");
/* 16 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 17 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 18 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 19 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 20 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 21 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 22 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 23 */   public static final EventEnum SET_ENDTIME = new EventEnum("set endTime");
/* 24 */   public static final EventEnum SET_EXEMPTION = new EventEnum("set exemption");
/* 25 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 26 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 27 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 28 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 29 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 30 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getRestrictionCategory();
/*    */   
/*    */   void setRestrictionCategory(String paramString);
/*    */   
/*    */   String getRestrictionCode();
/*    */   
/*    */   void setRestrictionCode(String paramString);
/*    */   
/*    */   String getDayCode();
/*    */   
/*    */   void setDayCode(String paramString);
/*    */   
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
/*    */   
/*    */   Date getStartTime();
/*    */   
/*    */   void setStartTime(Date paramDate);
/*    */   
/*    */   String getSaleLineItemTypeCode();
/*    */   
/*    */   void setSaleLineItemTypeCode(String paramString);
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
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   Date getEndTime();
/*    */   
/*    */   void setEndTime(Date paramDate);
/*    */   
/*    */   boolean getExemption();
/*    */   
/*    */   void setExemption(boolean paramBoolean);
/*    */   
/*    */   IDataModel getItemRestrictionCalendarExt();
/*    */   
/*    */   void setItemRestrictionCalendarExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IItemRestrictionCalendarProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IItemRestrictionCalendarProperty> paramList);
/*    */   
/*    */   void addItemRestrictionCalendarProperty(IItemRestrictionCalendarProperty paramIItemRestrictionCalendarProperty);
/*    */   
/*    */   void removeItemRestrictionCalendarProperty(IItemRestrictionCalendarProperty paramIItemRestrictionCalendarProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IItemRestrictionCalendar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */