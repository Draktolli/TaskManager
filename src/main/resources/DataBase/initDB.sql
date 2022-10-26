CREATE TABLE IF NOT EXISTS dashboard
(
    id UUID PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);
CREATE TABLE IF NOT EXISTS tasks
(
    id UUID PRIMARY KEY ,
    dashboard_id UUID REFERENCES dashboard (id) NOT NULL ,
    content  VARCHAR(200) NOT NULL ,
    task_status VARCHAR(20)  NOT NULL
);
