CREATE TABLE IF NOT EXISTS public.badges
(
    id bigint NOT NULL,
    badge_name character varying(255) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    reputations_for_merit integer,
    CONSTRAINT badges_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.badges
    OWNER to postgres;
GO
