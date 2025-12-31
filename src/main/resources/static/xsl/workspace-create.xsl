<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" encoding="UTF-8"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Create Workspace</title>
                <link rel="stylesheet" href="/css/style.css"/>
                <script src="/js/workspaces.js"></script>
            </head>

            <body>
                <div class="page">

                    <div class="card">
                        <h1>Create Workspace</h1>

                        <div id="workspace-create">

                            <p>
                                <label><strong>Name</strong></label><br/>
                                <input type="text" id="name"/>
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
                                <input type="number" id="capacity" value="1"/>
                            </p>

                            <p>
                                <label>
                                    <input type="checkbox" id="available" checked="checked"/>
                                    Available
                                </label>
                            </p>

                            <div class="actions">
                                <button class="btn primary"
                                        onclick="createWorkspace();">
                                    Create
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
