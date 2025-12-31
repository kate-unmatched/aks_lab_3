<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">

        <html>
            <head>
                <title>Rooms</title>
                <link rel="stylesheet" href="/css/style.css"/>
                <script src="/js/rooms.js"></script>
            </head>

            <body>

                <div class="page">

                    <!-- HEADER -->
                    <div class="header">
                        <h1>Rooms</h1>

                        <div class="actions">
                            <button class="btn primary"
                                    onclick="location.href='rooms/new'">
                                + Add Room
                            </button>

                            <button class="btn outline"
                                    onclick="location.href='/api/v2/workspaces'">
                                ← Back
                            </button>
                        </div>
                    </div>

                    <!-- CARDS -->
                    <div class="cards">
                        <xsl:for-each select="rooms/room">
                            <div class="card">
                                <h2>
                                    <xsl:value-of select="name"/>
                                </h2>

                                <p>
                                    Seats:
                                    <xsl:value-of select="seats"/>
                                </p>

                                <p>
                                    Available:
                                    <xsl:choose>
                                        <xsl:when test="available='true'">yes</xsl:when>
                                        <xsl:otherwise>no</xsl:otherwise>
                                    </xsl:choose>
                                </p>

                                <div class="actions">
                                    <button class="btn outline"
                                            type="button"
                                            onclick="location.href='/api/v2/workspaces/{workspaceId}/rooms/{id}/edit'">
                                        Edit
                                    </button>

                                    <button class="btn outline"
                                            type="button"
                                            onclick="location.href='/api/v2/workspaces/{workspaceId}/rooms/{id}/bookings'">
                                        Bookings
                                    </button>

                                    <button class="btn danger"
                                            type="button"
                                            onclick="deleteRoom('{workspaceId}', '{id}')">
                                        Delete
                                    </button>
                                </div>
                            </div>
                        </xsl:for-each>
                    </div>

                </div>

            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>
