/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public class DtxDefinition
/*     */ {
/*  22 */   private static final Logger _logger = Logger.getLogger(DtxDefinition.class);
/*  23 */   private final List<DtxDaoField> fields_ = new ArrayList<>();
/*     */   
/*     */   private String name_;
/*     */   private String package_;
/*     */   private String table_;
/*     */   private boolean extensible_ = false;
/*     */   private String extendsString_;
/*     */   private DtxDefinition extends_;
/*     */   private File sourceDtxFile_;
/*     */   private File dtj_;
/*  33 */   private List<DtxRelationship> relationships_ = new ArrayList<>();
/*  34 */   private List<DtxInverseRelationship> inverseRelationships_ = new ArrayList<>();
/*  35 */   private String implements_ = null;
/*  36 */   private String _modelGenerator = DefaultModelGenerator.class.getName();
/*     */   
/*     */   private boolean isProperties = false;
/*     */   
/*     */   private boolean customerExtension_ = false;
/*     */   
/*     */   private boolean placeHolder_;
/*     */   private boolean needsGeneration_ = true;
/*     */   
/*     */   public void addField(DtxDaoField argField) {
/*  46 */     this.fields_.add(argField);
/*     */   }
/*     */   
/*     */   public void addRelationship(DtxRelationship argRelationship) {
/*  50 */     argRelationship.setParent(this);
/*  51 */     this.relationships_.add(argRelationship);
/*     */   }
/*     */   
/*     */   public DtxDaoField findField(String argFieldName) {
/*  55 */     DtxDaoField[] fields = getFields();
/*     */     
/*  57 */     for (DtxDaoField field : fields) {
/*  58 */       if (field.getName().equals(argFieldName)) {
/*  59 */         return field;
/*     */       }
/*     */     } 
/*     */     
/*  63 */     if (isExtended()) {
/*  64 */       return this.extends_.findField(argFieldName);
/*     */     }
/*     */     
/*  67 */     return null;
/*     */   }
/*     */   
/*     */   public DtxDaoField[] getAllFields() {
/*  71 */     if (isExtended()) {
/*  72 */       DtxDaoField[] parentFields = this.extends_.getAllFields();
/*  73 */       DtxDaoField[] myFields = getFields();
/*     */       
/*  75 */       return (DtxDaoField[])ArrayUtils.combine(DtxDaoField.class, (Object[])parentFields, (Object[])myFields);
/*     */     } 
/*     */     
/*  78 */     return getFields();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DtxRelationship> getAllRelationships() {
/*  89 */     if (isExtended()) {
/*  90 */       List<DtxRelationship> parentRels = this.extends_.getAllRelationships();
/*  91 */       List<DtxRelationship> myRels = getRelationships();
/*  92 */       List<DtxRelationship> allRels = new ArrayList<>();
/*  93 */       allRels.addAll(parentRels);
/*  94 */       allRels.addAll(myRels);
/*     */       
/*  96 */       return allRels;
/*     */     } 
/*     */     
/*  99 */     return getRelationships();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCleanbeanClassname() {
/* 104 */     return getCleanbeanPackageRaw() + "." + getName();
/*     */   }
/*     */   
/*     */   public String getCleanbeanPackageRaw() {
/* 108 */     if (this.package_.contains(".dao.")) {
/* 109 */       return this.package_.replace(".dao.", ".cleanbean.");
/*     */     }
/* 111 */     return this.package_ + ".cleanbean";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getColumnForFieldName(String argFieldName) {
/* 116 */     DtxDaoField field = findField(argFieldName);
/*     */     
/* 118 */     if (field == null) {
/* 119 */       throw new RuntimeException("Could not get column name for field: " + argFieldName + " on dtx: " + 
/* 120 */           getName());
/*     */     }
/*     */     
/* 123 */     return field.getColumn();
/*     */   }
/*     */   
/*     */   public String getDao() {
/* 127 */     return getPackage() + "." + getName() + "DAO";
/*     */   }
/*     */   
/*     */   public String getDba() {
/* 131 */     return getPackage() + "." + getName() + "DBA";
/*     */   }
/*     */   
/*     */   public File getDtj() {
/* 135 */     return this.dtj_;
/*     */   }
/*     */   
/*     */   public DtxDefinition getExtends() {
/* 139 */     return this.extends_;
/*     */   }
/*     */   
/*     */   public String getExtendsStringType() {
/* 143 */     return this.extendsString_;
/*     */   }
/*     */   
/*     */   public DtxDaoField[] getFields() {
/* 147 */     return this.fields_.<DtxDaoField>toArray(new DtxDaoField[this.fields_.size()]);
/*     */   }
/*     */   
/*     */   public DtxDaoField[] getFieldsPlusInheritedPrimaryKeys() {
/* 151 */     if (!isExtended() || this.extends_.isPlaceHolder()) {
/* 152 */       return getFields();
/*     */     }
/*     */     
/* 155 */     List<DtxDaoField> fieldsPlusPrimarys = new ArrayList<>();
/* 156 */     for (DtxDaoField key : getPrimaryKeyFields()) {
/* 157 */       fieldsPlusPrimarys.add(key);
/*     */     }
/*     */     
/* 160 */     for (DtxDaoField f : this.fields_) {
/* 161 */       fieldsPlusPrimarys.add(f);
/*     */     }
/*     */     
/* 164 */     return fieldsPlusPrimarys.<DtxDaoField>toArray(new DtxDaoField[fieldsPlusPrimarys.size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getId() {
/* 169 */     return getId(true);
/*     */   }
/*     */   
/*     */   public String getIdType() {
/* 173 */     if (!isExtended()) {
/* 174 */       return getName() + "Id";
/*     */     }
/*     */     
/* 177 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getImplementingClassField() {
/* 182 */     return getImplementingClassField(true);
/*     */   }
/*     */   
/*     */   public String getImplementingClassField(boolean argTraverseTree) {
/* 186 */     for (DtxDaoField field : this.fields_) {
/* 187 */       if ("className".equalsIgnoreCase(field.getName())) {
/* 188 */         return field.getName();
/*     */       }
/*     */     } 
/*     */     
/* 192 */     if (argTraverseTree && isExtended()) {
/* 193 */       return this.extends_.getImplementingClassField();
/*     */     }
/*     */     
/* 196 */     return null;
/*     */   }
/*     */   
/*     */   public String getImplements() {
/* 200 */     return this.implements_;
/*     */   }
/*     */   
/*     */   public String getInterface() {
/* 204 */     return getInterfacePackage() + "." + getInterfaceTypeOnly();
/*     */   }
/*     */   
/*     */   public String getInterfacePackage() {
/* 208 */     return getPackage().replaceAll(".impl", "");
/*     */   }
/*     */   
/*     */   public String getInterfaceTypeOnly() {
/* 212 */     return "I" + getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DtxInverseRelationship getInverseRelationship(DtxDefinition argPotentialParent) {
/* 223 */     DtxInverseRelationship[] inverseRels = getInverseRelationships();
/*     */     
/* 225 */     for (DtxInverseRelationship inverseRel : inverseRels) {
/* 226 */       if (inverseRel.getParent().getName().equals(argPotentialParent.getName())) {
/* 227 */         return inverseRel;
/*     */       }
/*     */     } 
/* 230 */     return null;
/*     */   }
/*     */   
/*     */   public DtxInverseRelationship[] getInverseRelationships() {
/* 234 */     return this.inverseRelationships_.<DtxInverseRelationship>toArray(new DtxInverseRelationship[this.inverseRelationships_.size()]);
/*     */   }
/*     */   
/*     */   public String getModel() {
/* 238 */     return getPackage() + "." + getName() + "Model";
/*     */   }
/*     */   
/*     */   public String getModelGenerator() {
/* 242 */     return this._modelGenerator;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 246 */     return this.name_;
/*     */   }
/*     */   
/*     */   public List<DtxDaoField> getNonPkFields() {
/* 250 */     if (this.fields_ == null) {
/* 251 */       return new ArrayList<>(0);
/*     */     }
/*     */     
/* 254 */     List<DtxDaoField> nonPkFields = new ArrayList<>(this.fields_.size());
/*     */     
/* 256 */     for (DtxDaoField field : this.fields_) {
/* 257 */       if (!field.isPrimaryKey()) {
/* 258 */         nonPkFields.add(field);
/*     */       }
/*     */     } 
/*     */     
/* 262 */     return nonPkFields;
/*     */   }
/*     */   
/*     */   public String getPackage() {
/* 266 */     return this.package_ + ".impl";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPackageDomain() {
/* 275 */     return this.package_.substring(this.package_.lastIndexOf('.') + 1, this.package_.length());
/*     */   }
/*     */   
/*     */   public String getPackageRaw() {
/* 279 */     return this.package_;
/*     */   }
/*     */   
/*     */   public DtxDaoField[] getPrimaryKeyFields() {
/* 283 */     if (isExtended() && !this.extends_.isPlaceHolder()) {
/* 284 */       return this.extends_.getPrimaryKeyFields();
/*     */     }
/*     */     
/* 287 */     return getPrimaryKeyFieldsRaw();
/*     */   }
/*     */   
/*     */   public DtxDaoField[] getPrimaryKeyFieldsRaw() {
/* 291 */     List<DtxDaoField> primaryKeys = new ArrayList<>(5);
/*     */     
/* 293 */     for (DtxDaoField field : this.fields_) {
/* 294 */       if (field.isPrimaryKey()) {
/* 295 */         primaryKeys.add(field);
/*     */       }
/*     */     } 
/*     */     
/* 299 */     return primaryKeys.<DtxDaoField>toArray(new DtxDaoField[primaryKeys.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DtxRelationship> getRelationships() {
/* 308 */     return this.relationships_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DtxRelationship> getRelationships(String argType) {
/* 319 */     List<DtxRelationship> tempList = new ArrayList<>();
/* 320 */     for (DtxRelationship rel : this.relationships_) {
/* 321 */       if (rel.getType().equalsIgnoreCase(argType)) {
/* 322 */         tempList.add(rel);
/*     */       }
/*     */     } 
/*     */     
/* 326 */     return tempList;
/*     */   }
/*     */   
/*     */   public File getSourceDtxFile() {
/* 330 */     return this.sourceDtxFile_;
/*     */   }
/*     */   
/*     */   public String getTable() {
/* 334 */     return this.table_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DtxDefinition getTopMostParent() {
/* 343 */     if (isExtended()) {
/* 344 */       return this.extends_.getTopMostParent();
/*     */     }
/*     */     
/* 347 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasIncrementalField() {
/* 352 */     for (DtxDaoField field : this.fields_) {
/* 353 */       if (field.getIncrementField()) {
/* 354 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 358 */     return false;
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
/*     */   public boolean isCustomerExtension() {
/* 372 */     return this.customerExtension_;
/*     */   }
/*     */   
/*     */   public boolean isExtended() {
/* 376 */     return (this.extends_ != null && !isCustomerExtension());
/*     */   }
/*     */   
/*     */   public boolean isExtensible() {
/* 380 */     return this.extensible_;
/*     */   }
/*     */   
/*     */   public boolean isOrgHierarchical() {
/* 384 */     return DaoGenOrgHierarchyHelper.isOrgHierarchical(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPlaceHolder() {
/* 391 */     return this.placeHolder_;
/*     */   }
/*     */   
/*     */   public boolean isProperties() {
/* 395 */     return this.isProperties;
/*     */   }
/*     */   
/*     */   public boolean needsGeneration(File argFile) {
/* 399 */     return this.needsGeneration_;
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
/*     */   public void setCustomerExtension(boolean argCustomerExtension) {
/* 413 */     this.customerExtension_ = argCustomerExtension;
/*     */   }
/*     */   
/*     */   public void setExtends(DtxDefinition argExtends) {
/* 417 */     this.extends_ = argExtends;
/*     */   }
/*     */   
/*     */   public void setExtendsString(String argExtendsString) {
/* 421 */     this.extendsString_ = argExtendsString;
/*     */   }
/*     */   
/*     */   public void setExtensible(boolean argExtensible) {
/* 425 */     this.extensible_ = argExtensible;
/*     */   }
/*     */   
/*     */   public void setImplements(String impl) {
/* 429 */     this.implements_ = impl;
/*     */   }
/*     */   
/*     */   public void setInverseRelationships(List<DtxInverseRelationship> argInverseRelationships) {
/* 433 */     this.inverseRelationships_ = argInverseRelationships;
/*     */   }
/*     */   
/*     */   public void setIsProperties(boolean isProps) {
/* 437 */     this.isProperties = isProps;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setModelGenerator(String argModelGenerator) {
/* 445 */     this._modelGenerator = argModelGenerator;
/*     */   }
/*     */   
/*     */   public void setName(String argName) {
/* 449 */     this.name_ = argName;
/*     */   }
/*     */   
/*     */   public void setNeedsGeneration(boolean argNeedsGeneration) {
/* 453 */     this.needsGeneration_ = argNeedsGeneration;
/*     */   }
/*     */   
/*     */   public void setPackage(String argPackage) {
/* 457 */     this.package_ = argPackage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPlaceHolder(boolean argPlaceHolder) {
/* 464 */     this.placeHolder_ = argPlaceHolder;
/*     */   }
/*     */   
/*     */   public void setRelationships(List<DtxRelationship> argRelationships) {
/* 468 */     if (argRelationships != null) {
/* 469 */       for (DtxRelationship r : argRelationships) {
/* 470 */         r.setParent(this);
/*     */       }
/*     */     }
/*     */     
/* 474 */     this.relationships_ = argRelationships;
/*     */   }
/*     */   
/*     */   public void setSourceDtxFile(File argSourceDtxFile) {
/* 478 */     this.sourceDtxFile_ = argSourceDtxFile;
/* 479 */     this.dtj_ = new File(this.sourceDtxFile_.getPath().replaceAll("\\.dtx$", ".dtj"));
/*     */   }
/*     */   
/*     */   public void setTable(String argTable) {
/* 483 */     this.table_ = argTable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void validate() {
/* 492 */     if (StringUtils.isEmpty(getName())) {
/* 493 */       throw new RuntimeException("DTX: " + 
/* 494 */           getSourceDtxFile().getAbsolutePath() + " does not define a DAO name.");
/*     */     }
/* 496 */     if (StringUtils.isEmpty(getTable())) {
/* 497 */       throw new RuntimeException("DTX: " + 
/* 498 */           getSourceDtxFile().getAbsolutePath() + " does not define a table.");
/*     */     }
/* 500 */     if (StringUtils.isEmpty(getPackage())) {
/* 501 */       throw new RuntimeException("DTX: " + 
/* 502 */           getSourceDtxFile().getAbsolutePath() + " does not define a package.");
/*     */     }
/* 504 */     if ((getPrimaryKeyFields()).length < 1) {
/* 505 */       _logger
/* 506 */         .warn("DTX: " + getSourceDtxFile().getAbsolutePath() + " does not define any primary key fields.");
/*     */     }
/* 508 */     if (isExtensible() && StringUtils.isEmpty(getImplementingClassField())) {
/* 509 */       throw new RuntimeException("DTX: " + getSourceDtxFile().getAbsolutePath() + " is marked as extensible, but does not declare a className field");
/*     */     }
/*     */     
/* 512 */     if (!isExtensible() && !StringUtils.isEmpty(getImplementingClassField(false))) {
/* 513 */       throw new RuntimeException("DTX: " + getSourceDtxFile().getAbsolutePath() + " is NOT marked as extensible, but declares a className field");
/*     */     }
/*     */     
/* 516 */     if (!isExtensible() && !StringUtils.isEmpty(getImplementingClassField(false))) {
/* 517 */       throw new RuntimeException("DTX: " + getSourceDtxFile().getAbsolutePath() + " is NOT marked as extensible, but declares a className field");
/*     */     }
/*     */ 
/*     */     
/* 521 */     if ("dtv.data2.access.IDataModel".equals(getImplements())) {
/* 522 */       throw new RuntimeException("DTX: " + getSourceDtxFile().getAbsolutePath() + " should not declare 'implements dtv.data2.access.IDataModel' because this is implied. Remove the implements attribute if needed");
/*     */     }
/*     */ 
/*     */     
/* 526 */     if (!StringUtils.isEmpty(getId(false)) && isExtended()) {
/* 527 */       throw new RuntimeException("DTX: " + getSourceDtxFile().getAbsolutePath() + " should not declare an ID because it is a child of another dtx.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 533 */     if (isExtended() && (getPrimaryKeyFieldsRaw()).length > 0 && !this.extends_.isPlaceHolder()) {
/* 534 */       throw new RuntimeException("DTX: " + getSourceDtxFile().getAbsolutePath() + " declares primary key fields, but should not because it is a child.  It inherits the PARENTS primary key fields.");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 540 */       for (DtxDaoField f : this.fields_) {
/* 541 */         f.validate();
/*     */       }
/*     */       
/* 544 */       for (DtxRelationship r : getRelationships()) {
/* 545 */         r.validate();
/* 546 */         if (r.getName().equals(getName() + "Extension")) {
/* 547 */           throw new RuntimeException("DTX: " + 
/* 548 */               getSourceDtxFile().getAbsolutePath() + " contains an illegal retlationship name: " + r
/* 549 */               .getName() + ". This is a reserved relationship name.");
/*     */         }
/*     */       } 
/*     */       
/* 553 */       for (DtxInverseRelationship ir : this.inverseRelationships_) {
/* 554 */         ir.validate();
/*     */       }
/*     */     }
/* 557 */     catch (Exception ee) {
/* 558 */       throw new RuntimeException("Validation failed for DTX: " + getSourceDtxFile().getAbsolutePath(), ee);
/*     */     } 
/*     */   }
/*     */   
/*     */   private String getId(boolean argSearchParents) {
/* 563 */     if (isExtended()) {
/* 564 */       if (argSearchParents) {
/* 565 */         return this.extends_.getId();
/*     */       }
/*     */       
/* 568 */       return null;
/*     */     } 
/*     */     
/* 571 */     return this.package_ + "." + getName() + "Id";
/*     */   }
/*     */ 
/*     */   
/*     */   public static class DtxDaoField
/*     */   {
/*     */     private String name_;
/*     */     
/*     */     private String column_;
/*     */     private String type_;
/*     */     private boolean sensitive_ = false;
/*     */     private String encrypt_;
/*     */     private boolean primaryKey_ = false;
/*     */     private boolean export_ = true;
/*     */     private boolean incrementField_ = false;
/*     */     private Object defaultValueIfNull_;
/*     */     private boolean suppression_ = false;
/* 588 */     private String comment_ = new String();
/*     */     
/*     */     public String getColumn() {
/* 591 */       return this.column_;
/*     */     }
/*     */     
/*     */     public String getComment() {
/* 595 */       return this.comment_;
/*     */     }
/*     */     
/*     */     public Number getDefaultValueIfNull() {
/* 599 */       if (this.defaultValueIfNull_ == null) {
/* 600 */         return null;
/*     */       }
/*     */       
/* 603 */       if ("Integer".equalsIgnoreCase(getType()) || "Int".equalsIgnoreCase(getType())) {
/* 604 */         return Integer.valueOf(this.defaultValueIfNull_.toString());
/*     */       }
/* 606 */       if ("Long".equalsIgnoreCase(getType())) {
/* 607 */         return Long.valueOf(this.defaultValueIfNull_.toString());
/*     */       }
/*     */       
/* 610 */       throw new RuntimeException("Unknown type: " + 
/* 611 */           getType() + " this should have been caught during validation.");
/*     */     }
/*     */ 
/*     */     
/*     */     public String getEncrypt() {
/* 616 */       return this.encrypt_;
/*     */     }
/*     */     
/*     */     public boolean getExported() {
/* 620 */       return this.export_;
/*     */     }
/*     */     
/*     */     public boolean getIncrementField() {
/* 624 */       return this.incrementField_;
/*     */     }
/*     */     
/*     */     public String getName() {
/* 628 */       return this.name_;
/*     */     }
/*     */     
/*     */     public String getType() {
/* 632 */       return this.type_;
/*     */     }
/*     */     
/*     */     public boolean isPrimaryKey() {
/* 636 */       return this.primaryKey_;
/*     */     }
/*     */     
/*     */     public boolean isSensitive() {
/* 640 */       return this.sensitive_;
/*     */     }
/*     */     
/*     */     public boolean isSuppressed() {
/* 644 */       return this.suppression_;
/*     */     }
/*     */     
/*     */     public void setColumn(String argColumn) {
/* 648 */       this.column_ = argColumn;
/*     */     }
/*     */     
/*     */     public void setComment(String comment) {
/* 652 */       this.comment_ = comment;
/*     */     }
/*     */     
/*     */     public void setDefaultValueIfNull(Object argDefaultValueIfNull) {
/* 656 */       this.defaultValueIfNull_ = argDefaultValueIfNull;
/*     */     }
/*     */     
/*     */     public void setEncrypt(String argEncrypt) {
/* 660 */       this.encrypt_ = argEncrypt;
/*     */     }
/*     */     
/*     */     public void setExported(boolean xpt) {
/* 664 */       this.export_ = xpt;
/*     */     }
/*     */     
/*     */     public void setIncrementField(boolean argIncrementField) {
/* 668 */       this.incrementField_ = argIncrementField;
/*     */     }
/*     */     
/*     */     public void setName(String argName) {
/* 672 */       this.name_ = argName;
/*     */     }
/*     */     
/*     */     public void setPrimaryKey(boolean argPrimaryKey) {
/* 676 */       this.primaryKey_ = argPrimaryKey;
/*     */     }
/*     */     
/*     */     public void setSensitive(boolean argSensitive) {
/* 680 */       this.sensitive_ = argSensitive;
/*     */     }
/*     */     
/*     */     public void setSuppressed(boolean value) {
/* 684 */       this.suppression_ = value;
/*     */     }
/*     */     
/*     */     public void setType(String argType) {
/* 688 */       this.type_ = argType;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 693 */       return "(Field: " + this.name_ + " type: " + this.type_ + " pk: " + this.primaryKey_ + " sensitive: " + this.sensitive_ + ")";
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void validate() {
/* 703 */       if (StringUtils.isEmpty(getName())) {
/* 704 */         throw new RuntimeException("A field does not definte a field name.");
/*     */       }
/* 706 */       if (StringUtils.isEmpty(getColumn())) {
/* 707 */         throw new RuntimeException("FIELD: " + this.name_ + " does not define a column.");
/*     */       }
/* 709 */       if (StringUtils.isEmpty(getType())) {
/* 710 */         throw new RuntimeException("FIELD: " + this.name_ + " does not define a type.");
/*     */       }
/*     */       
/* 713 */       if (Character.isUpperCase(this.name_.charAt(0))) {
/* 714 */         throw new RuntimeException("FIELD: " + this.name_ + " should start with a lowercase letter, NOT uppercase.");
/*     */       }
/*     */ 
/*     */       
/* 718 */       if (this.defaultValueIfNull_ != null && !StringUtils.isEmpty(this.defaultValueIfNull_.toString()))
/* 719 */         if ("Integer".equalsIgnoreCase(getType())) {
/*     */           try {
/* 721 */             Integer.parseInt(this.defaultValueIfNull_.toString());
/*     */           }
/* 723 */           catch (Exception ee) {
/* 724 */             throw new RuntimeException("Invalid default value (" + this.defaultValueIfNull_ + ") specified for field " + this.name_ + " " + ee
/* 725 */                 .getMessage());
/*     */           }
/*     */         
/*     */         }
/* 729 */         else if ("Long".equalsIgnoreCase(getType())) {
/*     */           try {
/* 731 */             Long.parseLong(this.defaultValueIfNull_.toString());
/*     */           }
/* 733 */           catch (RuntimeException ee) {
/* 734 */             throw new RuntimeException("Invalid default value (" + this.defaultValueIfNull_ + ") specified for field " + this.name_ + " " + ee
/* 735 */                 .getMessage());
/*     */           } 
/*     */         } else {
/*     */           
/* 739 */           throw new RuntimeException("Field: " + this.name_ + " specifies a default value for a " + getType() + " field.  Default value is not supported for " + 
/* 740 */               getType() + " fields.");
/*     */         }  
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\DtxDefinition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */