WITH youngest_worker AS (
SELECT 'YOUNGEST' AS type, name, birthday FROM worker WHERE birthday = (SELECT max(birthday) FROM worker)
), eldest_worker AS (
SELECT 'ELDEST' AS type, name, birthday FROM worker WHERE birthday = (SELECT min(birthday) FROM worker)
)
SELECT * FROM youngest_worker
UNION
SELECT * FROM eldest_worker;