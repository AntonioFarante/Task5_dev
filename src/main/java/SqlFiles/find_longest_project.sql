WITH temp_table (project, month_count) AS (
SELECT id, DATEDIFF (month, start_date, finish_date)
	 AS month_count
	 FROM project
	 ORDER BY month_count DESC
)
SELECT * FROM temp_table
WHERE month_count =
				(SELECT max(month_count) FROM temp_table);