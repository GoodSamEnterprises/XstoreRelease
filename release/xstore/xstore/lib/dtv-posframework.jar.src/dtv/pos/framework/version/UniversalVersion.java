/*     */ package dtv.pos.framework.version;
/*     */ 
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*     */ import org.apache.commons.lang3.builder.HashCodeBuilder;
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
/*     */ public class UniversalVersion
/*     */   implements Comparable<UniversalVersion>, Iterable<UniversalVersion.IVersionLevel>
/*     */ {
/*     */   private final List<IVersionLevel> _versionLevels;
/*     */   
/*     */   public static UniversalVersion make(String argVersionString) {
/*  52 */     return new UniversalVersion(argVersionString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static UniversalVersion makeUnknown() {
/*  63 */     return new UniversalVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static List<? extends IVersionLevel> parseVersionLevels(String argVersionString) {
/*  73 */     List<IVersionLevel> levels = new ArrayList<>();
/*     */     
/*  75 */     if (!StringUtils.isEmpty(argVersionString)) {
/*     */ 
/*     */ 
/*     */       
/*  79 */       String[] levelParts = StringUtils.pack(argVersionString).split("[^0-9a-zA-Z\\.]");
/*     */       
/*  81 */       if (levelParts != null) {
/*  82 */         for (String levelPart : levelParts) {
/*  83 */           levels.add(new VersionLevel(levelPart));
/*     */         }
/*     */       }
/*     */     } 
/*  87 */     return levels;
/*     */   }
/*     */ 
/*     */   
/*     */   private static List<IVersionLevel> initLevels() {
/*  92 */     return new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private UniversalVersion() {
/*  99 */     this(initLevels());
/*     */   }
/*     */ 
/*     */   
/*     */   private UniversalVersion(IVersionLevel... argLevels) {
/* 104 */     this((argLevels == null) ? initLevels() : Arrays.<IVersionLevel>asList(argLevels));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private UniversalVersion(List<? extends IVersionLevel> argLevels) {
/* 110 */     this._versionLevels = (argLevels == null) ? initLevels() : new ArrayList<>(argLevels);
/*     */   }
/*     */ 
/*     */   
/*     */   private UniversalVersion(String argVersionString) {
/* 115 */     this(parseVersionLevels(argVersionString));
/*     */   }
/*     */ 
/*     */   
/*     */   private UniversalVersion(UniversalVersion argOriginal) {
/* 120 */     this((argOriginal == null) ? initLevels() : argOriginal._versionLevels);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UniversalVersion appendVersion(UniversalVersion argOther) {
/* 130 */     UniversalVersion copy = new UniversalVersion(this);
/*     */     
/* 132 */     if (argOther != null) {
/* 133 */       copy._versionLevels.addAll(argOther._versionLevels);
/*     */     }
/* 135 */     return copy;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(UniversalVersion argOther) {
/* 141 */     if (isUnknown())
/*     */     {
/*     */       
/* 144 */       return argOther.isUnknown() ? 0 : -1;
/*     */     }
/* 146 */     if (argOther.isUnknown())
/*     */     {
/*     */       
/* 149 */       return 1;
/*     */     }
/*     */ 
/*     */     
/* 153 */     int length1 = this._versionLevels.size();
/* 154 */     int length2 = argOther._versionLevels.size();
/*     */     
/* 156 */     for (int i = 0, n = Math.min(length1, length2); i < n; i++) {
/*     */ 
/*     */       
/* 159 */       int levelComparison = ((IVersionLevel)this._versionLevels.get(i)).compareTo(argOther._versionLevels.get(i));
/*     */       
/* 161 */       if (levelComparison != 0) {
/* 162 */         return levelComparison;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 169 */     return length1 - length2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObj) {
/* 176 */     if (argObj == this) {
/* 177 */       return true;
/*     */     }
/* 179 */     if (!(argObj instanceof UniversalVersion)) {
/* 180 */       return false;
/*     */     }
/* 182 */     UniversalVersion other = (UniversalVersion)argObj;
/* 183 */     return (new EqualsBuilder())
/* 184 */       .append(this._versionLevels, other._versionLevels)
/* 185 */       .isEquals();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 191 */     return (new HashCodeBuilder(17, 37))
/* 192 */       .append(this._versionLevels)
/* 193 */       .toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUnknown() {
/* 201 */     return this._versionLevels.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<IVersionLevel> iterator() {
/* 207 */     return this._versionLevels.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UniversalVersion removeVersion(UniversalVersion argOther) {
/* 217 */     UniversalVersion copy = new UniversalVersion(this);
/*     */     
/* 219 */     if (argOther != null) {
/* 220 */       copy._versionLevels.removeAll(argOther._versionLevels);
/*     */     }
/* 222 */     return copy;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 228 */     return this._versionLevels.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class VersionLevel
/*     */     implements IVersionLevel<VersionLevel>
/*     */   {
/*     */     private final List<String> _versionElements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String _versionString;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private VersionLevel(String argVersionString) {
/* 256 */       String[] versionParts = StringUtils.pack(argVersionString).split("[^0-9a-zA-Z]");
/*     */       
/* 258 */       this._versionElements = new ArrayList<>(Arrays.asList(versionParts));
/* 259 */       this._versionString = argVersionString;
/*     */     }
/*     */ 
/*     */     
/*     */     private VersionLevel(VersionLevel argOriginal) {
/* 264 */       this(argOriginal._versionString);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int compareTo(VersionLevel argOther) {
/* 270 */       if (isUnknown())
/*     */       {
/*     */ 
/*     */         
/* 274 */         return argOther.isUnknown() ? 0 : -1;
/*     */       }
/* 276 */       if (argOther.isUnknown())
/*     */       {
/*     */         
/* 279 */         return 1;
/*     */       }
/*     */ 
/*     */       
/* 283 */       int length1 = this._versionElements.size();
/* 284 */       int length2 = argOther._versionElements.size();
/*     */       
/* 286 */       for (int i = 0, n = Math.min(length1, length2); i < n; i++) {
/*     */ 
/*     */ 
/*     */         
/* 290 */         String elem1 = this._versionElements.get(i);
/* 291 */         String elem2 = argOther._versionElements.get(i);
/*     */ 
/*     */ 
/*     */         
/* 295 */         if (elem1.length() > elem2.length()) {
/* 296 */           elem2 = StringUtils.leftPadZeros(elem2, elem1.length());
/*     */         }
/* 298 */         else if (elem2.length() > elem1.length()) {
/* 299 */           elem1 = StringUtils.leftPadZeros(elem1, elem2.length());
/*     */         } 
/*     */         
/* 302 */         int lexicalComparison = elem1.compareToIgnoreCase(elem2);
/*     */         
/* 304 */         if (lexicalComparison != 0) {
/* 305 */           return lexicalComparison;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 312 */       return length1 - length2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object argObj) {
/* 319 */       if (argObj == this) {
/* 320 */         return true;
/*     */       }
/* 322 */       if (!(argObj instanceof VersionLevel)) {
/* 323 */         return false;
/*     */       }
/* 325 */       VersionLevel other = (VersionLevel)argObj;
/* 326 */       return (new EqualsBuilder())
/* 327 */         .append(this._versionElements, other._versionElements)
/* 328 */         .isEquals();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 334 */       return (new HashCodeBuilder(17, 37))
/* 335 */         .append(this._versionElements)
/* 336 */         .toHashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isUnknown() {
/* 344 */       return this._versionElements.isEmpty();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Iterator<String> iterator() {
/* 350 */       return this._versionElements.iterator();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 356 */       return this._versionString;
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface IVersionLevel<T extends IVersionLevel> extends Comparable<T>, Iterable<String> {}
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\version\UniversalVersion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */