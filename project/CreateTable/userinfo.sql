create table userinfo(
	uid VARCHAR(50) NOT NULL,
	uname VARCHAR(20) NOT NULL,
	upasswd VARCHAR(20) NOT NULL,
	ubirth DATE NOT NULL,
	ucell CHAR(11) NOT NULL,
	umail VARCHAR(50) NOT NULL,
	uimg VARCHAR(50) NULL,
	primary key (uid)
)
collate='utf8_general_ci'
;