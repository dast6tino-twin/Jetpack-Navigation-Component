package ru.dast_6_tino.androidx_navigation_example.main.list

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlin.random.Random

@Parcelize
data class Dog(
    val id: Long,
    val name: String,
    val breed: String,
    val description: String
) : Parcelable {

    companion object {
        val defaultItems: List<Dog> by lazy { getItems() }

        private val nameList = listOf(
            "Голубь", "Птица", "Андрей", "Маша", "Кексик", "Курлык", "Влад", "Николай", "Геннадий",
            "Еремей"
        )

        private val breedList = listOf(
            "Акита-ину", "Алабай (среднеазиатская овчарка)",
            "Американская акита", "Американский стаффордширский терьер",
            "Английский бульдог", "Аргентинский дог", "Басенджи", "Бернский зенненхунд", "Бигль"
        )

        private val descriptionList = listOf(
            "Среди пород собак, чья история уходит в глубину веков, особо выделяется акита-ину. «Акита» – это префектура в северной части Японии, а «ину» – по-японски «собака».",
            "Крупная аборигенная порода собак",
            "Американская акита – порода собак с очень интересной судьбой",
            "Порода выведена в США, относится к средним собакам.",
            "Считается, что корни у английских бульдогов общие с догообразными собаками Кавказа, древними римскими мастифами, молосскими догами из Греции и кельтскими сторожевыми собаками.",
            "В начале 20 века, под впечатлением от экстерьерных качеств белых испанских мастифов, выведением этой породы занялся известный собаковод того времени доктор Антонио Норес Мартинес.",
            "Относится к группе малых пород собак, другие названия – конго-терьер, конголезская кустарниковая собака, ньям-ньям-терьер.",
            "Разводить эту породу начали не так давно – в начале 20-го века в Швейцарии, в городе Берн. Считается, что своим происхождением бернские зенненхунды, так же, как и все молоссы, обязаны тибетским мастифам.",
            "Бигль – это одна из самых древних гончих небольшого размера. Относится к средним породам собак."
        )

        private fun getItems(): List<Dog> {
            val mutableList = mutableListOf<Dog>()
            val breedMaxIndex = breedList.size - 1

            for (index in 0L..30L) {
                val name = nameList.random()
                val breedIndex = Random.nextInt(0, breedMaxIndex)
                mutableList += Dog(
                    id = index,
                    name = name,
                    breed = breedList[breedIndex],
                    description = descriptionList[breedIndex]
                )
            }

            return mutableList
        }
    }

}
