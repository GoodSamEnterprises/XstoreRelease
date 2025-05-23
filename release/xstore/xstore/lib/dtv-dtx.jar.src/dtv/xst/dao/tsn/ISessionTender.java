/*    */ package dtv.xst.dao.tsn;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ISessionTender extends IDataModel, IHasDataProperty<ISessionTenderProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_SESSIONID = new EventEnum("set sessionId");
/* 12 */   public static final EventEnum SET_TENDERID = new EventEnum("set tenderId");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_MEDIAAMOUNT = new EventEnum("set mediaAmount");
/* 18 */   public static final EventEnum SET_MEDIACOUNT = new EventEnum("set mediaCount");
/* 19 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 20 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 21 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 22 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 23 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 24 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   long getSessionId();
/*    */   
/*    */   void setSessionId(long paramLong);
/*    */   
/*    */   String getTenderId();
/*    */   
/*    */   void setTenderId(String paramString);
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
/*    */   BigDecimal getMediaAmount();
/*    */   
/*    */   void setMediaAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   int getMediaCount();
/*    */   
/*    */   void setMediaCount(int paramInt);
/*    */   
/*    */   IDataModel getSessionTenderExt();
/*    */   
/*    */   void setSessionTenderExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ISessionTenderProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ISessionTenderProperty> paramList);
/*    */   
/*    */   void addSessionTenderProperty(ISessionTenderProperty paramISessionTenderProperty);
/*    */   
/*    */   void removeSessionTenderProperty(ISessionTenderProperty paramISessionTenderProperty);
/*    */   
/*    */   void setParentSession(ISession paramISession);
/*    */   
/*    */   ISession getParentSession();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\ISessionTender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */