CREATE TABLE public."Quiz"
(
    "QuizID" serial NOT NULL,
    "Title" character varying(255)[] NOT NULL,
    "Description" text NOT NULL,
    "TotalQuestions" integer NOT NULL,
    CONSTRAINT "Quiz_PK" PRIMARY KEY ("QuizID")
);

ALTER TABLE IF EXISTS public."Quiz"
    OWNER to postgres;
