CREATE TABLE IF NOT EXISTS public.groupchat_has_users
(
    chat_id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT groupchat_has_users_pkey PRIMARY KEY (chat_id, user_id),
    CONSTRAINT fk2rtdyfisemfv23xnmsxopptng FOREIGN KEY (chat_id)
    REFERENCES public.group_chat (chat_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkd1tr2cxaudn9q2ea52ydi3sea FOREIGN KEY (user_id)
    REFERENCES public.user_entity (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.groupchat_has_users
    OWNER to postgres;
GO
