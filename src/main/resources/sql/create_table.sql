CREATE TABLE `autism_user`
(
  `uuid`                 varchar(32)  NOT NULL COMMENT '用户唯一标识',
  `name`                 varchar(100) NOT NULL COMMENT '用户名',
  `password`             text         NOT NULL COMMENT '用户密码',
  `type`                 varchar(2)   NOT NULL COMMENT '1.普通 2.ASD 3.儿童 4.家长',
  `phone`                varchar(20)  NOT NULL COMMENT '电话',
  `email`                varchar(100) NOT NULL COMMENT '邮箱',
  `sex`                  varchar(2)   NOT NULL DEFAULT '0' COMMENT '0.未知 1.男 2.女',
  `province`             varchar(100) NOT NULL DEFAULT '' COMMENT '地区',
  `open_id`              varchar(255) NOT NULL DEFAULT '' COMMENT '微信用户open_id',
  `real_name`            varchar(100) NOT NULL DEFAULT '0' COMMENT '真实姓名',
  `nation`               varchar(100) NOT NULL DEFAULT '0' COMMENT '民族',
  `address`              varchar(100) NOT NULL DEFAULT '0' COMMENT '地址',
  `qualification_number` varchar(100) NOT NULL DEFAULT '0' COMMENT '民族',
  `work_time`            int(11)      NOT NULL DEFAULT '0' COMMENT '从业时间',
  `dept_id`              varchar(32)  NOT NULL COMMENT '所属机构id',
  `create_time`          int(11)      NOT NULL DEFAULT '0' COMMENT '用户注册时间',
  `update_time`          int(11)      NOT NULL DEFAULT '0' COMMENT '更新时间',
  `flag`                 int(2)       NOT NULL DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `phone` (`phone`),
  KEY `index_open_id` (`open_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户表';

CREATE TABLE `autism_assess`
(
  `uuid`               varchar(32) NOT NULL COMMENT '唯一标识',
  `intervention_id`    varchar(32) NOT NULL COMMENT '干预对象id',
  `interventionist_id` varchar(32) NOT NULL COMMENT '干预师id',
  `state`              varchar(2)  NOT NULL DEFAULT '1' COMMENT '评估状态 1.未开始 2.进行中 3.已结束',
  `start_time`         int(11)     NOT NULL DEFAULT '0' COMMENT '开始时间',
  `end_time`           int(11)     NOT NULL DEFAULT '0' COMMENT '完成时间',
  `blog`               text COMMENT '干预日志',
  `create_time`        int(11)     NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time`        int(11)     NOT NULL DEFAULT '0' COMMENT '更新时间',
  `flag`               varchar(2)  NOT NULL DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`uuid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='评估信息表';

CREATE TABLE `autism_dept`
(
  `uuid`              varchar(32)   NOT NULL COMMENT '唯一标识',
  `name`              varchar(1000) NOT NULL COMMENT '机构名称',
  `localtion`         varchar(1000) NOT NULL COMMENT '所在地',
  `registration_time` int(11)       NOT NULL DEFAULT '0' COMMENT '注册时间',
  `end_time`          int(11)       NOT NULL DEFAULT '0' COMMENT '完成时间',
  `blog`              text COMMENT '干预日志',
  `create_time`       int(11)       NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time`       int(11)       NOT NULL DEFAULT '0' COMMENT '更新时间',
  `flag`              varchar(2)    NOT NULL DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`uuid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='机构表';

CREATE TABLE `autism_user_relation`
(
  `uuid`             varchar(32) NOT NULL COMMENT '唯一标识',
  `user_id`          varchar(32) NOT NULL COMMENT '用户ID',
  `relation_user_id` varchar(32) NOT NULL COMMENT '关联用户id',
  `create_time`      int(11)     NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time`      int(11)     NOT NULL DEFAULT '0' COMMENT '用户更新时间',
  `flag`             varchar(2)  NOT NULL DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`uuid`),
  KEY `index_user_id` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户关联表';


CREATE TABLE `autism_game`
(
  `uuid`        varchar(32)   NOT NULL COMMENT '唯一标识',
  `name`        varchar(200)  NOT NULL COMMENT '游戏名称',
  `dev_id`      varchar(32)   NOT NULL COMMENT '开发者id',
  `summary`     text          NULL COMMENT '游戏简介',
  `url`         varchar(1000) NULL COMMENT '链接地址',
  `img`         varchar(1000) NULL COMMENT '图片地址',
  `create_time` int(11)       NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11)       NOT NULL DEFAULT '0' COMMENT '更新时间',
  `flag`        varchar(2)    NOT NULL DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`uuid`),
  KEY `index_dev_id` (`dev_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='游戏表';

CREATE TABLE `autism_communitys`
(
  `communitys_id`     varchar(32)    NOT NULL COMMENT '唯一标识',
  `communitys_pic`    longtext       NOT NULL COMMENT '图片',
  `communitys_see`    varchar(32)    NOT NULL COMMENT '查看量',
  `communitys_intro`  varchar(10000) NULL COMMENT '介绍',
  `communitys_like`   varchar(32)    NULL COMMENT '喜欢数量',
  `communitys_author` varchar(100)   NULL COMMENT '作者',
  `uuid`              varchar(32)    NULL COMMENT '用户ID',
  PRIMARY KEY (`uuid`),
  KEY `index_uuid` (`uuid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='社区表';

CREATE TABLE `autism_communitys_comment`
(
  `communitys_comment_id`   varchar(32)    NOT NULL COMMENT '唯一标识',
  `communitys_id`           longtext       NOT NULL COMMENT '动态ID',
  `comment_user_id`         varchar(32)    NOT NULL COMMENT '评论人ID',
  `communitys_comment`      varchar(10000) NULL COMMENT '评论',
  `communitys_comment_time` varchar(32)    NULL COMMENT '评论时间',
  `communitys_comment_name` varchar(100)   NULL COMMENT '评论作者',
  PRIMARY KEY (`communitys_comment_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='社区评论表';

CREATE TABLE `autism_new_detail`
(
  `news_id`    varchar(32)    NOT NULL COMMENT '唯一标识',
  `new_detail` varchar(10000) NOT NULL COMMENT '新闻详情',
  PRIMARY KEY (`news_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='新闻详情';

CREATE TABLE `autism_user_gameinfo`
(
  `uuid`        varchar(32) NOT NULL COMMENT '唯一标识',
  `game_id`     varchar(32) NOT NULL COMMENT '游戏id',
  `user_id`     varchar(32) NOT NULL COMMENT '患者id',
  `game_log`    text COMMENT '游戏日志文件',
  `create_time` int(11)     NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11)     NOT NULL DEFAULT '0' COMMENT '更新时间',
  `flag`        varchar(2)  NOT NULL DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`uuid`),
  KEY `index_game_id` (`game_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='游戏-玩家数据表';



CREATE TABLE `wx_user_token`
(
  `uuid`          varchar(32)  NOT NULL COMMENT '唯一标识',
  `access_token`  varchar(255) NOT NULL DEFAULT '' COMMENT '登录token',
  `expire_in`     int(11)      NOT NULL DEFAULT '0' COMMENT '登录会话过期时间',
  `refresh_token` varchar(255) NOT NULL DEFAULT '' COMMENT '用户刷新access_token',
  `open_id`       varchar(255) NOT NULL DEFAULT '' COMMENT '微信用户open_id',
  `scope`         varchar(255) NOT NULL DEFAULT '' COMMENT '用户授权作用域',
  `create_time`   int(11)      NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time`   int(11)      NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `open_id` (`open_id`),
  KEY `index_open_id` (`open_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='微信用户token表';
