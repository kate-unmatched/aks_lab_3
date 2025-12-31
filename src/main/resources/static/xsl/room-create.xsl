<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">

        <html>
            <head>
                <title>Create Room</title>
                <link rel="stylesheet" href="/css/style.css"/>
                <script src="/js/rooms.js"></script>
            </head>

            <body>

                <div class="page">

                    <div class="header">
                        <h1>Create room</h1>

                        <div class="actions">
                            <button class="btn outline"
                                    type="button"
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
                                   placeholder="Room name"
                                   style="width: 100%; padding: 8px;"/>
                        </p>

                        <p>
                            <label>Seats</label><br/>
                            <input id="seats"
                                   type="number"
                                   placeholder="Number of seats"
                                   style="width: 100%; padding: 8px;"/>
                        </p>

                        <p>
                            <label>
                                <input id="available"
                                       type="checkbox"
                                       checked="checked"/>
                                Available
                            </label>
                        </p>

                        <div class="actions">
                            <button class="btn primary"
                                    type="button"
                                    onclick="createRoom('{room/workspaceId}')">
                                Create
                            </button>
                        </div>

                    </div>

                </div>

            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>
