/*    */ package dtv.pos.iframework.hardware;
/*    */ 
/*    */ import dtv.barcode.BarcodeType;
/*    */ import dtv.util.crypto.EncString;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Barcode
/*    */   extends AbstractInput
/*    */   implements IBarcode
/*    */ {
/*    */   private final BarcodeType type_;
/*    */   
/*    */   public Barcode(String argData, BarcodeType argType, IHardwareType<?> argSourceType) {
/* 31 */     this(argData, argType, argSourceType, null);
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
/*    */ 
/*    */   
/*    */   public Barcode(String argData, BarcodeType argType, IHardwareType<?> argSourceType, Map<String, Object> argAdditionalInformation) {
/* 46 */     super(EncString.valueOf(argData), argSourceType, false, argAdditionalInformation);
/* 47 */     this.type_ = argType;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BarcodeType getType() {
/* 53 */     return this.type_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 62 */     return getType().toString() + ":" + EncString.getSensitiveData(getData());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\hardware\Barcode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */