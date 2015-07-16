--Users
INSERT INTO Users(user_no, user_name, user_gender, dep_id, user_password)
VALUES('209461', 'zhongsx', 'MALE', 4, '');
INSERT INTO Users(user_no, user_name, user_gender, dep_id, user_password)
VALUES('209387', 'wengsn', 'FEMALE', 4, '');
INSERT INTO Users(user_no, user_name, user_gender, dep_id, user_password)
VALUES('205639', 'wangx', 'MALE', 4, '');


--Departments
INSERT INTO Departments(dep_code, dep_name, father_dep_id)
VALUES('CSN', '中国南方航空股份有限公司', 0);
INSERT INTO Departments(dep_code, dep_name, father_dep_id)
VALUES('CWB', '财务部', 1);
INSERT INTO Departments(dep_code, dep_name, father_dep_id)
VALUES('XXZX', '信息中心', 1);
INSERT INTO Departments(dep_code, dep_name, father_dep_id)
VALUES('GLYFB', '管理研发部', 3);
INSERT INTO Departments(dep_code, dep_name, father_dep_id)
VALUES('YXYFB', '运行研发部', 3);
INSERT INTO Departments(dep_code, dep_name, father_dep_id)
VALUES('SWYFB', '商务研发部', 3);
INSERT INTO Departments(dep_code, dep_name, father_dep_id)
VALUES('JGB', '价格办', 2);
INSERT INTO Departments(dep_code, dep_name, father_dep_id)
VALUES('YSC', '预算处', 2);
INSERT INTO Departments(dep_code, dep_name, father_dep_id)
VALUES('ZWB', '总务部', 1);



