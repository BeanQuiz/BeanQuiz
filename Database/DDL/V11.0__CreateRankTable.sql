CREATE TABLE public."Rank"
(
    "RankID" serial NOT NULL,
    "Name" text NOT NULL,
    "Requirement" integer NOT NULL,
    "FunFact" text NOT NULL,
    CONSTRAINT "Rank_PK" PRIMARY KEY ("RankID")
);
