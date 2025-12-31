<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">

        <html>
            <head>
                <title>Edit Room</title>
                <link rel="stylesheet" href="/css/style.css"/>
                <script src="/js/rooms.js"></script>
            </head>

            <body>

                <div class="page">

                    <div class="header">
                        <h1>Edit room</h1>

                        <div class="actions">
                            <button class="btn outline"
                                    onclick="location.href='/api/v2/workspaces/{room/workspaceId}/rooms'">
                                ← Back
                            </button>
                        </div>
                    </div>

                    <div class="card">

                        <p>
                            <label>Name</label><br/>
                            <input id="roomName"
                                   type="text"
                                   value="{room/name}"
                                   style="width: 100%; padding: 8px;"/>
                        </p>

                        <p>
                            <label>Seats</label><br/>
                            <input id="seats"
                                   type="number"
                                   value="{room/seats}"
                                   style="width: 100%; padding: 8px;"/>
                        </p>

                        <p>
                            <label>
                                <input id="available"
                                       type="checkbox">
                                    <xsl:if test="room/available='true'">
                                        <xsl:attribute name="checked">checked</xsl:attribute>
                                    </xsl:if>
                                </input>
                                Available
                            </label>
                        </p>

                        <div class="actions">
                            <button type="button"
                                    class="btn primary"
                                    onclick="updateRoom('{room/workspaceId}', '{room/id}')">
                                Save
                            </button>
                        </div>

                    </div>

                </div>

            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>
