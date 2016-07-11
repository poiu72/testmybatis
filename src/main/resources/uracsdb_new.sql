-- create database uracsdb;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_app_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_menu`;
CREATE TABLE `t_app_menu` (
  `id` int(11) NOT NULL auto_increment,
  `menuName` varchar(32) collate utf8_unicode_ci NOT NULL COMMENT '菜单名称',
  `parentId` int(11) NOT NULL default '0' COMMENT '父菜单ID',
  `menuCode` varchar(32) collate utf8_unicode_ci default NULL COMMENT '编号',
  `menuUrl` varchar(256) collate utf8_unicode_ci default NULL COMMENT '菜单URL',
  `urlTarget` varchar(32) collate utf8_unicode_ci default NULL COMMENT '页面打开位置',
  `navMenu` int(11) NOT NULL default '0' COMMENT '0:不显示在导航菜单中,1:显示在导航菜单中',
  `sort` int(11) NOT NULL default '0' COMMENT '排序',
  `remark` varchar(64) collate utf8_unicode_ci default NULL COMMENT '备注',
  `createTime` datetime NOT NULL,
  `lastUpdate` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_app_menu
-- ----------------------------
INSERT INTO `t_app_menu` VALUES ('1', '应用基本功能', '0', null, null, null, '1', '0', null, '2013-03-28 00:00:00', '2013-03-28 00:00:00');
INSERT INTO `t_app_menu` VALUES ('2', '用户中心首页', '1', 'main', '/u/main', null, '1', '0', null, '2013-03-28 00:00:00', '2013-03-28 00:00:00');
INSERT INTO `t_app_menu` VALUES ('3', '系统管理', '0', null, null, null, '1', '0', null, '2013-03-28 00:00:00', '2013-03-28 00:00:00');
INSERT INTO `t_app_menu` VALUES ('4', '用户管理', '3', 'users', '/u/users', null, '1', '0', null, '2013-03-28 00:00:00', '2013-03-28 00:00:00');
INSERT INTO `t_app_menu` VALUES ('5', '角色管理', '3', 'roles', '/u/roles', null, '1', '0', null, '2013-03-28 00:00:00', '2013-03-28 00:00:00');
INSERT INTO `t_app_menu` VALUES ('6', '资源管理', '3', 'menus', '/u/menus', null, '1', '0', null, '2013-03-28 00:00:00', '2013-03-31 22:02:15');
INSERT INTO `t_app_menu` VALUES ('7', 'yangml', '0', 'menus', '/u/menus/http://www.baidu.com', null, '1', '0', null, '2014-06-18 17:11:54', '2014-06-18 17:46:58');
INSERT INTO `t_app_menu` VALUES ('8', 'hello', '7', 'vv', 'www.baidu.com', null, '1', '0', null, '2014-06-18 17:51:51', '2014-06-18 17:52:34');
-- ----------------------------
-- Table structure for `t_app_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_role`;
CREATE TABLE `t_app_role` (
  `id` int(11) NOT NULL auto_increment COMMENT '管理角色标识',
  `roleName` varchar(32) collate utf8_unicode_ci NOT NULL COMMENT '角色名称',
  `createTime` datetime NOT NULL COMMENT '角色创建时间',
  `lastUpdate` datetime NOT NULL COMMENT '角色最近修改时间',
  `status` int(11) NOT NULL COMMENT '0:禁用,1:启用',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_app_role
-- ----------------------------
INSERT INTO `t_app_role` VALUES ('1', '系统管理员', '2013-03-28 00:00:00', '2013-04-01 13:30:53', '1');
INSERT INTO `t_app_role` VALUES ('2', '普通用户1', '2013-03-28 00:00:00', '2014-06-18 17:37:55', '1');
INSERT INTO `t_app_role` VALUES ('3', 'bling', '2014-06-18 17:18:28', '2014-06-18 17:18:28', '1');

-- ----------------------------
-- Table structure for `t_app_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_role_menu`;
CREATE TABLE `t_app_role_menu` (
  `id` int(11) NOT NULL auto_increment,
  `roleId` int(11) NOT NULL COMMENT '角色id',
  `menuId` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_app_role_menu
-- ----------------------------
INSERT INTO `t_app_role_menu` VALUES ('31', '1', '2');
INSERT INTO `t_app_role_menu` VALUES ('32', '1', '3');
INSERT INTO `t_app_role_menu` VALUES ('33', '1', '1');
INSERT INTO `t_app_role_menu` VALUES ('34', '1', '4');
INSERT INTO `t_app_role_menu` VALUES ('35', '1', '5');
INSERT INTO `t_app_role_menu` VALUES ('36', '1', '6');
INSERT INTO `t_app_role_menu` VALUES ('38', '3', '1');
INSERT INTO `t_app_role_menu` VALUES ('39', '3', '7');
INSERT INTO `t_app_role_menu` VALUES ('40', '3', '2');
INSERT INTO `t_app_role_menu` VALUES ('41', '2', '1');
INSERT INTO `t_app_role_menu` VALUES ('42', '2', '2');

-- ----------------------------
-- Table structure for `t_app_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_user`;
CREATE TABLE `t_app_user` (
  `id` int(11) NOT NULL auto_increment,
  `userName` varchar(32) collate utf8_unicode_ci NOT NULL,
  `passWord` varchar(128) collate utf8_unicode_ci NOT NULL,
  `createTime` datetime NOT NULL,
  `lastUpdate` datetime NOT NULL,
  `status` int(11) NOT NULL default '1' COMMENT '0:禁用,1:启用',
  PRIMARY KEY  (`id`),
  KEY `Index_1` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_app_user
-- ----------------------------
INSERT INTO `t_app_user` VALUES ('1', 'admin', 'b444e82d17a54d53a9e623fa586bf23ad7087df5e6f44848d01150fb0d5d523ea07ed99abdd074fc', '2013-03-28 00:00:00', '2013-03-28 00:00:00', '1');
INSERT INTO `t_app_user` VALUES ('2', 'test', '43b9406871ef23d348fbdd3ddffb3eee69ae76fcba61525255dc0c6b04a44f6b9d7565a78718a5ae', '2013-03-28 00:00:00', '2013-03-28 00:00:00', '1');
INSERT INTO `t_app_user` VALUES ('3', 'test1', '969e1f2618d6bfc67517a549ef3033d0de740791aed0aabd65a5dd7b3224fea962ad0d3cd6bc87bb', '2013-03-31 20:04:19', '2013-03-31 20:17:26', '1');
INSERT INTO `t_app_user` VALUES ('5', 'test3', 'd8f2bc4461f85d9dcfcc397ee8bee45b330ebc634a760d2865e4fd8633042c1fb36bbe4f7f4aad0c', '2013-03-31 20:07:01', '2013-03-31 20:07:22', '1');
INSERT INTO `t_app_user` VALUES ('6', 'bling', '5f4401a7539568c12a303e73902306f7f0c6b79d2cb418b917c413ab67028a431cd5201a7aa686e1', '2014-06-18 17:13:09', '2014-06-18 17:13:09', '1');
INSERT INTO `t_app_user` VALUES ('7', 'yangml', '365649b9fe8d56fb8a623bcbfef5ebba20093fd26cbfb1464bc5de307195e3a6de522888725a4db9', '2014-06-18 17:18:50', '2014-06-18 17:18:50', '1');

-- ----------------------------
-- Table structure for `t_app_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_user_role`;
CREATE TABLE `t_app_user_role` (
  `id` int(11) NOT NULL auto_increment,
  `userId` int(11) NOT NULL COMMENT '用户id',
  `roleId` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_app_user_role
-- ----------------------------
INSERT INTO `t_app_user_role` VALUES ('3', '2', '1');
INSERT INTO `t_app_user_role` VALUES ('4', '2', '2');
INSERT INTO `t_app_user_role` VALUES ('5', '5', '1');
INSERT INTO `t_app_user_role` VALUES ('6', '5', '2');
INSERT INTO `t_app_user_role` VALUES ('7', '1', '1');
INSERT INTO `t_app_user_role` VALUES ('10', '6', '2');
INSERT INTO `t_app_user_role` VALUES ('13', '7', '4');
INSERT INTO `t_app_user_role` VALUES ('14', '7', '2');