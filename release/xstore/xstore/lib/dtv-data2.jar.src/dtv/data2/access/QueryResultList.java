/*     */ package dtv.data2.access;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.AbstractList;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
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
/*     */ public class QueryResultList<C>
/*     */   extends AbstractList<C>
/*     */   implements IQueryResultList<C>, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 38586867920957569L;
/*     */   private final Class<C> type_;
/*     */   private final long limit_;
/*     */   private final boolean isLimitReached_;
/*     */   
/*     */   public static <T> IQueryResultList<T> makeList(Object argObject, Class<T> argType) {
/*  36 */     if (argObject instanceof IQueryResultWrapper) {
/*  37 */       IQueryResultWrapper wrapper = (IQueryResultWrapper)argObject;
/*     */       
/*  39 */       return makeList(wrapper.getData(), argType, wrapper.getQueryLimit(), wrapper.isQueryLimitReached());
/*     */     } 
/*     */     
/*  42 */     return makeList(argObject, argType, Long.MAX_VALUE, false);
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
/*     */   public static <T> IQueryResultList<T> makeList(Object argObject, Class<T> argType, long argLimit, boolean argLimitReached) {
/*  60 */     if (argObject == null) {
/*  61 */       return null;
/*     */     }
/*  63 */     if (argObject instanceof IQueryResultList) {
/*  64 */       IQueryResultList<?> l = (IQueryResultList)argObject;
/*     */       
/*  66 */       if (l.getResultClass().isAssignableFrom(argType)) {
/*  67 */         return (IQueryResultList<T>)argObject;
/*     */       }
/*     */     } 
/*     */     
/*  71 */     if (argObject instanceof Collection) {
/*  72 */       IQueryResultList<T> iQueryResultList = new QueryResultList<>(argType, argLimit, argLimitReached);
/*  73 */       Collection<Object> collection = (Collection<Object>)argObject;
/*  74 */       for (Object o : collection) {
/*  75 */         iQueryResultList.add((T)o);
/*     */       }
/*  77 */       return iQueryResultList;
/*     */     } 
/*  79 */     if (argObject instanceof Object[][]) {
/*  80 */       IQueryResultList<T> iQueryResultList = new QueryResultList<>(argType, argLimit, argLimitReached);
/*  81 */       Object[][] objs = (Object[][])argObject;
/*  82 */       for (Object[] o : objs) {
/*  83 */         iQueryResultList.add((T)o);
/*     */       }
/*  85 */       return iQueryResultList;
/*     */     } 
/*     */     
/*  88 */     IQueryResultList<T> results = new QueryResultList<>(argType, argLimit, argLimitReached);
/*  89 */     results.add((T)argObject);
/*  90 */     return results;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   private List<C> list_ = null;
/*     */   
/*     */   public QueryResultList(Class<C> argType) {
/* 101 */     this(argType, Long.MAX_VALUE, false);
/*     */   }
/*     */   
/*     */   public QueryResultList(Class<C> argType, C[] obj) {
/* 105 */     this(argType, Long.MAX_VALUE, false, (obj == null) ? new ArrayList<>() : Arrays.<C>asList(obj));
/*     */   }
/*     */   
/*     */   public QueryResultList(Class<C> argType, Collection<C> col) {
/* 109 */     this(argType, Long.MAX_VALUE, false, col);
/*     */   }
/*     */   
/*     */   public QueryResultList(Class<C> argType, long argLimit, boolean argLimitReached) {
/* 113 */     this.type_ = argType;
/* 114 */     this.list_ = Collections.checkedList(new ArrayList<>(), this.type_);
/* 115 */     this.limit_ = argLimit;
/* 116 */     this.isLimitReached_ = argLimitReached;
/*     */   }
/*     */   
/*     */   public QueryResultList(Class<C> argType, long argLimit, boolean argLimitReached, Collection<C> col) {
/* 120 */     this.type_ = argType;
/* 121 */     this.list_ = Collections.checkedList(new ArrayList<>(col.size()), this.type_);
/* 122 */     this.list_.addAll(col);
/* 123 */     this.limit_ = argLimit;
/* 124 */     this.isLimitReached_ = argLimitReached;
/*     */   }
/*     */   
/*     */   public QueryResultList(Class<C> argType, long argLimit, boolean argLimitReached, int argInitialCapacity) {
/* 128 */     this.type_ = argType;
/* 129 */     this.list_ = Collections.checkedList(new ArrayList<>(argInitialCapacity), this.type_);
/* 130 */     this.limit_ = argLimit;
/* 131 */     this.isLimitReached_ = argLimitReached;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(C argO) {
/* 137 */     return this.list_.add(argO);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(int argIndex, C argElement) {
/* 143 */     this.list_.add(argIndex, argElement);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends C> argC) {
/* 149 */     return this.list_.addAll(argC);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(int argIndex, Collection<? extends C> argC) {
/* 155 */     return this.list_.addAll(argIndex, argC);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 161 */     this.list_.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Object argO) {
/* 167 */     return this.list_.contains(argO);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> argC) {
/* 173 */     return this.list_.containsAll(argC);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public C get(int argIndex) {
/* 179 */     return this.list_.get(argIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getQueryLimit() {
/* 185 */     return this.limit_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<C> getResultClass() {
/* 191 */     return this.type_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int indexOf(Object argO) {
/* 197 */     return this.list_.indexOf(argO);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 203 */     return this.list_.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isQueryLimitReached() {
/* 209 */     return this.isLimitReached_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<C> iterator() {
/* 215 */     return this.list_.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int lastIndexOf(Object argO) {
/* 221 */     return this.list_.lastIndexOf(argO);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ListIterator<C> listIterator() {
/* 227 */     return this.list_.listIterator();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ListIterator<C> listIterator(int argIndex) {
/* 233 */     return this.list_.listIterator(argIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public C remove(int argIndex) {
/* 239 */     return this.list_.remove(argIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove(Object argO) {
/* 245 */     return this.list_.remove(argO);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> argC) {
/* 251 */     return this.list_.removeAll(argC);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> argC) {
/* 257 */     return this.list_.retainAll(argC);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public C set(int argIndex, C argElement) {
/* 263 */     return this.list_.set(argIndex, argElement);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 269 */     return this.list_.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<C> subList(int argFromIndex, int argToIndex) {
/* 275 */     return this.list_.subList(argFromIndex, argToIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/* 281 */     return this.list_.toArray();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T[] toArray(T[] argA) {
/* 287 */     return this.list_.toArray(argA);
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\QueryResultList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */