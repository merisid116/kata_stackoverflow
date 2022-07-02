CREATE TABLE IF NOT EXISTS public.tag_tracked
(
    id bigint NOT NULL,
    persist_date timestamp without time zone,
    tracked_tag_id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT tag_tracked_pkey PRIMARY KEY (id),
    CONSTRAINT fki60fykn402bntk377q2t9ybde FOREIGN KEY (user_id)
    REFERENCES public.user_entity (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkpn5ysi8igj9rmnun213hg5uf FOREIGN KEY (tracked_tag_id)
    REFERENCES public.tag (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.tag_tracked
    OWNER to postgres;
GO
