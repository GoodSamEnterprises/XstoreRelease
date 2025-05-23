/*     */ package dtv.pos.framework.ui.vk;
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.FormatterType;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.i18n.TranslationHelper;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.framework.StationController;
/*     */ import dtv.pos.framework.ui.vk.config.KeyboardConfig;
/*     */ import dtv.pos.framework.ui.vk.config.KeyboardConfigHelper;
/*     */ import dtv.pos.framework.ui.vk.config.LayoutConfig;
/*     */ import dtv.pos.framework.ui.vk.config.PanelConfig;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.ui.touch.TouchHelper;
/*     */ import dtv.util.ImageUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.awt.AWTException;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Image;
/*     */ import java.awt.KeyboardFocusManager;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Robot;
/*     */ import java.awt.Window;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import javax.inject.Inject;
/*     */ import javax.swing.KeyStroke;
/*     */ import javax.swing.text.JTextComponent;
/*     */ import org.apache.log4j.Level;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.apache.log4j.Priority;
/*     */ 
/*     */ public class OnScreenKeyboard implements IOnScreenKeyboard {
/*  41 */   private static final Logger logger_ = Logger.getLogger(OnScreenKeyboard.class);
/*     */   
/*     */   private static KeyboardConfig keyboardConfig_;
/*     */   
/*  45 */   private static final String[] IMG_BUTTONS_DEFAULT = new String[] { "_imgBtnDefault", "_imgBtnTallDefault", "_imgBtnWideDefault" };
/*     */   
/*  47 */   private static final String[] IMG_BUTTONS_PRESSED = new String[] { "_imgBtnPressed", "_imgBtnTallPressed", "_imgBtnWidePressed" };
/*     */   
/*     */   private static List<Image[]> imagesList;
/*     */   
/*     */   private static IOnScreenKeyboard instance_;
/*     */   
/*     */   private final List<Keyboard> keyboards_;
/*     */   private final Window owner_;
/*     */   private final boolean isSliding_;
/*     */   
/*     */   public static void ensureKeyboardIsHiding() {
/*  58 */     if (!(getInstance() instanceof DummyKeyboard)) {
/*  59 */       IOnScreenKeyboard keyboard = getInstance();
/*  60 */       if (keyboard.isShowingImpl())
/*  61 */         keyboard.hideImpl(); 
/*     */     } 
/*     */   }
/*     */   private final boolean isSwipeToClose_; private final boolean isSwipeToSwitchLayout_; private final boolean hasSlidingBump_;
/*     */   private final String layout_;
/*     */   @Inject
/*     */   private TouchHelper _touchHelper;
/*     */   
/*     */   public static void ensureKeyboardIsShowing() {
/*  70 */     if (!(getInstance() instanceof DummyKeyboard)) {
/*  71 */       IOnScreenKeyboard keyboard = getInstance();
/*  72 */       if (!keyboard.isShowingImpl()) {
/*  73 */         keyboard.showImpl();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized IOnScreenKeyboard getInstance() {
/*  85 */     if (instance_ == null) {
/*  86 */       Window kbParent = StationController.getAppFrame().getFrameComponent();
/*     */       
/*  88 */       if (ConfigurationMgr.isOnScreenKeyboardEnabled() && kbParent != null) {
/*  89 */         logger_.info("Loading and initializing the on screen keyboard.");
/*  90 */         String implName = System.getProperty(OnScreenKeyboard.class.getName());
/*     */         
/*  92 */         if (StringUtils.isEmpty(implName)) {
/*     */ 
/*     */ 
/*     */           
/*  96 */           instance_ = new OnScreenKeyboard(kbParent, ConfigurationMgr.getOnScreenKeyboardLayout(), ConfigurationMgr.isOnScreenKeyboardSliding(), ConfigurationMgr.isOnScreenKeyboardSwipeToClose(), ConfigurationMgr.isOnScreenKeyboardSwipeToSwitchLayout(), ConfigurationMgr.isOnScreenKeyboardSlidingBump());
/*     */         } else {
/*     */           
/*     */           try {
/* 100 */             instance_ = (IOnScreenKeyboard)Class.forName(implName).newInstance();
/*     */           }
/* 102 */           catch (Exception ex) {
/* 103 */             throw new ExceptionInInitializerError(ex);
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         
/* 108 */         logger_.warn("Keyboard not enabled or xstore frame was not available yet. Loading a dummy keyboard.");
/* 109 */         instance_ = new DummyKeyboard();
/*     */       } 
/*     */       
/* 112 */       kbParent.addComponentListener(new KeyboardResizeListener());
/*     */     } 
/*     */     
/* 115 */     return instance_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getTranslation(String argKey) {
/* 124 */     return getTranslation(argKey, LayoutConfig.LOCALE_DEFAULT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getTranslation(String argKey, Locale argLocale) {
/* 134 */     FormatterType formatterType = null;
/*     */     
/* 136 */     if (TranslationHelper.getInstance().isTranslationKey(argKey) || 
/* 137 */       TranslationHelper.getInstance().isDatabaseTranslationKey(argKey)) {
/* 138 */       formatterType = FormatterType.TEXT;
/*     */     } else {
/*     */       
/* 141 */       formatterType = FormatterType.SIMPLE;
/*     */     } 
/*     */     
/* 144 */     return FormattableFactory.getInstance()
/* 145 */       .getSimpleFormattable(argKey, formatterType.deriveSubtype("dtv.pos.i18n.keyboard"))
/* 146 */       .toString(OutputContextType.VIEW, argLocale);
/*     */   }
/*     */   
/*     */   public static boolean isKeyboardComponent(Component c) {
/* 150 */     Component parent = c;
/* 151 */     while (parent != null && !(parent instanceof Keyboard)) {
/* 152 */       parent = parent.getParent();
/*     */     }
/*     */     
/* 155 */     if (parent != null) {
/* 156 */       return true;
/*     */     }
/*     */     
/* 159 */     return (c != null && c instanceof JTextComponent && ((JTextComponent)c).isEditable() && c.isVisible() && c
/* 160 */       .isValid() && c.isEnabled() && c.getWidth() > 0 && c.getHeight() > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static Image getButtonImage(Dimension buttonSize, boolean pressed) {
/* 170 */     if (imagesList == null) {
/* 171 */       loadButtonImages();
/*     */     }
/* 173 */     double ratio = (buttonSize.getHeight() == 0.0D) ? 0.0D : (buttonSize.getWidth() / buttonSize.getHeight());
/*     */     
/* 175 */     double match = 0.0D;
/* 176 */     Image image = null;
/*     */     
/* 178 */     for (Image[] images : imagesList) {
/* 179 */       double imageRatio = images[0].getWidth(null) / images[0].getHeight(null);
/* 180 */       if (Math.abs(imageRatio - ratio) > match && image != null) {
/*     */         break;
/*     */       }
/* 183 */       match = Math.abs(imageRatio - ratio);
/* 184 */       if (pressed) {
/* 185 */         image = images[1];
/*     */         continue;
/*     */       } 
/* 188 */       image = images[0];
/*     */     } 
/*     */ 
/*     */     
/* 192 */     return image;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static Image getButtonImage(String urlOrTranslation) {
/* 201 */     if (TranslationHelper.getInstance().isTranslationKey(urlOrTranslation)) {
/* 202 */       return UIResourceManager.getInstance().getImage(urlOrTranslation);
/*     */     }
/*     */     
/* 205 */     return ImageUtils.getImage(urlOrTranslation);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static KeyboardConfig getKeyboardConfig() {
/* 213 */     if (keyboardConfig_ == null) {
/* 214 */       keyboardConfig_ = (KeyboardConfig)KeyboardConfigHelper.getInstance().getRootConfig();
/*     */     }
/*     */     
/* 217 */     return keyboardConfig_;
/*     */   }
/*     */   
/*     */   protected static Window getKeyboardOwner() {
/* 221 */     if (instance_ != null) {
/* 222 */       return instance_.getKeyboardOwnerImpl();
/*     */     }
/*     */     
/* 225 */     return null;
/*     */   }
/*     */   
/*     */   protected static KeyEvent getKeyEvent(char keyStroke, int modifiers, int type) {
/* 229 */     Component source = getKeyboardOwner().getMostRecentFocusOwner();
/* 230 */     if (source == null) {
/* 231 */       logger_.warn("Not focused! May result in an exception.");
/*     */     }
/* 233 */     return getKeyEvent(source, keyStroke, modifiers, type);
/*     */   }
/*     */   
/*     */   protected static KeyEvent getKeyEvent(Component source, char keyStroke, int modifiers, int type) {
/* 237 */     int keyCode = 0, keyLocation = 1;
/* 238 */     if (Character.isLetter(keyStroke)) {
/* 239 */       keyCode = Character.isUpperCase(keyStroke) ? keyStroke : (keyStroke - 32);
/*     */     }
/* 241 */     else if (Character.isDigit(keyStroke)) {
/* 242 */       keyCode = 48 + Character.getNumericValue(keyStroke);
/*     */     } 
/*     */     
/* 245 */     if (type == 400) {
/* 246 */       keyCode = 0;
/* 247 */       keyLocation = 0;
/*     */     } 
/*     */     
/* 250 */     return new KeyEvent(source, type, System.currentTimeMillis(), modifiers, keyCode, keyStroke, keyLocation);
/*     */   }
/*     */   
/*     */   protected static KeyEvent getKeyEvent(Component source, int keyCode, int modifiers) {
/* 254 */     return new KeyEvent(source, 401, System.currentTimeMillis(), modifiers, keyCode, '￿', 1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected static KeyEvent getKeyEvent(int keyCode, int modifiers) {
/* 259 */     Component source = getKeyboardOwner().getMostRecentFocusOwner();
/* 260 */     return getKeyEvent(source, keyCode, modifiers);
/*     */   }
/*     */   
/*     */   protected static KeyEvent getKeyEvent(String keyStroke, int modifiers, int type) {
/* 264 */     if (isKeyTyped(keyStroke)) {
/* 265 */       return getKeyEvent(keyStroke.toCharArray()[0], modifiers, type);
/*     */     }
/*     */     
/* 268 */     KeyStroke key = buildKeyStroke(keyStroke);
/* 269 */     return getKeyEvent(key.getKeyCode(), key.getModifiers());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static LayoutConfig getLayoutConfig(Locale argLocale) {
/* 279 */     return getKeyboardConfig().getLayoutConfig(argLocale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static LayoutConfig getLayoutConfig(String argName) {
/* 288 */     return getKeyboardConfig().getLayoutConfig(argName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static List<LayoutConfig> getLayoutConfigurations() {
/* 296 */     return getKeyboardConfig().getLayoutConfigurations();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static boolean isKeyTyped(String keyStroke) {
/* 305 */     if (keyStroke != null && keyStroke.length() == 1) {
/* 306 */       return true;
/*     */     }
/* 308 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected static void loadButtonImages() {
/* 313 */     imagesList = (List)new ArrayList<>();
/*     */     
/* 315 */     for (int i = 0; i < IMG_BUTTONS_DEFAULT.length; i++) {
/* 316 */       Image imageDefault = ImageUtils.getImage(getTranslation(IMG_BUTTONS_DEFAULT[i]));
/* 317 */       Image imagePressed = ImageUtils.getImage(getTranslation(IMG_BUTTONS_PRESSED[i]));
/* 318 */       imagesList.add(new Image[] { imageDefault, imagePressed });
/*     */     } 
/*     */     
/* 321 */     Collections.sort((List)imagesList, (Comparator)new Comparator<Image[]>()
/*     */         {
/*     */           public int compare(Image[] img1, Image[] img2) {
/* 324 */             double ratio1 = img1[0].getWidth(null) / img1[0].getHeight(null);
/* 325 */             double ratio2 = img2[0].getWidth(null) / img2[0].getHeight(null);
/* 326 */             return Double.compare(ratio1, ratio2);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   protected static void log(Level level, String message) {
/* 333 */     log(level, message, null);
/*     */   }
/*     */   
/*     */   protected static void log(Level level, String message, Throwable throwable) {
/* 337 */     StringBuffer buffer = new StringBuffer("OSK->");
/* 338 */     if (level != null) {
/* 339 */       if (message != null) {
/* 340 */         buffer.append(" ");
/* 341 */         buffer.append(message);
/*     */       } 
/* 343 */       if (throwable != null) {
/* 344 */         buffer.append(" Throwed: ");
/* 345 */         buffer.append(throwable.toString());
/*     */       } 
/*     */       
/* 348 */       logger_.log((Priority)level, buffer.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void postKeyEvent(char keyStroke) {
/* 357 */     postKeyEvent(getKeyEvent(keyStroke, 0, 401));
/* 358 */     postKeyEvent(getKeyEvent(keyStroke, 0, 400));
/* 359 */     postKeyEvent(getKeyEvent(keyStroke, 0, 402));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void postKeyEvent(int keyCode) {
/* 367 */     postKeyEvent(getKeyEvent(keyCode, 0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void postKeyEvent(KeyEvent keyEvent) {
/* 375 */     KeyboardFocusManager.getCurrentKeyboardFocusManager().dispatchEvent(keyEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void postKeyEvent(String keyStroke) {
/* 385 */     if (isKeyTyped(keyStroke)) {
/* 386 */       postKeyEvent(keyStroke.toCharArray()[0]);
/*     */     } else {
/*     */       
/* 389 */       KeyStroke key = buildKeyStroke(keyStroke);
/*     */       
/* 391 */       Robot robot = null;
/*     */       try {
/* 393 */         robot = new Robot();
/* 394 */         robot.keyPress(key.getKeyCode());
/* 395 */         robot.keyRelease(key.getKeyCode());
/*     */       }
/* 397 */       catch (AWTException aWTException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static float RGBToFloat(int rgbValue) {
/* 407 */     return (rgbValue - 0.5F) / 255.0F;
/*     */   }
/*     */   
/*     */   private static KeyStroke buildKeyStroke(String argKeyStrokeCode) {
/* 411 */     String[] keyNameElements = argKeyStrokeCode.trim().split(" ");
/*     */ 
/*     */     
/* 414 */     for (int i = 0; i < keyNameElements.length - 1; i++) {
/* 415 */       keyNameElements[i] = keyNameElements[i].toLowerCase();
/*     */     }
/*     */ 
/*     */     
/* 419 */     String keyStrokeName = keyNameElements[keyNameElements.length - 1];
/* 420 */     if (!isAlphaKeyStroke(keyStrokeName)) {
/* 421 */       keyNameElements[keyNameElements.length - 1] = keyStrokeName.toUpperCase();
/*     */     }
/*     */     
/* 424 */     String convertedKeyStrokeName = StringUtils.join((Object[])keyNameElements, " ");
/*     */ 
/*     */     
/* 427 */     KeyStroke keyStroke = KeyStroke.getKeyStroke(convertedKeyStrokeName);
/*     */     
/* 429 */     return keyStroke;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isAlphaKeyStroke(String argKeyStrokeName) {
/* 434 */     return (argKeyStrokeName.length() == 1 && !argKeyStrokeName.equals(argKeyStrokeName.toUpperCase()));
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
/*     */ 
/*     */   
/*     */   public OnScreenKeyboard(Window argOwner, String defaultLayout, boolean isSliding, boolean isSwipeToClose, boolean isSwipeToSwitchLayout, boolean hasSlidingBump) {
/* 453 */     InjectionHammer.forceAtInjectProcessing(this);
/* 454 */     if (argOwner == null) {
/* 455 */       throw new NullPointerException("Owner cannot be null");
/*     */     }
/*     */     
/* 458 */     instance_ = this;
/*     */     
/* 460 */     this.isSliding_ = isSliding;
/* 461 */     this.isSwipeToClose_ = isSwipeToClose;
/* 462 */     this.isSwipeToSwitchLayout_ = isSwipeToSwitchLayout;
/* 463 */     this.hasSlidingBump_ = hasSlidingBump;
/* 464 */     this.layout_ = defaultLayout;
/*     */     
/* 466 */     this.owner_ = argOwner;
/* 467 */     loadButtonImages();
/*     */     
/* 469 */     this.keyboards_ = new ArrayList<>();
/*     */     
/* 471 */     for (LayoutConfig layout : getLayoutConfigurations()) {
/* 472 */       Keyboard keyboard = new Keyboard(getKeyboardOwner(), layout);
/* 473 */       keyboard.setIsSliding(this.isSliding_);
/* 474 */       keyboard.setIsSwipeToClose(this.isSwipeToClose_);
/* 475 */       keyboard.setIsSwipeToSwitchLayout(this.isSwipeToSwitchLayout_);
/* 476 */       keyboard.setHasEndOfSlideBump(this.hasSlidingBump_);
/* 477 */       this.keyboards_.add(keyboard);
/* 478 */       keyboard.setKeyboardDialogs(this.keyboards_);
/* 479 */       keyboard.initialize();
/*     */       
/* 481 */       if (getDefaultLayoutConfig().equals(layout)) {
/* 482 */         keyboard.setIsCurrentDialog(true);
/* 483 */         keyboard.setIsMainDialog(true);
/*     */         continue;
/*     */       } 
/* 486 */       keyboard.setState(KeyboardState.WAITING_TO_BE_SWITCHED);
/*     */     } 
/*     */ 
/*     */     
/* 490 */     this._touchHelper.addMouseListener(new MouseAdapter()
/*     */         {
/*     */           public void mousePressed(MouseEvent argE)
/*     */           {
/* 494 */             if (!OnScreenKeyboard.isKeyboardComponent((Component)argE.getSource())) {
/* 495 */               OnScreenKeyboard.ensureKeyboardIsHiding();
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addKeyboardListenerImpl(Keyboard.IKeyboardListener listener) {
/* 504 */     for (Keyboard dialog : getKeyboards()) {
/* 505 */       dialog.addKeyboardListener(listener);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Window getKeyboardOwnerImpl() {
/* 512 */     return this.owner_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hideImpl() {
/* 518 */     log(Level.DEBUG, "hideImpl() called");
/* 519 */     if (getKeyboard() != null) {
/* 520 */       return getKeyboard().slideOut();
/*     */     }
/*     */     
/* 523 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isShowingImpl() {
/* 529 */     return (getKeyboard() != null && getKeyboard().isShowing() && 
/* 530 */       !getKeyboard().getState().equals(KeyboardState.OUT) && 
/* 531 */       !getKeyboard().getState().equals(KeyboardState.KBD_ERROR));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void nextLayoutImpl() {
/* 537 */     if (getKeyboard() != null) {
/* 538 */       getKeyboard().nextLayout();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ownerBoundsChangedImpl(Rectangle argBounds) {
/* 545 */     if (getKeyboards() != null) {
/* 546 */       for (Keyboard dialog : getKeyboards()) {
/* 547 */         dialog.ownerBoundsChanged(argBounds);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void previousLayoutImpl() {
/* 555 */     if (getKeyboard() != null) {
/* 556 */       getKeyboard().previousLayout();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void repaintImpl() {
/* 563 */     for (Keyboard dialog : getKeyboards()) {
/* 564 */       dialog.repaintVK();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean showImpl() {
/* 571 */     log(Level.DEBUG, "showImpl() called");
/* 572 */     if (getKeyboard() != null) {
/* 573 */       return getKeyboard().slideIn();
/*     */     }
/*     */     
/* 576 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected LayoutConfig getDefaultLayoutConfig() {
/* 584 */     LayoutConfig config = getLayoutConfig(this.layout_);
/* 585 */     if (config == null) {
/* 586 */       log(Level.FATAL, "Could not find a layout named \"" + this.layout_ + "\"");
/*     */     }
/* 588 */     return getLayoutConfig(this.layout_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Keyboard getKeyboard() {
/* 596 */     Keyboard mainDialog = null;
/* 597 */     for (Keyboard dialog : this.keyboards_) {
/* 598 */       if (dialog.isCurrentDialog()) {
/* 599 */         return dialog;
/*     */       }
/* 601 */       if (dialog.isMainDialog()) {
/* 602 */         mainDialog = dialog;
/*     */       }
/*     */     } 
/* 605 */     return mainDialog;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<Keyboard> getKeyboards() {
/* 613 */     return this.keyboards_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected PanelConfig<KeyboardButtonPanel> getPanelConfiguration(int index) {
/* 622 */     return getPanelConfigurations().get(index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<PanelConfig<KeyboardButtonPanel>> getPanelConfigurations() {
/* 631 */     return getDefaultLayoutConfig().getPanelConfigurations();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class DummyKeyboard
/*     */     implements IOnScreenKeyboard
/*     */   {
/*     */     public void addKeyboardListenerImpl(Keyboard.IKeyboardListener argListener) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public Window getKeyboardOwnerImpl() {
/* 644 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hideImpl() {
/* 650 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isShowingImpl() {
/* 656 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void nextLayoutImpl() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void ownerBoundsChangedImpl(Rectangle argBounds) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void previousLayoutImpl() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void repaintImpl() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean showImpl() {
/* 678 */       return false;
/*     */     }
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
/*     */   public static interface IActionProvider
/*     */   {
/*     */     void postKeyAction(String param1String);
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
/*     */   protected enum KeyboardState
/*     */   {
/* 713 */     SLIDING_IN,
/*     */ 
/*     */     
/* 716 */     SLIDING_OUT,
/*     */ 
/*     */     
/* 719 */     IN,
/*     */ 
/*     */     
/* 722 */     OUT,
/*     */ 
/*     */     
/* 725 */     SWITCHING_LAYOUT,
/*     */ 
/*     */     
/* 728 */     WAITING_TO_BE_SWITCHED,
/*     */ 
/*     */     
/* 731 */     KBD_ERROR,
/*     */ 
/*     */     
/* 734 */     PROCESSING;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\OnScreenKeyboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */