PGDMP             
            w         
   moviestore    11.2    11.2 7    L           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            M           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            N           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            O           1262    16393 
   moviestore    DATABASE     �   CREATE DATABASE moviestore WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Colombia.1252' LC_CTYPE = 'Spanish_Colombia.1252';
    DROP DATABASE moviestore;
             postgres    false            �            1259    16609    account    TABLE     P  CREATE TABLE public.account (
    id integer NOT NULL,
    username character varying(15) NOT NULL,
    password character varying(15) NOT NULL,
    avatar character varying,
    state smallint,
    person_id character varying(20) NOT NULL,
    person_type character varying(2) NOT NULL,
    date date DEFAULT now(),
    rol integer
);
    DROP TABLE public.account;
       public         postgres    false            �            1259    16607    account_id_seq    SEQUENCE     �   CREATE SEQUENCE public.account_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.account_id_seq;
       public       postgres    false    200            P           0    0    account_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.account_id_seq OWNED BY public.account.id;
            public       postgres    false    199            �            1259    16676    arrear    TABLE     �   CREATE TABLE public.arrear (
    id integer NOT NULL,
    rental integer,
    date date DEFAULT now(),
    value bigint NOT NULL,
    state smallint NOT NULL
);
    DROP TABLE public.arrear;
       public         postgres    false            �            1259    16674    arrear_id_seq    SEQUENCE     �   CREATE SEQUENCE public.arrear_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.arrear_id_seq;
       public       postgres    false    208            Q           0    0    arrear_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.arrear_id_seq OWNED BY public.arrear.id;
            public       postgres    false    207            �            1259    16631    movie    TABLE     �  CREATE TABLE public.movie (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(1000) NOT NULL,
    gender character varying(60) NOT NULL,
    director character varying(300) NOT NULL,
    stars smallint NOT NULL,
    "time" integer NOT NULL,
    avatar text NOT NULL,
    background text NOT NULL,
    price bigint NOT NULL,
    date date DEFAULT now()
);
    DROP TABLE public.movie;
       public         postgres    false            �            1259    16629    movie_id_seq    SEQUENCE     �   CREATE SEQUENCE public.movie_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.movie_id_seq;
       public       postgres    false    202            R           0    0    movie_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.movie_id_seq OWNED BY public.movie.id;
            public       postgres    false    201            �            1259    16589    person    TABLE     �  CREATE TABLE public.person (
    identification character varying(20) NOT NULL,
    type_identification character varying(2) NOT NULL,
    first_name character varying(60) NOT NULL,
    last_name character varying(60) NOT NULL,
    phone character varying(12) NOT NULL,
    years integer NOT NULL,
    address character varying(100),
    email character varying(300),
    date date DEFAULT now()
);
    DROP TABLE public.person;
       public         postgres    false            �            1259    16657    rental    TABLE       CREATE TABLE public.rental (
    id integer NOT NULL,
    stock integer,
    init_date date DEFAULT now(),
    delivery_date date,
    price bigint NOT NULL,
    account integer,
    date timestamp without time zone DEFAULT now(),
    days integer NOT NULL
);
    DROP TABLE public.rental;
       public         postgres    false            �            1259    16655    rental_id_seq    SEQUENCE     �   CREATE SEQUENCE public.rental_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.rental_id_seq;
       public       postgres    false    206            S           0    0    rental_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.rental_id_seq OWNED BY public.rental.id;
            public       postgres    false    205            �            1259    16600    rol    TABLE     �   CREATE TABLE public.rol (
    id integer NOT NULL,
    name character varying(15) NOT NULL,
    description character varying(300),
    state smallint,
    date date DEFAULT now()
);
    DROP TABLE public.rol;
       public         postgres    false            �            1259    16598 
   rol_id_seq    SEQUENCE     �   CREATE SEQUENCE public.rol_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.rol_id_seq;
       public       postgres    false    198            T           0    0 
   rol_id_seq    SEQUENCE OWNED BY     9   ALTER SEQUENCE public.rol_id_seq OWNED BY public.rol.id;
            public       postgres    false    197            �            1259    16643    stock    TABLE     �   CREATE TABLE public.stock (
    id integer NOT NULL,
    movie integer NOT NULL,
    state smallint,
    date date DEFAULT now()
);
    DROP TABLE public.stock;
       public         postgres    false            �            1259    16641    stock_id_seq    SEQUENCE     �   CREATE SEQUENCE public.stock_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.stock_id_seq;
       public       postgres    false    204            U           0    0    stock_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.stock_id_seq OWNED BY public.stock.id;
            public       postgres    false    203            �
           2604    16612 
   account id    DEFAULT     h   ALTER TABLE ONLY public.account ALTER COLUMN id SET DEFAULT nextval('public.account_id_seq'::regclass);
 9   ALTER TABLE public.account ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    199    200    200            �
           2604    16679 	   arrear id    DEFAULT     f   ALTER TABLE ONLY public.arrear ALTER COLUMN id SET DEFAULT nextval('public.arrear_id_seq'::regclass);
 8   ALTER TABLE public.arrear ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    208    207    208            �
           2604    16634    movie id    DEFAULT     d   ALTER TABLE ONLY public.movie ALTER COLUMN id SET DEFAULT nextval('public.movie_id_seq'::regclass);
 7   ALTER TABLE public.movie ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    202    201    202            �
           2604    16660 	   rental id    DEFAULT     f   ALTER TABLE ONLY public.rental ALTER COLUMN id SET DEFAULT nextval('public.rental_id_seq'::regclass);
 8   ALTER TABLE public.rental ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    205    206    206            �
           2604    16603    rol id    DEFAULT     `   ALTER TABLE ONLY public.rol ALTER COLUMN id SET DEFAULT nextval('public.rol_id_seq'::regclass);
 5   ALTER TABLE public.rol ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    198    197    198            �
           2604    16646    stock id    DEFAULT     d   ALTER TABLE ONLY public.stock ALTER COLUMN id SET DEFAULT nextval('public.stock_id_seq'::regclass);
 7   ALTER TABLE public.stock ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    203    204    204            A          0    16609    account 
   TABLE DATA               k   COPY public.account (id, username, password, avatar, state, person_id, person_type, date, rol) FROM stdin;
    public       postgres    false    200   q=       I          0    16676    arrear 
   TABLE DATA               @   COPY public.arrear (id, rental, date, value, state) FROM stdin;
    public       postgres    false    208   �=       C          0    16631    movie 
   TABLE DATA               x   COPY public.movie (id, name, description, gender, director, stars, "time", avatar, background, price, date) FROM stdin;
    public       postgres    false    202   >       =          0    16589    person 
   TABLE DATA               �   COPY public.person (identification, type_identification, first_name, last_name, phone, years, address, email, date) FROM stdin;
    public       postgres    false    196   xF       G          0    16657    rental 
   TABLE DATA               a   COPY public.rental (id, stock, init_date, delivery_date, price, account, date, days) FROM stdin;
    public       postgres    false    206    G       ?          0    16600    rol 
   TABLE DATA               A   COPY public.rol (id, name, description, state, date) FROM stdin;
    public       postgres    false    198   LG       E          0    16643    stock 
   TABLE DATA               7   COPY public.stock (id, movie, state, date) FROM stdin;
    public       postgres    false    204   �G       V           0    0    account_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.account_id_seq', 1, true);
            public       postgres    false    199            W           0    0    arrear_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.arrear_id_seq', 1, false);
            public       postgres    false    207            X           0    0    movie_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.movie_id_seq', 7, true);
            public       postgres    false    201            Y           0    0    rental_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.rental_id_seq', 29, true);
            public       postgres    false    205            Z           0    0 
   rol_id_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.rol_id_seq', 3, true);
            public       postgres    false    197            [           0    0    stock_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.stock_id_seq', 135, true);
            public       postgres    false    203            �
           2606    16618    account account_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.account DROP CONSTRAINT account_pkey;
       public         postgres    false    200            �
           2606    16682    arrear arrear_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.arrear
    ADD CONSTRAINT arrear_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.arrear DROP CONSTRAINT arrear_pkey;
       public         postgres    false    208            �
           2606    16640    movie movies_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY public.movie
    ADD CONSTRAINT movies_pkey PRIMARY KEY (id);
 ;   ALTER TABLE ONLY public.movie DROP CONSTRAINT movies_pkey;
       public         postgres    false    202            �
           2606    16597 $   person pk_person_identification_type 
   CONSTRAINT     �   ALTER TABLE ONLY public.person
    ADD CONSTRAINT pk_person_identification_type PRIMARY KEY (identification, type_identification);
 N   ALTER TABLE ONLY public.person DROP CONSTRAINT pk_person_identification_type;
       public         postgres    false    196    196            �
           2606    16663    rental rental_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.rental
    ADD CONSTRAINT rental_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.rental DROP CONSTRAINT rental_pkey;
       public         postgres    false    206            �
           2606    16606    rol rol_pkey 
   CONSTRAINT     J   ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (id);
 6   ALTER TABLE ONLY public.rol DROP CONSTRAINT rol_pkey;
       public         postgres    false    198            �
           2606    16649    stock stock_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.stock
    ADD CONSTRAINT stock_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.stock DROP CONSTRAINT stock_pkey;
       public         postgres    false    204            �
           2606    16624    account account_person_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_person_id_fkey FOREIGN KEY (person_id, person_type) REFERENCES public.person(identification, type_identification);
 H   ALTER TABLE ONLY public.account DROP CONSTRAINT account_person_id_fkey;
       public       postgres    false    2737    200    196    200    196            �
           2606    16619    account account_rol_fkey    FK CONSTRAINT     q   ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_rol_fkey FOREIGN KEY (rol) REFERENCES public.rol(id);
 B   ALTER TABLE ONLY public.account DROP CONSTRAINT account_rol_fkey;
       public       postgres    false    198    200    2739            �
           2606    16683    arrear arrear_rental_fkey    FK CONSTRAINT     x   ALTER TABLE ONLY public.arrear
    ADD CONSTRAINT arrear_rental_fkey FOREIGN KEY (rental) REFERENCES public.rental(id);
 C   ALTER TABLE ONLY public.arrear DROP CONSTRAINT arrear_rental_fkey;
       public       postgres    false    206    208    2747            �
           2606    16669    rental rental_account_fkey    FK CONSTRAINT     {   ALTER TABLE ONLY public.rental
    ADD CONSTRAINT rental_account_fkey FOREIGN KEY (account) REFERENCES public.account(id);
 D   ALTER TABLE ONLY public.rental DROP CONSTRAINT rental_account_fkey;
       public       postgres    false    2741    206    200            �
           2606    16664    rental rental_stock_fkey    FK CONSTRAINT     u   ALTER TABLE ONLY public.rental
    ADD CONSTRAINT rental_stock_fkey FOREIGN KEY (stock) REFERENCES public.stock(id);
 B   ALTER TABLE ONLY public.rental DROP CONSTRAINT rental_stock_fkey;
       public       postgres    false    206    204    2745            �
           2606    16650    stock stock_movie_fkey    FK CONSTRAINT     s   ALTER TABLE ONLY public.stock
    ADD CONSTRAINT stock_movie_fkey FOREIGN KEY (movie) REFERENCES public.movie(id);
 @   ALTER TABLE ONLY public.stock DROP CONSTRAINT stock_movie_fkey;
       public       postgres    false    202    2743    204            A   u   x��A�  ���&�l�4z�^����`��7���l�KNpkc/�,�3l"_��I#I:�k��?:�#�*����c���������� �u�셈`]�?N�O6 ��VJ� �� �      I      x������ � �      C   U  x��W�n�8]�����ʥz�oe;��~?b�4(�%�,�2I����_�� Yx�]6L��|ɜK��N�I�	D%���qι�����#���.77�4�B�?[�V2ՖU�0Q��豰x�ɹ)�e��T
