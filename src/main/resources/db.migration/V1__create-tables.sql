CREATE TABLE beautyfast.tb_user (
	user_id  BIGINT AUTO_INCREMENT NOT NULL,
	name VARCHAR(100) NOT NULL,
	cpf VARCHAR(14) NOT NULL,
	user_salary DECIMAL(10,0) NOT NULL,
	user_position VARCHAR(100) NOT NULL,
	PRIMARY KEY (user_id)
)engine=InnoDB default charset=utf8;

CREATE TABLE beautyfast.tb_customer (
	customer_id  BIGINT AUTO_INCREMENT NOT NULL,
	name VARCHAR(100) NOT NULL,
	cpf VARCHAR(14) NOT NULL,
	address VARCHAR(100) NOT NULL,
	PRIMARY KEY (customer_id)
)engine=InnoDB default charset=utf8;

CREATE TABLE beautyfast.tb_schedules (
	schedule_id  BIGINT AUTO_INCREMENT NOT NULL,
	customer_id_fk BIGINT NOT NULL,
	user_id_fk BIGINT NOT NULL,
	schedule_date DATETIME NOT NULL,
	PRIMARY KEY (schedule_id)
)engine=InnoDB default charset=utf8;

ALTER TABLE beautyfast.tb_schedules ADD CONSTRAINT customer_id_fk
FOREIGN KEY(customer_id_fk) REFERENCES beautyfast.tb_customer(customer_id);

ALTER TABLE beautyfast.tb_schedules ADD CONSTRAINT user_id_fk
FOREIGN KEY(user_id_fk) REFERENCES beautyfast.tb_user(user_id);