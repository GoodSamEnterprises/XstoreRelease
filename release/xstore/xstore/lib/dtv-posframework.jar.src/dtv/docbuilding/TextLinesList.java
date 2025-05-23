/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TextLinesList
/*     */   implements Collection<Object>
/*     */ {
/*  17 */   private final List<Object> list_ = new ArrayList();
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(Object o) {
/*  22 */     return this.list_.add(o);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends Object> c) {
/*  28 */     return this.list_.addAll(c);
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendBlankLine() {
/*  33 */     appendLine("");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendLine(FormattedLine argLine) {
/*  42 */     this.list_.add(argLine);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendLine(String argLine) {
/*  51 */     this.list_.add(argLine);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendLines(String[] argLines) {
/*  59 */     for (String argLine : argLines) {
/*  60 */       this.list_.add(argLine.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  67 */     this.list_.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Object o) {
/*  73 */     return this.list_.contains(o);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> c) {
/*  79 */     return this.list_.containsAll(c);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  85 */     return this.list_.equals(o);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  91 */     return this.list_.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  97 */     return this.list_.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Object> iterator() {
/* 103 */     return this.list_.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove(Object o) {
/* 109 */     return this.list_.remove(o);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> c) {
/* 115 */     return this.list_.removeAll(c);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> c) {
/* 121 */     return this.list_.retainAll(c);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 127 */     return this.list_.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/* 133 */     return this.list_.toArray();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T[] toArray(T[] a) {
/* 139 */     return this.list_.toArray(a);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\TextLinesList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */