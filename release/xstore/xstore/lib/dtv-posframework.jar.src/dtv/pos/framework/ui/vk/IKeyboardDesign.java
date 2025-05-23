/*    */ package dtv.pos.framework.ui.vk;
/*    */ 
/*    */ import dtv.ui.UIResourceManager;
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Font;
/*    */ import java.awt.Rectangle;
/*    */ import java.util.List;
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
/*    */ public interface IKeyboardDesign
/*    */ {
/* 22 */   public static final Font FONT_SMALL = UIResourceManager.getInstance().getFont("_fontKeyboardSmall");
/*    */   
/* 24 */   public static final Font FONT_MEDIUM = UIResourceManager.getInstance().getFont("_fontKeyboardMedium");
/*    */   
/* 26 */   public static final Font FONT_LARGE = UIResourceManager.getInstance().getFont("_fontKeyboardLarge");
/*    */ 
/*    */   
/* 29 */   public static final Color COLOR_SEPARATOR_LINE = Color.WHITE;
/*    */   
/* 31 */   public static final Color COLOR_BUTTON_PANEL_BACKGROUND = new Color(0, 0, 0, 0);
/*    */   
/* 33 */   public static final Color COLOR_KBD_TEXT = Color.BLACK;
/*    */   
/* 35 */   public static final Color COLOR_KBD_BACKGROUND = new Color(OnScreenKeyboard.RGBToFloat(255), 
/* 36 */       OnScreenKeyboard.RGBToFloat(255), OnScreenKeyboard.RGBToFloat(255), 0.5F);
/*    */   
/*    */   Color getBackgroundColor();
/*    */   
/*    */   Rectangle getBounds();
/*    */   
/*    */   Rectangle getButtonBound(String paramString);
/*    */   
/*    */   Color getButtonPanelBackground();
/*    */   
/*    */   Dimension getButtonSize();
/*    */   
/*    */   Font getFont();
/*    */   
/*    */   Color getLineSeparatorColor();
/*    */   
/*    */   List<Rectangle> getPanelBounds();
/*    */   
/*    */   Rectangle getSlideOutButtonBounds();
/*    */   
/*    */   Color getTextColor();
/*    */   
/*    */   void setOwnerBounds(Rectangle paramRectangle);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\IKeyboardDesign.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */