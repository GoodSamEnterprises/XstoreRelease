/*    */ package dtv.data2.access;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ public abstract class AbstractQueryResult
/*    */   implements IGenericQueryResult, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final Map<Object, Object> _properties;
/* 22 */   private transient String _dataSource = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public AbstractQueryResult() {
/* 29 */     this._properties = new HashMap<>();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean containsKey(Object argPropertyName) {
/* 35 */     return this._properties.containsKey(argPropertyName);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Object get(Object argPropertyName) {
/* 41 */     return this._properties.get(argPropertyName);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getDataSource() {
/* 47 */     return this._dataSource;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final IObjectId getObjectId() {
/* 53 */     IObjectId objId = getObjectIdImpl();
/*    */     
/* 55 */     if (objId != null)
/*    */     {
/*    */ 
/*    */ 
/*    */       
/* 60 */       for (Map.Entry<Object, Object> property : this._properties.entrySet()) {
/* 61 */         objId.put(property.getKey(), property.getValue());
/*    */       }
/*    */     }
/* 64 */     return objId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Iterator<Object> iterator() {
/* 70 */     return this._properties.keySet().iterator();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void put(Object argPropertyName, Object argValue) {
/* 76 */     this._properties.put(argPropertyName, argValue);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setDataSource(String argDataSource) {
/* 82 */     this._dataSource = argDataSource;
/*    */   }
/*    */   
/*    */   protected abstract IObjectId getObjectIdImpl();
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\AbstractQueryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */