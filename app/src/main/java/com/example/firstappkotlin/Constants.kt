package com.example.firstappkotlin

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUSTION: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Questions> {
        val questionList = ArrayList<Questions>()
        val question1 = Questions(
            1,
            "Кого Джорджо Цукалос винит во всех бедах в этом меме?",
            R.drawable.jorjo,
            "Котов",
            "Людей",
            "Жену",
            "Пришельцев",
            4
        )
        questionList.add(question1)

        val question2 = Questions(
            2,
            "Как называется этот мем?",
            R.drawable.kianu,
            "Sad Keanu («грустный Киану»)",
            "Hungry Keanu («голодный Киану»)",
            "Lonely Keanu («одинокий Киану»)",
            "He's The One! («он избранный!»)",
            1
        )
        questionList.add(question2)

        val question3 = Questions(
            3,
            "Как зовут кота на фото?",
            R.drawable.kott,
            "Соус Кетчуп",
            "Соус Тысяча Островов",
            "Соус Ранч",
            "Соус Тардар",
            4
        )
        questionList.add(question3)

        val question4 = Questions(
            4,
            "Из какого сериала взят кадр с кричащей женщиной?",
            R.drawable.or,
            "«Уборка с Мари Кондо»",
            "«Беременна в 16»",
            "«Настоящие домохозяйки Беверли-Хиллз»",
            "«Отчаянные домохозяйки»",
            3
        )
        questionList.add(question4)

        val question5 = Questions(
            5,
            "В каких случаях надо использовать этот мем?",
            R.drawable.tylen,
            "Чтобы рассказать о набранном весе",
            "Чтобы рассказать о неловкой ситуации",
            "Чтобы рассказать страшную историю",
            "Чтобы задать вопрос о диете или фитнес-программе",
            2
        )
        questionList.add(question5)

        val question6 = Questions(
            6,
            "Как называется этот мем?",
            R.drawable.natasha,
            "«Наташ, вставай, мы там все уронили»",
            "«Уже 6 часов утра, Наташ»",
            "«Наташ, ты спишь?»",
            "«Что жрать будем, Наташа?»",
            1
        )
        questionList.add(question6)

        val question7 = Questions(
            7,
            "Как называется этот персонаж",
            R.drawable.lapenko,
            "Журналист",
            "Ведущий «Сдохний или Умри»",
            "«Главарь»",
            "«Багровый Фантомас»",
            3
        )
        questionList.add(question7)

        return questionList
    }
}