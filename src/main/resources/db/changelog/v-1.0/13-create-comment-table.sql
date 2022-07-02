CREATE TABLE IF NOT EXISTS public.comment
(
    id bigint NOT NULL,
    comment_type smallint NOT NULL,
    last_redaction_date timestamp without time zone,
    persist_date timestamp without time zone,
    text character varying(255) COLLATE pg_catalog."default" NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT comment_pkey PRIMARY KEY (id),
    CONSTRAINT fkl4xlhaqa07wrvf446sjwngh8j FOREIGN KEY (user_id)
    REFERENCES public.user_entity (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.comment
    OWNER to postgres;
GO
