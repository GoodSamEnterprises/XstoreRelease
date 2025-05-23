/*     */ package dtv.data2.access;
/*     */ 
/*     */ import dtv.util.ObjectUtils;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.Iterator;
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
/*     */ public class DataPropertyMap<T extends IDataProperty>
/*     */   extends AbstractMap<String, T>
/*     */ {
/*     */   final IDataPropertyParent<T> parent_;
/*     */   
/*     */   public DataPropertyMap(IDataPropertyParent<T> argParent) {
/*  26 */     this.parent_ = argParent;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<String, T>> entrySet() {
/*  32 */     return new EntrySet();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T put(String argKey, T argValue) {
/*  56 */     if (!argValue.getPropertyCode().equals(argKey)) {
/*  57 */       throw new IllegalArgumentException("v.getPropertyCode()->'" + argValue.getPropertyCode() + "' != key->'" + argKey + "'");
/*     */     }
/*     */ 
/*     */     
/*  61 */     IDataProperty iDataProperty = (IDataProperty)remove(argKey);
/*     */     
/*  63 */     this.parent_.getProperties().add(argValue);
/*     */     
/*  65 */     return (T)iDataProperty;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Entry<V extends IDataProperty>
/*     */     implements Map.Entry<String, V>
/*     */   {
/*     */     private final V prop_;
/*     */ 
/*     */     
/*     */     Entry(V argDataProperty) {
/*  76 */       this.prop_ = argDataProperty;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object argOther) {
/*  82 */       if (argOther == this) {
/*  83 */         return true;
/*     */       }
/*  85 */       if (!(argOther instanceof Map.Entry)) {
/*  86 */         return false;
/*     */       }
/*  88 */       Map.Entry<?, ?> other = (Map.Entry<?, ?>)argOther;
/*     */       
/*  90 */       return ObjectUtils.equivalent(other.getValue(), getValue());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getKey() {
/*  96 */       return this.prop_.getPropertyCode();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public V getValue() {
/* 102 */       return this.prop_;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 108 */       Object v = getValue();
/* 109 */       if (v == null) {
/* 110 */         return 0;
/*     */       }
/* 112 */       return v.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public V setValue(V value) {
/* 118 */       throw new UnsupportedOperationException(getClass().getName() + ".setValue not allowed");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class EntrySet
/*     */     extends AbstractSet<Map.Entry<String, T>>
/*     */   {
/*     */     private EntrySet() {}
/*     */ 
/*     */     
/*     */     public Iterator<Map.Entry<String, T>> iterator() {
/* 131 */       return new DataPropertyMap.EntrySetIterator(DataPropertyMap.this.parent_);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 137 */       return DataPropertyMap.this.parent_.getProperties().size();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class EntrySetIterator
/*     */     implements Iterator<Map.Entry<String, T>>
/*     */   {
/*     */     private final Iterator<T> _target;
/*     */ 
/*     */     
/*     */     EntrySetIterator(IDataPropertyParent<T> argParent) {
/* 150 */       this._target = argParent.getProperties().iterator();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 156 */       return this._target.hasNext();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Map.Entry<String, T> next() {
/* 162 */       IDataProperty iDataProperty = (IDataProperty)this._target.next();
/* 163 */       return new DataPropertyMap.Entry<>((T)iDataProperty);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void remove() {
/* 169 */       this._target.remove();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\DataPropertyMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */