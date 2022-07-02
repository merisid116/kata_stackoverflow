CREATE TABLE IF NOT EXISTS public.message
(
    id bigint NOT NULL,
    last_redaction_date timestamp without time zone NOT NULL,
    message text COLLATE pg_catalog."default",
    persist_date timestamp without time zone,
    chat_id bigint NOT NULL,
    user_sender_id bigint NOT NULL,
    CONSTRAINT message_pkey PRIMARY KEY (id),
    CONSTRAINT fklgr15f5qgibclatnawcadb4x9 FOREIGN KEY (user_sender_id)
    REFERENCES public.user_entity (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkmejd0ykokrbuekwwgd5a5xt8a FOREIGN KEY (chat_id)
    REFERENCES public.chat (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.message
    OWNER to postgres;
GO
