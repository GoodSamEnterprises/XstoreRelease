/*    */ package dtv.xst.dao.tnd;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITenderUserSettings extends IDataModel, IHasConfigElement, IHasDataProperty<ITenderUserSettingsProperty> {
/*  9 */   public static final EventEnum SET_GROUPID = new EventEnum("set groupId");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_TENDERID = new EventEnum("set tenderId");
/* 12 */   public static final EventEnum SET_USAGECODE = new EventEnum("set usageCode");
/* 13 */   public static final EventEnum SET_ENTRYMETHODCODE = new EventEnum("set entryMethodCode");
/* 14 */   public static final EventEnum SET_CONFIGELEMENT = new EventEnum("set configElement");
/* 15 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 16 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 17 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 18 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 19 */   public static final EventEnum SET_MAXIMUMACCEPTAMOUNT = new EventEnum("set maximumAcceptAmount");
/* 20 */   public static final EventEnum SET_MINIMUMACCEPTAMOUNT = new EventEnum("set minimumAcceptAmount");
/* 21 */   public static final EventEnum SET_OFFLINECEILINGAPPROVALAMOUNT = new EventEnum("set offlineCeilingApprovalAmount");
/* 22 */   public static final EventEnum SET_OFFLINEFLOORAPPROVALAMOUNT = new EventEnum("set offlineFloorApprovalAmount");
/* 23 */   public static final EventEnum SET_ONLINECEILINGAPPROVALAMOUNT = new EventEnum("set onlineCeilingApprovalAmount");
/* 24 */   public static final EventEnum SET_ONLINEFLOORAPPROVALAMOUNT = new EventEnum("set onlineFloorApprovalAmount");
/* 25 */   public static final EventEnum SET_OVERTENDERLIMIT = new EventEnum("set overTenderLimit");
/* 26 */   public static final EventEnum SET_MAXIMUMREFUNDWITHRECEIPTAMOUNT = new EventEnum("set maximumRefundWithReceiptAmount");
/* 27 */   public static final EventEnum SET_MAXIMUMREFUNDWITHOUTRECEIPTAMOUNT = new EventEnum("set maximumRefundWithoutReceiptAmount");
/* 28 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 29 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 30 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 31 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 32 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 33 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getGroupId();
/*    */   
/*    */   void setGroupId(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getTenderId();
/*    */   
/*    */   void setTenderId(String paramString);
/*    */   
/*    */   String getUsageCode();
/*    */   
/*    */   void setUsageCode(String paramString);
/*    */   
/*    */   String getEntryMethodCode();
/*    */   
/*    */   void setEntryMethodCode(String paramString);
/*    */   
/*    */   String getConfigElement();
/*    */   
/*    */   void setConfigElement(String paramString);
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
/*    */   BigDecimal getMaximumAcceptAmount();
/*    */   
/*    */   void setMaximumAcceptAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getMinimumAcceptAmount();
/*    */   
/*    */   void setMinimumAcceptAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getOfflineCeilingApprovalAmount();
/*    */   
/*    */   void setOfflineCeilingApprovalAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getOfflineFloorApprovalAmount();
/*    */   
/*    */   void setOfflineFloorApprovalAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getOnlineCeilingApprovalAmount();
/*    */   
/*    */   void setOnlineCeilingApprovalAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getOnlineFloorApprovalAmount();
/*    */   
/*    */   void setOnlineFloorApprovalAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getOverTenderLimit();
/*    */   
/*    */   void setOverTenderLimit(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getMaximumRefundWithReceiptAmount();
/*    */   
/*    */   void setMaximumRefundWithReceiptAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getMaximumRefundWithoutReceiptAmount();
/*    */   
/*    */   void setMaximumRefundWithoutReceiptAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getTenderUserSettingsExt();
/*    */   
/*    */   void setTenderUserSettingsExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ITenderUserSettingsProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITenderUserSettingsProperty> paramList);
/*    */   
/*    */   void addTenderUserSettingsProperty(ITenderUserSettingsProperty paramITenderUserSettingsProperty);
/*    */   
/*    */   void removeTenderUserSettingsProperty(ITenderUserSettingsProperty paramITenderUserSettingsProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\ITenderUserSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */