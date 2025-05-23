/*    */ package dtv.pos.framework.biometric.fingerprint;
/*    */ 
/*    */ import dtv.pos.iframework.type.AbstractCodeEnum;
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public class FingerEnum
/*    */   extends AbstractCodeEnum<FingerEnum>
/*    */ {
/* 21 */   private static final Logger logger_ = Logger.getLogger(FingerEnum.class);
/*    */ 
/*    */   
/* 24 */   public static final FingerEnum LEFT_LITTLE_FINGER = new FingerEnum("LEFT_LITTLE_FINGER");
/*    */   
/* 26 */   public static final FingerEnum LEFT_RING_FINGER = new FingerEnum("LEFT_RING_FINGER");
/*    */   
/* 28 */   public static final FingerEnum LEFT_MIDDLE_FINGER = new FingerEnum("LEFT_MIDDLE_FINGER");
/*    */   
/* 30 */   public static final FingerEnum LEFT_INDEX_FINGER = new FingerEnum("LEFT_INDEX_FINGER");
/*    */   
/* 32 */   public static final FingerEnum LEFT_THUMB = new FingerEnum("LEFT_THUMB");
/*    */   
/* 34 */   public static final FingerEnum RIGHT_THUMB = new FingerEnum("RIGHT_THUMB");
/*    */   
/* 36 */   public static final FingerEnum RIGHT_INDEX_FINGER = new FingerEnum("RIGHT_INDEX_FINGER");
/*    */   
/* 38 */   public static final FingerEnum RIGHT_MIDDLE_FINGER = new FingerEnum("RIGHT_MIDDLE_FINGER");
/*    */   
/* 40 */   public static final FingerEnum RIGHT_RING_FINGER = new FingerEnum("RIGHT_RING_FINGER");
/*    */   
/* 42 */   public static final FingerEnum RIGHT_LITTLE_FINGER = new FingerEnum("RIGHT_LITTLE_FINGER");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static Map<String, FingerEnum> values_;
/*    */ 
/*    */ 
/*    */   
/*    */   private static FingerEnum[] sortedInstances_;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static FingerEnum forName(String argName) {
/* 57 */     if (argName == null) {
/* 58 */       return null;
/*    */     }
/* 60 */     FingerEnum found = values_.get(argName.trim().toUpperCase());
/* 61 */     if (found == null) {
/* 62 */       logger_.warn("There is no instance of [" + FingerEnum.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*    */     }
/*    */     
/* 65 */     return found;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static FingerEnum[] getInstances() {
/* 74 */     if (sortedInstances_ == null) {
/* 75 */       sortedInstances_ = (FingerEnum[])values_.values().toArray((Object[])new FingerEnum[0]);
/* 76 */       Arrays.sort((Object[])sortedInstances_);
/*    */     } 
/* 78 */     return sortedInstances_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected FingerEnum(String argName) {
/* 87 */     super(FingerEnum.class, argName);
/* 88 */     if (values_ == null) {
/* 89 */       values_ = new HashMap<>();
/*    */     }
/* 91 */     values_.put(getCode(), this);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\biometric\fingerprint\FingerEnum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */