CREATE TABLE tasks (
    task_id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    status BOOLEAN DEFAULT FALSE,
    notes TEXT,
    date_added DATE DEFAULT CURRENT_DATE,
    tag TEXT
);
