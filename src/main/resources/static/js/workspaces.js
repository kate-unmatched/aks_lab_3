
function createWorkspace() {
    const dto = collectWorkspaceDto();

    fetch("/api/v2/workspaces", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(dto)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Create failed");
            }
            window.location.href = "/api/v2/workspaces";
        })
        .catch(err => {
            console.error(err);
            alert("Failed to create workspace");
        });
}

function updateWorkspace(id) {
    const dto = collectWorkspaceDto();

    fetch(`/api/v2/workspaces/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(dto)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Update failed");
            }
            window.location.href = "/api/v2/workspaces";
        })
        .catch(err => {
            console.error(err);
            alert("Failed to update workspace");
        });
}

function deleteWorkspace(id) {
    if (!confirm("Are you sure you want to delete this workspace?")) {
        return;
    }

    fetch(`/api/v2/workspaces/${id}`, {
        method: "DELETE"
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Delete failed");
            }
            window.location.reload();
        })
        .catch(err => {
            console.error(err);
            alert("Failed to delete workspace");
        });
}

function collectWorkspaceDto() {
    return {
        name: document.getElementById("name")?.value ?? "",
        type: document.getElementById("type")?.value ?? "OPEN_SPACE",
        capacity: parseInt(document.getElementById("capacity")?.value ?? "1"),
        available: document.getElementById("available")?.checked ?? false
    };
}
