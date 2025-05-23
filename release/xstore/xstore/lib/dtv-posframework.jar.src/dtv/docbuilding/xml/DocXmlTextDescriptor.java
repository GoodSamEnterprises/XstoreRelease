/*     */ package dtv.docbuilding.xml;
/*     */ 
/*     */ import dtv.util.CompositeObject;
/*     */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*     */ import org.apache.commons.lang3.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
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
/*     */ public class DocXmlTextDescriptor
/*     */ {
/*     */   private final CompositeObject.ThreePiece<String, String, Boolean> _values;
/*     */   
/*     */   public static DocXmlTextDescriptor makeExpression(String argExpr, String argFormatterName) {
/*  28 */     return new DocXmlTextDescriptor(argExpr, argFormatterName, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DocXmlTextDescriptor makeLiteral(String argLiteral) {
/*  38 */     return new DocXmlTextDescriptor(argLiteral, null, true);
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
/*     */   protected DocXmlTextDescriptor(String argLiteralOrExpr, String argFormatterName, boolean argLiteral) {
/*  55 */     this._values = CompositeObject.make(argLiteralOrExpr, argFormatterName, Boolean.valueOf(argLiteral));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObj) {
/*  61 */     if (argObj == this) return true; 
/*  62 */     if (argObj == null) return false; 
/*  63 */     if (!(argObj instanceof DocXmlTextDescriptor)) return false;
/*     */     
/*  65 */     return (new EqualsBuilder())
/*  66 */       .appendSuper(super.equals(argObj))
/*  67 */       .append(this._values, ((DocXmlTextDescriptor)argObj)._values)
/*  68 */       .isEquals();
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
/*     */   public String getFormatterName() {
/*  80 */     return (String)this._values.b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLiteralOrExpression() {
/*  88 */     return (String)this._values.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  94 */     return (new HashCodeBuilder()).append(this._values).toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLiteral() {
/* 104 */     return ((Boolean)this._values.c()).booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 110 */     return (new ToStringBuilder(this)).append("values", this._values).toString();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\DocXmlTextDescriptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */