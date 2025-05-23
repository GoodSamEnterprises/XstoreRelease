/*     */ package dtv.pos.iframework.form;
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
/*     */ public class Cardinality
/*     */   implements ICardinality
/*     */ {
/*     */   private final String description_;
/*     */   private final boolean isRequired_;
/*     */   private final boolean isBounded_;
/*     */   private final int minimum_;
/*     */   private final Integer maximum_;
/*     */   private final boolean isArray_;
/*     */   private final boolean isAvailable_;
/*     */   
/*     */   public static ICardinality makeRequired(ICardinality argCardinality, boolean argRequired) {
/*  25 */     if (argRequired && argCardinality.isRequired())
/*     */     {
/*     */       
/*  28 */       return argCardinality;
/*     */     }
/*  30 */     if (!argRequired && !argCardinality.isRequired())
/*     */     {
/*     */       
/*  33 */       return argCardinality;
/*     */     }
/*  35 */     if (argRequired) {
/*  36 */       if (argCardinality.equals(ICardinality.OPTIONAL)) {
/*  37 */         return ICardinality.REQUIRED;
/*     */       }
/*  39 */       if (argCardinality.equals(ICardinality.OPTIONAL_UNBOUNDED)) {
/*  40 */         return ICardinality.REQUIRED_UNBOUNDED;
/*     */       }
/*     */       
/*  43 */       return ICardinality.NOT_AVAILABLE;
/*     */     } 
/*     */ 
/*     */     
/*  47 */     if (argCardinality.equals(ICardinality.REQUIRED)) {
/*  48 */       return ICardinality.OPTIONAL;
/*     */     }
/*  50 */     if (argCardinality.equals(ICardinality.REQUIRED_UNBOUNDED)) {
/*  51 */       return ICardinality.OPTIONAL_UNBOUNDED;
/*     */     }
/*     */     
/*  54 */     return ICardinality.NOT_AVAILABLE;
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
/*     */   public Cardinality(String argDescription) {
/*  75 */     this.description_ = argDescription;
/*  76 */     String[] range = argDescription.split("\\.\\.");
/*     */ 
/*     */     
/*  79 */     if (range.length != 2) {
/*  80 */       throw new IllegalArgumentException("invalid Cardinality [" + argDescription + "]. must be [lowerbound..upperbound].");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  86 */       this.minimum_ = Integer.parseInt(range[0]);
/*     */     }
/*  88 */     catch (NumberFormatException ex) {
/*  89 */       throw new IllegalArgumentException("invalid lowerbound [" + range[0] + "]. must be non-negative integer.");
/*     */     } 
/*     */ 
/*     */     
/*  93 */     if (this.minimum_ < 0) {
/*  94 */       throw new IllegalArgumentException("invalid lowerbound [" + range[0] + "]. must be non-negative integer.");
/*     */     }
/*     */     
/*  97 */     if (this.minimum_ == 0) {
/*  98 */       this.isRequired_ = false;
/*     */     } else {
/*     */       
/* 101 */       this.isRequired_ = true;
/*     */     } 
/*     */ 
/*     */     
/* 105 */     if ("*".equals(range[1])) {
/* 106 */       this.isBounded_ = false;
/* 107 */       this.isAvailable_ = true;
/* 108 */       this.isArray_ = true;
/* 109 */       this.maximum_ = null;
/*     */     }
/*     */     else {
/*     */       
/* 113 */       this.isBounded_ = true;
/*     */       try {
/* 115 */         this.maximum_ = Integer.valueOf(range[1]);
/*     */       }
/* 117 */       catch (NumberFormatException ex1) {
/* 118 */         throw new IllegalArgumentException("invalid lowerbound [" + range[0] + "]. must be non-negative integer or '*'.");
/*     */       } 
/*     */       
/* 121 */       if (this.maximum_.intValue() == 0) {
/* 122 */         this.isAvailable_ = false;
/* 123 */         this.isArray_ = false;
/*     */       }
/* 125 */       else if (this.maximum_.intValue() > 1) {
/* 126 */         this.isAvailable_ = true;
/* 127 */         this.isArray_ = true;
/*     */       } else {
/*     */         
/* 130 */         this.isAvailable_ = true;
/* 131 */         this.isArray_ = false;
/*     */       } 
/*     */ 
/*     */       
/* 135 */       if (this.maximum_.intValue() < this.minimum_) {
/* 136 */         throw new IllegalArgumentException("invalid Cardinality [" + argDescription + "]. lowerbound [" + this.minimum_ + "] must not be greater than upperbound [" + this.maximum_ + "].");
/*     */       }
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
/*     */   public boolean equals(Object argTarget) {
/* 151 */     boolean equal = false;
/* 152 */     if (argTarget instanceof Cardinality) {
/* 153 */       equal = this.description_.equals(((Cardinality)argTarget).description_);
/*     */     }
/* 155 */     return equal;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getMaximum() {
/* 161 */     return this.maximum_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinimum() {
/* 167 */     return this.minimum_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 173 */     return this.description_.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isArray() {
/* 179 */     return this.isArray_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAvailable() {
/* 185 */     return this.isAvailable_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBounded() {
/* 191 */     return this.isBounded_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRequired() {
/* 197 */     return this.isRequired_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 202 */     return this.description_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\Cardinality.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */