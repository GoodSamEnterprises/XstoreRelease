/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import com.google.common.collect.LinkedListMultimap;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.XmlUtils;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
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
/*     */ public class GenerateXmlSchemas
/*     */   implements Callable<Void>
/*     */ {
/*  27 */   private static final Logger logger_ = Logger.getLogger(GenerateXmlSchemas.class);
/*     */   
/*     */   private final DaoGenHelper helper_;
/*     */   
/*     */   GenerateXmlSchemas(DaoGenHelper argHelper) {
/*  32 */     this.helper_ = argHelper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Void call() throws Exception {
/*  40 */     logger_.info("Generating XML Schemas");
/*     */ 
/*     */     
/*  43 */     File dir = new File(this.helper_.getOutPath() + File.separator + "xml-schemas");
/*  44 */     dir.mkdirs();
/*     */     
/*  46 */     LinkedListMultimap<String, DtxDefinition> dtxByPkg = getDtxByPkg();
/*     */     
/*  48 */     for (String pkg : dtxByPkg.keySet()) {
/*     */       
/*  50 */       StringBuilder w = new StringBuilder(5120);
/*     */       
/*  52 */       List<DtxDefinition> definitions = dtxByPkg.get(pkg);
/*     */       
/*  54 */       List<String> requiredImportDomains = getRequiredImports(pkg, definitions);
/*     */       
/*  56 */       writeHeader(definitions.get(0), w, requiredImportDomains);
/*     */       
/*  58 */       for (DtxDefinition dtx : definitions) {
/*  59 */         writeElement(dtx, w);
/*  60 */         writeTypeHeader(dtx, w);
/*  61 */         writeTypeFields(dtx, w);
/*  62 */         writeTypeRelationships(dtx, w);
/*  63 */         writeTypeFooter(dtx, w);
/*     */       } 
/*     */       
/*  66 */       writeFooter(definitions.get(0), w);
/*  67 */       Exception badXml = null;
/*     */       
/*  69 */       String schema = null;
/*     */       
/*     */       try {
/*  72 */         schema = XmlUtils.getBeautifiedXml(w.toString());
/*     */       }
/*  74 */       catch (Exception ee) {
/*  75 */         badXml = ee;
/*  76 */         schema = w.toString();
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*  81 */       File file = new File(this.helper_.getOutPath() + File.separator + "xml-schemas" + File.separator + StringUtils.ensureFirstUpperCase(((DtxDefinition)definitions.get(0)).getPackageDomain()) + ".xsd");
/*  82 */       this.helper_.getWriter().write(file, schema);
/*     */       
/*  84 */       if (badXml != null) {
/*  85 */         throw badXml;
/*     */       }
/*     */     } 
/*  88 */     return null;
/*     */   }
/*     */   
/*     */   private LinkedListMultimap<String, DtxDefinition> getDtxByPkg() {
/*  92 */     LinkedListMultimap<String, DtxDefinition> dtxByPkg = LinkedListMultimap.create();
/*  93 */     for (DtxDefinition dtx : this.helper_.getDtxDefinitions()) {
/*  94 */       dtxByPkg.put(dtx.getPackageRaw(), dtx);
/*     */     }
/*     */     
/*  97 */     return dtxByPkg;
/*     */   }
/*     */   
/*     */   private List<String> getRequiredImports(String argCurrentPackage, List<DtxDefinition> argDtxCurrentPkg) {
/* 101 */     String domain = ((DtxDefinition)argDtxCurrentPkg.get(0)).getPackageDomain();
/*     */     
/* 103 */     List<String> requiredImports = new ArrayList<>();
/*     */     
/* 105 */     for (DtxDefinition dtx : argDtxCurrentPkg) {
/* 106 */       for (DtxRelationship rel : dtx.getRelationships()) {
/* 107 */         if (!rel.getChild().getPackageDomain().equals(domain) && 
/* 108 */           !requiredImports.contains(rel.getChild().getPackageDomain()))
/*     */         {
/* 110 */           requiredImports.add(rel.getChild().getPackageDomain());
/*     */         }
/*     */       } 
/* 113 */       if (dtx.isExtended()) {
/* 114 */         if (!dtx.getExtends().getPackageDomain().equals(dtx.getPackageDomain()) && 
/* 115 */           !requiredImports.contains(dtx.getExtends().getPackageDomain()))
/*     */         {
/* 117 */           requiredImports.add(dtx.getExtends().getPackageDomain());
/*     */         }
/*     */         
/* 120 */         if (!dtx.getTopMostParent().getPackageDomain().equals(dtx.getPackageDomain()) && 
/* 121 */           !requiredImports.contains(dtx.getTopMostParent().getPackageDomain()))
/*     */         {
/* 123 */           requiredImports.add(dtx.getTopMostParent().getPackageDomain());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 128 */     return requiredImports;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isDuplicateField(DtxDefinition.DtxDaoField argField, DtxDefinition argDtx) {
/* 134 */     if (!argDtx.isExtended()) {
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     DtxDefinition.DtxDaoField[] fields = argDtx.getAllFields();
/*     */     
/* 140 */     int matches = 0;
/*     */     
/* 142 */     for (DtxDefinition.DtxDaoField field : fields) {
/* 143 */       if (field.getName().equals(argField.getName())) {
/* 144 */         matches++;
/*     */       }
/*     */     } 
/*     */     
/* 148 */     if (matches > 1) {
/* 149 */       return true;
/*     */     }
/*     */     
/* 152 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isLowLevelField(String argFieldName) {
/* 157 */     return ("CreateDate".equals(argFieldName) || "CreateUserId".equals(argFieldName) || "UpdateDate"
/* 158 */       .equals(argFieldName) || "UpdateUserId".equals(argFieldName));
/*     */   }
/*     */   
/*     */   private void writeElement(DtxDefinition dtx, StringBuilder buf) {
/* 162 */     buf.append("  <!-- ********************************************************************** -->\n");
/* 163 */     buf.append("  <!-- " + dtx.getName() + " - corresponds to table: " + dtx.getTable() + " -->\n");
/* 164 */     buf.append("  <!-- ********************************************************************** -->\n");
/*     */     
/* 166 */     buf.append("<xs:element name=\"" + dtx.getName() + "\"");
/* 167 */     if (dtx.isExtended()) {
/* 168 */       String substitutionGroupName = dtx.getTopMostParent().getName();
/*     */       
/* 170 */       if (!dtx.getTopMostParent().getPackageDomain().equals(dtx.getPackageDomain()))
/*     */       {
/* 172 */         substitutionGroupName = StringUtils.ensureFirstUpperCase(dtx.getTopMostParent().getPackageDomain()) + ":" + substitutionGroupName;
/*     */       }
/*     */ 
/*     */       
/* 176 */       buf.append(" substitutionGroup=\"" + substitutionGroupName + "\"");
/*     */     } 
/* 178 */     buf.append(" type=\"" + dtx.getName() + "Model\"/>");
/*     */   }
/*     */   
/*     */   private void writeFooter(DtxDefinition dtx, StringBuilder buf) {
/* 182 */     buf.append("</xs:schema>");
/*     */   }
/*     */   
/*     */   private void writeHeader(DtxDefinition dtx, StringBuilder buf, List<String> argRequiredImports) {
/* 186 */     String ns = StringUtils.ensureFirstUpperCase(dtx.getPackageDomain());
/* 187 */     buf.append("<?xml version = \"1.0\" encoding = \"UTF-8\"?>");
/* 188 */     buf.append("<!-- ** AUTOGENERATED xml schema ** - do not manually edit. -->");
/* 189 */     buf.append("<xs:schema xmlns = \"http://xmlns.datavantagecorp.com/xstore/" + ns + "\" targetNamespace = \"http://xmlns.datavantagecorp.com/xstore/" + ns + "\" xmlns:xs = \"http://www.w3.org/2001/XMLSchema\" elementFormDefault = \"qualified\" attributeFormDefault = \"unqualified\"");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     for (String domain : argRequiredImports) {
/* 195 */       domain = StringUtils.ensureFirstUpperCase(domain);
/* 196 */       buf.append(" xmlns:" + domain + " = \"http://xmlns.datavantagecorp.com/xstore/" + domain + "\"");
/*     */     } 
/*     */     
/* 199 */     buf.append(">\n\n");
/*     */     
/* 201 */     for (String domain : argRequiredImports) {
/* 202 */       domain = StringUtils.ensureFirstUpperCase(domain);
/* 203 */       buf.append(" <xs:import namespace=\"http://xmlns.datavantagecorp.com/xstore/" + domain + "\" schemaLocation = \"" + domain + ".xsd\"/>");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeTypeFields(DtxDefinition dtx, StringBuilder buf) {
/* 209 */     for (DtxDefinition.DtxDaoField field : dtx.getFields()) {
/* 210 */       String fieldName = StringUtils.ensureFirstUpperCase(field.getName());
/* 211 */       String xmlType = DaoGenUtils.getXmlTypeForField(field);
/*     */       
/* 213 */       if (field.getExported() && !isLowLevelField(fieldName) && !isDuplicateField(field, dtx)) {
/* 214 */         buf.append("<xs:element name=\"" + fieldName + "\" type=\"xs:" + xmlType + "\" ");
/*     */         
/* 216 */         if (!field.isPrimaryKey()) {
/* 217 */           buf.append(" minOccurs=\"0\"");
/*     */         }
/*     */         
/* 220 */         buf.append("/>");
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void writeTypeFooter(DtxDefinition dtx, StringBuilder buf) {
/* 226 */     buf.append("</xs:sequence>");
/*     */     
/* 228 */     if (dtx.isExtended()) {
/* 229 */       buf.append("            </xs:extension>         </xs:complexContent>");
/*     */     }
/*     */     
/* 232 */     buf.append("</xs:complexType>");
/*     */   }
/*     */   
/*     */   private void writeTypeHeader(DtxDefinition dtx, StringBuilder buf) {
/* 236 */     buf.append("<xs:complexType name=\"" + dtx.getName() + "Model\">");
/* 237 */     if (dtx.isExtended()) {
/* 238 */       String extendsName = dtx.getExtends().getName();
/*     */       
/* 240 */       if (!dtx.getExtends().getPackageDomain().equals(dtx.getPackageDomain()))
/*     */       {
/* 242 */         extendsName = StringUtils.ensureFirstUpperCase(dtx.getExtends().getPackageDomain()) + ":" + extendsName;
/*     */       }
/*     */       
/* 245 */       buf.append("        <xs:complexContent>            <xs:extension base=\"" + extendsName + "Model\">                <xs:sequence minOccurs=\"0\">");
/*     */     }
/*     */     else {
/*     */       
/* 249 */       buf.append("<xs:sequence>");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void writeTypeRelationships(DtxDefinition dtx, StringBuilder buf) {
/* 254 */     for (DtxRelationship rel : dtx.getRelationships()) {
/* 255 */       String relName = StringUtils.ensureFirstUpperCase(rel.getName());
/*     */       
/* 257 */       String childName = rel.getChildName();
/*     */       
/* 259 */       if (!rel.getChild().getPackageDomain().equals(dtx.getPackageDomain())) {
/* 260 */         childName = StringUtils.ensureFirstUpperCase(rel.getChild().getPackageDomain()) + ":" + childName;
/*     */       }
/*     */       
/* 263 */       buf.append("<xs:element name=\"" + relName + "\"  minOccurs=\"0\">   <xs:complexType>                                                    <xs:sequence>                                            ");
/*     */ 
/*     */ 
/*     */       
/* 267 */       buf.append("<xs:element ref=\"" + childName + "\" ");
/* 268 */       if (!rel.getType().equalsIgnoreCase(DtxRelationship.ONE_ONE)) {
/* 269 */         buf.append("maxOccurs=\"unbounded\"");
/*     */       }
/* 271 */       buf.append("/>");
/*     */       
/* 273 */       buf.append("                    </xs:sequence>                </xs:complexType>             </xs:element>         ");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\GenerateXmlSchemas.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */