/*     */ package dtv.pos.iframework.visibilityrules;
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
/*     */ public class AccessLevel
/*     */   implements IAccessLevel
/*     */ {
/*     */   public static final int DENIED_PRIVILEGED_INT = 10;
/*     */   public static final int DENIED_INT = 20;
/*     */   public static final int DENIED_OVERRIDABLE_INT = 30;
/*     */   public static final int GRANTED_INT = 2147483647;
/*  25 */   public static final AccessLevel DENIED = new AccessLevel("DENIED", 20, false);
/*     */   
/*  27 */   public static final AccessLevel DENIED_PRIVILEGED = new AccessLevel("DENIED_PRIVILEGED", 10, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  33 */   public static final AccessLevel DENIED_OVERRIDABLE = new AccessLevel("DENIED_OVERRIDABLE", 30, true);
/*     */ 
/*     */   
/*  36 */   public static final AccessLevel GRANTED = new AccessLevel("GRANTED", 2147483647, false);
/*     */   
/*  38 */   public static final AccessLevel GRANTED_PRIVILEGED = new AccessLevel("GRANTED_PRIVILEGED", 2147483647, true);
/*     */   
/*     */   private final String name_;
/*     */   
/*     */   private final int level_;
/*     */   private final boolean _privilegeBased;
/*     */   
/*     */   public static IAccessLevel convertToLevel(boolean argOverridable) {
/*  46 */     if (argOverridable) {
/*  47 */       return DENIED_OVERRIDABLE;
/*     */     }
/*     */     
/*  50 */     return DENIED_PRIVILEGED;
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
/*     */   public static IAccessLevel getInvertedLevel(IAccessLevel argLevel) {
/*  63 */     IAccessLevel invertedLevel = null;
/*     */     
/*  65 */     if (argLevel != null) {
/*  66 */       invertedLevel = argLevel.isGranted() ? DENIED : GRANTED;
/*     */     }
/*     */     
/*  69 */     return invertedLevel;
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
/*     */   protected AccessLevel(String argName, int argLevel, boolean argPrivilegeBased) {
/*  85 */     this.name_ = argName;
/*  86 */     this.level_ = argLevel;
/*  87 */     this._privilegeBased = argPrivilegeBased;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(IAccessLevel o) {
/*  93 */     if (o.getLevel() > this.level_) {
/*  94 */       return -1;
/*     */     }
/*  96 */     if (o.getLevel() < this.level_) {
/*  97 */       return 1;
/*     */     }
/*     */     
/* 100 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLevel() {
/* 107 */     return this.level_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 113 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 119 */     return this.level_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isGranted() {
/* 125 */     return (this.level_ == Integer.MAX_VALUE);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPrivilegeBased() {
/* 131 */     return this._privilegeBased;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isViewable() {
/* 137 */     return (this.level_ >= 30);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 143 */     return getClass().getName() + "[" + this.name_ + "]";
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\visibilityrules\AccessLevel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */