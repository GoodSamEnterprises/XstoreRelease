/*     */ package dtv.data2.access.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.lang3.StringUtils;
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
/*     */ public enum DaoState
/*     */ {
/*  22 */   UNDEFINED(0, false, false, false),
/*     */   
/*  24 */   CLEAN(1, false, false, false),
/*     */   
/*  26 */   NEW("INSERT", 16, true, false, false)
/*     */   {
/*     */     protected void applyStateChangesImpl(IDataAccessObject argDao, String argUserId)
/*     */     {
/*  30 */       super.applyStateChangesImpl(argDao, argUserId);
/*  31 */       setCreateFields(argDao, true, argUserId);
/*     */     }
/*     */   },
/*     */   
/*  35 */   UPDATED("UPDATE", 256, false, true, false)
/*     */   {
/*     */     protected void applyStateChangesImpl(IDataAccessObject argDao, String argUserId)
/*     */     {
/*  39 */       super.applyStateChangesImpl(argDao, argUserId);
/*  40 */       setUpdateFields(argDao, false, argUserId);
/*     */     }
/*     */   },
/*     */   
/*  44 */   DELETED("DELETE", 4096, false, false, true),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   INSERT_ONLY(65536, true, false, false)
/*     */   {
/*     */     protected void applyStateChangesImpl(IDataAccessObject argDao, String argUserId)
/*     */     {
/*  53 */       super.applyStateChangesImpl(argDao, argUserId);
/*  54 */       setCreateFields(argDao, true, argUserId);
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   INSERT_OR_UPDATE(1048576, true, true, false)
/*     */   {
/*     */     protected int getNewStateImpl(IDataAccessObject argDao, int argAssignedState)
/*     */     {
/*  65 */       int newState = super.getNewStateImpl(argDao, argAssignedState);
/*  66 */       int currentState = argDao.getObjectState();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  71 */       if (NEW.matches(currentState) || UPDATED.matches(currentState)) {
/*  72 */         newState |= currentState;
/*     */       }
/*  74 */       return newState;
/*     */     }
/*     */   };
/*     */   
/*     */   private final String _name;
/*     */   private final int _mask;
/*     */   private final boolean _isCreate;
/*     */   
/*     */   public static void applyStateChanges(IDataAccessObject argDao, String argUserId) {
/*  83 */     int newStateMask = argDao.getObjectState();
/*     */     
/*  85 */     for (DaoState state : valuesOf(newStateMask)) {
/*  86 */       state.applyStateChangesImpl(argDao, argUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean _isUpdate;
/*     */   
/*     */   private final boolean _isDelete;
/*     */   
/*     */   private final boolean _isDirty;
/*     */ 
/*     */   
/*     */   public static int getNewState(IDataAccessObject argDao, int argAssignedState) {
/* 100 */     int newState = argAssignedState;
/*     */     
/* 102 */     for (DaoState state : valuesOf(argAssignedState)) {
/* 103 */       newState = state.getNewStateImpl(argDao, newState);
/*     */     }
/* 105 */     return newState;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getStateMask(String argStateString) {
/* 116 */     int stateMask = 0;
/* 117 */     String stateString = StringUtils.deleteWhitespace(argStateString);
/* 118 */     if (!stateString.startsWith("|")) {
/* 119 */       stateString = "|" + stateString;
/*     */     }
/* 121 */     if (!stateString.endsWith("|")) {
/* 122 */       stateString = stateString + "|";
/*     */     }
/*     */     
/* 125 */     for (DaoState state : values()) {
/* 126 */       if (StringUtils.containsIgnoreCase(stateString, "|" + state.nameInternal() + "|")) {
/* 127 */         stateMask |= state._mask;
/*     */       }
/*     */     } 
/* 130 */     return stateMask;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getStateString(int argStateMask) {
/* 140 */     StringBuilder stateString = new StringBuilder();
/*     */     
/* 142 */     for (DaoState state : valuesOf(argStateMask)) {
/* 143 */       stateString.append(state.nameInternal()).append("|");
/*     */     }
/* 145 */     String retVal = StringUtils.removeEnd(stateString.toString(), "|");
/*     */     
/* 147 */     return retVal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isClean(IDataAccessObject argDao) {
/* 157 */     return CLEAN.matches(argDao);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isDeleted(IDataAccessObject argDao) {
/* 167 */     return DELETED.matches(argDao);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isNew(IDataAccessObject argDao) {
/* 177 */     return NEW.matches(argDao);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isUndefined(IDataAccessObject argDao) {
/* 188 */     boolean undefined = UNDEFINED.matches(argDao);
/* 189 */     if (!undefined) {
/* 190 */       undefined = UNDEFINED.equals(valuesOf(argDao.getObjectState()).iterator().next());
/*     */     }
/* 192 */     return undefined;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isUpdated(IDataAccessObject argDao) {
/* 202 */     return UPDATED.matches(argDao);
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
/*     */   private static void setCreateFields(IDataAccessObject argDao, boolean argOnlyIfNull, String argUserId) {
/* 214 */     if (!argOnlyIfNull || argDao.getCreateUserId() == null) {
/* 215 */       argDao.setCreateUserId(argUserId);
/*     */     }
/* 217 */     if (!argOnlyIfNull || argDao.getCreateDate() == null) {
/* 218 */       argDao.setCreateDate((Date)DaoDateFactory.getInstance().newDate());
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
/*     */   private static void setUpdateFields(IDataAccessObject argDao, boolean argOnlyIfNull, String argUserId) {
/* 231 */     if (!argOnlyIfNull || argDao.getUpdateUserId() == null) {
/* 232 */       argDao.setUpdateUserId(argUserId);
/*     */     }
/* 234 */     if (!argOnlyIfNull || argDao.getUpdateDate() == null) {
/* 235 */       argDao.setUpdateDate((Date)DaoDateFactory.getInstance().newDate());
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
/*     */   private static Set<DaoState> valuesOf(int argStateMask) {
/* 247 */     Set<DaoState> states = new HashSet<>();
/*     */     
/* 249 */     for (DaoState state : values()) {
/* 250 */       if (state.matches(argStateMask)) {
/* 251 */         states.add(state);
/*     */       }
/*     */     } 
/* 254 */     return states.isEmpty() ? Collections.<DaoState>singleton(UNDEFINED) : states;
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
/*     */ 
/*     */   
/*     */   DaoState(String argName, int argMask, boolean argCreate, boolean argUpdate, boolean argDelete) {
/* 271 */     this._name = (argName == null) ? name() : argName;
/* 272 */     this._mask = argMask;
/* 273 */     this._isCreate = argCreate;
/* 274 */     this._isUpdate = argUpdate;
/* 275 */     this._isDelete = argDelete;
/* 276 */     this._isDirty = argCreate | argUpdate | argDelete;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int intVal() {
/* 284 */     return this._mask;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCreate() {
/* 294 */     return this._isCreate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDelete() {
/* 304 */     return this._isDelete;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDirty() {
/* 315 */     return this._isDirty;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUpdate() {
/* 325 */     return this._isUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(IDataAccessObject argDao) {
/* 336 */     return matches(argDao.getObjectState());
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
/*     */   protected void applyStateChangesImpl(IDataAccessObject argDao, String argUserId) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getNewStateImpl(IDataAccessObject argDao, int argAssignedState) {
/* 358 */     return argAssignedState;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean matches(int argStateMask) {
/* 369 */     return ((this._mask & argStateMask) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private String nameInternal() {
/* 374 */     return this._name;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\DaoState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */