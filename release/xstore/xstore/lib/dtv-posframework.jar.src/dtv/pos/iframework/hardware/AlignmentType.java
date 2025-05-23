/*     */ package dtv.pos.iframework.hardware;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public final class AlignmentType
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -8670840898810579484L;
/*  23 */   private static final Logger logger_ = Logger.getLogger(AlignmentType.class);
/*     */ 
/*     */   
/*     */   private static final int PTR_BM_LEFT = -1;
/*     */ 
/*     */   
/*     */   private static final int PTR_BM_CENTER = -2;
/*     */ 
/*     */   
/*     */   private static final int PTR_BM_RIGHT = -3;
/*     */ 
/*     */   
/*  35 */   public static final AlignmentType LEFT = new AlignmentType("LEFT", -1);
/*     */ 
/*     */   
/*  38 */   public static final AlignmentType CENTER = new AlignmentType("CENTER", -2);
/*     */ 
/*     */   
/*  41 */   public static final AlignmentType RIGHT = new AlignmentType("RIGHT", -3);
/*     */   
/*     */   public static AlignmentType forJposEnum(int argJposValue) {
/*  44 */     switch (argJposValue) {
/*     */       case -2:
/*  46 */         return CENTER;
/*     */       case -1:
/*  48 */         return LEFT;
/*     */       case -3:
/*  50 */         return RIGHT;
/*     */     } 
/*  52 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String name_;
/*     */ 
/*     */   
/*     */   private final int jposValue_;
/*     */ 
/*     */   
/*     */   private static Map<Integer, AlignmentType> valuesByJposValue_;
/*     */ 
/*     */ 
/*     */   
/*     */   private AlignmentType(String argName, int argJposValue) {
/*  69 */     this.name_ = argName;
/*  70 */     this.jposValue_ = argJposValue;
/*  71 */     if (valuesByJposValue_ == null) {
/*  72 */       valuesByJposValue_ = new HashMap<>();
/*     */     }
/*  74 */     valuesByJposValue_.put(Integer.valueOf(argJposValue), this);
/*     */   }
/*     */   
/*     */   public String getName() {
/*  78 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int toJposEnum() {
/*  87 */     return this.jposValue_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  97 */     return getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object readResolve() {
/* 107 */     Object o = forJposEnum(this.jposValue_);
/* 108 */     if (o == null) {
/* 109 */       logger_.warn("problem resolving for value " + this.jposValue_);
/* 110 */       return this;
/*     */     } 
/*     */     
/* 113 */     return o;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\hardware\AlignmentType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */