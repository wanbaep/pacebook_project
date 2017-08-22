create table board(
	b_id VARCHAR(50) NOT NULL,
	b_text VARCHAR(200) NOT NULL,
	b_img VARCHAR(100),
	b_time TIMESTAMP NOT NULL,
	b_goodno INT NOT NULL DEFAULT 0,
	b_replyno INT NOT NULL DEFAULT 0,
	b_no INT NOT NULL AUTO_INCREMENT,
	primary key (b_no),
	foreign key (b_id) references userinfo (uid)
	ON DELETE CASCADE
)
collate='utf8_general_ci'
;