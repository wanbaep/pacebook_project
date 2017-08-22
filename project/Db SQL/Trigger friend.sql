CREATE trigger renum
AFTER INSERT ON comment
FOR EACH ROW
UPDATE board set b_replyno=b_replyno+1 where b_no=New.b_no;