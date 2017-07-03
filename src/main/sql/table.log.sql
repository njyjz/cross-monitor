/*==============================================================*/
/* Table: access_log                                             */
/*==============================================================*/
create table access_log_data
(
   id                   int(9)                         auto_increment not null,
   request_id              varchar(10)                       null,
   server_id              varchar(100)                       null,
   client_id              varchar(100)                       null,
   req_json              varchar(500)                        null,
   resp_json              varchar(1000)                           null,
   cost_time_mills        int(9)                              null,
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;