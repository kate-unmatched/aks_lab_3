function collectRoomDto() {
    return {
        roomName: document.getElementById("roomName").value,
        seats: parseInt(document.getElementById("seats").value),
        available: document.getElementById("available").checked
    };
}

function createRoom(workspaceId) {
    fetch(`/api/v2/workspaces/${workspaceId}/rooms`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(collectRoomDto())
    }).then(() => {
        window.location.href =
            `/api/v2/workspaces/${workspaceId}/rooms`;
    });
}

function updateRoom(workspaceId, roomId) {
    fetch(`/api/v2/workspaces/${workspaceId}/rooms/${roomId}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(collectRoomDto())
    }).then(() => {
        window.location.href =
            `/api/v2/workspaces/${workspaceId}/rooms`;
    });
}

function deleteRoom(workspaceId, roomId) {
    fetch(`/api/v2/workspaces/${workspaceId}/rooms/${roomId}`, {
        method: "DELETE"
    }).then(() => {
        window.location.reload();
    });
}
