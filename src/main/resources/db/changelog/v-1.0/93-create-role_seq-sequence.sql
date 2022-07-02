CREATE SEQUENCE IF NOT EXISTS public.role_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
GO

ALTER SEQUENCE public.role_seq
    OWNER TO postgres;
GO
