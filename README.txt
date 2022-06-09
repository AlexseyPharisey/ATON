Задание 1
Два треда, Sonny и Cher, исполняют в консоли дуэтом хит 1965 года "I Got You Babe" (https://youtu.be/BERd61bDY7k). Каждый тред выводит своем имя,
двоеточие и слова песни, например так:
Cher: They say we're young and we don't know
We won't find out until we grow
Необходимо написать программу, в которой треды работают согласованно, так, чтобы строчки, исполняемые в один голос, выводились в консоль в
правильном порядке. Строчки припева (в 2 голоса, отмечены "Sonny, Cher") должны выводиться каждым тредом, но в любом порядке.

Весь текст задан структурой:
String[][] lyrics = {
{"Cher", "They say we're young and we don't know \nWe won't find out until we grow"},
{"Sonny", "Well I don't know if all that's true \n'Cause you got me, and baby I got you"},
{"Sonny", "Babe"},
{"Sonny, Cher", "I got you babe \nI got you babe"},
{"Cher", "They say our love won't pay the rent \nBefore it's earned, our money's all been spent"},
{"Sonny", "I guess that's so, we don't have a pot \nBut at least I'm sure of all the things we got"},
{"Sonny", "Babe"},
{"Sonny, Cher", "I got you babe \nI got you babe"},
{"Sonny", "I got flowers in the spring \nI got you to wear my ring"},
{"Cher", "And when I'm sad, you're a clown \nAnd if I get scared, you're always around"},
{"Cher", "So let them say your hair's too long \n'Cause I don't care, with you I can't go wrong"},
{"Sonny", "Then put your little hand in mine \nThere ain't no hill or mountain we can't climb"},
{"Sonny", "Babe"},
{"Sonny, Cher", "I got you babe \nI got you babe"},
{"Sonny", "I got you to hold my hand"},
{"Cher", "I got you to understand"},
{"Sonny", "I got you to walk with me"},
{"Cher", "I got you to talk with me"},
{"Sonny", "I got you to kiss goodnight"},
{"Cher", "I got you to hold me tight"},
{"Sonny", "I got you, I won't let go"},
{"Cher", "I got you to love me so"},
{"Sonny, Cher", "I got you babe \nI got you babe \nI got you babe \nI got you babe \nI got you babe"}
};

----------------------------------------------------------------------------
Задание 2
Дано:
Таблица с ценами активов за период:
    create table dbo.tblClosePrice (
     -- Дата на которую берётся цена
     PriceDate date not null
     -- ИД актива
     ,PriceAssetId int not null
     -- Цена закрытия
     ,ClosePrice numeric (19, 8) not null
     ,constraint PK_tblClosePrice primary key clustered (PriceAssetId,
    PriceDate)
     )
    ;

Необходимо:
1) Написать SQL запрос, который бы выбирал по каждому активу минимальную и
максимальную цену за каждый месяц 2021 года.

----------------------------------------------------------------------------
Задание 3

Дано: Есть две таблицы. tblClient – содержит информацию о клиентах некоторой
компании, таблица tblClientPayments – содержит информацию о платежах клиента.

Таблица: tblClient
ClientId Name
1 Иванов Иван Иванович
2 Петров Петр Петрович
3 Кузнецова Анна Андреевна
4 Тихонова Светлана Анатольевна

Таблица: tblClientPayments
ClientId PaymentDate PaymentSum
1 01.02.2022 4000
1 05.02.2022 6000
3 02.03.2022 10000
4 09.03.2022 1000
1 16.03.2022 2000

Нужно написать SQL-запрос:
1) Выбрать всех клиентов (ClientId, Name) и посчитать по каждому общую сумму
платежей (TotalSum).
2) Выбрать всех клиентов (ClientId, Name, TotalSum), у которых либо есть платежи
после 05.03.2022, либо сумма всех платежей превышает 7000.
3) Выбрать постоянных клиентов (ClientId, Name), то есть клиентов, у которых есть
платежи по крайней мере в двух разных календарных месяцах одного года.
4) Измените платёж Кузнецовой Анны Андреевны от 02.03.2022, применив к нему
скидку 10% (Уменьшите на 10%). Напишите SQL запрос.
5) Добавьте платёж Петрова Петра Петровича за текущую дату на сумму 18000.

----------------------------------------------------------------------------
Задание 4

Дано:
Поезд замкнутый (каждый вагон сцеплен с двумя другими). Можно представлять,
что он стоит на замкнутых круглых путях. В начальный момент времени наблюдатель
(тот, кто считает вагоны) находится перед одним из вагонов (неизвестно каким). В
каждый момент времени наблюдатель видит только один вагон. Наблюдатель может
двигаться вдоль поезда и включать/выключать свет в вагонах. Все вагоны одинаковые.
Изначально свет в каждом конкретном вагоне может гореть, а может и не гореть – это
заранее неизвестно.
Нужно:
Написать программу для расчёта количества вагонов в поезде в ООП стиле.