SELECT
    concat('Project ',project.id) AS name,
    sum(worker.salary *DATEDIFF(MONTH, project.start_date, project.finish_date)) as price from project_worker
LEFT JOIN worker ON worker.id = project_worker.worker_id
LEFT JOIN project ON project.id = project_worker.project_id
GROUP BY name
ORDER BY price DESC;