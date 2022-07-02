CREATE TABLE IF NOT EXISTS public.singel_chat
(
    chat_id bigint NOT NULL,
    use_two_id bigint NOT NULL,
    user_one_id bigint NOT NULL,
    CONSTRAINT singel_chat_pkey PRIMARY KEY (chat_id),
    CONSTRAINT fk6nto53owdiythxo2h6dkbvu4t FOREIGN KEY (use_two_id)
    REFERENCES public.user_entity (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkl2cp5kdbj6ym2wgsgi218jej3 FOREIGN KEY (chat_id)
    REFERENCES public.chat (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fklyuqnigj07exf26a7f0dakusa FOREIGN KEY (user_one_id)
    REFERENCES public.user_entity (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.singel_chat
    OWNER to postgres;
GO
