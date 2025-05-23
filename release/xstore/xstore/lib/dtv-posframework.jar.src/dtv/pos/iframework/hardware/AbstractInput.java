/*    */ package dtv.pos.iframework.hardware;
/*    */ 
/*    */ import dtv.util.crypto.EncString;
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
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
/*    */ public abstract class AbstractInput
/*    */   implements IInput
/*    */ {
/*    */   private final EncString data_;
/*    */   private final IHardwareType<?> source_;
/*    */   private final boolean isError_;
/*    */   private final Map<String, Object> additionalInformation_;
/*    */   
/*    */   public AbstractInput() {
/* 26 */     this((EncString)null, (IHardwareType<?>)null, false, (Map<String, Object>)null);
/*    */   }
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
/*    */   public AbstractInput(EncString argData, IHardwareType<?> argSourceType, boolean argIsError, Map<String, Object> argAdditionalInformation) {
/* 39 */     this.data_ = argData;
/* 40 */     this.source_ = argSourceType;
/* 41 */     this.isError_ = argIsError;
/* 42 */     if (argAdditionalInformation == null) {
/* 43 */       this.additionalInformation_ = Collections.emptyMap();
/*    */     } else {
/*    */       
/* 46 */       this.additionalInformation_ = argAdditionalInformation;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public AbstractInput(IHardwareType<?> argSourceType) {
/* 55 */     this((EncString)null, argSourceType, false, (Map<String, Object>)null);
/*    */   }
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public AbstractInput(String argData, IHardwareType<?> argSourceType, boolean argIsError, Map<String, Object> argAdditionalInformation) {
/* 61 */     this(EncString.valueOf(argData), argSourceType, argIsError, argAdditionalInformation);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, Object> copyAdditionalInformation() {
/* 70 */     return new HashMap<>(this.additionalInformation_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getAdditionalInformation(String argInformationKey) {
/* 76 */     return this.additionalInformation_.get(argInformationKey);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EncString getData() {
/* 82 */     return this.data_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IHardwareType<?> getSourceType() {
/* 88 */     return this.source_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isError() {
/* 94 */     return this.isError_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\hardware\AbstractInput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */