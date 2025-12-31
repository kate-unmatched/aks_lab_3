<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" encoding="UTF-8"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Edit Workspace</title>
                <link rel="stylesheet" href="/css/style.css"/>
                <script src="/js/workspaces.js"></script>
            </head>

            <body>
                <div class="page">

                    <div class="card">
                        <h1>Edit Workspace</h1>

                        <!-- сохраняем id в data-атрибуте -->
                        <div id="workspace-edit"
                             data-id="{workspace/id}">

                            <p>
                                <label><strong>Name</strong></label><br/>
                                <input type="text" id="name"
                                       value="{workspace/name}"/>
                            </p>

                            <p>
                                <label><strong>Type</strong></label><br/>
                                <select id="type">
                                    <option value="OPEN_SPACE">OPEN_SPACE</option>
                                    <option value="MEETING_ROOM">MEETING_ROOM</option>
                                    <option value="PRIVATE_OFFICE">PRIVATE_OFFICE</option>
                                    <option value="EVENT_SPACE">EVENT_SPACE</option>
                                </select>
                            </p>

                            <p>
                                <label><strong>Capacity</strong></label><br/>
                                <input type="number" id="capacity"
                                       value="{workspace/capacity}"/>
                            </p>

                            <p>
                                <label>
                                    <input type="checkbox" id="available">
                                        <xsl:if test="workspace/available = 'true'">
                                            <xsl:attribute name="checked">checked</xsl:attribute>
                                        </xsl:if>
                                    </input>
                                    Available
                                </label>
                            </p>

                            <div class="actions">
                                <button class="btn primary"
                                        onclick="updateWorkspace();">
                                    Save
                                </button>

                                <a href="/api/v2/workspaces" class="btn outline">
                                    Cancel
                                </a>
                            </div>

                        </div>
                    </div>

                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
