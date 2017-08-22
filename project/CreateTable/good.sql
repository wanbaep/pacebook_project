create view good(id, name, total_good) AS
 select U.uid, U.uname, sum(B.b_goodno) from userinfo as U, board as B where U.uid=B.b_id group by U.uid;