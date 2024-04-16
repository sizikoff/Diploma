package com.example.diploma.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ButtonDefaults.buttonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diploma.R

interface ProfileState {
    fun goToWeb()
    fun contactUs()
    fun onExit()
}

@Composable
fun ProfileScreen(callback: ProfileState? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = CenterHorizontally
    ) {
        Spacer(Modifier.height(30.dp))

        Image(
            painter = painterResource(R.drawable.man5),
            contentDescription = null,
            contentScale = Crop,
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape),
        )

        Spacer(Modifier.height(40.dp))

        Text(
            text = "Сазонтов Василий Дмитриевич",
            fontWeight = SemiBold,
            textAlign = Center,
            fontSize = 26.sp,
            color = DarkGray
        )

        Spacer(Modifier.height(6.dp))

        Text(
            textAlign = Center,
            text = "Айтишник",
            fontSize = 16.sp,
            color = Gray
        )

        Spacer(Modifier.height(20.dp))

        Text(
            text = "Контакты",
            fontWeight = SemiBold,
            textAlign = Center,
            fontSize = 20.sp,
            color = DarkGray
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        fontWeight = SemiBold,
                        color = DarkGray
                    )
                ) { append("Телефон: ") }
                append("+7 (914) 558-99-96")
            },
            textAlign = Center,
            fontSize = 16.sp,
            color = Gray
        )

        Spacer(Modifier.height(16.dp))

        Column(Modifier.fillMaxWidth()) {
            ProfileButton(
                text = "На сайт",
                modifier = Modifier.fillMaxWidth()
            ) { callback?.goToWeb() }

            Spacer(Modifier.height(8.dp))

            ProfileButton(
                text = "Написать нам",
                modifier = Modifier.fillMaxWidth()
            ) { callback?.goToWeb() }

            Spacer(Modifier.height(8.dp))

            ProfileButton(
                text = "Выход",
                modifier = Modifier.fillMaxWidth()
            ) { callback?.goToWeb() }
        }

        Spacer(Modifier.height(20.dp))
    }
}

@Composable
private fun ProfileButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = buttonColors(
            containerColor = colorResource(
                R.color.splash_day
            ),
            contentColor = White
        ),
        shape = RoundedCornerShape(24.dp),
        elevation = buttonElevation(2.dp)
    ) {
        Text(
            modifier = Modifier.padding(6.dp, 4.dp),
            fontWeight = SemiBold,
            textAlign = Center,
            fontSize = 14.sp,
            text = text
        )
    }
}