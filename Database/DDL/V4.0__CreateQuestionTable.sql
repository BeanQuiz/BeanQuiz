CREATE TABLE public."Question"
(
    "QuestionID" serial NOT NULL,
    "QuizID" integer NOT NULL,
    "Text" text NOT NULL,
    CONSTRAINT "Question_PK" PRIMARY KEY ("QuestionID"),
    CONSTRAINT "Quiz_FK" FOREIGN KEY ("QuizID")
        REFERENCES public."Quiz" ("QuizID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public."Question"
    OWNER to postgres;
