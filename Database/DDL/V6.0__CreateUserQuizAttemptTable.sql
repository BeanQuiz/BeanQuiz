CREATE TABLE public."UserQuizAttempt"
(
    "AttemptID" serial NOT NULL,
    "UserID" integer NOT NULL,
    "QuizID" integer NOT NULL,
    "StartTimestamp" timestamp with time zone NOT NULL,
    "EndTimestamp" timestamp with time zone NOT NULL,
    "Score" integer NOT NULL,
    CONSTRAINT "UserQuizAttempt_PK" PRIMARY KEY ("AttemptID"),
    CONSTRAINT "User_FK" FOREIGN KEY ("UserID")
        REFERENCES public."User" ("UserID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "Quiz_FK" FOREIGN KEY ("QuizID")
        REFERENCES public."Quiz" ("QuizID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public."UserQuizAttempt"
    OWNER to postgres;
