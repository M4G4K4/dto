CREATE TABLE public.zones (
    id bigint not null,
    borough varchar(255) not null,
    zone varchar(255) not null,
    service_zone varchar(255) not null,
    constraint zone_pkey primary key (id)
);

CREATE TABLE public.trips (
    id bigint not null,
    pickup_at timestamp not null,
    drop_off_at timestamp not null,
    pick_up_zone bigint null,
    drop_off_zone bigint null,
    constraint trip_pkey primary key (id),
    constraint trip_pick_up_zone foreign key (pick_up_zone) references public.zone(id),
    constraint trip_drop_off_zone foreign key (drop_off_zone) references public.zone(id)
);