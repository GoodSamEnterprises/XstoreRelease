/*     */ package dtv.data2.access.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractDAOImpl
/*     */   implements IDataAccessObject
/*     */ {
/*     */   public static final String DAO_ELEMENT_NAME = "dao";
/*     */   protected static final String XML_TAG_FIELD = "<fld id=\"";
/*     */   protected static final String REDACTED = "[REDACTED]";
/*  37 */   protected static final boolean MANAGE_CASE = PersistenceConstants.MANAGE_CASE;
/*     */   
/*     */   private static final long serialVersionUID = 4444477777L;
/*     */   
/*     */   private static final String TRANSIENT_OBJECT_FIELD_NAME = "TransientObject";
/*     */   
/*  43 */   private int _objectState = DaoState.CLEAN.intVal();
/*  44 */   private transient int _lastObjectState = DaoState.UNDEFINED.intVal();
/*     */ 
/*     */   
/*     */   private transient boolean _objectStateRulesApplied = false;
/*     */ 
/*     */   
/*     */   private transient boolean _suppressStateChanges = true;
/*     */ 
/*     */   
/*     */   private boolean _transientObject = false;
/*     */ 
/*     */   
/*     */   private transient String _originDataSource;
/*     */   
/*     */   private transient IPersistenceDefaults _persistenceDefaults;
/*     */ 
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/*  62 */     return super.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastObjectState() {
/*  68 */     return this._lastObjectState;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getObjectState() {
/*  75 */     return this._transientObject ? DaoState.CLEAN.intVal() : this._objectState;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOriginDataSource() {
/*  86 */     return this._originDataSource;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isObjectStateRulesApplied() {
/*  92 */     return this._objectStateRulesApplied;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTransientObject() {
/*  98 */     return this._transientObject;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void revertObjectState() {
/* 104 */     if (this._lastObjectState != DaoState.UNDEFINED.intVal()) {
/* 105 */       this._objectState = this._lastObjectState;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObjectState(int argState) {
/* 112 */     this._lastObjectState = this._objectState;
/* 113 */     this._objectState = DaoState.getNewState(this, argState);
/* 114 */     if (!this._suppressStateChanges) {
/* 115 */       DaoState.applyStateChanges(this, getPersistenceDefaults().getUserId());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObjectState(String argObjectState) {
/* 122 */     int stateMask = DaoState.getStateMask(argObjectState);
/* 123 */     setObjectState(stateMask);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObjectStateRulesApplied(boolean argObjectStateRulesApplied) {
/* 129 */     this._objectStateRulesApplied = argObjectStateRulesApplied;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOriginDataSource(String argDataSourceName) {
/* 135 */     if (argDataSourceName != null && !argDataSourceName.equalsIgnoreCase(this._originDataSource)) {
/* 136 */       this._originDataSource = argDataSourceName;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPersistenceDefaults(IPersistenceDefaults argPD) {
/* 151 */     this._suppressStateChanges = false;
/* 152 */     this._persistenceDefaults = argPD;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransientObject(boolean argTransientObject) {
/* 158 */     this._transientObject = argTransientObject;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 164 */     String value = argValues.get("TransientObject");
/* 165 */     Object fieldValue = DaoUtils.getFieldValueForXmlString(16, value);
/* 166 */     this._transientObject = (value == null) ? false : ((Boolean)fieldValue).booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void suppressStateChanges(boolean argSuppress) {
/* 172 */     this._suppressStateChanges = argSuppress;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 178 */     return super.toString() + "Object Id: [" + getObjectId() + "} DaoState: [" + 
/* 179 */       DaoState.getStateString(getObjectState()) + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean changed(boolean argOne, boolean argTwo, String argFieldKey) {
/* 194 */     boolean changed = (argOne != argTwo);
/* 195 */     if (changed) {
/* 196 */       handleChange();
/*     */     }
/* 198 */     return changed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean changed(int argOne, int argTwo, String argFieldKey) {
/* 213 */     boolean changed = (argOne != argTwo);
/* 214 */     if (changed) {
/* 215 */       handleChange();
/*     */     }
/* 217 */     return changed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean changed(long argOne, long argTwo, String argFieldKey) {
/* 232 */     boolean changed = (argOne != argTwo);
/* 233 */     if (changed) {
/* 234 */       handleChange();
/*     */     }
/* 236 */     return changed;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean changed(Object argOne, Object argTwo, String argFieldKey) {
/* 241 */     boolean changed = false;
/*     */ 
/*     */     
/* 244 */     if (argOne == "") {
/* 245 */       changed = (argTwo != null && argTwo != "");
/*     */     }
/* 247 */     else if (argTwo == "") {
/* 248 */       changed = (argOne != null && argOne != "");
/*     */     } else {
/*     */       
/* 251 */       changed = !ObjectUtils.equivalent(argOne, argTwo);
/*     */     } 
/*     */     
/* 254 */     if (changed) {
/* 255 */       handleChange();
/*     */     }
/* 257 */     return changed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void getFieldsAsXml(StringBuilder argBuffer) {
/* 265 */     Map<String, String> values = getValues();
/* 266 */     Set<String> fieldNames = values.keySet();
/*     */     
/* 268 */     for (String fieldName : fieldNames) {
/* 269 */       argBuffer.append("<fld id=\"").append(fieldName).append("\" val=\"").append(values.get(fieldName))
/* 270 */         .append("\"/>");
/*     */     }
/*     */     
/* 273 */     if (!StringUtils.isEmpty(getOriginDataSource())) {
/* 274 */       argBuffer.append("<").append("originDS").append(">").append(getOriginDataSource()).append("</")
/* 275 */         .append("originDS").append(">");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getObjectStateString() {
/* 286 */     return DaoState.getStateString(getObjectState());
/*     */   }
/*     */   
/*     */   protected IPersistenceDefaults getPersistenceDefaults() {
/* 290 */     return this._persistenceDefaults;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<String, String> getValues() {
/* 300 */     Map<String, String> values = new HashMap<>();
/* 301 */     values.put("TransientObject", DaoUtils.getXmlSafeFieldValue(-7, Boolean.valueOf(this._transientObject)));
/* 302 */     return values;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleChange() {
/* 313 */     if (this._objectState == DaoState.CLEAN.intVal()) {
/* 314 */       setObjectState(DaoState.UPDATED.intVal());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
/* 323 */     in.defaultReadObject();
/* 324 */     this._lastObjectState = DaoState.UNDEFINED.intVal();
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\AbstractDAOImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */