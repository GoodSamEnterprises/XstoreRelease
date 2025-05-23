/*     */ package dtv.data2.dataserver;
/*     */ 
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang3.builder.HashCodeBuilder;
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
/*     */ 
/*     */ public abstract class AbstractAction
/*     */   implements IDataServerAction
/*     */ {
/*  23 */   private static final Logger _logger = Logger.getLogger(AbstractAction.class);
/*  24 */   private int _processingOrder = 0;
/*     */   
/*     */   private String _value;
/*     */   
/*     */   private String _type;
/*     */   
/*     */   private String _ownerId;
/*     */   
/*     */   public int compareTo(IDataServerAction argOther) {
/*  33 */     return getOrder() - argOther.getOrder();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOrder() {
/*  39 */     return this._processingOrder;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValue() {
/*  45 */     return this._value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  51 */     return (new HashCodeBuilder(17, 37)).append(this._type).append(this._processingOrder).append(this._value)
/*  52 */       .appendSuper(super.hashCode()).toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ActionResult process(Map<String, String> argParameters) {
/*  58 */     _logger.info("Processing " + toString());
/*     */     
/*  60 */     ActionResult result = null;
/*  61 */     long startTime = System.currentTimeMillis();
/*     */     
/*     */     try {
/*  64 */       processImpl(argParameters);
/*  65 */       result = ActionResult.makeSuccess();
/*     */     }
/*  67 */     catch (Exception ex) {
/*  68 */       result = ActionResult.makeFailure(ex);
/*     */     } finally {
/*     */       
/*  71 */       long processingTime = System.currentTimeMillis() - startTime;
/*  72 */       result.setProcessingTime(processingTime);
/*  73 */       String logMessage = toString() + "processed. Results = " + result;
/*     */       
/*  75 */       if (result.isSuccess()) {
/*  76 */         _logger.info(logMessage);
/*     */       } else {
/*     */         
/*  79 */         _logger.error(logMessage, result.getError());
/*     */       } 
/*     */     } 
/*     */     
/*  83 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrder(int argOrder) {
/*  89 */     this._processingOrder = argOrder;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOwnerId(String argOwnerId) {
/*  95 */     this._ownerId = argOwnerId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, Object argValue) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String argType) {
/* 107 */     this._type = argType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argValue) {
/* 113 */     this._value = argValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 119 */     StringBuilder builder = new StringBuilder("Action ");
/*     */     
/* 121 */     if (!StringUtils.isEmpty(this._ownerId)) {
/* 122 */       builder.append(this._ownerId + ":");
/*     */     }
/*     */     
/* 125 */     builder.append(this._type);
/* 126 */     builder.append(" [" + this._value + "] ");
/* 127 */     return builder.toString();
/*     */   }
/*     */   
/*     */   protected abstract Object processImpl(Map<String, String> paramMap) throws Exception;
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\AbstractAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */