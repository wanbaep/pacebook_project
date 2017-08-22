create table friend(
	my_id VARCHAR(50) NOT NULL,
	fr_id VARCHAR(50) NOT NULL,
	follow bit(1) NOT NULL DEFAULT 1,
	foreign key (my_id) references userinfo (uid)
	ON DELETE CASCADE,
	foreign key (fr_id) references userinfo (uid)
	ON DELETE CASCADE
)
collate='utf8_general_ci'
; 