create table reply(
	cno INT NOT NULL,
	rtext VARCHAR(100) NOT NULL,
	rid VARCHAR(50) NOT NULL,
	rtime TIMESTAMP NOT NULL,
	rno INT NOT NULL AUTO_INCREMENT,
	primary key (rno),
	foreign key (cno) references comment(cno)
	ON DELETE CASCADE,
	foreign key (rid) references userinfo(uid)
	ON DELETE CASCADE
)
collate='utf8_general_ci'
;