<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">

        <html>
            <head>
                <title>Bookings</title>
                <link rel="stylesheet" href="/css/style.css"/>
                <script src="/js/bookings.js"></script>
            </head>

            <body>

                <div class="page">

                    <div class="header">
                        <h1>
                            Bookings for room:
                            <xsl:value-of select="bookings/booking[1]/roomName"/>
                        </h1>

                        <button class="btn primary"
                                type="button"
                                onclick="location.href='/api/v2/workspaces/{bookings/workspaceId}/rooms/{bookings/roomId}/bookings/new'">
                            Create Booking
                        </button>
                    </div>

                    <table class="card" style="width:100%">
                        <tr>
                            <th>#</th>
                            <th>Booked By</th>
                            <th>Start</th>
                            <th>End</th>
                            <th>Actions</th>
                        </tr>

                        <xsl:choose>
                            <xsl:when test="count(bookings/booking) = 0">
                                <tr>
                                    <td colspan="5" style="text-align:center">No bookings yet.</td>
                                </tr>
                            </xsl:when>

                            <xsl:otherwise>
                                <xsl:for-each select="bookings/booking">
                                    <tr>
                                        <td><xsl:value-of select="position()"/></td>
                                        <td><xsl:value-of select="bookedBy"/></td>
                                        <td><xsl:value-of select="startTime"/></td>
                                        <td><xsl:value-of select="endTime"/></td>
                                        <td>
                                            <button class="btn danger"
                                                    type="button"
                                                    onclick="deleteBooking('{workspaceId}','{roomId}','{id}')">
                                                Delete
                                            </button>
                                        </td>
                                    </tr>
                                </xsl:for-each>
                            </xsl:otherwise>
                        </xsl:choose>

                    </table>

                    <div class="actions" style="margin-top:20px">
                        <button class="btn outline"
                                type="button"
                                onclick="location.href='/api/v2/workspaces/{bookings/workspaceId}/rooms'">
                            ← Back to Rooms
                        </button>
                    </div>

                </div>

            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>
