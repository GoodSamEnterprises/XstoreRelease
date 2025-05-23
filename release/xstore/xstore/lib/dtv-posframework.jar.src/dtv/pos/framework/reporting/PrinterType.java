/*    */ package dtv.pos.framework.reporting;
/*    */ 
/*    */ import dtv.hardware.service.posprinter.JavaPrinterServiceAttributeHelper;
/*    */ import dtv.util.CompositeObject;
/*    */ import java.util.Collection;
/*    */ import java.util.LinkedList;
/*    */ import java.util.Map;
/*    */ import javax.print.attribute.AttributeSet;
/*    */ import org.springframework.beans.factory.BeanNameAware;
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
/*    */ public class PrinterType
/*    */   implements BeanNameAware
/*    */ {
/*    */   private String name_;
/* 26 */   private final Collection<CompositeObject.TwoPiece<String, Object>> attributes_ = new LinkedList<>();
/*    */ 
/*    */   
/*    */   public AttributeSet getAttributes() {
/* 30 */     return JavaPrinterServiceAttributeHelper.getPrinterServiceAttributes(this.attributes_);
/*    */   }
/*    */   
/*    */   public String getName() {
/* 34 */     return this.name_;
/*    */   }
/*    */   
/*    */   public void setAttributes(Map<String, Object> argAttributes) {
/* 38 */     for (String key : argAttributes.keySet()) {
/* 39 */       this.attributes_.add(CompositeObject.make(key, argAttributes.get(key)));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void setBeanName(String argName) {
/* 45 */     this.name_ = argName;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\PrinterType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */