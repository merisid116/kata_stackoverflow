CREATE TABLE IF NOT EXISTS public.votes_on_answers
(
    id bigint NOT NULL,
    persist_date timestamp without time zone,
    vote integer,
    answer_id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT votes_on_answers_pkey PRIMARY KEY (id),
    CONSTRAINT fki8gxkndohkt08w93qkx756d8e FOREIGN KEY (user_id)
    REFERENCES public.user_entity (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkjyyufwvq2xtar6hhcajuv73f9 FOREIGN KEY (answer_id)
    REFERENCES public.answer (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.votes_on_answers
    OWNER to postgres;
GO
