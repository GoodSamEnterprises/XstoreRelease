/*    */ package dtv.xst.dao.crm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IGiftRegistryJournal extends IDataModel, IGiftRegistryJournalModel, IHasDataProperty<IGiftRegistryJournalProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_JOURNALSEQUENCE = new EventEnum("set journalSequence");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_REGISTRYID = new EventEnum("set registryId");
/* 16 */   public static final EventEnum SET_ACTIONCODE = new EventEnum("set actionCode");
/* 17 */   public static final EventEnum SET_REGISTRYSTATUS = new EventEnum("set registryStatus");
/* 18 */   public static final EventEnum SET_TRANSRETAILLOCATIONID = new EventEnum("set transRetailLocationId");
/* 19 */   public static final EventEnum SET_TRANSWORKSTATIONID = new EventEnum("set transWorkstationId");
/* 20 */   public static final EventEnum SET_TRANSBUSINESSDATE = new EventEnum("set transBusinessDate");
/* 21 */   public static final EventEnum SET_TRANSSEQUENCE = new EventEnum("set transSequence");
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
/*    */   long getJournalSequence();
/*    */   
/*    */   void setJournalSequence(long paramLong);
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
/*    */   long getRegistryId();
/*    */   
/*    */   void setRegistryId(long paramLong);
/*    */   
/*    */   String getActionCode();
/*    */   
/*    */   void setActionCode(String paramString);
/*    */   
/*    */   String getRegistryStatus();
/*    */   
/*    */   void setRegistryStatus(String paramString);
/*    */   
/*    */   long getTransRetailLocationId();
/*    */   
/*    */   void setTransRetailLocationId(long paramLong);
/*    */   
/*    */   long getTransWorkstationId();
/*    */   
/*    */   void setTransWorkstationId(long paramLong);
/*    */   
/*    */   Date getTransBusinessDate();
/*    */   
/*    */   void setTransBusinessDate(Date paramDate);
/*    */   
/*    */   long getTransSequence();
/*    */   
/*    */   void setTransSequence(long paramLong);
/*    */   
/*    */   IDataModel getGiftRegistryJournalExt();
/*    */   
/*    */   void setGiftRegistryJournalExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IGiftRegistryJournalProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IGiftRegistryJournalProperty> paramList);
/*    */   
/*    */   void addGiftRegistryJournalProperty(IGiftRegistryJournalProperty paramIGiftRegistryJournalProperty);
/*    */   
/*    */   void removeGiftRegistryJournalProperty(IGiftRegistryJournalProperty paramIGiftRegistryJournalProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\IGiftRegistryJournal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */