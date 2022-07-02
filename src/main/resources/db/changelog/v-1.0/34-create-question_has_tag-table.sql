CREATE TABLE IF NOT EXISTS public.question_has_tag
(
    question_id bigint NOT NULL,
    tag_id bigint NOT NULL,
    CONSTRAINT fk95qkp3v84rs97v7alcfk77fdr FOREIGN KEY (question_id)
    REFERENCES public.question (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkrg80k8r5dshnsufpxu1p0d8gp FOREIGN KEY (tag_id)
    REFERENCES public.tag (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;
GO

ALTER TABLE IF EXISTS public.question_has_tag
    OWNER to postgres;
GO
