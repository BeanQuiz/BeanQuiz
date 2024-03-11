CREATE TABLE public."Option"
(
    "OptionID" serial NOT NULL,
    "QuestionID" integer NOT NULL,
    "Text" text NOT NULL,
    "IsCorrect" boolean NOT NULL,
    CONSTRAINT "Option_PK" PRIMARY KEY ("OptionID"),
    CONSTRAINT "Question_FK" FOREIGN KEY ("QuestionID")
        REFERENCES public."Question" ("QuestionID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public."Option"
    OWNER to postgres;