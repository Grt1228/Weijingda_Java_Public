/*
Navicat MySQL Data Transfer

Source Server         : javaweb
Source Server Version : 50149
Source Host           : localhost:3306
Source Database       : ldjgsu

Target Server Type    : MYSQL
Target Server Version : 50149
File Encoding         : 65001

Date: 2018-09-02 23:32:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app_image
-- ----------------------------
DROP TABLE IF EXISTS `app_image`;
CREATE TABLE `app_image` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `image_id` varchar(50) NOT NULL COMMENT '图片id',
  `image_name` varchar(20) NOT NULL COMMENT '图片名称方便查看',
  `image_url` varchar(100) NOT NULL COMMENT '图片url',
  `status` varchar(2) NOT NULL COMMENT '状态：0：失效，1：生效',
  `image_type` varchar(2) NOT NULL COMMENT '图片类型 0轮播图，1首页图标',
  `sort_num` int(3) NOT NULL COMMENT '图片排序',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='小程序端图片表 ';

-- ----------------------------
-- Records of app_image
-- ----------------------------
-- ----------------------------
-- Table structure for calendar
-- ----------------------------
DROP TABLE IF EXISTS `calendar`;
CREATE TABLE `calendar` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `calendar_id` varchar(50) NOT NULL COMMENT '校历id',
  `calendar_date` varchar(15) NOT NULL COMMENT '校历学期 2018-09~2019-06',
  `calendar_type` varchar(1) NOT NULL COMMENT '校历类型 0日期，1描述',
  `calendar_year` varchar(4) DEFAULT NULL COMMENT '年份',
  `calendar_month` varchar(2) DEFAULT NULL COMMENT '月份',
  `calendar_date_str` varchar(150) DEFAULT NULL COMMENT '日期英文逗号分隔',
  `calendar_title` varchar(10) DEFAULT NULL COMMENT '日历特殊日期标题',
  `calendar_info` varchar(400) DEFAULT NULL COMMENT '日历特殊日期详细信息',
  `is_current_year` varchar(1) DEFAULT NULL COMMENT '是不是当前学期，0-是，1-不是',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='校历表 ';

-- ----------------------------
-- Records of calendar
-- ----------------------------
-- ----------------------------
-- Table structure for cet
-- ----------------------------
DROP TABLE IF EXISTS `cet`;
CREATE TABLE `cet` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cet_id` varchar(50) NOT NULL COMMENT '四六级id',
  `cet_number` varchar(50) NOT NULL COMMENT '准考证号码',
  `student_id` varchar(50) DEFAULT NULL COMMENT '学生id',
  `student_name` varchar(10) DEFAULT NULL COMMENT '学生姓名',
  `university` varchar(20) NOT NULL COMMENT '学校名称',
  `cet4_score` varchar(5) DEFAULT NULL COMMENT '四级总分数',
  `cet6_score` varchar(5) DEFAULT NULL COMMENT '六级总分数',
  `cet6_listen_score` varchar(5) DEFAULT NULL COMMENT '六级听力分数',
  `cet4_listen_score` varchar(5) DEFAULT NULL COMMENT '四级听力分数',
  `cet6_read_score` varchar(5) DEFAULT NULL COMMENT '六级阅读分数',
  `cet4_read_score` varchar(5) DEFAULT NULL COMMENT '四级阅读分数',
  `cet6_write_score` varchar(5) DEFAULT NULL COMMENT '六级写作分数',
  `cet4_write_score` varchar(5) DEFAULT NULL COMMENT '四级写作分数',
  `cet4_status` varchar(2) DEFAULT NULL COMMENT '状态值，0-通过，1-未通过',
  `cet6_status` varchar(2) DEFAULT NULL COMMENT '状态值，0-通过，1-未通过',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `idx_cet_id` (`cet_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='四六级表 ';

-- ----------------------------
-- Records of cet
-- ----------------------------

-- ----------------------------
-- Table structure for course_info
-- ----------------------------
DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(50) NOT NULL COMMENT '课程id_uuid',
  `course_code` varchar(20) NOT NULL COMMENT '课程编号-官方提供',
  `course_start_code` varchar(20) NOT NULL COMMENT '开课编号',
  `login_name` varchar(20) NOT NULL COMMENT '学号/登录名',
  `student_name` varchar(20) NOT NULL COMMENT '学生姓名',
  `course_name` varchar(20) NOT NULL COMMENT '课程名称',
  `course_teacher` varchar(20) NOT NULL COMMENT '授课教师',
  `course_time` varchar(20) NOT NULL COMMENT '开课时间',
  `course_week` varchar(20) NOT NULL COMMENT '上课周次',
  `course_place` varchar(20) NOT NULL COMMENT '开课地点',
  `course_class` varchar(20) NOT NULL COMMENT '上课班级',
  `course_coordinate` varchar(20) NOT NULL COMMENT '课程所在坐标，开课学期_周次_星期_节次。例如：(2016-2017-1_1_1_1) 第一周_星期一_第一二节',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `idx_course_id` (`course_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程信息表 ';

-- ----------------------------
-- Records of course_info
-- ----------------------------

-- ----------------------------
-- Table structure for idea
-- ----------------------------
DROP TABLE IF EXISTS `idea`;
CREATE TABLE `idea` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idea_id` varchar(50) NOT NULL COMMENT '意见id',
  `login_name` varchar(20) NOT NULL COMMENT '学生学号',
  `student_id` varchar(50) NOT NULL COMMENT '学生id',
  `idea_detail` varchar(20) NOT NULL COMMENT '意见详情',
  `link_type` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `idx_idea_id` (`idea_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='意见表 ';

-- ----------------------------
-- Records of idea
-- ----------------------------
-- ----------------------------
-- Table structure for lost_good
-- ----------------------------
DROP TABLE IF EXISTS `lost_good`;
CREATE TABLE `lost_good` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lost_good_id` varchar(50) NOT NULL COMMENT '遗失/寻找物品id',
  `login_name` varchar(10) NOT NULL COMMENT '学号',
  `student_name` varchar(10) NOT NULL COMMENT '学生姓名',
  `student_id` varchar(50) NOT NULL COMMENT '学生id',
  `adder_name` varchar(20) NOT NULL COMMENT '发布人姓名（匿名）',
  `adder_mobile` varchar(15) NOT NULL COMMENT '发布人联系方式',
  `good_title` varchar(20) NOT NULL COMMENT '标题',
  `good_detail` varchar(200) NOT NULL COMMENT '物品详情',
  `good_position` varchar(30) NOT NULL COMMENT '丢失或发现的位置',
  `good_type` varchar(2) NOT NULL COMMENT '物品的状态,1-发布捡到物品,2-发布寻找物品',
  `good_status` varchar(2) NOT NULL COMMENT '失物招领状态,01-完成,02-未完成',
  `status` varchar(2) NOT NULL COMMENT '记录的有效状态,1-有效,0-无效',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `idx_lost_good_id` (`lost_good_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='失物招领表 ';

-- ----------------------------
-- Records of lost_good
-- ----------------------------
-- ----------------------------
-- Table structure for map_group
-- ----------------------------
DROP TABLE IF EXISTS `map_group`;
CREATE TABLE `map_group` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `map_group_id` varchar(50) NOT NULL COMMENT '地图坐标分组id',
  `map_group_name` varchar(20) NOT NULL COMMENT '组名称',
  `map_group_desc` varchar(50) DEFAULT NULL COMMENT '组描述',
  `status` varchar(2) DEFAULT NULL COMMENT '状态值，0-有效，1-无效',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `idx_map_gruop_id` (`map_group_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='地图坐标分组表 ';

-- ----------------------------
-- Records of map_group
-- ----------------------------
-- ----------------------------
-- Table structure for map_point
-- ----------------------------
DROP TABLE IF EXISTS `map_point`;
CREATE TABLE `map_point` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `map_point_id` varchar(50) NOT NULL COMMENT '地图坐标点id',
  `map_point_name` varchar(20) NOT NULL COMMENT '点名称',
  `map_point_longitude` varchar(15) NOT NULL COMMENT '经度',
  `map_point_latitude` varchar(15) NOT NULL COMMENT '纬度',
  `map_point_desc` varchar(50) DEFAULT NULL COMMENT '点描述',
  `point_type` varchar(2) NOT NULL COMMENT '点类别，0-普通点，1-线路点',
  `sort` varchar(10) DEFAULT NULL COMMENT '点排序，排序在线路点中使用',
  `map_group_id` varchar(50) DEFAULT NULL COMMENT '点分组id',
  `map_group_name` varchar(20) DEFAULT NULL COMMENT '点分组名称',
  `status` varchar(2) DEFAULT NULL COMMENT '状态值，0-有效，1-无效',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `idx_map_point_id` (`map_point_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8 COMMENT='地图坐标点表 ';

-- ----------------------------
-- Records of map_point
-- ----------------------------
-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `message_id` varchar(50) NOT NULL COMMENT '留言id',
  `login_name` varchar(20)  COMMENT '学生学号',
  `openid` varchar(100) NOT NULL COMMENT '学生id',
  `content` varchar(50) NOT NULL COMMENT '留言内容',
  `likedCount` int(11) DEFAULT '0' COMMENT '点赞数量',
  `incognito` varchar(2) NOT NULL COMMENT '是否匿名',
  `status` varchar(2) NOT NULL COMMENT '状态值',
  `create_time` datetime NOT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `idx_cet_id` (`message_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='留言表';

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for phone_book
-- ----------------------------
DROP TABLE IF EXISTS `phone_book`;
CREATE TABLE `phone_book` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_book_id` varchar(50) NOT NULL COMMENT '部门id_uuid',
  `phone_name` varchar(20) NOT NULL COMMENT '部门名称',
  `phone_number` varchar(20) NOT NULL COMMENT '部门电话',
  `phone_level` varchar(20) NOT NULL COMMENT '部门级别，0-校级，1-院级，2-校园商铺',
  `status` varchar(2) NOT NULL COMMENT '状态：0：失效，1：生效',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `idx_phone_book_id` (`phone_book_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='校园通讯录表 ';

-- ----------------------------
-- Records of phone_book
-- ----------------------------
-- ----------------------------
-- Table structure for school_calendar
-- ----------------------------
DROP TABLE IF EXISTS `school_calendar`;
CREATE TABLE `school_calendar` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `calendar_id` varchar(50) NOT NULL COMMENT '校历id',
  `calendar_date` varchar(15) NOT NULL COMMENT '校历学期 2018-09~2019-06',
  `calendar_url` varchar(50) NOT NULL COMMENT '校历url',
  `is_current_year` varchar(2) NOT NULL COMMENT '是不是当前学期，0-是，1-不是',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='校历表 ';

-- ----------------------------
-- Records of school_calendar
-- ----------------------------


-- ----------------------------
-- Table structure for score_info
-- ----------------------------
DROP TABLE IF EXISTS `score_info`;
CREATE TABLE `score_info` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `score_id` varchar(50) NOT NULL COMMENT '成绩id',
  `student_id` varchar(50) NOT NULL COMMENT '学生id_uuid',
  `login_name` varchar(20) NOT NULL COMMENT '学号/登录名',
  `student_name` varchar(10) NOT NULL COMMENT '学生姓名',
  `course_id` varchar(10) NOT NULL COMMENT '课程编号',
  `course_name` varchar(20) NOT NULL COMMENT '课程名称',
  `course_property` varchar(10) NOT NULL COMMENT '课程性质，限选，任选，必修，实践',
  `course_type` varchar(10) NOT NULL COMMENT '课程类别，C2限选，A1必修...',
  `test_property` varchar(10) NOT NULL COMMENT '考试性质，正常考试，补考',
  `test_type` varchar(10) NOT NULL COMMENT '考核方式，考试，考查',
  `repair_time` varchar(20) DEFAULT NULL COMMENT '补重学期',
  `learning_time` varchar(20) NOT NULL COMMENT '开课时间',
  `score` varchar(5) NOT NULL COMMENT '总成绩',
  `credit` varchar(5) NOT NULL COMMENT '学分',
  `hours` varchar(5) NOT NULL COMMENT '学时',
  `count_credit` varchar(5) NOT NULL COMMENT '总学分',
  `count_hours` varchar(5) NOT NULL COMMENT '总学时',
  `count_course` varchar(5) NOT NULL COMMENT '总课程数',
  `count_fail` varchar(5) NOT NULL COMMENT '不及格数',
  `must_credit` varchar(5) NOT NULL COMMENT '必修学分',
  `major_elective_credit` varchar(5) NOT NULL COMMENT '专业选修学分',
  `public_elective_credit` varchar(5) NOT NULL COMMENT '公共选修学分',
  `avg_score_point` varchar(5) NOT NULL COMMENT '平均学分绩点',
  `status` varchar(2) NOT NULL COMMENT '是否及格,1-及格,2-不及格',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `idx_score_id` (`score_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2492 DEFAULT CHARSET=utf8 COMMENT='学生成绩表 ';

-- ----------------------------
-- Records of score_info
-- ----------------------------

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(50) NOT NULL COMMENT '课程id_uuid',
  `student_id` varchar(50) NOT NULL COMMENT '学生id_uuid',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程学生关系表';

-- ----------------------------
-- Records of student_course
-- ----------------------------

-- ----------------------------
-- Table structure for student_score
-- ----------------------------
DROP TABLE IF EXISTS `student_score`;
CREATE TABLE `student_score` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(50) NOT NULL COMMENT '学生id_uuid',
  `score_id` varchar(50) NOT NULL COMMENT '成绩id_uuid',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程成绩关系表 ';

-- ----------------------------
-- Records of student_score
-- ----------------------------

-- ----------------------------
-- Table structure for teacher_course
-- ----------------------------
DROP TABLE IF EXISTS `teacher_course`;
CREATE TABLE `teacher_course` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teacher_id` varchar(50) NOT NULL COMMENT '教师id_uuid',
  `course_id` varchar(50) NOT NULL COMMENT '课程id_uuid',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师和课程的对应关系表';

-- ----------------------------
-- Records of teacher_course
-- ----------------------------

-- ----------------------------
-- Table structure for teacher_info
-- ----------------------------
DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teacher_id` varchar(50) NOT NULL COMMENT '教师id_uuid',
  `teacher_code` varchar(20) NOT NULL COMMENT '教师编号',
  `teacher_name` varchar(20) NOT NULL COMMENT '教师姓名',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `idx_teacher_id` (`teacher_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师基本信息表';

-- ----------------------------
-- Records of teacher_info
-- ----------------------------

-- ----------------------------
-- Table structure for teacher_student
-- ----------------------------
DROP TABLE IF EXISTS `teacher_student`;
CREATE TABLE `teacher_student` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teacher_id` varchar(50) NOT NULL COMMENT '教师id_uuid',
  `student_id` varchar(50) NOT NULL COMMENT '学生id_uuid',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生教师关系表';

-- ----------------------------
-- Records of teacher_student
-- ----------------------------

-- ----------------------------
-- Table structure for university_news
-- ----------------------------
DROP TABLE IF EXISTS `university_news`;
CREATE TABLE `university_news` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `new_id` varchar(50) NOT NULL COMMENT '校园新闻id',
  `new_title` varchar(20) NOT NULL COMMENT '新闻题目',
  `new_type` varchar(20) NOT NULL COMMENT '新闻类别',
  `new_date` varchar(20) NOT NULL COMMENT '新闻日期',
  `new_creater` varchar(20) NOT NULL COMMENT '新闻发布人',
  `new_detail` varchar(600) DEFAULT NULL COMMENT '新闻内容',
  `new_status` varchar(2) NOT NULL COMMENT '新闻状态，1-有效，0-无效',
  `look_num` int(10) DEFAULT NULL COMMENT '访问人数',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `idx_new_id` (`new_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='校园新闻表 ';

-- ----------------------------
-- Records of university_news
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(50) NOT NULL COMMENT '学生id_uuid',
  `openid` varchar(100) DEFAULT NULL COMMENT '微信openid',
  `gender` varchar(1) DEFAULT NULL COMMENT '性别',
  `login_name` varchar(20) NOT NULL COMMENT '学号/登录名',
  `student_name` varchar(20) NOT NULL COMMENT '学生姓名',
  `org_code` varchar(1) DEFAULT NULL COMMENT '组织编号,1本科，2研究生，3教师',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `university_name` varchar(30) DEFAULT NULL COMMENT '学校名称',
  `college_name` varchar(50) DEFAULT NULL COMMENT '学院名称',
  `majors_name` varchar(50) DEFAULT NULL COMMENT '学科名称',
  `college_id` varchar(20) DEFAULT NULL COMMENT '学院编号',
  `majors_id` varchar(20) DEFAULT NULL COMMENT '学科编号',
  `class_name` varchar(20) DEFAULT NULL COMMENT '班级名称',
  `class_id` varchar(20) DEFAULT NULL COMMENT '班级编号',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮件',
  `avatar_url` varchar(500) DEFAULT NULL COMMENT '微信头像',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '微信名称',
  `status` varchar(2) NOT NULL COMMENT '状态：0：失效，1：生效',
  `role` varchar(2) NOT NULL COMMENT '角色：0：普通用户，1：管理员',
  `create_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `idx_student_id` (`student_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='学生个人的基本信息';

