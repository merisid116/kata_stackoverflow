CREATE TABLE IF NOT EXISTS public.comment_answer
(
    comment_id bigint NOT NULL,
    answer_id bigint NOT NULL,
    CONSTRAINT comment_answer_pkey PRIMARY KEY (comment_id),
    CONSTRAINT fkdqdik3krvw5227fq8oiei7vn4 FOREIGN KEY (answer_id)
    REFERENCES public.answer (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkoe2xyxejln3qgk05w6y3pih6j FOREIGN KEY (comment_id)
    REFERENCES public.comment (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.comment_answer
    OWNER to postgres;
GO