�*n8}t"ïZ��V�f��`v;)�h�G
�y<��26�:ɹe1w�(�m/��;��P�6XEVy�MV,��SҞ��ЫD+pf)3��
���1Y�R��6���LI��J�Q�wU��*#(�_P`�Y9��2YV���vT"9{#�D�?�6-\�cx׺�%:�*&k��z�A+w��[Q$;U�g��]G�H�<6�w{��� �oD���zr�˾=>|{tr��զ/�˳Τ�^lg}��3><O���ir;�Ϫ����z��vz]�kц���jwc���C:b=�b��
����mZ��B�9e!�E���Ւ����c�,g�X��)y�~�����$�D�R�8k�"���(��>��j�`��W	�0��bǲ��)�Z'�`Q���׹�����2#~��l\������!+�-�UbG���RT�>�!S��+�Ō������C�8��RD둝�$��:�� S���#g֓�q
07��y4y`j����OvJ���:�؆#�;N�H+N�Vj���(��C	�N}���i���D0+3r��S��K	��y����m�ۨv��_`o�=�yI�΀�Z.�DGz�ǐ���h��o��Ŏ�,�76�[k?Ē��ﺣ፽�;]�oF׳���Y����dm����؍���N�%�=/6�T��y;k��dseТ  w�� ��T���57B< �k]a�c��|*�J ͏Ғ�4�I���^���)��P4����	 �6 %'�Tc ���U·�%^k�a5�R2�L���T&q~
�(A<��03�V��!H�D*��Y�i<�E÷F�;�>\8f*�(<�L]i6&% �E���#N���t��^&�╬h%2�#�V���/���vfl�.n�5B̯��hB����^t��'�[Qr��TH{J��Lj�����؞�NG�g�E"�����������'E���2&��;���>�\�Y�I�cm�˄ގ+Ӹ�M����ֻ�?�J��_�!F�~�qmg;����{#wO�.��L��j6s/��F��E�W�f�>�+6W�Kl!�i�h]R�h�\�������e:6b*��\5@&��$�K�84a�~!ŉl�] ���g���m0P|&|ŒF��A��.�ð�h(��Ul$P�ÁP�i ��^p)N/|���۩�<�2[�$K�y��#.�L_C��"�oBd��B�یz�س��ߝܞ��6L������k����H����w�vv�����������o��%`֞����+��a	����b�p4�6�D�A^��ϖ`4����CSak�VRϞ(��=a����O��2QVR�s��&�?\�������@+�@$I�TIQ��˿�c�Pm���%1b�����pǤp8�Ke��W?�qD�+�"�O@��}��0F0&�p~� Q2��3��fÂT"E�9�Fu�4�;S�)8;D��l�<��A�t!������V�҃\�?�O�H��I�tD�q?I��8���!n?����kxI�Uύ��i���:�Včaﻘ^��è?��� �/��3������Z��L�u�p'��QJtGj�xʸ���?�k\$��w
�详���b��	Ŝ�	9�%M�6����<�m=6�����y=lT*�?=�������c? "���	���D�t1��y�[o�$��iE�u	]��9��7ֆo��"Ť�н =�҄�� q=h�����s0PP�)�&��_VN4>�:A@^�q�U�����Ʋ�*O�q�h|��k8|���ۣ�`��6�t���"�~6B�P���{� D�{2�J����;����
Cu��₪�.���T���|�uF��i�b'�R�N"	���"FZ�2�С�n��O�:,�� N!Q����w	�A��W�A�:q#_�/�	�s��B�ةv����~è�F ����6Ѥ��Fשּׁ��m�EV      =   x   x�%̽
�0 ����-w��&�R����b�J~���oo��>&���q�K{U<��	���Z]Sx�J��a�썷�@9'����8������<=˜��
hb�ѱ#�n�R��� �      G   <   x�3��440��!3 �4�420��50�54R00�#N.#K�R3�Rc<J��b���� ��      ?   N   x�3�LL����t��Q(H-��,.N-�4�420��50�5��2�L�-�ɯLM�tU��Ƙ39'35��3H�R���� :��      E     x�M��m!E�o����7�
��:���E�!�+!���s�[�z�������}��y��`ԁudț?
4�D�ڨ��#C4���pN�i8�4�FD�GM�h���htd��Ac��ƣ�6��ّ!G���Ƥ1iLI#i$���4�F�HI#i,��|�(�@%Zh�:���4v�|4�D�ڨ��#C�h��Q4�F�(ֻh��!���X�3��DC�ST�T3�\5W�Us�\5W�Us�\5W-T�B�P-Tk�"��)�����_=�b�����1��;     