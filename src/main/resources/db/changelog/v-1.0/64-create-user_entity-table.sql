CREATE TABLE IF NOT EXISTS public.user_entity
(
    id bigint NOT NULL,
    about character varying(255) COLLATE pg_catalog."default",
    city character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    full_name character varying(255) COLLATE pg_catalog."default",
    image_link character varying(255) COLLATE pg_catalog."default",
    is_deleted boolean,
    is_enabled boolean,
    last_redaction_date timestamp without time zone NOT NULL,
    link_github character varying(255) COLLATE pg_catalog."default",
    link_site character varying(255) COLLATE pg_catalog."default",
    link_vk character varying(255) COLLATE pg_catalog."default",
    nickname character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    persist_date timestamp without time zone,
    role_id bigint NOT NULL,
    CONSTRAINT user_entity_pkey PRIMARY KEY (id),
    CONSTRAINT fkpostrnt7qdgc4m56i71qlkl61 FOREIGN KEY (role_id)
    REFERENCES public.role (id) MATCH SIMPLE
                                  ON UPDATE NO ACTION
                                  ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.user_entity
    OWNER to postgres;
GO
