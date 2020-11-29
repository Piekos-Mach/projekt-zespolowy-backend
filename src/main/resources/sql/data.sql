INSERT INTO public.dictionary_user_type (user_type_id, name)
VALUES (1, 'CUSTOMER'), (2, 'GUEST'), (3, 'ADMIN');

INSERT INTO public.dictionary_currency (currency_id, name)
VALUES (1, 'PLN');

INSERT INTO public.dictionary_offer_status (offer_status_id, name)
VALUES (1, 'ACTIVE'), (2, 'ARCHIVAL');

INSERT INTO public.dictionary_offer_type (offer_type_id, name)
VALUES (1, 'ITEM'), (2, 'SERVICE');

INSERT INTO public.user (user_id, type, name, password, mail)
VALUES (1, 3, 'a', '$2a$10$Dd/ozXZuhTBlbqqQ/gsBE.zOExw.KBpCU67jOWXELYetXDPiYU/TW', 'a@mail.com'),
       (2, 1, 'user', '$2a$10$sCZFpfyp3NgiN02yjkrvB.GGVgXtgKcdWBRkBNAPqUiVgapkxzAZ6', 'user@mail.com'),
       (3, 1, 'user1', '$2a$10$hMCcue/xXYEV4fy39t2ZLeKbGAGaheneyFsQ9wxMlLpyckbE1fAQa', 'user1@mail.com');

INSERT INTO public.offer (offer_id, owning_user, title, text, price_value, price_currency, creation_date, status, type)
VALUES (1, 1, 'Przedmiot nr 1', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia. Ancidunt id aliquet risus.', 1, 1, '2020-05-01 12:30:00', 1, 1),
       (2, 1, 'Przedmiot nr 2', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia. Ancidunt id aliquet risus.', 2, 1, '2020-05-01 10:00:00', 1, 1),
       (3, 1, 'Przedmiot nr 3', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia. Ancidunt id aliquet risus.', 3, 1, '2020-05-15 15:30:00', 1, 1),
       (4, 1, 'Przedmiot nr 4', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia. Ancidunt id aliquet risus.', 4, 1, '2020-05-15 09:30:00', 1, 1),
       (5, 1, 'Przedmiot nr 5', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia. Ancidunt id aliquet risus.', 5, 1, '2020-06-01 12:30:00', 1, 1),
       (6, 1, 'Przedmiot nr 6', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia. Ancidunt id aliquet risus.', 6, 1, '2020-06-01 19:30:00', 1, 1),
       (7, 2, 'Przedmiot nr 7', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia. Ancidunt id aliquet risus.', 7, 1, '2020-06-15 13:30:00', 1, 1),
       (8, 2, 'Przedmiot nr 8', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia. Ancidunt id aliquet risus.', 8, 1, '2020-06-15 15:30:00', 1, 1),
       (9, 2, 'Przedmiot nr 9', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia. Ancidunt id aliquet risus.', 9, 1, '2020-06-30 16:30:00', 1, 1),
       (10, 3, 'Przedmiot nr 10', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia.tincidunt id aquet risus.', 11, 1, '2019-05-01 12:30:00', 2, 1),
       (11, 3, 'Przedmiot nr 11', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia.tincidunt id qluet risus.', 12, 1, '2019-05-01 10:00:00', 2, 1),
       (12, 3, 'Przedmiot nr 12', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia.tincidunt id liuet risus.', 13, 1, '2021-05-15 15:30:00', 1, 1),
       (13, 3, 'Przedmiot nr 13', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia.tincidunt id alqet risus.', 14, 1, '2021-05-15 09:30:00', 1, 1),
       (14, 3, 'Przedmiot nr 14', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia.tincidunt id aiuet risus.', 15, 1, '2021-06-01 12:30:00', 1, 1),
       (15, 3, 'Przedmiot nr 15', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia.tincidunt id iquet risus.', 16, 1, '2021-06-01 19:30:00', 1, 1),
       (16, 3, 'Usługa nr 1', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia.tincidunt id aliqudset risus.', 17, 1, '2021-06-15 13:30:00', 1, 2),
       (17, 3, 'Usługa nr 2', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia.tincidunt id aliquegst risus.', 18, 1, '2021-06-15 15:30:00', 2, 2),
       (18, 3, 'Usługa nr 3', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia.tincidunt id aliquzxet risus.', 19, 1, '2021-06-30 16:30:00', 1, 2),
       (19, 3, 'Usługa nr 4', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia.tincidunt id aliquxcet risus.', 20, 1, '2021-05-01 12:30:00', 1, 2),
       (20, 3, 'Usługa nr 5', 'Pellentesque diam volutpat commodo sed egestas. Lacus vestibulum sed arcu non odio euismod lacinia.tincidunt id aliqusdet risus.', 21, 1, '2021-05-01 10:00:00', 1, 2);