/*    */ package dtv.pos.iframework.form.design.type;
/*    */ 
/*    */ import dtv.util.config.IReflectionParameterCapable;
/*    */ import java.util.Arrays;
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
/*    */ public abstract class FontSize
/*    */   implements IReflectionParameterCapable<FontSize>
/*    */ {
/* 19 */   public static final FontSize DEFAULT = new FontSize()
/*    */     {
/*    */       public String getConfigValue() {
/* 22 */         return null;
/*    */       }
/*    */ 
/*    */       
/*    */       public int getSize(int argSize) {
/* 27 */         return argSize;
/*    */       }
/*    */ 
/*    */       
/*    */       public String toString() {
/* 32 */         return "<default>";
/*    */       }
/*    */     };
/* 35 */   private static final FontSize[] COMMON_FONT_SIZES = new FontSize[] { get("-4"), get("-2"), DEFAULT, 
/* 36 */       get("+2"), get("+4"), get("+6"), get("+8"), 
/* 37 */       get("+10"), get("+12"), get("+16"), get("+20"), 
/* 38 */       get("+24"), get("+28") };
/*    */   
/*    */   public static FontSize get(String argValue) {
/* 41 */     if (argValue == null) {
/* 42 */       return DEFAULT;
/*    */     }
/* 44 */     if (argValue.length() == 0) {
/* 45 */       return DEFAULT;
/*    */     }
/* 47 */     if ("0".equals(argValue) || "+0".equals(argValue)) {
/* 48 */       return DEFAULT;
/*    */     }
/*    */ 
/*    */     
/* 52 */     switch (argValue.charAt(0)) {
/*    */       case '+':
/*    */       case '-':
/* 55 */         return new RelativeFontSize(argValue);
/*    */     } 
/*    */ 
/*    */     
/* 59 */     return new AbsoluteFontSize(argValue);
/*    */   }
/*    */ 
/*    */   
/*    */   public static FontSize[] getCommonFontSizes() {
/* 64 */     return Arrays.<FontSize>copyOf(COMMON_FONT_SIZES, COMMON_FONT_SIZES.length);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getConfigDataType() {
/* 69 */     return "String";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<FontSize> getParamDataType() {
/* 77 */     return FontSize.class;
/*    */   }
/*    */ 
/*    */   
/*    */   public FontSize getParamValue() {
/* 82 */     return this;
/*    */   }
/*    */   
/*    */   public abstract String getConfigValue();
/*    */   
/*    */   public abstract int getSize(int paramInt);
/*    */   
/*    */   public abstract String toString();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\design\type\FontSize.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */