ALTER TABLE public."User"
ALTER COLUMN "Username" TYPE text,
ALTER COLUMN "Email" TYPE text;

ALTER TABLE public."Quiz"
ALTER COLUMN "Title" TYPE text;

ALTER TABLE public."Question"
ALTER COLUMN "Text" TYPE text;

ALTER TABLE public."Option"
ALTER COLUMN "Text" TYPE text;