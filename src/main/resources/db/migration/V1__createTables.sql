create table tb_person(
    id integer primary key,
    name varchar(50),
    department varchar(10)
);

CREATE SEQUENCE tb_person_id_seq OWNED BY tb_person.id;

ALTER TABLE tb_person ALTER COLUMN id SET DEFAULT nextval('tb_person_id_seq');

create table tb_task(
    id integer primary key,
    title varchar(20),
    description varchar(50),
    deadline int,
    department varchar(10),
    allocated_person varchar(50),
    task_status varchar(20),
    person_id integer
);

CREATE SEQUENCE tb_task_id_seq OWNED BY tb_task.id;

ALTER TABLE tb_task ALTER COLUMN id SET DEFAULT nextval('tb_task_id_seq');
