CREATE TABLE public."User"
(
    "UserID" serial NOT NULL,
    "Username" character varying(255)[] NOT NULL,
    "Email" character varying(255)[] NOT NULL,
    CONSTRAINT "User_PK" PRIMARY KEY ("UserID")
);
