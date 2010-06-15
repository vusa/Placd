
CREATE TABLE id_gen(
	id_name character varying(255) NOT NULL,
	id_val bigint NOT NULL
	CONSTRAINT id_gen_pkey PRIMARY KEY (id_name)
);

CREATE TABLE jobs(
    id bigint NOT NULL,
    date_posted timestamp without time zone,
    title character varying(255),
    summary character varying(255),
    description character varying(2000),
    pay_rate integer,
    pay_period character varying(50),
    date_closing timestamp without time zone
}
