<?xml version="1.1"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema">

  <xsl:output method="html" name="format"/>
  <xsl:param name="tell" as="xs:string*"/>

  <xsl:template match="/" name="f">
    <xsl:apply-templates select="greeting">
      <xsl:with-param name="tell" select="$tell"/>
    </xsl:apply-templates>
  </xsl:template>

  <xsl:template match="greeting">
    <xsl:param name="tell"/>
    <xsl:result-document href="src/test/resources/out/out.xml" format="format">
      <html>
        <body>
          <h1>
            <xsl:for-each select="$tell">
              <xsl:message terminate="no" select="."/>
            </xsl:for-each>
          </h1>
        </body>
      </html>
    </xsl:result-document>
  </xsl:template>
</xsl:stylesheet>
