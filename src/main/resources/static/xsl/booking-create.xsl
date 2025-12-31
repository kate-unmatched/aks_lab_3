<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">

        <html>
            <head>
                <title>Create Booking</title>
                <link rel="stylesheet" href="/css/style.css"/>
                <script src="/js/bookings.js"></script>
            </head>

            <body>

                <div class="page">

                    <div class="header">
                        <h1>
                            Create booking for room:
                            <xsl:value-of select="booking/roomName"/>
                        </h1>

                        <div class="actions">
                            <button class="btn outline"
                                    type="button"
                                    onclick="location.href='/api/v2/workspaces/{booking/workspaceId}/rooms/{booking/roomId}/bookings'">
                                ← Back to Bookings
                            </button>
                        </div>
                    </div>

                    <div class="card">

                        <p>
                            <label>Booked by</label><br/>
                            <input id="bookedBy"
                                   type="text"
                                   placeholder="Name"
                                   style="width:100%; padding:8px"/>
                        </p>

                        <p>
                            <label>Start time</label><br/>
                            <input id="startTime"
                                   type="datetime-local"
                                   style="width:100%; padding:8px"/>
                        </p>

                        <p>
                            <label>End time</label><br/>
                            <input id="endTime"
                                   type="datetime-local"
                                   style="width:100%; padding:8px"/>
                        </p>

                        <div class="actions">
                            <button class="btn primary"
                                    type="button"
                                    onclick="createBooking('{booking/workspaceId}','{booking/roomId}')">
                                Create
                            </button>
                        </div>

                    </div>

                </div>

            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>
