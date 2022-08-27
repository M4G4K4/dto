create sequence if not exists public.hibernate_sequence start 1 increment 1;

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
    pickup_zone_id bigint null,
    dropoff_zone_id bigint null,
    type varchar(255) null,
    constraint trip_pkey primary key (id),
    constraint trip_pick_up_zone foreign key (pickup_zone_id) references public.zones(id),
    constraint trip_drop_off_zone foreign key (dropoff_zone_id) references public.zones(id)
);
