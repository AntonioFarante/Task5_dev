WITH temp_table (client_id, project_count) AS (
	SELECT client_id, count(id)
	FROM project
	GROUP BY client_id
	ORDER BY count(id) DESC
	LIMIT 1
)
	SELECT name, project_count
	FROM client
	JOIN temp_table
	ON id = temp_table.client_id;