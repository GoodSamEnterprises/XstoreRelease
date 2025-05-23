/*    */ package dtv.xst.dao.prc;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDealFieldTest extends IDataModel, IDealFieldTestModel, IHasDataProperty<IDealFieldTestProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_DEALID = new EventEnum("set dealId");
/* 11 */   public static final EventEnum SET_ORDINAL = new EventEnum("set ordinal");
/* 12 */   public static final EventEnum SET_ITEMCONDITIONGROUP = new EventEnum("set itemConditionGroup");
/* 13 */   public static final EventEnum SET_ITEMCONDITIONSEQ = new EventEnum("set itemConditionSeq");
/* 14 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 15 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 16 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 17 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 18 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 19 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 20 */   public static final EventEnum SET_FIELD = new EventEnum("set field");
/* 21 */   public static final EventEnum SET_MATCHRULE = new EventEnum("set matchRule");
/* 22 */   public static final EventEnum SET_VALUE1 = new EventEnum("set value1");
/* 23 */   public static final EventEnum SET_VALUE2 = new EventEnum("set value2");
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
/*    */   String getDealId();
/*    */   
/*    */   void setDealId(String paramString);
/*    */   
/*    */   int getOrdinal();
/*    */   
/*    */   void setOrdinal(int paramInt);
/*    */   
/*    */   int getItemConditionGroup();
/*    */   
/*    */   void setItemConditionGroup(int paramInt);
/*    */   
/*    */   int getItemConditionSeq();
/*    */   
/*    */   void setItemConditionSeq(int paramInt);
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
/*    */   String getField();
/*    */   
/*    */   void setField(String paramString);
/*    */   
/*    */   String getMatchRule();
/*    */   
/*    */   void setMatchRule(String paramString);
/*    */   
/*    */   String getValue1();
/*    */   
/*    */   void setValue1(String paramString);
/*    */   
/*    */   String getValue2();
/*    */   
/*    */   void setValue2(String paramString);
/*    */   
/*    */   IDataModel getDealFieldTestExt();
/*    */   
/*    */   void setDealFieldTestExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IDealFieldTestProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDealFieldTestProperty> paramList);
/*    */   
/*    */   void addDealFieldTestProperty(IDealFieldTestProperty paramIDealFieldTestProperty);
/*    */   
/*    */   void removeDealFieldTestProperty(IDealFieldTestProperty paramIDealFieldTestProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\IDealFieldTest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */