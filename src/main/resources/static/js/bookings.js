function collectBookingDto() {
    return {
        bookedBy: document.getElementById("bookedBy").value,
        startTime: document.getElementById("startTime").value,
        endTime: document.getElementById("endTime").value
    };
}

function createBooking(workspaceId, roomId) {
    fetch(`/api/v2/workspaces/${workspaceId}/rooms/${roomId}/bookings`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(collectBookingDto())
    }).then(() => {
        window.location.href =
            `/api/v2/workspaces/${workspaceId}/rooms/${roomId}/bookings`;
    });
}

function deleteBooking(workspaceId, roomId, bookingId) {
    fetch(`/api/v2/workspaces/${workspaceId}/rooms/${roomId}/bookings/${bookingId}`, {
        method: "DELETE"
    }).then(() => {
        window.location.reload();
    });
}
