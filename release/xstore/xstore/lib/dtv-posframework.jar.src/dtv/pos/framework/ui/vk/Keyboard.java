/*      */ package dtv.pos.framework.ui.vk;
/*      */ 
/*      */ import dtv.pos.framework.ui.vk.config.LayoutConfig;
/*      */ import dtv.pos.framework.ui.vk.config.PanelConfig;
/*      */ import dtv.ui.UIServices;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Dialog;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Image;
/*      */ import java.awt.Point;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.Window;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.MouseListener;
/*      */ import java.awt.event.MouseMotionListener;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Set;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.SwingUtilities;
/*      */ import javax.swing.Timer;
/*      */ import org.apache.log4j.Logger;
/*      */ 
/*      */ public class Keyboard
/*      */   extends JDialog
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*   36 */   private static final Logger logger_ = Logger.getLogger(Keyboard.class);
/*      */   
/*   38 */   private OnScreenKeyboard.KeyboardState kbdState_ = OnScreenKeyboard.KeyboardState.OUT;
/*      */   
/*      */   private JButton kbdSlideOutBtn_;
/*      */   
/*      */   private final LayoutConfig layoutConfig_;
/*      */   
/*      */   private final IKeyboardDesign keyboardDesign_;
/*      */   
/*      */   private List<Keyboard> keyboards_;
/*      */   private boolean isCurrentDialog_;
/*      */   private boolean isMainDialog_;
/*      */   private boolean isSwipeToClose_ = true;
/*      */   private boolean isSwipeToSwitchLayout_ = true;
/*      */   private boolean isSliding_ = true;
/*      */   private boolean hasEndOfSlideBump_ = true;
/*   53 */   private double slideInAndOutAnimationDuration_ = 300.0D;
/*   54 */   private double switchLayoutAnimationDuration_ = 300.0D;
/*   55 */   private double animationReslidePercentage_ = 5.0D;
/*      */   
/*   57 */   private final List<IKeyboardListener> keyboardListeners_ = new ArrayList<>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Keyboard(Window argKbdOwner, LayoutConfig argLayoutConfig) {
/*   65 */     super(argKbdOwner, Dialog.ModalityType.MODELESS);
/*   66 */     this.layoutConfig_ = argLayoutConfig;
/*   67 */     this.keyboardDesign_ = new KeyboardDesign(argKbdOwner.getBounds(), argLayoutConfig);
/*      */     
/*   69 */     setContentPane(new KeyboardContentPane(this.keyboardDesign_, argLayoutConfig));
/*   70 */     setUndecorated(true);
/*   71 */     setState(OnScreenKeyboard.KeyboardState.PROCESSING);
/*   72 */     setBackground(new Color(0, 0, 0, 0));
/*   73 */     setName("OnScreenKeyboard");
/*   74 */     setResizable(false);
/*   75 */     setAutoRequestFocus(false);
/*   76 */     setFocusable(false);
/*   77 */     setFocusableWindowState(false);
/*      */     
/*   79 */     setDefaultCloseOperation(0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object obj) {
/*   85 */     if (obj != null && obj instanceof Keyboard) {
/*   86 */       Keyboard dialog = (Keyboard)obj;
/*   87 */       return getLayoutConfig().equals(dialog.getLayoutConfig());
/*      */     } 
/*      */     
/*   90 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IKeyboardDesign getKeyboardDesign() {
/*   98 */     return this.keyboardDesign_;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized OnScreenKeyboard.KeyboardState getState() {
/*  106 */     return this.kbdState_;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IKeyboardPanel getVirtualKeyboardPane() {
/*  114 */     return (IKeyboardPanel)getContentPane();
/*      */   }
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*  119 */     assert false : "hashCode not designed";
/*  120 */     return 42;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isCurrentDialog() {
/*  125 */     return this.isCurrentDialog_;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isMainDialog() {
/*  130 */     return this.isMainDialog_;
/*      */   }
/*      */   
/*      */   public void ownerBoundsChanged(Rectangle argBounds) {
/*  134 */     this.keyboardDesign_.setOwnerBounds(argBounds);
/*      */   }
/*      */ 
/*      */   
/*      */   public void previousLayout() {
/*  139 */     if (canSwitchLayout()) {
/*  140 */       notifyListeners(3);
/*  141 */       if (isSliding()) {
/*  142 */         switchLayoutWithSlide(false);
/*      */       } else {
/*      */         
/*  145 */         switchLayout(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void repaintVK() {
/*  154 */     UIServices.invoke(() -> { Rectangle bounds = new Rectangle(); if (getState().equals(OnScreenKeyboard.KeyboardState.OUT) || getState().equals(OnScreenKeyboard.KeyboardState.KBD_ERROR)) { bounds.setBounds(0, 0, 0, 0); } else { bounds = getKeyboardDesign().getBounds(); }  setLocation(bounds.getLocation()); setSize(bounds.getSize()); getVirtualKeyboardPane().setSlidingRectangle(0, 0, (int)bounds.getSize().getWidth(), (int)bounds.getSize().getHeight()); for (IKeyboardButtonPanel panel : getVirtualKeyboardPane().getButtonPanels()) { for (KeyboardButton button : panel.getButtons()) button.setBounds(getKeyboardDesign().getButtonBound(button.getId()));  }  getSlideOutButton().setLocation(getKeyboardDesign().getSlideOutButtonBounds().getLocation()); getSlideOutButton().setSize(getKeyboardDesign().getSlideOutButtonBounds().getSize()); revalidate(); getContentPane().repaint(); getSlideOutButton().revalidate(); getSlideOutButton().repaint(); }true, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAnimationReslidePercentage(double argAnimationReslidePercentage) {
/*  186 */     this.animationReslidePercentage_ = argAnimationReslidePercentage;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHasEndOfSlideBump(boolean argHasEndOfSlideBump) {
/*  194 */     this.hasEndOfSlideBump_ = argHasEndOfSlideBump;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIsCurrentDialog(boolean argIsCurrentDialog) {
/*  202 */     setEnabled(argIsCurrentDialog);
/*  203 */     setVisible(argIsCurrentDialog);
/*  204 */     this.isCurrentDialog_ = argIsCurrentDialog;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIsMainDialog(boolean argIsMainDialog) {
/*  212 */     this.isMainDialog_ = argIsMainDialog;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIsSliding(boolean argIsSliding) {
/*  220 */     this.isSliding_ = argIsSliding;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIsSwipeToClose(boolean argSwipeToClose) {
/*  228 */     this.isSwipeToClose_ = argSwipeToClose;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIsSwipeToSwitchLayout(boolean argSwipToSwitchLayout) {
/*  236 */     this.isSwipeToSwitchLayout_ = argSwipToSwitchLayout;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setKeyboardDialogs(List<Keyboard> argDialogs) {
/*  244 */     this.keyboards_ = argDialogs;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setLocation(int x, int y) {
/*  249 */     super.setLocation(x, y);
/*  250 */     if (getLayoutConfig() != null)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  258 */       for (int i = 0; i < getLayoutConfig().getPanelConfigurations().size(); i++) {
/*  259 */         PanelConfig<KeyboardButtonPanel> panel = getLayoutConfig().getPanelConfigurations().get(i);
/*  260 */         Dimension size = ((Rectangle)getKeyboardDesign().getPanelBounds().get(i)).getSize();
/*  261 */         panel.getSwingPanel(getKeyboardDesign()).setSize(size);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void setLocation(Point p) {
/*  268 */     super.setLocation(p);
/*  269 */     for (int i = 0; i < getLayoutConfig().getPanelConfigurations().size(); i++) {
/*  270 */       PanelConfig<KeyboardButtonPanel> panel = getLayoutConfig().getPanelConfigurations().get(i);
/*  271 */       Point location = ((Rectangle)getKeyboardDesign().getPanelBounds().get(i)).getLocation();
/*  272 */       panel.getSwingPanel(getKeyboardDesign()).setLocation(location);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSlideInAndOutAnimationDuration(double argAnimationDuration) {
/*  281 */     if (argAnimationDuration >= 0.0D && argAnimationDuration <= 10000.0D) {
/*  282 */       this.slideInAndOutAnimationDuration_ = argAnimationDuration;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void setState(OnScreenKeyboard.KeyboardState argState) {
/*  291 */     this.kbdState_ = argState;
/*  292 */     logger_.debug("Virtual keyboard state -> " + argState);
/*  293 */     switch (argState) {
/*      */       case IN:
/*  295 */         getSlideOutButton().setLocation(getKeyboardDesign().getSlideOutButtonBounds().getLocation());
/*  296 */         getSlideOutButton().setSize(getKeyboardDesign().getSlideOutButtonBounds().getSize());
/*  297 */         getSlideOutButton().setVisible(true);
/*  298 */         getSlideOutButton().repaint();
/*  299 */         getSlideOutButton().revalidate();
/*      */         break;
/*      */       
/*      */       case OUT:
/*  303 */         getSlideOutButton().setVisible(false);
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSwitchLayoutAnimationDuration(double argAnimationDuration) {
/*  312 */     if (argAnimationDuration >= 0.0D && argAnimationDuration <= 10000.0D) {
/*  313 */       this.switchLayoutAnimationDuration_ = argAnimationDuration;
/*      */     }
/*      */   }
/*      */   
/*      */   protected void addKeyboardListener(IKeyboardListener argListener) {
/*  318 */     if (this.keyboardListeners_.contains(argListener)) {
/*  319 */       this.keyboardListeners_.remove(argListener);
/*      */     }
/*      */     
/*  322 */     this.keyboardListeners_.add(argListener);
/*      */   }
/*      */   
/*      */   protected void addKeyboardListeners(List<IKeyboardListener> listeners) {
/*  326 */     for (IKeyboardListener l : listeners) {
/*  327 */       if (this.keyboardListeners_.contains(l)) {
/*  328 */         this.keyboardListeners_.remove(l);
/*      */       }
/*      */       
/*  331 */       this.keyboardListeners_.add(l);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void appear() {
/*  337 */     if (canSlideIn()) {
/*  338 */       UIServices.invoke(() -> { setBounds(this.keyboardDesign_.getBounds()); getVirtualKeyboardPane().setSlidingRectangle(0, 0, (int)getSize().getWidth(), (int)getSize().getHeight()); setVisible(true); repaint(); getContentPane().repaint(); setState(OnScreenKeyboard.KeyboardState.IN); }true, false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appearWithSlide() {
/*  353 */     int startY = 0;
/*  354 */     int endY = (int)getKeyboardDesign().getBounds().getHeight();
/*  355 */     List<SlideInstruction> instructions = new ArrayList<>();
/*  356 */     instructions.add(new SlideInstruction(0, endY, 
/*  357 */           Math.abs(0 - endY), getSlideInAndOutAnimationDuration()));
/*  358 */     if (hasEndOfSlideBump()) {
/*      */       
/*  360 */       int reslideHeight = (int)Math.round(getAnimationReslidePercentage() * getKeyboardDesign().getBounds().getHeight() / 100.0D);
/*  361 */       instructions.add(new SlideInstruction(endY, endY - reslideHeight, Math.abs(0 - endY), 
/*  362 */             getAnimationReslideDuration()));
/*  363 */       instructions.add(new SlideInstruction(endY - reslideHeight, endY, Math.abs(0 - endY), 
/*  364 */             getAnimationReslideDuration()));
/*      */     } 
/*      */ 
/*      */     
/*  368 */     setState(OnScreenKeyboard.KeyboardState.SLIDING_IN);
/*      */     
/*  370 */     SlideActionListener slideAction = new SlideActionListener(instructions.<SlideInstruction>toArray(new SlideInstruction[instructions.size()]), OnScreenKeyboard.KeyboardState.IN);
/*  371 */     fireTimerAction(slideAction);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canSlideIn() {
/*  379 */     if (!getState().equals(OnScreenKeyboard.KeyboardState.OUT)) {
/*  380 */       return false;
/*      */     }
/*      */     
/*  383 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canSlideOut() {
/*  391 */     if (!getState().equals(OnScreenKeyboard.KeyboardState.IN)) {
/*  392 */       return false;
/*      */     }
/*      */     
/*  395 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canSwitchLayout() {
/*  403 */     if (!getState().equals(OnScreenKeyboard.KeyboardState.IN) || !isSwipeToSwitchLayout() || this.keyboards_.size() <= 1) {
/*  404 */       return false;
/*      */     }
/*      */     
/*  407 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void disappear() {
/*  412 */     if (canSlideOut()) {
/*  413 */       UIServices.invoke(() -> { getVirtualKeyboardPane().setSlidingRectangle(0, 0, 0, 0); setVisible(false); repaint(); getContentPane().repaint(); setState(OnScreenKeyboard.KeyboardState.OUT); }true, false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void disappearWithSlide() {
/*  426 */     int startY = (int)getKeyboardDesign().getBounds().getHeight();
/*  427 */     int endY = 0;
/*  428 */     List<SlideInstruction> instructions = new ArrayList<>();
/*  429 */     if (hasEndOfSlideBump()) {
/*      */       
/*  431 */       int reslideHeight = (int)Math.round(getAnimationReslidePercentage() * getKeyboardDesign().getBounds().getHeight() / 100.0D);
/*  432 */       instructions.add(new SlideInstruction(startY, startY - reslideHeight, Math.abs(startY - 0), 
/*  433 */             getAnimationReslideDuration()));
/*  434 */       instructions.add(new SlideInstruction(startY - reslideHeight, startY, Math.abs(startY - 0), 
/*  435 */             getAnimationReslideDuration()));
/*      */     } 
/*  437 */     instructions.add(new SlideInstruction(startY, 0, 
/*  438 */           Math.abs(startY - 0), getSlideInAndOutAnimationDuration()));
/*      */ 
/*      */     
/*  441 */     setState(OnScreenKeyboard.KeyboardState.SLIDING_OUT);
/*      */     
/*  443 */     SlideActionListener slideAction = new SlideActionListener(instructions.<SlideInstruction>toArray(new SlideInstruction[instructions.size()]), OnScreenKeyboard.KeyboardState.OUT);
/*  444 */     fireTimerAction(slideAction);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void fireTimerAction(ActionListener argListener) {
/*  452 */     Timer animationTimer = new Timer(0, argListener);
/*  453 */     animationTimer.setRepeats(true);
/*  454 */     animationTimer.start();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected double getAnimationReslideDuration() {
/*  462 */     return 20.0D * this.slideInAndOutAnimationDuration_ / 100.0D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected double getAnimationReslidePercentage() {
/*  470 */     return this.animationReslidePercentage_;
/*      */   }
/*      */   
/*      */   protected List<Keyboard> getKeyboards() {
/*  474 */     return this.keyboards_;
/*      */   }
/*      */   
/*      */   protected LayoutConfig getLayoutConfig() {
/*  478 */     return this.layoutConfig_;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int getLayoutIndex(boolean argNext) {
/*  487 */     int index = getKeyboards().indexOf(this);
/*  488 */     if (argNext) {
/*  489 */       if (index >= getKeyboards().size() - 1) {
/*  490 */         index = 0;
/*      */       } else {
/*      */         
/*  493 */         index++;
/*      */       }
/*      */     
/*      */     }
/*  497 */     else if (index == 0) {
/*  498 */       index = getKeyboards().size() - 1;
/*      */     } else {
/*      */       
/*  501 */       index--;
/*      */     } 
/*      */     
/*  504 */     return index;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected double getSlideInAndOutAnimationDuration() {
/*  512 */     return this.slideInAndOutAnimationDuration_;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected JButton getSlideOutButton() {
/*  520 */     if (this.kbdSlideOutBtn_ == null) {
/*  521 */       this.kbdSlideOutBtn_ = new JButton() {
/*      */           private static final long serialVersionUID = 1L;
/*      */           private static final double widthRatio = 0.47368421052631576D;
/*      */           private static final double heightRatio = 0.7058823529411765D;
/*  525 */           Image image_ = OnScreenKeyboard.getButtonImage("_imageStatusBarKbdHideCell");
/*      */ 
/*      */ 
/*      */           
/*      */           protected void paintComponent(Graphics g) {
/*  530 */             int h = (int)Math.round(0.7058823529411765D * getHeight());
/*  531 */             int w = (int)Math.round(0.47368421052631576D * getWidth());
/*  532 */             g.drawImage(this.image_, (int)Math.floor((getWidth() - w) / 2.0D), 
/*  533 */                 (int)Math.floor((getHeight() - h) / 2.0D), w, h, null);
/*      */           }
/*      */         };
/*      */       
/*  537 */       this.kbdSlideOutBtn_.setVisible(false);
/*  538 */       this.kbdSlideOutBtn_.setLocation(getKeyboardDesign().getSlideOutButtonBounds().getLocation());
/*  539 */       this.kbdSlideOutBtn_.setSize(getKeyboardDesign().getSlideOutButtonBounds().getSize());
/*  540 */       this.kbdSlideOutBtn_.setBorderPainted(false);
/*  541 */       this.kbdSlideOutBtn_.setOpaque(false);
/*      */     } 
/*  543 */     return this.kbdSlideOutBtn_;
/*      */   }
/*      */   
/*      */   protected double getSwitchLayoutAnimationDuration() {
/*  547 */     return this.switchLayoutAnimationDuration_;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean hasEndOfSlideBump() {
/*  555 */     return this.hasEndOfSlideBump_;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void initialize() {
/*  562 */     getContentPane().setPreferredSize(this.keyboardDesign_.getBounds().getSize());
/*  563 */     getContentPane().setLocation(this.keyboardDesign_.getBounds().getLocation());
/*  564 */     setSize(this.keyboardDesign_.getBounds().getSize());
/*  565 */     setLocation(this.keyboardDesign_.getBounds().getLocation());
/*      */     
/*  567 */     getContentPane().add(getSlideOutButton(), Integer.valueOf(999));
/*  568 */     getSlideOutButton().addActionListener(argE -> OnScreenKeyboard.getInstance().hideImpl());
/*      */     
/*  570 */     initMouseListeners();
/*      */     
/*  572 */     loadPanels();
/*      */     
/*  574 */     setState(OnScreenKeyboard.KeyboardState.OUT);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void initMouseListeners() {
/*  581 */     getGlassPane().setVisible(true);
/*  582 */     GlassPaneMouseListener listner = new GlassPaneMouseListener();
/*  583 */     getGlassPane().addMouseListener(listner);
/*  584 */     getGlassPane().addMouseMotionListener(listner);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isSliding() {
/*  592 */     return this.isSliding_;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isSwipeToClose() {
/*  600 */     return this.isSwipeToClose_;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isSwipeToSwitchLayout() {
/*  608 */     return this.isSwipeToSwitchLayout_;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void loadPanels() {
/*  615 */     List<PanelConfig<KeyboardButtonPanel>> configs = this.layoutConfig_.getPanelConfigurations();
/*  616 */     for (PanelConfig<KeyboardButtonPanel> config : configs) {
/*  617 */       getContentPane().add(config.getSwingPanel(getKeyboardDesign()), Integer.valueOf(1));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   protected void nextLayout() {
/*  623 */     if (canSwitchLayout()) {
/*  624 */       notifyListeners(2);
/*  625 */       if (isSliding()) {
/*  626 */         switchLayoutWithSlide(true);
/*      */       } else {
/*      */         
/*  629 */         switchLayout(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void notifyListeners(int argEvent) {
/*  635 */     for (IKeyboardListener listener : this.keyboardListeners_) {
/*  636 */       switch (argEvent) {
/*      */         case 0:
/*  638 */           listener.keyboardHidden();
/*      */ 
/*      */         
/*      */         case 1:
/*  642 */           listener.keyboardShowed();
/*      */ 
/*      */         
/*      */         case 2:
/*  646 */           listener.keyboardSwitchedNextLayout();
/*      */ 
/*      */         
/*      */         case 3:
/*  650 */           listener.keyboardSwitchedPreviousLayout();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected synchronized boolean slideIn() {
/*  659 */     if (canSlideIn()) {
/*  660 */       notifyListeners(1);
/*  661 */       if (isSliding()) {
/*  662 */         appearWithSlide();
/*      */       } else {
/*      */         
/*  665 */         appear();
/*      */       } 
/*  667 */       return true;
/*      */     } 
/*  669 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   protected synchronized boolean slideOut() {
/*  674 */     if (canSlideOut()) {
/*  675 */       getSlideOutButton().setVisible(false);
/*  676 */       notifyListeners(0);
/*  677 */       if (isSliding()) {
/*  678 */         disappearWithSlide();
/*      */       } else {
/*      */         
/*  681 */         disappear();
/*      */       } 
/*  683 */       return true;
/*      */     } 
/*  685 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void switchLayout(boolean argNext) {
/*  693 */     UIServices.invoke(() -> { int index = getLayoutIndex(argNext); setIsCurrentDialog(false); setState(OnScreenKeyboard.KeyboardState.OUT); ((Keyboard)getKeyboards().get(index)).setIsCurrentDialog(true); ((Keyboard)getKeyboards().get(index)).setState(OnScreenKeyboard.KeyboardState.IN); Rectangle bounds = ((Keyboard)getKeyboards().get(index)).getKeyboardDesign().getBounds(); ((Keyboard)getKeyboards().get(index)).getVirtualKeyboardPane().setSlidingRectangle(0, 0, (int)bounds.getWidth(), (int)bounds.getHeight()); ((Keyboard)getKeyboards().get(index)).repaint(); ((Keyboard)getKeyboards().get(index)).getContentPane().repaint(); }true, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void switchLayoutWithSlide(boolean argNext) {
/*  716 */     if (getState().equals(OnScreenKeyboard.KeyboardState.IN)) {
/*      */       
/*  718 */       int index = getLayoutIndex(argNext);
/*      */ 
/*      */       
/*  721 */       Keyboard futureDialog_ = getKeyboards().get(index);
/*  722 */       futureDialog_.setState(OnScreenKeyboard.KeyboardState.SWITCHING_LAYOUT);
/*  723 */       setState(OnScreenKeyboard.KeyboardState.SWITCHING_LAYOUT);
/*  724 */       futureDialog_.setIsCurrentDialog(true);
/*      */       
/*  726 */       SwitchLayoutListener animation = new SwitchLayoutListener(this, futureDialog_, argNext, getSwitchLayoutAnimationDuration());
/*  727 */       fireTimerAction(animation);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private class GlassPaneMouseListener
/*      */     implements MouseListener, MouseMotionListener
/*      */   {
/*      */     private static final double VERTICAL_DRAG_PERCENTAGE = 15.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static final double HORIZONTAL_DRAG_PERCENTAGE = 5.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  758 */     private final Set<Component> pressedComponents_ = Collections.synchronizedSet(new HashSet<>());
/*      */     
/*      */     private boolean mousePressed_;
/*      */     private Point dragStart_;
/*      */     
/*      */     public void mouseClicked(MouseEvent argE) {
/*  764 */       Component destination = SwingUtilities.getDeepestComponentAt(Keyboard.this.getContentPane(), argE.getX(), argE.getY());
/*      */       
/*  766 */       MouseEvent newEvent = SwingUtilities.convertMouseEvent((Component)argE.getSource(), argE, destination);
/*  767 */       destination.dispatchEvent(newEvent);
/*      */     }
/*      */ 
/*      */     
/*      */     public void mouseDragged(MouseEvent argE) {
/*  772 */       if (Keyboard.this.isSwipeToClose() && this.dragStart_ != null) {
/*  773 */         double dragged = argE.getY() - this.dragStart_.getY();
/*  774 */         if (dragged > 0.0D) {
/*  775 */           double height = Keyboard.this.getGlassPane().getHeight();
/*  776 */           double percentage = dragged * 100.0D / height;
/*  777 */           if (percentage > 15.0D) {
/*  778 */             Keyboard.this.slideOut();
/*      */           }
/*      */         } 
/*      */       } 
/*  782 */       if (Keyboard.this.isSwipeToSwitchLayout() && this.dragStart_ != null) {
/*  783 */         double dragged = Math.abs(argE.getX() - this.dragStart_.getX());
/*  784 */         if (dragged > 0.0D) {
/*  785 */           double width = Keyboard.this.getGlassPane().getWidth();
/*  786 */           double percentage = dragged * 100.0D / width;
/*  787 */           if (percentage > 5.0D) {
/*  788 */             if (argE.getX() < this.dragStart_.getX()) {
/*  789 */               this.dragStart_.x = argE.getX();
/*  790 */               this.dragStart_.y = argE.getY();
/*  791 */               Keyboard.this.nextLayout();
/*      */             } else {
/*      */               
/*  794 */               this.dragStart_.x = argE.getX();
/*  795 */               this.dragStart_.y = argE.getY();
/*  796 */               Keyboard.this.previousLayout();
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void mouseEntered(MouseEvent argE) {}
/*      */ 
/*      */     
/*      */     public void mouseExited(MouseEvent argE) {}
/*      */ 
/*      */     
/*      */     public void mouseMoved(MouseEvent argE) {}
/*      */ 
/*      */     
/*      */     public void mousePressed(MouseEvent argE) {
/*  815 */       Component destination = SwingUtilities.getDeepestComponentAt(Keyboard.this.getContentPane(), argE.getX(), argE.getY());
/*      */       
/*  817 */       MouseEvent newEvent = SwingUtilities.convertMouseEvent((Component)argE.getSource(), argE, destination);
/*  818 */       this.pressedComponents_.add(destination);
/*  819 */       destination.dispatchEvent(newEvent);
/*      */       
/*  821 */       setMousePressed(true, argE);
/*      */     }
/*      */ 
/*      */     
/*      */     public void mouseReleased(MouseEvent argE) {
/*  826 */       Iterator<Component> it = this.pressedComponents_.iterator();
/*  827 */       while (it.hasNext()) {
/*  828 */         Component c = it.next();
/*  829 */         MouseEvent event = SwingUtilities.convertMouseEvent((Component)argE.getSource(), argE, c);
/*  830 */         if (event.getX() < 0 || event.getX() >= c.getWidth() || event.getY() < 0 || event
/*  831 */           .getY() >= c.getHeight()) {
/*  832 */           event.translatePoint(-event.getX(), -event.getY());
/*      */         }
/*      */         
/*  835 */         c.dispatchEvent(event);
/*  836 */         it.remove();
/*      */       } 
/*      */ 
/*      */       
/*  840 */       Component destination = SwingUtilities.getDeepestComponentAt(Keyboard.this.getContentPane(), argE.getX(), argE.getY());
/*      */       
/*  842 */       MouseEvent newEvent = SwingUtilities.convertMouseEvent((Component)argE.getSource(), argE, destination);
/*  843 */       if (destination != null) {
/*  844 */         destination.dispatchEvent(newEvent);
/*      */       }
/*  846 */       setMousePressed(false, argE);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean isMousePressed() {
/*  855 */       return this.mousePressed_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void setMousePressed(boolean isMousePressed, MouseEvent argE) {
/*  864 */       this.mousePressed_ = isMousePressed;
/*  865 */       if (isMousePressed) {
/*  866 */         this.dragStart_ = new Point(argE.getX(), argE.getY());
/*      */       } else {
/*      */         
/*  869 */         this.dragStart_ = null;
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private class SlideActionListener
/*      */     implements ActionListener
/*      */   {
/*  885 */     private final int _width = (int)Keyboard.this.getKeyboardDesign().getBounds().getWidth();
/*      */     private final Keyboard.SlideInstruction[] _sequences;
/*      */     private final OnScreenKeyboard.KeyboardState _endState;
/*  888 */     private int _currentSequence = 0;
/*  889 */     private double _currentY = 0.0D;
/*  890 */     private int _currentHeight = 0;
/*      */     private long _startTime;
/*      */     private long _endTime;
/*      */     
/*      */     private SlideActionListener(Keyboard.SlideInstruction[] argInstructions, OnScreenKeyboard.KeyboardState argEndState) {
/*  895 */       this._sequences = argInstructions;
/*  896 */       this._endState = argEndState;
/*  897 */       startSequence();
/*  898 */       Keyboard.this.setBounds(Keyboard.this.getKeyboardDesign().getBounds());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void actionPerformed(ActionEvent argE) {
/*  905 */       long currentTime = System.currentTimeMillis();
/*  906 */       long elapsedTime = currentTime - this._startTime;
/*  907 */       double f = elapsedTime / Keyboard.this.getSlideInAndOutAnimationDuration();
/*  908 */       if (currentTime >= this._endTime) {
/*  909 */         f = 1.0D;
/*      */       }
/*      */ 
/*      */       
/*  913 */       int yStart = (this._sequences[this._currentSequence]).yStart;
/*  914 */       int yEnd = (this._sequences[this._currentSequence]).yEnd;
/*  915 */       this._currentHeight = (int)Math.round(yStart + f * (yEnd - yStart));
/*  916 */       this._currentY = ((this._sequences[this._currentSequence]).slideHeight - this._currentHeight);
/*  917 */       Keyboard.this.getVirtualKeyboardPane().setSlidingRectangle(0, (int)this._currentY, this._width, this._currentHeight);
/*      */ 
/*      */       
/*  920 */       if (Keyboard.this.isVisible() && this._currentHeight <= 0) {
/*  921 */         Keyboard.this.setVisible(false);
/*      */       }
/*  923 */       else if (!Keyboard.this.isVisible() && this._currentHeight > 0) {
/*  924 */         Keyboard.this.setVisible(true);
/*      */       } 
/*      */ 
/*      */       
/*  928 */       Keyboard.this.repaint();
/*  929 */       Keyboard.this.getContentPane().repaint();
/*      */ 
/*      */       
/*  932 */       if (f >= 1.0D) {
/*  933 */         if (++this._currentSequence < this._sequences.length) {
/*      */           
/*  935 */           startSequence();
/*      */         }
/*      */         else {
/*      */           
/*  939 */           Keyboard.this.setState(this._endState);
/*  940 */           ((Timer)argE.getSource()).stop();
/*      */         } 
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void startSequence() {
/*  949 */       this._startTime = System.currentTimeMillis();
/*  950 */       this._endTime = this._startTime + (long)(this._sequences[this._currentSequence]).slideDuration;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private class SlideInstruction
/*      */   {
/*      */     private final int yStart;
/*      */ 
/*      */     
/*      */     private final int yEnd;
/*      */ 
/*      */     
/*      */     private final int slideHeight;
/*      */ 
/*      */     
/*      */     private final double slideDuration;
/*      */ 
/*      */     
/*      */     private SlideInstruction(int argYStart, int argYEnd, int argSlideHeight, double argSlideDuration) {
/*  971 */       this.yStart = argYStart;
/*  972 */       this.yEnd = argYEnd;
/*  973 */       this.slideHeight = argSlideHeight;
/*  974 */       this.slideDuration = argSlideDuration;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private class SwitchLayoutListener
/*      */     implements ActionListener
/*      */   {
/*  989 */     private final int _width = (int)Keyboard.this.getKeyboardDesign().getBounds().getWidth();
/*  990 */     private final int _height = (int)Keyboard.this.getKeyboardDesign().getBounds().getHeight();
/*      */     
/*      */     private final Keyboard _currentDialog;
/*      */     private final Keyboard _futureDialog;
/*      */     private final double _animationDuration;
/*      */     private final long _startTime;
/*      */     private final boolean _next;
/*      */     private int _x;
/*      */     
/*      */     private SwitchLayoutListener(Keyboard argCurrent, Keyboard argFuture, boolean argNext, double animationDurationMs) {
/* 1000 */       this._currentDialog = argCurrent;
/* 1001 */       this._futureDialog = argFuture;
/* 1002 */       this._next = argNext;
/* 1003 */       this._animationDuration = animationDurationMs;
/* 1004 */       this._startTime = System.currentTimeMillis();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void actionPerformed(ActionEvent argE) {
/* 1011 */       long currentTime = System.currentTimeMillis();
/* 1012 */       long elapsedTime = currentTime - this._startTime;
/* 1013 */       double f = elapsedTime / this._animationDuration;
/* 1014 */       if (elapsedTime > this._animationDuration) {
/* 1015 */         f = 1.0D;
/*      */       }
/*      */ 
/*      */       
/* 1019 */       this._x = (int)Math.round(f * this._width);
/* 1020 */       int slidingWidth = this._width - this._x;
/*      */ 
/*      */       
/* 1023 */       if (this._next) {
/* 1024 */         this._currentDialog.getVirtualKeyboardPane().setValue("SLIDING_TO_NEXT", Boolean.valueOf(true));
/* 1025 */         this._futureDialog.getVirtualKeyboardPane().setValue("SLIDING_TO_NEXT", Boolean.valueOf(false));
/* 1026 */         this._currentDialog.getVirtualKeyboardPane().setSlidingRectangle(0, 0, slidingWidth, this._height);
/* 1027 */         this._futureDialog.getVirtualKeyboardPane().setSlidingRectangle(slidingWidth, 0, this._width - slidingWidth, this._height);
/*      */       }
/*      */       else {
/*      */         
/* 1031 */         this._currentDialog.getVirtualKeyboardPane().setValue("SLIDING_TO_NEXT", Boolean.valueOf(false));
/* 1032 */         this._futureDialog.getVirtualKeyboardPane().setValue("SLIDING_TO_NEXT", Boolean.valueOf(true));
/* 1033 */         this._currentDialog.getVirtualKeyboardPane().setSlidingRectangle(this._x, 0, slidingWidth, this._height);
/* 1034 */         this._futureDialog.getVirtualKeyboardPane().setSlidingRectangle(0, 0, this._x, this._width);
/*      */       } 
/* 1036 */       this._currentDialog.repaint();
/* 1037 */       this._futureDialog.repaint();
/* 1038 */       this._currentDialog.getContentPane().repaint();
/* 1039 */       this._futureDialog.getContentPane().repaint();
/*      */ 
/*      */       
/* 1042 */       if (f >= 1.0D) {
/* 1043 */         this._futureDialog.getVirtualKeyboardPane().setSlidingRectangle(0, 0, this._width, this._height);
/* 1044 */         this._futureDialog.getContentPane().repaint();
/* 1045 */         this._futureDialog.setState(OnScreenKeyboard.KeyboardState.IN);
/* 1046 */         this._currentDialog.setState(OnScreenKeyboard.KeyboardState.WAITING_TO_BE_SWITCHED);
/* 1047 */         this._currentDialog.setIsCurrentDialog(false);
/* 1048 */         ((Timer)argE.getSource()).stop();
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public static interface IKeyboardListener {
/*      */     public static final int KEYBOARD_HIDDEN = 0;
/*      */     public static final int KEYBOARD_SHOWED = 1;
/*      */     public static final int KEYBOARD_SWITCHED_NEXT = 2;
/*      */     public static final int KEYBOARD_SWITCHED_PREVIOUS = 3;
/*      */     
/*      */     void keyboardHidden();
/*      */     
/*      */     void keyboardShowed();
/*      */     
/*      */     void keyboardSwitchedNextLayout();
/*      */     
/*      */     void keyboardSwitchedPreviousLayout();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\Keyboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */