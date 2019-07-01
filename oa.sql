/*
Navicat MySQL Data Transfer

Source Server         : oa
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2018-12-06 14:50:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_dialogue
-- ----------------------------
DROP TABLE IF EXISTS `t_dialogue`;
CREATE TABLE `t_dialogue` (
  `dialogue_id` varchar(40) NOT NULL,
  `user_a_id` varchar(40) DEFAULT NULL,
  `user_b_id` varchar(40) DEFAULT NULL,
  `dialogue_content` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `state` int(11) DEFAULT NULL COMMENT '0 未读；1已读；',
  PRIMARY KEY (`dialogue_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dialogue
-- ----------------------------
INSERT INTO `t_dialogue` VALUES ('004b158a-3832-413c-8ff7-3fa18a861a42', '1', '9cd4b835-d820-46af-89e5-c0234ecbe02f', 'root-------张老师', '2018-12-06 14:03:03', '1');
INSERT INTO `t_dialogue` VALUES ('0bb74cec-0f47-4435-9e58-e8c27cb8a241', '1', '9cd4b835-d820-46af-89e5-c0234ecbe02f', 'root----老师', '2018-12-06 13:34:22', '1');
INSERT INTO `t_dialogue` VALUES ('0e0c2dcf-d4ff-431e-859c-47ae663a4aec', '9cd4b835-d820-46af-89e5-c0234ecbe02f', '1', '此次政策', '2018-12-06 14:42:19', '1');
INSERT INTO `t_dialogue` VALUES ('0f2b7b7d-3266-42bf-93d1-f4c7b6fcfd30', '9cd4b835-d820-46af-89e5-c0234ecbe02f', 'd181f559-9562-49b4-94e7-90138cb9c74f', '老师------学生', '2018-12-06 13:34:35', '1');
INSERT INTO `t_dialogue` VALUES ('40237e27-7c32-4159-b267-868f71db8fad', '9cd4b835-d820-46af-89e5-c0234ecbe02f', '1', '老师------root', '2018-12-06 13:33:25', '1');
INSERT INTO `t_dialogue` VALUES ('50199365-e6ff-4f6a-8ea0-781605924bc9', '9cd4b835-d820-46af-89e5-c0234ecbe02f', '1', '阿萨大大撒旦', '2018-12-06 14:13:38', '1');
INSERT INTO `t_dialogue` VALUES ('6f3030e0-e574-444b-8635-0600f901737e', '9cd4b835-d820-46af-89e5-c0234ecbe02f', '1', '阿萨大大撒旦', '2018-12-06 14:22:29', '1');
INSERT INTO `t_dialogue` VALUES ('70aca2e2-d8b0-479c-8dd2-2d7f36a108a9', '9cd4b835-d820-46af-89e5-c0234ecbe02f', '1', '老师------root', '2018-12-06 13:33:25', '1');
INSERT INTO `t_dialogue` VALUES ('7c6b01c0-9f61-4f0f-a4e1-c0f0174ccd93', '9cd4b835-d820-46af-89e5-c0234ecbe02f', 'd181f559-9562-49b4-94e7-90138cb9c74f', '老师-----学生', '2018-12-06 13:34:35', '1');
INSERT INTO `t_dialogue` VALUES ('8c5076f2-0b11-4c35-8c50-23b5df33afca', '1', 'd181f559-9562-49b4-94e7-90138cb9c74f', 'root----学生', '2018-12-06 13:34:34', '1');
INSERT INTO `t_dialogue` VALUES ('9ed5db2a-5867-4999-a06f-f75a4fc9202b', 'd181f559-9562-49b4-94e7-90138cb9c74f', '9cd4b835-d820-46af-89e5-c0234ecbe02f', '学生-------老师', '2018-12-06 13:34:23', '1');
INSERT INTO `t_dialogue` VALUES ('a0e42dee-d56f-46b2-9352-0ac84e56c767', 'd181f559-9562-49b4-94e7-90138cb9c74f', '9cd4b835-d820-46af-89e5-c0234ecbe02f', '学生------老师', '2018-12-06 13:34:23', '1');
INSERT INTO `t_dialogue` VALUES ('a2af905d-5ac2-4b2a-9f75-d5e940e3c404', '1', '9cd4b835-d820-46af-89e5-c0234ecbe02f', 'root-------张老师', '2018-12-06 14:00:17', '1');
INSERT INTO `t_dialogue` VALUES ('a4c72008-0c66-4cea-80ba-efdf13a3af75', '1', '9cd4b835-d820-46af-89e5-c0234ecbe02f', 'root-------张老师', '2018-12-06 13:59:14', '1');
INSERT INTO `t_dialogue` VALUES ('be3af19c-211f-4e75-82cc-c535d95e7a5b', 'd181f559-9562-49b4-94e7-90138cb9c74f', '1', '啊大苏打', '2018-12-06 14:13:50', '1');
INSERT INTO `t_dialogue` VALUES ('c0da645a-faf5-448c-874e-12ab49729983', '1', 'd181f559-9562-49b4-94e7-90138cb9c74f', 'root------学生', '2018-12-06 13:58:02', '1');
INSERT INTO `t_dialogue` VALUES ('cabf49d0-86f0-473d-84cf-1082f8f32609', 'd181f559-9562-49b4-94e7-90138cb9c74f', '1', '学生-----root', '2018-12-06 13:33:50', '1');
INSERT INTO `t_dialogue` VALUES ('d7f58309-6ed1-4f50-8ccd-37619e043a73', '1', 'd181f559-9562-49b4-94e7-90138cb9c74f', 'root------学生', '2018-12-06 14:01:21', '1');
INSERT INTO `t_dialogue` VALUES ('dbb2d2c2-6c34-41db-ba07-189d867de742', '1', '9cd4b835-d820-46af-89e5-c0234ecbe02f', 'root------张老师', '2018-12-06 13:59:14', '1');
INSERT INTO `t_dialogue` VALUES ('e8ea0ec4-4d07-4aee-bdff-2b8ebc5173bf', '9cd4b835-d820-46af-89e5-c0234ecbe02f', '1', '此次政策', '2018-12-06 14:47:42', '1');
INSERT INTO `t_dialogue` VALUES ('f6510fe4-de67-4e55-9d27-27a922ea1668', 'd181f559-9562-49b4-94e7-90138cb9c74f', '1', '学生-------root', '2018-12-06 13:33:50', '1');
INSERT INTO `t_dialogue` VALUES ('fa96d9c3-e5e3-4099-9ab1-62dc2430b175', '1', 'd181f559-9562-49b4-94e7-90138cb9c74f', 'root------学生', '2018-12-06 14:03:07', '1');
INSERT INTO `t_dialogue` VALUES ('fd70ae12-4494-47e8-9479-859bcaf429a2', '1', 'd181f559-9562-49b4-94e7-90138cb9c74f', 'root-----学生', '2018-12-06 13:58:02', '1');

-- ----------------------------
-- Table structure for t_diary
-- ----------------------------
DROP TABLE IF EXISTS `t_diary`;
CREATE TABLE `t_diary` (
  `diary_id` varchar(40) NOT NULL,
  `student_id` varchar(40) DEFAULT NULL COMMENT '学生id',
  `teacher_id` varchar(40) DEFAULT NULL COMMENT '教师id',
  `create_time` datetime DEFAULT NULL,
  `diary_title` varchar(255) DEFAULT NULL COMMENT '日记标题',
  `diary_text` blob,
  `diary_state` int(11) DEFAULT NULL COMMENT '状态：0待审核；1通过；2驳回；',
  `remarks` varchar(255) DEFAULT NULL COMMENT '评价',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `fraction` varchar(40) DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`diary_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_diary
-- ----------------------------
INSERT INTO `t_diary` VALUES ('07c06bf3-3864-4680-9ca5-33aca7514eed', '1', '9cd4b835-d820-46af-89e5-c0234ecbe02f', '2018-12-05 15:20:44', '1024程序员节', 0x253343702532307374796C652533442532326C696E652D68656967687425334125323032253342253232253345253343622532307374796C65253344253232666F6E742D7374796C652533412532306974616C69632533422532322533452533437370616E2532307374796C65253344253232636F6C6F722533412532307267622835312532432532303531253243253230353129253342253230666F6E742D66616D696C79253341253230617269616C25324325323025453525414525384225453425424425393325324325323073616E732D7365726966253342253230746578742D696E64656E7425334125323032387078253342253230666F6E742D73697A65253341253230313870782533422532322533452532366E6273702533422532302532366E6273702533422532302532366E6273702533422532302532366E6273702533422533432532467370616E2533452533437370616E2532307374796C65253344253232636F6C6F72253341253230726762283235352532432532303025324325323030292533422532322533452533437370616E2532307374796C65253344253232666F6E742D66616D696C79253341253230617269616C25324325323025453525414525384225453425424425393325324325323073616E732D7365726966253342253230746578742D696E64656E7425334125323032387078253342253230666F6E742D73697A6525334125323031387078253342253232253345313032342533432532467370616E253345253343666F6E7425323066616365253344253232617269616C25324325323025453525414525384225453425424425393325324325323073616E732D73657269662532322533452533437370616E2532307374796C65253344253232746578742D696E64656E7425334125323032387078253342253230666F6E742D73697A65253341253230313870782533422532322533452545372541382538422545352542412538462545352539312539382533432532467370616E253345253343253246666F6E742533452533437370616E2532307374796C65253344253232666F6E742D66616D696C79253341253230617269616C25324325323025453525414525384225453425424425393325324325323073616E732D7365726966253342253230746578742D696E64656E7425334125323032387078253342253230666F6E742D73697A652533412532303138707825334225323225334525453825384125383225453625393825414625453425423825414425453525394225424425453725413825384225453525424125384625453525393125393825453725394125383425453525383525423125453525393025384325453825384125383225453625393725413525453325383025383231303234254536253938254146322545372539412538342545352538442538312545362541432541312545362539362542392545462542432538432545342542412538432545382542462539422545352538382542362545382541452541312545362539352542302545372539412538342545352539462542412545362539432541432545382541452541312545392538372538462545352538442539352545342542442538442545342542392538422545342542382538302545332538302538322545372541382538422545352542412538462545352539312539382825453825384225423125453625393625383750726F6772616D6D657229254536253938254146254534254242253845254534254241253842254537254138253842254535254241253846254535254243253830254535253846253931254533253830253831254537254242254234254536253841254134254537253941253834254534254238253933254534254238253941254534254241254241254535253931253938254533253830253832254537254138253842254535254241253846254535253931253938254535254230254231254535253833253846254536253938254146254534254238253830254534254238254141254534254238254141313032342545462542432538432545342542422541352545362539432538302545342542442538452545382542302538332545332538302538312545382542382538462545352541452539452545332538302538312545362541302542382545352542462538332545372539412538342545352538412539462545382538332542442545362541382541312545352539442539372545362539302541442545352542422542412545382542352542372545382542462539392545342542382541412545372541372539312545362538412538302545342542382539362545372539352538432545332538302538323147253344313032344D2545462542432538432545382538302538433147254534254238253845312545372542412541372545382542302539302545392539462542332545462542432538432545342542392539462545362539432538392545342542382538302545372542412541372545362541332539322545372539412538342545362538342538462545362538302539442545332538302538322533432532467370616E2533452533432532467370616E25334525334325324662253345253343627225334525334325324670253345, '3', '重写', '2018-12-05 15:31:16', '优');
INSERT INTO `t_diary` VALUES ('1067ecf8-2d5e-4fab-ac3c-b70a1272d4ca', null, null, '2018-12-05 12:43:56', '', 0x2533437025334525334362253345253343692532307374796C652533442532326261636B67726F756E642D636F6C6F72253341253230726762283235352532432532303235352532432532303029253342253230636F6C6F72253341253230726762283025324325323032353525324325323032353529253342253232253345254535254134254137254535254134254137254535254134254137254535254134254137253343253246692533452533432532466225334525334325324670253345, '0', null, null, null);
INSERT INTO `t_diary` VALUES ('84877c12-b7f1-4f4e-9d5b-a72a1f88b114', '1', '9cd4b835-d820-46af-89e5-c0234ecbe02f', '2018-12-05 20:40:12', '测试', 0x2533437025334525453525413425413725453525413425413725453825384225384625453625383925393325334325324670253345, '3', null, '2018-12-05 20:40:25', '差');
INSERT INTO `t_diary` VALUES ('8d321a87-40ae-432a-8dd8-9aad68c75320', '1', '9cd4b835-d820-46af-89e5-c0234ecbe02f', '2018-12-05 20:46:33', '测试', 0x2533437025334525453525393525384125453625393825414625453525413425413725453525413425413725453625393225393225453525413425413725453625393225393225453525413425413725453625393225393225334325324670253345, '3', '', '2018-12-06 09:53:55', '差');
INSERT INTO `t_diary` VALUES ('bccea507-b0b7-49c1-bc41-29dece1ddb54', '1', '9cd4b835-d820-46af-89e5-c0234ecbe02f', '2018-12-05 20:40:51', '测试', 0x2533437025334525453525413425413725453525413425413725453825384225384625453625383925393325334325324670253345, '3', null, '2018-12-05 20:41:01', '优');
INSERT INTO `t_diary` VALUES ('deecb757-d9c9-4dcc-937c-84797b33da85', '1', '9cd4b835-d820-46af-89e5-c0234ecbe02f', '2018-12-05 15:41:32', '测试', 0x2533437025334525453625423025423425453625423025423425453625423025423425453625423025423425453625423025423425334325324670253345, '3', '', '2018-12-05 20:39:43', '良');
INSERT INTO `t_diary` VALUES ('f5220109-96ac-462d-b4cf-dcb3123defd5', '1', '9cd4b835-d820-46af-89e5-c0234ecbe02f', '2018-12-05 20:40:03', '测试', 0x2533437025334525453525413425413725453525413425413725453825384225384625453625383925393325334325324670253345, '3', null, '2018-12-05 20:40:32', '不及格');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `menu_id` varchar(40) NOT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '用户');
INSERT INTO `t_menu` VALUES ('2', '角色');
INSERT INTO `t_menu` VALUES ('3', '留言');
INSERT INTO `t_menu` VALUES ('4', '日记记录');
INSERT INTO `t_menu` VALUES ('5', '日记审核');

-- ----------------------------
-- Table structure for t_power
-- ----------------------------
DROP TABLE IF EXISTS `t_power`;
CREATE TABLE `t_power` (
  `menu_id` varchar(40) DEFAULT NULL,
  `role_id` varchar(40) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `power_id` varchar(40) NOT NULL,
  PRIMARY KEY (`power_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_power
-- ----------------------------
INSERT INTO `t_power` VALUES ('1', '0', '1', '1');
INSERT INTO `t_power` VALUES ('5', '1', '1', '10');
INSERT INTO `t_power` VALUES ('1', '2', '0', '11');
INSERT INTO `t_power` VALUES ('2', '2', '0', '12');
INSERT INTO `t_power` VALUES ('3', '2', '1', '13');
INSERT INTO `t_power` VALUES ('4', '2', '1', '14');
INSERT INTO `t_power` VALUES ('5', '2', '0', '15');
INSERT INTO `t_power` VALUES ('3', '57ec0a34-0127-45f0-a1a4-5b3f369200fa', '0', '1597c1ea-4ee0-4c6f-b0bb-6924158b1985');
INSERT INTO `t_power` VALUES ('2', '0 ', '1', '2');
INSERT INTO `t_power` VALUES ('3', '0', '1', '3');
INSERT INTO `t_power` VALUES ('4', '0', '1', '4');
INSERT INTO `t_power` VALUES ('2', '57ec0a34-0127-45f0-a1a4-5b3f369200fa', '0', '4ed9d998-e93f-4424-bd07-f5ba0addb8f0');
INSERT INTO `t_power` VALUES ('5', '0', '1', '5');
INSERT INTO `t_power` VALUES ('1', '1', '0', '6');
INSERT INTO `t_power` VALUES ('2', '1', '0', '7');
INSERT INTO `t_power` VALUES ('5', '57ec0a34-0127-45f0-a1a4-5b3f369200fa', '0', '73601ca3-525d-4544-ad24-ad630c3d1ac0');
INSERT INTO `t_power` VALUES ('3', '1', '1', '8');
INSERT INTO `t_power` VALUES ('4', '57ec0a34-0127-45f0-a1a4-5b3f369200fa', '0', '86e0b0ef-64b5-4f57-a7a1-2f1e31ec16f3');
INSERT INTO `t_power` VALUES ('4', '1', '0', '9');
INSERT INTO `t_power` VALUES ('1', '57ec0a34-0127-45f0-a1a4-5b3f369200fa', '0', '9042d4fc-5a8d-4a1f-9ee9-200cca9d9b81');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` varchar(40) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('0', '管理员', '2018-11-30 19:43:31', '2018-11-30 20:52:14');
INSERT INTO `t_role` VALUES ('1', '教师', '2018-12-01 23:47:48', '2018-12-02 10:48:56');
INSERT INTO `t_role` VALUES ('2', '学生', '2018-12-01 23:48:01', '2018-12-02 10:48:50');
INSERT INTO `t_role` VALUES ('57ec0a34-0127-45f0-a1a4-5b3f369200fa', '测试', '2018-12-04 16:59:13', '2018-12-05 13:22:27');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(40) NOT NULL,
  `role_id` varchar(40) DEFAULT NULL,
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `user_email` varchar(255) DEFAULT NULL COMMENT '用户email',
  `user_phone` varchar(255) DEFAULT NULL COMMENT '用户电话',
  `user_state` int(10) DEFAULT NULL COMMENT '用户状态：0启用；1停用',
  `user_pwd` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('02a5e5bd-fe74-4fd1-9868-1891947f959e', '57ec0a34-0127-45f0-a1a4-5b3f369200fa', '测试1', '2018-12-05 12:26:34', '', '', '0', '000000', null, null);
INSERT INTO `t_user` VALUES ('1', '0', 'root', '2018-12-05 12:21:26', '1305156911@qq.com', '15122693135', '1', '000000', '2018-12-05 12:21:46', '5c67706a-6ad8-47e2-9bfb-e909d75c4e2e');
INSERT INTO `t_user` VALUES ('9cd4b835-d820-46af-89e5-c0234ecbe02f', '1', '张老师', '2018-12-04 17:00:28', '1305156911@qq.com', '15122693135', '1', '000000', '2018-12-05 12:13:46', 'cd5cc5ca-a7e8-4a77-952f-b4a2303bdbc8');
INSERT INTO `t_user` VALUES ('d181f559-9562-49b4-94e7-90138cb9c74f', '2', '李同学', '2018-12-04 17:00:42', '1305156911@qq.com', '15122693135', '1', '000000', '2018-12-05 12:13:54', 'ece4e4a6-4d04-4ffa-a0e6-9a1baaf1f186');
INSERT INTO `t_user` VALUES ('ed58ceab-6a6c-43b2-8ed5-20a6a4b97979', '57ec0a34-0127-45f0-a1a4-5b3f369200fa', '测试', '2018-12-05 12:04:57', '1305156911@qq.com', '15122693135', '1', '000000', '2018-12-05 12:07:39', null);