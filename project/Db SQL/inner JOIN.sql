select B.b_id, U.uname from (userinfo as U JOIN board as B ON B.b_id=U.uid);