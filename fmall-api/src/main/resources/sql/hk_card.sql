create table hk_card
(
    id       bigint auto_increment
        primary key,
    name     varchar(32)  default '' not null comment '昵称',
    card_num varchar(64)  default '' not null comment '身份证号',
    type     varchar(128) default '' not null comment '类型'
)
    comment '香港身份证';

