DROP TABLE IF EXISTS public.documents CASCADE;

CREATE TABLE public.documents
(
    id uuid NOT NULL,
    document_id character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT documents_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE public.documents
    OWNER to postgres;

CREATE INDEX fki_document_fk
    ON public.user_permissions USING btree
    (document_id ASC NULLS LAST)
    TABLESPACE pg_default;
