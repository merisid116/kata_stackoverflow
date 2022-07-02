CREATE TABLE IF NOT EXISTS public.question
(
    id bigint NOT NULL,
    description text COLLATE pg_catalog."default" NOT NULL,
    is_deleted boolean,
    last_redaction_date timestamp without time zone NOT NULL,
    persist_date timestamp without time zone,
    title character varying(255) COLLATE pg_catalog."default" NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT question_pkey PRIMARY KEY (id),
    CONSTRAINT fktg7oxllrdp5tf8isrfmory7yo FOREIGN KEY (user_id)
    REFERENCES public.user_entity (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.question
    OWNER to postgres;
GO
