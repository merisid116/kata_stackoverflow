CREATE TABLE IF NOT EXISTS public.user_favorite_question
(
    id bigint NOT NULL,
    persist_date timestamp without time zone NOT NULL,
    question_id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT user_favorite_question_pkey PRIMARY KEY (id),
    CONSTRAINT fklp6cfgrasgyon52khtdjjgi02 FOREIGN KEY (question_id)
    REFERENCES public.question (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fknhawqa1q89ai58etpxjbvlt3c FOREIGN KEY (user_id)
    REFERENCES public.user_entity (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.user_favorite_question
    OWNER to postgres;
GO
