package com.example.diploma.view.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign.Companion.Start
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import com.example.diploma.R
import com.example.diploma.model.New

class NewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        val news = setInitialData()

        setContent {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = spacedBy(8.dp)
            ) {
                item { Spacer(Modifier.height(8.dp)) }

                items(news) { new ->
                    NewsItem(new) {
                        val fragment: Fragment = NewsAboutFragment()
                        val bundle = Bundle()
                        bundle.putString("title", new.title)
                        bundle.putString("text", new.text)
                        bundle.putInt("image", new.image)
                        fragment.arguments = bundle

                        @Suppress("DEPRECATION")
                        fragmentManager
                            ?.beginTransaction()
                            ?.replace(R.id.fragment_container, fragment)
                            ?.setTransition(TRANSIT_FRAGMENT_FADE)
                            ?.commit()
                    }
                }

                item { Spacer(Modifier.height(16.dp)) }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun NewsItem(
    new: New,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(White)
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 6.dp),
            fontWeight = SemiBold,
            overflow = Ellipsis,
            textAlign = Start,
            fontSize = 18.sp,
            text = new.title,
            color = Gray,
            maxLines = 1
        )

        Divider(
            thickness = 2.dp,
            color = DarkGray
        )

        Image(
            painter = painterResource(new.image),
            contentDescription = null,
            contentScale = Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}

private fun setInitialData(): List<New> {
    val list = mutableListOf<New>()
    val images: IntArray = intArrayOf(
        R.drawable.mark,
        R.drawable.serv,
        R.drawable.news,
        R.drawable.bugal,
        R.drawable.cons
    )

    list.add(
        New(
            title = "Консультирование",
            image = images.random(),
            text = "Будет довольно прохладно.Новости на неделе:сегодня в городе произошел крупный пожар в районе Клинтон"
        )
    )
    list.add(
        New(
            title = "Отмечвем день рождения начальника",
            image = images.random(),
            text = "Сегодня сообщили точную дату выхода всеми ожидаемой игры Spore 2"
        )
    )
    list.add(
        New(
            title = "Совещание по вопросам дверного нейминга",
            image = images.random(),
            text = "Следующее в программе:Осуждение мемов в интернете"
        )
    )
    list.add(
        New(
            title = "Турнир по футболу.Не опаздывайте",
            image = images.random(),
            text = "Следующее в программе:Интервью с котом - только не пропустите!"
        )
    )
    list.add(
        New(
            title = "Поднимите зарплату",
            image = images.random(),
            text = "Новый фильм \"Рвущий\" рвёт все кинотеатры города и сборы фильма превысили 120 миллионов долларов\n"
        )
    )
    list.add(
        New(
            title = "Сбережения",
            image = images.random(),
            text = "Был построен новый жилой комплекс \"Дубовый\""
        )
    )
    list.add(
        New(
            title = "Аналитики на выезде",
            image = images.random(),
            text = "Следующее в программе:Обсуждение матча в спорте"
        )
    )
    list.add(
        New(
            title = "Интервью с лидерами предприятия",
            image = images.random(),
            text = "Сегодня торжественная дата - День Города!"
        )
    )
    return list
}