INSERT INTO `students_system_management`.`groupp` (`id`, `name`) VALUES ('1', 'T - 12');
INSERT INTO `students_system_management`.`student` (`admission_date`, `group_id`, `id`, `name`, `surname`) VALUES ('2000-09-01', '1', '1', 'Fred', 'Denisov');
INSERT INTO `students_system_management`.`student` (`admission_date`, `group_id`, `id`, `name`, `surname`) VALUES ('2000-09-01', '1', '2', 'Dima', 'Petrov');
INSERT INTO `students_system_management`.`discipline` (`id`, `name`) VALUES ('1', '�������');
INSERT INTO `students_system_management`.`discipline` (`id`, `name`) VALUES ('2', '������� ����');
INSERT INTO `students_system_management`.`discipline` (`id`, `name`) VALUES ('3', '������� ����� � �������');
INSERT INTO `students_system_management`.`discipline` (`id`, `name`) VALUES ('4', '�����������');
INSERT INTO `students_system_management`.`discipline` (`id`, `name`) VALUES ('5', '�����������');
INSERT INTO `students_system_management`.`discipline` (`id`, `name`) VALUES ('6', '������ ��������������');
INSERT INTO `students_system_management`.`term` (`id`, `duration`, `name`) VALUES ('1', '10 ������', '������� 1');
INSERT INTO `students_system_management`.`term` (`id`, `duration`, `name`) VALUES ('2', '12 ������', '������� 2');
insert into `students_system_management`.`term_discipline` (`discipline_id`, `term_id`) VALUES ('1', '1');
insert into `students_system_management`.`term_discipline` (`discipline_id`, `term_id`) VALUES ('2', '1');
insert into `students_system_management`.`term_discipline` (`discipline_id`, `term_id`) VALUES ('1', '2');
INSERT INTO `students_system_management`.`grade` (`grade`, `discipline_id`, `id`, `student_id`, `term_id`) VALUES ('3', '1', '1', '1', '1');
INSERT INTO `students_system_management`.`grade` (`grade`, `discipline_id`, `id`, `student_id`, `term_id`) VALUES ('4', '2', '2', '1', '1');
INSERT INTO `students_system_management`.`grade` (`grade`, `discipline_id`, `id`, `student_id`, `term_id`) VALUES ('5', '3', '3', '1', '1');
INSERT INTO `students_system_management`.`grade` (`grade`, `discipline_id`, `id`, `student_id`, `term_id`) VALUES ('2', '4', '4', '2', '2');




