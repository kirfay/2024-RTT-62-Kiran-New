--
select firstname, lastname, min(progress), max(progress),
	CASE
		WHEN min(progress) < 40 THEN 'F'
        WHEN min(progress) < 50 THEN 'D'
        WHEN min(progress) < 60 THEN 'C'
        WHEN min(progress) < 70 THEN 'B'
        ELSE 'A'
	END as min_grade,
	CASE
		WHEN max(progress) < 40 THEN 'F'
        WHEN max(progress) < 50 THEN 'D'
        WHEN max(progress) < 60 THEN 'C'
        WHEN max(progress) < 70 THEN 'B'
        ELSE 'A'
	END as max_grade
    from student s, studentcourse sc
    where s.id = sc.studentid
    group by s.id;
        