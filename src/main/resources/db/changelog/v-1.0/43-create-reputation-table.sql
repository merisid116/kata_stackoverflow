CREATE TABLE IF NOT EXISTS public.reputation
(
    id bigint NOT NULL,
    count integer,
    persist_date timestamp without time zone,
    type integer NOT NULL,
    answer_id bigint,
    author_id bigint NOT NULL,
    question_id bigint,
    sender_id bigint,
    CONSTRAINT reputation_pkey PRIMARY KEY (id),
    CONSTRAINT fklndsyfrqg3b6g87gplymx8y6r FOREIGN KEY (author_id)
    REFERENCES public.user_entity (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkolofwdfwvpjawwa9gpfvtycwf FOREIGN KEY (question_id)
    REFERENCES public.question (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkqm7j2hn9g8f57qjvw5r1vebcs FOREIGN KEY (sender_id)
    REFERENCES public.user_entity (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fksqo308es5w7bvg914o1mwrn2m FOREIGN KEY (answer_id)
    REFERENCES public.answer (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.reputation
    OWNER to postgres;
GO
