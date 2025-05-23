/*    */ package dtv.xst.dao.tsn;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITenderRepository extends IDataModel, ITenderRepositoryModel, IHasDataProperty<ITenderRepositoryProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_TENDERREPOSITORYID = new EventEnum("set tenderRepositoryId");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 17 */   public static final EventEnum SET_NAME = new EventEnum("set name");
/* 18 */   public static final EventEnum SET_NOTISSUABLE = new EventEnum("set notIssuable");
/* 19 */   public static final EventEnum SET_TYPECODE = new EventEnum("set typeCode");
/* 20 */   public static final EventEnum SET_DEFAULTWORKSTATIONID = new EventEnum("set defaultWorkstationId");
/* 21 */   public static final EventEnum ADD_TENDERREPOSITORYFLOAT = new EventEnum("add TenderRepositoryFloat");
/* 22 */   public static final EventEnum REMOVE_TENDERREPOSITORYFLOAT = new EventEnum("remove TenderRepositoryFloat");
/* 23 */   public static final EventEnum SET_TENDERREPOSITORYFLOAT = new EventEnum("set TenderRepositoryFloat");
/* 24 */   public static final EventEnum SET_TENDERREPOSITORYSTATUS = new EventEnum("set TenderRepositoryStatus");
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
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   String getTenderRepositoryId();
/*    */   
/*    */   void setTenderRepositoryId(String paramString);
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
/*    */   String getName();
/*    */   
/*    */   void setName(String paramString);
/*    */   
/*    */   boolean getNotIssuable();
/*    */   
/*    */   void setNotIssuable(boolean paramBoolean);
/*    */   
/*    */   String getTypeCode();
/*    */   
/*    */   void setTypeCode(String paramString);
/*    */   
/*    */   long getDefaultWorkstationId();
/*    */   
/*    */   void setDefaultWorkstationId(long paramLong);
/*    */   
/*    */   IDataModel getTenderRepositoryExt();
/*    */   
/*    */   void setTenderRepositoryExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ITenderRepositoryFloat> getTenderRepositoryFloat();
/*    */   
/*    */   void setTenderRepositoryFloat(List<ITenderRepositoryFloat> paramList);
/*    */   
/*    */   void addTenderRepositoryFloat(ITenderRepositoryFloat paramITenderRepositoryFloat);
/*    */   
/*    */   void removeTenderRepositoryFloat(ITenderRepositoryFloat paramITenderRepositoryFloat);
/*    */   
/*    */   ITenderRepositoryStatus getTenderRepositoryStatus();
/*    */   
/*    */   void setTenderRepositoryStatus(ITenderRepositoryStatus paramITenderRepositoryStatus);
/*    */   
/*    */   List<ITenderRepositoryProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITenderRepositoryProperty> paramList);
/*    */   
/*    */   void addTenderRepositoryProperty(ITenderRepositoryProperty paramITenderRepositoryProperty);
/*    */   
/*    */   void removeTenderRepositoryProperty(ITenderRepositoryProperty paramITenderRepositoryProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\ITenderRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */