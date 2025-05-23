/*     */ package dtv.data2.access;
/*     */ 
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang3.builder.ToStringStyle;
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
/*     */ public abstract class AbstractDataPropertyAccessor<T extends IHasDataProperty<? extends IDataProperty>, VT>
/*     */ {
/*     */   private final String key_;
/*     */   private final Class<T> parentType_;
/*     */   
/*     */   public AbstractDataPropertyAccessor(Class<T> argParentType, String argKey) {
/*  25 */     if (argParentType == null || argKey == null) {
/*  26 */       throw new NullPointerException();
/*     */     }
/*  28 */     this.key_ = argKey;
/*  29 */     this.parentType_ = argParentType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getKey() {
/*  36 */     return this.key_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract VT getValue(T paramT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract VT getValue(T paramT, VT paramVT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Class<VT> getValueType();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasProperty(T argParent) {
/*  65 */     return (validParent(argParent).getProperty(this.key_) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setValue(T paramT, VT paramVT);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  78 */     ToStringBuilder tsb = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
/*  79 */     tsb.append(this.key_);
/*  80 */     return tsb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Class<T> getParentType() {
/*  87 */     return this.parentType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final T validParent(T argParent) {
/*  98 */     Class<?> clz = argParent.getClass();
/*  99 */     if (!this.parentType_.isAssignableFrom(clz)) {
/* 100 */       throw new IllegalArgumentException("require " + this.parentType_.getName() + ", got " + clz.getName());
/*     */     }
/* 102 */     return argParent;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\AbstractDataPropertyAccessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */