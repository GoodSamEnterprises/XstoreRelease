/*    */ package dtv.xst.dao.com;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IButtonGrid extends IDataModel, IHasDataProperty<IButtonGridProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_LEVELCODE = new EventEnum("set levelCode");
/* 11 */   public static final EventEnum SET_LEVELVALUE = new EventEnum("set levelValue");
/* 12 */   public static final EventEnum SET_GRIDID = new EventEnum("set gridId");
/* 13 */   public static final EventEnum SET_ROWID = new EventEnum("set rowId");
/* 14 */   public static final EventEnum SET_COLUMNID = new EventEnum("set columnId");
/* 15 */   public static final EventEnum SET_COMPONENTID = new EventEnum("set componentId");
/* 16 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 17 */   public static final EventEnum SET_CHILDID = new EventEnum("set childId");
/* 18 */   public static final EventEnum SET_KEYNAME = new EventEnum("set keyName");
/* 19 */   public static final EventEnum SET_DATA = new EventEnum("set data");
/* 20 */   public static final EventEnum SET_TEXT = new EventEnum("set text");
/* 21 */   public static final EventEnum SET_TEXTX = new EventEnum("set textX");
/* 22 */   public static final EventEnum SET_TEXTY = new EventEnum("set textY");
/* 23 */   public static final EventEnum SET_IMAGEFILENAME = new EventEnum("set imageFilename");
/* 24 */   public static final EventEnum SET_IMAGEX = new EventEnum("set imageX");
/* 25 */   public static final EventEnum SET_IMAGEY = new EventEnum("set imageY");
/* 26 */   public static final EventEnum SET_VISIBILITYRULE = new EventEnum("set visibilityRule");
/* 27 */   public static final EventEnum SET_HEIGHTSPAN = new EventEnum("set heightSpan");
/* 28 */   public static final EventEnum SET_WIDTHSPAN = new EventEnum("set widthSpan");
/* 29 */   public static final EventEnum SET_BACKGROUNDRGB = new EventEnum("set backgroundRgb");
/* 30 */   public static final EventEnum SET_FOREGROUNDRGB = new EventEnum("set foregroundRgb");
/* 31 */   public static final EventEnum SET_BUTTONSTYLE = new EventEnum("set buttonStyle");
/* 32 */   public static final EventEnum SET_ACTIONIDX = new EventEnum("set actionIdx");
/* 33 */   public static final EventEnum SET_ANIMATIONIDX = new EventEnum("set animationIdx");
/* 34 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 35 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 36 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 37 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 38 */   public static final EventEnum SET_RECORDSTATE = new EventEnum("set recordState");
/* 39 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 40 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 41 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 42 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 43 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 44 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getLevelCode();
/*    */   
/*    */   void setLevelCode(String paramString);
/*    */   
/*    */   String getLevelValue();
/*    */   
/*    */   void setLevelValue(String paramString);
/*    */   
/*    */   String getGridId();
/*    */   
/*    */   void setGridId(String paramString);
/*    */   
/*    */   int getRowId();
/*    */   
/*    */   void setRowId(int paramInt);
/*    */   
/*    */   int getColumnId();
/*    */   
/*    */   void setColumnId(int paramInt);
/*    */   
/*    */   String getComponentId();
/*    */   
/*    */   void setComponentId(String paramString);
/*    */   
/*    */   int getSortOrder();
/*    */   
/*    */   void setSortOrder(int paramInt);
/*    */   
/*    */   String getChildId();
/*    */   
/*    */   void setChildId(String paramString);
/*    */   
/*    */   String getKeyName();
/*    */   
/*    */   void setKeyName(String paramString);
/*    */   
/*    */   String getData();
/*    */   
/*    */   void setData(String paramString);
/*    */   
/*    */   String getText();
/*    */   
/*    */   void setText(String paramString);
/*    */   
/*    */   int getTextX();
/*    */   
/*    */   void setTextX(int paramInt);
/*    */   
/*    */   int getTextY();
/*    */   
/*    */   void setTextY(int paramInt);
/*    */   
/*    */   String getImageFilename();
/*    */   
/*    */   void setImageFilename(String paramString);
/*    */   
/*    */   int getImageX();
/*    */   
/*    */   void setImageX(int paramInt);
/*    */   
/*    */   int getImageY();
/*    */   
/*    */   void setImageY(int paramInt);
/*    */   
/*    */   String getVisibilityRule();
/*    */   
/*    */   void setVisibilityRule(String paramString);
/*    */   
/*    */   int getHeightSpan();
/*    */   
/*    */   void setHeightSpan(int paramInt);
/*    */   
/*    */   int getWidthSpan();
/*    */   
/*    */   void setWidthSpan(int paramInt);
/*    */   
/*    */   String getBackgroundRgb();
/*    */   
/*    */   void setBackgroundRgb(String paramString);
/*    */   
/*    */   String getForegroundRgb();
/*    */   
/*    */   void setForegroundRgb(String paramString);
/*    */   
/*    */   String getButtonStyle();
/*    */   
/*    */   void setButtonStyle(String paramString);
/*    */   
/*    */   int getActionIdx();
/*    */   
/*    */   void setActionIdx(int paramInt);
/*    */   
/*    */   int getAnimationIdx();
/*    */   
/*    */   void setAnimationIdx(int paramInt);
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
/*    */   String getRecordState();
/*    */   
/*    */   void setRecordState(String paramString);
/*    */   
/*    */   IDataModel getButtonGridExt();
/*    */   
/*    */   void setButtonGridExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IButtonGridProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IButtonGridProperty> paramList);
/*    */   
/*    */   void addButtonGridProperty(IButtonGridProperty paramIButtonGridProperty);
/*    */   
/*    */   void removeButtonGridProperty(IButtonGridProperty paramIButtonGridProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\IButtonGrid.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */