CREATE TABLE IF NOT EXISTS public.user_badges
(
    id bigint NOT NULL,
    ready boolean,
    badges_id bigint,
    user_id bigint,
    CONSTRAINT user_badges_pkey PRIMARY KEY (id),
    CONSTRAINT fk337cc9ux9pqlb991y6w43to3j FOREIGN KEY (badges_id)
    REFERENCES public.badges (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkfb1c6pv1fesnielua9xtgci76 FOREIGN KEY (user_id)
    REFERENCES public.user_entity (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.user_badges
    OWNER to postgres;
GO
