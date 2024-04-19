package com.example.diploma.view.employee

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diploma.model.Employee

@Composable
fun EmployeeInfoScreen(employee: Employee) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(30.dp))

        Image(
            painter = painterResource(employee.photo),
            contentDescription = null,
            contentScale = Crop,
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape),
        )

        Spacer(Modifier.height(40.dp))

        Text(
            fontWeight = SemiBold,
            text = employee.fio,
            textAlign = Center,
            fontSize = 26.sp,
            color = DarkGray
        )

        Spacer(Modifier.height(6.dp))

        Text(
            text = employee.post,
            textAlign = Center,
            fontSize = 16.sp,
            color = Gray
        )

        Spacer(Modifier.height(20.dp))

        Text(
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = DarkGray,
                        fontWeight = SemiBold
                    )
                ) { append("Обязанности: ") }
                append(employee.responsibilities)
            },
            fontWeight = Medium,
            textAlign = Center,
            fontSize = 18.sp,
            color = Gray
        )

        Spacer(Modifier.height(20.dp))
    }
}