CREATE TABLE IF NOT EXISTS public.question_viewed
(
    id bigint NOT NULL,
    persist_date timestamp without time zone,
    question_id bigint,
    user_id bigint,
    CONSTRAINT question_viewed_pkey PRIMARY KEY (id),
    CONSTRAINT fknw7lp8384y34tnaulsvmmfnub FOREIGN KEY (user_id)
    REFERENCES public.user_entity (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkqeg29r7uu1g1flepcpm4mv1g2 FOREIGN KEY (question_id)
    REFERENCES public.question (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.question_viewed
    OWNER to postgres;
GO
