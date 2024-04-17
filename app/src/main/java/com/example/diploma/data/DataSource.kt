package com.example.diploma.data

import com.example.diploma.R
import com.example.diploma.model.Division
import com.example.diploma.model.Employee
import com.example.diploma.model.New

object DataSource {

    private val newImages = intArrayOf(
        R.drawable.mark,
        R.drawable.serv,
        R.drawable.news,
        R.drawable.bugal,
        R.drawable.cons
    )

    private var employeeAvatars: IntArray = intArrayOf(
        R.drawable.man4,
        R.drawable.man,
        R.drawable.man2,
        R.drawable.man5,
        R.drawable.man7,
        R.drawable.man8,
        R.drawable.men,
        R.drawable.men2,
        R.drawable.men1
    )

    private val namesList = arrayOf(
        "Виктор",
        "Алексей",
        "Владимир",
        "Евгений",
        "Антон",
        "Сергей",
        "Данил",
        "Жорж",
        "Владислав"
    )
    private val surnamesList = arrayOf(
        "Фролов",
        "Кулагин",
        "Дмитриев",
        "Ткачев",
        "Павлов",
        "Котов",
        "Козлов",
        "Иванов",
        "Поляков"
    )

    private val posts = arrayOf(
        "TeamLead",
        "CTO",
        "Senior",
        "Middle",
        "Junior",
        "CEO",
        "Тестировщик",
        "DevOps",
        "Завхох"
    )

    fun getNews(): List<New> {
        val list = mutableListOf<New>()
        list.add(
            New(
                title = "Консультирование",
                image = newImages.random(),
                text = "Будет довольно прохладно.Новости на неделе:сегодня в городе произошел крупный пожар в районе Клинтон"
            )
        )
        list.add(
            New(
                title = "Отмечвем день рождения начальника",
                image = newImages.random(),
                text = "Сегодня сообщили точную дату выхода всеми ожидаемой игры Spore 2"
            )
        )
        list.add(
            New(
                title = "Совещание по вопросам дверного нейминга",
                image = newImages.random(),
                text = "Следующее в программе:Осуждение мемов в интернете"
            )
        )
        list.add(
            New(
                title = "Турнир по футболу.Не опаздывайте",
                image = newImages.random(),
                text = "Следующее в программе:Интервью с котом - только не пропустите!"
            )
        )
        list.add(
            New(
                title = "Поднимите зарплату",
                image = newImages.random(),
                text = "Новый фильм \"Рвущий\" рвёт все кинотеатры города и сборы фильма превысили 120 миллионов долларов\n"
            )
        )
        list.add(
            New(
                title = "Сбережения",
                image = newImages.random(),
                text = "Был построен новый жилой комплекс \"Дубовый\""
            )
        )
        list.add(
            New(
                title = "Аналитики на выезде",
                image = newImages.random(),
                text = "Следующее в программе:Обсуждение матча в спорте"
            )
        )
        list.add(
            New(
                title = "Интервью с лидерами предприятия",
                image = newImages.random(),
                text = "Сегодня торжественная дата - День Города!"
            )
        )
        return list
    }

    fun getEmployees(): List<Employee> {
        val list = mutableListOf<Employee>()
        list.add(
            Employee(
                fio = "${namesList.random()} ${surnamesList.random()}",
                post = posts.random(),
                responsibilities = "Организовывает рабочие процессы в команде",
                photo = employeeAvatars.random()
            )
        )
        list.add(
            Employee(
                fio = "${namesList.random()} ${surnamesList.random()}",
                post = posts.random(),
                responsibilities = "Отвечает за стратегическое развитие основного продукта",
                photo = employeeAvatars.random()
            )
        )
        list.add(
            Employee(
                fio = "${namesList.random()} ${surnamesList.random()}",
                post = posts.random(),
                responsibilities = "Заряжает позитивом на целый день и не дает соскучиться",
                photo = employeeAvatars.random()
            )
        )
        list.add(
            Employee(
                fio = "${namesList.random()} ${surnamesList.random()}",
                post = posts.random(),
                responsibilities = "Контролирует важные стратегические решения в компании",
                photo = employeeAvatars.random()
            )
        )
        list.add(
            Employee(
                fio = "${namesList.random()} ${surnamesList.random()}",
                post = posts.random(),
                responsibilities = "Организовывает встречи с лидерами отделов и предприятий",
                photo = employeeAvatars.random()
            )
        )
        list.add(
            Employee(
                fio = "${namesList.random()} ${surnamesList.random()}",
                post = posts.random(),
                responsibilities = "Помогает компании достичь своих финансовых и маркетинговых целей, используя инновационный технологический подход",
                photo = employeeAvatars.random()
            )
        )
        list.add(
            Employee(
                fio = "${namesList.random()} ${surnamesList.random()}",
                post = posts.random(),
                responsibilities = "Управляет всеми сферами деятельности, поэтому он несёт полную законодательную ответственность за работу компании и её последствия",
                photo = employeeAvatars.random()
            )
        )
        return list
    }

    fun getDivisionsList(): List<Division> {
        val list = mutableListOf<Division>()
        list.add(
            Division(
                title = "Консалтинг",
                description = "Консультирование предприятий, руководителей и управленческих кадров по разным вопросам",
                icon = R.drawable.ico1
            )
        )
        list.add(
            Division(
                title = "Маркетинг",
                description = "Ставим своей целью получение прибыли с помощью удовлетворения потребностей покупателей",
                icon = R.drawable.ico2
            )
        )
        list.add(
            Division(
                title = "Бухгалтерия",
                description = "Ведем  бухгалтерский учёт в компании, занимаемся документооборотом",
                icon = R.drawable.ico3
            )
        )
        list.add(
            Division(
                title = "Клиентский сервис",
                description = "Помогаем компании обращаться со своими клиентами и решать их проблемы",
                icon = R.drawable.ico4
            )
        )
        list.add(
            Division(
                title = "Бизнес-поддержка",
                description = "Реализуем важную функцию получения обратной связи от пользователей",
                icon = R.drawable.ico5
            )
        )
        list.add(
            Division(
                title = "Разработка",
                description = "Создание программного обеспечения, приложений для смартфонов, сайтов.",
                icon = R.drawable.ica
            )
        )
        return list
    }
}