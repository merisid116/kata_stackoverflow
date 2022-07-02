CREATE SEQUENCE IF NOT EXISTS public.bookmarks_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY bookmarks.id;
GO

ALTER SEQUENCE public.bookmarks_id_seq
    OWNER TO postgres;
GO
