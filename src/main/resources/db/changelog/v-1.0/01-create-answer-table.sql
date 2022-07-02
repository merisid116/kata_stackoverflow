CREATE TABLE IF NOT EXISTS public.answer
(
    id bigint NOT NULL,
    date_accept_time timestamp without time zone,
    html_body text COLLATE pg_catalog."default" NOT NULL,
    is_deleted boolean NOT NULL,
    is_deleted_by_moderator boolean NOT NULL,
    is_helpful boolean NOT NULL,
    persist_date timestamp without time zone,
    update_date timestamp without time zone NOT NULL,
    question_id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT answer_pkey PRIMARY KEY (id),
    CONSTRAINT fk2k36bpxtxus6sxyg8mlof5js1 FOREIGN KEY (user_id)
    REFERENCES public.user_entity (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fk8frr4bcabmmeyyu60qt7iiblo FOREIGN KEY (question_id)
    REFERENCES public.question (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

GO
ALTER TABLE IF EXISTS public.answer
    OWNER to postgres;
GO
