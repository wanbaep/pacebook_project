select * from fr_request where EXISTS (select * from userinfo where uid='wanb')