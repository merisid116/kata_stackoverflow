CREATE TABLE IF NOT EXISTS public.group_chat
(
    chat_id bigint NOT NULL,
    CONSTRAINT group_chat_pkey PRIMARY KEY (chat_id),
    CONSTRAINT fkhwhjdn057057sx83g73m0iag5 FOREIGN KEY (chat_id)
    REFERENCES public.chat (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.group_chat
    OWNER to postgres;
GO
