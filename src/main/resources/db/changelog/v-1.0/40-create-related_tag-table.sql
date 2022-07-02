CREATE TABLE IF NOT EXISTS public.related_tag
(
    id bigint NOT NULL,
    child_tag bigint NOT NULL,
    main_tag bigint NOT NULL,
    CONSTRAINT related_tag_pkey PRIMARY KEY (id),
    CONSTRAINT fkk5320uu5wbdyg2xku67qp8aqe FOREIGN KEY (child_tag)
    REFERENCES public.tag (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fknb1cmjyv0amiv491xlx4xi6w1 FOREIGN KEY (main_tag)
    REFERENCES public.tag (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.related_tag
    OWNER to postgres;
GO
