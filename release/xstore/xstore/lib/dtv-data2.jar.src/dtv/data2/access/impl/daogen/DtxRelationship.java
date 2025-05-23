/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import dtv.data2.access.IDataModelRelationship;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DtxRelationship
/*     */ {
/*  19 */   public static final String ONE_ONE = IDataModelRelationship.RelationshipType.ONE_TO_ONE.toString();
/*  20 */   public static final String ONE_MANY = IDataModelRelationship.RelationshipType.ONE_TO_MANY.toString();
/*  21 */   public static final String MANY_MANY = IDataModelRelationship.RelationshipType.MANY_TO_MANY.toString();
/*     */   
/*  23 */   private final List<DtxRelationshipField> fields_ = new ArrayList<>();
/*     */   
/*     */   private String relationshipName_;
/*     */   
/*     */   private String type_;
/*     */   
/*     */   private String parentType_;
/*     */   
/*     */   private String childName_;
/*     */   
/*     */   private DtxDefinition child_;
/*     */   
/*     */   private String table_;
/*     */   
/*     */   private String elementName_;
/*     */   private DtxDefinition parent_;
/*     */   private boolean useParentPm_ = false;
/*     */   private boolean export_ = true;
/*     */   private boolean dependent_ = false;
/*     */   private boolean propertyRelationship_ = false;
/*     */   private boolean transient_ = false;
/*     */   
/*     */   public void addField(DtxRelationshipField argField) {
/*  46 */     this.fields_.add(argField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DtxDefinition getChild() {
/*  55 */     return this.child_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getChildName() {
/*  64 */     return this.childName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDependent() {
/*  73 */     return this.dependent_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getElementName() {
/*  82 */     return this.elementName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DtxRelationshipField getField(int argIndex) {
/*  92 */     return this.fields_.get(argIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DtxRelationshipField> getFields() {
/* 101 */     return this.fields_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DtxRelationshipField> getFieldsNotShared() {
/* 110 */     if (this.fields_ == null || this.fields_.isEmpty()) {
/* 111 */       return new ArrayList<>(0);
/*     */     }
/*     */     
/* 114 */     List<DtxRelationshipField> nonSharedFields = new ArrayList<>();
/* 115 */     for (DtxRelationshipField aField : this.fields_) {
/* 116 */       if (!aField.getShared()) {
/* 117 */         nonSharedFields.add(aField);
/*     */       }
/*     */     } 
/* 120 */     return nonSharedFields;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 129 */     return this.relationshipName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DtxDefinition getParent() {
/* 138 */     return this.parent_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParentAttributeName() {
/* 147 */     return "_" + StringUtils.ensureFirstLowerCase(getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParentType() {
/* 157 */     return this.parentType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTable() {
/* 166 */     return this.table_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 175 */     return this.type_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isExported() {
/* 184 */     return this.export_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPropertyRelationship() {
/* 192 */     return this.propertyRelationship_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTransient() {
/* 200 */     return this.transient_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUseParentPm() {
/* 209 */     return this.useParentPm_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChild(DtxDefinition argChild) {
/* 218 */     this.child_ = argChild;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChildName(String argChildName) {
/* 227 */     this.childName_ = argChildName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDependent(boolean argDependent) {
/* 236 */     this.dependent_ = argDependent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setElementName(String argElementName) {
/* 245 */     this.elementName_ = argElementName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExported(boolean argExport) {
/* 254 */     this.export_ = argExport;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String argRelationshipName) {
/* 263 */     this.relationshipName_ = argRelationshipName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParent(DtxDefinition argParent) {
/* 272 */     this.parent_ = argParent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentType(String argParent) {
/* 281 */     this.parentType_ = argParent;
/*     */   }
/*     */   
/*     */   public void setPropertyRelationship(boolean argPropertyRelationship) {
/* 285 */     this.propertyRelationship_ = argPropertyRelationship;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTable(String argTable) {
/* 294 */     this.table_ = argTable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransient(boolean argTransient) {
/* 302 */     this.transient_ = argTransient;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String argType) {
/* 311 */     this.type_ = argType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUseParentPm(boolean argUseParentPm) {
/* 320 */     this.useParentPm_ = argUseParentPm;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void validate() {
/* 329 */     if (StringUtils.isEmpty(getName())) {
/* 330 */       throw new RuntimeException("There is no relationship name specified.");
/*     */     }
/*     */     
/* 333 */     if (StringUtils.isEmpty(getType())) {
/* 334 */       throw new RuntimeException("The relationship: " + getName() + " does not define a relationship type.");
/*     */     }
/*     */     
/* 337 */     if (!getType().equalsIgnoreCase(ONE_ONE) && !getType().equalsIgnoreCase(ONE_MANY) && 
/* 338 */       !getType().equalsIgnoreCase(MANY_MANY))
/*     */     {
/* 340 */       throw new RuntimeException("The relationship: " + getName() + " defines an unknown type: " + getType());
/*     */     }
/*     */     
/* 343 */     if (StringUtils.isEmpty(getChildName())) {
/* 344 */       throw new RuntimeException("The relationship: " + getName() + " does not define a child type.");
/*     */     }
/*     */     
/* 347 */     if (this.child_ == null) {
/* 348 */       throw new RuntimeException("The relationship: " + 
/* 349 */           getName() + " does not have its child_ DtxDefinition set");
/*     */     }
/*     */     
/* 352 */     if (this.parent_ == null) {
/* 353 */       throw new RuntimeException("The relationship: " + 
/* 354 */           getName() + " does not have its parent_ DtxDefinition set");
/*     */     }
/*     */     
/* 357 */     if (getType().equalsIgnoreCase(MANY_MANY) && StringUtils.isEmpty(getTable())) {
/* 358 */       throw new RuntimeException("The relationship: " + 
/* 359 */           getName() + " is a MANY-MANY but does not define the table attribute");
/*     */     }
/*     */     
/* 362 */     if (!StringUtils.isEmpty(getParentType())) {
/* 363 */       throw new RuntimeException("The relationship: " + 
/* 364 */           getName() + " defines the parent: " + getParent() + " but does not need to");
/*     */     }
/*     */     
/* 367 */     if (!getType().equalsIgnoreCase(ONE_ONE) && getDependent()) {
/* 368 */       throw new RuntimeException("The relationship: " + getName() + " is marked as dependent but should not be.  The dependent attribute only applies to ONE-ONE relationships");
/*     */     }
/*     */ 
/*     */     
/* 372 */     Set<String> parentFieldNames = new HashSet<>();
/* 373 */     Set<String> childFieldNames = new HashSet<>();
/*     */     
/* 375 */     for (DtxRelationshipField field : this.fields_) {
/*     */       
/* 377 */       if (!getType().equalsIgnoreCase(ONE_ONE) && 
/* 378 */         field.getShared()) {
/* 379 */         throw new RuntimeException("The relationship: " + getName() + " defines a field which is marked as shared.  *Shared only applies to ONE-ONE relationships.*");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 384 */       if (ONE_ONE.equalsIgnoreCase(getType())) {
/*     */ 
/*     */         
/* 387 */         for (DtxDefinition.DtxDaoField key : this.parent_.getPrimaryKeyFields()) {
/* 388 */           if (!getDependent() && !field.getShared() && field.getParent().equals(key.getName())) {
/* 389 */             throw new RuntimeException("The relationship: " + getName() + " defines a NON-SHARED field " + field
/* 390 */                 .getParent() + " WHICH IS A PRIMARY KEY OF THE PARENT.  this is problematic because the primary key will be altered as this relationship changes.");
/*     */           }
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 401 */         if ((this.child_.getPrimaryKeyFields()).length == this.fields_.size()) {
/* 402 */           for (int ii = 0; ii < (this.child_.getPrimaryKeyFields()).length; ii++) {
/*     */             
/* 404 */             String childField = this.child_.getPrimaryKeyFields()[ii].getName();
/* 405 */             String relField = ((DtxRelationshipField)this.fields_.get(ii)).getChild();
/*     */             
/* 407 */             if (!childField.equals(relField))
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 413 */               for (DtxRelationshipField thisField : this.fields_) {
/* 414 */                 if (thisField.getChild().equals(this.child_.getPrimaryKeyFields()[ii].getName())) {
/* 415 */                   throw new RuntimeException((new StringBuilder(200)).append("Relationship [").append(getName())
/* 416 */                       .append("] in dtx [").append(this.parent_.getName())
/* 417 */                       .append("] has primary key fields in a different order than its child [")
/* 418 */                       .append(this.child_.getName()).append("]. This causes problems with object id parsing.")
/* 419 */                       .toString());
/*     */                 }
/*     */               } 
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 429 */       if (!MANY_MANY.equalsIgnoreCase(getType())) {
/* 430 */         if (!StringUtils.isEmpty(field.getXrefField())) {
/* 431 */           throw new RuntimeException("The relationship: " + getName() + " defines an xref field but is not MANY-MANY.  Only MANY-MANY's have xref fields.");
/*     */         }
/*     */ 
/*     */         
/* 435 */         if (StringUtils.isEmpty(field.getParent())) {
/* 436 */           throw new RuntimeException("The relationship: " + 
/* 437 */               getName() + " does not define a parent type, but should.");
/*     */         }
/* 439 */         if (StringUtils.isEmpty(field.getChild())) {
/* 440 */           throw new RuntimeException("The relationship: " + 
/* 441 */               getName() + " does not define a child type, but should.");
/*     */         }
/*     */       } 
/*     */       
/* 445 */       field.validate();
/*     */       
/* 447 */       if (!StringUtils.isEmpty(field.getParent())) {
/* 448 */         if (parentFieldNames.contains(field.getParent())) {
/* 449 */           throw new RuntimeException("The relationship: " + getName() + " defines the same parent field name twice: " + field
/* 450 */               .getParent());
/*     */         }
/* 452 */         parentFieldNames.add(field.getParent());
/*     */       } 
/*     */       
/* 455 */       if (!StringUtils.isEmpty(field.getChild())) {
/* 456 */         if (childFieldNames.contains(field.getChild())) {
/* 457 */           throw new RuntimeException("The relationship: " + getName() + " defines the same child field name twice: " + field
/* 458 */               .getChild());
/*     */         }
/* 460 */         childFieldNames.add(field.getChild());
/*     */       } 
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
/* 478 */       if (!StringUtils.isEmpty(field.getChild()) && 
/* 479 */         this.child_.findField(field.getChild()) == null) {
/* 480 */         throw new RuntimeException("The relationship: " + getName() + " has a field which references non-existent child field: " + field
/* 481 */             .getParent());
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public class DtxRelationshipField
/*     */   {
/*     */     private String fieldParent_;
/*     */     private String fieldChild_;
/*     */     private String xrefField_;
/*     */     private String value_;
/*     */     private boolean sharedSet_ = false;
/*     */     private boolean shared_ = false;
/*     */     
/*     */     public String getChild() {
/* 496 */       return this.fieldChild_;
/*     */     }
/*     */     
/*     */     public String getParent() {
/* 500 */       return this.fieldParent_;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean getShared() {
/* 505 */       if (!this.sharedSet_) {
/*     */         
/* 507 */         if (DtxRelationship.ONE_ONE.equalsIgnoreCase(DtxRelationship.this.getType())) {
/* 508 */           for (DtxDefinition.DtxDaoField key : DtxRelationship.this.parent_.getPrimaryKeyFields()) {
/* 509 */             if (getParent().equals(key.getName())) {
/* 510 */               this.shared_ = true;
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         }
/* 515 */         this.sharedSet_ = true;
/*     */       } 
/* 517 */       return this.shared_;
/*     */     }
/*     */     
/*     */     public String getValue() {
/* 521 */       return this.value_;
/*     */     }
/*     */     
/*     */     public String getXrefField() {
/* 525 */       return this.xrefField_;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setChild(String argChild) {
/* 534 */       this.fieldChild_ = argChild;
/*     */     }
/*     */     
/*     */     public void setParent(String argParent) {
/* 538 */       this.fieldParent_ = argParent;
/*     */     }
/*     */     
/*     */     public void setValue(String argValue) {
/* 542 */       this.value_ = argValue;
/*     */     }
/*     */     
/*     */     public void setXrefField(String argXrefField) {
/* 546 */       this.xrefField_ = argXrefField;
/*     */     }
/*     */     
/*     */     public void validate() {}
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\DtxRelationship.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */