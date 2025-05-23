/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ISubstituteItems extends IDataModel, IHasDataProperty<ISubstituteItemsProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_PRIMARYITEMID = new EventEnum("set primaryItemId");
/* 11 */   public static final EventEnum SET_SUBSTITUTEITEMID = new EventEnum("set substituteItemId");
/* 12 */   public static final EventEnum SET_LEVELCODE = new EventEnum("set levelCode");
/* 13 */   public static final EventEnum SET_LEVELVALUE = new EventEnum("set levelValue");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_BEGINDATETIME = new EventEnum("set beginDatetime");
/* 19 */   public static final EventEnum SET_ENDDATETIME = new EventEnum("set endDatetime");
/* 20 */   public static final EventEnum SET_EXTERNALID = new EventEnum("set externalId");
/* 21 */   public static final EventEnum SET_EXTERNALSYSTEM = new EventEnum("set externalSystem");
/* 22 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 23 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 24 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 25 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 26 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 27 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getPrimaryItemId();
/*    */   
/*    */   void setPrimaryItemId(String paramString);
/*    */   
/*    */   String getSubstituteItemId();
/*    */   
/*    */   void setSubstituteItemId(String paramString);
/*    */   
/*    */   String getLevelCode();
/*    */   
/*    */   void setLevelCode(String paramString);
/*    */   
/*    */   String getLevelValue();
/*    */   
/*    */   void setLevelValue(String paramString);
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
/*    */   Date getBeginDatetime();
/*    */   
/*    */   void setBeginDatetime(Date paramDate);
/*    */   
/*    */   Date getEndDatetime();
/*    */   
/*    */   void setEndDatetime(Date paramDate);
/*    */   
/*    */   String getExternalId();
/*    */   
/*    */   void setExternalId(String paramString);
/*    */   
/*    */   String getExternalSystem();
/*    */   
/*    */   void setExternalSystem(String paramString);
/*    */   
/*    */   IDataModel getSubstituteItemsExt();
/*    */   
/*    */   void setSubstituteItemsExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ISubstituteItemsProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ISubstituteItemsProperty> paramList);
/*    */   
/*    */   void addSubstituteItemsProperty(ISubstituteItemsProperty paramISubstituteItemsProperty);
/*    */   
/*    */   void removeSubstituteItemsProperty(ISubstituteItemsProperty paramISubstituteItemsProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ISubstituteItems.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */