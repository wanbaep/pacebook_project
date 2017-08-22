(select * from board where b_id='son') UNION 
(select * from board where b_id=ANY(select fr_id from friend where my_id='son'))