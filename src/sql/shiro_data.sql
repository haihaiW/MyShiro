DELETE FROM users;
DELETE FROM user_roles;
DELETE FROM roles_permissions;
INSERT INTO users(username, PASSWORD, password_salt) VALUES('zhang', '123', NULL);
INSERT INTO user_roles(username, role_name) VALUES('zhang', 'role1');
INSERT INTO user_roles(username, role_name) VALUES('zhang', 'role2');
INSERT INTO roles_permissions(role_name, permission) VALUES('role1', '+user1+10');
INSERT INTO roles_permissions(role_name, permission) VALUES('role1', 'user1:*');
INSERT INTO roles_permissions(role_name, permission) VALUES('role1', '+user2+10');
INSERT INTO roles_permissions(role_name, permission) VALUES('role1', 'user2:*');

INSERT INTO users(username, PASSWORD, password_salt) VALUES('wu', '$shiro1$SHA-512$1$$PJkJr+wlNU1VHa4hWQuybjjVPyFzuNPcPu5MBH56scHri4UQPjvnumE7MbtcnDYhTcnxSkL9ei/bhIVrylxEwg==', NULL);
INSERT INTO users(username, PASSWORD, password_salt) VALUES('liu', 'a9a114054aa6758184314fbb959fbda4', '24520ee264eab73ec09451d0e9ea6aac');



