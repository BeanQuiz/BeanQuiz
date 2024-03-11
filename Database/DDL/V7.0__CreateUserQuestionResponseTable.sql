USE BeanQuizDB;

CREATE TABLE public."UserQuestionResponse"
(
    "ResponseID" serial NOT NULL,
    "AttemptID" integer NOT NULL,
    "QuestionID" integer NOT NULL,
    "SelectedOptionID" integer NOT NULL,
    CONSTRAINT "UserQuestionResponse_PK" PRIMARY KEY ("ResponseID"),
    CONSTRAINT "UserQuizAttempt_FK" FOREIGN KEY ("AttemptID")
        REFERENCES public."UserQuizAttempt" ("AttemptID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "Question_FK" FOREIGN KEY ("QuestionID")
        REFERENCES public."Question" ("QuestionID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "Option_FK" FOREIGN KEY ("SelectedOptionID")
        REFERENCES public."Option" ("OptionID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public."UserQuestionResponse"
    OWNER to postgres;
