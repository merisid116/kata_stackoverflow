CREATE TABLE IF NOT EXISTS public.comment_question
(
    comment_id bigint NOT NULL,
    question_id bigint NOT NULL,
    CONSTRAINT comment_question_pkey PRIMARY KEY (comment_id),
    CONSTRAINT fk2ob5qywtuo1093g7ql5kfx3rk FOREIGN KEY (comment_id)
    REFERENCES public.comment (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkup4pc0f37svsrid4lwxkeqf2 FOREIGN KEY (question_id)
    REFERENCES public.question (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.comment_question
    OWNER to postgres;
GO
