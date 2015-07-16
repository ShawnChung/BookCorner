--Users
INSERT INTO Users(user_no, user_name, user_gender, dep_id, user_password)
VALUES('209461', '钟盛翔', 'MALE', 4, '');
INSERT INTO Users(user_no, user_name, user_gender, dep_id, user_password)
VALUES('209387', '翁少娜', 'FEMALE', 4, '');
INSERT INTO Users(user_no, user_name, user_gender, dep_id, user_password)
VALUES('205639', '王轩', 'MALE', 4, '');


--Departments
INSERT INTO Departments(id, dep_code, dep_name, father_dep_id)
VALUES(1, 'CSN', '中国南方航空股份有限公司', 0);
INSERT INTO Departments(id, dep_code, dep_name, father_dep_id)
VALUES(2, 'CWB', '财务部', 1);
INSERT INTO Departments(id, dep_code, dep_name, father_dep_id)
VALUES(3, 'XXZX', '信息中心', 1);
INSERT INTO Departments(id, dep_code, dep_name, father_dep_id)
VALUES(4, 'GLYFB', '管理研发部', 3);
INSERT INTO Departments(id, dep_code, dep_name, father_dep_id)
VALUES(5, 'YXYFB', '运行研发部', 3);
INSERT INTO Departments(id, dep_code, dep_name, father_dep_id)
VALUES(6, 'SWYFB', '商务研发部', 3);
INSERT INTO Departments(id, dep_code, dep_name, father_dep_id)
VALUES(7, 'JGB', '价格办', 2);
INSERT INTO Departments(id, dep_code, dep_name, father_dep_id)
VALUES(8, 'YSC', '预算处', 2);
INSERT INTO Departments(id, dep_code, dep_name, father_dep_id)
VALUES(9, 'ZWB', '总务部', 1);



