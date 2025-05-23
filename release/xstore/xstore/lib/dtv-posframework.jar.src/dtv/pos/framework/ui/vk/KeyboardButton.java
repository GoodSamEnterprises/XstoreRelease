/*     */ package dtv.pos.framework.ui.vk;
/*     */ 
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.framework.action.IXstActionFactory;
/*     */ import dtv.pos.framework.ui.vk.config.ButtonConfig;
/*     */ import dtv.pos.framework.worker.IWorker;
/*     */ import dtv.pos.framework.worker.WorkerLocator;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.ui.swing.DtvButton;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Image;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Observable;
/*     */ import java.util.Observer;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.springframework.beans.factory.NoSuchBeanDefinitionException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KeyboardButton
/*     */   extends DtvButton
/*     */   implements IIsSlidingComponent, Observer
/*     */ {
/*  40 */   private static final Logger logger_ = Logger.getLogger(KeyboardButton.class);
/*     */   
/*  42 */   private static final boolean ANTIALIAS_FONTS = UIResourceManager.getInstance().getBoolean("_boolAntiAlias", true);
/*     */   
/*  44 */   private static final boolean FILTERED_SCALING = UIResourceManager.getInstance().getBoolean("_boolFilteredScaling", true);
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   ButtonConfig config_;
/*     */   
/*     */   private int slidingHeight_;
/*     */   
/*     */   private int slidingWidth_;
/*     */   
/*     */   private int slidingX_;
/*     */   
/*     */   private int slidingY_;
/*     */   private Image buttonImage_;
/*     */   private Image buttonImagePressed_;
/*     */   private String text_;
/*     */   private String keyStroke_;
/*     */   private State buttonState_;
/*     */   private boolean initialized_;
/*     */   private IKeyboardDesign kbdDesign_;
/*     */   private ObservableModifier observableModifier_;
/*  65 */   private Map<String, Object> values_ = new HashMap<>();
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private IXstActionFactory _actionFactory;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private WorkerLocator _workerLocator;
/*     */   
/*     */   @Inject
/*     */   private ExecutorService _threadPool;
/*     */ 
/*     */   
/*     */   public KeyboardButton(ButtonConfig config, IKeyboardDesign argKeyboardDesign) {
/*  84 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */     
/*  86 */     this.config_ = config;
/*  87 */     this.kbdDesign_ = argKeyboardDesign;
/*  88 */     setOpaque(false);
/*  89 */     setContentAreaFilled(false);
/*  90 */     setBorderPainted(false);
/*  91 */     setState(State.DEFAULT);
/*  92 */     setConfiguredText(this.config_.getText());
/*  93 */     setConfiguredKeyStroke(this.config_.getKeyStroke());
/*  94 */     setFocusable(false);
/*  95 */     addMouseListener(new KeyboardButtonMouseListener());
/*  96 */     if (ConfigurationMgr.isOnScreenKeyboardKeyClickEnabled()) {
/*  97 */       addMouseListener(KeyClickListener.getInstance());
/*     */     }
/*     */     
/* 100 */     if (isModifier()) {
/* 101 */       this.observableModifier_ = new ObservableModifier(getConfiguredKeyStroke());
/*     */     }
/*     */   }
/*     */   
/*     */   public void addModifiable(Observer modifiable) {
/* 106 */     this.observableModifier_.addObserver(modifiable);
/*     */   }
/*     */   
/*     */   public Locale getConfiguredLocale() {
/* 110 */     return this.config_.getLocale();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/* 118 */     return this.config_.getId();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSlidingHeight() {
/* 124 */     return this.slidingHeight_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSlidingWidth() {
/* 130 */     return this.slidingWidth_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSlidingX() {
/* 136 */     return this.slidingX_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSlidingY() {
/* 142 */     return this.slidingY_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSlidingRectangle(int argX, int argY, int argWidth, int argHeight) {
/* 148 */     this.slidingX_ = argX;
/* 149 */     this.slidingY_ = argY;
/* 150 */     this.slidingWidth_ = argWidth;
/* 151 */     this.slidingHeight_ = argHeight;
/*     */   }
/*     */   
/*     */   public void setValue(String field, Object value) {
/* 155 */     this.values_.put(field, value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 161 */     return "Id='" + this.config_.getId() + "' Bounds='" + getBounds() + "' Text='" + this.config_.getText() + "' Keystroke='" + this.config_
/* 162 */       .getKeyStroke() + "'";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(Observable argO, Object argKeyStroke) {
/* 169 */     if (argKeyStroke instanceof ObservableModifier.Key) {
/* 170 */       ObservableModifier.Key key = (ObservableModifier.Key)argKeyStroke;
/* 171 */       String text = getConfiguredText();
/* 172 */       String keyStroke = getConfiguredKeyStroke();
/* 173 */       if (key.getKeyStroke().equalsIgnoreCase("SHIFT")) {
/* 174 */         if (key.isInactive()) {
/* 175 */           text = text.toUpperCase();
/* 176 */           keyStroke = keyStroke.toUpperCase();
/*     */         } else {
/*     */           
/* 179 */           text = text.toLowerCase();
/* 180 */           keyStroke = keyStroke.toLowerCase();
/*     */         } 
/*     */         
/* 183 */         setConfiguredText(text);
/* 184 */         setConfiguredKeyStroke(keyStroke);
/* 185 */         repaint();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Image getBackgroundImage() {
/* 196 */     switch (this.buttonState_) {
/*     */       case PRESSED:
/* 198 */         return this.buttonImagePressed_;
/*     */     } 
/*     */     
/* 201 */     return this.buttonImage_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getConfiguredKeyStroke() {
/* 207 */     return this.keyStroke_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getConfiguredText() {
/* 215 */     return this.text_;
/*     */   }
/*     */   
/*     */   protected String getKeyAction() {
/* 219 */     return this.config_.getKeyAction();
/*     */   }
/*     */   
/*     */   protected IKeyboardDesign getKeyboardDesign() {
/* 223 */     return this.kbdDesign_;
/*     */   }
/*     */   
/*     */   protected int getPanelX() {
/* 227 */     return this.config_.getParentRow().getParentPanel().getSwingPanel(getKeyboardDesign()).getX();
/*     */   }
/*     */   
/*     */   protected State getState() {
/* 231 */     return this.buttonState_;
/*     */   }
/*     */   
/*     */   protected Object getValue(String field) {
/* 235 */     return this.values_.get(field);
/*     */   }
/*     */   
/*     */   protected boolean hasKeyAction() {
/* 239 */     return (this.config_.getKeyAction() != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initUI() {
/* 246 */     if (getHeight() == 0 || getWidth() == 0) {
/*     */       return;
/*     */     }
/* 249 */     if (this.config_.getBackgroundImageURL() != null) {
/* 250 */       this.buttonImage_ = OnScreenKeyboard.getButtonImage(this.config_.getBackgroundImageURL());
/* 251 */       this.buttonImagePressed_ = this.buttonImage_;
/* 252 */       if (this.config_.getBackgroundPressedImageURL() != null) {
/* 253 */         this.buttonImagePressed_ = OnScreenKeyboard.getButtonImage(this.config_.getBackgroundPressedImageURL());
/*     */       }
/*     */     } 
/*     */     
/* 257 */     if (this.buttonImage_ == null || this.buttonImagePressed_ == null || this.buttonImage_.getHeight(null) <= 0 || this.buttonImagePressed_
/* 258 */       .getHeight(null) <= 0) {
/* 259 */       if (this.config_.getBackgroundImageURL() != null) {
/* 260 */         logger_.warn("Could not load image " + this.config_.getBackgroundImageURL());
/*     */       }
/* 262 */       Dimension size = getSize();
/* 263 */       this.buttonImage_ = OnScreenKeyboard.getButtonImage(size, false);
/* 264 */       this.buttonImagePressed_ = OnScreenKeyboard.getButtonImage(size, true);
/*     */     } 
/* 266 */     this.initialized_ = true;
/*     */   }
/*     */   
/*     */   protected boolean isComposite() {
/* 270 */     return this.config_.isComposite();
/*     */   }
/*     */   
/*     */   protected boolean isInitialized() {
/* 274 */     return this.initialized_;
/*     */   }
/*     */   
/*     */   protected boolean isModifier() {
/* 278 */     return this.config_.isModifier();
/*     */   }
/*     */   
/*     */   protected boolean isSlideToNext() {
/* 282 */     if (getValue("SLIDING_TO_NEXT") != null && getValue("SLIDING_TO_NEXT") instanceof Boolean) {
/* 283 */       return ((Boolean)getValue("SLIDING_TO_NEXT")).booleanValue();
/*     */     }
/* 285 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void paintComponent(Graphics g) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void paintSlide(Graphics g) {
/* 299 */     if (!isInitialized()) {
/* 300 */       initUI();
/*     */     }
/*     */     
/* 303 */     if (g instanceof Graphics2D) {
/* 304 */       Graphics2D g2D = (Graphics2D)g;
/* 305 */       Object aliasHint = ANTIALIAS_FONTS ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF;
/*     */       
/* 307 */       g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, aliasHint);
/* 308 */       if (FILTERED_SCALING) {
/* 309 */         g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
/*     */       }
/*     */     } 
/*     */     
/* 313 */     int slidingY = getSlidingY();
/* 314 */     int slidingHeight = getSlidingHeight();
/*     */     
/* 316 */     int buttonY = getY();
/* 317 */     int buttonHeight = getHeight();
/*     */     
/* 319 */     int paintY = slidingY + buttonY;
/* 320 */     int paintHeight = buttonHeight;
/*     */     
/* 322 */     if (paintY + buttonHeight > slidingY + slidingHeight) {
/* 323 */       paintHeight = slidingY + slidingHeight - paintY;
/* 324 */       if (paintHeight < 0) {
/* 325 */         paintHeight = 0;
/*     */       }
/*     */     } 
/*     */     
/* 329 */     int xStart = getPanelX() + getX() + getSlidingX();
/*     */     
/* 331 */     if (isSlideToNext()) {
/* 332 */       xStart = (int)(xStart - Math.abs(getSlidingWidth() - getKeyboardDesign().getBounds().getWidth()));
/*     */     }
/*     */     
/* 335 */     g.drawImage(getBackgroundImage(), xStart, paintY, getWidth(), paintHeight, null);
/* 336 */     g.setFont(getKeyboardDesign().getFont());
/* 337 */     g.setColor(getKeyboardDesign().getTextColor());
/*     */     
/* 339 */     if (getConfiguredText() != null && paintHeight > 0) {
/* 340 */       Rectangle2D bounds = g.getFontMetrics().getStringBounds(getConfiguredText(), g);
/* 341 */       int x = (int)Math.round(xStart + getWidth() / 2.0D - bounds.getWidth() / 2.0D);
/* 342 */       int y = (int)Math.round(paintY + getHeight() / 2.0D + bounds.getHeight() / 3.0D);
/* 343 */       g.drawChars(getConfiguredText().toCharArray(), 0, (getConfiguredText().toCharArray()).length, x, y);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void setConfiguredKeyStroke(String keyStroke) {
/* 348 */     this.keyStroke_ = keyStroke;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setConfiguredText(String argText) {
/* 356 */     this.text_ = argText;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setState(State state) {
/* 364 */     this.buttonState_ = state;
/*     */   }
/*     */   
/*     */   private List<IWorker> getWorkers(String keyAction) {
/*     */     try {
/* 369 */       return this._workerLocator.getWorkerList(keyAction).getWorkers();
/*     */     }
/* 371 */     catch (NoSuchBeanDefinitionException ex) {
/* 372 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void handleKeyAction(String argKeyAction) {
/* 377 */     List<IWorker> workers = getWorkers(argKeyAction);
/*     */     try {
/* 379 */       if (workers == null) {
/* 380 */         ((IModeController)this._modeProvider.get()).getEventRouter().fireEvent((IXstEvent)this._actionFactory.getAction(argKeyAction));
/*     */       } else {
/*     */         
/* 383 */         this._threadPool.submit(() -> {
/*     */               
/*     */               for (IWorker worker : workers) {
/*     */                 if (worker.isApplicable()) {
/*     */                   worker.performWork();
/*     */                 }
/*     */               } 
/*     */             });
/*     */       } 
/* 392 */     } catch (RuntimeException ex) {
/* 393 */       logger_.error(ex);
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
/*     */   protected class KeyboardButtonMouseListener
/*     */     implements MouseListener
/*     */   {
/*     */     public void mouseClicked(MouseEvent argE) {
/* 412 */       if (KeyboardButton.this.getState().equals(KeyboardButton.State.PRESSED)) {
/* 413 */         if (KeyboardButton.this.isModifier()) {
/* 414 */           KeyboardButton.this.observableModifier_.setInactive(true);
/* 415 */           (new Thread(KeyboardButton.this.observableModifier_)).start();
/*     */         } else {
/*     */           
/* 418 */           KeyboardButton.this.setState(KeyboardButton.State.DEFAULT);
/* 419 */           KeyboardButton.this.repaint();
/*     */         } 
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void mouseEntered(MouseEvent argE) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void mouseExited(MouseEvent argE) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void mousePressed(MouseEvent argE) {
/* 435 */       if (KeyboardButton.this.getState().equals(KeyboardButton.State.PRESSED)) {
/* 436 */         KeyboardButton.this.setState(KeyboardButton.State.DEFAULT);
/*     */       }
/* 438 */       else if (KeyboardButton.this.getState().equals(KeyboardButton.State.DEFAULT)) {
/* 439 */         KeyboardButton.this.setState(KeyboardButton.State.PRESSED);
/*     */       } 
/* 441 */       KeyboardButton.this.repaint();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void mouseReleased(MouseEvent argE) {
/* 447 */       if (KeyboardButton.this.isModifier()) {
/* 448 */         if (KeyboardButton.this.getState().equals(KeyboardButton.State.PRESSED)) {
/* 449 */           KeyboardButton.this.observableModifier_.setInactive(true);
/* 450 */           (new Thread(KeyboardButton.this.observableModifier_)).start();
/*     */         }
/* 452 */         else if (KeyboardButton.this.getState().equals(KeyboardButton.State.DEFAULT)) {
/* 453 */           KeyboardButton.this.observableModifier_.setInactive(false);
/* 454 */           (new Thread(KeyboardButton.this.observableModifier_)).start();
/*     */         } 
/*     */       }
/* 457 */       if (KeyboardButton.this.getState().equals(KeyboardButton.State.PRESSED) && !KeyboardButton.this.isModifier()) {
/* 458 */         if (argE.getX() != 0 && argE.getY() != 0) {
/* 459 */           if (KeyboardButton.this.isComposite()) {
/* 460 */             char[] keyStrokes = KeyboardButton.this.getConfiguredKeyStroke().toCharArray();
/*     */             
/* 462 */             for (char key : keyStrokes) {
/* 463 */               OnScreenKeyboard.postKeyEvent(key);
/*     */             }
/*     */           }
/* 466 */           else if (KeyboardButton.this.hasKeyAction()) {
/* 467 */             KeyboardButton.this.handleKeyAction(KeyboardButton.this.getKeyAction());
/*     */           } else {
/*     */             
/* 470 */             OnScreenKeyboard.postKeyEvent(KeyboardButton.this.getConfiguredKeyStroke());
/*     */           } 
/*     */         }
/*     */         
/* 474 */         KeyboardButton.this.setState(KeyboardButton.State.DEFAULT);
/* 475 */         KeyboardButton.this.repaint();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   protected class ObservableModifier
/*     */     extends Observable
/*     */     implements Runnable {
/*     */     private Key key_;
/*     */     
/*     */     public ObservableModifier(String keyStroke) {
/* 486 */       this.key_ = new Key(keyStroke);
/*     */     }
/*     */     
/*     */     public ObservableModifier(String keyStroke, boolean isDown) {
/* 490 */       this(keyStroke);
/* 491 */       setInactive(isDown);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void run() {
/* 497 */       setChanged();
/* 498 */       notifyObservers(this.key_);
/*     */     }
/*     */     
/*     */     public void setInactive(boolean inactive) {
/* 502 */       this.key_.setInactive(inactive);
/*     */     }
/*     */     
/*     */     class Key {
/*     */       private String stroke_;
/*     */       private boolean isInactive_;
/*     */       
/*     */       public Key(String keyStroke) {
/* 510 */         this.stroke_ = keyStroke;
/*     */       }
/*     */       
/*     */       public String getKeyStroke() {
/* 514 */         return this.stroke_;
/*     */       }
/*     */       
/*     */       public boolean isInactive() {
/* 518 */         return this.isInactive_;
/*     */       }
/*     */       
/*     */       public void setInactive(boolean inactive) {
/* 522 */         this.isInactive_ = inactive; } } } class Key { private String stroke_; private boolean isInactive_; public Key(String keyStroke) { this.stroke_ = keyStroke; } public String getKeyStroke() { return this.stroke_; } public void setInactive(boolean inactive) { this.isInactive_ = inactive; }
/*     */     
/*     */     public boolean isInactive() {
/*     */       return this.isInactive_;
/*     */     } }
/*     */   
/* 528 */   private enum State { PRESSED, DEFAULT; }
/*     */ 
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\KeyboardButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */