create table usuario (
       user_id int8 not null,
        username varchar(255),
        primary key (user_id)
    )

create table certificado (
       id int8 not null,
        certificado varchar(255),
        userid int8,
        primary key (id)
    )

INSERT INTO public.usuario (user_id,username) VALUES
	 (11,'user');