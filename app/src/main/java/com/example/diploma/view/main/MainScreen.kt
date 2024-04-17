package com.example.diploma.view.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign.Companion.Start
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diploma.model.Division

@Composable
fun MainScreen(
    divisions: List<Division>,
    onDivisionClick: (Division) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item { Spacer(Modifier.height(8.dp)) }

        items(divisions) { division ->
            DivisionItem(division) { onDivisionClick(division) }
        }

        item { Spacer(Modifier.height(16.dp)) }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun DivisionItem(
    division: Division,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        border = BorderStroke(1.dp, LightGray),
        shape = RoundedCornerShape(12.dp),
        elevation = cardElevation(2.dp),
    ) {
        Row {
            Icon(
                painter = painterResource(division.icon),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )

            Spacer(Modifier.width(10.dp))

            Text(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 6.dp),
                text = division.title ?: "",
                textAlign = Start,
                fontWeight = SemiBold,
                overflow = Ellipsis,
                fontSize = 18.sp,
                color = Gray,
                maxLines = 1
            )
        }
    }
}