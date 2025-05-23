/*     */ package dtv.pos.framework.action.type;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.action.IXstKeyStroke;
/*     */ import dtv.util.StringUtils;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.swing.KeyStroke;
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
/*     */ public class XstKeyStroke
/*     */   implements IXstKeyStroke
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  43 */   private static final Logger logger_ = Logger.getLogger(XstKeyStroke.class);
/*  44 */   private static final Map<KeyStroke, XstKeyStroke> keyStrokes_ = new HashMap<>();
/*  45 */   private static Map<String, XstKeyStroke> values_ = new HashMap<>();
/*     */   private static final String YES = "Yes";
/*     */   private static final String NO = "No";
/*     */   
/*     */   public static XstKeyStroke forKeyStroke(KeyStroke keyStroke) {
/*  50 */     XstKeyStroke found = keyStrokes_.get(keyStroke);
/*     */     
/*  52 */     if (found == null) {
/*  53 */       found = new XstKeyStroke(keyStroke);
/*     */     }
/*  55 */     return found;
/*     */   }
/*     */ 
/*     */   
/*     */   private final String name_;
/*     */   private KeyStroke keyStroke_;
/*     */   private String displayText_;
/*     */   
/*     */   public static XstKeyStroke forName(String name) {
/*  64 */     if (name == null) {
/*  65 */       return null;
/*     */     }
/*     */     
/*  68 */     String mapName = name.trim().toUpperCase();
/*     */     
/*  70 */     XstKeyStroke foundKey = values_.get(mapName);
/*     */     
/*  72 */     if (foundKey == null) {
/*     */ 
/*     */ 
/*     */       
/*  76 */       if (name.equals("Yes") || name.equals("No")) {
/*  77 */         if (name.equals("Yes")) {
/*  78 */           new I18nKeyStroke("Yes", FormattableFactory.getInstance().getTranslatable("_keyYes"));
/*     */         } else {
/*     */           
/*  81 */           new I18nKeyStroke("No", FormattableFactory.getInstance().getTranslatable("_keyNo"));
/*     */         } 
/*     */         
/*  84 */         return values_.get(mapName);
/*     */       } 
/*     */       
/*  87 */       KeyStroke keyStroke = buildKeyStroke(name);
/*     */       
/*  89 */       if (keyStroke == null) {
/*  90 */         logger_.warn("[" + name + "]: Configuration setting not supported!");
/*     */       } else {
/*     */         
/*  93 */         foundKey = new XstKeyStroke(name, keyStroke);
/*  94 */         values_.put(mapName, foundKey);
/*     */       } 
/*     */     } 
/*  97 */     return foundKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static KeyStroke buildKeyStroke(String argKeyStrokeCode) {
/* 104 */     String[] keyNameElements = argKeyStrokeCode.trim().split(" ");
/*     */ 
/*     */     
/* 107 */     for (int i = 0; i < keyNameElements.length - 1; i++) {
/* 108 */       keyNameElements[i] = keyNameElements[i].toLowerCase();
/*     */     }
/*     */ 
/*     */     
/* 112 */     String keyStrokeName = keyNameElements[keyNameElements.length - 1];
/* 113 */     if (!isAlphaKeyStroke(keyStrokeName)) {
/* 114 */       keyNameElements[keyNameElements.length - 1] = keyStrokeName.toUpperCase();
/*     */     }
/*     */     
/* 117 */     String convertedKeyStrokeName = StringUtils.join((Object[])keyNameElements, " ");
/*     */ 
/*     */     
/* 120 */     KeyStroke keyStroke = KeyStroke.getKeyStroke(convertedKeyStrokeName);
/*     */     
/* 122 */     return keyStroke;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isAlphaKeyStroke(String argKeyStrokeName) {
/* 127 */     return (argKeyStrokeName.length() == 1 && !argKeyStrokeName.equals(argKeyStrokeName.toUpperCase()));
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
/*     */   XstKeyStroke(String name, KeyStroke keyStroke) {
/* 144 */     this.name_ = name.trim().toUpperCase();
/* 145 */     setKeyStroke(keyStroke);
/*     */     
/* 147 */     if (getKeyStroke() != null) {
/* 148 */       setDisplayText(KeyEvent.getKeyText(getKeyStroke().getKeyCode()));
/*     */     }
/*     */     
/* 151 */     values_.put(this.name_, this);
/*     */   }
/*     */   
/*     */   private XstKeyStroke(KeyStroke keyStroke) {
/* 155 */     this.name_ = "";
/* 156 */     setKeyStroke(keyStroke);
/* 157 */     setDisplayText(KeyEvent.getKeyText(keyStroke.getKeyCode()));
/*     */     
/* 159 */     keyStrokes_.put(keyStroke, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public IXstActionKey get(String key) {
/* 164 */     return (IXstActionKey)forName(key);
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
/*     */   public String getDisplayText() {
/* 179 */     return this.displayText_;
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
/*     */   public KeyStroke getKeyStroke() {
/* 191 */     return this.keyStroke_;
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
/*     */   public String getName() {
/* 203 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayText(String displayText) {
/* 212 */     this.displayText_ = displayText;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeyStroke(KeyStroke keyStroke) {
/* 221 */     this.keyStroke_ = keyStroke;
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
/*     */   public String toString() {
/* 233 */     return getDisplayText();
/*     */   }
/*     */   
/*     */   private static class I18nKeyStroke
/*     */     extends XstKeyStroke {
/*     */     private static final long serialVersionUID = 1L;
/*     */     private final IFormattable keyStrokeText_;
/*     */     
/*     */     I18nKeyStroke(String argName, IFormattable argKeyStrokeText) {
/* 242 */       super(argName, null);
/* 243 */       this.keyStrokeText_ = argKeyStrokeText;
/*     */     }
/*     */ 
/*     */     
/*     */     public KeyStroke getKeyStroke() {
/* 248 */       if (this.keyStrokeText_ == null) {
/* 249 */         return null;
/*     */       }
/*     */       
/* 252 */       return KeyStroke.getKeyStroke(this.keyStrokeText_.toString(OutputContextType.VIEW));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\type\XstKeyStroke.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */