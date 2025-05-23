/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.ButtonGridId;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ButtonGridDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1943332424L;
/*     */   private Long _organizationId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private String _gridId;
/*     */   private Integer _rowId;
/*     */   private Integer _columnId;
/*     */   private String _componentId;
/*     */   private Integer _sortOrder;
/*     */   private String _childId;
/*     */   private String _keyName;
/*     */   private String _data;
/*     */   private String _text;
/*     */   private Integer _textX;
/*     */   private Integer _textY;
/*     */   private String _imageFilename;
/*     */   private Integer _imageX;
/*     */   private Integer _imageY;
/*     */   private String _visibilityRule;
/*     */   private Integer _heightSpan;
/*     */   private Integer _widthSpan;
/*     */   private String _backgroundRgb;
/*     */   private String _foregroundRgb;
/*     */   private String _buttonStyle;
/*     */   private Integer _actionIdx;
/*     */   private Integer _animationIdx;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _recordState;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.level_code, t.level_value, t.grid_id, t.row_id, t.column_id, t.component_id, t.sort_order, t.child_id, t.key_name, t.data, t.text, t.text_x, t.text_y, t.image_filename, t.image_x, t.image_y, t.visibility_rule, t.height_span, t.width_span, t.background_rgb, t.foreground_rgb, t.button_style, t.action_idx, t.animation_idx, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.record_state FROM com_button_grid t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND level_code = ?  AND level_value = ?  AND grid_id = ?  AND row_id = ?  AND column_id = ?  AND component_id = ?  AND sort_order = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  59 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  63 */     return "SELECT t.organization_id, t.level_code, t.level_value, t.grid_id, t.row_id, t.column_id, t.component_id, t.sort_order, t.child_id, t.key_name, t.data, t.text, t.text_x, t.text_y, t.image_filename, t.image_x, t.image_y, t.visibility_rule, t.height_span, t.width_span, t.background_rgb, t.foreground_rgb, t.button_style, t.action_idx, t.animation_idx, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.record_state FROM com_button_grid t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  69 */     return " WHERE organization_id = ?  AND level_code = ?  AND level_value = ?  AND grid_id = ?  AND row_id = ?  AND column_id = ?  AND component_id = ?  AND sort_order = ?  ";
/*     */   }
/*     */   
/*  72 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_button_grid(organization_id, level_code, level_value, grid_id, row_id, column_id, component_id, sort_order, child_id, key_name, data, text, text_x, text_y, image_filename, image_x, image_y, visibility_rule, height_span, width_span, background_rgb, foreground_rgb, button_style, action_idx, animation_idx, create_date, create_user_id, update_date, update_user_id, record_state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  75 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  79 */     Object[][] insertParameterObject = { { this._organizationId, this._levelCode, this._levelValue, this._gridId, this._rowId, this._columnId, this._componentId, this._sortOrder, this._childId, this._keyName, this._data, this._text, this._textX, this._textY, this._imageFilename, this._imageX, this._imageY, this._visibilityRule, this._heightSpan, this._widthSpan, this._backgroundRgb, this._foregroundRgb, this._buttonStyle, this._actionIdx, this._animationIdx, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._recordState } };
/*  80 */     return insertParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 4, 4, 12, 4, 12, 12, 12, 12, 4, 4, 12, 4, 4, 12, 4, 4, 12, 12, 12, 4, 4, 91, 12, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  86 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_button_grid SET child_id = ?, key_name = ?, data = ?, text = ?, text_x = ?, text_y = ?, image_filename = ?, image_x = ?, image_y = ?, visibility_rule = ?, height_span = ?, width_span = ?, background_rgb = ?, foreground_rgb = ?, button_style = ?, action_idx = ?, animation_idx = ?, update_date = ?, update_user_id = ?, record_state = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  92 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  96 */     Object[][] updateParameterObject = { { this._childId, this._keyName, this._data, this._text, this._textX, this._textY, this._imageFilename, this._imageX, this._imageY, this._visibilityRule, this._heightSpan, this._widthSpan, this._backgroundRgb, this._foregroundRgb, this._buttonStyle, this._actionIdx, this._animationIdx, this._updateDate, this._updateUserId, this._recordState } };
/*  97 */     return updateParameterObject;
/*     */   }
/*     */   
/* 100 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 12, 12, 4, 4, 12, 4, 4, 12, 4, 4, 12, 12, 12, 4, 4, 91, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 102 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 105 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_button_grid" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND level_code = ?  AND level_value = ?  AND grid_id = ?  AND row_id = ?  AND column_id = ?  AND component_id = ?  AND sort_order = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 108 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 114 */     return " WHERE organization_id = ?  AND level_code = ?  AND level_value = ?  AND grid_id = ?  AND row_id = ?  AND column_id = ?  AND component_id = ?  AND sort_order = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 117 */     return new Object[] { this._organizationId, this._levelCode, this._levelValue, this._gridId, this._rowId, this._columnId, this._componentId, this._sortOrder };
/*     */   }
/*     */   
/* 120 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12, 4, 4, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 123 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 126 */     return "com_button_grid";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 130 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 134 */     return new ButtonGridFiller(this);
/*     */   }
/*     */   
/*     */   private static class ButtonGridFiller
/*     */     implements IFiller {
/*     */     private ButtonGridDBA _parent;
/*     */     
/*     */     public ButtonGridFiller(ButtonGridDBA argParent) {
/* 142 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 147 */       long l = argResultSet.getLong(1);
/* 148 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 149 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 153 */       this._parent._levelCode = argResultSet.getString(2);
/* 154 */       this._parent._levelValue = argResultSet.getString(3);
/* 155 */       this._parent._gridId = argResultSet.getString(4);
/*     */ 
/*     */       
/* 158 */       int primitiveResult = argResultSet.getInt(5);
/* 159 */       if (primitiveResult != 0 || argResultSet.getObject(5) != null) {
/* 160 */         this._parent._rowId = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 166 */       primitiveResult = argResultSet.getInt(6);
/* 167 */       if (primitiveResult != 0 || argResultSet.getObject(6) != null) {
/* 168 */         this._parent._columnId = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 172 */       this._parent._componentId = argResultSet.getString(7);
/*     */ 
/*     */       
/* 175 */       primitiveResult = argResultSet.getInt(8);
/* 176 */       if (primitiveResult != 0 || argResultSet.getObject(8) != null) {
/* 177 */         this._parent._sortOrder = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 181 */       this._parent._childId = argResultSet.getString(9);
/* 182 */       this._parent._keyName = argResultSet.getString(10);
/* 183 */       this._parent._data = argResultSet.getString(11);
/* 184 */       this._parent._text = argResultSet.getString(12);
/*     */ 
/*     */       
/* 187 */       primitiveResult = argResultSet.getInt(13);
/* 188 */       if (primitiveResult != 0 || argResultSet.getObject(13) != null) {
/* 189 */         this._parent._textX = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 195 */       primitiveResult = argResultSet.getInt(14);
/* 196 */       if (primitiveResult != 0 || argResultSet.getObject(14) != null) {
/* 197 */         this._parent._textY = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 201 */       this._parent._imageFilename = argResultSet.getString(15);
/*     */ 
/*     */       
/* 204 */       primitiveResult = argResultSet.getInt(16);
/* 205 */       if (primitiveResult != 0 || argResultSet.getObject(16) != null) {
/* 206 */         this._parent._imageX = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 212 */       primitiveResult = argResultSet.getInt(17);
/* 213 */       if (primitiveResult != 0 || argResultSet.getObject(17) != null) {
/* 214 */         this._parent._imageY = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 218 */       this._parent._visibilityRule = argResultSet.getString(18);
/*     */ 
/*     */       
/* 221 */       primitiveResult = argResultSet.getInt(19);
/* 222 */       if (primitiveResult != 0 || argResultSet.getObject(19) != null) {
/* 223 */         this._parent._heightSpan = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 229 */       primitiveResult = argResultSet.getInt(20);
/* 230 */       if (primitiveResult != 0 || argResultSet.getObject(20) != null) {
/* 231 */         this._parent._widthSpan = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 235 */       this._parent._backgroundRgb = argResultSet.getString(21);
/* 236 */       this._parent._foregroundRgb = argResultSet.getString(22);
/* 237 */       this._parent._buttonStyle = argResultSet.getString(23);
/*     */ 
/*     */       
/* 240 */       primitiveResult = argResultSet.getInt(24);
/* 241 */       if (primitiveResult != 0 || argResultSet.getObject(24) != null) {
/* 242 */         this._parent._actionIdx = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 248 */       primitiveResult = argResultSet.getInt(25);
/* 249 */       if (primitiveResult != 0 || argResultSet.getObject(25) != null) {
/* 250 */         this._parent._animationIdx = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 255 */       Timestamp t26 = argResultSet.getTimestamp(26);
/* 256 */       if (t26 != null) {
/* 257 */         this._parent._createDate = (Date)new DtvDate(t26.getTime());
/*     */       } else {
/*     */         
/* 260 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 263 */       this._parent._createUserId = argResultSet.getString(27);
/*     */       
/* 265 */       Timestamp t28 = argResultSet.getTimestamp(28);
/* 266 */       if (t28 != null) {
/* 267 */         this._parent._updateDate = (Date)new DtvDate(t28.getTime());
/*     */       } else {
/*     */         
/* 270 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 273 */       this._parent._updateUserId = argResultSet.getString(29);
/* 274 */       this._parent._recordState = argResultSet.getString(30);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 279 */     argDAO.suppressStateChanges(true);
/* 280 */     ButtonGridDAO dao = (ButtonGridDAO)argDAO;
/* 281 */     dao.setOrganizationId(this._organizationId);
/* 282 */     dao.setLevelCode(this._levelCode);
/* 283 */     dao.setLevelValue(this._levelValue);
/* 284 */     dao.setGridId(this._gridId);
/* 285 */     dao.setRowId(this._rowId);
/* 286 */     dao.setColumnId(this._columnId);
/* 287 */     dao.setComponentId(this._componentId);
/* 288 */     dao.setSortOrder(this._sortOrder);
/* 289 */     dao.setChildId(this._childId);
/* 290 */     dao.setKeyName(this._keyName);
/* 291 */     dao.setData(this._data);
/* 292 */     dao.setText(this._text);
/* 293 */     dao.setTextX(this._textX);
/* 294 */     dao.setTextY(this._textY);
/* 295 */     dao.setImageFilename(this._imageFilename);
/* 296 */     dao.setImageX(this._imageX);
/* 297 */     dao.setImageY(this._imageY);
/* 298 */     dao.setVisibilityRule(this._visibilityRule);
/* 299 */     dao.setHeightSpan(this._heightSpan);
/* 300 */     dao.setWidthSpan(this._widthSpan);
/* 301 */     dao.setBackgroundRgb(this._backgroundRgb);
/* 302 */     dao.setForegroundRgb(this._foregroundRgb);
/* 303 */     dao.setButtonStyle(this._buttonStyle);
/* 304 */     dao.setActionIdx(this._actionIdx);
/* 305 */     dao.setAnimationIdx(this._animationIdx);
/* 306 */     dao.setCreateDate(this._createDate);
/* 307 */     dao.setCreateUserId(this._createUserId);
/* 308 */     dao.setUpdateDate(this._updateDate);
/* 309 */     dao.setUpdateUserId(this._updateUserId);
/* 310 */     dao.setRecordState(this._recordState);
/* 311 */     argDAO.suppressStateChanges(false);
/* 312 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 316 */     return loadDAO((IDataAccessObject)new ButtonGridDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 320 */     ButtonGridDAO dao = (ButtonGridDAO)argDAO;
/* 321 */     this._organizationId = dao.getOrganizationId();
/* 322 */     this._levelCode = dao.getLevelCode();
/* 323 */     this._levelValue = dao.getLevelValue();
/* 324 */     this._gridId = dao.getGridId();
/* 325 */     this._rowId = dao.getRowId();
/* 326 */     this._columnId = dao.getColumnId();
/* 327 */     this._componentId = dao.getComponentId();
/* 328 */     this._sortOrder = dao.getSortOrder();
/* 329 */     this._childId = dao.getChildId();
/* 330 */     this._keyName = dao.getKeyName();
/* 331 */     this._data = dao.getData();
/* 332 */     this._text = dao.getText();
/* 333 */     this._textX = dao.getTextX();
/* 334 */     this._textY = dao.getTextY();
/* 335 */     this._imageFilename = dao.getImageFilename();
/* 336 */     this._imageX = dao.getImageX();
/* 337 */     this._imageY = dao.getImageY();
/* 338 */     this._visibilityRule = dao.getVisibilityRule();
/* 339 */     this._heightSpan = dao.getHeightSpan();
/* 340 */     this._widthSpan = dao.getWidthSpan();
/* 341 */     this._backgroundRgb = dao.getBackgroundRgb();
/* 342 */     this._foregroundRgb = dao.getForegroundRgb();
/* 343 */     this._buttonStyle = dao.getButtonStyle();
/* 344 */     this._actionIdx = dao.getActionIdx();
/* 345 */     this._animationIdx = dao.getAnimationIdx();
/* 346 */     this._createDate = dao.getCreateDate();
/* 347 */     this._createUserId = dao.getCreateUserId();
/* 348 */     this._updateDate = dao.getUpdateDate();
/* 349 */     this._updateUserId = dao.getUpdateUserId();
/* 350 */     this._recordState = dao.getRecordState();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 354 */     ButtonGridId id = (ButtonGridId)argId;
/* 355 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 356 */     argStatement.setString(2, id.getLevelCode());
/* 357 */     argStatement.setString(3, id.getLevelValue());
/* 358 */     argStatement.setString(4, id.getGridId());
/* 359 */     argStatement.setInt(5, id.getRowId().intValue());
/* 360 */     argStatement.setInt(6, id.getColumnId().intValue());
/* 361 */     argStatement.setString(7, id.getComponentId());
/* 362 */     argStatement.setInt(8, id.getSortOrder().intValue());
/* 363 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 367 */     ButtonGridId id = new ButtonGridId();
/* 368 */     id.setOrganizationId(this._organizationId);
/* 369 */     id.setLevelCode(this._levelCode);
/* 370 */     id.setLevelValue(this._levelValue);
/* 371 */     id.setGridId(this._gridId);
/* 372 */     id.setRowId(this._rowId);
/* 373 */     id.setColumnId(this._columnId);
/* 374 */     id.setComponentId(this._componentId);
/* 375 */     id.setSortOrder(this._sortOrder);
/* 376 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 384 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 388 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ButtonGridDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */