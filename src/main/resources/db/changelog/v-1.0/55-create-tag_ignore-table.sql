CREATE TABLE IF NOT EXISTS public.tag_ignore
(
    id bigint NOT NULL,
    persist_date timestamp without time zone,
    ignored_tag_id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT tag_ignore_pkey PRIMARY KEY (id),
    CONSTRAINT fk7wnisc677h8s3wb6o4mv2oqkf FOREIGN KEY (ignored_tag_id)
    REFERENCES public.tag (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkjjdrwp57ok5c1ckuwqsft1qxf FOREIGN KEY (user_id)
    REFERENCES public.user_entity (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.tag_ignore
    OWNER to postgres;
GO
