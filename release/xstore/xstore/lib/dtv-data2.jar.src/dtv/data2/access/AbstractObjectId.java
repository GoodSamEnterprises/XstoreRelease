/*    */ package dtv.data2.access;
/*    */ 
/*    */ import dtv.data2.access.impl.PersistenceConstants;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractObjectId
/*    */   implements IObjectId
/*    */ {
/*    */   private static final long serialVersionUID = 5555577777L;
/* 23 */   protected static final boolean MANAGE_CASE = PersistenceConstants.MANAGE_CASE;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final Map<Object, Object> _properties;
/*    */ 
/*    */ 
/*    */   
/*    */   protected Long _organizationId;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public AbstractObjectId() {
/* 38 */     if (this._organizationId == null) {
/* 39 */       setOrganizationId(Long.getLong("dtv.location.organizationId"));
/*    */     }
/* 41 */     this._properties = new HashMap<>();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean containsKey(Object argKey) {
/* 47 */     return this._properties.containsKey(argKey);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract boolean equals(Object paramObject);
/*    */ 
/*    */ 
/*    */   
/*    */   public Object get(Object argKey) {
/* 57 */     return this._properties.get(argKey);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Long getOrganizationId() {
/* 63 */     if (this._organizationId == null) {
/* 64 */       setOrganizationId(Long.getLong("dtv.location.organizationId"));
/*    */     }
/* 66 */     return this._organizationId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract int hashCode();
/*    */ 
/*    */ 
/*    */   
/*    */   public Iterator<Object> iterator() {
/* 76 */     return this._properties.keySet().iterator();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void put(Object argKey, Object argValue) {
/* 82 */     this._properties.put(argKey, argValue);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setOrganizationId(Long argOrganizationId) {
/* 88 */     this._organizationId = argOrganizationId;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\AbstractObjectId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */