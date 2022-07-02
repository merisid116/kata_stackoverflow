CREATE TABLE IF NOT EXISTS public.votes_on_questions
(
    id bigint NOT NULL,
    persist_date timestamp without time zone,
    vote integer NOT NULL,
    question_id bigint,
    user_id bigint,
    CONSTRAINT votes_on_questions_pkey PRIMARY KEY (id),
    CONSTRAINT fk5rc898att1153186h64v2lym2 FOREIGN KEY (user_id)
    REFERENCES public.user_entity (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkiu40gq78m9r2n8nmwnefjxyry FOREIGN KEY (question_id)
    REFERENCES public.question (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.votes_on_questions
    OWNER to postgres;
GO
