create table fr_request(
	send_id VARCHAR(50) NOT NULL,
	receive_id VARCHAR(50) NOT NULL,
	comfr_num INT NOT NULL DEFAULT 0,
	comfr_name VARCHAR(20),
	foreign key (send_id) references userinfo(uid)
	ON DELETE CASCADE,
	foreign key (receive_id) references userinfo(uid)
	ON DELETE CASCADE
)
collate='utf8_general_ci'
;