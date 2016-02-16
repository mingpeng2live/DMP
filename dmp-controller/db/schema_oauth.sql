-- ----------------------------  
-- 创建管理员帐号表t_admin  
-- ----------------------------  
drop table if exists t_admin;
CREATE TABLE `t_admin` (  
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,  
  `passwd` varchar(12) NOT NULL DEFAULT '' COMMENT '用户密码',  
  `nickname` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名字',  
  `phoneno` varchar(32) NOT NULL DEFAULT '' COMMENT '电话号码',  
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;  

-- ----------------------------  
-- 添加3个管理帐号   
-- ----------------------------  
INSERT INTO `t_admin` VALUES ('1', 'admin', 'admin', '');  
INSERT INTO `t_admin` VALUES ('4', '123456', 'test', '');  
INSERT INTO `t_admin` VALUES ('5', '111111', '111111', '');  
  
-- ----------------------------  
-- 创建权限表t_role  
-- ----------------------------  
drop table if exists t_role;
CREATE TABLE `t_role` (  
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,  
  `role` varchar(40) NOT NULL DEFAULT '',  
  `descpt` varchar(40) NOT NULL DEFAULT '' COMMENT '角色描述',  
  `category` varchar(40) NOT NULL DEFAULT '' COMMENT '分类',  
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;  

-- ----------------------------  
-- 加入4个操作权限  
-- ----------------------------  
INSERT INTO `t_role` VALUES ('1', 'ROLE_ADMIN', '系统管理员', '系统管理员');  
INSERT INTO `t_role` VALUES ('2', 'ROLE_UPDATE_FILM', '修改', '影片管理');  
INSERT INTO `t_role` VALUES ('3', 'ROLE_DELETE_FILM', '删除', '影片管理');  
INSERT INTO `t_role` VALUES ('4', 'ROLE_ADD_FILM', '添加', '影片管理');  

-- ----------------------------  
-- 创建权限组表  
-- ----------------------------  
drop table if exists t_group;
CREATE TABLE `t_group` (  
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,  
  `groupname` varchar(50) NOT NULL DEFAULT '',  
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;  

-- ----------------------------  
-- 添加2个权限组  
-- ----------------------------  
INSERT INTO `t_group` VALUES ('1', 'Administrator');  
INSERT INTO `t_group` VALUES ('2', '影片维护');  

-- ----------------------------  
-- 创建权限组对应权限表t_group_role  
-- ----------------------------  
drop table if exists t_group_role;
CREATE TABLE `t_group_role` (  
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,  
  `groupid` bigint(20) unsigned NOT NULL,  
  `roleid` bigint(20) unsigned NOT NULL,  
  PRIMARY KEY (`id`),  
  UNIQUE KEY `groupid2` (`groupid`,`roleid`),  
  KEY `roleid` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;  

-- ----------------------------  
-- 加入权限组与权限的对应关系  
-- ----------------------------  
INSERT INTO `t_group_role` VALUES ('1', '1', '1');  
INSERT INTO `t_group_role` VALUES ('2', '2', '2');  
INSERT INTO `t_group_role` VALUES ('4', '2', '4');  

-- ----------------------------  
-- 创建管理员所属权限组表t_group_user  
-- ----------------------------  
drop table if exists t_group_user;
CREATE TABLE `t_group_user` (  
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,  
  `userid` bigint(20) unsigned NOT NULL,  
  `groupid` bigint(20) unsigned NOT NULL,  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;  

-- ----------------------------  
-- 将管理员加入权限组  
-- ----------------------------  
INSERT INTO `t_group_user` VALUES ('1', '1', '1');  
INSERT INTO `t_group_user` VALUES ('2', '4', '2');  

-- ----------------------------  
-- 创建管理员对应权限表t_user_role  
-- 设置该表可跳过权限组，为管理员直接分配权限  
-- ----------------------------  
drop table if exists t_user_role;
CREATE TABLE `t_user_role` (  
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,  
  `userid` bigint(20) unsigned NOT NULL,  
  `roleid` bigint(20) unsigned NOT NULL,  
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;