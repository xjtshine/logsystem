create table system_log
(log_id varchar(50) primary key, 
 log_type tinyint not null,
 client_id varchar(100),
 agent_id varchar(100), 
 user_name varchar(100),
 log_date datetime, 
 currency varchar(10), 
 total decimal(10,2));
