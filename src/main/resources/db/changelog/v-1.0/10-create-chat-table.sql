CREATE TABLE IF NOT EXISTS public.chat
(
    id bigint NOT NULL,
    chat_type smallint,
    persist_date timestamp without time zone,
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT chat_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.chat
    OWNER to postgres;
GO
