create table comment(
	b_no INT NOT NULL,
	ctext VARCHAR(100) NOT NULL,
	cid VARCHAR(50) NOT NULL,
	ctime TIMESTAMP NOT NULL,
	cno INT NOT NULL AUTO_INCREMENT,
	primary key (cno),
	foreign key (b_no) references board(b_no)
	ON DELETE CASCADE,
	foreign key (cid) references userinfo(uid)
	ON DELETE CASCADE
)
collate='utf8_general_ci'
;