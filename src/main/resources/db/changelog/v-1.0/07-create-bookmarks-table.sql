CREATE TABLE IF NOT EXISTS public.bookmarks
(
    id bigint NOT NULL DEFAULT nextval('bookmarks_id_seq'::regclass),
    question_id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT bookmarks_pkey PRIMARY KEY (id),
    CONSTRAINT fklo0de495ruc6wr4j8uim9fc2e FOREIGN KEY (user_id)
    REFERENCES public.user_entity (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkmge2txjhd0hq1ji859u0ylwyw FOREIGN KEY (question_id)
    REFERENCES public.question (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.bookmarks
    OWNER to postgres;
GO
