PGDMP                         z            demo_db    14.2    14.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24822    demo_db    DATABASE     c   CREATE DATABASE demo_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_India.1252';
    DROP DATABASE demo_db;
                postgres    false            �            1259    24860    changedit_id_seq    SEQUENCE     y   CREATE SEQUENCE public.changedit_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.changedit_id_seq;
       public          postgres    false            �            1259    24869    users    TABLE     /  CREATE TABLE public.users (
    id integer NOT NULL,
    first_name character varying(15) NOT NULL,
    last_name character varying(15) NOT NULL,
    username character varying(10) NOT NULL,
    email character varying(50) NOT NULL,
    dob date NOT NULL,
    password character varying(10) NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    24868    users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public          postgres    false    211            �           0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public          postgres    false    210            ]           2604    24872    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    211    210    211            �          0    24869    users 
   TABLE DATA           Z   COPY public.users (id, first_name, last_name, username, email, dob, password) FROM stdin;
    public          postgres    false    211   _       �           0    0    changedit_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.changedit_id_seq', 1, false);
          public          postgres    false    209            �           0    0    users_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq', 1, false);
          public          postgres    false    210            _           2606    24878    users users_email_key 
   CONSTRAINT     Q   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);
 ?   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key;
       public            postgres    false    211            a           2606    24876    users users_last_name_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_last_name_key UNIQUE (last_name);
 C   ALTER TABLE ONLY public.users DROP CONSTRAINT users_last_name_key;
       public            postgres    false    211            c           2606    24874    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    211            �      x������ � �     