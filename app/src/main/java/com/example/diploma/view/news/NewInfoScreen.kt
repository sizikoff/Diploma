package com.example.diploma.view.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diploma.model.New

@Composable
fun NewInfoScreen(new: New) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(new.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = Crop
        )

        Spacer(Modifier.height(16.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Center,
            fontWeight = SemiBold,
            text = new.title,
            fontSize = 20.sp,
            color = DarkGray
        )

        Spacer(Modifier.height(20.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Center,
            fontWeight = Medium,
            fontSize = 16.sp,
            color = Gray,
            text = new.text
        )

        Spacer(Modifier.height(30.dp))
    }
}