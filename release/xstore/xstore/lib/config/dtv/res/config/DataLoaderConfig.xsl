<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:variable name="customer.id" select="'XST'" />

<xsl:template match="/">
<html>
  <head>
    <title><xsl:value-of select="$customer.id"/>Xstore DataLoaderConfig.xml</title>
    <link rel="stylesheet" type="text/css" href="xststyle.css" />
    </head>
  <body>

    <!-- Display each record type -->
    <xsl:for-each select="DataLoaderConfig/RecordType">
    <div class="recordtype">
    <h2><xsl:value-of select="@name"/></h2><p><xsl:value-of select="@description"/></p>
    </div>
    <table width="100%">
    <thead><tr>
      <th width="70">File<br/>Position</th>
      <th width="200">Field<br/>Name</th>
      <th width="80">Data<br/>Type</th>
      <th width="50">Size</th>
      <th width="50">Req?</th>
      <th>Description</th>
    </tr></thead>
    <tbody>
    <!-- Display each DAO loaded by the record type -->
    <xsl:for-each select="Dao">
    <xsl:if test="not(@suppress)">
    <tr>
      <td colspan="6" class="daoname">
        <tr>
          <td>01</td>
          <td>Action Code</td>
          <td>String</td>
          <td class="ctr">6</td>
          <td class="required">&#8226;</td>
          <td>INSERT, INSERT_ONLY, UPDATE or DELETE</td>
        </tr>          
        <tr>
          <td>02</td>
          <td>Record Identifier</td>
          <td>String</td>
          <td class="ctr">30</td>
          <td class="required">&#8226;</td>
          <td><xsl:value-of select="../@name"/></td>
        </tr>         
        <!-- <h3><xsl:value-of select="@name"/></h3> -->
        <!-- Display each custom field on the dao -->
        <xsl:for-each select="Field">
          <xsl:sort select="@filePosition"/>
          <xsl:if test=".!=''">
            <tr>
              <td><xsl:value-of select="@filePosition"/><xsl:value-of select="@literal"/><xsl:value-of select="@sysProp"/></td>
              <td><xsl:value-of select="@name"/></td>
              <td><xsl:value-of select="@dataType"/></td>
              <td class="ctr"><xsl:value-of select="@size"/></td>
              <td class="required"><xsl:if test="@required"> &#8226; </xsl:if></td>
              <td><xsl:value-of select="."/></td>
            </tr>
          </xsl:if><!-- If there is a description, display a row for the field -->
        </xsl:for-each><!-- Field -->
     </td>
    </tr>
    </xsl:if><!-- Suppress Dao -->
    </xsl:for-each><!-- Dao -->
    </tbody>
    </table>    
    </xsl:for-each><!-- Record Type -->

  </body>
</html>
</xsl:template>

</xsl:stylesheet>
