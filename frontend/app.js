let tasksListDiv = document.getElementById('tasks');
const BASE_URL = 'http://localhost:8080';

function fetchAllTasks() {
    fetch(`${BASE_URL}/tasks`)
        .then(response => response.json())
        .then(data => {
            let tasksHtml = '<h2>Tasks</h2>';
            data.forEach(task => {
                tasksHtml += `
                    <div>
                        <strong>${task.name}</strong> - ${task.notes} - ${task.tag}
                        <button onclick="updateTask(${task.id})">Update</button>
                        <button onclick="deleteTask(${task.id})">Delete</button>
                    </div>
                `;
            });
            tasksListDiv.innerHTML = tasksHtml;
        });
}

function displayCreateForm() {
    const createForm = `
        <h2>Create Task</h2>
        Name: <input type="text" id="task-name"><br>
        Notes: <input type="text" id="task-notes"><br>
        Tag: <input type="text" id="task-tag"><br>
        <button onclick="createTask()">Submit</button>
        <button onclick="fetchAllTasks()">Cancel</button>
    `;

    tasksListDiv.innerHTML = createForm;
}

function createTask() {
    const name = document.getElementById('task-name').value;
    const notes = document.getElementById('task-notes').value;
    const tag = document.getElementById('task-tag').value;

    fetch(`${BASE_URL}/tasks`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, notes, tag }),
    })
    .then(() => fetchAllTasks());
}

function updateTask(taskId) {
    fetch(`${BASE_URL}/tasks/${taskId}`)
        .then(response => response.json())
        .then(task => {
            const updateForm = `
                <h2>Update Task</h2>
                Name: <input type="text" id="update-task-name-${taskId}" value="${task.name}"><br>
                Notes: <input type="text" id="update-task-notes-${taskId}" value="${task.notes}"><br>
                Tag: <input type="text" id="update-task-tag-${taskId}" value="${task.tag}"><br>
                <button onclick="submitUpdate(${taskId})">Submit</button>
                <button onclick="fetchAllTasks()">Cancel</button>
            `;

            tasksListDiv.innerHTML = updateForm;
        });
}

function submitUpdate(taskId) {
    const name = document.getElementById(`update-task-name-${taskId}`).value;
    const notes = document.getElementById(`update-task-notes-${taskId}`).value;
    const tag = document.getElementById(`update-task-tag-${taskId}`).value;

    fetch(`${BASE_URL}/tasks/${taskId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, notes, tag }),
    })
    .then(() => fetchAllTasks());
}

function deleteTask(taskId) {
    fetch(`${BASE_URL}/tasks/${taskId}`, {
        method: 'DELETE'
    })
    .then(() => fetchAllTasks());
}

fetchAllTasks(); // Load tasks on initial page load
