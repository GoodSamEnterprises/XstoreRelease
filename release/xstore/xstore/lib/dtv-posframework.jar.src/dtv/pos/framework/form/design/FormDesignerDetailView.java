/*     */ package dtv.pos.framework.form.design;
/*     */ 
/*     */ import dtv.i18n.FormatterType;
/*     */ import dtv.pos.framework.action.type.XstKeyStroke;
/*     */ import dtv.pos.framework.form.design.color.ColorCellEditor;
/*     */ import dtv.pos.framework.form.design.color.ColorCellRenderer;
/*     */ import dtv.pos.framework.form.design.model.FormDesignerDetailModel;
/*     */ import dtv.pos.framework.form.design.model.KeyStrokeComboBoxModel;
/*     */ import dtv.pos.framework.form.design.text.DataFieldConfigCellEditor;
/*     */ import dtv.pos.framework.form.design.text.DataFieldConfigCellRenderer;
/*     */ import dtv.pos.iframework.form.FormLocationType;
/*     */ import dtv.pos.iframework.form.config.EnumPossibleValues;
/*     */ import dtv.pos.iframework.form.config.FormPanelType;
/*     */ import dtv.pos.iframework.form.design.type.FontSize;
/*     */ import dtv.pos.iframework.form.design.type.FormComponentType;
/*     */ import dtv.pos.iframework.ui.FontStyle;
/*     */ import dtv.pos.iframework.ui.ScrollingPolicy;
/*     */ import dtv.pos.iframework.ui.SelectionMode;
/*     */ import dtv.pos.iframework.ui.TableLayoutHorizontalAlignment;
/*     */ import dtv.pos.iframework.ui.TableLayoutVerticalAlignment;
/*     */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
/*     */ import dtv.pos.ui.text.TextFieldFormatterFactory;
/*     */ import dtv.pos.ui.text.TextFieldInputType;
/*     */ import dtv.util.ArrayUtils;
/*     */ import java.awt.Color;
/*     */ import javax.swing.ComboBoxModel;
/*     */ import javax.swing.DefaultCellEditor;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFormattedTextField;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.TableModelEvent;
/*     */ import javax.swing.event.TableModelListener;
/*     */ import javax.swing.plaf.ComponentUI;
/*     */ import javax.swing.plaf.basic.BasicComboBoxEditor;
/*     */ import javax.swing.plaf.basic.BasicComboBoxUI;
/*     */ import javax.swing.table.DefaultTableCellRenderer;
/*     */ import javax.swing.table.TableCellEditor;
/*     */ import javax.swing.table.TableCellRenderer;
/*     */ import javax.swing.table.TableModel;
/*     */ 
/*     */ public class FormDesignerDetailView
/*     */   extends PropertyEditTable {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final FormDesignerDetailModel model_;
/*     */   
/*  46 */   private final TableModelListener cancelEditListener = new TableModelListener()
/*     */     {
/*     */       public void tableChanged(TableModelEvent e) {
/*  49 */         FormDesignerDetailView.this.editingCanceled(new ChangeEvent(this));
/*  50 */         FormDesignerDetailView.this.clearSelection();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   public FormDesignerDetailView(FormDesignerDetailModel argModel) {
/*  57 */     updateUI();
/*     */     
/*  59 */     this.model_ = argModel;
/*  60 */     setModel((TableModel)argModel);
/*     */     
/*  62 */     setRowHeight(28);
/*     */     
/*  64 */     this.model_.addTableModelListener(this.cancelEditListener);
/*     */ 
/*     */     
/*  67 */     JComboBox c = new TableComboBox((Object[])FormLocationType.getInstances());
/*  68 */     setDefaultEditor(FormLocationType.class, new DefaultCellEditor(c));
/*     */ 
/*     */     
/*  71 */     c = new TableComboBox((Object[])TableLayoutHorizontalAlignment.getInstances());
/*  72 */     setDefaultEditor(TableLayoutHorizontalAlignment.class, new DefaultCellEditor(c));
/*     */ 
/*     */     
/*  75 */     c = new TableComboBox((Object[])TableLayoutVerticalAlignment.getInstances());
/*  76 */     setDefaultEditor(TableLayoutVerticalAlignment.class, new DefaultCellEditor(c));
/*     */ 
/*     */     
/*  79 */     c = new TableComboBox((Object[])ScrollingPolicy.getInstances());
/*  80 */     setDefaultEditor(ScrollingPolicy.class, new DefaultCellEditor(c));
/*     */ 
/*     */     
/*  83 */     c = new TableComboBox((Object[])FormComponentType.getInstances());
/*     */     
/*  85 */     c.setEditable(true);
/*  86 */     setDefaultEditor(FormComponentType.class, new DefaultCellEditor(c));
/*     */ 
/*     */     
/*  89 */     c = new TableComboBox((ComboBoxModel)new KeyStrokeComboBoxModel());
/*  90 */     c.setEditable(true);
/*  91 */     setDefaultEditor(XstKeyStroke.class, new DefaultCellEditor(c));
/*     */ 
/*     */     
/*  94 */     c = new TableComboBox((Object[])FormPanelType.getInstances());
/*  95 */     setDefaultEditor(FormPanelType.class, new DefaultCellEditor(c));
/*     */ 
/*     */     
/*  98 */     c = new TableComboBox((Object[])FontStyle.getInstances());
/*  99 */     setDefaultEditor(FontStyle.class, new DefaultCellEditor(c));
/*     */ 
/*     */     
/* 102 */     c = new TableComboBox((Object[])FontSize.getCommonFontSizes());
/* 103 */     setDefaultEditor(FontSize.class, new DefaultCellEditor(c));
/*     */ 
/*     */     
/* 106 */     c = new TableComboBox((Object[])SelectionMode.getInstances());
/* 107 */     setDefaultEditor(SelectionMode.class, new DefaultCellEditor(c));
/*     */ 
/*     */     
/* 110 */     FormatterType[] types = FormatterType.getInstances();
/* 111 */     types = (FormatterType[])ArrayUtils.insert(FormatterType.class, (Object[])types, null, 0);
/* 112 */     JComboBox jComboBox1 = new TableComboBox((Object[])types);
/* 113 */     setDefaultEditor(FormatterType.class, new DefaultCellEditor(jComboBox1));
/*     */ 
/*     */     
/* 116 */     setDefaultEditor(Color.class, (TableCellEditor)new ColorCellEditor());
/* 117 */     setDefaultRenderer(Color.class, (TableCellRenderer)new ColorCellRenderer());
/*     */     
/* 119 */     setDefaultEditor(EnumPossibleValues.class, new EnumPossibleValuesEditor());
/*     */     
/* 121 */     setDefaultEditor(IDataFieldConfig.class, (TableCellEditor)new DataFieldConfigCellEditor());
/* 122 */     setDefaultRenderer(IDataFieldConfig.class, (TableCellRenderer)new DataFieldConfigCellRenderer());
/*     */ 
/*     */ 
/*     */     
/* 126 */     JFormattedTextField integerTextField = new JFormattedTextField(TextFieldFormatterFactory.getInstance().getFormatter(TextFieldInputType.INTEGER));
/*     */     
/* 128 */     setDefaultEditor(Integer.class, new DefaultCellEditor(integerTextField));
/*     */ 
/*     */ 
/*     */     
/* 132 */     JFormattedTextField stringTextField = new JFormattedTextField(TextFieldFormatterFactory.getInstance().getFormatter(TextFieldInputType.SIMPLE));
/*     */     
/* 134 */     setDefaultEditor(String.class, new DefaultCellEditor(stringTextField));
/*     */ 
/*     */     
/* 137 */     setDefaultRenderer(Integer.class, new DefaultTableCellRenderer());
/*     */   }
/*     */ 
/*     */   
/*     */   private class TableComboBox
/*     */     extends JComboBox
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private ComponentUI _ui;
/*     */     
/*     */     TableComboBox(ComboBoxModel<E> model) {
/* 149 */       super(model);
/* 150 */       setEditor(new BasicComboBoxEditor());
/* 151 */       updateUI();
/*     */     }
/*     */     
/*     */     TableComboBox(Object[] items) {
/* 155 */       super((E[])items);
/* 156 */       updateUI();
/*     */     }
/*     */ 
/*     */     
/*     */     public void updateUI() {
/* 161 */       if (this._ui == null)
/* 162 */         setUI(this._ui = BasicComboBoxUI.createUI(this)); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\FormDesignerDetailView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */