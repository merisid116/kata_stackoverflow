CREATE TABLE IF NOT EXISTS public.tag
(
    id bigint NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    persist_date timestamp without time zone,
    CONSTRAINT tag_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.tag
    OWNER to postgres;
GO
