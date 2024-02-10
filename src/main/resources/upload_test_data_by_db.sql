INSERT INTO `students_system_management`.`groupp` (`id`, `name`) VALUES ('1', 'T - 12');
INSERT INTO `students_system_management`.`student` (`admission_date`, `group_id`, `id`, `name`, `surname`) VALUES ('2000-09-01', '1', '1', 'Fred', 'Denisov');
INSERT INTO `students_system_management`.`student` (`admission_date`, `group_id`, `id`, `name`, `surname`) VALUES ('2000-09-01', '1', '2', 'Dima', 'Petrov');
INSERT INTO `students_system_management`.`discipline` (`id`, `name`) VALUES ('1', 'История');
INSERT INTO `students_system_management`.`discipline` (`id`, `name`) VALUES ('2', 'Русский язык');
INSERT INTO `students_system_management`.`term` (`id`, `duration`, `name`) VALUES ('1', '10 недель', 'Семестр 1');
INSERT INTO `students_system_management`.`term` (`id`, `duration`, `name`) VALUES ('2', '12 недель', 'Семестр 2');
insert into `students_system_management`.`term_discipline` (`discipline_id`, `term_id`) VALUES ('1', '1');
insert into `students_system_management`.`term_discipline` (`discipline_id`, `term_id`) VALUES ('2', '1');
insert into `students_system_management`.`term_discipline` (`discipline_id`, `term_id`) VALUES ('1', '2');





