/*    */ package dtv.xst.dao.tax;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITaxTaxGroupMapping extends IDataModel, IHasDataProperty<ITaxTaxGroupMappingProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CUSTOMERGROUP = new EventEnum("set customerGroup");
/* 11 */   public static final EventEnum SET_TAXGROUPID = new EventEnum("set taxGroupId");
/* 12 */   public static final EventEnum SET_RTLLOCID = new EventEnum("set rtlLocId");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_PRIORITY = new EventEnum("set priority");
/* 18 */   public static final EventEnum SET_NEWTAXGROUPID = new EventEnum("set newTaxGroupId");
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
/*    */   String getCustomerGroup();
/*    */   
/*    */   void setCustomerGroup(String paramString);
/*    */   
/*    */   String getTaxGroupId();
/*    */   
/*    */   void setTaxGroupId(String paramString);
/*    */   
/*    */   int getRtlLocId();
/*    */   
/*    */   void setRtlLocId(int paramInt);
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
/*    */   int getPriority();
/*    */   
/*    */   void setPriority(int paramInt);
/*    */   
/*    */   String getNewTaxGroupId();
/*    */   
/*    */   void setNewTaxGroupId(String paramString);
/*    */   
/*    */   IDataModel getTaxTaxGroupMappingExt();
/*    */   
/*    */   void setTaxTaxGroupMappingExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ITaxTaxGroupMappingProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITaxTaxGroupMappingProperty> paramList);
/*    */   
/*    */   void addTaxTaxGroupMappingProperty(ITaxTaxGroupMappingProperty paramITaxTaxGroupMappingProperty);
/*    */   
/*    */   void removeTaxTaxGroupMappingProperty(ITaxTaxGroupMappingProperty paramITaxTaxGroupMappingProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\ITaxTaxGroupMapping.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */