package com.example.diploma.view.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diploma.model.New

@Composable
fun NewsMainScreen(
    news: List<New>,
    onItemClick: (New) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item { Spacer(Modifier.height(8.dp)) }

        items(news) { new ->
            NewsItem(new) { onItemClick(new) }
        }

        item { Spacer(Modifier.height(16.dp)) }
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
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(White),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 6.dp),
            textAlign = TextAlign.Start,
            fontWeight = SemiBold,
            overflow = Ellipsis,
            fontSize = 18.sp,
            text = new.title,
            color = Gray,
            maxLines = 1
        )

        Divider(
            thickness = 2.dp,
            color = Color.DarkGray
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