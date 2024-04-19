package com.example.diploma.view.employee

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize.Max
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diploma.R
import com.example.diploma.model.Employee

@Composable
fun EmployeeScreen(
    employees: List<Employee>,
    onEmployeeClick: (Employee) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = spacedBy(8.dp)
    ) {
        item { Spacer(Modifier.height(8.dp)) }

        items(employees) { employee ->
            EmployeeItem(employee) {
                onEmployeeClick(employee)
            }
        }

        item { Spacer(Modifier.height(16.dp)) }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun EmployeeItem(
    employee: Employee,
    onClick: () -> Unit
) {
    Card(
        border = BorderStroke(1.dp, LightGray),
        shape = RoundedCornerShape(12.dp),
        elevation = cardElevation(2.dp),
        colors = cardColors(
            colorResource(R.color.splash_day)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(Max),
        onClick = onClick,
    ) {
        Row(verticalAlignment = CenterVertically) {
            Box(
                Modifier
                    .padding(6.dp)
                    .size(60.dp)
                    .background(White, CircleShape)
                    .border(1.dp, DarkGray, CircleShape)
            ) {
                Image(
                    painter = painterResource(employee.photo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    contentScale = Crop
                )
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                fontWeight = SemiBold,
                text = employee.fio,
                overflow = Ellipsis,
                textAlign = Center,
                fontSize = 18.sp,
                color = White,
                maxLines = 1
            )
        }
    }
}