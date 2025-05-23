/*     */ package dtv.pos.framework.ui;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.util.StringUtils;
/*     */ import javax.swing.ImageIcon;
/*     */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*     */ import org.apache.commons.lang3.builder.HashCodeBuilder;
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
/*     */ 
/*     */ public abstract class TextViewElement
/*     */ {
/*     */   private static final String DEFAULT_ICON_BUNDLE_KEY = "_iconCustomerMessageListViewDefault";
/*  33 */   protected static final FormattableFactory FF = FormattableFactory.getInstance();
/*     */   
/*     */   private final IFormattable formattable_;
/*     */   private final ImageIcon image_;
/*     */   
/*     */   protected TextViewElement() {
/*  39 */     this.image_ = null;
/*  40 */     this.formattable_ = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected TextViewElement(IFormattable argText) {
/*  45 */     this(argText, "_iconCustomerMessageListViewDefault");
/*     */   }
/*     */ 
/*     */   
/*     */   protected TextViewElement(IFormattable argText, ImageIcon argImage) {
/*  50 */     if (argText == null) {
/*  51 */       throw new IllegalArgumentException("Text cannot be null");
/*     */     }
/*  53 */     this.formattable_ = argText;
/*  54 */     this.image_ = argImage;
/*     */   }
/*     */ 
/*     */   
/*     */   protected TextViewElement(IFormattable argText, String argResourceName) {
/*  59 */     if (argText == null) {
/*  60 */       throw new IllegalArgumentException("Text cannot be null");
/*     */     }
/*  62 */     this.formattable_ = argText;
/*  63 */     if (StringUtils.isEmpty(argResourceName)) {
/*  64 */       this.image_ = null;
/*     */     } else {
/*     */       
/*  67 */       this.image_ = UIResourceManager.getInstance().getImageIcon(argResourceName);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/*     */     boolean result;
/*  75 */     if (this == argOther) {
/*  76 */       result = true;
/*     */     }
/*  78 */     else if (argOther == null || getClass() != argOther.getClass()) {
/*  79 */       result = false;
/*     */     } else {
/*     */       
/*  82 */       TextViewElement other = (TextViewElement)argOther;
/*  83 */       EqualsBuilder eq = new EqualsBuilder();
/*  84 */       eq.append(getText(), other.getText());
/*  85 */       eq.append(getImage(), other.getImage());
/*  86 */       result = eq.isEquals();
/*     */     } 
/*  88 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public ImageIcon getImage() {
/*  93 */     return this.image_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IFormattable getText() {
/*  98 */     return this.formattable_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 104 */     HashCodeBuilder hash = new HashCodeBuilder(727, 2179);
/* 105 */     hash.append(getClass().getName());
/* 106 */     hash.append(getImage());
/* 107 */     hash.append(getText());
/* 108 */     return hash.toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 115 */     return toString(OutputContextType.VIEW);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString(OutputContextType argContext) {
/* 120 */     IFormattable fmt = getText();
/* 121 */     return fmt.toString(argContext);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\TextViewElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */