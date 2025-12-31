<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" encoding="UTF-8"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Workspaces</title>

                <link rel="stylesheet" href="/css/style.css"/>
                <script src="/js/workspaces.js"></script>
            </head>

            <body>
                <div class="page">

                    <div class="header">
                        <h1>Workspaces</h1>

                        <a href="/api/v2/workspaces/new" class="btn primary">
                            + Add Workspace
                        </a>
                    </div>

                    <div class="cards">
                        <xsl:for-each select="workspaces/workspace">
                            <div class="card">

                                <h2>
                                    <xsl:value-of select="name"/>
                                </h2>

                                <p>
                                    <strong>Type:</strong>
                                    <xsl:text> </xsl:text>
                                    <xsl:value-of select="type"/>
                                </p>

                                <p>
                                    <strong>Capacity:</strong>
                                    <xsl:text> </xsl:text>
                                    <xsl:value-of select="capacity"/>
                                </p>

                                <div class="actions">

                                    <a class="btn outline"
                                       href="/api/v2/workspaces/{id}/rooms">
                                        Rooms
                                    </a>

                                    <a class="btn outline"
                                       href="/api/v2/workspaces/{id}/edit">
                                        Edit
                                    </a>

                                    <a class="btn danger"
                                       href="#"
                                       onclick="deleteWorkspace({id}); return false;">
                                        Delete
                                    </a>

                                </div>

                            </div>
                        </xsl:for-each>
                    </div>

                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
