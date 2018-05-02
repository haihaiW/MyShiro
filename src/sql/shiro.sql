DROP DATABASE IF EXISTS shiro;

CREATE DATABASE shiro;
USE shiro;

CREATE TABLE users (
  id BIGINT AUTO_INCREMENT,
  username VARCHAR(100),
  PASSWORD VARCHAR(100),
  password_salt VARCHAR(100),
  CONSTRAINT  PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=INNODB;
CREATE UNIQUE INDEX  ON users(username);

CREATE TABLE user_roles(
  id BIGINT AUTO_INCREMENT,
  username VARCHAR(100),
  role_name VARCHAR(100),
  CONSTRAINT  PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=INNODB;
CREATE UNIQUE INDEX  ON user_roles(username, role_name);

CREATE TABLE roles_permissions(
  id BIGINT AUTO_INCREMENT,
  role_name VARCHAR(100),
  permission VARCHAR(100),
  CONSTRAINT  PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=INNODB;
CREATE UNIQUE INDEX idx_roles_permissions ON roles_permissions(role_name, permission);

INSERT INTO users(username,PASSWORD)VALUES('zhang','123');
INSERT INTO users(username,PASSWORD)VALUES('hai','123');

DROP TABLE IF EXISTS sys_users;
DROP TABLE IF EXISTS sys_roles;
DROP TABLE IF EXISTS sys_permissions;
DROP TABLE IF EXISTS sys_users_roles;
DROP TABLE IF EXISTS sys_roles_permissions;

CREATE TABLE sys_users (
  id BIGINT AUTO_INCREMENT,
  username VARCHAR(100),
  PASSWORD VARCHAR(100),
  salt VARCHAR(100),
  locked BOOL DEFAULT FALSE,
  CONSTRAINT  PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=INNODB;
CREATE UNIQUE INDEX idx_sys_users_username ON sys_users(username);

CREATE TABLE sys_roles (
  id BIGINT AUTO_INCREMENT,
  role VARCHAR(100),
  description VARCHAR(100),
  available BOOL DEFAULT FALSE,
  CONSTRAINT pk_sys_roles PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=INNODB;
CREATE UNIQUE INDEX idx_sys_roles_role ON sys_roles(role);

CREATE TABLE sys_permissions (
  id BIGINT AUTO_INCREMENT,
  permission VARCHAR(100),
  description VARCHAR(100),
  available BOOL DEFAULT FALSE,
  CONSTRAINT pk_sys_permissions PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=INNODB;
CREATE UNIQUE INDEX idx_sys_permissions_permission ON sys_permissions(permission);

CREATE TABLE sys_users_roles (
  user_id BIGINT,
  role_id BIGINT,
  CONSTRAINT pk_sys_users_roles PRIMARY KEY(user_id, role_id)
) CHARSET=utf8 ENGINE=INNODB;

CREATE TABLE sys_roles_permissions (
  role_id BIGINT,
  permission_id BIGINT,
  CONSTRAINT pk_sys_roles_permissions PRIMARY KEY(role_id, permission_id)
) CHARSET=utf8 ENGINE=INNODB;

