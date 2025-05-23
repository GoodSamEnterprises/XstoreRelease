/*     */ package dtv.data2.access.impl;
/*     */ 
/*     */ import java.util.ArrayList;
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
/*     */ public class PersistentList<E>
/*     */   implements List<E>
/*     */ {
/*  18 */   List<E> persistentList_ = null;
/*  19 */   List<E> unmodifiableList_ = null;
/*  20 */   List<E> deletedList_ = null;
/*  21 */   List<E> newList_ = null;
/*     */   
/*     */   public PersistentList() {
/*  24 */     this.persistentList_ = new ArrayList<>();
/*  25 */     this.unmodifiableList_ = Collections.unmodifiableList(this.persistentList_);
/*  26 */     this.deletedList_ = new ArrayList<>();
/*  27 */     this.newList_ = new ArrayList<>();
/*     */   }
/*     */   
/*     */   public PersistentList(List<E> argInitialList) {
/*  31 */     this.persistentList_ = argInitialList;
/*  32 */     this.unmodifiableList_ = Collections.unmodifiableList(this.persistentList_);
/*  33 */     this.deletedList_ = new ArrayList<>();
/*  34 */     this.newList_ = new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(E o) {
/*  40 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(int index, E element) {
/*  46 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> c) {
/*  52 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(int index, Collection<? extends E> c) {
/*  58 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  64 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Object o) {
/*  70 */     return this.persistentList_.contains(o);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> c) {
/*  76 */     return this.persistentList_.containsAll(c);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public E get(int index) {
/*  82 */     return this.persistentList_.get(index);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int indexOf(Object o) {
/*  88 */     return this.persistentList_.indexOf(o);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  94 */     return this.persistentList_.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<E> iterator() {
/* 100 */     return this.unmodifiableList_.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int lastIndexOf(Object o) {
/* 106 */     return this.persistentList_.lastIndexOf(o);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ListIterator<E> listIterator() {
/* 112 */     return this.unmodifiableList_.listIterator();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ListIterator<E> listIterator(int index) {
/* 118 */     return this.unmodifiableList_.listIterator(index);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public E remove(int index) {
/* 124 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove(Object o) {
/* 130 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> c) {
/* 136 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> c) {
/* 142 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public E set(int index, E element) {
/* 148 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 154 */     return this.persistentList_.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<E> subList(int fromIndex, int toIndex) {
/* 160 */     return this.unmodifiableList_.subList(fromIndex, toIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/* 166 */     return this.persistentList_.toArray();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T[] toArray(T[] a) {
/* 172 */     return this.persistentList_.toArray(a);
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\PersistentList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */